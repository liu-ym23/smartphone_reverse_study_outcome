package androidx.core.view;

import android.view.ScaleGestureDetector;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    public static boolean isQuickScaleEnabled(Object r100) {
        return isQuickScaleEnabled((ScaleGestureDetector) r100);
    }

    @ReplaceWith(expression = "scaleGestureDetector.isQuickScaleEnabled()")
    public static boolean isQuickScaleEnabled(ScaleGestureDetector r100) {
        return r100.isQuickScaleEnabled();
    }

    public static void setQuickScaleEnabled(Object r100, boolean r101) {
        setQuickScaleEnabled((ScaleGestureDetector) r100, r101);
    }

    @ReplaceWith(expression = "scaleGestureDetector.setQuickScaleEnabled(enabled)")
    public static void setQuickScaleEnabled(ScaleGestureDetector r100, boolean r101) {
        r100.setQuickScaleEnabled(r101);
    }
}
