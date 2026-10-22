package M2;

import L2.e;
import L2.j;
import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public final class Z implements K2.B<a0> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4038a = "glass_stroke";

    @Override // K2.B
    public boolean a(Context context) {
        j4.k.g(context, "context");
        return L2.e.f3817a.n() || L2.j.f3840a.v();
    }

    @Override // K2.B
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public K2.s c(View view, a0 a0Var) {
        j4.k.g(view, "view");
        j4.k.g(a0Var, "params");
        if (a0Var.b()) {
            e.c cVarF = L2.e.f3817a.f(view);
            if (cVarF == null) {
                return null;
            }
            Y y5 = new Y(cVarF);
            y5.e(a0Var);
            return y5;
        }
        j.c cVarM = L2.j.f3840a.m(view);
        if (cVarM == null) {
            return null;
        }
        C0372i c0372i = new C0372i(cVarM);
        c0372i.e(a0Var);
        return c0372i;
    }

    @Override // K2.B
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a0 b() {
        return new a0();
    }

    @Override // K2.B
    public String getId() {
        return this.f4038a;
    }
}
