package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes17.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = null;
    private static final ViewUtilsBase IMPL = null;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA = null;
    private static final int VISIBILITY_MASK = 12;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;

    static {
        if (Build.VERSION.SDK_INT < 22) goto L5;
        IMPL = new ViewUtilsApi22();
    L6:
        final Class<Float> r100 = Float.class;
        final String r101 = "translationAlpha";
        TRANSITION_ALPHA = new AnonymousClass1(r100, r101);
        final Class<Rect> r102 = Rect.class;
        final String r103 = "clipBounds";
        CLIP_BOUNDS = new AnonymousClass2(r102, r103);
        return;
    L5:
        IMPL = new ViewUtilsApi21();
        goto L6
    }

    private static void fetchViewFlagsField() {
        if (sViewFlagsFieldFetched == false) goto L9;
        return;
    L9:
        Field r100 = View.class.getDeclaredField("mViewFlags");     // Catch: NoSuchFieldException -> L8
        sViewFlagsField = r100;     // Catch: NoSuchFieldException -> L8
        r100.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L6:
        sViewFlagsFieldFetched = true;
    }

    private ViewUtils() {
    }

    public static void clearNonTransitionAlpha(View r100) {
        IMPL.clearNonTransitionAlpha(r100);
    }

    public static ViewOverlayImpl getOverlay(View r100) {
        return new ViewOverlayApi18(r100);
    }

    public static float getTransitionAlpha(View r100) {
        return IMPL.getTransitionAlpha(r100);
    }

    public static WindowIdImpl getWindowId(View r100) {
        return new WindowIdApi18(r100);
    }

    public static void saveNonTransitionAlpha(View r100) {
        IMPL.saveNonTransitionAlpha(r100);
    }

    public static void setAnimationMatrix(View r100, Matrix r101) {
        IMPL.setAnimationMatrix(r100, r101);
    }

    public static void setTransitionAlpha(View r100, float r101) {
        IMPL.setTransitionAlpha(r100, r101);
    }

    public static void setTransitionVisibility(View r100, int r101) {
        fetchViewFlagsField();
        Field r102 = sViewFlagsField;
        if (r102 == null) goto L9;
        int r103 = r102.getInt(r100);     // Catch: IllegalAccessException -> L6
        sViewFlagsField.setInt(r100, r101 | (r103 & (-13)));     // Catch: IllegalAccessException -> L6
        return;
    L10:
        return;
    }

    public static void transformMatrixToGlobal(View r100, Matrix r101) {
        IMPL.transformMatrixToGlobal(r100, r101);
    }

    public static void transformMatrixToLocal(View r100, Matrix r101) {
        IMPL.transformMatrixToLocal(r100, r101);
    }

    public static void setLeftTopRightBottom(View r100, int r101, int r102, int r103, int r110) {
        IMPL.setLeftTopRightBottom(r100, r101, r102, r103, r110);
    }
}
