package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: androidx.core.view.animation.a$a, reason: collision with other inner class name */
    static class C0122a {
        static Interpolator a(float f5, float f6) {
            return new PathInterpolator(f5, f6);
        }

        static Interpolator b(float f5, float f6, float f7, float f8) {
            return new PathInterpolator(f5, f6, f7, f8);
        }

        static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f5, float f6, float f7, float f8) {
        return C0122a.b(f5, f6, f7, f8);
    }
}
