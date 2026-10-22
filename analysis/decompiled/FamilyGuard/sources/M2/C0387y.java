package M2;

import L2.e;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

/* renamed from: M2.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0387y implements K2.B<A> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4118a = "glass_text";

    @Override // K2.B
    public boolean a(Context context) {
        j4.k.g(context, "context");
        return L2.e.f3817a.n();
    }

    @Override // K2.B
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public K2.s c(View view, A a6) throws IllegalArgumentException {
        e.c cVarF;
        j4.k.g(view, "view");
        j4.k.g(a6, "params");
        if (!a6.b() || !(view instanceof TextView) || (cVarF = L2.e.f3817a.f(view)) == null) {
            return null;
        }
        C0386x c0386x = new C0386x(view, cVarF, a6.e());
        c0386x.z(a6);
        return c0386x;
    }

    @Override // K2.B
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public A b() {
        return new A();
    }

    @Override // K2.B
    public String getId() {
        return this.f4118a;
    }
}
