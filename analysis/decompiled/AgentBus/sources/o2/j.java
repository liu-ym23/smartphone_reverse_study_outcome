package o2;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class j {
    public static j0 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        j0 j0VarA = j0.a(null, rootWindowInsets);
        g0 g0Var = j0VarA.f7236a;
        g0Var.s(j0VarA);
        View rootView = view.getRootView();
        g0Var.d(rootView);
        g0Var.l(rootView);
        g0Var.m();
        return j0VarA;
    }
}
