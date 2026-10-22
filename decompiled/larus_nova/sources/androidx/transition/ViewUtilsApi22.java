package androidx.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static final String TAG = "ViewUtilsApi22";
    private static Method sSetLeftTopRightBottomMethod;
    private static boolean sSetLeftTopRightBottomMethodFetched;

    private void fetchSetLeftTopRightBottomMethod() {
        if (sSetLeftTopRightBottomMethodFetched == false) goto L9;
        return;
    L9:
        Class r100 = Integer.TYPE;     // Catch: NoSuchMethodException -> L8
        Method r101 = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[]{r100, r100, r100, r100});     // Catch: NoSuchMethodException -> L8
        sSetLeftTopRightBottomMethod = r101;     // Catch: NoSuchMethodException -> L8
        r101.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sSetLeftTopRightBottomMethodFetched = true;
    }

    public ViewUtilsApi22() {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setLeftTopRightBottom(View r100, int r101, int r102, int r103, int r104) {
        fetchSetLeftTopRightBottomMethod();
        Method r105 = sSetLeftTopRightBottomMethod;
        if (r105 != null) goto L12;
        return;
    L12:
        r105.invoke(r100, new Object[]{Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103), Integer.valueOf(r104)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }
}
