package u8;

import Zb.d;
import android.text.Spanned;
import android.widget.TextView;
import u8.g;
import u8.k;
import u8.m;
import v8.C5671a;

/* loaded from: classes4.dex */
public interface i {

    public interface a<P extends i> {
        void a(P p10);
    }

    public interface b {
        <P extends i> P a(Class<P> cls);

        <P extends i> void b(Class<P> cls, a<? super P> aVar);
    }

    void a(k.a aVar);

    void b(Yb.u uVar, m mVar);

    void c(m.b bVar);

    void d(Yb.u uVar);

    void e(TextView textView);

    void f(g.b bVar);

    String g(String str);

    void h(d.b bVar);

    void i(b bVar);

    void j(TextView textView, Spanned spanned);

    void k(C5671a.C0540a c0540a);
}
