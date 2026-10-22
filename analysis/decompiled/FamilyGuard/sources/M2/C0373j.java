package M2;

import L2.e;
import L2.j;
import android.content.Context;
import android.view.View;

/* renamed from: M2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0373j implements K2.B<C0374k> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4065a = "glass_blend";

    @Override // K2.B
    public boolean a(Context context) {
        j4.k.g(context, "context");
        return L2.e.f3817a.n() || L2.j.f3840a.v();
    }

    @Override // K2.B
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public K2.s c(View view, C0374k c0374k) {
        j4.k.g(view, "view");
        j4.k.g(c0374k, "params");
        if (c0374k.b()) {
            e.c cVarF = L2.e.f3817a.f(view);
            if (cVarF == null) {
                return null;
            }
            r rVar = new r(cVarF);
            rVar.e(c0374k);
            return rVar;
        }
        j.c cVarM = L2.j.f3840a.m(view);
        if (cVarM == null) {
            return null;
        }
        F f5 = new F(cVarM);
        f5.e(c0374k);
        return f5;
    }

    @Override // K2.B
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0374k b() {
        return new C0374k();
    }

    @Override // K2.B
    public String getId() {
        return this.f4065a;
    }
}
