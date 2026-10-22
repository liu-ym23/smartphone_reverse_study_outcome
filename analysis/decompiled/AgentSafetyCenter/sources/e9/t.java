package e9;

import java.lang.invoke.VarHandle;
import nc.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3722c;

    /* renamed from: f, reason: collision with root package name */
    public int f3723f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f3724g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(h hVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f3722c = i;
        this.f3724g = hVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f3722c) {
            case 0:
                return new t(this.f3724g, cVar, 0);
            case 1:
                return new t(this.f3724g, cVar, 1);
            case 2:
                return new t(this.f3724g, cVar, 2);
            default:
                return new t(this.f3724g, cVar, 3);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f3722c) {
        }
        return ((t) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i = this.f3722c;
        boolean z10 = false;
        h hVar = this.f3724g;
        jb.v vVar = jb.v.f6774a;
        int i3 = 1;
        char c9 = 1;
        char c10 = 1;
        nb.c cVar = null;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i10 = this.f3723f;
                if (i10 != 0) {
                    if (i10 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                this.f3723f = 1;
                rc.e eVar = kc.e0.f7430a;
                Object objE = kc.w.E(rc.d.f10552f, new f(hVar, null, 0), this);
                if (objE != aVar) {
                    objE = vVar;
                }
                return objE == aVar ? aVar : vVar;
            case 1:
                Object obj2 = ob.a.f9351c;
                int i11 = this.f3723f;
                if (i11 != 0) {
                    if (i11 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                nc.c cVarE = k0.e(new androidx.lifecycle.h0(hVar, (nb.c) null, 3));
                u uVar = new u(0);
                uVar.f3726f = hVar;
                VarHandle.storeStoreFence();
                this.f3723f = 1;
                return cVarE.collect(uVar, this) == obj2 ? obj2 : vVar;
            case 2:
                ob.a aVar2 = ob.a.f9351c;
                int i12 = this.f3723f;
                if (i12 != 0) {
                    if (i12 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                this.f3723f = 1;
                rc.e eVar2 = kc.e0.f7430a;
                Object objE2 = kc.w.E(rc.d.f10552f, new g(hVar, c10 == true ? 1 : 0, cVar, c9 == true ? 1 : 0), this);
                if (objE2 != aVar2) {
                    objE2 = vVar;
                }
                return objE2 == aVar2 ? aVar2 : vVar;
            default:
                ob.a aVar3 = ob.a.f9351c;
                int i13 = this.f3723f;
                if (i13 != 0) {
                    if (i13 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                this.f3723f = 1;
                rc.e eVar3 = kc.e0.f7430a;
                Object objE3 = kc.w.E(rc.d.f10552f, new g(hVar, z10, cVar, i3), this);
                if (objE3 != aVar3) {
                    objE3 = vVar;
                }
                return objE3 == aVar3 ? aVar3 : vVar;
        }
    }
}
