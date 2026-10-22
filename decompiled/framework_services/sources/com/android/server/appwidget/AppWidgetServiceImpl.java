package com.android.server.appwidget;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.AppOpsManagerInternal;
import android.app.BroadcastOptions;
import android.app.IApplicationThread;
import android.app.IServiceConnection;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.StatsManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.usage.UsageStatsManagerInternal;
import android.appwidget.AppWidgetManagerInternal;
import android.appwidget.AppWidgetProviderInfo;
import android.appwidget.PendingHostUpdate;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.ShortcutServiceInternal;
import android.content.pm.SuspendDialogInfo;
import android.content.pm.UserInfo;
import android.content.pm.UserPackage;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Point;
import android.graphics.drawable.Icon;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.AttributeSet;
import android.util.IntArray;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SizeF;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.StatsEvent;
import android.util.TypedValue;
import android.util.Xml;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import android.util.proto.ProtoUtils;
import android.view.Display;
import android.widget.RemoteViews;
import com.android.internal.app.SuspendedAppActivity;
import com.android.internal.app.UnlaunchableAppActivity;
import com.android.internal.appwidget.IAppWidgetHost;
import com.android.internal.appwidget.IAppWidgetService;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;
import com.android.server.WidgetBackupProvider;
import com.android.server.am.HostingRecord;
import com.android.server.am.IProcessStatusChecker;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.Settings;
import com.android.server.scene.SceneUtils;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.uri.GrantUri;
import com.android.server.uri.UriGrantsManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes.dex */
class AppWidgetServiceImpl extends IAppWidgetService.Stub implements WidgetBackupProvider, DevicePolicyManagerInternal.OnCrossProfileWidgetProvidersChangeListener {
    private static final String APPWIDGET_CE_DATA_DIRNAME = "appwidget";
    private static final int CURRENT_VERSION = 1;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GENERATED_PREVIEW_MAX_CALLS_PER_INTERVAL = 2;
    private static final int DEFAULT_GENERATED_PREVIEW_MAX_PROVIDERS = 50;
    private static final long DEFAULT_GENERATED_PREVIEW_RESET_INTERVAL_MS = 0;
    private static final boolean ENABLE_READ_PROVIDER_WHEN_LOCKED = true;
    private static final boolean ENABLE_SHOW_APP_WIDGET_WHEN_STOPED = true;
    private static final int ID_PROVIDER_CHANGED = 1;
    private static final int ID_VIEWS_UPDATE = 0;
    private static final String KEY_SIZES = "sizes";
    private static final int MAX_NUMBER_OF_HOSTS_PER_PACKAGE = 20;
    private static final int MAX_NUMBER_OF_WIDGETS_PER_HOST = 200;
    private static final int MIN_UPDATE_PERIOD = 0;
    private static final String PENDING_DELETED_IDS_ATTR = "pending_deleted_ids";
    private static final String STATE_FILENAME = "appwidgets.xml";
    private static final String TAG = "AppWidgetServiceImpl";
    private static final int TAG_UNDEFINED = -1;
    private static final int UNKNOWN_UID = -1;
    private static final int UNKNOWN_USER_ID = -10;
    private static final AtomicLong UPDATE_COUNTER = null;
    private static final String WIDGET_PREVIEWS_DIRNAME = "previews";
    private ActivityManagerInternal mActivityManagerInternal;
    private Handler mAlarmHandler;
    private AlarmManager mAlarmManager;
    private AppOpsManager mAppOpsManager;
    private AppOpsManagerInternal mAppOpsManagerInternal;
    private BackupRestoreController mBackupRestoreController;
    private final BroadcastReceiver mBroadcastReceiver;
    private Handler mCallbackHandler;
    private final Context mContext;
    private DevicePolicyManagerInternal mDevicePolicyManagerInternal;
    private ApiCounter mGeneratedPreviewsApiCounter;
    private final ArrayList<Host> mHosts;
    private Bundle mInteractiveBroadcast;
    private boolean mIsCombinedBroadcastEnabled;
    private KeyguardManager mKeyguardManager;
    private final SparseBooleanArray mLoadedUserIds;
    private final Object mLock;
    private int mMaxWidgetBitmapMemory;
    private final SparseIntArray mNextAppWidgetIds;
    private IPackageManager mPackageManager;
    private PackageManagerInternal mPackageManagerInternal;
    private final ArraySet<Pair<Integer, String>> mPackagesWithBindWidgetPermission;
    private final ArrayList<Provider> mProviders;
    private final HashMap<Pair<Integer, Intent.FilterComparison>, HashSet<Integer>> mRemoteViewsServicesAppWidgets;
    private boolean mSafeMode;
    private Handler mSavePreviewsHandler;
    private Handler mSaveStateHandler;
    private SecurityPolicy mSecurityPolicy;
    private UsageStatsManagerInternal mUsageStatsManagerInternal;
    private UserManager mUserManager;
    private final SparseArray<ArraySet<String>> mWidgetPackages;
    private final Object mWidgetPackagesLock;
    private final ArrayList<Widget> mWidgets;

    static final class ApiCounter {
        private final Map<ProviderId, ApiCallRecord> mCallCount;
        private int mMaxCallsPerInterval;
        private int mMaxProviders;
        private LongSupplier mMonotonicClock;
        private long mResetIntervalMs;

        private static final class ApiCallRecord {
            public int apiCallCount;
            public long lastResetTimeMs;

            /* synthetic */ ApiCallRecord(AppWidgetServiceImplIA r1) {
                this();
            }

            private ApiCallRecord() {
                this.apiCallCount = 0;
                this.lastResetTimeMs = 0;
            }

            void reset(long nowMs) {
                this.apiCallCount = 0;
                this.lastResetTimeMs = nowMs;
            }
        }

        ApiCounter(long resetIntervalMs, int maxCallsPerInterval, int maxProviders) {
            this(resetIntervalMs, maxCallsPerInterval, maxProviders, new AppWidgetServiceImpl$ApiCounter$$ExternalSyntheticLambda0());
        }

        ApiCounter(long resetIntervalMs, int maxCallsPerInterval, int maxProviders, LongSupplier monotonicClock) {
            this.mCallCount = new ArrayMap();
            this.mResetIntervalMs = resetIntervalMs;
            this.mMaxCallsPerInterval = maxCallsPerInterval;
            this.mMaxProviders = maxProviders;
            this.mMonotonicClock = monotonicClock;
        }

        public void setResetIntervalMs(long resetIntervalMs) {
            this.mResetIntervalMs = resetIntervalMs;
        }

        public long getResetIntervalMs() {
            return this.mResetIntervalMs;
        }

        public void setMaxCallsPerInterval(int maxCallsPerInterval) {
            this.mMaxCallsPerInterval = maxCallsPerInterval;
        }

        public int getMaxCallsPerInterval() {
            return this.mMaxCallsPerInterval;
        }

        public void setMaxProviders(int maxProviders) {
            this.mMaxProviders = maxProviders;
        }

        public int getMaxProviders() {
            return this.mMaxProviders;
        }

        public boolean tryApiCall(ProviderId provider) {
            if (this.mCallCount.containsKey(provider) == false) goto L5;
        L8:
            ApiCallRecord record = this.mCallCount.get(provider);
            long now = this.mMonotonicClock.getAsLong();
            long timeSinceLastResetMs = now - record.lastResetTimeMs;
            if (timeSinceLastResetMs <= this.mResetIntervalMs) goto L12;
            record.reset(now);
        L12:
            if (record.apiCallCount >= this.mMaxCallsPerInterval) goto L15;
            record.apiCallCount++;
            return true;
        L15:
            return false;
        L5:
            if (this.mCallCount.size() < this.mMaxProviders) goto L7;
            return false;
        L7:
            this.mCallCount.put(provider, new ApiCallRecord(null));
            goto L8
        }

        public void remove(ProviderId id) {
            this.mCallCount.remove(id);
        }
    }

    private class AppWidgetManagerLocal extends AppWidgetManagerInternal {
        final /* synthetic */ AppWidgetServiceImpl this$0;

        /* synthetic */ AppWidgetManagerLocal(AppWidgetServiceImpl r1, AppWidgetServiceImplIA r2) {
            this(r1);
        }

        private AppWidgetManagerLocal(AppWidgetServiceImpl r1) {
            this.this$0 = r1;
        }

