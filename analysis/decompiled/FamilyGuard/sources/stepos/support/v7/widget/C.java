package stepos.support.v7.widget;

import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.H;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class C {

    /* renamed from: a, reason: collision with root package name */
    private static Method f21561a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f21562b;

    /* renamed from: c, reason: collision with root package name */
    private static int f21563c;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f21564a;

        a(View view) {
            this.f21564a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.n(this.f21564a);
        }
    }

    private static class b extends Thread {
        private b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws NoSuchMethodException, SecurityException {
            if (C.f21562b == null) {
                C.k();
            }
            if (C.f21561a == null) {
                C.j();
            }
            int unused = C.f21563c = 2;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        new b(null).start();
        f21563c = 1;
    }

    public static boolean f(View view, Rect rect, boolean z5, boolean z6, boolean z7, boolean z8) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        boolean z9 = false;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (z5) {
                int i5 = marginLayoutParams.leftMargin;
                int i6 = rect.left;
                if (i5 != i6) {
                    marginLayoutParams.leftMargin = i6;
                    z9 = true;
                }
            }
            if (z6) {
                int i7 = marginLayoutParams.topMargin;
                int i8 = rect.top;
                if (i7 != i8) {
                    marginLayoutParams.topMargin = i8;
                    z9 = true;
                }
            }
            if (z7) {
                int i9 = marginLayoutParams.rightMargin;
                int i10 = rect.right;
                if (i9 != i10) {
                    marginLayoutParams.rightMargin = i10;
                    z9 = true;
                }
            }
            if (z8) {
                int i11 = marginLayoutParams.bottomMargin;
                int i12 = rect.bottom;
                if (i11 != i12) {
                    marginLayoutParams.bottomMargin = i12;
                    return true;
                }
            }
        }
        return z9;
    }

    public static boolean g(View view, Rect rect, boolean z5, boolean z6, boolean z7, boolean z8) {
        boolean z9;
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        boolean z10 = true;
        if (!z5 || paddingLeft == (i8 = rect.left)) {
            z9 = false;
        } else {
            paddingLeft = i8;
            z9 = true;
        }
        if (z6 && paddingTop != (i7 = rect.top)) {
            paddingTop = i7;
            z9 = true;
        }
        if (z7 && paddingRight != (i6 = rect.right)) {
            paddingRight = i6;
            z9 = true;
        }
        if (!z8 || paddingBottom == (i5 = rect.bottom)) {
            z10 = z9;
        } else {
            paddingBottom = i5;
        }
        if (z10) {
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        return z10;
    }

    public static int h(int i5, int i6) {
        return i5 | i6;
    }

    public static boolean i(View view, Rect rect, Rect rect2) {
        Method method = f21561a;
        if (method == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(view, rect, rect2)).booleanValue();
        } catch (Exception e6) {
            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e6);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f21561a = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            f21561a.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() throws NoSuchMethodException, SecurityException {
        try {
            Method method = View.class.getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            f21562b = method;
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        }
    }

    public static void l() {
        if (f21561a == null || f21562b == null) {
            int i5 = f21563c;
            if (i5 == 2 || i5 == 0) {
                new b(null).start();
                f21563c = 1;
            }
        }
    }

    public static boolean m(View view) {
        return H.x(view) == 1;
    }

    public static void n(View view) {
        try {
            Method method = f21562b;
            a aVar = null;
            if (method != null) {
                method.invoke(view, null);
                return;
            }
            if (f21563c == 2) {
                new b(aVar).run();
            }
            new Handler().postAtFrontOfQueue(new a(view));
        } catch (IllegalAccessException e6) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e6);
        } catch (InvocationTargetException e7) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e7.getTargetException());
        }
    }
}
