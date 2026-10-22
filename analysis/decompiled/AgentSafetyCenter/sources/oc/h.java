package oc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9373c = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f9374f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f9375g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k f9376h;
    public final /* synthetic */ nc.h i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(k kVar, nc.h hVar, Object obj, nb.c cVar) {
        super(2, cVar);
        this.f9376h = kVar;
        this.i = hVar;
        this.f9375g = obj;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f9373c) {
            case 0:
                return new h(this.f9376h, this.i, this.f9375g, cVar);
            default:
                h hVar = new h(this.f9376h, this.i, cVar);
                hVar.f9375g = obj;
                return hVar;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f9373c) {
        }
        return ((h) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [pb.i, xb.q] */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f9373c;
        jb.v vVar = jb.v.f6774a;
        nc.h hVar = this.i;
        k kVar = this.f9376h;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i3 = this.f9374f;
                if (i3 != 0) {
                    if (i3 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                ?? r10 = kVar.i;
                Object obj2 = this.f9375g;
                this.f9374f = 1;
                return r10.invoke(hVar, obj2, this) == aVar ? aVar : vVar;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i10 = this.f9374f;
                if (i10 != 0) {
                    if (i10 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                kc.t tVar = (kc.t) this.f9375g;
                yb.u uVar = new yb.u();
                nc.g gVar = kVar.f9372h;
                j jVar = new j(0);
                jVar.f9382f = uVar;
                jVar.f9383g = tVar;
                jVar.f9384h = kVar;
                jVar.i = hVar;
                VarHandle.storeStoreFence();
                this.f9374f = 1;
                return gVar.collect(jVar, this) == aVar2 ? aVar2 : vVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(k kVar, nc.h hVar, nb.c cVar) {
        super(2, cVar);
        this.f9376h = kVar;
        this.i = hVar;
    }
}
