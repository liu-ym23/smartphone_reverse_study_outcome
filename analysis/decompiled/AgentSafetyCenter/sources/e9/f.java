package e9;

import java.io.IOException;
import nc.t0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3644c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f3645f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(h hVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f3644c = i;
        this.f3645f = hVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f3644c) {
            case 0:
                return new f(this.f3645f, cVar, 0);
            case 1:
                return new f(this.f3645f, cVar, 1);
            default:
                return new f(this.f3645f, cVar, 2);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f3644c) {
            case 0:
                f fVar = (f) create(tVar, cVar);
                jb.v vVar = jb.v.f6774a;
                fVar.invokeSuspend(vVar);
                return vVar;
            case 1:
                f fVar2 = (f) create(tVar, cVar);
                jb.v vVar2 = jb.v.f6774a;
                fVar2.invokeSuspend(vVar2);
                return vVar2;
            default:
                ((f) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
                throw null;
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws IOException {
        int i = this.f3644c;
        jb.v vVar = jb.v.f6774a;
        h hVar = this.f3645f;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                t0 t0Var = hVar.f3660d;
                t0Var.g(null, z.a((z) t0Var.getValue(), false, 7));
                h.a(hVar);
                return vVar;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                h.a(hVar);
                return vVar;
            default:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                throw null;
        }
    }
}
