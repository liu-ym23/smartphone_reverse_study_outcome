package com.android.server.wm;

import android.os.HandlerExecutor;
import android.util.ArrayMap;
import android.util.BoostFramework;
import android.util.Slog;
import android.view.IExtWindowManager;
import android.view.SurfaceControl;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.android.server.ISmtResourceControl;
import com.android.server.SysOptBridge;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
class AsyncRotationController extends FadeAnimationController implements Consumer<WindowState> {
    private static final boolean DEBUG = false;
    private static final int OP_APP_SWITCH = 1;
    private static final int OP_CHANGE = 2;
    private static final int OP_CHANGE_MAY_SEAMLESS = 3;
    private static final int OP_LEGACY = 0;
    private static final String TAG = "AsyncRotation";
    private final boolean mHasScreenRotationAnimation;
    private boolean mHideImmediately;
    private boolean mIsLatencyPerfLockAcquired;
    private boolean mIsStartTransactionCommitted;
    private boolean mIsStartTransactionPrepared;
    private boolean mIsSyncDrawRequested;
    private WindowToken mNavBarToken;
    private Runnable mOnShowRunnable;
    private int mOriginalRotation;
    private BoostFramework mPerf;
    private SeamlessRotator mRotator;
    private final WindowManagerService mService;
    private final ArrayMap<WindowToken, Operation> mTargetWindowTokens;
    private Runnable mTimeoutRunnable;
    private final int mTransitionOp;

    private static class Operation {
        static final int ACTION_FADE = 2;
        static final int ACTION_SEAMLESS = 1;
        static final int ACTION_TOGGLE_IME = 4;
        final int mActions;
        SurfaceControl.Transaction mDrawTransaction;
        boolean mIsCompletionPending;
        SurfaceControl mLeash;

        @Retention(RetentionPolicy.SOURCE)
        @interface Action {
        }

        Operation(int actions) {
            this.mActions = actions;
        }

        boolean isValidSeamless() {
            if ((this.mActions & 1) != 0) goto L5;
        L9:
            return false;
        L5:
            if (this.mLeash == null) goto L9;
            if (this.mLeash.isValid() == false) goto L9;
            return true;
        }

