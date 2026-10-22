package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.ReplaceWith;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes17.dex */
public final class VelocityTrackerCompat {
    private static Map<VelocityTracker, VelocityTrackerFallback> sFallbackTrackers;

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static float getAxisVelocity(VelocityTracker r100, int r101) {
            return r100.getAxisVelocity(r101);
        }

        public static boolean isAxisSupported(VelocityTracker r100, int r101) {
            return r100.isAxisSupported(r101);
        }

        public static float getAxisVelocity(VelocityTracker r100, int r101, int r102) {
            return r100.getAxisVelocity(r101, r102);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VelocityTrackableMotionEventAxis {
    }

    private VelocityTrackerCompat() {
    }

    static {
        sFallbackTrackers = Collections.synchronizedMap(new WeakHashMap());
    }

    public static void clear(VelocityTracker r100) {
        r100.clear();
        removeFallbackForTracker(r100);
    }

    private static VelocityTrackerFallback getFallbackTrackerOrNull(VelocityTracker r100) {
        return sFallbackTrackers.get(r100);
    }

    public static void recycle(VelocityTracker r100) {
        r100.recycle();
        removeFallbackForTracker(r100);
    }

    private static void removeFallbackForTracker(VelocityTracker r100) {
        sFallbackTrackers.remove(r100);
    }

    public static void addMovement(VelocityTracker r100, MotionEvent r101) {
        r100.addMovement(r101);
        if (Build.VERSION.SDK_INT < 34) goto L6;
        return;
    L6:
        if (r101.getSource() == 4194304) goto L8;
        return;
    L8:
        if (sFallbackTrackers.containsKey(r100) == true) goto L10;
        sFallbackTrackers.put(r100, new VelocityTrackerFallback());
    L10:
        sFallbackTrackers.get(r100).addMovement(r101);
    }

    public static void computeCurrentVelocity(VelocityTracker r100, int r101) {
        computeCurrentVelocity(r100, r101, Float.MAX_VALUE);
    }

    public static float getAxisVelocity(VelocityTracker r100, int r101) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        if (r101 != 0) goto L10;
        return r100.getXVelocity();
    L10:
        if (r101 == 1) goto L12;
        VelocityTrackerFallback r102 = getFallbackTrackerOrNull(r100);
        if (r102 != null) goto L16;
        return 0.0f;
    L16:
        return r102.getAxisVelocity(r101);
    L12:
        return r100.getYVelocity();
    L5:
        return Api34Impl.getAxisVelocity(r100, r101);
    }

    @ReplaceWith(expression = "tracker.getXVelocity(pointerId)")
    public static float getXVelocity(VelocityTracker r100, int r101) {
        return r100.getXVelocity(r101);
    }

    @ReplaceWith(expression = "tracker.getYVelocity(pointerId)")
    public static float getYVelocity(VelocityTracker r100, int r101) {
        return r100.getYVelocity(r101);
    }

    public static boolean isAxisSupported(VelocityTracker r100, int r101) {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.isAxisSupported(r100, r101);
    L7:
        if (r101 == 26) goto L13;
        if (r101 == 0) goto L14;
        if (r101 == 1) goto L15;
        return false;
    L15:
        return true;
    L14:
        return true;
    L13:
        return true;
    }

    public static void computeCurrentVelocity(VelocityTracker r100, int r101, float r102) {
        r100.computeCurrentVelocity(r101, r102);
        VelocityTrackerFallback r103 = getFallbackTrackerOrNull(r100);
        if (r103 == null) goto L6;
        r103.computeCurrentVelocity(r101, r102);
        return;
    }

    public static float getAxisVelocity(VelocityTracker r100, int r101, int r102) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        if (r101 != 0) goto L10;
        return r100.getXVelocity(r102);
    L10:
        if (r101 == 1) goto L12;
        return 0.0f;
    L12:
        return r100.getYVelocity(r102);
    L5:
        return Api34Impl.getAxisVelocity(r100, r101, r102);
    }
}
