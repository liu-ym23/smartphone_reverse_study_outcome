package com.android.server.wm;

import android.graphics.Point;
import android.os.SystemClock;
import android.util.proto.ProtoOutputStream;
import android.view.Choreographer;
import android.view.SurfaceControl;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class LocalAnimationAdapter implements AnimationAdapter {
    private final SurfaceAnimationRunner mAnimator;
    private final AnimationSpec mSpec;

    interface AnimationSpec {
        void apply(SurfaceControl.Transaction r1, SurfaceControl r2, long r3);

        void dump(PrintWriter r1, String r2);

        void dumpDebugInner(ProtoOutputStream r1);

        long getDuration();

        default boolean getShowWallpaper() {
            return false;
        }

        default boolean getShowBackground() {
            return false;
        }

        default int getBackgroundColor() {
            return 0;
        }

        default long calculateStatusBarTransitionStartTime() {
            return SystemClock.uptimeMillis();
        }

        default boolean canSkipFirstFrame() {
            return false;
        }

        default boolean needsEarlyWakeup() {
            return false;
        }

        default float getFraction(float currentPlayTime) {
            float duration = getDuration();
            if (duration > 0.0f) goto L7;
            return 1.0f;
        L7:
            return currentPlayTime / duration;
        }

        default void dumpDebug(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            dumpDebugInner(proto);
            proto.end(token);
        }

        default WindowAnimationSpec asWindowAnimationSpec() {
            return null;
        }

        default Point getLeashPosition() {
            return new Point(0, 0);
        }
    }

    public static /* synthetic */ void $r8$lambda$UaYzKKcZYGPfDd4JouVmDEKELq0(LocalAnimationAdapter r0, SurfaceAnimator.OnAnimationFinishedCallback r1, int r2) {
        r0.lambda$startAnimation$0(r1, r2);
    }

    LocalAnimationAdapter(AnimationSpec spec, SurfaceAnimationRunner animator) {
        this.mSpec = spec;
        this.mAnimator = animator;
    }

    @Override // com.android.server.wm.AnimationAdapter
    public boolean getShowWallpaper() {
        return this.mSpec.getShowWallpaper();
    }

    @Override // com.android.server.wm.AnimationAdapter
    public boolean getShowBackground() {
        return this.mSpec.getShowBackground();
    }

    @Override // com.android.server.wm.AnimationAdapter
    public int getBackgroundColor() {
        return this.mSpec.getBackgroundColor();
    }

    @Override // com.android.server.wm.AnimationAdapter
    public void startAnimation(SurfaceControl animationLeash, SurfaceControl.Transaction t, final int type, final SurfaceAnimator.OnAnimationFinishedCallback finishCallback) {
        this.mAnimator.startAnimation(this.mSpec, animationLeash, t, new LocalAnimationAdapter$$ExternalSyntheticLambda0(this, finishCallback, type));
    }

    private /* synthetic */ void lambda$startAnimation$0(SurfaceAnimator.OnAnimationFinishedCallback finishCallback, int type) {
        finishCallback.onAnimationFinished(type, this);
    }

    @Override // com.android.server.wm.AnimationAdapter
    public void onAnimationCancelled(SurfaceControl animationLeash) {
        this.mAnimator.onAnimationCancelled(animationLeash);
    }

    @Override // com.android.server.wm.AnimationAdapter
    public Point getLeashPosition() {
        return this.mSpec.getLeashPosition();
    }

    @Override // com.android.server.wm.AnimationAdapter
    public long getDurationHint() {
        return this.mSpec.getDuration();
    }

    @Override // com.android.server.wm.AnimationAdapter
    public long getStatusBarTransitionsStartTime() {
        return this.mSpec.calculateStatusBarTransitionStartTime();
    }

    @Override // com.android.server.wm.AnimationAdapter
    public void dump(PrintWriter pw, String prefix) {
        this.mSpec.dump(pw, prefix);
    }

    @Override // com.android.server.wm.AnimationAdapter
    public void dumpDebug(ProtoOutputStream proto) {
        long token = proto.start(1146756268033L);
        this.mSpec.dumpDebug(proto, 1146756268033L);
        proto.end(token);
    }

    public Choreographer getChoreographer() {
        return this.mAnimator.getChoreographer();
    }
}
