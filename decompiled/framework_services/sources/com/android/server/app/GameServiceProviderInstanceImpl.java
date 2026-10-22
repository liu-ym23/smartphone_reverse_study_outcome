package com.android.server.app;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityTaskManager;
import android.app.IActivityManager;
import android.app.IActivityTaskManager;
import android.app.IProcessObserver;
import android.app.TaskStackListener;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.net.Uri;
import android.os.RemoteException;
import android.os.UserHandle;
import android.service.games.CreateGameSessionRequest;
import android.service.games.CreateGameSessionResult;
import android.service.games.GameScreenshotResult;
import android.service.games.GameSessionViewHostConfiguration;
import android.service.games.GameStartedEvent;
import android.service.games.IGameService;
import android.service.games.IGameServiceController;
import android.service.games.IGameSession;
import android.service.games.IGameSessionController;
import android.service.games.IGameSessionService;
import android.text.TextUtils;
import android.util.Slog;
import android.view.SurfaceControl;
import android.view.SurfaceControlViewHost;
import android.window.ScreenCapture;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.infra.ServiceConnector;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ScreenshotHelper;
import com.android.internal.util.ScreenshotRequest;
import com.android.server.job.controllers.JobStatus;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import com.android.server.wm.WindowManagerService;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class GameServiceProviderInstanceImpl implements GameServiceProviderInstance {
    private static final int CREATE_GAME_SESSION_TIMEOUT_MS = 10000;
    private static final boolean DEBUG = false;
    private static final String TAG = "GameServiceProviderInstance";
    private final IActivityManager mActivityManager;
    private final ActivityManagerInternal mActivityManagerInternal;
    private final IActivityTaskManager mActivityTaskManager;
    private final ActivityTaskManagerInternal mActivityTaskManagerInternal;
    private final Executor mBackgroundExecutor;
    private final Context mContext;
    private final ServiceConnector<IGameService> mGameServiceConnector;
    private final IGameServiceController mGameServiceController;
    private final ServiceConnector.ServiceLifecycleCallbacks<IGameService> mGameServiceLifecycleCallbacks;
    private final IGameSessionController mGameSessionController;
    private final ServiceConnector<IGameSessionService> mGameSessionServiceConnector;
    private final ServiceConnector.ServiceLifecycleCallbacks<IGameSessionService> mGameSessionServiceLifecycleCallbacks;
    private final ConcurrentHashMap<Integer, GameSessionRecord> mGameSessions;
    private final GameTaskInfoProvider mGameTaskInfoProvider;
    private volatile boolean mIsRunning;
    private final Object mLock;
    private final ConcurrentHashMap<String, Integer> mPackageNameToProcessCountMap;
    private final ConcurrentHashMap<Integer, String> mPidToPackageMap;
    private final IProcessObserver mProcessObserver;
    private final ScreenshotHelper mScreenshotHelper;
    private final TaskStackListener mTaskStackListener;
    private final WindowManagerInternal.TaskSystemBarsListener mTaskSystemBarsVisibilityListener;
    private final UserHandle mUserHandle;
    private final WindowManagerInternal mWindowManagerInternal;
    private final WindowManagerService mWindowManagerService;

    /* JADX INFO: renamed from: com.android.server.app.GameServiceProviderInstanceImpl$2, reason: invalid class name */
    class AnonymousClass2 implements ServiceConnector.ServiceLifecycleCallbacks<IGameSessionService> {
        final /* synthetic */ GameServiceProviderInstanceImpl this$0;

        /* JADX INFO: renamed from: $r8$lambda$G0HNQTa18rfd-UJ69vZRLjJueII, reason: not valid java name */
        public static /* synthetic */ void m1670$r8$lambda$G0HNQTa18rfdUJ69vZRLjJueII(AnonymousClass2 r0) {
            r0.lambda$onBinderDied$0();
        }

        AnonymousClass2(GameServiceProviderInstanceImpl this$0) {
            this.this$0 = this$0;
        }

        public void onBinderDied() {
            GameServiceProviderInstanceImpl.m1658$$Nest$fgetmBackgroundExecutor(this.this$0).execute(new GameServiceProviderInstanceImpl$2$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$onBinderDied$0() {
            Object r0 = GameServiceProviderInstanceImpl.m1660$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            GameServiceProviderInstanceImpl.m1662$$Nest$mdestroyAndClearAllGameSessionsLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.android.server.app.GameServiceProviderInstanceImpl$4, reason: invalid class name */
    class AnonymousClass4 extends TaskStackListener {
        final /* synthetic */ GameServiceProviderInstanceImpl this$0;

        public static /* synthetic */ void $r8$lambda$UeqZkCkrTjrMxMDgM1jEWnkGMy0(AnonymousClass4 r0, int r1) {
            r0.lambda$onTaskRemoved$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$_Wkeha9or834_Z5oft60729RJPc(AnonymousClass4 r0, int r1, ComponentName r2) {
            r0.lambda$onTaskCreated$0(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$zBC789RjBRS-tbnPPWQds3G929w, reason: not valid java name */
        public static /* synthetic */ void m1671$r8$lambda$zBC789RjBRStbnPPWQds3G929w(AnonymousClass4 r0, int r1, boolean r2) {
            r0.lambda$onTaskFocusChanged$2(r1, r2);
        }

        AnonymousClass4(GameServiceProviderInstanceImpl this$0) {
            this.this$0 = this$0;
        }

        public void onTaskCreated(final int taskId, final ComponentName componentName) throws RemoteException {
            if (componentName != null) goto L4;
            return;
        L4:
            GameServiceProviderInstanceImpl.m1658$$Nest$fgetmBackgroundExecutor(this.this$0).execute(new GameServiceProviderInstanceImpl$4$$ExternalSyntheticLambda0(this, taskId, componentName));
        }

        private /* synthetic */ void lambda$onTaskCreated$0(int taskId, ComponentName componentName) {
            GameServiceProviderInstanceImpl.m1665$$Nest$monTaskCreated(this.this$0, taskId, componentName);
        }

        public void onTaskRemoved(final int taskId) throws RemoteException {
            GameServiceProviderInstanceImpl.m1658$$Nest$fgetmBackgroundExecutor(this.this$0).execute(new GameServiceProviderInstanceImpl$4$$ExternalSyntheticLambda1(this, taskId));
        }

        private /* synthetic */ void lambda$onTaskRemoved$1(int taskId) {
            GameServiceProviderInstanceImpl.m1667$$Nest$monTaskRemoved(this.this$0, taskId);
        }

        public void onTaskFocusChanged(final int taskId, final boolean focused) {
            GameServiceProviderInstanceImpl.m1658$$Nest$fgetmBackgroundExecutor(this.this$0).execute(new GameServiceProviderInstanceImpl$4$$ExternalSyntheticLambda2(this, taskId, focused));
        }

        private /* synthetic */ void lambda$onTaskFocusChanged$2(int taskId, boolean focused) {
            GameServiceProviderInstanceImpl.m1666$$Nest$monTaskFocusChanged(this.this$0, taskId, focused);
        }
    }

    /* JADX INFO: renamed from: com.android.server.app.GameServiceProviderInstanceImpl$5, reason: invalid class name */
    class AnonymousClass5 extends IProcessObserver.Stub {
        final /* synthetic */ GameServiceProviderInstanceImpl this$0;

        public static /* synthetic */ void $r8$lambda$2k6dxdub2zTeeWjyKdFvv2rkX3s(AnonymousClass5 r0, int r1) {
            r0.lambda$onForegroundActivitiesChanged$0(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$Mxnw4Fca_ghN8W0ctEZE-nNInnQ, reason: not valid java name */
        public static /* synthetic */ void m1672$r8$lambda$Mxnw4Fca_ghN8W0ctEZEnNInnQ(AnonymousClass5 r0, int r1) {
            r0.lambda$onProcessDied$1(r1);
        }

        AnonymousClass5(GameServiceProviderInstanceImpl this$0) {
            this.this$0 = this$0;
        }

        public void onForegroundActivitiesChanged(final int pid, int uid, boolean fg) {
            GameServiceProviderInstanceImpl.m1658$$Nest$fgetmBackgroundExecutor(this.this$0).execute(new GameServiceProviderInstanceImpl$5$$ExternalSyntheticLambda0(this, pid));
        }

        private /* synthetic */ void lambda$onForegroundActivitiesChanged$0(int pid) {
            GameServiceProviderInstanceImpl.m1663$$Nest$monForegroundActivitiesChanged(this.this$0, pid);
        }

        public void onProcessDied(final int pid, int uid) {
            GameServiceProviderInstanceImpl.m1658$$Nest$fgetmBackgroundExecutor(this.this$0).execute(new GameServiceProviderInstanceImpl$5$$ExternalSyntheticLambda1(this, pid));
        }

        private /* synthetic */ void lambda$onProcessDied$1(int pid) {
            GameServiceProviderInstanceImpl.m1664$$Nest$monProcessDied(this.this$0, pid);
        }

        public void onProcessStarted(int pid, int processUid, int packageUid, String packageName, String processName) {
        }

        public void onForegroundServicesChanged(int pid, int uid, int serviceTypes) {
        }
    }

    /* JADX INFO: renamed from: com.android.server.app.GameServiceProviderInstanceImpl$6, reason: invalid class name */
    class AnonymousClass6 extends IGameServiceController.Stub {
        final /* synthetic */ GameServiceProviderInstanceImpl this$0;

        /* JADX INFO: renamed from: $r8$lambda$gg-NaxM7hWj216h-VvL3KuSR-uY, reason: not valid java name */
        public static /* synthetic */ void m1673$r8$lambda$ggNaxM7hWj216hVvL3KuSRuY(AnonymousClass6 r0, int r1) {
            r0.lambda$createGameSession$0(r1);
        }

        AnonymousClass6(GameServiceProviderInstanceImpl this$0) {
            this.this$0 = this$0;
        }

        public void createGameSession(final int taskId) {
            super.createGameSession_enforcePermission();
            GameServiceProviderInstanceImpl.m1658$$Nest$fgetmBackgroundExecutor(this.this$0).execute(new GameServiceProviderInstanceImpl$6$$ExternalSyntheticLambda0(this, taskId));
        }

        private /* synthetic */ void lambda$createGameSession$0(int taskId) {
            GameServiceProviderInstanceImpl.m1661$$Nest$mcreateGameSession(this.this$0, taskId);
        }
    }

    /* JADX INFO: renamed from: com.android.server.app.GameServiceProviderInstanceImpl$7, reason: invalid class name */
    class AnonymousClass7 extends IGameSessionController.Stub {
        final /* synthetic */ GameServiceProviderInstanceImpl this$0;

        /* JADX INFO: renamed from: $r8$lambda$GUx1YH9iLeiPmRwgNvh_-pzvGa0, reason: not valid java name */
        public static /* synthetic */ void m1674$r8$lambda$GUx1YH9iLeiPmRwgNvh_pzvGa0(AnonymousClass7 r0, int r1, AndroidFuture r2) {
            r0.lambda$takeScreenshot$0(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$wcIQF0tgwSvxGC62jY0Lins38TI(AnonymousClass7 r0, int r1) {
            r0.lambda$restartGame$1(r1);
        }

        AnonymousClass7(GameServiceProviderInstanceImpl this$0) {
            this.this$0 = this$0;
        }

        public void takeScreenshot(final int taskId, final AndroidFuture gameScreenshotResultFuture) {
            super.takeScreenshot_enforcePermission();
            GameServiceProviderInstanceImpl.m1658$$Nest$fgetmBackgroundExecutor(this.this$0).execute(new GameServiceProviderInstanceImpl$7$$ExternalSyntheticLambda1(this, taskId, gameScreenshotResultFuture));
        }

        private /* synthetic */ void lambda$takeScreenshot$0(int taskId, AndroidFuture gameScreenshotResultFuture) {
            this.this$0.takeScreenshot(taskId, gameScreenshotResultFuture);
        }

        public void restartGame(final int taskId) {
            super.restartGame_enforcePermission();
            GameServiceProviderInstanceImpl.m1658$$Nest$fgetmBackgroundExecutor(this.this$0).execute(new GameServiceProviderInstanceImpl$7$$ExternalSyntheticLambda0(this, taskId));
        }

        private /* synthetic */ void lambda$restartGame$1(int taskId) {
            GameServiceProviderInstanceImpl.m1669$$Nest$mrestartGame(this.this$0, taskId);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-GVnoC3-iGycUUR3m60ZQRgOVSU, reason: not valid java name */
    public static /* synthetic */ void m1655$r8$lambda$GVnoC3iGycUUR3m60ZQRgOVSU(GameTaskInfo r0, IGameService r1) {
        lambda$gameTaskStartedLocked$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$PpF6D3DGlIR7Dzk2mkJO3nI_TfY(GameServiceProviderInstanceImpl r0, int r1, GameSessionRecord r2, GameSessionViewHostConfiguration r3, AndroidFuture r4, IGameSessionService r5) {
        r0.lambda$createGameSessionLocked$3(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$ST7_KY_rDNbV8lfuuM06-M5LDts, reason: not valid java name */
    public static /* synthetic */ void m1656$r8$lambda$ST7_KY_rDNbV8lfuuM06M5LDts(GameServiceProviderInstanceImpl r0, Void r1, Throwable r2) {
        r0.lambda$stopLocked$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ZY9VPc5KcwRjDUhGLsea0Tnd2eo(AndroidFuture r0, Uri r1) {
        lambda$takeScreenshot$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$mDIPWPIU06rIGFotmoDVDviW_os(GameServiceProviderInstanceImpl r0, SurfaceControl r1, int r2, AndroidFuture r3, GameSessionRecord r4) {
        r0.lambda$takeScreenshot$5(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$zQZdYbclR8S-pnnmQrhsovBnzC8, reason: not valid java name */
    public static /* synthetic */ void m1657$r8$lambda$zQZdYbclR8SpnnmQrhsovBnzC8(GameServiceProviderInstanceImpl r0, GameSessionRecord r1, int r2, CreateGameSessionResult r3, Throwable r4) {
        r0.lambda$createGameSessionLocked$2(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackgroundExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Executor m1658$$Nest$fgetmBackgroundExecutor(GameServiceProviderInstanceImpl r0) {
        return r0.mBackgroundExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGameServiceController, reason: not valid java name */
    static /* bridge */ /* synthetic */ IGameServiceController m1659$$Nest$fgetmGameServiceController(GameServiceProviderInstanceImpl r0) {
        return r0.mGameServiceController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1660$$Nest$fgetmLock(GameServiceProviderInstanceImpl r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateGameSession, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1661$$Nest$mcreateGameSession(GameServiceProviderInstanceImpl r0, int r1) {
        r0.createGameSession(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdestroyAndClearAllGameSessionsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1662$$Nest$mdestroyAndClearAllGameSessionsLocked(GameServiceProviderInstanceImpl r0) {
        r0.destroyAndClearAllGameSessionsLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$monForegroundActivitiesChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1663$$Nest$monForegroundActivitiesChanged(GameServiceProviderInstanceImpl r0, int r1) {
        r0.onForegroundActivitiesChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monProcessDied, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1664$$Nest$monProcessDied(GameServiceProviderInstanceImpl r0, int r1) {
        r0.onProcessDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monTaskCreated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1665$$Nest$monTaskCreated(GameServiceProviderInstanceImpl r0, int r1, ComponentName r2) {
        r0.onTaskCreated(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monTaskFocusChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1666$$Nest$monTaskFocusChanged(GameServiceProviderInstanceImpl r0, int r1, boolean r2) {
        r0.onTaskFocusChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monTaskRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1667$$Nest$monTaskRemoved(GameServiceProviderInstanceImpl r0, int r1) {
        r0.onTaskRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monTransientSystemBarsVisibilityChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1668$$Nest$monTransientSystemBarsVisibilityChanged(GameServiceProviderInstanceImpl r0, int r1, boolean r2, boolean r3) {
        r0.onTransientSystemBarsVisibilityChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mrestartGame, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1669$$Nest$mrestartGame(GameServiceProviderInstanceImpl r0, int r1) {
        r0.restartGame(r1);
    }

    GameServiceProviderInstanceImpl(UserHandle userHandle, Executor backgroundExecutor, Context context, GameTaskInfoProvider gameTaskInfoProvider, IActivityManager activityManager, ActivityManagerInternal activityManagerInternal, IActivityTaskManager activityTaskManager, WindowManagerService windowManagerService, WindowManagerInternal windowManagerInternal, ActivityTaskManagerInternal activityTaskManagerInternal, ServiceConnector<IGameService> gameServiceConnector, ServiceConnector<IGameSessionService> gameSessionServiceConnector, ScreenshotHelper screenshotHelper) {
        this.mGameServiceLifecycleCallbacks = new AnonymousClass1(this);
        this.mGameSessionServiceLifecycleCallbacks = new AnonymousClass2(this);
        this.mTaskSystemBarsVisibilityListener = new AnonymousClass3(this);
        this.mTaskStackListener = new AnonymousClass4(this);
        this.mProcessObserver = new AnonymousClass5(this);
        this.mGameServiceController = new AnonymousClass6(this);
        this.mGameSessionController = new AnonymousClass7(this);
        this.mLock = new Object();
        this.mGameSessions = new ConcurrentHashMap();
        this.mPidToPackageMap = new ConcurrentHashMap();
        this.mPackageNameToProcessCountMap = new ConcurrentHashMap();
        this.mUserHandle = userHandle;
        this.mBackgroundExecutor = backgroundExecutor;
        this.mContext = context;
        this.mGameTaskInfoProvider = gameTaskInfoProvider;
        this.mActivityManager = activityManager;
        this.mActivityManagerInternal = activityManagerInternal;
        this.mActivityTaskManager = activityTaskManager;
        this.mWindowManagerService = windowManagerService;
        this.mWindowManagerInternal = windowManagerInternal;
        this.mActivityTaskManagerInternal = activityTaskManagerInternal;
        this.mGameServiceConnector = gameServiceConnector;
        this.mGameSessionServiceConnector = gameSessionServiceConnector;
        this.mScreenshotHelper = screenshotHelper;
    }

    @Override // com.android.server.app.GameServiceProviderInstance
    public void start() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        startLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.app.GameServiceProviderInstance
    public void stop() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        stopLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void startLocked() {
        if (this.mIsRunning == false) goto L5;
        return;
    L5:
        this.mIsRunning = true;
        this.mGameServiceConnector.setServiceLifecycleCallbacks(this.mGameServiceLifecycleCallbacks);
        this.mGameSessionServiceConnector.setServiceLifecycleCallbacks(this.mGameSessionServiceLifecycleCallbacks);
        this.mGameServiceConnector.connect();
        this.mActivityTaskManager.registerTaskStackListener(this.mTaskStackListener);     // Catch: RemoteException -> L8
    L16:
        this.mActivityManager.registerProcessObserver(this.mProcessObserver);     // Catch: RemoteException -> L12
    L14:
        this.mWindowManagerInternal.registerTaskSystemBarsListener(this.mTaskSystemBarsVisibilityListener);
        return;
    L12:
        e = move-exception;
        Slog.w(TAG, "Failed to register process observer", e);
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed to register task stack listener", e);
        goto L16
    }

    private void stopLocked() {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        this.mIsRunning = false;
        this.mActivityManager.unregisterProcessObserver(this.mProcessObserver);     // Catch: RemoteException -> L8
    L16:
        this.mActivityTaskManager.unregisterTaskStackListener(this.mTaskStackListener);     // Catch: RemoteException -> L12
    L14:
        this.mWindowManagerInternal.unregisterTaskSystemBarsListener(this.mTaskSystemBarsVisibilityListener);
        destroyAndClearAllGameSessionsLocked();
        this.mGameServiceConnector.post(new GameServiceProviderInstanceImpl$$ExternalSyntheticLambda1()).whenComplete(new GameServiceProviderInstanceImpl$$ExternalSyntheticLambda2(this));
        this.mGameSessionServiceConnector.unbind();
        this.mGameServiceConnector.setServiceLifecycleCallbacks(null);
        this.mGameSessionServiceConnector.setServiceLifecycleCallbacks(null);
        return;
    L12:
        e = move-exception;
        Slog.w(TAG, "Failed to unregister task stack listener", e);
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed to unregister process observer", e);
        goto L16
    }

    private /* synthetic */ void lambda$stopLocked$0(Void result, Throwable t) {
        this.mGameServiceConnector.unbind();
    }

    private void onTaskCreated(int taskId, ComponentName componentName) {
        GameTaskInfo taskInfo = this.mGameTaskInfoProvider.get(taskId, componentName);
        if (taskInfo.mIsGameTask == true) goto L5;
        return;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        gameTaskStartedLocked(taskInfo);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onTaskFocusChanged(int taskId, boolean focused) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onTaskFocusChangedLocked(taskId, focused);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onTaskFocusChangedLocked(int taskId, boolean focused) {
        GameSessionRecord gameSessionRecord = this.mGameSessions.get(Integer.valueOf(taskId));
        if (gameSessionRecord != null) goto L8;
        if (focused == false) goto L17;
        maybeCreateGameSessionForFocusedTaskLocked(taskId);
        return;
    L17:
        return;
    L8:
        if (gameSessionRecord.getGameSession() != null) goto L15;
        return;
    L15:
        gameSessionRecord.getGameSession().onTaskFocusChanged(focused);     // Catch: RemoteException -> L12
        return;
    L13:
        Slog.w(TAG, "Failed to notify session of task focus change: " + gameSessionRecord);
    }

    private void maybeCreateGameSessionForFocusedTaskLocked(int taskId) {
        GameTaskInfo taskInfo = this.mGameTaskInfoProvider.get(taskId);
        if (taskInfo != null) goto L7;
        Slog.w(TAG, "No task info for focused task: " + taskId);
        return;
    L7:
        if (taskInfo.mIsGameTask == true) goto L9;
        return;
    L9:
        gameTaskStartedLocked(taskInfo);
    }

    private void gameTaskStartedLocked(final GameTaskInfo gameTaskInfo) {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        GameSessionRecord existingGameSessionRecord = this.mGameSessions.get(Integer.valueOf(gameTaskInfo.mTaskId));
        if (existingGameSessionRecord == null) goto L9;
        Slog.w(TAG, "Existing game session found for task (id: " + gameTaskInfo.mTaskId + ") creation. Ignoring.");
        return;
    L9:
        GameSessionRecord gameSessionRecord = GameSessionRecord.awaitingGameSessionRequest(gameTaskInfo.mTaskId, gameTaskInfo.mComponentName);
        this.mGameSessions.put(Integer.valueOf(gameTaskInfo.mTaskId), gameSessionRecord);
        this.mGameServiceConnector.post(new GameServiceProviderInstanceImpl$$ExternalSyntheticLambda3(gameTaskInfo));
    }

    private static /* synthetic */ void lambda$gameTaskStartedLocked$1(GameTaskInfo gameTaskInfo, IGameService gameService) throws Exception {
        gameService.gameStarted(new GameStartedEvent(gameTaskInfo.mTaskId, gameTaskInfo.mComponentName.getPackageName()));
    }

    private void onTaskRemoved(int taskId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean isTaskAssociatedWithGameSession = this.mGameSessions.containsKey(Integer.valueOf(taskId));     // Catch: Throwable -> L8
        if (isTaskAssociatedWithGameSession == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        removeAndDestroyGameSessionIfNecessaryLocked(taskId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void onTransientSystemBarsVisibilityChanged(int taskId, boolean visible, boolean wereRevealedFromSwipeOnSystemBar) {
        if (visible == false) goto L5;
        if (wereRevealedFromSwipeOnSystemBar == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        GameSessionRecord gameSessionRecord = this.mGameSessions.get(Integer.valueOf(taskId));     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        if (gameSessionRecord != null) goto L11;
        return;
    L11:
        IGameSession gameSession = gameSessionRecord.getGameSession();
        if (gameSession != null) goto L22;
        return;
    L22:
        gameSession.onTransientSystemBarVisibilityFromRevealGestureChanged(visible);     // Catch: RemoteException -> L16
        return;
    L17:
        Slog.w(TAG, "Failed to send transient system bars visibility from reveal gesture for task: " + taskId);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private void createGameSession(int taskId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        createGameSessionLocked(taskId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void createGameSessionLocked(final int taskId) {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        final GameSessionRecord existingGameSessionRecord = this.mGameSessions.get(Integer.valueOf(taskId));
        if (existingGameSessionRecord != null) goto L10;
        Slog.w(TAG, "No existing game session record found for task (id: " + taskId + ") creation. Ignoring.");
        return;
    L10:
        if (existingGameSessionRecord.isAwaitingGameSessionRequest() == true) goto L13;
        Slog.w(TAG, "Existing game session for task (id: " + taskId + ") is not awaiting game session request. Ignoring.");
        return;
    L13:
        final GameSessionViewHostConfiguration gameSessionViewHostConfiguration = createViewHostConfigurationForTask(taskId);
        if (gameSessionViewHostConfiguration != null) goto L17;
        Slog.w(TAG, "Failed to create view host configuration for task (id" + taskId + ") creation. Ignoring.");
        return;
    L17:
        this.mGameSessions.put(Integer.valueOf(taskId), existingGameSessionRecord.withGameSessionRequested());
        final AndroidFuture<CreateGameSessionResult> createGameSessionResultFuture = new AndroidFuture().orTimeout(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY, TimeUnit.MILLISECONDS).whenCompleteAsync(new GameServiceProviderInstanceImpl$$ExternalSyntheticLambda4(this, existingGameSessionRecord, taskId), this.mBackgroundExecutor);
        this.mGameSessionServiceConnector.post(new GameServiceProviderInstanceImpl$$ExternalSyntheticLambda5(this, taskId, existingGameSessionRecord, gameSessionViewHostConfiguration, createGameSessionResultFuture));
    }

    private /* synthetic */ void lambda$createGameSessionLocked$2(GameSessionRecord existingGameSessionRecord, int taskId, CreateGameSessionResult createGameSessionResult, Throwable exception) {
        if (exception != null) goto L14;
        if (createGameSessionResult == null) goto L14;
        Object r0 = this.mLock;
        monitor-enter(r0);
        attachGameSessionLocked(taskId, createGameSessionResult);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        setGameSessionFocusedIfNecessary(taskId, createGameSessionResult.getGameSession());
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        Slog.w(TAG, "Failed to create GameSession: " + existingGameSessionRecord, exception);
        Object r1 = this.mLock;
        monitor-enter(r1);
        removeAndDestroyGameSessionIfNecessaryLocked(taskId);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$createGameSessionLocked$3(int taskId, GameSessionRecord existingGameSessionRecord, GameSessionViewHostConfiguration gameSessionViewHostConfiguration, AndroidFuture createGameSessionResultFuture, IGameSessionService gameSessionService) throws Exception {
        CreateGameSessionRequest createGameSessionRequest = new CreateGameSessionRequest(taskId, existingGameSessionRecord.getComponentName().getPackageName());
        gameSessionService.create(this.mGameSessionController, createGameSessionRequest, gameSessionViewHostConfiguration, createGameSessionResultFuture);
    }

    private void setGameSessionFocusedIfNecessary(int taskId, IGameSession gameSession) {
        ActivityTaskManager.RootTaskInfo rootTaskInfo = this.mActivityTaskManager.getFocusedRootTaskInfo();     // Catch: RemoteException -> L8
        if (rootTaskInfo != null) goto L5;
        return;
    L5:
        if (rootTaskInfo.taskId != taskId) goto L16;
        gameSession.onTaskFocusChanged(true);     // Catch: RemoteException -> L8
        return;
    L16:
        return;
    L11:
        Slog.w(TAG, "Failed to set task focused for ID: " + taskId);
    }

    private void attachGameSessionLocked(int taskId, CreateGameSessionResult createGameSessionResult) {
        GameSessionRecord gameSessionRecord = this.mGameSessions.get(Integer.valueOf(taskId));
        if (gameSessionRecord != null) goto L7;
        Slog.w(TAG, "No associated game session record. Destroying id: " + taskId);
        destroyGameSessionDuringAttach(taskId, createGameSessionResult);
        return;
    L7:
        if (gameSessionRecord.isGameSessionRequested() == true) goto L16;
        destroyGameSessionDuringAttach(taskId, createGameSessionResult);
        return;
    L16:
        this.mWindowManagerInternal.addTrustedTaskOverlay(taskId, createGameSessionResult.getSurfacePackage());     // Catch: IllegalArgumentException -> L13
        this.mGameSessions.put(Integer.valueOf(taskId), gameSessionRecord.withGameSession(createGameSessionResult.getGameSession(), createGameSessionResult.getSurfacePackage()));
        return;
    L14:
        Slog.w(TAG, "Failed to add task overlay. Destroying id: " + taskId);
        destroyGameSessionDuringAttach(taskId, createGameSessionResult);
    }

    private void destroyAndClearAllGameSessionsLocked() {
        Iterator<GameSessionRecord> r0 = this.mGameSessions.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        GameSessionRecord gameSessionRecord = r0.next();
        destroyGameSessionFromRecordLocked(gameSessionRecord);
        goto L4
    L6:
        this.mGameSessions.clear();
    }

    private void destroyGameSessionDuringAttach(int taskId, CreateGameSessionResult createGameSessionResult) {
        createGameSessionResult.getGameSession().onDestroyed();     // Catch: RemoteException -> L4
        return;
    L5:
        Slog.w(TAG, "Failed to destroy session: " + taskId);
    }

    private void removeAndDestroyGameSessionIfNecessaryLocked(int taskId) {
        GameSessionRecord gameSessionRecord = this.mGameSessions.remove(Integer.valueOf(taskId));
        if (gameSessionRecord != null) goto L5;
        return;
    L5:
        destroyGameSessionFromRecordLocked(gameSessionRecord);
    }

    private void destroyGameSessionFromRecordLocked(GameSessionRecord gameSessionRecord) {
        SurfaceControlViewHost.SurfacePackage surfacePackage = gameSessionRecord.getSurfacePackage();
        if (surfacePackage != null) goto L20;
    L8:
        IGameSession gameSession = gameSessionRecord.getGameSession();
        if (gameSession == null) goto L15;
        gameSession.onDestroyed();     // Catch: RemoteException -> L12
    L12:
        ex = move-exception;
        Slog.w(TAG, "Failed to destroy session: " + gameSessionRecord, ex);
    L15:
        if (this.mGameSessions.isEmpty() == false) goto L22;
        this.mGameSessionServiceConnector.unbind();
        return;
    L22:
        return;
    L20:
        this.mWindowManagerInternal.removeTrustedTaskOverlay(gameSessionRecord.getTaskId(), surfacePackage);     // Catch: IllegalArgumentException -> L6
    L7:
        Slog.i(TAG, "Failed to remove task overlay. This is expected if the task is already destroyed: " + gameSessionRecord);
        goto L8
    }

    private void onForegroundActivitiesChanged(int pid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onForegroundActivitiesChangedLocked(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onForegroundActivitiesChangedLocked(int pid) {
        if (this.mPidToPackageMap.containsKey(Integer.valueOf(pid)) == false) goto L5;
        return;
    L5:
        String packageName = this.mActivityManagerInternal.getPackageNameByPid(pid);
        if (TextUtils.isEmpty(packageName) == false) goto L9;
        return;
    L9:
        if (gameSessionExistsForPackageNameLocked(packageName) == true) goto L11;
        return;
    L11:
        this.mPidToPackageMap.put(Integer.valueOf(pid), packageName);
        int processCountForPackage = this.mPackageNameToProcessCountMap.getOrDefault(packageName, 0).intValue() + 1;
        this.mPackageNameToProcessCountMap.put(packageName, Integer.valueOf(processCountForPackage));
        if (processCountForPackage <= 0) goto L15;
        recreateEndedGameSessionsLocked(packageName);
        return;
    }

    private void recreateEndedGameSessionsLocked(String packageName) {
        Iterator<GameSessionRecord> r0 = this.mGameSessions.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        GameSessionRecord gameSessionRecord = r0.next();
        if (gameSessionRecord.isGameSessionEndedForProcessDeath() == false) goto L4;
        if (packageName.equals(gameSessionRecord.getComponentName().getPackageName()) == false) goto L4;
        int taskId = gameSessionRecord.getTaskId();
        this.mGameSessions.put(Integer.valueOf(taskId), GameSessionRecord.awaitingGameSessionRequest(taskId, gameSessionRecord.getComponentName()));
        createGameSessionLocked(gameSessionRecord.getTaskId());
        goto L4
    }

    private void onProcessDied(int pid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onProcessDiedLocked(pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onProcessDiedLocked(int pid) {
        String packageName = this.mPidToPackageMap.remove(Integer.valueOf(pid));
        if (packageName != null) goto L5;
        return;
    L5:
        Integer oldProcessCountForPackage = this.mPackageNameToProcessCountMap.get(packageName);
        if (oldProcessCountForPackage != null) goto L9;
        Slog.w(TAG, "onProcessDiedLocked(): Missing process count for package");
        return;
    L9:
        int processCountForPackage = oldProcessCountForPackage.intValue() - 1;
        this.mPackageNameToProcessCountMap.put(packageName, Integer.valueOf(processCountForPackage));
        if (processCountForPackage > 0) goto L13;
        endGameSessionsForPackageLocked(packageName);
        return;
    }

    private void endGameSessionsForPackageLocked(String packageName) {
        Iterator<GameSessionRecord> r0 = this.mGameSessions.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        GameSessionRecord gameSessionRecord = r0.next();
        if (gameSessionRecord.getGameSession() == null) goto L4;
        if (packageName.equals(gameSessionRecord.getComponentName().getPackageName()) == false) goto L4;
        ActivityManager.RunningTaskInfo runningTaskInfo = this.mGameTaskInfoProvider.getRunningTaskInfo(gameSessionRecord.getTaskId());
        if (runningTaskInfo == null) goto L14;
        if (runningTaskInfo.isVisible == true) goto L4;
    L14:
        this.mGameSessions.put(Integer.valueOf(gameSessionRecord.getTaskId()), gameSessionRecord.withGameSessionEndedOnProcessDeath());
        destroyGameSessionFromRecordLocked(gameSessionRecord);
        goto L4
    }

    private boolean gameSessionExistsForPackageNameLocked(String packageName) {
        Iterator<GameSessionRecord> r0 = this.mGameSessions.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        GameSessionRecord gameSessionRecord = r0.next();
        if (packageName.equals(gameSessionRecord.getComponentName().getPackageName()) == false) goto L4;
        return true;
    L10:
        return false;
    }

    private GameSessionViewHostConfiguration createViewHostConfigurationForTask(int taskId) {
        ActivityManager.RunningTaskInfo runningTaskInfo = this.mGameTaskInfoProvider.getRunningTaskInfo(taskId);
        if (runningTaskInfo != null) goto L6;
        return null;
    L6:
        Rect bounds = runningTaskInfo.configuration.windowConfiguration.getBounds();
        return new GameSessionViewHostConfiguration(runningTaskInfo.displayId, bounds.width(), bounds.height());
    }

    void takeScreenshot(final int taskId, final AndroidFuture callback) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        final GameSessionRecord gameSessionRecord = this.mGameSessions.get(Integer.valueOf(taskId));     // Catch: Throwable -> L20
        if (gameSessionRecord == null) goto L26;
        monitor-exit(r1);     // Catch: Throwable -> L20
        SurfaceControlViewHost.SurfacePackage overlaySurfacePackage = gameSessionRecord.getSurfacePackage();
        if (overlaySurfacePackage == null) goto L17;
        SurfaceControl r2 = overlaySurfacePackage.getSurfaceControl();
    L16:
        final SurfaceControl overlaySurfaceControl = r2;
        this.mBackgroundExecutor.execute(new GameServiceProviderInstanceImpl$$ExternalSyntheticLambda0(this, overlaySurfaceControl, taskId, callback, gameSessionRecord));
        return;
    L17:
        r2 = null;
        goto L16
    L26:
        Slog.w(TAG, "No game session found for id: " + taskId);     // Catch: Throwable -> L10
        callback.complete(GameScreenshotResult.createInternalErrorResult());     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = th;
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L24
        throw th;
    L24:
        th = th;
    L20:
        th = th;
        goto L30
    }

    private /* synthetic */ void lambda$takeScreenshot$5(SurfaceControl overlaySurfaceControl, int taskId, final AndroidFuture callback, GameSessionRecord gameSessionRecord) {
        ScreenCapture.LayerCaptureArgs.Builder layerCaptureArgsBuilder = new ScreenCapture.LayerCaptureArgs.Builder(null);
        if (overlaySurfaceControl == null) goto L5;
        SurfaceControl[] excludeLayers = {overlaySurfaceControl};
        layerCaptureArgsBuilder.setExcludeLayers(excludeLayers);
    L5:
        Bitmap bitmap = this.mWindowManagerService.captureTaskBitmap(taskId, layerCaptureArgsBuilder);
        if (bitmap != null) goto L8;
        Slog.w(TAG, "Could not get bitmap for id: " + taskId);
        callback.complete(GameScreenshotResult.createInternalErrorResult());
        return;
    L8:
        ActivityManager.RunningTaskInfo runningTaskInfo = this.mGameTaskInfoProvider.getRunningTaskInfo(taskId);
        if (runningTaskInfo != null) goto L11;
        Slog.w(TAG, "Could not get running task info for id: " + taskId);
        callback.complete(GameScreenshotResult.createInternalErrorResult());
    L11:
        Rect crop = runningTaskInfo.configuration.windowConfiguration.getBounds();
        Consumer<Uri> completionConsumer = new GameServiceProviderInstanceImpl$$ExternalSyntheticLambda6(callback);
        ScreenshotRequest request = new ScreenshotRequest.Builder(3, 5).setTopComponent(gameSessionRecord.getComponentName()).setTaskId(taskId).setUserId(this.mUserHandle.getIdentifier()).setBitmap(bitmap).setBoundsOnScreen(crop).setInsets(Insets.NONE).build();
        this.mScreenshotHelper.takeScreenshot(request, BackgroundThread.getHandler(), completionConsumer);
    }

    private static /* synthetic */ void lambda$takeScreenshot$4(AndroidFuture callback, Uri uri) {
        if (uri != null) goto L4;
        callback.complete(GameScreenshotResult.createInternalErrorResult());
        return;
    L4:
        callback.complete(GameScreenshotResult.createSuccessResult());
    }

    private void restartGame(int taskId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        GameSessionRecord gameSessionRecord = this.mGameSessions.get(Integer.valueOf(taskId));     // Catch: Throwable -> L8
        if (gameSessionRecord != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        String packageName = gameSessionRecord.getComponentName().getPackageName();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (packageName != null) goto L14;
        return;
    L14:
        this.mActivityTaskManagerInternal.restartTaskActivityProcessIfVisible(taskId, packageName);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