        public String toString() {
            return "Operation{a=" + this.mActions + " pending=" + this.mIsCompletionPending + '}';
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface TransitionOp {
    }

    public static /* synthetic */ void $r8$lambda$Oa6FtXbJwr3LMuRcvfY_AJCLKRk(AsyncRotationController r0) {
        r0.lambda$setupStartTransaction$4();
    }

    public static /* synthetic */ void $r8$lambda$PtCO_81xYwXV73uQFHrlsomD81E(SurfaceControl.Transaction r0) {
        lambda$keepAppearanceInPreviousRotation$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$jEAiEPvteaP_XtxOEwzemo2HPis(AsyncRotationController r0, int r1, AnimationAdapter r2) {
        r0.lambda$finishOp$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$rYwDFNOZAqwN3R8jlPun6FKFUpE(AsyncRotationController r0, WindowState r1) {
        r0.lambda$updateRotation$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$tZhELYMNbDKN9vJbgZinpPi7roU(AsyncRotationController r0) {
        r0.lambda$scheduleTimeout$3();
    }

    @Override // java.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(WindowState r1) {
        accept2(r1);
    }

    AsyncRotationController(DisplayContent displayContent) {
        super(displayContent);
        this.mTargetWindowTokens = new ArrayMap();
        this.mPerf = null;
        boolean r0 = false;
        this.mIsLatencyPerfLockAcquired = false;
        this.mService = displayContent.mWmService;
        this.mOriginalRotation = displayContent.getWindowConfiguration().getRotation();
        if (this.mPerf != null) goto L5;
        this.mPerf = new BoostFramework();
    L5:
        int transitionType = displayContent.mTransitionController.getCollectingTransitionType();
        if (transitionType != 6) goto L19;
        DisplayRotation dr = displayContent.getDisplayRotation();
        WindowState w = displayContent.getDisplayPolicy().getTopFullscreenOpaqueWindow();
        if (w != null) goto L10;
    L16:
        this.mTransitionOp = 2;
    L23:
        if (this.mTransitionOp != 2) goto L25;
        r0 = true;
    L25:
        this.mHasScreenRotationAnimation = r0;
        if (this.mHasScreenRotationAnimation == false) goto L28;
        this.mHideImmediately = true;
    L28:
        displayContent.forAllWindows(this, true);
        if (this.mTransitionOp != 0) goto L32;
        this.mIsStartTransactionCommitted = true;
        return;
    L32:
        if (displayContent.mTransitionController.isCollecting(displayContent) == false) goto L36;
        keepAppearanceInPreviousRotation();
        return;
    L36:
        return;
    L10:
        if (w.mAttrs.rotationAnimation != 3) goto L16;
        if (w.getTask() == null) goto L16;
        if (dr.canRotateSeamlessly(this.mOriginalRotation, dr.getRotation()) == false) goto L16;
        this.mTransitionOp = 3;
        goto L23
    L19:
        if (displayContent.mTransitionController.isShellTransitionsEnabled() == false) goto L21;
        this.mTransitionOp = 1;
        goto L23
    L21:
        this.mTransitionOp = 0;
        goto L23
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(WindowState w) {
        if (w.mHasSurface == true) goto L5;
        return;
    L5:
        if (canBeAsync(w.mToken) == true) goto L8;
        return;
    L8:
        if (this.mTransitionOp != 0) goto L13;
        if (w.mForceSeamlesslyRotate == false) goto L13;
        return;
    L13:
        if (w.mAttrs.type != 2019) goto L27;
        int action = 2;
        boolean navigationBarCanMove = this.mDisplayContent.getDisplayPolicy().navigationBarCanMove();
        if (this.mTransitionOp != 0) goto L19;
        this.mNavBarToken = w.mToken;
        if (navigationBarCanMove == false) goto L25;
        return;
    L25:
        this.mTargetWindowTokens.put(w.mToken, new Operation(action));
        return;
    L19:
        if (navigationBarCanMove == false) goto L21;
    L24:
        action = 1;
        goto L25
    L21:
        if (this.mTransitionOp == 3) goto L24;
        if (this.mDisplayContent.mTransitionController.mNavigationBarAttachedToApp == false) goto L25;
    L27:
        int action2 = this.mTransitionOp;
        if (action2 != 3) goto L30;
    L33:
        int action3 = 1;
    L34:
        this.mTargetWindowTokens.put(w.mToken, new Operation(action3));
        return;
    L30:
        if (w.mForceSeamlesslyRotate == true) goto L33;
        action3 = 2;
        goto L34
    }

    static boolean canBeAsync(WindowToken token) {
        int type = token.windowType;
        if (IExtWindowManager.isIsland(type) == false) goto L6;
        return false;
    L6:
        if (type > 99) goto L8;
        return false;
    L8:
        if (type != 2011) goto L10;
        return false;
    L10:
        if (type != 2013) goto L12;
        return false;
    L12:
        if (type == 2040) goto L18;
        return true;
    L18:
        return false;
    }

    void keepAppearanceInPreviousRotation() {
        if (this.mIsSyncDrawRequested == false) goto L5;
        return;
    L5:
        int i = this.mTargetWindowTokens.size() - 1;
    L6:
        if (i < 0) goto L14;
        if (canDrawBeforeStartTransaction(this.mTargetWindowTokens.valueAt(i)) == true) goto L13;
        WindowToken token = this.mTargetWindowTokens.keyAt(i);
        int j = token.getChildCount() - 1;
    L11:
        if (j < 0) goto L13;
        token.getChildAt(j).applyWithNextDraw(new AsyncRotationController$$ExternalSyntheticLambda3());
        j = j - 1;
    L13:
        i = i - 1;
        goto L6
    L14:
        this.mIsSyncDrawRequested = true;
    }

    private static /* synthetic */ void lambda$keepAppearanceInPreviousRotation$0(SurfaceControl.Transaction t) {
    }

    void updateTargetWindows() {
        if (this.mTransitionOp != 0) goto L6;
        return;
    L6:
        if (this.mIsStartTransactionCommitted == false) goto L8;
        int i = this.mTargetWindowTokens.size() - 1;
    L20:
        if (i < 0) goto L39;
        Operation op = this.mTargetWindowTokens.valueAt(i);
        if (op.mIsCompletionPending == true) goto L37;
        if (op.mActions == 1) goto L37;
        WindowToken token = this.mTargetWindowTokens.keyAt(i);
        int readyCount = 0;
        int childCount = token.getChildCount();
        int j = childCount - 1;
    L27:
        if (j < 0) goto L35;
        WindowState w = token.getChildAt(j);
        if (w.isDrawn() == false) goto L31;
    L32:
        readyCount = readyCount + 1;
    L33:
        j = j - 1;
        goto L27
    L31:
        if (w.mWinAnimator.getShown() == true) goto L33;
    L35:
        if (readyCount != childCount) goto L37;
        this.mDisplayContent.finishAsyncRotation(token);
    L37:
        i = i - 1;
        goto L20
    L39:
        return;
    L8:
        if (this.mTimeoutRunnable == null) goto L12;
        if (this.mIsStartTransactionPrepared == false) goto L12;
        return;
    L12:
        if (this.mDisplayContent.hasTopFixedRotationLaunchingApp() == false) goto L14;
        return;
    L14:
        if (this.mDisplayContent.isRotationChanging() == false) goto L16;
        return;
    L16:
        if (this.mDisplayContent.inTransition() == true) goto L51;
        Slog.d(TAG, "Cancel for no change");
        this.mDisplayContent.finishAsyncRotationIfPossible();
        return;
    }

    private void finishOp(WindowToken windowToken) {
        Operation op = this.mTargetWindowTokens.remove(windowToken);
        if (op != null) goto L6;
        return;
    L6:
        if (op.mDrawTransaction == null) goto L9;
        windowToken.getSyncTransaction().merge(op.mDrawTransaction);
        op.mDrawTransaction = null;
    L9:
        if (op.mActions != 4) goto L12;
        fadeWindowToken(true, windowToken, 64, new AsyncRotationController$$ExternalSyntheticLambda0(this));
    L15:
        if (op.isValidSeamless() == false) goto L18;
        SurfaceControl.Transaction t = windowToken.getSyncTransaction();
        clearTransform(t, op.mLeash);
    L18:
        if (isSeamlessTransition() == false) goto L25;
        int i = windowToken.getChildCount() - 1;
    L20:
        if (i < 0) goto L29;
        WindowState w = windowToken.getChildAt(i);
        InsetsSourceProvider insetsProvider = w.getControllableInsetProvider();
        if (insetsProvider == null) goto L24;
        insetsProvider.updateInsetsControlPosition(w);
    L24:
        i = i - 1;
        goto L20
    L29:
        return;
    L25:
        return;
    L12:
        if ((op.mActions & 2) == 0) goto L15;
        fadeWindowToken(true, windowToken, 64);
        goto L15
    }

    private /* synthetic */ void lambda$finishOp$1(int type, AnimationAdapter anim) {
        this.mDisplayContent.getInsetsStateController().getImeSourceProvider().reportImeDrawnForOrganizer();
    }

    private static void clearTransform(SurfaceControl.Transaction t, SurfaceControl sc) {
        t.setMatrix(sc, 1.0f, 0.0f, 0.0f, 1.0f);
        t.setPosition(sc, 0.0f, 0.0f);
    }

    void completeAll() {
        int i = this.mTargetWindowTokens.size() - 1;
    L3:
        if (i < 0) goto L5;
        finishOp(this.mTargetWindowTokens.keyAt(i));
        i = i - 1;
        goto L3
    L5:
        this.mTargetWindowTokens.clear();
        onAllCompleted();
    }

    private void onAllCompleted() {
        if (this.mTimeoutRunnable == null) goto L6;
        this.mService.mH.removeCallbacks(this.mTimeoutRunnable);
    L6:
        if (this.mOnShowRunnable == null) goto L9;
        this.mOnShowRunnable.run();
        this.mOnShowRunnable = null;
        return;
    }

    boolean completeRotation(WindowToken token) {
        if (this.mIsStartTransactionCommitted == true) goto L9;
        Operation op = this.mTargetWindowTokens.get(token);
        if (op == null) goto L7;
        op.mIsCompletionPending = true;
    L7:
        return false;
    L9:
        if (this.mTransitionOp != 1) goto L18;
        if (token.mTransitionController.inTransition() == false) goto L18;
        Operation op2 = this.mTargetWindowTokens.get(token);
        if (op2 == null) goto L18;
        if (op2.mActions != 2) goto L18;
        return false;
    L18:
        if (isTargetToken(token) == true) goto L21;
        return false;
    L21:
        if (this.mHasScreenRotationAnimation == false) goto L23;
    L24:
        finishOp(token);
        if (this.mTargetWindowTokens.isEmpty() == true) goto L27;
    L33:
        return false;
    L27:
        if (this.mPerf != null) goto L29;
    L31:
        onAllCompleted();
        return true;
    L29:
        if (this.mIsLatencyPerfLockAcquired == false) goto L31;
        this.mPerf.perfLockRelease();
        this.mIsLatencyPerfLockAcquired = false;
        goto L31
    L23:
        if (this.mTransitionOp == 0) goto L33;
        goto L24
    }

    void start() {
        if (this.mPerf == null) goto L5;
        SysOptBridge.getFactory().getBoostFrameworkService().perfLockAcquire(4233);
        this.mIsLatencyPerfLockAcquired = true;
    L5:
        int i = this.mTargetWindowTokens.size() - 1;
    L6:
        if (i < 0) goto L18;
        WindowToken windowToken = this.mTargetWindowTokens.keyAt(i);
        Operation op = this.mTargetWindowTokens.valueAt(i);
        if ((op.mActions & 2) == 0) goto L10;
    L15:
        fadeWindowToken(false, windowToken, 64);
        op.mLeash = windowToken.getAnimationLeash();
    L16:
        i = i - 1;
        goto L6
    L10:
        if (op.mActions == 4) goto L15;
        if (op.mActions != 1) goto L16;
        op.mLeash = windowToken.mSurfaceControl;
        goto L16
    L18:
        if (this.mHasScreenRotationAnimation == false) goto L25;
        scheduleTimeout();
        return;
    }

    void updateRotation() {
        if (this.mRotator != null) goto L5;
        return;
    L5:
        int currentRotation = this.mDisplayContent.getWindowConfiguration().getRotation();
        if (this.mOriginalRotation != currentRotation) goto L8;
        return;
    L8:
        Slog.d(TAG, "Update original rotation " + currentRotation);
        this.mOriginalRotation = currentRotation;
        this.mDisplayContent.forAllWindows(new AsyncRotationController$$ExternalSyntheticLambda2(this), true);
        this.mRotator = null;
        this.mIsStartTransactionCommitted = false;
        this.mIsSyncDrawRequested = false;
        keepAppearanceInPreviousRotation();
    }

    private /* synthetic */ void lambda$updateRotation$2(WindowState w) {
        if (w.mForceSeamlesslyRotate == true) goto L5;
        return;
    L5:
        if (w.mHasSurface == true) goto L7;
        return;
    L7:
        if (this.mTargetWindowTokens.containsKey(w.mToken) == true) goto L12;
        Operation op = new Operation(1);
        op.mLeash = w.mToken.mSurfaceControl;
        this.mTargetWindowTokens.put(w.mToken, op);
        return;
    }

    private void scheduleTimeout() {
        if (this.mTimeoutRunnable != null) goto L5;
        this.mTimeoutRunnable = new AsyncRotationController$$ExternalSyntheticLambda1(this);
    L5:
        this.mService.mH.postDelayed(this.mTimeoutRunnable, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
    }

    private /* synthetic */ void lambda$scheduleTimeout$3() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mIsStartTransactionCommitted == false) goto L7;
        String reason = "unfinished windows " + this.mTargetWindowTokens;     // Catch: Throwable -> L9
    L13:
        Slog.i(TAG, "Async rotation timeout: " + reason);     // Catch: Throwable -> L9
        if (this.mIsStartTransactionCommitted == false) goto L16;
    L20:
        this.mDisplayContent.finishAsyncRotationIfPossible();     // Catch: Throwable -> L9
        this.mService.mWindowPlacerLocked.performSurfacePlacement();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L16:
        if (this.mIsStartTransactionPrepared == false) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        if (this.mIsStartTransactionPrepared == true) goto L11;
        reason = "setupStartTransaction is not called";
        goto L13
    L11:
        reason = "start transaction is not committed";
        goto L13
    }

    void hideImeImmediately() {
        if (this.mDisplayContent.mInputMethodWindow != null) goto L5;
        return;
    L5:
        WindowToken imeWindowToken = this.mDisplayContent.mInputMethodWindow.mToken;
        if (isTargetToken(imeWindowToken) == false) goto L8;
        return;
    L8:
        hideImmediately(imeWindowToken, 4);
    }

    private void hideImmediately(WindowToken token, int action) {
        boolean original = this.mHideImmediately;
        this.mHideImmediately = true;
        Operation op = new Operation(action);
        this.mTargetWindowTokens.put(token, op);
        fadeWindowToken(false, token, 64);
        op.mLeash = token.getAnimationLeash();
        this.mHideImmediately = original;
    }

    boolean isAsync(WindowState w) {
        if (w.mToken != this.mNavBarToken) goto L5;
    L12:
        return true;
    L5:
        if (w.mForceSeamlesslyRotate == false) goto L9;
        if (this.mTransitionOp == 0) goto L12;
    L9:
        if (isTargetToken(w.mToken) == true) goto L12;
        return false;
    }

    boolean isTargetToken(WindowToken token) {
        return this.mTargetWindowTokens.containsKey(token);
    }

    boolean hasFadeOperation(WindowToken token) {
        Operation op = this.mTargetWindowTokens.get(token);
        if (op != null) goto L5;
    L7:
        return false;
    L5:
        if ((op.mActions & 2) == 0) goto L7;
        return true;
    }

    boolean hasSeamlessOperation(WindowToken token) {
        Operation op = this.mTargetWindowTokens.get(token);
        if (op != null) goto L5;
    L7:
        return false;
    L5:
        if ((op.mActions & 1) == 0) goto L7;
        return true;
    }

    boolean shouldFreezeInsetsPosition(WindowState w) {
        if (this.mTransitionOp != 0) goto L5;
    L13:
        return false;
    L5:
        if (isSeamlessTransition() == true) goto L9;
        if (TransitionController.SYNC_METHOD != 1) goto L13;
    L9:
        if (canBeAsync(w.mToken) == false) goto L13;
        if (isTargetToken(w.mToken) == false) goto L13;
        return true;
    }

    private boolean isSeamlessTransition() {
        if (this.mTransitionOp != 1) goto L5;
        return true;
    L5:
        if (this.mTransitionOp == 3) goto L10;
        return false;
    L10:
        return true;
    }

    SurfaceControl.Transaction getDrawTransaction(WindowToken token) {
        if (this.mTransitionOp != 0) goto L5;
        return null;
    L5:
        Operation op = this.mTargetWindowTokens.get(token);
        if (op != null) goto L8;
        return null;
    L8:
        if (op.mDrawTransaction != null) goto L11;
        op.mDrawTransaction = new SurfaceControl.Transaction();
    L11:
        return op.mDrawTransaction;
    }

    void setOnShowRunnable(Runnable onShowRunnable) {
        this.mOnShowRunnable = onShowRunnable;
    }

    void setupStartTransaction(SurfaceControl.Transaction t) {
        if (this.mIsStartTransactionCommitted == false) goto L5;
        return;
    L5:
        int i = this.mTargetWindowTokens.size() - 1;
    L6:
        if (i < 0) goto L22;
        Operation op = this.mTargetWindowTokens.valueAt(i);
        SurfaceControl leash = op.mLeash;
        if (leash == null) goto L21;
        if (leash.isValid() == false) goto L21;
        if (this.mHasScreenRotationAnimation == false) goto L18;
        if (op.mActions != 2) goto L18;
        t.setAlpha(leash, 0.0f);
    L18:
        if (this.mRotator != null) goto L20;
        this.mRotator = new SeamlessRotator(this.mOriginalRotation, this.mDisplayContent.getWindowConfiguration().getRotation(), this.mDisplayContent.getDisplayInfo(), false);
    L20:
        this.mRotator.applyTransform(t, leash);
    L21:
        i = i - 1;
        goto L6
    L22:
        t.addTransactionCommittedListener(new HandlerExecutor(this.mService.mH), new AsyncRotationController$$ExternalSyntheticLambda4(this));
        this.mIsStartTransactionPrepared = true;
    }

    private /* synthetic */ void lambda$setupStartTransaction$4() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mIsStartTransactionCommitted = true;     // Catch: Throwable -> L10
        int i = this.mTargetWindowTokens.size() - 1;     // Catch: Throwable -> L10
    L6:
        if (i < 0) goto L14;
        if (this.mTargetWindowTokens.valueAt(i).mIsCompletionPending == false) goto L12;
        this.mDisplayContent.finishAsyncRotation(this.mTargetWindowTokens.keyAt(i));     // Catch: Throwable -> L10
    L12:
        i = i - 1;     // Catch: Throwable -> L10
        goto L6
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void onTransactionCommitTimeout(SurfaceControl.Transaction t) {
        if (this.mIsStartTransactionCommitted == false) goto L5;
        return;
    L5:
        int i = this.mTargetWindowTokens.size() - 1;
    L6:
        if (i < 0) goto L12;
        Operation op = this.mTargetWindowTokens.valueAt(i);
        op.mIsCompletionPending = true;
        if (op.isValidSeamless() == false) goto L10;
        Slog.d(TAG, "Transaction timeout. Clear transform for " + this.mTargetWindowTokens.keyAt(i).getTopChild());
        clearTransform(t, op.mLeash);
    L10:
        i = i - 1;
        goto L6
    }

    void onTransitionFinished() {
        if (this.mTransitionOp == 2) goto L5;
        int i = this.mTargetWindowTokens.size() - 1;
    L9:
        if (i < 0) goto L21;
        WindowToken token = this.mTargetWindowTokens.keyAt(i);
        if (token.isVisible() == true) goto L13;
        this.mDisplayContent.finishAsyncRotation(token);
    L19:
        i = i - 1;
        goto L9
    L13:
        int j = token.getChildCount() - 1;
    L14:
        if (j < 0) goto L19;
        if (token.getChildAt(j).isDrawFinishedLw() == true) goto L17;
        j = j - 1;
        goto L14
    L17:
        this.mDisplayContent.finishAsyncRotation(token);
        goto L19
    L21:
        if (this.mTargetWindowTokens.isEmpty() == true) goto L30;
        scheduleTimeout();
        return;
    L30:
        return;
    L5:
        if (this.mTargetWindowTokens.isEmpty() == false) goto L29;
        this.mDisplayContent.finishAsyncRotationIfPossible();
        return;
    }

    boolean handleFinishDrawing(WindowState w, SurfaceControl.Transaction postDrawTransaction) {
        if (this.mTransitionOp != 0) goto L5;
        return false;
    L5:
        Operation op = this.mTargetWindowTokens.get(w.mToken);
        if (op == null) goto L8;
        if (postDrawTransaction != null) goto L21;
    L34:
        this.mDisplayContent.finishAsyncRotation(w.mToken);
        return false;
    L21:
        if (this.mIsSyncDrawRequested == false) goto L34;
        if (canDrawBeforeStartTransaction(op) == true) goto L34;
        if (op.mDrawTransaction == null) goto L28;
        op.mDrawTransaction.merge(postDrawTransaction);
    L32:
        this.mDisplayContent.finishAsyncRotation(w.mToken);
        return true;
    L28:
        if (w.isClientLocal() == false) goto L30;
        op.mDrawTransaction = this.mService.mTransactionFactory.get();
        op.mDrawTransaction.merge(postDrawTransaction);
        goto L32
    L30:
        op.mDrawTransaction = postDrawTransaction;
        goto L32
    L8:
        if (this.mTransitionOp == 1) goto L10;
    L18:
        return false;
    L10:
        if (this.mIsStartTransactionCommitted == true) goto L18;
        if (canBeAsync(w.mToken) == false) goto L18;
        if (this.mDisplayContent.hasFixedRotationTransientLaunch() == true) goto L18;
        if (this.mService.mAtmService.mBackNavigationController.hasFixedRotationAnimation(this.mDisplayContent) == true) goto L18;
        hideImmediately(w.mToken, 2);
        goto L18
    }

    @Override // com.android.server.wm.FadeAnimationController
    public Animation getFadeInAnimation() {
        Animation anim = super.getFadeInAnimation();
        if (this.mHasScreenRotationAnimation == false) goto L5;
        anim.setDuration(getScaledDuration(200));
    L5:
        return anim;
    }

    @Override // com.android.server.wm.FadeAnimationController
    public Animation getFadeOutAnimation() {
        if (this.mHideImmediately == false) goto L11;
        if (this.mTransitionOp != 2) goto L7;
        float alpha = 1.0f;
    L9:
        return new AlphaAnimation(alpha, alpha);
    L7:
        alpha = 0.0f;
        goto L9
    L11:
        return super.getFadeOutAnimation();
    }

    private boolean canDrawBeforeStartTransaction(Operation op) {
        if ((op.mActions & 1) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "AsyncRotationController");
        String prefix2 = prefix + "  ";
        pw.println(prefix2 + "mTransitionOp=" + this.mTransitionOp);
        pw.println(prefix2 + "mIsStartTransactionCommitted=" + this.mIsStartTransactionCommitted);
        pw.println(prefix2 + "mIsSyncDrawRequested=" + this.mIsSyncDrawRequested);
        pw.println(prefix2 + "mOriginalRotation=" + this.mOriginalRotation);
        pw.println(prefix2 + "mTargetWindowTokens=" + this.mTargetWindowTokens);
    }
}
