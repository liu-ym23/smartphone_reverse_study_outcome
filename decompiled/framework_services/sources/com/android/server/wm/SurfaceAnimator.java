package com.android.server.wm;

import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.SurfaceControl;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.protolog.common.LogLevel;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class SurfaceAnimator {
    public static final int ANIMATION_TYPE_ALL = -1;
    public static final int ANIMATION_TYPE_APP_TRANSITION = 1;
    public static final int ANIMATION_TYPE_DIMMER = 4;
    public static final int ANIMATION_TYPE_INSETS_CONTROL = 32;
    public static final int ANIMATION_TYPE_NONE = 0;
    public static final int ANIMATION_TYPE_PREDICT_BACK = 256;
    public static final int ANIMATION_TYPE_RECENTS = 8;
    public static final int ANIMATION_TYPE_SCREEN_ROTATION = 2;
    public static final int ANIMATION_TYPE_STARTING_REVEAL = 128;
    public static final int ANIMATION_TYPE_TOKEN_TRANSFORM = 64;
    public static final int ANIMATION_TYPE_WINDOW_ANIMATION = 16;
    private static final String TAG = "WindowManager";
    final Animatable mAnimatable;
    private AnimationAdapter mAnimation;
    private Runnable mAnimationCancelledCallback;
    private boolean mAnimationFinished;
    private int mAnimationType;
    final OnAnimationFinishedCallback mInnerAnimationFinishedCallback;
    SurfaceControl mLeash;
    private final WindowManagerService mService;
    final OnAnimationFinishedCallback mStaticAnimationFinishedCallback;
    private OnAnimationFinishedCallback mSurfaceAnimationFinishedCallback;

    interface Animatable {
        void commitPendingTransaction();

        SurfaceControl getAnimationLeashParent();

        SurfaceControl getParentSurfaceControl();

        SurfaceControl.Transaction getPendingTransaction();

        SurfaceControl getSurfaceControl();

        int getSurfaceHeight();

        int getSurfaceWidth();

        SurfaceControl.Transaction getSyncTransaction();

        SurfaceControl.Builder makeAnimationLeash();

        void onAnimationLeashCreated(SurfaceControl.Transaction r1, SurfaceControl r2);

        void onAnimationLeashLost(SurfaceControl.Transaction r1);

        default void onLeashAnimationStarting(SurfaceControl.Transaction t, SurfaceControl leash) {
        }

        default SurfaceControl getAnimationLeash() {
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface AnimationType {
    }

    public interface OnAnimationFinishedCallback {
        void onAnimationFinished(int r1, AnimationAdapter r2);
    }

    public static /* synthetic */ void $r8$lambda$A_SDCtBYtLcYDAAdc6Nygk1chE0(SurfaceAnimator r0, OnAnimationFinishedCallback r1, int r2, AnimationAdapter r3) {
        r0.lambda$getFinishedCallback$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$jpWLmdZ8WD7VMOkNht1QSuwzXVM(SurfaceAnimator r0, AnimationAdapter r1, OnAnimationFinishedCallback r2, int r3) {
        r0.lambda$getFinishedCallback$0(r1, r2, r3);
    }

    SurfaceAnimator(Animatable animatable, OnAnimationFinishedCallback staticAnimationFinishedCallback, WindowManagerService service) {
        this.mAnimatable = animatable;
        this.mService = service;
        this.mStaticAnimationFinishedCallback = staticAnimationFinishedCallback;
        this.mInnerAnimationFinishedCallback = getFinishedCallback(staticAnimationFinishedCallback);
    }

    private OnAnimationFinishedCallback getFinishedCallback(final OnAnimationFinishedCallback staticAnimationFinishedCallback) {
        return new SurfaceAnimator$$ExternalSyntheticLambda0(this, staticAnimationFinishedCallback);
    }

    private /* synthetic */ void lambda$getFinishedCallback$1(final OnAnimationFinishedCallback staticAnimationFinishedCallback, final int type, final AnimationAdapter anim) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        SurfaceAnimator target = this.mService.mAnimationTransferMap.remove(anim);     // Catch: Throwable -> L10
        if (target == null) goto L13;
        target.mInnerAnimationFinishedCallback.onAnimationFinished(type, anim);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        if (anim == this.mAnimation) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L17:
        Runnable resetAndInvokeFinish = new SurfaceAnimator$$ExternalSyntheticLambda1(this, anim, staticAnimationFinishedCallback, type);     // Catch: Throwable -> L10
        if (anim.shouldDeferAnimationFinish(resetAndInvokeFinish) == true) goto L20;
        resetAndInvokeFinish.run();     // Catch: Throwable -> L10
    L20:
        this.mAnimationFinished = true;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$getFinishedCallback$0(AnimationAdapter anim, OnAnimationFinishedCallback staticAnimationFinishedCallback, int type) {
        if (anim == this.mAnimation) goto L5;
        return;
    L5:
        OnAnimationFinishedCallback animationFinishCallback = this.mSurfaceAnimationFinishedCallback;
        reset(this.mAnimatable.getSyncTransaction(), true);
        if (staticAnimationFinishedCallback == null) goto L8;
        staticAnimationFinishedCallback.onAnimationFinished(type, anim);
    L8:
        if (animationFinishCallback == null) goto L11;
        animationFinishCallback.onAnimationFinished(type, anim);
        return;
    }

    void startAnimation(SurfaceControl.Transaction t, AnimationAdapter anim, boolean hidden, int type, OnAnimationFinishedCallback animationFinishedCallback, Runnable animationCancelledCallback, AnimationAdapter snapshotAnim) {
        cancelAnimation(t, true, true);
        this.mAnimation = anim;
        this.mAnimationType = type;
        this.mSurfaceAnimationFinishedCallback = animationFinishedCallback;
        this.mAnimationCancelledCallback = animationCancelledCallback;
        SurfaceControl surface = this.mAnimatable.getSurfaceControl();
        if (surface != null) goto L7;
        Slog.w(TAG, "Unable to start animation, surface is null or no children.");
        cancelAnimation();
        return;
    L7:
        if (this.mLeash != null) goto L9;
        this.mLeash = createAnimationLeash(this.mAnimatable, surface, t, type, this.mAnimatable.getSurfaceWidth(), this.mAnimatable.getSurfaceHeight(), 0, 0, hidden, this.mService.mTransactionFactory);
        this.mAnimatable.onAnimationLeashCreated(t, this.mLeash);
    L9:
        this.mAnimatable.onLeashAnimationStarting(t, this.mLeash);
        this.mAnimation.startAnimation(this.mLeash, t, type, this.mInnerAnimationFinishedCallback);
        if (type != 1) goto L17;
        if ((this.mAnimatable instanceof ActivityRecord) == false) goto L17;
        if ((this.mAnimation instanceof LocalAnimationAdapter) == false) goto L17;
        ((LocalAnimationAdapter) this.mAnimation).getChoreographer().getPerfSceneTrackerOpt().onPerfSceneStart(4, ((ActivityRecord) this.mAnimatable).getProcessName());
    L17:
        if (ProtoLogImpl_798997914.isEnabled(WmProtoLogGroups.WM_DEBUG_ANIM, LogLevel.DEBUG) == false) goto L21;
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        this.mAnimation.dump(pw, "");
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[0] == false) goto L21;
        String protoLogParam0 = String.valueOf(this.mAnimatable);
        String protoLogParam1 = String.valueOf(sw);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ANIM, 1371702561758591499L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L21:
        setAnimatorPendingState(t);
    }

    void startAnimation(SurfaceControl.Transaction t, AnimationAdapter anim, boolean hidden, int type) {
        startAnimation(t, anim, hidden, type, null, null, null);
    }

    private void setAnimatorPendingState(SurfaceControl.Transaction t) {
        if (this.mService.mAnimator.mPendingState == 0) goto L5;
        return;
    L5:
        if (t != this.mAnimatable.getPendingTransaction()) goto L9;
        this.mService.mAnimator.mPendingState = 1;
        return;
    }

    boolean isAnimating() {
        if (this.mAnimation == null) goto L5;
        return true;
    L5:
        return false;
    }

    int getAnimationType() {
        return this.mAnimationType;
    }

    AnimationAdapter getAnimation() {
        return this.mAnimation;
    }

    void cancelAnimation() {
        if (this.mAnimationType != 128) goto L5;
        cancelAnimation(this.mAnimatable.getPendingTransaction(), false, true);
    L6:
        this.mAnimatable.commitPendingTransaction();
        return;
    L5:
        cancelAnimation(this.mAnimatable.getSyncTransaction(), false, true);
        goto L6
    }

    void setLayer(SurfaceControl.Transaction t, int layer) {
        if (this.mLeash == null) goto L5;
        SurfaceControl r0 = this.mLeash;
    L6:
        t.setLayer(r0, layer);
        return;
    L5:
        r0 = this.mAnimatable.getSurfaceControl();
        goto L6
    }

    void setRelativeLayer(SurfaceControl.Transaction t, SurfaceControl relativeTo, int layer) {
        if (this.mLeash == null) goto L5;
        SurfaceControl r0 = this.mLeash;
    L6:
        t.setRelativeLayer(r0, relativeTo, layer);
        return;
    L5:
        r0 = this.mAnimatable.getSurfaceControl();
        goto L6
    }

    boolean hasLeash() {
        if (this.mLeash == null) goto L5;
        return true;
    L5:
        return false;
    }

    void transferAnimation(SurfaceAnimator from) {
        if (from.mLeash != null) goto L5;
        return;
    L5:
        SurfaceControl surface = this.mAnimatable.getSurfaceControl();
        SurfaceControl parent = this.mAnimatable.getAnimationLeashParent();
        if (surface == null) goto L15;
        if (parent == null) goto L15;
        if (from.mAnimationFinished == false) goto L13;
        Slog.w(TAG, "Unable to transfer animation, because " + from + " animation is finished");
        return;
    L13:
        SurfaceControl.Transaction t = this.mAnimatable.getSyncTransaction();
        cancelAnimation(t, true, true);
        this.mLeash = from.mLeash;
        this.mAnimation = from.mAnimation;
        this.mAnimationType = from.mAnimationType;
        this.mSurfaceAnimationFinishedCallback = from.mSurfaceAnimationFinishedCallback;
        this.mAnimationCancelledCallback = from.mAnimationCancelledCallback;
        from.cancelAnimation(t, false, false);
        t.reparent(surface, this.mLeash);
        t.reparent(this.mLeash, parent);
        this.mAnimatable.onAnimationLeashCreated(t, this.mLeash);
        this.mService.mAnimationTransferMap.put(this.mAnimation, this);
        return;
    L15:
        Slog.w(TAG, "Unable to transfer animation, surface or parent is null");
        cancelAnimation();
    }

    private void cancelAnimation(SurfaceControl.Transaction t, boolean restarting, boolean forwardCancel) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[2] == false) goto L5;
        String protoLogParam1 = String.valueOf(this.mAnimatable);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ANIM, -5370506662233296228L, 3, new Object[]{Boolean.valueOf(restarting), protoLogParam1});
    L5:
        SurfaceControl leash = this.mLeash;
        AnimationAdapter animation = this.mAnimation;
        int animationType = this.mAnimationType;
        OnAnimationFinishedCallback animationFinishedCallback = this.mSurfaceAnimationFinishedCallback;
        Runnable animationCancelledCallback = this.mAnimationCancelledCallback;
        reset(t, false);
        if (animation == null) goto L17;
        if (forwardCancel == false) goto L11;
        animation.onAnimationCancelled(leash);
        if (animationCancelledCallback == null) goto L11;
        animationCancelledCallback.run();
    L11:
        if (restarting == true) goto L17;
        if (this.mStaticAnimationFinishedCallback == null) goto L15;
        this.mStaticAnimationFinishedCallback.onAnimationFinished(animationType, animation);
    L15:
        if (animationFinishedCallback == null) goto L17;
        animationFinishedCallback.onAnimationFinished(animationType, animation);
    L17:
        if (forwardCancel == false) goto L21;
        if (leash == null) goto L22;
        t.remove(leash);
        this.mService.scheduleAnimationLocked();
        return;
    L22:
        return;
    }

    private void reset(SurfaceControl.Transaction t, boolean destroyLeash) {
        this.mService.mAnimationTransferMap.remove(this.mAnimation);
        this.mAnimation = null;
        this.mSurfaceAnimationFinishedCallback = null;
        this.mAnimationType = 0;
        if (this.mLeash != null) goto L5;
        return;
    L5:
        SurfaceControl leash = this.mLeash;
        this.mLeash = null;
        boolean scheduleAnim = removeLeash(t, this.mAnimatable, leash, destroyLeash);
        this.mAnimationFinished = false;
        if (scheduleAnim == false) goto L9;
        setAnimatorPendingState(t);
        this.mService.scheduleAnimationLocked();
        return;
    }

    static boolean removeLeash(SurfaceControl.Transaction t, Animatable animatable, SurfaceControl leash, boolean destroy) {
        boolean scheduleAnim = false;
        SurfaceControl surface = animatable.getSurfaceControl();
        SurfaceControl parent = animatable.getParentSurfaceControl();
        SurfaceControl curAnimationLeash = animatable.getAnimationLeash();
        if (surface == null) goto L8;
        if (curAnimationLeash != null) goto L6;
    L7:
        boolean reparent = true;
    L10:
        if (reparent == true) goto L12;
        Slog.d(TAG, "removeLeash dont reparent: curAnimationLeash= " + curAnimationLeash + " surface=" + surface + " leash: " + leash);
    L22:
        if (destroy == false) goto L24;
        t.remove(leash);
        scheduleAnim = true;
    L24:
        if (reparent == false) goto L27;
        animatable.onAnimationLeashLost(t);
        return true;
    L27:
        return scheduleAnim;
    L12:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[2] == false) goto L15;
        String protoLogParam0 = String.valueOf(parent);
        String protoLogParam1 = String.valueOf(animatable);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ANIM, -3045933321063743917L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L15:
        if (surface.isValid() == false) goto L20;
        if (parent == null) goto L20;
        if (parent.isValid() == false) goto L20;
        t.reparent(surface, parent);
        scheduleAnim = true;
    L20:
        Slog.d(TAG, "removeLeash  ignore reparent surface isValid: " + surface.isValid() + " parent= " + parent + " surface: " + surface);
        goto L22
    L6:
        if (curAnimationLeash.equals(leash) == true) goto L7;
    L8:
        reparent = false;
        goto L10
    }

    static SurfaceControl createAnimationLeash(Animatable animatable, SurfaceControl surface, SurfaceControl.Transaction t, int type, int width, int height, int x, int y, boolean hidden, Supplier<SurfaceControl.Transaction> transactionFactory) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[2] == false) goto L5;
        String protoLogParam0 = String.valueOf(animatable);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ANIM, -855083149623806053L, 0, new Object[]{protoLogParam0});
    L5:
        SurfaceControl.Builder builder = animatable.makeAnimationLeash().setParent(animatable.getAnimationLeashParent()).setName(surface + " - animation-leash of " + animationTypeToString(type)).setHidden(hidden).setEffectLayer().setCallsite("SurfaceAnimator.createAnimationLeash");
        SurfaceControl leash = builder.build();
        t.setWindowCrop(leash, width, height);
        t.setPosition(leash, (float) x, (float) y);
        t.show(leash);
        if (hidden == false) goto L8;
        float r2 = 0.0f;
    L9:
        t.setAlpha(leash, r2);
        t.reparent(surface, leash);
        return leash;
    L8:
        r2 = 1.0f;
        goto L9
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        if (this.mAnimation == null) goto L6;
        this.mAnimation.dumpDebug(proto, 1146756268035L);
    L6:
        if (this.mLeash == null) goto L8;
        this.mLeash.dumpDebug(proto, 1146756268033L);
    L8:
        proto.end(token);
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mLeash=");
        pw.print(this.mLeash);
        pw.print(" mAnimationType=");
        pw.println(animationTypeToString(this.mAnimationType));
        pw.print(prefix);
        pw.print("Animation: ");
        pw.println(this.mAnimation);
        if (this.mAnimation == null) goto L6;
        this.mAnimation.dump(pw, prefix + "  ");
        return;
    }

    static String animationTypeToString(int type) {
        switch(type) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L17;
            case 4: goto L15;
            case 16: goto L13;
            case 32: goto L11;
            case 64: goto L9;
            case 128: goto L7;
            case 256: goto L5;
            default: goto L4;
        };
    L5:
        return "predict_back";
    L7:
        return "starting_reveal";
    L9:
        return "token_transform";
    L11:
        return "insets_animation";
    L13:
        return "window_animation";
    L15:
        return "dimmer";
    L17:
        return "screen_rotation";
    L19:
        return "app_transition";
    L21:
        return "none";
    L4:
        return "unknown type:" + type;
    }
}
