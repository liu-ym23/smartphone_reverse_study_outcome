package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    private static Map<VelocityTracker, F> f9724a = Collections.synchronizedMap(new WeakHashMap());

    private static class a {
        static float a(VelocityTracker velocityTracker, int i5) {
            return velocityTracker.getAxisVelocity(i5);
        }

        static float b(VelocityTracker velocityTracker, int i5, int i6) {
            return velocityTracker.getAxisVelocity(i5, i6);
        }

        static boolean c(VelocityTracker velocityTracker, int i5) {
            return velocityTracker.isAxisSupported(i5);
        }
    }

    public static void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!f9724a.containsKey(velocityTracker)) {
                f9724a.put(velocityTracker, new F());
            }
            f9724a.get(velocityTracker).a(motionEvent);
        }
    }

    public static void b(VelocityTracker velocityTracker, int i5) {
        c(velocityTracker, i5, Float.MAX_VALUE);
    }

    public static void c(VelocityTracker velocityTracker, int i5, float f5) {
        velocityTracker.computeCurrentVelocity(i5, f5);
        F fE = e(velocityTracker);
        if (fE != null) {
            fE.c(i5, f5);
        }
    }

    public static float d(VelocityTracker velocityTracker, int i5) {
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(velocityTracker, i5);
        }
        if (i5 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i5 == 1) {
            return velocityTracker.getYVelocity();
        }
        F fE = e(velocityTracker);
        if (fE != null) {
            return fE.d(i5);
        }
        return 0.0f;
    }

    private static F e(VelocityTracker velocityTracker) {
        return f9724a.get(velocityTracker);
    }

    @Deprecated
    public static float f(VelocityTracker velocityTracker, int i5) {
        return velocityTracker.getXVelocity(i5);
    }
}
