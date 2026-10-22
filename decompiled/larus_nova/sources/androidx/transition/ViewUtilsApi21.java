package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static final String TAG = "ViewUtilsApi21";
    private static Method sSetAnimationMatrixMethod;
    private static boolean sSetAnimationMatrixMethodFetched;
    private static Method sTransformMatrixToGlobalMethod;
    private static boolean sTransformMatrixToGlobalMethodFetched;
    private static Method sTransformMatrixToLocalMethod;
    private static boolean sTransformMatrixToLocalMethodFetched;

    private void fetchSetAnimationMatrix() {
        if (sSetAnimationMatrixMethodFetched == false) goto L9;
        return;
    L9:
        Method r100 = View.class.getDeclaredMethod("setAnimationMatrix", new Class[]{Matrix.class});     // Catch: NoSuchMethodException -> L8
        sSetAnimationMatrixMethod = r100;     // Catch: NoSuchMethodException -> L8
        r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sSetAnimationMatrixMethodFetched = true;
    }

    private void fetchTransformMatrixToGlobalMethod() {
        if (sTransformMatrixToGlobalMethodFetched == false) goto L9;
        return;
    L9:
        Method r100 = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});     // Catch: NoSuchMethodException -> L8
        sTransformMatrixToGlobalMethod = r100;     // Catch: NoSuchMethodException -> L8
        r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sTransformMatrixToGlobalMethodFetched = true;
    }

    private void fetchTransformMatrixToLocalMethod() {
        if (sTransformMatrixToLocalMethodFetched == false) goto L9;
        return;
    L9:
        Method r100 = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});     // Catch: NoSuchMethodException -> L8
        sTransformMatrixToLocalMethod = r100;     // Catch: NoSuchMethodException -> L8
        r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sTransformMatrixToLocalMethodFetched = true;
    }

    public ViewUtilsApi21() {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setAnimationMatrix(View r100, Matrix r101) {
        fetchSetAnimationMatrix();
        Method r102 = sSetAnimationMatrixMethod;
        if (r102 != null) goto L12;
        return;
    L12:
        r102.invoke(r100, new Object[]{r101});     // Catch: IllegalAccessException -> L7 InvocationTargetException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToGlobal(View r100, Matrix r101) {
        fetchTransformMatrixToGlobalMethod();
        Method r102 = sTransformMatrixToGlobalMethod;
        if (r102 != null) goto L12;
        return;
    L12:
        r102.invoke(r100, new Object[]{r101});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToLocal(View r100, Matrix r101) {
        fetchTransformMatrixToLocalMethod();
        Method r102 = sTransformMatrixToLocalMethod;
        if (r102 != null) goto L12;
        return;
    L12:
        r102.invoke(r100, new Object[]{r101});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }
}
