package K;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class K {
    @Nullable
    public static z0 a(@NonNull View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        z0 z0VarF = z0.f(null, rootWindowInsets);
        x0 x0Var = z0VarF.f1023a;
        x0Var.m(z0VarF);
        x0Var.d(view.getRootView());
        return z0VarF;
    }

    @DoNotInline
    public static int b(@NonNull View view) {
        return view.getScrollIndicators();
    }

    @DoNotInline
    public static void c(@NonNull View view, int i4) {
        view.setScrollIndicators(i4);
    }

    @DoNotInline
    public static void d(@NonNull View view, int i4, int i5) {
        view.setScrollIndicators(i4, i5);
    }
}
