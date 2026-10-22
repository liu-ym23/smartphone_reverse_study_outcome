package stepos.support.v7.widget;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class x1 {

    /* renamed from: a, reason: collision with root package name */
    public static Method f12901a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f12902b;

    /* renamed from: c, reason: collision with root package name */
    public static int f12903c;

    static {
        new j6.h().start();
        f12903c = 1;
    }

    public static boolean a(View view, Rect rect, boolean z10, boolean z11) {
        boolean z12;
        int i;
        int i3;
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        int i10 = rect.left;
        boolean z13 = true;
        if (paddingLeft != i10) {
            paddingLeft = i10;
            z12 = true;
        } else {
            z12 = false;
        }
        if (z10 && paddingTop != (i3 = rect.top)) {
            paddingTop = i3;
            z12 = true;
        }
        int i11 = rect.right;
        if (paddingRight != i11) {
            paddingRight = i11;
            z12 = true;
        }
        if (!z11 || paddingBottom == (i = rect.bottom)) {
            z13 = z12;
        } else {
            paddingBottom = i;
        }
        if (z13) {
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        return z13;
    }

    public static boolean b(ViewGroup viewGroup) {
        WeakHashMap weakHashMap = n3.k0.f8724a;
        return viewGroup.getLayoutDirection() == 1;
    }

    public static void c(View view) {
        try {
            Method method = f12902b;
            if (method != null) {
                method.invoke(view, null);
                return;
            }
            if (f12903c == 2) {
                new j6.h().run();
            }
            Handler handler = new Handler();
            w0 w0Var = new w0(3);
            w0Var.f12894f = view;
            VarHandle.storeStoreFence();
            handler.postAtFrontOfQueue(w0Var);
        } catch (IllegalAccessException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        } catch (InvocationTargetException e11) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e11.getTargetException());
        }
    }
}
