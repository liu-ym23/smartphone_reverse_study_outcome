package androidx.transition;

import android.view.ViewGroup;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
class ViewGroupUtilsApi18 {
    private static final String TAG = "ViewUtilsApi18";
    private static Method sSuppressLayoutMethod;
    private static boolean sSuppressLayoutMethodFetched;

    private static void fetchSuppressLayoutMethod() {
        if (sSuppressLayoutMethodFetched == false) goto L9;
        return;
    L9:
        Method r100 = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L8
        sSuppressLayoutMethod = r100;     // Catch: NoSuchMethodException -> L8
        r100.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L6:
        sSuppressLayoutMethodFetched = true;
    }

    private ViewGroupUtilsApi18() {
    }

    public static void suppressLayout(ViewGroup r100, boolean r101) {
        fetchSuppressLayoutMethod();
        Method r102 = sSuppressLayoutMethod;
        if (r102 != null) goto L8;
        return;
    L8:
        r102.invoke(r100, new Object[]{Boolean.valueOf(r101)});     // Catch: Throwable -> L7
        return;
    }
}
