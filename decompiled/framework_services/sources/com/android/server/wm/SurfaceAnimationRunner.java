package com.android.server.wm;

import android.animation.AnimationHandler;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.PowerManagerInternal;
import android.util.ArrayMap;
import android.view.Choreographer;
import android.view.SurfaceControl;
import com.android.internal.graphics.SfVsyncFrameCallbackProvider;
import com.android.server.AnimationThread;
import com.android.server.SysOptBridge;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class SurfaceAnimationRunner {
    private static final String TAG = null;
    private final AnimationHandler mAnimationHandler;
    private boolean mAnimationStartDeferred;
    private final Handler mAnimationThreadHandler;
    private final AnimatorFactory mAnimatorFactory;
    private boolean mApplyScheduled;
    private final Runnable mApplyTransactionRunnable;
    private final Object mCancelLock;
    Choreographer mChoreographer;
    private final SurfaceControl.Transaction mFrameTransaction;
    private final Object mLock;
    final ArrayMap<SurfaceControl, RunningAnimation> mPendingAnimations;
    private final PowerManagerInternal mPowerManagerInternal;
    final ArrayMap<SurfaceControl, RunningAnimation> mPreProcessingAnimations;
    final ArrayMap<SurfaceControl, RunningAnimation> mRunningAnimations;
    private final Handler mSurfaceAnimationHandler;

    interface AnimatorFactory {
        ValueAnimator makeAnimator();
    }

    private static final class RunningAnimation {
        ValueAnimator mAnim;
        final LocalAnimationAdapter.AnimationSpec mAnimSpec;
        private boolean mCancelled;
        final Runnable mFinishCallback;
        final SurfaceControl mLeash;

        /* JADX INFO: renamed from: -$$Nest$fgetmCancelled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10157$$Nest$fgetmCancelled(RunningAnimation r0) {
            return r0.mCancelled;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmCancelled, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10158$$Nest$fputmCancelled(RunningAnimation r0, boolean r1) {
            r0.mCancelled = r1;
        }

        RunningAnimation(LocalAnimationAdapter.AnimationSpec animSpec, SurfaceControl leash, Runnable finishCallback) {
            this.mAnimSpec = animSpec;
            this.mLeash = leash;
            this.mFinishCallback = finishCallback;
        }
    }

    private class SfValueAnimator extends ValueAnimator {
        final /* synthetic */ SurfaceAnimationRunner this$0;

        SfValueAnimator(SurfaceAnimationRunner r1) {
            this.this$0 = r1;
            setFloatValues(new float[]{0.0f, 1.0f});
        }

        public AnimationHandler getAnimationHandler() {
            return SurfaceAnimationRunner.m10152$$Nest$fgetmAnimationHandler(this.this$0);
        }
    }

    public static /* synthetic */ void $r8$lambda$ToSJy1KwSRMhh9jEX86pHrCMpsM(SurfaceAnimationRunner r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$XKYbomSeJZ5X1QvoC6W5WshA39k(SurfaceAnimationRunner r0, RunningAnimation r1, ValueAnimator r2, ValueAnimator r3) {
        r0.lambda$startAnimationLocked$3(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ZTJ0zv3TBWmm9N7PsMhXlrn1N_k(SurfaceAnimationRunner r0, long r1) {
        r0.startAnimations(r1);
    }

    public static /* synthetic */ void $r8$lambda$en1f4FBxd8eEk5eoeaVdMyjtzIQ(SurfaceAnimationRunner r0, RunningAnimation r1) {
        r0.lambda$onAnimationCancelled$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$qJwhWRhUrmZXvj8AiaQY-79qSPU, reason: not valid java name */
    public static /* synthetic */ ValueAnimator m10151$r8$lambda$qJwhWRhUrmZXvj8AiaQY79qSPU(SurfaceAnimationRunner r0) {
        return r0.lambda$new$1();
    }

    public static /* synthetic */ void $r8$lambda$rSMLySCWRN8MY7ZdHCaQcDy2620(SurfaceAnimationRunner r0) {
        r0.applyTransaction();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAnimationHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ AnimationHandler m10152$$Nest$fgetmAnimationHandler(SurfaceAnimationRunner r0) {
        return r0.mAnimationHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAnimationThreadHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m10153$$Nest$fgetmAnimationThreadHandler(SurfaceAnimationRunner r0) {
        return r0.mAnimationThreadHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCancelLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10154$$Nest$fgetmCancelLock(SurfaceAnimationRunner r0) {
        return r0.mCancelLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFrameTransaction, reason: not valid java name */
    static /* bridge */ /* synthetic */ SurfaceControl.Transaction m10155$$Nest$fgetmFrameTransaction(SurfaceAnimationRunner r0) {
        return r0.mFrameTransaction;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10156$$Nest$fgetmLock(SurfaceAnimationRunner r0) {
        return r0.mLock;
    }

    static {
        TAG = SurfaceAnimationRunner.class.getSimpleName();
    }

    SurfaceAnimationRunner(Supplier<SurfaceControl.Transaction> transactionFactory, PowerManagerInternal powerManagerInternal) {
        this(null, null, transactionFactory.get(), powerManagerInternal);
    }

    SurfaceAnimationRunner(AnimationHandler.AnimationFrameCallbackProvider callbackProvider, AnimatorFactory animatorFactory, SurfaceControl.Transaction frameTransaction, PowerManagerInternal powerManagerInternal) {
        this.mLock = new Object();
        this.mCancelLock = new Object();
        this.mAnimationThreadHandler = AnimationThread.getHandler();
        this.mSurfaceAnimationHandler = SurfaceAnimationThread.getHandler();
        this.mApplyTransactionRunnable = new SurfaceAnimationRunner$$ExternalSyntheticLambda1(this);
        this.mPendingAnimations = new ArrayMap();
        this.mPreProcessingAnimations = new ArrayMap();
        this.mRunningAnimations = new ArrayMap();
        this.mSurfaceAnimationHandler.runWithScissors(new SurfaceAnimationRunner$$ExternalSyntheticLambda2(this), 0);
        this.mFrameTransaction = frameTransaction;
        this.mAnimationHandler = new AnimationHandler();
        AnimationHandler r0 = this.mAnimationHandler;
        if (callbackProvider == null) goto L5;
        AnimationHandler.AnimationFrameCallbackProvider r1 = callbackProvider;
    L6:
        r0.setProvider(r1);
        if (animatorFactory == null) goto L9;
        AnimatorFactory r2 = animatorFactory;
    L10:
        this.mAnimatorFactory = r2;
        this.mPowerManagerInternal = powerManagerInternal;
        return;
    L9:
        r2 = new SurfaceAnimationRunner$$ExternalSyntheticLambda3(this);
        goto L10
    L5:
        r1 = new SfVsyncFrameCallbackProvider(this.mChoreographer);
        goto L6
    }

    private /* synthetic */ void lambda$new$0() {
        this.mChoreographer = Choreographer.getSfInstance();
    }

    private /* synthetic */ ValueAnimator lambda$new$1() {
        return new SfValueAnimator(this);
    }

    public Choreographer getChoreographer() {
        return this.mChoreographer;
    }

    void deferStartingAnimations() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAnimationStartDeferred = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void continueStartingAnimations() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAnimationStartDeferred = false;     // Catch: Throwable -> L12
        if (this.mPendingAnimations.isEmpty() == false) goto L8;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L8:
        if (this.mPreProcessingAnimations.isEmpty() == false) goto L15;
        long maxDuration = 0;
        int i = this.mPendingAnimations.size() - 1;     // Catch: Throwable -> L12
    L10:
        if (i < 0) goto L14;
        long animDuration = this.mPendingAnimations.valueAt(i).mAnimSpec.getDuration();     // Catch: Throwable -> L12
        maxDuration = Math.max(animDuration, maxDuration);     // Catch: Throwable -> L12
        i = i - 1;     // Catch: Throwable -> L12
        goto L10
    L14:
        SysOptBridge.getFactory().getDynamicRefreshRateService().onLocalAnimationStartLocked(maxDuration);     // Catch: Throwable -> L12
        this.mChoreographer.postFrameCallback(new SurfaceAnimationRunner$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    void startAnimation(LocalAnimationAdapter.AnimationSpec a, SurfaceControl animationLeash, SurfaceControl.Transaction t, Runnable finishCallback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RunningAnimation runningAnim = new RunningAnimation(a, animationLeash, finishCallback);     // Catch: Throwable -> L9
        this.mPendingAnimations.put(animationLeash, runningAnim);     // Catch: Throwable -> L9
        if (this.mAnimationStartDeferred == false) goto L7;
    L11:
        applyTransformation(runningAnim, t, 0);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mPreProcessingAnimations.isEmpty() == false) goto L11;
        SysOptBridge.getFactory().getDynamicRefreshRateService().onLocalAnimationStartLocked(a.getDuration());     // Catch: Throwable -> L9
        this.mChoreographer.postFrameCallback(new SurfaceAnimationRunner$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    void onAnimationCancelled(SurfaceControl leash) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingAnimations.containsKey(leash) == false) goto L12;
        this.mPendingAnimations.remove(leash);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mPreProcessingAnimations.containsKey(leash) == false) goto L16;
        this.mPreProcessingAnimations.remove(leash);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        final RunningAnimation anim = this.mRunningAnimations.get(leash);     // Catch: Throwable -> L9
        if (anim == null) goto L28;
        this.mRunningAnimations.remove(leash);     // Catch: Throwable -> L9
        Object r2 = this.mCancelLock;     // Catch: Throwable -> L9
        monitor-enter(r2);     // Catch: Throwable -> L9
        RunningAnimation.m10158$$Nest$fputmCancelled(anim, true);     // Catch: Throwable -> L25
        monitor-exit(r2);     // Catch: Throwable -> L25
        this.mSurfaceAnimationHandler.post(new SurfaceAnimationRunner$$ExternalSyntheticLambda5(this, anim));     // Catch: Throwable -> L9
        goto L28
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private /* synthetic */ void lambda$onAnimationCancelled$2(RunningAnimation anim) {
        anim.mAnim.cancel();
        applyTransaction();
    }

    private void startPendingAnimationsLocked() {
        int i = this.mPendingAnimations.size() - 1;
    L3:
        if (i < 0) goto L5;
        startAnimationLocked(this.mPendingAnimations.valueAt(i));
        i = i - 1;
        goto L3
    L5:
        this.mPendingAnimations.clear();
    }

    private void startAnimationLocked(final RunningAnimation a) {
        this.mChoreographer.getAnimationSmoothOpt().trackAnimationStart(4);
        final ValueAnimator anim = this.mAnimatorFactory.makeAnimator();
        anim.overrideDurationScale(1.0f);
        anim.setDuration(a.mAnimSpec.getDuration());
        anim.addUpdateListener(new SurfaceAnimationRunner$$ExternalSyntheticLambda4(this, a, anim));
        anim.addListener(new AnonymousClass1(this, a));
        a.mAnim = anim;
        this.mRunningAnimations.put(a.mLeash, a);
        anim.start();
        if (a.mAnimSpec.canSkipFirstFrame() == false) goto L5;
        anim.setCurrentPlayTime(this.mChoreographer.getFrameIntervalNanos() / 1000000);
    L5:
        anim.doAnimationFrame(this.mChoreographer.getFrameTime());
    }

    private /* synthetic */ void lambda$startAnimationLocked$3(RunningAnimation a, ValueAnimator anim, ValueAnimator animation) {
        Object r0 = this.mCancelLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (RunningAnimation.m10157$$Nest$fgetmCancelled(a) == true) goto L12;
        long duration = anim.getDuration();     // Catch: Throwable -> L10
        long currentPlayTime = anim.getCurrentPlayTime();     // Catch: Throwable -> L10
        if (currentPlayTime <= duration) goto L9;
        currentPlayTime = duration;
    L9:
        applyTransformation(a, this.mFrameTransaction, currentPlayTime);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        scheduleApplyTransaction();
    }

    private void applyTransformation(RunningAnimation a, SurfaceControl.Transaction t, long currentPlayTime) {
        a.mAnimSpec.apply(t, a.mLeash, currentPlayTime);
    }

    private void startAnimations(long frameTimeNanos) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPreProcessingAnimations.isEmpty() == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        startPendingAnimationsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mPowerManagerInternal.setPowerBoost(0, 0);
    }

    private void scheduleApplyTransaction() {
        if (this.mApplyScheduled == true) goto L6;
        this.mChoreographer.postCallback(3, this.mApplyTransactionRunnable, null);
        this.mApplyScheduled = true;
        return;
    }

    private void applyTransaction() {
        this.mFrameTransaction.setAnimationTransaction();
        this.mFrameTransaction.setFrameTimelineVsync(this.mChoreographer.getVsyncId());
        this.mFrameTransaction.setFrameTimelineSceneType(this.mChoreographer.getPerfSceneTrackerOpt().getCurrentSceneType());
        this.mFrameTransaction.setFrameTimelineSceneTargetName(this.mChoreographer.getPerfSceneTrackerOpt().getSceneTargetName());
        this.mFrameTransaction.apply();
        this.mApplyScheduled = false;
    }
}
