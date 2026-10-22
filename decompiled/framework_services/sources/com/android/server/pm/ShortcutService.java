package com.android.server.pm;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AppGlobals;
import android.app.IUidObserver;
import android.app.IUriGrantsManager;
import android.app.UidObserver;
import android.app.UriGrantsManager;
import android.app.role.OnRoleHoldersChangedListener;
import android.app.role.RoleManager;
import android.app.usage.UsageStatsManagerInternal;
import android.appwidget.AppWidgetProviderInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.IPackageManager;
import android.content.pm.IShortcutService;
import android.content.pm.LauncherApps;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.pm.ShortcutServiceInternal;
import android.content.pm.UserPackage;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SELinux;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.text.TextUtils;
import android.text.format.TimeMigrationUtils;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.KeyValueListParser;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.IWindowManager;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.internal.util.StatLogger;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.uri.UriGrantsManagerInternal;
import com.obric.utils.ObricImplFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutService extends IShortcutService.Stub {
    private static final Predicate<ResolveInfo> ACTIVITY_NOT_EXPORTED = null;
    private static final Predicate<ResolveInfo> ACTIVITY_NOT_INSTALLED = null;
    private static final String ATTR_VALUE = "value";
    private static final long CALLBACK_DELAY = 100;
    static final boolean DEBUG = false;
    static final boolean DEBUG_LOAD = false;
    static final boolean DEBUG_PROCSTATE = false;
    static final boolean DEBUG_REBOOT = false;
    static final String DEFAULT_ICON_PERSIST_FORMAT = null;
    static final int DEFAULT_ICON_PERSIST_QUALITY = 100;
    static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    static final int DEFAULT_MAX_SHORTCUTS_PER_ACTIVITY = 15;
    static final int DEFAULT_MAX_SHORTCUTS_PER_APP = 100;
    static final int DEFAULT_MAX_UPDATES_PER_INTERVAL = 10;
    static final long DEFAULT_RESET_INTERVAL_SEC = 86400;
    static final int DEFAULT_SAVE_DELAY_MS = 3000;
    static final String DIRECTORY_BITMAPS = "bitmaps";
    static final String DIRECTORY_DUMP = "shortcut_dump";
    static final String DIRECTORY_PER_USER = "shortcut_service";
    private static final String DUMMY_MAIN_ACTIVITY = "android.__dummy__";
    private static final List<ResolveInfo> EMPTY_RESOLVE_INFO = null;
    static final String FILENAME_BASE_STATE = "shortcut_service.xml";
    static final String FILENAME_USER_PACKAGES = "shortcuts.xml";
    static final String FILENAME_USER_PACKAGES_RESERVE_COPY = "shortcuts.xml.reservecopy";
    private static final String KEY_ICON_SIZE = "iconSize";
    private static final String KEY_LOW_RAM = "lowRam";
    private static final String KEY_SHORTCUT = "shortcut";
    private static final String LAUNCHER_INTENT_CATEGORY = "android.intent.category.LAUNCHER";
    static final int OPERATION_ADD = 1;
    static final int OPERATION_SET = 0;
    static final int OPERATION_UPDATE = 2;
    private static final int PACKAGE_MATCH_FLAGS = 795136;
    private static final Predicate<PackageInfo> PACKAGE_NOT_INSTALLED = null;
    private static final int PROCESS_STATE_FOREGROUND_THRESHOLD = 5;
    private static final int SYSTEM_APP_MASK = 129;
    static final String TAG = "ShortcutService";
    private static final String TAG_LAST_RESET_TIME = "last_reset_time";
    private static final String TAG_ROOT = "root";
    private final ActivityManagerInternal mActivityManagerInternal;
    private final AtomicBoolean mBootCompleted;
    private ComponentName mChooserActivity;
    final Context mContext;
    private List<Integer> mDirtyUserIds;
    private IExtShortcutService mExt;
    private final Handler mHandler;
    private final IPackageManager mIPackageManager;
    private Bitmap.CompressFormat mIconPersistFormat;
    private int mIconPersistQuality;
    private int mLastLockedUser;
    private Exception mLastWtfStacktrace;
    private final ArrayList<ShortcutServiceInternal.ShortcutChangeListener> mListeners;
    private int mMaxIconDimension;
    private int mMaxShortcuts;
    private int mMaxShortcutsPerApp;
    int mMaxUpdatesPerInterval;
    private final MetricsLogger mMetricsLogger;
    private final Object mNonPersistentUsersLock;
    private IObricShortcutService mObricExt;
    private final OnRoleHoldersChangedListener mOnRoleHoldersChangedListener;
    private final PackageManagerInternal mPackageManagerInternal;
    final BroadcastReceiver mPackageMonitor;
    private final AtomicLong mRawLastResetTime;
    final BroadcastReceiver mReceiver;
    private long mResetInterval;
    private final RoleManager mRoleManager;
    int mSaveDelayMillis;
    private final Runnable mSaveDirtyInfoRunner;
    final Object mServiceLock;
    private final ArrayList<LauncherApps.ShortcutChangeCallback> mShortcutChangeCallbacks;
    private final ShortcutDumpFiles mShortcutDumpFiles;
    private final SparseArray<ShortcutNonPersistentUser> mShortcutNonPersistentUsers;
    private final ShortcutRequestPinProcessor mShortcutRequestPinProcessor;
    private final AtomicBoolean mShutdown;
    private final BroadcastReceiver mShutdownReceiver;
    private final StatLogger mStatLogger;
    final SparseLongArray mUidLastForegroundElapsedTime;
    private final IUidObserver mUidObserver;
    final SparseIntArray mUidState;
    final SparseBooleanArray mUnlockedUsers;
    private final IUriGrantsManager mUriGrantsManager;
    private final UriGrantsManagerInternal mUriGrantsManagerInternal;
    private final IBinder mUriPermissionOwner;
    private final UsageStatsManagerInternal mUsageStatsManagerInternal;
    final UserManagerInternal mUserManagerInternal;
    private final SparseArray<ShortcutUser> mUsers;
    private int mWtfCount;
    private final Object mWtfLock;

    /* JADX INFO: renamed from: com.android.server.pm.ShortcutService$3, reason: invalid class name */
    class AnonymousClass3 implements OnRoleHoldersChangedListener {
        final /* synthetic */ ShortcutService this$0;

        /* JADX INFO: renamed from: $r8$lambda$Hw8F-lF39t_TP-SvXEJwSJS38k8, reason: not valid java name */
        public static /* synthetic */ void m6947$r8$lambda$Hw8FlF39t_TPSvXEJwSJS38k8(AnonymousClass3 r0, UserHandle r1) {
            r0.lambda$onRoleHoldersChanged$0(r1);
        }

        AnonymousClass3(ShortcutService this$0) {
            this.this$0 = this$0;
        }

        public void onRoleHoldersChanged(String roleName, final UserHandle user) {
            if ("android.app.role.HOME".equals(roleName) == false) goto L6;
            this.this$0.injectPostToHandler(new ShortcutService$3$$ExternalSyntheticLambda0(this, user));
            return;
        }

        private /* synthetic */ void lambda$onRoleHoldersChanged$0(UserHandle user) {
            this.this$0.handleOnDefaultLauncherChanged(user.getIdentifier());
        }
    }

    /* JADX INFO: renamed from: com.android.server.pm.ShortcutService$4, reason: invalid class name */
    class AnonymousClass4 extends UidObserver {
        final /* synthetic */ ShortcutService this$0;

        /* JADX INFO: renamed from: $r8$lambda$T38dA-CIlJpPfJ4NeUI0t9KKVrc, reason: not valid java name */
        public static /* synthetic */ void m6948$r8$lambda$T38dACIlJpPfJ4NeUI0t9KKVrc(AnonymousClass4 r0, int r1) {
            r0.lambda$onUidGone$1(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$hFVl7KreRTWPjzcQMzQwU2JU-Sg, reason: not valid java name */
        public static /* synthetic */ void m6949$r8$lambda$hFVl7KreRTWPjzcQMzQwU2JUSg(AnonymousClass4 r0, int r1, int r2) {
            r0.lambda$onUidStateChanged$0(r1, r2);
        }

        AnonymousClass4(ShortcutService this$0) {
            this.this$0 = this$0;
        }

        private /* synthetic */ void lambda$onUidStateChanged$0(int uid, int procState) {
            this.this$0.handleOnUidStateChanged(uid, procState);
        }

        public void onUidStateChanged(final int uid, final int procState, long procStateSeq, int capability) {
            this.this$0.injectPostToHandler(new ShortcutService$4$$ExternalSyntheticLambda0(this, uid, procState));
        }

        public void onUidGone(final int uid, boolean disabled) {
            this.this$0.injectPostToHandler(new ShortcutService$4$$ExternalSyntheticLambda1(this, uid));
        }

        private /* synthetic */ void lambda$onUidGone$1(int uid) {
            this.this$0.handleOnUidStateChanged(uid, 20);
        }
    }

    static class CommandException extends Exception {
        public CommandException(String message) {
            super(message);
        }
    }

    interface ConfigConstants {
        public static final String KEY_ICON_FORMAT = "icon_format";
        public static final String KEY_ICON_QUALITY = "icon_quality";
        public static final String KEY_MAX_ICON_DIMENSION_DP = "max_icon_dimension_dp";
        public static final String KEY_MAX_ICON_DIMENSION_DP_LOWRAM = "max_icon_dimension_dp_lowram";
        public static final String KEY_MAX_SHORTCUTS = "max_shortcuts";
        public static final String KEY_MAX_SHORTCUTS_PER_APP = "max_shortcuts_per_app";
        public static final String KEY_MAX_UPDATES_PER_INTERVAL = "max_updates_per_interval";
        public static final String KEY_RESET_INTERVAL_SEC = "reset_interval_sec";
        public static final String KEY_SAVE_DELAY_MILLIS = "save_delay_ms";
    }

    static class DumpFilter {
        private boolean mCheckInClear;
        private boolean mDumpCheckIn;
        private boolean mDumpDetails;
        private boolean mDumpFiles;
        private boolean mDumpMain;
        private boolean mDumpUid;
        private final List<Pattern> mPackagePatterns;
        private final List<Integer> mUsers;

        DumpFilter() {
            this.mDumpCheckIn = false;
            this.mCheckInClear = false;
            this.mDumpMain = true;
            this.mDumpUid = false;
            this.mDumpFiles = false;
            this.mDumpDetails = true;
            this.mPackagePatterns = new ArrayList();
            this.mUsers = new ArrayList();
        }

        void addPackageRegex(String regex) {
            this.mPackagePatterns.add(Pattern.compile(regex));
        }

        public void addPackage(String packageName) {
            addPackageRegex(Pattern.quote(packageName));
        }

        void addUser(int userId) {
            this.mUsers.add(Integer.valueOf(userId));
        }

        boolean isPackageMatch(String packageName) {
            if (this.mPackagePatterns.size() != 0) goto L5;
            return true;
        L5:
            int i = 0;
        L7:
            if (i >= this.mPackagePatterns.size()) goto L12;
            if (this.mPackagePatterns.get(i).matcher(packageName).find() == true) goto L10;
            i = i + 1;
            goto L7
        L10:
            return true;
        L12:
            return false;
        }

        boolean isUserMatch(int userId) {
            if (this.mUsers.size() != 0) goto L5;
            return true;
        L5:
            int i = 0;
        L7:
            if (i >= this.mUsers.size()) goto L12;
            if (this.mUsers.get(i).intValue() == userId) goto L10;
            i = i + 1;
            goto L7
        L10:
            return true;
        L12:
            return false;
        }

        public boolean shouldDumpCheckIn() {
            return this.mDumpCheckIn;
        }

        public void setDumpCheckIn(boolean dumpCheckIn) {
            this.mDumpCheckIn = dumpCheckIn;
        }

        public boolean shouldCheckInClear() {
            return this.mCheckInClear;
        }

        public void setCheckInClear(boolean checkInClear) {
            this.mCheckInClear = checkInClear;
        }

        public boolean shouldDumpMain() {
            return this.mDumpMain;
        }

        public void setDumpMain(boolean dumpMain) {
            this.mDumpMain = dumpMain;
        }

        public boolean shouldDumpUid() {
            return this.mDumpUid;
        }

        public void setDumpUid(boolean dumpUid) {
            this.mDumpUid = dumpUid;
        }

        public boolean shouldDumpFiles() {
            return this.mDumpFiles;
        }

        public void setDumpFiles(boolean dumpFiles) {
            this.mDumpFiles = dumpFiles;
        }

        public boolean shouldDumpDetails() {
            return this.mDumpDetails;
        }

        public void setDumpDetails(boolean dumpDetails) {
            this.mDumpDetails = dumpDetails;
        }
    }

    static class FileOutputStreamWithPath extends FileOutputStream {
        private final File mFile;

        public FileOutputStreamWithPath(File file) throws FileNotFoundException {
            super(file);
            this.mFile = file;
        }

        public File getFile() {
            return this.mFile;
        }
    }

    static class InvalidFileFormatException extends Exception {
        public InvalidFileFormatException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static final class Lifecycle extends SystemService {
        final ShortcutService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mService = new ShortcutService(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService(ShortcutService.KEY_SHORTCUT, this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            this.mService.onBootPhase(phase);
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser user) {
            this.mService.handleStopUser(user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            this.mService.handleUnlockUser(user.getUserIdentifier());
        }
    }

    private class LocalService extends ShortcutServiceInternal {
        final /* synthetic */ ShortcutService this$0;

        public static /* synthetic */ boolean $r8$lambda$1vKeTGpxedlJ9e03WbhZmxrp6Jc(String r0, ShortcutInfo r1) {
            return lambda$getShortcutInfoLocked$2(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$3lWA6IdBBMst2VF_gQSz1s4aYQs(LocalService r0, int r1, String r2, List r3, List r4, long r5, ComponentName r7, int r8, int r9, ArrayList r10, int r11, int r12, int r13, ShortcutPackage r14) {
            r0.lambda$getShortcuts$0(r1, r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14);
        }

        /* JADX INFO: renamed from: $r8$lambda$4oN-teeezN_bMPNKBELK1aAUWLM, reason: not valid java name */
        public static /* synthetic */ boolean m6950$r8$lambda$4oNteeezN_bMPNKBELK1aAUWLM(long r0, ArraySet r2, ArraySet r3, ComponentName r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, ShortcutInfo r10) {
            return lambda$getFilterFromQuery$1(r0, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        }

        /* JADX INFO: renamed from: $r8$lambda$IBSFmVJ_VaUQlDo3h-_AspFrixU, reason: not valid java name */
        public static /* synthetic */ boolean m6951$r8$lambda$IBSFmVJ_VaUQlDo3h_AspFrixU(ShortcutInfo r0) {
            return lambda$pinShortcuts$3(r0);
        }

        /* synthetic */ LocalService(ShortcutService r1, ShortcutServiceIA r2) {
            this(r1);
        }

        private LocalService(ShortcutService r1) {
            this.this$0 = r1;
        }

        public List<ShortcutInfo> getShortcuts(final int launcherUserId, final String callingPackage, final long changedSince, String packageName, List<String> shortcutIds, final List<LocusId> locusIds, final ComponentName componentName, final int queryFlags, final int userId, final int callingPid, final int callingUid) {
            final ArrayList<ShortcutInfo> ret = new ArrayList();
            if ((queryFlags & 4) == 0) goto L6;
            int flags = 4;
        L9:
            final int cloneFlag = flags;
            if (packageName != null) goto L12;
            final List<String> shortcutIds2 = null;
        L13:
            Object r3 = this.this$0.mServiceLock;
            monitor-enter(r3);
            this.this$0.throwIfUserLockedL(userId);     // Catch: Throwable -> L33
            this.this$0.throwIfUserLockedL(launcherUserId);     // Catch: Throwable -> L33
            this.this$0.getLauncherShortcutsLocked(callingPackage, userId, launcherUserId).attemptToRestoreIfNeededAndSave();     // Catch: Throwable -> L33
            if (packageName == null) goto L22;
            Object r17 = r3;
            getShortcutsInnerLocked(launcherUserId, callingPackage, packageName, shortcutIds2, locusIds, changedSince, componentName, queryFlags, userId, ret, cloneFlag, callingPid, callingUid);     // Catch: Throwable -> L20
            ret = ret;
        L26:
            monitor-exit(r17);     // Catch: Throwable -> L29
            return ShortcutService.m6944$$Nest$msetReturnedByServer(this.this$0, ret);
        L20:
            th = th;
        L35:
            monitor-exit(r17);     // Catch: Throwable -> L29
            throw th;
        L22:
            r17 = r3;
            this.this$0.getUserShortcutsLocked(userId).forAllPackages(new ShortcutService$LocalService$$ExternalSyntheticLambda2(this, launcherUserId, callingPackage, shortcutIds2, locusIds, changedSince, componentName, queryFlags, userId, ret, cloneFlag, callingPid, callingUid));     // Catch: Throwable -> L29
        L31:
            th = th;
        L33:
            th = th;
            r17 = r3;
        L29:
            th = th;
            goto L35
        L12:
            shortcutIds2 = shortcutIds;
            goto L13
        L6:
            if ((queryFlags & 2048) == 0) goto L8;
            int flags2 = 27 & (-17);
            flags = flags2;
            goto L9
        L8:
            flags = 27;
            goto L9
        }

        private /* synthetic */ void lambda$getShortcuts$0(int launcherUserId, String callingPackage, List shortcutIdsF, List locusIdsF, long changedSince, ComponentName componentName, int queryFlags, int userId, ArrayList ret, int cloneFlag, int callingPid, int callingUid, ShortcutPackage p) {
            getShortcutsInnerLocked(launcherUserId, callingPackage, p.getPackageName(), shortcutIdsF, locusIdsF, changedSince, componentName, queryFlags, userId, ret, cloneFlag, callingPid, callingUid);
        }

        private void getShortcutsInnerLocked(int launcherUserId, String callingPackage, String packageName, List<String> shortcutIds, List<LocusId> locusIds, long changedSince, ComponentName componentName, int queryFlags, int userId, ArrayList<ShortcutInfo> ret, int cloneFlag, int callingPid, int callingUid) {
            if (shortcutIds != null) goto L5;
            ArraySet<String> ids = null;
        L6:
            ShortcutUser user = this.this$0.getUserShortcutsLocked(userId);
            ShortcutPackage p = user.getPackageShortcutsIfExists(packageName);
            if (p != null) goto L9;
            return;
        L9:
            boolean canAccessAllShortcuts = this.this$0.canSeeAnyPinnedShortcut(callingPackage, launcherUserId, callingPid, callingUid);
            int r3 = 0;
            if (canAccessAllShortcuts == true) goto L12;
        L14:
            boolean getPinnedByAnyLauncher = false;
        L15:
            if (getPinnedByAnyLauncher == false) goto L17;
            r3 = 2;
        L17:
            Predicate<ShortcutInfo> filter = getFilterFromQuery(ids, locusIds, changedSince, componentName, queryFlags | r3, getPinnedByAnyLauncher);
            p.findAll(ret, filter, cloneFlag, callingPackage, launcherUserId, getPinnedByAnyLauncher);
            return;
        L12:
            if ((queryFlags & 1024) == 0) goto L14;
            getPinnedByAnyLauncher = true;
            goto L15
        L5:
            ids = new ArraySet(shortcutIds);
            goto L6
        }

        private Predicate<ShortcutInfo> getFilterFromQuery(final ArraySet<String> ids, List<LocusId> locusIds, final long changedSince, final ComponentName componentName, int queryFlags, final boolean getPinnedByAnyLauncher) {
            if (locusIds != null) goto L4;
            ArraySet<LocusId> r0 = null;
        L5:
            final ArraySet<LocusId> locIds = r0;
            if ((queryFlags & 1) == 0) goto L8;
            final boolean matchDynamic = true;
        L10:
            if ((queryFlags & 2) == 0) goto L12;
            final boolean matchPinned = true;
        L14:
            if ((queryFlags & 8) == 0) goto L16;
            final boolean matchManifest = true;
        L18:
            if ((queryFlags & 16) == 0) goto L20;
            final boolean matchCached = true;
        L22:
            return new ShortcutService$LocalService$$ExternalSyntheticLambda3(changedSince, ids, locIds, componentName, matchDynamic, matchPinned, getPinnedByAnyLauncher, matchManifest, matchCached);
        L20:
            matchCached = false;
            goto L22
        L16:
            matchManifest = false;
            goto L18
        L12:
            matchPinned = false;
            goto L14
        L8:
            matchDynamic = false;
            goto L10
        L4:
            r0 = new ArraySet(locusIds);
            goto L5
        }

        private static /* synthetic */ boolean lambda$getFilterFromQuery$1(long changedSince, ArraySet ids, ArraySet locIds, ComponentName componentName, boolean matchDynamic, boolean matchPinned, boolean getPinnedByAnyLauncher, boolean matchManifest, boolean matchCached, ShortcutInfo si) {
            if (si.getLastChangedTimestamp() >= changedSince) goto L5;
            return false;
        L5:
            if (ids != null) goto L7;
        L9:
            if (locIds != null) goto L11;
        L13:
            if (componentName == null) goto L20;
            if (si.getActivity() == null) goto L20;
            if (si.getActivity().equals(componentName) == true) goto L20;
            return false;
        L20:
            if (matchDynamic == true) goto L22;
        L24:
            if (matchPinned == true) goto L27;
            if (getPinnedByAnyLauncher == true) goto L27;
        L29:
            if (matchManifest == true) goto L31;
        L33:
            if (matchCached == true) goto L35;
        L37:
            return false;
        L35:
            if (si.isCached() == false) goto L37;
            return true;
        L31:
            if (si.isDeclaredInManifest() == false) goto L33;
            return true;
        L27:
            if (si.isPinned() == false) goto L29;
            return true;
        L22:
            if (si.isDynamic() == false) goto L24;
            return true;
        L11:
            if (locIds.contains(si.getLocusId()) == true) goto L13;
            return false;
        L7:
            if (ids.contains(si.getId()) == true) goto L9;
            return false;
        }

        public boolean isPinnedByCaller(int launcherUserId, String callingPackage, String packageName, String shortcutId, int userId) {
            Preconditions.checkStringNotEmpty(packageName, "packageName");
            Preconditions.checkStringNotEmpty(shortcutId, "shortcutId");
            Object r1 = this.this$0.mServiceLock;
            monitor-enter(r1);
            this.this$0.throwIfUserLockedL(userId);     // Catch: Throwable -> L16
            this.this$0.throwIfUserLockedL(launcherUserId);     // Catch: Throwable -> L16
            this.this$0.getLauncherShortcutsLocked(callingPackage, userId, launcherUserId).attemptToRestoreIfNeededAndSave();     // Catch: Throwable -> L16
            ShortcutInfo si = getShortcutInfoLocked(launcherUserId, callingPackage, packageName, shortcutId, userId, false);     // Catch: Throwable -> L11
            if (si != null) goto L9;
        L13:
            boolean r11 = false;
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return r11;
        L9:
            if (si.isPinned() == false) goto L13;
            r11 = true;
        L11:
            th = move-exception;
            Throwable r10 = th;
        L18:
            monitor-exit(r1);     // Catch: Throwable -> L11
            throw r10;
        L16:
            th = move-exception;
            r10 = th;
            goto L18
        }

        private ShortcutInfo getShortcutInfoLocked(int launcherUserId, String callingPackage, String packageName, final String shortcutId, int userId, boolean getPinnedByAnyLauncher) {
            Preconditions.checkStringNotEmpty(packageName, "packageName");
            Preconditions.checkStringNotEmpty(shortcutId, "shortcutId");
            this.this$0.throwIfUserLockedL(userId);
            this.this$0.throwIfUserLockedL(launcherUserId);
            ShortcutPackage p = this.this$0.getUserShortcutsLocked(userId).getPackageShortcutsIfExists(packageName);
            if (p != null) goto L5;
            return null;
        L5:
            ArrayList<ShortcutInfo> list = new ArrayList(1);
            p.findAll(list, new ShortcutService$LocalService$$ExternalSyntheticLambda1(shortcutId), 0, callingPackage, launcherUserId, getPinnedByAnyLauncher);
            if (list.size() != 0) goto L9;
            return null;
        L9:
            return list.get(0);
        }

        private static /* synthetic */ boolean lambda$getShortcutInfoLocked$2(String shortcutId, ShortcutInfo si) {
            return shortcutId.equals(si.getId());
        }

        public void pinShortcuts(int launcherUserId, String callingPackage, String packageName, List<String> shortcutIds, int userId) {
            Preconditions.checkStringNotEmpty(packageName, "packageName");
            shortcutIds.getClass();
            List<ShortcutInfo> removedShortcuts = null;
            Object r12 = this.this$0.mServiceLock;
            monitor-enter(r12);
            this.this$0.throwIfUserLockedL(userId);     // Catch: Throwable -> L12
            this.this$0.throwIfUserLockedL(launcherUserId);     // Catch: Throwable -> L12
            ShortcutLauncher launcher = this.this$0.getLauncherShortcutsLocked(callingPackage, userId, launcherUserId);     // Catch: Throwable -> L12
            launcher.attemptToRestoreIfNeededAndSave();     // Catch: Throwable -> L12
            ShortcutPackage sp = this.this$0.getUserShortcutsLocked(userId).getPackageShortcutsIfExists(packageName);     // Catch: Throwable -> L12
            if (sp == null) goto L14;
            List<ShortcutInfo> removedShortcuts2 = new ArrayList();     // Catch: Throwable -> L12
            sp.findAll(removedShortcuts2, new ShortcutService$LocalService$$ExternalSyntheticLambda0(), 4, callingPackage, launcherUserId, false);     // Catch: Throwable -> L10
            ShortcutPackage sp2 = sp;
            removedShortcuts = removedShortcuts2;
        L15:
            ArraySet<String> oldPinnedIds = launcher.getPinnedShortcutIds(packageName, userId);     // Catch: Throwable -> L12
            launcher.pinShortcuts(userId, packageName, shortcutIds, false);     // Catch: Throwable -> L12
            if (oldPinnedIds == null) goto L22;
            if (removedShortcuts == null) goto L22;
            int i = 0;
        L20:
            if (i >= removedShortcuts.size()) goto L22;
            oldPinnedIds.remove(removedShortcuts.get(i).getId());     // Catch: Throwable -> L12
            i = i + 1;     // Catch: Throwable -> L12
        L22:
            List<ShortcutInfo> changedShortcuts = ShortcutService.m6942$$Nest$mprepareChangedShortcuts(this.this$0, oldPinnedIds, new ArraySet(shortcutIds), removedShortcuts, sp2);     // Catch: Throwable -> L12
            monitor-exit(r12);     // Catch: Throwable -> L12
            if (sp2 == null) goto L26;
            this.this$0.packageShortcutsChanged(sp2, changedShortcuts, removedShortcuts);
        L26:
            this.this$0.verifyStates();
            return;
        L10:
            th = th;
        L28:
            monitor-exit(r12);     // Catch: Throwable -> L12
            throw th;
        L14:
            sp2 = sp;
        L12:
            th = th;
            goto L28
        }

        private static /* synthetic */ boolean lambda$pinShortcuts$3(ShortcutInfo si) {
            if (si.isVisibleToPublisher() == true) goto L5;
        L13:
            return false;
        L5:
            if (si.isPinned() == false) goto L13;
            if (si.isCached() == true) goto L13;
            if (si.isDynamic() == true) goto L13;
            if (si.isDeclaredInManifest() == true) goto L13;
            return true;
        }

        public void cacheShortcuts(int launcherUserId, String callingPackage, String packageName, List<String> shortcutIds, int userId, int cacheFlags) {
            updateCachedShortcutsInternal(launcherUserId, callingPackage, packageName, shortcutIds, userId, cacheFlags, true);
        }

        public void uncacheShortcuts(int launcherUserId, String callingPackage, String packageName, List<String> shortcutIds, int userId, int cacheFlags) {
            updateCachedShortcutsInternal(launcherUserId, callingPackage, packageName, shortcutIds, userId, cacheFlags, false);
        }

        public List<ShortcutManager.ShareShortcutInfo> getShareTargets(String callingPackage, IntentFilter intentFilter, int userId) {
            return this.this$0.getShareTargets(callingPackage, intentFilter, userId).getList();
        }

        public boolean isSharingShortcut(int callingUserId, String callingPackage, String packageName, String shortcutId, int userId, IntentFilter filter) {
            Preconditions.checkStringNotEmpty(callingPackage, "callingPackage");
            Preconditions.checkStringNotEmpty(packageName, "packageName");
            Preconditions.checkStringNotEmpty(shortcutId, "shortcutId");
            return this.this$0.isSharingShortcut(callingUserId, callingPackage, packageName, shortcutId, userId, filter);
        }

        private void updateCachedShortcutsInternal(int launcherUserId, String callingPackage, String packageName, List<String> shortcutIds, int userId, int cacheFlags, boolean doCache) {
            Preconditions.checkStringNotEmpty(packageName, "packageName");
            shortcutIds.getClass();
            if ((1610629120 & cacheFlags) == 0) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0, "invalid cacheFlags");
            List<ShortcutInfo> changedShortcuts = null;
            List<ShortcutInfo> removedShortcuts = null;
            Object r9 = this.this$0.mServiceLock;
            monitor-enter(r9);
            this.this$0.throwIfUserLockedL(userId);     // Catch: Throwable -> L57
            this.this$0.throwIfUserLockedL(launcherUserId);     // Catch: Throwable -> L55
            int idSize = shortcutIds.size();     // Catch: Throwable -> L55
            ShortcutPackage sp = this.this$0.getUserShortcutsLocked(userId).getPackageShortcutsIfExists(packageName);     // Catch: Throwable -> L55
            if (idSize == 0) goto L53;
            if (sp == null) goto L53;
            int i = 0;
        L15:
            if (i >= idSize) goto L49;
            String id = (String) Preconditions.checkStringNotEmpty(shortcutIds.get(i));     // Catch: Throwable -> L28
            ShortcutInfo si = sp.findShortcutById(id);     // Catch: Throwable -> L28
            if (si != null) goto L20;
            idSize = idSize;
        L47:
            i = i + 1;     // Catch: Throwable -> L28
            idSize = idSize;
            goto L15
        L20:
            if (doCache != si.hasFlags(cacheFlags)) goto L22;
            idSize = idSize;
            goto L47
        L22:
            if (doCache == true) goto L24;
            idSize = idSize;
            ShortcutInfo removed = null;
            si.clearFlags(cacheFlags);     // Catch: Throwable -> L28
            if (si.isDynamic() == false) goto L36;
        L38:
            if (removed != null) goto L42;
            if (changedShortcuts != null) goto L41;
            changedShortcuts = new ArrayList(1);     // Catch: Throwable -> L28
        L41:
            changedShortcuts.add(si);     // Catch: Throwable -> L28
            goto L47
        L42:
            if (removedShortcuts != null) goto L45;
            removedShortcuts = new ArrayList(1);     // Catch: Throwable -> L28
        L45:
            removedShortcuts.add(removed);     // Catch: Throwable -> L28
            goto L47
        L36:
            if (si.isCached() == true) goto L38;
            removed = sp.deleteLongLivedWithId(id, true);     // Catch: Throwable -> L28
            goto L38
        L24:
            if (si.isLongLived() == false) goto L32;
            si.addFlags(cacheFlags);     // Catch: Throwable -> L28
            if (changedShortcuts != null) goto L31;
            changedShortcuts = new ArrayList(1);     // Catch: Throwable -> L28
        L31:
            changedShortcuts.add(si);     // Catch: Throwable -> L28
            goto L47
        L32:
            idSize = idSize;
            Log.w(ShortcutService.TAG, "Only long lived shortcuts can get cached. Ignoring id " + si.getId());     // Catch: Throwable -> L28
            goto L47
        L49:
            monitor-exit(r9);     // Catch: Throwable -> L28
            this.this$0.packageShortcutsChanged(sp, changedShortcuts, removedShortcuts);
            this.this$0.verifyStates();
            return;
        L53:
            monitor-exit(r9);     // Catch: Throwable -> L28
            return;
        L55:
            th = th;
        L59:
            monitor-exit(r9);     // Catch: Throwable -> L28
            throw th;
        L28:
            th = th;
        L57:
            th = th;
            goto L59
        L5:
            r0 = false;
            goto L6
        }

        public Intent[] createShortcutIntents(int launcherUserId, String callingPackage, String packageName, String shortcutId, int userId, int callingPid, int callingUid) {
            Preconditions.checkStringNotEmpty(packageName, "packageName can't be empty");
            Preconditions.checkStringNotEmpty(shortcutId, "shortcutId can't be empty");
            Object r8 = this.this$0.mServiceLock;
            monitor-enter(r8);
            this.this$0.throwIfUserLockedL(userId);     // Catch: Throwable -> L23
            this.this$0.throwIfUserLockedL(launcherUserId);     // Catch: Throwable -> L23
            this.this$0.getLauncherShortcutsLocked(callingPackage, userId, launcherUserId).attemptToRestoreIfNeededAndSave();     // Catch: Throwable -> L23
            boolean getPinnedByAnyLauncher = this.this$0.canSeeAnyPinnedShortcut(callingPackage, launcherUserId, callingPid, callingUid);     // Catch: Throwable -> L17
            ShortcutInfo si = getShortcutInfoLocked(launcherUserId, callingPackage, packageName, shortcutId, userId, getPinnedByAnyLauncher);     // Catch: Throwable -> L17
            if (si == null) goto L19;
            if (si.isEnabled() == false) goto L19;
            if (si.isAlive() == true) goto L14;
            if (getPinnedByAnyLauncher == false) goto L19;
        L14:
            Intent[] r1 = si.getIntents();     // Catch: Throwable -> L17
            monitor-exit(r8);     // Catch: Throwable -> L17
            return r1;
        L19:
            Log.e(ShortcutService.TAG, "Shortcut " + shortcutId + " does not exist or disabled");     // Catch: Throwable -> L17
            monitor-exit(r8);     // Catch: Throwable -> L17
            return null;
        L17:
            th = th;
        L25:
            monitor-exit(r8);     // Catch: Throwable -> L17
            throw th;
        L23:
            th = th;
            goto L25
        }

        public void addListener(ShortcutServiceInternal.ShortcutChangeListener listener) {
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            ArrayList r1 = ShortcutService.m6928$$Nest$fgetmListeners(this.this$0);     // Catch: Throwable -> L7
            listener.getClass();     // Catch: Throwable -> L7
            r1.add(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void addShortcutChangeCallback(LauncherApps.ShortcutChangeCallback callback) {
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            ArrayList r1 = ShortcutService.m6931$$Nest$fgetmShortcutChangeCallbacks(this.this$0);     // Catch: Throwable -> L7
            callback.getClass();     // Catch: Throwable -> L7
            r1.add(callback);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void removeShortcutChangeCallback(LauncherApps.ShortcutChangeCallback callback) {
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            ArrayList r1 = ShortcutService.m6931$$Nest$fgetmShortcutChangeCallbacks(this.this$0);     // Catch: Throwable -> L7
            callback.getClass();     // Catch: Throwable -> L7
            r1.remove(callback);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public int getShortcutIconResId(int launcherUserId, String callingPackage, String packageName, String shortcutId, int userId) {
            callingPackage.getClass();
            packageName.getClass();
            shortcutId.getClass();
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            this.this$0.throwIfUserLockedL(userId);     // Catch: Throwable -> L8
            this.this$0.throwIfUserLockedL(launcherUserId);     // Catch: Throwable -> L8
            this.this$0.getLauncherShortcutsLocked(callingPackage, userId, launcherUserId).attemptToRestoreIfNeededAndSave();     // Catch: Throwable -> L8
            ShortcutPackage p = this.this$0.getUserShortcutsLocked(userId).getPackageShortcutsIfExists(packageName);     // Catch: Throwable -> L8
            int r2 = 0;
            if (p != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return 0;
        L10:
            ShortcutInfo shortcutInfo = p.findShortcutById(shortcutId);     // Catch: Throwable -> L8
            if (shortcutInfo != null) goto L13;
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L13:
            if (shortcutInfo.hasIconResource() == false) goto L16;
            r2 = shortcutInfo.getIconResourceId();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        public String getShortcutStartingThemeResName(int launcherUserId, String callingPackage, String packageName, String shortcutId, int userId) {
            callingPackage.getClass();
            packageName.getClass();
            shortcutId.getClass();
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            this.this$0.throwIfUserLockedL(userId);     // Catch: Throwable -> L8
            this.this$0.throwIfUserLockedL(launcherUserId);     // Catch: Throwable -> L8
            this.this$0.getLauncherShortcutsLocked(callingPackage, userId, launcherUserId).attemptToRestoreIfNeededAndSave();     // Catch: Throwable -> L8
            ShortcutPackage p = this.this$0.getUserShortcutsLocked(userId).getPackageShortcutsIfExists(packageName);     // Catch: Throwable -> L8
            String r2 = null;
            if (p != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L10:
            ShortcutInfo shortcutInfo = p.findShortcutById(shortcutId);     // Catch: Throwable -> L8
            if (shortcutInfo == null) goto L13;
            r2 = shortcutInfo.getStartingThemeResName();     // Catch: Throwable -> L8
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L8:
            th = move-exception;
            throw th;
        }

        public ParcelFileDescriptor getShortcutIconFd(int launcherUserId, String callingPackage, String packageName, String shortcutId, int userId) {
            callingPackage.getClass();
            packageName.getClass();
            shortcutId.getClass();
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            this.this$0.throwIfUserLockedL(userId);     // Catch: Throwable -> L8
            this.this$0.throwIfUserLockedL(launcherUserId);     // Catch: Throwable -> L8
            this.this$0.getLauncherShortcutsLocked(callingPackage, userId, launcherUserId).attemptToRestoreIfNeededAndSave();     // Catch: Throwable -> L8
            ShortcutPackage p = this.this$0.getUserShortcutsLocked(userId).getPackageShortcutsIfExists(packageName);     // Catch: Throwable -> L8
            if (p != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L10:
            ShortcutInfo shortcutInfo = p.findShortcutById(shortcutId);     // Catch: Throwable -> L8
            if (shortcutInfo != null) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L14:
            ParcelFileDescriptor r2 = getShortcutIconParcelFileDescriptor(p, shortcutInfo);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L8:
            th = move-exception;
            throw th;
        }

        private ParcelFileDescriptor getShortcutIconParcelFileDescriptor(ShortcutPackage p, ShortcutInfo shortcutInfo) {
            if (p == null) goto L17;
            if (shortcutInfo == null) goto L17;
            if (shortcutInfo.hasIconFile() == false) goto L17;
            String path = p.getBitmapPathMayWait(shortcutInfo);
            if (path != null) goto L18;
            Slog.w(ShortcutService.TAG, "null bitmap detected in getShortcutIconFd()");
            return null;
        L18:
            return ParcelFileDescriptor.open(new File(path), 268435456);
        L15:
            Slog.e(ShortcutService.TAG, "Icon file not found: " + path);
            return null;
        L17:
            return null;
        }

        public String getShortcutIconUri(int launcherUserId, String launcherPackage, String packageName, String shortcutId, int userId) {
            launcherPackage.getClass();
            packageName.getClass();
            shortcutId.getClass();
            Object r1 = this.this$0.mServiceLock;
            monitor-enter(r1);
            this.this$0.throwIfUserLockedL(userId);     // Catch: Throwable -> L22
            this.this$0.throwIfUserLockedL(launcherUserId);     // Catch: Throwable -> L22
            this.this$0.getLauncherShortcutsLocked(launcherPackage, userId, launcherUserId).attemptToRestoreIfNeededAndSave();     // Catch: Throwable -> L22
            ShortcutPackage p = this.this$0.getUserShortcutsLocked(userId).getPackageShortcutsIfExists(packageName);     // Catch: Throwable -> L22
            if (p != null) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L9
            return null;
        L11:
            ShortcutInfo shortcutInfo = p.findShortcutById(shortcutId);     // Catch: Throwable -> L22
            if (shortcutInfo != null) goto L17;
            monitor-exit(r1);     // Catch: Throwable -> L9
            return null;
        L17:
            String r11 = getShortcutIconUriInternal(launcherUserId, launcherPackage, packageName, shortcutInfo, userId);     // Catch: Throwable -> L20
            monitor-exit(r1);     // Catch: Throwable -> L20
            return r11;
        L9:
            th = th;
        L24:
            monitor-exit(r1);     // Catch: Throwable -> L20
            throw th;
        L20:
            th = th;
        L22:
            th = th;
            goto L24
        }

        private String getShortcutIconUriInternal(int launcherUserId, String launcherPackage, String packageName, ShortcutInfo shortcutInfo, int userId) {
            if (shortcutInfo.hasIconUri() == true) goto L5;
            return null;
        L5:
            String uri = shortcutInfo.getIconUri();
            if (uri != null) goto L9;
            Slog.w(ShortcutService.TAG, "null uri detected in getShortcutIconUri()");
            return null;
        L9:
            long token = Binder.clearCallingIdentity();
        L31:
            int packageUid = ShortcutService.m6929$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageUid(packageName, 268435456, userId);     // Catch: Throwable -> L14 Exception -> L16
            ShortcutService.m6933$$Nest$fgetmUriGrantsManager(this.this$0).grantUriPermissionFromOwner(ShortcutService.m6934$$Nest$fgetmUriPermissionOwner(this.this$0), packageUid, launcherPackage, Uri.parse(uri), 1, userId, launcherUserId);     // Catch: Throwable -> L14 Exception -> L16
            Binder.restoreCallingIdentity(token);
            return uri;
        L16:
            e = e;
        L23:
            StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L14
            r7.append("Failed to grant uri access to ");     // Catch: Throwable -> L14
            r7.append(launcherPackage);     // Catch: Throwable -> L28
            r7.append(" for ");     // Catch: Throwable -> L28
            r7.append(uri);     // Catch: Throwable -> L28
            Slog.e(ShortcutService.TAG, r7.toString(), e);     // Catch: Throwable -> L28
            Binder.restoreCallingIdentity(token);
            return null;
        L28:
            th = th;
        L29:
            Binder.restoreCallingIdentity(token);
            throw th;
        L14:
            th = th;
        L20:
            e = e;
        L18:
            th = th;
            goto L29
        }

        public boolean hasShortcutHostPermission(int launcherUserId, String callingPackage, int callingPid, int callingUid) {
            return this.this$0.hasShortcutHostPermission(callingPackage, launcherUserId, callingPid, callingUid);
        }

        public boolean areShortcutsSupportedOnHomeScreen(int userId) {
            return this.this$0.areShortcutsSupportedOnHomeScreen(userId);
        }

        public void setShortcutHostPackage(String type, String packageName, int userId) {
            this.this$0.setShortcutHostPackage(type, packageName, userId);
        }

        public boolean requestPinAppWidget(String callingPackage, AppWidgetProviderInfo appWidget, Bundle extras, IntentSender resultIntent, int userId) {
            appWidget.getClass();
            return ShortcutService.m6943$$Nest$mrequestPinItem(this.this$0, callingPackage, userId, null, appWidget, extras, resultIntent);
        }

        public boolean isRequestPinItemSupported(int callingUserId, int requestType) {
            return this.this$0.isRequestPinItemSupported(callingUserId, requestType);
        }

        public boolean isForegroundDefaultLauncher(String callingPackage, int callingUid) {
            callingPackage.getClass();
            int userId = UserHandle.getUserId(callingUid);
            String defaultLauncher = this.this$0.getDefaultLauncher(userId);
            if (defaultLauncher != null) goto L6;
            return false;
        L6:
            if (callingPackage.equals(defaultLauncher) == true) goto L8;
            return false;
        L8:
            Object r3 = this.this$0.mServiceLock;
            monitor-enter(r3);
        L14:
            th = move-exception;
            throw th;
        L11:
            if (this.this$0.isUidForegroundLocked(callingUid) == true) goto L16;
            monitor-exit(r3);     // Catch: Throwable -> L14
            return false;
        L16:
            monitor-exit(r3);     // Catch: Throwable -> L14
            return true;
        }
    }

    private class MyShellCommand extends ShellCommand {
        private int mShortcutMatchFlags;
        private int mUserId;
        final /* synthetic */ ShortcutService this$0;

        /* synthetic */ MyShellCommand(ShortcutService r1, ShortcutServiceIA r2) {
            this(r1);
        }

        private MyShellCommand(ShortcutService r1) {
            this.this$0 = r1;
            this.mUserId = 0;
            this.mShortcutMatchFlags = 15;
        }

        private void parseOptionsLocked(boolean takeUser) throws CommandException {
        L2:
            String opt = getNextOption();
            if (opt == null) goto L25;
            switch(opt.hashCode()) {
                case -1626182425: goto L11;
                case 1333469547: goto L8;
                default: goto L13;
            };
        L13:
            byte r0 = -1;
        L14:
            switch(r0) {
                case 0: goto L17;
                case 1: goto L23;
                default: goto L16;
            };
        L17:
            if (takeUser == false) goto L23;
            this.mUserId = UserHandle.parseUserArg(getNextArgRequired());
            if (this.this$0.isUserUnlockedL(this.mUserId) == true) goto L2;
            throw new CommandException("User (with userId=" + this.mUserId + ") is not running or locked");
        L16:
            throw new CommandException("Unknown option: " + opt);
        L23:
            this.mShortcutMatchFlags = Integer.parseInt(getNextArgRequired());
            goto L2
        L8:
            if (opt.equals("--user") == false) goto L13;
            r0 = 0;
            goto L14
        L11:
            if (opt.equals("--flags") == false) goto L13;
            r0 = 1;
            goto L14
        }

        public int onCommand(String cmd) {
            if (cmd == null) goto L4;
            PrintWriter pw = getOutPrintWriter();
        L12:
            e = move-exception;
            pw.println("Error: " + e.getMessage());
            return 1;
        L7:
            switch(cmd.hashCode()) {
                case -1610733672: goto L39;
                case -1117067818: goto L36;
                case -749565587: goto L33;
                case -276993226: goto L30;
                case -139706031: goto L27;
                case -76794781: goto L24;
                case 188791973: goto L21;
                case 1190495043: goto L18;
                case 1411888601: goto L15;
                case 1964247424: goto L10;
                default: goto L41;
            };     // Catch: CommandException -> L12
        L41:
            byte r2 = -1;
        L42:
            switch(r2) {
                case 0: goto L54;
                case 1: goto L53;
                case 2: goto L52;
                case 3: goto L51;
                case 4: goto L50;
                case 5: goto L49;
                case 6: goto L48;
                case 7: goto L47;
                case 8: goto L46;
                case 9: goto L45;
                default: goto L44;
            };     // Catch: CommandException -> L12
        L45:
            handleHasShortcutAccess();     // Catch: CommandException -> L12
        L55:
            pw.println("Success");
            return 0;
        L46:
            handleVerifyStates();     // Catch: CommandException -> L12
            goto L55
        L47:
            handleGetShortcuts();     // Catch: CommandException -> L12
            goto L55
        L48:
            handleClearShortcuts();     // Catch: CommandException -> L12
            goto L55
        L49:
            handleUnloadUser();     // Catch: CommandException -> L12
            goto L55
        L50:
            handleGetDefaultLauncher();     // Catch: CommandException -> L12
            goto L55
        L51:
            handleResetConfig();     // Catch: CommandException -> L12
            goto L55
        L52:
            handleOverrideConfig();     // Catch: CommandException -> L12
            goto L55
        L53:
            handleResetAllThrottling();     // Catch: CommandException -> L12
            goto L55
        L54:
            handleResetThrottling();     // Catch: CommandException -> L12
            goto L55
        L44:
            return handleDefaultCommands(cmd);
        L10:
            if (cmd.equals("reset-config") == false) goto L41;
            r2 = 3;
            goto L42
        L15:
            if (cmd.equals("unload-user") == false) goto L41;
            r2 = 5;
            goto L42
        L18:
            if (cmd.equals("get-default-launcher") == false) goto L41;
            r2 = 4;
            goto L42
        L21:
            if (cmd.equals("reset-throttling") == false) goto L41;
            r2 = 0;
            goto L42
        L24:
            if (cmd.equals("override-config") == false) goto L41;
            r2 = 2;
            goto L42
        L27:
            if (cmd.equals("reset-all-throttling") == false) goto L41;
            r2 = 1;
            goto L42
        L30:
            if (cmd.equals("get-shortcuts") == false) goto L41;
            r2 = 7;
            goto L42
        L33:
            if (cmd.equals("clear-shortcuts") == false) goto L41;
            r2 = 6;
            goto L42
        L36:
            if (cmd.equals("verify-states") == false) goto L41;
            r2 = 8;
            goto L42
        L39:
            if (cmd.equals("has-shortcut-access") == false) goto L41;
            r2 = 9;
            goto L42
        L4:
            return handleDefaultCommands(cmd);
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("Usage: cmd shortcut COMMAND [options ...]");
            pw.println();
            pw.println("cmd shortcut reset-throttling [--user USER_ID]");
            pw.println("    Reset throttling for all packages and users");
            pw.println();
            pw.println("cmd shortcut reset-all-throttling");
            pw.println("    Reset the throttling state for all users");
            pw.println();
            pw.println("cmd shortcut override-config CONFIG");
            pw.println("    Override the configuration for testing (will last until reboot)");
            pw.println();
            pw.println("cmd shortcut reset-config");
            pw.println("    Reset the configuration set with \"update-config\"");
            pw.println();
            pw.println("[Deprecated] cmd shortcut get-default-launcher [--user USER_ID]");
            pw.println("    Show the default launcher");
            pw.println("    Note: This command is deprecated. Callers should query the default launcher from RoleManager instead.");
            pw.println();
            pw.println("cmd shortcut unload-user [--user USER_ID]");
            pw.println("    Unload a user from the memory");
            pw.println("    (This should not affect any observable behavior)");
            pw.println();
            pw.println("cmd shortcut clear-shortcuts [--user USER_ID] PACKAGE");
            pw.println("    Remove all shortcuts from a package, including pinned shortcuts");
            pw.println();
            pw.println("cmd shortcut get-shortcuts [--user USER_ID] [--flags FLAGS] PACKAGE");
            pw.println("    Show the shortcuts for a package that match the given flags");
            pw.println();
            pw.println("cmd shortcut has-shortcut-access [--user USER_ID] PACKAGE");
            pw.println("    Prints \"true\" if the package can access shortcuts, \"false\" otherwise");
            pw.println();
        }

        private void handleResetThrottling() throws CommandException {
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            parseOptionsLocked(true);     // Catch: Throwable -> L8
            Slog.i("ShellCommand", "cmd: handleResetThrottling: userId=" + this.mUserId);     // Catch: Throwable -> L8
            this.this$0.resetThrottlingInner(this.mUserId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void handleResetAllThrottling() {
            Slog.i("ShellCommand", "cmd: handleResetAllThrottling");
            this.this$0.resetAllThrottlingInner();
        }

        private void handleOverrideConfig() throws CommandException {
            String config = getNextArgRequired();
            Slog.i("ShellCommand", "cmd: handleOverrideConfig: " + config);
            Object r1 = this.this$0.mServiceLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.updateConfigurationLocked(config) == false) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L11:
            throw new CommandException("override-config failed.  See logcat for details.");     // Catch: Throwable -> L8
        }

        private void handleResetConfig() {
            Slog.i("ShellCommand", "cmd: handleResetConfig");
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            ShortcutService.m6941$$Nest$mloadConfigurationLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void handleGetDefaultLauncher() throws CommandException {
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            parseOptionsLocked(true);     // Catch: Throwable -> L13
            String defaultLauncher = this.this$0.getDefaultLauncher(this.mUserId);     // Catch: Throwable -> L13
            if (defaultLauncher == null) goto L19;
            List<ResolveInfo> allHomeCandidates = new ArrayList();     // Catch: Throwable -> L13
            ShortcutService.m6929$$Nest$fgetmPackageManagerInternal(this.this$0).getHomeActivitiesAsUser(allHomeCandidates, this.this$0.getParentOrSelfUserId(this.mUserId));     // Catch: Throwable -> L13
            Iterator<ResolveInfo> r3 = allHomeCandidates.iterator();     // Catch: Throwable -> L13
        L9:
            if (r3.hasNext() == false) goto L16;
            ResolveInfo ri = r3.next();     // Catch: Throwable -> L13
            ComponentInfo ci = ri.getComponentInfo();     // Catch: Throwable -> L13
            if (ci.packageName.equals(defaultLauncher) == false) goto L9;
            getOutPrintWriter().println("Launcher: " + ci.getComponentName());     // Catch: Throwable -> L13
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L19:
            throw new CommandException("Failed to get the default launcher for userId=" + this.mUserId);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        private void handleUnloadUser() throws CommandException {
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            parseOptionsLocked(true);     // Catch: Throwable -> L8
            Slog.i("ShellCommand", "cmd: handleUnloadUser: userId=" + this.mUserId);     // Catch: Throwable -> L8
            this.this$0.handleStopUser(this.mUserId);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void handleClearShortcuts() throws CommandException {
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            parseOptionsLocked(true);     // Catch: Throwable -> L8
            String packageName = getNextArgRequired();     // Catch: Throwable -> L8
            Slog.i("ShellCommand", "cmd: handleClearShortcuts: userId=" + this.mUserId + ", " + packageName);     // Catch: Throwable -> L8
            ShortcutService.m6935$$Nest$mcleanUpPackageForAllLoadedUsers(this.this$0, packageName, this.mUserId, true);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void handleGetShortcuts() throws CommandException {
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            parseOptionsLocked(true);     // Catch: Throwable -> L9
            String packageName = getNextArgRequired();     // Catch: Throwable -> L9
            Slog.i("ShellCommand", "cmd: handleGetShortcuts: userId=" + this.mUserId + ", flags=" + this.mShortcutMatchFlags + ", package=" + packageName);     // Catch: Throwable -> L9
            ShortcutUser user = this.this$0.getUserShortcutsLocked(this.mUserId);     // Catch: Throwable -> L9
            ShortcutPackage p = user.getPackageShortcutsIfExists(packageName);     // Catch: Throwable -> L9
            if (p != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            p.dumpShortcuts(getOutPrintWriter(), this.mShortcutMatchFlags);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private void handleVerifyStates() throws CommandException {
            ShortcutService.m6945$$Nest$mverifyStatesForce(this.this$0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new CommandException(th.getMessage() + "\n" + Log.getStackTraceString(th));
        }

        private void handleHasShortcutAccess() throws CommandException {
            Object r0 = this.this$0.mServiceLock;
            monitor-enter(r0);
            parseOptionsLocked(true);     // Catch: Throwable -> L8
            String packageName = getNextArgRequired();     // Catch: Throwable -> L8
            boolean shortcutAccess = this.this$0.hasShortcutHostPermissionInner(packageName, this.mUserId);     // Catch: Throwable -> L8
            getOutPrintWriter().println(Boolean.toString(shortcutAccess));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface ShortcutOperation {
    }

    interface Stats {
        public static final int ASYNC_PRELOAD_USER_DELAY = 15;
        public static final int CHECK_LAUNCHER_ACTIVITY = 12;
        public static final int CHECK_PACKAGE_CHANGES = 8;
        public static final int CLEANUP_DANGLING_BITMAPS = 5;
        public static final int COUNT = 17;
        public static final int GET_ACTIVITY_WITH_METADATA = 6;
        public static final int GET_APPLICATION_INFO = 3;
        public static final int GET_APPLICATION_RESOURCES = 9;
        public static final int GET_DEFAULT_HOME = 0;
        public static final int GET_DEFAULT_LAUNCHER = 16;
        public static final int GET_INSTALLED_PACKAGES = 7;
        public static final int GET_LAUNCHER_ACTIVITY = 11;
        public static final int GET_PACKAGE_INFO = 1;
        public static final int GET_PACKAGE_INFO_WITH_SIG = 2;
        public static final int IS_ACTIVITY_ENABLED = 13;
        public static final int LAUNCHER_PERMISSION_CHECK = 4;
        public static final int PACKAGE_UPDATE_CHECK = 14;
        public static final int RESOURCE_NAME_LOOKUP = 10;
    }

    /* JADX INFO: renamed from: $r8$lambda$-E1nysez3ca4jqkVa2zpUFyw0fs, reason: not valid java name */
    public static /* synthetic */ void m6919$r8$lambda$E1nysez3ca4jqkVa2zpUFyw0fs(ShortcutService r0, PrintWriter r1) {
        r0.dumpInner(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$61TIRCuL1wUrrMGCNk9WZpdxEkE(ShortcutInfo r0) {
        return lambda$removeAllDynamicShortcuts$6(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$7rv-mE0g49gCi8ScAXXEokztNMo, reason: not valid java name */
    public static /* synthetic */ void m6920$r8$lambda$7rvmE0g49gCi8ScAXXEokztNMo(ShortcutService r0, long r1, int r3) {
        r0.lambda$handleUnlockUser$1(r1, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$BCG7wYfoamZWapUkJ17fb20DLlA(ShortcutInfo r0) {
        return lambda$setDynamicShortcuts$4(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$BDhOaAE5veHHQ_RtN3GY5v87JoE(ShortcutService r0, int r1, ResolveInfo r2) {
        return r0.lambda$queryActivities$16(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$BDxZ_1YwzWEheF3kjK2n5LrPnRU(ShortcutService r0, List r1, IntentFilter r2, String r3, int r4, ShortcutPackage r5) {
        r0.lambda$getShareTargets$8(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$BXpYW6JLpxMgYlNW13u6mZcsO8Y(ShortcutPackage r0) {
        lambda$cleanUpPackageLocked$11(r0);
    }

    public static /* synthetic */ void $r8$lambda$CzW6B410aSiUluhiotmG85cxivQ(ShortcutService r0, ShortcutUser r1, int r2, ApplicationInfo r3) {
        r0.lambda$rescanUpdatedPackagesLocked$15(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$DlBIYEfBVRLfkQ03O4yixRwEygU(ShortcutUser r0) {
        lambda$verifyStatesInner$22(r0);
    }

    public static /* synthetic */ void $r8$lambda$Gp6lYzP9L65qAz8A5TC9EjAJ1ts(ShortcutLauncher r0) {
        lambda$getBackupPayload$19(r0);
    }

    public static /* synthetic */ void $r8$lambda$IoL_G5_KwdQvp9KXUZYf4p8p0fk(ShortcutUser r0) {
        lambda$handleLocaleChanged$13(r0);
    }

    public static /* synthetic */ void $r8$lambda$J6T1wdAzRJXSyM3Fjbs4z0aR2q4(ShortcutService r0, ArrayList r1, ShortcutPackageItem r2) {
        r0.lambda$checkPackageChanges$14(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$K2dzQYNWodhYB27Myr1Hyurt2o0(ShortcutPackageItem r0) {
        lambda$getBackupPayload$17(r0);
    }

    public static /* synthetic */ void $r8$lambda$M9E5LXGmqQU_FuTZqJApwfvH5q8(ShortcutService r0, PrintWriter r1) {
        r0.lambda$applyRestore$21(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$OT1gy-r1XI1AcqPkxBE6bA-3JDI, reason: not valid java name */
    public static /* synthetic */ void m6921$r8$lambda$OT1gyr1XI1AcqPkxBE6bA3JDI(String r0, int r1, ShortcutLauncher r2) {
        lambda$cleanUpPackageLocked$10(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$PNh5C8HPIJGGYj6-U9dEpCWj8E4, reason: not valid java name */
    public static /* synthetic */ boolean m6922$r8$lambda$PNh5C8HPIJGGYj6U9dEpCWj8E4(ResolveInfo r0) {
        return lambda$static$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Q5ys-_m9LbhZnQo_7uWuak9XcIk, reason: not valid java name */
    public static /* synthetic */ boolean m6923$r8$lambda$Q5ys_m9LbhZnQo_7uWuak9XcIk(ArraySet r0, ShortcutInfo r1) {
        return lambda$prepareChangedShortcuts$24(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$RUlLlnUg5syr8aZSEgTeiZDnNHs(ShortcutUser r0) {
        lambda$waitForBitmapSavesForTest$23(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Zij-lBJYti-Z-g19IgeM2QkrCSE, reason: not valid java name */
    public static /* synthetic */ void m6924$r8$lambda$ZijlBJYtiZg19IgeM2QkrCSE(ShortcutPackage r0) {
        lambda$cleanUpPackageLocked$12(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$hXF1tAhocIYzRidHQjMNDaLAFgo(ArraySet r0, ShortcutInfo r1) {
        return lambda$prepareChangedShortcuts$25(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$jT1w2NJ8bhvhswF4usDaQXve8UI(ShortcutService r0, ShortcutInfo r1, ShortcutPackage r2, List r3, ShortcutInfo r4) {
        r0.lambda$updateShortcuts$5(r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean $r8$lambda$oAuz6Jx9DGNsylPaIk0ujMg1HAA(int r0, ShortcutInfo r1) {
        return lambda$getShortcuts$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$oaxWGXDC09-WZHQxMkQPKUPQDLM, reason: not valid java name */
    public static /* synthetic */ void m6925$r8$lambda$oaxWGXDC09WZHQxMkQPKUPQDLM(ShortcutService r0, PrintWriter r1) {
        r0.lambda$applyRestore$20(r1);
    }

    public static /* synthetic */ void $r8$lambda$qmXsSrkG1sY5mQZKbh8vonwJC94(ShortcutService r0, int r1, List r2, String r3, UserHandle r4, List r5) {
        r0.lambda$notifyShortcutChangeCallbacks$3(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$tvgGiYIbVUCKNZ5q7o59yPOY6TY(ShortcutService r0, String r1, int r2, boolean r3, ShortcutUser r4) {
        r0.lambda$cleanUpPackageForAllLoadedUsers$9(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$uge0gpNvAfaUqAiwpXWh5esRT9o(ShortcutPackage r0) {
        lambda$getBackupPayload$18(r0);
    }

    public static /* synthetic */ void $r8$lambda$yKU4jgBsUzyszwnIVxSwO_MEiaM(ShortcutService r0, int r1, String r2) {
        r0.lambda$notifyListenerRunnable$2(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m6926$$Nest$fgetmBootCompleted(ShortcutService r0) {
        return r0.mBootCompleted;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6927$$Nest$fgetmHandler(ShortcutService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m6928$$Nest$fgetmListeners(ShortcutService r0) {
        return r0.mListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m6929$$Nest$fgetmPackageManagerInternal(ShortcutService r0) {
        return r0.mPackageManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSaveDirtyInfoRunner, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m6930$$Nest$fgetmSaveDirtyInfoRunner(ShortcutService r0) {
        return r0.mSaveDirtyInfoRunner;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShortcutChangeCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m6931$$Nest$fgetmShortcutChangeCallbacks(ShortcutService r0) {
        return r0.mShortcutChangeCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShutdown, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m6932$$Nest$fgetmShutdown(ShortcutService r0) {
        return r0.mShutdown;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUriGrantsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ IUriGrantsManager m6933$$Nest$fgetmUriGrantsManager(ShortcutService r0) {
        return r0.mUriGrantsManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUriPermissionOwner, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m6934$$Nest$fgetmUriPermissionOwner(ShortcutService r0) {
        return r0.mUriPermissionOwner;
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanUpPackageForAllLoadedUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6935$$Nest$mcleanUpPackageForAllLoadedUsers(ShortcutService r0, String r1, int r2, boolean r3) {
        r0.cleanUpPackageForAllLoadedUsers(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6936$$Nest$mhandlePackageAdded(ShortcutService r0, String r1, int r2) {
        r0.handlePackageAdded(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6937$$Nest$mhandlePackageChanged(ShortcutService r0, String r1, int r2) {
        r0.handlePackageChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageDataCleared, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6938$$Nest$mhandlePackageDataCleared(ShortcutService r0, String r1, int r2) {
        r0.handlePackageDataCleared(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6939$$Nest$mhandlePackageRemoved(ShortcutService r0, String r1, int r2) {
        r0.handlePackageRemoved(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandlePackageUpdateFinished, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6940$$Nest$mhandlePackageUpdateFinished(ShortcutService r0, String r1, int r2) {
        r0.handlePackageUpdateFinished(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mloadConfigurationLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6941$$Nest$mloadConfigurationLocked(ShortcutService r0) {
        r0.loadConfigurationLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mprepareChangedShortcuts, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6942$$Nest$mprepareChangedShortcuts(ShortcutService r0, ArraySet r1, ArraySet r2, List r3, ShortcutPackage r4) {
        return r0.prepareChangedShortcuts(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestPinItem, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6943$$Nest$mrequestPinItem(ShortcutService r0, String r1, int r2, ShortcutInfo r3, AppWidgetProviderInfo r4, Bundle r5, IntentSender r6) {
        return r0.requestPinItem(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$msetReturnedByServer, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6944$$Nest$msetReturnedByServer(ShortcutService r0, List r1) {
        return r0.setReturnedByServer(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mverifyStatesForce, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6945$$Nest$mverifyStatesForce(ShortcutService r0) {
        r0.verifyStatesForce();
    }

    /* JADX INFO: renamed from: -$$Nest$smisInstalled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6946$$Nest$smisInstalled(PackageInfo r0) {
        return isInstalled(r0);
    }

    static {
        DEFAULT_ICON_PERSIST_FORMAT = Bitmap.CompressFormat.PNG.name();
        EMPTY_RESOLVE_INFO = new ArrayList(0);
        ACTIVITY_NOT_EXPORTED = new AnonymousClass1();
        ACTIVITY_NOT_INSTALLED = new ShortcutService$$ExternalSyntheticLambda25();
        PACKAGE_NOT_INSTALLED = new AnonymousClass2();
    }

    private static /* synthetic */ boolean lambda$static$0(ResolveInfo ri) {
        return !isInstalled(ri.activityInfo);
    }

    public ShortcutService(Context context) {
        this(context, getBgLooper(), false);
    }

    private static Looper getBgLooper() {
        HandlerThread handlerThread = new HandlerThread(KEY_SHORTCUT, 10);
        handlerThread.start();
        return handlerThread.getLooper();
    }

    ShortcutService(Context context, Looper looper, boolean onlyForPackageManagerApis) {
        this.mServiceLock = new Object();
        this.mNonPersistentUsersLock = new Object();
        this.mWtfLock = new Object();
        this.mListeners = new ArrayList(1);
        this.mShortcutChangeCallbacks = new ArrayList(1);
        this.mRawLastResetTime = new AtomicLong(0);
        this.mUsers = new SparseArray();
        this.mShortcutNonPersistentUsers = new SparseArray();
        this.mUidState = new SparseIntArray();
        this.mUidLastForegroundElapsedTime = new SparseLongArray();
        this.mDirtyUserIds = new ArrayList();
        this.mBootCompleted = new AtomicBoolean();
        this.mShutdown = new AtomicBoolean();
        this.mUnlockedUsers = new SparseBooleanArray();
        this.mStatLogger = new StatLogger(new String[]{"getHomeActivities()", "Launcher permission check", "getPackageInfo()", "getPackageInfo(SIG)", "getApplicationInfo", "cleanupDanglingBitmaps", "getActivity+metadata", "getInstalledPackages", "checkPackageChanges", "getApplicationResources", "resourceNameLookup", "getLauncherActivity", "checkLauncherActivity", "isActivityEnabled", "packageUpdateCheck", "asyncPreloadUserDelay", "getDefaultLauncher()"});
        this.mWtfCount = 0;
        this.mMetricsLogger = new MetricsLogger();
        this.mObricExt = (IObricShortcutService) ObricImplFactory.getImpl(IObricShortcutService.class, new Object[]{this});
        this.mOnRoleHoldersChangedListener = new AnonymousClass3(this);
        this.mUidObserver = new AnonymousClass4(this);
        this.mSaveDirtyInfoRunner = new ShortcutService$$ExternalSyntheticLambda10(this);
        this.mLastLockedUser = -1;
        this.mReceiver = new AnonymousClass5(this);
        this.mPackageMonitor = new AnonymousClass6(this);
        this.mShutdownReceiver = new AnonymousClass7(this);
        this.mExt = (IExtShortcutService) ExtImplFactory.getImpl(IExtShortcutService.class, new Object[]{this});
        context.getClass();
        this.mContext = context;
        LocalServices.addService(ShortcutServiceInternal.class, new LocalService(this, null));
        this.mHandler = new Handler(looper);
        this.mIPackageManager = AppGlobals.getPackageManager();
        PackageManagerInternal r2 = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        r2.getClass();
        this.mPackageManagerInternal = r2;
        UserManagerInternal r3 = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        r3.getClass();
        this.mUserManagerInternal = r3;
        UsageStatsManagerInternal r4 = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        r4.getClass();
        this.mUsageStatsManagerInternal = r4;
        ActivityManagerInternal r5 = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        r5.getClass();
        this.mActivityManagerInternal = r5;
        IUriGrantsManager r6 = UriGrantsManager.getService();
        r6.getClass();
        this.mUriGrantsManager = r6;
        UriGrantsManagerInternal r7 = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);
        r7.getClass();
        this.mUriGrantsManagerInternal = r7;
        this.mUriPermissionOwner = this.mUriGrantsManagerInternal.newUriPermissionOwner(TAG);
        RoleManager r8 = (RoleManager) this.mContext.getSystemService(RoleManager.class);
        r8.getClass();
        this.mRoleManager = r8;
        this.mShortcutRequestPinProcessor = new ShortcutRequestPinProcessor(this, this.mServiceLock);
        this.mShortcutDumpFiles = new ShortcutDumpFiles(this);
        if (onlyForPackageManagerApis == false) goto L5;
        return;
    L5:
        IntentFilter packageFilter = new IntentFilter();
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        packageFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        packageFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        packageFilter.addDataScheme(Settings.ATTR_PACKAGE);
        packageFilter.setPriority(1000);
        this.mContext.registerReceiverAsUser(this.mPackageMonitor, UserHandle.ALL, packageFilter, null, this.mHandler);
        IntentFilter localeFilter = new IntentFilter();
        localeFilter.addAction("android.intent.action.LOCALE_CHANGED");
        localeFilter.setPriority(1000);
        this.mContext.registerReceiverAsUser(this.mReceiver, UserHandle.ALL, localeFilter, null, this.mHandler);
        IntentFilter shutdownFilter = new IntentFilter();
        shutdownFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        shutdownFilter.setPriority(1000);
        this.mContext.registerReceiverAsUser(this.mShutdownReceiver, UserHandle.SYSTEM, shutdownFilter, null, this.mHandler);
        injectRegisterUidObserver(this.mUidObserver, 3);
        injectRegisterRoleHoldersListener(this.mOnRoleHoldersChangedListener);
    }

    long getStatStartTime() {
        return this.mStatLogger.getTime();
    }

    void logDurationStat(int statId, long start) {
        this.mStatLogger.logDurationStat(statId, start);
    }

    public String injectGetLocaleTagsForUser(int userId) {
        return LocaleList.getDefault().toLanguageTags();
    }

    void handleOnDefaultLauncherChanged(int userId) {
        this.mUriGrantsManagerInternal.revokeUriPermissionFromOwner(this.mUriPermissionOwner, null, -1, 0);
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isUserLoadedLocked(userId) == false) goto L9;
        getUserShortcutsLocked(userId).setCachedLauncher(null);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void handleOnUidStateChanged(int uid, int procState) {
        Trace.traceBegin(524288, "shortcutHandleOnUidStateChanged");
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        this.mUidState.put(uid, procState);     // Catch: Throwable -> L7
        if (isProcessStateForeground(procState) == false) goto L9;
        this.mUidLastForegroundElapsedTime.put(uid, injectElapsedRealtime());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        Trace.traceEnd(524288);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isProcessStateForeground(int processState) {
        if (processState > 5) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isUidForegroundLocked(int uid) {
        if (uid != 1000) goto L6;
        return true;
    L6:
        if (isProcessStateForeground(this.mUidState.get(uid, 20)) == false) goto L9;
        return true;
    L9:
        return isProcessStateForeground(this.mActivityManagerInternal.getUidProcessState(uid));
    }

    long getUidLastForegroundElapsedTimeLocked(int uid) {
        return this.mUidLastForegroundElapsedTime.get(uid);
    }

    void onBootPhase(int phase) {
        switch(phase) {
            case 480: goto L5;
            case 1000: goto L4;
            default: goto L8;
        };
    L4:
        this.mBootCompleted.set(true);
        return;
    L5:
        initialize();
        return;
    }

    void handleUnlockUser(final int userId) {
        SparseBooleanArray r0 = this.mUnlockedUsers;
        monitor-enter(r0);
        this.mUnlockedUsers.put(userId, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        final long start = getStatStartTime();
        injectRunOnNewThread(new ShortcutService$$ExternalSyntheticLambda7(this, start, userId));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$handleUnlockUser$1(long start, int userId) {
        Trace.traceBegin(524288, "shortcutHandleUnlockUser");
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        logDurationStat(15, start);     // Catch: Throwable -> L9
        getUserShortcutsLocked(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        Trace.traceEnd(524288);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void handleStopUser(int userId) {
        Trace.traceBegin(524288, "shortcutHandleStopUser");
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        unloadUserLocked(userId);     // Catch: Throwable -> L11
        SparseBooleanArray r3 = this.mUnlockedUsers;     // Catch: Throwable -> L11
        monitor-enter(r3);     // Catch: Throwable -> L11
        this.mUnlockedUsers.put(userId, false);     // Catch: Throwable -> L13
        monitor-exit(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L11
        Trace.traceEnd(524288);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void unloadUserLocked(int userId) {
        saveDirtyInfo();
        this.mUsers.delete(userId);
    }

    final ResilientAtomicFile getBaseStateFile() {
        File mainFile = new File(injectSystemDataPath(), FILENAME_BASE_STATE);
        File temporaryBackup = new File(injectSystemDataPath(), "shortcut_service.xml.backup");
        File reserveCopy = new File(injectSystemDataPath(), "shortcut_service.xml.reservecopy");
        return new ResilientAtomicFile(mainFile, temporaryBackup, reserveCopy, 505, "base shortcut", null);
    }

    private void initialize() {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        loadConfigurationLocked();     // Catch: Throwable -> L7
        loadBaseStateLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void loadConfigurationLocked() {
        updateConfigurationLocked(injectShortcutManagerConstants());
    }

    boolean updateConfigurationLocked(String config) {
        boolean result = true;
        KeyValueListParser parser = new KeyValueListParser(',');
        parser.setString(config);     // Catch: IllegalArgumentException -> L5
    L7:
        this.mSaveDelayMillis = Math.max(0, (int) parser.getLong(ConfigConstants.KEY_SAVE_DELAY_MILLIS, BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS));
        this.mResetInterval = Math.max(1, parser.getLong(ConfigConstants.KEY_RESET_INTERVAL_SEC, DEFAULT_RESET_INTERVAL_SEC) * 1000);
        this.mMaxUpdatesPerInterval = Math.max(0, (int) parser.getLong(ConfigConstants.KEY_MAX_UPDATES_PER_INTERVAL, 10));
        this.mMaxShortcuts = Math.max(0, (int) parser.getLong(ConfigConstants.KEY_MAX_SHORTCUTS, 15));
        this.mMaxShortcutsPerApp = Math.max(0, (int) parser.getLong(ConfigConstants.KEY_MAX_SHORTCUTS_PER_APP, CALLBACK_DELAY));
        if (injectIsLowRamDevice() == false) goto L10;
        int r2 = (int) parser.getLong(ConfigConstants.KEY_MAX_ICON_DIMENSION_DP_LOWRAM, 48);
    L11:
        int iconDimensionDp = Math.max(1, r2);
        this.mMaxIconDimension = injectDipToPixel(iconDimensionDp);
        this.mIconPersistFormat = Bitmap.CompressFormat.valueOf(parser.getString(ConfigConstants.KEY_ICON_FORMAT, DEFAULT_ICON_PERSIST_FORMAT));
        this.mIconPersistQuality = (int) parser.getLong(ConfigConstants.KEY_ICON_QUALITY, CALLBACK_DELAY);
        return result;
    L10:
        r2 = (int) parser.getLong(ConfigConstants.KEY_MAX_ICON_DIMENSION_DP, 96);
    L5:
        e = move-exception;
        Slog.e(TAG, "Bad shortcut manager settings", e);
        result = false;
        goto L7
    }

    String injectShortcutManagerConstants() {
        return android.provider.Settings.Global.getString(this.mContext.getContentResolver(), "shortcut_manager_constants");
    }

    int injectDipToPixel(int dip) {
        return (int) TypedValue.applyDimension(1, dip, this.mContext.getResources().getDisplayMetrics());
    }

    static String parseStringAttribute(TypedXmlPullParser parser, String attribute) {
        return parser.getAttributeValue(null, attribute);
    }

    static boolean parseBooleanAttribute(TypedXmlPullParser parser, String attribute) {
        if (parseLongAttribute(parser, attribute) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean parseBooleanAttribute(TypedXmlPullParser r4, String r5, boolean r6) {
        if (parseLongAttribute(r4, r5, r6 ? 1 : 0) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    static int parseIntAttribute(TypedXmlPullParser parser, String attribute) {
        return (int) parseLongAttribute(parser, attribute);
    }

    static int parseIntAttribute(TypedXmlPullParser parser, String attribute, int def) {
        return (int) parseLongAttribute(parser, attribute, def);
    }

    static long parseLongAttribute(TypedXmlPullParser parser, String attribute) {
        return parseLongAttribute(parser, attribute, 0);
    }

    static long parseLongAttribute(TypedXmlPullParser parser, String attribute, long def) {
        String value = parseStringAttribute(parser, attribute);
        if (TextUtils.isEmpty(value) == false) goto L10;
        return def;
    L10:
        return Long.parseLong(value);
    L8:
        Slog.e(TAG, "Error parsing long " + value);
        return def;
    }

    static ComponentName parseComponentNameAttribute(TypedXmlPullParser parser, String attribute) {
        String value = parseStringAttribute(parser, attribute);
        if (TextUtils.isEmpty(value) == false) goto L7;
        return null;
    L7:
        return ComponentName.unflattenFromString(value);
    }

    static Intent parseIntentAttributeNoDefault(TypedXmlPullParser parser, String attribute) {
        String value = parseStringAttribute(parser, attribute);
        if (TextUtils.isEmpty(value) == false) goto L10;
        return null;
    L10:
        Intent parsed = Intent.parseUri(value, 0);     // Catch: URISyntaxException -> L7
        return parsed;
    L7:
        e = move-exception;
        Slog.e(TAG, "Error parsing intent", e);
        return null;
    }

    static Intent parseIntentAttribute(TypedXmlPullParser parser, String attribute) {
        Intent parsed = parseIntentAttributeNoDefault(parser, attribute);
        if (parsed == null) goto L5;
        return parsed;
    L5:
        return new Intent("android.intent.action.VIEW");
    }

    static void writeTagValue(TypedXmlSerializer out, String tag, String value) throws IOException {
        if (TextUtils.isEmpty(value) == false) goto L5;
        return;
    L5:
        out.startTag(null, tag);
        out.attribute(null, ATTR_VALUE, value);
        out.endTag(null, tag);
    }

    static void writeTagValue(TypedXmlSerializer out, String tag, long value) throws IOException {
        writeTagValue(out, tag, Long.toString(value));
    }

    static void writeTagValue(TypedXmlSerializer out, String tag, ComponentName name) throws IOException {
        if (name != null) goto L4;
        return;
    L4:
        writeTagValue(out, tag, name.flattenToString());
    }

    static void writeTagExtra(TypedXmlSerializer out, String tag, PersistableBundle bundle) throws IOException, XmlPullParserException {
        if (bundle != null) goto L4;
        return;
    L4:
        out.startTag(null, tag);
        bundle.saveToXml(out);
        out.endTag(null, tag);
    }

    static void writeAttr(TypedXmlSerializer out, String name, CharSequence value) throws IOException {
        if (TextUtils.isEmpty(value) == false) goto L5;
        return;
    L5:
        out.attribute(null, name, value.toString());
    }

    static void writeAttr(TypedXmlSerializer out, String name, long value) throws IOException {
        writeAttr(out, name, String.valueOf(value));
    }

    static void writeAttr(TypedXmlSerializer out, String name, boolean value) throws IOException {
        if (value == false) goto L4;
        writeAttr(out, name, "1");
        return;
    L4:
        writeAttr(out, name, "0");
    }

    static void writeAttr(TypedXmlSerializer out, String name, ComponentName comp) throws IOException {
        if (comp != null) goto L4;
        return;
    L4:
        writeAttr(out, name, comp.flattenToString());
    }

    static void writeAttr(TypedXmlSerializer out, String name, Intent intent) throws IOException {
        if (intent != null) goto L4;
        return;
    L4:
        writeAttr(out, name, intent.toUri(0));
    }

    void injectSaveBaseState() {
        ResilientAtomicFile file = getBaseStateFile();
        Object r2 = this.mServiceLock;     // Catch: Throwable -> L9 IOException -> L11
        monitor-enter(r2);     // Catch: Throwable -> L9 IOException -> L11
        FileOutputStream outs = file.startWrite();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        saveBaseStateAsXml(outs);     // Catch: Throwable -> L9 IOException -> L11
        injectFinishWrite(file, outs);     // Catch: Throwable -> L9 IOException -> L11
    L18:
        if (file == null) goto L33;
        file.close();
        return;
    L33:
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9 IOException -> L11
    L11:
        e = move-exception;
        Slog.w(TAG, "Failed to write to file " + file.getBaseFile(), e);     // Catch: Throwable -> L9
        file.failWrite(null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (file != null) goto L29;
    L26:
        throw th;
    L29:
        file.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);
        goto L26
    }

    protected void saveBaseStateAsXml(OutputStream outs) throws IOException {
        TypedXmlSerializer out = Xml.resolveSerializer(outs);
        out.startDocument(null, true);
        out.startTag(null, TAG_ROOT);
        writeTagValue(out, TAG_LAST_RESET_TIME, this.mRawLastResetTime.get());
        out.endTag(null, TAG_ROOT);
        out.endDocument();
    }

    private void loadBaseStateLocked() {
        this.mRawLastResetTime.set(0);
        injectLoadBaseState();
        getLastResetTimeLocked();
    }

    protected void injectLoadBaseState() {
        ResilientAtomicFile file = getBaseStateFile();
        FileInputStream in = file.openRead();     // Catch: Throwable -> L7 Throwable -> L9 FileNotFoundException -> L11
        if (in == null) goto L14;
        loadBaseStateAsXml(in);     // Catch: Throwable -> L7 Throwable -> L9 FileNotFoundException -> L11
        goto L25
    L14:
        throw new FileNotFoundException(file.getBaseFile().getAbsolutePath());     // Catch: Throwable -> L7 Throwable -> L9 FileNotFoundException -> L11
    L7:
        th = move-exception;
        if (file != null) goto L29;
    L24:
        throw th;
    L29:
        file.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);
    L9:
        e = move-exception;
        file.failRead(null, e);     // Catch: Throwable -> L7
        loadBaseStateLocked();     // Catch: Throwable -> L7
        file.close();
        return;
    L25:
        if (file == null) goto L31;
        file.close();
        return;
    }

    protected void loadBaseStateAsXml(InputStream in) throws IOException, XmlPullParserException {
        TypedXmlPullParser parser = Xml.resolvePullParser(in);
    L3:
        int type = parser.next();
        if (type == 1) goto L25;
        if (type != 2) goto L3;
        int depth = parser.getDepth();
        String tag = parser.getName();
        if (depth == 1) goto L11;
        switch(tag.hashCode()) {
            case -68726522: goto L18;
            default: goto L20;
        };
    L20:
        byte r3 = -1;
    L21:
        switch(r3) {
            case 0: goto L23;
            default: goto L22;
        };
    L23:
        this.mRawLastResetTime.set(parseLongAttribute(parser, ATTR_VALUE));
        goto L3
    L22:
        Slog.v(TAG, "Invalid tag: " + tag);
        goto L3
    L18:
        if (tag.equals(TAG_LAST_RESET_TIME) == false) goto L20;
        r3 = 0;
        goto L21
    L11:
        if (TAG_ROOT.equals(tag) == true) goto L3;
        Slog.v(TAG, "Invalid root tag: " + tag);
        return;
    }

    final ResilientAtomicFile getUserFile(int userId) {
        File mainFile = new File(injectUserDataPath(userId), FILENAME_USER_PACKAGES);
        File temporaryBackup = new File(injectUserDataPath(userId), "shortcuts.xml.backup");
        File reserveCopy = new File(injectUserDataPath(userId), FILENAME_USER_PACKAGES_RESERVE_COPY);
        return new ResilientAtomicFile(mainFile, temporaryBackup, reserveCopy, 505, "user shortcut", null);
    }

    protected void injectSaveUser(int userId) {
        ResilientAtomicFile file = getUserFile(userId);
        Object r2 = this.mServiceLock;     // Catch: Throwable -> L9 Throwable -> L11
        monitor-enter(r2);     // Catch: Throwable -> L9 Throwable -> L11
        File root = injectUserDataPath(userId);     // Catch: Throwable -> L13
        FileUtils.deleteContents(new File(root, "packages"));     // Catch: Throwable -> L13
        FileUtils.deleteContents(new File(root, "launchers"));     // Catch: Throwable -> L13
        FileOutputStream os = file.startWrite();     // Catch: Throwable -> L13
        saveUserInternalLocked(userId, os, false);     // Catch: Throwable -> L13
        getUserShortcutsLocked(userId).scheduleSaveAllLaunchersAndPackages();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        injectFinishWrite(file, os);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11
        cleanupDanglingBitmapDirectoriesLocked(userId);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11
    L18:
        if (file == null) goto L20;
        file.close();
    L20:
        getUserShortcutsLocked(userId).logSharingShortcutStats(this.mMetricsLogger);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11
    L9:
        th = move-exception;
        if (file != null) goto L28;
    L27:
        throw th;
    L28:
        file.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);
    L11:
        e = move-exception;
        Slog.w(TAG, "Failed to write to file " + file, e);     // Catch: Throwable -> L9
        file.failWrite(null);     // Catch: Throwable -> L9
        goto L18
    }

    protected void saveUserInternalLocked(int userId, OutputStream os, boolean forBackup) throws IOException, XmlPullParserException {
        if (forBackup == false) goto L4;
        TypedXmlSerializer out = Xml.newFastSerializer();
        out.setOutput(os, StandardCharsets.UTF_8.name());
    L5:
        out.startDocument(null, true);
        getUserShortcutsLocked(userId).saveToXml(out, forBackup);
        out.endDocument();
        os.flush();
        return;
    L4:
        out = Xml.resolveSerializer(os);
        goto L5
    }

    static IOException throwForInvalidTag(int depth, String tag) throws IOException {
        throw new IOException(String.format("Invalid tag '%s' found at depth %d", new Object[]{tag, Integer.valueOf(depth)}));
    }

    static void warnForInvalidTag(int depth, String tag) throws IOException {
        Slog.w(TAG, String.format("Invalid tag '%s' found at depth %d", new Object[]{tag, Integer.valueOf(depth)}));
    }

    protected ShortcutUser injectLoadUserLocked(int userId) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            com.android.server.pm.ResilientAtomicFile r0 = r4.getUserFile(r5)
            r1 = 0
            java.io.FileInputStream r2 = r0.openRead()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            r1 = r2
            if (r1 != 0) goto L12
        Ld:
            r0.close()
            r2 = 0
            return r2
        L12:
            r2 = 0
            com.android.server.pm.ShortcutUser r2 = r4.loadUserInternal(r5, r1, r2)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1d
            r0.close()
            return r2
        L1b:
            r1 = move-exception
            goto L2a
        L1d:
            r2 = move-exception
            r0.failRead(r1, r2)     // Catch: java.lang.Throwable -> L1b
            com.android.server.pm.ShortcutUser r3 = r4.injectLoadUserLocked(r5)     // Catch: java.lang.Throwable -> L1b
            r0.close()
            return r3
        L2a:
            if (r0 == 0) goto L34
            r0.close()     // Catch: java.lang.Throwable -> L30
            goto L34
        L30:
            r2 = move-exception
            r1.addSuppressed(r2)
        L34:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.pm.ShortcutService.injectLoadUserLocked(int):com.android.server.pm.ShortcutUser");
    }

    protected ShortcutUser loadUserInternal(int userId, InputStream is, boolean fromBackup) throws XmlPullParserException, IOException, InvalidFileFormatException {
        ShortcutUser ret = null;
        if (fromBackup == false) goto L5;
        TypedXmlPullParser parser = Xml.newFastPullParser();
        parser.setInput(is, StandardCharsets.UTF_8.name());
    L6:
        int type = parser.next();
        if (type == 1) goto L17;
        if (type != 2) goto L6;
        int depth = parser.getDepth();
        String tag = parser.getName();
        if (depth != 1) goto L16;
        if ("user".equals(tag) == false) goto L16;
        ret = ShortcutUser.loadFromXml(this, parser, userId, fromBackup);
    L16:
        throwForInvalidTag(depth, tag);
        goto L6
    L17:
        return ret;
    L5:
        parser = Xml.resolvePullParser(is);
        goto L6
    }

    private void scheduleSaveBaseState() {
        scheduleSaveInner(ProcessList.INVALID_ADJ);
    }

    void scheduleSaveUser(int userId) {
        scheduleSaveInner(userId);
    }

    private void scheduleSaveInner(int userId) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mDirtyUserIds.contains(Integer.valueOf(userId)) == true) goto L9;
        this.mDirtyUserIds.add(Integer.valueOf(userId));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mHandler.removeCallbacks(this.mSaveDirtyInfoRunner);
        this.mHandler.postDelayed(this.mSaveDirtyInfoRunner, this.mSaveDelayMillis);
    }

    void saveDirtyInfo() {
        if (this.mShutdown.get() == false) goto L35;
        return;
    L35:
        Trace.traceBegin(524288, "shortcutSaveDirtyInfo");     // Catch: Throwable -> L15 Exception -> L17
        List<Integer> dirtyUserIds = new ArrayList();     // Catch: Throwable -> L15 Exception -> L17
        Object r3 = this.mServiceLock;     // Catch: Throwable -> L15 Exception -> L17
        monitor-enter(r3);     // Catch: Throwable -> L15 Exception -> L17
        List<Integer> tmp = this.mDirtyUserIds;     // Catch: Throwable -> L23
        this.mDirtyUserIds = dirtyUserIds;     // Catch: Throwable -> L23
        monitor-exit(r3);     // Catch: Throwable -> L23
        int i = tmp.size() - 1;     // Catch: Throwable -> L15 Exception -> L17
    L11:
        if (i < 0) goto L22;
        int userId = tmp.get(i).intValue();     // Catch: Throwable -> L15 Exception -> L17
        if (userId != (-10000)) goto L19;
        injectSaveBaseState();     // Catch: Throwable -> L15 Exception -> L17
    L20:
        i = i - 1;
        goto L11
    L19:
        injectSaveUser(userId);     // Catch: Throwable -> L15 Exception -> L17
    L22:
        Trace.traceEnd(524288);
        return;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15 Exception -> L17
    L17:
        e = move-exception;
        wtf("Exception in saveDirtyInfo", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    }

    long getLastResetTimeLocked() {
        updateTimesLocked();
        return this.mRawLastResetTime.get();
    }

    long getNextResetTimeLocked() {
        updateTimesLocked();
        return this.mRawLastResetTime.get() + this.mResetInterval;
    }

    static boolean isClockValid(long time) {
        if (time < 1420070400) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateTimesLocked() {
        long now = injectCurrentTimeMillis();
        long prevLastResetTime = this.mRawLastResetTime.get();
        long newLastResetTime = prevLastResetTime;
        if (newLastResetTime != 0) goto L6;
        newLastResetTime = now;
    L13:
        this.mRawLastResetTime.set(newLastResetTime);
        if (prevLastResetTime == newLastResetTime) goto L17;
        scheduleSaveBaseState();
        return;
    L17:
        return;
    L6:
        if (now >= newLastResetTime) goto L11;
        if (isClockValid(now) == false) goto L13;
        Slog.w(TAG, "Clock rewound");
        newLastResetTime = now;
        goto L13
    L11:
        if ((this.mResetInterval + newLastResetTime) > now) goto L13;
        long offset = newLastResetTime % this.mResetInterval;
        newLastResetTime = ((now / this.mResetInterval) * this.mResetInterval) + offset;
        goto L13
    }

    protected boolean isUserUnlockedL(int userId) {
        SparseBooleanArray r0 = this.mUnlockedUsers;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mUnlockedUsers.get(userId) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return this.mUserManagerInternal.isUserUnlockingOrUnlocked(userId);
    }

    void throwIfUserLockedL(int userId) {
        if (isUserUnlockedL(userId) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("User (with userId=" + userId + ") is locked or not running");
    }

    private boolean isUserLoadedLocked(int userId) {
        if (this.mUsers.get(userId) == null) goto L5;
        return true;
    L5:
        return false;
    }

    ShortcutUser getUserShortcutsLocked(int userId) {
        if (isUserUnlockedL(userId) == false) goto L5;
        this.mLastLockedUser = -1;
    L8:
        ShortcutUser userPackages = this.mUsers.get(userId);
        if (userPackages != null) goto L14;
        userPackages = injectLoadUserLocked(userId);
        if (userPackages != null) goto L13;
        userPackages = new ShortcutUser(this, userId);
    L13:
        this.mUsers.put(userId, userPackages);
        checkPackageChanges(userId);
    L14:
        return userPackages;
    L5:
        if (userId == this.mLastLockedUser) goto L8;
        wtf("User still locked");
        this.mLastLockedUser = userId;
        goto L8
    }

    ShortcutNonPersistentUser getNonPersistentUserLocked(int userId) {
        ShortcutNonPersistentUser ret = this.mShortcutNonPersistentUsers.get(userId);
        if (ret != null) goto L6;
        ShortcutNonPersistentUser ret2 = new ShortcutNonPersistentUser(userId);
        this.mShortcutNonPersistentUsers.put(userId, ret2);
        return ret2;
    L6:
        return ret;
    }

    void forEachLoadedUserLocked(Consumer<ShortcutUser> c) {
        int i = this.mUsers.size() - 1;
    L3:
        if (i < 0) goto L6;
        c.accept(this.mUsers.valueAt(i));
        i = i - 1;
        goto L3
    }

    ShortcutPackage getPackageShortcutsLocked(String packageName, int userId) {
        return getUserShortcutsLocked(userId).getPackageShortcuts(packageName);
    }

    ShortcutPackage getPackageShortcutsForPublisherLocked(String packageName, int userId) {
        ShortcutPackage ret = getUserShortcutsLocked(userId).getPackageShortcuts(packageName);
        ret.getUser().onCalledByPublisher(packageName);
        return ret;
    }

    ShortcutLauncher getLauncherShortcutsLocked(String packageName, int ownerUserId, int launcherUserId) {
        return getUserShortcutsLocked(ownerUserId).getLauncherShortcuts(packageName, launcherUserId);
    }

    public void cleanupBitmapsForPackage(int userId, String packageName) {
        File packagePath = new File(getUserBitmapFilePath(userId), packageName);
        if (packagePath.isDirectory() == true) goto L6;
        return;
    L6:
        if (FileUtils.deleteContents(packagePath) == true) goto L8;
    L9:
        Slog.w(TAG, "Unable to remove directory " + packagePath);
        return;
    L8:
        if (packagePath.delete() == false) goto L9;
    }

    void cleanupDanglingBitmapDirectoriesLocked(int userId) {
        long start = getStatStartTime();
        ShortcutUser user = getUserShortcutsLocked(userId);
        File bitmapDir = getUserBitmapFilePath(userId);
        File[] children = bitmapDir.listFiles();
        if (children != null) goto L5;
        return;
    L5:
        int r5 = children.length;
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L15;
        File child = children[r6];
        if (child.isDirectory() == false) goto L14;
        String packageName = child.getName();
        if (user.hasPackage(packageName) == true) goto L13;
        cleanupBitmapsForPackage(userId, packageName);
        goto L14
    L13:
        user.getPackageShortcuts(packageName).cleanupDanglingBitmapFiles(child);
    L14:
        r6 = r6 + 1;
        goto L6
    L15:
        logDurationStat(5, start);
    }

    FileOutputStreamWithPath openIconFileForWrite(int userId, ShortcutInfo shortcut) throws IOException {
        File packagePath = new File(getUserBitmapFilePath(userId), shortcut.getPackage());
        if (packagePath.isDirectory() == true) goto L9;
        packagePath.mkdirs();
        if (packagePath.isDirectory() == false) goto L8;
        SELinux.restorecon(packagePath);
        goto L9
    L8:
        throw new IOException("Unable to create directory " + packagePath);
    L9:
        String baseName = String.valueOf(injectCurrentTimeMillis());
        int suffix = 0;
    L10:
        StringBuilder r3 = new StringBuilder();
        if (suffix != 0) goto L13;
        String r4 = baseName;
    L14:
        r3.append(r4);
        r3.append(".png");
        String filename = r3.toString();
        File file = new File(packagePath, filename);
        if (file.exists() == false) goto L17;
        suffix = suffix + 1;
        goto L10
    L17:
        return new FileOutputStreamWithPath(file);
    L13:
        r4 = baseName + "_" + suffix;
        goto L14
    }

    void saveIconAndFixUpShortcutLocked(ShortcutPackage p, ShortcutInfo shortcut) {
        if (shortcut.hasIconFile() == false) goto L5;
        return;
    L5:
        if (shortcut.hasIconResource() == false) goto L7;
        return;
    L7:
        if (shortcut.hasIconUri() == true) goto L49;
        long token = injectClearCallingIdentity();
        p.removeIcon(shortcut);     // Catch: Throwable -> L25
        Icon icon = shortcut.getIcon();     // Catch: Throwable -> L25
        if (icon != null) goto L14;
        injectRestoreCallingIdentity(token);
        return;
    L14:
        int maxIconDimension = this.mMaxIconDimension;     // Catch: Throwable -> L25
    L19:
        th = move-exception;
        shortcut.clearIcon();     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L16:
        switch(icon.getType()) {
            case 1: goto L36;
            case 2: goto L32;
            case 3: goto L18;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L21;
            default: goto L18;
        };     // Catch: Throwable -> L19
    L21:
        shortcut.setIconUri(icon.getUriString());     // Catch: Throwable -> L19
        shortcut.addFlags(33280);     // Catch: Throwable -> L19
        shortcut.clearIcon();     // Catch: Throwable -> L25
        injectRestoreCallingIdentity(token);
        return;
    L27:
        icon.getBitmap();     // Catch: Throwable -> L19
        maxIconDimension = (int) (maxIconDimension * ((AdaptiveIconDrawable.getExtraInsetFraction() * 2.0f) + 1.0f));     // Catch: Throwable -> L19
    L37:
        p.saveBitmap(shortcut, maxIconDimension, this.mIconPersistFormat, this.mIconPersistQuality);     // Catch: Throwable -> L19
        shortcut.clearIcon();     // Catch: Throwable -> L25
        injectRestoreCallingIdentity(token);
        return;
    L28:
        shortcut.setIconUri(icon.getUriString());     // Catch: Throwable -> L19
        shortcut.addFlags(32768);     // Catch: Throwable -> L19
        shortcut.clearIcon();     // Catch: Throwable -> L25
        injectRestoreCallingIdentity(token);
        return;
    L32:
        injectValidateIconResPackage(shortcut, icon);     // Catch: Throwable -> L19
        shortcut.setIconResourceId(icon.getResId());     // Catch: Throwable -> L19
        shortcut.addFlags(4);     // Catch: Throwable -> L19
        shortcut.clearIcon();     // Catch: Throwable -> L25
        injectRestoreCallingIdentity(token);
        return;
    L36:
        icon.getBitmap();     // Catch: Throwable -> L19
        goto L37
    L18:
        throw ShortcutInfo.getInvalidIconException();     // Catch: Throwable -> L19
    L25:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        throw th;
    }

    void injectValidateIconResPackage(ShortcutInfo shortcut, Icon icon) {
        if (shortcut.getPackage().equals(icon.getResPackage()) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Icon resource must reside in shortcut owner package");
    }

    static Bitmap shrinkBitmap(Bitmap in, int maxSize) {
        int ow = in.getWidth();
        int oh = in.getHeight();
        if (ow > maxSize) goto L6;
        if (oh > maxSize) goto L6;
        return in;
    L6:
        int longerDimension = Math.max(ow, oh);
        int nw = (ow * maxSize) / longerDimension;
        int nh = (oh * maxSize) / longerDimension;
        Bitmap scaledBitmap = Bitmap.createBitmap(nw, nh, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(scaledBitmap);
        RectF dst = new RectF(0.0f, 0.0f, nw, nh);
        c.drawBitmap(in, null, dst, null);
        return scaledBitmap;
    }

    void fixUpShortcutResourceNamesAndValues(ShortcutInfo si) {
        Resources publisherRes = injectGetResourcesForApplicationAsUser(si.getPackage(), si.getUserId());
        if (publisherRes == null) goto L10;
        long start = getStatStartTime();
        si.lookupAndFillInResourceNames(publisherRes);     // Catch: Throwable -> L7
        logDurationStat(10, start);
        si.resolveResourceStrings(publisherRes);
        return;
    L7:
        th = move-exception;
        logDurationStat(10, start);
        throw th;
    }

    private boolean isCallerSystem() {
        int callingUid = injectBinderCallingUid();
        return UserHandle.isSameApp(callingUid, 1000);
    }

    private boolean isCallerShell() {
        int callingUid = injectBinderCallingUid();
        if (callingUid == 2000) goto L7;
        if (callingUid == 0) goto L7;
        return false;
    L7:
        return true;
    }

    ComponentName injectChooserActivity() {
        if (this.mChooserActivity != null) goto L6;
        this.mChooserActivity = ComponentName.unflattenFromString(this.mContext.getResources().getString(R.string.config_defaultProfcollectReportUploaderAction));
    L6:
        return this.mChooserActivity;
    }

    private boolean isCallerChooserActivity() {
        int callingUid = injectBinderCallingUid();
        ComponentName systemChooser = injectChooserActivity();
        if (systemChooser != null) goto L5;
        return false;
    L5:
        int uid = injectGetPackageUid(systemChooser.getPackageName(), 0);
        if (UserHandle.getAppId(uid) != UserHandle.getAppId(callingUid)) goto L9;
        return true;
    L9:
        return false;
    }

    private void enforceSystemOrShell() {
        if (isCallerSystem() == false) goto L5;
        return;
    L5:
        if (isCallerShell() == false) goto L8;
        return;
    L8:
        throw new SecurityException("Caller must be system or shell");
    }

    private void enforceShell() {
        if (isCallerShell() == false) goto L6;
        return;
    L6:
        throw new SecurityException("Caller must be shell");
    }

    private void enforceSystem() {
        if (isCallerSystem() == false) goto L6;
        return;
    L6:
        throw new SecurityException("Caller must be system");
    }

    private void enforceResetThrottlingPermission() {
        if (isCallerSystem() == false) goto L5;
        return;
    L5:
        enforceCallingOrSelfPermission("android.permission.RESET_SHORTCUT_MANAGER_THROTTLING", null);
    }

    private void enforceCallingOrSelfPermission(String permission, String message) {
        if (isCallerSystem() == false) goto L5;
        return;
    L5:
        injectEnforceCallingPermission(permission, message);
    }

    void injectEnforceCallingPermission(String permission, String message) {
        this.mContext.enforceCallingPermission(permission, message);
    }

    private void verifyCallerUserId(int userId) {
        if (isCallerSystem() == false) goto L5;
        return;
    L5:
        int callingUid = injectBinderCallingUid();
        if (UserHandle.getUserId(callingUid) != userId) goto L9;
        return;
    L9:
        throw new SecurityException("Invalid userId");
    }

    private void verifyCaller(String packageName, int userId) {
        Preconditions.checkStringNotEmpty(packageName, "packageName");
        if (this.mExt.allowModifyShortcut(injectBinderCallingUid()) == false) goto L6;
        return;
    L6:
        if (isCallerSystem() == false) goto L8;
        return;
    L8:
        int callingUid = injectBinderCallingUid();
        if (UserHandle.getUserId(callingUid) != userId) goto L17;
        if (injectGetPackageUid(packageName, userId) != callingUid) goto L15;
        Preconditions.checkState(!isEphemeralApp(packageName, userId), "Ephemeral apps can't use ShortcutManager");
        return;
    L15:
        throw new SecurityException("Calling package name mismatch");
    L17:
        throw new SecurityException("Invalid userId");
    }

    private void verifyShortcutInfoPackage(String callerPackage, ShortcutInfo si) {
        if (this.mExt.allowModifyShortcut(injectBinderCallingUid()) == false) goto L5;
        return;
    L5:
        if (si != null) goto L8;
        return;
    L8:
        if (Objects.equals(callerPackage, si.getPackage()) == false) goto L14;
        int callingUid = injectBinderCallingUid();
        if (UserHandle.getUserId(callingUid) != si.getUserId()) goto L13;
        return;
    L13:
        throw new SecurityException("UserId in shortcut doesn't match the caller");
    L14:
        EventLog.writeEvent(1397638484, new Object[]{"109824443", -1, ""});
        throw new SecurityException("Shortcut package name mismatch");
    }

    private void verifyShortcutInfoPackages(String callerPackage, List<ShortcutInfo> list) {
        int size = list.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        verifyShortcutInfoPackage(callerPackage, list.get(i));
        i = i + 1;
        goto L3
    }

    void injectPostToHandler(Runnable r) {
        this.mHandler.post(r);
    }

    void injectRunOnNewThread(Runnable r) {
        new Thread(r).start();
    }

    void injectPostToHandlerDebounced(Object token, Runnable r) {
        token.getClass();
        r.getClass();
        Handler r0 = this.mHandler;
        monitor-enter(r0);
        this.mHandler.removeCallbacksAndMessages(token);     // Catch: Throwable -> L7
        this.mHandler.postDelayed(r, token, CALLBACK_DELAY);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void enforceMaxActivityShortcuts(int numShortcuts) {
        if (numShortcuts > this.mMaxShortcuts) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Max number of dynamic shortcuts exceeded");
    }

    int getMaxActivityShortcuts() {
        return this.mMaxShortcuts;
    }

    int getMaxAppShortcuts() {
        return this.mMaxShortcutsPerApp;
    }

    void packageShortcutsChanged(ShortcutPackage sp, List<ShortcutInfo> changedShortcuts, List<ShortcutInfo> removedShortcuts) {
        sp.getClass();
        String packageName = sp.getPackageName();
        int userId = sp.getPackageUserId();
        injectPostToHandlerDebounced(sp, notifyListenerRunnable(packageName, userId));
        notifyShortcutChangeCallbacks(packageName, userId, changedShortcuts, removedShortcuts);
        sp.scheduleSave();
    }

    private void notifyListeners(String packageName, int userId) {
        injectPostToHandler(notifyListenerRunnable(packageName, userId));
    }

    private Runnable notifyListenerRunnable(final String packageName, final int userId) {
        return new ShortcutService$$ExternalSyntheticLambda13(this, userId, packageName);
    }

    private /* synthetic */ void lambda$notifyListenerRunnable$2(int userId, String packageName) {
        Object r0 = this.mServiceLock;     // Catch: Exception -> L16
        monitor-enter(r0);     // Catch: Exception -> L16
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L5:
        if (isUserUnlockedL(userId) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ArrayList<ShortcutServiceInternal.ShortcutChangeListener> copy = new ArrayList(this.mListeners);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        int i = copy.size() - 1;     // Catch: Exception -> L16
    L13:
        if (i < 0) goto L25;
        copy.get(i).onShortcutChanged(packageName, userId);     // Catch: Exception -> L16
        i = i - 1;
        goto L13
    L25:
        return;
    }

    private void notifyShortcutChangeCallbacks(final String packageName, final int userId, List<ShortcutInfo> changedShortcuts, List<ShortcutInfo> removedShortcuts) {
        final List<ShortcutInfo> changedList = removeNonKeyFields(changedShortcuts);
        final List<ShortcutInfo> removedList = removeNonKeyFields(removedShortcuts);
        final UserHandle user = UserHandle.of(userId);
        injectPostToHandler(new ShortcutService$$ExternalSyntheticLambda21(this, userId, changedList, packageName, user, removedList));
    }

    private /* synthetic */ void lambda$notifyShortcutChangeCallbacks$3(int userId, List changedList, String packageName, UserHandle user, List removedList) {
        Object r0 = this.mServiceLock;     // Catch: Exception -> L17
        monitor-enter(r0);     // Catch: Exception -> L17
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L17
    L5:
        if (isUserUnlockedL(userId) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ArrayList<LauncherApps.ShortcutChangeCallback> copy = new ArrayList(this.mShortcutChangeCallbacks);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        int i = copy.size() - 1;     // Catch: Exception -> L17
    L13:
        if (i < 0) goto L32;
        if (CollectionUtils.isEmpty(changedList) == true) goto L20;
        copy.get(i).onShortcutsAddedOrUpdated(packageName, changedList, user);     // Catch: Exception -> L17
    L20:
        if (CollectionUtils.isEmpty(removedList) == true) goto L22;
        copy.get(i).onShortcutsRemoved(packageName, removedList, user);     // Catch: Exception -> L17
    L22:
        i = i - 1;
        goto L13
    L32:
        return;
    }

    private List<ShortcutInfo> removeNonKeyFields(List<ShortcutInfo> shortcutInfos) {
        if (CollectionUtils.isEmpty(shortcutInfos) == false) goto L5;
        return shortcutInfos;
    L5:
        int size = shortcutInfos.size();
        List<ShortcutInfo> keyFieldOnlyShortcuts = new ArrayList(size);
        int i = 0;
    L6:
        if (i >= size) goto L13;
        ShortcutInfo si = shortcutInfos.get(i);
        if (si.hasKeyFieldsOnly() == false) goto L10;
        keyFieldOnlyShortcuts.add(si);
    L11:
        i = i + 1;
        goto L6
    L10:
        keyFieldOnlyShortcuts.add(si.clone(4));
        goto L11
    L13:
        return keyFieldOnlyShortcuts;
    }

    private void fixUpIncomingShortcutInfo(ShortcutInfo shortcut, boolean forUpdate, boolean forPinRequest) {
        if (shortcut.isReturnedByServer() == false) goto L5;
        Log.w(TAG, "Re-publishing ShortcutInfo returned by server is not supported. Some information such as icon may lost from shortcut.");
    L5:
        shortcut.getClass();
        if (shortcut.getActivity() == null) goto L8;
        Preconditions.checkState(shortcut.getPackage().equals(shortcut.getActivity().getPackageName()), "Cannot publish shortcut: activity " + shortcut.getActivity() + " does not belong to package " + shortcut.getPackage());
        Preconditions.checkState(injectIsMainActivity(shortcut.getActivity(), shortcut.getUserId()), "Cannot publish shortcut: activity " + shortcut.getActivity() + " is not main activity");
    L8:
        if (forUpdate == true) goto L17;
        shortcut.enforceMandatoryFields(forPinRequest);
        if (forPinRequest == true) goto L17;
        if (shortcut.getActivity() == null) goto L14;
        boolean r0 = true;
    L15:
        Preconditions.checkState(r0, "Cannot publish shortcut: target activity is not set");
        goto L17
    L14:
        r0 = false;
    L17:
        if (shortcut.getIcon() == null) goto L19;
        ShortcutInfo.validateIcon(shortcut.getIcon());
        validateIconURI(shortcut);
    L19:
        shortcut.replaceFlags(shortcut.getFlags() & 8192);
    }

    private void validateIconURI(ShortcutInfo si) {
        int callingUid = injectBinderCallingUid();
        Icon icon = si.getIcon();
        if (icon != null) goto L5;
        return;
    L5:
        int iconType = icon.getType();
        if (iconType != 4) goto L8;
    L10:
        Uri uri = icon.getUri();
        this.mUriGrantsManagerInternal.checkGrantUriPermission(callingUid, si.getPackage(), ContentProvider.getUriWithoutUserId(uri), 1, ContentProvider.getUserIdFromUri(uri, UserHandle.getUserId(callingUid)));
        return;
    L8:
        if (iconType == 6) goto L10;
    }

    private void fixUpIncomingShortcutInfo(ShortcutInfo shortcut, boolean forUpdate) {
        fixUpIncomingShortcutInfo(shortcut, forUpdate, false);
    }

    public void validateShortcutForPinRequest(ShortcutInfo shortcut) {
        fixUpIncomingShortcutInfo(shortcut, false, true);
    }

    private void fillInDefaultActivity(List<ShortcutInfo> shortcuts) {
        ComponentName defaultActivity = null;
        int i = shortcuts.size() - 1;
    L3:
        if (i < 0) goto L15;
        ShortcutInfo si = shortcuts.get(i);
        if (si.getActivity() != null) goto L13;
        if (defaultActivity != null) goto L12;
        defaultActivity = injectGetDefaultMainActivity(si.getPackage(), si.getUserId());
        if (defaultActivity == null) goto L10;
        boolean r4 = true;
    L11:
        Preconditions.checkState(r4, "Launcher activity not found for package " + si.getPackage());
        goto L12
    L10:
        r4 = false;
    L12:
        si.setActivity(defaultActivity);
    L13:
        i = i - 1;
        goto L3
    }

    private void assignImplicitRanks(List<ShortcutInfo> shortcuts) {
        int i = shortcuts.size() - 1;
    L3:
        if (i < 0) goto L6;
        shortcuts.get(i).setImplicitRank(i);
        i = i - 1;
        goto L3
    }

    private List<ShortcutInfo> setReturnedByServer(List<ShortcutInfo> shortcuts) {
        int i = shortcuts.size() - 1;
    L3:
        if (i < 0) goto L6;
        shortcuts.get(i).setReturnedByServer();
        i = i - 1;
        goto L3
    L6:
        return shortcuts;
    }

    public boolean setDynamicShortcuts(String packageName, ParceledListSlice shortcutInfoList, int userId) {
        verifyCaller(packageName, userId);
        boolean unlimited = injectHasUnlimitedShortcutsApiCallsPermission(injectBinderCallingPid(), injectBinderCallingUid());
        List<ShortcutInfo> newShortcuts = shortcutInfoList.getList();
        verifyShortcutInfoPackages(packageName, newShortcuts);
        int size = newShortcuts.size();
        Object r5 = this.mServiceLock;
        monitor-enter(r5);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L8
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L8
        ps.ensureImmutableShortcutsNotIncluded(newShortcuts, true);     // Catch: Throwable -> L8
        ps.ensureNoBitmapIconIfShortcutIsLongLived(newShortcuts);     // Catch: Throwable -> L8
        fillInDefaultActivity(newShortcuts);     // Catch: Throwable -> L8
        ps.enforceShortcutCountsBeforeOperation(newShortcuts, 0);     // Catch: Throwable -> L8
        if (ps.tryApiCall(unlimited) == true) goto L10;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return false;
    L10:
        ps.clearAllImplicitRanks();     // Catch: Throwable -> L8
        assignImplicitRanks(newShortcuts);     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= size) goto L13;
        fixUpIncomingShortcutInfo(newShortcuts.get(i), false);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L13:
        ArrayList<ShortcutInfo> cachedOrPinned = new ArrayList();     // Catch: Throwable -> L8
        ps.findAll(cachedOrPinned, new ShortcutService$$ExternalSyntheticLambda14(), 4);     // Catch: Throwable -> L8
        List<ShortcutInfo> removedShortcuts = ps.deleteAllDynamicShortcuts();     // Catch: Throwable -> L8
        int i2 = 0;
    L14:
        if (i2 >= size) goto L16;
        ShortcutInfo newShortcut = newShortcuts.get(i2);     // Catch: Throwable -> L8
        ps.addOrReplaceDynamicShortcut(newShortcut);     // Catch: Throwable -> L8
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L14
    L16:
        ps.adjustRanks();     // Catch: Throwable -> L8
        List<ShortcutInfo> changedShortcuts = prepareChangedShortcuts(cachedOrPinned, newShortcuts, removedShortcuts, ps);     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        packageShortcutsChanged(ps, changedShortcuts, removedShortcuts);
        verifyStates();
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$setDynamicShortcuts$4(ShortcutInfo si) {
        if (si.isVisibleToPublisher() == true) goto L5;
    L11:
        return false;
    L5:
        if (si.isDynamic() == false) goto L11;
        if (si.isCached() == false) goto L9;
    L10:
        return true;
    L9:
        if (si.isPinned() == false) goto L11;
        goto L10
    }

    public boolean updateShortcuts(String packageName, ParceledListSlice shortcutInfoList, int userId) {
        verifyCaller(packageName, userId);
        boolean unlimited = injectHasUnlimitedShortcutsApiCallsPermission(injectBinderCallingPid(), injectBinderCallingUid());
        List<ShortcutInfo> newShortcuts = shortcutInfoList.getList();
        verifyShortcutInfoPackages(packageName, newShortcuts);
        int size = newShortcuts.size();
        final List<ShortcutInfo> changedShortcuts = new ArrayList(1);
        Object r5 = this.mServiceLock;
        monitor-enter(r5);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L9
        final ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L9
        ps.ensureImmutableShortcutsNotIncluded(newShortcuts, true);     // Catch: Throwable -> L9
        ps.ensureNoBitmapIconIfShortcutIsLongLived(newShortcuts);     // Catch: Throwable -> L9
        ps.ensureAllShortcutsVisibleToLauncher(newShortcuts);     // Catch: Throwable -> L9
        ps.enforceShortcutCountsBeforeOperation(newShortcuts, 2);     // Catch: Throwable -> L9
        if (ps.tryApiCall(unlimited) == true) goto L11;
        monitor-exit(r5);     // Catch: Throwable -> L9
        return false;
    L11:
        ps.clearAllImplicitRanks();     // Catch: Throwable -> L9
        assignImplicitRanks(newShortcuts);     // Catch: Throwable -> L9
        int i = 0;
    L13:
        if (i >= size) goto L15;
        final ShortcutInfo source = newShortcuts.get(i);     // Catch: Throwable -> L9
        fixUpIncomingShortcutInfo(source, true);     // Catch: Throwable -> L9
        ps.mutateShortcut(source.getId(), null, new ShortcutService$$ExternalSyntheticLambda17(this, source, ps, changedShortcuts));     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L13
    L15:
        ps.adjustRanks();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        if (changedShortcuts.isEmpty() == false) goto L20;
        List<ShortcutInfo> r6 = null;
    L21:
        packageShortcutsChanged(ps, r6, null);
        verifyStates();
        return true;
    L20:
        r6 = changedShortcuts;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$updateShortcuts$5(ShortcutInfo source, ShortcutPackage ps, List changedShortcuts, ShortcutInfo target) {
        if (target != null) goto L4;
        return;
    L4:
        if (target.isVisibleToPublisher() == true) goto L7;
        return;
    L7:
        if (target.isEnabled() == source.isEnabled()) goto L10;
        Slog.w(TAG, "ShortcutInfo.enabled cannot be changed with updateShortcuts()");
    L10:
        if (target.isLongLived() == source.isLongLived()) goto L13;
        Slog.w(TAG, "ShortcutInfo.longLived cannot be changed with updateShortcuts()");
    L13:
        if (source.hasRank() == false) goto L16;
        target.setRankChanged();
        target.setImplicitRank(source.getImplicitRank());
    L16:
        if (source.getIcon() == null) goto L18;
        boolean replacingIcon = true;
    L19:
        if (replacingIcon == false) goto L21;
        ps.removeIcon(target);
    L21:
        target.copyNonNullFieldsFrom(source);
        target.setTimestamp(injectCurrentTimeMillis());
        if (replacingIcon == false) goto L24;
        saveIconAndFixUpShortcutLocked(ps, target);
    L24:
        if (replacingIcon == false) goto L26;
    L27:
        fixUpShortcutResourceNamesAndValues(target);
    L28:
        changedShortcuts.add(target);
        return;
    L26:
        if (source.hasStringResources() == false) goto L28;
    L18:
        replacingIcon = false;
        goto L19
    }

    public boolean addDynamicShortcuts(String packageName, ParceledListSlice shortcutInfoList, int userId) {
        verifyCaller(packageName, userId);
        boolean unlimited = injectHasUnlimitedShortcutsApiCallsPermission(injectBinderCallingPid(), injectBinderCallingUid());
        List<ShortcutInfo> newShortcuts = shortcutInfoList.getList();
        verifyShortcutInfoPackages(packageName, newShortcuts);
        int size = newShortcuts.size();
        List<ShortcutInfo> changedShortcuts = null;
        Object r4 = this.mServiceLock;
        monitor-enter(r4);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L8
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L8
        ps.ensureImmutableShortcutsNotIncluded(newShortcuts, true);     // Catch: Throwable -> L8
        ps.ensureNoBitmapIconIfShortcutIsLongLived(newShortcuts);     // Catch: Throwable -> L8
        fillInDefaultActivity(newShortcuts);     // Catch: Throwable -> L8
        ps.enforceShortcutCountsBeforeOperation(newShortcuts, 1);     // Catch: Throwable -> L8
        ps.clearAllImplicitRanks();     // Catch: Throwable -> L8
        assignImplicitRanks(newShortcuts);     // Catch: Throwable -> L8
        if (ps.tryApiCall(unlimited) == true) goto L10;
        monitor-exit(r4);     // Catch: Throwable -> L8
        return false;
    L10:
        int i = 0;
    L11:
        if (i >= size) goto L16;
        ShortcutInfo newShortcut = newShortcuts.get(i);     // Catch: Throwable -> L8
        fixUpIncomingShortcutInfo(newShortcut, false);     // Catch: Throwable -> L8
        newShortcut.setRankChanged();     // Catch: Throwable -> L8
        ps.addOrReplaceDynamicShortcut(newShortcut);     // Catch: Throwable -> L8
        if (changedShortcuts != null) goto L15;
        changedShortcuts = new ArrayList(1);     // Catch: Throwable -> L8
    L15:
        changedShortcuts.add(newShortcut);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L16:
        ps.adjustRanks();     // Catch: Throwable -> L8
        monitor-exit(r4);     // Catch: Throwable -> L8
        packageShortcutsChanged(ps, changedShortcuts, null);
        verifyStates();
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    public void pushDynamicShortcut(String packageName, ShortcutInfo shortcut, int userId) {
        verifyCaller(packageName, userId);
        verifyShortcutInfoPackage(packageName, shortcut);
        List<ShortcutInfo> changedShortcuts = new ArrayList();
        List<ShortcutInfo> removedShortcuts = null;
        Object r2 = this.mServiceLock;
        monitor-enter(r2);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L7
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L7
        ps.ensureNotImmutable(shortcut.getId(), true);     // Catch: Throwable -> L7
        fillInDefaultActivity(Arrays.asList(new ShortcutInfo[]{shortcut}));     // Catch: Throwable -> L7
        if (shortcut.hasRank() == true) goto L9;
        shortcut.setRank(0);     // Catch: Throwable -> L7
    L9:
        ps.clearAllImplicitRanks();     // Catch: Throwable -> L7
        shortcut.setImplicitRank(0);     // Catch: Throwable -> L7
        fixUpIncomingShortcutInfo(shortcut, false);     // Catch: Throwable -> L7
        shortcut.setRankChanged();     // Catch: Throwable -> L7
        boolean deleted = ps.pushDynamicShortcut(shortcut, changedShortcuts);     // Catch: Throwable -> L7
        if (deleted == true) goto L12;
    L16:
        changedShortcuts.add(shortcut);     // Catch: Throwable -> L7
        ps.adjustRanks();     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        packageShortcutsChanged(ps, changedShortcuts, removedShortcuts);
        ps.reportShortcutUsed(this.mUsageStatsManagerInternal, shortcut.getId());
        verifyStates();
        return;
    L12:
        if (changedShortcuts.isEmpty() == false) goto L15;
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L15:
        removedShortcuts = Collections.singletonList(changedShortcuts.get(0));     // Catch: Throwable -> L7
        changedShortcuts.clear();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public boolean requestPinShortcut(String packageName, ShortcutInfo shortcut, IntentSender resultIntent, int userId) {
        shortcut.getClass();
        Preconditions.checkArgument(shortcut.isEnabled(), "Shortcut must be enabled");
        Preconditions.checkArgument(true ^ shortcut.isExcludedFromSurfaces(1), "Shortcut excluded from launcher cannot be pinned");
        return requestPinItem(packageName, userId, shortcut, null, null, resultIntent);
    }

    public Intent createShortcutResultIntent(String packageName, ShortcutInfo shortcut, int userId) throws RemoteException {
        shortcut.getClass();
        Preconditions.checkArgument(shortcut.isEnabled(), "Shortcut must be enabled");
        verifyCaller(packageName, userId);
        verifyShortcutInfoPackage(packageName, shortcut);
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L8
        Intent intent = this.mShortcutRequestPinProcessor.createShortcutResultIntent(shortcut, userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        verifyStates();
        return intent;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean requestPinItem(String callingPackage, int userId, ShortcutInfo shortcut, AppWidgetProviderInfo appWidget, Bundle extras, IntentSender resultIntent) {
        return requestPinItem(callingPackage, userId, shortcut, appWidget, extras, resultIntent, injectBinderCallingPid(), injectBinderCallingUid());
    }

    private boolean requestPinItem(String callingPackage, int userId, ShortcutInfo shortcut, AppWidgetProviderInfo appWidget, Bundle extras, IntentSender resultIntent, int callingPid, int callingUid) {
        verifyCaller(callingPackage, userId);
        if (shortcut == null) goto L8;
        if (injectHasAccessShortcutsPermission(callingPid, callingUid) == false) goto L8;
    L9:
        Object r3 = this.mServiceLock;
        monitor-enter(r3);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L16
        Preconditions.checkState(isUidForegroundLocked(callingUid), "Calling application must have a foreground activity or a foreground service");     // Catch: Throwable -> L16
        if (shortcut == null) goto L18;
        String shortcutPackage = shortcut.getPackage();     // Catch: Throwable -> L16
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(shortcutPackage, userId);     // Catch: Throwable -> L16
        String id = shortcut.getId();     // Catch: Throwable -> L16
        if (ps.isShortcutExistsAndInvisibleToPublisher(id) == false) goto L18;
        ps.updateInvisibleShortcutForPinRequestWith(shortcut);     // Catch: Throwable -> L16
        packageShortcutsChanged(ps, Collections.singletonList(shortcut), null);     // Catch: Throwable -> L16
    L18:
        boolean ret = this.mShortcutRequestPinProcessor.requestPinItemLocked(shortcut, appWidget, extras, userId, resultIntent);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        verifyStates();
        return ret;
    L16:
        th = move-exception;
        throw th;
    L8:
        verifyShortcutInfoPackage(callingPackage, shortcut);
        goto L9
    }

    public void disableShortcuts(String packageName, List shortcutIds, CharSequence disabledMessage, int disabledMessageResId, int userId) {
        verifyCaller(packageName, userId);
        shortcutIds.getClass();
        List<ShortcutInfo> changedShortcuts = null;
        List<ShortcutInfo> removedShortcuts = null;
        Object r7 = this.mServiceLock;
        monitor-enter(r7);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L18
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L18
        ps.ensureImmutableShortcutsNotIncludedWithIds(shortcutIds, true);     // Catch: Throwable -> L18
        if (disabledMessage != null) goto L8;
        String r9 = null;
    L7:
        String disabledMessageString = r9;
        int i = shortcutIds.size() - 1;     // Catch: Throwable -> L18
    L10:
        if (i < 0) goto L25;
        String id = (String) Preconditions.checkStringNotEmpty((String) shortcutIds.get(i));     // Catch: Throwable -> L18
        if (ps.isShortcutExistsAndVisibleToPublisher(id) == false) goto L24;
        ShortcutInfo deleted = ps.disableWithId(id, disabledMessageString, disabledMessageResId, false, true, 1);     // Catch: Throwable -> L18
        if (deleted != null) goto L21;
        if (changedShortcuts != null) goto L20;
        changedShortcuts = new ArrayList(1);     // Catch: Throwable -> L18
    L20:
        changedShortcuts.add(ps.findShortcutById(id));     // Catch: Throwable -> L18
        goto L24
    L21:
        if (removedShortcuts != null) goto L23;
        removedShortcuts = new ArrayList(1);     // Catch: Throwable -> L18
    L23:
        removedShortcuts.add(deleted);     // Catch: Throwable -> L18
    L24:
        i = i - 1;     // Catch: Throwable -> L18
        goto L10
    L25:
        ps.adjustRanks();     // Catch: Throwable -> L18
        monitor-exit(r7);     // Catch: Throwable -> L18
        packageShortcutsChanged(ps, changedShortcuts, removedShortcuts);
        verifyStates();
        return;
    L8:
        r9 = disabledMessage.toString();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public void enableShortcuts(String packageName, List shortcutIds, int userId) {
        verifyCaller(packageName, userId);
        shortcutIds.getClass();
        List<ShortcutInfo> changedShortcuts = null;
        Object r1 = this.mServiceLock;
        monitor-enter(r1);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L12
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L12
        ps.ensureImmutableShortcutsNotIncludedWithIds(shortcutIds, true);     // Catch: Throwable -> L12
        int i = shortcutIds.size() - 1;     // Catch: Throwable -> L12
    L5:
        if (i < 0) goto L17;
        String id = (String) Preconditions.checkStringNotEmpty((String) shortcutIds.get(i));     // Catch: Throwable -> L12
        if (ps.isShortcutExistsAndVisibleToPublisher(id) == false) goto L15;
        ps.enableWithId(id);     // Catch: Throwable -> L12
        if (changedShortcuts != null) goto L14;
        changedShortcuts = new ArrayList(1);     // Catch: Throwable -> L12
    L14:
        changedShortcuts.add(ps.findShortcutById(id));     // Catch: Throwable -> L12
    L15:
        i = i - 1;     // Catch: Throwable -> L12
        goto L5
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L12
        packageShortcutsChanged(ps, changedShortcuts, null);
        verifyStates();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void removeDynamicShortcuts(String packageName, List<String> shortcutIds, int userId) {
        verifyCaller(packageName, userId);
        shortcutIds.getClass();
        List<ShortcutInfo> changedShortcuts = null;
        List<ShortcutInfo> removedShortcuts = null;
        Object r2 = this.mServiceLock;
        monitor-enter(r2);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L13
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L13
        ps.ensureImmutableShortcutsNotIncludedWithIds(shortcutIds, true);     // Catch: Throwable -> L13
        int i = shortcutIds.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (i < 0) goto L20;
        String id = (String) Preconditions.checkStringNotEmpty(shortcutIds.get(i));     // Catch: Throwable -> L13
        if (ps.isShortcutExistsAndVisibleToPublisher(id) == false) goto L19;
        ShortcutInfo removed = ps.deleteDynamicWithId(id, true);     // Catch: Throwable -> L13
        if (removed != null) goto L16;
        if (changedShortcuts != null) goto L15;
        changedShortcuts = new ArrayList(1);     // Catch: Throwable -> L13
    L15:
        changedShortcuts.add(ps.findShortcutById(id));     // Catch: Throwable -> L13
        goto L19
    L16:
        if (removedShortcuts != null) goto L18;
        removedShortcuts = new ArrayList(1);     // Catch: Throwable -> L13
    L18:
        removedShortcuts.add(removed);     // Catch: Throwable -> L13
    L19:
        i = i - 1;     // Catch: Throwable -> L13
        goto L5
    L20:
        ps.adjustRanks();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        packageShortcutsChanged(ps, changedShortcuts, removedShortcuts);
        verifyStates();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void removeAllDynamicShortcuts(String packageName, int userId) {
        verifyCaller(packageName, userId);
        List<ShortcutInfo> changedShortcuts = new ArrayList();
        Object r2 = this.mServiceLock;
        monitor-enter(r2);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L8
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L8
        ps.findAll(changedShortcuts, new ShortcutService$$ExternalSyntheticLambda20(), 4);     // Catch: Throwable -> L8
        List<ShortcutInfo> removedShortcuts = ps.deleteAllDynamicShortcuts();     // Catch: Throwable -> L8
        List<ShortcutInfo> changedShortcuts2 = prepareChangedShortcuts(changedShortcuts, null, removedShortcuts, ps);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        packageShortcutsChanged(ps, changedShortcuts2, removedShortcuts);
        verifyStates();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeAllDynamicShortcuts$6(ShortcutInfo si) {
        if (si.isVisibleToPublisher() == true) goto L5;
    L11:
        return false;
    L5:
        if (si.isDynamic() == false) goto L11;
        if (si.isCached() == false) goto L9;
    L10:
        return true;
    L9:
        if (si.isPinned() == false) goto L11;
        goto L10
    }

    public void removeLongLivedShortcuts(String packageName, List shortcutIds, int userId) {
        verifyCaller(packageName, userId);
        shortcutIds.getClass();
        List<ShortcutInfo> changedShortcuts = null;
        List<ShortcutInfo> removedShortcuts = null;
        Object r2 = this.mServiceLock;
        monitor-enter(r2);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L13
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L13
        ps.ensureImmutableShortcutsNotIncludedWithIds(shortcutIds, true);     // Catch: Throwable -> L13
        int i = shortcutIds.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (i < 0) goto L20;
        String id = (String) Preconditions.checkStringNotEmpty((String) shortcutIds.get(i));     // Catch: Throwable -> L13
        if (ps.isShortcutExistsAndVisibleToPublisher(id) == false) goto L19;
        ShortcutInfo removed = ps.deleteLongLivedWithId(id, true);     // Catch: Throwable -> L13
        if (removed == null) goto L16;
        if (removedShortcuts != null) goto L15;
        removedShortcuts = new ArrayList(1);     // Catch: Throwable -> L13
    L15:
        removedShortcuts.add(removed);     // Catch: Throwable -> L13
        goto L19
    L16:
        if (changedShortcuts != null) goto L18;
        changedShortcuts = new ArrayList(1);     // Catch: Throwable -> L13
    L18:
        changedShortcuts.add(ps.findShortcutById(id));     // Catch: Throwable -> L13
    L19:
        i = i - 1;     // Catch: Throwable -> L13
        goto L5
    L20:
        ps.adjustRanks();     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        packageShortcutsChanged(ps, changedShortcuts, removedShortcuts);
        verifyStates();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public ParceledListSlice<ShortcutInfo> getShortcuts(String packageName, int matchFlags, int userId) {
        verifyCaller(packageName, userId);
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L36
        int r2 = 1;
        int r3 = 0;
        if ((matchFlags & 2) == 0) goto L7;
        boolean matchDynamic = true;
    L9:
        if ((matchFlags & 4) == 0) goto L11;
        boolean matchPinned = true;
    L13:
        if ((matchFlags & 1) == 0) goto L15;
        boolean matchManifest = true;
    L17:
        if ((matchFlags & 8) == 0) goto L19;
        boolean matchCached = true;
    L20:
        if (matchDynamic == true) goto L23;
        r2 = 0;
    L23:
        if (matchPinned == false) goto L25;
        int r7 = 2;
    L26:
        int r4 = r2 | r7;     // Catch: Throwable -> L36
        if (matchManifest == false) goto L29;
        int r8 = 32;
    L30:
        int r5 = r4 | r8;     // Catch: Throwable -> L36
        if (matchCached == false) goto L33;
        r3 = 1610629120;
    L33:
        final int shortcutFlags = r5 | r3;     // Catch: Throwable -> L36
        ParceledListSlice<ShortcutInfo> r6 = getShortcutsWithQueryLocked(packageName, userId, 9, new ShortcutService$$ExternalSyntheticLambda9(shortcutFlags));     // Catch: Throwable -> L36
        monitor-exit(r0);     // Catch: Throwable -> L36
        return r6;
    L29:
        r8 = 0;
        goto L30
    L25:
        r7 = 0;
        goto L26
    L19:
        matchCached = false;
        goto L20
    L15:
        matchManifest = false;
        goto L17
    L11:
        matchPinned = false;
        goto L13
    L7:
        matchDynamic = false;
    L36:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getShortcuts$7(int shortcutFlags, ShortcutInfo si) {
        if (si.isVisibleToPublisher() == true) goto L5;
    L7:
        return false;
    L5:
        if ((si.getFlags() & shortcutFlags) == 0) goto L7;
        return true;
    }

    public ParceledListSlice getShareTargets(String packageName, final IntentFilter filter, final int userId) {
        Preconditions.checkStringNotEmpty(packageName, "packageName");
        filter.getClass();
        if (isCallerChooserActivity() == true) goto L5;
        verifyCaller(packageName, userId);
    L5:
        enforceCallingOrSelfPermission("android.permission.MANAGE_APP_PREDICTIONS", "getShareTargets");
        ComponentName chooser = injectChooserActivity();
        if (chooser == null) goto L8;
        String r0 = chooser.getPackageName();
    L9:
        final String pkg = r0;
        Object r8 = this.mServiceLock;
        monitor-enter(r8);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L18
        final List<ShortcutManager.ShareShortcutInfo> shortcutInfoList = new ArrayList();     // Catch: Throwable -> L18
        ShortcutUser user = getUserShortcutsLocked(userId);     // Catch: Throwable -> L18
        user.forAllPackages(new ShortcutService$$ExternalSyntheticLambda22(this, shortcutInfoList, filter, pkg, userId));     // Catch: Throwable -> L16
        ParceledListSlice r11 = new ParceledListSlice(shortcutInfoList);     // Catch: Throwable -> L16
        monitor-exit(r8);     // Catch: Throwable -> L16
        return r11;
    L16:
        th = move-exception;
        Throwable r12 = th;
    L20:
        monitor-exit(r8);     // Catch: Throwable -> L16
        throw r12;
    L18:
        th = move-exception;
        r12 = th;
        goto L20
    L8:
        r0 = this.mContext.getPackageName();
        goto L9
    }

    private /* synthetic */ void lambda$getShareTargets$8(List shortcutInfoList, IntentFilter filter, String pkg, int userId, ShortcutPackage p) {
        shortcutInfoList.addAll(p.getMatchingShareTargets(filter, pkg, this.mUserManagerInternal.getProfileParentId(userId)));
    }

    public boolean hasShareTargets(String packageName, String packageToCheck, int userId) {
        verifyCaller(packageName, userId);
        enforceCallingOrSelfPermission("android.permission.MANAGE_APP_PREDICTIONS", "hasShareTargets");
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L7
        boolean r1 = getPackageShortcutsLocked(packageToCheck, userId).hasShareTargets();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isSharingShortcut(int callingUserId, String callingPackage, String packageName, String shortcutId, int userId, IntentFilter filter) {
        verifyCaller(callingPackage, callingUserId);
        enforceCallingOrSelfPermission("android.permission.MANAGE_APP_PREDICTIONS", "isSharingShortcut");
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L11
        throwIfUserLockedL(callingUserId);     // Catch: Throwable -> L11
        List<ShortcutManager.ShareShortcutInfo> matchedTargets = getPackageShortcutsLocked(packageName, userId).getMatchingShareTargets(filter, this.mUserManagerInternal.getProfileParentId(callingUserId));     // Catch: Throwable -> L11
        int matchedSize = matchedTargets.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= matchedSize) goto L15;
        if (matchedTargets.get(i).getShortcutInfo().getId().equals(shortcutId) == true) goto L8;
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    private ParceledListSlice<ShortcutInfo> getShortcutsWithQueryLocked(String packageName, int userId, int cloneFlags, Predicate<ShortcutInfo> filter) {
        ArrayList<ShortcutInfo> ret = new ArrayList();
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);
        ps.findAll(ret, filter, cloneFlags);
        return new ParceledListSlice(setReturnedByServer(ret));
    }

    public int getMaxShortcutCountPerActivity(String packageName, int userId) throws RemoteException {
        verifyCaller(packageName, userId);
        return this.mMaxShortcuts;
    }

    public int getRemainingCallCount(String packageName, int userId) {
        verifyCaller(packageName, userId);
        boolean unlimited = injectHasUnlimitedShortcutsApiCallsPermission(injectBinderCallingPid(), injectBinderCallingUid());
        Object r1 = this.mServiceLock;
        monitor-enter(r1);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L7
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L7
        int r3 = this.mMaxUpdatesPerInterval - ps.getApiCallCount(unlimited);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public long getRateLimitResetTime(String packageName, int userId) {
        verifyCaller(packageName, userId);
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L7
        long r1 = getNextResetTimeLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getIconMaxDimensions(String packageName, int userId) {
        verifyCaller(packageName, userId);
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        int r1 = this.mMaxIconDimension;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void reportShortcutUsed(String packageName, String shortcutId, int userId) {
        verifyCaller(packageName, userId);
        shortcutId.getClass();
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L9
        ShortcutPackage ps = getPackageShortcutsForPublisherLocked(packageName, userId);     // Catch: Throwable -> L9
        if (ps.findShortcutById(shortcutId) != null) goto L11;
        Log.w(TAG, String.format("reportShortcutUsed: package %s doesn't have shortcut %s", new Object[]{packageName, shortcutId}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        ps.reportShortcutUsed(this.mUsageStatsManagerInternal, shortcutId);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isRequestPinItemSupported(int callingUserId, int requestType) {
        verifyCallerUserId(callingUserId);
        long token = injectClearCallingIdentity();
        boolean r2 = this.mShortcutRequestPinProcessor.isRequestPinItemSupported(callingUserId, requestType);     // Catch: Throwable -> L6
        injectRestoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        throw th;
    }

    public void resetThrottling() {
        enforceSystemOrShell();
        resetThrottlingInner(getCallingUserId());
    }

    void resetThrottlingInner(int userId) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isUserUnlockedL(userId) == true) goto L11;
        Log.w(TAG, "User (with userId=" + userId + ") is locked or not running");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        getUserShortcutsLocked(userId).resetThrottling();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        scheduleSaveUser(userId);
        Slog.i(TAG, "ShortcutManager: throttling counter reset for userId=" + userId);
    }

    void resetAllThrottlingInner() {
        this.mRawLastResetTime.set(injectCurrentTimeMillis());
        scheduleSaveBaseState();
        Slog.i(TAG, "ShortcutManager: throttling counter reset for all users");
    }

    public void onApplicationActive(String packageName, int userId) {
        enforceResetThrottlingPermission();
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isUserUnlockedL(userId) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        getPackageShortcutsLocked(packageName, userId).resetRateLimitingForCommandLineNoSaving();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        injectSaveUser(userId);
    }

    boolean hasShortcutHostPermission(String callingPackage, int userId, int callingPid, int callingUid) {
        if (canSeeAnyPinnedShortcut(callingPackage, userId, callingPid, callingUid) == false) goto L6;
        return true;
    L6:
        long start = getStatStartTime();
        boolean r3 = hasShortcutHostPermissionInner(callingPackage, userId);     // Catch: Throwable -> L10
        logDurationStat(4, start);
        return r3;
    L10:
        th = move-exception;
        logDurationStat(4, start);
        throw th;
    }

    boolean canSeeAnyPinnedShortcut(String callingPackage, int userId, int callingPid, int callingUid) {
        if (injectHasAccessShortcutsPermission(callingPid, callingUid) == false) goto L6;
        return true;
    L6:
        Object r0 = this.mNonPersistentUsersLock;
        monitor-enter(r0);
        boolean r1 = getNonPersistentUserLocked(userId).hasHostPackage(callingPackage);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    boolean injectHasAccessShortcutsPermission(int callingPid, int callingUid) {
        if (this.mContext.checkPermission("android.permission.ACCESS_SHORTCUTS", callingPid, callingUid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean injectHasUnlimitedShortcutsApiCallsPermission(int callingPid, int callingUid) {
        if (this.mContext.checkPermission("android.permission.UNLIMITED_SHORTCUTS_API_CALLS", callingPid, callingUid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasShortcutHostPermissionInner(String packageName, int userId) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        throwIfUserLockedL(userId);     // Catch: Throwable -> L9
        String defaultLauncher = getDefaultLauncher(userId);     // Catch: Throwable -> L9
        if (defaultLauncher == null) goto L11;
        boolean r2 = defaultLauncher.equals(packageName);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    boolean areShortcutsSupportedOnHomeScreen(int userId) {
        long start = getStatStartTime();
        long token = injectClearCallingIdentity();
        Object r5 = this.mServiceLock;     // Catch: Throwable -> L15
        monitor-enter(r5);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L6:
        if (this.mUserManagerInternal.getUserProperties(userId).areItemsRestrictedOnHomeScreen() == true) goto L8;
        boolean isSupported = true;
    L9:
        monitor-exit(r5);     // Catch: Throwable -> L12
        injectRestoreCallingIdentity(token);
        logDurationStat(16, start);
        return isSupported;
    L8:
        isSupported = false;
    L15:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        logDurationStat(16, start);
        throw th;
    }

    String getDefaultLauncher(int userId) {
        long start = getStatStartTime();
        long token = injectClearCallingIdentity();
        Object r5 = this.mServiceLock;     // Catch: Throwable -> L21
        monitor-enter(r5);     // Catch: Throwable -> L21
        throwIfUserLockedL(userId);     // Catch: Throwable -> L10
        ShortcutUser user = getUserShortcutsLocked(userId);     // Catch: Throwable -> L10
        String cachedLauncher = user.getCachedLauncher();     // Catch: Throwable -> L10
        if (cachedLauncher == null) goto L12;
        monitor-exit(r5);     // Catch: Throwable -> L10
        injectRestoreCallingIdentity(token);
        logDurationStat(16, start);
        return cachedLauncher;
    L12:
        long startGetHomeRoleHoldersAsUser = getStatStartTime();     // Catch: Throwable -> L10
        String defaultLauncher = injectGetHomeRoleHolderAsUser(getParentOrSelfUserId(userId));     // Catch: Throwable -> L10
        logDurationStat(0, startGetHomeRoleHoldersAsUser);     // Catch: Throwable -> L10
        if (defaultLauncher == null) goto L15;
        user.setCachedLauncher(defaultLauncher);     // Catch: Throwable -> L10
    L16:
        monitor-exit(r5);     // Catch: Throwable -> L10
        injectRestoreCallingIdentity(token);
        logDurationStat(16, start);
        return defaultLauncher;
    L15:
        Slog.e(TAG, "Default launcher not found. userId=" + userId);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        logDurationStat(16, start);
        throw th;
    }

    public void setShortcutHostPackage(String type, String packageName, int userId) {
        Object r0 = this.mNonPersistentUsersLock;
        monitor-enter(r0);
        getNonPersistentUserLocked(userId).setShortcutHostPackage(type, packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void cleanUpPackageForAllLoadedUsers(final String packageName, final int packageUserId, final boolean appStillExists) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        forEachLoadedUserLocked(new ShortcutService$$ExternalSyntheticLambda8(this, packageName, packageUserId, appStillExists));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$cleanUpPackageForAllLoadedUsers$9(String packageName, int packageUserId, boolean appStillExists, ShortcutUser user) {
        cleanUpPackageLocked(packageName, user.getUserId(), packageUserId, appStillExists);
    }

    void cleanUpPackageLocked(final String packageName, int owningUserId, final int packageUserId, boolean appStillExists) {
        boolean wasUserLoaded = isUserLoadedLocked(owningUserId);
        ShortcutUser user = getUserShortcutsLocked(owningUserId);
        boolean doNotify = false;
        if (packageUserId != owningUserId) goto L5;
        final ShortcutPackage sp = user.removePackage(packageName);
    L6:
        if (sp == null) goto L8;
        doNotify = true;
    L8:
        user.removeLauncher(packageUserId, packageName);
        user.forAllLaunchers(new ShortcutService$$ExternalSyntheticLambda3(packageName, packageUserId));
        user.forAllPackages(new ShortcutService$$ExternalSyntheticLambda4());
        if (doNotify == false) goto L11;
        notifyListeners(packageName, owningUserId);
    L11:
        if (appStillExists == false) goto L14;
        if (packageUserId != owningUserId) goto L14;
        user.rescanPackageIfNeeded(packageName, true);
    L14:
        if (appStillExists == true) goto L18;
        if (packageUserId != owningUserId) goto L18;
        if (sp == null) goto L18;
        injectPostToHandler(new ShortcutService$$ExternalSyntheticLambda5(sp));
    L18:
        if (wasUserLoaded == true) goto L21;
        unloadUserLocked(owningUserId);
        return;
    L21:
        return;
    L5:
        sp = null;
        goto L6
    }

    private static /* synthetic */ void lambda$cleanUpPackageLocked$10(String packageName, int packageUserId, ShortcutLauncher l) {
        l.cleanUpPackage(packageName, packageUserId);
    }

    private static /* synthetic */ void lambda$cleanUpPackageLocked$11(ShortcutPackage p) {
        p.refreshPinnedFlags();
    }

    private static /* synthetic */ void lambda$cleanUpPackageLocked$12(ShortcutPackage sp) {
        sp.removeShortcutPackageItem();
    }

    void handleLocaleChanged() {
        scheduleSaveBaseState();
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        long token = injectClearCallingIdentity();     // Catch: Throwable -> L9
        forEachLoadedUserLocked(new ShortcutService$$ExternalSyntheticLambda16());     // Catch: Throwable -> L11
        injectRestoreCallingIdentity(token);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        injectRestoreCallingIdentity(token);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$handleLocaleChanged$13(ShortcutUser user) {
        user.detectLocaleChange();
    }

    void checkPackageChanges(int ownerUserId) {
        if (injectIsSafeModeEnabled() == false) goto L6;
        Slog.i(TAG, "Safe mode, skipping checkPackageChanges()");
        return;
    L6:
        long start = getStatStartTime();
        final ArrayList<UserPackage> gonePackages = new ArrayList();     // Catch: Throwable -> L22
        Object r4 = this.mServiceLock;     // Catch: Throwable -> L22
        monitor-enter(r4);     // Catch: Throwable -> L22
        ShortcutUser user = getUserShortcutsLocked(ownerUserId);     // Catch: Throwable -> L14
        user.forAllPackageItems(new ShortcutService$$ExternalSyntheticLambda18(this, gonePackages));     // Catch: Throwable -> L14
        if (gonePackages.size() <= 0) goto L16;
        int i = gonePackages.size() - 1;     // Catch: Throwable -> L14
    L12:
        if (i < 0) goto L16;
        UserPackage up = gonePackages.get(i);     // Catch: Throwable -> L14
        cleanUpPackageLocked(up.packageName, ownerUserId, up.userId, false);     // Catch: Throwable -> L14
        i = i - 1;     // Catch: Throwable -> L14
    L16:
        rescanUpdatedPackagesLocked(ownerUserId, user.getLastAppScanTime());     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        logDurationStat(8, start);
        verifyStates();
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        logDurationStat(8, start);
        throw th;
    }

    private /* synthetic */ void lambda$checkPackageChanges$14(ArrayList gonePackages, ShortcutPackageItem spi) {
        if (spi.getPackageInfo().isShadow() == false) goto L6;
        return;
    L6:
        if (isPackageInstalled(spi.getPackageName(), spi.getPackageUserId()) == true) goto L9;
        gonePackages.add(UserPackage.of(spi.getPackageUserId(), spi.getPackageName()));
        return;
    }

    private void rescanUpdatedPackagesLocked(final int userId, long lastScanTime) {
        final ShortcutUser user = getUserShortcutsLocked(userId);
        long now = injectCurrentTimeMillis();
        boolean afterOta = !injectBuildFingerprint().equals(user.getLastAppScanOsFingerprint());
        forUpdatedPackages(userId, lastScanTime, afterOta, new ShortcutService$$ExternalSyntheticLambda23(this, user, userId));
        user.setLastAppScanTime(now);
        user.setLastAppScanOsFingerprint(injectBuildFingerprint());
        scheduleSaveUser(userId);
    }

    private /* synthetic */ void lambda$rescanUpdatedPackagesLocked$15(ShortcutUser user, int userId, ApplicationInfo ai) {
        user.attemptToRestoreIfNeededAndSave(this, ai.packageName, userId);
        user.rescanPackageIfNeeded(ai.packageName, true);
    }

    private void handlePackageAdded(String packageName, int userId) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        ShortcutUser user = getUserShortcutsLocked(userId);     // Catch: Throwable -> L8
        user.attemptToRestoreIfNeededAndSave(this, packageName, userId);     // Catch: Throwable -> L8
        user.rescanPackageIfNeeded(packageName, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        verifyStates();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void handlePackageUpdateFinished(String packageName, int userId) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        ShortcutUser user = getUserShortcutsLocked(userId);     // Catch: Throwable -> L7
        user.attemptToRestoreIfNeededAndSave(this, packageName, userId);     // Catch: Throwable -> L7
        if (isPackageInstalled(packageName, userId) == false) goto L9;
        user.rescanPackageIfNeeded(packageName, true);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        verifyStates();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void handlePackageRemoved(String packageName, int packageUserId) {
        cleanUpPackageForAllLoadedUsers(packageName, packageUserId, false);
        verifyStates();
    }

    private void handlePackageDataCleared(String packageName, int packageUserId) {
        cleanUpPackageForAllLoadedUsers(packageName, packageUserId, true);
        verifyStates();
    }

    private void handlePackageChanged(String packageName, int packageUserId) {
        if (isPackageInstalled(packageName, packageUserId) == true) goto L6;
        handlePackageRemoved(packageName, packageUserId);
        return;
    L6:
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        ShortcutUser user = getUserShortcutsLocked(packageUserId);     // Catch: Throwable -> L12
        user.rescanPackageIfNeeded(packageName, true);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        verifyStates();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    final PackageInfo getPackageInfoWithSignatures(String packageName, int userId) {
        return getPackageInfo(packageName, userId, true);
    }

    final PackageInfo getPackageInfo(String packageName, int userId) {
        return getPackageInfo(packageName, userId, false);
    }

    int injectGetPackageUid(String packageName, int userId) {
        long token = injectClearCallingIdentity();
        int r2 = this.mIPackageManager.getPackageUid(packageName, 795136, userId);     // Catch: Throwable -> L6 RemoteException -> L8
        injectRestoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        throw th;
    L8:
        e = move-exception;
        Slog.wtf(TAG, "RemoteException", e);     // Catch: Throwable -> L6
        injectRestoreCallingIdentity(token);
        return -1;
    }

    final PackageInfo getPackageInfo(String packageName, int userId, boolean getSignatures) {
        return isInstalledOrNull(injectPackageInfoWithUninstalled(packageName, userId, getSignatures));
    }

    PackageInfo injectPackageInfoWithUninstalled(String packageName, int userId, boolean getSignatures) {
        long start = getStatStartTime();
        long token = injectClearCallingIdentity();
        int r4 = 1;
        IPackageManager r6 = this.mIPackageManager;     // Catch: Throwable -> L13 RemoteException -> L15
        if (getSignatures == false) goto L6;
        int r7 = 134217728;
    L7:
        PackageInfo r8 = r6.getPackageInfo(packageName, r7 | PACKAGE_MATCH_FLAGS, userId);     // Catch: Throwable -> L13 RemoteException -> L15
        injectRestoreCallingIdentity(token);
        if (getSignatures == false) goto L11;
        r4 = 2;
    L11:
        logDurationStat(r4, start);
        return r8;
    L6:
        r7 = 0;
    L13:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        if (getSignatures == false) goto L25;
        r4 = 2;
    L25:
        logDurationStat(r4, start);
        throw th;
    L15:
        e = move-exception;
        Slog.wtf(TAG, "RemoteException", e);     // Catch: Throwable -> L13
        injectRestoreCallingIdentity(token);
        if (getSignatures == false) goto L20;
        r4 = 2;
    L20:
        logDurationStat(r4, start);
        return null;
    }

    final ApplicationInfo getApplicationInfo(String packageName, int userId) {
        return isInstalledOrNull(injectApplicationInfoWithUninstalled(packageName, userId));
    }

    ApplicationInfo injectApplicationInfoWithUninstalled(String packageName, int userId) {
        long start = getStatStartTime();
        long token = injectClearCallingIdentity();
        ApplicationInfo r5 = this.mIPackageManager.getApplicationInfo(packageName, 795136, userId);     // Catch: Throwable -> L6 RemoteException -> L8
        injectRestoreCallingIdentity(token);
        logDurationStat(3, start);
        return r5;
    L6:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        logDurationStat(3, start);
        throw th;
    L8:
        e = move-exception;
        Slog.wtf(TAG, "RemoteException", e);     // Catch: Throwable -> L6
        injectRestoreCallingIdentity(token);
        logDurationStat(3, start);
        return null;
    }

    final ActivityInfo getActivityInfoWithMetadata(ComponentName activity, int userId) {
        return isInstalledOrNull(injectGetActivityInfoWithMetadataWithUninstalled(activity, userId));
    }

    ActivityInfo injectGetActivityInfoWithMetadataWithUninstalled(ComponentName activity, int userId) {
        long start = getStatStartTime();
        long token = injectClearCallingIdentity();
        ActivityInfo r5 = this.mIPackageManager.getActivityInfo(activity, 795264, userId);     // Catch: Throwable -> L6 RemoteException -> L8
        injectRestoreCallingIdentity(token);
        logDurationStat(6, start);
        return r5;
    L6:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        logDurationStat(6, start);
        throw th;
    L8:
        e = move-exception;
        Slog.wtf(TAG, "RemoteException", e);     // Catch: Throwable -> L6
        injectRestoreCallingIdentity(token);
        logDurationStat(6, start);
        return null;
    }

    final List<PackageInfo> getInstalledPackages(int userId) {
        long start = getStatStartTime();
        long token = injectClearCallingIdentity();
        List<PackageInfo> all = injectGetPackagesWithUninstalled(userId);     // Catch: Throwable -> L6 RemoteException -> L8
        all.removeIf(PACKAGE_NOT_INSTALLED);     // Catch: Throwable -> L6 RemoteException -> L8
        injectRestoreCallingIdentity(token);
        logDurationStat(7, start);
        return all;
    L8:
        e = move-exception;
        Slog.wtf(TAG, "RemoteException", e);     // Catch: Throwable -> L6
        injectRestoreCallingIdentity(token);
        logDurationStat(7, start);
        return null;
    L6:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        logDurationStat(7, start);
        throw th;
    }

    List<PackageInfo> injectGetPackagesWithUninstalled(int userId) throws RemoteException {
        ParceledListSlice<PackageInfo> parceledList = this.mIPackageManager.getInstalledPackages(795136, userId);
        if (parceledList != null) goto L7;
        return Collections.emptyList();
    L7:
        return parceledList.getList();
    }

    private void forUpdatedPackages(int userId, long lastScanTime, boolean afterOta, Consumer<ApplicationInfo> callback) {
        List<PackageInfo> list = getInstalledPackages(userId);
        int i = list.size() - 1;
    L3:
        if (i < 0) goto L11;
        PackageInfo pi = list.get(i);
        if (afterOta == false) goto L7;
    L8:
        callback.accept(pi.applicationInfo);
    L9:
        i = i - 1;
        goto L3
    L7:
        if (pi.lastUpdateTime < lastScanTime) goto L9;
    }

    private boolean isApplicationFlagSet(String packageName, int userId, int flags) {
        ApplicationInfo ai = injectApplicationInfoWithUninstalled(packageName, userId);
        if (ai != null) goto L5;
    L7:
        return false;
    L5:
        if ((ai.flags & flags) != flags) goto L7;
        return true;
    }

    private boolean isEnabled(ActivityInfo ai, int userId) {
        if (ai != null) goto L5;
        return false;
    L5:
        long token = injectClearCallingIdentity();
        int enabledFlag = this.mIPackageManager.getComponentEnabledSetting(ai.getComponentName(), userId);     // Catch: Throwable -> L14 RemoteException -> L16
        injectRestoreCallingIdentity(token);
        if (enabledFlag == 0) goto L10;
    L11:
        if (enabledFlag != 1) goto L13;
    L12:
        return true;
    L13:
        return false;
    L10:
        if (ai.enabled == true) goto L12;
    L14:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        throw th;
    L16:
        e = move-exception;
        Slog.wtf(TAG, "RemoteException", e);     // Catch: Throwable -> L14
        injectRestoreCallingIdentity(token);
        return false;
    }

    private static boolean isSystem(ActivityInfo ai) {
        if (ai != null) goto L4;
    L6:
        return false;
    L4:
        if (isSystem(ai.applicationInfo) == false) goto L6;
        return true;
    }

    private static boolean isSystem(ApplicationInfo ai) {
        if (ai != null) goto L4;
    L6:
        return false;
    L4:
        if ((ai.flags & 129) == 0) goto L6;
        return true;
    }

    private static boolean isInstalled(ApplicationInfo ai) {
        if (ai != null) goto L4;
    L8:
        return false;
    L4:
        if (ai.enabled == false) goto L8;
        if ((ai.flags & 8388608) == 0) goto L8;
        return true;
    }

    private static boolean isEphemeralApp(ApplicationInfo ai) {
        if (ai != null) goto L4;
    L6:
        return false;
    L4:
        if (ai.isInstantApp() == false) goto L6;
        return true;
    }

    private static boolean isInstalled(PackageInfo pi) {
        if (pi != null) goto L4;
    L6:
        return false;
    L4:
        if (isInstalled(pi.applicationInfo) == false) goto L6;
        return true;
    }

    private static boolean isInstalled(ActivityInfo ai) {
        if (ai != null) goto L4;
    L6:
        return false;
    L4:
        if (isInstalled(ai.applicationInfo) == false) goto L6;
        return true;
    }

    private static ApplicationInfo isInstalledOrNull(ApplicationInfo ai) {
        if (isInstalled(ai) == true) goto L7;
        return null;
    L7:
        return ai;
    }

    private static PackageInfo isInstalledOrNull(PackageInfo pi) {
        if (isInstalled(pi) == true) goto L7;
        return null;
    L7:
        return pi;
    }

    private static ActivityInfo isInstalledOrNull(ActivityInfo ai) {
        if (isInstalled(ai) == true) goto L7;
        return null;
    L7:
        return ai;
    }

    boolean isPackageInstalled(String packageName, int userId) {
        if (getApplicationInfo(packageName, userId) == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isEphemeralApp(String packageName, int userId) {
        return isEphemeralApp(getApplicationInfo(packageName, userId));
    }

    XmlResourceParser injectXmlMetaData(ActivityInfo activityInfo, String key) {
        return activityInfo.loadXmlMetaData(this.mContext.getPackageManager(), key);
    }

    Resources injectGetResourcesForApplicationAsUser(String packageName, int userId) {
        long start = getStatStartTime();
        long token = injectClearCallingIdentity();
        Resources r5 = this.mContext.createContextAsUser(UserHandle.of(userId), 0).getPackageManager().getResourcesForApplication(packageName);     // Catch: Throwable -> L6 PackageManager.NameNotFoundException -> L8
        injectRestoreCallingIdentity(token);
        logDurationStat(9, start);
        return r5;
    L6:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        logDurationStat(9, start);
        throw th;
    L9:
        Slog.e(TAG, "Resources of package " + packageName + " for userId=" + userId + " not found");     // Catch: Throwable -> L6
        injectRestoreCallingIdentity(token);
        logDurationStat(9, start);
        return null;
    }

    private Intent getMainActivityIntent() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory(LAUNCHER_INTENT_CATEGORY);
        return intent;
    }

    List<ResolveInfo> queryActivities(Intent baseIntent, String packageName, ComponentName activity, int userId) {
        packageName.getClass();
        baseIntent.setPackage(packageName);
        if (activity == null) goto L6;
        baseIntent.setComponent(activity);
    L6:
        return queryActivities(baseIntent, userId, true);
    }

    List<ResolveInfo> queryActivities(Intent intent, final int userId, boolean exportedOnly) {
        long token = injectClearCallingIdentity();
        List<ResolveInfo> resolved = this.mContext.getPackageManager().queryIntentActivitiesAsUser(intent, PACKAGE_MATCH_FLAGS, userId);     // Catch: Throwable -> L15
        injectRestoreCallingIdentity(token);
        if (resolved == null) goto L14;
        if (resolved.size() == 0) goto L14;
        resolved.removeIf(ACTIVITY_NOT_INSTALLED);
        resolved.removeIf(new ShortcutService$$ExternalSyntheticLambda29(this, userId));
        if (exportedOnly == false) goto L12;
        resolved.removeIf(ACTIVITY_NOT_EXPORTED);
    L12:
        return resolved;
    L14:
        return EMPTY_RESOLVE_INFO;
    L15:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        throw th;
    }

    private /* synthetic */ boolean lambda$queryActivities$16(int userId, ResolveInfo ri) {
        ActivityInfo ai = ri.activityInfo;
        if (isSystem(ai) == false) goto L5;
    L7:
        return false;
    L5:
        if (isEnabled(ai, userId) == true) goto L7;
        return true;
    }

    ComponentName injectGetDefaultMainActivity(String packageName, int userId) {
        long start = getStatStartTime();
        ComponentName r4 = null;
        List<ResolveInfo> resolved = queryActivities(getMainActivityIntent(), packageName, null, userId);     // Catch: Throwable -> L10
        if (resolved.size() == 0) goto L8;
        r4 = resolved.get(0).activityInfo.getComponentName();     // Catch: Throwable -> L10
    L8:
        logDurationStat(11, start);
        return r4;
    L10:
        th = move-exception;
        logDurationStat(11, start);
        throw th;
    }

    boolean injectIsMainActivity(ComponentName activity, int userId) {
        long start = getStatStartTime();
        boolean r2 = false;
        if (activity != null) goto L11;
        wtf("null activity detected");     // Catch: Throwable -> L7
        logDurationStat(12, start);
        return false;
    L11:
        if (DUMMY_MAIN_ACTIVITY.equals(activity.getClassName()) == false) goto L15;
        logDurationStat(12, start);
        return true;
    L15:
        List<ResolveInfo> resolved = queryActivities(getMainActivityIntent(), activity.getPackageName(), activity, userId);     // Catch: Throwable -> L7
        if (resolved.size() <= 0) goto L18;
        r2 = true;
    L18:
        logDurationStat(12, start);
        return r2;
    L7:
        th = move-exception;
        logDurationStat(12, start);
        throw th;
    }

    ComponentName getDummyMainActivity(String packageName) {
        return new ComponentName(packageName, DUMMY_MAIN_ACTIVITY);
    }

    boolean isDummyMainActivity(ComponentName name) {
        if (name != null) goto L4;
    L6:
        return false;
    L4:
        if (DUMMY_MAIN_ACTIVITY.equals(name.getClassName()) == false) goto L6;
        return true;
    }

    List<ResolveInfo> injectGetMainActivities(String packageName, int userId) {
        long start = getStatStartTime();
        List<ResolveInfo> r3 = queryActivities(getMainActivityIntent(), packageName, null, userId);     // Catch: Throwable -> L6
        logDurationStat(12, start);
        return r3;
    L6:
        th = move-exception;
        logDurationStat(12, start);
        throw th;
    }

    boolean injectIsActivityEnabledAndExported(ComponentName activity, int userId) {
        long start = getStatStartTime();
        if (queryActivities(new Intent(), activity.getPackageName(), activity, userId).size() <= 0) goto L6;
        boolean r3 = true;
    L7:
        logDurationStat(13, start);
        return r3;
    L6:
        r3 = false;
    L9:
        th = move-exception;
        logDurationStat(13, start);
        throw th;
    }

    ComponentName injectGetPinConfirmationActivity(String launcherPackageName, int launcherUserId, int requestType) {
        launcherPackageName.getClass();
        if (requestType != 1) goto L5;
        String action = "android.content.pm.action.CONFIRM_PIN_SHORTCUT";
    L6:
        Intent confirmIntent = new Intent(action).setPackage(launcherPackageName);
        List<ResolveInfo> candidates = queryActivities(confirmIntent, launcherUserId, false);
        Iterator<ResolveInfo> r3 = candidates.iterator();
        if (r3.hasNext() == false) goto L10;
        ResolveInfo ri = r3.next();
        return ri.activityInfo.getComponentName();
    L10:
        return null;
    L5:
        action = "android.content.pm.action.CONFIRM_PIN_APPWIDGET";
        goto L6
    }

    boolean injectIsSafeModeEnabled() {
        long token = injectClearCallingIdentity();
        boolean r2 = IWindowManager.Stub.asInterface(ServiceManager.getService("window")).isSafeModeEnabled();     // Catch: Throwable -> L6 RemoteException -> L8
        injectRestoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        injectRestoreCallingIdentity(token);
        throw th;
    L12:
        injectRestoreCallingIdentity(token);
        return false;
    }

    int getParentOrSelfUserId(int userId) {
        return this.mUserManagerInternal.getProfileParentId(userId);
    }

    void injectSendIntentSender(IntentSender intentSender, Intent extras) {
        if (intentSender != null) goto L14;
        return;
    L14:
        ActivityOptions options = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(2);     // Catch: IntentSender.SendIntentException -> L10
        intentSender.sendIntent(this.mContext, 0, extras, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L8
        return;
    L8:
        e = move-exception;
        IntentSender.SendIntentException e = e;
    L12:
        Slog.w(TAG, "sendIntent failed().", e);
        return;
    L10:
        e = move-exception;
        e = e;
        goto L12
    }

    boolean shouldBackupApp(String packageName, int userId) {
        return isApplicationFlagSet(packageName, userId, 32768);
    }

    static boolean shouldBackupApp(PackageInfo pi) {
        if ((pi.applicationInfo.flags & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public byte[] getBackupPayload(int userId) {
        enforceSystem();
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isUserUnlockedL(userId) == true) goto L11;
        wtf("Can't backup: userId=" + userId + " is locked or not running");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        ShortcutUser user = getUserShortcutsLocked(userId);     // Catch: Throwable -> L9
        if (user != null) goto L16;
        wtf("Can't backup: user not found: userId=" + userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L16:
        user.forAllPackageItems(new ShortcutService$$ExternalSyntheticLambda26());     // Catch: Throwable -> L9
        user.forAllPackages(new ShortcutService$$ExternalSyntheticLambda27());     // Catch: Throwable -> L9
        user.forAllLaunchers(new ShortcutService$$ExternalSyntheticLambda28());     // Catch: Throwable -> L9
        scheduleSaveUser(userId);     // Catch: Throwable -> L9
        saveDirtyInfo();     // Catch: Throwable -> L9
        ByteArrayOutputStream os = new ByteArrayOutputStream(32768);     // Catch: Throwable -> L9
        saveUserInternalLocked(userId, os, true);     // Catch: Throwable -> L9 Throwable -> L22
        byte[] payload = os.toByteArray();     // Catch: Throwable -> L9
        this.mShortcutDumpFiles.save("backup-1-payload.txt", payload);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return payload;
    L22:
        e = move-exception;
        Slog.w(TAG, "Backup failed.", e);     // Catch: Throwable -> L9
        return null;
    }

    private static /* synthetic */ void lambda$getBackupPayload$17(ShortcutPackageItem spi) {
        spi.refreshPackageSignatureAndSave();
    }

    private static /* synthetic */ void lambda$getBackupPayload$18(ShortcutPackage pkg) {
        pkg.rescanPackageIfNeeded(false, true);
    }

    private static /* synthetic */ void lambda$getBackupPayload$19(ShortcutLauncher launcher) {
        launcher.ensurePackageInfo();
    }

    public void applyRestore(byte[] payload, int userId) {
        enforceSystem();
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isUserUnlockedL(userId) == true) goto L11;
        wtf("Can't restore: user (with userId=" + userId + ") is locked or not running");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mShortcutDumpFiles.save("restore-0-start.txt", new ShortcutService$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L9
        this.mShortcutDumpFiles.save("restore-1-payload.xml", payload);     // Catch: Throwable -> L9
        ByteArrayInputStream is = new ByteArrayInputStream(payload);     // Catch: Throwable -> L9
        ShortcutUser restored = loadUserInternal(userId, is, true);     // Catch: Throwable -> L9 Throwable -> L18
        this.mShortcutDumpFiles.save("restore-2.txt", new ShortcutService$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L9
        getUserShortcutsLocked(userId).mergeRestoredFile(restored);     // Catch: Throwable -> L9
        this.mShortcutDumpFiles.save("restore-3.txt", new ShortcutService$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L9
        rescanUpdatedPackagesLocked(userId, 0);     // Catch: Throwable -> L9
        this.mShortcutDumpFiles.save("restore-4.txt", new ShortcutService$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L9
        this.mShortcutDumpFiles.save("restore-5-finish.txt", new ShortcutService$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        injectSaveUser(userId);
        return;
    L18:
        e = move-exception;
        Slog.w(TAG, "Restoration failed.", e);     // Catch: Throwable -> L9
    }

    private /* synthetic */ void lambda$applyRestore$20(PrintWriter pw) {
        pw.print("Start time: ");
        dumpCurrentTime(pw);
        pw.println();
    }

    private /* synthetic */ void lambda$applyRestore$21(PrintWriter pw) {
        pw.print("Finish time: ");
        dumpCurrentTime(pw);
        pw.println();
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpAndUsageStatsPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        dumpNoCheck(fd, pw, args);
    }

    void dumpNoCheck(FileDescriptor fd, PrintWriter pw, String[] args) {
        DumpFilter filter = parseDumpArgs(args);
        if (filter.shouldDumpCheckIn() == false) goto L6;
        dumpCheckin(pw, filter.shouldCheckInClear());
        return;
    L6:
        if (filter.shouldDumpMain() == false) goto L9;
        dumpInner(pw, filter);
        pw.println();
    L9:
        if (filter.shouldDumpUid() == false) goto L12;
        dumpUid(pw);
        pw.println();
    L12:
        if (filter.shouldDumpFiles() == false) goto L16;
        dumpDumpFiles(pw);
        pw.println();
        return;
    }

    private static DumpFilter parseDumpArgs(String[] args) {
        DumpFilter filter = new DumpFilter();
        if (args != null) goto L5;
        return filter;
    L5:
        int argIndex = 0;
    L7:
        if (argIndex >= args.length) goto L66;
        int argIndex2 = argIndex + 1;
        String arg = args[argIndex];
        if ("-c".equals(arg) == true) goto L10;
        if ("--checkin".equals(arg) == true) goto L13;
        if ("-a".equals(arg) == true) goto L64;
        if ("--all".equals(arg) == true) goto L64;
        if ("-u".equals(arg) == true) goto L63;
        if ("--uid".equals(arg) == true) goto L63;
        if ("-f".equals(arg) == true) goto L62;
        if ("--files".equals(arg) == true) goto L62;
        if ("-n".equals(arg) == true) goto L61;
        if ("--no-main".equals(arg) == true) goto L61;
        if ("--user".equals(arg) == true) goto L37;
        if ("-p".equals(arg) == true) goto L57;
        if ("--package".equals(arg) == true) goto L57;
        if (arg.startsWith("-") == true) goto L55;
        argIndex = argIndex2;
        goto L66
    L55:
        throw new IllegalArgumentException("Unknown option " + arg);
    L57:
        if (argIndex2 >= args.length) goto L60;
        filter.addPackageRegex(args[argIndex2]);
        filter.setDumpDetails(false);
        argIndex = argIndex2 + 1;
        goto L7
    L60:
        throw new IllegalArgumentException("Missing package name for --package");
    L37:
        if (argIndex2 >= args.length) goto L45;
        int argIndex3 = argIndex2 + 1;
        filter.addUser(Integer.parseInt(args[argIndex2]));     // Catch: NumberFormatException -> L41
        argIndex = argIndex3;
    L41:
        e = move-exception;
        throw new IllegalArgumentException("Invalid user ID", e);
    L45:
        throw new IllegalArgumentException("Missing user ID for --user");
    L61:
        filter.setDumpMain(false);
    L65:
        argIndex = argIndex2;
    L62:
        filter.setDumpFiles(true);
    L63:
        filter.setDumpUid(true);
    L64:
        filter.setDumpUid(true);
        filter.setDumpFiles(true);
        goto L65
    L13:
        filter.setDumpCheckIn(true);
        filter.setCheckInClear(true);
        goto L65
    L10:
        filter.setDumpCheckIn(true);
    L66:
        int argIndex4 = args.length;
        if (argIndex >= argIndex4) goto L69;
        filter.addPackage(args[argIndex]);
        argIndex = argIndex + 1;
        goto L66
    L69:
        return filter;
    }

    private void dumpInner(PrintWriter pw) {
        dumpInner(pw, new DumpFilter());
    }

    private void dumpInner(PrintWriter pw, DumpFilter filter) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (filter.shouldDumpDetails() == false) goto L20;
        long now = injectCurrentTimeMillis();     // Catch: Throwable -> L16
        pw.print("Now: [");     // Catch: Throwable -> L16
        pw.print(now);     // Catch: Throwable -> L16
        pw.print("] ");     // Catch: Throwable -> L16
        pw.print(formatTime(now));     // Catch: Throwable -> L16
        pw.print("  Raw last reset: [");     // Catch: Throwable -> L16
        pw.print(this.mRawLastResetTime.get());     // Catch: Throwable -> L16
        pw.print("] ");     // Catch: Throwable -> L16
        pw.print(formatTime(this.mRawLastResetTime.get()));     // Catch: Throwable -> L16
        long last = getLastResetTimeLocked();     // Catch: Throwable -> L16
        pw.print("  Last reset: [");     // Catch: Throwable -> L16
        pw.print(last);     // Catch: Throwable -> L16
        pw.print("] ");     // Catch: Throwable -> L16
        pw.print(formatTime(last));     // Catch: Throwable -> L16
        long next = getNextResetTimeLocked();     // Catch: Throwable -> L16
        pw.print("  Next reset: [");     // Catch: Throwable -> L16
        pw.print(next);     // Catch: Throwable -> L16
        pw.print("] ");     // Catch: Throwable -> L16
        pw.print(formatTime(next));     // Catch: Throwable -> L16
        pw.println();     // Catch: Throwable -> L16
        pw.println();     // Catch: Throwable -> L16
        pw.print("  Config:");     // Catch: Throwable -> L16
        pw.print("    Max icon dim: ");     // Catch: Throwable -> L16
        pw.println(this.mMaxIconDimension);     // Catch: Throwable -> L16
        pw.print("    Icon format: ");     // Catch: Throwable -> L16
        pw.println(this.mIconPersistFormat);     // Catch: Throwable -> L16
        pw.print("    Icon quality: ");     // Catch: Throwable -> L16
        pw.println(this.mIconPersistQuality);     // Catch: Throwable -> L16
        pw.print("    saveDelayMillis: ");     // Catch: Throwable -> L16
        pw.println(this.mSaveDelayMillis);     // Catch: Throwable -> L16
        pw.print("    resetInterval: ");     // Catch: Throwable -> L16
        pw.println(this.mResetInterval);     // Catch: Throwable -> L16
        pw.print("    maxUpdatesPerInterval: ");     // Catch: Throwable -> L16
        pw.println(this.mMaxUpdatesPerInterval);     // Catch: Throwable -> L16
        pw.print("    maxShortcutsPerActivity: ");     // Catch: Throwable -> L16
        pw.println(this.mMaxShortcuts);     // Catch: Throwable -> L16
        pw.println();     // Catch: Throwable -> L16
        this.mStatLogger.dump(pw, "  ");     // Catch: Throwable -> L16
        Object r7 = this.mWtfLock;     // Catch: Throwable -> L16
        monitor-enter(r7);     // Catch: Throwable -> L16
        pw.println();     // Catch: Throwable -> L11
        pw.print("  #Failures: ");     // Catch: Throwable -> L11
        pw.println(this.mWtfCount);     // Catch: Throwable -> L11
        if (this.mLastWtfStacktrace == null) goto L13;
        pw.print("  Last failure stack trace: ");     // Catch: Throwable -> L11
        pw.println(Log.getStackTraceString(this.mLastWtfStacktrace));     // Catch: Throwable -> L11
    L13:
        monitor-exit(r7);     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L16
        goto L20
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L20:
        int i = 0;
    L22:
        if (i >= this.mUsers.size()) goto L27;
        ShortcutUser user = this.mUsers.valueAt(i);     // Catch: Throwable -> L16
        if (filter.isUserMatch(user.getUserId()) == false) goto L26;
        user.dump(pw, "  ", filter);     // Catch: Throwable -> L16
        pw.println();     // Catch: Throwable -> L16
    L26:
        i = i + 1;     // Catch: Throwable -> L16
        goto L22
    L27:
        int i2 = 0;
    L29:
        if (i2 >= this.mShortcutNonPersistentUsers.size()) goto L35;
        ShortcutNonPersistentUser user2 = this.mShortcutNonPersistentUsers.valueAt(i2);     // Catch: Throwable -> L16
        if (filter.isUserMatch(user2.getUserId()) == false) goto L33;
        user2.dump(pw, "  ", filter);     // Catch: Throwable -> L16
        pw.println();     // Catch: Throwable -> L16
    L33:
        i2 = i2 + 1;     // Catch: Throwable -> L16
        goto L29
    L35:
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    private void dumpUid(PrintWriter pw) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        pw.println("** SHORTCUT MANAGER UID STATES (dumpsys shortcut -n -u)");     // Catch: Throwable -> L10
        int i = 0;
    L6:
        if (i >= this.mUidState.size()) goto L14;
        int uid = this.mUidState.keyAt(i);     // Catch: Throwable -> L10
        int state = this.mUidState.valueAt(i);     // Catch: Throwable -> L10
        pw.print("    UID=");     // Catch: Throwable -> L10
        pw.print(uid);     // Catch: Throwable -> L10
        pw.print(" state=");     // Catch: Throwable -> L10
        pw.print(state);     // Catch: Throwable -> L10
        if (isProcessStateForeground(state) == false) goto L12;
        pw.print("  [FG]");     // Catch: Throwable -> L10
    L12:
        pw.print("  last FG=");     // Catch: Throwable -> L10
        pw.print(this.mUidLastForegroundElapsedTime.get(uid));     // Catch: Throwable -> L10
        pw.println();     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L6
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    static String formatTime(long time) {
        return TimeMigrationUtils.formatMillisWithFixedFormat(time);
    }

    private void dumpCurrentTime(PrintWriter pw) {
        pw.print(formatTime(injectCurrentTimeMillis()));
    }

    private void dumpCheckin(PrintWriter pw, boolean clear) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        JSONArray users = new JSONArray();     // Catch: Throwable -> L8 JSONException -> L10
        int i = 0;
    L6:
        if (i >= this.mUsers.size()) goto L12;
        users.put(this.mUsers.valueAt(i).dumpCheckin(clear));     // Catch: Throwable -> L8 JSONException -> L10
        i = i + 1;     // Catch: Throwable -> L8 JSONException -> L10
        goto L6
    L12:
        JSONObject result = new JSONObject();     // Catch: Throwable -> L8 JSONException -> L10
        result.put(KEY_SHORTCUT, users);     // Catch: Throwable -> L8 JSONException -> L10
        result.put(KEY_LOW_RAM, injectIsLowRamDevice());     // Catch: Throwable -> L8 JSONException -> L10
        result.put(KEY_ICON_SIZE, this.mMaxIconDimension);     // Catch: Throwable -> L8 JSONException -> L10
        pw.println(result.toString(1));     // Catch: Throwable -> L8 JSONException -> L10
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L10:
        e = move-exception;
        Slog.e(TAG, "Unable to write in json", e);     // Catch: Throwable -> L8
        goto L16
    }

    private void dumpDumpFiles(PrintWriter pw) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        pw.println("** SHORTCUT MANAGER FILES (dumpsys shortcut -n -f)");     // Catch: Throwable -> L7
        this.mShortcutDumpFiles.dumpAll(pw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        enforceShell();
        long token = injectClearCallingIdentity();
        int status = new MyShellCommand(this, null).exec(this, in, out, err, args, callback, resultReceiver);     // Catch: Throwable -> L8
        resultReceiver.send(status, null);     // Catch: Throwable -> L8
        injectRestoreCallingIdentity(token);
        return;
    L8:
        th = th;
    L12:
        injectRestoreCallingIdentity(token);
        throw th;
    L10:
        th = th;
        goto L12
    }

    long injectCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    long injectElapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    long injectUptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    int injectBinderCallingUid() {
        return IShortcutService.Stub.getCallingUid();
    }

    int injectBinderCallingPid() {
        return IShortcutService.Stub.getCallingPid();
    }

    private int getCallingUserId() {
        return UserHandle.getUserId(injectBinderCallingUid());
    }

    long injectClearCallingIdentity() {
        return Binder.clearCallingIdentity();
    }

    void injectRestoreCallingIdentity(long token) {
        Binder.restoreCallingIdentity(token);
    }

    String injectBuildFingerprint() {
        return Build.FINGERPRINT;
    }

    void injectFinishWrite(ResilientAtomicFile file, FileOutputStream os) throws IOException {
        file.finishWrite(os);
    }

    final void wtf(String message) {
        wtf(message, null);
    }

    void wtf(String message, Throwable e) {
        if (e != null) goto L4;
        e = new RuntimeException("Stacktrace");
    L4:
        Object r0 = this.mWtfLock;
        monitor-enter(r0);
        this.mWtfCount++;     // Catch: Throwable -> L10
        this.mLastWtfStacktrace = new Exception("Last failure was logged here:");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        Slog.wtf(TAG, message, e);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    File injectSystemDataPath() {
        return Environment.getDataSystemDirectory();
    }

    File injectUserDataPath(int userId) {
        return new File(Environment.getDataSystemCeDirectory(userId), DIRECTORY_PER_USER);
    }

    public File getDumpPath() {
        return new File(injectUserDataPath(0), DIRECTORY_DUMP);
    }

    boolean injectIsLowRamDevice() {
        return ActivityManager.isLowRamDeviceStatic();
    }

    void injectRegisterUidObserver(IUidObserver observer, int which) {
        ActivityManager.getService().registerUidObserver(observer, which, -1, null);     // Catch: RemoteException -> L4
        return;
    }

    void injectRegisterRoleHoldersListener(OnRoleHoldersChangedListener listener) {
        this.mRoleManager.addOnRoleHoldersChangedListenerAsUser(this.mContext.getMainExecutor(), listener, UserHandle.ALL);
    }

    String injectGetHomeRoleHolderAsUser(int userId) {
        List<String> roleHolders = this.mRoleManager.getRoleHoldersAsUser("android.app.role.HOME", UserHandle.of(userId));
        if (roleHolders.isEmpty() == false) goto L6;
        return null;
    L6:
        return roleHolders.get(0);
    }

    File getUserBitmapFilePath(int userId) {
        return new File(injectUserDataPath(userId), DIRECTORY_BITMAPS);
    }

    SparseArray<ShortcutUser> getShortcutsForTest() {
        return this.mUsers;
    }

    int getMaxShortcutsForTest() {
        return this.mMaxShortcuts;
    }

    int getMaxUpdatesPerIntervalForTest() {
        return this.mMaxUpdatesPerInterval;
    }

    long getResetIntervalForTest() {
        return this.mResetInterval;
    }

    int getMaxIconDimensionForTest() {
        return this.mMaxIconDimension;
    }

    Bitmap.CompressFormat getIconPersistFormatForTest() {
        return this.mIconPersistFormat;
    }

    int getIconPersistQualityForTest() {
        return this.mIconPersistQuality;
    }

    ShortcutPackage getPackageShortcutForTest(String packageName, int userId) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        ShortcutUser user = this.mUsers.get(userId);     // Catch: Throwable -> L9
        if (user != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        ShortcutPackage r2 = user.getAllPackagesForTest().get(packageName);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    ShortcutInfo getPackageShortcutForTest(String packageName, String shortcutId, int userId) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        ShortcutPackage pkg = getPackageShortcutForTest(packageName, userId);     // Catch: Throwable -> L9
        if (pkg != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        ShortcutInfo r2 = pkg.findShortcutById(shortcutId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    void updatePackageShortcutForTest(String packageName, String shortcutId, int userId, Consumer<ShortcutInfo> cb) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        ShortcutPackage pkg = getPackageShortcutForTest(packageName, userId);     // Catch: Throwable -> L8
        if (pkg != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        cb.accept(pkg.findShortcutById(shortcutId));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    ShortcutLauncher getLauncherShortcutForTest(String packageName, int userId) {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        ShortcutUser user = this.mUsers.get(userId);     // Catch: Throwable -> L9
        if (user != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        ShortcutLauncher r2 = user.getAllLaunchersForTest().get(UserPackage.of(userId, packageName));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    ShortcutRequestPinProcessor getShortcutRequestPinProcessorForTest() {
        return this.mShortcutRequestPinProcessor;
    }

    boolean injectShouldPerformVerification() {
        return false;
    }

    final void verifyStates() {
        if (injectShouldPerformVerification() == false) goto L6;
        verifyStatesInner();
        return;
    }

    private final void verifyStatesForce() {
        verifyStatesInner();
    }

    private void verifyStatesInner() {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        forEachLoadedUserLocked(new ShortcutService$$ExternalSyntheticLambda15());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$verifyStatesInner$22(ShortcutUser u) {
        u.forAllPackageItems(new ShortcutService$$ExternalSyntheticLambda24());
    }

    void waitForBitmapSavesForTest() {
        Object r0 = this.mServiceLock;
        monitor-enter(r0);
        forEachLoadedUserLocked(new ShortcutService$$ExternalSyntheticLambda19());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$waitForBitmapSavesForTest$23(ShortcutUser u) {
        u.forAllPackageItems(new ShortcutService$$ExternalSyntheticLambda6());
    }

    private List<ShortcutInfo> prepareChangedShortcuts(ArraySet<String> changedIds, ArraySet<String> newIds, List<ShortcutInfo> deletedList, ShortcutPackage ps) {
        if (ps != null) goto L6;
        return null;
    L6:
        if (CollectionUtils.isEmpty(changedIds) == true) goto L8;
    L10:
        final ArraySet<String> resultIds = new ArraySet();
        if (CollectionUtils.isEmpty(changedIds) == true) goto L14;
        resultIds.addAll(changedIds);
    L14:
        if (CollectionUtils.isEmpty(newIds) == true) goto L17;
        resultIds.addAll(newIds);
    L17:
        if (CollectionUtils.isEmpty(deletedList) == true) goto L19;
        deletedList.removeIf(new ShortcutService$$ExternalSyntheticLambda11(resultIds));
    L19:
        List<ShortcutInfo> result = new ArrayList();
        ps.findAll(result, new ShortcutService$$ExternalSyntheticLambda12(resultIds), 4);
        return result;
    L8:
        if (CollectionUtils.isEmpty(newIds) == false) goto L10;
        return null;
    }

    private static /* synthetic */ boolean lambda$prepareChangedShortcuts$24(ArraySet resultIds, ShortcutInfo si) {
        return resultIds.contains(si.getId());
    }

    private static /* synthetic */ boolean lambda$prepareChangedShortcuts$25(ArraySet resultIds, ShortcutInfo si) {
        return resultIds.contains(si.getId());
    }

    private List<ShortcutInfo> prepareChangedShortcuts(List<ShortcutInfo> changedList, List<ShortcutInfo> newList, List<ShortcutInfo> deletedList, ShortcutPackage ps) {
        ArraySet<String> changedIds = new ArraySet();
        addShortcutIdsToSet(changedIds, changedList);
        ArraySet<String> newIds = new ArraySet();
        addShortcutIdsToSet(newIds, newList);
        return prepareChangedShortcuts(changedIds, newIds, deletedList, ps);
    }

    private void addShortcutIdsToSet(ArraySet<String> ids, List<ShortcutInfo> shortcuts) {
        if (CollectionUtils.isEmpty(shortcuts) == false) goto L5;
        return;
    L5:
        int size = shortcuts.size();
        int i = 0;
    L6:
        if (i >= size) goto L9;
        ids.add(shortcuts.get(i).getId());
        i = i + 1;
        goto L6
    }

    public IObricShortcutService getObricExt() {
        return this.mObricExt;
    }
}
