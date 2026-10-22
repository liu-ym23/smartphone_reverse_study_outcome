package androidx.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
class ViewUtilsApi19 extends ViewUtilsBase {
    private static final String TAG = "ViewUtilsApi19";
    private static Method sGetTransitionAlphaMethod;
    private static boolean sGetTransitionAlphaMethodFetched;
    private static Method sSetTransitionAlphaMethod;
    private static boolean sSetTransitionAlphaMethodFetched;

    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(View r100) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(View r100) {
    }

    private void fetchGetTransitionAlphaMethod() {
        if (sGetTransitionAlphaMethodFetched == false) goto L9;
        return;
    L9:
        Method r100 = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);     // Catch: NoSuchMethodException -> L8
        sGetTransitionAlphaMethod = r100;     // Catch: NoSuchMethodException -> L8
        r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sGetTransitionAlphaMethodFetched = true;
    }

    private void fetchSetTransitionAlphaMethod() {
        if (sSetTransitionAlphaMethodFetched == false) goto L9;
        return;
    L9:
        Method r100 = View.class.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L8
        sSetTransitionAlphaMethod = r100;     // Catch: NoSuchMethodException -> L8
        r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sSetTransitionAlphaMethodFetched = true;
    }

    public ViewUtilsApi19() {
    }

    @Override // androidx.transition.ViewUtilsBase
    public float getTransitionAlpha(View r100) {
        fetchGetTransitionAlphaMethod();
        Method r101 = sGetTransitionAlphaMethod;
        if (r101 == null) goto L11;
        return ((Float) r101.invoke(r100, new Object[0])).floatValue();
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    L11:
        return super.getTransitionAlpha(r100);
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionAlpha(View r100, float r101) {
        fetchSetTransitionAlphaMethod();
        Method r102 = sSetTransitionAlphaMethod;
        if (r102 != null) goto L13;
        r100.setAlpha(r101);
        return;
    L13:
        r102.invoke(r100, new Object[]{Float.valueOf(r101)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L12
        goto L16
    L15:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }
}
