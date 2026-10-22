package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    private ViewUtils() {
    }

    static {
        Method r100 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L6
        sComputeFitSystemWindowsMethod = r100;     // Catch: NoSuchMethodException -> L6
        if (r100.isAccessible() == true) goto L9;
        sComputeFitSystemWindowsMethod.setAccessible(true);     // Catch: NoSuchMethodException -> L6
        return;
    L9:
        return;
    }

    public static boolean isLayoutRtl(View r100) {
        if (ViewCompat.getLayoutDirection(r100) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void makeOptionalFitsSystemWindows(View r100) {
        Method r101 = r100.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);     // Catch: Throwable -> L7
        if (r101.isAccessible() == true) goto L5;
        r101.setAccessible(true);     // Catch: Throwable -> L7
    L5:
        r101.invoke(r100, new Object[0]);     // Catch: Throwable -> L7
        return;
    }

    public static void computeFitSystemWindows(View r100, Rect r101, Rect r102) {
        Method r103 = sComputeFitSystemWindowsMethod;
        if (r103 != null) goto L8;
        return;
    L8:
        r103.invoke(r100, new Object[]{r101, r102});     // Catch: Exception -> L7
        return;
    }
}
