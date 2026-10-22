package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewGroupUtils.java */
/* JADX INFO: loaded from: classes.dex */
class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f2782a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f2783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2784c;

    static {
    }

    static aa a(ViewGroup r2) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new z(r2);
    L7:
        return y.a(r2);
    }

    static void a(ViewGroup r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        r2.suppressLayout(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 18) goto L8;
        b(r2, r3);
        return;
    L8:
        ac.a(r2, r3);
    }

    private static void b(ViewGroup r1, boolean r2) {
        if (f2782a == false) goto L10;
        r1.suppressLayout(r2);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        f2782a = false;
        return;
    }

    static int a(ViewGroup r7, int r8) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return r7.getChildDrawingOrder(r8);
    L7:
        if (f2784c == false) goto L19;
    L10:
        Method r0 = f2783b;
        if (r0 != null) goto L17;
    L14:
        return r8;
    L17:
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.invoke(r7, new Object[]{Integer.valueOf(r7.getChildCount()), Integer.valueOf(r8)}), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L19:
        Method r1 = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: NoSuchMethodException -> L16
        f2783b = r1;     // Catch: NoSuchMethodException -> L16
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L16
    L9:
        f2784c = true;
        goto L10
    }
}
