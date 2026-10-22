package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    static class Api21Impl {
        private Api21Impl() {
        }

        static void onPull(EdgeEffect r0, float r1, float r2) {
            r0.onPull(r1, r2);
        }
    }

    private static class Api31Impl {
        private Api31Impl() {
        }

        public static EdgeEffect create(Context r1, AttributeSet r2) {
            return new EdgeEffect(r1, r2);
        L5:
            return new EdgeEffect(r1);
        }

        public static float onPullDistance(EdgeEffect r0, float r1, float r2) {
            return r0.onPullDistance(r1, r2);
        L4:
            r0.onPull(r1, r2);
            return 0.0f;
        }

        public static float getDistance(EdgeEffect r0) {
            return r0.getDistance();
        L4:
            return 0.0f;
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context r2) {
        this.mEdgeEffect = new EdgeEffect(r2);
    }

    public static EdgeEffect create(Context r0, AttributeSet r1) {
        return Api31Impl.create(r0, r1);
    }

    public static float getDistance(EdgeEffect r0) {
        return Api31Impl.getDistance(r0);
    }

    @Deprecated
    public void setSize(int r1, int r2) {
        this.mEdgeEffect.setSize(r1, r2);
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean onPull(float r1) {
        this.mEdgeEffect.onPull(r1);
        return true;
    }

    @Deprecated
    public boolean onPull(float r1, float r2) {
        onPull(this.mEdgeEffect, r1, r2);
        return true;
    }

    public static void onPull(EdgeEffect r0, float r1, float r2) {
        Api21Impl.onPull(r0, r1, r2);
    }

    public static float onPullDistance(EdgeEffect r0, float r1, float r2) {
        return Api31Impl.onPullDistance(r0, r1, r2);
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int r1) {
        this.mEdgeEffect.onAbsorb(r1);
        return true;
    }

    @Deprecated
    public boolean draw(Canvas r1) {
        return this.mEdgeEffect.draw(r1);
    }
}
