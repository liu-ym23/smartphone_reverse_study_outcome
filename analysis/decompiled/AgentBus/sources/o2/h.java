package o2;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class h implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f7234a;

    public h(View view, f fVar) {
        this.f7234a = fVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        g0 g0Var = this.f7234a.a(view, j0.a(view, windowInsets)).f7236a;
        if (g0Var instanceof y) {
            return ((y) g0Var).f7249b;
        }
        return null;
    }
}
