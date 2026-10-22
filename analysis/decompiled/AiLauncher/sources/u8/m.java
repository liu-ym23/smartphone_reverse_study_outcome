package u8;

import Yb.B;

/* loaded from: classes4.dex */
public interface m extends B {

    public interface a {
        void a(m mVar, Yb.u uVar);

        void b(m mVar, Yb.u uVar);
    }

    public interface b {
        <N extends Yb.u> b a(Class<N> cls, c<? super N> cVar);

        b b(a aVar);

        m c(g gVar, r rVar);
    }

    public interface c<N extends Yb.u> {
        void a(m mVar, N n10);
    }

    void B();

    void C();

    <N extends Yb.u> void F(N n10, int i10);

    <N extends Yb.u> void b(N n10, int i10);

    v builder();

    void d(int i10, Object obj);

    void g(Yb.u uVar);

    boolean h(Yb.u uVar);

    int length();

    void q(Yb.u uVar);

    r r();

    void v(Yb.u uVar);

    g z();
}
