package n3;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f0 {
    public static m1 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        m1 m1VarH = m1.h(null, rootWindowInsets);
        j1 j1Var = m1VarH.f8737a;
        j1Var.y(m1VarH);
        View rootView = view.getRootView();
        j1Var.d(rootView);
        j1Var.p(rootView);
        j1Var.q();
        return m1VarH;
    }
}
