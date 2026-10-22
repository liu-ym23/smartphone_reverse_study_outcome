package androidx.core.view;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    public static Map<VelocityTracker, L> f13111a = Collections.synchronizedMap(new WeakHashMap());

    public static class a {
        public static float a(VelocityTracker velocityTracker, int i10) {
            return velocityTracker.getAxisVelocity(i10);
        }
    }

    public static void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
    }

    public static void b(VelocityTracker velocityTracker, int i10) {
        c(velocityTracker, i10, Float.MAX_VALUE);
    }

    public static void c(VelocityTracker velocityTracker, int i10, float f10) {
        velocityTracker.computeCurrentVelocity(i10, f10);
        L lE = e(velocityTracker);
        if (lE != null) {
            lE.a(i10, f10);
        }
    }

    public static float d(VelocityTracker velocityTracker, int i10) {
        return a.a(velocityTracker, i10);
    }

    public static L e(VelocityTracker velocityTracker) {
        return f13111a.get(velocityTracker);
    }
}
