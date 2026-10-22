package K;

import android.view.VelocityTracker;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class A {
    @DoNotInline
    public static float a(VelocityTracker velocityTracker, int i4) {
        return velocityTracker.getAxisVelocity(i4);
    }

    @DoNotInline
    public static float b(VelocityTracker velocityTracker, int i4, int i5) {
        return velocityTracker.getAxisVelocity(i4, i5);
    }

    @DoNotInline
    public static boolean c(VelocityTracker velocityTracker, int i4) {
        return velocityTracker.isAxisSupported(i4);
    }
}
