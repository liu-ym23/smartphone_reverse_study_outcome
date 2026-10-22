package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: PathInterpolatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: androidx.core.view.animation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PathInterpolatorCompat.java */
    static class C0039a {
        static Interpolator a(Path r1) {
            return new PathInterpolator(r1);
        }

        static Interpolator a(float r1, float r2) {
            return new PathInterpolator(r1, r2);
        }

        static Interpolator a(float r1, float r2, float r3, float r4) {
            return new PathInterpolator(r1, r2, r3, r4);
        }
    }

    public static Interpolator a(Path r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return C0039a.a(r2);
    L7:
        return new PathInterpolatorApi14(r2);
    }

    public static Interpolator a(float r2, float r3, float r4, float r5) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return C0039a.a(r2, r3, r4, r5);
    L7:
        return new PathInterpolatorApi14(r2, r3, r4, r5);
    }
}
