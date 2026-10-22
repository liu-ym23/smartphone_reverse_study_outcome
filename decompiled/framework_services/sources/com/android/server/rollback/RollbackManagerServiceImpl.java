package com.android.server.rollback;

import android.app.AppOpsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.ModuleInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.VersionedPackage;
import android.content.pm.parsing.ApkLite;
import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.content.rollback.IRollbackManager;
import android.content.rollback.RollbackInfo;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.ext.SdkExtensions;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LongArrayQueue;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.PackageWatchdog;
import com.android.server.SystemConfig;
import com.android.server.Watchdog;
import com.android.server.pm.ApexManager;
import com.android.server.pm.Installer;
import com.android.server.pm.Settings;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class RollbackManagerServiceImpl extends IRollbackManager.Stub implements RollbackManagerInternal {
    private static final long DEFAULT_ROLLBACK_LIFETIME_DURATION_MILLIS = 0;
    private static final long HANDLER_THREAD_TIMEOUT_DURATION_MILLIS = 0;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "RollbackManager";
    private final SparseBooleanArray mAllocatedRollbackIds;
    private final AppDataRollbackHelper mAppDataRollbackHelper;
    private final Context mContext;
    private final Executor mExecutor;
    private final Handler mHandler;
    private final Installer mInstaller;
    private final RollbackPackageHealthObserver mPackageHealthObserver;
    private final PackageWatchdog mPackageWatchdog;
    private final Random mRandom;
    private long mRelativeBootTime;
    private long mRollbackLifetimeDurationInMillis;
    private final RollbackStore mRollbackStore;
    private final List<Rollback> mRollbacks;
    private final Runnable mRunExpiration;
    private final LongArrayQueue mSleepDuration;
    private final ArrayMap<Integer, Pair<Context, BroadcastReceiver>> mUserBroadcastReceivers;

    /* JADX INFO: renamed from: com.android.server.rollback.RollbackManagerServiceImpl$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ RollbackManagerServiceImpl this$0;

        public static /* synthetic */ void $r8$lambda$w1SaCw1HiMvduL71odZRdmEO1xY(AnonymousClass1 r0, int r1, int r2) {
            r0.lambda$onReceive$0(r1, r2);
        }

        AnonymousClass1(RollbackManagerServiceImpl this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RollbackManagerServiceImpl.m7982$$Nest$massertInWorkerThread(this.this$0);
            if ("android.intent.action.PACKAGE_ENABLE_ROLLBACK".equals(intent.getAction()) == false) goto L6;
            final int token = intent.getIntExtra(PackageManagerInternal.EXTRA_ENABLE_ROLLBACK_TOKEN, -1);
            final int sessionId = intent.getIntExtra(PackageManagerInternal.EXTRA_ENABLE_ROLLBACK_SESSION_ID, -1);
            RollbackManagerServiceImpl.m7991$$Nest$mqueueSleepIfNeeded(this.this$0);
            RollbackManagerServiceImpl.m7986$$Nest$mgetHandler(this.this$0).post(new RollbackManagerServiceImpl$1$$ExternalSyntheticLambda0(this, sessionId, token));
            return;
        }

        private /* synthetic */ void lambda$onReceive$0(int sessionId, int token) {
            RollbackManagerServiceImpl.m7982$$Nest$massertInWorkerThread(this.this$0);
            boolean success = RollbackManagerServiceImpl.m7985$$Nest$menableRollback(this.this$0, sessionId);
            int ret = 1;
            if (success == true) goto L5;
            ret = -1;
        L5:
            PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            pm.setEnableRollbackCode(token, ret);
        }
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    private @interface ExtThread {
    }

    private class SessionCallback extends PackageInstaller.SessionCallback {
        final /* synthetic */ RollbackManagerServiceImpl this$0;

        /* synthetic */ SessionCallback(RollbackManagerServiceImpl r1, RollbackManagerServiceImplIA r2) {
            this(r1);
        }

        private SessionCallback(RollbackManagerServiceImpl r1) {
            this.this$0 = r1;
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onCreated(int sessionId) {
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onBadgingChanged(int sessionId) {
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onActiveChanged(int sessionId, boolean active) {
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onProgressChanged(int sessionId, float progress) {
        }

        @Override // android.content.pm.PackageInstaller.SessionCallback
        public void onFinished(int sessionId, boolean success) {
            RollbackManagerServiceImpl.m7982$$Nest$massertInWorkerThread(this.this$0);
            if (RollbackManagerServiceImpl.m7994$$Nest$sfgetLOCAL_LOGV() == false) goto L5;
            Slog.v(RollbackManagerServiceImpl.TAG, "SessionCallback.onFinished id=" + sessionId + " success=" + success);
        L5:
            Rollback rollback = RollbackManagerServiceImpl.m7987$$Nest$mgetRollbackForSession(this.this$0, sessionId);
            if (rollback != null) goto L8;
            return;
        L8:
            if (rollback.isEnabling() == true) goto L10;
            return;
        L10:
            if (sessionId != rollback.getOriginalSessionId()) goto L25;
            if (success == true) goto L14;
            Slog.w(RollbackManagerServiceImpl.TAG, "Delete rollback id=" + rollback.info.getRollbackId() + " for failed session id=" + sessionId);
            RollbackManagerServiceImpl.m7980$$Nest$fgetmRollbacks(this.this$0).remove(rollback);
            RollbackManagerServiceImpl.m7984$$Nest$mdeleteRollback(this.this$0, rollback, "Session " + sessionId + " failed");
            return;
        L14:
            if (rollback.isStaged() == false) goto L16;
            return;
        L16:
            if (RollbackManagerServiceImpl.m7983$$Nest$mcompleteEnableRollback(this.this$0, rollback) == false) goto L22;
            RollbackManagerServiceImpl.m7988$$Nest$mmakeRollbackAvailable(this.this$0, rollback);
            return;
        L22:
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$2VvkTVIHdJRcNwfCsUuOnAVCSrg(RollbackManagerServiceImpl r0, String r1, int[] r2, int r3, String r4, int r5) {
        r0.lambda$snapshotAndRestoreUserData$12(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$5ba2COgc7nscJnHcl1QkhQ-HxvI, reason: not valid java name */
    public static /* synthetic */ void m7975$r8$lambda$5ba2COgc7nscJnHcl1QkhQHxvI(RollbackManagerServiceImpl r0, Context r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$5ePSTVmaLxSjKqVxrnrccgGY6zE(RollbackManagerServiceImpl r0) {
        r0.lambda$onBootCompleted$11();
    }

    public static /* synthetic */ void $r8$lambda$5tQXNWvAjaaDIurB7OaM0ZLLgkE(RollbackManagerServiceImpl r0, String r1) {
        r0.lambda$expireRollbackForPackage$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$6wVe4YeQyP1IYc6CkpY-4SEE9_Y, reason: not valid java name */
    public static /* synthetic */ void m7976$r8$lambda$6wVe4YeQyP1IYc6CkpY4SEE9_Y(RollbackManagerServiceImpl r0) {
        r0.runExpiration();
    }

    /* JADX INFO: renamed from: $r8$lambda$Cgtuf_5dagNRnyeqyJSt-SkgYrE, reason: not valid java name */
    public static /* synthetic */ void m7977$r8$lambda$Cgtuf_5dagNRnyeqyJStSkgYrE(RollbackManagerServiceImpl r0, DeviceConfig.Properties r1) {
        r0.lambda$onBootCompleted$10(r1);
    }

    public static /* synthetic */ ParceledListSlice $r8$lambda$E12yKais_ZT6UmD7C7ceevrZTo8(RollbackManagerServiceImpl r0) {
        return r0.lambda$getRecentlyCommittedRollbacks$2();
    }

    public static /* synthetic */ void $r8$lambda$KTFhNtgvTTaxZxgdCpFeRkq3kg8(RollbackManagerServiceImpl r0, long r1) {
        r0.lambda$blockRollbackManager$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$NEa1nlTnxZ3uHyw6aGoYzrCWL1A(RollbackManagerServiceImpl r0) {
        r0.lambda$reloadPersistedData$4();
    }

    public static /* synthetic */ Integer $r8$lambda$No8LDEgXeH4Ylci5VNWDDAvC_PE(RollbackManagerServiceImpl r0, int r1) {
        return r0.lambda$notifyStagedSession$13(r1);
    }

    public static /* synthetic */ void $r8$lambda$QUbd13KFyDqxIfT_YSz5yMAQQhY(RollbackManagerServiceImpl r0, IndentingPrintWriter r1) {
        r0.lambda$dump$14(r1);
    }

    public static /* synthetic */ ParceledListSlice $r8$lambda$bbfHD4WtP5OoGBOtkEzNdwF9g2M(RollbackManagerServiceImpl r0) {
        return r0.lambda$getAvailableRollbacks$1();
    }

    public static /* synthetic */ void $r8$lambda$cgsk1gEEkcqmJsC3ABW97j7UdiE(RollbackManagerServiceImpl r0, int r1, ParceledListSlice r2, String r3, IntentSender r4) {
        r0.lambda$commitRollback$3(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$fQDZo-8mYW8tPdxnapF0CQgGj4w, reason: not valid java name */
    public static /* synthetic */ void m7978$r8$lambda$fQDZo8mYW8tPdxnapF0CQgGj4w(RollbackManagerServiceImpl r0, int r1) {
        r0.lambda$onUnlockUser$8(r1);
    }

    public static /* synthetic */ void $r8$lambda$l0jOsI4D4tsO9tHi89vVcHGslz8(RollbackManagerServiceImpl r0, int r1) {
        r0.lambda$onUnlockUser$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$tEQRYHZBUl3VS0VAYgHVFKMsLXg(RollbackManagerServiceImpl r0, long r1) {
        r0.lambda$queueSleepIfNeeded$7(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRelativeBootTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7979$$Nest$fgetmRelativeBootTime(RollbackManagerServiceImpl r2) {
        return r2.mRelativeBootTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRollbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m7980$$Nest$fgetmRollbacks(RollbackManagerServiceImpl r0) {
        return r0.mRollbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRelativeBootTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7981$$Nest$fputmRelativeBootTime(RollbackManagerServiceImpl r0, long r1) {
        r0.mRelativeBootTime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$massertInWorkerThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7982$$Nest$massertInWorkerThread(RollbackManagerServiceImpl r0) {
        r0.assertInWorkerThread();
    }

    /* JADX INFO: renamed from: -$$Nest$mcompleteEnableRollback, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7983$$Nest$mcompleteEnableRollback(RollbackManagerServiceImpl r0, Rollback r1) {
        return r0.completeEnableRollback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdeleteRollback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7984$$Nest$mdeleteRollback(RollbackManagerServiceImpl r0, Rollback r1, String r2) {
        r0.deleteRollback(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$menableRollback, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7985$$Nest$menableRollback(RollbackManagerServiceImpl r0, int r1) {
        return r0.enableRollback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7986$$Nest$mgetHandler(RollbackManagerServiceImpl r0) {
        return r0.getHandler();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRollbackForSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ Rollback m7987$$Nest$mgetRollbackForSession(RollbackManagerServiceImpl r0, int r1) {
        return r0.getRollbackForSession(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mmakeRollbackAvailable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7988$$Nest$mmakeRollbackAvailable(RollbackManagerServiceImpl r0, Rollback r1) {
        r0.makeRollbackAvailable(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageFullyRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7989$$Nest$monPackageFullyRemoved(RollbackManagerServiceImpl r0, String r1) {
        r0.onPackageFullyRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageReplaced, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7990$$Nest$monPackageReplaced(RollbackManagerServiceImpl r0, String r1) {
        r0.onPackageReplaced(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mqueueSleepIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7991$$Nest$mqueueSleepIfNeeded(RollbackManagerServiceImpl r0) {
        r0.queueSleepIfNeeded();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterUserCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7992$$Nest$mregisterUserCallbacks(RollbackManagerServiceImpl r0, UserHandle r1) {
        r0.registerUserCallbacks(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterUserCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7993$$Nest$munregisterUserCallbacks(RollbackManagerServiceImpl r0, UserHandle r1) {
        r0.unregisterUserCallbacks(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOCAL_LOGV, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7994$$Nest$sfgetLOCAL_LOGV() {
        return LOCAL_LOGV;
    }

    /* JADX INFO: renamed from: -$$Nest$smcalculateRelativeBootTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7995$$Nest$smcalculateRelativeBootTime() {
        return calculateRelativeBootTime();
    }

    static {
        LOCAL_LOGV = Log.isLoggable(TAG, 2);
        DEFAULT_ROLLBACK_LIFETIME_DURATION_MILLIS = TimeUnit.DAYS.toMillis(14);
        HANDLER_THREAD_TIMEOUT_DURATION_MILLIS = TimeUnit.MINUTES.toMillis(10);
    }

    RollbackManagerServiceImpl(final Context context) {
        this.mRollbackLifetimeDurationInMillis = DEFAULT_ROLLBACK_LIFETIME_DURATION_MILLIS;
        this.mRandom = new SecureRandom();
        this.mAllocatedRollbackIds = new SparseBooleanArray();
        this.mRollbacks = new ArrayList();
        this.mRunExpiration = new RollbackManagerServiceImpl$$ExternalSyntheticLambda7(this);
        this.mSleepDuration = new LongArrayQueue();
        this.mRelativeBootTime = calculateRelativeBootTime();
        this.mContext = context;
        this.mInstaller = new Installer(this.mContext);
        this.mInstaller.onStart();
        this.mRollbackStore = new RollbackStore(new File(Environment.getDataDirectory(), "rollback"), new File(Environment.getDataDirectory(), "rollback-history"));
        this.mPackageHealthObserver = new RollbackPackageHealthObserver(this.mContext);
        this.mAppDataRollbackHelper = new AppDataRollbackHelper(this.mInstaller);
        this.mPackageWatchdog = PackageWatchdog.getInstance(this.mContext);
        HandlerThread handlerThread = new HandlerThread("RollbackManagerServiceHandler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        Watchdog.getInstance().addThread(getHandler(), HANDLER_THREAD_TIMEOUT_DURATION_MILLIS);
        this.mExecutor = new HandlerExecutor(getHandler());
        getHandler().post(new RollbackManagerServiceImpl$$ExternalSyntheticLambda8(this, context));
        this.mUserBroadcastReceivers = new ArrayMap();
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        Iterator r2 = userManager.getUserHandles(true).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        UserHandle user = (UserHandle) r2.next();
        registerUserCallbacks(user);
        goto L4
    L6:
        IntentFilter enableRollbackFilter = new IntentFilter();
        enableRollbackFilter.addAction("android.intent.action.PACKAGE_ENABLE_ROLLBACK");
        enableRollbackFilter.addDataType("application/vnd.android.package-archive");     // Catch: IntentFilter.MalformedMimeTypeException -> L9
    L11:
        this.mContext.registerReceiver(new AnonymousClass1(this), enableRollbackFilter, null, getHandler());
        IntentFilter enableRollbackTimedOutFilter = new IntentFilter();
        enableRollbackTimedOutFilter.addAction("android.intent.action.CANCEL_ENABLE_ROLLBACK");
        this.mContext.registerReceiver(new AnonymousClass2(this), enableRollbackTimedOutFilter, null, getHandler());
        IntentFilter userIntentFilter = new IntentFilter();
        userIntentFilter.addAction("android.intent.action.USER_ADDED");
        userIntentFilter.addAction("android.intent.action.USER_REMOVED");
        this.mContext.registerReceiver(new AnonymousClass3(this), userIntentFilter, null, getHandler());
        registerTimeChangeReceiver();
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "addDataType", e);
        goto L11
    }

    private /* synthetic */ void lambda$new$0(Context context) {
        this.mRollbacks.addAll(this.mRollbackStore.loadRollbacks());
        if (context.getPackageManager().isDeviceUpgrading() == true) goto L9;
        Iterator<Rollback> r0 = this.mRollbacks.iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        Rollback rollback = r0.next();
        this.mAllocatedRollbackIds.put(rollback.info.getRollbackId(), true);
        goto L6
    L17:
        return;
    L9:
        Iterator<Rollback> r1 = this.mRollbacks.iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        Rollback rollback2 = r1.next();
        deleteRollback(rollback2, "Fingerprint changed");
        goto L11
    L13:
        this.mRollbacks.clear();
    }

    private <U> U awaitResult(Supplier<U> r3) {
        assertNotInWorkerThread();
        return (U) CompletableFuture.supplyAsync(r3, this.mExecutor).get();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void awaitResult(Runnable runnable) {
        assertNotInWorkerThread();
        CompletableFuture.runAsync(runnable, this.mExecutor).get();     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void assertInWorkerThread() {
        Preconditions.checkState(getHandler().getLooper().isCurrentThread());
    }

    private void assertNotInWorkerThread() {
        Preconditions.checkState(!getHandler().getLooper().isCurrentThread());
    }

    private void registerUserCallbacks(UserHandle user) {
        Context context = getContextAsUser(user);
        if (context != null) goto L6;
        Slog.e(TAG, "Unable to register user callbacks for user " + user);
        return;
    L6:
        context.getPackageManager().getPackageInstaller().registerSessionCallback(new SessionCallback(this, null), getHandler());
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_REPLACED");
        filter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        BroadcastReceiver receiver = new AnonymousClass4(this);
        context.registerReceiver(receiver, filter, null, getHandler());
        this.mUserBroadcastReceivers.put(Integer.valueOf(user.getIdentifier()), new Pair(context, receiver));
    }

    private void unregisterUserCallbacks(UserHandle user) {
        Pair<Context, BroadcastReceiver> pair = this.mUserBroadcastReceivers.get(Integer.valueOf(user.getIdentifier()));
        if (pair != null) goto L5;
    L11:
        Slog.e(TAG, "No receiver found for the user" + user);
        return;
    L5:
        if (pair.first == null) goto L11;
        if (pair.second == null) goto L11;
        ((Context) pair.first).unregisterReceiver((BroadcastReceiver) pair.second);
        this.mUserBroadcastReceivers.remove(Integer.valueOf(user.getIdentifier()));
    }

    public ParceledListSlice getAvailableRollbacks() {
        assertNotInWorkerThread();
        enforceManageRollbacks("getAvailableRollbacks");
        return (ParceledListSlice) awaitResult(new RollbackManagerServiceImpl$$ExternalSyntheticLambda13(this));
    }

    private /* synthetic */ ParceledListSlice lambda$getAvailableRollbacks$1() {
        assertInWorkerThread();
        List<RollbackInfo> rollbacks = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mRollbacks.size()) goto L10;
        Rollback rollback = this.mRollbacks.get(i);
        if (rollback.isAvailable() == false) goto L8;
        rollbacks.add(rollback.info);
    L8:
        i = i + 1;
        goto L4
    L10:
        return new ParceledListSlice(rollbacks);
    }

    public ParceledListSlice<RollbackInfo> getRecentlyCommittedRollbacks() {
        assertNotInWorkerThread();
        enforceManageRollbacks("getRecentlyCommittedRollbacks");
        return (ParceledListSlice) awaitResult(new RollbackManagerServiceImpl$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ ParceledListSlice lambda$getRecentlyCommittedRollbacks$2() {
        assertInWorkerThread();
        List<RollbackInfo> rollbacks = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mRollbacks.size()) goto L10;
        Rollback rollback = this.mRollbacks.get(i);
        if (rollback.isCommitted() == false) goto L8;
        rollbacks.add(rollback.info);
    L8:
        i = i + 1;
        goto L4
    L10:
        return new ParceledListSlice(rollbacks);
    }

    public void commitRollback(final int rollbackId, final ParceledListSlice causePackages, final String callerPackageName, final IntentSender statusReceiver) {
        assertNotInWorkerThread();
        enforceManageRollbacks("commitRollback");
        int callingUid = Binder.getCallingUid();
        AppOpsManager appOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        appOps.checkPackage(callingUid, callerPackageName);
        getHandler().post(new RollbackManagerServiceImpl$$ExternalSyntheticLambda12(this, rollbackId, causePackages, callerPackageName, statusReceiver));
    }

    private /* synthetic */ void lambda$commitRollback$3(int rollbackId, ParceledListSlice causePackages, String callerPackageName, IntentSender statusReceiver) {
        commitRollbackInternal(rollbackId, causePackages.getList(), callerPackageName, statusReceiver);
    }

    private void registerTimeChangeReceiver() {
        BroadcastReceiver timeChangeIntentReceiver = new AnonymousClass5(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.TIME_SET");
        this.mContext.registerReceiver(timeChangeIntentReceiver, filter, null, getHandler());
    }

    private static long calculateRelativeBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private void commitRollbackInternal(int rollbackId, List<VersionedPackage> causePackages, String callerPackageName, IntentSender statusReceiver) {
        assertInWorkerThread();
        Slog.i(TAG, "commitRollback id=" + rollbackId + " caller=" + callerPackageName);
        Rollback rollback = getRollbackForId(rollbackId);
        if (rollback != null) goto L6;
        sendFailure(this.mContext, statusReceiver, 2, "Rollback unavailable");
        return;
    L6:
        rollback.commit(this.mContext, causePackages, callerPackageName, statusReceiver);
    }

    public void reloadPersistedData() {
        assertNotInWorkerThread();
        this.mContext.enforceCallingOrSelfPermission("android.permission.TEST_MANAGE_ROLLBACKS", "reloadPersistedData");
        awaitResult(new RollbackManagerServiceImpl$$ExternalSyntheticLambda11(this));
    }

    private /* synthetic */ void lambda$reloadPersistedData$4() {
        assertInWorkerThread();
        this.mRollbacks.clear();
        this.mRollbacks.addAll(this.mRollbackStore.loadRollbacks());
    }

    private void expireRollbackForPackageInternal(String packageName, String reason) {
        assertInWorkerThread();
        Iterator<Rollback> iter = this.mRollbacks.iterator();
    L4:
        if (iter.hasNext() == false) goto L9;
        Rollback rollback = iter.next();
        if (rollback.includesPackage(packageName) == false) goto L4;
        iter.remove();
        deleteRollback(rollback, reason);
        goto L4
    }

    public void expireRollbackForPackage(final String packageName) {
        assertNotInWorkerThread();
        this.mContext.enforceCallingOrSelfPermission("android.permission.TEST_MANAGE_ROLLBACKS", "expireRollbackForPackage");
        awaitResult(new RollbackManagerServiceImpl$$ExternalSyntheticLambda3(this, packageName));
    }

    private /* synthetic */ void lambda$expireRollbackForPackage$5(String packageName) {
        expireRollbackForPackageInternal(packageName, "Expired by API");
    }

    public void blockRollbackManager(final long millis) {
        assertNotInWorkerThread();
        this.mContext.enforceCallingOrSelfPermission("android.permission.TEST_MANAGE_ROLLBACKS", "blockRollbackManager");
        getHandler().post(new RollbackManagerServiceImpl$$ExternalSyntheticLambda9(this, millis));
    }

    private /* synthetic */ void lambda$blockRollbackManager$6(long millis) {
        assertInWorkerThread();
        this.mSleepDuration.addLast(millis);
    }

    private void queueSleepIfNeeded() {
        assertInWorkerThread();
        if (this.mSleepDuration.size() != 0) goto L5;
        return;
    L5:
        final long millis = this.mSleepDuration.removeFirst();
        if (millis > 0) goto L8;
        return;
    L8:
        getHandler().post(new RollbackManagerServiceImpl$$ExternalSyntheticLambda10(this, millis));
    }

    private /* synthetic */ void lambda$queueSleepIfNeeded$7(long millis) {
        assertInWorkerThread();
        Thread.sleep(millis);     // Catch: InterruptedException -> L5
        return;
    L7:
        throw new IllegalStateException("RollbackManagerHandlerThread interrupted");
    }

    void onUnlockUser(final int userId) {
        assertNotInWorkerThread();
        if (LOCAL_LOGV == false) goto L5;
        Slog.v(TAG, "onUnlockUser id=" + userId);
    L5:
        awaitResult(new RollbackManagerServiceImpl$$ExternalSyntheticLambda0(this, userId));
        getHandler().post(new RollbackManagerServiceImpl$$ExternalSyntheticLambda1(this, userId));
    }

    private /* synthetic */ void lambda$onUnlockUser$8(int userId) {
        assertInWorkerThread();
        List<Rollback> rollbacks = new ArrayList(this.mRollbacks);
        int i = 0;
    L4:
        if (i >= rollbacks.size()) goto L7;
        Rollback rollback = rollbacks.get(i);
        rollback.commitPendingBackupAndRestoreForUser(userId, this.mAppDataRollbackHelper);
        i = i + 1;
        goto L4
    }

    private /* synthetic */ void lambda$onUnlockUser$9(int userId) {
        destroyCeSnapshotsForExpiredRollbacks(userId);
    }

    private void destroyCeSnapshotsForExpiredRollbacks(int userId) {
        int[] rollbackIds = new int[this.mRollbacks.size()];
        int i = 0;
    L4:
        if (i >= rollbackIds.length) goto L6;
        rollbackIds[i] = this.mRollbacks.get(i).info.getRollbackId();
        i = i + 1;
        goto L4
    L6:
        ApexManager.getInstance().destroyCeSnapshotsNotSpecified(userId, rollbackIds);
        this.mInstaller.destroyCeSnapshotsNotSpecified(userId, rollbackIds);     // Catch: Installer.InstallerException -> L9
        return;
    L9:
        ie = move-exception;
        Slog.e(TAG, "Failed to delete snapshots for user: " + userId, ie);
    }

    private void updateRollbackLifetimeDurationInMillis() {
        assertInWorkerThread();
        this.mRollbackLifetimeDurationInMillis = DeviceConfig.getLong("rollback_boot", "rollback_lifetime_in_millis", DEFAULT_ROLLBACK_LIFETIME_DURATION_MILLIS);
        if (this.mRollbackLifetimeDurationInMillis >= 0) goto L5;
        this.mRollbackLifetimeDurationInMillis = DEFAULT_ROLLBACK_LIFETIME_DURATION_MILLIS;
    L5:
        Slog.d(TAG, "mRollbackLifetimeDurationInMillis=" + this.mRollbackLifetimeDurationInMillis);
        runExpiration();
    }

    void onBootCompleted() {
        DeviceConfig.addOnPropertiesChangedListener("rollback_boot", this.mExecutor, new RollbackManagerServiceImpl$$ExternalSyntheticLambda14(this));
        getHandler().post(new RollbackManagerServiceImpl$$ExternalSyntheticLambda15(this));
    }

    private /* synthetic */ void lambda$onBootCompleted$10(DeviceConfig.Properties properties) {
        updateRollbackLifetimeDurationInMillis();
    }

    private /* synthetic */ void lambda$onBootCompleted$11() {
        assertInWorkerThread();
        updateRollbackLifetimeDurationInMillis();
        runExpiration();
        List<Rollback> enabling = new ArrayList();
        List<Rollback> restoreInProgress = new ArrayList();
        Set<String> apexPackageNames = new HashSet();
        Iterator<Rollback> iter = this.mRollbacks.iterator();
    L4:
        if (iter.hasNext() == false) goto L25;
        Rollback rollback = iter.next();
        if (rollback.isStaged() == false) goto L4;
        PackageInstaller.SessionInfo session = this.mContext.getPackageManager().getPackageInstaller().getSessionInfo(rollback.getOriginalSessionId());
        if (session == null) goto L23;
        if (session.isStagedSessionFailed() == true) goto L23;
        if (session.isStagedSessionApplied() == true) goto L16;
    L21:
        apexPackageNames.addAll(rollback.getApexPackageNames());
        goto L4
    L16:
        if (rollback.isEnabling() == false) goto L19;
        enabling.add(rollback);
        goto L21
    L19:
        if (rollback.isRestoreUserDataInProgress() == false) goto L21;
        restoreInProgress.add(rollback);
    L23:
        if (rollback.isEnabling() == false) goto L4;
        iter.remove();
        deleteRollback(rollback, "Session " + rollback.getOriginalSessionId() + " not existed or failed");
        goto L4
    L25:
        Iterator<Rollback> r4 = enabling.iterator();
    L27:
        if (r4.hasNext() == false) goto L29;
        Rollback rollback2 = r4.next();
        makeRollbackAvailable(rollback2);
        goto L27
    L29:
        Iterator<Rollback> r5 = restoreInProgress.iterator();
    L31:
        if (r5.hasNext() == false) goto L33;
        Rollback rollback3 = r5.next();
        rollback3.setRestoreUserDataInProgress(false);
        goto L31
    L33:
        Iterator<String> r6 = apexPackageNames.iterator();
    L35:
        if (r6.hasNext() == false) goto L37;
        String apexPackageName = r6.next();
        onPackageReplaced(apexPackageName);
        goto L35
    L37:
        this.mPackageHealthObserver.onBootCompletedAsync();
    }

    private void onPackageReplaced(String packageName) {
        assertInWorkerThread();
        long installedVersion = getInstalledPackageVersion(packageName);
        Iterator<Rollback> iter = this.mRollbacks.iterator();
    L4:
        if (iter.hasNext() == false) goto L11;
        Rollback rollback = iter.next();
        if (rollback.isAvailable() == false) goto L4;
        if (rollback.includesPackageWithDifferentVersion(packageName, installedVersion) == false) goto L4;
        iter.remove();
        deleteRollback(rollback, "Package " + packageName + " replaced");
        goto L4
    }

    private void onPackageFullyRemoved(String packageName) {
        assertInWorkerThread();
        expireRollbackForPackageInternal(packageName, "Package " + packageName + " removed");
    }

    static void sendFailure(Context context, IntentSender statusReceiver, int status, String message) {
        Slog.e(TAG, message);
        Intent fillIn = new Intent();     // Catch: IntentSender.SendIntentException -> L9
        fillIn.putExtra("android.content.rollback.extra.STATUS", status);     // Catch: IntentSender.SendIntentException -> L9
        fillIn.putExtra("android.content.rollback.extra.STATUS_MESSAGE", message);     // Catch: IntentSender.SendIntentException -> L9
        statusReceiver.sendIntent(context, 0, fillIn, null, null);     // Catch: IntentSender.SendIntentException -> L7
        return;
    L17:
        return;
    }

    private void runExpiration() {
        runExpirationCustomRollbackLifetime();
    }

    private void runExpirationDefaultRollbackLifetime() {
        getHandler().removeCallbacks(this.mRunExpiration);
        assertInWorkerThread();
        Instant now = Instant.now();
        Instant oldest = null;
        Iterator<Rollback> iter = this.mRollbacks.iterator();
    L4:
        if (iter.hasNext() == false) goto L18;
        Rollback rollback = iter.next();
        if (rollback.isAvailable() == true) goto L10;
        if (rollback.isCommitted() == false) goto L4;
    L10:
        Instant rollbackTimestamp = rollback.getTimestamp();
        if (now.isBefore(rollbackTimestamp.plusMillis(this.mRollbackLifetimeDurationInMillis)) == false) goto L12;
        if (oldest == null) goto L16;
        if (oldest.isAfter(rollbackTimestamp) == false) goto L4;
    L16:
        oldest = rollbackTimestamp;
        goto L4
    L12:
        Slog.i(TAG, "runExpiration id=" + rollback.info.getRollbackId());
        iter.remove();
        deleteRollback(rollback, "Expired by timeout");
        goto L4
    L18:
        if (oldest == null) goto L33;
        long delay = now.until(oldest.plusMillis(this.mRollbackLifetimeDurationInMillis), ChronoUnit.MILLIS);
        getHandler().postDelayed(this.mRunExpiration, delay);
        return;
    }

    private void runExpirationCustomRollbackLifetime() {
        getHandler().removeCallbacks(this.mRunExpiration);
        assertInWorkerThread();
        Instant now = Instant.now();
        long minDelay = 0;
        Iterator<Rollback> iter = this.mRollbacks.iterator();
    L4:
        if (iter.hasNext() == false) goto L23;
        Rollback rollback = iter.next();
        if (rollback.isAvailable() == true) goto L10;
        if (rollback.isCommitted() == false) goto L4;
    L10:
        long rollbackLifetimeMillis = rollback.getRollbackLifetimeMillis();
        if (rollbackLifetimeMillis > 0) goto L13;
        rollbackLifetimeMillis = this.mRollbackLifetimeDurationInMillis;
    L13:
        Instant rollbackExpiryTimestamp = rollback.getTimestamp().plusMillis(rollbackLifetimeMillis);
        if (now.isBefore(rollbackExpiryTimestamp) == false) goto L15;
        long delay = now.until(rollbackExpiryTimestamp, ChronoUnit.MILLIS);
        if (minDelay == 0) goto L20;
        if (delay >= minDelay) goto L4;
    L20:
        minDelay = delay;
        goto L4
    L15:
        Slog.i(TAG, "runExpiration id=" + rollback.info.getRollbackId());
        iter.remove();
        deleteRollback(rollback, "Expired by timeout");
        goto L4
    L23:
        if (minDelay == 0) goto L38;
        getHandler().postDelayed(this.mRunExpiration, minDelay);
        return;
    }

    private Handler getHandler() {
        return this.mHandler;
    }

    private Context getContextAsUser(UserHandle user) {
        return this.mContext.createPackageContextAsUser(this.mContext.getPackageName(), 0, user);
    L5:
        return null;
    }

    private boolean enableRollback(int sessionId) {
        assertInWorkerThread();
        if (LOCAL_LOGV == false) goto L5;
        Slog.v(TAG, "enableRollback sessionId=" + sessionId);
    L5:
        PackageInstaller installer = this.mContext.getPackageManager().getPackageInstaller();
        PackageInstaller.SessionInfo packageSession = installer.getSessionInfo(sessionId);
        if (packageSession != null) goto L10;
        Slog.e(TAG, "Unable to find session for enabled rollback.");
        return false;
    L10:
        if (packageSession.hasParentSessionId() == false) goto L12;
        PackageInstaller.SessionInfo parentSession = installer.getSessionInfo(packageSession.getParentSessionId());
    L13:
        if (parentSession != null) goto L16;
        Slog.e(TAG, "Unable to find parent session for enabled rollback.");
        return false;
    L16:
        Rollback newRollback = getRollbackForSession(packageSession.getSessionId());
        if (newRollback != null) goto L20;
        newRollback = createNewRollback(parentSession);
    L20:
        if (enableRollbackForPackageSession(newRollback, packageSession) == true) goto L22;
        return false;
    L22:
        if (newRollback.allPackagesEnabled() == true) goto L27;
        return true;
    L27:
        return completeEnableRollback(newRollback);
    L12:
        parentSession = packageSession;
        goto L13
    }

    private int computeRollbackDataPolicy(int sessionPolicy, int manifestPolicy) {
        assertInWorkerThread();
        if (manifestPolicy == 0) goto L5;
        return manifestPolicy;
    L5:
        return sessionPolicy;
    }

    private boolean enableRollbackForPackageSession(Rollback rollback, PackageInstaller.SessionInfo session) {
        RollbackManagerServiceImpl r1 = this;
        r1.assertInWorkerThread();
        int installFlags = session.installFlags;
        boolean r5 = false;
        if ((262144 & installFlags) != 0) goto L7;
        Slog.e(TAG, "Rollback is not enabled.");
        return false;
    L7:
        if ((installFlags & 2048) == 0) goto L11;
        Slog.e(TAG, "Rollbacks not supported for instant app install");
        return false;
    L11:
        if (session.resolvedBaseCodePath != null) goto L14;
        Slog.e(TAG, "Session code path has not been resolved.");
        return false;
    L14:
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        ParseResult<ApkLite> parseResult = ApkLiteParseUtils.parseApkLite(input.reset(), new File(session.resolvedBaseCodePath), 0);
        if (parseResult.isError() == false) goto L18;
        Slog.e(TAG, "Unable to parse new package: " + parseResult.getErrorMessage(), parseResult.getException());
        return false;
    L18:
        ApkLite newPackage = (ApkLite) parseResult.getResult();
        String packageName = newPackage.getPackageName();
        int rollbackDataPolicy = r1.computeRollbackDataPolicy(session.rollbackDataPolicy, newPackage.getRollbackDataPolicy());
        if (session.isStaged() == false) goto L21;
    L26:
        Slog.i(TAG, "Enabling rollback for install of " + packageName + ", session:" + session.sessionId + ", rollbackDataPolicy=" + rollbackDataPolicy + ", rollbackId:" + rollback.info.getRollbackId() + ", originalSessionId:" + rollback.getOriginalSessionId());
        String installerPackageName = session.getInstallerPackageName();
        if (r1.enableRollbackAllowed(installerPackageName, packageName) == true) goto L31;
        Slog.e(TAG, "Installer " + installerPackageName + " is not allowed to enable rollback on " + packageName);
        return false;
    L31:
        if ((installFlags & 131072) == 0) goto L33;
        boolean r0 = true;
    L34:
        boolean isApex = r0;
        PackageInfo pkgInfo = r1.getPackageInfo(packageName);     // Catch: PackageManager.NameNotFoundException -> L52
        if (isApex == false) goto L50;
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        List<String> apksInApex = pmi.getApksInApex(packageName);
        Iterator<String> r2 = apksInApex.iterator();
    L40:
        if (r2.hasNext() == false) goto L50;
        boolean r19 = r5;
        String apkInApex = r2.next();
        PackageInfo apkPkgInfo = r1.getPackageInfo(apkInApex);     // Catch: PackageManager.NameNotFoundException -> L47
        Iterator<String> r20 = r2;
        if (rollback.enableForPackageInApex(apkInApex, apkPkgInfo.getLongVersionCode(), rollbackDataPolicy) == false) goto L45;
        r1 = this;
        r5 = r19;
        r2 = r20;
        goto L40
    L45:
        return r19;
    L48:
        Slog.e(TAG, apkInApex + " is not installed");
        return r19;
    L50:
        ApplicationInfo appInfo = pkgInfo.applicationInfo;
        return rollback.enableForPackage(packageName, newPackage.getVersionCode(), pkgInfo.getLongVersionCode(), isApex, appInfo.sourceDir, appInfo.splitSourceDirs, rollbackDataPolicy, session.rollbackImpactLevel);
    L53:
        Slog.e(TAG, packageName + " is not installed");
        return false;
    L33:
        r0 = false;
        goto L34
    L21:
        if ((installFlags & 131072) == 0) goto L26;
        if (rollbackDataPolicy == 2) goto L26;
        Slog.e(TAG, "Only RETAIN is supported for rebootless APEX: " + packageName);
        return false;
    }

    @Override // com.android.server.rollback.RollbackManagerInternal
    public void snapshotAndRestoreUserData(String packageName, List<UserHandle> users, int appId, long ceDataInode, String seInfo, int token) {
        assertNotInWorkerThread();
        snapshotAndRestoreUserData(packageName, UserHandle.fromUserHandles(users), appId, ceDataInode, seInfo, token);
    }

    public void snapshotAndRestoreUserData(final String packageName, final int[] userIds, final int appId, long ceDataInode, final String seInfo, final int token) {
        assertNotInWorkerThread();
        if (Binder.getCallingUid() != 1000) goto L7;
        getHandler().post(new RollbackManagerServiceImpl$$ExternalSyntheticLambda6(this, packageName, userIds, appId, seInfo, token));
        return;
    L7:
        throw new SecurityException("snapshotAndRestoreUserData may only be called by the system.");
    }

    private /* synthetic */ void lambda$snapshotAndRestoreUserData$12(String packageName, int[] userIds, int appId, String seInfo, int token) {
        assertInWorkerThread();
        snapshotUserDataInternal(packageName, userIds);
        restoreUserDataInternal(packageName, userIds, appId, seInfo);
        if (token <= 0) goto L6;
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        pmi.finishPackageInstall(token, false);
        return;
    }

    private void snapshotUserDataInternal(String packageName, int[] userIds) {
        assertInWorkerThread();
        if (LOCAL_LOGV == false) goto L5;
        Slog.v(TAG, "snapshotUserData pkg=" + packageName + " users=" + Arrays.toString(userIds));
    L5:
        int i = 0;
    L7:
        if (i >= this.mRollbacks.size()) goto L10;
        Rollback rollback = this.mRollbacks.get(i);
        rollback.snapshotUserData(packageName, userIds, this.mAppDataRollbackHelper);
        i = i + 1;
        goto L7
    }

    private void restoreUserDataInternal(String packageName, int[] userIds, int appId, String seInfo) {
        assertInWorkerThread();
        if (LOCAL_LOGV == false) goto L5;
        Slog.v(TAG, "restoreUserData pkg=" + packageName + " users=" + Arrays.toString(userIds));
    L5:
        int i = 0;
    L7:
        if (i >= this.mRollbacks.size()) goto L13;
        Rollback rollback = this.mRollbacks.get(i);
        String packageName2 = packageName;
        int[] userIds2 = userIds;
        int appId2 = appId;
        String seInfo2 = seInfo;
        if (rollback.restoreUserDataForPackageIfInProgress(packageName2, userIds2, appId2, seInfo2, this.mAppDataRollbackHelper) == true) goto L10;
        i = i + 1;
        packageName = packageName2;
        userIds = userIds2;
        appId = appId2;
        seInfo = seInfo2;
        goto L7
    L10:
        return;
    }

    @Override // com.android.server.rollback.RollbackManagerInternal
    public int notifyStagedSession(final int sessionId) {
        assertNotInWorkerThread();
        if (Binder.getCallingUid() != 1000) goto L7;
        return ((Integer) awaitResult(new RollbackManagerServiceImpl$$ExternalSyntheticLambda5(this, sessionId))).intValue();
    L7:
        throw new SecurityException("notifyStagedSession may only be called by the system.");
    }

    private /* synthetic */ Integer lambda$notifyStagedSession$13(int sessionId) {
        assertInWorkerThread();
        Rollback rollback = getRollbackForSession(sessionId);
        if (rollback == null) goto L5;
        int r1 = rollback.info.getRollbackId();
    L7:
        return Integer.valueOf(r1);
    L5:
        r1 = -1;
        goto L7
    }

    private boolean enableRollbackAllowed(String installerPackageName, String packageName) {
        if (installerPackageName != null) goto L5;
        return false;
    L5:
        PackageManager pm = this.mContext.getPackageManager();
        if (pm.checkPermission("android.permission.MANAGE_ROLLBACKS", installerPackageName) != 0) goto L8;
        boolean manageRollbacksGranted = true;
    L10:
        if (pm.checkPermission("android.permission.TEST_MANAGE_ROLLBACKS", installerPackageName) != 0) goto L12;
        boolean testManageRollbacksGranted = true;
    L14:
        if (isRollbackAllowed(packageName) == false) goto L16;
        if (manageRollbacksGranted == false) goto L16;
    L18:
        return true;
    L16:
        if (testManageRollbacksGranted == true) goto L18;
        return false;
    L12:
        testManageRollbacksGranted = false;
        goto L14
    L8:
        manageRollbacksGranted = false;
        goto L10
    }

    private boolean isRollbackAllowed(String packageName) {
        if (SystemConfig.getInstance().getRollbackWhitelistedPackages().contains(packageName) == false) goto L5;
    L8:
        return true;
    L5:
        if (isModule(packageName) == true) goto L8;
        return false;
    }

    private boolean isModule(String packageName) {
        PackageManager pm = this.mContext.getPackageManager();
        ModuleInfo moduleInfo = pm.getModuleInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (moduleInfo == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        return false;
    }

    private long getInstalledPackageVersion(String packageName) {
        PackageInfo pkgInfo = getPackageInfo(packageName);     // Catch: PackageManager.NameNotFoundException -> L5
        return pkgInfo.getLongVersionCode();
    L6:
        return -1;
    }

    private PackageInfo getPackageInfo(String packageName) throws PackageManager.NameNotFoundException {
        PackageManager pm = this.mContext.getPackageManager();
        return pm.getPackageInfo(packageName, 4194304);
    L7:
        return pm.getPackageInfo(packageName, 1073741824);
    }

    private boolean completeEnableRollback(Rollback rollback) {
        assertInWorkerThread();
        if (LOCAL_LOGV == false) goto L6;
        Slog.v(TAG, "completeEnableRollback id=" + rollback.info.getRollbackId());
    L6:
        if (rollback.allPackagesEnabled() == true) goto L9;
        Slog.e(TAG, "Failed to enable rollback for all packages in session.");
        this.mRollbacks.remove(rollback);
        deleteRollback(rollback, "Failed to enable rollback for all packages in session");
        return false;
    L9:
        rollback.saveRollback();
        return true;
    }

    private void makeRollbackAvailable(Rollback rollback) {
        assertInWorkerThread();
        Slog.i(TAG, "makeRollbackAvailable id=" + rollback.info.getRollbackId());
        rollback.makeAvailable();
        this.mPackageHealthObserver.notifyRollbackAvailable(rollback.info);
        if (rollback.info.getRollbackImpactLevel() != 0) goto L5;
        this.mPackageWatchdog.startExplicitHealthCheck(rollback.getPackageNames(), this.mRollbackLifetimeDurationInMillis, this.mPackageHealthObserver);
    L5:
        runExpiration();
    }

    private Rollback getRollbackForId(int rollbackId) {
        assertInWorkerThread();
        int i = 0;
    L4:
        if (i >= this.mRollbacks.size()) goto L9;
        Rollback rollback = this.mRollbacks.get(i);
        if (rollback.info.getRollbackId() == rollbackId) goto L7;
        i = i + 1;
        goto L4
    L7:
        return rollback;
    L9:
        return null;
    }

    private int allocateRollbackId() {
        assertInWorkerThread();
        int n = 0;
    L3:
        int rollbackId = this.mRandom.nextInt(2147483646) + 1;
        if (this.mAllocatedRollbackIds.get(rollbackId, false) == false) goto L5;
        int n2 = n + 1;
        if (n >= 32) goto L11;
        n = n2;
        goto L3
    L11:
        throw new IllegalStateException("Failed to allocate rollback ID");
    L5:
        this.mAllocatedRollbackIds.put(rollbackId, true);
        return rollbackId;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        assertNotInWorkerThread();
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        final IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        awaitResult(new RollbackManagerServiceImpl$$ExternalSyntheticLambda4(this, ipw));
        this.mPackageWatchdog.dump(ipw);
    }

    private /* synthetic */ void lambda$dump$14(IndentingPrintWriter ipw) {
        assertInWorkerThread();
        Iterator<Rollback> r0 = this.mRollbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Rollback rollback = r0.next();
        rollback.dump(ipw);
        goto L4
    L6:
        ipw.println();
        List<Rollback> historicalRollbacks = this.mRollbackStore.loadHistorialRollbacks();
        if (historicalRollbacks.isEmpty() == true) goto L16;
        ipw.println("Historical rollbacks:");
        ipw.increaseIndent();
        Iterator<Rollback> r1 = historicalRollbacks.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        Rollback rollback2 = r1.next();
        rollback2.dump(ipw);
        goto L10
    L12:
        ipw.decreaseIndent();
        ipw.println();
        return;
    }

    private void enforceManageRollbacks(String message) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MANAGE_ROLLBACKS") != 0) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.TEST_MANAGE_ROLLBACKS") != 0) goto L8;
        return;
    L8:
        throw new SecurityException(message + " requires android.permission.MANAGE_ROLLBACKS or android.permission.TEST_MANAGE_ROLLBACKS");
    }

    private Rollback createNewRollback(PackageInstaller.SessionInfo parentSession) {
        assertInWorkerThread();
        int rollbackId = allocateRollbackId();
        if (parentSession.getUser().equals(UserHandle.ALL) == false) goto L5;
        int userId = UserHandle.SYSTEM.getIdentifier();
    L6:
        String installerPackageName = parentSession.getInstallerPackageName();
        int parentSessionId = parentSession.getSessionId();
        if (LOCAL_LOGV == false) goto L10;
        Slog.v(TAG, "createNewRollback id=" + rollbackId + " user=" + userId + " installer=" + installerPackageName);
    L10:
        if (parentSession.isMultiPackage() == false) goto L12;
        int[] packageSessionIds = parentSession.getChildSessionIds();
    L14:
        if (parentSession.isStaged() == false) goto L16;
        Rollback rollback = this.mRollbackStore.createStagedRollback(rollbackId, parentSessionId, userId, installerPackageName, packageSessionIds, getExtensionVersions());
    L17:
        rollback.setRollbackLifetimeMillis(parentSession.rollbackLifetimeMillis);
        this.mRollbacks.add(rollback);
        return rollback;
    L16:
        rollback = this.mRollbackStore.createNonStagedRollback(rollbackId, parentSessionId, userId, installerPackageName, packageSessionIds, getExtensionVersions());
        goto L17
    L12:
        int[] packageSessionIds2 = {parentSessionId};
        packageSessionIds = packageSessionIds2;
        goto L14
    L5:
        userId = parentSession.getUser().getIdentifier();
        goto L6
    }

    private SparseIntArray getExtensionVersions() {
        Map<Integer, Integer> allExtensionVersions = SdkExtensions.getAllExtensionVersions();
        SparseIntArray result = new SparseIntArray(allExtensionVersions.size());
        Iterator<Integer> r2 = allExtensionVersions.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        int extension = r2.next().intValue();
        result.put(extension, allExtensionVersions.get(Integer.valueOf(extension)).intValue());
        goto L4
    L6:
        return result;
    }

    private Rollback getRollbackForSession(int sessionId) {
        assertInWorkerThread();
        int i = 0;
    L4:
        if (i >= this.mRollbacks.size()) goto L12;
        Rollback rollback = this.mRollbacks.get(i);
        if (rollback.getOriginalSessionId() == sessionId) goto L11;
        if (rollback.containsSessionId(sessionId) == true) goto L11;
        i = i + 1;
    L11:
        return rollback;
    L12:
        return null;
    }

    private void deleteRollback(Rollback rollback, String reason) {
        assertInWorkerThread();
        rollback.delete(this.mAppDataRollbackHelper, reason);
        this.mRollbackStore.saveRollbackToHistory(rollback);
    }
}
