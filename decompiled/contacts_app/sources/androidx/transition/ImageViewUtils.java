package androidx.transition;

import android.graphics.Matrix;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class ImageViewUtils {
    private static Field sDrawMatrixField = null;
    private static boolean sDrawMatrixFieldFetched = false;
    private static boolean sTryHiddenAnimateTransform = true;

    static {
    }

    static void animateTransform(ImageView r0, Matrix r1) {
        r0.animateTransform(r1);
    }

    private static void hiddenAnimateTransform(ImageView r1, Matrix r2) {
        if (sTryHiddenAnimateTransform == false) goto L10;
        r1.animateTransform(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenAnimateTransform = false;
        return;
    }

    private static void fetchDrawMatrixField() {
        if (sDrawMatrixFieldFetched == false) goto L9;
        return;
    L9:
        Field r1 = ImageView.class.getDeclaredField("mDrawMatrix");     // Catch: NoSuchFieldException -> L8
        sDrawMatrixField = r1;     // Catch: NoSuchFieldException -> L8
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L6:
        sDrawMatrixFieldFetched = true;
    }

    private ImageViewUtils() {
    }
}
