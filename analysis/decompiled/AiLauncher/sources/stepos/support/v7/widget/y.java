package stepos.support.v7.widget;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.N;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public static Method f41783a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f41784b;

    /* renamed from: c, reason: collision with root package name */
    public static int f41785c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f41786a;

        public a(View view) {
            this.f41786a = view;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            y.n(this.f41786a);
        }
    }

    public static class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws NoSuchMethodException, SecurityException {
            if (y.f41784b == null) {
                y.k();
            }
            if (y.f41783a == null) {
                y.j();
            }
            int unused = y.f41785c = 2;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        new b(null).start();
        f41785c = 1;
    }

    public static boolean f(View view, Rect rect, boolean z10, boolean z11, boolean z12, boolean z13) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        boolean z14 = false;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (z10) {
                int i10 = marginLayoutParams.leftMargin;
                int i11 = rect.left;
                if (i10 != i11) {
                    marginLayoutParams.leftMargin = i11;
                    z14 = true;
                }
            }
            if (z11) {
                int i12 = marginLayoutParams.topMargin;
                int i13 = rect.top;
                if (i12 != i13) {
                    marginLayoutParams.topMargin = i13;
                    z14 = true;
                }
            }
            if (z12) {
                int i14 = marginLayoutParams.rightMargin;
                int i15 = rect.right;
                if (i14 != i15) {
                    marginLayoutParams.rightMargin = i15;
                    z14 = true;
                }
            }
            if (z13) {
                int i16 = marginLayoutParams.bottomMargin;
                int i17 = rect.bottom;
                if (i16 != i17) {
                    marginLayoutParams.bottomMargin = i17;
                    return true;
                }
            }
        }
        return z14;
    }

    public static boolean g(View view, Rect rect, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14;
        int i10;
        int i11;
        int i12;
        int i13;
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        boolean z15 = true;
        if (!z10 || paddingLeft == (i13 = rect.left)) {
            z14 = false;
        } else {
            paddingLeft = i13;
            z14 = true;
        }
        if (z11 && paddingTop != (i12 = rect.top)) {
            paddingTop = i12;
            z14 = true;
        }
        if (z12 && paddingRight != (i11 = rect.right)) {
            paddingRight = i11;
            z14 = true;
        }
        if (!z13 || paddingBottom == (i10 = rect.bottom)) {
            z15 = z14;
        } else {
            paddingBottom = i10;
        }
        if (z15) {
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        return z15;
    }

    public static int h(int i10, int i11) {
        return i10 | i11;
    }

    public static boolean i(View view, Rect rect, Rect rect2) {
        Method method = f41783a;
        if (method == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(view, rect, rect2)).booleanValue();
        } catch (Exception e10) {
            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e10);
            return false;
        }
    }

    public static void j() throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f41783a = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            f41783a.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    public static void k() throws NoSuchMethodException, SecurityException {
        try {
            Method method = View.class.getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            f41784b = method;
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        }
    }

    public static void l() {
        if (f41783a == null || f41784b == null) {
            int i10 = f41785c;
            if (i10 == 2 || i10 == 0) {
                new b(null).start();
                f41785c = 1;
            }
        }
    }

    public static boolean m(View view) {
        return N.u(view) == 1;
    }

    public static void n(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = f41784b;
            a aVar = null;
            if (method != null) {
                method.invoke(view, null);
                return;
            }
            if (f41785c == 2) {
                new b(aVar).run();
            }
            new Handler().postAtFrontOfQueue(new a(view));
        } catch (IllegalAccessException e10) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e10);
        } catch (InvocationTargetException e11) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e11.getTargetException());
        }
    }
}
