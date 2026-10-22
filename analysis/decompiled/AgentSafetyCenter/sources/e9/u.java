package e9;

import g9.g1;
import g9.j1;
import g9.m1;
import g9.t0;
import g9.u0;
import java.lang.invoke.VarHandle;
import java.util.UUID;
import m8.k0;
import v1.l1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u implements nc.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3725c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3726f;

    public /* synthetic */ u(int i) {
        this.f3725c = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nc.h
    public final Object emit(Object obj, nb.c cVar) throws Throwable {
        Object objE;
        int i = this.f3725c;
        Object[] objArr = 0;
        int i3 = 1;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                h hVar = (h) this.f3726f;
                rc.e eVar = kc.e0.f7430a;
                Object objE2 = kc.w.E(rc.d.f10552f, new f(hVar, objArr == true ? 1 : 0, i3), cVar);
                ob.a aVar = ob.a.f9351c;
                if (objE2 != aVar) {
                    objE2 = vVar;
                }
                return objE2 == aVar ? objE2 : vVar;
            case 1:
                t0 t0Var = (t0) obj;
                j1 j1Var = (j1) this.f3726f;
                t0Var.getClass();
                if (((Boolean) j1Var.f4504d.invoke(t0Var)).booleanValue()) {
                    mc.e eVar2 = j1Var.f4506f;
                    String string = UUID.randomUUID().toString();
                    string.getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    m1 m1Var = t0Var.f4616b == u0.f4626g ? (m1) j1Var.f4501a.f4631a.f4455g.f8841c.getValue() : null;
                    g1 g1Var = new g1();
                    g1Var.f4463a = string;
                    g1Var.f4464b = jCurrentTimeMillis;
                    g1Var.f4465c = t0Var;
                    g1Var.f4466d = m1Var;
                    VarHandle.storeStoreFence();
                    eVar2.h(g1Var);
                }
                return vVar;
            case 2:
                v.j jVar = (v.j) obj;
                u0.q qVar = (u0.q) this.f3726f;
                if (jVar instanceof v.h) {
                    qVar.add(jVar);
                } else if (jVar instanceof v.i) {
                    qVar.remove(((v.i) jVar).f14311a);
                } else if (jVar instanceof v.d) {
                    qVar.add(jVar);
                } else if (jVar instanceof v.e) {
                    qVar.remove(((v.e) jVar).f14303a);
                } else if (jVar instanceof v.m) {
                    qVar.add(jVar);
                } else if (jVar instanceof v.n) {
                    qVar.remove(((v.n) jVar).f14315a);
                } else if (jVar instanceof v.l) {
                    qVar.remove(((v.l) jVar).f14313a);
                }
                return vVar;
            case 3:
                k0.h((k0) this.f3726f, (x8.a) obj);
                return vVar;
            case 4:
                ((yb.u) this.f3726f).f16098c = obj;
                throw new oc.a(this);
            case 5:
                ((l1) this.f3726f).f14489c.h(((Number) obj).floatValue());
                return vVar;
            default:
                v3.z zVar = (v3.z) this.f3726f;
                return ((zVar.f14758l.b() instanceof v3.j0) || (objE = v3.z.e(zVar, true, cVar)) != ob.a.f9351c) ? vVar : objE;
        }
    }
}
