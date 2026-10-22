package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = null;
    private static final ViewUtilsBase IMPL = null;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA = null;

    static {
        IMPL = new ViewUtilsApi29();
        final Class<Float> r1 = Float.class;
        final String r2 = "translationAlpha";
        TRANSITION_ALPHA = new AnonymousClass1(r1, r2);
        final Class<Rect> r3 = Rect.class;
        final String r4 = "clipBounds";
        CLIP_BOUNDS = new AnonymousClass2(r3, r4);
    }

    static ViewOverlayImpl getOverlay(View r1) {
        return new ViewOverlayApi18(r1);
    }

    static WindowIdImpl getWindowId(View r1) {
        return new WindowIdApi18(r1);
    }

    static void setTransitionAlpha(View r1, float r2) {
        IMPL.setTransitionAlpha(r1, r2);
    }

    static float getTransitionAlpha(View r1) {
        return IMPL.getTransitionAlpha(r1);
    }

    static void saveNonTransitionAlpha(View r1) {
        IMPL.saveNonTransitionAlpha(r1);
    }

    static void clearNonTransitionAlpha(View r1) {
        IMPL.clearNonTransitionAlpha(r1);
    }

    static void setTransitionVisibility(View r1, int r2) {
        IMPL.setTransitionVisibility(r1, r2);
    }

    static void transformMatrixToGlobal(View r1, Matrix r2) {
        IMPL.transformMatrixToGlobal(r1, r2);
    }

    static void transformMatrixToLocal(View r1, Matrix r2) {
        IMPL.transformMatrixToLocal(r1, r2);
    }

    static void setAnimationMatrix(View r1, Matrix r2) {
        IMPL.setAnimationMatrix(r1, r2);
    }

    static void setLeftTopRightBottom(View r6, int r7, int r8, int r9, int r10) {
        IMPL.setLeftTopRightBottom(r6, r7, r8, r9, r10);
    }

    private ViewUtils() {
    }
}
