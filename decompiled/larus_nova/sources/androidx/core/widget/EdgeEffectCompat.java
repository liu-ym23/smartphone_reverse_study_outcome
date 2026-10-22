package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* JADX INFO: loaded from: classes17.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void onPull(EdgeEffect r100, float r101, float r102) {
            r100.onPull(r101, r102);
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static float getDistance(EdgeEffect r100) {
            return r100.getDistance();
        L4:
            return 0.0f;
        }

        public static EdgeEffect create(Context r100, AttributeSet r101) {
            return new EdgeEffect(r100, r101);
        L5:
            return new EdgeEffect(r100);
        }

        public static float onPullDistance(EdgeEffect r100, float r101, float r102) {
            return r100.onPullDistance(r101, r102);
        L4:
            r100.onPull(r101, r102);
            return 0.0f;
        }
    }

    public void finish() {
        this.mEdgeEffect.finish();
    }

    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    public EdgeEffectCompat(Context r100) {
        this.mEdgeEffect = new EdgeEffect(r100);
    }

    public static float getDistance(EdgeEffect r100) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return 0.0f;
    L5:
        return Api31Impl.getDistance(r100);
    }

    public boolean draw(Canvas r100) {
        return this.mEdgeEffect.draw(r100);
    }

    public boolean onAbsorb(int r100) {
        this.mEdgeEffect.onAbsorb(r100);
        return true;
    }

    public boolean onPull(float r100) {
        this.mEdgeEffect.onPull(r100);
        return true;
    }

    public static EdgeEffect create(Context r100, AttributeSet r101) {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Api31Impl.create(r100, r101);
    L7:
        return new EdgeEffect(r100);
    }

    public boolean onPull(float r100, float r101) {
        onPull(this.mEdgeEffect, r100, r101);
        return true;
    }

    public void setSize(int r100, int r101) {
        this.mEdgeEffect.setSize(r100, r101);
    }

    public static void onPull(EdgeEffect r100, float r101, float r102) {
        Api21Impl.onPull(r100, r101, r102);
    }

    public static float onPullDistance(EdgeEffect r100, float r101, float r102) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        onPull(r100, r101, r102);
        return r101;
    L5:
        return Api31Impl.onPullDistance(r100, r101, r102);
    }
}
