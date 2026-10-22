package androidx.activity;

import android.os.Build;
import android.view.View;
import android.view.Window;
import n3.n1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {
    public void a(h0 h0Var, h0 h0Var2, Window window, View view, boolean z10, boolean z11) {
        h0Var.getClass();
        h0Var2.getClass();
        window.getClass();
        view.getClass();
        com.stepos.statsrpk.h.F(window, false);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(false);
        n6.a n1Var = Build.VERSION.SDK_INT >= 35 ? new n1(window) : new n6.a(window);
        n1Var.n(!z10);
        n1Var.m(!z11);
    }
}
