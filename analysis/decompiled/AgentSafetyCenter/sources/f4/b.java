package f4;

import java.lang.invoke.VarHandle;
import jb.v;
import k0.r1;
import kc.t;
import kc.w;
import nb.h;
import nc.g;
import od.f;
import pb.i;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends i implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3911c;

    /* renamed from: f, reason: collision with root package name */
    public int f3912f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f3913g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ r1 f3914h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(g gVar, r1 r1Var, nb.c cVar, int i) {
        super(2, cVar);
        this.f3911c = i;
        this.f3913g = gVar;
        this.f3914h = r1Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f3911c) {
            case 0:
                return new b(this.f3913g, this.f3914h, cVar, 0);
            default:
                return new b(this.f3913g, this.f3914h, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        t tVar = (t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f3911c) {
        }
        return ((b) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f3911c;
        v vVar = v.f6774a;
        g gVar = this.f3913g;
        r1 r1Var = this.f3914h;
        nb.c cVar = null;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i3 = this.f3912f;
                if (i3 != 0) {
                    if (i3 == 1) {
                        id.c.I(obj);
                        return vVar;
                    }
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                a aVar2 = new a(1);
                aVar2.f3910f = r1Var;
                VarHandle.storeStoreFence();
                this.f3912f = 1;
                return gVar.collect(aVar2, this) == aVar ? aVar : vVar;
            default:
                ob.a aVar3 = ob.a.f9351c;
                int i10 = this.f3912f;
                if (i10 != 0) {
                    if (i10 == 1 || i10 == 2) {
                        id.c.I(obj);
                        return vVar;
                    }
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                h hVar = h.f8811c;
                int i11 = 0;
                if (hVar.equals(hVar)) {
                    a aVar4 = new a(0);
                    aVar4.f3910f = r1Var;
                    VarHandle.storeStoreFence();
                    this.f3912f = 1;
                    if (gVar.collect(aVar4, this) != aVar3) {
                        return vVar;
                    }
                } else {
                    b bVar = new b(gVar, r1Var, cVar, i11);
                    this.f3912f = 2;
                    if (w.E(hVar, bVar, this) != aVar3) {
                        return vVar;
                    }
                }
                return aVar3;
        }
    }
}
