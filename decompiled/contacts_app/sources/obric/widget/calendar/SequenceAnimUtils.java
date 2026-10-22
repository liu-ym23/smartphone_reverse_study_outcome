package obric.widget.calendar;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes5.dex */
public class SequenceAnimUtils {
    private static final AccelerateInterpolator accelerateInterpolator = null;
    private static final DecelerateInterpolator decelerateInterpolator = null;
    private static final LinearInterpolator linearInterpolator = null;

    public static int getDuration(int needToRunCount, int currentCount) {
        if (needToRunCount != 1) goto L7;
        return 200;
    L7:
        if (needToRunCount == 2) goto L9;
        return 300;
    L9:
        if (currentCount != 2) goto L11;
        return 150;
    L11:
        if (currentCount != 1) goto L16;
        return 100;
    L16:
        return 150;
    }

    public SequenceAnimUtils() {
    }

    static {
        accelerateInterpolator = new AccelerateInterpolator();
        decelerateInterpolator = new DecelerateInterpolator();
        linearInterpolator = new LinearInterpolator();
    }

    public static Interpolator getInterpolator(int needToRunCount, int currentCount) {
        if (needToRunCount != 1) goto L10;
        if (currentCount != 1) goto L8;
        return accelerateInterpolator;
    L8:
        return decelerateInterpolator;
    L10:
        if (needToRunCount != 2) goto L19;
        if (currentCount == 2) goto L13;
        if (currentCount != 1) goto L18;
        return linearInterpolator;
    L18:
        return decelerateInterpolator;
    L13:
        return accelerateInterpolator;
    L19:
        return null;
    }
}
