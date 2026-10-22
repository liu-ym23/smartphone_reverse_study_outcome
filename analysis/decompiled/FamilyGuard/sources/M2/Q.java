package M2;

import L2.e;
import L2.j;
import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public final class Q implements K2.B<T> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4028a = "glass_refraction";

    @Override // K2.B
    public boolean a(Context context) {
        j4.k.g(context, "context");
        return L2.e.f3817a.n() || L2.j.f3840a.v();
    }

    @Override // K2.B
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public K2.s c(View view, T t5) {
        j4.k.g(view, "view");
        j4.k.g(t5, "params");
        if (t5.b()) {
            e.c cVarF = L2.e.f3817a.f(view);
            if (cVarF == null) {
                return null;
            }
            P p5 = new P(cVarF);
            p5.e(t5);
            return p5;
        }
        j.c cVarM = L2.j.f3840a.m(view);
        if (cVarM == null) {
            return null;
        }
        C0369f c0369f = new C0369f(cVarM);
        c0369f.e(t5);
        return c0369f;
    }

    @Override // K2.B
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public T b() {
        return new T();
    }

    @Override // K2.B
    public String getId() {
        return this.f4028a;
    }
}
