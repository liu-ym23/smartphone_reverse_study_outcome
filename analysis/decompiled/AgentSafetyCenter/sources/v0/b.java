package v0;

import e9.j;
import java.lang.invoke.VarHandle;
import java.util.List;
import k0.s;
import l0.j0;
import r2.i;
import t.n;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements j0, nb.e {

    /* renamed from: f, reason: collision with root package name */
    public static final i f14317f = new i(21);

    /* renamed from: c, reason: collision with root package name */
    public s f14318c;

    public final void a(Throwable th, Object obj) {
        j jVar = new j(16);
        jVar.f3666f = this;
        jVar.f3667g = obj;
        VarHandle.storeStoreFence();
        n.m(th, jVar);
    }

    @Override // l0.j0
    public final List c(Integer num) {
        return this.f14318c.F();
    }

    @Override // nb.g
    public final Object fold(Object obj, p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // nb.g
    public final nb.e get(nb.f fVar) {
        return ac.a.t(this, fVar);
    }

    @Override // nb.e
    public final nb.f getKey() {
        return f14317f;
    }

    @Override // nb.g
    public final nb.g minusKey(nb.f fVar) {
        return ac.a.H(this, fVar);
    }

    @Override // nb.g
    public final nb.g plus(nb.g gVar) {
        return ac.a.N(this, gVar);
    }
}
