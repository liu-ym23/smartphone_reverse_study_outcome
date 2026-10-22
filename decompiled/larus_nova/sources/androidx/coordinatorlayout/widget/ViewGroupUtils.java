package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes17.dex */
public class ViewGroupUtils {
    private static final ThreadLocal<Matrix> sMatrix = null;
    private static final ThreadLocal<RectF> sRectF = null;

    static {
        sMatrix = new ThreadLocal();
        sRectF = new ThreadLocal();
    }

    private ViewGroupUtils() {
    }

    public static void getDescendantRect(ViewGroup r100, View r101, Rect r102) {
        r102.set(0, 0, r101.getWidth(), r101.getHeight());
        offsetDescendantRect(r100, r101, r102);
    }

    private static void offsetDescendantMatrix(ViewParent r100, View r101, Matrix r102) {
        Object r103 = r101.getParent();
        if ((r103 instanceof View) == false) goto L6;
        if (r103 == r100) goto L6;
        View r104 = (View) r103;
        offsetDescendantMatrix(r100, r104, r102);
        r102.preTranslate(-r104.getScrollX(), -r104.getScrollY());
    L6:
        r102.preTranslate(r101.getLeft(), r101.getTop());
        if (r101.getMatrix().isIdentity() == true) goto L10;
        r102.preConcat(r101.getMatrix());
        return;
    }

    public static void offsetDescendantRect(ViewGroup r100, View r101, Rect r102) {
        ThreadLocal<Matrix> r103 = sMatrix;
        Matrix r104 = r103.get();
        if (r104 != null) goto L5;
        r104 = new Matrix();
        r103.set(r104);
    L6:
        offsetDescendantMatrix(r100, r101, r104);
        ThreadLocal<RectF> r105 = sRectF;
        RectF r106 = r105.get();
        if (r106 != null) goto L9;
        r106 = new RectF();
        r105.set(r106);
    L9:
        r106.set(r102);
        r104.mapRect(r106);
        r102.set((int) (r106.left + 0.5f), (int) (r106.top + 0.5f), (int) (r106.right + 0.5f), (int) (r106.bottom + 0.5f));
        return;
    L5:
        r104.reset();
        goto L6
    }
}
