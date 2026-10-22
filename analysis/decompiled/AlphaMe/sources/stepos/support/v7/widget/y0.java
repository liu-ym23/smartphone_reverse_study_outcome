package stepos.support.v7.widget;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import k3.C0687b;

/* loaded from: classes2.dex */
public abstract class y0 {

    /* renamed from: a, reason: collision with root package name */
    public static Method f15251a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f15252b;

    /* renamed from: c, reason: collision with root package name */
    public static int f15253c;

    static {
        new C0687b().start();
        f15253c = 1;
    }

    public static boolean a(FrameLayout frameLayout, Rect rect, boolean z4, boolean z5) {
        boolean z6;
        int i4;
        int i5;
        int paddingLeft = frameLayout.getPaddingLeft();
        int paddingTop = frameLayout.getPaddingTop();
        int paddingRight = frameLayout.getPaddingRight();
        int paddingBottom = frameLayout.getPaddingBottom();
        int i6 = rect.left;
        boolean z7 = true;
        if (paddingLeft != i6) {
            paddingLeft = i6;
            z6 = true;
        } else {
            z6 = false;
        }
        if (z4 && paddingTop != (i5 = rect.top)) {
            paddingTop = i5;
            z6 = true;
        }
        int i7 = rect.right;
        if (paddingRight != i7) {
            paddingRight = i7;
            z6 = true;
        }
        if (!z5 || paddingBottom == (i4 = rect.bottom)) {
            z7 = z6;
        } else {
            paddingBottom = i4;
        }
        if (z7) {
            frameLayout.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        return z7;
    }

    public static boolean b(View view) {
        WeakHashMap weakHashMap = K.S.f939a;
        return view.getLayoutDirection() == 1;
    }

    public static void c(View view) {
        try {
            Method method = f15252b;
            if (method != null) {
                method.invoke(view, new Object[0]);
                return;
            }
            if (f15253c == 2) {
                new C0687b().run();
            }
            new Handler().postAtFrontOfQueue(new J3.a(5, view));
        } catch (IllegalAccessException e4) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e4);
        } catch (InvocationTargetException e5) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e5.getTargetException());
        }
    }
}
