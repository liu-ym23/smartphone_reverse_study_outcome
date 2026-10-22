package T1;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f5389a;

    static {
        try {
            f5389a = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
        }
    }

    public static int a(Context context) {
        return a5.g.a(context);
    }

    public static int b(Context context) throws Resources.NotFoundException, SecurityException {
        Method method;
        Log.d("ActionbarUtils", "getActionBarTabHeight() called with: context = [" + context + "]");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(P1.b.f4545a);
        try {
            Method[] methods = androidx.appcompat.view.a.class.getMethods();
            int length = methods.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    method = null;
                    break;
                }
                method = methods[i5];
                if (method.getGenericReturnType() == androidx.appcompat.view.a.class) {
                    break;
                }
                i5++;
            }
            if (method == null) {
                Log.w("ActionbarUtils", "getActionBarTabHeight() called with: getMethod = null");
                return dimensionPixelSize;
            }
            method.setAccessible(true);
            androidx.appcompat.view.a aVar = (androidx.appcompat.view.a) method.invoke(null, context);
            if (aVar != null) {
                return aVar.f();
            }
            Log.w("ActionbarUtils", "getActionBarTabHeight() called with: policy = null");
            return dimensionPixelSize;
        } catch (IllegalAccessException | InvocationTargetException e6) {
            e6.printStackTrace();
            return dimensionPixelSize;
        }
    }

    public static int c(Context context) {
        return N1.i.e(context);
    }

    public static void d(Activity activity, boolean z5) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(z5 ? systemUiVisibility | 16 : systemUiVisibility & (-17));
    }

    public static void e(Activity activity, boolean z5) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(z5 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    public static void f(Activity activity, boolean z5, boolean z6) {
        View decorView = activity.getWindow().getDecorView();
        if (z5) {
            decorView.setSystemUiVisibility(9216);
        } else {
            decorView.setSystemUiVisibility(1280);
        }
    }
}
