package s;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: s.a$a, reason: collision with other inner class name */
    public static class C0374a {
        @DoNotInline
        public static PathInterpolator a(float r10, float r11) {
            return new PathInterpolator(r10, r11);
        }

        @DoNotInline
        public static PathInterpolator b(float r10, float r11, float r12, float r13) {
            return new PathInterpolator(r10, r11, r12, r13);
        }

        @DoNotInline
        public static PathInterpolator c(Path r10) {
            return new PathInterpolator(r10);
        }
    }

    public static Interpolator a(float r10, float r11, float r12, float r13) {
        return C0374a.b(r10, r11, r12, r13);
    }

    public static Interpolator b(Path r10) {
        return C0374a.c(r10);
    }
}
