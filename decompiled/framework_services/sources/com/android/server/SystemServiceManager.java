package com.android.server;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.os.Trace;
import android.util.ArraySet;
import android.util.Dumpable;
import android.util.EventLog;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.SystemServerClassLoaderFactory;
import com.android.internal.util.Preconditions;
import com.android.server.pm.ApexManager;
import com.android.server.pm.UserManagerInternal;
import com.android.server.utils.TimingsTraceAndSlog;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class SystemServiceManager implements Dumpable {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_MAX_USER_POOL_THREADS = 3;
    private static final int SERVICE_CALL_WARN_TIME_MS = 50;
    private static final String TAG = null;
    private static final String USER_COMPLETED_EVENT = "CompletedEvent";
    private static final long USER_POOL_SHUTDOWN_TIMEOUT_SECONDS = 30;
    private static final String USER_STARTING = "Start";
    private static final String USER_STOPPED = "Cleanup";
    private static final String USER_STOPPING = "Stop";
    private static final String USER_SWITCHING = "Switch";
    private static final String USER_UNLOCKED = "Unlocked";
    private static final String USER_UNLOCKING = "Unlocking";
    private static volatile int sOtherServicesStartIndex;
    private static File sSystemDir;
    private final Context mContext;
    private int mCurrentPhase;
    private SystemService.TargetUser mCurrentUser;
    private final int mNumUserPoolThreads;
    private boolean mRuntimeRestarted;
    private long mRuntimeStartElapsedTime;
    private long mRuntimeStartUptime;
    private boolean mSafeMode;
    private Set<String> mServiceClassnames;
    private List<SystemService> mServices;
    private final SparseArray<SystemService.TargetUser> mTargetUsers;
    private UserManagerInternal mUserManagerInternal;

    /* JADX INFO: renamed from: $r8$lambda$-x2iNvPr7Y3U1ISY6dmkmFA351E, reason: not valid java name */
    public static /* synthetic */ void m396$r8$lambda$x2iNvPr7Y3U1ISY6dmkmFA351E(SystemServiceManager r0, TimingsTraceAndSlog r1, SystemService.TargetUser r2, SystemService.UserCompletedEventType r3, String r4, SystemService r5) {
        r0.lambda$getOnUserCompletedEventRunnable$1(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$b-DpR8g_gHKh6QevGlmwPmA5i4M, reason: not valid java name */
    public static /* synthetic */ void m397$r8$lambda$bDpR8g_gHKh6QevGlmwPmA5i4M(SystemServiceManager r0, TimingsTraceAndSlog r1, SystemService r2, SystemService.TargetUser r3) {
        r0.lambda$getOnUserStartingRunnable$0(r1, r2, r3);
    }

    static {
        TAG = SystemServiceManager.class.getSimpleName();
    }

    public SystemServiceManager(Context context) {
        this.mCurrentPhase = -1;
        this.mTargetUsers = new SparseArray();
        this.mContext = context;
        this.mServices = new ArrayList();
        this.mServiceClassnames = new ArraySet();
        this.mNumUserPoolThreads = Math.min(Runtime.getRuntime().availableProcessors(), 3);
    }

    public SystemService startService(String className) {
        Class<SystemService> serviceClass = loadClassFromLoader(className, getClass().getClassLoader());
        return startService(serviceClass);
    }

    public SystemService startServiceFromJar(String className, String path) {
        PathClassLoader pathClassLoader = SystemServerClassLoaderFactory.getOrCreateClassLoader(path, getClass().getClassLoader(), isJarInTestApex(path));
        Class<SystemService> serviceClass = loadClassFromLoader(className, pathClassLoader);
        return startService(serviceClass);
    }

    private boolean isJarInTestApex(String pathStr) {
        Path path = Paths.get(pathStr, new String[0]);
        if (path.getNameCount() >= 2) goto L5;
    L13:
        return false;
    L5:
        if (path.getName(0).toString().equals("apex") == false) goto L13;
        String apexModuleName = path.getName(1).toString();
        ApexManager apexManager = ApexManager.getInstance();
        String packageName = apexManager.getActivePackageNameForApexModuleName(apexModuleName);
        PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(1073741824));     // Catch: Exception -> L12
        if ((packageInfo.applicationInfo.flags & 256) != 0) goto L11;
        return false;
    L11:
        return true;
    }

    private static Class<SystemService> loadClassFromLoader(String className, ClassLoader classLoader) {
        return Class.forName(className, true, classLoader);
    L5:
        ex = move-exception;
        throw new RuntimeException("Failed to create service " + className + " from class loader " + classLoader.toString() + ": service class not found, usually indicates that the caller should have called PackageManager.hasSystemFeature() to check whether the feature is available on this device before trying to start the services that implement it. Also ensure that the correct path for the classloader is supplied, if applicable.", ex);
    }

    public <T extends SystemService> T startService(Class<T> serviceClass) {
        String name = serviceClass.getName();     // Catch: Throwable -> L10
        Slog.i(TAG, "Starting " + name);     // Catch: Throwable -> L10
        Trace.traceBegin(524288, "StartService " + name);     // Catch: Throwable -> L10
        if (SystemService.class.isAssignableFrom(serviceClass) == false) goto L30;
        Constructor<T> constructor = serviceClass.getConstructor(new Class[]{Context.class});     // Catch: Throwable -> L10 InvocationTargetException -> L12 NoSuchMethodException -> L14 IllegalAccessException -> L16 InstantiationException -> L18
        T service = constructor.newInstance(new Object[]{this.mContext});     // Catch: Throwable -> L10 InvocationTargetException -> L12 NoSuchMethodException -> L14 IllegalAccessException -> L16 InstantiationException -> L18
        startService(service);     // Catch: Throwable -> L10
        Trace.traceEnd(524288);
        return service;
    L16:
        ex = move-exception;
        throw new RuntimeException("Failed to create service " + name + ": service must have a public constructor with a Context argument", ex);     // Catch: Throwable -> L10
    L12:
        ex = move-exception;
        throw new RuntimeException("Failed to create service " + name + ": service constructor threw an exception", ex);     // Catch: Throwable -> L10
    L18:
        ex = move-exception;
        throw new RuntimeException("Failed to create service " + name + ": service could not be instantiated", ex);     // Catch: Throwable -> L10
    L14:
        ex = move-exception;
        throw new RuntimeException("Failed to create service " + name + ": service must have a public constructor with a Context argument", ex);     // Catch: Throwable -> L10
    L30:
        throw new RuntimeException("Failed to create " + name + ": service must extend " + SystemService.class.getName());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    }

    public void startService(SystemService service) {
        String className = service.getClass().getName();
        if (this.mServiceClassnames.contains(className) == false) goto L6;
        Slog.i(TAG, "Not starting an already started service " + className);
        return;
    L6:
        this.mServiceClassnames.add(className);
        this.mServices.add(service);
        long time = SystemClock.elapsedRealtime();
        service.onStart();     // Catch: RuntimeException -> L10
        warnIfTooLong(SystemClock.elapsedRealtime() - time, service, "onStart");
        return;
    L10:
        ex = move-exception;
        throw new RuntimeException("Failed to start service " + service.getClass().getName() + ": onStart threw an exception", ex);
    }

    public void sealStartedServices() {
        this.mServiceClassnames = Collections.emptySet();
        this.mServices = Collections.unmodifiableList(this.mServices);
    }

    public void startBootPhase(TimingsTraceAndSlog t, int phase) {
        if (phase <= this.mCurrentPhase) goto L22;
        this.mCurrentPhase = phase;
        Slog.i(TAG, "Starting phase " + this.mCurrentPhase);
        t.traceBegin("OnBootPhase_" + phase);     // Catch: Throwable -> L10
        int serviceLen = this.mServices.size();     // Catch: Throwable -> L10
        int i = 0;
    L6:
        if (i >= serviceLen) goto L15;
        SystemService service = this.mServices.get(i);     // Catch: Throwable -> L10
        long time = SystemClock.elapsedRealtime();     // Catch: Throwable -> L10
        t.traceBegin("OnBootPhase_" + phase + "_" + service.getClass().getName());     // Catch: Throwable -> L10
        service.onBootPhase(this.mCurrentPhase);     // Catch: Throwable -> L10 Exception -> L12
        warnIfTooLong(SystemClock.elapsedRealtime() - time, service, "onBootPhase");     // Catch: Throwable -> L10
        t.traceEnd();     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L6
    L12:
        ex = move-exception;
        throw new RuntimeException("Failed to boot service " + service.getClass().getName() + ": onBootPhase threw an exception during phase " + this.mCurrentPhase, ex);     // Catch: Throwable -> L10
    L15:
        t.traceEnd();
        if (phase != 1000) goto L28;
        long totalBootTime = SystemClock.uptimeMillis() - this.mRuntimeStartUptime;
        t.logDuration("TotalBootTime", totalBootTime);
        shutdownInitThreadPool();
        return;
    L28:
        return;
    L10:
        th = move-exception;
        t.traceEnd();
        throw th;
    L22:
        throw new IllegalArgumentException("Next phase must be larger than previous");
    }

    private void shutdownInitThreadPool() {
        SystemServerInitThreadPool.shutdown();
    }

    private void shutdownInitThreadPool$ravenwood() {
    }

    public boolean isBootCompleted() {
        if (this.mCurrentPhase < 1000) goto L5;
        return true;
    L5:
        return false;
    }

    public void updateOtherServicesStartIndex() {
        if (isBootCompleted() == true) goto L6;
        sOtherServicesStartIndex = this.mServices.size();
        return;
    }

    public void preSystemReady() {
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    }

    private SystemService.TargetUser getTargetUser(int userId) {
        SparseArray<SystemService.TargetUser> r0 = this.mTargetUsers;
        monitor-enter(r0);
        SystemService.TargetUser r1 = this.mTargetUsers.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private SystemService.TargetUser newTargetUser(int userId) {
        UserInfo userInfo = this.mUserManagerInternal.getUserInfo(userId);
        if (userInfo == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "No UserInfo for " + userId);
        return new SystemService.TargetUser(userInfo);
    L5:
        r1 = false;
        goto L6
    }

    public void onUserStarting(TimingsTraceAndSlog t, int userId) {
        SystemService.TargetUser targetUser = newTargetUser(userId);
        SparseArray<SystemService.TargetUser> r1 = this.mTargetUsers;
        monitor-enter(r1);
        if (userId == 0) goto L18;
    L12:
        this.mTargetUsers.put(userId, targetUser);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        EventLog.writeEvent(com.android.server.am.EventLogTags.SSM_USER_STARTING, userId);
        onUser(t, USER_STARTING, null, targetUser);
        return;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mTargetUsers.contains(userId) == false) goto L12;
        Slog.e(TAG, "Skipping starting system user twice");     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
    }

    public void onUserUnlocking(int userId) {
        EventLog.writeEvent(com.android.server.am.EventLogTags.SSM_USER_UNLOCKING, userId);
        onUser(USER_UNLOCKING, userId);
    }

    public void onUserUnlocked(int userId) {
        EventLog.writeEvent(com.android.server.am.EventLogTags.SSM_USER_UNLOCKED, userId);
        onUser(USER_UNLOCKED, userId);
    }

    public void onUserSwitching(int from, int to) {
        EventLog.writeEvent(com.android.server.am.EventLogTags.SSM_USER_SWITCHING, new Object[]{Integer.valueOf(from), Integer.valueOf(to)});
        SparseArray<SystemService.TargetUser> r0 = this.mTargetUsers;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentUser != null) goto L10;
        SystemService.TargetUser prevUser = newTargetUser(from);     // Catch: Throwable -> L7
    L13:
        SystemService.TargetUser curUser = getTargetUser(to);     // Catch: Throwable -> L7
        this.mCurrentUser = curUser;     // Catch: Throwable -> L7
        if (curUser == null) goto L16;
        boolean r3 = true;
    L17:
        Preconditions.checkState(r3, "No TargetUser for " + to);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        onUser(TimingsTraceAndSlog.newAsyncLog(), USER_SWITCHING, prevUser, curUser);
        return;
    L16:
        r3 = false;
        goto L17
    L10:
        if (from == this.mCurrentUser.getUserIdentifier()) goto L12;
        Slog.wtf(TAG, "switchUser(" + from + "," + to + "): mCurrentUser is " + this.mCurrentUser + ", it should be " + from);     // Catch: Throwable -> L7
    L12:
        prevUser = this.mCurrentUser;     // Catch: Throwable -> L7
        goto L13
    }

    public void onUserStopping(int userId) {
        EventLog.writeEvent(com.android.server.am.EventLogTags.SSM_USER_STOPPING, userId);
        onUser(USER_STOPPING, userId);
    }

    public void onUserStopped(int userId) {
        EventLog.writeEvent(com.android.server.am.EventLogTags.SSM_USER_STOPPED, userId);
        onUser(USER_STOPPED, userId);
        SparseArray<SystemService.TargetUser> r0 = this.mTargetUsers;
        monitor-enter(r0);
        this.mTargetUsers.remove(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onUserCompletedEvent(int userId, int eventFlags) {
        EventLog.writeEvent(com.android.server.am.EventLogTags.SSM_USER_COMPLETED_EVENT, new Object[]{Integer.valueOf(userId), Integer.valueOf(eventFlags)});
        if (eventFlags != 0) goto L5;
        return;
    L5:
        SystemService.TargetUser targetUser = getTargetUser(userId);
        if (targetUser != null) goto L8;
        return;
    L8:
        onUser(TimingsTraceAndSlog.newAsyncLog(), USER_COMPLETED_EVENT, null, targetUser, new SystemService.UserCompletedEventType(eventFlags));
    }

    private void onUser(String onWhat, int userId) {
        SystemService.TargetUser targetUser = getTargetUser(userId);
        if (targetUser == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkState(r1, "No TargetUser for " + userId);
        onUser(TimingsTraceAndSlog.newAsyncLog(), onWhat, null, targetUser);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void onUser(TimingsTraceAndSlog t, String onWhat, SystemService.TargetUser prevUser, SystemService.TargetUser curUser) {
        onUser(t, onWhat, prevUser, curUser, null);
    }

    private void onUser(TimingsTraceAndSlog t, String onWhat, SystemService.TargetUser prevUser, SystemService.TargetUser curUser, SystemService.UserCompletedEventType completedEventType) {
        SystemServiceManager r1 = this;
        TimingsTraceAndSlog r2 = t;
        int curUserId = curUser.getUserIdentifier();
        r2.traceBegin("ssm." + onWhat + "User-" + curUserId);
        String r0 = TAG;
        StringBuilder r3 = new StringBuilder();
        r3.append("Calling on");
        r3.append(onWhat);
        r3.append("User ");
        r3.append(curUserId);
        if (prevUser == null) goto L5;
        String r4 = " (from " + prevUser + ")";
    L6:
        r3.append(r4);
        Slog.i(r0, r3.toString());
        boolean useThreadPool = r1.useThreadPool(curUserId, onWhat);
        if (useThreadPool == false) goto L9;
        ExecutorService r5 = Executors.newFixedThreadPool(r1.mNumUserPoolThreads);
    L10:
        ExecutorService threadPool = r5;
        int serviceLen = r1.mServices.size();
        int i = 0;
    L11:
        if (i >= serviceLen) goto L76;
        SystemService service = r1.mServices.get(i);
        String serviceName = service.getClass().getName();
        boolean supported = service.isUserSupported(curUser);
        if (supported == true) goto L16;
        if (prevUser == null) goto L16;
        boolean supported2 = service.isUserSupported(prevUser);
    L17:
        if (supported2 == true) goto L19;
        Slog.i(TAG, "Skipping " + onWhat + "User-" + curUserId + " on " + serviceName);
    L74:
        i = i + 1;
        r2 = t;
        useThreadPool = useThreadPool;
        goto L11
    L19:
        if (useThreadPool == true) goto L21;
    L23:
        boolean submitToThreadPool = false;
    L24:
        if (submitToThreadPool == true) goto L26;
        r2.traceBegin("ssm.on" + onWhat + "User-" + curUserId + "_" + serviceName);
    L26:
        long time = SystemClock.elapsedRealtime();
        switch(onWhat.hashCode()) {
            case -1805606060: goto L51;
            case -1773539708: goto L48;
            case -240492034: goto L45;
            case -146305277: goto L42;
            case 2587682: goto L39;
            case 80204866: goto L36;
            case 537825071: goto L31;
            default: goto L53;
        };     // Catch: Exception -> L33
    L53:
        byte r6 = -1;
    L54:
        switch(r6) {
            case 0: goto L68;
            case 1: goto L65;
            case 2: goto L64;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L61;
            case 6: goto L59;
            default: goto L86;
        };
    L59:
        r1 = this;
        threadPool.submit(r1.getOnUserCompletedEventRunnable(r2, service, serviceName, curUser, completedEventType));     // Catch: Exception -> L33
    L71:
        if (submitToThreadPool == true) goto L74;
        r1.warnIfTooLong(SystemClock.elapsedRealtime() - time, service, "on" + onWhat + "User-" + curUserId);
        t.traceEnd();
        goto L74
    L61:
        service.onUserStopped(curUser);     // Catch: Exception -> L33
        goto L71
    L62:
        service.onUserStopping(curUser);     // Catch: Exception -> L33
        goto L71
    L63:
        service.onUserUnlocked(curUser);     // Catch: Exception -> L33
        goto L71
    L64:
        service.onUserUnlocking(curUser);     // Catch: Exception -> L33
        goto L71
    L65:
        if (submitToThreadPool == false) goto L67;
        threadPool.submit(r1.getOnUserStartingRunnable(r2, service, curUser));     // Catch: Exception -> L33
        goto L71
    L67:
        service.onUserStarting(curUser);     // Catch: Exception -> L33
        goto L71
    L68:
        service.onUserSwitching(prevUser, curUser);     // Catch: Exception -> L33
        goto L71
    L86:
    L57:
        ex = e;
        r1 = this;
    L70:
        r1.logFailure(onWhat, curUser, serviceName, ex);
        goto L71
    L56:
        throw new IllegalArgumentException(onWhat + " what?");     // Catch: Exception -> L57
    L31:
        if (onWhat.equals(USER_COMPLETED_EVENT) == false) goto L53;
        r6 = 6;
        goto L54
    L36:
        if (onWhat.equals(USER_STARTING) == false) goto L53;
        r6 = 1;
        goto L54
    L39:
        if (onWhat.equals(USER_STOPPING) == false) goto L53;
        r6 = 4;
        goto L54
    L42:
        if (onWhat.equals(USER_UNLOCKED) == false) goto L53;
        r6 = 3;
        goto L54
    L45:
        if (onWhat.equals(USER_UNLOCKING) == false) goto L53;
        r6 = 2;
        goto L54
    L48:
        if (onWhat.equals(USER_STOPPED) == false) goto L53;
        r6 = 5;
        goto L54
    L51:
        if (onWhat.equals(USER_SWITCHING) == false) goto L53;
        r6 = 0;
    L33:
        ex = e;
        goto L70
    L21:
        if (r1.useThreadPoolForService(onWhat, i) == false) goto L23;
        submitToThreadPool = true;
    L16:
        supported2 = supported;
        goto L17
    L76:
        if (useThreadPool == false) goto L84;
        boolean terminated = false;
        threadPool.shutdown();
        terminated = threadPool.awaitTermination(USER_POOL_SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS);     // Catch: InterruptedException -> L80
    L82:
        if (terminated == true) goto L84;
        r1.logFailure(onWhat, curUser, "(user lifecycle threadpool was not terminated)", null);
    L80:
        e = move-exception;
        r1.logFailure(onWhat, curUser, "(user lifecycle threadpool was interrupted)", e);
    L84:
        t.traceEnd();
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = "";
        goto L6
    }

    private boolean useThreadPool(int userId, String onWhat) {
        switch(onWhat.hashCode()) {
            case 80204866: goto L9;
            case 537825071: goto L6;
            default: goto L11;
        };
    L11:
        byte r0 = -1;
    L12:
        switch(r0) {
            case 0: goto L16;
            case 1: goto L14;
            default: goto L13;
        };
    L13:
        return false;
    L14:
        return true;
    L16:
        if (ActivityManager.isLowRamDeviceStatic() == true) goto L20;
        if (userId != 0) goto L19;
        return false;
    L19:
        return true;
    L20:
        return false;
    L6:
        if (onWhat.equals(USER_COMPLETED_EVENT) == false) goto L11;
        r0 = 1;
        goto L12
    L9:
        if (onWhat.equals(USER_STARTING) == false) goto L11;
        r0 = 0;
        goto L12
    }

    private boolean useThreadPoolForService(String onWhat, int serviceIndex) {
        switch(onWhat.hashCode()) {
            case 80204866: goto L9;
            case 537825071: goto L6;
            default: goto L11;
        };
    L11:
        byte r0 = -1;
    L12:
        switch(r0) {
            case 0: goto L16;
            case 1: goto L14;
            default: goto L13;
        };
    L13:
        return false;
    L14:
        return true;
    L16:
        if (serviceIndex >= sOtherServicesStartIndex) goto L18;
        return false;
    L18:
        return true;
    L6:
        if (onWhat.equals(USER_COMPLETED_EVENT) == false) goto L11;
        r0 = 1;
        goto L12
    L9:
        if (onWhat.equals(USER_STARTING) == false) goto L11;
        r0 = 0;
        goto L12
    }

    private Runnable getOnUserStartingRunnable(final TimingsTraceAndSlog oldTrace, final SystemService service, final SystemService.TargetUser curUser) {
        return new SystemServiceManager$$ExternalSyntheticLambda1(this, oldTrace, service, curUser);
    }

    private /* synthetic */ void lambda$getOnUserStartingRunnable$0(TimingsTraceAndSlog oldTrace, SystemService service, SystemService.TargetUser curUser) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog(oldTrace);
        String serviceName = service.getClass().getName();
        int curUserId = curUser.getUserIdentifier();
        t.traceBegin("ssm.onStartUser-" + curUserId + "_" + serviceName);
        long time = SystemClock.elapsedRealtime();     // Catch: Throwable -> L5 Exception -> L7
        service.onUserStarting(curUser);     // Catch: Throwable -> L5 Exception -> L7
        warnIfTooLong(SystemClock.elapsedRealtime() - time, service, "onStartUser-" + curUserId);     // Catch: Throwable -> L5 Exception -> L7
    L4:
        t.traceEnd();
        return;
    L5:
        th = move-exception;
        t.traceEnd();
        throw th;
    L7:
        e = move-exception;
        logFailure(USER_STARTING, curUser, serviceName, e);     // Catch: Throwable -> L5
        goto L4
    }

    private Runnable getOnUserCompletedEventRunnable(final TimingsTraceAndSlog oldTrace, final SystemService service, final String serviceName, final SystemService.TargetUser curUser, final SystemService.UserCompletedEventType eventType) {
        return new SystemServiceManager$$ExternalSyntheticLambda0(this, oldTrace, curUser, eventType, serviceName, service);
    }

    private /* synthetic */ void lambda$getOnUserCompletedEventRunnable$1(TimingsTraceAndSlog oldTrace, SystemService.TargetUser curUser, SystemService.UserCompletedEventType eventType, String serviceName, SystemService service) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog(oldTrace);
        int curUserId = curUser.getUserIdentifier();
        t.traceBegin("ssm.onCompletedEventUser-" + curUserId + "_" + eventType + "_" + serviceName);
        long time = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6 Exception -> L8
        service.onUserCompletedEvent(curUser, eventType);     // Catch: Throwable -> L6 Exception -> L8
        warnIfTooLong(SystemClock.elapsedRealtime() - time, service, "onCompletedEventUser-" + curUserId);     // Catch: Throwable -> L6 Exception -> L8
        t.traceEnd();
        return;
    L6:
        th = move-exception;
        t.traceEnd();
        throw th;
    L8:
        e = move-exception;
        logFailure(USER_COMPLETED_EVENT, curUser, serviceName, e);     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    }

    private void logFailure(String onWhat, SystemService.TargetUser curUser, String serviceName, Exception ex) {
        Slog.wtf(TAG, "SystemService failure: Failure reporting " + onWhat + " of user " + curUser + " to service " + serviceName, ex);
    }

    void setSafeMode(boolean safeMode) {
        this.mSafeMode = safeMode;
    }

    public boolean isSafeMode() {
        return this.mSafeMode;
    }

    public boolean isRuntimeRestarted() {
        return this.mRuntimeRestarted;
    }

    public long getRuntimeStartElapsedTime() {
        return this.mRuntimeStartElapsedTime;
    }

    public long getRuntimeStartUptime() {
        return this.mRuntimeStartUptime;
    }

    public void setStartInfo(boolean runtimeRestarted, long runtimeStartElapsedTime, long runtimeStartUptime) {
        this.mRuntimeRestarted = runtimeRestarted;
        this.mRuntimeStartElapsedTime = runtimeStartElapsedTime;
        this.mRuntimeStartUptime = runtimeStartUptime;
    }

    private void warnIfTooLong(long duration, SystemService service, String operation) {
        if (duration <= 50) goto L6;
        Slog.w(TAG, "Service " + service.getClass().getName() + " took " + duration + " ms in " + operation);
        return;
    }

    @Deprecated
    public static File ensureSystemDir() {
        if (sSystemDir != null) goto L5;
        File dataDir = Environment.getDataDirectory();
        sSystemDir = new File(dataDir, "system");
        sSystemDir.mkdirs();
    L5:
        File dataDir2 = sSystemDir;
        return dataDir2;
    }

    @Override // android.util.Dumpable
    public String getDumpableName() {
        return SystemServiceManager.class.getSimpleName();
    }

    @Override // android.util.Dumpable
    public void dump(PrintWriter pw, String[] args) {
        pw.printf("Current phase: %d\n", new Object[]{Integer.valueOf(this.mCurrentPhase)});
        SparseArray<SystemService.TargetUser> r0 = this.mTargetUsers;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentUser == null) goto L9;
        pw.print("Current user: ");     // Catch: Throwable -> L7
        this.mCurrentUser.dump(pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
    L10:
        int targetUsersSize = this.mTargetUsers.size();     // Catch: Throwable -> L7
        if (targetUsersSize <= 0) goto L19;
        pw.printf("%d target users: ", new Object[]{Integer.valueOf(targetUsersSize)});     // Catch: Throwable -> L7
        int i = 0;
    L13:
        if (i >= targetUsersSize) goto L18;
        this.mTargetUsers.valueAt(i).dump(pw);     // Catch: Throwable -> L7
        if (i == (targetUsersSize - 1)) goto L17;
        pw.print(", ");     // Catch: Throwable -> L7
    L17:
        i = i + 1;     // Catch: Throwable -> L7
        goto L13
    L18:
        pw.println();     // Catch: Throwable -> L7
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L7
        int startedLen = this.mServices.size();
        if (startedLen <= 0) goto L27;
        pw.printf("%d started services:\n", new Object[]{Integer.valueOf(startedLen)});
        int i2 = 0;
    L24:
        if (i2 >= startedLen) goto L37;
        SystemService service = this.mServices.get(i2);
        pw.print("  ");
        pw.println(service.getClass().getCanonicalName());
        i2 = i2 + 1;
        goto L24
    L37:
        return;
    L27:
        pw.println("No started services");
        return;
    L19:
        pw.println("No target users");     // Catch: Throwable -> L7
        goto L20
    L9:
        pw.println("Current user not set!");     // Catch: Throwable -> L7
        goto L10
    }
}
