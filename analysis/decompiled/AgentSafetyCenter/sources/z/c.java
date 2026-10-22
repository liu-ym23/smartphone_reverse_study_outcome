package z;

import androidx.lifecycle.l0;
import jb.v;
import kc.t;
import kc.w;
import pb.i;
import u1.g1;
import xb.p;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends i implements p {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f16130c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f16131f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g1 f16132g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ l f16133h;
    public final /* synthetic */ ed.l i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(d dVar, g1 g1Var, xb.a aVar, ed.l lVar, nb.c cVar) {
        super(2, cVar);
        this.f16131f = dVar;
        this.f16132g = g1Var;
        this.f16133h = (l) aVar;
        this.i = lVar;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [xb.a, yb.l] */
    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        c cVar2 = new c(this.f16131f, this.f16132g, this.f16133h, this.i, cVar);
        cVar2.f16130c = obj;
        return cVar2;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((t) obj, (nb.c) obj2)).invokeSuspend(v.f6774a);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [xb.a, yb.l] */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        id.c.I(obj);
        t tVar = (t) this.f16130c;
        g1 g1Var = this.f16132g;
        ?? r22 = this.f16133h;
        d dVar = this.f16131f;
        w.u(tVar, null, null, new l0(dVar, g1Var, (xb.a) r22, (nb.c) null), 3);
        return w.u(tVar, null, null, new t5.e(dVar, this.i, null, 11), 3);
    }
}
