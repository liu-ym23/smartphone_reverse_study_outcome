package M2;

import L2.e;
import L2.j;
import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public final class L implements K2.B<M> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4019a = "glass_inner_shadow";

    @Override // K2.B
    public boolean a(Context context) {
        j4.k.g(context, "context");
        return L2.e.f3817a.n() || L2.j.f3840a.v();
    }

    @Override // K2.B
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public K2.s c(View view, M m5) {
        j4.k.g(view, "view");
        j4.k.g(m5, "params");
        if (m5.b()) {
            e.c cVarF = L2.e.f3817a.f(view);
            if (cVarF == null) {
                return null;
            }
            K k5 = new K(cVarF);
            k5.e(m5);
            return k5;
        }
        j.c cVarM = L2.j.f3840a.m(view);
        if (cVarM == null) {
            return null;
        }
        C0366c c0366c = new C0366c(cVarM);
        c0366c.e(m5);
        return c0366c;
    }

    @Override // K2.B
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public M b() {
        return new M();
    }

    @Override // K2.B
    public String getId() {
        return this.f4019a;
    }
}
