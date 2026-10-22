package stepos.support.v7.widget;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static Method f12796a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f12797b;

    /* renamed from: c, reason: collision with root package name */
    public static int f12798c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends Thread {
        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws NoSuchMethodException, SecurityException {
            if (g0.f12797b == null) {
                try {
                    Method method = View.class.getMethod("makeOptionalFitsSystemWindows", null);
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    g0.f12797b = method;
                } catch (NoSuchMethodException unused) {
                    Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                }
            }
            if (g0.f12796a == null) {
                try {
                    Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                    g0.f12796a = declaredMethod;
                    if (!declaredMethod.isAccessible()) {
                        g0.f12796a.setAccessible(true);
                    }
                } catch (NoSuchMethodException unused2) {
                    Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                }
            }
            g0.f12798c = 2;
        }
    }

    static {
        new a().start();
        f12798c = 1;
    }

    public static boolean a(View view, Rect rect, boolean z, boolean z3) {
        boolean z10;
        int i10;
        int i11;
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        int i12 = rect.left;
        boolean z11 = true;
        if (paddingLeft != i12) {
            paddingLeft = i12;
            z10 = true;
        } else {
            z10 = false;
        }
        if (z && paddingTop != (i11 = rect.top)) {
            paddingTop = i11;
            z10 = true;
        }
        int i13 = rect.right;
        if (paddingRight != i13) {
            paddingRight = i13;
            z10 = true;
        }
        if (!z3 || paddingBottom == (i10 = rect.bottom)) {
            z11 = z10;
        } else {
            paddingBottom = i10;
        }
        if (z11) {
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        return z11;
    }

    public static boolean b(ViewGroup viewGroup) {
        WeakHashMap<View, h0> weakHashMap = v0.e0.f13274a;
        return viewGroup.getLayoutDirection() == 1;
    }

    public static void c(ViewGroup viewGroup) {
        try {
            Method method = f12797b;
            if (method != null) {
                method.invoke(viewGroup, null);
                return;
            }
            if (f12798c == 2) {
                new a().run();
            }
            new Handler().postAtFrontOfQueue(new v(viewGroup, 1));
        } catch (IllegalAccessException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        } catch (InvocationTargetException e11) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e11.getTargetException());
        }
    }
}