        public ArraySet<String> getHostedWidgetPackages(int uid) {
            Object r0 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            ArraySet<String> widgetPackages = null;
            int widgetCount = AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).size();     // Catch: Throwable -> L13
            int i = 0;
        L6:
            if (i >= widgetCount) goto L18;
            Widget widget = (Widget) AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).get(i);     // Catch: Throwable -> L13
            if (widget.host.id.uid != uid) goto L16;
            if (widget.provider == null) goto L16;
            if (widgetPackages != null) goto L15;
            widgetPackages = new ArraySet();     // Catch: Throwable -> L13
        L15:
            widgetPackages.add(widget.provider.id.componentName.getPackageName());     // Catch: Throwable -> L13
        L16:
            i = i + 1;     // Catch: Throwable -> L13
            goto L6
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return widgetPackages;
        L13:
            th = move-exception;
            throw th;
        }

        public void unlockUser(int userId) {
            this.this$0.handleUserUnlocked(userId);
        }

        public void applyResourceOverlaysToWidgets(Set<String> packageNames, int userId, boolean updateFrameworkRes) {
            Object r0 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            AppWidgetServiceImpl.m1861$$Nest$mapplyResourceOverlaysToWidgetsLocked(this.this$0, new HashSet(packageNames), userId, updateFrameworkRes);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    final class BackupRestoreController {
        private static final boolean DEBUG = false;
        private static final String TAG = "BackupRestoreController";
        private static final int WIDGET_STATE_VERSION = 2;
        private boolean mHasSystemRestoreFinished;
        private final SparseArray<Set<String>> mPrunedAppsPerUser;
        private final Map<Host, List<RestoreUpdateRecord>> mUpdatesByHost;
        final Map<Provider, List<RestoreUpdateRecord>> mUpdatesByProvider;
        final /* synthetic */ AppWidgetServiceImpl this$0;

        static class RestoreUpdateRecord {
            public int newId;
            public boolean notified;
            public int oldId;

            public RestoreUpdateRecord(int theOldId, int theNewId) {
                this.oldId = theOldId;
                this.newId = theNewId;
                this.notified = false;
            }
        }

        static final class State {
            private final Set<String> mPrunedApps;
            private final SparseArray<List<RestoreUpdateRecord>> mUpdatesByHost;
            private final SparseArray<List<RestoreUpdateRecord>> mUpdatesByProvider;

            State(Set<String> prunedApps, SparseArray<List<RestoreUpdateRecord>> updatesByProvider, SparseArray<List<RestoreUpdateRecord>> updatesByHost) {
                this.mPrunedApps = prunedApps;
                this.mUpdatesByProvider = updatesByProvider;
                this.mUpdatesByHost = updatesByHost;
            }

            Set<String> getPrunedApps() {
                return this.mPrunedApps;
            }

            SparseArray<List<RestoreUpdateRecord>> getUpdatesByProvider() {
                return this.mUpdatesByProvider;
            }

            SparseArray<List<RestoreUpdateRecord>> getUpdatesByHost() {
                return this.mUpdatesByHost;
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$6VnhVMhCijw-NcQTYax_zUq3plU, reason: not valid java name */
        public static /* synthetic */ void m1888$r8$lambda$6VnhVMhCijwNcQTYax_zUq3plU(int r0, SparseArray r1, Host r2, List r3) {
            lambda$getStateLocked$1(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$n_9KW5yvJhkRtTpvb6O_xw66F3I(int r0, SparseArray r1, Provider r2, List r3) {
            lambda$getStateLocked$0(r0, r1, r2, r3);
        }

        BackupRestoreController(AppWidgetServiceImpl this$0) {
            this.this$0 = this$0;
            this.mPrunedAppsPerUser = new SparseArray();
            this.mUpdatesByProvider = new ArrayMap();
            this.mUpdatesByHost = new ArrayMap();
        }

        static {
            DEBUG = AppWidgetServiceImpl.m1881$$Nest$sfgetDEBUG();
        }

        public boolean requiresPersistenceLocked() {
            if (this.mHasSystemRestoreFinished == false) goto L6;
            return false;
        L6:
            if (this.mPrunedAppsPerUser.size() == 0) goto L8;
        L11:
            return true;
        L8:
            if (this.mUpdatesByProvider.isEmpty() == false) goto L11;
            if (this.mUpdatesByHost.isEmpty() == false) goto L11;
            return false;
        }

        public List<String> getWidgetParticipants(int userId) {
            if (DEBUG == false) goto L5;
            Slog.i(TAG, "Getting widget participants for user: " + userId);
        L5:
            HashSet<String> packages = new HashSet();
            Object r1 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            int N = AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).size();     // Catch: Throwable -> L15
            int i = 0;
        L8:
            if (i >= N) goto L19;
            Widget widget = (Widget) AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).get(i);     // Catch: Throwable -> L15
            if (isProviderAndHostInUser(widget, userId) == false) goto L17;
            packages.add(widget.host.id.packageName);     // Catch: Throwable -> L15
            Provider provider = widget.provider;     // Catch: Throwable -> L15
            if (provider == null) goto L17;
            packages.add(provider.id.componentName.getPackageName());     // Catch: Throwable -> L15
        L17:
            i = i + 1;     // Catch: Throwable -> L15
            goto L8
        L19:
            monitor-exit(r1);     // Catch: Throwable -> L15
            return new ArrayList(packages);
        L15:
            th = move-exception;
            throw th;
        }

        public byte[] getWidgetState(String backedupPackage, int userId) {
            if (DEBUG == false) goto L5;
            Slog.i(TAG, "Getting widget state for user: " + userId);
        L5:
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Object r1 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L8:
            if (packageNeedsWidgetBackupLocked(backedupPackage, userId) == true) goto L56;
            monitor-exit(r1);     // Catch: Throwable -> L11
            return null;
        L56:
            TypedXmlSerializer out = Xml.newFastSerializer();     // Catch: Throwable -> L11 IOException -> L23
            out.setOutput(stream, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L11 IOException -> L23
            out.startDocument(null, true);     // Catch: Throwable -> L11 IOException -> L23
            out.startTag(null, "ws");     // Catch: Throwable -> L11 IOException -> L23
            out.attributeInt(null, "version", 2);     // Catch: Throwable -> L11 IOException -> L23
            out.attribute(null, SceneUtils.KEY_PKG, backedupPackage);     // Catch: Throwable -> L11 IOException -> L23
            int index = 0;
            int N = AppWidgetServiceImpl.m1857$$Nest$fgetmProviders(this.this$0).size();     // Catch: Throwable -> L11 IOException -> L23
            int i = 0;
        L15:
            if (i >= N) goto L27;
            Provider provider = (Provider) AppWidgetServiceImpl.m1857$$Nest$fgetmProviders(this.this$0).get(i);     // Catch: Throwable -> L11 IOException -> L23
            if (provider.shouldBePersisted() == false) goto L26;
            if (provider.isInPackageForUser(backedupPackage, userId) == false) goto L21;
        L25:
            provider.tag = index;     // Catch: Throwable -> L11 IOException -> L23
            AppWidgetServiceImpl.m1887$$Nest$smserializeProvider(out, provider, false);     // Catch: Throwable -> L11 IOException -> L23
            index = index + 1;     // Catch: Throwable -> L11 IOException -> L23
            goto L26
        L21:
            if (provider.hostedByPackageForUser(backedupPackage, userId) == true) goto L25;
        L26:
            i = i + 1;     // Catch: Throwable -> L11 IOException -> L23
            goto L15
        L27:
            int N2 = AppWidgetServiceImpl.m1853$$Nest$fgetmHosts(this.this$0).size();     // Catch: Throwable -> L11 IOException -> L23
            int index2 = 0;
            int i2 = 0;
        L28:
            if (i2 >= N2) goto L37;
            Host host = (Host) AppWidgetServiceImpl.m1853$$Nest$fgetmHosts(this.this$0).get(i2);     // Catch: Throwable -> L11 IOException -> L23
            if (host.widgets.isEmpty() == true) goto L36;
            if (host.isInPackageForUser(backedupPackage, userId) == false) goto L34;
        L35:
            host.tag = index2;     // Catch: Throwable -> L11 IOException -> L23
            AppWidgetServiceImpl.m1886$$Nest$smserializeHost(out, host);     // Catch: Throwable -> L11 IOException -> L23
            index2 = index2 + 1;     // Catch: Throwable -> L11 IOException -> L23
            goto L36
        L34:
            if (Host.m1889$$Nest$mhostsPackageForUser(host, backedupPackage, userId) == true) goto L35;
        L36:
            i2 = i2 + 1;     // Catch: Throwable -> L11 IOException -> L23
            goto L28
        L37:
            int N3 = AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).size();     // Catch: Throwable -> L11 IOException -> L23
            int i3 = 0;
        L38:
            if (i3 >= N3) goto L46;
            Widget widget = (Widget) AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).get(i3);     // Catch: Throwable -> L11 IOException -> L23
            Provider provider2 = widget.provider;     // Catch: Throwable -> L11 IOException -> L23
            if (widget.host.isInPackageForUser(backedupPackage, userId) == true) goto L44;
            if (provider2 == null) goto L45;
            if (provider2.isInPackageForUser(backedupPackage, userId) == true) goto L44;
        L45:
            i3 = i3 + 1;     // Catch: Throwable -> L11 IOException -> L23
        L44:
            AppWidgetServiceImpl.m1885$$Nest$smserializeAppWidget(out, widget, false);     // Catch: Throwable -> L11 IOException -> L23
            goto L45
        L46:
            out.endTag(null, "ws");     // Catch: Throwable -> L11 IOException -> L23
            out.endDocument();     // Catch: Throwable -> L11 IOException -> L23
            monitor-exit(r1);     // Catch: Throwable -> L11
            return stream.toByteArray();
        L51:
            Slog.w(TAG, "Unable to save widget state for " + backedupPackage);     // Catch: Throwable -> L11
            return null;
        }

        public void systemRestoreStarting(int userId) {
            if (DEBUG == false) goto L5;
            Slog.i(TAG, "System restore starting for user: " + userId);
        L5:
            Object r0 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mHasSystemRestoreFinished = false;     // Catch: Throwable -> L11
            getPrunedAppsLocked(userId).clear();     // Catch: Throwable -> L11
            this.mUpdatesByProvider.clear();     // Catch: Throwable -> L11
            this.mUpdatesByHost.clear();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void restoreWidgetState(String packageName, byte[] restoredState, int userId) {
            if (DEBUG == false) goto L5;
            Slog.i(TAG, "Restoring widget state for user:" + userId + " package: " + packageName);
        L5:
            ByteArrayInputStream stream = new ByteArrayInputStream(restoredState);
            ArrayList<Provider> restoredProviders = new ArrayList();     // Catch: Throwable -> L106 Throwable -> L108
            ArrayList<Host> restoredHosts = new ArrayList();     // Catch: Throwable -> L106 Throwable -> L108
            TypedXmlPullParser parser = Xml.newFastPullParser();     // Catch: Throwable -> L106 Throwable -> L108
            parser.setInput(stream, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L106 Throwable -> L108
            Object r9 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L106 Throwable -> L108
            monitor-enter(r9);     // Catch: Throwable -> L106 Throwable -> L108
        L116:
            int type = parser.next();     // Catch: Throwable -> L92
            if (type != 2) goto L94;
            String tag = parser.getName();     // Catch: Throwable -> L92
            if ("ws".equals(tag) == true) goto L125;
            if ("p".equals(tag) == true) goto L120;
            stream = stream;
        L77:
            th = th;
        L100:
            monitor-exit(r9);     // Catch: Throwable -> L75
            throw th;     // Catch: Throwable -> L102 Throwable -> L104
        L102:
            th = th;
        L114:
            AppWidgetServiceImpl.m1876$$Nest$msaveGroupStateAsync(this.this$0, userId);
            throw th;
        L49:
            if ("h".equals(tag) == false) goto L57;
            String pkg = parser.getAttributeValue(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L40
            int uid = AppWidgetServiceImpl.m1865$$Nest$mgetUidForPackage(this.this$0, pkg, userId);     // Catch: Throwable -> L40
            int hostId = parser.getAttributeIntHex(null, "id");     // Catch: Throwable -> L40
            Host h = AppWidgetServiceImpl.m1873$$Nest$mlookupOrAddHostLocked(this.this$0, new HostId(uid, hostId, pkg));     // Catch: Throwable -> L40
            restoredHosts.add(h);     // Catch: Throwable -> L40
            if (DEBUG == false) goto L55;
            Slog.i(TAG, "   host[" + restoredHosts.size() + "]: {" + h.id + "}");     // Catch: Throwable -> L40
        L55:
            restoredProviders = restoredProviders;
        L96:
            if (type == 1) goto L97;
            stream = stream;
            restoredProviders = restoredProviders;
            goto L116
        L97:
            monitor-exit(r9);     // Catch: Throwable -> L75
        L98:
            AppWidgetServiceImpl.m1876$$Nest$msaveGroupStateAsync(this.this$0, userId);
            return;
        L57:
            if ("g".equals(tag) == false) goto L91;
            int restoredId = parser.getAttributeIntHex(null, "id");     // Catch: Throwable -> L77
            int hostIndex = parser.getAttributeIntHex(null, "h");     // Catch: Throwable -> L77
            Host host = restoredHosts.get(hostIndex);     // Catch: Throwable -> L77
            Provider p = null;
            int which = parser.getAttributeIntHex(null, "p", -1);     // Catch: Throwable -> L77
            if (which != (-1)) goto L61;
        L62:
            pruneWidgetStateLocked(host.id.packageName, userId);     // Catch: Throwable -> L77
            if (p == null) goto L65;
            pruneWidgetStateLocked(p.id.componentName.getPackageName(), userId);     // Catch: Throwable -> L40
        L65:
            Widget id = findRestoredWidgetLocked(restoredId, host, p);     // Catch: Throwable -> L77
            if (id != null) goto L81;
            id = new Widget(null);     // Catch: Throwable -> L77
            id.appWidgetId = AppWidgetServiceImpl.m1872$$Nest$mincrementAndGetAppWidgetIdLocked(this.this$0, userId);     // Catch: Throwable -> L77
            id.restoredId = restoredId;     // Catch: Throwable -> L77
            id.options = AppWidgetServiceImpl.m1884$$Nest$smparseWidgetIdOptions(parser);     // Catch: Throwable -> L77
            id.host = host;     // Catch: Throwable -> L77
            id.host.widgets.add(id);     // Catch: Throwable -> L77
            id.provider = p;     // Catch: Throwable -> L77
            if (id.provider == null) goto L71;
            id.provider.widgets.add(id);     // Catch: Throwable -> L40
        L71:
            if (DEBUG == false) goto L80;
            StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L77
            r14.append("New restored id ");     // Catch: Throwable -> L75
            r14.append(restoredId);     // Catch: Throwable -> L75
            r14.append(" now ");     // Catch: Throwable -> L75
            r14.append(id);     // Catch: Throwable -> L75
            Slog.i(TAG, r14.toString());     // Catch: Throwable -> L75
        L75:
            th = th;
        L80:
            this.this$0.addWidgetLocked(id);     // Catch: Throwable -> L75
        L83:
            if (id.provider != null) goto L85;
        L87:
            Slog.w(TAG, "Missing provider for restored widget " + id);     // Catch: Throwable -> L75
        L88:
            stashHostRestoreUpdateLocked(id.host, restoredId, id.appWidgetId);     // Catch: Throwable -> L75
            if (DEBUG == false) goto L96;
            Slog.i(TAG, "   instance: " + restoredId + " -> " + id.appWidgetId + " :: p=" + id.provider);     // Catch: Throwable -> L75
            goto L96
        L85:
            if (id.provider.getPartialInfoLocked() == null) goto L87;
            stashProviderRestoreUpdateLocked(id.provider, restoredId, id.appWidgetId);     // Catch: Throwable -> L75
            goto L88
        L81:
            restoredProviders = restoredProviders;
            goto L83
        L61:
            p = restoredProviders.get(which);     // Catch: Throwable -> L40
            goto L62
        L91:
            restoredProviders = restoredProviders;
            goto L96
        L120:
            String pkg2 = parser.getAttributeValue(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L42
            String cl = parser.getAttributeValue(null, "cl");     // Catch: Throwable -> L42
            ComponentName componentName = new ComponentName(pkg2, cl);     // Catch: Throwable -> L42
            Provider p2 = findProviderLocked(componentName, userId);     // Catch: Throwable -> L42
            if (p2 != null) goto L34;
            AppWidgetProviderInfo info = new AppWidgetProviderInfo();     // Catch: Throwable -> L19
            info.provider = componentName;     // Catch: Throwable -> L19
            Provider p3 = new Provider();     // Catch: Throwable -> L19
            p3.id = new ProviderId(-1, componentName);     // Catch: Throwable -> L19
            p3.setPartialInfoLocked(info);     // Catch: Throwable -> L19
            p3.zombie = true;     // Catch: Throwable -> L19
            AppWidgetServiceImpl.m1857$$Nest$fgetmProviders(this.this$0).add(p3);     // Catch: Throwable -> L19
        L36:
            if (DEBUG == false) goto L45;
            StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L42
            r13.append("   provider ");     // Catch: Throwable -> L40
            r13.append(p3.id);     // Catch: Throwable -> L40
            Slog.i(TAG, r13.toString());     // Catch: Throwable -> L40
        L40:
            th = th;
        L45:
            restoredProviders.add(p3);     // Catch: Throwable -> L40
            restoredProviders = restoredProviders;
            goto L96
        L34:
            p3 = p2;
        L42:
            th = th;
            goto L100
        L125:
            int versionNumber = parser.getAttributeInt(null, "version");     // Catch: Throwable -> L19
            if (versionNumber > 2) goto L15;
            String pkg3 = parser.getAttributeValue(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L19
            if (packageName.equals(pkg3) == false) goto L23;
            stream = stream;
            restoredProviders = restoredProviders;
            goto L96
        L23:
            Slog.w(TAG, "Package mismatch in ws");     // Catch: Throwable -> L19
            monitor-exit(r9);     // Catch: Throwable -> L19
            AppWidgetServiceImpl.m1876$$Nest$msaveGroupStateAsync(this.this$0, userId);
            return;
        L15:
            Slog.w(TAG, "Unable to process state version " + versionNumber);     // Catch: Throwable -> L19
            monitor-exit(r9);     // Catch: Throwable -> L19
            AppWidgetServiceImpl.m1876$$Nest$msaveGroupStateAsync(this.this$0, userId);
            return;
        L19:
            th = th;
            goto L100
        L94:
            stream = stream;
            restoredProviders = restoredProviders;
        L92:
            th = th;
            goto L100
        L106:
            th = th;
        L111:
            Slog.w(TAG, "Unable to restore widget state for " + packageName);     // Catch: Throwable -> L102
            goto L98
        }

        public void systemRestoreFinished(int userId) {
            if (DEBUG == false) goto L5;
            Slog.i(TAG, "systemRestoreFinished for " + userId);
        L5:
            Object r0 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.mHasSystemRestoreFinished = true;     // Catch: Throwable -> L11
            maybeSendWidgetRestoreBroadcastsLocked(userId);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void widgetComponentsChanged(int userId) {
            Object r0 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mHasSystemRestoreFinished == false) goto L9;
            maybeSendWidgetRestoreBroadcastsLocked(userId);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private void maybeSendWidgetRestoreBroadcastsLocked(int userId) {
            BackupRestoreController r0 = this;
            if (DEBUG == false) goto L5;
            Slog.i(TAG, "maybeSendWidgetRestoreBroadcasts for " + userId);
        L5:
            UserHandle userHandle = new UserHandle(userId);
            Set<Map.Entry<Provider, List<RestoreUpdateRecord>>> providerEntries = r0.mUpdatesByProvider.entrySet();
            Iterator<Map.Entry<Provider, List<RestoreUpdateRecord>>> r10 = providerEntries.iterator();
        L7:
            if (r10.hasNext() == false) goto L28;
            Map.Entry<Provider, List<RestoreUpdateRecord>> e = r10.next();
            Provider provider = e.getKey();
            if (provider.zombie == true) goto L7;
            List<RestoreUpdateRecord> updates = e.getValue();
            int pending = r0.countPendingUpdates(updates);
            if (DEBUG == false) goto L14;
            Slog.i(TAG, "Provider " + provider + " pending: " + pending);
        L14:
            if (pending <= 0) goto L7;
            int[] oldIds = new int[pending];
            int[] newIds = new int[pending];
            int N = updates.size();
            int nextPending = 0;
            int i = 0;
        L16:
            if (i >= N) goto L25;
            RestoreUpdateRecord r = updates.get(i);
            List<RestoreUpdateRecord> updates2 = updates;
            if (r.notified == true) goto L24;
            r.notified = true;
            oldIds[nextPending] = r.oldId;
            newIds[nextPending] = r.newId;
            nextPending = nextPending + 1;
            if (DEBUG == false) goto L24;
            Slog.i(TAG, "   " + r.oldId + " => " + r.newId);
        L24:
            i = i + 1;
            updates = updates2;
            provider = provider;
            goto L16
        L25:
            r0 = this;
            r0.sendWidgetRestoreBroadcastLocked("android.appwidget.action.APPWIDGET_RESTORED", provider, null, oldIds, newIds, userHandle);
            goto L7
        L28:
            Set<Map.Entry<Host, List<RestoreUpdateRecord>>> hostEntries = r0.mUpdatesByHost.entrySet();
            Iterator<Map.Entry<Host, List<RestoreUpdateRecord>>> r14 = hostEntries.iterator();
        L30:
            if (r14.hasNext() == false) goto L51;
            Map.Entry<Host, List<RestoreUpdateRecord>> e2 = r14.next();
            Host host = e2.getKey();
            if (host.id.uid == (-1)) goto L50;
            List<RestoreUpdateRecord> updates3 = e2.getValue();
            int pending2 = r0.countPendingUpdates(updates3);
            if (DEBUG == false) goto L36;
            Slog.i(TAG, "Host " + host + " pending: " + pending2);
        L36:
            if (pending2 <= 0) goto L50;
            int[] oldIds2 = new int[pending2];
            int[] newIds2 = new int[pending2];
            int N2 = updates3.size();
            int nextPending2 = 0;
            int i2 = 0;
        L38:
            if (i2 >= N2) goto L47;
            int i3 = i2;
            RestoreUpdateRecord r2 = updates3.get(i2);
            List<RestoreUpdateRecord> updates4 = updates3;
            if (r2.notified == true) goto L46;
            r2.notified = true;
            oldIds2[nextPending2] = r2.oldId;
            newIds2[nextPending2] = r2.newId;
            nextPending2 = nextPending2 + 1;
            if (DEBUG == false) goto L46;
            StringBuilder r1 = new StringBuilder();
            r1.append("   ");
            int N3 = r2.oldId;
            r1.append(N3);
            r1.append(" => ");
            r1.append(r2.newId);
            Slog.i(TAG, r1.toString());
        L46:
            i2 = i3 + 1;
            updates3 = updates4;
            N2 = N2;
            goto L38
        L47:
            sendWidgetRestoreBroadcastLocked("android.appwidget.action.APPWIDGET_HOST_RESTORED", null, host, oldIds2, newIds2, userHandle);
        L50:
            r0 = this;
            goto L30
        }

        private Provider findProviderLocked(ComponentName componentName, int userId) {
            int providerCount = AppWidgetServiceImpl.m1857$$Nest$fgetmProviders(this.this$0).size();
            int i = 0;
        L3:
            if (i >= providerCount) goto L10;
            Provider provider = (Provider) AppWidgetServiceImpl.m1857$$Nest$fgetmProviders(this.this$0).get(i);
            if (provider.getUserId() != userId) goto L9;
            if (provider.id.componentName.equals(componentName) == false) goto L9;
            return provider;
        L9:
            i = i + 1;
            goto L3
        L10:
            return null;
        }

        private Widget findRestoredWidgetLocked(int restoredId, Host host, Provider p) {
            if (DEBUG == false) goto L6;
            Slog.i(TAG, "Find restored widget: id=" + restoredId + " host=" + host + " provider=" + p);
        L6:
            if (p == null) goto L24;
            if (host == null) goto L24;
            int N = AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).size();
            int i = 0;
        L10:
            if (i >= N) goto L23;
            Widget widget = (Widget) AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).get(i);
            if (widget.restoredId != restoredId) goto L21;
            if (widget.host.id.equals(host.id) == false) goto L21;
            if (widget.provider.id.equals(p.id) == false) goto L21;
            if (DEBUG == false) goto L20;
            Slog.i(TAG, "   Found at " + i + " : " + widget);
        L20:
            return widget;
        L21:
            i = i + 1;
            goto L10
        L23:
            return null;
        L24:
            return null;
        }

        private boolean packageNeedsWidgetBackupLocked(String packageName, int userId) {
            int N = AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).size();
            int i = 0;
        L3:
            if (i >= N) goto L16;
            Widget widget = (Widget) AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).get(i);
            if (isProviderAndHostInUser(widget, userId) == false) goto L15;
            if (widget.host.isInPackageForUser(packageName, userId) == true) goto L9;
            Provider provider = widget.provider;
            if (provider == null) goto L15;
            if (provider.isInPackageForUser(packageName, userId) == false) goto L15;
            return true;
        L9:
            return true;
        L15:
            i = i + 1;
            goto L3
        L16:
            return false;
        }

        private void stashProviderRestoreUpdateLocked(Provider provider, int oldId, int newId) {
            List<RestoreUpdateRecord> r = this.mUpdatesByProvider.get(provider);
            if (r != null) goto L6;
            r = new ArrayList();
            this.mUpdatesByProvider.put(provider, r);
        L11:
            r.add(new RestoreUpdateRecord(oldId, newId));
            return;
        L6:
            if (alreadyStashed(r, oldId, newId) == false) goto L11;
            if (DEBUG == false) goto L13;
            Slog.i(TAG, "ID remap " + oldId + " -> " + newId + " already stashed for " + provider);
            return;
        }

        private boolean alreadyStashed(List<RestoreUpdateRecord> stash, int oldId, int newId) {
            int N = stash.size();
            int i = 0;
        L3:
            if (i >= N) goto L11;
            RestoreUpdateRecord r = stash.get(i);
            if (r.oldId != oldId) goto L10;
            if (r.newId != newId) goto L10;
            return true;
        L10:
            i = i + 1;
            goto L3
        L11:
            return false;
        }

        private void stashHostRestoreUpdateLocked(Host host, int oldId, int newId) {
            List<RestoreUpdateRecord> r = this.mUpdatesByHost.get(host);
            if (r != null) goto L6;
            r = new ArrayList();
            this.mUpdatesByHost.put(host, r);
        L11:
            r.add(new RestoreUpdateRecord(oldId, newId));
            return;
        L6:
            if (alreadyStashed(r, oldId, newId) == false) goto L11;
            if (DEBUG == false) goto L13;
            Slog.i(TAG, "ID remap " + oldId + " -> " + newId + " already stashed for " + host);
            return;
        }

        private void sendWidgetRestoreBroadcastLocked(String action, Provider provider, Host host, int[] oldIds, int[] newIds, UserHandle userHandle) {
            Intent intent = new Intent(action);
            intent.putExtra("appWidgetOldIds", oldIds);
            intent.putExtra("appWidgetIds", newIds);
            if (provider == null) goto L5;
            intent.setComponent(provider.id.componentName);
            AppWidgetServiceImpl.m1878$$Nest$msendBroadcastAsUser(this.this$0, intent, userHandle, true);
        L5:
            if (host == null) goto L8;
            intent.setComponent(null);
            intent.setPackage(host.id.packageName);
            intent.putExtra("hostId", host.id.hostId);
            AppWidgetServiceImpl.m1878$$Nest$msendBroadcastAsUser(this.this$0, intent, userHandle, true);
            return;
        }

        private void pruneWidgetStateLocked(String pkg, int userId) {
            Set<String> prunedApps = getPrunedAppsLocked(userId);
            if (prunedApps.contains(pkg) == true) goto L21;
            if (DEBUG == false) goto L7;
            Slog.i(TAG, "pruning widget state for restoring package " + pkg);
        L7:
            int i = AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).size() - 1;
        L8:
            if (i < 0) goto L19;
            Widget widget = (Widget) AppWidgetServiceImpl.m1860$$Nest$fgetmWidgets(this.this$0).get(i);
            Host host = widget.host;
            Provider provider = widget.provider;
            if (Host.m1889$$Nest$mhostsPackageForUser(host, pkg, userId) == true) goto L14;
            if (provider == null) goto L18;
            if (provider.isInPackageForUser(pkg, userId) == true) goto L14;
        L18:
            i = i - 1;
        L14:
            host.widgets.remove(widget);
            if (provider == null) goto L17;
            provider.widgets.remove(widget);
        L17:
            AppWidgetServiceImpl.m1862$$Nest$mdecrementAppWidgetServiceRefCount(this.this$0, widget);
            this.this$0.removeWidgetLocked(widget);
            goto L18
        L19:
            prunedApps.add(pkg);
            return;
        L21:
            if (DEBUG == false) goto L29;
            Slog.i(TAG, "already pruned " + pkg + ", continuing normally");
            return;
        }

        private Set<String> getPrunedAppsLocked(int userId) {
            if (this.mPrunedAppsPerUser.contains(userId) == true) goto L6;
            this.mPrunedAppsPerUser.set(userId, new ArraySet());
        L6:
            return this.mPrunedAppsPerUser.get(userId);
        }

        private boolean isProviderAndHostInUser(Widget widget, int userId) {
            if (widget.host.getUserId() == userId) goto L5;
        L9:
            return false;
        L5:
            if (widget.provider != null) goto L7;
        L8:
            return true;
        L7:
            if (widget.provider.getUserId() != userId) goto L9;
            goto L8
        }

        private int countPendingUpdates(List<RestoreUpdateRecord> updates) {
            int pending = 0;
            int N = updates.size();
            int i = 0;
        L3:
            if (i >= N) goto L9;
            RestoreUpdateRecord r = updates.get(i);
            if (r.notified == true) goto L7;
            pending = pending + 1;
        L7:
            i = i + 1;
            goto L3
        L9:
            return pending;
        }

        private State getStateLocked(final int userId) {
            Set<String> prunedApps = this.mPrunedAppsPerUser.get(userId);
            final SparseArray<List<RestoreUpdateRecord>> updatesByProvider = new SparseArray();
            final SparseArray<List<RestoreUpdateRecord>> updatesByHost = new SparseArray();
            this.mUpdatesByProvider.forEach(new AppWidgetServiceImpl$BackupRestoreController$$ExternalSyntheticLambda0(userId, updatesByProvider));
            this.mUpdatesByHost.forEach(new AppWidgetServiceImpl$BackupRestoreController$$ExternalSyntheticLambda1(userId, updatesByHost));
            return new State(prunedApps, updatesByProvider, updatesByHost);
        }

        private static /* synthetic */ void lambda$getStateLocked$0(int userId, SparseArray updatesByProvider, Provider p, List updates) {
            if (p.getUserId() != userId) goto L6;
            updatesByProvider.put(p.tag, new ArrayList(updates));
            return;
        }

        private static /* synthetic */ void lambda$getStateLocked$1(int userId, SparseArray updatesByHost, Host h, List updates) {
            if (h.getUserId() != userId) goto L6;
            updatesByHost.put(h.tag, new ArrayList(updates));
            return;
        }
    }

    private final class CallbackHandler extends Handler {
        public static final int MSG_NOTIFY_APP_WIDGET_REMOVED = 5;
        public static final int MSG_NOTIFY_PROVIDERS_CHANGED = 3;
        public static final int MSG_NOTIFY_PROVIDER_CHANGED = 2;
        public static final int MSG_NOTIFY_UPDATE_APP_WIDGET = 1;
        public static final int MSG_NOTIFY_UPDATE_APP_WIDGET_DEFERRED = 6;
        public static final int MSG_NOTIFY_VIEW_DATA_CHANGED = 4;
        final /* synthetic */ AppWidgetServiceImpl this$0;

        public CallbackHandler(AppWidgetServiceImpl r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, false);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch(message.what) {
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L17;
            };
        L5:
            SomeArgs args = (SomeArgs) message.obj;
            Host host = (Host) args.arg1;
            IAppWidgetHost callbacks = (IAppWidgetHost) args.arg2;
            long requestId = ((Long) args.arg4).longValue();
            int appWidgetId = args.argi1;
            args.recycle();
            AppWidgetServiceImpl.m1871$$Nest$mhandleNotifyUpdateAppWidgetDeferred(this.this$0, host, callbacks, appWidgetId, requestId);
            return;
        L6:
            SomeArgs args2 = (SomeArgs) message.obj;
            Host host2 = (Host) args2.arg1;
            IAppWidgetHost callbacks2 = (IAppWidgetHost) args2.arg2;
            long requestId2 = ((Long) args2.arg3).longValue();
            int appWidgetId2 = args2.argi1;
            args2.recycle();
            AppWidgetServiceImpl.m1866$$Nest$mhandleNotifyAppWidgetRemoved(this.this$0, host2, callbacks2, appWidgetId2, requestId2);
            return;
        L7:
            SomeArgs args3 = (SomeArgs) message.obj;
            Host host3 = (Host) args3.arg1;
            IAppWidgetHost callbacks3 = (IAppWidgetHost) args3.arg2;
            long requestId3 = ((Long) args3.arg3).longValue();
            int appWidgetId3 = args3.argi1;
            int viewId = args3.argi2;
            args3.recycle();
            AppWidgetServiceImpl.m1867$$Nest$mhandleNotifyAppWidgetViewDataChanged(this.this$0, host3, callbacks3, appWidgetId3, viewId, requestId3);
            return;
        L8:
            SomeArgs args4 = (SomeArgs) message.obj;
            Host host4 = (Host) args4.arg1;
            IAppWidgetHost callbacks4 = (IAppWidgetHost) args4.arg2;
            args4.recycle();
            AppWidgetServiceImpl.m1869$$Nest$mhandleNotifyProvidersChanged(this.this$0, host4, callbacks4);
            return;
        L9:
            SomeArgs args5 = (SomeArgs) message.obj;
            Host host5 = (Host) args5.arg1;
            IAppWidgetHost callbacks5 = (IAppWidgetHost) args5.arg2;
            AppWidgetProviderInfo info = (AppWidgetProviderInfo) args5.arg3;
            long requestId4 = ((Long) args5.arg4).longValue();
            int appWidgetId4 = args5.argi1;
            args5.recycle();
            AppWidgetServiceImpl.m1868$$Nest$mhandleNotifyProviderChanged(this.this$0, host5, callbacks5, appWidgetId4, info, requestId4);
            return;
        L10:
            SomeArgs args6 = (SomeArgs) message.obj;
            Host host6 = (Host) args6.arg1;
            IAppWidgetHost callbacks6 = (IAppWidgetHost) args6.arg2;
            RemoteViews views = (RemoteViews) args6.arg3;
            long requestId5 = ((Long) args6.arg4).longValue();
            int appWidgetId5 = args6.argi1;
            args6.recycle();
            AppWidgetServiceImpl.m1870$$Nest$mhandleNotifyUpdateAppWidget(this.this$0, host6, callbacks6, appWidgetId5, views, requestId5);
            return;
        }
    }

    static final class Host {
        private static final boolean DEBUG = true;
        private static final String TAG = "AppWidgetServiceHost";
        IAppWidgetHost callbacks;
        HostId id;
        long lastWidgetUpdateSequenceNo;
        int tag;
        ArrayList<Widget> widgets;
        boolean zombie;

        /* JADX INFO: renamed from: -$$Nest$mhostsPackageForUser, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1889$$Nest$mhostsPackageForUser(Host r0, String r1, int r2) {
            return r0.hostsPackageForUser(r1, r2);
        }

        Host() {
            this.widgets = new ArrayList();
            this.tag = -1;
        }

        public int getUserId() {
            return UserHandle.getUserId(this.id.uid);
        }

        public boolean isInPackageForUser(String packageName, int userId) {
            if (getUserId() == userId) goto L5;
        L7:
            return false;
        L5:
            if (this.id.packageName.equals(packageName) == false) goto L7;
            return true;
        }

        private boolean hostsPackageForUser(String pkg, int userId) {
            int N = this.widgets.size();
            int i = 0;
        L3:
            if (i >= N) goto L13;
            Provider provider = this.widgets.get(i).provider;
            if (provider == null) goto L12;
            if (provider.getUserId() != userId) goto L12;
            if (pkg.equals(provider.id.componentName.getPackageName()) == false) goto L12;
            return true;
        L12:
            i = i + 1;
            goto L3
        L13:
            return false;
        }

        public void getPendingUpdatesForIdLocked(Context context, int appWidgetId, LongSparseArray<PendingHostUpdate> outUpdates) {
            long updateSequenceNo = this.lastWidgetUpdateSequenceNo;
            int N = this.widgets.size();
            int i = 0;
        L3:
            if (i >= N) goto L21;
            Widget widget = this.widgets.get(i);
            if (widget.appWidgetId == appWidgetId) goto L6;
            i = i + 1;
            goto L3
        L6:
            int j = widget.updateSequenceNos.size() - 1;
        L7:
            if (j < 0) goto L19;
            long requestId = widget.updateSequenceNos.valueAt(j);
            if (requestId <= updateSequenceNo) goto L17;
            int id = widget.updateSequenceNos.keyAt(j);
            switch(id) {
                case 0: goto L15;
                case 1: goto L14;
                default: goto L13;
            };
        L13:
            PendingHostUpdate update = PendingHostUpdate.viewDataChanged(appWidgetId, id);
        L16:
            outUpdates.put(requestId, update);
            goto L17
        L14:
            update = PendingHostUpdate.providerChanged(appWidgetId, widget.provider.getInfoLocked(context));
            goto L16
        L15:
            update = PendingHostUpdate.updateAppWidget(appWidgetId, AppWidgetServiceImpl.m1882$$Nest$smcloneIfLocalBinder(widget.getEffectiveViewsLocked()));
        L17:
            j = j - 1;
            goto L7
        L19:
            return;
        L21:
            outUpdates.put(this.lastWidgetUpdateSequenceNo, PendingHostUpdate.appWidgetRemoved(appWidgetId));
        }

        public SparseArray<String> getWidgetUidsIfBound() {
            SparseArray<String> uids = new SparseArray();
            int i = this.widgets.size() - 1;
        L3:
            if (i < 0) goto L10;
            Widget widget = this.widgets.get(i);
            if (widget.provider != null) goto L7;
            Slog.d(TAG, "Widget with no provider " + widget.toString());
        L8:
            i = i - 1;
            goto L3
        L7:
            ProviderId providerId = widget.provider.id;
            uids.put(providerId.uid, providerId.componentName.getPackageName());
            goto L8
        L10:
            return uids;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("Host{");
            r0.append(this.id);
            if (this.zombie == false) goto L5;
            String r1 = " Z";
        L6:
            r0.append(r1);
            r0.append('}');
            return r0.toString();
        L5:
            r1 = "";
            goto L6
        }
    }

    private static final class HostId {
        final int hostId;
        final String packageName;
        final int uid;

        public HostId(int uid, int hostId, String packageName) {
            this.uid = uid;
            this.hostId = hostId;
            this.packageName = packageName;
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if (obj != null) goto L9;
            return false;
        L9:
            if (getClass() == obj.getClass()) goto L11;
            return false;
        L11:
            HostId other = (HostId) obj;
            if (this.uid == other.uid) goto L15;
            return false;
        L15:
            if (this.hostId == other.hostId) goto L18;
            return false;
        L18:
            if (this.packageName != null) goto L23;
            if (other.packageName == null) goto L25;
            return false;
        L25:
            return true;
        L23:
            if (this.packageName.equals(other.packageName) == true) goto L25;
            return false;
        }

        public int hashCode() {
            int result = this.uid;
            int result2 = (result * 31) + this.hostId;
            int result3 = result2 * 31;
            if (this.packageName == null) goto L5;
            int r2 = this.packageName.hashCode();
        L7:
            return result3 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "HostId{user:" + UserHandle.getUserId(this.uid) + ", app:" + UserHandle.getAppId(this.uid) + ", hostId:" + this.hostId + ", pkg:" + this.packageName + '}';
        }
    }

    private class LoadedWidgetState {
        final int hostTag;
        final int providerTag;
        final Widget widget;

        public LoadedWidgetState(AppWidgetServiceImpl r1, Widget widget, int hostTag, int providerTag) {
            this.widget = widget;
            this.hostTag = hostTag;
            this.providerTag = providerTag;
        }
    }

    static final class Provider {
        private static final int[] WIDGET_CATEGORY_FLAGS = null;
        PendingIntent broadcast;
        SparseArray<RemoteViews> generatedPreviews;
        ProviderId id;
        AppWidgetProviderInfo info;
        String infoTag;
        boolean mInfoParsed;
        boolean maskedByLockedProfile;
        boolean maskedByQuietProfile;
        boolean maskedByStoppedPackage;
        boolean maskedBySuspendedPackage;
        IntArray pendingDeletedWidgetIds;
        int tag;
        ArrayList<Widget> widgets;
        boolean zombie;

        /* JADX INFO: renamed from: -$$Nest$mupdateGeneratedPreviewCategoriesLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m1890$$Nest$mupdateGeneratedPreviewCategoriesLocked(Provider r0, SparseArray r1) {
            r0.updateGeneratedPreviewCategoriesLocked(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$sfgetWIDGET_CATEGORY_FLAGS, reason: not valid java name */
        static /* bridge */ /* synthetic */ int[] m1891$$Nest$sfgetWIDGET_CATEGORY_FLAGS() {
            return WIDGET_CATEGORY_FLAGS;
        }

        Provider() {
            this.widgets = new ArrayList();
            this.generatedPreviews = new SparseArray(3);
            this.pendingDeletedWidgetIds = new IntArray();
            this.mInfoParsed = false;
            this.tag = -1;
        }

        static {
            WIDGET_CATEGORY_FLAGS = new int[]{1, 2, 4};
        }

        public int getUserId() {
            return UserHandle.getUserId(this.id.uid);
        }

        public boolean isInPackageForUser(String packageName, int userId) {
            if (getUserId() == userId) goto L5;
        L7:
            return false;
        L5:
            if (this.id.componentName.getPackageName().equals(packageName) == false) goto L7;
            return true;
        }

        public boolean hostedByPackageForUser(String packageName, int userId) {
            int N = this.widgets.size();
            int i = 0;
        L3:
            if (i >= N) goto L11;
            Widget widget = this.widgets.get(i);
            if (packageName.equals(widget.host.id.packageName) == false) goto L10;
            if (widget.host.getUserId() != userId) goto L10;
            return true;
        L10:
            i = i + 1;
            goto L3
        L11:
            return false;
        }

        public AppWidgetProviderInfo getInfoLocked(Context context) {
            if (this.mInfoParsed == true) goto L17;
            if (this.zombie == true) goto L15;
            AppWidgetProviderInfo newInfo = null;
            if (TextUtils.isEmpty(this.infoTag) == true) goto L9;
            newInfo = AppWidgetServiceImpl.m1883$$Nest$smparseAppWidgetProviderInfo(context, this.id, this.info.providerInfo, this.infoTag);
        L9:
            if (newInfo != null) goto L11;
            newInfo = AppWidgetServiceImpl.m1883$$Nest$smparseAppWidgetProviderInfo(context, this.id, this.info.providerInfo, "android.appwidget.provider");
        L11:
            if (newInfo == null) goto L15;
            newInfo.generatedPreviewCategories = this.info.generatedPreviewCategories;
            this.info = newInfo;
            if (AppWidgetServiceImpl.m1881$$Nest$sfgetDEBUG() == false) goto L15;
            this.info.getClass();
        L15:
            this.mInfoParsed = true;
        L17:
            return this.info;
        }

        public AppWidgetProviderInfo getPartialInfoLocked() {
            return this.info;
        }

        public void setPartialInfoLocked(AppWidgetProviderInfo info) {
            this.info = info;
            if (AppWidgetServiceImpl.m1881$$Nest$sfgetDEBUG() == false) goto L5;
            this.info.getClass();
        L5:
            this.mInfoParsed = false;
        }

        public void setInfoLocked(AppWidgetProviderInfo info) {
            this.info = info;
            if (AppWidgetServiceImpl.m1881$$Nest$sfgetDEBUG() == false) goto L5;
            this.info.getClass();
        L5:
            this.mInfoParsed = true;
        }

        public RemoteViews getGeneratedPreviewLocked(int widgetCategories) {
            int i = 0;
        L4:
            if (i >= this.generatedPreviews.size()) goto L10;
            if ((this.generatedPreviews.keyAt(i) & widgetCategories) != 0) goto L8;
            i = i + 1;
            goto L4
        L8:
            return this.generatedPreviews.valueAt(i);
        L10:
            return null;
        }

        public void setGeneratedPreviewLocked(int widgetCategories, RemoteViews preview) {
            int[] r0 = WIDGET_CATEGORY_FLAGS;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            int flag = r0[r2];
            if ((widgetCategories & flag) == 0) goto L7;
            this.generatedPreviews.put(flag, preview);
        L7:
            r2 = r2 + 1;
            goto L3
        L8:
            updateGeneratedPreviewCategoriesLocked(this.generatedPreviews);
        }

        public boolean removeGeneratedPreviewLocked(int widgetCategories) {
            boolean changed = false;
            int[] r1 = WIDGET_CATEGORY_FLAGS;
            int r2 = r1.length;
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L12;
            int flag = r1[r4];
            if ((widgetCategories & flag) == 0) goto L11;
            if (this.generatedPreviews.removeReturnOld(flag) == null) goto L9;
            boolean r6 = true;
        L10:
            changed = changed | r6;
            goto L11
        L9:
            r6 = false;
        L11:
            r4 = r4 + 1;
            goto L3
        L12:
            if (changed == false) goto L14;
            updateGeneratedPreviewCategoriesLocked(this.generatedPreviews);
        L14:
            return changed;
        }

        public boolean clearGeneratedPreviewsLocked() {
            if (this.generatedPreviews.size() <= 0) goto L6;
            this.generatedPreviews.clear();
            updateGeneratedPreviewCategoriesLocked(this.generatedPreviews);
            return true;
        L6:
            return false;
        }

        private void updateGeneratedPreviewCategoriesLocked(SparseArray<RemoteViews> previews) {
            this.info.generatedPreviewCategories = 0;
            if (previews == null) goto L8;
            int i = 0;
        L6:
            if (i >= previews.size()) goto L10;
            this.info.generatedPreviewCategories |= previews.keyAt(i);
            i = i + 1;
            goto L6
        L10:
            return;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("Provider{");
            r0.append(this.id);
            if (this.zombie == false) goto L5;
            String r1 = " Z";
        L6:
            r0.append(r1);
            r0.append('}');
            return r0.toString();
        L5:
            r1 = "";
            goto L6
        }

        public boolean setMaskedByQuietProfileLocked(boolean masked) {
            boolean oldState = this.maskedByQuietProfile;
            this.maskedByQuietProfile = masked;
            if (masked == oldState) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean setMaskedByLockedProfileLocked(boolean masked) {
            boolean oldState = this.maskedByLockedProfile;
            this.maskedByLockedProfile = masked;
            if (masked == oldState) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean setMaskedBySuspendedPackageLocked(boolean masked) {
            boolean oldState = this.maskedBySuspendedPackage;
            this.maskedBySuspendedPackage = masked;
            if (masked == oldState) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean setMaskedByStoppedPackageLocked(boolean masked) {
            boolean oldState = this.maskedByStoppedPackage;
            this.maskedByStoppedPackage = masked;
            if (masked == oldState) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isMaskedLocked() {
            if (this.maskedByQuietProfile == false) goto L5;
        L12:
            return true;
        L5:
            if (this.maskedByLockedProfile == true) goto L12;
            if (this.maskedBySuspendedPackage == true) goto L12;
            if (this.maskedByStoppedPackage == true) goto L12;
            return false;
        }

        public boolean shouldBePersisted() {
            if (this.widgets.isEmpty() == true) goto L5;
        L8:
            return true;
        L5:
            if (TextUtils.isEmpty(this.infoTag) == false) goto L8;
            return false;
        }
    }

    static final class ProviderId {
        final ComponentName componentName;
        final int uid;

        ProviderId(int uid, ComponentName componentName) {
            this.uid = uid;
            this.componentName = componentName;
        }

        public UserHandle getProfile() {
            return UserHandle.getUserHandleForUid(this.uid);
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if (obj != null) goto L9;
            return false;
        L9:
            if (getClass() == obj.getClass()) goto L11;
            return false;
        L11:
            ProviderId other = (ProviderId) obj;
            if (this.uid == other.uid) goto L15;
            return false;
        L15:
            if (this.componentName != null) goto L20;
            if (other.componentName == null) goto L22;
            return false;
        L22:
            return true;
        L20:
            if (this.componentName.equals(other.componentName) == true) goto L22;
            return false;
        }

        public int hashCode() {
            int result = this.uid;
            int r1 = result * 31;
            if (this.componentName == null) goto L5;
            int r2 = this.componentName.hashCode();
        L6:
            int result2 = r1 + r2;
            return result2;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "ProviderId{user:" + UserHandle.getUserId(this.uid) + ", app:" + UserHandle.getAppId(this.uid) + ", cmp:" + this.componentName + '}';
        }
    }

    private final class SaveStateRunnable implements Runnable {
        final int mUserId;
        final /* synthetic */ AppWidgetServiceImpl this$0;

        public SaveStateRunnable(AppWidgetServiceImpl r1, int userId) {
            this.this$0 = r1;
            this.mUserId = userId;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            Trace.traceBegin(64, "convert_state_and_io");     // Catch: Throwable -> L7
            AppWidgetServiceImpl.m1864$$Nest$mensureGroupStateLoadedLocked(this.this$0, this.mUserId, false);     // Catch: Throwable -> L7
            AppWidgetServiceImpl.m1877$$Nest$msaveStateLocked(this.this$0, this.mUserId);     // Catch: Throwable -> L7
            Trace.traceEnd(64);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private final class SecurityPolicy {
        final /* synthetic */ AppWidgetServiceImpl this$0;

        /* synthetic */ SecurityPolicy(AppWidgetServiceImpl r1, AppWidgetServiceImplIA r2) {
            this(r1);
        }

        private SecurityPolicy(AppWidgetServiceImpl r1) {
            this.this$0 = r1;
        }

        public boolean isEnabledGroupProfile(int profileId) {
            int parentId = UserHandle.getCallingUserId();
            if (isParentOrProfile(parentId, profileId) == true) goto L5;
        L7:
            return false;
        L5:
            if (isProfileEnabled(profileId) == false) goto L7;
            return true;
        }

        public int[] getEnabledGroupProfileIds(int userId) {
            int parentId = getGroupParent(userId);
            long identity = Binder.clearCallingIdentity();
            int[] r3 = AppWidgetServiceImpl.m1859$$Nest$fgetmUserManager(this.this$0).getEnabledProfileIds(parentId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void enforceServiceExistsAndRequiresBindRemoteViewsPermission(ComponentName componentName, int userId) {
            long identity = Binder.clearCallingIdentity();
            ServiceInfo serviceInfo = AppWidgetServiceImpl.m1855$$Nest$fgetmPackageManager(this.this$0).getServiceInfo(componentName, 4096, userId);     // Catch: Throwable -> L11 RemoteException -> L13
            if (serviceInfo == null) goto L16;
            if ("android.permission.BIND_REMOTEVIEWS".equals(serviceInfo.permission) == true) goto L8;
            throw new SecurityException("Service " + componentName + " in user " + userId + "does not require android.permission.BIND_REMOTEVIEWS");     // Catch: Throwable -> L11 RemoteException -> L13
        L16:
            throw new SecurityException("Service " + componentName + " not installed for user " + userId);     // Catch: Throwable -> L11 RemoteException -> L13
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L8:
            Binder.restoreCallingIdentity(identity);
        }

        public void enforceModifyAppWidgetBindPermissions(String packageName) {
            AppWidgetServiceImpl.m1851$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.MODIFY_APPWIDGET_BIND_PERMISSIONS", "hasBindAppWidgetPermission packageName=" + packageName);
        }

        public boolean isCallerInstantAppLocked() {
            int callingUid = Binder.getCallingUid();
            long identity = Binder.clearCallingIdentity();
            String[] uidPackages = AppWidgetServiceImpl.m1855$$Nest$fgetmPackageManager(this.this$0).getPackagesForUid(callingUid);     // Catch: Throwable -> L8 RemoteException -> L10
            if (ArrayUtils.isEmpty(uidPackages) == true) goto L13;
            boolean r3 = AppWidgetServiceImpl.m1855$$Nest$fgetmPackageManager(this.this$0).isInstantApp(uidPackages[0], UserHandle.getUserId(callingUid));     // Catch: Throwable -> L8 RemoteException -> L10
            Binder.restoreCallingIdentity(identity);
            return r3;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L13:
            Binder.restoreCallingIdentity(identity);
            return false;
        }

        public boolean isInstantAppLocked(String packageName, int userId) {
            long identity = Binder.clearCallingIdentity();
            boolean r2 = AppWidgetServiceImpl.m1855$$Nest$fgetmPackageManager(this.this$0).isInstantApp(packageName, userId);     // Catch: Throwable -> L6 RemoteException -> L8
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L12:
            Binder.restoreCallingIdentity(identity);
            return false;
        }

        public void enforceCallFromPackage(String packageName) {
            AppWidgetServiceImpl.m1850$$Nest$fgetmAppOpsManager(this.this$0).checkPackage(Binder.getCallingUid(), packageName);
        }

        public boolean hasCallerBindPermissionOrBindWhiteListedLocked(String packageName) {
            AppWidgetServiceImpl.m1851$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.BIND_APPWIDGET", null);     // Catch: SecurityException -> L4
            return true;
        L6:
            if (isCallerBindAppWidgetAllowListedLocked(packageName) == true) goto L9;
            return false;
        L9:
            return true;
        }

        private boolean isCallerBindAppWidgetAllowListedLocked(String packageName) {
            int userId = UserHandle.getCallingUserId();
            int packageUid = AppWidgetServiceImpl.m1865$$Nest$mgetUidForPackage(this.this$0, packageName, userId);
            if (packageUid < 0) goto L20;
            Object r2 = AppWidgetServiceImpl.m1854$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
            AppWidgetServiceImpl.m1863$$Nest$mensureGroupStateLoadedLocked(this.this$0, userId);     // Catch: Throwable -> L11
            Pair<Integer, String> packageId = Pair.create(Integer.valueOf(userId), packageName);     // Catch: Throwable -> L11
            if (AppWidgetServiceImpl.m1856$$Nest$fgetmPackagesWithBindWidgetPermission(this.this$0).contains(packageId) == false) goto L14;
            monitor-exit(r2);     // Catch: Throwable -> L11
            return true;
        L14:
            monitor-exit(r2);     // Catch: Throwable -> L11
            return false;
        L11:
            th = move-exception;
            throw th;
        L20:
            throw new IllegalArgumentException("No package " + packageName + " for user " + userId);
        }

        public boolean canAccessAppWidget(Widget widget, int uid, String packageName) {
            if (packageName == null) goto L14;
            if (widget.provider == null) goto L14;
            if (isDifferentPackageFromProvider(widget.provider, packageName) == false) goto L14;
            if (widget.host == null) goto L14;
            if (isDifferentPackageFromHost(widget.host, packageName) == false) goto L14;
            return false;
        L14:
            if (isHostInPackageForUid(widget.host, uid, packageName) == false) goto L17;
            return true;
        L17:
            if (isProviderInPackageForUid(widget.provider, uid, packageName) == false) goto L20;
            return true;
        L20:
            if (isHostAccessingProvider(widget.host, widget.provider, uid, packageName) == false) goto L22;
            return true;
        L22:
            int userId = UserHandle.getUserId(uid);
            if (widget.host.getUserId() == userId) goto L32;
            if (widget.provider == null) goto L29;
            if (widget.provider.getUserId() == userId) goto L32;
        L29:
            if (hasCallerInteractAcrossUsersPermission() == true) goto L32;
        L35:
            if (AppWidgetServiceImpl.m1881$$Nest$sfgetDEBUG() == false) goto L37;
            Slog.i(AppWidgetServiceImpl.TAG, "canAccessAppWidget() failed. packageName=" + packageName + " uid=" + uid + " userId=" + userId + " widget=" + widget);
        L37:
            return false;
        L32:
            if (callerHasPermission("android.permission.BIND_APPWIDGET") == false) goto L35;
            return true;
        }

        private boolean isParentOrProfile(int parentId, int profileId) {
            if (parentId != profileId) goto L6;
            return true;
        L6:
            if (getProfileParent(profileId) == parentId) goto L10;
            return false;
        L10:
            return true;
        }

        public boolean canAccessProvider(String packageName, int profileId) {
            int callerId = UserHandle.getCallingUserId();
            if (profileId != callerId) goto L6;
            return true;
        L6:
            int parentId = getProfileParent(profileId);
            if (parentId == callerId) goto L11;
            return false;
        L11:
            return isProviderWhiteListed(packageName, profileId);
        }

        public boolean isProviderWhiteListed(String packageName, int profileId) {
            if (AppWidgetServiceImpl.m1852$$Nest$fgetmDevicePolicyManagerInternal(this.this$0) != null) goto L6;
            return false;
        L6:
            List<String> crossProfilePackages = AppWidgetServiceImpl.m1852$$Nest$fgetmDevicePolicyManagerInternal(this.this$0).getCrossProfileWidgetProviders(profileId);
            return crossProfilePackages.contains(packageName);
        }

        public int getProfileParent(int profileId) {
            long identity = Binder.clearCallingIdentity();
            UserInfo parent = AppWidgetServiceImpl.m1859$$Nest$fgetmUserManager(this.this$0).getProfileParent(profileId);     // Catch: Throwable -> L8
            if (parent == null) goto L10;
            int r3 = parent.getUserHandle().getIdentifier();     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return r3;
        L10:
            Binder.restoreCallingIdentity(identity);
            return -10;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public int getGroupParent(int profileId) {
            int parentId = AppWidgetServiceImpl.m1858$$Nest$fgetmSecurityPolicy(this.this$0).getProfileParent(profileId);
            if (parentId == (-10)) goto L6;
            return parentId;
        L6:
            return profileId;
        }

        public boolean isHostInPackageForUid(Host host, int uid, String packageName) {
            if (host.id.uid == uid) goto L5;
        L7:
            return false;
        L5:
            if (host.id.packageName.equals(packageName) == false) goto L7;
            return true;
        }

        public boolean isProviderInPackageForUid(Provider provider, int uid, String packageName) {
            if (provider != null) goto L4;
        L8:
            return false;
        L4:
            if (provider.id.uid != uid) goto L8;
            if (provider.id.componentName.getPackageName().equals(packageName) == false) goto L8;
            return true;
        }

        public boolean isHostAccessingProvider(Host host, Provider provider, int uid, String packageName) {
            if (host.id.uid != uid) goto L8;
            if (provider == null) goto L8;
            if (provider.id.componentName.getPackageName().equals(packageName) == false) goto L8;
            return true;
        L8:
            return false;
        }

        private boolean isDifferentPackageFromHost(Host host, String packageName) {
            if (host.id != null) goto L5;
        L9:
            return true;
        L5:
            if (host.id.packageName == null) goto L9;
            return !packageName.equals(host.id.packageName);
        }

        private boolean isDifferentPackageFromProvider(Provider provider, String packageName) {
            if (provider.id != null) goto L5;
        L9:
            return true;
        L5:
            if (provider.id.componentName == null) goto L9;
            return !packageName.equals(provider.id.componentName.getPackageName());
        }

        private boolean isProfileEnabled(int profileId) {
            long identity = Binder.clearCallingIdentity();
            UserInfo userInfo = AppWidgetServiceImpl.m1859$$Nest$fgetmUserManager(this.this$0).getUserInfo(profileId);     // Catch: Throwable -> L10
            if (userInfo == null) goto L12;
            if (userInfo.isEnabled() == false) goto L12;
            Binder.restoreCallingIdentity(identity);
            return true;
        L12:
            Binder.restoreCallingIdentity(identity);
            return false;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public boolean hasCallerInteractAcrossUsersPermission() {
            if (callerHasPermission("android.permission.INTERACT_ACROSS_USERS") == false) goto L5;
        L8:
            return true;
        L5:
            if (callerHasPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == true) goto L8;
            return false;
        }

        private boolean callerHasPermission(String permission) {
            if (AppWidgetServiceImpl.m1851$$Nest$fgetmContext(this.this$0).checkCallingPermission(permission) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private static final class Widget {
        int appWidgetId;
        Host host;
        RemoteViews maskedViews;
        Bundle options;
        Provider provider;
        int restoredId;
        boolean trackingUpdate;
        SparseLongArray updateSequenceNos;
        RemoteViews views;

        /* JADX INFO: renamed from: -$$Nest$mclearMaskedViewsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1892$$Nest$mclearMaskedViewsLocked(Widget r0) {
            return r0.clearMaskedViewsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mreplaceWithMaskedViewsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1893$$Nest$mreplaceWithMaskedViewsLocked(Widget r0, RemoteViews r1) {
            return r0.replaceWithMaskedViewsLocked(r1);
        }

        /* synthetic */ Widget(AppWidgetServiceImplIA r1) {
            this();
        }

        private Widget() {
            this.updateSequenceNos = new SparseLongArray(2);
            this.trackingUpdate = false;
        }

        public String toString() {
            return "AppWidgetId{" + this.appWidgetId + ':' + this.host + ':' + this.provider + '}';
        }

        private boolean replaceWithMaskedViewsLocked(RemoteViews views) {
            this.maskedViews = views;
            return true;
        }

        private boolean clearMaskedViewsLocked() {
            if (this.maskedViews == null) goto L6;
            this.maskedViews = null;
            return true;
        L6:
            return false;
        }

        public RemoteViews getEffectiveViewsLocked() {
            if (this.maskedViews == null) goto L6;
            return this.maskedViews;
        L6:
            return this.views;
        }
    }

    public static /* synthetic */ void $r8$lambda$0ewWCmGttnHykEDaxPiwssWG2Ng(AppWidgetServiceImpl r0, PendingIntent r1) {
        r0.lambda$cancelBroadcastsLocked$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$1R_AdIKm91vlvjM49xzzCUsmURo(AppWidgetServiceImpl r0, Provider r1, int r2) {
        r0.lambda$removeGeneratedPreviewsAsync$6(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$97_NqFhNdH7yi75Hrr_1-A9lAN0, reason: not valid java name */
    public static /* synthetic */ void m1846$r8$lambda$97_NqFhNdH7yi75Hrr_1A9lAN0(UriGrantsManagerInternal r0, int r1, int r2, Uri r3) {
        lambda$checkRemoteViewsUris$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$I-Iq10hkqbcd4Fr2u9ba2JuV2Pg, reason: not valid java name */
    public static /* synthetic */ void m1847$r8$lambda$IIq10hkqbcd4Fr2u9ba2JuV2Pg(AppWidgetServiceImpl r0, Provider r1, int r2, RemoteViews r3) {
        r0.lambda$setGeneratedPreviewsAsync$5(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$MdNZjnBdEEF_twtpYATH__6l_hM(AppWidgetServiceImpl r0, Message r1) {
        return r0.handleSaveMessage(r1);
    }

    public static /* synthetic */ int $r8$lambda$VG4rQn1uMRhUnabYrpMAgqu1yR8(AppWidgetServiceImpl r0, int r1, List r2) {
        return r0.onPullAtom(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$d3gmRXMJXq_h37kUdyUE7oYkhw0(AppWidgetServiceImpl r0, Provider r1, int r2, AndroidFuture r3) {
        r0.lambda$getGeneratedPreviewsAsync$4(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$lkTQH5TBU8nFgBdMgfZM1JX4vaY(AppWidgetServiceImpl r0, DeviceConfig.Properties r1) {
        r0.handleSystemUiDeviceConfigChange(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$mOvg524MDhCAG2Z4MKIp-ujqMc8, reason: not valid java name */
    public static /* synthetic */ void m1848$r8$lambda$mOvg524MDhCAG2Z4MKIpujqMc8(AppWidgetServiceImpl r0, Provider r1) {
        r0.lambda$clearGeneratedPreviewsAsync$7(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$o2LnvkPu-GVDI_IFwcpi7YYgUdI, reason: not valid java name */
    public static /* synthetic */ void m1849$r8$lambda$o2LnvkPuGVDI_IFwcpi7YYgUdI(AppWidgetServiceImpl r0, Intent r1, AppWidgetProviderInfo r2, Provider r3, boolean r4) {
        r0.lambda$registerForBroadcastsLocked$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$vw1D7IsMc5WRnkGVq0WacqAxbjo(Provider r0, Widget r1) {
        lambda$handleUserUnlocked$3(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManager m1850$$Nest$fgetmAppOpsManager(AppWidgetServiceImpl r0) {
        return r0.mAppOpsManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m1851$$Nest$fgetmContext(AppWidgetServiceImpl r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDevicePolicyManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ DevicePolicyManagerInternal m1852$$Nest$fgetmDevicePolicyManagerInternal(AppWidgetServiceImpl r0) {
        return r0.mDevicePolicyManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHosts, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m1853$$Nest$fgetmHosts(AppWidgetServiceImpl r0) {
        return r0.mHosts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1854$$Nest$fgetmLock(AppWidgetServiceImpl r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ IPackageManager m1855$$Nest$fgetmPackageManager(AppWidgetServiceImpl r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackagesWithBindWidgetPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m1856$$Nest$fgetmPackagesWithBindWidgetPermission(AppWidgetServiceImpl r0) {
        return r0.mPackagesWithBindWidgetPermission;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProviders, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m1857$$Nest$fgetmProviders(AppWidgetServiceImpl r0) {
        return r0.mProviders;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSecurityPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ SecurityPolicy m1858$$Nest$fgetmSecurityPolicy(AppWidgetServiceImpl r0) {
        return r0.mSecurityPolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m1859$$Nest$fgetmUserManager(AppWidgetServiceImpl r0) {
        return r0.mUserManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWidgets, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m1860$$Nest$fgetmWidgets(AppWidgetServiceImpl r0) {
        return r0.mWidgets;
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyResourceOverlaysToWidgetsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1861$$Nest$mapplyResourceOverlaysToWidgetsLocked(AppWidgetServiceImpl r0, Set r1, int r2, boolean r3) {
        r0.applyResourceOverlaysToWidgetsLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mdecrementAppWidgetServiceRefCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1862$$Nest$mdecrementAppWidgetServiceRefCount(AppWidgetServiceImpl r0, Widget r1) {
        r0.decrementAppWidgetServiceRefCount(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mensureGroupStateLoadedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1863$$Nest$mensureGroupStateLoadedLocked(AppWidgetServiceImpl r0, int r1) {
        r0.ensureGroupStateLoadedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mensureGroupStateLoadedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1864$$Nest$mensureGroupStateLoadedLocked(AppWidgetServiceImpl r0, int r1, boolean r2) {
        r0.ensureGroupStateLoadedLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUidForPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1865$$Nest$mgetUidForPackage(AppWidgetServiceImpl r0, String r1, int r2) {
        return r0.getUidForPackage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNotifyAppWidgetRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1866$$Nest$mhandleNotifyAppWidgetRemoved(AppWidgetServiceImpl r0, Host r1, IAppWidgetHost r2, int r3, long r4) {
        r0.handleNotifyAppWidgetRemoved(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNotifyAppWidgetViewDataChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1867$$Nest$mhandleNotifyAppWidgetViewDataChanged(AppWidgetServiceImpl r0, Host r1, IAppWidgetHost r2, int r3, int r4, long r5) {
        r0.handleNotifyAppWidgetViewDataChanged(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNotifyProviderChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1868$$Nest$mhandleNotifyProviderChanged(AppWidgetServiceImpl r0, Host r1, IAppWidgetHost r2, int r3, AppWidgetProviderInfo r4, long r5) {
        r0.handleNotifyProviderChanged(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNotifyProvidersChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1869$$Nest$mhandleNotifyProvidersChanged(AppWidgetServiceImpl r0, Host r1, IAppWidgetHost r2) {
        r0.handleNotifyProvidersChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNotifyUpdateAppWidget, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1870$$Nest$mhandleNotifyUpdateAppWidget(AppWidgetServiceImpl r0, Host r1, IAppWidgetHost r2, int r3, RemoteViews r4, long r5) {
        r0.handleNotifyUpdateAppWidget(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleNotifyUpdateAppWidgetDeferred, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1871$$Nest$mhandleNotifyUpdateAppWidgetDeferred(AppWidgetServiceImpl r0, Host r1, IAppWidgetHost r2, int r3, long r4) {
        r0.handleNotifyUpdateAppWidgetDeferred(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mincrementAndGetAppWidgetIdLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1872$$Nest$mincrementAndGetAppWidgetIdLocked(AppWidgetServiceImpl r0, int r1) {
        return r0.incrementAndGetAppWidgetIdLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mlookupOrAddHostLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ Host m1873$$Nest$mlookupOrAddHostLocked(AppWidgetServiceImpl r0, HostId r1) {
        return r0.lookupOrAddHostLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageBroadcastReceived, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1874$$Nest$monPackageBroadcastReceived(AppWidgetServiceImpl r0, Intent r1, int r2) {
        r0.onPackageBroadcastReceived(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreloadWidgetsMaskedState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1875$$Nest$mreloadWidgetsMaskedState(AppWidgetServiceImpl r0, int r1) {
        r0.reloadWidgetsMaskedState(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msaveGroupStateAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1876$$Nest$msaveGroupStateAsync(AppWidgetServiceImpl r0, int r1) {
        r0.saveGroupStateAsync(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msaveStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1877$$Nest$msaveStateLocked(AppWidgetServiceImpl r0, int r1) {
        r0.saveStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendBroadcastAsUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1878$$Nest$msendBroadcastAsUser(AppWidgetServiceImpl r0, Intent r1, UserHandle r2, boolean r3) {
        r0.sendBroadcastAsUser(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateWidgetPackageStoppedMaskedState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1879$$Nest$mupdateWidgetPackageStoppedMaskedState(AppWidgetServiceImpl r0, Intent r1) {
        r0.updateWidgetPackageStoppedMaskedState(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateWidgetPackageSuspensionMaskedState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1880$$Nest$mupdateWidgetPackageSuspensionMaskedState(AppWidgetServiceImpl r0, Intent r1, boolean r2, int r3) {
        r0.updateWidgetPackageSuspensionMaskedState(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1881$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$smcloneIfLocalBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteViews m1882$$Nest$smcloneIfLocalBinder(RemoteViews r0) {
        return cloneIfLocalBinder(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smparseAppWidgetProviderInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppWidgetProviderInfo m1883$$Nest$smparseAppWidgetProviderInfo(Context r0, ProviderId r1, ActivityInfo r2, String r3) {
        return parseAppWidgetProviderInfo(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$smparseWidgetIdOptions, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m1884$$Nest$smparseWidgetIdOptions(TypedXmlPullParser r0) {
        return parseWidgetIdOptions(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smserializeAppWidget, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1885$$Nest$smserializeAppWidget(TypedXmlSerializer r0, Widget r1, boolean r2) {
        serializeAppWidget(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smserializeHost, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1886$$Nest$smserializeHost(TypedXmlSerializer r0, Host r1) {
        serializeHost(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smserializeProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1887$$Nest$smserializeProvider(TypedXmlSerializer r0, Provider r1, boolean r2) {
        serializeProvider(r0, r1, r2);
    }

    static {
        DEBUG = Build.IS_DEBUGGABLE;
        if (DEBUG == false) goto L5;
        int r0 = 0;
    L6:
        MIN_UPDATE_PERIOD = r0;
        UPDATE_COUNTER = new AtomicLong();
        DEFAULT_GENERATED_PREVIEW_RESET_INTERVAL_MS = Duration.ofHours(1).toMillis();
        return;
    L5:
        r0 = 1800000;
        goto L6
    }

    AppWidgetServiceImpl(Context context) {
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mRemoteViewsServicesAppWidgets = new HashMap();
        this.mLock = new Object();
        this.mWidgets = new ArrayList();
        this.mHosts = new ArrayList();
        this.mProviders = new ArrayList();
        this.mPackagesWithBindWidgetPermission = new ArraySet();
        this.mLoadedUserIds = new SparseBooleanArray();
        this.mWidgetPackagesLock = new Object();
        this.mWidgetPackages = new SparseArray();
        this.mNextAppWidgetIds = new SparseIntArray();
        this.mContext = context;
    }

    public void onStart() {
        this.mPackageManager = AppGlobals.getPackageManager();
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        this.mUserManager = (UserManager) this.mContext.getSystemService("user");
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
        this.mDevicePolicyManagerInternal = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mSaveStateHandler = new Handler(BackgroundThread.get().getLooper(), new AppWidgetServiceImpl$$ExternalSyntheticLambda2(this));
        this.mAlarmHandler = new Handler(BackgroundThread.get().getLooper());
        this.mSavePreviewsHandler = new Handler(BackgroundThread.get().getLooper());
        ServiceThread serviceThread = new ServiceThread(TAG, -2, false);
        serviceThread.start();
        this.mCallbackHandler = new CallbackHandler(this, serviceThread.getLooper());
        this.mBackupRestoreController = new BackupRestoreController(this);
        AppWidgetServiceImplIA r2 = null;
        this.mSecurityPolicy = new SecurityPolicy(this, r2);
        this.mIsCombinedBroadcastEnabled = DeviceConfig.getBoolean("systemui", "combined_broadcast_enabled", true);
        long generatedPreviewResetInterval = DeviceConfig.getLong("systemui", "generated_preview_api_reset_interval_ms", DEFAULT_GENERATED_PREVIEW_RESET_INTERVAL_MS);
        int generatedPreviewMaxCallsPerInterval = DeviceConfig.getInt("systemui", "generated_preview_api_max_calls_per_interval", 2);
        DeviceConfig.getInt("systemui", "generated_preview_api_max_providers", 50);
        this.mGeneratedPreviewsApiCounter = new ApiCounter(generatedPreviewResetInterval, generatedPreviewMaxCallsPerInterval, Integer.MAX_VALUE);
        DeviceConfig.addOnPropertiesChangedListener("systemui", new HandlerExecutor(this.mCallbackHandler), new AppWidgetServiceImpl$$ExternalSyntheticLambda3(this));
        BroadcastOptions opts = BroadcastOptions.makeBasic();
        opts.setBackgroundActivityStartsAllowed(false);
        opts.setInteractive(true);
        this.mInteractiveBroadcast = opts.toBundle();
        computeMaximumWidgetBitmapMemory();
        registerBroadcastReceiver();
        registerOnCrossProfileProvidersChangedListener();
        LocalServices.addService(AppWidgetManagerInternal.class, new AppWidgetManagerLocal(this, r2));
    }

    public int getMaxBitmapMemory() {
        return this.mMaxWidgetBitmapMemory;
    }

    void systemServicesReady() {
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mAppOpsManagerInternal = (AppOpsManagerInternal) LocalServices.getService(AppOpsManagerInternal.class);
        this.mUsageStatsManagerInternal = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        registerPullCallbacks();
    }

    private void registerPullCallbacks() {
        StatsManager manager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        manager.setPullAtomCallback(FrameworkStatsLog.WIDGET_MEMORY_STATS, new StatsManager.PullAtomMetadata.Builder().build(), new HandlerExecutor(this.mCallbackHandler), new AppWidgetServiceImpl$$ExternalSyntheticLambda8(this));
    }

    private int onPullAtom(int atomTag, List<StatsEvent> data) {
        if (atomTag != 10234) goto L20;
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<Widget> r2 = this.mWidgets.iterator();     // Catch: Throwable -> L12
    L8:
        if (r2.hasNext() == false) goto L15;
        Widget widget = r2.next();     // Catch: Throwable -> L12
        if (widget.views == null) goto L8;
        int uid = widget.provider.id.uid;     // Catch: Throwable -> L12
        int appWidgetId = widget.appWidgetId;     // Catch: Throwable -> L12
        long bitmapMemoryUsage = widget.views.estimateTotalBitmapMemoryUsage();     // Catch: Throwable -> L12
        StatsEvent event = FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.WIDGET_MEMORY_STATS, uid, appWidgetId, bitmapMemoryUsage);     // Catch: Throwable -> L12
        data.add(event);     // Catch: Throwable -> L12
        goto L8
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return 0;
    L12:
        th = move-exception;
        throw th;
    L20:
        return 1;
    }

    private void computeMaximumWidgetBitmapMemory() {
        Display display = this.mContext.getDisplayNoVerify();
        Point size = new Point();
        display.getRealSize(size);
        this.mMaxWidgetBitmapMemory = (size.x * 6) * size.y;
    }

    private boolean handleSaveMessage(Message msg) {
        int userId = msg.what;
        Object r1 = this.mLock;
        monitor-enter(r1);
        Trace.traceBegin(64, "convert_state_to_bytes");     // Catch: Throwable -> L20
        ensureGroupStateLoadedLocked(userId, false);     // Catch: Throwable -> L20
        SparseArray<byte[]> userIdToBytesMapping = saveStateToByteArrayLocked(userId);     // Catch: Throwable -> L20
        Trace.traceEnd(64);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        Trace.traceBegin(64, "byte_to_disk_io");
        int i = 0;
    L8:
        if (i >= userIdToBytesMapping.size()) goto L18;
        int currentProfileId = userIdToBytesMapping.keyAt(i);
        byte[] currentStateByteArray = userIdToBytesMapping.valueAt(i);
        AtomicFile currentFile = getSavedStateFile(currentProfileId);
        FileOutputStream fileStream = currentFile.startWrite();     // Catch: IOException -> L15
        fileStream.write(currentStateByteArray);     // Catch: IOException -> L13
        currentFile.finishWrite(fileStream);     // Catch: IOException -> L13
    L17:
        i = i + 1;
    L13:
        e = move-exception;
        Log.e(TAG, "Failed to write state byte stream to file", e);
        currentFile.failWrite(fileStream);
    L15:
        e = move-exception;
        Log.e(TAG, "Failed to start writing stream", e);
        goto L17
    L18:
        Trace.traceEnd(64);
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    private void registerBroadcastReceiver() {
        IntentFilter packageFilter = new IntentFilter();
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        packageFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        packageFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        packageFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        packageFilter.addAction("android.intent.action.PACKAGE_UNSTOPPED");
        packageFilter.addDataScheme(Settings.ATTR_PACKAGE);
        packageFilter.setPriority(1000);
        this.mContext.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, packageFilter, null, this.mCallbackHandler);
        IntentFilter sdFilter = new IntentFilter();
        sdFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
        sdFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
        this.mContext.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, sdFilter, null, this.mCallbackHandler);
        IntentFilter offModeFilter = new IntentFilter();
        offModeFilter.addAction("android.intent.action.MANAGED_PROFILE_AVAILABLE");
        offModeFilter.addAction("android.intent.action.MANAGED_PROFILE_UNAVAILABLE");
        this.mContext.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, offModeFilter, null, this.mCallbackHandler);
        IntentFilter suspendPackageFilter = new IntentFilter();
        suspendPackageFilter.addAction("android.intent.action.PACKAGES_SUSPENDED");
        suspendPackageFilter.addAction("android.intent.action.PACKAGES_UNSUSPENDED");
        this.mContext.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, suspendPackageFilter, null, this.mCallbackHandler);
    }

    private void registerOnCrossProfileProvidersChangedListener() {
        if (this.mDevicePolicyManagerInternal == null) goto L6;
        this.mDevicePolicyManagerInternal.addOnCrossProfileWidgetProvidersChangeListener(this);
        return;
    }

    public void setSafeMode(boolean safeMode) {
        this.mSafeMode = safeMode;
    }

    private void onPackageBroadcastReceived(Intent intent, int userId) {
        String action = intent.getAction();
        boolean added = false;
        boolean componentsModified = false;
        boolean packageRemovedPermanently = true;
        int r10 = 0;
        switch(action.hashCode()) {
            case -1403934493: goto L18;
            case -1338021860: goto L15;
            case -1001645458: goto L12;
            case 267468725: goto L9;
            case 1290767157: goto L6;
            default: goto L20;
        };
    L20:
        byte r8 = -1;
    L21:
        switch(r8) {
            case 0: goto L32;
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L31;
            case 4: goto L29;
            default: goto L22;
        };
    L22:
        Uri uri = intent.getData();
        if (uri != null) goto L25;
        return;
    L25:
        String pkgName = uri.getSchemeSpecificPart();
        if (pkgName != null) goto L28;
        return;
    L28:
        String[] pkgList = {pkgName};
        boolean added2 = "android.intent.action.PACKAGE_ADDED".equals(action);
        boolean changed = "android.intent.action.PACKAGE_CHANGED".equals(action);
        int clearedUid = -1;
        boolean changed2 = changed;
        boolean changed3 = added2;
    L33:
        if (pkgList != null) goto L35;
    L36:
        if (clearedUid != (-1)) goto L38;
        return;
    L38:
        Object r12 = this.mLock;
        monitor-enter(r12);
    L81:
        th = th;
    L118:
        monitor-exit(r12);     // Catch: Throwable -> L81
        throw th;
    L85:
        th = th;
        goto L118
    L41:
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == false) goto L116;
        if (isProfileWithLockedParent(userId) == true) goto L116;
        ensureGroupStateLoadedLocked(userId, false);     // Catch: Throwable -> L85
        Bundle extras = intent.getExtras();     // Catch: Throwable -> L85
        if (changed3 == true) goto L93;
        if (changed2 == true) goto L93;
        if (clearedUid == (-1)) goto L53;
        componentsModified = false | clearPreviewsForUidLocked(clearedUid);     // Catch: Throwable -> L51
    L111:
        if (componentsModified == false) goto L113;
        saveGroupStateAsync(userId);     // Catch: Throwable -> L81
        scheduleNotifyGroupHostsForProvidersChangedLocked(userId);     // Catch: Throwable -> L81
        this.mBackupRestoreController.widgetComponentsChanged(userId);     // Catch: Throwable -> L81
    L113:
        monitor-exit(r12);     // Catch: Throwable -> L81
        return;
    L53:
        if (extras != null) goto L55;
    L57:
        boolean isReplacing = false;
    L59:
        if (extras != null) goto L61;
    L63:
        boolean isArchival = false;
    L65:
        if (extras == null) goto L71;
        if (isReplacing == false) goto L71;
        if (isReplacing == false) goto L70;
        if (isArchival == true) goto L71;
    L70:
        packageRemovedPermanently = false;
    L71:
        if (packageRemovedPermanently == false) goto L111;
        int r15 = pkgList.length;     // Catch: Throwable -> L85
    L73:
        if (r10 >= r15) goto L111;
        String pkgName2 = pkgList[r10];     // Catch: Throwable -> L85
        if (DEBUG == false) goto L88;
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L83
        r4.append("calling removeHostsAndProvidersForPackageLocked() because package removed permanently. extras=");     // Catch: Throwable -> L81
        r4.append(extras);     // Catch: Throwable -> L81
        r4.append(" isReplacing=");     // Catch: Throwable -> L81
        r4.append(isReplacing);     // Catch: Throwable -> L81
        r4.append(" isArchival=");     // Catch: Throwable -> L81
        r4.append(isArchival);     // Catch: Throwable -> L81
        Slog.i(TAG, r4.toString());     // Catch: Throwable -> L81
    L83:
        th = th;
    L88:
        componentsModified = componentsModified | removeHostsAndProvidersForPackageLocked(pkgName2, userId);     // Catch: Throwable -> L81
        r10 = r10 + 1;     // Catch: Throwable -> L81
        action = action;
        changed3 = changed3;
        goto L73
    L61:
        if (extras.getBoolean("android.intent.extra.ARCHIVAL", false) == false) goto L63;
        isArchival = true;
        goto L65
    L55:
        if (extras.getBoolean("android.intent.extra.REPLACING", false) == false) goto L57;
        isReplacing = true;
    L51:
        th = th;
    L93:
        if (changed3 == false) goto L98;
        if (extras == null) goto L99;
        if (extras.getBoolean("android.intent.extra.REPLACING", false) == true) goto L98;
    L99:
        int r2 = pkgList.length;     // Catch: Throwable -> L81
    L100:
        if (r10 >= r2) goto L111;
        String pkgName3 = pkgList[r10];     // Catch: Throwable -> L81
        componentsModified = componentsModified | updateProvidersForPackageLocked(pkgName3, userId, null);     // Catch: Throwable -> L81
        UserHandle mainUser = this.mUserManager.getMainUser();     // Catch: Throwable -> L81
        if (packageRemovedPermanently == false) goto L109;
        if (mainUser == null) goto L109;
        if (userId != mainUser.getIdentifier()) goto L109;
        int uid = getUidForPackage(pkgName3, userId);     // Catch: Throwable -> L81
        if (uid < 0) goto L109;
        resolveHostUidLocked(pkgName3, uid);     // Catch: Throwable -> L81
    L109:
        r10 = r10 + 1;     // Catch: Throwable -> L81
    L98:
        packageRemovedPermanently = false;
    L116:
        monitor-exit(r12);     // Catch: Throwable -> L81
        return;
    L35:
        if (pkgList.length != 0) goto L38;
    L29:
        pkgList = null;
        int clearedUid2 = intent.getIntExtra("android.intent.extra.UID", -1);
        clearedUid = clearedUid2;
        changed2 = false;
        changed3 = false;
        goto L33
    L30:
        added = true;
    L31:
        pkgList = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
        clearedUid = -1;
        changed2 = false;
        changed3 = added;
        goto L33
    L32:
        pkgList = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
        clearedUid = -1;
        changed2 = true;
        changed3 = false;
        goto L33
    L6:
        if (action.equals("android.intent.action.PACKAGES_UNSUSPENDED") == false) goto L134;
        r8 = 1;
        goto L21
    L134:
        r8 = -1;
        goto L21
    L9:
        if (action.equals("android.intent.action.PACKAGE_DATA_CLEARED") == false) goto L135;
        r8 = 4;
        goto L21
    L135:
        r8 = -1;
        goto L21
    L12:
        if (action.equals("android.intent.action.PACKAGES_SUSPENDED") == false) goto L136;
        r8 = 0;
        goto L21
    L136:
        r8 = -1;
        goto L21
    L15:
        if (action.equals("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE") == false) goto L137;
        r8 = 2;
        goto L21
    L137:
        r8 = -1;
        goto L21
    L18:
        if (action.equals("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE") == false) goto L138;
        r8 = 3;
        goto L21
    L138:
        r8 = -1;
        goto L21
    }

    private boolean clearPreviewsForUidLocked(int clearedUid) {
        boolean changed = false;
        int providerCount = this.mProviders.size();
        int i = 0;
    L3:
        if (i >= providerCount) goto L11;
        Provider provider = this.mProviders.get(i);
        if (provider.id.uid != clearedUid) goto L9;
        changed = changed | clearGeneratedPreviewsAsync(provider);
        if (DEBUG == false) goto L9;
        Slog.e(TAG, "clearPreviewsForUidLocked " + provider + " changed " + changed);
    L9:
        i = i + 1;
        goto L3
    L11:
        return changed;
    }

    void reloadWidgetsMaskedStateForGroup(int userId) {
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        reloadWidgetsMaskedState(userId);     // Catch: Throwable -> L11
        int[] profileIds = this.mUserManager.getEnabledProfileIds(userId);     // Catch: Throwable -> L11
        int r2 = profileIds.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L13;
        int profileId = profileIds[r3];     // Catch: Throwable -> L11
        reloadWidgetsMaskedState(profileId);     // Catch: Throwable -> L11
        r3 = r3 + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void reloadWidgetsMaskedState(int userId) {
        long identity = Binder.clearCallingIdentity();
        UserInfo user = this.mUserManager.getUserInfo(userId);     // Catch: Throwable -> L16
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L6;
        boolean lockedProfile = true;
    L7:
        boolean quietProfile = user.isQuietModeEnabled();     // Catch: Throwable -> L16
        int N = this.mProviders.size();     // Catch: Throwable -> L16
        int i = 0;
    L8:
        if (i >= N) goto L32;
        Provider provider = this.mProviders.get(i);     // Catch: Throwable -> L16
        int providerUserId = provider.getUserId();     // Catch: Throwable -> L16
        if (providerUserId == userId) goto L13;
    L31:
        i = i + 1;
        goto L8
    L13:
        boolean changed = provider.setMaskedByLockedProfileLocked(lockedProfile) | provider.setMaskedByQuietProfileLocked(quietProfile);
        boolean suspended = this.mPackageManager.isPackageSuspendedForUser(provider.id.componentName.getPackageName(), provider.getUserId());     // Catch: Throwable -> L16 RemoteException -> L18 IllegalArgumentException -> L20
        this.mPackageManager.isPackageStoppedForUser(provider.id.componentName.getPackageName(), provider.getUserId());     // Catch: Throwable -> L16 RemoteException -> L18 IllegalArgumentException -> L20
        boolean stopped = false;
    L23:
        changed = (changed | provider.setMaskedBySuspendedPackageLocked(suspended)) | provider.setMaskedByStoppedPackageLocked(stopped);
    L26:
        if (changed == false) goto L31;
        if (provider.isMaskedLocked() == false) goto L30;
        maskWidgetsViewsLocked(provider, null);     // Catch: Throwable -> L16
        goto L31
    L30:
        unmaskWidgetsViewsLocked(provider);     // Catch: Throwable -> L16
        goto L31
    L18:
        e = move-exception;
        Slog.e(TAG, "Failed to query application info", e);     // Catch: Throwable -> L16
    L21:
        suspended = false;
        stopped = false;
        goto L23
    L32:
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        lockedProfile = false;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void updateWidgetPackageSuspensionMaskedState(Intent intent, boolean suspended, int profileId) {
        String[] packagesArray = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
        if (packagesArray != null) goto L5;
        return;
    L5:
        Set<String> packages = new ArraySet(Arrays.asList(packagesArray));
        Object r2 = this.mLock;
        monitor-enter(r2);
        int N = this.mProviders.size();     // Catch: Throwable -> L19
        int i = 0;
    L8:
        if (i >= N) goto L24;
        Provider provider = this.mProviders.get(i);     // Catch: Throwable -> L19
        int providerUserId = provider.getUserId();     // Catch: Throwable -> L19
        if (providerUserId != profileId) goto L22;
        if (packages.contains(provider.id.componentName.getPackageName()) == false) goto L22;
        if (provider.setMaskedBySuspendedPackageLocked(suspended) == false) goto L22;
        if (provider.isMaskedLocked() == false) goto L21;
        maskWidgetsViewsLocked(provider, null);     // Catch: Throwable -> L19
        goto L22
    L21:
        unmaskWidgetsViewsLocked(provider);     // Catch: Throwable -> L19
    L22:
        i = i + 1;     // Catch: Throwable -> L19
        goto L8
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private void updateWidgetPackageStoppedMaskedState(Intent intent) {
        int providerUid = intent.getIntExtra("android.intent.extra.UID", -1);
        Uri uri = intent.getData();
        if (providerUid == (-1)) goto L56;
        if (uri == null) goto L70;
        String packageName = uri.getSchemeSpecificPart();
        if (packageName != null) goto L57;
        return;
    L57:
        boolean isStopped = this.mPackageManager.isPackageStoppedForUser(packageName, UserHandle.getUserId(providerUid));     // Catch: Exception -> L53
        if (DEBUG == false) goto L13;
        Slog.i(TAG, "Updating package stopped masked state for uid " + providerUid + " package " + packageName + " isStopped " + isStopped);
    L13:
        Object r4 = this.mLock;
        monitor-enter(r4);
        int count = this.mProviders.size();     // Catch: Throwable -> L27
        int i = 0;
    L16:
        if (i >= count) goto L49;
        Provider provider = this.mProviders.get(i);     // Catch: Throwable -> L27
        if (providerUid != provider.id.uid) goto L47;
        if (packageName.equals(provider.id.componentName.getPackageName()) == false) goto L47;
        if (provider.setMaskedByStoppedPackageLocked(isStopped) == false) goto L47;
        if (provider.isMaskedLocked() == false) goto L29;
        maskWidgetsViewsLocked(provider, null);     // Catch: Throwable -> L27
        cancelBroadcastsLocked(provider);     // Catch: Throwable -> L27
        goto L47
    L29:
        unmaskWidgetsViewsLocked(provider);     // Catch: Throwable -> L27
        int widgetCount = provider.widgets.size();     // Catch: Throwable -> L27
        if (widgetCount <= 0) goto L35;
        int[] widgetIds = new int[widgetCount];     // Catch: Throwable -> L27
        int j = 0;
    L32:
        if (j >= widgetCount) goto L34;
        widgetIds[j] = provider.widgets.get(j).appWidgetId;     // Catch: Throwable -> L27
        j = j + 1;     // Catch: Throwable -> L27
        goto L32
    L34:
        registerForBroadcastsLocked(provider, widgetIds);     // Catch: Throwable -> L27
        sendUpdateIntentLocked(provider, widgetIds, false);     // Catch: Throwable -> L27
    L35:
        int pendingIdsCount = provider.pendingDeletedWidgetIds.size();     // Catch: Throwable -> L27
        if (pendingIdsCount <= 0) goto L47;
        if (DEBUG == false) goto L40;
        Slog.i(TAG, "Sending missed deleted broadcasts for " + provider.id.componentName + " " + provider.pendingDeletedWidgetIds);     // Catch: Throwable -> L27
    L40:
        int j2 = 0;
    L41:
        if (j2 >= pendingIdsCount) goto L43;
        sendDeletedIntentLocked(provider.id.componentName, provider.id.getProfile(), provider.pendingDeletedWidgetIds.get(j2));     // Catch: Throwable -> L27
        j2 = j2 + 1;     // Catch: Throwable -> L27
        goto L41
    L43:
        provider.pendingDeletedWidgetIds.clear();     // Catch: Throwable -> L27
        if (widgetCount != 0) goto L46;
        sendDisabledIntentLocked(provider);     // Catch: Throwable -> L27
    L46:
        saveGroupStateAsync(provider.id.getProfile().getIdentifier());     // Catch: Throwable -> L27
    L47:
        i = i + 1;     // Catch: Throwable -> L27
        goto L16
    L49:
        monitor-exit(r4);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        throw th;
    L53:
        e = move-exception;
        Slog.e(TAG, "Failed to query package stopped state", e);
        return;
    L70:
        return;
    }

    private void maskWidgetsViewsLocked(Provider provider, Widget targetWidget) {
        Provider r2 = provider;
        int widgetCount = r2.widgets.size();
        if (widgetCount != 0) goto L5;
        return;
    L5:
        RemoteViews views = new RemoteViews(this.mContext.getPackageName(), 17367540);
        ActivityInfo activityInfo = r2.info.providerInfo;
        if (activityInfo == null) goto L8;
        ApplicationInfo appInfo = activityInfo.applicationInfo;
    L9:
        if (appInfo == null) goto L11;
        String r8 = appInfo.packageName;
    L12:
        String packageName = r8;
        int appUserId = r2.getUserId();
        boolean showBadge = false;
        long identity = Binder.clearCallingIdentity();
    L71:
        th = th;
    L83:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L85:
        if (r2.maskedByQuietProfile == false) goto L21;
        showBadge = true;
        Intent onClickIntent = UnlaunchableAppActivity.createInQuietModeDialogIntent(appUserId);     // Catch: Throwable -> L18
        Intent onClickIntent2 = onClickIntent;
    L41:
        if (appInfo != null) goto L43;
    L46:
        Icon icon = Icon.createWithResource(this.mContext, R.drawable.sym_def_app_icon);     // Catch: Throwable -> L71
    L47:
        views.setImageViewIcon(16910021, icon);     // Catch: Throwable -> L71
        if (showBadge == false) goto L50;
    L51:
        int j = 0;
    L52:
        if (j >= widgetCount) goto L81;
        Widget widget = r2.widgets.get(j);     // Catch: Throwable -> L71
        if (targetWidget == 0) goto L57;
        if (targetWidget == widget) goto L57;
        icon = icon;
        int widgetCount2 = widgetCount;
    L80:
        j = j + 1;
        r2 = provider;
        icon = icon;
        widgetCount = widgetCount2;
    L57:
        Host host = widget.host;     // Catch: Throwable -> L71
        if (host == null) goto L63;
        if (host.id == null) goto L63;
        UserHandle hostUser = UserHandle.getUserHandleForUid(host.id.uid);     // Catch: Throwable -> L18
    L65:
        if (r2.maskedByStoppedPackage == false) goto L73;
        Intent intent = createUpdateIntentLocked(r2, new int[]{widget.appWidgetId});     // Catch: Throwable -> L71
        widgetCount2 = widgetCount;
        views.setOnClickPendingIntent(R.id.background, PendingIntent.getBroadcastAsUser(this.mContext, widget.appWidgetId, intent, AudioFormat.DTS_HD, hostUser));     // Catch: Throwable -> L69
    L78:
        if (Widget.m1893$$Nest$mreplaceWithMaskedViewsLocked(widget, views) == false) goto L80;
        scheduleNotifyUpdateAppWidgetLocked(widget, widget.getEffectiveViewsLocked());     // Catch: Throwable -> L69
    L69:
        th = th;
        goto L83
    L73:
        widgetCount2 = widgetCount;
        if (onClickIntent2 == null) goto L78;
        views.setOnClickPendingIntent(R.id.background, PendingIntent.getActivityAsUser(this.mContext, widget.appWidgetId, onClickIntent2, AudioFormat.DTS_HD, null, hostUser));     // Catch: Throwable -> L69
    L63:
        Slog.w(TAG, "Host is null when masking widget: " + widget.appWidgetId);     // Catch: Throwable -> L71
        hostUser = this.mUserManager.getProfileParent(appUserId).getUserHandle();     // Catch: Throwable -> L71
        goto L65
    L81:
        Binder.restoreCallingIdentity(identity);
        return;
    L50:
        views.setViewVisibility(16910022, 4);     // Catch: Throwable -> L18
        goto L51
    L43:
        if (appInfo.icon == 0) goto L46;
        icon = Icon.createWithResource(appInfo.packageName, appInfo.icon);     // Catch: Throwable -> L18
        goto L47
    L21:
        if (r2.maskedBySuspendedPackage == false) goto L31;
        showBadge = this.mUserManager.hasBadge(appUserId);     // Catch: Throwable -> L18
        UserPackage suspendingPackage = this.mPackageManagerInternal.getSuspendingPackage(packageName, appUserId);     // Catch: Throwable -> L18
        if (suspendingPackage != null) goto L25;
    L27:
        SuspendDialogInfo dialogInfo = this.mPackageManagerInternal.getSuspendedDialogInfo(packageName, suspendingPackage, appUserId);     // Catch: Throwable -> L18
        Intent onClickIntent3 = SuspendedAppActivity.createSuspendedAppInterceptIntent(packageName, suspendingPackage, dialogInfo, null, null, appUserId);     // Catch: Throwable -> L18
    L29:
        onClickIntent2 = onClickIntent3;
        goto L41
    L25:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(suspendingPackage.packageName) == false) goto L27;
        onClickIntent3 = this.mDevicePolicyManagerInternal.createShowAdminSupportIntent(appUserId, true);     // Catch: Throwable -> L18
        goto L29
    L31:
        if (r2.maskedByLockedProfile == false) goto L38;
        showBadge = true;
        Intent onClickIntent4 = this.mKeyguardManager.createConfirmDeviceCredentialIntent(null, null, appUserId);     // Catch: Throwable -> L18
        if (onClickIntent4 == null) goto L36;
        onClickIntent4.setFlags(276824064);     // Catch: Throwable -> L18
    L36:
        onClickIntent2 = onClickIntent4;
        goto L41
    L38:
        if (r2.maskedByStoppedPackage == false) goto L40;
        showBadge = this.mUserManager.hasBadge(appUserId);     // Catch: Throwable -> L18
        onClickIntent2 = null;
        goto L41
    L40:
        onClickIntent2 = null;
    L18:
        th = th;
        goto L83
    L11:
        r8 = r2.id.componentName.getPackageName();
        goto L12
    L8:
        appInfo = null;
        goto L9
    }

    private void unmaskWidgetsViewsLocked(Provider provider) {
        int widgetCount = provider.widgets.size();
        int j = 0;
    L3:
        if (j >= widgetCount) goto L9;
        Widget widget = provider.widgets.get(j);
        if (Widget.m1892$$Nest$mclearMaskedViewsLocked(widget) == false) goto L7;
        scheduleNotifyUpdateAppWidgetLocked(widget, widget.getEffectiveViewsLocked());
    L7:
        j = j + 1;
        goto L3
    }

    private void resolveHostUidLocked(String pkg, int uid) {
        int N = this.mHosts.size();
        int i = 0;
    L3:
        if (i >= N) goto L15;
        Host host = this.mHosts.get(i);
        if (host.id.uid != (-1)) goto L13;
        if (pkg.equals(host.id.packageName) == false) goto L13;
        if (DEBUG == false) goto L11;
        Slog.i(TAG, "host " + host.id + " resolved to uid " + uid);
    L11:
        host.id = new HostId(uid, host.id.hostId, host.id.packageName);
        return;
    L13:
        i = i + 1;
        goto L3
    }

    private void ensureGroupStateLoadedLocked(int userId) {
        ensureGroupStateLoadedLocked(userId, true);
    }

    private void ensureGroupStateLoadedLocked(int userId, boolean enforceUserUnlockingOrUnlocked) {
        if (enforceUserUnlockingOrUnlocked == true) goto L4;
    L8:
        if (enforceUserUnlockingOrUnlocked == true) goto L10;
    L14:
        int[] profileIds = this.mSecurityPolicy.getEnabledGroupProfileIds(userId);
        IntArray newIds = new IntArray(1);
        int r3 = profileIds.length;
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L21;
        int profileId = profileIds[r4];
        if (this.mLoadedUserIds.get(profileId) == true) goto L19;
        this.mLoadedUserIds.put(profileId, true);
        newIds.add(profileId);
    L19:
        r4 = r4 + 1;
        goto L15
    L21:
        if (newIds.size() > 0) goto L23;
        return;
    L23:
        int[] newProfileIds = newIds.toArray();
        clearProvidersAndHostsTagsLocked();
        loadGroupWidgetProvidersLocked(newProfileIds);
        loadGroupStateLocked(newProfileIds);
        return;
    L10:
        if (isProfileWithLockedParent(userId) == false) goto L14;
        throw new IllegalStateException("Profile " + userId + " must have unlocked parent");
    L4:
        if (isUserRunningAndUnlocked(userId) == true) goto L8;
        throw new IllegalStateException("User " + userId + " must be unlocked for widgets to be available");
    }

    private boolean isUserRunningAndUnlocked(int userId) {
        return this.mUserManager.isUserUnlockingOrUnlocked(userId);
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (args.length > 0) goto L10;
    L14:
        dumpInternalLocked(pw);     // Catch: Throwable -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L10:
        if ("--proto".equals(args[0]) == false) goto L14;
        dumpProto(fd);     // Catch: Throwable -> L12
        goto L15
    }

    private void dumpProto(FileDescriptor fd) {
        Slog.i(TAG, "dump proto for " + this.mWidgets.size() + " widgets");
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        int N = this.mWidgets.size();
        int i = 0;
    L3:
        if (i >= N) goto L5;
        dumpProtoWidget(proto, this.mWidgets.get(i));
        i = i + 1;
        goto L3
    L5:
        proto.flush();
    }

    private void dumpProtoWidget(ProtoOutputStream proto, Widget widget) {
        if (widget.host != null) goto L5;
    L23:
        Slog.d(TAG, "skip dumping widget because host or provider is null: widget.host=" + widget.host + " widget.provider=" + widget.provider);
        return;
    L5:
        if (widget.provider == null) goto L23;
        long token = proto.start(2246267895809L);
        boolean r4 = true;
        if (widget.host.getUserId() == widget.provider.getUserId()) goto L10;
        boolean r2 = true;
    L11:
        proto.write(1133871366145L, r2);
        if (widget.host.callbacks == null) goto L15;
        r4 = false;
    L15:
        proto.write(1133871366146L, r4);
        proto.write(1138166333443L, widget.host.id.packageName);
        proto.write(1138166333444L, widget.provider.id.componentName.getPackageName());
        proto.write(1138166333445L, widget.provider.id.componentName.getClassName());
        if (widget.options == null) goto L19;
        proto.write(1133871366154L, widget.options.getBoolean("appWidgetRestoreCompleted"));
        proto.write(1120986464262L, widget.options.getInt("appWidgetMinWidth", 0));
        proto.write(1120986464263L, widget.options.getInt("appWidgetMinHeight", 0));
        proto.write(1120986464264L, widget.options.getInt("appWidgetMaxWidth", 0));
        proto.write(1120986464265L, widget.options.getInt("appWidgetMaxHeight", 0));
    L19:
        if (widget.views == null) goto L21;
        proto.write(1120986464267L, widget.views.estimateTotalBitmapMemoryUsage());
    L21:
        proto.end(token);
        return;
    L10:
        r2 = false;
        goto L11
    }

    private void dumpInternalLocked(PrintWriter pw) {
        int N = this.mProviders.size();
        pw.println("Providers:");
        int i = 0;
    L3:
        if (i >= N) goto L5;
        dumpProviderLocked(this.mProviders.get(i), i, pw);
        i = i + 1;
        goto L3
    L5:
        int N2 = this.mWidgets.size();
        pw.println(" ");
        pw.println("Widgets:");
        int i2 = 0;
    L6:
        if (i2 >= N2) goto L8;
        dumpWidget(this.mWidgets.get(i2), i2, pw);
        i2 = i2 + 1;
        goto L6
    L8:
        int N3 = this.mHosts.size();
        pw.println(" ");
        pw.println("Hosts:");
        int i3 = 0;
    L9:
        if (i3 >= N3) goto L11;
        dumpHost(this.mHosts.get(i3), i3, pw);
        i3 = i3 + 1;
        goto L9
    L11:
        int N4 = this.mPackagesWithBindWidgetPermission.size();
        pw.println(" ");
        pw.println("Grants:");
        int i4 = 0;
    L12:
        if (i4 >= N4) goto L15;
        Pair<Integer, String> grant = this.mPackagesWithBindWidgetPermission.valueAt(i4);
        dumpGrant(grant, i4, pw);
        i4 = i4 + 1;
        goto L12
    }

    public ParceledListSlice<PendingHostUpdate> startListening(IAppWidgetHost callbacks, String callingPackage, int hostId, int[] appWidgetIds) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "startListening() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r5 = this.mLock;
        monitor-enter(r5);
    L12:
        th = th;
    L31:
        monitor-exit(r5);     // Catch: Throwable -> L23
        throw th;
    L8:
        if (this.mSecurityPolicy.isInstantAppLocked(callingPackage, userId) == false) goto L14;
        Slog.w(TAG, "Instant package " + callingPackage + " cannot host app widgets");     // Catch: Throwable -> L12
        ParceledListSlice<PendingHostUpdate> r0 = ParceledListSlice.emptyList();     // Catch: Throwable -> L12
        monitor-exit(r5);     // Catch: Throwable -> L12
        return r0;
    L14:
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L12
        HostId id = new HostId(Binder.getCallingUid(), hostId, callingPackage);     // Catch: Throwable -> L29
        Host host = lookupOrAddHostLocked(id);     // Catch: Throwable -> L29
        host.callbacks = callbacks;     // Catch: Throwable -> L23
        long updateSequenceNo = UPDATE_COUNTER.incrementAndGet();     // Catch: Throwable -> L23
        int N = appWidgetIds.length;     // Catch: Throwable -> L23
        ArrayList<PendingHostUpdate> outUpdates = new ArrayList(N);     // Catch: Throwable -> L23
        LongSparseArray<PendingHostUpdate> updatesMap = new LongSparseArray();     // Catch: Throwable -> L23
        int i = 0;
    L19:
        if (i >= N) goto L26;
        updatesMap.clear();     // Catch: Throwable -> L23
        HostId id2 = id;
        host.getPendingUpdatesForIdLocked(this.mContext, appWidgetIds[i], updatesMap);     // Catch: Throwable -> L23
        int m = updatesMap.size();     // Catch: Throwable -> L23
        int j = 0;
    L21:
        if (j >= m) goto L25;
        outUpdates.add(updatesMap.valueAt(j));     // Catch: Throwable -> L23
        j = j + 1;     // Catch: Throwable -> L23
        m = m;
        goto L21
    L25:
        i = i + 1;     // Catch: Throwable -> L23
        id = id2;
        goto L19
    L26:
        host.lastWidgetUpdateSequenceNo = updateSequenceNo;     // Catch: Throwable -> L23
        ParceledListSlice<PendingHostUpdate> r1 = new ParceledListSlice(outUpdates);     // Catch: Throwable -> L23
        monitor-exit(r5);     // Catch: Throwable -> L23
        return r1;
    L29:
        th = th;
    L23:
        th = th;
        goto L31
    }

    public void stopListening(String callingPackage, int hostId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "stopListening() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId, false);     // Catch: Throwable -> L11
        HostId id = new HostId(Binder.getCallingUid(), hostId, callingPackage);     // Catch: Throwable -> L11
        Host host = lookupHostLocked(id);     // Catch: Throwable -> L11
        if (host == null) goto L13;
        host.callbacks = null;     // Catch: Throwable -> L11
        pruneHostLocked(host);     // Catch: Throwable -> L11
        this.mAppOpsManagerInternal.updateAppWidgetVisibility(host.getWidgetUidsIfBound(), false);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public int allocateAppWidgetId(String callingPackage, int hostId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "allocateAppWidgetId() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.mSecurityPolicy.isInstantAppLocked(callingPackage, userId) == false) goto L15;
        Slog.w(TAG, "Instant package " + callingPackage + " cannot host app widgets");     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return 0;
    L15:
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L13
        if (this.mNextAppWidgetIds.indexOfKey(userId) >= 0) goto L18;
        this.mNextAppWidgetIds.put(userId, 1);     // Catch: Throwable -> L13
    L18:
        int appWidgetId = incrementAndGetAppWidgetIdLocked(userId);     // Catch: Throwable -> L13
        HostId id = new HostId(Binder.getCallingUid(), hostId, callingPackage);     // Catch: Throwable -> L13
        Host host = lookupOrAddHostLocked(id);     // Catch: Throwable -> L13
        Widget widget = new Widget(null);     // Catch: Throwable -> L13
        widget.appWidgetId = appWidgetId;     // Catch: Throwable -> L13
        widget.host = host;     // Catch: Throwable -> L13
        host.widgets.add(widget);     // Catch: Throwable -> L13
        addWidgetLocked(widget);     // Catch: Throwable -> L13
        saveGroupStateAsync(userId);     // Catch: Throwable -> L13
        if (DEBUG == false) goto L21;
        Slog.i(TAG, "Allocated widget id " + appWidgetId + " for host " + host.id);     // Catch: Throwable -> L13
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return appWidgetId;
    }

    public void setAppWidgetHidden(String callingPackage, int hostId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "setAppWidgetHidden() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId, false);     // Catch: Throwable -> L11
        HostId id = new HostId(Binder.getCallingUid(), hostId, callingPackage);     // Catch: Throwable -> L11
        Host host = lookupHostLocked(id);     // Catch: Throwable -> L11
        if (host == null) goto L13;
        this.mAppOpsManagerInternal.updateAppWidgetVisibility(host.getWidgetUidsIfBound(), false);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void deleteAppWidgetId(String callingPackage, int appWidgetId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "deleteAppWidgetId() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L11
        Widget widget = lookupWidgetLocked(appWidgetId, Binder.getCallingUid(), callingPackage);     // Catch: Throwable -> L11
        if (widget != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L13:
        deleteAppWidgetLocked(widget);     // Catch: Throwable -> L11
        saveGroupStateAsync(userId);     // Catch: Throwable -> L11
        if (DEBUG == false) goto L16;
        Slog.i(TAG, "Deleted widget id " + appWidgetId + " for host " + widget.host.id);     // Catch: Throwable -> L11
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean hasBindAppWidgetPermission(String packageName, int userId) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "hasBindAppWidgetPermission() " + UserHandle.getCallingUserId());
    L5:
        this.mSecurityPolicy.enforceModifyAppWidgetBindPermissions(packageName);
        Object r0 = this.mLock;
        monitor-enter(r0);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L12
        int packageUid = getUidForPackage(packageName, userId);     // Catch: Throwable -> L12
        if (packageUid >= 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L14:
        Pair<Integer, String> packageId = Pair.create(Integer.valueOf(userId), packageName);     // Catch: Throwable -> L12
        boolean r3 = this.mPackagesWithBindWidgetPermission.contains(packageId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    public void setBindAppWidgetPermission(String packageName, int userId, boolean grantPermission) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "setBindAppWidgetPermission() " + UserHandle.getCallingUserId());
    L5:
        this.mSecurityPolicy.enforceModifyAppWidgetBindPermissions(packageName);
        Object r0 = this.mLock;
        monitor-enter(r0);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L11
        int packageUid = getUidForPackage(packageName, userId);     // Catch: Throwable -> L11
        if (packageUid >= 0) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        Pair<Integer, String> packageId = Pair.create(Integer.valueOf(userId), packageName);     // Catch: Throwable -> L11
        if (grantPermission == false) goto L16;
        this.mPackagesWithBindWidgetPermission.add(packageId);     // Catch: Throwable -> L11
    L17:
        saveGroupStateAsync(userId);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L16:
        this.mPackagesWithBindWidgetPermission.remove(packageId);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public IntentSender createAppWidgetConfigIntentSender(String callingPackage, int appWidgetId, int intentFlags) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "createAppWidgetConfigIntentSender() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r5 = this.mLock;
        monitor-enter(r5);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L26
        Widget widget = lookupWidgetLocked(appWidgetId, Binder.getCallingUid(), callingPackage);     // Catch: Throwable -> L26
        if (widget == null) goto L29;
        Provider provider = widget.provider;     // Catch: Throwable -> L26
        if (provider == null) goto L25;
        int secureFlags = intentFlags & (-196);
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_CONFIGURE");     // Catch: Throwable -> L19
        intent.putExtra("appWidgetId", appWidgetId);     // Catch: Throwable -> L19
        intent.setComponent(provider.getInfoLocked(this.mContext).configure);     // Catch: Throwable -> L19
        intent.setFlags(secureFlags);     // Catch: Throwable -> L19
        ActivityOptions options = ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(2);     // Catch: Throwable -> L19
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L19
        IntentSender r0 = PendingIntent.getActivityAsUser(this.mContext, 0, intent, 1409286144, options.toBundle(), new UserHandle(provider.getUserId())).getIntentSender();     // Catch: Throwable -> L21
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L19
        monitor-exit(r5);     // Catch: Throwable -> L19
        return r0;
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L25:
        throw new IllegalArgumentException("Widget not bound " + appWidgetId);     // Catch: Throwable -> L19
    L29:
        throw new IllegalArgumentException("Bad widget id " + appWidgetId);     // Catch: Throwable -> L19
    L19:
        th = th;
    L30:
        monitor-exit(r5);     // Catch: Throwable -> L19
        throw th;
    L26:
        th = th;
        goto L30
    }

    public boolean bindAppWidgetId(String callingPackage, int appWidgetId, int providerProfileId, ComponentName providerComponent, Bundle options) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "bindAppWidgetId() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        if (this.mSecurityPolicy.isEnabledGroupProfile(providerProfileId) == true) goto L9;
        return false;
    L9:
        if (this.mSecurityPolicy.canAccessProvider(providerComponent.getPackageName(), providerProfileId) == true) goto L11;
        return false;
    L11:
        Object r8 = this.mLock;
        monitor-enter(r8);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L17
        if (this.mSecurityPolicy.hasCallerBindPermissionOrBindWhiteListedLocked(callingPackage) == true) goto L19;
        monitor-exit(r8);     // Catch: Throwable -> L17
        return false;
    L19:
        Widget widget = lookupWidgetLocked(appWidgetId, Binder.getCallingUid(), callingPackage);     // Catch: Throwable -> L17
        if (widget != null) goto L25;
        Slog.e(TAG, "Bad widget id " + appWidgetId);     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        return false;
    L25:
        if (widget.provider == null) goto L29;
        Slog.e(TAG, "Widget id " + appWidgetId + " already bound to: " + widget.provider.id);     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        return false;
    L29:
        int providerUid = getUidForPackage(providerComponent.getPackageName(), providerProfileId);     // Catch: Throwable -> L17
        if (providerUid >= 0) goto L34;
        Slog.e(TAG, "Package " + providerComponent.getPackageName() + " not installed  for profile " + providerProfileId);     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        return false;
    L34:
        ProviderId providerId = new ProviderId(providerUid, providerComponent);     // Catch: Throwable -> L17
        Provider provider = lookupProviderLocked(providerId);     // Catch: Throwable -> L17
        if (provider != null) goto L40;
        Slog.e(TAG, "No widget provider " + providerComponent + " for profile " + providerProfileId);     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        return false;
    L40:
        if (provider.zombie == false) goto L44;
        Slog.e(TAG, "Can't bind to a 3rd party provider in safe mode " + provider);     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        return false;
    L44:
        widget.provider = provider;     // Catch: Throwable -> L17
        if (options == null) goto L47;
        Bundle r7 = cloneIfLocalBinder(options);     // Catch: Throwable -> L17
    L48:
        widget.options = r7;     // Catch: Throwable -> L17
        if (widget.options.containsKey("appWidgetCategory") == true) goto L51;
        widget.options.putInt("appWidgetCategory", 1);     // Catch: Throwable -> L17
    L51:
        provider.widgets.add(widget);     // Catch: Throwable -> L17
        onWidgetProviderAddedOrChangedLocked(widget);     // Catch: Throwable -> L17
        int widgetCount = provider.widgets.size();     // Catch: Throwable -> L17
        if (widgetCount != 1) goto L54;
        sendEnableAndUpdateIntentLocked(provider, new int[]{appWidgetId});     // Catch: Throwable -> L17
    L55:
        registerForBroadcastsLocked(provider, getWidgetIds(provider.widgets));     // Catch: Throwable -> L17
        saveGroupStateAsync(userId);     // Catch: Throwable -> L17
        Slog.i(TAG, "Bound widget " + appWidgetId + " to provider " + provider.id);     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        return true;
    L54:
        sendUpdateIntentLocked(provider, new int[]{appWidgetId}, true);     // Catch: Throwable -> L17
        goto L55
    L47:
        r7 = new Bundle();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public int[] getAppWidgetIds(ComponentName componentName) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "getAppWidgetIds() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(componentName.getPackageName());
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L12
        ProviderId providerId = new ProviderId(Binder.getCallingUid(), componentName);     // Catch: Throwable -> L12
        Provider provider = lookupProviderLocked(providerId);     // Catch: Throwable -> L12
        if (provider == null) goto L14;
        int[] r4 = getWidgetIds(provider.widgets);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r4;
    L14:
        int[] r5 = new int[0];     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r5;
    L12:
        th = move-exception;
        throw th;
    }

    public int[] getAppWidgetIdsForHost(String callingPackage, int hostId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "getAppWidgetIdsForHost() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L12
        HostId id = new HostId(Binder.getCallingUid(), hostId, callingPackage);     // Catch: Throwable -> L12
        Host host = lookupHostLocked(id);     // Catch: Throwable -> L12
        if (host == null) goto L14;
        int[] r4 = getWidgetIds(host.widgets);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r4;
    L14:
        int[] r5 = new int[0];     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r5;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean bindRemoteViewsService(String callingPackage, int appWidgetId, Intent intent, IApplicationThread caller, IBinder activtiyToken, IServiceConnection connection, long flags) {
        throw new UnsupportedOperationException("bindRemoteViewsService is deprecated");
    }

    public void deleteHost(String callingPackage, int hostId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "deleteHost() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L11
        HostId id = new HostId(Binder.getCallingUid(), hostId, callingPackage);     // Catch: Throwable -> L11
        Host host = lookupHostLocked(id);     // Catch: Throwable -> L11
        if (host != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L13:
        deleteHostLocked(host);     // Catch: Throwable -> L11
        saveGroupStateAsync(userId);     // Catch: Throwable -> L11
        if (DEBUG == false) goto L16;
        Slog.i(TAG, "Deleted host " + host.id);     // Catch: Throwable -> L11
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void deleteAllHosts() {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "deleteAllHosts() " + userId);
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L14
        boolean changed = false;
        int N = this.mHosts.size();     // Catch: Throwable -> L14
        int i = N - 1;     // Catch: Throwable -> L14
    L8:
        if (i < 0) goto L18;
        Host host = this.mHosts.get(i);     // Catch: Throwable -> L14
        if (host.id.uid != Binder.getCallingUid()) goto L16;
        deleteHostLocked(host);     // Catch: Throwable -> L14
        changed = true;
        if (DEBUG == false) goto L16;
        Slog.i(TAG, "Deleted host " + host.id);     // Catch: Throwable -> L14
    L16:
        i = i - 1;     // Catch: Throwable -> L14
        goto L8
    L18:
        if (changed == false) goto L20;
        saveGroupStateAsync(userId);     // Catch: Throwable -> L14
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public AppWidgetProviderInfo getAppWidgetInfo(String callingPackage, int appWidgetId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "getAppWidgetInfo() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L18
        Widget widget = lookupWidgetLocked(appWidgetId, Binder.getCallingUid(), callingPackage);     // Catch: Throwable -> L18
        if (widget != null) goto L10;
    L25:
        if (widget != null) goto L28;
        Slog.e(TAG, "getAppWidgetInfo() returns null because widget is null. appWidgetId=" + appWidgetId + " userId=" + userId);     // Catch: Throwable -> L18
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return null;
    L28:
        if (widget.provider != null) goto L30;
        Slog.e(TAG, "getAppWidgetInfo() returns null because widget.provider is null. appWidgetId=" + appWidgetId + " userId=" + userId + " widget=" + widget);     // Catch: Throwable -> L18
        goto L31
    L30:
        Slog.e(TAG, "getAppWidgetInfo() returns null because widget.provider is zombie. appWidgetId=" + appWidgetId + " userId=" + userId + " widget=" + widget);     // Catch: Throwable -> L18
        goto L31
    L10:
        if (widget.provider == null) goto L25;
        if (widget.provider.zombie == true) goto L25;
        AppWidgetProviderInfo info = widget.provider.getInfoLocked(this.mContext);     // Catch: Throwable -> L18
        if (info != null) goto L20;
        Slog.e(TAG, "getAppWidgetInfo() returns null because widget.provider.getInfoLocked() returned null. appWidgetId=" + appWidgetId + " userId=" + userId + " widget=" + widget);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return null;
    L20:
        AppWidgetProviderInfo ret = cloneIfLocalBinder(info);     // Catch: Throwable -> L18
        if (ret != null) goto L23;
        Slog.e(TAG, "getAppWidgetInfo() returns null because cloneIfLocalBinder() returned null. appWidgetId=" + appWidgetId + " userId=" + userId + " widget=" + widget + " appWidgetProviderInfo=" + info);     // Catch: Throwable -> L18
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return ret;
    L18:
        th = move-exception;
        throw th;
    }

    public RemoteViews getAppWidgetViews(String callingPackage, int appWidgetId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "getAppWidgetViews() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L12
        Widget widget = lookupWidgetLocked(appWidgetId, Binder.getCallingUid(), callingPackage);     // Catch: Throwable -> L12
        if (widget == null) goto L14;
        RemoteViews r3 = cloneIfLocalBinder(widget.getEffectiveViewsLocked());     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r3;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public void updateAppWidgetOptions(String callingPackage, int appWidgetId, Bundle options) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "updateAppWidgetOptions() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L11
        Widget widget = lookupWidgetLocked(appWidgetId, Binder.getCallingUid(), callingPackage);     // Catch: Throwable -> L11
        if (widget != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L13:
        widget.options.putAll(options);     // Catch: Throwable -> L11
        sendOptionsChangedIntentLocked(widget);     // Catch: Throwable -> L11
        saveGroupStateAsync(userId);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public Bundle getAppWidgetOptions(String callingPackage, int appWidgetId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "getAppWidgetOptions() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L14
        Widget widget = lookupWidgetLocked(appWidgetId, Binder.getCallingUid(), callingPackage);     // Catch: Throwable -> L14
        if (widget != null) goto L10;
    L16:
        Bundle r3 = Bundle.EMPTY;     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r3;
    L10:
        if (widget.options == null) goto L16;
        Bundle r4 = cloneIfLocalBinder(widget.options);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r4;
    L14:
        th = move-exception;
        throw th;
    }

    public void updateAppWidgetIds(String callingPackage, int[] appWidgetIds, RemoteViews views) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "updateAppWidgetIds() " + UserHandle.getCallingUserId());
    L5:
        updateAppWidgetIds(callingPackage, appWidgetIds, views, false);
    }

    public void partiallyUpdateAppWidgetIds(String callingPackage, int[] appWidgetIds, RemoteViews views) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "partiallyUpdateAppWidgetIds() " + UserHandle.getCallingUserId());
    L5:
        updateAppWidgetIds(callingPackage, appWidgetIds, views, true);
    }

    public void notifyProviderInheritance(ComponentName[] componentNames) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "notifyProviderInheritance() " + userId);
    L5:
        if (componentNames != null) goto L7;
        return;
    L7:
        int r1 = componentNames.length;
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L13;
        ComponentName componentName = componentNames[r3];
        if (componentName == null) goto L11;
        this.mSecurityPolicy.enforceCallFromPackage(componentName.getPackageName());
        r3 = r3 + 1;
        goto L8
    L11:
        return;
    L13:
        Object r4 = this.mLock;
        monitor-enter(r4);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L23
        int r5 = componentNames.length;     // Catch: Throwable -> L23
    L16:
        if (r2 >= r5) goto L27;
        ProviderId providerId = new ProviderId(Binder.getCallingUid(), componentNames[r2]);     // Catch: Throwable -> L23
        Provider provider = lookupProviderLocked(providerId);     // Catch: Throwable -> L23
        if (provider == null) goto L25;
        if (provider.info == null) goto L25;
        provider.info.isExtendedFromAppWidgetProvider = true;     // Catch: Throwable -> L23
        r2 = r2 + 1;     // Catch: Throwable -> L23
    L25:
        monitor-exit(r4);     // Catch: Throwable -> L23
        return;
    L27:
        saveGroupStateAsync(userId);     // Catch: Throwable -> L23
        monitor-exit(r4);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public void notifyAppWidgetViewDataChanged(String callingPackage, int[] appWidgetIds, int viewId) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "notifyAppWidgetViewDataChanged() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        if (appWidgetIds != null) goto L8;
        return;
    L8:
        if (appWidgetIds.length == 0) goto L31;
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L17
        int N = appWidgetIds.length;     // Catch: Throwable -> L17
        int i = 0;
    L13:
        if (i >= N) goto L21;
        int appWidgetId = appWidgetIds[i];     // Catch: Throwable -> L17
        Widget widget = lookupWidgetLocked(appWidgetId, Binder.getCallingUid(), callingPackage);     // Catch: Throwable -> L17
        if (widget == null) goto L19;
        scheduleNotifyAppWidgetViewDataChanged(widget, viewId);     // Catch: Throwable -> L17
    L19:
        i = i + 1;     // Catch: Throwable -> L17
        goto L13
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void updateAppWidgetProvider(ComponentName componentName, RemoteViews views) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "updateAppWidgetProvider() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(componentName.getPackageName());
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L12
        ProviderId providerId = new ProviderId(Binder.getCallingUid(), componentName);     // Catch: Throwable -> L12
        Provider provider = lookupProviderLocked(providerId);     // Catch: Throwable -> L12
        if (provider != null) goto L14;
        Slog.w(TAG, "Provider doesn't exist " + providerId);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L14:
        ArrayList<Widget> instances = provider.widgets;     // Catch: Throwable -> L12
        int N = instances.size();     // Catch: Throwable -> L12
        int i = 0;
    L15:
        if (i >= N) goto L18;
        Widget widget = instances.get(i);     // Catch: Throwable -> L12
        updateAppWidgetInstanceLocked(widget, views, false);     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        goto L15
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void updateAppWidgetProviderInfo(ComponentName componentName, String metadataKey) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "updateAppWidgetProvider() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(componentName.getPackageName());
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L13
        ProviderId providerId = new ProviderId(Binder.getCallingUid(), componentName);     // Catch: Throwable -> L13
        Provider provider = lookupProviderLocked(providerId);     // Catch: Throwable -> L13
        if (provider == null) goto L29;
        if (Objects.equals(provider.infoTag, metadataKey) == false) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L15:
        if (metadataKey != null) goto L17;
        String keyToUse = "android.appwidget.provider";
    L18:
        AppWidgetProviderInfo info = parseAppWidgetProviderInfo(this.mContext, providerId, provider.getPartialInfoLocked().providerInfo, keyToUse);     // Catch: Throwable -> L13
        if (info == null) goto L27;
        provider.setInfoLocked(info);     // Catch: Throwable -> L13
        provider.infoTag = metadataKey;     // Catch: Throwable -> L13
        int N = provider.widgets.size();     // Catch: Throwable -> L13
        int i = 0;
    L21:
        if (i >= N) goto L23;
        Widget widget = provider.widgets.get(i);     // Catch: Throwable -> L13
        scheduleNotifyProviderChangedLocked(widget);     // Catch: Throwable -> L13
        updateAppWidgetInstanceLocked(widget, widget.views, false);     // Catch: Throwable -> L13
        i = i + 1;     // Catch: Throwable -> L13
        goto L21
    L23:
        saveGroupStateAsync(userId);     // Catch: Throwable -> L13
        scheduleNotifyGroupHostsForProvidersChangedLocked(userId);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L27:
        throw new IllegalArgumentException("Unable to parse " + keyToUse + " meta-data to a valid AppWidget provider");     // Catch: Throwable -> L13
    L17:
        keyToUse = metadataKey;
        goto L18
    L29:
        throw new IllegalArgumentException(componentName + " is not a valid AppWidget provider");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public boolean isRequestPinAppWidgetSupported() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSecurityPolicy.isCallerInstantAppLocked() == false) goto L12;
        Slog.w(TAG, "Instant uid " + Binder.getCallingUid() + " query information about app widgets");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return ((ShortcutServiceInternal) LocalServices.getService(ShortcutServiceInternal.class)).isRequestPinItemSupported(UserHandle.getCallingUserId(), 2);
    }

    public boolean requestPinAppWidget(String callingPackage, ComponentName componentName, Bundle extras, IntentSender resultSender) {
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getUserId(callingUid);
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "requestPinAppWidget() " + userId);
    L5:
        Object r2 = this.mLock;
        monitor-enter(r2);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L33
        String pkg = componentName.getPackageName();     // Catch: Throwable -> L33
        if (this.mPackageManagerInternal.isSameApp(pkg, callingUid, userId) == false) goto L41;
        ProviderId id = new ProviderId(callingUid, componentName);     // Catch: Throwable -> L33
    L19:
        Provider provider = lookupProviderLocked(id);     // Catch: Throwable -> L33
        if (provider == null) goto L36;
        if (provider.zombie == true) goto L36;
        AppWidgetProviderInfo info = provider.getInfoLocked(this.mContext);     // Catch: Throwable -> L33
        if ((info.widgetCategory & 1) != 0) goto L30;
        monitor-exit(r2);     // Catch: Throwable -> L14
        return false;
    L30:
        monitor-exit(r2);     // Catch: Throwable -> L33
        return ((ShortcutServiceInternal) LocalServices.getService(ShortcutServiceInternal.class)).requestPinAppWidget(callingPackage, info, extras, resultSender, userId);
    L36:
        monitor-exit(r2);     // Catch: Throwable -> L38
        return false;
    L41:
    L14:
        th = th;
    L39:
        monitor-exit(r2);     // Catch: Throwable -> L38
    L38:
        th = th;
        goto L39
    L40:
        throw th;
    L11:
        if (injectHasAccessWidgetsPermission(Binder.getCallingPid(), callingUid) == true) goto L16;
        monitor-exit(r2);     // Catch: Throwable -> L14
        return false;
    L16:
        id = new ProviderId(this.mPackageManagerInternal.getPackageUid(pkg, 0, userId), componentName);     // Catch: Throwable -> L14
    L33:
        th = th;
        goto L39
    L45:
        th = th;
        goto L39
    }

    private boolean injectHasAccessWidgetsPermission(int callingPid, int callingUid) {
        if (this.mContext.checkPermission("android.permission.CLEAR_APP_USER_DATA", callingPid, callingUid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ParceledListSlice<AppWidgetProviderInfo> getInstalledProvidersForProfile(int categoryFilter, int profileId, String packageName) {
        int userId = UserHandle.getCallingUserId();
        int callingUid = Binder.getCallingUid();
        if (DEBUG == false) goto L6;
        Slog.i(TAG, "getInstalledProvidersForProfiles() " + userId);
    L6:
        if (this.mSecurityPolicy.isEnabledGroupProfile(profileId) == true) goto L9;
        return null;
    L9:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (this.mSecurityPolicy.isCallerInstantAppLocked() == false) goto L18;
        Slog.w(TAG, "Instant uid " + callingUid + " cannot access widget providers");     // Catch: Throwable -> L16
        ParceledListSlice<AppWidgetProviderInfo> r3 = ParceledListSlice.emptyList();     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return r3;
    L18:
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L16
        ArrayList<AppWidgetProviderInfo> result = new ArrayList();     // Catch: Throwable -> L16
        int providerCount = this.mProviders.size();     // Catch: Throwable -> L16
        int i = 0;
    L19:
        if (i >= providerCount) goto L42;
        Provider provider = this.mProviders.get(i);     // Catch: Throwable -> L16
        String providerPackageName = provider.id.componentName.getPackageName();     // Catch: Throwable -> L16
        if (packageName == null) goto L26;
        if (providerPackageName.equals(packageName) == true) goto L26;
        boolean inPackage = false;
    L28:
        if (provider.zombie == true) goto L41;
        if (inPackage == false) goto L41;
        AppWidgetProviderInfo info = provider.getInfoLocked(this.mContext);     // Catch: Throwable -> L16
        if ((info.widgetCategory & categoryFilter) == 0) goto L41;
        int providerProfileId = info.getProfile().getIdentifier();     // Catch: Throwable -> L16
        if (providerProfileId != profileId) goto L41;
        if (this.mSecurityPolicy.canAccessProvider(providerPackageName, providerProfileId) == false) goto L41;
        if (this.mPackageManagerInternal.filterAppAccess(providerPackageName, callingUid, profileId) == true) goto L41;
        result.add(cloneIfLocalBinder(info));     // Catch: Throwable -> L16
    L41:
        i = i + 1;     // Catch: Throwable -> L16
    L26:
        inPackage = true;
        goto L28
    L42:
        ParceledListSlice<AppWidgetProviderInfo> r5 = new ParceledListSlice(result);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return r5;
    }

    private void updateAppWidgetIds(String callingPackage, int[] appWidgetIds, RemoteViews views, boolean partially) {
        int userId = UserHandle.getCallingUserId();
        if (appWidgetIds != null) goto L5;
        return;
    L5:
        if (appWidgetIds.length == 0) goto L28;
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        checkRemoteViewsUris(views);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L14
        int N = appWidgetIds.length;     // Catch: Throwable -> L14
        int i = 0;
    L10:
        if (i >= N) goto L18;
        int appWidgetId = appWidgetIds[i];     // Catch: Throwable -> L14
        Widget widget = lookupWidgetLocked(appWidgetId, Binder.getCallingUid(), callingPackage);     // Catch: Throwable -> L14
        if (widget == null) goto L16;
        updateAppWidgetInstanceLocked(widget, views, partially);     // Catch: Throwable -> L14
    L16:
        i = i + 1;     // Catch: Throwable -> L14
        goto L10
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void checkRemoteViewsUris(RemoteViews views) {
        final UriGrantsManagerInternal uriGrantsManager = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);
        final int callingUid = Binder.getCallingUid();
        final int callingUser = UserHandle.getCallingUserId();
        views.visitUris(new AppWidgetServiceImpl$$ExternalSyntheticLambda4(uriGrantsManager, callingUser, callingUid));
    }

    private static /* synthetic */ void lambda$checkRemoteViewsUris$0(UriGrantsManagerInternal uriGrantsManager, int callingUser, int callingUid, Uri uri) {
        String r0 = uri.getScheme();
        switch(r0.hashCode()) {
            case -368816979: goto L12;
            case 3143036: goto L9;
            case 951530617: goto L6;
            default: goto L14;
        };
    L14:
        byte r1 = -1;
    L15:
        switch(r1) {
            case 0: goto L19;
            case 1: goto L24;
            default: goto L17;
        };
    L19:
        boolean canAccessUri = uriGrantsManager.checkUriPermission(GrantUri.resolve(callingUser, uri, 1), callingUid, 1, true);
        if (canAccessUri == false) goto L23;
        return;
    L23:
        throw new SecurityException("Provider uid " + callingUid + " cannot access URI " + uri);
    L24:
        return;
    L17:
        throw new SecurityException("Disallowed URI " + uri + " in RemoteViews.");
    L6:
        if (r0.equals(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT) == false) goto L14;
        r1 = 0;
        goto L15
    L9:
        if (r0.equals("file") == false) goto L14;
        r1 = 2;
        goto L15
    L12:
        if (r0.equals("android.resource") == false) goto L14;
        r1 = 1;
        goto L15
    }

    private int incrementAndGetAppWidgetIdLocked(int userId) {
        int appWidgetId = peekNextAppWidgetIdLocked(userId) + 1;
        this.mNextAppWidgetIds.put(userId, appWidgetId);
        return appWidgetId;
    }

    private void setMinAppWidgetIdLocked(int userId, int minWidgetId) {
        int nextAppWidgetId = peekNextAppWidgetIdLocked(userId);
        if (nextAppWidgetId >= minWidgetId) goto L6;
        this.mNextAppWidgetIds.put(userId, minWidgetId);
        return;
    }

    private int peekNextAppWidgetIdLocked(int userId) {
        if (this.mNextAppWidgetIds.indexOfKey(userId) >= 0) goto L7;
        return 1;
    L7:
        return this.mNextAppWidgetIds.get(userId);
    }

    private Host lookupOrAddHostLocked(HostId id) {
        Host host = lookupHostLocked(id);
        if (host == null) goto L5;
        return host;
    L5:
        ensureHostCountBeforeAddLocked(id);
        Host host2 = new Host();
        host2.id = id;
        this.mHosts.add(host2);
        return host2;
    }

    private void ensureHostCountBeforeAddLocked(HostId hostId) {
        List<Host> hosts = new ArrayList();
        Iterator<Host> r1 = this.mHosts.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        Host host = r1.next();
        if (host.id.uid != hostId.uid) goto L4;
        if (host.id.packageName.equals(hostId.packageName) == false) goto L4;
        hosts.add(host);
    L12:
        if (hosts.size() < 20) goto L14;
        deleteHostLocked(hosts.remove(0));
        goto L12
    }

    private void deleteHostLocked(Host host) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "deleteHostLocked() " + host);
    L5:
        int N = host.widgets.size();
        int i = N - 1;
    L6:
        if (i < 0) goto L8;
        Widget widget = host.widgets.remove(i);
        deleteAppWidgetLocked(widget);
        i = i - 1;
        goto L6
    L8:
        this.mHosts.remove(host);
        host.callbacks = null;
    }

    private void deleteAppWidgetLocked(Widget widget) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "deleteAppWidgetLocked() " + widget);
    L5:
        decrementAppWidgetServiceRefCount(widget);
        Host host = widget.host;
        host.widgets.remove(widget);
        pruneHostLocked(host);
        removeWidgetLocked(widget);
        Provider provider = widget.provider;
        if (provider == null) goto L19;
        provider.widgets.remove(widget);
        if (provider.zombie == false) goto L10;
        return;
    L10:
        if (provider.maskedByStoppedPackage == true) goto L12;
        sendDeletedIntentLocked(widget);
    L14:
        if (provider.widgets.isEmpty() == false) goto L21;
        cancelBroadcastsLocked(provider);
        if (provider.maskedByStoppedPackage == true) goto L22;
        sendDisabledIntentLocked(provider);
        return;
    L22:
        return;
    L21:
        return;
    L12:
        provider.pendingDeletedWidgetIds.add(widget.appWidgetId);
        goto L14
    }

    private void cancelBroadcastsLocked(Provider provider) {
        if (DEBUG == false) goto L6;
        Slog.i(TAG, "cancelBroadcastsLocked() for " + provider);
    L6:
        if (provider.broadcast == null) goto L9;
        final PendingIntent broadcast = provider.broadcast;
        Runnable cancelRunnable = new AppWidgetServiceImpl$$ExternalSyntheticLambda9(this, broadcast);
        this.mAlarmHandler.post(cancelRunnable);
        provider.broadcast = null;
        return;
    }

    private /* synthetic */ void lambda$cancelBroadcastsLocked$1(PendingIntent broadcast) {
        this.mAlarmManager.cancel(broadcast);
        broadcast.cancel();
    }

    private void destroyRemoteViewsService(final Intent intent, Widget widget) {
        ServiceConnection conn = new AnonymousClass2(this, intent);
        long token = Binder.clearCallingIdentity();
        this.mContext.bindServiceAsUser(intent, conn, 33554433, widget.provider.id.getProfile());     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void incrementAppWidgetServiceRefCount(int appWidgetId, Pair<Integer, Intent.FilterComparison> serviceId) {
        if (this.mRemoteViewsServicesAppWidgets.containsKey(serviceId) == false) goto L5;
        HashSet<Integer> appWidgetIds = this.mRemoteViewsServicesAppWidgets.get(serviceId);
    L6:
        appWidgetIds.add(Integer.valueOf(appWidgetId));
        return;
    L5:
        appWidgetIds = new HashSet();
        this.mRemoteViewsServicesAppWidgets.put(serviceId, appWidgetIds);
        goto L6
    }

    private void decrementAppWidgetServiceRefCount(Widget widget) {
        Iterator<Pair<Integer, Intent.FilterComparison>> it = this.mRemoteViewsServicesAppWidgets.keySet().iterator();
    L4:
        if (it.hasNext() == false) goto L13;
        Pair<Integer, Intent.FilterComparison> key = it.next();
        HashSet<Integer> ids = this.mRemoteViewsServicesAppWidgets.get(key);
        if (ids.remove(Integer.valueOf(widget.appWidgetId)) == false) goto L4;
        if (ids.isEmpty() == false) goto L4;
        if (widget.provider.maskedByStoppedPackage == true) goto L4;
        destroyRemoteViewsService(((Intent.FilterComparison) key.second).getIntent(), widget);
        it.remove();
        goto L4
    }

    private void saveGroupStateAsync(int groupId) {
        this.mSaveStateHandler.removeMessages(groupId);
        this.mSaveStateHandler.sendEmptyMessage(groupId);
    }

    private void updateAppWidgetInstanceLocked(Widget widget, RemoteViews views, boolean isPartialUpdate) {
        if (widget != null) goto L4;
        return;
    L4:
        if (widget.provider != null) goto L6;
        return;
    L6:
        if (widget.provider.zombie == false) goto L8;
        return;
    L8:
        if (widget.host.zombie == true) goto L28;
        if (isPartialUpdate == true) goto L11;
    L13:
        widget.views = views;
    L15:
        if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L17;
    L23:
        scheduleNotifyUpdateAppWidgetLocked(widget, widget.getEffectiveViewsLocked());
        return;
    L17:
        if (widget.views == null) goto L23;
        long memoryUsage = widget.views.estimateMemoryUsage();
        if (memoryUsage <= this.mMaxWidgetBitmapMemory) goto L23;
        widget.views = null;
        throw new IllegalArgumentException("RemoteViews for widget update exceeds maximum bitmap memory usage (used: " + memoryUsage + ", max: " + this.mMaxWidgetBitmapMemory + ")");
    L11:
        if (widget.views == null) goto L13;
        widget.views.mergeRemoteViews(views);
        goto L15
    }

    private void scheduleNotifyAppWidgetViewDataChanged(Widget widget, int viewId) {
        if (viewId != 0) goto L4;
        return;
    L4:
        if (viewId == 1) goto L30;
        long requestId = UPDATE_COUNTER.incrementAndGet();
        if (widget == null) goto L9;
        widget.updateSequenceNos.put(viewId, requestId);
    L9:
        if (widget != null) goto L11;
        return;
    L11:
        if (widget.host != null) goto L13;
        return;
    L13:
        if (widget.host.zombie == false) goto L15;
        return;
    L15:
        if (widget.host.callbacks != null) goto L17;
        return;
    L17:
        if (widget.provider != null) goto L19;
        return;
    L19:
        if (widget.provider.zombie == true) goto L29;
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = widget.host;
        args.arg2 = widget.host.callbacks;
        args.arg3 = Long.valueOf(requestId);
        args.argi1 = widget.appWidgetId;
        args.argi2 = viewId;
        this.mCallbackHandler.obtainMessage(4, args).sendToTarget();
        return;
    L29:
        return;
    }

    private void handleNotifyAppWidgetViewDataChanged(Host host, IAppWidgetHost callbacks, int appWidgetId, int viewId, long requestId) {
        Slog.d(TAG, "Trying to notify widget view data changed");     // Catch: RemoteException -> L4
        callbacks.viewDataChanged(appWidgetId, viewId);     // Catch: RemoteException -> L4
        host.lastWidgetUpdateSequenceNo = requestId;     // Catch: RemoteException -> L4
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (callbacks == null) goto L23;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L23:
        host.callbacks = null;     // Catch: Throwable -> L16
        Set<Pair<Integer, Intent.FilterComparison>> keys = this.mRemoteViewsServicesAppWidgets.keySet();     // Catch: Throwable -> L16
        Iterator<Pair<Integer, Intent.FilterComparison>> r2 = keys.iterator();     // Catch: Throwable -> L16
    L12:
        if (r2.hasNext() == false) goto L19;
        Pair<Integer, Intent.FilterComparison> key = r2.next();     // Catch: Throwable -> L16
        if (this.mRemoteViewsServicesAppWidgets.get(key).contains(Integer.valueOf(appWidgetId)) == false) goto L12;
        ServiceConnection connection = new AnonymousClass3(this);     // Catch: Throwable -> L16
        int userId = UserHandle.getUserId(((Integer) key.first).intValue());     // Catch: Throwable -> L16
        Intent intent = ((Intent.FilterComparison) key.second).getIntent();     // Catch: Throwable -> L16
        bindService(intent, connection, new UserHandle(userId));     // Catch: Throwable -> L16
    L5:
        callbacks = null;
        goto L6
    }

    private void scheduleNotifyUpdateAppWidgetLocked(Widget widget, RemoteViews updateViews) {
        long requestId = UPDATE_COUNTER.incrementAndGet();
        if (widget != null) goto L5;
    L8:
        if (widget != null) goto L10;
        return;
    L10:
        if (widget.provider != null) goto L12;
        return;
    L12:
        if (widget.provider.zombie == false) goto L14;
        return;
    L14:
        if (widget.host.callbacks != null) goto L16;
        return;
    L16:
        if (widget.host.zombie == true) goto L32;
        if (updateViews == null) goto L20;
        updateViews = new RemoteViews(updateViews);
        updateViews.setProviderInstanceId(requestId);
    L20:
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = widget.host;
        args.arg2 = widget.host.callbacks;
        args.arg3 = updateViews;
        args.arg4 = Long.valueOf(requestId);
        args.argi1 = widget.appWidgetId;
        if (updateViews != null) goto L23;
    L26:
        this.mCallbackHandler.obtainMessage(1, args).sendToTarget();
        return;
    L23:
        if (updateViews.isLegacyListRemoteViews() == false) goto L26;
        this.mCallbackHandler.obtainMessage(6, args).sendToTarget();
        return;
    L32:
        return;
    L5:
        if (widget.trackingUpdate == false) goto L7;
        widget.trackingUpdate = false;
        Log.i(TAG, "Widget update received " + widget.toString());
        Trace.asyncTraceEnd(64, "appwidget update-intent " + widget.provider.id.toString(), widget.appWidgetId);
    L7:
        widget.updateSequenceNos.put(0, requestId);
        goto L8
    }

    private void handleNotifyUpdateAppWidgetDeferred(Host host, IAppWidgetHost callbacks, int appWidgetId, long requestId) {
        Slog.d(TAG, "Trying to notify widget update deferred for id: " + appWidgetId);     // Catch: RemoteException -> L4
        callbacks.updateAppWidgetDeferred(appWidgetId);     // Catch: RemoteException -> L4
        host.lastWidgetUpdateSequenceNo = requestId;     // Catch: RemoteException -> L4
        return;
    L4:
        re = move-exception;
        monitor-enter(this.mLock);
        Slog.e(TAG, "Widget host dead: " + host.id, re);     // Catch: Throwable -> L10
        host.callbacks = null;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void handleNotifyUpdateAppWidget(Host host, IAppWidgetHost callbacks, int appWidgetId, RemoteViews views, long requestId) {
        StringBuilder r1 = new StringBuilder();     // Catch: RemoteException -> L5
        r1.append("Trying to notify widget update for package ");     // Catch: RemoteException -> L5
        if (views != null) goto L7;
        String r2 = "null";
    L8:
        r1.append(r2);     // Catch: RemoteException -> L5
        r1.append(" with widget id: ");     // Catch: RemoteException -> L5
        r1.append(appWidgetId);     // Catch: RemoteException -> L5
        Slog.d(TAG, r1.toString());     // Catch: RemoteException -> L5
        callbacks.updateAppWidget(appWidgetId, views);     // Catch: RemoteException -> L5
        host.lastWidgetUpdateSequenceNo = requestId;     // Catch: RemoteException -> L5
        return;
    L7:
        r2 = views.getPackage();     // Catch: RemoteException -> L5
    L5:
        re = move-exception;
        monitor-enter(this.mLock);
        Slog.e(TAG, "Widget host dead: " + host.id, re);     // Catch: Throwable -> L15
        host.callbacks = null;     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void scheduleNotifyProviderChangedLocked(Widget widget) {
        long requestId = UPDATE_COUNTER.incrementAndGet();
        if (widget == null) goto L5;
        widget.updateSequenceNos.clear();
        widget.updateSequenceNos.append(1, requestId);
    L5:
        if (widget != null) goto L7;
        return;
    L7:
        if (widget.provider != null) goto L9;
        return;
    L9:
        if (widget.provider.zombie == false) goto L11;
        return;
    L11:
        if (widget.host.callbacks != null) goto L13;
        return;
    L13:
        if (widget.host.zombie == true) goto L21;
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = widget.host;
        args.arg2 = widget.host.callbacks;
        args.arg3 = widget.provider.getInfoLocked(this.mContext);
        args.arg4 = Long.valueOf(requestId);
        args.argi1 = widget.appWidgetId;
        this.mCallbackHandler.obtainMessage(2, args).sendToTarget();
        return;
    }

    private void handleNotifyProviderChanged(Host host, IAppWidgetHost callbacks, int appWidgetId, AppWidgetProviderInfo info, long requestId) {
        Slog.d(TAG, "Trying to notify provider update");     // Catch: RemoteException -> L4
        callbacks.providerChanged(appWidgetId, info);     // Catch: RemoteException -> L4
        host.lastWidgetUpdateSequenceNo = requestId;     // Catch: RemoteException -> L4
        return;
    L4:
        re = move-exception;
        monitor-enter(this.mLock);
        Slog.e(TAG, "Widget host dead: " + host.id, re);     // Catch: Throwable -> L10
        host.callbacks = null;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void scheduleNotifyAppWidgetRemovedLocked(Widget widget) {
        long requestId = UPDATE_COUNTER.incrementAndGet();
        if (widget != null) goto L5;
    L8:
        if (widget != null) goto L10;
        return;
    L10:
        if (widget.provider != null) goto L12;
        return;
    L12:
        if (widget.provider.zombie == false) goto L14;
        return;
    L14:
        if (widget.host.callbacks != null) goto L16;
        return;
    L16:
        if (widget.host.zombie == true) goto L24;
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = widget.host;
        args.arg2 = widget.host.callbacks;
        args.arg3 = Long.valueOf(requestId);
        args.argi1 = widget.appWidgetId;
        this.mCallbackHandler.obtainMessage(5, args).sendToTarget();
        return;
    L24:
        return;
    L5:
        if (widget.trackingUpdate == false) goto L7;
        widget.trackingUpdate = false;
        Log.i(TAG, "Widget removed " + widget.toString());
        Trace.asyncTraceEnd(64, "appwidget update-intent " + widget.provider.id.toString(), widget.appWidgetId);
    L7:
        widget.updateSequenceNos.clear();
        goto L8
    }

    private void handleNotifyAppWidgetRemoved(Host host, IAppWidgetHost callbacks, int appWidgetId, long requestId) {
        Slog.d(TAG, "Trying to notify widget removed");     // Catch: RemoteException -> L4
        callbacks.appWidgetRemoved(appWidgetId);     // Catch: RemoteException -> L4
        host.lastWidgetUpdateSequenceNo = requestId;     // Catch: RemoteException -> L4
        return;
    L4:
        re = move-exception;
        monitor-enter(this.mLock);
        Slog.e(TAG, "Widget host dead: " + host.id, re);     // Catch: Throwable -> L10
        host.callbacks = null;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void scheduleNotifyGroupHostsForProvidersChangedLocked(int userId) {
        int[] profileIds = this.mSecurityPolicy.getEnabledGroupProfileIds(userId);
        int N = this.mHosts.size();
        int i = N - 1;
    L3:
        if (i < 0) goto L21;
        Host host = this.mHosts.get(i);
        boolean hostInGroup = false;
        int M = profileIds.length;
        int j = 0;
    L5:
        if (j >= M) goto L10;
        int profileId = profileIds[j];
        if (host.getUserId() == profileId) goto L8;
        j = j + 1;
        goto L5
    L8:
        hostInGroup = true;
    L10:
        if (hostInGroup == false) goto L19;
        if (host == null) goto L19;
        if (host.zombie == true) goto L19;
        if (host.callbacks == null) goto L19;
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = host;
        args.arg2 = host.callbacks;
        this.mCallbackHandler.obtainMessage(3, args).sendToTarget();
    L19:
        i = i - 1;
        goto L3
    }

    private void handleNotifyProvidersChanged(Host host, IAppWidgetHost callbacks) {
        Slog.d(TAG, "Trying to notify widget providers changed");     // Catch: RemoteException -> L4
        callbacks.providersChanged();     // Catch: RemoteException -> L4
        return;
    L4:
        re = move-exception;
        monitor-enter(this.mLock);
        Slog.e(TAG, "Widget host dead: " + host.id, re);     // Catch: Throwable -> L10
        host.callbacks = null;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static boolean isLocalBinder() {
        if (Process.myPid() != Binder.getCallingPid()) goto L5;
        return true;
    L5:
        return false;
    }

    private static RemoteViews cloneIfLocalBinder(RemoteViews rv) {
        if (isLocalBinder() == false) goto L7;
        if (rv == null) goto L7;
        return rv.clone();
    L7:
        return rv;
    }

    private static AppWidgetProviderInfo cloneIfLocalBinder(AppWidgetProviderInfo info) {
        if (isLocalBinder() == false) goto L7;
        if (info == null) goto L7;
        return info.clone();
    L7:
        return info;
    }

    private static Bundle cloneIfLocalBinder(Bundle bundle) {
        if (isLocalBinder() == false) goto L7;
        if (bundle == null) goto L7;
        return (Bundle) bundle.clone();
    L7:
        return bundle;
    }

    private Widget lookupWidgetLocked(int appWidgetId, int uid, String packageName) {
        int N = this.mWidgets.size();
        int i = 0;
    L3:
        if (i >= N) goto L11;
        Widget widget = this.mWidgets.get(i);
        if (widget.appWidgetId != appWidgetId) goto L9;
        if (this.mSecurityPolicy.canAccessAppWidget(widget, uid, packageName) == false) goto L9;
        return widget;
    L9:
        i = i + 1;
        goto L3
    L11:
        if (DEBUG == false) goto L19;
        Slog.i(TAG, "cannot find widget for appWidgetId=" + appWidgetId + " uid=" + uid + " packageName=" + packageName);
        return null;
    L19:
        return null;
    }

    private Provider lookupProviderLocked(ProviderId id) {
        int N = this.mProviders.size();
        int i = 0;
    L3:
        if (i >= N) goto L8;
        Provider provider = this.mProviders.get(i);
        if (provider.id.equals(id) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return provider;
    L8:
        return null;
    }

    private Host lookupHostLocked(HostId hostId) {
        int N = this.mHosts.size();
        int i = 0;
    L3:
        if (i >= N) goto L8;
        Host host = this.mHosts.get(i);
        if (host.id.equals(hostId) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return host;
    L8:
        return null;
    }

    private void pruneHostLocked(Host host) {
        if (host.widgets.size() == 0) goto L5;
        return;
    L5:
        if (host.callbacks == null) goto L7;
        return;
    L7:
        if (DEBUG == false) goto L9;
        Slog.i(TAG, "Pruning host " + host.id);
    L9:
        this.mHosts.remove(host);
    }

    private void loadGroupWidgetProvidersLocked(int[] profileIds) {
        List<ResolveInfo> allReceivers = null;
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
        int profileCount = profileIds.length;
        int i = 0;
    L3:
        if (i >= profileCount) goto L13;
        int profileId = profileIds[i];
        List<ResolveInfo> receivers = queryIntentReceivers(intent, profileId);
        if (receivers == null) goto L11;
        if (receivers.isEmpty() == true) goto L11;
        if (allReceivers != null) goto L10;
        allReceivers = new ArrayList();
    L10:
        allReceivers.addAll(receivers);
    L11:
        i = i + 1;
        goto L3
    L13:
        if (allReceivers != null) goto L15;
        int N = 0;
    L16:
        int i2 = 0;
    L17:
        if (i2 >= N) goto L20;
        ResolveInfo receiver = allReceivers.get(i2);
        addProviderLocked(receiver);
        i2 = i2 + 1;
        goto L17
    L20:
        return;
    L15:
        N = allReceivers.size();
        goto L16
    }

    private boolean addProviderLocked(ResolveInfo ri) {
        if ((ri.activityInfo.applicationInfo.flags & 262144) == 0) goto L5;
        return false;
    L5:
        ComponentName componentName = new ComponentName(ri.activityInfo.packageName, ri.activityInfo.name);
        ProviderId providerId = new ProviderId(ri.activityInfo.applicationInfo.uid, componentName);
        Provider existing = lookupProviderLocked(providerId);
        if (existing != null) goto L8;
        ProviderId restoredProviderId = new ProviderId(-1, componentName);
        existing = lookupProviderLocked(restoredProviderId);
    L8:
        AppWidgetProviderInfo info = createPartialProviderInfo(providerId, ri, existing);
        if (info != null) goto L11;
    L13:
        if (info == null) goto L25;
        if (existing != null) goto L16;
        Provider provider = new Provider();
        provider.id = providerId;
        provider.setPartialInfoLocked(info);
        this.mProviders.add(provider);
        return true;
    L16:
        if (existing.zombie == true) goto L18;
        return true;
    L18:
        if (this.mSafeMode == true) goto L27;
        existing.id = providerId;
        existing.zombie = false;
        existing.setPartialInfoLocked(info);
        if (DEBUG == false) goto L28;
        Slog.i(TAG, "Provider placeholder now reified: " + existing);
        return true;
    L28:
        return true;
    L27:
        return true;
    L25:
        return false;
    L11:
        if (this.mUserManager.getUserProperties(info.getProfile()).areItemsRestrictedOnHomeScreen() == false) goto L13;
        return false;
    }

    private void deleteWidgetsLocked(Provider provider, int userId) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "deleteWidgetsLocked() provider=" + provider + " userId=" + userId);
    L5:
        int N = provider.widgets.size();
        int i = N - 1;
    L6:
        if (i < 0) goto L14;
        Widget widget = provider.widgets.get(i);
        if (userId != (-1)) goto L10;
    L11:
        provider.widgets.remove(i);
        updateAppWidgetInstanceLocked(widget, null, false);
        widget.host.widgets.remove(widget);
        removeWidgetLocked(widget);
        widget.provider = null;
        pruneHostLocked(widget.host);
        widget.host = null;
    L12:
        i = i - 1;
        goto L6
    L10:
        if (userId != widget.host.getUserId()) goto L12;
    }

    private void deleteProviderLocked(Provider provider) {
        deleteWidgetsLocked(provider, -1);
        this.mProviders.remove(provider);
        this.mGeneratedPreviewsApiCounter.remove(provider.id);
        clearGeneratedPreviewsAsync(provider);
        cancelBroadcastsLocked(provider);
    }

    private void sendEnableAndUpdateIntentLocked(Provider p, int[] appWidgetIds) {
        if (this.mIsCombinedBroadcastEnabled == true) goto L5;
    L9:
        boolean canSendCombinedBroadcast = false;
    L10:
        if (canSendCombinedBroadcast == true) goto L13;
        sendEnableIntentLocked(p);
        sendUpdateIntentLocked(p, appWidgetIds, true);
        return;
    L13:
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_ENABLE_AND_UPDATE");
        intent.putExtra("appWidgetIds", appWidgetIds);
        intent.setComponent(p.id.componentName);
        sendBroadcastAsUser(intent, p.id.getProfile(), true);
        return;
    L5:
        if (p.info == null) goto L9;
        if (p.info.isExtendedFromAppWidgetProvider == false) goto L9;
        canSendCombinedBroadcast = true;
        goto L10
    }

    private void sendEnableIntentLocked(Provider p) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_ENABLED");
        intent.setComponent(p.id.componentName);
        sendBroadcastAsUser(intent, p.id.getProfile(), true);
    }

    private void sendUpdateIntentLocked(Provider provider, int[] appWidgetIds, boolean interactive) {
        Intent intent = createUpdateIntentLocked(provider, appWidgetIds);
        sendBroadcastAsUser(intent, provider.id.getProfile(), interactive);
    }

    private Intent createUpdateIntentLocked(Provider provider, int[] appWidgetIds) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
        intent.putExtra("appWidgetIds", appWidgetIds);
        intent.setComponent(provider.id.componentName);
        return intent;
    }

    private void sendDeletedIntentLocked(Widget widget) {
        sendDeletedIntentLocked(widget.provider.id.componentName, widget.provider.id.getProfile(), widget.appWidgetId);
    }

    private void sendDeletedIntentLocked(ComponentName provider, UserHandle profile, int appWidgetId) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_DELETED");
        intent.setComponent(provider);
        intent.putExtra("appWidgetId", appWidgetId);
        sendBroadcastAsUser(intent, profile, false);
    }

    private void sendDisabledIntentLocked(Provider provider) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_DISABLED");
        intent.setComponent(provider.id.componentName);
        sendBroadcastAsUser(intent, provider.id.getProfile(), false);
    }

    public void sendOptionsChangedIntentLocked(Widget widget) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS");
        intent.setComponent(widget.provider.id.componentName);
        intent.putExtra("appWidgetId", widget.appWidgetId);
        intent.putExtra("appWidgetOptions", widget.options);
        sendBroadcastAsUser(intent, widget.provider.id.getProfile(), true);
    }

    private void registerForBroadcastsLocked(final Provider provider, int[] appWidgetIds) {
        final AppWidgetProviderInfo info = provider.getInfoLocked(this.mContext);
        if (info.updatePeriodMillis <= 0) goto L11;
        if (provider.broadcast == null) goto L8;
        boolean r0 = true;
    L7:
        final boolean alreadyRegistered = r0;
        final Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
        intent.putExtra("appWidgetIds", appWidgetIds);
        intent.setComponent(info.provider);
        Runnable registerRunnable = new AppWidgetServiceImpl$$ExternalSyntheticLambda5(this, intent, info, provider, alreadyRegistered);
        this.mAlarmHandler.post(registerRunnable);
        return;
    L8:
        r0 = false;
        goto L7
    }

    private /* synthetic */ void lambda$registerForBroadcastsLocked$2(Intent intent, AppWidgetProviderInfo info, Provider provider, boolean alreadyRegistered) {
        long token = Binder.clearCallingIdentity();
        PendingIntent broadcast = PendingIntent.getBroadcastAsUser(this.mContext, 1, intent, AudioFormat.DTS_HD, info.getProfile());     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(token);
        Object r3 = this.mLock;
        monitor-enter(r3);
        provider.broadcast = broadcast;     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        long period = Math.max(info.updatePeriodMillis, MIN_UPDATE_PERIOD);
        if (alreadyRegistered == true) goto L22;
        this.mAlarmManager.setInexactRepeating(2, SystemClock.elapsedRealtime() + period, period, broadcast);
        return;
    L22:
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private static int[] getWidgetIds(ArrayList<Widget> widgets) {
        int instancesSize = widgets.size();
        int[] appWidgetIds = new int[instancesSize];
        int i = 0;
    L3:
        if (i >= instancesSize) goto L6;
        appWidgetIds[i] = widgets.get(i).appWidgetId;
        i = i + 1;
        goto L3
    L6:
        return appWidgetIds;
    }

    private static void dumpProviderLocked(Provider provider, int index, PrintWriter pw) {
        AppWidgetProviderInfo info = provider.getPartialInfoLocked();
        pw.print("  [");
        pw.print(index);
        pw.print("] provider ");
        pw.println(provider.id);
        pw.print("    min=(");
        pw.print(info.minWidth);
        pw.print("x");
        pw.print(info.minHeight);
        pw.print(")   minResize=(");
        pw.print(info.minResizeWidth);
        pw.print("x");
        pw.print(info.minResizeHeight);
        pw.print(") updatePeriodMillis=");
        pw.print(info.updatePeriodMillis);
        pw.print(" resizeMode=");
        pw.print(info.resizeMode);
        pw.print(" widgetCategory=");
        pw.print(info.widgetCategory);
        pw.print(" autoAdvanceViewId=");
        pw.print(info.autoAdvanceViewId);
        pw.print(" initialLayout=#");
        pw.print(Integer.toHexString(info.initialLayout));
        pw.print(" initialKeyguardLayout=#");
        pw.print(Integer.toHexString(info.initialKeyguardLayout));
        pw.print("   zombie=");
        pw.println(provider.zombie);
    }

    private static void dumpHost(Host host, int index, PrintWriter pw) {
        pw.print("  [");
        pw.print(index);
        pw.print("] hostId=");
        pw.println(host.id);
        pw.print("    callbacks=");
        pw.println(host.callbacks);
        pw.print("    widgets.size=");
        pw.print(host.widgets.size());
        pw.print(" zombie=");
        pw.println(host.zombie);
    }

    private static void dumpGrant(Pair<Integer, String> grant, int index, PrintWriter pw) {
        pw.print("  [");
        pw.print(index);
        pw.print(']');
        pw.print(" user=");
        pw.print(grant.first);
        pw.print(" package=");
        pw.println((String) grant.second);
    }

    private static void dumpWidget(Widget widget, int index, PrintWriter pw) {
        pw.print("  [");
        pw.print(index);
        pw.print("] id=");
        pw.println(widget.appWidgetId);
        pw.print("    host=");
        pw.println(widget.host.id);
        if (widget.provider == null) goto L6;
        pw.print("    provider=");
        pw.println(widget.provider.id);
    L6:
        if (widget.host == null) goto L9;
        pw.print("    host.callbacks=");
        pw.println(widget.host.callbacks);
    L9:
        if (widget.views == null) goto L12;
        pw.print("    views=");
        pw.println(widget.views);
        pw.print("    views_bitmap_memory=");
        pw.println(widget.views.estimateTotalBitmapMemoryUsage());
        return;
    }

    private static void serializeProvider(TypedXmlSerializer out, Provider p, boolean persistsProviderInfo) throws IOException {
        out.getClass();
        p.getClass();
        out.startTag(null, "p");
        out.attribute(null, SceneUtils.KEY_PKG, p.id.componentName.getPackageName());
        out.attribute(null, "cl", p.id.componentName.getClassName());
        out.attributeIntHex(null, "tag", p.tag);
        if (TextUtils.isEmpty(p.infoTag) == true) goto L5;
        out.attribute(null, "info_tag", p.infoTag);
    L5:
        if (persistsProviderInfo == true) goto L7;
    L9:
        int pendingIdsCount = p.pendingDeletedWidgetIds.size();
        if (pendingIdsCount <= 0) goto L15;
        List<String> idStrings = new ArrayList();
        int i = 0;
    L12:
        if (i >= pendingIdsCount) goto L14;
        idStrings.add(String.valueOf(p.pendingDeletedWidgetIds.get(i)));
        i = i + 1;
        goto L12
    L14:
        out.attribute(null, PENDING_DELETED_IDS_ATTR, String.join(",", idStrings));
    L15:
        out.endTag(null, "p");
        return;
    L7:
        if (p.mInfoParsed == false) goto L9;
        AppWidgetXmlUtil.writeAppWidgetProviderInfoLocked(out, p.info);
        goto L9
    }

    private static void serializeHost(TypedXmlSerializer out, Host host) throws IOException {
        out.startTag(null, "h");
        out.attribute(null, SceneUtils.KEY_PKG, host.id.packageName);
        out.attributeIntHex(null, "id", host.id.hostId);
        out.attributeIntHex(null, "tag", host.tag);
        out.endTag(null, "h");
    }

    private static void serializeAppWidget(TypedXmlSerializer out, Widget widget, boolean saveRestoreCompleted) throws IOException {
        out.startTag(null, "g");
        out.attributeIntHex(null, "id", widget.appWidgetId);
        out.attributeIntHex(null, "rid", widget.restoredId);
        out.attributeIntHex(null, "h", widget.host.tag);
        if (widget.provider == null) goto L6;
        out.attributeIntHex(null, "p", widget.provider.tag);
    L6:
        if (widget.options == null) goto L27;
        int minWidth = widget.options.getInt("appWidgetMinWidth");
        int minHeight = widget.options.getInt("appWidgetMinHeight");
        int maxWidth = widget.options.getInt("appWidgetMaxWidth");
        int maxHeight = widget.options.getInt("appWidgetMaxHeight");
        int r6 = 0;
        if (minWidth <= 0) goto L10;
        int r7 = minWidth;
    L11:
        out.attributeIntHex(null, "min_width", r7);
        if (minHeight <= 0) goto L14;
        int r8 = minHeight;
    L15:
        out.attributeIntHex(null, "min_height", r8);
        if (maxWidth <= 0) goto L18;
        int r9 = maxWidth;
    L19:
        out.attributeIntHex(null, "max_width", r9);
        if (maxHeight <= 0) goto L22;
        r6 = maxHeight;
    L22:
        out.attributeIntHex(null, "max_height", r6);
        out.attributeIntHex(null, "host_category", widget.options.getInt("appWidgetCategory"));
        List<SizeF> sizes = widget.options.getParcelableArrayList("appWidgetSizes", SizeF.class);
        if (sizes == null) goto L25;
        out.attribute(null, KEY_SIZES, AppWidgetXmlUtil.serializeWidgetSizes(sizes));
    L25:
        if (saveRestoreCompleted == false) goto L27;
        boolean restoreCompleted = widget.options.getBoolean("appWidgetRestoreCompleted");
        out.attributeBoolean(null, "restore_completed", restoreCompleted);
        goto L27
    L18:
        r9 = 0;
        goto L19
    L14:
        r8 = 0;
        goto L15
    L10:
        r7 = 0;
    L27:
        out.endTag(null, "g");
    }

    private static Bundle parseWidgetIdOptions(TypedXmlPullParser parser) {
        Bundle options = new Bundle();
        boolean restoreCompleted = parser.getAttributeBoolean(null, "restore_completed", false);
        if (restoreCompleted == false) goto L5;
        options.putBoolean("appWidgetRestoreCompleted", true);
    L5:
        int minWidth = parser.getAttributeIntHex(null, "min_width", -1);
        if (minWidth == (-1)) goto L8;
        options.putInt("appWidgetMinWidth", minWidth);
    L8:
        int minHeight = parser.getAttributeIntHex(null, "min_height", -1);
        if (minHeight == (-1)) goto L11;
        options.putInt("appWidgetMinHeight", minHeight);
    L11:
        int maxWidth = parser.getAttributeIntHex(null, "max_width", -1);
        if (maxWidth == (-1)) goto L14;
        options.putInt("appWidgetMaxWidth", maxWidth);
    L14:
        int maxHeight = parser.getAttributeIntHex(null, "max_height", -1);
        if (maxHeight == (-1)) goto L17;
        options.putInt("appWidgetMaxHeight", maxHeight);
    L17:
        String sizesStr = parser.getAttributeValue(null, KEY_SIZES);
        ArrayList<SizeF> sizes = AppWidgetXmlUtil.deserializeWidgetSizesStr(sizesStr);
        if (sizes == null) goto L20;
        options.putParcelableArrayList("appWidgetSizes", sizes);
    L20:
        int category = parser.getAttributeIntHex(null, "host_category", -1);
        if (category == (-1)) goto L23;
        options.putInt("appWidgetCategory", category);
    L23:
        return options;
    }

    public List<String> getWidgetParticipants(int userId) {
        return this.mBackupRestoreController.getWidgetParticipants(userId);
    }

    public byte[] getWidgetState(String packageName, int userId) {
        return this.mBackupRestoreController.getWidgetState(packageName, userId);
    }

    public void systemRestoreStarting(int userId) {
        this.mBackupRestoreController.systemRestoreStarting(userId);
    }

    public void restoreWidgetState(String packageName, byte[] restoredState, int userId) {
        this.mBackupRestoreController.restoreWidgetState(packageName, restoredState, userId);
    }

    public void systemRestoreFinished(int userId) {
        this.mBackupRestoreController.systemRestoreFinished(userId);
    }

    private AppWidgetProviderInfo createPartialProviderInfo(ProviderId providerId, ResolveInfo ri, Provider provider) {
        boolean hasXmlDefinition = false;
        Bundle metaData = ri.activityInfo.metaData;
        if (metaData != null) goto L5;
        return null;
    L5:
        boolean r3 = false;
        if (provider == null) goto L15;
        if (TextUtils.isEmpty(provider.infoTag) == true) goto L15;
        if (metaData.getInt(provider.infoTag) == 0) goto L12;
        boolean r5 = true;
    L13:
        hasXmlDefinition = r5;
        goto L15
    L12:
        r5 = false;
    L15:
        if (metaData.getInt("android.appwidget.provider") == 0) goto L18;
        r3 = true;
    L18:
        if ((hasXmlDefinition | r3) == false) goto L23;
        AppWidgetProviderInfo info = new AppWidgetProviderInfo();
        info.provider = providerId.componentName;
        info.providerInfo = ri.activityInfo;
        if (DEBUG == false) goto L22;
        ri.activityInfo.getClass();
    L22:
        return info;
    L23:
        return null;
    }

    private static AppWidgetProviderInfo parseAppWidgetProviderInfo(Context context, ProviderId providerId, ActivityInfo activityInfo, String metadataKey) {
        PackageManager pm = context.getPackageManager();
        XmlResourceParser parser = activityInfo.loadXmlMetaData(pm, metadataKey);     // Catch: Throwable -> L10
        if (parser != null) goto L87;
        Slog.w(TAG, "No " + metadataKey + " meta-data for AppWidget provider '" + providerId + '\'');     // Catch: Throwable -> L13
        if (parser == null) goto L12;
        parser.close();     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
    L12:
        return null;
    L87:
        AttributeSet attrs = Xml.asAttributeSet(parser);     // Catch: Throwable -> L74
    L16:
        int type = parser.next();     // Catch: Throwable -> L74
        if (type == 1) goto L20;
        if (type != 2) goto L16;
    L20:
        String nodeName = parser.getName();     // Catch: Throwable -> L74
        if ("appwidget-provider".equals(nodeName) == true) goto L25;
        Slog.w(TAG, "Meta-data does not start with appwidget-provider tag for AppWidget provider " + providerId.componentName + " for user " + providerId.uid);     // Catch: Throwable -> L13
        parser.close();     // Catch: Throwable -> L10 Throwable -> L10 Throwable -> L10
        return null;
    L25:
        AppWidgetProviderInfo info = new AppWidgetProviderInfo();     // Catch: Throwable -> L74
        info.provider = providerId.componentName;     // Catch: Throwable -> L74
        info.providerInfo = activityInfo;     // Catch: Throwable -> L74
        if (DEBUG == false) goto L85;
        activityInfo.getClass();     // Catch: Throwable -> L13
    L85:
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L74
        int userId = UserHandle.getUserId(providerId.uid);     // Catch: Throwable -> L70
        ApplicationInfo app = pm.getApplicationInfoAsUser(activityInfo.packageName, 0, userId);     // Catch: Throwable -> L68
        Resources resources = pm.getResourcesForApplication(app);     // Catch: Throwable -> L68
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L36
        TypedArray sa = resources.obtainAttributes(attrs, com.android.internal.R.styleable.AppWidgetProviderInfo);     // Catch: Throwable -> L36
        TypedValue value = sa.peekValue(1);     // Catch: Throwable -> L36
        if (value == null) goto L38;
        int r11 = value.data;     // Catch: Throwable -> L36
    L39:
        info.minWidth = r11;     // Catch: Throwable -> L36
        TypedValue value2 = sa.peekValue(2);     // Catch: Throwable -> L36
        if (value2 == null) goto L42;
        int r12 = value2.data;     // Catch: Throwable -> L36
    L43:
        info.minHeight = r12;     // Catch: Throwable -> L36
        TypedValue value3 = sa.peekValue(9);     // Catch: Throwable -> L36
        if (value3 == null) goto L46;
        int r13 = value3.data;     // Catch: Throwable -> L36
    L47:
        info.minResizeWidth = r13;     // Catch: Throwable -> L36
        TypedValue value4 = sa.peekValue(10);     // Catch: Throwable -> L36
        if (value4 == null) goto L50;
        int r14 = value4.data;     // Catch: Throwable -> L36
    L51:
        info.minResizeHeight = r14;     // Catch: Throwable -> L36
        TypedValue value5 = sa.peekValue(15);     // Catch: Throwable -> L36
        if (value5 == null) goto L54;
        int r15 = value5.data;     // Catch: Throwable -> L36
    L55:
        info.maxResizeWidth = r15;     // Catch: Throwable -> L36
        TypedValue value6 = sa.peekValue(16);     // Catch: Throwable -> L36
        if (value6 == null) goto L58;
        int r16 = value6.data;     // Catch: Throwable -> L36
    L59:
        info.maxResizeHeight = r16;     // Catch: Throwable -> L36
        info.targetCellWidth = sa.getInt(17, 0);     // Catch: Throwable -> L36
        info.targetCellHeight = sa.getInt(18, 0);     // Catch: Throwable -> L36
        info.updatePeriodMillis = sa.getInt(3, 0);     // Catch: Throwable -> L36
        info.initialLayout = sa.getResourceId(4, 0);     // Catch: Throwable -> L36
        info.initialKeyguardLayout = sa.getResourceId(11, 0);     // Catch: Throwable -> L36
        String className = sa.getString(5);     // Catch: Throwable -> L36
        if (className == null) goto L63;
        info.configure = new ComponentName(providerId.componentName.getPackageName(), className);     // Catch: Throwable -> L36
    L63:
        info.label = activityInfo.loadLabel(pm).toString();     // Catch: Throwable -> L36
        info.icon = activityInfo.getIconResource();     // Catch: Throwable -> L36
        info.previewImage = sa.getResourceId(6, 0);     // Catch: Throwable -> L36
        info.previewLayout = sa.getResourceId(14, 0);     // Catch: Throwable -> L36
        info.autoAdvanceViewId = sa.getResourceId(7, -1);     // Catch: Throwable -> L36
        info.resizeMode = sa.getInt(8, 0);     // Catch: Throwable -> L36
        info.widgetCategory = sa.getInt(12, 1);     // Catch: Throwable -> L36
        info.widgetFeatures = sa.getInt(13, 0);     // Catch: Throwable -> L36
        info.descriptionRes = sa.getResourceId(0, 0);     // Catch: Throwable -> L36
        sa.recycle();     // Catch: Throwable -> L36
        parser.close();     // Catch: Throwable -> L66
        return info;
    L58:
        r16 = 0;
        goto L59
    L54:
        r15 = 0;
        goto L55
    L50:
        r14 = info.minHeight;     // Catch: Throwable -> L36
        goto L51
    L46:
        r13 = info.minWidth;     // Catch: Throwable -> L36
        goto L47
    L42:
        r12 = 0;
        goto L43
    L38:
        r11 = 0;
    L68:
        th = th;
    L72:
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L70:
        th = th;
    L36:
        th = th;
    L37:
        Throwable r3 = th;
    L76:
        if (parser == null) goto L98;
        parser.close();     // Catch: Throwable -> L79
        throw r3;     // Catch: Throwable -> L66 Throwable -> L66 Throwable -> L66
    L79:
        th = move-exception;
        r3.addSuppressed(th);     // Catch: Throwable -> L66 Throwable -> L66 Throwable -> L66
        throw r3;     // Catch: Throwable -> L66 Throwable -> L66 Throwable -> L66
    L98:
        throw r3;     // Catch: Throwable -> L66 Throwable -> L66 Throwable -> L66
    L74:
        th = th;
    L66:
        e = e;
    L83:
        Slog.w(TAG, "XML parsing failed for AppWidget provider " + providerId.componentName + " for user " + providerId.uid, e);
        return null;
    L13:
        th = move-exception;
        r3 = th;
    L10:
        e = e;
        goto L83
    }

    private int getUidForPackage(String packageName, int userId) {
        PackageInfo pkgInfo = null;
        long identity = Binder.clearCallingIdentity();
        pkgInfo = this.mPackageManager.getPackageInfo(packageName, 0, userId);     // Catch: Throwable -> L6 RemoteException -> L8
        goto L5
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        Binder.restoreCallingIdentity(identity);
        if (pkgInfo != null) goto L14;
        return -1;
    L14:
        if (pkgInfo.applicationInfo != null) goto L17;
        return -1;
    L17:
        return pkgInfo.applicationInfo.uid;
    }

    private ActivityInfo getProviderInfo(ComponentName componentName, int userId) {
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
        intent.setComponent(componentName);
        List<ResolveInfo> receivers = queryIntentReceivers(intent, userId);
        if (receivers.isEmpty() == false) goto L5;
        return null;
    L5:
        return receivers.get(0).activityInfo;
    }

    private List<ResolveInfo> queryIntentReceivers(Intent intent, int userId) {
        long identity = Binder.clearCallingIdentity();
        int flags = 128 | 268435456;
        isProfileWithUnlockedParent(userId);     // Catch: Throwable -> L12 RemoteException -> L14
        goto L17
    L22:
        List<ResolveInfo> r10 = this.mPackageManager.queryIntentReceivers(intent, intent.resolveTypeIfNeeded(this.mContext.getContentResolver()), (flags | 786432) | 1024, userId).getList();     // Catch: Throwable -> L8 RemoteException -> L10
        Binder.restoreCallingIdentity(identity);
        return r10;
    L8:
        th = move-exception;
        RemoteException re = th;
    L20:
        Binder.restoreCallingIdentity(identity);
        throw re;
    L12:
        th = move-exception;
        re = th;
    L17:
        List<ResolveInfo> r11 = Collections.emptyList();     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return r11;
    }

    void handleUserUnlocked(int userId) {
        if (isProfileWithLockedParent(userId) == false) goto L6;
        return;
    L6:
        if (this.mUserManager.isUserUnlockingOrUnlocked(userId) == true) goto L9;
        Slog.w(TAG, "User " + userId + " is no longer unlocked - exiting");
        return;
    L9:
        long time = SystemClock.elapsedRealtime();
        Object r2 = this.mLock;
        monitor-enter(r2);
        Trace.traceBegin(64, "appwidget ensure");     // Catch: Throwable -> L21
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L21
        Trace.traceEnd(64);     // Catch: Throwable -> L21
        Trace.traceBegin(64, "appwidget reload");     // Catch: Throwable -> L21
        reloadWidgetsMaskedStateForGroup(this.mSecurityPolicy.getGroupParent(userId));     // Catch: Throwable -> L21
        Trace.traceEnd(64);     // Catch: Throwable -> L21
        int N = this.mProviders.size();     // Catch: Throwable -> L21
        int i = 0;
    L12:
        if (i >= N) goto L25;
        final Provider provider = this.mProviders.get(i);     // Catch: Throwable -> L21
        if (provider.getUserId() == userId) goto L17;
    L23:
        i = i + 1;     // Catch: Throwable -> L21
        goto L12
    L17:
        if (provider.widgets.size() <= 0) goto L23;
        if (provider.maskedByStoppedPackage == true) goto L23;
        Trace.traceBegin(64, "appwidget init " + provider.id.componentName.getPackageName());     // Catch: Throwable -> L21
        provider.widgets.forEach(new AppWidgetServiceImpl$$ExternalSyntheticLambda7(provider));     // Catch: Throwable -> L21
        int[] appWidgetIds = getWidgetIds(provider.widgets);     // Catch: Throwable -> L21
        sendEnableAndUpdateIntentLocked(provider, appWidgetIds);     // Catch: Throwable -> L21
        registerForBroadcastsLocked(provider, appWidgetIds);     // Catch: Throwable -> L21
        Trace.traceEnd(64);     // Catch: Throwable -> L21
        goto L23
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L21
        Slog.i(TAG, "Processing of handleUserUnlocked u" + userId + " took " + (SystemClock.elapsedRealtime() - time) + " ms");
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$handleUserUnlocked$3(Provider provider, Widget widget) {
        widget.trackingUpdate = true;
        Trace.asyncTraceBegin(64, "appwidget update-intent " + provider.id.toString(), widget.appWidgetId);
        Log.i(TAG, "Widget update scheduled on unlock " + widget.toString());
    }

    private void loadGroupStateLocked(int[] profileIds) {
        List<LoadedWidgetState> loadedWidgets = new ArrayList();
        int version = 0;
        int profileIdCount = profileIds.length;
        int i = 0;
    L4:
        if (i >= profileIdCount) goto L31;
        int profileId = profileIds[i];
        AtomicFile file = getSavedStateFile(profileId);
        FileInputStream stream = file.openRead();     // Catch: IOException -> L12
        version = readProfileStateFromFileLocked(stream, profileId, loadedWidgets);     // Catch: Throwable -> L15
        if (stream == null) goto L43;
        stream.close();     // Catch: IOException -> L12
    L43:
        loadGeneratedPreviewCategoriesLocked(profileId);     // Catch: IOException -> L27
    L29:
        i = i + 1;
    L27:
        e = move-exception;
        Slog.w(TAG, "Failed to read preview categories: " + e);
        goto L29
    L15:
        th = move-exception;
        if (stream != null) goto L41;
    L22:
        throw th;     // Catch: IOException -> L12
    L41:
        stream.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
    L12:
        e = move-exception;
        Slog.w(TAG, "Failed to read state: " + e);
        goto L43
    L31:
        if (version < 0) goto L33;
        bindLoadedWidgetsLocked(loadedWidgets);
        performUpgradeLocked(version);
        return;
    L33:
        Slog.w(TAG, "Failed to read state, clearing widgets and hosts.");
        clearWidgetsLocked();
        this.mHosts.clear();
        int N = this.mProviders.size();
        int i2 = 0;
    L34:
        if (i2 >= N) goto L50;
        this.mProviders.get(i2).widgets.clear();
        i2 = i2 + 1;
        goto L34
    }

    private void bindLoadedWidgetsLocked(List<LoadedWidgetState> loadedWidgets) {
        int loadedWidgetCount = loadedWidgets.size();
        int i = loadedWidgetCount - 1;
    L3:
        if (i < 0) goto L13;
        LoadedWidgetState loadedWidget = loadedWidgets.remove(i);
        Widget widget = loadedWidget.widget;
        widget.provider = findProviderByTag(loadedWidget.providerTag);
        if (widget.provider == null) goto L11;
        widget.host = findHostByTag(loadedWidget.hostTag);
        if (widget.host == null) goto L11;
        widget.provider.widgets.add(widget);
        widget.host.widgets.add(widget);
        addWidgetLocked(widget);
    L11:
        i = i - 1;
        goto L3
    }

    private Provider findProviderByTag(int tag) {
        if (tag >= 0) goto L5;
        return null;
    L5:
        int providerCount = this.mProviders.size();
        int i = 0;
    L6:
        if (i >= providerCount) goto L12;
        Provider provider = this.mProviders.get(i);
        if (provider.tag == tag) goto L9;
        i = i + 1;
        goto L6
    L9:
        return provider;
    L12:
        return null;
    }

    private Host findHostByTag(int tag) {
        if (tag >= 0) goto L5;
        return null;
    L5:
        int hostCount = this.mHosts.size();
        int i = 0;
    L6:
        if (i >= hostCount) goto L12;
        Host host = this.mHosts.get(i);
        if (host.tag == tag) goto L9;
        i = i + 1;
        goto L6
    L9:
        return host;
    L12:
        return null;
    }

    void addWidgetLocked(Widget widget) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "addWidgetLocked() " + widget);
    L5:
        ensureWidgetCountBeforeAddLocked(widget);
        this.mWidgets.add(widget);
        onWidgetProviderAddedOrChangedLocked(widget);
    }

    private void ensureWidgetCountBeforeAddLocked(Widget widget) {
        if (widget.host != null) goto L5;
        return;
    L5:
        if (widget.host.id == null) goto L29;
        List<Widget> widgetsInSameHost = new ArrayList();
        Iterator<Widget> r1 = this.mWidgets.iterator();
    L9:
        if (r1.hasNext() == false) goto L17;
        Widget w = r1.next();
        if (w.host == null) goto L9;
        if (widget.host.id.equals(w.host.id) == false) goto L9;
        widgetsInSameHost.add(w);
    L17:
        if (widgetsInSameHost.size() < 200) goto L19;
        removeWidgetLocked(widgetsInSameHost.remove(0));
        goto L17
    L19:
        return;
    }

    void onWidgetProviderAddedOrChangedLocked(Widget widget) {
        if (widget.provider != null) goto L5;
        return;
    L5:
        int userId = widget.provider.getUserId();
        Object r1 = this.mWidgetPackagesLock;
        monitor-enter(r1);
        ArraySet<String> packages = this.mWidgetPackages.get(userId);     // Catch: Throwable -> L10
        if (packages != null) goto L12;
        SparseArray<ArraySet<String>> r3 = this.mWidgetPackages;     // Catch: Throwable -> L10
        ArraySet<String> r4 = new ArraySet();     // Catch: Throwable -> L10
        packages = r4;
        r3.put(userId, r4);     // Catch: Throwable -> L10
    L12:
        packages.add(widget.provider.id.componentName.getPackageName());     // Catch: Throwable -> L10
        SysOptBridge.getFactory().getProcessStatusChecker().onWidgetAdded(new IProcessStatusChecker.WidgetInfo(userId, widget.provider.id.componentName.getPackageName()).setSize(widget.options.getInt("appWidgetMinWidth"), widget.options.getInt("appWidgetMinHeight")));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (widget.provider.isMaskedLocked() == false) goto L17;
        maskWidgetsViewsLocked(widget.provider, widget);
        return;
    L17:
        Widget.m1892$$Nest$mclearMaskedViewsLocked(widget);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void removeWidgetLocked(Widget widget) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "removeWidgetLocked() " + widget);
    L5:
        this.mWidgets.remove(widget);
        onWidgetRemovedLocked(widget);
        scheduleNotifyAppWidgetRemovedLocked(widget);
    }

    private void onWidgetRemovedLocked(Widget widget) {
        if (widget.provider != null) goto L5;
        return;
    L5:
        int userId = widget.provider.getUserId();
        String packageName = widget.provider.id.componentName.getPackageName();
        Object r2 = this.mWidgetPackagesLock;
        monitor-enter(r2);
        ArraySet<String> packages = this.mWidgetPackages.get(userId);     // Catch: Throwable -> L11
        if (packages != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L13:
        int N = this.mWidgets.size();     // Catch: Throwable -> L11
        int i = 0;
    L14:
        if (i >= N) goto L25;
        Widget w = this.mWidgets.get(i);     // Catch: Throwable -> L11
        if (w.provider != null) goto L19;
    L24:
        i = i + 1;     // Catch: Throwable -> L11
        goto L14
    L19:
        if (w.provider.getUserId() != userId) goto L24;
        if (packageName.equals(w.provider.id.componentName.getPackageName()) == false) goto L24;
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L25:
        packages.remove(packageName);     // Catch: Throwable -> L11
        SysOptBridge.getFactory().getProcessStatusChecker().onWidgetRemoved(new IProcessStatusChecker.WidgetInfo(userId, widget.provider.id.componentName.getPackageName()).setSize(widget.options.getInt("appWidgetMinWidth"), widget.options.getInt("appWidgetMinHeight")));     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void clearWidgetsLocked() {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "clearWidgetsLocked()");
    L5:
        this.mWidgets.clear();
        onWidgetsClearedLocked();
    }

    private void onWidgetsClearedLocked() {
        Object r0 = this.mWidgetPackagesLock;
        monitor-enter(r0);
        this.mWidgetPackages.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        SysOptBridge.getFactory().getProcessStatusChecker().onWidgetClear();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isBoundWidgetPackage(String packageName, int userId) {
        if (Binder.getCallingUid() != 1000) goto L20;
        Object r0 = this.mWidgetPackagesLock;
        monitor-enter(r0);
        ArraySet<String> packages = this.mWidgetPackages.get(userId);     // Catch: Throwable -> L11
        if (packages == null) goto L14;
        boolean r2 = packages.contains(packageName);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    L20:
        throw new SecurityException("Only the system process can call this");
    }

    private SparseArray<byte[]> saveStateToByteArrayLocked(int userId) {
        tagProvidersAndHosts();
        int[] profileIds = this.mSecurityPolicy.getEnabledGroupProfileIds(userId);
        SparseArray<byte[]> userIdToBytesMapping = new SparseArray();
        int r2 = profileIds.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        int profileId = profileIds[r3];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if (writeProfileStateToStreamLocked(outputStream, profileId) == false) goto L7;
        userIdToBytesMapping.put(profileId, outputStream.toByteArray());
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return userIdToBytesMapping;
    }

    private void saveStateLocked(int userId) {
        tagProvidersAndHosts();
        int[] profileIds = this.mSecurityPolicy.getEnabledGroupProfileIds(userId);
        int profileCount = profileIds.length;
        int i = 0;
    L3:
        if (i >= profileCount) goto L15;
        int profileId = profileIds[i];
        AtomicFile file = getSavedStateFile(profileId);
        FileOutputStream stream = file.startWrite();     // Catch: IOException -> L8
        if (writeProfileStateToStreamLocked(stream, profileId) == false) goto L10;
        file.finishWrite(stream);     // Catch: IOException -> L8
    L13:
        i = i + 1;
        goto L3
    L10:
        file.failWrite(stream);     // Catch: IOException -> L8
        Slog.w(TAG, "Failed to save state, restoring backup.");     // Catch: IOException -> L8
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed open state file for write: " + e);
        goto L13
    }

    private void tagProvidersAndHosts() {
        int providerCount = this.mProviders.size();
        int i = 0;
    L3:
        if (i >= providerCount) goto L5;
        Provider provider = this.mProviders.get(i);
        provider.tag = i;
        i = i + 1;
        goto L3
    L5:
        int hostCount = this.mHosts.size();
        int i2 = 0;
    L6:
        if (i2 >= hostCount) goto L9;
        Host host = this.mHosts.get(i2);
        host.tag = i2;
        i2 = i2 + 1;
        goto L6
    }

    private void clearProvidersAndHostsTagsLocked() {
        int providerCount = this.mProviders.size();
        int i = 0;
    L4:
        if (i >= providerCount) goto L6;
        Provider provider = this.mProviders.get(i);
        provider.tag = -1;
        i = i + 1;
        goto L4
    L6:
        int hostCount = this.mHosts.size();
        int i2 = 0;
    L7:
        if (i2 >= hostCount) goto L10;
        Host host = this.mHosts.get(i2);
        host.tag = -1;
        i2 = i2 + 1;
        goto L7
    }

    private boolean writeProfileStateToStreamLocked(OutputStream stream, int userId) {
        TypedXmlSerializer out = Xml.resolveSerializer(stream);     // Catch: IOException -> L10
        out.startDocument(null, true);     // Catch: IOException -> L10
        out.startTag(null, "gs");     // Catch: IOException -> L10
        out.attributeInt(null, "version", 1);     // Catch: IOException -> L10
        int N = this.mProviders.size();     // Catch: IOException -> L10
        int i = 0;
    L4:
        if (i >= N) goto L12;
        Provider provider = this.mProviders.get(i);     // Catch: IOException -> L10
        if (provider.getUserId() != userId) goto L9;
        serializeProvider(out, provider, true);     // Catch: IOException -> L10
    L9:
        i = i + 1;     // Catch: IOException -> L10
        goto L4
    L12:
        int N2 = this.mHosts.size();     // Catch: IOException -> L10
        int i2 = 0;
    L13:
        if (i2 >= N2) goto L19;
        Host host = this.mHosts.get(i2);     // Catch: IOException -> L10
        if (host.getUserId() != userId) goto L18;
        serializeHost(out, host);     // Catch: IOException -> L10
    L18:
        i2 = i2 + 1;     // Catch: IOException -> L10
        goto L13
    L19:
        int N3 = this.mWidgets.size();     // Catch: IOException -> L10
        int i3 = 0;
    L20:
        if (i3 >= N3) goto L26;
        Widget widget = this.mWidgets.get(i3);     // Catch: IOException -> L10
        if (widget.host.getUserId() != userId) goto L25;
        serializeAppWidget(out, widget, true);     // Catch: IOException -> L10
    L25:
        i3 = i3 + 1;     // Catch: IOException -> L10
        goto L20
    L26:
        Iterator<Pair<Integer, String>> it = this.mPackagesWithBindWidgetPermission.iterator();     // Catch: IOException -> L10
    L28:
        if (it.hasNext() == false) goto L33;
        Pair<Integer, String> binding = it.next();     // Catch: IOException -> L10
        if (((Integer) binding.first).intValue() != userId) goto L28;
        out.startTag(null, "b");     // Catch: IOException -> L10
        out.attribute(null, "packageName", (String) binding.second);     // Catch: IOException -> L10
        out.endTag(null, "b");     // Catch: IOException -> L10
        goto L28
    L33:
        out.endTag(null, "gs");     // Catch: IOException -> L10
        out.endDocument();     // Catch: IOException -> L10
        return true;
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed to write state: " + e);
        return false;
    }

    private int readProfileStateFromFileLocked(FileInputStream stream, int userId, List<LoadedWidgetState> outLoadedWidgets) {
        int version = -1;
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L12
        int legacyProviderIndex = -1;
        int legacyHostIndex = -1;
    L115:
        int type = parser.next();     // Catch: Throwable -> L100
        if (type != 2) goto L102;
        String tag = parser.getName();     // Catch: Throwable -> L100
        if ("gs".equals(tag) == false) goto L14;
        version = parser.getAttributeInt(null, "version", 0);     // Catch: Throwable -> L12 Throwable -> L12 Throwable -> L12 Throwable -> L12 Throwable -> L12
    L105:
        if (type != 1) goto L115;
        return version;
    L14:
        int r16 = -1;
        if ("p".equals(tag) == false) goto L68;
        legacyProviderIndex = legacyProviderIndex + 1;
        String pkg = parser.getAttributeValue(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L65
        String cl = parser.getAttributeValue(null, "cl");     // Catch: Throwable -> L65
        String pkg2 = getCanonicalPackageName(pkg, cl, userId);     // Catch: Throwable -> L65
        if (pkg2 != null) goto L21;
        int version2 = version;
        legacyHostIndex = legacyHostIndex;
    L64:
        version = version2;
        legacyHostIndex = legacyHostIndex;
        goto L105
    L21:
        int uid = getUidForPackage(pkg2, userId);     // Catch: Throwable -> L65
        if (uid >= 0) goto L24;
        version2 = version;
        legacyHostIndex = legacyHostIndex;
        goto L64
    L24:
        ComponentName componentName = new ComponentName(pkg2, cl);     // Catch: Throwable -> L65
        ActivityInfo providerInfo = getProviderInfo(componentName, userId);     // Catch: Throwable -> L65
        if (providerInfo != null) goto L27;
        version2 = version;
        legacyHostIndex = legacyHostIndex;
        goto L64
    L27:
        version2 = version;
        ProviderId providerId = new ProviderId(uid, componentName);     // Catch: Throwable -> L36
        Provider provider = lookupProviderLocked(providerId);     // Catch: Throwable -> L36
        if (provider != null) goto L42;
        if (this.mSafeMode == false) goto L42;
        AppWidgetProviderInfo info = new AppWidgetProviderInfo();     // Catch: Throwable -> L36
        legacyHostIndex = legacyHostIndex;
        info.provider = providerId.componentName;     // Catch: Throwable -> L36
        info.providerInfo = providerInfo;     // Catch: Throwable -> L36
        if (DEBUG == false) goto L39;
        providerInfo.getClass();     // Catch: Throwable -> L36
    L39:
        Provider provider2 = new Provider();     // Catch: Throwable -> L36
        provider2.setPartialInfoLocked(info);     // Catch: Throwable -> L36
        provider2.zombie = true;     // Catch: Throwable -> L36
        provider2.id = providerId;     // Catch: Throwable -> L36
        this.mProviders.add(provider2);     // Catch: Throwable -> L36
    L53:
        int providerTag = parser.getAttributeIntHex(null, "tag", legacyProviderIndex);     // Catch: Throwable -> L36
        provider2.tag = providerTag;     // Catch: Throwable -> L36
        provider2.infoTag = parser.getAttributeValue(null, "info_tag");     // Catch: Throwable -> L36
        String pendingDeletedIds = parser.getAttributeValue(null, PENDING_DELETED_IDS_ATTR);     // Catch: Throwable -> L36
        if (pendingDeletedIds == null) goto L64;
        if (pendingDeletedIds.isEmpty() == true) goto L64;
        String[] idStrings = pendingDeletedIds.split(",");     // Catch: Throwable -> L36
        int i = 0;
    L58:
        int providerTag2 = providerTag;
        int providerTag3 = idStrings.length;     // Catch: Throwable -> L36
        if (i >= providerTag3) goto L64;
        int i2 = i;
        provider2.pendingDeletedWidgetIds.add(Integer.parseInt(idStrings[i]));     // Catch: Throwable -> L36
        i = i2 + 1;     // Catch: Throwable -> L36
        providerTag = providerTag2;
    L42:
        AppWidgetProviderInfo info2 = AppWidgetXmlUtil.readAppWidgetProviderInfoLocked(parser);     // Catch: Throwable -> L36
        if (DEBUG == false) goto L47;
        if (info2 != null) goto L47;
        Slog.d(TAG, "Unable to load widget provider info from xml for " + providerId.componentName);     // Catch: Throwable -> L36
    L47:
        if (info2 == null) goto L52;
        info2.provider = providerId.componentName;     // Catch: Throwable -> L36
        info2.providerInfo = r20;     // Catch: Throwable -> L36
        if (DEBUG == false) goto L51;
        providerInfo.getClass();     // Catch: Throwable -> L36
    L51:
        provider2 = provider;
        provider2.setInfoLocked(info2);     // Catch: Throwable -> L36
        goto L53
    L52:
        provider2 = provider;
    L36:
        e = e;
    L107:
        Slog.w(TAG, "failed parsing " + e);
        return r16;
    L65:
        e = e;
        goto L107
    L68:
        version2 = version;
        int legacyHostIndex2 = legacyHostIndex;
        if ("h".equals(tag) == false) goto L82;
        int legacyHostIndex3 = legacyHostIndex2 + 1;
        Host host = new Host();     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        String pkg3 = parser.getAttributeValue(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        int uid2 = getUidForPackage(pkg3, userId);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        if (uid2 >= 0) goto L76;
        host.zombie = true;     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
    L76:
        if (host.zombie == true) goto L78;
    L79:
        int hostId = parser.getAttributeIntHex(null, "id");     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        int hostTag = parser.getAttributeIntHex(null, "tag", legacyHostIndex3);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        host.tag = hostTag;     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        host.id = new HostId(uid2, hostId, pkg3);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        this.mHosts.add(host);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
    L80:
        legacyHostIndex = legacyHostIndex3;
        version = version2;
        goto L105
    L78:
        if (this.mSafeMode == false) goto L80;
    L82:
        if ("b".equals(tag) == false) goto L88;
        String packageName = parser.getAttributeValue(null, "packageName");     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        if (getUidForPackage(packageName, userId) < 0) goto L103;
        Pair<Integer, String> packageId = Pair.create(Integer.valueOf(userId), packageName);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        this.mPackagesWithBindWidgetPermission.add(packageId);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
    L103:
        version = version2;
        legacyHostIndex = legacyHostIndex2;
        goto L105
    L88:
        if ("g".equals(tag) == false) goto L103;
        Widget widget = new Widget(null);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        widget.appWidgetId = parser.getAttributeIntHex(null, "id");     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        setMinAppWidgetIdLocked(userId, widget.appWidgetId + 1);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        widget.restoredId = parser.getAttributeIntHex(null, "rid", 0);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        widget.options = parseWidgetIdOptions(parser);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        int hostTag2 = parser.getAttributeIntHex(null, "h");     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        String providerString = parser.getAttributeValue(null, "p");     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        if (providerString == null) goto L92;
        int providerTag4 = parser.getAttributeIntHex(null, "p");     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
    L93:
        LoadedWidgetState loadedWidgets = new LoadedWidgetState(this, widget, hostTag2, providerTag4);     // Catch: Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36 Throwable -> L36
        outLoadedWidgets.add(loadedWidgets);     // Catch: Throwable -> L97
    L97:
        e = e;
        goto L107
    L92:
        providerTag4 = -1;
        goto L93
    L102:
        version2 = version;
        legacyHostIndex2 = legacyHostIndex;
    L100:
        e = e;
        r16 = -1;
    L12:
        e = e;
        r16 = -1;
        goto L107
    }

    private <T> void loadUpdateRecords(SparseArray<List<BackupRestoreController.RestoreUpdateRecord>> updatesOnFile, Function<Integer, T> findKeyByTagCb, Function<T, List<BackupRestoreController.RestoreUpdateRecord>> findRecordsCb, BiConsumer<T, List<BackupRestoreController.RestoreUpdateRecord>> newRecordsCb) {
        if (updatesOnFile != null) goto L4;
        return;
    L4:
        int i = 0;
    L6:
        if (i >= updatesOnFile.size()) goto L18;
        int tag = updatesOnFile.keyAt(i);
        List<BackupRestoreController.RestoreUpdateRecord> recordsOnFile = updatesOnFile.get(tag);
        if (recordsOnFile == null) goto L16;
        if (recordsOnFile.isEmpty() == true) goto L16;
        T key = findKeyByTagCb.apply(Integer.valueOf(tag));
        List<BackupRestoreController.RestoreUpdateRecord> recordsInMemory = findRecordsCb.apply(key);
        if (recordsInMemory == null) goto L15;
        recordsInMemory.addAll(recordsOnFile);
        goto L16
    L15:
        newRecordsCb.accept(key, recordsOnFile);
    L16:
        i = i + 1;
        goto L6
    }

    private void performUpgradeLocked(int fromVersion) {
        if (fromVersion >= 1) goto L5;
        Slog.v(TAG, "Upgrading widget database from " + fromVersion + " to 1");
    L5:
        int version = fromVersion;
        if (version != 0) goto L8;
        Slog.e(TAG, "Found widget database with version 0, this should not be possible, forcing upgrade to version 1");
        version = 1;
    L8:
        if (version != 1) goto L11;
        return;
    L11:
        throw new IllegalStateException("Failed to upgrade widget database");
    }

    private static AtomicFile getSavedStateFile(int userId) {
        return new AtomicFile(new File(Environment.getUserSystemDirectory(userId), STATE_FILENAME));
    }

    void onUserStopped(int userId) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "onUserStopped() " + userId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean crossProfileWidgetsChanged = false;
        int widgetCount = this.mWidgets.size();     // Catch: Throwable -> L23
        int i = widgetCount - 1;     // Catch: Throwable -> L23
    L9:
        boolean providerInUser = false;
        if (i < 0) goto L33;
        Widget widget = this.mWidgets.get(i);     // Catch: Throwable -> L23
        if (widget.host.getUserId() != userId) goto L14;
        boolean hostInUser = true;
    L16:
        if (widget.provider == null) goto L18;
        boolean hasProvider = true;
    L19:
        if (hasProvider == true) goto L21;
    L26:
        if (hostInUser == false) goto L32;
        if (hasProvider == false) goto L29;
        if (providerInUser == false) goto L32;
    L29:
        removeWidgetLocked(widget);     // Catch: Throwable -> L23
        widget.host.widgets.remove(widget);     // Catch: Throwable -> L23
        widget.host = null;     // Catch: Throwable -> L23
        if (hasProvider == false) goto L32;
        widget.provider.widgets.remove(widget);     // Catch: Throwable -> L23
        widget.provider = null;     // Catch: Throwable -> L23
    L32:
        i = i - 1;     // Catch: Throwable -> L23
        goto L9
    L21:
        if (widget.provider.getUserId() != userId) goto L26;
        providerInUser = true;
        goto L26
    L18:
        hasProvider = false;
        goto L19
    L14:
        hostInUser = false;
        goto L16
    L33:
        int hostCount = this.mHosts.size();     // Catch: Throwable -> L23
        int i2 = hostCount - 1;     // Catch: Throwable -> L23
    L34:
        if (i2 < 0) goto L43;
        Host host = this.mHosts.get(i2);     // Catch: Throwable -> L23
        if (host.getUserId() != userId) goto L42;
        if (host.widgets.isEmpty() == true) goto L40;
        boolean r8 = true;
    L41:
        crossProfileWidgetsChanged = crossProfileWidgetsChanged | r8;     // Catch: Throwable -> L23
        deleteHostLocked(host);     // Catch: Throwable -> L23
        goto L42
    L40:
        r8 = false;
    L42:
        i2 = i2 - 1;     // Catch: Throwable -> L23
        goto L34
    L43:
        int grantCount = this.mPackagesWithBindWidgetPermission.size();     // Catch: Throwable -> L23
        int i3 = grantCount - 1;     // Catch: Throwable -> L23
    L44:
        if (i3 < 0) goto L49;
        Pair<Integer, String> packageId = this.mPackagesWithBindWidgetPermission.valueAt(i3);     // Catch: Throwable -> L23
        if (((Integer) packageId.first).intValue() != userId) goto L48;
        this.mPackagesWithBindWidgetPermission.removeAt(i3);     // Catch: Throwable -> L23
    L48:
        i3 = i3 - 1;     // Catch: Throwable -> L23
        goto L44
    L49:
        int userIndex = this.mLoadedUserIds.indexOfKey(userId);     // Catch: Throwable -> L23
        if (userIndex < 0) goto L52;
        this.mLoadedUserIds.removeAt(userIndex);     // Catch: Throwable -> L23
    L52:
        int nextIdIndex = this.mNextAppWidgetIds.indexOfKey(userId);     // Catch: Throwable -> L23
        if (nextIdIndex < 0) goto L55;
        this.mNextAppWidgetIds.removeAt(nextIdIndex);     // Catch: Throwable -> L23
    L55:
        if (crossProfileWidgetsChanged == false) goto L57;
        saveGroupStateAsync(userId);     // Catch: Throwable -> L23
    L57:
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private void applyResourceOverlaysToWidgetsLocked(Set<String> packageNames, int userId, boolean updateFrameworkRes) {
        int i = 0;
        int N = this.mProviders.size();
    L3:
        if (i >= N) goto L47;
        Provider provider = this.mProviders.get(i);
        if (provider.getUserId() != userId) goto L45;
        String packageName = provider.id.componentName.getPackageName();
        if (updateFrameworkRes == false) goto L10;
    L12:
        ApplicationInfo newAppInfo = null;
        newAppInfo = this.mPackageManager.getApplicationInfo(packageName, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, userId);     // Catch: RemoteException -> L15
    L17:
        if (newAppInfo == null) goto L45;
        if (provider.info == null) goto L45;
        if (provider.info.providerInfo == null) goto L45;
        ApplicationInfo oldAppInfo = provider.info.providerInfo.applicationInfo;
        if (oldAppInfo == null) goto L45;
        if (newAppInfo.sourceDir.equals(oldAppInfo.sourceDir) == false) goto L45;
        ApplicationInfo oldAppInfo2 = new ApplicationInfo(oldAppInfo);
        String[] r7 = null;
        if (newAppInfo.overlayPaths != null) goto L31;
        String[] r5 = null;
    L32:
        oldAppInfo2.overlayPaths = r5;
        if (newAppInfo.resourceDirs == null) goto L36;
        r7 = (String[]) newAppInfo.resourceDirs.clone();
    L36:
        oldAppInfo2.resourceDirs = r7;
        provider.info.providerInfo.applicationInfo = oldAppInfo2;
        int j = 0;
        int M = provider.widgets.size();
    L37:
        if (j >= M) goto L45;
        Widget widget = provider.widgets.get(j);
        if (widget.views == null) goto L42;
        widget.views.updateAppInfo(oldAppInfo2);
    L42:
        if (widget.maskedViews == null) goto L44;
        widget.maskedViews.updateAppInfo(oldAppInfo2);
    L44:
        j = j + 1;
        goto L37
    L31:
        r5 = (String[]) newAppInfo.overlayPaths.clone();
    L15:
        e = move-exception;
        Slog.w(TAG, "Failed to retrieve app info for " + packageName + " userId=" + userId, e);
        goto L17
    L10:
        if (packageNames.contains(packageName) == true) goto L12;
    L45:
        i = i + 1;
        goto L3
    }

    private boolean updateProvidersForPackageLocked(String packageName, int userId, Set<ProviderId> removedProviders) {
        boolean providersUpdated = false;
        HashSet<ProviderId> keep = new HashSet();
        Intent intent = new Intent("android.appwidget.action.APPWIDGET_UPDATE");
        intent.setPackage(packageName);
        List<ResolveInfo> broadcastReceivers = queryIntentReceivers(intent, userId);
        if (broadcastReceivers != null) goto L5;
        int N = 0;
    L6:
        int i = 0;
    L7:
        if (i >= N) goto L33;
        ResolveInfo ri = broadcastReceivers.get(i);
        ActivityInfo ai = ri.activityInfo;
        if ((ai.applicationInfo.flags & 262144) == 0) goto L12;
    L31:
        providersUpdated = providersUpdated;
    L32:
        i = i + 1;
        broadcastReceivers = broadcastReceivers;
        intent = intent;
        goto L7
    L12:
        if (packageName.equals(ai.packageName) == false) goto L31;
        ProviderId providerId = new ProviderId(ai.applicationInfo.uid, new ComponentName(ai.packageName, ai.name));
        Provider provider = lookupProviderLocked(providerId);
        if (provider == null) goto L16;
        AppWidgetProviderInfo info = createPartialProviderInfo(providerId, ri, provider);
        if (info == null) goto L28;
        keep.add(providerId);
        provider.setPartialInfoLocked(info);
        int M = provider.widgets.size();
        if (M <= 0) goto L27;
        int[] appWidgetIds = getWidgetIds(provider.widgets);
        cancelBroadcastsLocked(provider);
        registerForBroadcastsLocked(provider, appWidgetIds);
        int j = 0;
    L24:
        if (j >= M) goto L26;
        List<ResolveInfo> broadcastReceivers2 = broadcastReceivers;
        Widget widget = provider.widgets.get(j);
        widget.views = null;
        scheduleNotifyProviderChangedLocked(widget);
        j = j + 1;
        broadcastReceivers = broadcastReceivers2;
        goto L24
    L26:
        broadcastReceivers = broadcastReceivers;
        sendUpdateIntentLocked(provider, appWidgetIds, false);
    L29:
        providersUpdated = true;
        goto L32
    L27:
        broadcastReceivers = broadcastReceivers;
        goto L29
    L28:
        broadcastReceivers = broadcastReceivers;
        goto L29
    L16:
        if (addProviderLocked(ri) == false) goto L31;
        keep.add(providerId);
        intent = intent;
        broadcastReceivers = broadcastReceivers;
        providersUpdated = true;
        goto L32
    L33:
        boolean providersUpdated2 = providersUpdated;
        int N2 = this.mProviders.size();
        int i2 = N2 - 1;
    L34:
        if (i2 < 0) goto L46;
        Provider provider2 = this.mProviders.get(i2);
        if (packageName.equals(provider2.id.componentName.getPackageName()) == false) goto L44;
        if (provider2.getUserId() != userId) goto L44;
        if (keep.contains(provider2.id) == true) goto L44;
        if (removedProviders == null) goto L43;
        removedProviders.add(provider2.id);
    L43:
        deleteProviderLocked(provider2);
        providersUpdated2 = true;
    L44:
        i2 = i2 - 1;
        goto L34
    L46:
        return providersUpdated2;
    L5:
        N = broadcastReceivers.size();
        goto L6
    }

    private void removeWidgetsForPackageLocked(String pkgName, int userId, int parentUserId) {
        int N = this.mProviders.size();
        int i = 0;
    L3:
        if (i >= N) goto L13;
        Provider provider = this.mProviders.get(i);
        if (pkgName.equals(provider.id.componentName.getPackageName()) == false) goto L11;
        if (provider.getUserId() != userId) goto L11;
        if (provider.widgets.size() <= 0) goto L11;
        deleteWidgetsLocked(provider, parentUserId);
    L11:
        i = i + 1;
        goto L3
    }

    private boolean removeProvidersForPackageLocked(String pkgName, int userId) {
        boolean removed = false;
        int N = this.mProviders.size();
        int i = N - 1;
    L3:
        if (i < 0) goto L11;
        Provider provider = this.mProviders.get(i);
        if (pkgName.equals(provider.id.componentName.getPackageName()) == false) goto L9;
        if (provider.getUserId() != userId) goto L9;
        deleteProviderLocked(provider);
        removed = true;
    L9:
        i = i - 1;
        goto L3
    L11:
        return removed;
    }

    private boolean removeHostsAndProvidersForPackageLocked(String pkgName, int userId) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "removeHostsAndProvidersForPackageLocked() pkg=" + pkgName + " userId=" + userId);
    L5:
        boolean removed = removeProvidersForPackageLocked(pkgName, userId);
        int N = this.mHosts.size();
        int i = N - 1;
    L6:
        if (i < 0) goto L14;
        Host host = this.mHosts.get(i);
        if (pkgName.equals(host.id.packageName) == false) goto L12;
        if (host.getUserId() != userId) goto L12;
        deleteHostLocked(host);
        removed = true;
    L12:
        i = i - 1;
        goto L6
    L14:
        return removed;
    }

    private String getCanonicalPackageName(String packageName, String className, int userId) {
        long identity = Binder.clearCallingIdentity();
        AppGlobals.getPackageManager().getReceiverInfo(new ComponentName(packageName, className), 0, userId);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(identity);
        return packageName;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L9:
        String[] packageNames = this.mContext.getPackageManager().currentToCanonicalPackageNames(new String[]{packageName});     // Catch: Throwable -> L6
        if (packageNames != null) goto L12;
    L16:
        Binder.restoreCallingIdentity(identity);
        return null;
    L12:
        if (packageNames.length <= 0) goto L16;
        String r4 = packageNames[0];     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r4;
    }

    private void sendBroadcastAsUser(Intent intent, UserHandle userHandle, boolean isInteractive) {
        long identity = Binder.clearCallingIdentity();
        Context r2 = this.mContext;     // Catch: Throwable -> L6
        if (isInteractive == false) goto L8;
        Bundle r4 = this.mInteractiveBroadcast;     // Catch: Throwable -> L6
    L9:
        r2.sendBroadcastAsUser(intent, userHandle, null, r4);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L8:
        r4 = null;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void bindService(Intent intent, ServiceConnection connection, UserHandle userHandle) {
        long token = Binder.clearCallingIdentity();
        this.mContext.bindServiceAsUser(intent, connection, 33554433, userHandle);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void unbindService(ServiceConnection connection) {
        long token = Binder.clearCallingIdentity();
        this.mContext.unbindService(connection);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void onCrossProfileWidgetProvidersChanged(int userId, List<String> packages) {
        int parentId = this.mSecurityPolicy.getProfileParent(userId);
        if (parentId == userId) goto L29;
        Object r1 = this.mLock;
        monitor-enter(r1);
        boolean providersChanged = false;
        ArraySet<String> previousPackages = new ArraySet();     // Catch: Throwable -> L12
        int providerCount = this.mProviders.size();     // Catch: Throwable -> L12
        int i = 0;
    L8:
        if (i >= providerCount) goto L15;
        Provider provider = this.mProviders.get(i);     // Catch: Throwable -> L12
        if (provider.getUserId() != userId) goto L14;
        previousPackages.add(provider.id.componentName.getPackageName());     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L8
    L15:
        int packageCount = packages.size();     // Catch: Throwable -> L12
        int i2 = 0;
    L16:
        if (i2 >= packageCount) goto L18;
        String packageName = packages.get(i2);     // Catch: Throwable -> L12
        previousPackages.remove(packageName);     // Catch: Throwable -> L12
        providersChanged = providersChanged | updateProvidersForPackageLocked(packageName, userId, null);     // Catch: Throwable -> L12
        i2 = i2 + 1;     // Catch: Throwable -> L12
        goto L16
    L18:
        int removedCount = previousPackages.size();     // Catch: Throwable -> L12
        int i3 = 0;
    L19:
        if (i3 >= removedCount) goto L22;
        removeWidgetsForPackageLocked(previousPackages.valueAt(i3), userId, parentId);     // Catch: Throwable -> L12
        i3 = i3 + 1;     // Catch: Throwable -> L12
        goto L19
    L22:
        if (providersChanged == true) goto L24;
        if (removedCount > 0) goto L24;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L24:
        saveGroupStateAsync(userId);     // Catch: Throwable -> L12
        scheduleNotifyGroupHostsForProvidersChangedLocked(userId);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private boolean isProfileWithLockedParent(int userId) {
        long token = Binder.clearCallingIdentity();
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);     // Catch: Throwable -> L13
        if (userInfo != null) goto L6;
    L15:
        Binder.restoreCallingIdentity(token);
        return false;
    L6:
        if (userInfo.isProfile() == false) goto L15;
        UserInfo parentInfo = this.mUserManager.getProfileParent(userId);     // Catch: Throwable -> L13
        if (parentInfo == null) goto L15;
        if (isUserRunningAndUnlocked(parentInfo.getUserHandle().getIdentifier()) == true) goto L15;
        Binder.restoreCallingIdentity(token);
        return true;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private boolean isProfileWithUnlockedParent(int userId) {
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);
        if (userInfo != null) goto L5;
        return false;
    L5:
        if (userInfo.isProfile() == false) goto L14;
        UserInfo parentInfo = this.mUserManager.getProfileParent(userId);
        if (parentInfo != null) goto L9;
        return false;
    L9:
        if (this.mUserManager.isUserUnlockingOrUnlocked(parentInfo.getUserHandle()) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    public void noteAppWidgetTapped(String callingPackage, int appWidgetId) {
        this.mSecurityPolicy.enforceCallFromPackage(callingPackage);
        int callingUid = Binder.getCallingUid();
        long ident = Binder.clearCallingIdentity();
        int procState = this.mActivityManagerInternal.getUidProcessState(callingUid);     // Catch: Throwable -> L28
        if (procState <= 2) goto L8;
        Binder.restoreCallingIdentity(ident);
        return;
    L8:
        Object r4 = this.mLock;     // Catch: Throwable -> L28
        monitor-enter(r4);     // Catch: Throwable -> L28
        Widget widget = lookupWidgetLocked(appWidgetId, callingUid, callingPackage);     // Catch: Throwable -> L15
        if (widget != null) goto L17;
        monitor-exit(r4);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(ident);
        return;
    L17:
        ProviderId providerId = widget.provider.id;     // Catch: Throwable -> L15
        String packageName = providerId.componentName.getPackageName();     // Catch: Throwable -> L15
        if (packageName != null) goto L22;
        monitor-exit(r4);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(ident);
        return;
    L22:
        SparseArray<String> uid2PackageName = new SparseArray();     // Catch: Throwable -> L15
        uid2PackageName.put(providerId.uid, packageName);     // Catch: Throwable -> L15
        this.mAppOpsManagerInternal.updateAppWidgetVisibility(uid2PackageName, true);     // Catch: Throwable -> L15
        reportWidgetInteractionEvent(packageName, UserHandle.getUserId(providerId.uid), "tap");     // Catch: Throwable -> L15
        monitor-exit(r4);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(ident);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void reportWidgetInteractionEvent(String packageName, int userId, String action) {
        PersistableBundle extras = new PersistableBundle();
        extras.putString("android.app.usage.extra.EVENT_CATEGORY", "android.appwidget");
        extras.putString("android.app.usage.extra.EVENT_ACTION", action);
        this.mUsageStatsManagerInternal.reportUserInteractionEvent(packageName, userId, extras);
    }

    public RemoteViews getWidgetPreview(String callingPackage, ComponentName providerComponent, int profileId, int widgetCategory) {
        String r2 = callingPackage;
        int callingUserId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "getWidgetPreview() " + callingUserId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(r2);
        ensureWidgetCategoryCombinationIsValid(widgetCategory);
        AndroidFuture<RemoteViews> result = null;
        Object r6 = this.mLock;
        monitor-enter(r6);
        ensureGroupStateLoadedLocked(profileId);     // Catch: Throwable -> L34
        int providerCount = this.mProviders.size();     // Catch: Throwable -> L34
        int i = 0;
    L8:
        if (i >= providerCount) goto L37;
        Provider provider = this.mProviders.get(i);     // Catch: Throwable -> L34
        ComponentName componentName = provider.id.componentName;     // Catch: Throwable -> L34
        if (provider.zombie == false) goto L48;
        int providerCount2 = providerCount;
    L54:
        i = i + 1;     // Catch: Throwable -> L27
        r2 = callingPackage;
        providerCount = providerCount2;
    L27:
        th = th;
    L46:
        monitor-exit(r6);     // Catch: Throwable -> L27
        throw th;
    L48:
    L30:
        th = th;
        goto L46
    L13:
        if (providerComponent.equals(componentName) == true) goto L15;
        providerCount2 = providerCount;
        goto L54
    L15:
        AppWidgetProviderInfo info = provider.getInfoLocked(this.mContext);     // Catch: Throwable -> L30
        int providerProfileId = info.getProfile().getIdentifier();     // Catch: Throwable -> L30
        if (providerProfileId == profileId) goto L18;
        providerCount2 = providerCount;
        goto L54
    L18:
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L30
        String providerPackageName = componentName.getPackageName();     // Catch: Throwable -> L30
        boolean providerIsInCallerProfile = this.mSecurityPolicy.canAccessProvider(providerPackageName, providerProfileId);     // Catch: Throwable -> L30
        providerCount2 = providerCount;
        boolean shouldFilterAppAccess = this.mPackageManagerInternal.filterAppAccess(providerPackageName, callingUid, providerProfileId);     // Catch: Throwable -> L30
        boolean providerIsInCallerPackage = this.mSecurityPolicy.isProviderInPackageForUid(provider, callingUid, r2);     // Catch: Throwable -> L30
        boolean hasBindAppWidgetPermission = this.mSecurityPolicy.hasCallerBindPermissionOrBindWhiteListedLocked(r2);     // Catch: Throwable -> L30
        if (providerIsInCallerProfile == false) goto L54;
        if (shouldFilterAppAccess == true) goto L54;
        if (providerIsInCallerPackage == true) goto L26;
        if (hasBindAppWidgetPermission == false) goto L54;
    L26:
        result = getGeneratedPreviewsAsync(provider, widgetCategory);     // Catch: Throwable -> L27
        goto L54
    L37:
        monitor-exit(r6);     // Catch: Throwable -> L27
        if (result != null) goto L52;
        return null;
    L52:
        return (RemoteViews) result.get();
    L42:
        e = move-exception;
        Slog.e(TAG, "Failed to get generated previews Future result", e);
        return null;
    L34:
        th = th;
        goto L46
    }

    public boolean setWidgetPreview(ComponentName providerComponent, int widgetCategories, RemoteViews preview) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "setWidgetPreview() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(providerComponent.getPackageName());
        ensureWidgetCategoryCombinationIsValid(widgetCategories);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L15
        ProviderId providerId = new ProviderId(Binder.getCallingUid(), providerComponent);     // Catch: Throwable -> L15
        Provider provider = lookupProviderLocked(providerId);     // Catch: Throwable -> L15
        if (provider == null) goto L21;
        if (this.mGeneratedPreviewsApiCounter.tryApiCall(providerId) == false) goto L17;
        setGeneratedPreviewsAsync(provider, widgetCategories, preview);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return true;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return false;
    L21:
        throw new IllegalArgumentException(providerComponent + " is not a valid AppWidget provider");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void removeWidgetPreview(ComponentName providerComponent, int widgetCategories) {
        int userId = UserHandle.getCallingUserId();
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "removeWidgetPreview() " + userId);
    L5:
        this.mSecurityPolicy.enforceCallFromPackage(providerComponent.getPackageName());
        ensureWidgetCategoryCombinationIsValid(widgetCategories);
        Object r1 = this.mLock;
        monitor-enter(r1);
        ensureGroupStateLoadedLocked(userId);     // Catch: Throwable -> L12
        ProviderId providerId = new ProviderId(Binder.getCallingUid(), providerComponent);     // Catch: Throwable -> L12
        Provider provider = lookupProviderLocked(providerId);     // Catch: Throwable -> L12
        if (provider == null) goto L15;
        removeGeneratedPreviewsAsync(provider, widgetCategories);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L15:
        throw new IllegalArgumentException(providerComponent + " is not a valid AppWidget provider");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private AndroidFuture<RemoteViews> getGeneratedPreviewsAsync(final Provider provider, final int widgetCategory) {
        final AndroidFuture<RemoteViews> result = new AndroidFuture();
        this.mSavePreviewsHandler.post(new AppWidgetServiceImpl$$ExternalSyntheticLambda10(this, provider, widgetCategory, result));
        return result;
    }

    private /* synthetic */ void lambda$getGeneratedPreviewsAsync$4(Provider provider, int widgetCategory, AndroidFuture result) {
        SparseArray<RemoteViews> previews = loadGeneratedPreviews(provider);
        if (previews.size() == 0) goto L5;
    L7:
        int i = 0;
    L9:
        if (i >= previews.size()) goto L15;
        if ((previews.keyAt(i) & widgetCategory) != 0) goto L12;
        i = i + 1;
        goto L9
    L12:
        result.complete(previews.valueAt(i));
        return;
    L15:
        result.complete(null);
        return;
    L5:
        if (provider.info.generatedPreviewCategories == 0) goto L7;
        saveGeneratedPreviews(provider, previews, true);
        goto L7
    }

    private void setGeneratedPreviewsAsync(final Provider provider, final int widgetCategories, final RemoteViews preview) {
        this.mSavePreviewsHandler.post(new AppWidgetServiceImpl$$ExternalSyntheticLambda0(this, provider, widgetCategories, preview));
    }

    private /* synthetic */ void lambda$setGeneratedPreviewsAsync$5(Provider provider, int widgetCategories, RemoteViews preview) {
        SparseArray<RemoteViews> previews = loadGeneratedPreviews(provider);
        int[] r1 = Provider.m1891$$Nest$sfgetWIDGET_CATEGORY_FLAGS();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        int flag = r1[r3];
        if ((widgetCategories & flag) == 0) goto L7;
        previews.put(flag, preview);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        saveGeneratedPreviews(provider, previews, true);
    }

    private void removeGeneratedPreviewsAsync(final Provider provider, final int widgetCategories) {
        this.mSavePreviewsHandler.post(new AppWidgetServiceImpl$$ExternalSyntheticLambda1(this, provider, widgetCategories));
    }

    private /* synthetic */ void lambda$removeGeneratedPreviewsAsync$6(Provider provider, int widgetCategories) {
        SparseArray<RemoteViews> previews = loadGeneratedPreviews(provider);
        boolean changed = false;
        int[] r2 = Provider.m1891$$Nest$sfgetWIDGET_CATEGORY_FLAGS();
        int r3 = r2.length;
        int r5 = 0;
    L3:
        boolean r6 = true;
        if (r5 >= r3) goto L13;
        int flag = r2[r5];
        if ((widgetCategories & flag) == 0) goto L12;
        if (previews.removeReturnOld(flag) != null) goto L11;
        r6 = false;
    L11:
        changed = changed | r6;
    L12:
        r5 = r5 + 1;
        goto L3
    L13:
        if (changed == false) goto L19;
        saveGeneratedPreviews(provider, previews, true);
        return;
    }

    private boolean clearGeneratedPreviewsAsync(final Provider provider) {
        this.mSavePreviewsHandler.post(new AppWidgetServiceImpl$$ExternalSyntheticLambda6(this, provider));
        if (provider.info.generatedPreviewCategories == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ void lambda$clearGeneratedPreviewsAsync$7(Provider provider) {
        saveGeneratedPreviews(provider, null, false);
    }

    private void checkSavePreviewsThread() {
        if (DEBUG == true) goto L5;
        return;
    L5:
        if (this.mSavePreviewsHandler.getLooper().isCurrentThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Only modify previews on the background thread");
    }

    private SparseArray<RemoteViews> loadGeneratedPreviews(Provider provider) {
        checkSavePreviewsThread();
        AtomicFile previewsFile = getWidgetPreviewsFile(provider);     // Catch: Exception -> L7
        if (previewsFile.exists() == false) goto L6;
        ProtoInputStream input = new ProtoInputStream(previewsFile.readFully());     // Catch: Exception -> L7
        SparseArray<RemoteViews> entries = readGeneratedPreviewsFromProto(input);     // Catch: Exception -> L7
        SparseArray<RemoteViews> singleCategoryKeyedEntries = new SparseArray();     // Catch: Exception -> L7
        int i = 0;
    L11:
        if (i >= entries.size()) goto L20;
        int widgetCategories = entries.keyAt(i);     // Catch: Exception -> L7
        RemoteViews preview = entries.valueAt(i);     // Catch: Exception -> L7
        int[] r7 = Provider.m1891$$Nest$sfgetWIDGET_CATEGORY_FLAGS();     // Catch: Exception -> L7
        int r8 = r7.length;     // Catch: Exception -> L7
        int r9 = 0;
    L13:
        if (r9 >= r8) goto L18;
        int flag = r7[r9];     // Catch: Exception -> L7
        if ((widgetCategories & flag) == 0) goto L17;
        singleCategoryKeyedEntries.put(flag, preview);     // Catch: Exception -> L7
    L17:
        r9 = r9 + 1;
        goto L13
    L18:
        i = i + 1;
        goto L11
    L20:
        return singleCategoryKeyedEntries;
    L6:
        return new SparseArray();
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to load generated previews for " + provider, e);
        return new SparseArray();
    }

    private void loadGeneratedPreviewCategoriesLocked(int profileId) throws IOException {
        Iterator<Provider> r1 = this.mProviders.iterator();
    L4:
        if (r1.hasNext() == false) goto L20;
        Provider provider = r1.next();
        if (provider.id.getProfile().getIdentifier() != profileId) goto L4;
        AtomicFile previewsFile = getWidgetPreviewsFile(provider);
        if (previewsFile.exists() == false) goto L4;
        ProtoInputStream input = new ProtoInputStream(previewsFile.readFully());
        provider.info.generatedPreviewCategories = readGeneratedPreviewCategoriesFromProto(input);     // Catch: Exception -> L14
    L17:
        if (DEBUG == false) goto L4;
        Slog.i(TAG, TextUtils.formatSimple("loadGeneratedPreviewCategoriesLocked %d %s categories %d", new Object[]{Integer.valueOf(profileId), provider, Integer.valueOf(provider.info.generatedPreviewCategories)}));
    L14:
        e = move-exception;
        Slog.e(TAG, "Failed to read generated previews from file for " + provider, e);
        previewsFile.delete();
        provider.info.generatedPreviewCategories = 0;
        goto L17
    }

    private void saveGeneratedPreviews(Provider provider, SparseArray<RemoteViews> previews, boolean notify) {
        checkSavePreviewsThread();
        AtomicFile file = null;
        FileOutputStream stream = null;
        file = getWidgetPreviewsFile(provider);     // Catch: Exception -> L11
        if (previews == null) goto L15;
        if (previews.size() == 0) goto L15;
        if (DEBUG == false) goto L13;
        Slog.i(TAG, "Writing widget preview file " + file);     // Catch: Exception -> L11
    L13:
        ProtoOutputStream out = new ProtoOutputStream();     // Catch: Exception -> L11
        writePreviewsToProto(out, previews);     // Catch: Exception -> L11
        stream = file.startWrite();     // Catch: Exception -> L11
        stream.write(out.getBytes());     // Catch: Exception -> L11
        file.finishWrite(stream);     // Catch: Exception -> L11
    L20:
        Object r2 = this.mLock;     // Catch: Exception -> L11
        monitor-enter(r2);     // Catch: Exception -> L11
        Provider.m1890$$Nest$mupdateGeneratedPreviewCategoriesLocked(provider, previews);     // Catch: Throwable -> L25
        if (notify == false) goto L27;
        scheduleNotifyGroupHostsForProvidersChangedLocked(provider.getUserId());     // Catch: Throwable -> L25
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L25
        goto L32
    L40:
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Exception -> L11
    L15:
        if (file.exists() == false) goto L20;
        if (DEBUG == false) goto L19;
        Slog.i(TAG, "Deleting widget preview file " + file);     // Catch: Exception -> L11
    L19:
        file.delete();     // Catch: Exception -> L11
    L32:
        if (file == null) goto L35;
        if (stream == null) goto L35;
        file.failWrite(stream);
    L35:
        Slog.w(TAG, "Failed to save widget previews for provider " + provider.id.componentName);
    }

    private void writePreviewsToProto(ProtoOutputStream out, SparseArray<RemoteViews> generatedPreviews) {
        SparseArray<Pair<Integer, RemoteViews>> previewsToWrite = new SparseArray();
        int i = 0;
    L4:
        if (i >= generatedPreviews.size()) goto L10;
        int widgetCategory = generatedPreviews.keyAt(i);
        RemoteViews views = generatedPreviews.valueAt(i);
        if (previewsToWrite.contains(views.hashCode()) == true) goto L8;
        previewsToWrite.put(views.hashCode(), new Pair(Integer.valueOf(widgetCategory), views));
    L9:
        i = i + 1;
        goto L4
    L8:
        Pair<Integer, RemoteViews> entry = previewsToWrite.get(views.hashCode());
        previewsToWrite.put(views.hashCode(), Pair.create(Integer.valueOf(((Integer) entry.first).intValue() | widgetCategory), views));
        goto L9
    L10:
        int i2 = 0;
    L12:
        if (i2 >= previewsToWrite.size()) goto L15;
        long token = out.start(2246267895809L);
        Pair<Integer, RemoteViews> entry2 = previewsToWrite.valueAt(i2);
        out.write(2220498092033L, ((Integer) entry2.first).intValue());
        long viewsToken = out.start(1146756268034L);
        ((RemoteViews) entry2.second).writePreviewToProto(this.mContext, out);
        out.end(viewsToken);
        out.end(token);
        i2 = i2 + 1;
        goto L12
    }

    private SparseArray<RemoteViews> readGeneratedPreviewsFromProto(ProtoInputStream input) throws IOException {
        SparseArray<RemoteViews> entries = new SparseArray();
    L4:
        if (input.nextField() == (-1)) goto L9;
        switch(input.getFieldNumber()) {
            case 1: goto L8;
            default: goto L7;
        };
    L8:
        long token = input.start(2246267895809L);
        Pair<Integer, RemoteViews> entry = readSinglePreviewFromProto(input, false);
        entries.put(((Integer) entry.first).intValue(), (RemoteViews) entry.second);
        input.end(token);
        goto L4
    L7:
        Slog.w(TAG, "Unknown field while reading GeneratedPreviewsProto! " + ProtoUtils.currentFieldToString(input));
        goto L4
    L9:
        return entries;
    }

    private int readGeneratedPreviewCategoriesFromProto(ProtoInputStream input) throws IOException {
        int widgetCategories = 0;
    L4:
        if (input.nextField() == (-1)) goto L9;
        switch(input.getFieldNumber()) {
            case 1: goto L8;
            default: goto L7;
        };
    L8:
        long token = input.start(2246267895809L);
        Pair<Integer, RemoteViews> entry = readSinglePreviewFromProto(input, true);
        widgetCategories = widgetCategories | ((Integer) entry.first).intValue();
        input.end(token);
        goto L4
    L7:
        Slog.w(TAG, "Unknown field while reading GeneratedPreviewsProto! " + ProtoUtils.currentFieldToString(input));
        goto L4
    L9:
        return widgetCategories;
    }

    private Pair<Integer, RemoteViews> readSinglePreviewFromProto(ProtoInputStream input, boolean skipViews) throws IOException {
        int widgetCategories = 0;
        RemoteViews views = null;
    L4:
        if (input.nextField() == (-1)) goto L18;
        switch(input.getFieldNumber()) {
            case 1: goto L16;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        if (skipViews == true) goto L4;
        long token = input.start(1146756268034L);
        RemoteViews views2 = RemoteViews.createPreviewFromProto(this.mContext, input);     // Catch: Exception -> L13
        views = views2;
    L15:
        input.end(token);
    L13:
        e = move-exception;
        Slog.e(TAG, "Unable to deserialize RemoteViews", e);
        goto L15
    L16:
        widgetCategories = input.readInt(2220498092033L);
        goto L4
    L7:
        Slog.w(TAG, "Unknown field while reading GeneratedPreviewsProto! " + ProtoUtils.currentFieldToString(input));
        goto L4
    L18:
        return Pair.create(Integer.valueOf(widgetCategories), views);
    }

    private static AtomicFile getWidgetPreviewsFile(Provider provider) throws IOException {
        int userId = provider.getUserId();
        File previewsDirectory = getWidgetPreviewsDirectory(userId);
        File providerPreviews = Environment.buildPath(previewsDirectory, new String[]{TextUtils.formatSimple("%s-%s-%d.binpb", new Object[]{provider.id.componentName.getPackageName(), provider.id.componentName.getClassName(), Integer.valueOf(provider.id.uid)})});
        return new AtomicFile(providerPreviews);
    }

    private static File getWidgetPreviewsDirectory(int userId) throws IOException {
        File dataSystemCeDirectory = Environment.getDataSystemCeDirectory(userId);
        File previewsDirectory = Environment.buildPath(dataSystemCeDirectory, new String[]{APPWIDGET_CE_DATA_DIRNAME, WIDGET_PREVIEWS_DIRNAME});
        if (previewsDirectory.exists() == false) goto L5;
    L9:
        return previewsDirectory;
    L5:
        if (previewsDirectory.mkdirs() == true) goto L9;
        throw new IOException("Unable to create widget preview directory " + previewsDirectory.getPath());
    }

    private static void ensureWidgetCategoryCombinationIsValid(int widgetCategories) {
        int invalid = ~7;
        if ((widgetCategories & invalid) != 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(widgetCategories + " is not a valid widget category combination");
    }

    private void handleSystemUiDeviceConfigChange(DeviceConfig.Properties properties) {
        Set<String> changed = properties.getKeyset();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (changed.contains("generated_preview_api_reset_interval_ms") == false) goto L10;
        long resetIntervalMs = properties.getLong("generated_preview_api_reset_interval_ms", this.mGeneratedPreviewsApiCounter.getResetIntervalMs());     // Catch: Throwable -> L7
        this.mGeneratedPreviewsApiCounter.setResetIntervalMs(resetIntervalMs);     // Catch: Throwable -> L7
    L10:
        if (changed.contains("generated_preview_api_max_calls_per_interval") == false) goto L13;
        int maxCallsPerInterval = properties.getInt("generated_preview_api_max_calls_per_interval", this.mGeneratedPreviewsApiCounter.getMaxCallsPerInterval());     // Catch: Throwable -> L7
        this.mGeneratedPreviewsApiCounter.setMaxCallsPerInterval(maxCallsPerInterval);     // Catch: Throwable -> L7
    L13:
        if (changed.contains("generated_preview_api_max_providers") == false) goto L15;
        int maxProviders = properties.getInt("generated_preview_api_max_providers", this.mGeneratedPreviewsApiCounter.getMaxProviders());     // Catch: Throwable -> L7
        this.mGeneratedPreviewsApiCounter.setMaxProviders(maxProviders);     // Catch: Throwable -> L7
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L7
    }
}
