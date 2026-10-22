package stepos.support.v7.widget;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public abstract class I0 {

    /* renamed from: a, reason: collision with root package name */
    public static Method f6469a;
    public static Method b;
    public static int c;

    static {
        new E2.b().start();
        c = 1;
    }

    public static boolean a(View view, Rect rect, boolean z10, boolean z11) {
        boolean z12;
        int i;
        int i6;
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
        if (z10 && paddingTop != (i6 = rect.top)) {
            paddingTop = i6;
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
        return ViewCompat.getLayoutDirection(viewGroup) == 1;
    }

    public static void c(ViewGroup viewGroup) {
        try {
            Method method = b;
            if (method != null) {
                method.invoke(viewGroup, null);
                return;
            }
            if (c == 2) {
                new E2.b().run();
            }
            new Handler().postAtFrontOfQueue(new RunnableC1986e0(viewGroup, 3));
        } catch (IllegalAccessException e) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (InvocationTargetException e6) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e6.getTargetException());
        }
    }
}
