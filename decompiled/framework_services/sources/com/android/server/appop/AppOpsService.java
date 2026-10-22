package com.android.server.appop;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.AppOpsManagerInternal;
import android.app.AsyncNotedAppOp;
import android.app.RuntimeAppOpAccessMessage;
import android.app.SyncNotedAppOp;
import android.app.admin.DevicePolicyManagerInternal;
import android.content.AttributionSource;
import android.content.AttributionSourceState;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.PermissionInfo;
import android.database.ContentObserver;
import android.hardware.SensorPrivacyManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.PackageTagsList;
import android.os.Process;
import android.os.RemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.storage.StorageManagerInternal;
import android.permission.PermissionManager;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.KeyValueListParser;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import android.util.Xml;
import bytedanceos.os.BinderCallCacheAgent;
import com.android.internal.app.IAppOpsActiveCallback;
import com.android.internal.app.IAppOpsAsyncNotedCallback;
import com.android.internal.app.IAppOpsCallback;
import com.android.internal.app.IAppOpsNotedCallback;
import com.android.internal.app.IAppOpsService;
import com.android.internal.app.IAppOpsServiceSmtEx;
import com.android.internal.app.IAppOpsStartedCallback;
import com.android.internal.app.MessageSamplingConfig;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.os.Clock;
import com.android.internal.pm.pkg.component.ParsedAttribution;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.IoThread;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.LockGuard;
import com.android.server.SysOptBridge;
import com.android.server.companion.association.DisassociationProcessor;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.job.controllers.JobStatus;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.pm.PackageList;
import com.android.server.pm.PackageManagerLocal;
import com.android.server.pm.ProtectedPackages;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.policy.AppOpsPolicy;
import com.android.server.scene.SceneUtils;
import com.android.server.selinux.RateLimiter;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.usb.descriptors.UsbTerminalTypes;
import com.android.server.wm.ActivityTaskManagerService;
import com.obric.utils.ObricImplFactory;
import dalvik.annotation.optimization.NeverCompile;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import libcore.util.EmptyArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AppOpsService extends IAppOpsService.Stub {
    private static final int CURRENT_VERSION = 1;
    static final boolean DEBUG = false;
    private static final int MAX_UNFORWARDED_OPS = 10;
    private static final int MAX_UNUSED_POOLED_OBJECTS = 3;
    private static final int[] NON_PACKAGE_UIDS = null;
    private static final int NUM_ATTRIBUTED_OP_ENTRY_THRESHOLD = 2000;
    private static final int[] OPS_RESTRICTED_ON_SUSPEND = null;
    private static final int RARELY_USED_PACKAGES_INITIALIZATION_DELAY_MILLIS = 300000;
    private static final Duration RATE_LIMITER_WINDOW = null;
    private static final long REMOVE_USER_DELAY = 5000;
    static final String TAG = "AppOps";
    private static final int UID_ANY = -2;
    static final long WRITE_DELAY = 1800000;
    private final DevicePolicyManagerInternal dpmi;
    private int mAcceptableLeftDistance;
    final ArrayMap<IBinder, SparseArray<ActiveCallback>> mActiveWatchers;
    AppOpsCheckingServiceInterface mAppOpsCheckingService;
    private final AppOpsManagerInternalImpl mAppOpsManagerInternal;
    AppOpsRestrictions mAppOpsRestrictions;
    private final ArrayMap<Pair<String, Integer>, RemoteCallbackList<IAppOpsAsyncNotedCallback>> mAsyncOpWatchers;
    final AudioRestrictionManager mAudioRestrictionManager;
    private volatile CheckOpsDelegateDispatcher mCheckOpsDelegateDispatcher;
    private RuntimeAppOpAccessMessage mCollectedRuntimePermissionMessage;
    final Constants mConstants;
    final Context mContext;
    boolean mFastWriteScheduled;
    final Handler mHandler;
    volatile HistoricalRegistryInterface mHistoricalRegistry;
    private IAppOpsCallback mIgnoredCallback;
    final AttributedOp.InProgressStartOpEventPool mInProgressStartOpEventPool;
    private final SparseArray<String> mKnownDeviceIds;
    private float mMessagesCollectedCount;
    final ArrayMap<IBinder, ModeCallback> mModeWatchers;
    private final ArraySet<NoteOpTrace> mNoteOpCallerStacktraces;
    private final File mNoteOpCallerStacktracesFile;
    final ArrayMap<IBinder, SparseArray<NotedCallback>> mNotedWatchers;
    private IObricAppOpsService mObricExt;
    private BroadcastReceiver mOnPackageUpdatedReceiver;
    final AttributedOp.OpEventProxyInfoPool mOpEventProxyInfoPool;
    private final ArrayMap<IBinder, ClientGlobalRestrictionState> mOpGlobalRestrictions;
    private final SparseArray<ArraySet<OnOpModeChangedListener>> mOpModeWatchers;
    private final ArrayMap<IBinder, ClientUserRestrictionState> mOpUserRestrictions;
    private PackageManagerInternal mPackageManagerInternal;
    private PackageManagerLocal mPackageManagerLocal;
    private final ArrayMap<String, ArraySet<OnOpModeChangedListener>> mPackageModeWatchers;
    private final IPlatformCompat mPlatformCompat;
    SparseIntArray mProfileOwners;
    private ProtectedPackages mProtectedPackages;
    private ArraySet<String> mRarelyUsedPackages;
    private boolean mRarelyUsedPackagesInitialized;
    private final RateLimiter mRateLimiter;
    private final AppOpsRecentAccessPersistence mRecentAccessPersistence;
    final AtomicFile mRecentAccessesFile;
    private int mSampledAppOpCode;
    private String mSampledPackage;
    private int mSamplingStrategy;
    private SensorPrivacyManager mSensorPrivacyManager;
    private final AppOpsServiceSmtEx mSmtEx;
    final ArrayMap<IBinder, SparseArray<StartedCallback>> mStartedWatchers;
    final AtomicFile mStorageFile;
    private final SparseArray<int[]> mSwitchedOps;
    private AppOpsUidStateTracker mUidStateTracker;
    final SparseArray<UidState> mUidStates;
    private final ArrayMap<Pair<String, Integer>, ArrayList<AsyncNotedAppOp>> mUnforwardedAsyncNotedOps;
    private UserManagerInternal mUserManagerInternal;
    private VirtualDeviceManagerInternal mVirtualDeviceManagerInternal;
    boolean mWriteNoteOpsScheduled;
    final Runnable mWriteRunner;
    boolean mWriteScheduled;

    /* JADX INFO: renamed from: com.android.server.appop.AppOpsService$3, reason: invalid class name */
    class AnonymousClass3 implements AppOpsCheckingServiceInterface.AppOpsModeChangedListener {
        final /* synthetic */ AppOpsService this$0;

        public static /* synthetic */ void $r8$lambda$tCrK7GHyC4CL9PmON8WCNADuzSQ(AppOpsService r0, int r1, int r2, boolean r3, String r4) {
            AppOpsService.m1740$$Nest$mnotifyOpChangedForAllPkgsInUid(r0, r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: $r8$lambda$uFJESR2-a5QZ8IO7g6cs3rQ3Zdc, reason: not valid java name */
        public static /* synthetic */ void m1755$r8$lambda$uFJESR2a5QZ8IO7g6cs3rQ3Zdc(AppOpsService r0, String r1, int r2, int r3, int r4) {
            AppOpsService.m1741$$Nest$mnotifyOpChangedForPkg(r0, r1, r2, r3, r4);
        }

        AnonymousClass3(AppOpsService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.appop.AppOpsCheckingServiceInterface.AppOpsModeChangedListener
        public void onUidModeChanged(int uid, int code, int mode, String persistentDeviceId) {
            AppOpsManager.invalidateAppOpModeCache();
            this.this$0.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$3$$ExternalSyntheticLambda0(), this.this$0, Integer.valueOf(code), Integer.valueOf(uid), false, persistentDeviceId));
        }

        @Override // com.android.server.appop.AppOpsCheckingServiceInterface.AppOpsModeChangedListener
        public void onPackageModeChanged(String packageName, int userId, int code, int mode) {
            AppOpsManager.invalidateAppOpModeCache();
            this.this$0.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$3$$ExternalSyntheticLambda1(), this.this$0, packageName, Integer.valueOf(code), Integer.valueOf(mode), Integer.valueOf(userId)));
        }
    }

    final class ActiveCallback implements IBinder.DeathRecipient {
        final IAppOpsActiveCallback mCallback;
        final int mCallingPid;
        final int mCallingUid;
        final int mWatchingUid;
        final /* synthetic */ AppOpsService this$0;

        ActiveCallback(AppOpsService this$0, IAppOpsActiveCallback callback, int watchingUid, int callingUid, int callingPid) {
            this.this$0 = this$0;
            this.mCallback = callback;
            this.mWatchingUid = watchingUid;
            this.mCallingUid = callingUid;
            this.mCallingPid = callingPid;
            this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("ActiveCallback{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" watchinguid=");
            UserHandle.formatUid(sb, this.mWatchingUid);
            sb.append(" from uid=");
            UserHandle.formatUid(sb, this.mCallingUid);
            sb.append(" pid=");
            sb.append(this.mCallingPid);
            sb.append('}');
            return sb.toString();
        }

        void destroy() {
            this.mCallback.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.stopWatchingActive(this.mCallback);
        }
    }

    private final class AppOpsManagerInternalImpl extends AppOpsManagerInternal {
        final /* synthetic */ AppOpsService this$0;

        public static /* synthetic */ void $r8$lambda$KZ8csPYjnHRgqtsqPZIdzSZk2M0(AppOpsService r0, int r1, boolean r2, int r3) {
            AppOpsService.m1752$$Nest$mupdateStartedOpModeForUserForDefaultDevice(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$_3mKgx97gA3YgX5RtEESYaD_JvY(AppOpsService r0, int r1, int r2) {
            AppOpsService.m1742$$Nest$mnotifyWatchersOnDefaultDevice(r0, r1, r2);
        }

        /* synthetic */ AppOpsManagerInternalImpl(AppOpsService r1, AppOpsServiceIA r2) {
            this(r1);
        }

        private AppOpsManagerInternalImpl(AppOpsService r1) {
            this.this$0 = r1;
        }

        public void setDeviceAndProfileOwners(SparseIntArray owners) {
            AppOpsService r0 = this.this$0;
            monitor-enter(r0);
            this.this$0.mProfileOwners = owners;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void updateAppWidgetVisibility(SparseArray<String> uidPackageNames, boolean visible) {
            AppOpsService.m1751$$Nest$mupdateAppWidgetVisibility(this.this$0, uidPackageNames, visible);
        }

        public void setUidModeFromPermissionPolicy(int code, int uid, int mode, IAppOpsCallback callback) {
            AppOpsService.m1748$$Nest$msetUidMode(this.this$0, code, uid, mode, callback);
        }

        public void setModeFromPermissionPolicy(int code, int uid, String packageName, int mode, IAppOpsCallback callback) {
            this.this$0.setMode(code, uid, packageName, mode, callback);
        }

        public void setGlobalRestriction(int code, boolean restricted, IBinder token) {
            if (Binder.getCallingPid() != Process.myPid()) goto L27;
            AppOpsService r0 = this.this$0;
            monitor-enter(r0);
            ClientGlobalRestrictionState restrictionState = (ClientGlobalRestrictionState) AppOpsService.m1720$$Nest$fgetmOpGlobalRestrictions(this.this$0).get(token);     // Catch: Throwable -> L11
            if (restrictionState != null) goto L17;
            restrictionState = new ClientGlobalRestrictionState(this.this$0, token);     // Catch: Throwable -> L11 RemoteException -> L13
            AppOpsService.m1720$$Nest$fgetmOpGlobalRestrictions(this.this$0).put(token, restrictionState);     // Catch: Throwable -> L11
            goto L17
        L15:
            return;
        L17:
            if (restrictionState.setRestriction(code, restricted) == false) goto L20;
            this.this$0.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$AppOpsManagerInternalImpl$$ExternalSyntheticLambda0(), this.this$0, Integer.valueOf(code), -2));     // Catch: Throwable -> L11
            this.this$0.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$AppOpsManagerInternalImpl$$ExternalSyntheticLambda1(), this.this$0, Integer.valueOf(code), Boolean.valueOf(restricted), -1));     // Catch: Throwable -> L11
        L20:
            if (restrictionState.isDefault() == false) goto L22;
            AppOpsService.m1720$$Nest$fgetmOpGlobalRestrictions(this.this$0).remove(token);     // Catch: Throwable -> L11
            restrictionState.destroy();     // Catch: Throwable -> L11
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        L27:
            throw new SecurityException("Only the system can set global restrictions");
        }

        public int getOpRestrictionCount(int code, UserHandle user, String pkg, String attributionTag) {
            int number = 0;
            AppOpsService r2 = this.this$0;
            monitor-enter(r2);
            int numRestrictions = AppOpsService.m1722$$Nest$fgetmOpUserRestrictions(this.this$0).size();     // Catch: Throwable -> L14
            int i = 0;
        L5:
            if (i >= numRestrictions) goto L16;
            int code2 = code;
            String pkg2 = pkg;
            String attributionTag2 = attributionTag;
            if (((ClientUserRestrictionState) AppOpsService.m1722$$Nest$fgetmOpUserRestrictions(this.this$0).valueAt(i)).hasRestriction(code2, pkg2, attributionTag2, user.getIdentifier(), false) == false) goto L11;
            number = number + 1;     // Catch: Throwable -> L12
        L11:
            i = i + 1;     // Catch: Throwable -> L12
            code = code2;
            pkg = pkg2;
            attributionTag = attributionTag2;
            goto L5
        L16:
            int code3 = code;
            int numRestrictions2 = AppOpsService.m1720$$Nest$fgetmOpGlobalRestrictions(this.this$0).size();     // Catch: Throwable -> L12
            int i2 = 0;
        L17:
            if (i2 >= numRestrictions2) goto L23;
            if (((ClientGlobalRestrictionState) AppOpsService.m1720$$Nest$fgetmOpGlobalRestrictions(this.this$0).valueAt(i2)).hasRestriction(code3) == false) goto L21;
            number = number + 1;     // Catch: Throwable -> L12
        L21:
            i2 = i2 + 1;     // Catch: Throwable -> L12
            goto L17
        L23:
            monitor-exit(r2);     // Catch: Throwable -> L12
            return number;
        L12:
            th = move-exception;
            Throwable r12 = th;
        L25:
            monitor-exit(r2);     // Catch: Throwable -> L12
            throw r12;
        L14:
            th = move-exception;
            r12 = th;
            goto L25
        }

        public void onPackageAdded(String pkgName, int appId) {
            int[] userIds = AppOpsService.m1734$$Nest$mgetUserManagerInternal(this.this$0).getUserIds();
            int i = 0;
        L4:
            if (i >= userIds.length) goto L7;
            int userId = userIds[i];
            AppOpsService.m1743$$Nest$monPackageAdded(this.this$0, pkgName, UserHandle.getUid(userId, appId));
            i = i + 1;
            goto L4
        }
    }

    private final class AppOpsManagerLocalImpl implements AppOpsManagerLocal {
        final /* synthetic */ AppOpsService this$0;

        /* synthetic */ AppOpsManagerLocalImpl(AppOpsService r1, AppOpsServiceIA r2) {
            this(r1);
        }

        private AppOpsManagerLocalImpl(AppOpsService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.appop.AppOpsManagerLocal
        public boolean isUidInForeground(int uid) {
            AppOpsService r0 = this.this$0;
            monitor-enter(r0);
            boolean r1 = AppOpsService.m1724$$Nest$fgetmUidStateTracker(this.this$0).isUidInForeground(uid);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static final class ChangeRec {
        final int op;
        final String pkg;
        final int previous_mode;
        final int uid;

        ChangeRec(int _op, int _uid, String _pkg, int _previous_mode) {
            this.op = _op;
            this.uid = _uid;
            this.pkg = _pkg;
            this.previous_mode = _previous_mode;
        }
    }

    private final class CheckOpsDelegateDispatcher {
        private final AppOpsManagerInternal.CheckOpsDelegate mCheckOpsDelegate;
        private final AppOpsManagerInternal.CheckOpsDelegate mPolicy;
        final /* synthetic */ AppOpsService this$0;

        public static /* synthetic */ SyncNotedAppOp $r8$lambda$3aURxMYfaymLmfN8haMS7PDl9yA(CheckOpsDelegateDispatcher r0, int r1, int r2, String r3, String r4, int r5, boolean r6, String r7, boolean r8, int r9) {
            return r0.noteDelegateOperationImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        public static /* synthetic */ Void $r8$lambda$5eJqmaakm_s_oGqpAQpTNSFr04s(AppOpsService r0, IBinder r1, int r2, AttributionSource r3, boolean r4) {
            return AppOpsService.m1731$$Nest$mfinishProxyOperationImpl(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Void $r8$lambda$Ayvp1DHZVQeWcc9dkMYIweRp9q0(CheckOpsDelegateDispatcher r0, IBinder r1, int r2, AttributionSource r3, boolean r4) {
            return r0.finishDelegateProxyOperationImpl(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: $r8$lambda$DFdSptJ9fMoX-NzBt8taAoNaTTo, reason: not valid java name */
        public static /* synthetic */ SyncNotedAppOp m1756$r8$lambda$DFdSptJ9fMoXNzBt8taAoNaTTo(CheckOpsDelegateDispatcher r0, IBinder r1, int r2, AttributionSource r3, boolean r4, boolean r5, String r6, boolean r7, boolean r8, int r9, int r10, int r11) {
            return r0.startDelegateProxyOperationImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        }

        public static /* synthetic */ SyncNotedAppOp $r8$lambda$QYYOaLjjANfgn7zrHGCvO2kFgvs(CheckOpsDelegateDispatcher r0, int r1, AttributionSource r2, boolean r3, String r4, boolean r5, boolean r6) {
            return r0.noteDelegateProxyOperationImpl(r1, r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ SyncNotedAppOp $r8$lambda$Qiy_yvdentXgLxdC1JZ9pb7Y8QU(AppOpsService r0, IBinder r1, int r2, AttributionSource r3, boolean r4, boolean r5, String r6, boolean r7, boolean r8, int r9, int r10, int r11) {
            return AppOpsService.m1750$$Nest$mstartProxyOperationImpl(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        }

        public static /* synthetic */ int $r8$lambda$TqGvemNPXzXUjdqWw7kwupm3azw(AppOpsService r0, int r1, int r2, int r3, String r4) {
            return AppOpsService.m1728$$Nest$mcheckAudioOperationImpl(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ SyncNotedAppOp $r8$lambda$eTKLGbByFLiOzK62QHhpSvtx4do(AppOpsService r0, int r1, int r2, String r3, String r4, int r5, boolean r6, String r7, boolean r8, int r9) {
            return AppOpsService.m1737$$Nest$mnoteOperationImpl(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        public static /* synthetic */ void $r8$lambda$isKDS9RXD9cfyW6vB1LFop2lwy4(AppOpsService r0, IBinder r1, int r2, int r3, String r4, String r5, int r6) {
            AppOpsService.m1730$$Nest$mfinishOperationImpl(r0, r1, r2, r3, r4, r5, r6);
        }

        /* JADX INFO: renamed from: $r8$lambda$khQ5trL9-6Mx-n2RZi7D8IOPhPY, reason: not valid java name */
        public static /* synthetic */ int m1757$r8$lambda$khQ5trL96Mxn2RZi7D8IOPhPY(CheckOpsDelegateDispatcher r0, int r1, int r2, String r3, String r4, int r5, boolean r6) {
            return r0.checkDelegateOperationImpl(r1, r2, r3, r4, r5, r6);
        }

        /* JADX INFO: renamed from: $r8$lambda$p7Z0eGBUU1-Gt7vHG9S-93UhGlY, reason: not valid java name */
        public static /* synthetic */ int m1758$r8$lambda$p7Z0eGBUU1Gt7vHG9S93UhGlY(AppOpsService r0, int r1, int r2, String r3, String r4, int r5, boolean r6) {
            return AppOpsService.m1729$$Nest$mcheckOperationImpl(r0, r1, r2, r3, r4, r5, r6);
        }

        /* JADX INFO: renamed from: $r8$lambda$q8BbxI-iIBB256_4cFe16ffKxiE, reason: not valid java name */
        public static /* synthetic */ SyncNotedAppOp m1759$r8$lambda$q8BbxIiIBB256_4cFe16ffKxiE(AppOpsService r0, int r1, AttributionSource r2, boolean r3, String r4, boolean r5, boolean r6) {
            return AppOpsService.m1738$$Nest$mnoteProxyOperationImpl(r0, r1, r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ void $r8$lambda$qvxkF0OLcpYbdLrAI06Yrb9AOik(CheckOpsDelegateDispatcher r0, IBinder r1, int r2, int r3, String r4, String r5, int r6) {
            r0.finishDelegateOperationImpl(r1, r2, r3, r4, r5, r6);
        }

        /* JADX INFO: renamed from: $r8$lambda$vZeNm9U4ce-mUj2m0fon_vppmA0, reason: not valid java name */
        public static /* synthetic */ SyncNotedAppOp m1760$r8$lambda$vZeNm9U4cemUj2m0fon_vppmA0(AppOpsService r0, IBinder r1, int r2, int r3, String r4, String r5, int r6, boolean r7, boolean r8, String r9, boolean r10, int r11, int r12) {
            return AppOpsService.m1749$$Nest$mstartOperationImpl(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        }

        public static /* synthetic */ SyncNotedAppOp $r8$lambda$xtb3Avg40ciEkkkqr1odxfgddB4(CheckOpsDelegateDispatcher r0, IBinder r1, int r2, int r3, String r4, String r5, int r6, boolean r7, boolean r8, String r9, boolean r10, int r11, int r12) {
            return r0.startDelegateOperationImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        }

        public static /* synthetic */ int $r8$lambda$zHf8r9qti_kUFlypiLDM0nvIlM8(CheckOpsDelegateDispatcher r0, int r1, int r2, int r3, String r4) {
            return r0.checkDelegateAudioOperationImpl(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCheckOpsDelegate, reason: not valid java name */
        static /* bridge */ /* synthetic */ AppOpsManagerInternal.CheckOpsDelegate m1761$$Nest$fgetmCheckOpsDelegate(CheckOpsDelegateDispatcher r0) {
            return r0.mCheckOpsDelegate;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPolicy, reason: not valid java name */
        static /* bridge */ /* synthetic */ AppOpsManagerInternal.CheckOpsDelegate m1762$$Nest$fgetmPolicy(CheckOpsDelegateDispatcher r0) {
            return r0.mPolicy;
        }

        CheckOpsDelegateDispatcher(AppOpsService r1, AppOpsManagerInternal.CheckOpsDelegate policy, AppOpsManagerInternal.CheckOpsDelegate checkOpsDelegate) {
            this.this$0 = r1;
            this.mPolicy = policy;
            this.mCheckOpsDelegate = checkOpsDelegate;
        }

        public int checkOperation(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean raw) {
            if (this.mPolicy == null) goto L11;
            if (this.mCheckOpsDelegate == null) goto L9;
            return this.mPolicy.checkOperation(code, uid, packageName, attributionTag, virtualDeviceId, raw, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda11(this));
        L9:
            return this.mPolicy.checkOperation(code, uid, packageName, attributionTag, virtualDeviceId, raw, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda12(this.this$0));
        L11:
            if (this.mCheckOpsDelegate == null) goto L15;
            return checkDelegateOperationImpl(code, uid, packageName, attributionTag, virtualDeviceId, raw);
        L15:
            return AppOpsService.m1729$$Nest$mcheckOperationImpl(this.this$0, code, uid, packageName, attributionTag, virtualDeviceId, raw);
        }

        private int checkDelegateOperationImpl(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean raw) {
            return this.mCheckOpsDelegate.checkOperation(code, uid, packageName, attributionTag, virtualDeviceId, raw, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda12(this.this$0));
        }

        public int checkAudioOperation(int code, int usage, int uid, String packageName) {
            int mode = AppOpsService.m1719$$Nest$fgetmObricExt(this.this$0).checkAudioOperation(code, usage, uid, packageName);
            if (mode == 0) goto L6;
            return mode;
        L6:
            if (code != 28) goto L12;
            boolean isMute = SysOptBridge.getFactory().getAppOpsServiceSysEx().isMutedApp(uid, packageName);
            if (isMute == false) goto L12;
            Slog.i(AppOpsService.TAG, "prefetch mute uid " + uid + " pkg " + packageName + " isMute=" + isMute);
            return 1;
        L12:
            if (this.mPolicy == null) goto L20;
            if (this.mCheckOpsDelegate == null) goto L18;
            return this.mPolicy.checkAudioOperation(code, usage, uid, packageName, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda7(this));
        L18:
            return this.mPolicy.checkAudioOperation(code, usage, uid, packageName, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda4(this.this$0));
        L20:
            if (this.mCheckOpsDelegate == null) goto L24;
            return checkDelegateAudioOperationImpl(code, usage, uid, packageName);
        L24:
            return AppOpsService.m1728$$Nest$mcheckAudioOperationImpl(this.this$0, code, usage, uid, packageName);
        }

        private int checkDelegateAudioOperationImpl(int code, int usage, int uid, String packageName) {
            return this.mCheckOpsDelegate.checkAudioOperation(code, usage, uid, packageName, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda4(this.this$0));
        }

        public SyncNotedAppOp noteOperation(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int notedCount) {
            if (this.mPolicy == null) goto L11;
            if (this.mCheckOpsDelegate == null) goto L9;
            return this.mPolicy.noteOperation(code, uid, packageName, attributionTag, virtualDeviceId, shouldCollectAsyncNotedOp, message, shouldCollectMessage, notedCount, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda8(this));
        L9:
            return this.mPolicy.noteOperation(code, uid, packageName, attributionTag, virtualDeviceId, shouldCollectAsyncNotedOp, message, shouldCollectMessage, notedCount, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda0(this.this$0));
        L11:
            if (this.mCheckOpsDelegate == null) goto L15;
            return noteDelegateOperationImpl(code, uid, packageName, attributionTag, virtualDeviceId, shouldCollectAsyncNotedOp, message, shouldCollectMessage, notedCount);
        L15:
            return AppOpsService.m1737$$Nest$mnoteOperationImpl(this.this$0, code, uid, packageName, attributionTag, virtualDeviceId, shouldCollectAsyncNotedOp, message, shouldCollectMessage, notedCount);
        }

        private SyncNotedAppOp noteDelegateOperationImpl(int code, int uid, String packageName, String featureId, int virtualDeviceId, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int notedCount) {
            return this.mCheckOpsDelegate.noteOperation(code, uid, packageName, featureId, virtualDeviceId, shouldCollectAsyncNotedOp, message, shouldCollectMessage, notedCount, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda0(this.this$0));
        }

        public SyncNotedAppOp noteProxyOperation(int code, AttributionSource attributionSource, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation) {
            if (this.mPolicy == null) goto L11;
            if (this.mCheckOpsDelegate == null) goto L9;
            return this.mPolicy.noteProxyOperation(code, attributionSource, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda14(this));
        L9:
            return this.mPolicy.noteProxyOperation(code, attributionSource, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda1(this.this$0));
        L11:
            if (this.mCheckOpsDelegate == null) goto L15;
            return noteDelegateProxyOperationImpl(code, attributionSource, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation);
        L15:
            return AppOpsService.m1738$$Nest$mnoteProxyOperationImpl(this.this$0, code, attributionSource, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation);
        }

        private SyncNotedAppOp noteDelegateProxyOperationImpl(int code, AttributionSource attributionSource, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation) {
            return this.mCheckOpsDelegate.noteProxyOperation(code, attributionSource, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda1(this.this$0));
        }

        public SyncNotedAppOp startOperation(IBinder token, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int attributionFlags, int attributionChainId) {
            if (this.mPolicy == null) goto L11;
            if (this.mCheckOpsDelegate == null) goto L9;
            return this.mPolicy.startOperation(token, code, uid, packageName, attributionTag, virtualDeviceId, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, attributionFlags, attributionChainId, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda9(this));
        L9:
            return this.mPolicy.startOperation(token, code, uid, packageName, attributionTag, virtualDeviceId, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, attributionFlags, attributionChainId, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda10(this.this$0));
        L11:
            if (this.mCheckOpsDelegate == null) goto L15;
            return startDelegateOperationImpl(token, code, uid, packageName, attributionTag, virtualDeviceId, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, attributionFlags, attributionChainId);
        L15:
            return AppOpsService.m1749$$Nest$mstartOperationImpl(this.this$0, token, code, uid, packageName, attributionTag, virtualDeviceId, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, attributionFlags, attributionChainId);
        }

        private SyncNotedAppOp startDelegateOperationImpl(IBinder token, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int attributionFlags, int attributionChainId) {
            return this.mCheckOpsDelegate.startOperation(token, code, uid, packageName, attributionTag, virtualDeviceId, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, attributionFlags, attributionChainId, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda10(this.this$0));
        }

        public SyncNotedAppOp startProxyOperation(IBinder clientId, int code, AttributionSource attributionSource, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation, int proxyAttributionFlags, int proxiedAttributionFlags, int attributionChainId) {
            if (this.mPolicy == null) goto L11;
            if (this.mCheckOpsDelegate == null) goto L9;
            return this.mPolicy.startProxyOperation(clientId, code, attributionSource, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, proxyAttributionFlags, proxiedAttributionFlags, attributionChainId, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda5(this));
        L9:
            return this.mPolicy.startProxyOperation(clientId, code, attributionSource, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, proxyAttributionFlags, proxiedAttributionFlags, attributionChainId, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda6(this.this$0));
        L11:
            if (this.mCheckOpsDelegate == null) goto L15;
            return startDelegateProxyOperationImpl(clientId, code, attributionSource, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, proxyAttributionFlags, proxiedAttributionFlags, attributionChainId);
        L15:
            return AppOpsService.m1750$$Nest$mstartProxyOperationImpl(this.this$0, clientId, code, attributionSource, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, proxyAttributionFlags, proxiedAttributionFlags, attributionChainId);
        }

        private SyncNotedAppOp startDelegateProxyOperationImpl(IBinder clientId, int code, AttributionSource attributionSource, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation, int proxyAttributionFlags, int proxiedAttributionFlsgs, int attributionChainId) {
            return this.mCheckOpsDelegate.startProxyOperation(clientId, code, attributionSource, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, proxyAttributionFlags, proxiedAttributionFlsgs, attributionChainId, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda6(this.this$0));
        }

        public void finishOperation(IBinder clientId, int code, int uid, String packageName, String attributionTag, int virtualDeviceId) {
            if (this.mPolicy == null) goto L9;
            if (this.mCheckOpsDelegate == null) goto L7;
            this.mPolicy.finishOperation(clientId, code, uid, packageName, attributionTag, virtualDeviceId, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda13(this));
            return;
        L7:
            this.mPolicy.finishOperation(clientId, code, uid, packageName, attributionTag, virtualDeviceId, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda3(this.this$0));
            return;
        L9:
            if (this.mCheckOpsDelegate == null) goto L11;
            finishDelegateOperationImpl(clientId, code, uid, packageName, attributionTag, virtualDeviceId);
            return;
        L11:
            AppOpsService.m1730$$Nest$mfinishOperationImpl(this.this$0, clientId, code, uid, packageName, attributionTag, virtualDeviceId);
        }

        private void finishDelegateOperationImpl(IBinder clientId, int code, int uid, String packageName, String attributionTag, int virtualDeviceId) {
            this.mCheckOpsDelegate.finishOperation(clientId, code, uid, packageName, attributionTag, virtualDeviceId, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda3(this.this$0));
        }

        public void finishProxyOperation(IBinder clientId, int code, AttributionSource attributionSource, boolean skipProxyOperation) {
            if (this.mPolicy == null) goto L9;
            if (this.mCheckOpsDelegate == null) goto L7;
            this.mPolicy.finishProxyOperation(clientId, code, attributionSource, skipProxyOperation, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda15(this));
            return;
        L7:
            this.mPolicy.finishProxyOperation(clientId, code, attributionSource, skipProxyOperation, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda2(this.this$0));
            return;
        L9:
            if (this.mCheckOpsDelegate == null) goto L11;
            finishDelegateProxyOperationImpl(clientId, code, attributionSource, skipProxyOperation);
            return;
        L11:
            AppOpsService.m1731$$Nest$mfinishProxyOperationImpl(this.this$0, clientId, code, attributionSource, skipProxyOperation);
        }

        private Void finishDelegateProxyOperationImpl(IBinder clientId, int code, AttributionSource attributionSource, boolean skipProxyOperation) {
            this.mCheckOpsDelegate.finishProxyOperation(clientId, code, attributionSource, skipProxyOperation, new AppOpsService$CheckOpsDelegateDispatcher$$ExternalSyntheticLambda2(this.this$0));
            return null;
        }
    }

    private final class ClientGlobalRestrictionState implements IBinder.DeathRecipient {
        final IBinder mToken;
        final /* synthetic */ AppOpsService this$0;

        ClientGlobalRestrictionState(AppOpsService r1, IBinder token) throws RemoteException {
            this.this$0 = r1;
            token.linkToDeath(this, 0);
            this.mToken = token;
        }

        boolean setRestriction(int code, boolean restricted) {
            return this.this$0.mAppOpsRestrictions.setGlobalRestriction(this.mToken, code, restricted);
        }

        boolean hasRestriction(int code) {
            return this.this$0.mAppOpsRestrictions.getGlobalRestriction(this.mToken, code);
        }

        boolean isDefault() {
            return !this.this$0.mAppOpsRestrictions.hasGlobalRestrictions(this.mToken);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.mAppOpsRestrictions.clearGlobalRestrictions(this.mToken);
            AppOpsService.m1720$$Nest$fgetmOpGlobalRestrictions(this.this$0).remove(this.mToken);
            destroy();
        }

        void destroy() {
            this.mToken.unlinkToDeath(this, 0);
        }
    }

    private final class ClientUserRestrictionState implements IBinder.DeathRecipient {
        final /* synthetic */ AppOpsService this$0;
        private final IBinder token;

        ClientUserRestrictionState(AppOpsService r1, IBinder token) throws RemoteException {
            this.this$0 = r1;
            token.linkToDeath(this, 0);
            this.token = token;
        }

        public boolean setRestriction(int code, boolean restricted, PackageTagsList excludedPackageTags, int userId) {
            return this.this$0.mAppOpsRestrictions.setUserRestriction(this.token, userId, code, restricted, excludedPackageTags);
        }

        public boolean hasRestriction(int code, String packageName, String attributionTag, int userId, boolean isCheckOp) {
            return this.this$0.mAppOpsRestrictions.getUserRestriction(this.token, userId, code, packageName, attributionTag, isCheckOp);
        }

        public void removeUser(int userId) {
            this.this$0.mAppOpsRestrictions.clearUserRestrictions(this.token, Integer.valueOf(userId));
        }

        public boolean isDefault() {
            return !this.this$0.mAppOpsRestrictions.hasUserRestrictions(this.token);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            AppOpsService r0 = this.this$0;
            monitor-enter(r0);
            this.this$0.mAppOpsRestrictions.clearUserRestrictions(this.token);     // Catch: Throwable -> L7
            AppOpsService.m1722$$Nest$fgetmOpUserRestrictions(this.this$0).remove(this.token);     // Catch: Throwable -> L7
            destroy();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void destroy() {
            this.token.unlinkToDeath(this, 0);
        }
    }

    final class Constants extends ContentObserver {
        public long BG_STATE_SETTLE_TIME;
        public long FG_SERVICE_STATE_SETTLE_TIME;
        public long TOP_STATE_SETTLE_TIME;
        private final KeyValueListParser mParser;
        private ContentResolver mResolver;
        final /* synthetic */ AppOpsService this$0;

        public Constants(AppOpsService this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
            this.mParser = new KeyValueListParser(',');
            updateConstants();
        }

        public void startMonitoring(ContentResolver resolver) {
            this.mResolver = resolver;
            this.mResolver.registerContentObserver(Settings.Global.getUriFor("app_ops_constants"), false, this);
            updateConstants();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            updateConstants();
        }

        private void updateConstants() {
            if (this.mResolver == null) goto L5;
            String value = Settings.Global.getString(this.mResolver, "app_ops_constants");
        L6:
            AppOpsService r1 = this.this$0;
            monitor-enter(r1);
            this.mParser.setString(value);     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        L14:
            this.TOP_STATE_SETTLE_TIME = this.mParser.getDurationMillis("top_state_settle_time", AppOpsService.REMOVE_USER_DELAY);     // Catch: Throwable -> L10
            this.FG_SERVICE_STATE_SETTLE_TIME = this.mParser.getDurationMillis("fg_service_state_settle_time", AppOpsService.REMOVE_USER_DELAY);     // Catch: Throwable -> L10
            this.BG_STATE_SETTLE_TIME = this.mParser.getDurationMillis("bg_state_settle_time", 1000);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L12:
            e = move-exception;
            Slog.e(AppOpsService.TAG, "Bad app ops settings", e);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        L5:
            value = "";
            goto L6
        }

        void dump(PrintWriter pw) {
            pw.println("  Settings:");
            pw.print("    ");
            pw.print("top_state_settle_time");
            pw.print("=");
            TimeUtils.formatDuration(this.TOP_STATE_SETTLE_TIME, pw);
            pw.println();
            pw.print("    ");
            pw.print("fg_service_state_settle_time");
            pw.print("=");
            TimeUtils.formatDuration(this.FG_SERVICE_STATE_SETTLE_TIME, pw);
            pw.println();
            pw.print("    ");
            pw.print("bg_state_settle_time");
            pw.print("=");
            TimeUtils.formatDuration(this.BG_STATE_SETTLE_TIME, pw);
            pw.println();
        }
    }

    final class ModeCallback extends OnOpModeChangedListener implements IBinder.DeathRecipient {
        public static final int ALL_OPS = -2;
        private final IAppOpsCallback mCallback;
        final /* synthetic */ AppOpsService this$0;

        ModeCallback(AppOpsService this$0, IAppOpsCallback callback, int watchingUid, int flags, int watchedOpCode, int callingUid, int callingPid) {
            this.this$0 = this$0;
            super(watchingUid, flags, watchedOpCode, callingUid, callingPid);
            this.mCallback = callback;
            this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        }

        @Override // com.android.server.appop.OnOpModeChangedListener
        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("ModeCallback{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" watchinguid=");
            UserHandle.formatUid(sb, getWatchingUid());
            sb.append(" flags=0x");
            sb.append(Integer.toHexString(getFlags()));
            switch(getWatchedOpCode()) {
                case -2: goto L6;
                case -1: goto L7;
                default: goto L4;
            };
        L4:
            sb.append(" op=");
            sb.append(AppOpsManager.opToName(getWatchedOpCode()));
            goto L7
        L6:
            sb.append(" op=(all)");
        L7:
            sb.append(" from uid=");
            UserHandle.formatUid(sb, getCallingUid());
            sb.append(" pid=");
            sb.append(getCallingPid());
            sb.append('}');
            return sb.toString();
        }

        void unlinkToDeath() {
            this.mCallback.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.stopWatchingMode(this.mCallback);
        }

        @Override // com.android.server.appop.OnOpModeChangedListener
        public void onOpModeChanged(int op, int uid, String packageName) throws RemoteException {
            throw new IllegalStateException("unimplemented onOpModeChanged method called for op: " + op + " uid: " + uid + " packageName: " + packageName);
        }

        @Override // com.android.server.appop.OnOpModeChangedListener
        public void onOpModeChanged(int op, int uid, String packageName, String persistentDeviceId) throws RemoteException {
            IAppOpsCallback r0 = this.mCallback;
            if (packageName == null) goto L5;
            String r1 = packageName;
        L6:
            persistentDeviceId.getClass();
            r0.opChanged(op, uid, r1, persistentDeviceId);
            return;
        L5:
            r1 = "";
            goto L6
        }
    }

    static class NoteOpTrace {
        static final String OP = "op";
        static final String PACKAGENAME = "packageName";
        static final String STACKTRACE = "stackTrace";
        static final String VERSION = "version";
        private final int mOp;
        private final String mPackageName;
        private final String mStackTrace;
        private final long mVersion;

        static NoteOpTrace fromJson(String jsonTrace) {
            JSONObject obj = new JSONObject(jsonTrace.concat("}"));     // Catch: JSONException -> L4
            return new NoteOpTrace(obj.getString(STACKTRACE), obj.getInt(OP), obj.getString("packageName"), obj.getLong(VERSION));
        L4:
            e = move-exception;
            Slog.e(AppOpsService.TAG, "Error constructing NoteOpTrace object JSON trace format incorrect", e);
            return null;
        }

        NoteOpTrace(String stackTrace, int op, String packageName, long version) {
            this.mStackTrace = stackTrace;
            this.mOp = op;
            this.mPackageName = packageName;
            this.mVersion = version;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L21;
            NoteOpTrace that = (NoteOpTrace) o;
            if (this.mOp != that.mOp) goto L20;
            if (this.mVersion != that.mVersion) goto L20;
            if (this.mStackTrace.equals(that.mStackTrace) == false) goto L20;
            if (Objects.equals(this.mPackageName, that.mPackageName) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mStackTrace, Integer.valueOf(this.mOp), this.mPackageName, Long.valueOf(this.mVersion)});
        }

        public String asJson() {
            return "{\"stackTrace\":\"" + this.mStackTrace.replace("\n", "\\n") + "\",\"" + OP + "\":" + this.mOp + ",\"packageName\":\"" + this.mPackageName + "\",\"" + VERSION + "\":" + this.mVersion + '}';
        }
    }

    final class NotedCallback implements IBinder.DeathRecipient {
        final IAppOpsNotedCallback mCallback;
        final int mCallingPid;
        final int mCallingUid;
        final int mWatchingUid;
        final /* synthetic */ AppOpsService this$0;

        NotedCallback(AppOpsService this$0, IAppOpsNotedCallback callback, int watchingUid, int callingUid, int callingPid) {
            this.this$0 = this$0;
            this.mCallback = callback;
            this.mWatchingUid = watchingUid;
            this.mCallingUid = callingUid;
            this.mCallingPid = callingPid;
            this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("NotedCallback{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" watchinguid=");
            UserHandle.formatUid(sb, this.mWatchingUid);
            sb.append(" from uid=");
            UserHandle.formatUid(sb, this.mCallingUid);
            sb.append(" pid=");
            sb.append(this.mCallingPid);
            sb.append('}');
            return sb.toString();
        }

        void destroy() {
            this.mCallback.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.stopWatchingNoted(this.mCallback);
        }
    }

    final class Op {
        final ArrayMap<String, ArrayMap<String, AttributedOp>> mDeviceAttributedOps;
        int op;
        final String packageName;
        final /* synthetic */ AppOpsService this$0;
        int uid;
        final UidState uidState;

        Op(AppOpsService this$0, UidState uidState, String packageName, int op, int uid) {
            this.this$0 = this$0;
            this.mDeviceAttributedOps = new ArrayMap(1);
            this.op = op;
            this.uid = uid;
            this.uidState = uidState;
            this.packageName = packageName.intern();
            this.mDeviceAttributedOps.put("default:0", new ArrayMap());
        }

        void removeAttributionsWithNoTime() {
            int deviceIndex = this.mDeviceAttributedOps.size() - 1;
        L3:
            if (deviceIndex < 0) goto L17;
            ArrayMap<String, AttributedOp> attributedOps = this.mDeviceAttributedOps.valueAt(deviceIndex);
            int tagIndex = attributedOps.size() - 1;
        L5:
            if (tagIndex < 0) goto L11;
            if (attributedOps.valueAt(tagIndex).hasAnyTime() == true) goto L9;
            attributedOps.removeAt(tagIndex);
        L9:
            tagIndex = tagIndex - 1;
            goto L5
        L11:
            if (Objects.equals("default:0", this.mDeviceAttributedOps.keyAt(deviceIndex)) == true) goto L15;
            if (attributedOps.isEmpty() == false) goto L15;
            this.mDeviceAttributedOps.removeAt(deviceIndex);
        L15:
            deviceIndex = deviceIndex - 1;
            goto L3
        }

        AttributedOp getOrCreateAttribution(Op parent, String attributionTag, String persistentDeviceId) {
            ArrayMap<String, AttributedOp> attributedOps = this.mDeviceAttributedOps.get(persistentDeviceId);
            if (attributedOps != null) goto L5;
            attributedOps = new ArrayMap();
            this.mDeviceAttributedOps.put(persistentDeviceId, attributedOps);
        L5:
            AttributedOp attributedOp = attributedOps.get(attributionTag);
            if (attributedOp != null) goto L9;
            AttributedOp attributedOp2 = new AttributedOp(this.this$0, attributionTag, persistentDeviceId, parent);
            attributedOps.put(attributionTag, attributedOp2);
            return attributedOp2;
        L9:
            return attributedOp;
        }

        AppOpsManager.OpEntry createEntryLocked(String persistentDeviceId) {
            ArrayMap<String, AttributedOp> attributedOps = this.mDeviceAttributedOps.get(persistentDeviceId);
            if (attributedOps != null) goto L5;
            attributedOps = new ArrayMap();
        L5:
            ArrayMap<String, AppOpsManager.AttributedOpEntry> attributionEntries = new ArrayMap(attributedOps.size());
            int i = 0;
        L7:
            if (i >= attributedOps.size()) goto L10;
            attributionEntries.put(attributedOps.keyAt(i), attributedOps.valueAt(i).createAttributedOpEntryLocked());
            i = i + 1;
            goto L7
        L10:
            return new AppOpsManager.OpEntry(this.op, this.this$0.mAppOpsCheckingService.getPackageMode(this.packageName, this.op, UserHandle.getUserId(this.uid)), attributionEntries);
        }

        AppOpsManager.OpEntry createSingleAttributionEntryLocked(String attributionTag) {
            ArrayMap<String, AttributedOp> attributedOps = this.mDeviceAttributedOps.get("default:0");
            if (attributedOps != null) goto L5;
            attributedOps = new ArrayMap();
        L5:
            ArrayMap<String, AppOpsManager.AttributedOpEntry> attributionEntries = new ArrayMap(1);
            if (attributedOps.get(attributionTag) == null) goto L9;
            attributionEntries.put(attributionTag, attributedOps.get(attributionTag).createAttributedOpEntryLocked());
        L9:
            return new AppOpsManager.OpEntry(this.op, this.this$0.mAppOpsCheckingService.getPackageMode(this.packageName, this.op, UserHandle.getUserId(this.uid)), attributionEntries);
        }

        boolean isRunning() {
            int deviceIndex = 0;
        L4:
            if (deviceIndex >= this.mDeviceAttributedOps.size()) goto L14;
            ArrayMap<String, AttributedOp> attributedOps = this.mDeviceAttributedOps.valueAt(deviceIndex);
            int tagIndex = 0;
        L7:
            if (tagIndex >= attributedOps.size()) goto L13;
            if (attributedOps.valueAt(tagIndex).isRunning() == true) goto L10;
            tagIndex = tagIndex + 1;
            goto L7
        L10:
            return true;
        L13:
            deviceIndex = deviceIndex + 1;
            goto L4
        L14:
            return false;
        }
    }

    static final class Ops extends SparseArray<Op> {
        AppOpsManager.RestrictionBypass bypass;
        final ArraySet<String> knownAttributionTags;
        final String packageName;
        final UidState uidState;
        final ArraySet<String> validAttributionTags;

        Ops(String _packageName, UidState _uidState) {
            this.knownAttributionTags = new ArraySet();
            this.validAttributionTags = new ArraySet();
            this.packageName = _packageName;
            this.uidState = _uidState;
        }
    }

    private static final class PackageVerificationResult {
        final AppOpsManager.RestrictionBypass bypass;
        final boolean isAttributionTagValid;

        PackageVerificationResult(AppOpsManager.RestrictionBypass bypass, boolean isAttributionTagValid) {
            this.bypass = bypass;
            this.isAttributionTagValid = isAttributionTagValid;
        }
    }

    static class Shell extends ShellCommand {
        static final Binder sBinder = null;
        String attributionTag;
        final IAppOpsService mInterface;
        final AppOpsService mInternal;
        IBinder mToken;
        int mode;
        String modeStr;
        int nonpackageUid;
        int op;
        String opStr;
        String packageName;
        int packageUid;
        boolean targetsUid;
        int userId;

        /* JADX INFO: renamed from: -$$Nest$smstrOpToOp, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1763$$Nest$smstrOpToOp(String r0, PrintWriter r1) {
            return strOpToOp(r0, r1);
        }

        static {
            sBinder = new Binder();
        }

        Shell(IAppOpsService iface, AppOpsService internal) {
            this.userId = 0;
            this.mInterface = iface;
            this.mInternal = internal;
            this.mToken = AppOpsManager.getClientId();
        }

        public int onCommand(String cmd) {
            return AppOpsService.onShellCommand(this, cmd);
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            AppOpsService.dumpCommandHelp(pw);
        }

        private static int strOpToOp(String op, PrintWriter err) {
            return AppOpsManager.strOpToOp(op);
        L17:
            return Integer.parseInt(op);
        L15:
            return AppOpsManager.strDebugOpToOp(op);
        L10:
            e = move-exception;
            err.println("Error: " + e.getMessage());
            return -1;
        }

        static int strModeToMode(String modeStr, PrintWriter err) {
            int i = AppOpsManager.MODE_NAMES.length - 1;
        L3:
            if (i >= 0) goto L5;
            int i2 = Integer.parseInt(modeStr);     // Catch: NumberFormatException -> L11
            return i2;
        L12:
            err.println("Error: Mode " + modeStr + " is not valid");
            return -1;
        L5:
            if (AppOpsManager.MODE_NAMES[i].equals(modeStr) == true) goto L6;
            i = i - 1;
            goto L3
        L6:
            return i;
        }

        int parseUserOpMode(int defMode, PrintWriter err) throws RemoteException {
            this.userId = -2;
            this.opStr = null;
            this.modeStr = null;
        L3:
            String argument = getNextArg();
            if (argument == null) goto L15;
            if ("--user".equals(argument) == true) goto L7;
            if (this.opStr == null) goto L10;
            if (this.modeStr != null) goto L3;
            this.modeStr = argument;
            goto L15
        L10:
            this.opStr = argument;
            goto L3
        L7:
            this.userId = UserHandle.parseUserArg(getNextArgRequired());
        L15:
            if (this.opStr != null) goto L18;
            err.println("Error: Operation not specified.");
            return -1;
        L18:
            this.op = strOpToOp(this.opStr, err);
            if (this.op >= 0) goto L22;
            return -1;
        L22:
            if (this.modeStr == null) goto L26;
            int r0 = strModeToMode(this.modeStr, err);
            this.mode = r0;
            if (r0 >= 0) goto L39;
            return -1;
        L39:
            return 0;
        L26:
            this.mode = defMode;
            return 0;
        }

        int parseUserPackageOp(boolean reqOp, PrintWriter err) throws RemoteException {
            this.userId = -2;
            this.packageName = null;
            this.opStr = null;
        L3:
            String argument = getNextArg();
            if (argument == null) goto L21;
            if ("--user".equals(argument) == true) goto L7;
            if ("--uid".equals(argument) == true) goto L10;
            if ("--attribution".equals(argument) == true) goto L13;
            if (this.packageName == null) goto L16;
            if (this.opStr != null) goto L3;
            this.opStr = argument;
            goto L21
        L16:
            this.packageName = argument;
            goto L3
        L13:
            this.attributionTag = getNextArgRequired();
            goto L3
        L10:
            this.targetsUid = true;
            goto L3
        L7:
            this.userId = UserHandle.parseUserArg(getNextArgRequired());
        L21:
            if (this.packageName != null) goto L25;
            err.println("Error: Package name not specified.");
            return -1;
        L25:
            if (this.opStr != null) goto L30;
            if (reqOp == false) goto L30;
            err.println("Error: Operation not specified.");
            return -1;
        L30:
            if (this.opStr == null) goto L34;
            this.op = strOpToOp(this.opStr, err);
            if (this.op >= 0) goto L36;
            return -1;
        L36:
            if (this.userId != (-2)) goto L38;
            this.userId = ActivityManager.getCurrentUser();
        L38:
            this.nonpackageUid = -1;
            this.nonpackageUid = Integer.parseInt(this.packageName);     // Catch: NumberFormatException -> L41
        L43:
            if (this.nonpackageUid == (-1)) goto L45;
        L84:
            int i = this.nonpackageUid;
            if (i == (-1)) goto L87;
            this.packageName = null;
        L94:
            return 0;
        L87:
            this.packageUid = AppOpsService.m1754$$Nest$smresolveNonAppUid(this.packageName);
            if (this.packageUid >= 0) goto L91;
            this.packageUid = AppGlobals.getPackageManager().getPackageUid(this.packageName, 8192, this.userId);
        L91:
            if (this.packageUid >= 0) goto L94;
            err.println("Error: No UID for " + this.packageName + " in user " + this.userId);
            return -1;
        L45:
            if (this.packageName.length() <= 1) goto L84;
            if (this.packageName.charAt(0) != 'u') goto L84;
            if (this.packageName.indexOf(46) >= 0) goto L84;
            int i2 = 1;
        L52:
            if (i2 >= this.packageName.length()) goto L58;
            if (this.packageName.charAt(i2) < '0') goto L58;
            if (this.packageName.charAt(i2) > '9') goto L58;
            i2 = i2 + 1;
        L58:
            if (i2 <= 1) goto L84;
            if (i2 >= this.packageName.length()) goto L84;
            String userStr = this.packageName.substring(1, i2);
            int user = Integer.parseInt(userStr);     // Catch: NumberFormatException -> L70
            char type = this.packageName.charAt(i2);     // Catch: NumberFormatException -> L70
            int i3 = i2 + 1;     // Catch: NumberFormatException -> L70
        L64:
            if (i3 >= this.packageName.length()) goto L72;
            if (this.packageName.charAt(i3) < '0') goto L72;
            if (this.packageName.charAt(i3) > '9') goto L72;
            i3 = i3 + 1;     // Catch: NumberFormatException -> L70
        L72:
            if (i3 <= i3) goto L84;
            String typeValStr = this.packageName.substring(i3, i3);     // Catch: NumberFormatException -> L70
            int typeVal = Integer.parseInt(typeValStr);     // Catch: NumberFormatException -> L77
            if (type != 'a') goto L80;
            this.nonpackageUid = UserHandle.getUid(user, typeVal + 10000);     // Catch: NumberFormatException -> L77
        L97:
            goto L84
        L80:
            if (type != 's') goto L97;
            this.nonpackageUid = UserHandle.getUid(user, typeVal);     // Catch: NumberFormatException -> L77
            goto L97
        L34:
            this.op = -1;
            goto L36
        }
    }

    final class StartedCallback implements IBinder.DeathRecipient {
        final IAppOpsStartedCallback mCallback;
        final int mCallingPid;
        final int mCallingUid;
        final int mWatchingUid;
        final /* synthetic */ AppOpsService this$0;

        StartedCallback(AppOpsService this$0, IAppOpsStartedCallback callback, int watchingUid, int callingUid, int callingPid) {
            this.this$0 = this$0;
            this.mCallback = callback;
            this.mWatchingUid = watchingUid;
            this.mCallingUid = callingUid;
            this.mCallingPid = callingPid;
            this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("StartedCallback{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" watchinguid=");
            UserHandle.formatUid(sb, this.mWatchingUid);
            sb.append(" from uid=");
            UserHandle.formatUid(sb, this.mCallingUid);
            sb.append(" pid=");
            sb.append(this.mCallingPid);
            sb.append('}');
            return sb.toString();
        }

        void destroy() {
            this.mCallback.asBinder().unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.stopWatchingStarted(this.mCallback);
        }
    }

    final class UidState {
        public final ArrayMap<String, Ops> pkgOps;
        final /* synthetic */ AppOpsService this$0;
        public final int uid;

        public UidState(AppOpsService this$0, int uid) {
            this.this$0 = this$0;
            this.pkgOps = new ArrayMap();
            this.uid = uid;
        }

        public void clear() {
            this.this$0.mAppOpsCheckingService.removeUid(this.uid);
            int i = 0;
        L4:
            if (i >= this.pkgOps.size()) goto L7;
            String packageName = this.pkgOps.keyAt(i);
            this.this$0.mAppOpsCheckingService.removePackage(packageName, UserHandle.getUserId(this.uid));
            i = i + 1;
            goto L4
        }

        int evalMode(int op, int mode) {
            return AppOpsService.m1733$$Nest$mgetUidStateTracker(this.this$0).evalMode(this.uid, op, mode);
        }

        public int getState() {
            return AppOpsService.m1733$$Nest$mgetUidStateTracker(this.this$0).getUidState(this.uid);
        }

        public void dump(PrintWriter pw, long nowElapsed) {
            AppOpsService.m1733$$Nest$mgetUidStateTracker(this.this$0).dumpUidState(pw, this.uid, nowElapsed);
        }
    }

    public static /* synthetic */ void $r8$lambda$4QeldWBMj6YlbZhhSHdkBipazyw(SparseLongArray r0, AttributedOp r1, AttributedOp.InProgressStartOpEvent r2) {
        lambda$finishChainsLocked$4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$6UFdJMlVEdApX-_k1ZXaih_y7hc, reason: not valid java name */
    public static /* synthetic */ boolean m1713$r8$lambda$6UFdJMlVEdApX_k1ZXaih_y7hc(IBinder r0, AttributedOp.InProgressStartOpEvent r1) {
        return lambda$getAttributedOpWithClientId$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$6k_N9hZ8kvjX_OAIx8qy1xpZV_s(AppOpsService r0, Runnable r1) {
        r0.lambda$getUidStateTracker$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$71LMZ7JKcTz2Del8VraOPLH95C8(RemoteCallback r0) {
        lambda$getHistoricalOps$6(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$8-LvphSu5hQo1Pm8R22O3seI00E, reason: not valid java name */
    public static /* synthetic */ void m1714$r8$lambda$8LvphSu5hQo1Pm8R22O3seI00E(AppOpsService r0, String r1, IAppOpsAsyncNotedCallback r2, RemoteCallbackList r3, IAppOpsAsyncNotedCallback r4, Object r5) {
        r0.lambda$startWatchingAsyncNoted$8(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$88KncsbhH2kd-HDYOv6wbK3as_E, reason: not valid java name */
    public static /* synthetic */ void m1715$r8$lambda$88KncsbhH2kdHDYOv6wbK3as_E(AppOpsService r0, int r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Cs6vN-igHXngWbyuQPObjqfNiNg, reason: not valid java name */
    public static /* synthetic */ void m1716$r8$lambda$Cs6vNigHXngWbyuQPObjqfNiNg(SparseLongArray r0, AttributedOp r1) {
        lambda$finishChainsLocked$5(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$H_OtNgiiXWUlQZA6FKtIStkV4xE(IBinder r0, AttributedOp.InProgressStartOpEvent r1) {
        return lambda$getAttributedOpWithClientId$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$KZ8csPYjnHRgqtsqPZIdzSZk2M0(AppOpsService r0, int r1, boolean r2, int r3) {
        r0.updateStartedOpModeForUserForDefaultDevice(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$V27VMlXcq0A5RHEdccFS2jyDRxk(IBinder r0, AttributedOp.InProgressStartOpEvent r1) {
        return lambda$getAttributedOpWithClientId$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$_3mKgx97gA3YgX5RtEESYaD_JvY(AppOpsService r0, int r1, int r2) {
        r0.notifyWatchersOnDefaultDevice(r1, r2);
    }

    public static /* synthetic */ List $r8$lambda$dY2bz9MdZpnfSsD9a6i_blsrnnU(AppOpsService r0) {
        return r0.getPackageListAndResample();
    }

    /* JADX INFO: renamed from: $r8$lambda$g0ArtqSM29pOULfLH4E-sDrtkFU, reason: not valid java name */
    public static /* synthetic */ void m1717$r8$lambda$g0ArtqSM29pOULfLH4EsDrtkFU(AppOpsService r0) {
        lambda$collectNoteOpCallsForValidation$13(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$gTPk1MOGd-_YuXFccxYAVQp0m20, reason: not valid java name */
    public static /* synthetic */ void m1718$r8$lambda$gTPk1MOGd_YuXFccxYAVQp0m20(SparseLongArray r0, AttributedOp r1, AttributedOp.InProgressStartOpEvent r2) {
        lambda$onUidProcessDeath$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$goph2rcKC3ZkblAuNqSuM_8dDAo(AppOpsService r0, ArraySet r1, int r2, int r3, String r4, String r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        r0.notifyOpStarted(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ void $r8$lambda$iBEgFaVmWH6RsWQk8E__bKKARGk(AppOpsService r0, ArraySet r1, int r2, int r3, String r4, String r5) {
        r0.notifyOpChanged(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$ivy8byvsjd3SaSvT4UqsaMoeNyY(AppOpsService r0, int r1) {
        r0.lambda$removeUser$12(r1);
    }

    public static /* synthetic */ void $r8$lambda$laMlKOOi6dw8cUrr4g6FMdAeID8(AsyncNotedAppOp r0, boolean[] r1, int r2, String r3, int r4, String r5, IAppOpsAsyncNotedCallback r6) {
        lambda$collectAsyncNotedOp$7(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$mwzhma31ieiNEIMs5kEanG9uYik(SparseLongArray r0, AttributedOp r1) {
        lambda$onUidProcessDeath$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$tCrK7GHyC4CL9PmON8WCNADuzSQ(AppOpsService r0, int r1, int r2, boolean r3, String r4) {
        r0.notifyOpChangedForAllPkgsInUid(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$uCCOXFJxz3bCZJrsIAuF17lDZks(AppOpsService r0, ArraySet r1, int r2, int r3, String r4, String r5, int r6, int r7, int r8) {
        r0.notifyOpChecked(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void $r8$lambda$vGfeEw9xZxujs2PjNSTjusJ_yRE(AppOpsService r0, ArraySet r1, int r2, int r3, String r4, String r5, int r6, boolean r7, int r8, int r9) {
        r0.notifyOpActiveChanged(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void $r8$lambda$xAhQeGPgXGiSjmtMzzdf_avZ1GE(AppOpsService r0, OnOpModeChangedListener r1, int r2, int r3, String r4, String r5) {
        r0.notifyOpChanged(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObricExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IObricAppOpsService m1719$$Nest$fgetmObricExt(AppOpsService r0) {
        return r0.mObricExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOpGlobalRestrictions, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m1720$$Nest$fgetmOpGlobalRestrictions(AppOpsService r0) {
        return r0.mOpGlobalRestrictions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOpModeWatchers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m1721$$Nest$fgetmOpModeWatchers(AppOpsService r0) {
        return r0.mOpModeWatchers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOpUserRestrictions, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m1722$$Nest$fgetmOpUserRestrictions(AppOpsService r0) {
        return r0.mOpUserRestrictions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRarelyUsedPackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m1723$$Nest$fgetmRarelyUsedPackages(AppOpsService r0) {
        return r0.mRarelyUsedPackages;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidStateTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsUidStateTracker m1724$$Nest$fgetmUidStateTracker(AppOpsService r0) {
        return r0.mUidStateTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDeviceManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ VirtualDeviceManagerInternal m1725$$Nest$fgetmVirtualDeviceManagerInternal(AppOpsService r0) {
        return r0.mVirtualDeviceManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRarelyUsedPackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1726$$Nest$fputmRarelyUsedPackages(AppOpsService r0, ArraySet r1) {
        r0.mRarelyUsedPackages = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRarelyUsedPackagesInitialized, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1727$$Nest$fputmRarelyUsedPackagesInitialized(AppOpsService r0, boolean r1) {
        r0.mRarelyUsedPackagesInitialized = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckAudioOperationImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1728$$Nest$mcheckAudioOperationImpl(AppOpsService r0, int r1, int r2, int r3, String r4) {
        return r0.checkAudioOperationImpl(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckOperationImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1729$$Nest$mcheckOperationImpl(AppOpsService r0, int r1, int r2, String r3, String r4, int r5, boolean r6) {
        return r0.checkOperationImpl(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishOperationImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1730$$Nest$mfinishOperationImpl(AppOpsService r0, IBinder r1, int r2, int r3, String r4, String r5, int r6) {
        r0.finishOperationImpl(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishProxyOperationImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ Void m1731$$Nest$mfinishProxyOperationImpl(AppOpsService r0, IBinder r1, int r2, AttributionSource r3, boolean r4) {
        return r0.finishProxyOperationImpl(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPackageListAndResample, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m1732$$Nest$mgetPackageListAndResample(AppOpsService r0) {
        return r0.getPackageListAndResample();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUidStateTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsUidStateTracker m1733$$Nest$mgetUidStateTracker(AppOpsService r0) {
        return r0.getUidStateTracker();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManagerInternal m1734$$Nest$mgetUserManagerInternal(AppOpsService r0) {
        return r0.getUserManagerInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$minitializeRarelyUsedPackagesList, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1735$$Nest$minitializeRarelyUsedPackagesList(AppOpsService r0, ArraySet r1) {
        r0.initializeRarelyUsedPackagesList(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$minitializeUserUidStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1736$$Nest$minitializeUserUidStates(AppOpsService r0, int r1) {
        r0.initializeUserUidStates(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnoteOperationImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ SyncNotedAppOp m1737$$Nest$mnoteOperationImpl(AppOpsService r0, int r1, int r2, String r3, String r4, int r5, boolean r6, String r7, boolean r8, int r9) {
        return r0.noteOperationImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: -$$Nest$mnoteProxyOperationImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ SyncNotedAppOp m1738$$Nest$mnoteProxyOperationImpl(AppOpsService r0, int r1, AttributionSource r2, boolean r3, String r4, boolean r5, boolean r6) {
        return r0.noteProxyOperationImpl(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyOpChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1739$$Nest$mnotifyOpChanged(AppOpsService r0, ArraySet r1, int r2, int r3, String r4, String r5) {
        r0.notifyOpChanged(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyOpChangedForAllPkgsInUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1740$$Nest$mnotifyOpChangedForAllPkgsInUid(AppOpsService r0, int r1, int r2, boolean r3, String r4) {
        r0.notifyOpChangedForAllPkgsInUid(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyOpChangedForPkg, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1741$$Nest$mnotifyOpChangedForPkg(AppOpsService r0, String r1, int r2, int r3, int r4) {
        r0.notifyOpChangedForPkg(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyWatchersOnDefaultDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1742$$Nest$mnotifyWatchersOnDefaultDevice(AppOpsService r0, int r1, int r2) {
        r0.notifyWatchersOnDefaultDevice(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1743$$Nest$monPackageAdded(AppOpsService r0, String r1, int r2) {
        r0.onPackageAdded(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1744$$Nest$monPackageRemoved(AppOpsService r0, String r1, int r2) {
        r0.onPackageRemoved(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageReplaced, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1745$$Nest$monPackageReplaced(AppOpsService r0, String r1, int r2) {
        r0.onPackageReplaced(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monUidProcessDeath, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1746$$Nest$monUidProcessDeath(AppOpsService r0, int r1) {
        r0.onUidProcessDeath(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUidStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1747$$Nest$monUidStateChanged(AppOpsService r0, int r1, int r2, boolean r3) {
        r0.onUidStateChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetUidMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1748$$Nest$msetUidMode(AppOpsService r0, int r1, int r2, int r3, IAppOpsCallback r4) {
        r0.setUidMode(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartOperationImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ SyncNotedAppOp m1749$$Nest$mstartOperationImpl(AppOpsService r0, IBinder r1, int r2, int r3, String r4, String r5, int r6, boolean r7, boolean r8, String r9, boolean r10, int r11, int r12) {
        return r0.startOperationImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartProxyOperationImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ SyncNotedAppOp m1750$$Nest$mstartProxyOperationImpl(AppOpsService r0, IBinder r1, int r2, AttributionSource r3, boolean r4, boolean r5, String r6, boolean r7, boolean r8, int r9, int r10, int r11) {
        return r0.startProxyOperationImpl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAppWidgetVisibility, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1751$$Nest$mupdateAppWidgetVisibility(AppOpsService r0, SparseArray r1, boolean r2) {
        r0.updateAppWidgetVisibility(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateStartedOpModeForUserForDefaultDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1752$$Nest$mupdateStartedOpModeForUserForDefaultDevice(AppOpsService r0, int r1, boolean r2, int r3) {
        r0.updateStartedOpModeForUserForDefaultDevice(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetOPS_RESTRICTED_ON_SUSPEND, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m1753$$Nest$sfgetOPS_RESTRICTED_ON_SUSPEND() {
        return OPS_RESTRICTED_ON_SUSPEND;
    }

    /* JADX INFO: renamed from: -$$Nest$smresolveNonAppUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1754$$Nest$smresolveNonAppUid(String r0) {
        return resolveNonAppUid(r0);
    }

    static {
        OPS_RESTRICTED_ON_SUSPEND = new int[]{28, 27, 26, 3, 141};
        NON_PACKAGE_UIDS = new int[]{0, 1001, 1002, FrameworkStatsLog.ADVANCED_PROTECTION_SUPPORT_DIALOG_DISPLAYED, UsbTerminalTypes.TERMINAL_BIDIR_SKRPHONE, 1073, 2000};
        RATE_LIMITER_WINDOW = Duration.ofMillis(10);
    }

    private AppOpsUidStateTracker getUidStateTracker() {
        if (this.mUidStateTracker != null) goto L6;
        this.mUidStateTracker = new AppOpsUidStateTrackerImpl((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class), this.mHandler, new AppOpsService$$ExternalSyntheticLambda13(this), Clock.SYSTEM_CLOCK, this.mConstants);
        this.mUidStateTracker.addUidStateChangedCallback(new HandlerExecutor(this.mHandler), new AnonymousClass2(this));
    L6:
        return this.mUidStateTracker;
    }

    private /* synthetic */ void lambda$getUidStateTracker$0(Runnable r) {
        monitor-enter(this);
        r.run();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static void onClientDeath(AttributedOp attributedOp, IBinder clientId) {
        attributedOp.onClientDeath(clientId);
    }

    private void readNoteOpCallerStackTraces() {
    L6:
        e = move-exception;
        Slog.e(TAG, "Cannot parse traces noteOps", e);
        return;
    L3:
        if (this.mNoteOpCallerStacktracesFile.exists() == true) goto L8;
        this.mNoteOpCallerStacktracesFile.createNewFile();     // Catch: Exception -> L6
        return;
    L8:
        Scanner read = new Scanner(this.mNoteOpCallerStacktracesFile);     // Catch: Exception -> L6
        read.useDelimiter("\\},");     // Catch: Throwable -> L14
    L11:
        if (read.hasNext() == false) goto L16;
        String jsonOps = read.next();     // Catch: Throwable -> L14
        this.mNoteOpCallerStacktraces.add(NoteOpTrace.fromJson(jsonOps));     // Catch: Throwable -> L14
    L16:
        read.close();     // Catch: Exception -> L6
        return;
    L14:
        th = move-exception;
        read.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Exception -> L6
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L6
        goto L22
    }

    public AppOpsService(File recentAccessesFile, File storageFile, Handler handler, Context context) {
        this.mNoteOpCallerStacktraces = new ArraySet();
        this.mOpEventProxyInfoPool = new AttributedOp.OpEventProxyInfoPool(3);
        this.mInProgressStartOpEventPool = new AttributedOp.InProgressStartOpEventPool(this.mOpEventProxyInfoPool, 3);
        this.mAppOpsManagerInternal = new AppOpsManagerInternalImpl(this, null);
        this.dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        this.mKnownDeviceIds = new SparseArray();
        this.mPlatformCompat = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));
        this.mAsyncOpWatchers = new ArrayMap();
        this.mUnforwardedAsyncNotedOps = new ArrayMap();
        this.mOpModeWatchers = new SparseArray();
        this.mPackageModeWatchers = new ArrayMap();
        this.mWriteRunner = new AnonymousClass1(this);
        this.mUidStates = new SparseArray();
        this.mRateLimiter = new RateLimiter(RATE_LIMITER_WINDOW);
        this.mOpUserRestrictions = new ArrayMap();
        this.mOpGlobalRestrictions = new ArrayMap();
        this.mCheckOpsDelegateDispatcher = new CheckOpsDelegateDispatcher(this, null, null);
        this.mSwitchedOps = new SparseArray();
        this.mSampledPackage = null;
        this.mSampledAppOpCode = -1;
        this.mAcceptableLeftDistance = 0;
        this.mRarelyUsedPackages = new ArraySet();
        this.mIgnoredCallback = null;
        this.mObricExt = (IObricAppOpsService) ObricImplFactory.getImpl(IObricAppOpsService.class, new Object[]{this});
        this.mModeWatchers = new ArrayMap();
        this.mActiveWatchers = new ArrayMap();
        this.mStartedWatchers = new ArrayMap();
        this.mNotedWatchers = new ArrayMap();
        this.mAudioRestrictionManager = new AudioRestrictionManager();
        this.mOnPackageUpdatedReceiver = new AnonymousClass4(this);
        this.mSmtEx = new AppOpsServiceSmtEx(this);
        this.mContext = context;
        this.mKnownDeviceIds.put(0, "default:0");
        int switchedCode = 0;
    L4:
        if (switchedCode >= 166) goto L7;
        int switchCode = AppOpsManager.opToSwitch(switchedCode);
        this.mSwitchedOps.put(switchCode, ArrayUtils.appendInt(this.mSwitchedOps.get(switchCode), switchedCode));
        switchedCode = switchedCode + 1;
        goto L4
    L7:
        if (PermissionManager.USE_ACCESS_CHECKING_SERVICE == false) goto L9;
        this.mAppOpsCheckingService = new AppOpsCheckingServiceTracingDecorator((AppOpsCheckingServiceInterface) LocalServices.getService(AppOpsCheckingServiceInterface.class));
        AppOpsService r5 = this;
        File storageFile2 = storageFile;
        Handler handler2 = handler;
        Context context2 = context;
    L10:
        r5.mAppOpsCheckingService.addAppOpsModeChangedListener(new AnonymousClass3(this));
        r5.mAppOpsRestrictions = new AppOpsRestrictionsImpl(context2, handler2, new AppOpsService$$ExternalSyntheticLambda20(this));
        LockGuard.installLock(this, 0);
        r5.mStorageFile = new AtomicFile(storageFile2, "appops_legacy");
        r5.mRecentAccessesFile = new AtomicFile(recentAccessesFile, "appops_accesses");
        r5.mRecentAccessPersistence = new AppOpsRecentAccessPersistence(r5.mRecentAccessesFile, this);
        r5.mNoteOpCallerStacktracesFile = null;
        r5.mHandler = handler2;
        r5.mConstants = new Constants(this, r5.mHandler);
        readRecentAccesses();
        r5.mAppOpsCheckingService.readState();
        AppOpsManager.invalidateAppOpModeCache();
        AppOpsManager.disableAppOpModeCache();
        r5.mHistoricalRegistry = new LegacyHistoricalRegistry(this, context2);
        return;
    L9:
        r5 = this;
        storageFile2 = storageFile;
        handler2 = handler;
        context2 = context;
        r5.mAppOpsCheckingService = new AppOpsCheckingServiceTracingDecorator(new AppOpsCheckingServiceImpl(storageFile2, r5, handler2, context2, this.mSwitchedOps));
        goto L10
    }

    private /* synthetic */ void lambda$new$1(int code) {
        notifyWatchersOnDefaultDevice(code, -2);
    }

    public void publish() {
        ServiceManager.addService("appops", asBinder());
        LocalServices.addService(AppOpsManagerInternal.class, this.mAppOpsManagerInternal);
        LocalManagerRegistry.addManager(AppOpsManagerLocal.class, new AppOpsManagerLocalImpl(this, null));
    }

    private void onPackageAdded(String pkgName, int uid) {
        PackageInfo pi = getPackageManagerInternal().getPackageInfo(pkgName, 4096, Process.myUid(), UserHandle.getUserId(uid));
        monitor-enter(this);
        boolean isSamplingTarget = false;
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.mRarelyUsedPackagesInitialized == false) goto L10;
        isSamplingTarget = isSamplingTarget(pi);     // Catch: Throwable -> L8
    L10:
        if (isSamplingTarget == false) goto L12;
        this.mRarelyUsedPackages.add(pkgName);     // Catch: Throwable -> L8
    L12:
        UidState uidState = getUidStateLocked(uid, true);     // Catch: Throwable -> L8
        if (uidState.pkgOps.containsKey(pkgName) == true) goto L15;
        uidState.pkgOps.put(pkgName, new Ops(pkgName, uidState));     // Catch: Throwable -> L8
    L15:
        createSandboxUidStateIfNotExistsForAppLocked(uid, null);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    private void onPackageRemoved(String pkgName, int uid) {
        monitor-enter(this);
        packageRemovedLocked(uid, pkgName);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void onPackageReplaced(String pkgName, int uid) {
        AndroidPackage pkg = getPackageManagerInternal().getPackage(pkgName);
        if (pkg != null) goto L5;
        return;
    L5:
        monitor-enter(this);
        refreshAttributionsLocked(pkg, uid);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void systemReady() {
        this.mVirtualDeviceManagerInternal = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
        this.mAppOpsCheckingService.systemReady();
        initializeUidStates();
        this.mConstants.startMonitoring(this.mContext.getContentResolver());
        this.mHistoricalRegistry.systemReady(this.mContext.getContentResolver());
        IntentFilter packageUpdateFilter = new IntentFilter();
        packageUpdateFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        packageUpdateFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        packageUpdateFilter.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(this.mOnPackageUpdatedReceiver, UserHandle.ALL, packageUpdateFilter, null, null);
        prepareInternalCallbacks();
        IntentFilter packageSuspendFilter = new IntentFilter();
        packageSuspendFilter.addAction("android.intent.action.PACKAGES_UNSUSPENDED");
        packageSuspendFilter.addAction("android.intent.action.PACKAGES_SUSPENDED");
        this.mContext.registerReceiverAsUser(new AnonymousClass5(this), UserHandle.ALL, packageSuspendFilter, null, null);
        this.mHandler.postDelayed(new AnonymousClass6(this), 300000);
        getPackageManagerInternal().setExternalSourcesPolicy(new AnonymousClass7(this));
        this.mSensorPrivacyManager = SensorPrivacyManager.getInstance(this.mContext);
        SysOptBridge.getFactory().getAppOpsServiceSysEx().systemReady(this);
    }

    void prepareInternalCallbacks() {
        getUserManagerInternal().addUserLifecycleListener(new AnonymousClass8(this));
    }

    void initializeUidStates() {
        UserManagerInternal umi = getUserManagerInternal();
        monitor-enter(this);
        SparseBooleanArray knownUids = new SparseBooleanArray();     // Catch: Throwable -> L9
        int[] r2 = NON_PACKAGE_UIDS;     // Catch: Throwable -> L9
        int r3 = r2.length;     // Catch: Throwable -> L9
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L12;
        int uid = r2[r4];     // Catch: Throwable -> L9
        if (this.mUidStates.contains(uid) == true) goto L11;
        this.mUidStates.put(uid, new UidState(this, uid));     // Catch: Throwable -> L9
    L11:
        knownUids.put(uid, true);     // Catch: Throwable -> L9
        r4 = r4 + 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        int[] userIds = umi.getUserIds();     // Catch: Throwable -> L9
        PackageManagerLocal.UnfilteredSnapshot snapshot = getPackageManagerLocal().withUnfilteredSnapshot();     // Catch: Throwable -> L9
        Map<String, PackageState> packageStates = snapshot.getPackageStates();     // Catch: Throwable -> L17
        int i = 0;
    L15:
        if (i >= userIds.length) goto L19;
        int userId = userIds[i];     // Catch: Throwable -> L17
        initializeUserUidStatesLocked(userId, packageStates, knownUids);     // Catch: Throwable -> L17
        i = i + 1;     // Catch: Throwable -> L17
        goto L15
    L19:
        trimUidStatesLocked(knownUids, packageStates);     // Catch: Throwable -> L17
        snapshot.close();     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L17:
        th = move-exception;
        if (snapshot != null) goto L35;
    L29:
        throw th;     // Catch: Throwable -> L9
    L35:
        snapshot.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void initializeUserUidStates(int userId) {
        monitor-enter(this);
        PackageManagerLocal.UnfilteredSnapshot snapshot = getPackageManagerLocal().withUnfilteredSnapshot();     // Catch: Throwable -> L8
        initializeUserUidStatesLocked(userId, snapshot.getPackageStates(), null);     // Catch: Throwable -> L10
        snapshot.close();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        th = move-exception;
        if (snapshot != null) goto L20;
    L17:
        throw th;     // Catch: Throwable -> L8
    L20:
        snapshot.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void initializeUserUidStatesLocked(int userId, Map<String, PackageState> packageStates, SparseBooleanArray knownUids) {
        Iterator<Map.Entry<String, PackageState>> r0 = packageStates.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, PackageState> entry = r0.next();
        PackageState packageState = entry.getValue();
        if (packageState.isApex() == true) goto L4;
        int appId = packageState.getAppId();
        String packageName = entry.getKey();
        initializePackageUidStateLocked(userId, appId, packageName, knownUids);
        goto L4
    }

    private void initializePackageUidStateLocked(int userId, int appId, String packageName, SparseBooleanArray knownUids) {
        int uid = UserHandle.getUid(userId, appId);
        if (knownUids == null) goto L5;
        knownUids.put(uid, true);
    L5:
        UidState uidState = getUidStateLocked(uid, true);
        Ops ops = uidState.pkgOps.get(packageName);
        if (ops != null) goto L8;
        Ops ops2 = new Ops(packageName, uidState);
        uidState.pkgOps.put(packageName.intern(), ops2);
        Ops ops3 = ops2;
    L9:
        SparseIntArray packageModes = this.mAppOpsCheckingService.getNonDefaultPackageModes(packageName, userId);
        int k = 0;
    L11:
        if (k >= packageModes.size()) goto L17;
        int code = packageModes.keyAt(k);
        if (ops3.indexOfKey(code) >= 0) goto L15;
        String packageName2 = packageName;
        ops3.put(code, new Op(this, uidState, packageName2, code, uid));
    L16:
        k = k + 1;
        packageName = packageName2;
        goto L11
    L15:
        packageName2 = packageName;
        goto L16
    L17:
        createSandboxUidStateIfNotExistsForAppLocked(uid, knownUids);
        return;
    L8:
        ops3 = ops;
        goto L9
    }

    private void trimUidStatesLocked(SparseBooleanArray knownUids, Map<String, PackageState> packageStates) {
        monitor-enter(this);
        int uidIdx = this.mUidStates.size() - 1;     // Catch: Throwable -> L16
    L4:
        if (uidIdx < 0) goto L29;
        int uid = this.mUidStates.keyAt(uidIdx);     // Catch: Throwable -> L16
        if (knownUids.get(uid, false) == false) goto L26;
        int appId = UserHandle.getAppId(uid);     // Catch: Throwable -> L16
        if (appId < 10000) goto L27;
        if (appId > 19999) goto L27;
        ArrayMap<String, Ops> pkgOps = this.mUidStates.valueAt(uidIdx).pkgOps;     // Catch: Throwable -> L16
        int pkgIdx = pkgOps.size() - 1;     // Catch: Throwable -> L16
    L12:
        if (pkgIdx < 0) goto L23;
        String pkgName = pkgOps.keyAt(pkgIdx);     // Catch: Throwable -> L16
        if (packageStates.containsKey(pkgName) == true) goto L18;
        pkgOps.removeAt(pkgIdx);     // Catch: Throwable -> L16
    L21:
        pkgIdx = pkgIdx - 1;     // Catch: Throwable -> L16
        goto L12
    L18:
        AndroidPackage pkg = packageStates.get(pkgName).getAndroidPackage();     // Catch: Throwable -> L16
        if (pkg == null) goto L21;
        refreshAttributionsLocked(pkg, uid);     // Catch: Throwable -> L16
        goto L21
    L23:
        if (pkgOps.isEmpty() == false) goto L27;
        this.mUidStates.removeAt(uidIdx);     // Catch: Throwable -> L16
    L27:
        uidIdx = uidIdx - 1;     // Catch: Throwable -> L16
        goto L4
    L26:
        this.mUidStates.removeAt(uidIdx);     // Catch: Throwable -> L16
        goto L27
    L29:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void refreshAttributionsLocked(AndroidPackage pkg, int uid) {
        String pkgName = pkg.getPackageName();
        ArrayMap<String, String> dstAttributionTags = new ArrayMap();
        ArraySet<String> attributionTags = new ArraySet();
        attributionTags.add(null);
        if (pkg.getAttributions() == null) goto L10;
        int numAttributions = pkg.getAttributions().size();
        int attributionNum = 0;
    L5:
        if (attributionNum >= numAttributions) goto L10;
        ParsedAttribution attribution = (ParsedAttribution) pkg.getAttributions().get(attributionNum);
        attributionTags.add(attribution.getTag());
        int numInheritFrom = attribution.getInheritFrom().size();
        int inheritFromNum = 0;
    L7:
        if (inheritFromNum >= numInheritFrom) goto L9;
        dstAttributionTags.put((String) attribution.getInheritFrom().get(inheritFromNum), attribution.getTag());
        inheritFromNum = inheritFromNum + 1;
        goto L7
    L9:
        attributionNum = attributionNum + 1;
    L10:
        UidState uidState = this.mUidStates.get(uid);
        if (uidState != null) goto L13;
        return;
    L13:
        Ops ops = uidState.pkgOps.get(pkgName);
        if (ops != null) goto L16;
        return;
    L16:
        ops.bypass = null;
        ops.knownAttributionTags.clear();
        int numOps = ops.size();
        int opNum = 0;
    L17:
        if (opNum >= numOps) goto L30;
        Op op = ops.valueAt(opNum);
        int deviceIndex = op.mDeviceAttributedOps.size() - 1;
    L19:
        if (deviceIndex < 0) goto L28;
        ArrayMap<String, AttributedOp> attributedOps = op.mDeviceAttributedOps.valueAt(deviceIndex);
        int tagIndex = attributedOps.size() - 1;
    L21:
        if (tagIndex < 0) goto L27;
        String tag = attributedOps.keyAt(tagIndex);
        if (attributionTags.contains(tag) == true) goto L26;
        String newAttributionTag = dstAttributionTags.get(tag);
        AttributedOp newAttributedOp = op.getOrCreateAttribution(op, newAttributionTag, op.mDeviceAttributedOps.keyAt(deviceIndex));
        newAttributedOp.add(attributedOps.get(tag));
        attributedOps.remove(tag);
        scheduleFastWriteLocked();
    L26:
        tagIndex = tagIndex - 1;
        pkgName = pkgName;
        goto L21
    L27:
        deviceIndex = deviceIndex - 1;
        goto L19
    L28:
        opNum = opNum + 1;
        goto L17
    }

    public void setAppOpsPolicy(AppOpsManagerInternal.CheckOpsDelegate policy) {
        CheckOpsDelegateDispatcher oldDispatcher = this.mCheckOpsDelegateDispatcher;
        if (oldDispatcher == null) goto L5;
        AppOpsManagerInternal.CheckOpsDelegate delegate = CheckOpsDelegateDispatcher.m1761$$Nest$fgetmCheckOpsDelegate(oldDispatcher);
    L6:
        this.mCheckOpsDelegateDispatcher = new CheckOpsDelegateDispatcher(this, policy, delegate);
        return;
    L5:
        delegate = null;
        goto L6
    }

    void packageRemoved(int uid, String packageName) {
        monitor-enter(this);
        packageRemovedLocked(uid, packageName);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void packageRemovedLocked(int uid, String packageName) {
        getIoHandler().post(PooledLambda.obtainRunnable(new AppOpsService$$ExternalSyntheticLambda23(), this.mHistoricalRegistry, Integer.valueOf(uid), packageName));
        UidState uidState = this.mUidStates.get(uid);
        if (uidState != null) goto L5;
        return;
    L5:
        Ops removedOps = uidState.pkgOps.remove(packageName);
        BinderCallCacheAgent.removeCheckPackageBinderCache(uid);
        this.mAppOpsCheckingService.removePackage(packageName, UserHandle.getUserId(uid));
        if (removedOps == null) goto L25;
        scheduleFastWriteLocked();
        int numOps = removedOps.size();
        int opNum = 0;
    L8:
        if (opNum >= numOps) goto L31;
        Op op = removedOps.valueAt(opNum);
        int deviceIndex = 0;
    L11:
        if (deviceIndex >= op.mDeviceAttributedOps.size()) goto L24;
        ArrayMap<String, AttributedOp> attributedOps = op.mDeviceAttributedOps.valueAt(deviceIndex);
        int tagIndex = 0;
    L14:
        if (tagIndex >= attributedOps.size()) goto L23;
        AttributedOp attributedOp = attributedOps.valueAt(tagIndex);
    L17:
        if (attributedOp.isRunning() == false) goto L20;
        attributedOp.finished(attributedOp.mInProgressEvents.keyAt(0));
    L20:
        if (attributedOp.isPaused() == false) goto L22;
        attributedOp.finished(attributedOp.mPausedInProgressEvents.keyAt(0));
        goto L20
    L22:
        tagIndex = tagIndex + 1;
        goto L14
    L23:
        deviceIndex = deviceIndex + 1;
        goto L11
    L24:
        opNum = opNum + 1;
        goto L8
    L31:
        return;
    }

    public void uidRemoved(int uid) {
        long token = Binder.clearCallingIdentity();
        String uidName = getPackageManagerInternal().getNameForUid(uid);     // Catch: Throwable -> L8
        if (uidName == null) goto L10;
        Slog.e(TAG, "Tried to remove existing UID. uid: " + uid + " name: " + uidName);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        Binder.restoreCallingIdentity(token);
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L13:
        if (this.mUidStates.indexOfKey(uid) < 0) goto L17;
        this.mUidStates.get(uid).clear();     // Catch: Throwable -> L15
        this.mUidStates.remove(uid);     // Catch: Throwable -> L15
        scheduleFastWriteLocked();     // Catch: Throwable -> L15
    L17:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void onUidStateChanged(int uid, int state, boolean foregroundModeMayChange) {
        AppOpsService r1 = this;
        monitor-enter(this);
        int r0 = 0;
        UidState uidState = r1.getUidStateLocked(uid, false);     // Catch: Throwable -> L13
        int i = 0;
    L6:
        boolean r9 = true;
        if (i >= r1.mModeWatchers.size()) goto L16;
        ModeCallback cb = r1.mModeWatchers.valueAt(i);     // Catch: Throwable -> L13
        if (cb.isWatchingUid(uid) == false) goto L15;
        if ((cb.getFlags() & 1) == 0) goto L15;
        boolean hasForegroundWatchers = true;
    L17:
        if (uidState == null) goto L71;
        if (foregroundModeMayChange == false) goto L71;
        if (hasForegroundWatchers == false) goto L71;
        SparseBooleanArray foregroundOps = new SparseBooleanArray();     // Catch: Throwable -> L13
        SparseBooleanArray uidForegroundOps = r1.mAppOpsCheckingService.getForegroundOps(uid, "default:0");     // Catch: Throwable -> L13
        int i2 = 0;
    L22:
        if (i2 >= uidForegroundOps.size()) goto L24;
        foregroundOps.put(uidForegroundOps.keyAt(i2), true);     // Catch: Throwable -> L13
        i2 = i2 + 1;     // Catch: Throwable -> L13
        goto L22
    L24:
        String[] uidPackageNames = getPackagesForUid(uid);     // Catch: Throwable -> L13
        int userId = UserHandle.getUserId(uid);     // Catch: Throwable -> L13
        int r2 = uidPackageNames.length;     // Catch: Throwable -> L13
    L25:
        if (r0 >= r2) goto L31;
        String packageName = uidPackageNames[r0];     // Catch: Throwable -> L13
        SparseBooleanArray packageForegroundOps = r1.mAppOpsCheckingService.getForegroundOps(packageName, userId);     // Catch: Throwable -> L13
        int i3 = 0;
    L28:
        if (i3 >= packageForegroundOps.size()) goto L30;
        foregroundOps.put(packageForegroundOps.keyAt(i3), true);     // Catch: Throwable -> L13
        i3 = i3 + 1;     // Catch: Throwable -> L13
        goto L28
    L30:
        r0 = r0 + 1;     // Catch: Throwable -> L13
        goto L25
    L31:
        int fgi = foregroundOps.size() - 1;     // Catch: Throwable -> L13
    L32:
        if (fgi < 0) goto L71;
        if (foregroundOps.valueAt(fgi) == true) goto L36;
        r9 = r9;
    L70:
        fgi = fgi - 1;     // Catch: Throwable -> L13
        r1 = this;
        r9 = r9;
        goto L32
    L36:
        int code = foregroundOps.keyAt(fgi);     // Catch: Throwable -> L13
        char r3 = 4;
        if (r1.mAppOpsCheckingService.getUidMode(uidState.uid, "default:0", code) == AppOpsManager.opToDefaultMode(code)) goto L44;
        if (r1.mAppOpsCheckingService.getUidMode(uidState.uid, "default:0", code) != 4) goto L44;
        r9 = r9;
        r1.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda10(), r1, Integer.valueOf(code), Integer.valueOf(uidState.uid), Boolean.valueOf(r9), "default:0"));     // Catch: Throwable -> L13
    L44:
        if (uidState.pkgOps.isEmpty() == true) goto L70;
        ArraySet<OnOpModeChangedListener> listenerSet = r1.mOpModeWatchers.get(code);     // Catch: Throwable -> L13
        if (listenerSet == null) goto L70;
        int cbi = listenerSet.size() - 1;     // Catch: Throwable -> L13
    L48:
        if (cbi < 0) goto L70;
        OnOpModeChangedListener listener = listenerSet.valueAt(cbi);     // Catch: Throwable -> L13
        if ((listener.getFlags() & 1) != 0) goto L52;
        int cbi2 = cbi;
        char r16 = r3;
        int code2 = code;
    L66:
        cbi = cbi2 - 1;     // Catch: Throwable -> L13
        r1 = this;
        r3 = r16;
        code = code2;
        goto L48
    L52:
        if (listener.isWatchingUid(uidState.uid) == true) goto L54;
        cbi2 = cbi;
        r16 = r3;
        code2 = code;
        goto L66
    L54:
        int pkgi = uidState.pkgOps.size() - 1;     // Catch: Throwable -> L13
    L55:
        if (pkgi < 0) goto L64;
        Op op = uidState.pkgOps.valueAt(pkgi).get(code);     // Catch: Throwable -> L13
        if (op != null) goto L59;
        OnOpModeChangedListener listener2 = listener;
        char r17 = r3;
        int code3 = code;
    L63:
        pkgi = pkgi - 1;     // Catch: Throwable -> L13
        r1 = this;
        r3 = r17;
        listener = listener2;
        code = code3;
        cbi = cbi;
        goto L55
    L59:
        listener2 = listener;
        code3 = code;
        if (r1.mAppOpsCheckingService.getPackageMode(op.packageName, op.op, UserHandle.getUserId(op.uid)) != 4) goto L62;
        Handler r7 = r1.mHandler;     // Catch: Throwable -> L13
        AppOpsService$$ExternalSyntheticLambda11 r4 = new AppOpsService$$ExternalSyntheticLambda11();     // Catch: Throwable -> L13
        OnOpModeChangedListener r6 = listenerSet.valueAt(cbi);     // Catch: Throwable -> L13
        r17 = 4;
        Integer r5 = Integer.valueOf(code3);     // Catch: Throwable -> L13
        int cbi3 = uidState.uid;     // Catch: Throwable -> L13
        r7.sendMessage(PooledLambda.obtainMessage(r4, r1, r6, r5, Integer.valueOf(cbi3), uidState.pkgOps.keyAt(pkgi), "default:0"));     // Catch: Throwable -> L13
        goto L63
    L62:
        r17 = 4;
        goto L63
    L64:
        cbi2 = cbi;
        r16 = r3;
        code2 = code;
    L71:
        if (uidState == null) goto L92;
        int numPkgs = uidState.pkgOps.size();     // Catch: Throwable -> L13
        int pkgNum = 0;
    L73:
        if (pkgNum >= numPkgs) goto L92;
        Ops ops = uidState.pkgOps.valueAt(pkgNum);     // Catch: Throwable -> L13
        int numOps = ops.size();     // Catch: Throwable -> L13
        int opNum = 0;
    L75:
        if (opNum >= numOps) goto L89;
        Op op2 = ops.valueAt(opNum);     // Catch: Throwable -> L13
        int deviceIndex = 0;
    L78:
        if (deviceIndex >= op2.mDeviceAttributedOps.size()) goto L88;
        ArrayMap<String, AttributedOp> attributedOps = op2.mDeviceAttributedOps.valueAt(deviceIndex);     // Catch: Throwable -> L13
        int tagIndex = 0;
    L81:
        if (tagIndex >= attributedOps.size()) goto L87;
        AttributedOp attributedOp = attributedOps.valueAt(tagIndex);     // Catch: Throwable -> L13
        attributedOp.onUidStateChanged(state);     // Catch: Throwable -> L85
        tagIndex = tagIndex + 1;     // Catch: Throwable -> L85
        goto L81
    L87:
        deviceIndex = deviceIndex + 1;     // Catch: Throwable -> L85
        goto L78
    L88:
        opNum = opNum + 1;     // Catch: Throwable -> L85
        goto L75
    L89:
        pkgNum = pkgNum + 1;     // Catch: Throwable -> L85
    L92:
        monitor-exit(this);     // Catch: Throwable -> L85
        return;
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L6
    L16:
        hasForegroundWatchers = false;
    L85:
        th = th;
    L94:
        monitor-exit(this);     // Catch: Throwable -> L85
        throw th;
    L13:
        th = th;
        goto L94
    }

    private void onUidProcessDeath(int uid) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mUidStates.contains(uid) == false) goto L10;
        final SparseLongArray chainsToFinish = new SparseLongArray();     // Catch: Throwable -> L8
        doForAllAttributedOpsInUidLocked(uid, new AppOpsService$$ExternalSyntheticLambda12(chainsToFinish));     // Catch: Throwable -> L8
        finishChainsLocked(chainsToFinish);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    private static /* synthetic */ void lambda$onUidProcessDeath$3(final SparseLongArray chainsToFinish, final AttributedOp attributedOp) {
        attributedOp.doForAllInProgressStartOpEvents(new AppOpsService$$ExternalSyntheticLambda2(chainsToFinish, attributedOp));
    }

    private static /* synthetic */ void lambda$onUidProcessDeath$2(SparseLongArray chainsToFinish, AttributedOp attributedOp, AttributedOp.InProgressStartOpEvent event) {
        if (event != null) goto L4;
        return;
    L4:
        int chainId = event.getAttributionChainId();
        if (chainId == (-1)) goto L9;
        long currentEarliestStartTime = chainsToFinish.get(chainId, Long.MAX_VALUE);
        if (event.getStartTime() >= currentEarliestStartTime) goto L9;
        chainsToFinish.put(chainId, event.getStartTime());
    L9:
        attributedOp.finished(event.getClientId());
    }

    private void finishChainsLocked(final SparseLongArray chainsToFinish) {
        doForAllAttributedOpsLocked(new AppOpsService$$ExternalSyntheticLambda3(chainsToFinish));
    }

    private static /* synthetic */ void lambda$finishChainsLocked$5(final SparseLongArray chainsToFinish, final AttributedOp attributedOp) {
        attributedOp.doForAllInProgressStartOpEvents(new AppOpsService$$ExternalSyntheticLambda19(chainsToFinish, attributedOp));
    }

    private static /* synthetic */ void lambda$finishChainsLocked$4(SparseLongArray chainsToFinish, AttributedOp attributedOp, AttributedOp.InProgressStartOpEvent event) {
        int chainId = event.getAttributionChainId();
        long earliestEventStart = chainsToFinish.get(chainId, Long.MAX_VALUE);
        if (chainId != (-1)) goto L5;
        return;
    L5:
        if (event.getStartTime() < earliestEventStart) goto L9;
        attributedOp.finished(event.getClientId());
        return;
    }

    private void doForAllAttributedOpsLocked(Consumer<AttributedOp> action) {
        int numUids = this.mUidStates.size();
        int uidNum = 0;
    L3:
        if (uidNum >= numUids) goto L6;
        int uid = this.mUidStates.keyAt(uidNum);
        doForAllAttributedOpsInUidLocked(uid, action);
        uidNum = uidNum + 1;
        goto L3
    }

    private void doForAllAttributedOpsInUidLocked(int uid, Consumer<AttributedOp> action) {
        UidState uidState = this.mUidStates.get(uid);
        if (uidState != null) goto L5;
        return;
    L5:
        int numPkgs = uidState.pkgOps.size();
        int pkgNum = 0;
    L6:
        if (pkgNum >= numPkgs) goto L18;
        Ops ops = uidState.pkgOps.valueAt(pkgNum);
        int numOps = ops.size();
        int opNum = 0;
    L8:
        if (opNum >= numOps) goto L16;
        Op op = ops.valueAt(opNum);
        int numDevices = op.mDeviceAttributedOps.size();
        int deviceNum = 0;
    L10:
        if (deviceNum >= numDevices) goto L15;
        ArrayMap<String, AttributedOp> attrOps = op.mDeviceAttributedOps.valueAt(deviceNum);
        int numAttributions = attrOps.size();
        int attrNum = 0;
    L12:
        if (attrNum >= numAttributions) goto L14;
        action.accept(attrOps.valueAt(attrNum));
        attrNum = attrNum + 1;
        goto L12
    L14:
        deviceNum = deviceNum + 1;
        goto L10
    L15:
        opNum = opNum + 1;
        goto L8
    L16:
        pkgNum = pkgNum + 1;
        goto L6
    }

    public void updateUidProcState(int uid, int procState, int capability) {
        monitor-enter(this);
        getUidStateTracker().updateUidProcState(uid, procState, capability);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void shutdown() {
        Slog.w(TAG, "Writing app ops before shutdown...");
        boolean doWrite = false;
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mWriteScheduled == false) goto L9;
        this.mWriteScheduled = false;     // Catch: Throwable -> L7
        this.mFastWriteScheduled = false;     // Catch: Throwable -> L7
        getIoHandler().removeCallbacks(this.mWriteRunner);     // Catch: Throwable -> L7
        doWrite = true;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (doWrite == false) goto L12;
        writeRecentAccesses();
    L12:
        this.mAppOpsCheckingService.shutdown();
        this.mHistoricalRegistry.shutdown();
    }

    private ArrayList<AppOpsManager.OpEntry> collectOps(Ops pkgOps, int[] ops, String persistentDeviceId) {
        ArrayList<AppOpsManager.OpEntry> resOps = null;
        if (this.mContext.checkPermission("android.permission.GET_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid()) != 0) goto L5;
        boolean shouldReturnRestrictedAppOps = true;
    L6:
        int totalAttributedOpEntryCount = 0;
        if (ops != null) goto L20;
        ArrayList<AppOpsManager.OpEntry> resOps2 = new ArrayList();
        int j = 0;
    L10:
        if (j >= pkgOps.size()) goto L36;
        Op curOp = pkgOps.valueAt(j);
        if (AppOpsManager.opRestrictsRead(curOp.op) == false) goto L15;
        if (shouldReturnRestrictedAppOps == true) goto L15;
    L18:
        j = j + 1;
    L15:
        if (totalAttributedOpEntryCount > 2000) goto L36;
        AppOpsManager.OpEntry opEntry = getOpEntryForResult(curOp, persistentDeviceId);
        resOps2.add(opEntry);
        totalAttributedOpEntryCount = totalAttributedOpEntryCount + opEntry.getAttributedOpEntries().size();
    L36:
        if (totalAttributedOpEntryCount <= 2000) goto L38;
        Slog.w(TAG, "The number of attributed op entries has exceeded the threshold. This could be due to DoS attack from malicious apps. The result is throttled.");
    L38:
        return resOps2;
    L20:
        int j2 = 0;
    L22:
        if (j2 >= ops.length) goto L35;
        Op curOp2 = pkgOps.get(ops[j2]);
        if (curOp2 == null) goto L34;
        if (resOps != null) goto L28;
        resOps = new ArrayList();
    L28:
        if (AppOpsManager.opRestrictsRead(curOp2.op) == false) goto L31;
        if (shouldReturnRestrictedAppOps == false) goto L34;
    L31:
        if (totalAttributedOpEntryCount > 2000) goto L32;
        AppOpsManager.OpEntry opEntry2 = getOpEntryForResult(curOp2, persistentDeviceId);
        resOps.add(opEntry2);
        totalAttributedOpEntryCount = totalAttributedOpEntryCount + opEntry2.getAttributedOpEntries().size();
        goto L34
    L32:
        resOps2 = resOps;
    L34:
        j2 = j2 + 1;
        goto L22
    L35:
        resOps2 = resOps;
        goto L36
    L5:
        shouldReturnRestrictedAppOps = false;
        goto L6
    }

    private ArrayList<AppOpsManager.OpEntry> collectUidOps(UidState uidState, int[] ops) {
        SparseIntArray opModes = this.mAppOpsCheckingService.getNonDefaultUidModes(uidState.uid, "default:0");
        if (opModes != null) goto L5;
        return null;
    L5:
        int opModeCount = opModes.size();
        if (opModeCount != 0) goto L8;
        return null;
    L8:
        ArrayList<AppOpsManager.OpEntry> resOps = null;
        if (ops != null) goto L14;
        ArrayList<AppOpsManager.OpEntry> resOps2 = new ArrayList();
        int i = 0;
    L11:
        if (i >= opModeCount) goto L29;
        int code = opModes.keyAt(i);
        resOps2.add(new AppOpsManager.OpEntry(code, opModes.get(code), Collections.emptyMap()));
        i = i + 1;
        goto L11
    L29:
        return resOps2;
    L14:
        int j = 0;
    L16:
        if (j >= ops.length) goto L24;
        int code2 = ops[j];
        if (opModes.indexOfKey(code2) < 0) goto L22;
        if (resOps != null) goto L21;
        resOps = new ArrayList();
    L21:
        resOps.add(new AppOpsManager.OpEntry(code2, opModes.get(code2), Collections.emptyMap()));
    L22:
        j = j + 1;
        goto L16
    L24:
        return resOps;
    }

    private static AppOpsManager.OpEntry getOpEntryForResult(Op op, String persistentDeviceId) {
        return op.createEntryLocked(persistentDeviceId);
    }

    public List<AppOpsManager.PackageOps> getPackagesForOps(int[] ops) {
        ParceledListSlice<AppOpsManager.PackageOps> packageOps = getPackagesForOpsForDevice(ops, "default:0");
        if (packageOps != null) goto L6;
        return null;
    L6:
        return packageOps.getList();
    }

    public ParceledListSlice<AppOpsManager.PackageOps> getPackagesForOpsForDevice(int[] ops, String persistentDeviceId) {
        int callingUid = Binder.getCallingUid();
        if (this.mContext.checkPermission("android.permission.GET_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null) != 0) goto L5;
        boolean r0 = true;
    L6:
        boolean hasAllPackageAccess = r0;
        ArrayList<AppOpsManager.PackageOps> res = null;
        monitor-enter(this);
        int uidStateCount = this.mUidStates.size();     // Catch: Throwable -> L17
        int i = 0;
    L9:
        if (i >= uidStateCount) goto L35;
        UidState uidState = this.mUidStates.valueAt(i);     // Catch: Throwable -> L17
        if (uidState.pkgOps.isEmpty() == true) goto L16;
        if (hasAllPackageAccess == false) goto L15;
    L19:
        ArrayMap<String, Ops> packages = uidState.pkgOps;     // Catch: Throwable -> L17
        int packageCount = packages.size();     // Catch: Throwable -> L17
        int j = 0;
    L20:
        if (j >= packageCount) goto L32;
        Ops pkgOps = packages.valueAt(j);     // Catch: Throwable -> L17
        ArrayList<AppOpsManager.OpEntry> resOps = collectOps(pkgOps, ops, persistentDeviceId);     // Catch: Throwable -> L27
        if (resOps == null) goto L31;
        if (res != null) goto L29;
        res = new ArrayList();     // Catch: Throwable -> L27
    L29:
        AppOpsManager.PackageOps resPackage = new AppOpsManager.PackageOps(pkgOps.packageName, pkgOps.uidState.uid, resOps);     // Catch: Throwable -> L27
        res.add(resPackage);     // Catch: Throwable -> L27
    L31:
        j = j + 1;     // Catch: Throwable -> L27
        uidStateCount = uidStateCount;
        goto L20
    L32:
        int uidStateCount2 = uidStateCount;
    L44:
        i = i + 1;     // Catch: Throwable -> L27
        uidStateCount = uidStateCount2;
    L27:
        th = th;
    L40:
        monitor-exit(this);     // Catch: Throwable -> L27
        throw th;
    L15:
        if (callingUid == uidState.uid) goto L19;
    L16:
        uidStateCount2 = uidStateCount;
        goto L44
    L35:
        monitor-exit(this);     // Catch: Throwable -> L27
        if (res != null) goto L39;
        return null;
    L39:
        return new ParceledListSlice(res);
    L17:
        th = th;
        goto L40
    L5:
        r0 = false;
        goto L6
    }

    public List<AppOpsManager.PackageOps> getOpsForPackage(int uid, String packageName, int[] ops) {
        enforceGetAppOpsStatsPermissionIfNeeded(uid, packageName);
        String resolvedPackageName = AppOpsManager.resolvePackageName(uid, packageName);
        if (resolvedPackageName == null) goto L5;
        monitor-enter(this);
        Ops pkgOps = getOpsLocked(uid, resolvedPackageName, null, false, null, false);     // Catch: Throwable -> L12
        if (pkgOps != null) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L12
        return null;
    L14:
        ArrayList<AppOpsManager.OpEntry> resOps = collectOps(pkgOps, ops, "default:0");     // Catch: Throwable -> L12
        if (resOps == null) goto L22;
        if (resOps.size() == 0) goto L22;
        ArrayList<AppOpsManager.PackageOps> res = new ArrayList();     // Catch: Throwable -> L12
        AppOpsManager.PackageOps resPackage = new AppOpsManager.PackageOps(pkgOps.packageName, pkgOps.uidState.uid, resOps);     // Catch: Throwable -> L12
        res.add(resPackage);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return res;
    L22:
        monitor-exit(this);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    private void enforceGetAppOpsStatsPermissionIfNeeded(int uid, String packageName) {
        int callingPid = Binder.getCallingPid();
        if (callingPid != Process.myPid()) goto L5;
        return;
    L5:
        int callingUid = Binder.getCallingUid();
        if (uid != callingUid) goto L11;
        if (packageName == null) goto L11;
        if (checkPackage(uid, packageName) != 0) goto L11;
        return;
    L11:
        this.mContext.enforcePermission("android.permission.GET_APP_OPS_STATS", callingPid, callingUid, null);
    }

    private void ensureHistoricalOpRequestIsValid(int uid, String packageName, String attributionTag, List<String> opNames, int filter, long beginTimeMillis, long endTimeMillis, int flags) {
        boolean r2 = false;
        if ((filter & 1) == 0) goto L8;
        if (uid == (-1)) goto L6;
        boolean r0 = true;
    L7:
        Preconditions.checkArgument(r0);
    L13:
        if ((filter & 2) == 0) goto L15;
        packageName.getClass();
    L20:
        if ((filter & 4) != 0) goto L26;
        if (attributionTag != null) goto L23;
        boolean r1 = true;
    L24:
        Preconditions.checkArgument(r1);
        goto L26
    L23:
        r1 = false;
    L26:
        if ((filter & 8) == 0) goto L28;
        opNames.getClass();
    L32:
        Preconditions.checkFlagsArgument(filter, 15);
        Preconditions.checkArgumentNonnegative(beginTimeMillis);
        if (endTimeMillis <= beginTimeMillis) goto L35;
        r2 = true;
    L35:
        Preconditions.checkArgument(r2);
        Preconditions.checkFlagsArgument(flags, 31);
        return;
    L28:
        if (opNames != null) goto L30;
        boolean r3 = true;
    L31:
        Preconditions.checkArgument(r3);
        goto L32
    L30:
        r3 = false;
        goto L31
    L15:
        if (packageName != null) goto L17;
        boolean r4 = true;
    L18:
        Preconditions.checkArgument(r4);
        goto L20
    L17:
        r4 = false;
        goto L18
    L6:
        r0 = false;
        goto L7
    L8:
        if (uid != (-1)) goto L10;
        boolean r5 = true;
    L11:
        Preconditions.checkArgument(r5);
        goto L13
    L10:
        r5 = false;
        goto L11
    }

    public void getHistoricalOps(int uid, String packageName, String attributionTag, List<String> opNames, int dataType, int filter, long beginTimeMillis, long endTimeMillis, int flags, final RemoteCallback callback) {
        PackageManager pm = this.mContext.getPackageManager();
        ensureHistoricalOpRequestIsValid(uid, packageName, attributionTag, opNames, filter, beginTimeMillis, endTimeMillis, flags);
        callback.getClass();
        ActivityManagerInternal ami = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        boolean doesCallerHavePermission = false;
        if ((filter & 1) == 0) goto L7;
        int r6 = uid;
        if (r6 != Binder.getCallingUid()) goto L8;
        boolean r0 = true;
    L9:
        boolean isSelfRequest = r0;
        if (isSelfRequest == true) goto L39;
        if (ami.getInstrumentationSourceUid(Binder.getCallingUid()) == (-1)) goto L14;
        boolean r1 = true;
    L15:
        boolean isCallerInstrumented = r1;
        if (Binder.getCallingPid() != Process.myPid()) goto L18;
        boolean r2 = true;
    L19:
        boolean isCallerSystem = r2;
        if (pm.getPackageUidAsUser(this.mContext.getPackageManager().getPermissionControllerPackageName(), 0, UserHandle.getUserId(Binder.getCallingUid())) != Binder.getCallingUid()) goto L23;
        boolean isCallerPermissionController = true;
    L25:
        if (this.mContext.checkPermission("android.permission.GET_HISTORICAL_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid()) != 0) goto L27;
        doesCallerHavePermission = true;
    L27:
        if (isCallerSystem == true) goto L33;
        if (isCallerInstrumented == true) goto L33;
        if (isCallerPermissionController == true) goto L33;
        if (doesCallerHavePermission == true) goto L33;
        this.mHandler.post(new AppOpsService$$ExternalSyntheticLambda24(callback));
        return;
    L33:
        this.mContext.enforcePermission("android.permission.GET_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), "getHistoricalOps");
        goto L39
    L23:
        isCallerPermissionController = false;
    L36:
        return;
    L18:
        r2 = false;
        goto L19
    L14:
        r1 = false;
    L39:
        if (opNames == null) goto L41;
        String[] opNamesArray = (String[]) opNames.toArray(new String[opNames.size()]);
    L42:
        Set<String> attributionChainExemptPackages = null;
        if ((dataType & 4) == 0) goto L45;
        attributionChainExemptPackages = PermissionManager.getIndicatorExemptedPackages(this.mContext);
    L45:
        if (attributionChainExemptPackages == null) goto L47;
        String[] chainExemptPkgArray = (String[]) attributionChainExemptPackages.toArray(new String[attributionChainExemptPackages.size()]);
    L48:
        getIoHandler().post(PooledLambda.obtainRunnable(new AppOpsService$$ExternalSyntheticLambda25(), this.mHistoricalRegistry, Integer.valueOf(r6), packageName, attributionTag, opNamesArray, Integer.valueOf(dataType), Integer.valueOf(filter), Long.valueOf(beginTimeMillis), Long.valueOf(endTimeMillis), Integer.valueOf(flags), chainExemptPkgArray, callback).recycleOnUse());
        return;
    L47:
        chainExemptPkgArray = null;
        goto L48
    L41:
        opNamesArray = null;
    L8:
        r0 = false;
        goto L9
    L7:
        r6 = uid;
        goto L8
    }

    private static /* synthetic */ void lambda$getHistoricalOps$6(RemoteCallback callback) {
        callback.sendResult(new Bundle());
    }

    public void getHistoricalOpsFromDiskRaw(int uid, String packageName, String attributionTag, List<String> opNames, int dataType, int filter, long beginTimeMillis, long endTimeMillis, int flags, RemoteCallback callback) {
        ensureHistoricalOpRequestIsValid(uid, packageName, attributionTag, opNames, filter, beginTimeMillis, endTimeMillis, flags);
        callback.getClass();
        this.mContext.enforcePermission("android.permission.MANAGE_APPOPS", Binder.getCallingPid(), Binder.getCallingUid(), "getHistoricalOps");
        if (opNames == null) goto L5;
        String[] opNamesArray = (String[]) opNames.toArray(new String[opNames.size()]);
    L7:
        if ((dataType & 4) == 0) goto L9;
        Set<String> attributionChainExemptPackages = PermissionManager.getIndicatorExemptedPackages(this.mContext);
        Set<String> attributionChainExemptPackages2 = attributionChainExemptPackages;
    L10:
        if (attributionChainExemptPackages2 == null) goto L12;
        String[] chainExemptPkgArray = (String[]) attributionChainExemptPackages2.toArray(new String[attributionChainExemptPackages2.size()]);
    L13:
        getIoHandler().post(PooledLambda.obtainRunnable(new AppOpsService$$ExternalSyntheticLambda0(), this.mHistoricalRegistry, Integer.valueOf(uid), packageName, attributionTag, opNamesArray, Integer.valueOf(dataType), Integer.valueOf(filter), Long.valueOf(beginTimeMillis), Long.valueOf(endTimeMillis), Integer.valueOf(flags), chainExemptPkgArray, callback).recycleOnUse());
        return;
    L12:
        chainExemptPkgArray = null;
        goto L13
    L9:
        attributionChainExemptPackages2 = null;
        goto L10
    L5:
        opNamesArray = null;
        goto L7
    }

    public void reloadNonHistoricalState() {
        this.mContext.enforcePermission("android.permission.MANAGE_APPOPS", Binder.getCallingPid(), Binder.getCallingUid(), "reloadNonHistoricalState");
        this.mAppOpsCheckingService.writeState();
        this.mAppOpsCheckingService.readState();
    }

    void readState() {
        this.mAppOpsCheckingService.readState();
    }

    public List<AppOpsManager.PackageOps> getUidOps(int uid, int[] ops) {
        this.mContext.enforcePermission("android.permission.GET_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
        monitor-enter(this);
        UidState uidState = getUidStateLocked(uid, false);     // Catch: Throwable -> L9
        if (uidState != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return null;
    L11:
        ArrayList<AppOpsManager.OpEntry> resOps = collectUidOps(uidState, ops);     // Catch: Throwable -> L9
        if (resOps != null) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L9
        return null;
    L15:
        ArrayList<AppOpsManager.PackageOps> res = new ArrayList();     // Catch: Throwable -> L9
        AppOpsManager.PackageOps resPackage = new AppOpsManager.PackageOps(null, uidState.uid, resOps);     // Catch: Throwable -> L9
        res.add(resPackage);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return res;
    L9:
        th = move-exception;
        throw th;
    }

    private void pruneOpLocked(Op op, int uid, String packageName) {
        op.removeAttributionsWithNoTime();
        if (op.mDeviceAttributedOps.isEmpty() == false) goto L12;
        Ops ops = getOpsLocked(uid, packageName, null, false, null, false);
        if (ops == null) goto L13;
        ops.remove(op.op);
        this.mAppOpsCheckingService.setPackageMode(packageName, op.op, AppOpsManager.opToDefaultMode(op.op), UserHandle.getUserId(op.uid));
        if (ops.size() > 0) goto L14;
        UidState uidState = ops.uidState;
        ArrayMap<String, Ops> pkgOps = uidState.pkgOps;
        if (pkgOps == null) goto L15;
        pkgOps.remove(ops.packageName);
        BinderCallCacheAgent.removeCheckPackageBinderCache(uid);
        this.mAppOpsCheckingService.removePackage(ops.packageName, UserHandle.getUserId(uidState.uid));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    private void enforceManageAppOpsModes(int callingPid, int callingUid, int targetUid) {
        if (callingPid != Process.myPid()) goto L5;
        return;
    L5:
        int callingUser = UserHandle.getUserId(callingUid);
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.mProfileOwners != null) goto L10;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L16
        this.mContext.enforcePermission("android.permission.MANAGE_APP_OPS_MODES", Binder.getCallingPid(), Binder.getCallingUid(), null);
        return;
    L10:
        if (this.mProfileOwners.get(callingUser, -1) != callingUid) goto L18;
        if (targetUid < 0) goto L18;
        if (callingUser != UserHandle.getUserId(targetUid)) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L16
    }

    public void setUidMode(int code, int uid, int mode) {
        setUidMode(code, uid, mode, null);
    }

    private void setUidMode(int code, int uid, int mode, IAppOpsCallback permissionPolicyCallback) {
        enforceManageAppOpsModes(Binder.getCallingPid(), Binder.getCallingUid(), uid);
        verifyIncomingOp(code);
        if (isDeviceProvisioningPackage(uid, null) == false) goto L6;
        Slog.w(TAG, "Cannot set uid mode for device provisioning app by Shell");
        return;
    L6:
        int code2 = AppOpsManager.opToSwitch(code);
        if (permissionPolicyCallback != null) goto L9;
        updatePermissionRevokedCompat(uid, code2, mode);
    L9:
        monitor-enter(this);
        int defaultMode = AppOpsManager.opToDefaultMode(code2);     // Catch: Throwable -> L40
        boolean r0 = false;
        UidState uidState = getUidStateLocked(uid, false);     // Catch: Throwable -> L40
        if (uidState != null) goto L22;
        if (mode != defaultMode) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L18:
        if (uid < 10000) goto L20;
        Slog.e(TAG, "Trying to set mode for unknown uid " + uid + ".");     // Catch: Throwable -> L15
    L20:
        uidState = new UidState(this, uid);     // Catch: Throwable -> L15
        this.mUidStates.put(uid, uidState);     // Catch: Throwable -> L15
    L22:
        if (this.mAppOpsCheckingService.getUidMode(uidState.uid, "default:0", code2) != AppOpsManager.opToDefaultMode(code2)) goto L24;
        int previousMode = 3;
    L26:
        this.mIgnoredCallback = permissionPolicyCallback;     // Catch: Throwable -> L40
        if (this.mAppOpsCheckingService.setUidMode(uidState.uid, "default:0", code2, mode) == true) goto L31;
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L31:
        if (mode == 2) goto L37;
        if (mode == previousMode) goto L37;
        if (mode != 1) goto L36;
        r0 = true;
    L36:
        updateStartedOpModeForUidForDefaultDeviceLocked(code2, r0, uid);     // Catch: Throwable -> L15
    L37:
        monitor-exit(this);     // Catch: Throwable -> L40
        notifyStorageManagerOpModeChangedSync(code2, uid, null, mode, previousMode);
        return;
    L24:
        previousMode = this.mAppOpsCheckingService.getUidMode(uidState.uid, "default:0", code2);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Throwable r9 = th;
    L46:
        monitor-exit(this);     // Catch: Throwable -> L44
        throw r9;
    L44:
        th = move-exception;
        r9 = th;
    L40:
        th = move-exception;
        r9 = th;
        goto L46
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:? -> B:19:0x0035). Please report as a decompilation issue!!! */
    private void notifyOpChangedForAllPkgsInUid(int code, int uid, boolean onlyForeground, String persistentDeviceId) {
        AppOpsService r1 = this;
        String[] uidPackageNames = getPackagesForUid(uid);
        ArrayMap<OnOpModeChangedListener, ArraySet<String>> callbackSpecs = null;
        monitor-enter(this);
        ArraySet<OnOpModeChangedListener> callbacks = r1.mOpModeWatchers.get(code);     // Catch: Throwable -> L26
        if (callbacks == null) goto L30;
        int callbackCount = callbacks.size();     // Catch: Throwable -> L26
        int i = 0;
    L9:
        if (i >= callbackCount) goto L30;
        OnOpModeChangedListener callback = callbacks.valueAt(i);     // Catch: Throwable -> L26
    L19:
        th = th;
    L78:
        monitor-exit(this);     // Catch: Throwable -> L19
        throw th;
    L13:
        if (callback.isWatchingUid(uid) == false) goto L25;
        if (onlyForeground == true) goto L17;
    L21:
        ArraySet<String> changedPackages = new ArraySet();     // Catch: Throwable -> L19
        Collections.addAll(changedPackages, uidPackageNames);     // Catch: Throwable -> L19
        if (callbackSpecs != null) goto L24;
        callbackSpecs = new ArrayMap();     // Catch: Throwable -> L19
    L24:
        callbackSpecs.put(callback, changedPackages);     // Catch: Throwable -> L19
        goto L25
    L17:
        if ((callback.getFlags() & 1) != 0) goto L21;
    L25:
        i = i + 1;     // Catch: Throwable -> L19
    L30:
        int r3 = uidPackageNames.length;     // Catch: Throwable -> L19
        int r4 = 0;
        ArrayMap<OnOpModeChangedListener, ArraySet<String>> callbackSpecs2 = callbackSpecs;
    L32:
        if (r4 >= r3) goto L57;
        String uidPackageName = uidPackageNames[r4];     // Catch: Throwable -> L38
        ArraySet<OnOpModeChangedListener> callbacks2 = r1.mPackageModeWatchers.get(uidPackageName);     // Catch: Throwable -> L38
        if (callbacks2 == null) goto L56;
        if (callbackSpecs2 != null) goto L40;
        ArrayMap<OnOpModeChangedListener, ArraySet<String>> callbackSpecs3 = new ArrayMap();     // Catch: Throwable -> L38
    L88:
        int callbackCount2 = callbacks2.size();     // Catch: Throwable -> L48
        int i2 = 0;
    L42:
        if (i2 >= callbackCount2) goto L55;
        OnOpModeChangedListener callback2 = callbacks2.valueAt(i2);     // Catch: Throwable -> L48
        if (onlyForeground == true) goto L46;
    L50:
        ArraySet<String> changedPackages2 = callbackSpecs3.get(callback2);     // Catch: Throwable -> L48
        if (changedPackages2 != null) goto L53;
        changedPackages2 = new ArraySet();     // Catch: Throwable -> L48
        callbackSpecs3.put(callback2, changedPackages2);     // Catch: Throwable -> L48
    L53:
        changedPackages2.add(uidPackageName);     // Catch: Throwable -> L48
    L54:
        i2 = i2 + 1;
        goto L42
    L46:
        if ((callback2.getFlags() & 1) != 0) goto L50;
    L55:
        callbackSpecs2 = callbackSpecs3;
    L48:
        th = th;
        goto L78
    L40:
        callbackSpecs3 = callbackSpecs2;
    L56:
        r4 = r4 + 1;
    L38:
        th = th;
        goto L78
    L57:
        if (callbackSpecs2 != null) goto L59;
    L61:
        monitor-exit(this);     // Catch: Throwable -> L38
        if (callbackSpecs2 != null) goto L64;
        return;
    L64:
        int i3 = 0;
    L66:
        if (i3 >= callbackSpecs2.size()) goto L75;
        OnOpModeChangedListener callback3 = callbackSpecs2.keyAt(i3);
        ArraySet<String> reportedPackageNames = callbackSpecs2.valueAt(i3);
        if (reportedPackageNames != null) goto L70;
        r1.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda11(), r1, callback3, Integer.valueOf(code), Integer.valueOf(uid), null, persistentDeviceId));
    L73:
        i3 = i3 + 1;
        r1 = this;
        goto L66
    L70:
        int reportedPackageCount = reportedPackageNames.size();
        int j = 0;
    L71:
        if (j >= reportedPackageCount) goto L73;
        String reportedPackageName = reportedPackageNames.valueAt(j);
        r1.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda11(), r1, callback3, Integer.valueOf(code), Integer.valueOf(uid), reportedPackageName, persistentDeviceId));
        j = j + 1;
        r1 = this;
        goto L71
    L75:
        return;
    L59:
        if (r1.mIgnoredCallback == null) goto L61;
        callbackSpecs2.remove(r1.mModeWatchers.get(r1.mIgnoredCallback.asBinder()));     // Catch: Throwable -> L38
    L26:
        th = th;
    L76:
        th = th;
        goto L78
    }

    private void notifyOpChangedForPkg(String packageName, int code, int mode, int userId) {
        ArraySet<OnOpModeChangedListener> repCbs = null;
        monitor-enter(this);
        ArraySet<? extends OnOpModeChangedListener> r0 = this.mOpModeWatchers.get(code);     // Catch: Throwable -> L8
        if (r0 == null) goto L11;
        if (0 != 0) goto L10;
        repCbs = new ArraySet();     // Catch: Throwable -> L8
    L10:
        repCbs.addAll(r0);     // Catch: Throwable -> L8
    L11:
        ArraySet<? extends OnOpModeChangedListener> r6 = this.mPackageModeWatchers.get(packageName);     // Catch: Throwable -> L8
        if (r6 == null) goto L17;
        if (repCbs != null) goto L15;
        repCbs = new ArraySet();     // Catch: Throwable -> L8
    L15:
        repCbs.addAll(r6);     // Catch: Throwable -> L8
        ArraySet<OnOpModeChangedListener> repCbs2 = repCbs;
    L18:
        if (repCbs2 != null) goto L79;
    L65:
        int uid = getPackageManagerInternal().getPackageUid(packageName, 4202496, userId);     // Catch: Throwable -> L57
        Op op = getOpLocked(code, uid, packageName, null, false, null, false);     // Catch: Throwable -> L55
        if (op != null) goto L75;
    L67:
        scheduleFastWriteLocked();     // Catch: Throwable -> L53
        if (mode == 2) goto L46;
        boolean r2 = true;
        if (mode == 1) goto L45;
        r2 = false;
    L45:
        updateStartedOpModeForUidForDefaultDeviceLocked(code, r2, uid);     // Catch: Throwable -> L36
    L36:
        th = th;
    L71:
        monitor-exit(this);     // Catch: Throwable -> L63
        throw th;
    L63:
        th = th;
    L46:
        monitor-exit(this);     // Catch: Throwable -> L53
        if (repCbs2 == null) goto L52;
        if (uid == (-1)) goto L52;
        ArraySet<OnOpModeChangedListener> repCbs3 = repCbs2;
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda22(), this, repCbs3, Integer.valueOf(code), Integer.valueOf(uid), packageName, "default:0"));
        return;
    L52:
        return;
    L53:
        th = th;
        goto L71
    L75:
        if (mode != AppOpsManager.opToDefaultMode(op.op)) goto L67;
        pruneOpLocked(op, uid, packageName);     // Catch: Throwable -> L36
    L55:
        th = th;
    L57:
        th = th;
    L59:
        th = th;
        goto L71
    L79:
    L23:
        th = th;
        goto L71
    L20:
        if (this.mIgnoredCallback == null) goto L65;
        repCbs2.remove(this.mModeWatchers.get(this.mIgnoredCallback.asBinder()));     // Catch: Throwable -> L23
        goto L65
    L17:
        repCbs2 = repCbs;
    L8:
        th = th;
        goto L71
    }

    private void updatePermissionRevokedCompat(int uid, int switchCode, int mode) {
        AppOpsService r1 = this;
        PackageManager packageManager = r1.mContext.getPackageManager();
        if (packageManager != null) goto L5;
        return;
    L5:
        String[] packageNames = packageManager.getPackagesForUid(uid);
        if (ArrayUtils.isEmpty(packageNames) == false) goto L8;
        return;
    L8:
        int r12 = 0;
        String packageName = packageNames[0];
        int[] ops = r1.mSwitchedOps.get(switchCode);
        int r14 = ops.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L77;
        int code = ops[r15];
        String permissionName = AppOpsManager.opToPermission(code);
        if (permissionName != null) goto L14;
        ops = ops;
        r14 = r14;
    L76:
        r15 = r15 + 1;
        r1 = this;
        r14 = r14;
        packageNames = packageNames;
        ops = ops;
        r12 = 0;
        goto L9
    L14:
        if (r1.mContext.checkPermission(permissionName, -1, uid) == 0) goto L82;
        ops = ops;
        r14 = r14;
        goto L76
    L82:
        PermissionInfo permissionInfo = packageManager.getPermissionInfo(permissionName, r12);     // Catch: PackageManager.NameNotFoundException -> L74
        if (permissionInfo.isRuntime() == true) goto L20;
        ops = ops;
        r14 = r14;
        goto L76
    L20:
        boolean isRevokedCompat = true;
        if (r1.getPackageManagerInternal().getUidTargetSdkVersion(uid) < 23) goto L23;
        int r0 = 1;
    L24:
        int r18 = r0;
        UserHandle user = UserHandle.getUserHandleForUid(uid);
        String r9 = ", permission=";
        if (permissionInfo.backgroundPermission == null) goto L57;
        String permissionName2 = permissionName;
        if (packageManager.checkPermission(permissionInfo.backgroundPermission, packageName) != 0) goto L51;
        if (mode == 0) goto L30;
        boolean r6 = true;
    L31:
        boolean isBackgroundRevokedCompat = r6;
        if (isBackgroundRevokedCompat == false) goto L36;
        if (r18 == 0) goto L36;
        Slog.w(TAG, "setUidMode() called with a mode inconsistent with runtime permission state, this is discouraged and you should revoke the runtime permission instead: uid=" + uid + ", switchCode=" + switchCode + ", mode=" + mode + ", permission=" + permissionInfo.backgroundPermission);
    L36:
        long identity = Binder.clearCallingIdentity();
        String r7 = permissionInfo.backgroundPermission;     // Catch: Throwable -> L46
        if (isBackgroundRevokedCompat == false) goto L40;
        int r10 = 8;
    L41:
        packageManager = packageManager;
        packageManager.updatePermissionFlags(r7, packageName, 8, r10, user);     // Catch: Throwable -> L44
        Binder.restoreCallingIdentity(identity);
    L44:
        th = th;
    L48:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L40:
        r10 = 0;
    L46:
        th = th;
        goto L48
    L30:
        r6 = false;
    L51:
        if (mode != 0) goto L53;
    L55:
        isRevokedCompat = false;
    L61:
        if (isRevokedCompat == false) goto L64;
        if (r18 == 0) goto L64;
        Slog.w(TAG, "setUidMode() called with a mode inconsistent with runtime permission state, this is discouraged and you should revoke the runtime permission instead: uid=" + uid + ", switchCode=" + switchCode + ", mode=" + mode + r9 + permissionName2);
    L64:
        long identity2 = Binder.clearCallingIdentity();
        if (isRevokedCompat == false) goto L67;
        int r11 = 8;
    L84:
        packageManager.updatePermissionFlags(permissionName2, packageName, 8, r11, user);     // Catch: Throwable -> L71
        Binder.restoreCallingIdentity(identity2);
    L71:
        th = move-exception;
        Binder.restoreCallingIdentity(identity2);
        throw th;
    L67:
        r11 = 0;
        goto L84
    L53:
        if (mode == 4) goto L55;
    L57:
        ops = ops;
        r14 = r14;
        permissionName2 = permissionName;
        r9 = ", permission=";
        if (mode != 0) goto L61;
        isRevokedCompat = false;
        goto L61
    L23:
        r0 = r12;
    L74:
        e = move-exception;
        ops = ops;
        r14 = r14;
        e.printStackTrace();
        goto L76
    }

    private void notifyStorageManagerOpModeChangedSync(int code, int uid, String packageName, int mode, int previousMode) {
        StorageManagerInternal storageManagerInternal = (StorageManagerInternal) LocalServices.getService(StorageManagerInternal.class);
        if (storageManagerInternal == null) goto L6;
        storageManagerInternal.onAppOpsChanged(code, uid, packageName, mode, previousMode);
        return;
    }

    public void setMode(int code, int uid, String packageName, int mode) {
        setMode(code, uid, packageName, mode, null);
    }

    void setMode(int code, int uid, String packageName, int mode, IAppOpsCallback permissionPolicyCallback) {
        if (AppOpsServiceZteHook.enforceManageAppOpsModesForZte(this.mContext, Binder.getCallingPid(), Binder.getCallingUid(), uid, packageName, code) == true) goto L5;
        enforceManageAppOpsModes(Binder.getCallingPid(), Binder.getCallingUid(), uid);
    L5:
        verifyIncomingOp(code);
        if (isIncomingPackageValid(packageName, UserHandle.getUserId(uid)) == true) goto L9;
        return;
    L9:
        if (isDeviceProvisioningPackage(uid, packageName) == false) goto L12;
        Slog.w(TAG, "Cannot set op mode for device provisioning app by Shell");
        return;
    L12:
        int code2 = AppOpsManager.opToSwitch(code);
        PackageVerificationResult pvr = verifyAndGetBypass(uid, packageName, null);     // Catch: SecurityException -> L40
        monitor-enter(this);
        Op op = getOpLocked(code2, uid, packageName, null, false, pvr.bypass, true);     // Catch: Throwable -> L32
        if (op != null) goto L49;
    L26:
        int previousMode = 3;
    L45:
        monitor-exit(this);     // Catch: Throwable -> L30
        notifyStorageManagerOpModeChangedSync(code2, uid, packageName, mode, previousMode);
        return;
    L30:
        th = move-exception;
        Throwable r12 = th;
    L43:
        monitor-exit(this);     // Catch: Throwable -> L38
        throw r12;
    L38:
        th = move-exception;
        r12 = th;
        goto L43
    L49:
    L24:
        th = move-exception;
        r12 = th;
        goto L43
    L21:
        if (this.mAppOpsCheckingService.getPackageMode(op.packageName, op.op, UserHandle.getUserId(op.uid)) == mode) goto L26;
        int previousMode2 = this.mAppOpsCheckingService.getPackageMode(op.packageName, op.op, UserHandle.getUserId(op.uid));     // Catch: Throwable -> L24
        this.mIgnoredCallback = permissionPolicyCallback;     // Catch: Throwable -> L24
        this.mAppOpsCheckingService.setPackageMode(op.packageName, op.op, mode, UserHandle.getUserId(op.uid));     // Catch: Throwable -> L24
        previousMode = previousMode2;
    L32:
        th = move-exception;
        r12 = th;
    L34:
        th = move-exception;
        r12 = th;
    L40:
        e = move-exception;
        logVerifyAndGetBypassFailure(uid, e, "setMode");
    }

    private boolean isDeviceProvisioningPackage(int uid, String packageName) {
        if (UserHandle.getAppId(Binder.getCallingUid()) != 2000) goto L18;
        ProtectedPackages protectedPackages = getProtectedPackages();
        if (packageName != null) goto L7;
    L9:
        String[] packageNames = this.mContext.getPackageManager().getPackagesForUid(uid);
        if (packageNames == null) goto L18;
        int r4 = packageNames.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L18;
        String pkg = packageNames[r5];
        if (protectedPackages.isDeviceProvisioningPackage(pkg) == true) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        return true;
    L7:
        if (protectedPackages.isDeviceProvisioningPackage(packageName) == false) goto L9;
        return true;
    L18:
        return false;
    }

    private ProtectedPackages getProtectedPackages() {
        if (this.mProtectedPackages != null) goto L6;
        this.mProtectedPackages = new ProtectedPackages(this.mContext);
    L6:
        return this.mProtectedPackages;
    }

    private void notifyOpChanged(ArraySet<OnOpModeChangedListener> callbacks, int code, int uid, String packageName, String persistentDeviceId) {
        int i = 0;
    L4:
        if (i >= callbacks.size()) goto L7;
        OnOpModeChangedListener callback = callbacks.valueAt(i);
        notifyOpChanged(callback, code, uid, packageName, persistentDeviceId);
        i = i + 1;
        goto L4
    }

    private void notifyOpChanged(OnOpModeChangedListener onModeChangedListener, int code, int uid, String packageName, String persistentDeviceId) {
        onModeChangedListener.getClass();
        if (uid == (-2)) goto L10;
        if (onModeChangedListener.getWatchingUid() < 0) goto L10;
        if (onModeChangedListener.getWatchingUid() == uid) goto L10;
        return;
    L10:
        if (onModeChangedListener.getWatchedOpCode() != (-2)) goto L13;
        int[] switchedCodes = this.mSwitchedOps.get(code);
    L16:
        int r1 = switchedCodes.length;
        int r2 = 0;
    L17:
        if (r2 >= r1) goto L31;
        int switchedCode = switchedCodes[r2];
        long identity = Binder.clearCallingIdentity();
    L24:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L20:
        if (shouldIgnoreCallback(switchedCode, onModeChangedListener.getCallingPid(), onModeChangedListener.getCallingUid()) == false) goto L22;
        Binder.restoreCallingIdentity(identity);
    L30:
        r2 = r2 + 1;
        goto L17
    L22:
        onModeChangedListener.onOpModeChanged(switchedCode, uid, packageName, persistentDeviceId);     // Catch: Throwable -> L24 RemoteException -> L26
    L23:
        Binder.restoreCallingIdentity(identity);
        goto L30
    L31:
        return;
    L13:
        if (onModeChangedListener.getWatchedOpCode() != (-1)) goto L15;
        switchedCodes = new int[]{code};
        goto L16
    L15:
        switchedCodes = new int[]{onModeChangedListener.getWatchedOpCode()};
        goto L16
    }

    private static ArrayList<ChangeRec> addChange(ArrayList<ChangeRec> reports, int op, int uid, String packageName, int previousMode) {
        boolean duplicate = false;
        if (reports != null) goto L5;
        reports = new ArrayList();
    L13:
        if (duplicate == true) goto L15;
        reports.add(new ChangeRec(op, uid, packageName, previousMode));
    L15:
        return reports;
    L5:
        int reportCount = reports.size();
        int j = 0;
    L6:
        if (j >= reportCount) goto L13;
        ChangeRec report = reports.get(j);
        if (report.op != op) goto L12;
        if (report.pkg.equals(packageName) == false) goto L12;
        duplicate = true;
    L12:
        j = j + 1;
        goto L6
    }

    private static HashMap<OnOpModeChangedListener, ArrayList<ChangeRec>> addCallbacks(HashMap<OnOpModeChangedListener, ArrayList<ChangeRec>> callbacks, int op, int uid, String packageName, int previousMode, ArraySet<OnOpModeChangedListener> cbs) {
        if (cbs != null) goto L4;
        return callbacks;
    L4:
        if (callbacks != null) goto L6;
        callbacks = new HashMap();
    L6:
        int N = cbs.size();
        int i = 0;
    L7:
        if (i >= N) goto L13;
        OnOpModeChangedListener cb = cbs.valueAt(i);
        ArrayList<ChangeRec> reports = callbacks.get(cb);
        ArrayList<ChangeRec> changed = addChange(reports, op, uid, packageName, previousMode);
        if (changed == reports) goto L11;
        callbacks.put(cb, changed);
    L11:
        i = i + 1;
        goto L7
    L13:
        return callbacks;
    }

    public void resetAllModes(int reqUserId, String reqPackageName) {
        AppOpsService r1 = this;
        String r7 = reqPackageName;
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        int reqUserId2 = ActivityManager.handleIncomingUser(callingPid, callingUid, reqUserId, true, true, "resetAllModes", null);
        if (r7 != null) goto L139;
    L7:
        int reqUid = -1;
    L8:
        r1.enforceManageAppOpsModes(callingPid, callingUid, reqUid);
        ArrayList<ChangeRec> allChanges = new ArrayList();
        monitor-enter(this);
        boolean changed = false;
    L145:
        th = th;
    L127:
        monitor-exit(this);     // Catch: Throwable -> L126
    L126:
        th = th;
        goto L127
    L128:
        throw th;
    L12:
        int i = r1.mUidStates.size() - 1;
        HashMap<OnOpModeChangedListener, ArrayList<ChangeRec>> callbacks = null;
        ArrayList<ChangeRec> allChanges2 = allChanges;
    L13:
        if (i < 0) goto L102;
        UidState uidState = r1.mUidStates.valueAt(i);     // Catch: Throwable -> L37
        SparseIntArray opModes = r1.mAppOpsCheckingService.getNonDefaultUidModes(uidState.uid, "default:0");     // Catch: Throwable -> L37
        if (opModes == null) goto L43;
        if (uidState.uid == reqUid) goto L21;
        if (reqUid != (-1)) goto L43;
    L21:
        int uidOpCount = opModes.size();     // Catch: Throwable -> L37
        int j = uidOpCount - 1;     // Catch: Throwable -> L37
    L22:
        if (j < 0) goto L41;
        int code = opModes.keyAt(j);     // Catch: Throwable -> L37
        if (AppOpsManager.opAllowsReset(code) == false) goto L40;
        int previousMode = opModes.valueAt(j);     // Catch: Throwable -> L37
        int code2 = code;
        if (r1.isUidOpGrantedByRole(uidState.uid, code2) == false) goto L28;
        int newMode = 0;
    L29:
        r1.mAppOpsCheckingService.setUidMode(uidState.uid, "default:0", code2, newMode);     // Catch: Throwable -> L37
        String[] r0 = getPackagesForUid(uidState.uid);     // Catch: Throwable -> L37
        int r3 = r0.length;     // Catch: Throwable -> L37
        HashMap<OnOpModeChangedListener, ArrayList<ChangeRec>> callbacks2 = callbacks;
        int r4 = 0;
    L31:
        if (r4 >= r3) goto L36;
        String packageName = r0[r4];     // Catch: Throwable -> L34
        String[] r26 = r0;
        int code3 = code2;
        HashMap<OnOpModeChangedListener, ArrayList<ChangeRec>> r2 = addCallbacks(addCallbacks(callbacks2, code3, uidState.uid, packageName, previousMode, r1.mOpModeWatchers.get(code2)), code3, uidState.uid, packageName, previousMode, r1.mPackageModeWatchers.get(packageName));     // Catch: Throwable -> L34
        code2 = code3;
        int previousMode2 = previousMode;
        callbacks2 = r2;
        int r18 = r3;
        allChanges2 = addChange(allChanges2, code2, uidState.uid, packageName, previousMode2);     // Catch: Throwable -> L34
        r4 = r4 + 1;
        previousMode = previousMode2;
        r3 = r18;
        r0 = r26;
    L34:
        th = th;
        goto L127
    L36:
        callbacks = callbacks2;
        goto L40
    L28:
        newMode = AppOpsManager.opToDefaultMode(code2);     // Catch: Throwable -> L37
    L40:
        j = j - 1;
        changed = changed;
        opModes = opModes;
        i = i;
        goto L22
    L41:
        changed = changed;
        i = i;
        ArrayList<ChangeRec> allChanges3 = allChanges2;
    L133:
        if (uidState.pkgOps.isEmpty() == false) goto L48;
    L51:
        allChanges2 = allChanges3;
        changed = changed;
    L100:
        i = i - 1;
        r7 = reqPackageName;
        goto L13
    L48:
        if (reqUserId2 != (-1)) goto L50;
    L54:
        Map<String, Ops> packages = uidState.pkgOps;     // Catch: Throwable -> L52
        Iterator<Map.Entry<String, Ops>> it = packages.entrySet().iterator();     // Catch: Throwable -> L52
    L56:
        if (it.hasNext() == false) goto L99;
        Map.Entry<String, Ops> ent = it.next();     // Catch: Throwable -> L52
        String packageName2 = ent.getKey();     // Catch: Throwable -> L52
        if (r7 == null) goto L62;
        if (r7.equals(packageName2) == false) goto L56;
    L62:
        Ops pkgOps = ent.getValue();     // Catch: Throwable -> L52
        int j2 = pkgOps.size() - 1;
    L64:
        if (j2 < 0) goto L94;
        Op curOp = pkgOps.valueAt(j2);     // Catch: Throwable -> L90
        Map<String, Ops> packages2 = packages;
        if (r1.shouldDeferResetOpToDpm(curOp.op) == false) goto L70;
        r1.deferResetOpToDpm(curOp.op, r7, reqUserId2);     // Catch: Throwable -> L52
        Iterator<Map.Entry<String, Ops>> it2 = it;
        Map.Entry<String, Ops> ent2 = ent;
        Ops pkgOps2 = pkgOps;
        int j3 = j2;
        HashMap<OnOpModeChangedListener, ArrayList<ChangeRec>> callbacks3 = callbacks;
        String packageName3 = packageName2;
    L93:
        j2 = j3 - 1;
        r7 = reqPackageName;
        packageName2 = packageName3;
        callbacks = callbacks3;
        it = it2;
        ent = ent2;
        pkgOps = pkgOps2;
        packages = packages2;
        goto L64
    L70:
        if (AppOpsManager.opAllowsReset(curOp.op) == false) goto L92;
        it2 = it;
        ent2 = ent;
        int previousMode3 = r1.mAppOpsCheckingService.getPackageMode(curOp.packageName, curOp.op, UserHandle.getUserId(curOp.uid));     // Catch: Throwable -> L90
        if (r1.isPackageOpGrantedByRole(packageName2, uidState.uid, curOp.op) == false) goto L74;
        int newMode2 = 0;
    L75:
        if (previousMode3 != newMode2) goto L77;
        pkgOps2 = pkgOps;
        j3 = j2;
        callbacks3 = callbacks;
        packageName3 = packageName2;
        goto L93
    L77:
        String packageName4 = packageName2;
        r1.mAppOpsCheckingService.setPackageMode(curOp.packageName, curOp.op, newMode2, UserHandle.getUserId(curOp.uid));     // Catch: Throwable -> L90
        changed = true;
        int uid = curOp.uidState.uid;     // Catch: Throwable -> L90
        j3 = j2;
        int j4 = curOp.op;     // Catch: Throwable -> L90
        pkgOps2 = pkgOps;
        HashMap<OnOpModeChangedListener, ArrayList<ChangeRec>> callbacks4 = callbacks;
        packageName3 = packageName4;
        callbacks4 = addCallbacks(callbacks4, j4, uid, packageName4, previousMode3, r1.mOpModeWatchers.get(curOp.op));     // Catch: Throwable -> L88
        HashMap<OnOpModeChangedListener, ArrayList<ChangeRec>> callbacks5 = addCallbacks(callbacks4, curOp.op, uid, packageName3, previousMode3, r1.mPackageModeWatchers.get(packageName3));     // Catch: Throwable -> L88
        allChanges3 = addChange(allChanges3, curOp.op, uid, packageName3, previousMode3);     // Catch: Throwable -> L85
        curOp.removeAttributionsWithNoTime();     // Catch: Throwable -> L85
        if (curOp.mDeviceAttributedOps.isEmpty() == false) goto L87;
        pkgOps2.removeAt(j3);     // Catch: Throwable -> L85
        BinderCallCacheAgent.removeCheckPackageBinderCache(uid);     // Catch: Throwable -> L85
    L87:
        callbacks3 = callbacks5;
    L85:
        th = th;
    L88:
        th = th;
        goto L127
    L74:
        newMode2 = AppOpsManager.opToDefaultMode(curOp.op);     // Catch: Throwable -> L90
        goto L75
    L92:
        it2 = it;
        ent2 = ent;
        pkgOps2 = pkgOps;
        j3 = j2;
        callbacks3 = callbacks;
        packageName3 = packageName2;
    L90:
        th = th;
        goto L127
    L94:
        Map<String, Ops> packages3 = packages;
        Iterator<Map.Entry<String, Ops>> it3 = it;
        Ops pkgOps3 = pkgOps;
        HashMap<OnOpModeChangedListener, ArrayList<ChangeRec>> callbacks6 = callbacks;
        String packageName5 = packageName2;
        if (pkgOps3.size() != 0) goto L98;
        it3.remove();     // Catch: Throwable -> L88
        r1.mAppOpsCheckingService.removePackage(packageName5, UserHandle.getUserId(uidState.uid));     // Catch: Throwable -> L88
    L98:
        r7 = reqPackageName;
        callbacks = callbacks6;
        packages = packages3;
        it = it3;
        goto L56
    L99:
        allChanges2 = allChanges3;
        changed = changed;
        goto L100
    L50:
        if (reqUserId2 == UserHandle.getUserId(uidState.uid)) goto L54;
    L52:
        th = th;
    L43:
        allChanges3 = allChanges2;
    L37:
        th = th;
        goto L127
    L102:
        if (changed == false) goto L104;
        r1.scheduleFastWriteLocked();     // Catch: Throwable -> L37
    L104:
        monitor-exit(this);     // Catch: Throwable -> L37
        if (callbacks == null) goto L121;
        Iterator<Map.Entry<OnOpModeChangedListener, ArrayList<ChangeRec>>> r8 = callbacks.entrySet().iterator();
    L108:
        if (r8.hasNext() == false) goto L121;
        Map.Entry<OnOpModeChangedListener, ArrayList<ChangeRec>> ent3 = r8.next();
        OnOpModeChangedListener cb = ent3.getKey();
        ArrayList<ChangeRec> reports = ent3.getValue();
        int i2 = 0;
    L111:
        if (i2 >= reports.size()) goto L120;
        ChangeRec rep = reports.get(i2);
        Set<String> devices = new ArraySet();
        devices.add("default:0");
        if (r1.mVirtualDeviceManagerInternal == null) goto L115;
        devices.addAll(r1.mVirtualDeviceManagerInternal.getAllPersistentDeviceIds());
    L115:
        Iterator<String> r16 = devices.iterator();
    L117:
        if (r16.hasNext() == false) goto L119;
        String device = r16.next();
        r1.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda11(), r1, cb, Integer.valueOf(rep.op), Integer.valueOf(rep.uid), rep.pkg, device));
        r1 = this;
        r8 = r8;
        i2 = i2;
        rep = rep;
        devices = devices;
        goto L117
    L119:
        i2 = i2 + 1;
        r1 = this;
        goto L111
    L120:
        r1 = this;
    L121:
        int numChanges = allChanges2.size();
        int i3 = 0;
    L122:
        if (i3 >= numChanges) goto L125;
        ChangeRec change = allChanges2.get(i3);
        notifyStorageManagerOpModeChangedSync(change.op, change.uid, change.pkg, AppOpsManager.opToDefaultMode(change.op), change.previous_mode);
        i3 = i3 + 1;
        goto L122
    L125:
        return;
    L139:
        int reqUid2 = AppGlobals.getPackageManager().getPackageUid(r7, 8192, reqUserId2);     // Catch: RemoteException -> L6
        reqUid = reqUid2;
        goto L8
    }

    private boolean isUidOpGrantedByRole(int uid, int code) {
        boolean r1 = false;
        if (AppOpsManager.opIsUidAppOpPermission(code) == true) goto L5;
        return false;
    L5:
        PackageManager packageManager = this.mContext.getPackageManager();
        long token = Binder.clearCallingIdentity();
        String packageName = (String) ArrayUtils.firstOrNull(ArrayUtils.defeatNullable(packageManager.getPackagesForUid(uid)));     // Catch: Throwable -> L16
        if (packageName != null) goto L10;
        Binder.restoreCallingIdentity(token);
        return false;
    L10:
        int permissionFlags = packageManager.getPermissionFlags(AppOpsManager.opToPermission(code), packageName, UserHandle.getUserHandleForUid(uid));     // Catch: Throwable -> L16
        if ((32768 & permissionFlags) == 0) goto L14;
        r1 = true;
    L14:
        Binder.restoreCallingIdentity(token);
        return r1;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private boolean isPackageOpGrantedByRole(String packageName, int uid, int code) {
        boolean r1 = false;
        if (AppOpsManager.opIsPackageAppOpPermission(code) == true) goto L5;
        return false;
    L5:
        PackageManager packageManager = this.mContext.getPackageManager();
        long token = Binder.clearCallingIdentity();
        int permissionFlags = packageManager.getPermissionFlags(AppOpsManager.opToPermission(code), packageName, UserHandle.getUserHandleForUid(uid));     // Catch: Throwable -> L12
        if ((32768 & permissionFlags) == 0) goto L10;
        r1 = true;
    L10:
        Binder.restoreCallingIdentity(token);
        return r1;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private boolean shouldDeferResetOpToDpm(int op) {
        if (this.dpmi != null) goto L5;
    L7:
        return false;
    L5:
        if (this.dpmi.supportsResetOp(op) == false) goto L7;
        return true;
    }

    private void deferResetOpToDpm(int op, String packageName, int userId) {
        this.dpmi.resetOp(op, packageName, userId);
    }

    public void startWatchingMode(int op, String packageName, IAppOpsCallback callback) {
        startWatchingModeWithFlags(op, packageName, 0, callback);
    }

    public void startWatchingModeWithFlags(int op, String packageName, int flags, IAppOpsCallback callback) {
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        Preconditions.checkArgumentInRange(op, -1, 165, "Invalid op code: " + op);
        if (callback != null) goto L5;
        return;
    L5:
        if (packageName != null) goto L7;
    L9:
        boolean r0 = false;
    L10:
        boolean mayWatchPackageName = r0;
        monitor-enter(this);
        if (op != (-1)) goto L40;
        int r1 = op;
    L17:
        int switchOp = r1;
        if ((flags & 2) != 0) goto L22;
        if (op != (-1)) goto L21;
        int notifiedOps = -2;
    L23:
        ModeCallback cb = this.mModeWatchers.get(callback.asBinder());     // Catch: Throwable -> L14
        if (cb != null) goto L26;
        cb = new ModeCallback(this, callback, -1, flags, notifiedOps, callingUid, callingPid);     // Catch: Throwable -> L14
        this.mModeWatchers.put(callback.asBinder(), cb);     // Catch: Throwable -> L14
    L26:
        if (switchOp == (-1)) goto L31;
        ArraySet<OnOpModeChangedListener> cbs = this.mOpModeWatchers.get(switchOp);     // Catch: Throwable -> L14
        if (cbs != null) goto L30;
        cbs = new ArraySet();     // Catch: Throwable -> L14
        this.mOpModeWatchers.put(switchOp, cbs);     // Catch: Throwable -> L14
    L30:
        cbs.add(cb);     // Catch: Throwable -> L14
    L31:
        if (mayWatchPackageName == false) goto L36;
        ArraySet<OnOpModeChangedListener> cbs2 = this.mPackageModeWatchers.get(packageName);     // Catch: Throwable -> L14
        if (cbs2 != null) goto L35;
        cbs2 = new ArraySet();     // Catch: Throwable -> L14
        this.mPackageModeWatchers.put(packageName, cbs2);     // Catch: Throwable -> L14
    L35:
        cbs2.add(cb);     // Catch: Throwable -> L14
    L36:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L21:
        notifiedOps = op;
        goto L23
    L22:
        notifiedOps = switchOp;
        goto L23
    L40:
        r1 = AppOpsManager.opToSwitch(op);     // Catch: Throwable -> L14
        goto L17
    L7:
        if (filterAppAccessUnlocked(packageName, UserHandle.getUserId(callingUid)) == true) goto L9;
        r0 = true;
        goto L10
    }

    public void stopWatchingMode(IAppOpsCallback callback) {
        if (callback != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        ModeCallback cb = this.mModeWatchers.remove(callback.asBinder());     // Catch: Throwable -> L12
        if (cb == null) goto L21;
        cb.unlinkToDeath();     // Catch: Throwable -> L12
        int i = this.mOpModeWatchers.size() - 1;     // Catch: Throwable -> L12
    L8:
        if (i < 0) goto L15;
        ArraySet<OnOpModeChangedListener> cbs = this.mOpModeWatchers.valueAt(i);     // Catch: Throwable -> L12
        cbs.remove(cb);     // Catch: Throwable -> L12
        if (cbs.size() > 0) goto L14;
        this.mOpModeWatchers.removeAt(i);     // Catch: Throwable -> L12
    L14:
        i = i - 1;     // Catch: Throwable -> L12
        goto L8
    L15:
        int i2 = this.mPackageModeWatchers.size() - 1;     // Catch: Throwable -> L12
    L16:
        if (i2 < 0) goto L21;
        ArraySet<OnOpModeChangedListener> cbs2 = this.mPackageModeWatchers.valueAt(i2);     // Catch: Throwable -> L12
        cbs2.remove(cb);     // Catch: Throwable -> L12
        if (cbs2.size() > 0) goto L20;
        this.mPackageModeWatchers.removeAt(i2);     // Catch: Throwable -> L12
    L20:
        i2 = i2 - 1;     // Catch: Throwable -> L12
    L21:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void setCheckOpsDelegate(AppOpsManagerInternal.CheckOpsDelegate delegate) {
        monitor-enter(this);
        CheckOpsDelegateDispatcher oldDispatcher = this.mCheckOpsDelegateDispatcher;     // Catch: Throwable -> L6
        if (oldDispatcher == null) goto L8;
        AppOpsManagerInternal.CheckOpsDelegate policy = CheckOpsDelegateDispatcher.m1762$$Nest$fgetmPolicy(oldDispatcher);     // Catch: Throwable -> L6
    L9:
        this.mCheckOpsDelegateDispatcher = new CheckOpsDelegateDispatcher(this, policy, delegate);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L8:
        policy = null;
    L6:
        th = move-exception;
        throw th;
    }

    private static boolean isOpAllowedForUid(int uid) {
        int appId = UserHandle.getAppId(uid);
        if (appId != 0) goto L5;
    L8:
        return true;
    L5:
        if (appId == 1000) goto L8;
        return false;
    }

    public int checkOperationRaw(int code, int uid, String packageName, String attributionTag) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
    L5:
        return this.mCheckOpsDelegateDispatcher.checkOperation(code, uid, packageName, attributionTag, 0, true);
    }

    public int checkOperationRawForDevice(int code, int uid, String packageName, String attributionTag, int virtualDeviceId) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
    L5:
        return this.mCheckOpsDelegateDispatcher.checkOperation(code, uid, packageName, attributionTag, virtualDeviceId, true);
    }

    public int checkOperation(int code, int uid, String packageName) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
    L5:
        return this.mCheckOpsDelegateDispatcher.checkOperation(code, uid, packageName, null, 0, false);
    }

    public int checkOperationForDevice(int code, int uid, String packageName, String attributionTag, int virtualDeviceId) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
    L5:
        return this.mCheckOpsDelegateDispatcher.checkOperation(code, uid, packageName, attributionTag, virtualDeviceId, false);
    }

    private int checkOperationImpl(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean raw) {
        if (shouldUseNewCheckOp() == true) goto L16;
        verifyIncomingOp(code);
        if (isValidVirtualDeviceId(virtualDeviceId) == true) goto L9;
        Slog.w(TAG, "checkOperationImpl returned MODE_IGNORED as virtualDeviceId " + virtualDeviceId + " is invalid");
        return 1;
    L9:
        if (isIncomingPackageValid(packageName, UserHandle.getUserId(uid)) == false) goto L11;
        String resolvedPackageName = AppOpsManager.resolvePackageName(uid, packageName);
        if (resolvedPackageName != null) goto L15;
        return 1;
    L15:
        String resolvedPackageName2 = resolvedPackageName;
    L21:
        return getAppOpMode(code, uid, resolvedPackageName2, attributionTag, virtualDeviceId, raw, true);
    L11:
        return AppOpsManager.opToDefaultMode(code);
    L16:
        String resolvedPackageName3 = validateOpRequest(code, uid, packageName, virtualDeviceId, false, "checkOperation");
        if (resolvedPackageName3 != null) goto L19;
        return 1;
    L19:
        resolvedPackageName2 = resolvedPackageName3;
        goto L21
    }

    private int checkOperationUnchecked(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean raw) {
        PackageVerificationResult pvr = verifyAndGetBypass(uid, packageName, null);     // Catch: SecurityException -> L70
        if (isOpRestrictedDueToSuspend(code, packageName, uid) == false) goto L7;
        return 1;
    L7:
        monitor-enter(this);
    L63:
        th = th;
    L68:
        monitor-exit(this);     // Catch: Throwable -> L42
        throw th;
    L74:
        if (isOpRestrictedLocked(uid, code, packageName, attributionTag, virtualDeviceId, pvr.bypass, true) == false) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L14
        return 1;
    L18:
        if (isOpAllowedForUid(uid) == false) goto L22;
        monitor-exit(this);     // Catch: Throwable -> L14
        return 0;
    L22:
        if (this.mSmtEx.mEnabled == true) goto L26;
        monitor-exit(this);     // Catch: Throwable -> L14
        return 0;
    L26:
        if (this.mSmtEx.canIgnoreCheckOp(code, uid, packageName) == false) goto L29;
        monitor-exit(this);     // Catch: Throwable -> L14
        return 0;
    L29:
        int code2 = AppOpsManager.opToSwitch(code);     // Catch: Throwable -> L63
        UidState uidState = getUidStateLocked(uid, false);     // Catch: Throwable -> L44
        if (uidState == null) goto L78;
        AppOpsCheckingServiceInterface r5 = this.mAppOpsCheckingService;     // Catch: Throwable -> L44
        int r6 = uidState.uid;     // Catch: Throwable -> L44
        int rawUidMode = r5.getUidMode(r6, getPersistentDeviceIdForOp(virtualDeviceId, code2), code2);     // Catch: Throwable -> L42
        if (rawUidMode == AppOpsManager.opToDefaultMode(code2)) goto L78;
        if (raw == false) goto L39;
        int r7 = rawUidMode;
    L40:
        monitor-exit(this);     // Catch: Throwable -> L42
        return r7;
    L39:
        r7 = evaluateForegroundMode(uid, code2, rawUidMode);     // Catch: Throwable -> L42
    L42:
        th = th;
    L78:
        Op op = getOpLocked(code2, uid, packageName, null, false, pvr.bypass, false);     // Catch: Throwable -> L61
        if (op != null) goto L55;
        int r4 = evaluateForegroundMode(uid, code2, AppOpsManager.opToDefaultMode(code2));     // Catch: Throwable -> L42
        monitor-exit(this);     // Catch: Throwable -> L42
        return r4;
    L55:
        int packageMode = this.mAppOpsCheckingService.getPackageMode(op.packageName, op.op, UserHandle.getUserId(op.uid));     // Catch: Throwable -> L42
        if (raw == false) goto L58;
        int r8 = packageMode;
    L59:
        monitor-exit(this);     // Catch: Throwable -> L42
        return r8;
    L58:
        r8 = evaluateForegroundMode(uid, op.op, packageMode);     // Catch: Throwable -> L42
    L61:
        th = th;
    L44:
        th = th;
    L14:
        th = th;
    L66:
        th = th;
    L70:
        e = move-exception;
        logVerifyAndGetBypassFailure(uid, e, "checkOperation");
        return AppOpsManager.opToDefaultMode(code);
    }

    private int getAppOpMode(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean raw, boolean isCheckOp) {
        PackageVerificationResult pvr = verifyAndGetBypass(uid, packageName, attributionTag);     // Catch: SecurityException -> L40
        if (isOpRestrictedDueToSuspend(code, packageName, uid) == false) goto L7;
        return 1;
    L7:
        monitor-enter(this);
    L14:
        th = th;
    L38:
        monitor-exit(this);     // Catch: Throwable -> L30
        throw th;
    L11:
        if (isOpRestrictedLocked(uid, code, packageName, attributionTag, virtualDeviceId, pvr.bypass, isCheckOp) == false) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L14
        return 1;
    L17:
        if (isOpAllowedForUid(uid) == false) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L14
        return 0;
    L21:
        int switchCode = AppOpsManager.opToSwitch(code);     // Catch: Throwable -> L14
        AppOpsCheckingServiceInterface r1 = this.mAppOpsCheckingService;     // Catch: Throwable -> L14
        int rawUidMode = r1.getUidMode(uid, getPersistentDeviceIdForOp(virtualDeviceId, switchCode), switchCode);     // Catch: Throwable -> L30
        if (rawUidMode == AppOpsManager.opToDefaultMode(switchCode)) goto L32;
        if (raw == false) goto L27;
        int r5 = rawUidMode;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L30
        return r5;
    L27:
        r5 = evaluateForegroundMode(uid, switchCode, rawUidMode);     // Catch: Throwable -> L30
        goto L28
    L32:
        int rawPackageMode = this.mAppOpsCheckingService.getPackageMode(packageName, switchCode, UserHandle.getUserId(uid));     // Catch: Throwable -> L30
        if (raw == false) goto L35;
        int r7 = rawPackageMode;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L30
        return r7;
    L35:
        r7 = evaluateForegroundMode(uid, switchCode, rawPackageMode);     // Catch: Throwable -> L30
    L30:
        th = th;
    L40:
        e = move-exception;
        logVerifyAndGetBypassFailure(uid, e, "getAppOpMode");
        return 1;
    }

    public int checkAudioOperation(int code, int usage, int uid, String packageName) {
        return this.mCheckOpsDelegateDispatcher.checkAudioOperation(code, usage, uid, packageName);
    }

    private int checkAudioOperationImpl(int code, int usage, int uid, String packageName) {
        int mode = this.mAudioRestrictionManager.checkAudioOperation(code, usage, uid, packageName);
        if (mode == 0) goto L6;
        return mode;
    L6:
        if (this.mSmtEx.mEnabled == true) goto L10;
        return 0;
    L10:
        return checkOperation(code, uid, packageName);
    }

    public void setAudioRestriction(int code, int usage, int uid, int mode, String[] exceptionPackages) {
        enforceManageAppOpsModes(Binder.getCallingPid(), Binder.getCallingUid(), uid);
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        this.mAudioRestrictionManager.setZenModeAudioRestriction(code, usage, uid, mode, exceptionPackages);
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda8(), this, Integer.valueOf(code), -2));
    }

    public void setCameraAudioRestriction(int mode) {
        enforceManageAppOpsModes(Binder.getCallingPid(), Binder.getCallingUid(), -1);
        this.mAudioRestrictionManager.setCameraAudioRestriction(mode);
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda8(), this, 28, -2));
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda8(), this, 3, -2));
    }

    public int checkPackage(int uid, String packageName) {
        packageName.getClass();
        if (this.mSmtEx.mEnabled == true) goto L25;
        return 0;
    L25:
        verifyAndGetBypass(uid, packageName, null, -1, null, true, true);     // Catch: SecurityException -> L15
        if (resolveNonAppUid(packageName) != uid) goto L11;
    L18:
        return 0;
    L11:
        if (isPackageExisted(packageName) == false) goto L17;
        if (filterAppAccessUnlocked(packageName, UserHandle.getUserId(uid)) == false) goto L18;
    L17:
        return 2;
    L22:
        return 2;
    }

    private boolean isPackageExisted(String packageName) {
        if (getPackageManagerInternal().getPackageStateInternal(packageName) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean filterAppAccessUnlocked(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        return ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).filterAppAccess(packageName, callingUid, userId);
    }

    public SyncNotedAppOp noteProxyOperation(int code, AttributionSource attributionSource, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation) {
        return this.mCheckOpsDelegateDispatcher.noteProxyOperation(code, attributionSource, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation);
    }

    public SyncNotedAppOp noteProxyOperationWithState(int code, AttributionSourceState attributionSourceState, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation) {
        if (Binder.getCallingPid() != Process.myPid()) goto L4;
    L4:
        AttributionSource attributionSource = new AttributionSource(attributionSourceState);
        return this.mCheckOpsDelegateDispatcher.noteProxyOperation(code, attributionSource, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation);
    }

    private SyncNotedAppOp noteProxyOperationImpl(int code, AttributionSource attributionSource, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation) {
        int proxyUid = attributionSource.getUid();
        String proxyPackageName = attributionSource.getPackageName();
        String proxyAttributionTag = attributionSource.getAttributionTag();
        int proxyVirtualDeviceId = attributionSource.getDeviceId();
        int proxiedUid = attributionSource.getNextUid();
        String proxiedPackageName = attributionSource.getNextPackageName();
        String proxiedAttributionTag = attributionSource.getNextAttributionTag();
        int proxiedVirtualDeviceId = attributionSource.getNextDeviceId();
        verifyIncomingProxyUid(attributionSource);
        verifyIncomingOp(code);
        if (isValidVirtualDeviceId(proxyVirtualDeviceId) == true) goto L6;
        Slog.w(TAG, "noteProxyOperationImpl returned MODE_IGNORED as virtualDeviceId " + proxyVirtualDeviceId + " is invalid");
        return new SyncNotedAppOp(1, code, proxiedAttributionTag, proxiedPackageName);
    L6:
        int proxyFlags = 2;
        if (isIncomingPackageValid(proxiedPackageName, UserHandle.getUserId(proxiedUid)) == false) goto L60;
        if (isIncomingPackageValid(proxyPackageName, UserHandle.getUserId(proxyUid)) == false) goto L60;
        if (skipProxyOperation == true) goto L13;
    L15:
        boolean r12 = false;
    L16:
        boolean skipProxyOperation2 = r12;
        String resolveProxyPackageName = AppOpsManager.resolvePackageName(proxyUid, proxyPackageName);
        if (resolveProxyPackageName != null) goto L21;
        return new SyncNotedAppOp(1, code, proxiedAttributionTag, proxiedPackageName);
    L21:
        if (Binder.getCallingUid() != proxiedUid) goto L23;
        boolean r13 = true;
    L24:
        boolean isSelfBlame = r13;
        if (this.mContext.checkPermission("android.permission.UPDATE_APP_OPS_STATS", -1, proxyUid) == 0) goto L29;
        if (isSelfBlame == true) goto L29;
        boolean r8 = false;
    L30:
        boolean isProxyTrusted = r8;
        if (skipProxyOperation2 == true) goto L44;
        if (isProxyTrusted == true) goto L35;
        proxyFlags = 4;
    L35:
        int proxyFlags2 = proxyFlags;
        if (isProxyTrusted == true) goto L38;
        boolean r11 = true;
    L39:
        int proxiedUid2 = proxyVirtualDeviceId;
        String proxiedPackageName2 = proxiedPackageName;
        SyncNotedAppOp proxyReturn = noteOperationUnchecked(code, proxyUid, resolveProxyPackageName, proxyAttributionTag, proxiedUid2, -1, null, null, 0, proxyFlags2, r11, "proxy " + message, shouldCollectMessage, 1);
        if (proxyReturn.getOpMode() != 0) goto L42;
        String proxiedAttributionTag2 = proxiedAttributionTag;
    L45:
        String resolveProxiedPackageName = AppOpsManager.resolvePackageName(proxiedUid, proxiedPackageName2);
        if (resolveProxiedPackageName != null) goto L50;
        return new SyncNotedAppOp(1, code, proxiedAttributionTag2, proxiedPackageName2);
    L50:
        if (this.mSmtEx.mEnabled == false) goto L52;
        if (isProxyTrusted == false) goto L55;
        int proxiedFlags = 8;
    L57:
        return noteOperationUnchecked(code, proxiedUid, resolveProxiedPackageName, proxiedAttributionTag2, proxiedVirtualDeviceId, proxyUid, resolveProxyPackageName, proxyAttributionTag, proxiedUid2, proxiedFlags, shouldCollectAsyncNotedOp, message, shouldCollectMessage, 1);
    L55:
        proxiedFlags = 16;
        goto L57
    L52:
        return new SyncNotedAppOp(0, code, proxiedAttributionTag2, proxiedPackageName2);
    L42:
        return new SyncNotedAppOp(proxyReturn.getOpMode(), code, proxiedAttributionTag, proxiedPackageName2);
    L38:
        r11 = false;
        goto L39
    L44:
        proxiedPackageName2 = proxiedPackageName;
        proxiedUid2 = proxyVirtualDeviceId;
        proxiedAttributionTag2 = proxiedAttributionTag;
    L29:
        r8 = true;
        goto L30
    L23:
        r13 = false;
        goto L24
    L13:
        if (isCallerAndAttributionTrusted(attributionSource) == false) goto L15;
        r12 = true;
    L60:
        return new SyncNotedAppOp(2, code, proxiedAttributionTag, proxiedPackageName);
    }

    public void noteOperationsInBatch(Map batchedNoteOps) {
        Iterator r0 = batchedNoteOps.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<AppOpsManager.NotedOp, Integer> entry = (Map.Entry) r0.next();
        AppOpsManager.NotedOp notedOp = entry.getKey();
        int notedCount = entry.getValue().intValue();
        this.mCheckOpsDelegateDispatcher.noteOperation(notedOp.getOp(), notedOp.getUid(), notedOp.getPackageName(), notedOp.getAttributionTag(), notedOp.getVirtualDeviceId(), notedOp.getShouldCollectAsyncNotedOp(), notedOp.getMessage(), notedOp.getShouldCollectMessage(), notedCount);
        goto L4
    }

    public SyncNotedAppOp noteOperation(int code, int uid, String packageName, String attributionTag, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
    L5:
        return this.mCheckOpsDelegateDispatcher.noteOperation(code, uid, packageName, attributionTag, 0, shouldCollectAsyncNotedOp, message, shouldCollectMessage, 1);
    }

    public SyncNotedAppOp noteOperationForDevice(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage) {
        return this.mCheckOpsDelegateDispatcher.noteOperation(code, uid, packageName, attributionTag, virtualDeviceId, shouldCollectAsyncNotedOp, message, shouldCollectMessage, 1);
    }

    private SyncNotedAppOp noteOperationImpl(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int notedCount) {
        if (shouldUseNewCheckOp() == true) goto L20;
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        if (isValidVirtualDeviceId(virtualDeviceId) == true) goto L9;
        Slog.w(TAG, "checkOperationImpl returned MODE_IGNORED as virtualDeviceId " + virtualDeviceId + " is invalid");
        return new SyncNotedAppOp(1, code, attributionTag, packageName);
    L9:
        if (isIncomingPackageValid(packageName, UserHandle.getUserId(uid)) == false) goto L11;
        String resolvedPackageName = AppOpsManager.resolvePackageName(uid, packageName);
        if (resolvedPackageName == null) goto L18;
        String r15 = packageName;
        String resolvedPackageName2 = resolvedPackageName;
    L26:
        if (this.mSmtEx.mEnabled == true) goto L30;
        return new SyncNotedAppOp(0, code, attributionTag, r15);
    L30:
        return noteOperationUnchecked(code, uid, resolvedPackageName2, attributionTag, virtualDeviceId, -1, null, null, 0, 1, shouldCollectAsyncNotedOp, message, shouldCollectMessage, notedCount);
    L18:
        return new SyncNotedAppOp(1, code, attributionTag, packageName);
    L11:
        if (code != 111) goto L14;
        Slog.e(TAG, "noting OP_BLUETOOTH_CONNECT returned MODE_ERRORED as incoming package: " + packageName + " and uid: " + uid + " is invalid");
    L14:
        return new SyncNotedAppOp(2, code, attributionTag, packageName);
    L20:
        String resolvedPackageName3 = validateOpRequest(code, uid, packageName, virtualDeviceId, true, "noteOperation");
        r15 = packageName;
        if (resolvedPackageName3 == null) goto L23;
        resolvedPackageName2 = resolvedPackageName3;
        goto L26
    L23:
        return new SyncNotedAppOp(1, code, attributionTag, r15);
    }

    private SyncNotedAppOp noteOperationUnchecked(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, int proxyUid, String proxyPackageName, String proxyAttributionTag, int proxyVirtualDeviceId, int flags, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int notedCount) {
        String proxyAttributionTag2 = proxyAttributionTag;
        if ((flags & 16) != 0) goto L5;
        boolean proxyTrusted = true;
    L190:
        PackageVerificationResult pvr = verifyAndGetBypass(uid, packageName, attributionTag, proxyUid, proxyPackageName, proxyTrusted);     // Catch: SecurityException -> L165
        int r3 = uid;
        if (pvr.isAttributionTagValid == true) goto L12;
        String attributionTag2 = null;
    L14:
        if (isOpRestrictedDueToSuspend(code, packageName, r3) == true) goto L16;
        if (proxyAttributionTag2 == null) goto L22;
        if (isAttributionTagDefined(packageName, proxyPackageName, proxyAttributionTag2) == true) goto L22;
        proxyAttributionTag2 = null;
    L22:
        monitor-enter(this);
    L159:
        th = th;
    L161:
        monitor-exit(this);     // Catch: Throwable -> L131
        throw th;
    L200:
        if (this.mSmtEx.mEnabled == true) goto L30;
        SyncNotedAppOp r0 = new SyncNotedAppOp(0, code, attributionTag2, packageName);     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r0;
    L30:
        if (this.mSmtEx.canIgnoreCheckOp(code, r3, packageName) == false) goto L35;
        SyncNotedAppOp r1 = new SyncNotedAppOp(0, code, attributionTag2, packageName);     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return r1;
    L35:
        String attributionTag3 = attributionTag2;
        Ops ops = getOpsLocked(r3, packageName, attributionTag3, pvr.isAttributionTagValid, pvr.bypass, true);     // Catch: Throwable -> L154
        if (ops == null) goto L42;
        String r4 = packageName;
        Op op = getOpLocked(ops, code, uid, true);     // Catch: Throwable -> L151
        AttributedOp attributedOp = op.getOrCreateAttribution(op, attributionTag3, getPersistentDeviceIdForOp(virtualDeviceId, code));     // Catch: Throwable -> L151
        if (attributedOp.isRunning() == false) goto L54;
        Slog.w(TAG, "Noting op not finished: uid " + uid + " pkg " + r4 + " code " + code + " startTime of in progress event=" + attributedOp.mInProgressEvents.valueAt(0).getStartTime());     // Catch: Throwable -> L45
    L54:
        int switchCode = AppOpsManager.opToSwitch(code);     // Catch: Throwable -> L151
        UidState uidState = ops.uidState;     // Catch: Throwable -> L151
        String proxyAttributionTag3 = proxyAttributionTag2;
        if (isOpRestrictedLocked(uid, code, r4, attributionTag3, virtualDeviceId, pvr.bypass, false) == true) goto L201;
        int r2 = code;
        r4 = packageName;
    L147:
        th = th;
        goto L161
    L69:
        if (isOpAllowedForUid(uid) == true) goto L115;
        if (this.mAppOpsCheckingService.getUidMode(uidState.uid, getPersistentDeviceIdForOp(virtualDeviceId, switchCode), switchCode) == AppOpsManager.opToDefaultMode(switchCode)) goto L89;
        int uidMode = uidState.evalMode(r2, this.mAppOpsCheckingService.getUidMode(uidState.uid, getPersistentDeviceIdForOp(virtualDeviceId, switchCode), switchCode));     // Catch: Throwable -> L63
        if (uidMode == 0) goto L115;
        attributedOp.rejected(uidState.getState(), flags);     // Catch: Throwable -> L63
        scheduleOpNotedIfNeededLocked(r2, uid, r4, attributionTag3, virtualDeviceId, flags, uidMode);     // Catch: Throwable -> L82
        if (r2 == 111) goto L80;
    L84:
        SyncNotedAppOp r6 = new SyncNotedAppOp(uidMode, r2, attributionTag3, r4);     // Catch: Throwable -> L82
        monitor-exit(this);     // Catch: Throwable -> L82
        return r6;
    L80:
        if (uidMode != 2) goto L84;
        Slog.e(TAG, "noting OP_BLUETOOTH_CONNECT returned MODE_ERRORED as uid mode is MODE_ERRORED");     // Catch: Throwable -> L82
        goto L84
    L89:
        if (switchCode == r2) goto L92;
        Op r7 = getOpLocked(ops, switchCode, uid, true);     // Catch: Throwable -> L82
    L93:
        Op switchOp = r7;
    L137:
        th = th;
        goto L161
    L193:
        int mode = switchOp.uidState.evalMode(switchOp.op, this.mAppOpsCheckingService.getPackageMode(switchOp.packageName, switchOp.op, UserHandle.getUserId(switchOp.uid)));     // Catch: Throwable -> L140
        if (mode != 0) goto L186;
        r2 = code;
        r4 = packageName;
        goto L115
    L186:
        attributedOp.rejected(uidState.getState(), flags);     // Catch: Throwable -> L111
        scheduleOpNotedIfNeededLocked(code, uid, packageName, attributionTag3, virtualDeviceId, flags, mode);     // Catch: Throwable -> L106
        if (code == 111) goto L104;
    L108:
        SyncNotedAppOp r5 = new SyncNotedAppOp(mode, code, attributionTag3, packageName);     // Catch: Throwable -> L106
        monitor-exit(this);     // Catch: Throwable -> L106
        return r5;
    L104:
        if (mode != 2) goto L108;
        Slog.e(TAG, "noting OP_BLUETOOTH_CONNECT returned MODE_ERRORED as package mode is MODE_ERRORED");     // Catch: Throwable -> L106
    L106:
        th = th;
    L111:
        th = th;
    L140:
        th = th;
    L142:
        th = th;
    L145:
        th = th;
        goto L161
    L92:
        r7 = op;
    L82:
        th = th;
    L115:
        scheduleOpNotedIfNeededLocked(r2, uid, r4, attributionTag3, virtualDeviceId, flags, 0);     // Catch: Throwable -> L137
        int r13 = r2;
        attributedOp.accessed(proxyUid, proxyPackageName, proxyAttributionTag3, getPersistentDeviceIdForOp(proxyVirtualDeviceId, r13), uidState.getState(), flags, notedCount);     // Catch: Throwable -> L133
        if (shouldCollectAsyncNotedOp == true) goto L178;
        String attributionTag4 = packageName;
        int r8 = r13;
        String attributionTag5 = attributionTag3;
    L128:
        SyncNotedAppOp r9 = new SyncNotedAppOp(0, r8, attributionTag5, attributionTag4);     // Catch: Throwable -> L131
        monitor-exit(this);     // Catch: Throwable -> L131
        return r9;
    L178:
        collectAsyncNotedOp(uid, packageName, r13, attributionTag3, flags, message, shouldCollectMessage, notedCount);     // Catch: Throwable -> L125
        attributionTag5 = attributionTag3;
        attributionTag4 = packageName;
        r8 = r13;
    L125:
        th = th;
    L133:
        th = th;
    L135:
        th = th;
        goto L161
    L201:
        attributedOp.rejected(uidState.getState(), flags);     // Catch: Throwable -> L65
        scheduleOpNotedIfNeededLocked(code, uid, packageName, attributionTag3, virtualDeviceId, flags, 1);     // Catch: Throwable -> L63
        SyncNotedAppOp r10 = new SyncNotedAppOp(1, code, attributionTag3, packageName);     // Catch: Throwable -> L63
        monitor-exit(this);     // Catch: Throwable -> L63
        return r10;
    L65:
        th = th;
    L63:
        th = th;
    L149:
        th = th;
    L151:
        th = th;
        goto L161
    L42:
        scheduleOpNotedIfNeededLocked(code, uid, packageName, attributionTag3, virtualDeviceId, flags, 1);     // Catch: Throwable -> L45
        if (code != 111) goto L47;
        Slog.e(TAG, "noting OP_BLUETOOTH_CONNECT returned MODE_ERRORED as #getOpsLocked returned null for uid: " + uid + " packageName: " + packageName + " attributionTag: " + attributionTag3 + " pvr.isAttributionTagValid: " + pvr.isAttributionTagValid + " pvr.bypass: " + pvr.bypass);     // Catch: Throwable -> L45
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L45
        r11.append("mUidStates.get(");     // Catch: Throwable -> L45
        r11.append(uid);     // Catch: Throwable -> L45
        r11.append("): ");     // Catch: Throwable -> L45
        r11.append(this.mUidStates.get(uid));     // Catch: Throwable -> L45
        Slog.e(TAG, r11.toString());     // Catch: Throwable -> L45
    L47:
        SyncNotedAppOp r12 = new SyncNotedAppOp(2, code, attributionTag3, packageName);     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L45
        return r12;
    L45:
        th = th;
    L154:
        th = th;
    L157:
        th = th;
    L28:
        th = th;
    L131:
        th = th;
        goto L161
    L16:
        return new SyncNotedAppOp(1, code, attributionTag2, packageName);
    L12:
        attributionTag2 = attributionTag;
    L163:
        e = e;
        String r14 = packageName;
    L167:
        logVerifyAndGetBypassFailure(r3, e, "noteOperation");
        if (r8 != 111(0x6f, float:1.56E-43)) goto L171;
        Slog.e(TAG, "noting OP_BLUETOOTH_CONNECT returned MODE_ERRORED as verifyAndGetBypass returned a SecurityException for package: " + r14 + " and uid: " + r3 + " and attributionTag: " + attributionTag, e);
    L171:
        return new SyncNotedAppOp(2, code, attributionTag, r14);
    L165:
        e = e;
        r14 = packageName;
        r3 = uid;
        goto L167
    L5:
        proxyTrusted = false;
        goto L190
    }

    public void startWatchingActive(int[] ops, IAppOpsActiveCallback callback) {
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WATCH_APPOPS") == 0) goto L5;
        int watchedUid = callingUid;
    L6:
        int watchedUid2 = 0;
        if (ops == null) goto L9;
        Preconditions.checkArrayElementsInRange(ops, 0, 165, "Invalid op code in: " + Arrays.toString(ops));
    L9:
        if (callback != null) goto L11;
        return;
    L11:
        monitor-enter(this);
        SparseArray<ActiveCallback> callbacks = this.mActiveWatchers.get(callback.asBinder());     // Catch: Throwable -> L29
        if (callbacks == null) goto L35;
        SparseArray<ActiveCallback> callbacks2 = callbacks;
    L19:
        ActiveCallback activeCallback = new ActiveCallback(this, callback, watchedUid, callingUid, callingPid);     // Catch: Throwable -> L25
        int r11 = ops.length;     // Catch: Throwable -> L25
    L23:
        if (watchedUid2 >= r11) goto L27;
        int op = ops[watchedUid2];     // Catch: Throwable -> L25
        callbacks2.put(op, activeCallback);     // Catch: Throwable -> L25
        watchedUid2 = watchedUid2 + 1;     // Catch: Throwable -> L25
        goto L23
    L27:
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L35:
        SparseArray<ActiveCallback> callbacks3 = new SparseArray();     // Catch: Throwable -> L16
        this.mActiveWatchers.put(callback.asBinder(), callbacks3);     // Catch: Throwable -> L16
        callbacks2 = callbacks3;
    L16:
        th = th;
    L31:
        monitor-exit(this);     // Catch: Throwable -> L25
        throw th;
    L25:
        th = th;
    L29:
        th = th;
        goto L31
    L5:
        watchedUid = -1;
        goto L6
    }

    public void stopWatchingActive(IAppOpsActiveCallback callback) {
        if (callback != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        SparseArray<ActiveCallback> activeCallbacks = this.mActiveWatchers.remove(callback.asBinder());     // Catch: Throwable -> L9
        if (activeCallbacks != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L11:
        int callbackCount = activeCallbacks.size();     // Catch: Throwable -> L9
        int i = 0;
    L12:
        if (i >= callbackCount) goto L15;
        activeCallbacks.valueAt(i).destroy();     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L12
    L15:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void startWatchingStarted(int[] ops, IAppOpsStartedCallback callback) {
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WATCH_APPOPS") == 0) goto L5;
        int watchedUid = callingUid;
    L6:
        Preconditions.checkArgument(!ArrayUtils.isEmpty(ops), "Ops cannot be null or empty");
        int r7 = 0;
        Preconditions.checkArrayElementsInRange(ops, 0, 165, "Invalid op code in: " + Arrays.toString(ops));
        callback.getClass();
        monitor-enter(this);
        SparseArray<StartedCallback> callbacks = this.mStartedWatchers.get(callback.asBinder());     // Catch: Throwable -> L24
        if (callbacks == null) goto L30;
    L14:
        StartedCallback startedCallback = new StartedCallback(this, callback, watchedUid, callingUid, callingPid);     // Catch: Throwable -> L20
        int r11 = ops.length;     // Catch: Throwable -> L20
    L18:
        if (r7 >= r11) goto L22;
        int op = ops[r7];     // Catch: Throwable -> L20
        callbacks.put(op, startedCallback);     // Catch: Throwable -> L20
        r7 = r7 + 1;     // Catch: Throwable -> L20
        goto L18
    L22:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L30:
        callbacks = new SparseArray();     // Catch: Throwable -> L12
        this.mStartedWatchers.put(callback.asBinder(), callbacks);     // Catch: Throwable -> L12
    L12:
        th = th;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L20
        throw th;
    L20:
        th = th;
    L24:
        th = th;
        goto L26
    L5:
        watchedUid = -1;
        goto L6
    }

    public void stopWatchingStarted(IAppOpsStartedCallback callback) {
        callback.getClass();
        monitor-enter(this);
        SparseArray<StartedCallback> startedCallbacks = this.mStartedWatchers.remove(callback.asBinder());     // Catch: Throwable -> L8
        if (startedCallbacks != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        int callbackCount = startedCallbacks.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= callbackCount) goto L14;
        startedCallbacks.valueAt(i).destroy();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void startWatchingNoted(int[] ops, IAppOpsNotedCallback callback) {
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WATCH_APPOPS") == 0) goto L5;
        int watchedUid = callingUid;
    L6:
        Preconditions.checkArgument(!ArrayUtils.isEmpty(ops), "Ops cannot be null or empty");
        int r7 = 0;
        Preconditions.checkArrayElementsInRange(ops, 0, 165, "Invalid op code in: " + Arrays.toString(ops));
        callback.getClass();
        monitor-enter(this);
        SparseArray<NotedCallback> callbacks = this.mNotedWatchers.get(callback.asBinder());     // Catch: Throwable -> L24
        if (callbacks == null) goto L30;
    L14:
        NotedCallback notedCallback = new NotedCallback(this, callback, watchedUid, callingUid, callingPid);     // Catch: Throwable -> L20
        int r11 = ops.length;     // Catch: Throwable -> L20
    L18:
        if (r7 >= r11) goto L22;
        int op = ops[r7];     // Catch: Throwable -> L20
        callbacks.put(op, notedCallback);     // Catch: Throwable -> L20
        r7 = r7 + 1;     // Catch: Throwable -> L20
        goto L18
    L22:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L30:
        callbacks = new SparseArray();     // Catch: Throwable -> L12
        this.mNotedWatchers.put(callback.asBinder(), callbacks);     // Catch: Throwable -> L12
    L12:
        th = th;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L20
        throw th;
    L20:
        th = th;
    L24:
        th = th;
        goto L26
    L5:
        watchedUid = -1;
        goto L6
    }

    public void stopWatchingNoted(IAppOpsNotedCallback callback) {
        callback.getClass();
        monitor-enter(this);
        SparseArray<NotedCallback> notedCallbacks = this.mNotedWatchers.remove(callback.asBinder());     // Catch: Throwable -> L8
        if (notedCallbacks != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        int callbackCount = notedCallbacks.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= callbackCount) goto L14;
        notedCallbacks.valueAt(i).destroy();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void collectAsyncNotedOp(int uid, String packageName, final int opCode, final String attributionTag, int flags, String message, boolean shouldCollectMessage, int notedCount) {
        message.getClass();
        int callingUid = Binder.getCallingUid();
        long token = Binder.clearCallingIdentity();
        monitor-enter(this);     // Catch: Throwable -> L37
        if ((flags & 9) == 0) goto L11;
        if (shouldCollectMessage == false) goto L11;
        AppOpsService r1 = this;
        r1.reportRuntimeAppOpAccessMessageAsyncLocked(uid, packageName, opCode, attributionTag, message);     // Catch: Throwable -> L9
    L12:
        int r2 = uid;
        String r3 = packageName;
        Pair<String, Integer> key = r1.getAsyncNotedOpsKey(r3, r2);     // Catch: Throwable -> L9
        RemoteCallbackList<IAppOpsAsyncNotedCallback> callbacks = r1.mAsyncOpWatchers.get(key);     // Catch: Throwable -> L9
        if (callbacks != null) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L17:
        final boolean[] wasNoteForwarded = {false};     // Catch: Throwable -> L9
        int i = 0;
    L19:
        if (i >= notedCount) goto L30;
        final AsyncNotedAppOp asyncNotedOp = new AsyncNotedAppOp(opCode, callingUid, attributionTag, message, System.currentTimeMillis());     // Catch: Throwable -> L9
        wasNoteForwarded[0] = false;     // Catch: Throwable -> L9
        final int r22 = r2;
        final String r21 = r3;
        callbacks.broadcast(new AppOpsService$$ExternalSyntheticLambda21(asyncNotedOp, wasNoteForwarded, opCode, r21, r22, attributionTag));     // Catch: Throwable -> L9
        if (wasNoteForwarded[0] == true) goto L28;
        ArrayList<AsyncNotedAppOp> unforwardedOps = r1.mUnforwardedAsyncNotedOps.get(key);     // Catch: Throwable -> L9
        if (unforwardedOps != null) goto L25;
        unforwardedOps = new ArrayList(1);     // Catch: Throwable -> L9
        r1.mUnforwardedAsyncNotedOps.put(key, unforwardedOps);     // Catch: Throwable -> L9
    L25:
        unforwardedOps.add(asyncNotedOp);     // Catch: Throwable -> L9
        if (unforwardedOps.size() <= 10) goto L28;
        unforwardedOps.remove(0);     // Catch: Throwable -> L9
    L28:
        i = i + 1;     // Catch: Throwable -> L9
        r2 = uid;
        r3 = packageName;
        goto L19
    L30:
        monitor-exit(this);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = th;
    L39:
        Binder.restoreCallingIdentity(token);
        throw th;
    L11:
        r1 = this;
    L37:
        th = th;
        goto L39
    }

    private static /* synthetic */ void lambda$collectAsyncNotedOp$7(AsyncNotedAppOp asyncNotedOp, boolean[] wasNoteForwarded, int opCode, String packageName, int uid, String attributionTag, IAppOpsAsyncNotedCallback cb) {
        cb.opNoted(asyncNotedOp);     // Catch: RemoteException -> L4
        wasNoteForwarded[0] = true;     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Could not forward noteOp of " + opCode + " to " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER + uid + "(" + attributionTag + ")", e);
    }

    private Pair<String, Integer> getAsyncNotedOpsKey(String packageName, int uid) {
        return new Pair(packageName, Integer.valueOf(uid));
    }

    public void startWatchingAsyncNoted(final String packageName, final IAppOpsAsyncNotedCallback callback) {
        packageName.getClass();
        callback.getClass();
        int uid = Binder.getCallingUid();
        Pair<String, Integer> key = getAsyncNotedOpsKey(packageName, uid);
        verifyAndGetBypass(uid, packageName, null);
        monitor-enter(this);
        RemoteCallbackList<IAppOpsAsyncNotedCallback> callbacks = this.mAsyncOpWatchers.get(key);     // Catch: Throwable -> L7
        if (callbacks != null) goto L9;
        callbacks = new RemoteCallbackList.Builder(3).setInterfaceDiedCallback(new AppOpsService$$ExternalSyntheticLambda1(this, packageName, callback)).build();     // Catch: Throwable -> L7
    L9:
        if (callbacks != null) goto L11;
        callbacks = new AnonymousClass9(this, packageName, callback);     // Catch: Throwable -> L7
    L11:
        this.mAsyncOpWatchers.put(key, callbacks);     // Catch: Throwable -> L7
        callbacks.register(callback);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$startWatchingAsyncNoted$8(String packageName, IAppOpsAsyncNotedCallback callback, RemoteCallbackList rcl, IAppOpsAsyncNotedCallback cb, Object cookie) {
        stopWatchingAsyncNoted(packageName, callback);
    }

    public void stopWatchingAsyncNoted(String packageName, IAppOpsAsyncNotedCallback callback) {
        packageName.getClass();
        callback.getClass();
        int uid = Binder.getCallingUid();
        Pair<String, Integer> key = getAsyncNotedOpsKey(packageName, uid);
        verifyAndGetBypass(uid, packageName, null);
        monitor-enter(this);
        RemoteCallbackList<IAppOpsAsyncNotedCallback> callbacks = this.mAsyncOpWatchers.get(key);     // Catch: Throwable -> L9
        if (callbacks == null) goto L11;
        callbacks.unregister(callback);     // Catch: Throwable -> L9
        if (callbacks.getRegisteredCallbackCount() != 0) goto L11;
        this.mAsyncOpWatchers.remove(key);     // Catch: Throwable -> L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public List<AsyncNotedAppOp> extractAsyncOps(String packageName) {
        packageName.getClass();
        int uid = Binder.getCallingUid();
        verifyAndGetBypass(uid, packageName, null);
        monitor-enter(this);
        ArrayList<AsyncNotedAppOp> r1 = this.mUnforwardedAsyncNotedOps.remove(getAsyncNotedOpsKey(packageName, uid));     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public SyncNotedAppOp startOperation(IBinder token, int code, int uid, String packageName, String attributionTag, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int attributionFlags, int attributionChainId) {
        return this.mCheckOpsDelegateDispatcher.startOperation(token, code, uid, packageName, attributionTag, 0, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, attributionFlags, attributionChainId);
    }

    public SyncNotedAppOp startOperationForDevice(IBinder token, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int attributionFlags, int attributionChainId) {
        return this.mCheckOpsDelegateDispatcher.startOperation(token, code, uid, packageName, attributionTag, virtualDeviceId, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, attributionFlags, attributionChainId);
    }

    private SyncNotedAppOp startOperationImpl(IBinder clientId, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int attributionFlags, int attributionChainId) {
        int r3 = code;
        int r4 = uid;
        String r5 = packageName;
        if (shouldUseNewCheckOp() == true) goto L17;
        verifyIncomingUid(r4);
        verifyIncomingOp(r3);
        if (isValidVirtualDeviceId(virtualDeviceId) == true) goto L9;
        Slog.w(TAG, "startOperationImpl returned MODE_IGNORED as virtualDeviceId " + virtualDeviceId + " is invalid");
        return new SyncNotedAppOp(1, r3, attributionTag, r5);
    L9:
        if (isIncomingPackageValid(r5, UserHandle.getUserId(r4)) == false) goto L11;
        String resolvedPackageName = AppOpsManager.resolvePackageName(uid, packageName);
        if (resolvedPackageName != null) goto L22;
        return new SyncNotedAppOp(1, r3, attributionTag, r5);
    L22:
        int result = 3;
        if (r3 != 102) goto L25;
    L28:
        result = checkOperation(27, r4, r5);
        if (result != 0) goto L31;
    L33:
        if (r3 != 134) goto L41;
        int result2 = checkOperation(26, r4, r5);
        if (result2 == 0) goto L41;
        return new SyncNotedAppOp(result2, r3, attributionTag, r5);
    L41:
        return startOperationUnchecked(clientId, r3, r4, r5, attributionTag, virtualDeviceId, -1, null, null, 0, 1, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, attributionFlags, attributionChainId);
    L31:
        return new SyncNotedAppOp(result, r3, attributionTag, r5);
    L25:
        if (r3 == 120) goto L28;
        if (r3 != 135) goto L33;
    L11:
        return new SyncNotedAppOp(2, r3, attributionTag, r5);
    L17:
        String resolvedPackageName2 = validateOpRequest(r3, r4, packageName, virtualDeviceId, true, "startOperation");
        r3 = r3;
        r5 = packageName;
        r4 = r4;
        if (resolvedPackageName2 != null) goto L22;
        return new SyncNotedAppOp(1, r3, attributionTag, r5);
    }

    public SyncNotedAppOp startProxyOperation(IBinder clientId, int code, AttributionSource attributionSource, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation, int proxyAttributionFlags, int proxiedAttributionFlags, int attributionChainId) {
        return this.mCheckOpsDelegateDispatcher.startProxyOperation(clientId, code, attributionSource, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, proxyAttributionFlags, proxiedAttributionFlags, attributionChainId);
    }

    public SyncNotedAppOp startProxyOperationWithState(IBinder clientId, int code, AttributionSourceState attributionSourceState, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation, int proxyAttributionFlags, int proxiedAttributionFlags, int attributionChainId) {
        AttributionSource attributionSource = new AttributionSource(attributionSourceState);
        return this.mCheckOpsDelegateDispatcher.startProxyOperation(clientId, code, attributionSource, startIfModeDefault, shouldCollectAsyncNotedOp, message, shouldCollectMessage, skipProxyOperation, proxyAttributionFlags, proxiedAttributionFlags, attributionChainId);
    }

    private SyncNotedAppOp startProxyOperationImpl(IBinder clientId, int code, AttributionSource attributionSource, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation, int proxyAttributionFlags, int proxiedAttributionFlags, int attributionChainId) {
        AppOpsService r1 = this;
        int proxyUid = attributionSource.getUid();
        String proxyPackageName = attributionSource.getPackageName();
        String proxyAttributionTag = attributionSource.getAttributionTag();
        int proxyVirtualDeviceId = attributionSource.getDeviceId();
        int proxiedUid = attributionSource.getNextUid();
        String proxiedPackageName = attributionSource.getNextPackageName();
        String proxiedAttributionTag = attributionSource.getNextAttributionTag();
        int proxiedVirtualDeviceId = attributionSource.getNextDeviceId();
        r1.verifyIncomingProxyUid(attributionSource);
        r1.verifyIncomingOp(code);
        if (r1.isValidVirtualDeviceId(proxyVirtualDeviceId) == true) goto L7;
        Slog.w(TAG, "startProxyOperationImpl returned MODE_IGNORED as proxyVirtualDeviceId " + proxyVirtualDeviceId + " is invalid");
        return new SyncNotedAppOp(1, code, proxiedAttributionTag, proxiedPackageName);
    L7:
        if (r1.isValidVirtualDeviceId(proxiedVirtualDeviceId) == true) goto L11;
        Slog.w(TAG, "startProxyOperationImpl returned MODE_IGNORED as proxiedVirtualDeviceId " + proxiedVirtualDeviceId + " is invalid");
        return new SyncNotedAppOp(1, code, proxiedAttributionTag, proxiedPackageName);
    L11:
        if (r1.isIncomingPackageValid(proxyPackageName, UserHandle.getUserId(proxyUid)) == true) goto L13;
        int r15 = 2;
    L74:
        return new SyncNotedAppOp(r15, code, proxiedAttributionTag, proxiedPackageName);
    L13:
        if (r1.isIncomingPackageValid(proxiedPackageName, UserHandle.getUserId(proxiedUid)) == true) goto L15;
        r15 = 2;
        goto L74
    L15:
        boolean isCallerTrusted = r1.isCallerAndAttributionTrusted(attributionSource);
        if (isCallerTrusted == false) goto L19;
        if (skipProxyOperation == false) goto L19;
        boolean r0 = true;
    L20:
        boolean skipProxyOperation2 = r0;
        String resolvedProxyPackageName = AppOpsManager.resolvePackageName(proxyUid, proxyPackageName);
        if (resolvedProxyPackageName != null) goto L25;
        return new SyncNotedAppOp(1, code, proxiedAttributionTag, proxiedPackageName);
    L25:
        if (isCallerTrusted == false) goto L34;
        if (attributionChainId == (-1)) goto L34;
        if ((proxyAttributionFlags & 8) == 0) goto L31;
    L32:
        boolean r17 = true;
    L35:
        boolean isChainTrusted = r17;
        if (Binder.getCallingUid() != proxiedUid) goto L38;
        boolean r7 = true;
    L39:
        boolean isSelfBlame = r7;
        if (r1.mContext.checkPermission("android.permission.UPDATE_APP_OPS_STATS", -1, proxyUid) == 0) goto L45;
        if (isSelfBlame == true) goto L45;
        if (isChainTrusted == true) goto L45;
        boolean r2 = false;
    L46:
        boolean isProxyTrusted = r2;
        String resolvedProxiedPackageName = AppOpsManager.resolvePackageName(proxiedUid, proxiedPackageName);
        if (resolvedProxiedPackageName != null) goto L51;
        return new SyncNotedAppOp(1, code, proxiedAttributionTag, proxiedPackageName);
    L51:
        if (isProxyTrusted == false) goto L53;
        int proxiedFlags = 8;
    L55:
        if (skipProxyOperation2 == true) goto L69;
        int proxiedFlags2 = proxiedFlags;
        SyncNotedAppOp testProxiedOp = r1.startOperationDryRun(code, proxiedUid, resolvedProxiedPackageName, proxiedAttributionTag, proxiedVirtualDeviceId, proxyUid, resolvedProxyPackageName, proxiedFlags2, startIfModeDefault);
        r1 = r1;
        String resolvedProxiedPackageName2 = resolvedProxiedPackageName;
        String proxiedAttributionTag2 = proxiedAttributionTag;
        proxyUid = proxyUid;
        String resolvedProxyPackageName2 = resolvedProxyPackageName;
        int proxiedFlags3 = proxiedFlags2;
        if (r1.shouldStartForMode(testProxiedOp.getOpMode(), startIfModeDefault) == true) goto L59;
        return testProxiedOp;
    L59:
        if (isProxyTrusted == false) goto L61;
        int proxyFlags = 2;
    L63:
        if (isProxyTrusted == true) goto L65;
        boolean r16 = true;
    L66:
        int proxiedUid2 = proxiedUid;
        String proxyPackageName2 = proxyAttributionTag;
        int proxyFlags2 = proxyFlags;
        int proxyFlags3 = proxyVirtualDeviceId;
        SyncNotedAppOp proxyAppOp = r1.startOperationUnchecked(clientId, code, proxyUid, resolvedProxyPackageName2, proxyPackageName2, proxyFlags3, -1, null, null, 0, proxyFlags2, startIfModeDefault, r16, "proxy " + message, shouldCollectMessage, proxyAttributionFlags, attributionChainId);
        boolean r9 = startIfModeDefault;
        if (r1.shouldStartForMode(proxyAppOp.getOpMode(), r9) == true) goto L70;
        return proxyAppOp;
    L70:
        boolean r13 = r9;
        String resolvedProxyPackageName3 = resolvedProxyPackageName2;
        return r1.startOperationUnchecked(clientId, code, proxiedUid2, resolvedProxiedPackageName2, proxiedAttributionTag2, proxiedVirtualDeviceId, proxyUid, resolvedProxyPackageName3, proxyPackageName2, proxyFlags3, proxiedFlags3, r13, shouldCollectAsyncNotedOp, message, shouldCollectMessage, proxiedAttributionFlags, attributionChainId);
    L65:
        r16 = false;
        goto L66
    L61:
        proxyFlags = 4;
        goto L63
    L69:
        resolvedProxiedPackageName2 = resolvedProxiedPackageName;
        proxiedUid2 = proxiedUid;
        proxiedAttributionTag2 = proxiedAttributionTag;
        proxiedFlags3 = proxiedFlags;
        resolvedProxyPackageName2 = resolvedProxyPackageName;
        proxyPackageName2 = proxyAttributionTag;
        proxyFlags3 = proxyVirtualDeviceId;
        r9 = startIfModeDefault;
        goto L70
    L53:
        proxiedFlags = 16;
    L45:
        r2 = true;
        goto L46
    L38:
        r7 = false;
        goto L39
    L31:
        if ((proxiedAttributionFlags & 8) != 0) goto L32;
    L34:
        r17 = false;
    L19:
        r0 = false;
        goto L20
    }

    private boolean shouldStartForMode(int mode, boolean startIfModeDefault) {
        if (mode != 0) goto L4;
    L8:
        return true;
    L4:
        if (mode != 3) goto L7;
        if (startIfModeDefault == true) goto L8;
    L7:
        return false;
    }

    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v6 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchDebugInfoByOffset(DebugInfoApplyVisitor.java:107)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:83)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v3 ??, new type: com.android.server.appop.AppOpsService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v3 ??, new type: com.android.server.appop.AppOpsService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v5 ??, new type: com.android.server.appop.AppOpsService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v8 ??, new type: com.android.server.appop.AppOpsService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r27v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r27v0 'this'  ??, new type: com.android.server.appop.AppOpsService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v13 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v6 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v6 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v8 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r27v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r27v0 'this'  ??, new type: com.android.server.appop.AppOpsService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v6 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    private android.app.SyncNotedAppOp startOperationUnchecked(android.os.IBinder r28, int r29, int r30, java.lang.String r31, java.lang.String r32, int r33, int r34, java.lang.String r35, java.lang.String r36, int r37, int r38, boolean r39, boolean r40, java.lang.String r41, boolean r42, int r43, int r44) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0279: MOVE (r13v5 ?? I:??[OBJECT, ARRAY]) = (r27v0 'this' ?? I:??[OBJECT, ARRAY] A[D('attributedOp' com.android.server.appop.AttributedOp), IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] (LINE:4286) in method: com.android.server.appop.AppOpsService.startOperationUnchecked(android.os.IBinder, int, int, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, int, int, boolean, boolean, java.lang.String, boolean, int, int):android.app.SyncNotedAppOp, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.appop.AppOpsService.startOperationUnchecked(android.os.IBinder, int, int, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, int, int, boolean, boolean, java.lang.String, boolean, int, int):android.app.SyncNotedAppOp");
    }

    private SyncNotedAppOp startOperationDryRun(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, int proxyUid, String proxyPackageName, int flags, boolean startIfModeDefault) {
        if ((flags & 16) != 0) goto L5;
        boolean proxyTrusted = true;
    L80:
        PackageVerificationResult pvr = verifyAndGetBypass(uid, packageName, attributionTag, proxyUid, proxyPackageName, proxyTrusted);     // Catch: SecurityException -> L66
        if (pvr.isAttributionTagValid == true) goto L12;
        String attributionTag2 = null;
    L14:
        if (isOpRestrictedDueToSuspend(code, packageName, uid) == false) goto L18;
        return new SyncNotedAppOp(1, code, attributionTag2, packageName);
    L18:
        monitor-enter(this);
        Ops ops = getOpsLocked(uid, packageName, null, pvr.isAttributionTagValid, pvr.bypass, true);     // Catch: Throwable -> L60
        if (ops == null) goto L83;
        Op op = getOpLocked(ops, code, uid, true);     // Catch: Throwable -> L60
        UidState uidState = ops.uidState;     // Catch: Throwable -> L60
        String attributionTag3 = attributionTag2;
        boolean isRestricted = isOpRestrictedLocked(uid, code, packageName, attributionTag3, virtualDeviceId, pvr.bypass, false);     // Catch: Throwable -> L58
        int switchCode = AppOpsManager.opToSwitch(code);     // Catch: Throwable -> L37
        if (this.mAppOpsCheckingService.getUidMode(uidState.uid, getPersistentDeviceIdForOp(virtualDeviceId, switchCode), switchCode) == AppOpsManager.opToDefaultMode(switchCode)) goto L40;
        int uidMode = uidState.evalMode(code, this.mAppOpsCheckingService.getUidMode(uidState.uid, getPersistentDeviceIdForOp(virtualDeviceId, switchCode), switchCode));     // Catch: Throwable -> L37
        if (shouldStartForMode(uidMode, startIfModeDefault) == true) goto L51;
        SyncNotedAppOp r10 = new SyncNotedAppOp(uidMode, code, attributionTag3, packageName);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return r10;
    L51:
        monitor-exit(this);     // Catch: Throwable -> L37
        if (isRestricted == false) goto L55;
        int r11 = 1;
    L57:
        return new SyncNotedAppOp(r11, code, attributionTag3, packageName);
    L55:
        r11 = 0;
        goto L57
    L40:
        if (switchCode == code) goto L42;
        Op switchOp = getOpLocked(ops, switchCode, uid, true);     // Catch: Throwable -> L37
    L43:
        int mode = switchOp.uidState.evalMode(switchOp.op, this.mAppOpsCheckingService.getPackageMode(switchOp.packageName, switchOp.op, UserHandle.getUserId(switchOp.uid)));     // Catch: Throwable -> L37
        if (mode == 0) goto L51;
        if (startIfModeDefault == true) goto L47;
    L48:
        SyncNotedAppOp r2 = new SyncNotedAppOp(mode, code, attributionTag3, packageName);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return r2;
    L47:
        if (mode == 3) goto L51;
    L42:
        switchOp = op;
    L58:
        th = th;
    L62:
        monitor-exit(this);     // Catch: Throwable -> L37
        throw th;
    L83:
        SyncNotedAppOp r4 = new SyncNotedAppOp(2, code, attributionTag2, packageName);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return r4;
    L24:
        th = th;
    L60:
        th = th;
    L37:
        th = th;
        goto L62
    L12:
        attributionTag2 = attributionTag;
    L64:
        e = e;
    L69:
        if (Process.isIsolated(uid) == false) goto L71;
        Slog.e(TAG, "Cannot startOperation: isolated process");
    L73:
        return new SyncNotedAppOp(2, code, attributionTag, packageName);
    L71:
        Slog.e(TAG, "Cannot startOperation", e);
    L66:
        e = e;
        goto L69
    L5:
        proxyTrusted = false;
        goto L80
    }

    public void finishOperation(IBinder clientId, int code, int uid, String packageName, String attributionTag) {
        this.mCheckOpsDelegateDispatcher.finishOperation(clientId, code, uid, packageName, attributionTag, 0);
    }

    public void finishOperationForDevice(IBinder clientId, int code, int uid, String packageName, String attributionTag, int virtualDeviceId) {
        this.mCheckOpsDelegateDispatcher.finishOperation(clientId, code, uid, packageName, attributionTag, virtualDeviceId);
    }

    private void finishOperationImpl(IBinder clientId, int code, int uid, String packageName, String attributionTag, int virtualDeviceId) {
        verifyIncomingUid(uid);
        verifyIncomingOp(code);
        if (isValidVirtualDeviceId(virtualDeviceId) == true) goto L7;
        Slog.w(TAG, "finishOperationImpl was a no-op as virtualDeviceId " + virtualDeviceId + " is invalid");
        return;
    L7:
        if (isIncomingPackageValid(packageName, UserHandle.getUserId(uid)) == true) goto L9;
        return;
    L9:
        String resolvedPackageName = AppOpsManager.resolvePackageName(uid, packageName);
        if (resolvedPackageName != null) goto L12;
        return;
    L12:
        finishOperationUnchecked(clientId, code, uid, resolvedPackageName, attributionTag, virtualDeviceId);
    }

    public void finishProxyOperation(IBinder clientId, int code, AttributionSource attributionSource, boolean skipProxyOperation) {
        this.mCheckOpsDelegateDispatcher.finishProxyOperation(clientId, code, attributionSource, skipProxyOperation);
    }

    public void finishProxyOperationWithState(IBinder clientId, int code, AttributionSourceState attributionSourceState, boolean skipProxyOperation) {
        AttributionSource attributionSource = new AttributionSource(attributionSourceState);
        this.mCheckOpsDelegateDispatcher.finishProxyOperation(clientId, code, attributionSource, skipProxyOperation);
    }

    private Void finishProxyOperationImpl(IBinder clientId, int code, AttributionSource attributionSource, boolean skipProxyOperation) {
        int proxyUid = attributionSource.getUid();
        String proxyPackageName = attributionSource.getPackageName();
        String proxyAttributionTag = attributionSource.getAttributionTag();
        int proxiedUid = attributionSource.getNextUid();
        int proxyVirtualDeviceId = attributionSource.getDeviceId();
        String proxiedPackageName = attributionSource.getNextPackageName();
        String proxiedAttributionTag = attributionSource.getNextAttributionTag();
        if (skipProxyOperation == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean skipProxyOperation2 = r1;
        verifyIncomingProxyUid(attributionSource);
        verifyIncomingOp(code);
        if (isValidVirtualDeviceId(proxyVirtualDeviceId) == true) goto L13;
        Slog.w(TAG, "finishProxyOperationImpl was a no-op as virtualDeviceId " + proxyVirtualDeviceId + " is invalid");
        return null;
    L13:
        if (isIncomingPackageValid(proxyPackageName, UserHandle.getUserId(proxyUid)) == false) goto L29;
        if (isIncomingPackageValid(proxiedPackageName, UserHandle.getUserId(proxiedUid)) == false) goto L29;
        String resolvedProxyPackageName = AppOpsManager.resolvePackageName(proxyUid, proxyPackageName);
        if (resolvedProxyPackageName != null) goto L20;
        return null;
    L20:
        if (skipProxyOperation2 == true) goto L23;
        finishOperationUnchecked(clientId, code, proxyUid, resolvedProxyPackageName, proxyAttributionTag, proxyVirtualDeviceId);
    L23:
        String resolvedProxiedPackageName = AppOpsManager.resolvePackageName(proxiedUid, proxiedPackageName);
        if (resolvedProxiedPackageName != null) goto L26;
        return null;
    L26:
        finishOperationUnchecked(clientId, code, proxyUid, resolvedProxyPackageName, proxiedUid, resolvedProxiedPackageName, proxiedAttributionTag, proxyVirtualDeviceId);
        return null;
    L29:
        return null;
    L5:
        if (isCallerAndAttributionTrusted(attributionSource) == false) goto L7;
        r1 = true;
        goto L8
    }

    private void finishOperationUnchecked(IBinder clientId, int code, int uid, String packageName, String attributionTag, int virtualDeviceId) {
        finishOperationUnchecked(clientId, code, -1, null, uid, packageName, attributionTag, virtualDeviceId);
    }

    private void finishOperationUnchecked(IBinder clientId, int code, int proxyUid, String proxyPackageName, int proxiedUid, String proxiedPackageName, String attributionTag, int virtualDeviceId) {
        PackageVerificationResult pvr = verifyAndGetBypass(proxiedUid, proxiedPackageName, attributionTag, proxyUid, proxyPackageName, true);     // Catch: SecurityException -> L52
        if (pvr.isAttributionTagValid == true) goto L8;
        String attributionTag2 = null;
    L10:
        monitor-enter(this);
    L15:
        th = th;
    L48:
        monitor-exit(this);     // Catch: Throwable -> L30
        throw th;
    L12:
        if (this.mSmtEx.mEnabled == true) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L18:
        if (proxyUid == (-1)) goto L21;
        boolean r0 = true;
    L20:
        boolean hasProxy = r0;
        String attributionTag3 = attributionTag2;
        Op op = getOpLocked(code, proxiedUid, proxiedPackageName, attributionTag3, pvr.isAttributionTagValid, pvr.bypass, false);     // Catch: Throwable -> L46
        if (op != null) goto L32;
        Slog.e(TAG, "Operation not found: uid=" + proxiedUid + " pkg=" + proxiedPackageName + "(" + attributionTag3 + ") op=" + AppOpsManager.opToName(code));     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L32:
        AttributedOp attributedOp = getAttributedOpWithClientId(op, clientId, attributionTag3, virtualDeviceId, hasProxy);     // Catch: Throwable -> L30
        if (attributedOp != null) goto L38;
        Slog.e(TAG, "Attribution not found: uid=" + proxiedUid + " pkg=" + proxiedPackageName + "(" + attributionTag3 + ") op=" + AppOpsManager.opToName(code));     // Catch: Throwable -> L30
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L38:
        if (attributedOp.isRunning() == true) goto L43;
        if (attributedOp.isPaused() == true) goto L43;
        Slog.e(TAG, "Operation not started: uid=" + proxiedUid + " pkg=" + proxiedPackageName + "(" + attributionTag3 + ") op=" + AppOpsManager.opToName(code));     // Catch: Throwable -> L30
    L44:
        monitor-exit(this);     // Catch: Throwable -> L30
        return;
    L43:
        attributedOp.finished(clientId);     // Catch: Throwable -> L30
    L46:
        th = th;
        goto L48
    L21:
        r0 = false;
    L30:
        th = th;
        goto L48
    L8:
        attributionTag2 = attributionTag;
    L50:
        e = e;
        int r7 = proxiedUid;
    L54:
        logVerifyAndGetBypassFailure(r7, e, "finishOperation");
        return;
    L52:
        e = e;
        r7 = proxiedUid;
        goto L54
    }

    private AttributedOp getAttributedOpWithClientId(Op op, final IBinder clientId, String attributionTag, int virtualDeviceId, boolean hasProxy) {
        AttributedOp attributedOp = op.mDeviceAttributedOps.getOrDefault(getPersistentDeviceIdForOp(virtualDeviceId, op.op), new ArrayMap()).get(attributionTag);
        if (hasProxy == true) goto L5;
        return attributedOp;
    L5:
        boolean hasUntrustedNullEvent = false;
        if (attributedOp != null) goto L8;
    L10:
        boolean hasTrustedInProgressEvent = false;
    L12:
        if (hasTrustedInProgressEvent == false) goto L14;
        return attributedOp;
    L14:
        boolean tagValid = false;
        tagValid = verifyAndGetBypass(op.uid, op.packageName, attributionTag).isAttributionTagValid;     // Catch: SecurityException -> L17
    L18:
        if (tagValid == false) goto L27;
        if (attributedOp != null) goto L21;
    L23:
        boolean hasUntrustedInProgressEvent = false;
    L25:
        if (hasUntrustedInProgressEvent == false) goto L27;
        return attributedOp;
    L21:
        if (attributedOp.hasInProgressEvent(new AppOpsService$$ExternalSyntheticLambda6(clientId)) == false) goto L23;
        hasUntrustedInProgressEvent = true;
    L27:
        AttributedOp attributedOp2 = op.mDeviceAttributedOps.getOrDefault(getPersistentDeviceIdForOp(virtualDeviceId, op.op), new ArrayMap()).get(null);
        if (attributedOp2 != null) goto L30;
    L34:
        if (hasUntrustedNullEvent == false) goto L36;
        return attributedOp2;
    L36:
        return null;
    L30:
        if (attributedOp2.hasInProgressEvent(new AppOpsService$$ExternalSyntheticLambda7(clientId)) == false) goto L34;
        hasUntrustedNullEvent = true;
        goto L34
    L8:
        if (attributedOp.hasInProgressEvent(new AppOpsService$$ExternalSyntheticLambda5(clientId)) == false) goto L10;
        hasTrustedInProgressEvent = true;
        goto L12
    }

    private static /* synthetic */ boolean lambda$getAttributedOpWithClientId$9(IBinder clientId, AttributedOp.InProgressStartOpEvent event) {
        if (event.getClientId() == clientId) goto L5;
    L7:
        return false;
    L5:
        if ((event.getFlags() & 16) != 0) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getAttributedOpWithClientId$10(IBinder clientId, AttributedOp.InProgressStartOpEvent event) {
        if (event.getClientId() == clientId) goto L5;
    L7:
        return false;
    L5:
        if ((event.getFlags() & 16) == 0) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getAttributedOpWithClientId$11(IBinder clientId, AttributedOp.InProgressStartOpEvent event) {
        if (event.getClientId() == clientId) goto L5;
    L7:
        return false;
    L5:
        if ((event.getFlags() & 16) == 0) goto L7;
        return true;
    }

    void scheduleOpActiveChangedIfNeededLocked(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean active, int attributionFlags, int attributionChainId) {
        int callbackListCount = this.mActiveWatchers.size();
        ArraySet<ActiveCallback> dispatchedCallbacks = null;
        int i = 0;
    L3:
        if (i >= callbackListCount) goto L18;
        SparseArray<ActiveCallback> callbacks = this.mActiveWatchers.valueAt(i);
        ActiveCallback callback = callbacks.get(code);
        if (callback == null) goto L16;
        if (callback.mWatchingUid < 0) goto L12;
        if (callback.mWatchingUid != uid) goto L16;
    L12:
        if (dispatchedCallbacks != null) goto L14;
        dispatchedCallbacks = new ArraySet();
    L14:
        dispatchedCallbacks.add(callback);
    L16:
        i = i + 1;
        goto L3
    L18:
        if (dispatchedCallbacks != null) goto L20;
        return;
    L20:
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda14(), this, dispatchedCallbacks, Integer.valueOf(code), Integer.valueOf(uid), packageName, attributionTag, Integer.valueOf(virtualDeviceId), Boolean.valueOf(active), Integer.valueOf(attributionFlags), Integer.valueOf(attributionChainId)));
    }

    private void notifyOpActiveChanged(ArraySet<ActiveCallback> callbacks, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean active, int attributionFlags, int attributionChainId) {
        long identity = Binder.clearCallingIdentity();
        int callbackCount = callbacks.size();     // Catch: Throwable -> L27
        int i = 0;
    L5:
        if (i >= callbackCount) goto L25;
        ActiveCallback callback = callbacks.valueAt(i);     // Catch: Throwable -> L20
        goto L24
    L36:
    L16:
        th = th;
    L29:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L12:
        if (shouldIgnoreCallback(code, callback.mCallingPid, callback.mCallingUid) == true) goto L24;
        callback.mCallback.opActiveChanged(code, uid, packageName, attributionTag, virtualDeviceId, active, attributionFlags, attributionChainId);     // Catch: Throwable -> L16 RemoteException -> L18
    L24:
        i = i + 1;
    L20:
        th = th;
        goto L29
    L25:
        Binder.restoreCallingIdentity(identity);
        return;
    L27:
        th = th;
        goto L29
    }

    void scheduleOpStartedIfNeededLocked(int code, int uid, String pkgName, String attributionTag, int virtualDeviceId, int flags, int result, int startedType, int attributionFlags, int attributionChainId) {
        int callbackListCount = this.mStartedWatchers.size();
        ArraySet<StartedCallback> dispatchedCallbacks = null;
        int i = 0;
    L3:
        if (i >= callbackListCount) goto L18;
        SparseArray<StartedCallback> callbacks = this.mStartedWatchers.valueAt(i);
        StartedCallback callback = callbacks.get(code);
        if (callback == null) goto L16;
        if (callback.mWatchingUid < 0) goto L12;
        if (callback.mWatchingUid != uid) goto L16;
    L12:
        if (dispatchedCallbacks != null) goto L14;
        dispatchedCallbacks = new ArraySet();
    L14:
        dispatchedCallbacks.add(callback);
    L16:
        i = i + 1;
        goto L3
    L18:
        if (dispatchedCallbacks != null) goto L20;
        return;
    L20:
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda16(), this, dispatchedCallbacks, Integer.valueOf(code), Integer.valueOf(uid), pkgName, attributionTag, Integer.valueOf(virtualDeviceId), Integer.valueOf(flags), Integer.valueOf(result), Integer.valueOf(startedType), Integer.valueOf(attributionFlags), Integer.valueOf(attributionChainId)));
    }

    private void notifyOpStarted(ArraySet<StartedCallback> callbacks, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, int flags, int result, int startedType, int attributionFlags, int attributionChainId) {
        long identity = Binder.clearCallingIdentity();
        int callbackCount = callbacks.size();     // Catch: Throwable -> L27
        int i = 0;
    L5:
        if (i >= callbackCount) goto L25;
        StartedCallback callback = callbacks.valueAt(i);     // Catch: Throwable -> L20
        goto L24
    L36:
    L16:
        th = th;
    L29:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L12:
        if (shouldIgnoreCallback(code, callback.mCallingPid, callback.mCallingUid) == true) goto L24;
        callback.mCallback.opStarted(code, uid, packageName, attributionTag, virtualDeviceId, flags, result, startedType, attributionFlags, attributionChainId);     // Catch: Throwable -> L16 RemoteException -> L18
    L24:
        i = i + 1;
    L20:
        th = th;
        goto L29
    L25:
        Binder.restoreCallingIdentity(identity);
        return;
    L27:
        th = th;
        goto L29
    }

    private void scheduleOpNotedIfNeededLocked(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, int flags, int result) {
        int callbackListCount = this.mNotedWatchers.size();
        int i = 0;
        ArraySet<NotedCallback> dispatchedCallbacks = null;
    L3:
        if (i >= callbackListCount) goto L18;
        SparseArray<NotedCallback> callbacks = this.mNotedWatchers.valueAt(i);
        NotedCallback callback = callbacks.get(code);
        if (callback == null) goto L16;
        if (callback.mWatchingUid < 0) goto L12;
        if (callback.mWatchingUid != uid) goto L16;
    L12:
        if (dispatchedCallbacks != null) goto L14;
        dispatchedCallbacks = new ArraySet();
    L14:
        dispatchedCallbacks.add(callback);
    L16:
        i = i + 1;
        goto L3
    L18:
        if (dispatchedCallbacks != null) goto L20;
        return;
    L20:
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda9(), this, dispatchedCallbacks, Integer.valueOf(code), Integer.valueOf(uid), packageName, attributionTag, Integer.valueOf(virtualDeviceId), Integer.valueOf(flags), Integer.valueOf(result)));
    }

    private void notifyOpChecked(ArraySet<NotedCallback> callbacks, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, int flags, int result) {
        long identity = Binder.clearCallingIdentity();
        int callbackCount = callbacks.size();     // Catch: Throwable -> L27
        int i = 0;
    L5:
        if (i >= callbackCount) goto L25;
        NotedCallback callback = callbacks.valueAt(i);     // Catch: Throwable -> L20
        goto L24
    L36:
    L16:
        th = th;
    L29:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L12:
        if (shouldIgnoreCallback(code, callback.mCallingPid, callback.mCallingUid) == true) goto L24;
        callback.mCallback.opNoted(code, uid, packageName, attributionTag, virtualDeviceId, flags, result);     // Catch: Throwable -> L16 RemoteException -> L18
    L24:
        i = i + 1;
    L20:
        th = th;
        goto L29
    L25:
        Binder.restoreCallingIdentity(identity);
        return;
    L27:
        th = th;
        goto L29
    }

    public int permissionToOpCode(String permission) {
        if (permission != null) goto L6;
        return -1;
    L6:
        return AppOpsManager.permissionToOpCode(permission);
    }

    public boolean shouldCollectNotes(int opCode) {
        Preconditions.checkArgumentInRange(opCode, 0, 165, "opCode");
        if (AppOpsManager.shouldForceCollectNoteForOp(opCode) == false) goto L5;
        return true;
    L5:
        String perm = AppOpsManager.opToPermission(opCode);
        if (perm != null) goto L17;
        return false;
    L17:
        PermissionInfo permInfo = this.mContext.getPackageManager().getPermissionInfo(perm, 0);     // Catch: PackageManager.NameNotFoundException -> L15
        if (permInfo.getProtection() == 1) goto L14;
        if ((permInfo.getProtectionFlags() & 64) != 0) goto L14;
        return false;
    L14:
        return true;
    L16:
        return false;
    }

    private boolean shouldUseNewCheckOp() {
        long identity = Binder.clearCallingIdentity();
        Binder.restoreCallingIdentity(identity);
        return true;
    }

    private String validateOpRequest(int code, int uid, String packageName, int vdi, boolean shouldVerifyUid, String methodName) {
        verifyIncomingOp(code);
        if (shouldVerifyUid == false) goto L6;
        verifyIncomingUid(uid);
    L6:
        if (isValidVirtualDeviceId(vdi) == true) goto L10;
        Slog.w(TAG, methodName + ": error due to virtualDeviceId " + vdi + " is invalid");
        return null;
    L10:
        if (isIncomingPackageValid(packageName, UserHandle.getUserId(uid)) == true) goto L13;
        Slog.w(TAG, methodName + ": error due to package: " + packageName + " is invalid for " + uid);
        return null;
    L13:
        String resolvedPackageName = AppOpsManager.resolvePackageName(uid, packageName);
        if (resolvedPackageName != null) goto L17;
        Slog.w(TAG, methodName + ": error due to unable to resolve uid: " + uid);
        return null;
    L17:
        return resolvedPackageName;
    }

    private void verifyIncomingProxyUid(AttributionSource attributionSource) {
        if (attributionSource.getUid() != Binder.getCallingUid()) goto L6;
        return;
    L6:
        if (Binder.getCallingPid() != Process.myPid()) goto L9;
        return;
    L9:
        if (attributionSource.isTrusted(this.mContext) == false) goto L11;
        return;
    L11:
        this.mContext.enforcePermission("android.permission.UPDATE_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
    }

    private void verifyIncomingUid(int uid) {
        if (uid != Binder.getCallingUid()) goto L6;
        return;
    L6:
        if (Binder.getCallingPid() != Process.myPid()) goto L8;
        return;
    L8:
        this.mContext.enforcePermission("android.permission.UPDATE_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
    }

    private boolean shouldIgnoreCallback(int op, int watcherPid, int watcherUid) {
        if (AppOpsManager.opRestrictsRead(op) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mContext.checkPermission("android.permission.MANAGE_APPOPS", watcherPid, watcherUid) == 0) goto L7;
        return true;
    }

    private boolean isValidVirtualDeviceId(int virtualDeviceId) {
        if (virtualDeviceId != 0) goto L6;
        return true;
    L6:
        if (this.mVirtualDeviceManagerInternal != null) goto L10;
        Slog.w(TAG, "VirtualDeviceManagerInternal is null when device Id is non-default");
        return false;
    L10:
        if (this.mVirtualDeviceManagerInternal.isValidVirtualDeviceId(virtualDeviceId) == false) goto L13;
        this.mKnownDeviceIds.put(virtualDeviceId, this.mVirtualDeviceManagerInternal.getPersistentIdForDevice(virtualDeviceId));
        return true;
    L13:
        return false;
    }

    private void verifyIncomingOp(int op) {
        if (op < 0) goto L18;
        if (op >= 166) goto L18;
        if (AppOpsManager.opRestrictsRead(op) == true) goto L8;
        return;
    L8:
        if (this.mContext.checkPermission("android.permission.MANAGE_APPOPS", Binder.getCallingPid(), Binder.getCallingUid()) != 0) goto L10;
        return;
    L10:
        if (this.mContext.checkPermission("android.permission.GET_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid()) != 0) goto L12;
        return;
    L12:
        if (this.mContext.checkPermission("android.permission.MANAGE_APP_OPS_MODES", Binder.getCallingPid(), Binder.getCallingUid()) != 0) goto L15;
        return;
    L15:
        throw new SecurityException("verifyIncomingOp: uid " + Binder.getCallingUid() + " does not have any of {MANAGE_APPOPS, GET_APP_OPS_STATS, MANAGE_APP_OPS_MODES}");
    L18:
        throw new IllegalArgumentException("Bad operation #" + op);
    }

    private boolean isIncomingPackageValid(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        if (packageName != null) goto L5;
    L15:
        return true;
    L5:
        if (isSpecialPackage(callingUid, packageName) == true) goto L15;
        if (isPackageExisted(packageName) == true) goto L11;
        return false;
    L11:
        if (getPackageManagerInternal().filterAppAccess(packageName, callingUid, userId) == false) goto L14;
        Slog.w(TAG, packageName + " not found from " + callingUid);
        return false;
    L14:
        return true;
    }

    private boolean isSpecialPackage(int callingUid, String packageName) {
        String resolvedPackage = AppOpsManager.resolvePackageName(callingUid, packageName);
        if (callingUid != 1000) goto L5;
    L8:
        return true;
    L5:
        if (resolveNonAppUid(resolvedPackage) != (-1)) goto L8;
        return false;
    }

    private boolean isCallerAndAttributionTrusted(AttributionSource attributionSource) {
        if (attributionSource.getUid() == Binder.getCallingUid()) goto L12;
        if (attributionSource.isTrusted(this.mContext) == false) goto L12;
        if (attributionSource.getNext() != null) goto L9;
    L10:
        return true;
    L9:
        if (attributionSource.getNext().isTrusted(this.mContext) == true) goto L10;
    L12:
        if (this.mContext.checkPermission("android.permission.UPDATE_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null) == 0) goto L16;
        return false;
    L16:
        return true;
    }

    private UidState getUidStateLocked(int uid, boolean edit) {
        UidState uidState = this.mUidStates.get(uid);
        if (uidState != null) goto L9;
        if (edit == true) goto L7;
        return null;
    L7:
        UidState uidState2 = new UidState(this, uid);
        this.mUidStates.put(uid, uidState2);
        return uidState2;
    L9:
        return uidState;
    }

    private void createSandboxUidStateIfNotExistsForAppLocked(int uid, SparseBooleanArray knownUids) {
        if (UserHandle.getAppId(uid) >= 10000) goto L5;
        return;
    L5:
        int sandboxUid = Process.toSdkSandboxUid(uid);
        if (knownUids == null) goto L8;
        knownUids.put(sandboxUid, true);
    L8:
        getUidStateLocked(sandboxUid, true);
    }

    private void updateAppWidgetVisibility(SparseArray<String> uidPackageNames, boolean visible) {
        monitor-enter(this);
        getUidStateTracker().updateAppWidgetVisibility(uidPackageNames, visible);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private PackageManagerInternal getPackageManagerInternal() {
        if (this.mPackageManagerInternal != null) goto L6;
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
    L6:
        if (this.mPackageManagerInternal == null) goto L10;
        return this.mPackageManagerInternal;
    L10:
        throw new IllegalStateException("PackageManagerInternal not loaded");
    }

    private PackageManagerLocal getPackageManagerLocal() {
        if (this.mPackageManagerLocal != null) goto L6;
        this.mPackageManagerLocal = (PackageManagerLocal) LocalManagerRegistry.getManager(PackageManagerLocal.class);
    L6:
        if (this.mPackageManagerLocal == null) goto L10;
        return this.mPackageManagerLocal;
    L10:
        throw new IllegalStateException("PackageManagerLocal not loaded");
    }

    private UserManagerInternal getUserManagerInternal() {
        if (this.mUserManagerInternal != null) goto L6;
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    L6:
        if (this.mUserManagerInternal == null) goto L10;
        return this.mUserManagerInternal;
    L10:
        throw new IllegalStateException("UserManagerInternal not loaded");
    }

    private AppOpsManager.RestrictionBypass getBypassforPackage(PackageState packageState) {
        boolean r3 = false;
        if (packageState.getAppId() != 1000) goto L5;
        boolean r1 = true;
    L6:
        boolean r2 = packageState.isPrivileged();
        if (this.mContext.checkPermission("android.permission.EXEMPT_FROM_AUDIO_RECORD_RESTRICTIONS", -1, packageState.getAppId()) != 0) goto L10;
        r3 = true;
    L10:
        return new AppOpsManager.RestrictionBypass(r1, r2, r3);
    L5:
        r1 = false;
        goto L6
    }

    private PackageVerificationResult verifyAndGetBypass(int uid, String packageName, String attributionTag) {
        return verifyAndGetBypass(uid, packageName, attributionTag, -1, null, true);
    }

    private PackageVerificationResult verifyAndGetBypass(int uid, String packageName, String attributionTag, int proxyUid, String proxyPackageName, boolean isProxyTrusted) {
        return verifyAndGetBypass(uid, packageName, attributionTag, proxyUid, proxyPackageName, isProxyTrusted, false);
    }

    private PackageVerificationResult verifyAndGetBypass(int uid, String packageName, String attributionTag, int proxyUid, String proxyPackageName, boolean isProxyTrusted, boolean suppressErrorLogs) {
        AndroidPackage proxyPkg = null;
        if (uid != 0) goto L13;
        if (isProxyTrusted == true) goto L7;
    L9:
        boolean r6 = false;
    L11:
        return new PackageVerificationResult(null, r6);
    L7:
        if (isPackageNullOrSystem(proxyPackageName, proxyUid) == false) goto L9;
        r6 = true;
        goto L11
    L13:
        if (Process.isSdkSandboxUid(uid) == true) goto L108;
    L23:
        int uid2 = uid;
    L24:
        monitor-enter(this);
        UidState uidState = this.mUidStates.get(uid2);     // Catch: Throwable -> L35
        if (uidState != null) goto L28;
    L42:
        monitor-exit(this);     // Catch: Throwable -> L35
        int callingUid = Binder.getCallingUid();
        if (Objects.equals(packageName, "com.android.shell") == false) goto L46;
        int nonAppUid = 2000;
    L48:
        if (nonAppUid != (-1)) goto L50;
        int userId = UserHandle.getUserId(uid2);
        AppOpsManager.RestrictionBypass bypass = null;
        boolean isAttributionTagValid = false;
        int pkgUid = nonAppUid;
        long ident = Binder.clearCallingIdentity();
        PackageManagerInternal pmInt = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L71
        PackageStateInternal pkgState = pmInt.getPackageStateInternal(packageName);     // Catch: Throwable -> L71
        if (pkgState != null) goto L67;
        AndroidPackage r18 = null;
    L68:
        AndroidPackage pkg = r18;
        if (pkg == null) goto L73;
        AndroidPackage pkg2 = pkg;
        isAttributionTagValid = isAttributionInPackage(pkg2, attributionTag);     // Catch: Throwable -> L71
        pkgUid = UserHandle.getUid(userId, pkgState.getAppId());     // Catch: Throwable -> L71
        bypass = getBypassforPackage(pkgState);     // Catch: Throwable -> L71
    L74:
        if (isAttributionTagValid == true) goto L94;
        if (proxyPackageName == null) goto L78;
        proxyPkg = pmInt.getPackage(proxyPackageName);     // Catch: Throwable -> L71
    L78:
        if (isProxyTrusted == true) goto L80;
    L82:
        boolean r19 = false;
    L83:
        isAttributionTagValid = r19;
        if (pkg2 == null) goto L88;
        if (isAttributionTagValid == false) goto L88;
        String msg = "attributionTag " + attributionTag + " declared in manifest of the proxy package " + proxyPackageName + ", this is not advised";     // Catch: Throwable -> L71
    L91:
        Slog.e(TAG, msg);     // Catch: Throwable -> L71
    L88:
        if (pkg2 == null) goto L90;
        msg = "attributionTag " + attributionTag + " not declared in manifest of " + packageName;     // Catch: Throwable -> L71
        goto L91
    L90:
        msg = "package " + packageName + " not found, can't check for attributionTag " + attributionTag;     // Catch: Throwable -> L71
        goto L91
    L80:
        if (isAttributionInPackage(proxyPkg, attributionTag) == false) goto L82;
        r19 = true;
    L94:
        Binder.restoreCallingIdentity(ident);
        if (pkgUid == uid2) goto L101;
        if (suppressErrorLogs == true) goto L99;
        Slog.e(TAG, "Bad call made by uid " + callingUid + ". Package \"" + packageName + "\" does not belong to uid " + uid2 + ".");
    L99:
        throw new SecurityException("Specified package \"" + packageName + "\" under uid " + uid2 + " but it is not");
    L101:
        return new PackageVerificationResult(bypass, isAttributionTagValid);
    L73:
        pkg2 = pkg;
        goto L74
    L67:
        r18 = pkgState.getAndroidPackage();     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L50:
        if (nonAppUid == UserHandle.getAppId(uid2)) goto L55;
        if (suppressErrorLogs == true) goto L54;
        Slog.e(TAG, "Bad call made by uid " + callingUid + ". Package \"" + packageName + "\" does not belong to uid " + uid2 + ".");
    L54:
        throw new SecurityException("Specified package \"" + packageName + "\" under uid " + UserHandle.getAppId(uid2) + " but it is not");
    L55:
        AppOpsManager.RestrictionBypass r8 = AppOpsManager.RestrictionBypass.UNRESTRICTED;
        if (isProxyTrusted == true) goto L58;
    L60:
        boolean r7 = false;
    L62:
        return new PackageVerificationResult(r8, r7);
    L58:
        if (isPackageNullOrSystem(proxyPackageName, proxyUid) == false) goto L60;
        r7 = true;
        goto L62
    L46:
        int nonAppUid2 = resolveNonAppUid(packageName);
        nonAppUid = nonAppUid2;
        goto L48
    L28:
        if (uidState.pkgOps.isEmpty() == true) goto L42;
        Ops ops = uidState.pkgOps.get(packageName);     // Catch: Throwable -> L35
        if (ops == null) goto L42;
        if (attributionTag == null) goto L38;
        if (ops.knownAttributionTags.contains(attributionTag) == false) goto L42;
    L38:
        if (ops.bypass == null) goto L42;
        PackageVerificationResult r9 = new PackageVerificationResult(ops.bypass, ops.validAttributionTags.contains(attributionTag));     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
        return r9;
    L35:
        th = move-exception;
        throw th;
    L108:
        PackageManager pm = this.mContext.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L18
        String supplementalPackageName = pm.getSdkSandboxPackageName();     // Catch: PackageManager.NameNotFoundException -> L18
        if (Objects.equals(packageName, supplementalPackageName) == false) goto L20;
        uid2 = pm.getPackageUidAsUser(supplementalPackageName, PackageManager.PackageInfoFlags.of(0), UserHandle.getUserId(uid));     // Catch: PackageManager.NameNotFoundException -> L18
        goto L24
    L20:
        uid2 = uid;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    private boolean isPackageNullOrSystem(String packageName, int uid) {
        if (packageName != null) goto L6;
        return true;
    L6:
        if (Process.isSdkSandboxUid(uid) == false) goto L8;
        return false;
    L8:
        int appId = UserHandle.getAppId(uid);
        if (appId <= 0) goto L14;
        if (appId >= 10000) goto L14;
        return true;
    L14:
        if (this.mPackageManagerInternal.getPackageUid(packageName, 131072, UserHandle.getUserId(uid)) == uid) goto L17;
        return false;
    L17:
        return this.mPackageManagerInternal.isSystemPackage(packageName);
    }

    private boolean isAttributionInPackage(AndroidPackage pkg, String attributionTag) {
        if (pkg != null) goto L6;
        return false;
    L6:
        if (attributionTag != null) goto L9;
        return true;
    L9:
        if (pkg.getAttributions() == null) goto L16;
        int numAttributions = pkg.getAttributions().size();
        int i = 0;
    L11:
        if (i >= numAttributions) goto L16;
        if (((ParsedAttribution) pkg.getAttributions().get(i)).getTag().equals(attributionTag) == true) goto L14;
        i = i + 1;
        goto L11
    L14:
        return true;
    L16:
        return false;
    }

    private boolean isAttributionTagDefined(String packageName, String proxyPackageName, String attributionTag) {
        if (packageName != null) goto L6;
        return false;
    L6:
        if (attributionTag != null) goto L8;
        return true;
    L8:
        PackageManagerInternal pmInt = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (proxyPackageName == null) goto L15;
        AndroidPackage proxyPkg = pmInt.getPackage(proxyPackageName);
        if (proxyPkg == null) goto L15;
        if (isAttributionInPackage(proxyPkg, attributionTag) == false) goto L15;
        return true;
    L15:
        AndroidPackage pkg = pmInt.getPackage(packageName);
        return isAttributionInPackage(pkg, attributionTag);
    }

    private void logVerifyAndGetBypassFailure(int uid, SecurityException e, String methodName) {
        if (Process.isIsolated(uid) == false) goto L6;
        Slog.e(TAG, "Cannot " + methodName + ": isolated UID");
        return;
    L6:
        if (UserHandle.getAppId(uid) >= 10000) goto L8;
        Slog.e(TAG, "Cannot " + methodName + ": non-application UID " + uid);
        return;
    L8:
        Slog.e(TAG, "Cannot " + methodName, e);
    }

    private Ops getOpsLocked(int uid, String packageName, String attributionTag, boolean isAttributionTagValid, AppOpsManager.RestrictionBypass bypass, boolean edit) {
        UidState uidState = getUidStateLocked(uid, false);
        if (uidState != null) goto L5;
        return null;
    L5:
        Ops ops = uidState.pkgOps.get(packageName);
        if (ops != null) goto L10;
        if (edit == true) goto L9;
        return null;
    L9:
        ops = new Ops(packageName, uidState);
        uidState.pkgOps.put(packageName.intern(), ops);
    L10:
        if (edit == false) goto L18;
        if (bypass == null) goto L13;
        ops.bypass = bypass;
    L13:
        if (attributionTag == null) goto L18;
        ops.knownAttributionTags.add(attributionTag);
        if (isAttributionTagValid == false) goto L17;
        ops.validAttributionTags.add(attributionTag);
        goto L18
    L17:
        ops.validAttributionTags.remove(attributionTag);
    L18:
        return ops;
    }

    private void scheduleWriteLocked() {
        if (this.mWriteScheduled == true) goto L6;
        this.mWriteScheduled = true;
        getIoHandler().postDelayed(this.mWriteRunner, 1800000);
        return;
    }

    protected void scheduleFastWriteLocked() {
        if (this.mFastWriteScheduled == true) goto L6;
        this.mWriteScheduled = true;
        this.mFastWriteScheduled = true;
        getIoHandler().removeCallbacks(this.mWriteRunner);
        getIoHandler().postDelayed(this.mWriteRunner, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        return;
    }

    private Op getOpLocked(int code, int uid, String packageName, String attributionTag, boolean isAttributionTagValid, AppOpsManager.RestrictionBypass bypass, boolean edit) {
        Ops ops = getOpsLocked(uid, packageName, attributionTag, isAttributionTagValid, bypass, edit);
        if (ops != null) goto L7;
        return null;
    L7:
        return getOpLocked(ops, code, uid, edit);
    }

    private Op getOpLocked(Ops ops, int code, int uid, boolean edit) {
        Op op = ops.get(code);
        if (op != null) goto L9;
        if (edit == true) goto L7;
        return null;
    L7:
        op = new Op(this, ops.uidState, ops.packageName, code, uid);
        ops.put(code, op);
    L9:
        if (edit == false) goto L11;
        scheduleWriteLocked();
    L11:
        return op;
    }

    private boolean isOpRestrictedDueToSuspend(int code, String packageName, int uid) {
        if (ArrayUtils.contains(OPS_RESTRICTED_ON_SUSPEND, code) == true) goto L6;
        return false;
    L6:
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        return pmi.isPackageSuspended(packageName, UserHandle.getUserId(uid));
    }

    private boolean isAutomotive() {
        return this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    private boolean isOpRestrictedLocked(int uid, int code, String packageName, String attributionTag, int virtualDeviceId, AppOpsManager.RestrictionBypass appBypass, boolean isCheckOp) {
        if (virtualDeviceId == 0) goto L5;
        return false;
    L5:
        int restrictionSetCount = this.mOpGlobalRestrictions.size();
        int i = 0;
    L7:
        if (i >= restrictionSetCount) goto L13;
        ClientGlobalRestrictionState restrictionState = this.mOpGlobalRestrictions.valueAt(i);
        if (restrictionState.hasRestriction(code) == true) goto L10;
        i = i + 1;
        goto L7
    L10:
        return true;
    L13:
        if (code != 26) goto L31;
        if (isAutomotive() == false) goto L31;
        long identity = Binder.clearCallingIdentity();
        if (this.mSensorPrivacyManager.isCameraPrivacyEnabled(packageName) == false) goto L23;
        Binder.restoreCallingIdentity(identity);
        return true;
    L23:
        Binder.restoreCallingIdentity(identity);
    L24:
        th = th;
    L28:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L26:
        th = th;
    L31:
        int userHandle = UserHandle.getUserId(uid);
        int restrictionSetCount2 = this.mOpUserRestrictions.size();
        int i2 = 0;
    L32:
        if (i2 >= restrictionSetCount2) goto L68;
        ClientUserRestrictionState restrictionState2 = this.mOpUserRestrictions.valueAt(i2);
        if (restrictionState2.hasRestriction(code, packageName, attributionTag, userHandle, isCheckOp) == true) goto L35;
        i2 = i2 + 1;
        packageName = packageName;
        goto L32
    L35:
        AppOpsManager.RestrictionBypass opBypass = AppOpsManager.opAllowSystemBypassRestriction(code);
        if (opBypass == null) goto L65;
        monitor-enter(this);
    L45:
        th = move-exception;
        throw th;
    L39:
        if (opBypass.isSystemUid == false) goto L48;
        if (appBypass == null) goto L48;
        if (appBypass.isSystemUid == false) goto L48;
        monitor-exit(this);     // Catch: Throwable -> L45
        return false;
    L48:
        if (opBypass.isPrivileged == false) goto L55;
        if (appBypass == null) goto L55;
        if (appBypass.isPrivileged == false) goto L55;
        monitor-exit(this);     // Catch: Throwable -> L45
        return false;
    L55:
        if (opBypass.isRecordAudioRestrictionExcept == false) goto L61;
        if (appBypass == null) goto L61;
        if (appBypass.isRecordAudioRestrictionExcept == false) goto L61;
        monitor-exit(this);     // Catch: Throwable -> L45
        return false;
    L61:
        monitor-exit(this);     // Catch: Throwable -> L45
    L65:
        return true;
    L68:
        return false;
    }

    private void readRecentAccesses() {
        if (this.mRecentAccessesFile.exists() == true) goto L5;
        readRecentAccesses(this.mStorageFile);
        return;
    L5:
        readRecentAccesses(this.mRecentAccessesFile);
    }

    private void readRecentAccesses(AtomicFile file) {
        monitor-enter(file);
        monitor-enter(this);     // Catch: Throwable -> L62
        FileInputStream stream = file.openRead();     // Catch: Throwable -> L45 FileNotFoundException -> L71
        goto L72
    L84:
        this.mUidStates.clear();     // Catch: Throwable -> L45
        this.mAppOpsCheckingService.clearAllModes();     // Catch: Throwable -> L45
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L21 Exception -> L23
    L8:
        int type = parser.next();     // Catch: Throwable -> L21 Exception -> L23
        if (type == 2) goto L12;
        if (type != 1) goto L8;
    L12:
        if (type != 2) goto L52;
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L21 Exception -> L23
    L14:
        int type2 = parser.next();     // Catch: Throwable -> L21 Exception -> L23
        if (type2 == 1) goto L42;
        if (type2 == 3) goto L19;
    L26:
        if (type2 == 3) goto L14;
        if (type2 == 4) goto L14;
        String tagName = parser.getName();     // Catch: Throwable -> L21 Exception -> L23
        if (tagName.equals(SceneUtils.KEY_PKG) == true) goto L32;
        if (tagName.equals("uid") == true) goto L35;
        if (tagName.equals("enable") == true) goto L38;
        Slog.w(TAG, "Unknown element under <app-ops>: " + parser.getName());     // Catch: Throwable -> L21 Exception -> L23
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L21 Exception -> L23
        goto L14
    L38:
        this.mSmtEx.mEnabled = Boolean.parseBoolean(parser.getAttributeValue(null, "e"));     // Catch: Throwable -> L21 Exception -> L23
        goto L14
    L35:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L21 Exception -> L23
        goto L14
    L32:
        readPackage(parser);     // Catch: Throwable -> L21 Exception -> L23
        goto L14
    L19:
        if (parser.getDepth() > outerDepth) goto L26;
    L42:
        if (1 != 0) goto L47;
        this.mUidStates.clear();     // Catch: Throwable -> L45
        this.mAppOpsCheckingService.clearAllModes();     // Catch: Throwable -> L45
    L47:
        stream.close();     // Catch: Throwable -> L45 IOException -> L49
    L86:
        goto L59
    L52:
        throw new IllegalStateException("no start tag found");     // Catch: Throwable -> L21 Exception -> L23
    L23:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L21
        if (0 != 0) goto L57;
        this.mUidStates.clear();     // Catch: Throwable -> L45
        this.mAppOpsCheckingService.clearAllModes();     // Catch: Throwable -> L45
    L57:
        stream.close();     // Catch: Throwable -> L45 IOException -> L49
    L21:
        th = move-exception;
        if (0 != 0) goto L80;
        this.mUidStates.clear();     // Catch: Throwable -> L45
        this.mAppOpsCheckingService.clearAllModes();     // Catch: Throwable -> L45
    L80:
        stream.close();     // Catch: Throwable -> L45 IOException -> L68
    L70:
        throw th;     // Catch: Throwable -> L45
    L59:
        monitor-exit(this);     // Catch: Throwable -> L45
        monitor-exit(file);     // Catch: Throwable -> L62
        return;
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L72:
        Slog.i(TAG, "No existing app ops " + file.getBaseFile() + "; starting empty");     // Catch: Throwable -> L45
        return;
    L62:
        th = move-exception;
        throw th;
    }

    private void readPackage(TypedXmlPullParser parser) throws NumberFormatException, XmlPullParserException, IOException {
        String pkgName = parser.getAttributeValue(null, "n");
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("uid") == true) goto L16;
        Slog.w(TAG, "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readUid(parser, pkgName);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readUid(TypedXmlPullParser parser, String pkgName) throws NumberFormatException, XmlPullParserException, IOException {
        int uid = parser.getAttributeInt(null, "n");
        UidState uidState = getUidStateLocked(uid, true);
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("op") == true) goto L16;
        Slog.w(TAG, "Unknown element under <pkg>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readOp(parser, uidState, pkgName);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void readAttributionOp(TypedXmlPullParser parser, Op parent, String attribution) throws NumberFormatException, IOException, XmlPullParserException {
        AttributedOp attributedOp = parent.getOrCreateAttribution(parent, attribution, "default:0");
        long key = parser.getAttributeLong(null, "n");
        int uidState = AppOpsManager.extractUidStateFromKey(key);
        int opFlags = AppOpsManager.extractFlagsFromKey(key);
        long accessTime = parser.getAttributeLong(null, "t", 0);
        long r10 = parser.getAttributeLong(null, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD, 0);
        long accessDuration = parser.getAttributeLong(null, "d", -1);
        String proxyPkg = XmlUtils.readStringAttribute(parser, "pp");
        int proxyUid = parser.getAttributeInt(null, "pu", -1);
        String proxyAttributionTag = XmlUtils.readStringAttribute(parser, "pc");
        if (accessTime <= 0) goto L7;
        attributedOp.accessed(accessTime, accessDuration, proxyUid, proxyPkg, proxyAttributionTag, "default:0", uidState, opFlags);
    L7:
        if (r10 <= 0) goto L10;
        attributedOp.rejected(r10, uidState, opFlags);
        return;
    }

    private void readOp(TypedXmlPullParser parser, UidState uidState, String pkgName) throws NumberFormatException, XmlPullParserException, IOException {
        int opCode = parser.getAttributeInt(null, "n");
        Op op = new Op(this, uidState, pkgName, opCode, uidState.uid);
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("st") == true) goto L16;
        Slog.w(TAG, "Unknown element under <op>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        readAttributionOp(parser, op, XmlUtils.readStringAttribute(parser, "id"));
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L19:
        Ops ops = uidState.pkgOps.get(pkgName);
        if (ops != null) goto L22;
        ops = new Ops(pkgName, uidState);
        uidState.pkgOps.put(pkgName.intern(), ops);
    L22:
        ops.put(op.op, op);
    }

    void writeRecentAccesses() {
        AtomicFile r2 = this.mRecentAccessesFile;
        monitor-enter(r2);
        FileOutputStream stream = this.mRecentAccessesFile.startWrite();     // Catch: Throwable -> L16 IOException -> L90
        String r0 = null;
        List<AppOpsManager.PackageOps> allOps = getPackagesForOps(null);     // Catch: Throwable -> L16
        TypedXmlSerializer out = Xml.resolveSerializer(stream);     // Catch: Throwable -> L16 IOException -> L75
        out.startDocument(null, true);     // Catch: Throwable -> L16 IOException -> L75
        out.startTag(null, "app-ops");     // Catch: Throwable -> L16 IOException -> L75
        out.attributeInt(null, "v", 1);     // Catch: Throwable -> L16 IOException -> L75
        out.startTag(null, "enable");     // Catch: Throwable -> L16 IOException -> L75
        out.attribute(null, "e", Boolean.toString(this.mSmtEx.mEnabled));     // Catch: Throwable -> L16 IOException -> L75
        out.endTag(null, "enable");     // Catch: Throwable -> L16 IOException -> L75
        if (allOps == null) goto L83;
        String lastPkg = null;
        int i = 0;
    L11:
        if (i >= allOps.size()) goto L80;
        AppOpsManager.PackageOps pkg = allOps.get(i);     // Catch: Throwable -> L16 IOException -> L75
        if (Objects.equals(pkg.getPackageName(), lastPkg) == true) goto L24;
        if (lastPkg != null) goto L101;
    L20:
        String lastPkg2 = pkg.getPackageName();     // Catch: Throwable -> L16 IOException -> L18
        if (lastPkg2 == null) goto L23;
        out.startTag(r0, SceneUtils.KEY_PKG);     // Catch: Throwable -> L16 IOException -> L18
        out.attribute(r0, "n", lastPkg2);     // Catch: Throwable -> L16 IOException -> L18
    L23:
        lastPkg = lastPkg2;
        goto L24
    L101:
        out.endTag(r0, SceneUtils.KEY_PKG);     // Catch: Throwable -> L16 IOException -> L18
    L18:
        e = e;
    L86:
        Slog.w(TAG, "Failed to write state, restoring backup.", e);     // Catch: Throwable -> L16
        this.mRecentAccessesFile.failWrite(stream);     // Catch: Throwable -> L16
    L87:
        monitor-exit(r2);     // Catch: Throwable -> L16
        this.mHistoricalRegistry.writeAndClearDiscreteHistory();
        return;
    L24:
        out.startTag(r0, "uid");     // Catch: Throwable -> L16 IOException -> L75
        out.attributeInt(r0, "n", pkg.getUid());     // Catch: Throwable -> L16 IOException -> L75
        List<AppOpsManager.OpEntry> ops = pkg.getOps();     // Catch: Throwable -> L16 IOException -> L75
        int j = 0;
    L26:
        if (j >= ops.size()) goto L78;
        AppOpsManager.OpEntry op = ops.get(j);     // Catch: Throwable -> L16 IOException -> L75
        out.startTag(r0, "op");     // Catch: Throwable -> L16 IOException -> L75
        out.attributeInt(r0, "n", op.getOp());     // Catch: Throwable -> L16 IOException -> L75
        if (op.getMode() == AppOpsManager.opToDefaultMode(op.getOp())) goto L30;
        out.attributeInt(r0, "m", op.getMode());     // Catch: Throwable -> L16 IOException -> L18
    L30:
        Iterator r12 = op.getAttributedOpEntries().keySet().iterator();     // Catch: Throwable -> L16 IOException -> L75
    L32:
        if (r12.hasNext() == false) goto L77;
        String attributionTag = (String) r12.next();     // Catch: Throwable -> L16 IOException -> L75
        AppOpsManager.AttributedOpEntry attribution = (AppOpsManager.AttributedOpEntry) op.getAttributedOpEntries().get(attributionTag);     // Catch: Throwable -> L16 IOException -> L75
        ArraySet<Long> keys = attribution.collectKeys();     // Catch: Throwable -> L16 IOException -> L75
        int k = keys.size();     // Catch: Throwable -> L16 IOException -> L75
        int k2 = 0;
    L35:
        List<AppOpsManager.PackageOps> allOps2 = allOps;
        int keyCount = k;
        if (k2 >= keyCount) goto L74;
        long key = keys.valueAt(k2).longValue();     // Catch: Throwable -> L16 IOException -> L48
        int uidState = AppOpsManager.extractUidStateFromKey(key);     // Catch: Throwable -> L16 IOException -> L48
        int flags = AppOpsManager.extractFlagsFromKey(key);     // Catch: Throwable -> L16 IOException -> L48
        int k3 = k2;
        long accessTime = attribution.getLastAccessTime(uidState, uidState, flags);     // Catch: Throwable -> L16 IOException -> L48
        long rejectTime = attribution.getLastRejectTime(uidState, uidState, flags);     // Catch: Throwable -> L16 IOException -> L48
        long accessDuration = attribution.getLastDuration(uidState, uidState, flags);     // Catch: Throwable -> L16 IOException -> L48
        AppOpsManager.OpEventProxyInfo proxy = attribution.getLastProxyInfo(uidState, uidState, flags);     // Catch: Throwable -> L16 IOException -> L48
        if (accessTime > 0) goto L46;
        if (rejectTime > 0) goto L46;
        if (accessDuration > 0) goto L46;
        if (proxy != null) goto L46;
        lastPkg = lastPkg;
    L73:
        k2 = k3 + 1;     // Catch: Throwable -> L16 IOException -> L48
        allOps = allOps2;
        k = keyCount;
        ops = ops;
        j = j;
        lastPkg = lastPkg;
        i = i;
        pkg = pkg;
    L46:
        if (proxy == null) goto L50;
        String proxyPkg = proxy.getPackageName();     // Catch: Throwable -> L16 IOException -> L48
        String proxyAttributionTag = proxy.getAttributionTag();     // Catch: Throwable -> L16 IOException -> L48
        int proxyUid = proxy.getUid();     // Catch: Throwable -> L16 IOException -> L48
        String proxyPkg2 = proxyPkg;
        String proxyAttributionTag2 = proxyAttributionTag;
        int proxyUid2 = proxyUid;
    L51:
        out.startTag(null, "st");     // Catch: Throwable -> L16 IOException -> L48
        if (attributionTag == null) goto L54;
        out.attribute(null, "id", attributionTag);     // Catch: Throwable -> L16 IOException -> L48
    L54:
        out.attributeLong(null, "n", key);     // Catch: Throwable -> L16 IOException -> L48
        if (accessTime <= 0) goto L57;
        long key2 = accessTime;
        out.attributeLong(null, "t", key2);     // Catch: Throwable -> L16 IOException -> L48
    L59:
        if (rejectTime <= 0) goto L61;
        long accessTime2 = rejectTime;
        out.attributeLong(null, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD, accessTime2);     // Catch: Throwable -> L16 IOException -> L48
    L63:
        if (accessDuration <= 0) goto L66;
        out.attributeLong(null, "d", accessDuration);     // Catch: Throwable -> L16 IOException -> L48
    L66:
        if (proxyPkg2 == null) goto L68;
        out.attribute(null, "pp", proxyPkg2);     // Catch: Throwable -> L16 IOException -> L48
    L68:
        if (proxyAttributionTag2 == null) goto L70;
        out.attribute(null, "pc", proxyAttributionTag2);     // Catch: Throwable -> L16 IOException -> L48
    L70:
        if (proxyUid2 < 0) goto L72;
        out.attributeInt(null, "pu", proxyUid2);     // Catch: Throwable -> L16 IOException -> L48
    L72:
        out.endTag(null, "st");     // Catch: Throwable -> L16 IOException -> L48
        goto L73
    L61:
        accessTime2 = rejectTime;
        goto L63
    L57:
        key2 = accessTime;
        goto L59
    L50:
        proxyPkg2 = null;
        proxyAttributionTag2 = null;
        proxyUid2 = -1;
    L48:
        e = e;
        goto L86
    L74:
        allOps = allOps2;
        goto L32
    L77:
        out.endTag(null, "op");     // Catch: Throwable -> L16 IOException -> L48
        j = j + 1;     // Catch: Throwable -> L16 IOException -> L48
        allOps = allOps;
        ops = ops;
        lastPkg = lastPkg;
        i = i;
        pkg = pkg;
        r0 = null;
        goto L26
    L78:
        out.endTag(null, "uid");     // Catch: Throwable -> L16 IOException -> L48
        i = i + 1;     // Catch: Throwable -> L16 IOException -> L48
        allOps = allOps;
        lastPkg = lastPkg;
        r0 = null;
        goto L11
    L80:
        if (lastPkg == null) goto L83;
        out.endTag(null, SceneUtils.KEY_PKG);     // Catch: Throwable -> L16 IOException -> L48
    L83:
        out.endTag(null, "app-ops");     // Catch: Throwable -> L16 IOException -> L48
        out.endDocument();     // Catch: Throwable -> L16 IOException -> L48
        this.mRecentAccessesFile.finishWrite(stream);     // Catch: Throwable -> L16 IOException -> L48
    L75:
        e = e;
        goto L86
    L16:
        th = move-exception;
        throw th;
    L90:
        e = move-exception;
        Slog.w(TAG, "Failed to write state: " + e);     // Catch: Throwable -> L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new Shell(this, this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    static void dumpCommandHelp(PrintWriter pw) {
        pw.println("AppOps service (appops) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("  start [--user <USER_ID>] [--attribution <ATTRIBUTION_TAG>] <PACKAGE | UID> <OP> ");
        pw.println("    Starts a given operation for a particular application.");
        pw.println("  stop [--user <USER_ID>] [--attribution <ATTRIBUTION_TAG>] <PACKAGE | UID> <OP> ");
        pw.println("    Stops a given operation for a particular application.");
        pw.println("  set [--user <USER_ID>] <[--uid] PACKAGE | UID> <OP> <MODE>");
        pw.println("    Set the mode for a particular application and operation.");
        pw.println("  get [--user <USER_ID>] [--attribution <ATTRIBUTION_TAG>] <PACKAGE | UID> [<OP>]");
        pw.println("    Return the mode for a particular application and optional operation.");
        pw.println("  query-op [--user <USER_ID>] <OP> [<MODE>]");
        pw.println("    Print all packages that currently have the given op in the given mode.");
        pw.println("  reset [--user <USER_ID>] [<PACKAGE>]");
        pw.println("    Reset the given application or all applications to default modes.");
        pw.println("  write-settings");
        pw.println("    Immediately write pending changes to storage.");
        pw.println("  read-settings");
        pw.println("    Read the last written settings, replacing current state in RAM.");
        pw.println("  options:");
        pw.println("    <PACKAGE> an Android package name or its UID if prefixed by --uid");
        pw.println("    <OP>      an AppOps operation.");
        pw.println("    <MODE>    one of allow, ignore, deny, or default");
        pw.println("    <USER_ID> the user id under which the package is installed. If --user is");
        pw.println("              not specified, the current user is assumed.");
    }

    static int onShellCommand(Shell shell, String cmd) {
        if (cmd == null) goto L5;
        PrintWriter pw = shell.getOutPrintWriter();
        PrintWriter err = shell.getErrPrintWriter();
        int r7 = 0;
        switch(cmd.hashCode()) {
            case -1703718319: goto L37;
            case -1166702330: goto L34;
            case 102230: goto L31;
            case 113762: goto L28;
            case 3387378: goto L25;
            case 3540994: goto L22;
            case 108404047: goto L19;
            case 109757538: goto L16;
            case 2085703290: goto L11;
            default: goto L39;
        };     // Catch: RemoteException -> L13
    L39:
        byte r0 = -1;
    L40:
        switch(r0) {
            case 0: goto L217;
            case 1: goto L138;
            case 2: goto L111;
            case 3: goto L89;
            case 4: goto L74;
            case 5: goto L67;
            case 6: goto L59;
            case 7: goto L51;
            case 8: goto L43;
            default: goto L42;
        };     // Catch: RemoteException -> L13
    L43:
        int res = shell.parseUserPackageOp(true, err);     // Catch: RemoteException -> L13
        if (res >= 0) goto L47;
        return res;
    L47:
        if (shell.packageName == null) goto L50;
        shell.mInterface.finishOperation(shell.mToken, shell.op, shell.packageUid, shell.packageName, shell.attributionTag);     // Catch: RemoteException -> L13
        return 0;
    L50:
        return -1;
    L51:
        int res2 = shell.parseUserPackageOp(true, err);     // Catch: RemoteException -> L13
        if (res2 >= 0) goto L55;
        return res2;
    L55:
        if (shell.packageName == null) goto L58;
        shell.mInterface.startOperation(shell.mToken, shell.op, shell.packageUid, shell.packageName, shell.attributionTag, true, true, "appops start shell command", true, 1, -1);     // Catch: RemoteException -> L13
        return 0;
    L58:
        return -1;
    L59:
        int res3 = shell.parseUserPackageOp(true, err);     // Catch: RemoteException -> L13
        if (res3 >= 0) goto L63;
        return res3;
    L63:
        if (shell.packageName == null) goto L66;
        shell.mInterface.noteOperation(shell.op, shell.packageUid, shell.packageName, shell.attributionTag, true, "appops note shell command", true);     // Catch: RemoteException -> L13
        return 0;
    L66:
        return -1;
    L67:
        shell.mInternal.enforceManageAppOpsModes(Binder.getCallingPid(), Binder.getCallingUid(), -1);     // Catch: RemoteException -> L13
        long token = Binder.clearCallingIdentity();     // Catch: RemoteException -> L13
        shell.mInternal.readRecentAccesses();     // Catch: Throwable -> L71
        shell.mInternal.mAppOpsCheckingService.readState();     // Catch: Throwable -> L71
        pw.println("Last settings read.");     // Catch: Throwable -> L71
        Binder.restoreCallingIdentity(token);     // Catch: RemoteException -> L13
        return 0;
    L71:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: RemoteException -> L13
        throw th;     // Catch: RemoteException -> L13
    L74:
        shell.mInternal.enforceManageAppOpsModes(Binder.getCallingPid(), Binder.getCallingUid(), -1);     // Catch: RemoteException -> L13
        long token2 = Binder.clearCallingIdentity();     // Catch: RemoteException -> L13
        AppOpsService r6 = shell.mInternal;     // Catch: Throwable -> L82
        monitor-enter(r6);     // Catch: Throwable -> L82
        shell.mInternal.getIoHandler().removeCallbacks(shell.mInternal.mWriteRunner);     // Catch: Throwable -> L84
        monitor-exit(r6);     // Catch: Throwable -> L84
        shell.mInternal.writeRecentAccesses();     // Catch: Throwable -> L82
        shell.mInternal.mAppOpsCheckingService.writeState();     // Catch: Throwable -> L82
        pw.println("Current settings written.");     // Catch: Throwable -> L82
        Binder.restoreCallingIdentity(token2);     // Catch: RemoteException -> L13
        return 0;
    L84:
        th = move-exception;
        throw th;     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        Binder.restoreCallingIdentity(token2);     // Catch: RemoteException -> L13
        throw th;     // Catch: RemoteException -> L13
    L89:
        String packageName = null;
        int userId = -2;
    L90:
        String argument = shell.getNextArg();     // Catch: RemoteException -> L13
        if (argument == null) goto L100;
        if ("--user".equals(argument) == true) goto L94;
        if (packageName != null) goto L97;
        packageName = argument;
        goto L90
    L97:
        err.println("Error: Unsupported argument: " + argument);     // Catch: RemoteException -> L13
        return -1;
    L94:
        String userStr = shell.getNextArgRequired();     // Catch: RemoteException -> L13
        userId = UserHandle.parseUserArg(userStr);     // Catch: RemoteException -> L13
        goto L90
    L100:
        if (userId != (-2)) goto L102;
        userId = ActivityManager.getCurrentUser();     // Catch: RemoteException -> L13
    L102:
        shell.mInterface.resetAllModes(userId, packageName);     // Catch: RemoteException -> L13
        pw.print("Reset all modes for: ");     // Catch: RemoteException -> L13
        if (userId != (-1)) goto L105;
        pw.print("all users");     // Catch: RemoteException -> L13
    L106:
        pw.print(", ");     // Catch: RemoteException -> L13
        if (packageName != null) goto L109;
        pw.println("all packages");     // Catch: RemoteException -> L13
    L110:
        return 0;
    L109:
        pw.print("package ");     // Catch: RemoteException -> L13
        pw.println(packageName);     // Catch: RemoteException -> L13
        goto L110
    L105:
        pw.print("user ");     // Catch: RemoteException -> L13
        pw.print(userId);     // Catch: RemoteException -> L13
        goto L106
    L111:
        int res4 = shell.parseUserOpMode(1, err);     // Catch: RemoteException -> L13
        if (res4 >= 0) goto L114;
        return res4;
    L114:
        List<AppOpsManager.PackageOps> ops = shell.mInterface.getPackagesForOps(new int[]{shell.op});     // Catch: RemoteException -> L13
        if (ops == null) goto L136;
        if (ops.size() <= 0) goto L136;
        int i = 0;
    L121:
        if (i >= ops.size()) goto L135;
        AppOpsManager.PackageOps pkg = ops.get(i);     // Catch: RemoteException -> L13
        boolean hasMatch = false;
        List<AppOpsManager.OpEntry> entries = ops.get(i).getOps();     // Catch: RemoteException -> L13
        int j = 0;
    L124:
        if (j >= entries.size()) goto L131;
        AppOpsManager.OpEntry ent = entries.get(j);     // Catch: RemoteException -> L13
        if (ent.getOp() != shell.op) goto L130;
        if (ent.getMode() != shell.mode) goto L130;
        hasMatch = true;
    L130:
        j = j + 1;     // Catch: RemoteException -> L13
    L131:
        if (hasMatch == false) goto L133;
        pw.println(pkg.getPackageName());     // Catch: RemoteException -> L13
    L133:
        i = i + 1;     // Catch: RemoteException -> L13
        goto L121
    L135:
        return 0;
    L136:
        pw.println("No operations.");     // Catch: RemoteException -> L13
        return 0;
    L138:
        int res5 = shell.parseUserPackageOp(false, err);     // Catch: RemoteException -> L13
        if (res5 >= 0) goto L141;
        return res5;
    L141:
        List<AppOpsManager.PackageOps> ops2 = new ArrayList();     // Catch: RemoteException -> L13
        int[] r9 = null;
        if (shell.packageName == null) goto L157;
        IAppOpsService r8 = shell.mInterface;     // Catch: RemoteException -> L13
        int r10 = shell.packageUid;     // Catch: RemoteException -> L13
        if (shell.op == (-1)) goto L146;
        int[] r11 = {shell.op};     // Catch: RemoteException -> L13
    L147:
        List<AppOpsManager.PackageOps> r = r8.getUidOps(r10, r11);     // Catch: RemoteException -> L13
        if (r == null) goto L150;
        ops2.addAll(r);     // Catch: RemoteException -> L13
    L150:
        IAppOpsService r12 = shell.mInterface;     // Catch: RemoteException -> L13
        int r13 = shell.packageUid;     // Catch: RemoteException -> L13
        String r14 = shell.packageName;     // Catch: RemoteException -> L13
        if (shell.op == (-1)) goto L153;
        r9 = new int[]{shell.op};     // Catch: RemoteException -> L13
    L153:
        List<AppOpsManager.PackageOps> r2 = r12.getOpsForPackage(r13, r14, r9);     // Catch: RemoteException -> L13
        if (r2 == null) goto L161;
        ops2.addAll(r2);     // Catch: RemoteException -> L13
    L161:
        if (ops2 == null) goto L211;
        if (ops2.size() <= 0) goto L211;
        long now = System.currentTimeMillis();     // Catch: RemoteException -> L13
        int i2 = 0;
    L167:
        if (i2 >= ops2.size()) goto L209;
        AppOpsManager.PackageOps packageOps = ops2.get(i2);     // Catch: RemoteException -> L13
        if (packageOps.getPackageName() != null) goto L171;
        pw.print("Uid mode: ");     // Catch: RemoteException -> L13
    L171:
        List<AppOpsManager.OpEntry> entries2 = packageOps.getOps();     // Catch: RemoteException -> L13
        int j2 = 0;
    L173:
        if (j2 >= entries2.size()) goto L207;
        AppOpsManager.OpEntry ent2 = entries2.get(j2);     // Catch: RemoteException -> L13
        pw.print(AppOpsManager.opToName(ent2.getOp()));     // Catch: RemoteException -> L13
        pw.print(": ");     // Catch: RemoteException -> L13
        pw.print(AppOpsManager.modeToName(ent2.getMode()));     // Catch: RemoteException -> L13
        int r18 = r7;
        if (shell.attributionTag == null) goto L177;
        ops2 = ops2;
        AppOpsManager.AttributedOpEntry attributionEnt = (AppOpsManager.AttributedOpEntry) ent2.getAttributedOpEntries().get(shell.attributionTag);     // Catch: RemoteException -> L13
        if (attributionEnt != null) goto L193;
        long now2 = now;
    L206:
        pw.println();     // Catch: RemoteException -> L13
        j2 = j2 + 1;     // Catch: RemoteException -> L13
        r7 = r18;
        ops2 = ops2;
        now = now2;
        goto L173
    L193:
        if (attributionEnt.getLastAccessTime(31) == (-1)) goto L195;
        pw.print("; time=");     // Catch: RemoteException -> L13
        now2 = now;
        TimeUtils.formatDuration(now2 - attributionEnt.getLastAccessTime(31), pw);     // Catch: RemoteException -> L13
        pw.print(" ago");     // Catch: RemoteException -> L13
    L197:
        if (attributionEnt.getLastRejectTime(31) == (-1)) goto L200;
        pw.print("; rejectTime=");     // Catch: RemoteException -> L13
        TimeUtils.formatDuration(now2 - attributionEnt.getLastRejectTime(31), pw);     // Catch: RemoteException -> L13
        pw.print(" ago");     // Catch: RemoteException -> L13
    L200:
        if (attributionEnt.isRunning() == false) goto L203;
        pw.print(" (running)");     // Catch: RemoteException -> L13
        goto L206
    L203:
        if (attributionEnt.getLastDuration(31) == (-1)) goto L206;
        pw.print("; duration=");     // Catch: RemoteException -> L13
        TimeUtils.formatDuration(attributionEnt.getLastDuration(31), pw);     // Catch: RemoteException -> L13
        goto L206
    L195:
        now2 = now;
        goto L197
    L177:
        if (ent2.getLastAccessTime(31) == (-1)) goto L181;
        pw.print("; time=");     // Catch: RemoteException -> L13
        TimeUtils.formatDuration(now - ent2.getLastAccessTime(31), pw);     // Catch: RemoteException -> L13
        pw.print(" ago");     // Catch: RemoteException -> L13
    L181:
        if (ent2.getLastRejectTime(31) == (-1)) goto L184;
        pw.print("; rejectTime=");     // Catch: RemoteException -> L13
        TimeUtils.formatDuration(now - ent2.getLastRejectTime(31), pw);     // Catch: RemoteException -> L13
        pw.print(" ago");     // Catch: RemoteException -> L13
    L184:
        if (ent2.isRunning() == false) goto L187;
        pw.print(" (running)");     // Catch: RemoteException -> L13
        now2 = now;
        goto L206
    L187:
        if (ent2.getLastDuration(31) == (-1)) goto L189;
        pw.print("; duration=");     // Catch: RemoteException -> L13
        TimeUtils.formatDuration(ent2.getLastDuration(31), pw);     // Catch: RemoteException -> L13
        now2 = now;
        goto L206
    L189:
        now2 = now;
        goto L206
    L207:
        i2 = i2 + 1;     // Catch: RemoteException -> L13
        goto L167
    L209:
        return r7;
    L211:
        pw.println("No operations.");     // Catch: RemoteException -> L13
        if (shell.op > (-1)) goto L214;
    L216:
        return 0;
    L214:
        if (shell.op >= 166) goto L216;
        pw.println("Default mode: " + AppOpsManager.modeToName(AppOpsManager.opToDefaultMode(shell.op)));     // Catch: RemoteException -> L13
        goto L216
    L146:
        r11 = null;
        goto L147
    L157:
        IAppOpsService r15 = shell.mInterface;     // Catch: RemoteException -> L13
        int r16 = shell.nonpackageUid;     // Catch: RemoteException -> L13
        if (shell.op == (-1)) goto L160;
        r9 = new int[]{shell.op};     // Catch: RemoteException -> L13
    L160:
        ops2 = r15.getUidOps(r16, r9);     // Catch: RemoteException -> L13
        goto L161
    L217:
        int res6 = shell.parseUserPackageOp(true, err);     // Catch: RemoteException -> L13
        if (res6 >= 0) goto L220;
        return res6;
    L220:
        String modeStr = shell.getNextArg();     // Catch: RemoteException -> L13
        if (modeStr != null) goto L224;
        err.println("Error: Mode not specified.");     // Catch: RemoteException -> L13
        return -1;
    L224:
        int mode = Shell.strModeToMode(modeStr, err);     // Catch: RemoteException -> L13
        if (mode >= 0) goto L229;
        return -1;
    L229:
        if (shell.targetsUid == true) goto L234;
        if (shell.packageName == null) goto L234;
        shell.mInterface.setMode(shell.op, shell.packageUid, shell.packageName, mode);     // Catch: RemoteException -> L13
    L243:
        return 0;
    L234:
        if (shell.targetsUid == true) goto L236;
    L242:
        shell.mInterface.setUidMode(shell.op, shell.nonpackageUid, mode);     // Catch: RemoteException -> L13
        goto L243
    L236:
        if (shell.packageName == null) goto L242;
        int uid = shell.mInternal.mContext.getPackageManager().getPackageUidAsUser(shell.packageName, shell.userId);     // Catch: RemoteException -> L13 PackageManager.NameNotFoundException -> L239
        shell.mInterface.setUidMode(shell.op, uid, mode);     // Catch: RemoteException -> L13 PackageManager.NameNotFoundException -> L239
    L240:
        return -1;
    L42:
        return shell.handleDefaultCommands(cmd);
    L11:
        if (cmd.equals("read-settings") == false) goto L39;
        r0 = 5;
        goto L40
    L16:
        if (cmd.equals(IMediaProjectionManagerServiceExt.NODE_START) == false) goto L39;
        r0 = 7;
        goto L40
    L19:
        if (cmd.equals("reset") == false) goto L39;
        r0 = 3;
        goto L40
    L22:
        if (cmd.equals(IMediaProjectionManagerServiceExt.NODE_STOP) == false) goto L39;
        r0 = 8;
        goto L40
    L25:
        if (cmd.equals("note") == false) goto L39;
        r0 = 6;
        goto L40
    L28:
        if (cmd.equals("set") == false) goto L39;
        r0 = 0;
        goto L40
    L31:
        if (cmd.equals("get") == false) goto L39;
        r0 = 1;
        goto L40
    L34:
        if (cmd.equals("query-op") == false) goto L39;
        r0 = 2;
        goto L40
    L37:
        if (cmd.equals("write-settings") == false) goto L39;
        r0 = 4;
    L13:
        e = move-exception;
        pw.println("Remote exception: " + e);
        return -1;
    L5:
        return shell.handleDefaultCommands(cmd);
    }

    private void dumpHelp(PrintWriter pw) {
        pw.println("AppOps service (appops) dump options:");
        pw.println("  -h");
        pw.println("    Print this help text.");
        pw.println("  --op [OP]");
        pw.println("    Limit output to data associated with the given app op code.");
        pw.println("  --mode [MODE]");
        pw.println("    Limit output to data associated with the given app op mode.");
        pw.println("  --package [PACKAGE]");
        pw.println("    Limit output to data associated with the given package name.");
        pw.println("  --attributionTag [attributionTag]");
        pw.println("    Limit output to data associated with the given attribution tag.");
        pw.println("  --include-discrete [n]");
        pw.println("    Include discrete ops limited to n per dimension. Use zero for no limit.");
        pw.println("  --watchers");
        pw.println("    Only output the watcher sections.");
        pw.println("  --history");
        pw.println("    Only output history.");
        pw.println("  --uid-state-changes");
        pw.println("    Include logs about uid state changes.");
    }

    private void dumpStatesLocked(PrintWriter pw, String filterAttributionTag, int filter, long nowElapsed, Op op, long now, SimpleDateFormat sdf, Date date, String prefix) {
        Op r4 = op;
        ArrayMap<String, AttributedOp> defaultDeviceAttributedOps = r4.mDeviceAttributedOps.get("default:0");
        int numAttributions = defaultDeviceAttributedOps.size();
        int i = 0;
    L3:
        if (i >= numAttributions) goto L13;
        if ((filter & 4) == 0) goto L10;
        if (Objects.equals(defaultDeviceAttributedOps.keyAt(i), filterAttributionTag) == true) goto L10;
    L11:
        i = i + 1;
        r4 = op;
    L10:
        pw.print(prefix + defaultDeviceAttributedOps.keyAt(i) + "=[\n");
        dumpStatesLocked(pw, nowElapsed, r4, defaultDeviceAttributedOps.keyAt(i), now, sdf, date, prefix + "  ");
        pw.print(prefix + "]\n");
        goto L11
    }

    private void dumpStatesLocked(PrintWriter pw, long nowElapsed, Op op, String attributionTag, long now, SimpleDateFormat sdf, Date date, String prefix) {
        String r3 = prefix;
        AppOpsManager.AttributedOpEntry entry = (AppOpsManager.AttributedOpEntry) op.createSingleAttributionEntryLocked(attributionTag).getAttributedOpEntries().get(attributionTag);
        ArraySet<Long> keys = entry.collectKeys();
        int keyCount = keys.size();
        int k = 0;
    L3:
        if (k >= keyCount) goto L26;
        long key = keys.valueAt(k).longValue();
        int uidState = AppOpsManager.extractUidStateFromKey(key);
        int flags = AppOpsManager.extractFlagsFromKey(key);
        long accessTime = entry.getLastAccessTime(uidState, uidState, flags);
        long rejectTime = entry.getLastRejectTime(uidState, uidState, flags);
        ArraySet<Long> keys2 = keys;
        int keyCount2 = keyCount;
        long accessDuration = entry.getLastDuration(uidState, uidState, flags);
        AppOpsManager.OpEventProxyInfo proxy = entry.getLastProxyInfo(uidState, uidState, flags);
        if (proxy == null) goto L7;
        String proxyPkg = proxy.getPackageName();
        String proxyAttributionTag = proxy.getAttributionTag();
        int proxyUid = proxy.getUid();
        String proxyPkg2 = proxyPkg;
        String proxyAttributionTag2 = proxyAttributionTag;
        int proxyUid2 = proxyUid;
        long key2 = key;
    L9:
        if (accessTime <= 0) goto L17;
        pw.print(r3);
        pw.print("Access: ");
        pw.print(AppOpsManager.keyToString(key2));
        pw.print(" ");
        date.setTime(accessTime);
        pw.print(sdf.format(date));
        pw.print(" (");
        TimeUtils.formatDuration(accessTime - now, pw);
        pw.print(")");
        if (accessDuration <= 0) goto L13;
        pw.print(" duration=");
        TimeUtils.formatDuration(accessDuration, pw);
    L13:
        if (proxyUid2 < 0) goto L15;
        pw.print(" proxy[");
        pw.print("uid=");
        pw.print(proxyUid2);
        pw.print(", pkg=");
        pw.print(proxyPkg2);
        pw.print(", attributionTag=");
        pw.print(proxyAttributionTag2);
        String r4 = "]";
        pw.print(r4);
    L16:
        pw.println();
    L19:
        if (rejectTime <= 0) goto L24;
        String r12 = prefix;
        pw.print(r12);
        pw.print("Reject: ");
        pw.print(AppOpsManager.keyToString(key2));
        date.setTime(rejectTime);
        pw.print(sdf.format(date));
        pw.print(" (");
        TimeUtils.formatDuration(rejectTime - now, pw);
        pw.print(")");
        if (proxyUid2 < 0) goto L23;
        pw.print(" proxy[");
        pw.print("uid=");
        pw.print(proxyUid2);
        pw.print(", pkg=");
        pw.print(proxyPkg2);
        pw.print(", attributionTag=");
        pw.print(proxyAttributionTag2);
        pw.print(r4);
    L23:
        pw.println();
    L25:
        k = k + 1;
        r3 = r12;
        keys = keys2;
        keyCount = keyCount2;
        entry = entry;
        goto L3
    L24:
        r12 = prefix;
        goto L25
    L15:
        r4 = "]";
        goto L16
    L17:
        r4 = "]";
        goto L19
    L7:
        proxyPkg2 = null;
        proxyAttributionTag2 = null;
        proxyUid2 = -1;
        key2 = key;
        goto L9
    L26:
        String r13 = r3;
        AttributedOp attributedOp = op.mDeviceAttributedOps.getOrDefault("default:0", new ArrayMap()).get(attributionTag);
        if (attributedOp.isRunning() == false) goto L39;
        long earliestElapsedTime = Long.MAX_VALUE;
        long maxNumStarts = 0;
        int numInProgressEvents = attributedOp.mInProgressEvents.size();
        int i = 0;
    L29:
        if (i >= numInProgressEvents) goto L31;
        AttributedOp.InProgressStartOpEvent event = attributedOp.mInProgressEvents.valueAt(i);
        earliestElapsedTime = Math.min(earliestElapsedTime, event.getStartElapsedTime());
        maxNumStarts = Math.max(maxNumStarts, event.mNumUnfinishedStarts);
        i = i + 1;
        goto L29
    L31:
        pw.print(r13 + "Running start at: ");
        TimeUtils.formatDuration(nowElapsed - earliestElapsedTime, pw);
        pw.println();
        if (maxNumStarts <= 1) goto L40;
        pw.print(r13 + "startNesting=");
        pw.println(maxNumStarts);
        return;
    L40:
        return;
    }

    @NeverCompile
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        AppOpsService r1 = this;
        if (DumpUtils.checkDumpAndUsageStatsPermission(r1.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        boolean r16 = true;
        if (args == null) goto L93;
        int dumpOp = -1;
        int dumpOp2 = 0;
        boolean dumpAll = false;
        int dumpFilter = 0;
        int dumpFilter2 = 10;
        boolean dumpUidStateChangeLogs = false;
        boolean dumpUidStateChangeLogs2 = false;
        boolean includeDiscreteOps = false;
        boolean dumpHistory = false;
        int dumpMode = -1;
        int dumpMode2 = -1;
        String dumpAttributionTag = null;
        String dumpAttributionTag2 = null;
    L9:
        if (dumpOp2 >= args.length) goto L92;
        String arg = args[dumpOp2];
        int i = dumpOp2;
        if ("-h".equals(arg) == true) goto L12;
        if ("-a".equals(arg) == false) goto L18;
        dumpAll = true;
        int i2 = i;
    L89:
        dumpOp2 = i2 + 1;
        goto L9
    L18:
        if ("--op".equals(arg) == false) goto L26;
        i2 = i + 1;
        int dumpOp3 = args.length;
        if (i2 >= dumpOp3) goto L21;
        dumpOp = Shell.m1763$$Nest$smstrOpToOp(args[i2], pw);
        dumpFilter = dumpFilter | 8;
        if (dumpOp >= 0) goto L89;
        return;
    L21:
        pw.println("No argument for --op option");
        return;
    L26:
        int dumpOp4 = dumpOp;
        if ("--package".equals(arg) == false) goto L46;
        int i3 = i + 1;
        if (i3 >= args.length) goto L30;
        dumpAttributionTag2 = args[i3];
        int dumpFilter3 = dumpFilter | 2;
        String dumpAttributionTag3 = dumpAttributionTag;
        int i4 = i3;
        int dumpUid = AppGlobals.getPackageManager().getPackageUid(dumpAttributionTag2, 12591104, 0);     // Catch: RemoteException -> L37
    L42:
        if (dumpUid < 0) goto L43;
        dumpMode2 = UserHandle.getAppId(dumpUid);
        dumpFilter = dumpFilter3 | 1;
        i2 = i4;
        dumpOp = dumpOp4;
        dumpAttributionTag = dumpAttributionTag3;
        goto L89
    L43:
        pw.println("Unknown package: " + dumpAttributionTag2);
        return;
    L41:
        dumpUid = dumpMode2;
    L40:
        i4 = i3;
        dumpAttributionTag3 = dumpAttributionTag;
        goto L41
    L30:
        pw.println("No argument for --package option");
        return;
    L46:
        String dumpAttributionTag4 = dumpAttributionTag;
        int dumpUid2 = dumpMode2;
        if ("--attributionTag".equals(arg) == false) goto L54;
        i2 = i + 1;
        if (i2 >= args.length) goto L50;
        String dumpAttributionTag5 = args[i2];
        dumpFilter = dumpFilter | 4;
        dumpMode2 = dumpUid2;
        dumpAttributionTag = dumpAttributionTag5;
        dumpOp = dumpOp4;
        goto L89
    L50:
        pw.println("No argument for --attributionTag option");
        return;
    L54:
        if ("--mode".equals(arg) == false) goto L64;
        i2 = i + 1;
        if (i2 >= args.length) goto L57;
        int dumpMode3 = Shell.strModeToMode(args[i2], pw);
        if (dumpMode3 < 0) goto L61;
        dumpMode = dumpMode3;
        dumpOp = dumpOp4;
        dumpAttributionTag = dumpAttributionTag4;
        dumpMode2 = dumpUid2;
        goto L89
    L61:
        return;
    L57:
        pw.println("No argument for --mode option");
        return;
    L64:
        if ("--watchers".equals(arg) == false) goto L67;
        dumpHistory = true;
        i2 = i;
        dumpOp = dumpOp4;
        dumpAttributionTag = dumpAttributionTag4;
        dumpMode2 = dumpUid2;
        goto L89
    L67:
        if ("--include-discrete".equals(arg) == false) goto L78;
        int i5 = i + 1;
        if (i5 >= args.length) goto L70;
        int nDiscreteOps = Integer.valueOf(args[i5]).intValue();     // Catch: NumberFormatException -> L74
        dumpFilter2 = nDiscreteOps;
        i2 = i5;
        dumpUidStateChangeLogs2 = true;
        dumpOp = dumpOp4;
        dumpAttributionTag = dumpAttributionTag4;
        dumpMode2 = dumpUid2;
    L75:
        pw.println("Wrong parameter: " + args[i5]);
        return;
    L70:
        pw.println("No argument for --include-discrete option");
        return;
    L78:
        if ("--history".equals(arg) == false) goto L81;
        includeDiscreteOps = true;
        i2 = i;
        dumpOp = dumpOp4;
        dumpAttributionTag = dumpAttributionTag4;
        dumpMode2 = dumpUid2;
        goto L89
    L81:
        if (arg.length() <= 0) goto L87;
        if (arg.charAt(0) != '-') goto L87;
        pw.println("Unknown option: " + arg);
        return;
    L87:
        if ("--uid-state-changes".equals(arg) == false) goto L90;
        dumpUidStateChangeLogs = true;
        i2 = i;
        dumpOp = dumpOp4;
        dumpAttributionTag = dumpAttributionTag4;
        dumpMode2 = dumpUid2;
        goto L89
    L90:
        pw.println("Unknown command: " + arg);
        return;
    L12:
        r1.dumpHelp(pw);
        return;
    L92:
        String dumpAttributionTag6 = dumpAttributionTag;
        int dumpUid3 = dumpMode2;
        String dumpPackage = dumpAttributionTag2;
        int dumpUid4 = dumpMode;
        boolean dumpHistory2 = includeDiscreteOps;
        int dumpMode4 = dumpFilter;
        boolean dumpAll2 = dumpAll;
        int dumpFilter4 = dumpOp;
        String dumpPackage2 = dumpAttributionTag6;
        int dumpUid5 = dumpUid3;
        boolean dumpAll3 = dumpHistory;
        boolean includeDiscreteOps2 = dumpUidStateChangeLogs2;
        boolean dumpUidStateChangeLogs3 = dumpUidStateChangeLogs;
        int dumpUid6 = dumpFilter2;
    L94:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        monitor-enter(this);
        pw.println("Current AppOps Service state:");     // Catch: Throwable -> L530
        if (dumpHistory2 == true) goto L103;
        if (dumpAll3 == true) goto L103;
        r1.mConstants.dump(pw);     // Catch: Throwable -> L101
    L101:
        th = th;
    L543:
        monitor-exit(this);     // Catch: Throwable -> L534
        throw th;
    L534:
        th = th;
    L103:
        pw.println();     // Catch: Throwable -> L530
        long now = System.currentTimeMillis();     // Catch: Throwable -> L530
        long nowElapsed = SystemClock.elapsedRealtime();     // Catch: Throwable -> L530
        SystemClock.uptimeMillis();     // Catch: Throwable -> L530
        boolean needSep = false;
        if (dumpMode4 != 0) goto L116;
        if (dumpUid4 >= 0) goto L116;
        if (r1.mProfileOwners == null) goto L116;
        if (dumpAll3 == true) goto L116;
        if (dumpHistory2 == true) goto L116;
        pw.println("  Profile owners:");     // Catch: Throwable -> L101
        int poi = 0;
    L113:
        if (poi >= r1.mProfileOwners.size()) goto L115;
        pw.print("    User #");     // Catch: Throwable -> L101
        pw.print(r1.mProfileOwners.keyAt(poi));     // Catch: Throwable -> L101
        pw.print(": ");     // Catch: Throwable -> L101
        UserHandle.formatUid(pw, r1.mProfileOwners.valueAt(poi));     // Catch: Throwable -> L101
        pw.println();     // Catch: Throwable -> L101
        poi = poi + 1;     // Catch: Throwable -> L101
        goto L113
    L115:
        pw.println();     // Catch: Throwable -> L101
    L116:
        if (r1.mOpModeWatchers.size() <= 0) goto L155;
        if (dumpHistory2 == true) goto L155;
        boolean printedHeader = false;
        int i6 = 0;
    L120:
        boolean needSep2 = needSep;
    L152:
        th = th;
        goto L543
    L122:
        if (i6 >= r1.mOpModeWatchers.size()) goto L154;
        if (dumpFilter4 < 0) goto L127;
        if (dumpFilter4 == r1.mOpModeWatchers.keyAt(i6)) goto L127;
    L151:
        needSep = needSep2;
        i6 = i6 + 1;
        dumpPackage2 = dumpPackage2;
    L127:
        boolean printedOpHeader = false;
        ArraySet<OnOpModeChangedListener> callbacks = r1.mOpModeWatchers.valueAt(i6);     // Catch: Throwable -> L152
        int j = 0;
    L130:
        boolean printedHeader2 = printedHeader;
    L138:
        th = th;
        goto L543
    L132:
        if (j >= callbacks.size()) goto L150;
        OnOpModeChangedListener cb = callbacks.valueAt(j);     // Catch: Throwable -> L138
        if (dumpPackage == null) goto L140;
        ArraySet<OnOpModeChangedListener> callbacks2 = callbacks;
        if (dumpUid5 == UserHandle.getAppId(cb.getWatchingUid())) goto L141;
        printedHeader = printedHeader2;
    L149:
        j = j + 1;
        callbacks = callbacks2;
    L141:
        needSep2 = true;
        if (printedHeader2 == true) goto L145;
        pw.println("  Op mode watchers:");     // Catch: Throwable -> L138
        printedHeader2 = true;
    L145:
        if (printedOpHeader == true) goto L147;
        pw.print("    Op ");     // Catch: Throwable -> L138
        pw.print(AppOpsManager.opToName(r1.mOpModeWatchers.keyAt(i6)));     // Catch: Throwable -> L138
        pw.println(":");     // Catch: Throwable -> L138
        printedOpHeader = true;
    L147:
        pw.print("      #");     // Catch: Throwable -> L138
        pw.print(j);     // Catch: Throwable -> L138
        pw.print(": ");     // Catch: Throwable -> L138
        pw.println(cb);     // Catch: Throwable -> L138
        printedHeader = printedHeader2;
        goto L149
    L140:
        callbacks2 = callbacks;
        goto L141
    L150:
        printedHeader = printedHeader2;
        goto L151
    L154:
        String dumpAttributionTag7 = dumpPackage2;
        needSep = needSep2;
    L539:
    L528:
        th = th;
        goto L543
    L157:
        if (r1.mPackageModeWatchers.size() <= 0) goto L178;
        if (dumpFilter4 >= 0) goto L178;
        if (dumpHistory2 == true) goto L178;
        boolean printedHeader3 = false;
        int i7 = 0;
    L162:
        if (i7 >= r1.mPackageModeWatchers.size()) goto L178;
        if (dumpPackage == null) goto L168;
        if (dumpPackage.equals(r1.mPackageModeWatchers.keyAt(i7)) == true) goto L168;
    L176:
        i7 = i7 + 1;
    L168:
        if (printedHeader3 == true) goto L170;
        pw.println("  Package mode watchers:");     // Catch: Throwable -> L138
        printedHeader3 = true;
    L170:
        pw.print("    Pkg ");     // Catch: Throwable -> L138
        pw.print(r1.mPackageModeWatchers.keyAt(i7));     // Catch: Throwable -> L138
        pw.println(":");     // Catch: Throwable -> L138
        ArraySet<OnOpModeChangedListener> callbacks3 = r1.mPackageModeWatchers.valueAt(i7);     // Catch: Throwable -> L138
        int j2 = 0;
    L171:
        boolean printedHeader4 = printedHeader3;
        if (j2 >= callbacks3.size()) goto L175;
        pw.print("      #");     // Catch: Throwable -> L138
        pw.print(j2);     // Catch: Throwable -> L138
        pw.print(": ");     // Catch: Throwable -> L138
        pw.println(callbacks3.valueAt(j2));     // Catch: Throwable -> L138
        j2 = j2 + 1;
        printedHeader3 = printedHeader4;
        goto L171
    L175:
        printedHeader3 = printedHeader4;
        needSep = true;
    L178:
        if (r1.mModeWatchers.size() <= 0) goto L199;
        if (dumpFilter4 >= 0) goto L199;
        if (dumpHistory2 == true) goto L199;
        boolean printedHeader5 = false;
        int i8 = 0;
    L183:
        if (i8 >= r1.mModeWatchers.size()) goto L199;
        ModeCallback cb2 = r1.mModeWatchers.valueAt(i8);     // Catch: Throwable -> L138
        if (dumpPackage == null) goto L191;
        boolean needSep3 = needSep;
        if (dumpUid5 == UserHandle.getAppId(cb2.getWatchingUid())) goto L191;
        needSep = needSep3;
    L196:
        i8 = i8 + 1;
    L191:
        if (printedHeader5 == true) goto L194;
        pw.println("  All op mode watchers:");     // Catch: Throwable -> L138
        printedHeader5 = true;
    L194:
        pw.print("    ");     // Catch: Throwable -> L138
        pw.print(Integer.toHexString(System.identityHashCode(r1.mModeWatchers.keyAt(i8))));     // Catch: Throwable -> L138
        pw.print(": ");     // Catch: Throwable -> L138
        pw.println(cb2);     // Catch: Throwable -> L138
        needSep = true;
    L199:
        if (r1.mActiveWatchers.size() <= 0) goto L232;
        if (dumpUid4 >= 0) goto L232;
        needSep = true;
        boolean printedHeader6 = false;
        int watcherNum = 0;
    L203:
        if (watcherNum >= r1.mActiveWatchers.size()) goto L232;
        SparseArray<ActiveCallback> activeWatchers = r1.mActiveWatchers.valueAt(watcherNum);     // Catch: Throwable -> L138
        if (activeWatchers.size() > 0) goto L207;
        boolean needSep4 = needSep;
        boolean printedHeader7 = printedHeader6;
    L215:
        printedHeader6 = printedHeader7;
    L230:
        watcherNum = watcherNum + 1;
        needSep = needSep4;
        goto L203
    L207:
        printedHeader7 = printedHeader6;
        ActiveCallback cb3 = activeWatchers.valueAt(0);     // Catch: Throwable -> L138
        if (dumpFilter4 >= 0) goto L210;
    L212:
        if (dumpPackage == null) goto L216;
        needSep4 = needSep;
        if (dumpUid5 != UserHandle.getAppId(cb3.mWatchingUid)) goto L215;
    L217:
        if (printedHeader7 == true) goto L219;
        pw.println("  All op active watchers:");     // Catch: Throwable -> L138
        printedHeader7 = true;
    L219:
        pw.print("    ");     // Catch: Throwable -> L138
        pw.print(Integer.toHexString(System.identityHashCode(r1.mActiveWatchers.keyAt(watcherNum))));     // Catch: Throwable -> L138
        pw.println(" ->");     // Catch: Throwable -> L138
        pw.print("        [");     // Catch: Throwable -> L138
        int opCount = activeWatchers.size();     // Catch: Throwable -> L138
        int watcherNum2 = 0;
    L220:
        if (watcherNum2 >= opCount) goto L228;
        if (watcherNum2 <= 0) goto L224;
        pw.print(' ');     // Catch: Throwable -> L138
    L224:
        int opCount2 = activeWatchers.keyAt(watcherNum2);     // Catch: Throwable -> L138
        pw.print(AppOpsManager.opToName(opCount2));     // Catch: Throwable -> L138
        if (watcherNum2 >= (opCount - 1)) goto L227;
        pw.print(',');     // Catch: Throwable -> L138
    L227:
        watcherNum2 = watcherNum2 + 1;     // Catch: Throwable -> L138
        opCount = opCount;
        goto L220
    L228:
        pw.println("]");     // Catch: Throwable -> L138
        pw.print("        ");     // Catch: Throwable -> L138
        pw.println(cb3);     // Catch: Throwable -> L138
        printedHeader6 = printedHeader7;
        goto L230
    L216:
        needSep4 = needSep;
        goto L217
    L210:
        if (activeWatchers.indexOfKey(dumpFilter4) >= 0) goto L212;
        needSep4 = needSep;
    L232:
        if (r1.mStartedWatchers.size() <= 0) goto L274;
        if (dumpUid4 >= 0) goto L274;
        needSep = true;
        boolean printedHeader8 = false;
        int watchersSize = r1.mStartedWatchers.size();     // Catch: Throwable -> L271
        int watcherNum3 = 0;
    L237:
        if (watcherNum3 >= watchersSize) goto L273;
        boolean needSep5 = needSep;
        SparseArray<StartedCallback> startedWatchers = r1.mStartedWatchers.valueAt(watcherNum3);     // Catch: Throwable -> L271
        if (startedWatchers.size() > 0) goto L241;
        boolean printedHeader9 = printedHeader8;
        int watchersSize2 = watchersSize;
    L250:
        int dumpFilter5 = dumpMode4;
        printedHeader8 = printedHeader9;
    L270:
        watcherNum3 = watcherNum3 + 1;
        needSep = needSep5;
        watchersSize = watchersSize2;
        dumpMode4 = dumpFilter5;
        goto L237
    L241:
        printedHeader9 = printedHeader8;
        StartedCallback cb4 = startedWatchers.valueAt(0);     // Catch: Throwable -> L271
        if (dumpFilter4 < 0) goto L247;
        if (startedWatchers.indexOfKey(dumpFilter4) >= 0) goto L247;
        watchersSize2 = watchersSize;
    L247:
        if (dumpPackage == null) goto L251;
        watchersSize2 = watchersSize;
        int watchersSize3 = cb4.mWatchingUid;     // Catch: Throwable -> L138
        if (dumpUid5 != UserHandle.getAppId(watchersSize3)) goto L250;
    L252:
        if (printedHeader9 == true) goto L255;
        pw.println("  All op started watchers:");     // Catch: Throwable -> L138
        printedHeader9 = true;
    L255:
        pw.print("    ");     // Catch: Throwable -> L271
        pw.print(Integer.toHexString(System.identityHashCode(r1.mStartedWatchers.keyAt(watcherNum3))));     // Catch: Throwable -> L271
        pw.println(" ->");     // Catch: Throwable -> L271
        pw.print("        [");     // Catch: Throwable -> L271
        int opCount3 = startedWatchers.size();     // Catch: Throwable -> L271
        dumpFilter5 = dumpMode4;
        int dumpFilter6 = 0;
    L257:
        if (dumpFilter6 >= opCount3) goto L268;
        if (dumpFilter6 <= 0) goto L264;
        pw.print(' ');     // Catch: Throwable -> L261
    L261:
        th = th;
    L264:
        int opCount4 = startedWatchers.keyAt(dumpFilter6);     // Catch: Throwable -> L261
        pw.print(AppOpsManager.opToName(opCount4));     // Catch: Throwable -> L261
        if (dumpFilter6 >= (opCount3 - 1)) goto L267;
        pw.print(',');     // Catch: Throwable -> L261
    L267:
        dumpFilter6 = dumpFilter6 + 1;     // Catch: Throwable -> L261
        opCount3 = opCount3;
        goto L257
    L268:
        pw.println("]");     // Catch: Throwable -> L261
        pw.print("        ");     // Catch: Throwable -> L261
        pw.println(cb4);     // Catch: Throwable -> L261
        printedHeader8 = printedHeader9;
        goto L270
    L251:
        watchersSize2 = watchersSize;
        goto L252
    L273:
        dumpFilter5 = dumpMode4;
    L563:
    L526:
        th = th;
        goto L543
    L276:
        if (r1.mNotedWatchers.size() <= 0) goto L311;
        if (dumpUid4 >= 0) goto L311;
        needSep = true;
        boolean printedHeader10 = false;
        int watcherNum4 = 0;
    L280:
        if (watcherNum4 >= r1.mNotedWatchers.size()) goto L311;
        SparseArray<NotedCallback> notedWatchers = r1.mNotedWatchers.valueAt(watcherNum4);     // Catch: Throwable -> L261
        if (notedWatchers.size() > 0) goto L284;
        boolean needSep6 = needSep;
    L308:
        watcherNum4 = watcherNum4 + 1;
        needSep = needSep6;
        goto L280
    L284:
        NotedCallback cb5 = notedWatchers.valueAt(0);     // Catch: Throwable -> L261
        if (dumpFilter4 >= 0) goto L287;
    L289:
        if (dumpPackage == null) goto L293;
        NotedCallback cb6 = cb5;
        needSep6 = needSep;
        if (dumpUid5 != UserHandle.getAppId(cb6.mWatchingUid)) goto L308;
    L294:
        if (printedHeader10 == true) goto L296;
        pw.println("  All op noted watchers:");     // Catch: Throwable -> L261
        printedHeader10 = true;
    L296:
        pw.print("    ");     // Catch: Throwable -> L261
        pw.print(Integer.toHexString(System.identityHashCode(r1.mNotedWatchers.keyAt(watcherNum4))));     // Catch: Throwable -> L261
        pw.println(" ->");     // Catch: Throwable -> L261
        pw.print("        [");     // Catch: Throwable -> L261
        int opCount5 = notedWatchers.size();     // Catch: Throwable -> L261
        boolean printedHeader11 = printedHeader10;
        int opNum = 0;
    L297:
        if (opNum >= opCount5) goto L306;
        if (opNum <= 0) goto L301;
        pw.print(' ');     // Catch: Throwable -> L261
    L301:
        pw.print(AppOpsManager.opToName(notedWatchers.keyAt(opNum)));     // Catch: Throwable -> L261
        if (opNum >= (opCount5 - 1)) goto L305;
        pw.print(',');     // Catch: Throwable -> L261
    L305:
        opNum = opNum + 1;     // Catch: Throwable -> L261
        opCount5 = opCount5;
        goto L297
    L306:
        pw.println("]");     // Catch: Throwable -> L261
        pw.print("        ");     // Catch: Throwable -> L261
        pw.println(cb6);     // Catch: Throwable -> L261
        printedHeader10 = printedHeader11;
        goto L308
    L293:
        cb6 = cb5;
        needSep6 = needSep;
        goto L294
    L287:
        if (notedWatchers.indexOfKey(dumpFilter4) >= 0) goto L289;
        needSep6 = needSep;
    L311:
        if (r1.mAudioRestrictionManager.hasActiveRestrictions() == false) goto L323;
        if (dumpFilter4 >= 0) goto L323;
        if (dumpPackage == null) goto L323;
        if (dumpUid4 >= 0) goto L323;
        if (dumpAll3 == true) goto L323;
        if (r1.mAudioRestrictionManager.dump(pw) == true) goto L321;
        if (needSep == true) goto L321;
        boolean r3 = false;
    L322:
        needSep = r3;
    L321:
        r3 = true;
    L323:
        if (needSep == false) goto L325;
        pw.println();     // Catch: Throwable -> L261
    L325:
        int i9 = 0;
    L326:
        if (i9 >= r1.mUidStates.size()) goto L491;
        UidState uidState = r1.mUidStates.valueAt(i9);     // Catch: Throwable -> L489
        boolean needSep7 = needSep;
        SparseIntArray opModes = r1.mAppOpsCheckingService.getNonDefaultUidModes(uidState.uid, "default:0");     // Catch: Throwable -> L489
        ArrayMap<String, Ops> pkgOps = uidState.pkgOps;     // Catch: Throwable -> L489
        if (dumpAll3 == true) goto L486;
        if (dumpHistory2 == false) goto L332;
        int i10 = i9;
        int dumpUid7 = dumpUid5;
        sdf = sdf;
        now = now;
        Date date2 = date;
    L487:
        needSep = needSep7;
    L488:
        dumpAttributionTag7 = dumpAttributionTag7;
        dumpFilter5 = dumpFilter5;
        nowElapsed = nowElapsed;
        date = date2;
        dumpUid4 = dumpUid4;
        dumpUid5 = dumpUid7;
        sdf = sdf;
        i9 = i10 + 1;
        r1 = r1;
        now = now;
        goto L326
    L332:
        if (dumpFilter4 >= 0) goto L338;
        if (dumpPackage != null) goto L338;
        if (dumpUid4 >= 0) goto L338;
        i10 = i9;
        dumpUid7 = dumpUid5;
        Date date3 = date;
        sdf = sdf;
        now = now;
    L569:
        pw.print("  Uid ");     // Catch: Throwable -> L479
        UserHandle.formatUid(pw, uidState.uid);     // Catch: Throwable -> L479
        pw.println(":");     // Catch: Throwable -> L479
        long nowElapsed2 = nowElapsed;
        uidState.dump(pw, nowElapsed2);     // Catch: Throwable -> L479
        if (opModes != null) goto L567;
    L436:
        if (pkgOps != null) goto L438;
        r1 = r1;
        date2 = date3;
        dumpUid4 = dumpUid4;
        nowElapsed = nowElapsed2;
        dumpAttributionTag7 = dumpAttributionTag7;
        dumpFilter5 = dumpFilter5;
    L484:
        needSep = true;
        goto L488
    L438:
        int pkgi = 0;
    L440:
        if (pkgi >= pkgOps.size()) goto L483;
        Ops ops = pkgOps.valueAt(pkgi);     // Catch: Throwable -> L479
        if (dumpPackage != null) goto L444;
    L446:
        boolean printedPackage = false;
        int j3 = 0;
    L448:
        if (j3 >= ops.size()) goto L481;
        Op op = ops.valueAt(j3);     // Catch: Throwable -> L479
        SparseIntArray opModes2 = opModes;
        int opCode = op.op;     // Catch: Throwable -> L479
        if (dumpFilter4 < 0) goto L453;
        if (dumpFilter4 == opCode) goto L453;
        long nowElapsed3 = nowElapsed2;
        UidState uidState2 = uidState;
        ArrayMap<String, Ops> pkgOps2 = pkgOps;
    L457:
        Date date4 = date3;
        String dumpAttributionTag8 = dumpAttributionTag7;
        int dumpFilter7 = dumpFilter5;
        long nowElapsed4 = nowElapsed3;
    L476:
        j3 = j3 + 1;
        r1 = r1;
        pkgi = pkgi;
        dumpFilter5 = dumpFilter7;
        opModes = opModes2;
        ops = ops;
        pkgOps = pkgOps2;
        dumpAttributionTag7 = dumpAttributionTag8;
        nowElapsed2 = nowElapsed4;
        dumpUid4 = dumpUid4;
        uidState = uidState2;
        date3 = date4;
    L453:
        if (dumpUid4 < 0) goto L458;
        nowElapsed3 = nowElapsed2;
        uidState2 = uidState;
        pkgOps2 = pkgOps;
        if (dumpUid4 != r1.mAppOpsCheckingService.getPackageMode(op.packageName, op.op, UserHandle.getUserId(op.uid))) goto L457;
    L459:
        if (printedPackage == true) goto L462;
        pw.print("    Package ");     // Catch: Throwable -> L402
        pw.print(ops.packageName);     // Catch: Throwable -> L402
        pw.println(":");     // Catch: Throwable -> L402
        boolean printedPackage2 = true;
    L463:
        pw.print("      ");     // Catch: Throwable -> L479
        pw.print(AppOpsManager.opToName(opCode));     // Catch: Throwable -> L479
        pw.print(" (");     // Catch: Throwable -> L479
        pw.print(AppOpsManager.modeToName(r1.mAppOpsCheckingService.getPackageMode(op.packageName, op.op, UserHandle.getUserId(op.uid))));     // Catch: Throwable -> L479
        int switchOp = AppOpsManager.opToSwitch(opCode);     // Catch: Throwable -> L479
        if (switchOp == opCode) goto L472;
        pw.print(" / switch ");     // Catch: Throwable -> L402
        pw.print(AppOpsManager.opToName(switchOp));     // Catch: Throwable -> L402
        Op switchObj = ops.get(switchOp);     // Catch: Throwable -> L402
        if (switchObj != null) goto L468;
        int mode = AppOpsManager.opToDefaultMode(switchOp);     // Catch: Throwable -> L402
    L469:
        pw.print("=");     // Catch: Throwable -> L402
        pw.print(AppOpsManager.modeToName(mode));     // Catch: Throwable -> L402
        goto L472
    L468:
        mode = r1.mAppOpsCheckingService.getPackageMode(switchObj.packageName, switchObj.op, UserHandle.getUserId(switchObj.uid));     // Catch: Throwable -> L402
    L472:
        pw.println("): ");     // Catch: Throwable -> L479
        dumpFilter7 = dumpFilter5;
        Date date5 = date3;
        nowElapsed4 = nowElapsed3;
        dumpAttributionTag8 = dumpAttributionTag7;
        r1.dumpStatesLocked(pw, dumpAttributionTag8, dumpFilter7, nowElapsed4, op, now, sdf, date5, "        ");     // Catch: Throwable -> L477
        date4 = date5;
        printedPackage = printedPackage2;
    L477:
        th = th;
        goto L543
    L462:
        printedPackage2 = printedPackage;
        goto L463
    L458:
        nowElapsed3 = nowElapsed2;
        uidState2 = uidState;
        pkgOps2 = pkgOps;
        goto L459
    L481:
        SparseIntArray opModes3 = opModes;
        UidState uidState3 = uidState;
        ArrayMap<String, Ops> pkgOps3 = pkgOps;
        int pkgi2 = pkgi;
        Date date6 = date3;
        int dumpMode5 = dumpUid4;
        long nowElapsed5 = nowElapsed2;
        String dumpAttributionTag9 = dumpAttributionTag7;
        int dumpFilter8 = dumpFilter5;
        AppOpsService r11 = r1;
    L482:
        pkgi = pkgi2 + 1;
        dumpAttributionTag7 = dumpAttributionTag9;
        dumpFilter5 = dumpFilter8;
        nowElapsed2 = nowElapsed5;
        r1 = r11;
        opModes = opModes3;
        dumpUid4 = dumpMode5;
        uidState = uidState3;
        pkgOps = pkgOps3;
        date3 = date6;
        goto L440
    L444:
        if (dumpPackage.equals(ops.packageName) == true) goto L446;
        opModes3 = opModes;
        r11 = r1;
        uidState3 = uidState;
        pkgOps3 = pkgOps;
        pkgi2 = pkgi;
        date6 = date3;
        dumpMode5 = dumpUid4;
        nowElapsed5 = nowElapsed2;
        dumpAttributionTag9 = dumpAttributionTag7;
        dumpFilter8 = dumpFilter5;
        goto L482
    L483:
        r1 = r1;
        date2 = date3;
        dumpUid4 = dumpUid4;
        nowElapsed = nowElapsed2;
        dumpAttributionTag7 = dumpAttributionTag7;
        dumpFilter5 = dumpFilter5;
        goto L484
    L567:
        int opModeCount = opModes.size();     // Catch: Throwable -> L402
        int j4 = 0;
    L426:
        if (j4 >= opModeCount) goto L436;
        int code = opModes.keyAt(j4);     // Catch: Throwable -> L402
        int mode2 = opModes.valueAt(j4);     // Catch: Throwable -> L402
        if (dumpFilter4 < 0) goto L431;
        if (dumpFilter4 == code) goto L431;
    L435:
        j4 = j4 + 1;
    L431:
        if (dumpUid4 < 0) goto L434;
        if (dumpUid4 != mode2) goto L435;
    L434:
        pw.print("      ");     // Catch: Throwable -> L402
        pw.print(AppOpsManager.opToName(code));     // Catch: Throwable -> L402
        pw.print(": mode=");     // Catch: Throwable -> L402
        pw.println(AppOpsManager.modeToName(mode2));     // Catch: Throwable -> L402
    L402:
        th = th;
    L479:
        th = th;
    L338:
        if (dumpFilter4 < 0) goto L344;
        if (opModes == null) goto L343;
        if (opModes.indexOfKey(dumpFilter4) >= 0) goto L344;
    L343:
        boolean hasOp = false;
    L346:
        if (dumpPackage == null) goto L354;
        date3 = date;
        if (dumpUid5 == r1.mUidStates.keyAt(i9)) goto L355;
        boolean hasPackage = false;
    L357:
        if (dumpUid4 >= 0) goto L359;
        boolean hasMode = true;
    L360:
        if (hasMode == true) goto L374;
        if (opModes == null) goto L374;
        i10 = i9;
        int i11 = 0;
    L363:
        if (hasMode == true) goto L373;
        dumpUid7 = dumpUid5;
        int dumpUid8 = opModes.size();     // Catch: Throwable -> L371
        if (i11 >= dumpUid8) goto L375;
        if (opModes.valueAt(i11) != dumpUid4) goto L370;
        hasMode = true;
    L370:
        i11 = i11 + 1;
        dumpUid5 = dumpUid7;
    L375:
        if (pkgOps == null) goto L417;
        int pkgi3 = 0;
    L377:
        if (hasOp == false) goto L541;
        if (hasPackage == false) goto L541;
        if (hasMode == false) goto L541;
    L416:
        hasPackage = hasPackage;
    L418:
        if (hasOp == false) goto L485;
        if (hasPackage == false) goto L485;
        if (hasMode == true) goto L569;
        date2 = date3;
    L485:
        date2 = date3;
    L541:
    L404:
        th = th;
        goto L543
    L383:
        if (pkgi3 >= pkgOps.size()) goto L416;
        Ops ops2 = pkgOps.valueAt(pkgi3);     // Catch: Throwable -> L404
        if (hasOp == true) goto L390;
        if (ops2 == null) goto L390;
        if (ops2.indexOfKey(dumpFilter4) < 0) goto L390;
        hasOp = true;
    L390:
        if (hasMode == true) goto L408;
        int pkgi4 = pkgi3;
        int pkgi5 = 0;
    L392:
        if (hasMode == true) goto L407;
        boolean hasPackage2 = hasPackage;
        if (pkgi5 >= ops2.size()) goto L406;
        Op op2 = ops2.valueAt(pkgi5);     // Catch: Throwable -> L404
        int opi = pkgi5;
        boolean hasOp2 = hasOp;
        SimpleDateFormat sdf2 = sdf;
        long now2 = now;
        if (r1.mAppOpsCheckingService.getPackageMode(op2.packageName, op2.op, UserHandle.getUserId(op2.uid)) != dumpUid4) goto L401;
        hasMode = true;
    L401:
        pkgi5 = opi + 1;     // Catch: Throwable -> L402
        hasPackage = hasPackage2;
        hasOp = hasOp2;
        sdf = sdf2;
        now = now2;
        goto L392
    L406:
        boolean hasOp3 = hasOp;
        SimpleDateFormat sdf3 = sdf;
        long now3 = now;
    L409:
        if (hasPackage2 == false) goto L411;
    L413:
        hasPackage = hasPackage2;
    L414:
        pkgi3 = pkgi4 + 1;
        hasOp = hasOp3;
        sdf = sdf3;
        now = now3;
        goto L377
    L411:
        if (dumpPackage.equals(ops2.packageName) == false) goto L413;
        hasPackage = true;
        goto L414
    L407:
        hasPackage2 = hasPackage;
        hasOp3 = hasOp;
        sdf3 = sdf;
        now3 = now;
        goto L409
    L408:
        pkgi4 = pkgi3;
        hasPackage2 = hasPackage;
        hasOp3 = hasOp;
        sdf3 = sdf;
        now3 = now;
        goto L409
    L417:
        sdf = sdf;
        now = now;
    L371:
        th = th;
        goto L543
    L373:
        dumpUid7 = dumpUid5;
    L374:
        i10 = i9;
        dumpUid7 = dumpUid5;
        goto L375
    L359:
        hasMode = false;
    L355:
        hasPackage = true;
    L352:
        th = th;
        goto L543
    L354:
        date3 = date;
    L344:
        hasOp = true;
        goto L346
    L486:
        i10 = i9;
        dumpUid7 = dumpUid5;
        sdf = sdf;
        now = now;
        date2 = date;
    L489:
        th = th;
        goto L543
    L491:
        int dumpUid9 = dumpUid5;
        int dumpMode6 = dumpUid4;
        SimpleDateFormat sdf4 = sdf;
        String dumpAttributionTag10 = dumpAttributionTag7;
        int dumpFilter9 = dumpFilter5;
        AppOpsService r12 = r1;
        Date date7 = date;
        if (needSep == true) goto L536;
    L497:
        if (dumpMode6 >= 0) goto L502;
        if (dumpAll3 == true) goto L502;
        if (dumpHistory2 == true) goto L502;
        r16 = false;
    L502:
        boolean showUserRestrictions = r16;
        r12.mAppOpsRestrictions.dumpRestrictions(pw, dumpFilter4, dumpPackage, showUserRestrictions);     // Catch: Throwable -> L524
        if (dumpHistory2 == true) goto L512;
        if (dumpAll3 == true) goto L512;
        pw.println();     // Catch: Throwable -> L495
        if (CheckOpsDelegateDispatcher.m1762$$Nest$fgetmPolicy(r12.mCheckOpsDelegateDispatcher) != null) goto L509;
    L511:
        pw.println("  AppOps policy not set.");     // Catch: Throwable -> L495
        goto L512
    L509:
        if ((CheckOpsDelegateDispatcher.m1762$$Nest$fgetmPolicy(r12.mCheckOpsDelegateDispatcher) instanceof AppOpsPolicy) == false) goto L511;
        AppOpsPolicy policy = (AppOpsPolicy) CheckOpsDelegateDispatcher.m1762$$Nest$fgetmPolicy(r12.mCheckOpsDelegateDispatcher);     // Catch: Throwable -> L495
        policy.dumpTags(pw);     // Catch: Throwable -> L495
    L512:
        if (dumpAll2 == true) goto L514;
        if (dumpUidStateChangeLogs3 == true) goto L514;
    L515:
        monitor-exit(this);     // Catch: Throwable -> L524
        if (dumpHistory2 == false) goto L519;
        if (dumpAll3 == true) goto L519;
        int dumpOp5 = dumpFilter4;
        String dumpPackage3 = dumpPackage;
        r12.mHistoricalRegistry.dump("  ", pw, dumpUid9, dumpPackage3, dumpAttributionTag10, dumpOp5, dumpFilter9);
        String dumpPackage4 = dumpPackage3;
        String dumpAttributionTag11 = dumpAttributionTag10;
        dumpFilter9 = dumpFilter9;
    L520:
        if (includeDiscreteOps2 == false) goto L523;
        pw.println("Discrete accesses: ");
        int nDiscreteOps2 = dumpUid6;
        r12.mHistoricalRegistry.dumpDiscreteData(pw, dumpUid9, dumpPackage4, dumpAttributionTag11, dumpFilter9, dumpOp5, sdf4, date7, "  ", nDiscreteOps2);
        return;
    L523:
        return;
    L519:
        dumpAttributionTag11 = dumpAttributionTag10;
        dumpOp5 = dumpFilter4;
        dumpPackage4 = dumpPackage;
    L514:
        pw.println();     // Catch: Throwable -> L524
        pw.println("Uid State Changes Event Log:");     // Catch: Throwable -> L524
        r12.getUidStateTracker().dumpEvents(pw);     // Catch: Throwable -> L524
    L524:
        th = th;
        goto L543
    L536:
        pw.println();     // Catch: Throwable -> L495
    L495:
        th = th;
    L271:
        th = th;
    L274:
        dumpFilter5 = dumpMode4;
    L155:
        dumpAttributionTag7 = dumpPackage2;
    L530:
        th = th;
        goto L543
    L93:
        dumpPackage = null;
        dumpPackage2 = null;
        dumpUid5 = -1;
        dumpUid4 = -1;
        dumpAll3 = false;
        dumpHistory2 = false;
        includeDiscreteOps2 = false;
        dumpUidStateChangeLogs3 = false;
        dumpUid6 = 10;
        dumpMode4 = 0;
        dumpAll2 = false;
        dumpFilter4 = -1;
        goto L94
    }

    public void setUserRestrictions(Bundle restrictions, IBinder token, int userHandle) {
        checkSystemUid("setUserRestrictions");
        restrictions.getClass();
        token.getClass();
        int i = 0;
    L4:
        if (i >= 166) goto L11;
        String restriction = AppOpsManager.opToRestriction(i);
        if (restriction == null) goto L8;
        IBinder token2 = token;
        int userHandle2 = userHandle;
        setUserRestrictionNoCheck(i, restrictions.getBoolean(restriction, false), token2, userHandle2, null);
    L9:
        i = i + 1;
        token = token2;
        userHandle = userHandle2;
        goto L4
    L8:
        token2 = token;
        userHandle2 = userHandle;
        goto L9
    }

    public void setUserRestriction(int code, boolean restricted, IBinder token, int userHandle, PackageTagsList excludedPackageTags) {
        if (Binder.getCallingPid() == Process.myPid()) goto L6;
        this.mContext.enforcePermission("android.permission.MANAGE_APP_OPS_RESTRICTIONS", Binder.getCallingPid(), Binder.getCallingUid(), null);
    L6:
        if (userHandle != UserHandle.getCallingUserId()) goto L8;
    L14:
        verifyIncomingOp(code);
        token.getClass();
        setUserRestrictionNoCheck(code, restricted, token, userHandle, excludedPackageTags);
        return;
    L8:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) goto L14;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS") == 0) goto L14;
        throw new SecurityException("Need INTERACT_ACROSS_USERS_FULL or INTERACT_ACROSS_USERS to interact cross user ");
    }

    private void setUserRestrictionNoCheck(int code, boolean restricted, IBinder token, int userHandle, PackageTagsList excludedPackageTags) {
        monitor-enter(this);
        ClientUserRestrictionState restrictionState = this.mOpUserRestrictions.get(token);     // Catch: Throwable -> L8
        if (restrictionState != null) goto L14;
        restrictionState = new ClientUserRestrictionState(this, token);     // Catch: Throwable -> L8 RemoteException -> L10
        this.mOpUserRestrictions.put(token, restrictionState);     // Catch: Throwable -> L8
        goto L14
    L12:
        return;
    L14:
        if (restrictionState.setRestriction(code, restricted, excludedPackageTags, userHandle) == false) goto L17;
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda8(), this, Integer.valueOf(code), -2));     // Catch: Throwable -> L8
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda18(), this, Integer.valueOf(code), Boolean.valueOf(restricted), Integer.valueOf(userHandle)));     // Catch: Throwable -> L8
    L17:
        if (restrictionState.isDefault() == false) goto L19;
        this.mOpUserRestrictions.remove(token);     // Catch: Throwable -> L8
        restrictionState.destroy();     // Catch: Throwable -> L8
    L19:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void updateStartedOpModeForUserForDefaultDevice(int code, boolean restricted, int userId) {
        monitor-enter(this);
        int numUids = this.mUidStates.size();     // Catch: Throwable -> L10
        int uidNum = 0;
    L4:
        if (uidNum >= numUids) goto L15;
        int uid = this.mUidStates.keyAt(uidNum);     // Catch: Throwable -> L10
        if (userId != (-1)) goto L8;
    L12:
        updateStartedOpModeForUidForDefaultDeviceLocked(code, restricted, uid);     // Catch: Throwable -> L10
    L13:
        uidNum = uidNum + 1;     // Catch: Throwable -> L10
        goto L4
    L8:
        if (UserHandle.getUserId(uid) == userId) goto L12;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void updateStartedOpModeForUidForDefaultDeviceLocked(int code, boolean restricted, int uid) {
        AppOpsService r0 = this;
        int r1 = uid;
        UidState uidState = r0.mUidStates.get(r1);
        if (uidState != null) goto L5;
        return;
    L5:
        int numPkgOps = uidState.pkgOps.size();
        int pkgNum = 0;
    L6:
        if (pkgNum >= numPkgOps) goto L36;
        Ops ops = uidState.pkgOps.valueAt(pkgNum);
        if (ops == null) goto L10;
        int r2 = code;
        Op r3 = ops.get(r2);
    L11:
        Op op = r3;
        if (op == null) goto L34;
        int mode = r0.mAppOpsCheckingService.getPackageMode(op.packageName, op.op, UserHandle.getUserId(op.uid));
        if (mode != 0) goto L17;
    L19:
        ArrayMap<String, AttributedOp> defaultDeviceAttributedOps = op.mDeviceAttributedOps.get("default:0");
        int tagIndex = 0;
    L21:
        if (tagIndex >= defaultDeviceAttributedOps.size()) goto L34;
        AttributedOp attrOp = defaultDeviceAttributedOps.valueAt(tagIndex);
        if (restricted == false) goto L28;
        if (attrOp.isRunning() == false) goto L28;
        attrOp.pause();
    L33:
        tagIndex = tagIndex + 1;
        r0 = this;
        r2 = code;
        r1 = uid;
    L28:
        if (attrOp.isPaused() == false) goto L33;
        AppOpsManager.RestrictionBypass bypass = r0.verifyAndGetBypass(r1, ops.packageName, attrOp.tag).bypass;
        if (r0.isOpRestrictedLocked(r1, r2, ops.packageName, attrOp.tag, 0, bypass, false) == true) goto L33;
        attrOp.resume();
        goto L33
    L17:
        if (mode == 4) goto L19;
    L34:
        pkgNum = pkgNum + 1;
        r0 = this;
        r1 = uid;
        goto L6
    L10:
        r2 = code;
        r3 = null;
        goto L11
    }

    private void notifyWatchersOnDefaultDevice(int code, int uid) {
        monitor-enter(this);
        ArraySet<OnOpModeChangedListener> modeChangedListenerSet = this.mOpModeWatchers.get(code);     // Catch: Throwable -> L13
        if (modeChangedListenerSet == null) goto L23;
        ArraySet<OnOpModeChangedListener> modeChangedListenerSet2 = new ArraySet(modeChangedListenerSet);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        notifyOpChanged(modeChangedListenerSet2, code, uid, null, "default:0");
        return;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = th;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L17
        throw th;
    L17:
        th = th;
    L13:
        th = th;
        goto L21
    }

    public void removeUser(final int userHandle) throws RemoteException {
        checkSystemUid("removeUser");
        this.mHandler.postDelayed(new AppOpsService$$ExternalSyntheticLambda17(this, userHandle), REMOVE_USER_DELAY);
    }

    private /* synthetic */ void lambda$removeUser$12(int userHandle) {
        Slog.i(TAG, "Removing user " + userHandle + " from AppOpsService");
        monitor-enter(this);
        int tokenCount = this.mOpUserRestrictions.size();     // Catch: Throwable -> L7
        int i = tokenCount - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L9;
        ClientUserRestrictionState opRestrictions = this.mOpUserRestrictions.valueAt(i);     // Catch: Throwable -> L7
        opRestrictions.removeUser(userHandle);     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        removeUidsForUserLocked(userHandle);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isOperationActive(int code, int uid, String packageName) {
        if (Binder.getCallingUid() != uid) goto L5;
    L7:
        verifyIncomingOp(code);
        if (isIncomingPackageValid(packageName, UserHandle.getUserId(uid)) == true) goto L10;
        return false;
    L10:
        String resolvedPackageName = AppOpsManager.resolvePackageName(uid, packageName);
        if (resolvedPackageName != null) goto L13;
        return false;
    L13:
        monitor-enter(this);
        Ops pkgOps = getOpsLocked(uid, resolvedPackageName, null, false, null, false);     // Catch: Throwable -> L19
        if (pkgOps != null) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L19
        return false;
    L21:
        Op op = pkgOps.get(code);     // Catch: Throwable -> L19
        if (op != null) goto L25;
        monitor-exit(this);     // Catch: Throwable -> L19
        return false;
    L25:
        boolean r1 = op.isRunning();     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return r1;
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WATCH_APPOPS") == 0) goto L7;
        return false;
    }

    public boolean isProxying(int op, String proxyPackageName, String proxyAttributionTag, int proxiedUid, String proxiedPackageName) {
        proxyPackageName.getClass();
        proxiedPackageName.getClass();
        long callingUid = Binder.getCallingUid();
        long identity = Binder.clearCallingIdentity();
        List<AppOpsManager.PackageOps> packageOps = getOpsForPackage(proxiedUid, proxiedPackageName, new int[]{op});     // Catch: Throwable -> L37
        boolean r7 = false;
        if (packageOps == null) goto L44;
        if (packageOps.isEmpty() == true) goto L44;
        List<AppOpsManager.OpEntry> opEntries = packageOps.get(0).getOps();     // Catch: Throwable -> L37
        if (opEntries.isEmpty() == false) goto L14;
        Binder.restoreCallingIdentity(identity);
        return false;
    L14:
        AppOpsManager.OpEntry opEntry = opEntries.get(0);     // Catch: Throwable -> L37
        if (opEntry.isRunning() == true) goto L19;
        Binder.restoreCallingIdentity(identity);
        return false;
    L19:
        AppOpsManager.OpEventProxyInfo proxyInfo = opEntry.getLastProxyInfo(24);     // Catch: Throwable -> L37
        if (proxyInfo == null) goto L41;
        if (callingUid != proxyInfo.getUid()) goto L41;
    L34:
        th = th;
    L48:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L26:
        if (proxyPackageName.equals(proxyInfo.getPackageName()) == false) goto L41;
        if (Objects.equals(proxyAttributionTag, proxyInfo.getAttributionTag()) == false) goto L41;
        r7 = true;
    L32:
        th = th;
    L41:
        Binder.restoreCallingIdentity(identity);
        return r7;
    L44:
        Binder.restoreCallingIdentity(identity);
        return false;
    L37:
        th = th;
    L46:
        th = th;
        goto L48
    }

    public void resetPackageOpsNoHistory(String packageName) {
        resetPackageOpsNoHistory_enforcePermission();
        monitor-enter(this);
        int uid = this.mPackageManagerInternal.getPackageUid(packageName, 0, UserHandle.getCallingUserId());     // Catch: Throwable -> L8
        if (uid != (-1)) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        UidState uidState = this.mUidStates.get(uid);     // Catch: Throwable -> L8
        if (uidState != null) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L14:
        Ops removedOps = uidState.pkgOps.remove(packageName);     // Catch: Throwable -> L8
        this.mAppOpsCheckingService.removePackage(packageName, UserHandle.getUserId(uid));     // Catch: Throwable -> L8
        if (removedOps == null) goto L17;
        scheduleFastWriteLocked();     // Catch: Throwable -> L8
    L17:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void setHistoryParameters(int mode, long baseSnapshotInterval, int compressionStep) {
        setHistoryParameters_enforcePermission();
        this.mHistoricalRegistry.setHistoryParameters(mode, baseSnapshotInterval, compressionStep);
    }

    public void offsetHistory(long offsetMillis) {
        offsetHistory_enforcePermission();
        this.mHistoricalRegistry.offsetHistory(offsetMillis);
    }

    public void addHistoricalOps(AppOpsManager.HistoricalOps ops) {
        addHistoricalOps_enforcePermission();
        this.mHistoricalRegistry.addHistoricalOps(ops);
    }

    public void resetHistoryParameters() {
        resetHistoryParameters_enforcePermission();
        this.mHistoricalRegistry.resetHistoryParameters();
    }

    public void clearHistory() {
        clearHistory_enforcePermission();
        this.mHistoricalRegistry.clearAllHistory();
    }

    public void rebootHistory(long offlineDurationMillis) {
        rebootHistory_enforcePermission();
        if (offlineDurationMillis < 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2);
        this.mHistoricalRegistry.shutdown();
        if (offlineDurationMillis <= 0) goto L9;
        SystemClock.sleep(offlineDurationMillis);
    L9:
        this.mHistoricalRegistry = new LegacyHistoricalRegistry((LegacyHistoricalRegistry) this.mHistoricalRegistry);
        this.mHistoricalRegistry.systemReady(this.mContext.getContentResolver());
        this.mHistoricalRegistry.persistPendingHistory();
        return;
    L5:
        r2 = false;
        goto L6
    }

    public MessageSamplingConfig reportRuntimeAppOpAccessMessageAndGetConfig(String packageName, SyncNotedAppOp notedAppOp, String message) {
        int uid = Binder.getCallingUid();
        packageName.getClass();
        monitor-enter(this);
        switchPackageIfBootTimeOrRarelyUsedLocked(packageName);     // Catch: Throwable -> L19
        if (packageName.equals(this.mSampledPackage) == false) goto L25;
        notedAppOp.getClass();     // Catch: Throwable -> L19
        message.getClass();     // Catch: Throwable -> L19
        reportRuntimeAppOpAccessMessageInternalLocked(uid, packageName, AppOpsManager.strOpToOp(notedAppOp.getOp()), notedAppOp.getAttributionTag(), message);     // Catch: Throwable -> L17
        MessageSamplingConfig r10 = new MessageSamplingConfig(this.mSampledAppOpCode, this.mAcceptableLeftDistance, Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli());     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return r10;
    L25:
        MessageSamplingConfig r0 = new MessageSamplingConfig(-1, 0, Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli());     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r0;
    L10:
        th = th;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L17
        throw th;
    L17:
        th = th;
    L19:
        th = th;
        goto L21
    }

    private void reportRuntimeAppOpAccessMessageAsyncLocked(int uid, String packageName, int opCode, String attributionTag, String message) {
        switchPackageIfBootTimeOrRarelyUsedLocked(packageName);
        if (Objects.equals(this.mSampledPackage, packageName) == true) goto L5;
        return;
    L5:
        reportRuntimeAppOpAccessMessageInternalLocked(uid, packageName, opCode, attributionTag, message);
    }

    private void reportRuntimeAppOpAccessMessageInternalLocked(int uid, String packageName, int opCode, String attributionTag, String message) {
        int newLeftDistance = AppOpsManager.leftCircularDistance(opCode, this.mSampledAppOpCode, 166);
        if (this.mAcceptableLeftDistance >= newLeftDistance) goto L8;
        if (this.mSamplingStrategy == 4) goto L8;
        return;
    L8:
        if (this.mAcceptableLeftDistance > newLeftDistance) goto L10;
    L12:
        this.mMessagesCollectedCount += 1.0f;
        if (ThreadLocalRandom.current().nextFloat() > (1.0f / this.mMessagesCollectedCount)) goto L16;
        this.mCollectedRuntimePermissionMessage = new RuntimeAppOpAccessMessage(uid, opCode, packageName, attributionTag, message, this.mSamplingStrategy);
        return;
    L16:
        return;
    L10:
        if (this.mSamplingStrategy == 4) goto L12;
        this.mAcceptableLeftDistance = newLeftDistance;
        this.mMessagesCollectedCount = 0.0f;
        goto L12
    }

    public RuntimeAppOpAccessMessage collectRuntimeAppOpAccessMessage() {
        ActivityManagerInternal ami = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        boolean isCallerSystem = false;
        if (ami.getInstrumentationSourceUid(Binder.getCallingUid()) == (-1)) goto L5;
        boolean isCallerInstrumented = true;
    L7:
        if (Binder.getCallingPid() != Process.myPid()) goto L10;
        isCallerSystem = true;
    L10:
        if (isCallerSystem == true) goto L13;
        if (isCallerInstrumented == true) goto L13;
        return null;
    L13:
        this.mContext.enforcePermission("android.permission.GET_APP_OPS_STATS", Binder.getCallingPid(), Binder.getCallingUid(), null);
        monitor-enter(this);
        RuntimeAppOpAccessMessage result = this.mCollectedRuntimePermissionMessage;     // Catch: Throwable -> L19
        this.mCollectedRuntimePermissionMessage = null;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        this.mHandler.sendMessage(PooledLambda.obtainMessage(new AppOpsService$$ExternalSyntheticLambda15(), this));
        return result;
    L19:
        th = move-exception;
        throw th;
    L5:
        isCallerInstrumented = false;
        goto L7
    }

    private void switchPackageIfBootTimeOrRarelyUsedLocked(String packageName) {
        if (this.mSampledPackage != null) goto L8;
        if (ThreadLocalRandom.current().nextFloat() >= 0.5f) goto L13;
        this.mSamplingStrategy = 3;
        resampleAppOpForPackageLocked(packageName, true);
        return;
    L13:
        return;
    L8:
        if (this.mRarelyUsedPackages.contains(packageName) == false) goto L15;
        this.mRarelyUsedPackages.remove(packageName);
        if (ThreadLocalRandom.current().nextFloat() >= 0.5f) goto L16;
        this.mSamplingStrategy = 2;
        resampleAppOpForPackageLocked(packageName, true);
        return;
    L16:
        return;
    }

    private List<String> getPackageListAndResample() {
        List<String> packageNames = getPackageNamesForSampling();
        monitor-enter(this);
        resamplePackageAndAppOpLocked(packageNames);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return packageNames;
    L7:
        th = move-exception;
        throw th;
    }

    private void resamplePackageAndAppOpLocked(List<String> packageNames) {
        if (packageNames.isEmpty() == false) goto L5;
        return;
    L5:
        if (ThreadLocalRandom.current().nextFloat() >= 0.5f) goto L7;
        this.mSamplingStrategy = 1;
        resampleAppOpForPackageLocked(packageNames.get(ThreadLocalRandom.current().nextInt(packageNames.size())), true);
        return;
    L7:
        this.mSamplingStrategy = 4;
        resampleAppOpForPackageLocked(packageNames.get(ThreadLocalRandom.current().nextInt(packageNames.size())), false);
    }

    private void resampleAppOpForPackageLocked(String packageName, boolean pickOp) {
        this.mMessagesCollectedCount = 0.0f;
        if (pickOp == false) goto L5;
        int r0 = ThreadLocalRandom.current().nextInt(166);
    L6:
        this.mSampledAppOpCode = r0;
        this.mAcceptableLeftDistance = 165;
        this.mSampledPackage = packageName;
        return;
    L5:
        r0 = -1;
        goto L6
    }

    private void initializeRarelyUsedPackagesList(final ArraySet<String> candidates) {
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        List<String> runtimeAppOpsList = getRuntimeAppOpsList();
        AppOpsManager.HistoricalOpsRequest histOpsRequest = new AppOpsManager.HistoricalOpsRequest.Builder(Math.max(Instant.now().minus(7, ChronoUnit.DAYS).toEpochMilli(), 0), Long.MAX_VALUE).setOpNames(runtimeAppOpsList).setFlags(9).build();
        appOps.getHistoricalOps(histOpsRequest, AsyncTask.THREAD_POOL_EXECUTOR, new AnonymousClass10(this, candidates));
    }

    private List<String> getRuntimeAppOpsList() {
        ArrayList<String> result = new ArrayList();
        int i = 0;
    L4:
        if (i >= 166) goto L10;
        if (shouldCollectNotes(i) == false) goto L8;
        result.add(AppOpsManager.opToPublicName(i));
    L8:
        i = i + 1;
        goto L4
    L10:
        return result;
    }

    private List<String> getPackageNamesForSampling() {
        List<String> packageNames = new ArrayList();
        PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        PackageList packages = packageManagerInternal.getPackageList();
        Iterator<String> r8 = packages.getPackageNames().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        String packageName = r8.next();
        PackageInfo pkg = packageManagerInternal.getPackageInfo(packageName, 4096, Process.myUid(), this.mContext.getUserId());
        if (isSamplingTarget(pkg) == false) goto L4;
        packageNames.add(pkg.packageName);
        goto L4
    L9:
        return packageNames;
    }

    private boolean isSamplingTarget(PackageInfo pkg) {
        if (pkg != null) goto L5;
        return false;
    L5:
        String[] requestedPermissions = pkg.requestedPermissions;
        if (requestedPermissions != null) goto L8;
        return false;
    L8:
        int r2 = requestedPermissions.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L17;
        String permission = requestedPermissions[r3];
        PermissionInfo permissionInfo = this.mContext.getPackageManager().getPermissionInfo(permission, 0);     // Catch: PackageManager.NameNotFoundException -> L15
        if (permissionInfo.getProtection() != 1) goto L16;
        return true;
    L16:
        r3 = r3 + 1;
        goto L9
    L17:
        return false;
    }

    private void removeUidsForUserLocked(int userHandle) {
        int i = this.mUidStates.size() - 1;
    L3:
        if (i < 0) goto L9;
        int uid = this.mUidStates.keyAt(i);
        if (UserHandle.getUserId(uid) != userHandle) goto L7;
        this.mUidStates.valueAt(i).clear();
        this.mUidStates.removeAt(i);
    L7:
        i = i - 1;
        goto L3
    }

    private void checkSystemUid(String function) {
        int uid = Binder.getCallingUid();
        if (uid != 1000) goto L6;
        return;
    L6:
        throw new SecurityException(function + " must by called by the system");
    }

    private static int resolveNonAppUid(String packageName) {
        if (packageName != null) goto L6;
        return -1;
    L6:
        switch(packageName.hashCode()) {
            case -1336564963: goto L24;
            case -31178072: goto L21;
            case 3506402: goto L18;
            case 103772132: goto L15;
            case 109403696: goto L12;
            case 1344606873: goto L9;
            default: goto L26;
        };
    L26:
        byte r1 = -1;
    L27:
        switch(r1) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L29;
            default: goto L28;
        };
    L28:
        return -1;
    L29:
        return 1047;
    L31:
        return FrameworkStatsLog.ADVANCED_PROTECTION_SUPPORT_DIALOG_DISPLAYED;
    L33:
        return 1013;
    L35:
        return 2000;
    L37:
        return 0;
    L9:
        if (packageName.equals("audioserver") == false) goto L38;
        r1 = 4;
        goto L27
    L38:
        r1 = -1;
        goto L27
    L12:
        if (packageName.equals(DisassociationProcessor.REASON_SHELL) == false) goto L39;
        r1 = 1;
        goto L27
    L39:
        r1 = -1;
        goto L27
    L15:
        if (packageName.equals("media") == false) goto L40;
        r1 = 3;
        goto L27
    L40:
        r1 = -1;
        goto L27
    L18:
        if (packageName.equals("root") == false) goto L41;
        r1 = 0;
        goto L27
    L41:
        r1 = -1;
        goto L27
    L21:
        if (packageName.equals("cameraserver") == false) goto L42;
        r1 = 5;
        goto L27
    L42:
        r1 = -1;
        goto L27
    L24:
        if (packageName.equals("dumpstate") == false) goto L43;
        r1 = 2;
        goto L27
    L43:
        r1 = -1;
        goto L27
    }

    private static String[] getPackagesForUid(int uid) {
        String[] packageNames = null;
        if (AppGlobals.getPackageManager() != null) goto L11;
    L7:
        if (packageNames == null) goto L9;
        return packageNames;
    L9:
        return EmptyArray.STRING;
    L11:
        packageNames = AppGlobals.getPackageManager().getPackagesForUid(uid);     // Catch: RemoteException -> L6
        goto L7
    }

    private String getPersistentDeviceIdForOp(int virtualDeviceId, int op) {
        int virtualDeviceId2 = PermissionManager.resolveDeviceIdForPermissionCheck(this.mContext, virtualDeviceId, AppOpsManager.opToPermission(op));
        if (virtualDeviceId2 != 0) goto L6;
        return "default:0";
    L6:
        if (this.mVirtualDeviceManagerInternal != null) goto L8;
        return "default:0";
    L8:
        String persistentId = this.mVirtualDeviceManagerInternal.getPersistentIdForDevice(virtualDeviceId2);
        if (persistentId != null) goto L11;
        persistentId = this.mKnownDeviceIds.get(virtualDeviceId2);
    L11:
        if (persistentId == null) goto L14;
        return persistentId;
    L14:
        throw new IllegalStateException("Requested persistentId for invalid virtualDeviceId: " + virtualDeviceId2);
    }

    private int evaluateForegroundMode(int uid, int op, int rawUidMode) {
        return getUidStateTracker().evalMode(uid, op, rawUidMode);
    }

    private void writeNoteOps() {
        monitor-enter(this);
        this.mWriteNoteOpsScheduled = false;     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        File r0 = this.mNoteOpCallerStacktracesFile;
        monitor-enter(r0);
        FileWriter writer = new FileWriter(this.mNoteOpCallerStacktracesFile);     // Catch: Throwable -> L18 IOException -> L20
        int numTraces = this.mNoteOpCallerStacktraces.size();     // Catch: Throwable -> L13
        int i = 0;
    L10:
        if (i >= numTraces) goto L16;
        writer.write(this.mNoteOpCallerStacktraces.valueAt(i).asJson());     // Catch: Throwable -> L13
        writer.write(",");     // Catch: Throwable -> L13
        i = i + 1;
        goto L10
    L16:
        writer.close();     // Catch: Throwable -> L18 IOException -> L20
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L13:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L18 IOException -> L20
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L18 IOException -> L20
    L20:
        e = move-exception;
        Slog.w(TAG, "Failed to load opsValidation file for FileWriter", e);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L33:
        th = move-exception;
        throw th;
    }

    public void collectNoteOpCallsForValidation(String stackTrace, int op, String packageName, long version) {
    }

    private static /* synthetic */ void lambda$collectNoteOpCallsForValidation$14(final AppOpsService that) {
        AsyncTask.execute(new AppOpsService$$ExternalSyntheticLambda4(that));
    }

    private static /* synthetic */ void lambda$collectNoteOpCallsForValidation$13(AppOpsService that) {
        that.writeNoteOps();
    }

    private Handler getIoHandler() {
        return IoThread.getHandler();
    }

    public AppOpsServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IAppOpsServiceSmtEx getISmtEx() {
        return this.mSmtEx;
    }

    public IObricAppOpsService getObricExt() {
        return this.mObricExt;
    }
}
