package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.RequiresApi;

/* loaded from: classes2.dex */
public final class PathInterpolatorCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        public static Interpolator createPathInterpolator(float f, float f7) {
            return new PathInterpolator(f, f7);
        }

        public static Interpolator createPathInterpolator(float f, float f7, float f9, float f10) {
            return new PathInterpolator(f, f7, f9, f10);
        }
    }

    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    public static Interpolator create(float f, float f7) {
        return Api21Impl.createPathInterpolator(f, f7);
    }

    public static Interpolator create(float f, float f7, float f9, float f10) {
        return Api21Impl.createPathInterpolator(f, f7, f9, f10);
    }
}
