package m8;

import android.util.Log;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.Set;
import kc.w0;
import s8.v3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8324c;

    /* renamed from: f, reason: collision with root package name */
    public int f8325f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0 f8326g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, k0 k0Var, nb.c cVar) {
        super(2, cVar);
        this.f8324c = i;
        this.f8326g = k0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8324c) {
            case 0:
                return new d(0, this.f8326g, cVar);
            case 1:
                return new d(1, this.f8326g, cVar);
            case 2:
                return new d(2, this.f8326g, cVar);
            case 3:
                return new d(3, this.f8326g, cVar);
            case 4:
                return new d(4, this.f8326g, cVar);
            case 5:
                return new d(5, this.f8326g, cVar);
            case 6:
                return new d(6, this.f8326g, cVar);
            default:
                return new d(7, this.f8326g, cVar);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f8324c) {
        }
        return ((d) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE;
        int i = this.f8324c;
        jb.v vVar = jb.v.f6774a;
        k0 k0Var = this.f8326g;
        int i3 = 1;
        nb.c cVar = null;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i10 = this.f8325f;
                if (i10 == 0) {
                    id.c.I(obj);
                    x8.c cVar2 = (x8.c) k0Var.f8424h.getValue();
                    cVar2.getClass();
                    nc.c cVarE = nc.k0.e(new t5.e(cVar2, cVar, 9));
                    nc.n nVar = new nc.n(5);
                    nVar.f8888f = cVarE;
                    nVar.f8889g = cVar2;
                    VarHandle.storeStoreFence();
                    rc.e eVar = kc.e0.f7430a;
                    rc.d dVar = rc.d.f10552f;
                    if (dVar.get(w0.f7498c) == null) {
                        nc.g gVarA = nVar;
                        if (!dVar.equals(nb.h.f8811c)) {
                            gVarA = nVar instanceof oc.r ? oc.c.a((oc.r) nVar, dVar, 0, null, 6) : new oc.g(nVar, dVar, 0, null, 12);
                        }
                        nc.g gVarG = nc.k0.g(gVarA);
                        e9.u uVar = new e9.u(3);
                        uVar.f3726f = k0Var;
                        VarHandle.storeStoreFence();
                        this.f8325f = 1;
                        return gVarG.collect(uVar, this) == aVar ? aVar : vVar;
                    }
                    g5.f.l(dVar, "Flow context cannot contain job in it. Had ");
                } else {
                    if (i10 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                }
                return null;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                int i11 = this.f8325f;
                if (i11 != 0) {
                    if (i11 == 1) {
                        id.c.I(obj);
                        return obj;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                v3 v3Var = (v3) k0Var.f8423g.getValue();
                this.f8325f = 1;
                Serializable serializableA = v3Var.a(this);
                return serializableA == aVar2 ? aVar2 : serializableA;
            case 2:
                ob.a aVar3 = ob.a.f9351c;
                int i12 = this.f8325f;
                if (i12 == 0) {
                    id.c.I(obj);
                    rc.e eVar2 = kc.e0.f7430a;
                    rc.d dVar2 = rc.d.f10552f;
                    d dVar3 = new d(i3, k0Var, cVar);
                    this.f8325f = 1;
                    objE = kc.w.E(dVar2, dVar3, this);
                    if (objE == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i12 != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                    objE = obj;
                }
                k0Var.U(a.a(k0Var.v(), false, null, null, null, 0, null, (Set) objE, false, null, null, 0, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1073741759));
                return vVar;
            case 3:
                ob.a aVar4 = ob.a.f9351c;
                int i13 = this.f8325f;
                if (i13 != 0) {
                    if (i13 == 1) {
                        id.c.I(obj);
                        return obj;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                q8.t tVarU = k0Var.u();
                this.f8325f = 1;
                Object objG = tVarU.g(this);
                return objG == aVar4 ? aVar4 : objG;
            case 4:
                ob.a aVar5 = ob.a.f9351c;
                int i14 = this.f8325f;
                if (i14 != 0) {
                    if (i14 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                x8.a aVarA = ((x8.c) k0Var.f8424h.getValue()).a();
                rc.e eVar3 = kc.e0.f7430a;
                lc.d dVar4 = pc.n.f9978a.i;
                androidx.lifecycle.r rVar = new androidx.lifecycle.r(k0Var, aVarA, cVar, 8);
                this.f8325f = 1;
                return kc.w.E(dVar4, rVar, this) == aVar5 ? aVar5 : vVar;
            case 5:
                ob.a aVar6 = ob.a.f9351c;
                int i15 = this.f8325f;
                if (i15 == 0) {
                    id.c.I(obj);
                    Log.i("BehaviorAnalysis", "READ_MEDIA (images/video/audio) granted: reload dashboard with trash filter");
                    this.f8325f = 1;
                    if (k0.i(k0Var, this) == aVar6) {
                        return aVar6;
                    }
                } else {
                    if (i15 != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                k0Var.N();
                return vVar;
            case 6:
                ob.a aVar7 = ob.a.f9351c;
                int i16 = this.f8325f;
                if (i16 == 0) {
                    id.c.I(obj);
                    this.f8325f = 1;
                    Object objS = k0Var.s(this);
                    return objS == aVar7 ? aVar7 : objS;
                }
                if (i16 == 1) {
                    id.c.I(obj);
                    return obj;
                }
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                ob.a aVar8 = ob.a.f9351c;
                int i17 = this.f8325f;
                if (i17 == 0) {
                    id.c.I(obj);
                    this.f8325f = 1;
                    return k0.i(k0Var, this) == aVar8 ? aVar8 : vVar;
                }
                if (i17 == 1) {
                    id.c.I(obj);
                    return vVar;
                }
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
