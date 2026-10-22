package v;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import jb.v;
import k0.c1;
import kc.t;
import nc.j0;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends pb.i implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14307c;

    /* renamed from: f, reason: collision with root package name */
    public int f14308f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k f14309g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c1 f14310h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(k kVar, c1 c1Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f14307c = i;
        this.f14309g = kVar;
        this.f14310h = c1Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f14307c) {
            case 0:
                return new g(this.f14309g, this.f14310h, cVar, 0);
            case 1:
                return new g(this.f14309g, this.f14310h, cVar, 1);
            default:
                return new g(this.f14309g, this.f14310h, cVar, 2);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        t tVar = (t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f14307c) {
        }
        return ((g) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i = this.f14307c;
        c1 c1Var = this.f14310h;
        k kVar = this.f14309g;
        v vVar = v.f6774a;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i3 = this.f14308f;
                if (i3 != 0) {
                    if (i3 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                ArrayList arrayList = new ArrayList();
                j0 j0Var = kVar.f14312a;
                f fVar = new f(0);
                fVar.f14305f = arrayList;
                fVar.f14306g = c1Var;
                VarHandle.storeStoreFence();
                this.f14308f = 1;
                j0Var.getClass();
                j0.i(j0Var, fVar, this);
                return aVar;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                int i10 = this.f14308f;
                if (i10 != 0) {
                    if (i10 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                ArrayList arrayList2 = new ArrayList();
                j0 j0Var2 = kVar.f14312a;
                f fVar2 = new f(1);
                fVar2.f14305f = arrayList2;
                fVar2.f14306g = c1Var;
                VarHandle.storeStoreFence();
                this.f14308f = 1;
                j0Var2.getClass();
                j0.i(j0Var2, fVar2, this);
                return aVar2;
            default:
                ob.a aVar3 = ob.a.f9351c;
                int i11 = this.f14308f;
                if (i11 != 0) {
                    if (i11 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                ArrayList arrayList3 = new ArrayList();
                j0 j0Var3 = kVar.f14312a;
                f fVar3 = new f(2);
                fVar3.f14305f = arrayList3;
                fVar3.f14306g = c1Var;
                VarHandle.storeStoreFence();
                this.f14308f = 1;
                j0Var3.getClass();
                j0.i(j0Var3, fVar3, this);
                return aVar3;
        }
    }
}
