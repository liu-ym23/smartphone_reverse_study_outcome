package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: GhostViewPlatform.java */
/* JADX INFO: loaded from: classes.dex */
class j implements i {
    private static final String TAG = "GhostViewApi21";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f2840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f2841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f2842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f2843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f2844e;
    private static boolean f;
    private final View g;

    @Override // androidx.transition.i
    public void reserveEndViewTransition(ViewGroup r1, View r2) {
    }

    static i a(View r5, ViewGroup r6, Matrix r7) {
        b();
        if (f2842c != null) goto L11;
    L9:
        return null;
    L11:
        return new j((View) ZeusTransformUtils.preCheckCast(f2842c.invoke(null, new Object[]{r5, r6, r7}), View.class, "com.obric.aiagent.plugin"));
    L6:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    static void a(View r4) {
        c();
        Method r0 = f2844e;
        if (r0 != null) goto L12;
        return;
    L12:
        r0.invoke(null, new Object[]{r4});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    private j(View r1) {
        this.g = r1;
    }

    @Override // androidx.transition.i
    public void setVisibility(int r1) {
        this.g.setVisibility(r1);
    }

    private static void a() {
        if (f2841b == true) goto L12;
        f2840a = ZeusTransformUtils.forName("android.view.GhostView", "com.obric.aiagent.plugin");     // Catch: ClassNotFoundException -> L6
    L8:
        f2841b = true;
        return;
    L6:
        e = move-exception;
        a(TAG, "Failed to retrieve GhostView class", e);
        goto L8
    }

    private static void b() {
        if (f2843d == false) goto L11;
        return;
    L11:
        a();     // Catch: NoSuchMethodException -> L7
        Method r1 = f2840a.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});     // Catch: NoSuchMethodException -> L7
        f2842c = r1;     // Catch: NoSuchMethodException -> L7
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        f2843d = true;
        return;
    L7:
        e = move-exception;
        a(TAG, "Failed to retrieve addGhost method", e);
        goto L9
    }

    private static void c() {
        if (f == false) goto L11;
        return;
    L11:
        a();     // Catch: NoSuchMethodException -> L7
        Method r1 = f2840a.getDeclaredMethod("removeGhost", new Class[]{View.class});     // Catch: NoSuchMethodException -> L7
        f2844e = r1;     // Catch: NoSuchMethodException -> L7
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        f = true;
        return;
    L7:
        e = move-exception;
        a(TAG, "Failed to retrieve removeGhost method", e);
        goto L9
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }
}
