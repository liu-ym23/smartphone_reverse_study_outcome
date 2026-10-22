package e0;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class v {
    public static x0 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        x0 x0VarC = x0.c(null, rootWindowInsets);
        t0 t0Var = x0VarC.f2338a;
        t0Var.r(x0VarC);
        View rootView = view.getRootView();
        t0Var.d(rootView);
        t0Var.k(rootView);
        t0Var.l();
        return x0VarC;
    }
}
