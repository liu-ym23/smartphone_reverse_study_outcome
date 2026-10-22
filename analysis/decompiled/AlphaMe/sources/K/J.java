package K;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public abstract class J {
    @DoNotInline
    public static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    @DoNotInline
    public static z0 b(@NonNull View view, @NonNull z0 z0Var, @NonNull Rect rect) {
        WindowInsets windowInsetsE = z0Var.e();
        if (windowInsetsE != null) {
            return z0.f(view, view.computeSystemWindowInsets(windowInsetsE, rect));
        }
        rect.setEmpty();
        return z0Var;
    }

    @DoNotInline
    public static boolean c(@NonNull View view, float f4, float f5, boolean z4) {
        return view.dispatchNestedFling(f4, f5, z4);
    }

    @DoNotInline
    public static boolean d(@NonNull View view, float f4, float f5) {
        return view.dispatchNestedPreFling(f4, f5);
    }

    @DoNotInline
    public static boolean e(View view, int i4, int i5, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i4, i5, iArr, iArr2);
    }

    @DoNotInline
    public static boolean f(View view, int i4, int i5, int i6, int i7, int[] iArr) {
        return view.dispatchNestedScroll(i4, i5, i6, i7, iArr);
    }

    @DoNotInline
    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    @DoNotInline
    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    @DoNotInline
    public static float i(View view) {
        return view.getElevation();
    }

    @Nullable
    @DoNotInline
    public static z0 j(@NonNull View view) throws IllegalAccessException, IllegalArgumentException {
        if (!o0.f997d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = o0.f994a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) o0.f995b.get(obj);
            Rect rect2 = (Rect) o0.f996c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            q0 q0Var = new q0();
            q0Var.g(D.c.b(rect.left, rect.top, rect.right, rect.bottom));
            q0Var.e(D.c.b(rect2.left, rect2.top, rect2.right, rect2.bottom));
            z0 z0VarB = q0Var.b();
            z0VarB.f1023a.m(z0VarB);
            z0VarB.f1023a.d(view.getRootView());
            return z0VarB;
        } catch (IllegalAccessException e4) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e4.getMessage(), e4);
            return null;
        }
    }

    @DoNotInline
    public static String k(View view) {
        return view.getTransitionName();
    }

    @DoNotInline
    public static float l(View view) {
        return view.getTranslationZ();
    }

    @DoNotInline
    public static float m(@NonNull View view) {
        return view.getZ();
    }

    @DoNotInline
    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    @DoNotInline
    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    @DoNotInline
    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    @DoNotInline
    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    @DoNotInline
    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    @DoNotInline
    public static void s(View view, float f4) {
        view.setElevation(f4);
    }

    @DoNotInline
    public static void t(View view, boolean z4) {
        view.setNestedScrollingEnabled(z4);
    }

    @DoNotInline
    public static void u(@NonNull View view, @Nullable InterfaceC0088u interfaceC0088u) {
        if (interfaceC0088u == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new I(view, interfaceC0088u));
        }
    }

    @DoNotInline
    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    @DoNotInline
    public static void w(View view, float f4) {
        view.setTranslationZ(f4);
    }

    @DoNotInline
    public static void x(@NonNull View view, float f4) {
        view.setZ(f4);
    }

    @DoNotInline
    public static boolean y(View view, int i4) {
        return view.startNestedScroll(i4);
    }

    @DoNotInline
    public static void z(View view) {
        view.stopNestedScroll();
    }
}
