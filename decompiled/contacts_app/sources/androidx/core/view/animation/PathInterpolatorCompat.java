package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static PathInterpolator createPathInterpolator(Path r1) {
            return new PathInterpolator(r1);
        }

        static PathInterpolator createPathInterpolator(float r1, float r2) {
            return new PathInterpolator(r1, r2);
        }

        static PathInterpolator createPathInterpolator(float r1, float r2, float r3, float r4) {
            return new PathInterpolator(r1, r2, r3, r4);
        }
    }

    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path r0) {
        return Api21Impl.createPathInterpolator(r0);
    }

    public static Interpolator create(float r0, float r1) {
        return Api21Impl.createPathInterpolator(r0, r1);
    }

    public static Interpolator create(float r0, float r1, float r2, float r3) {
        return Api21Impl.createPathInterpolator(r0, r1, r2, r3);
    }
}
