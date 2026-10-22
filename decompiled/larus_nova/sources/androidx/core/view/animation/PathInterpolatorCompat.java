package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes17.dex */
public final class PathInterpolatorCompat {

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Interpolator createPathInterpolator(Path r100) {
            return new PathInterpolator(r100);
        }

        public static Interpolator createPathInterpolator(float r100, float r101) {
            return new PathInterpolator(r100, r101);
        }

        public static Interpolator createPathInterpolator(float r100, float r101, float r102, float r103) {
            return new PathInterpolator(r100, r101, r102, r103);
        }
    }

    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path r100) {
        return Api21Impl.createPathInterpolator(r100);
    }

    public static Interpolator create(float r100, float r101) {
        return Api21Impl.createPathInterpolator(r100, r101);
    }

    public static Interpolator create(float r100, float r101, float r102, float r103) {
        return Api21Impl.createPathInterpolator(r100, r101, r102, r103);
    }
}
