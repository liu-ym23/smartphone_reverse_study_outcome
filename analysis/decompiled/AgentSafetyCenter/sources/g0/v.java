package g0;

import k0.z;
import s.c1;
import s.e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4191c = 0;

    /* renamed from: f, reason: collision with root package name */
    public float f4192f;

    /* renamed from: g, reason: collision with root package name */
    public int f4193g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f4194h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(ed.e eVar, float f5, s.h hVar, nb.c cVar) {
        super(2, cVar);
        this.f4194h = eVar;
        this.f4192f = f5;
        this.i = hVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f4191c) {
            case 0:
                return new v((ed.e) this.f4194h, this.f4192f, (s.h) this.i, cVar);
            default:
                v vVar = new v((e1) this.i, cVar);
                vVar.f4194h = obj;
                return vVar;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f4191c) {
        }
        return ((v) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        float fK;
        kc.t tVar;
        switch (this.f4191c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f4193g;
                if (i == 0) {
                    id.c.I(obj);
                    s.c cVar = (s.c) ((ed.e) this.f4194h).f3785c;
                    Float f5 = new Float(this.f4192f);
                    s.h hVar = (s.h) this.i;
                    this.f4193g = 1;
                    if (s.c.c(cVar, f5, hVar, null, this, 12) == aVar) {
                    }
                } else if (i != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f4193g;
                if (i3 == 0) {
                    id.c.I(obj);
                    kc.t tVar2 = (kc.t) this.f4194h;
                    fK = s.d.k(tVar2.n());
                    tVar = tVar2;
                } else if (i3 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    fK = this.f4192f;
                    tVar = (kc.t) this.f4194h;
                    id.c.I(obj);
                }
                while (kc.w.r(tVar)) {
                    c1 c1Var = new c1((e1) this.i, fK);
                    this.f4194h = tVar;
                    this.f4192f = fK;
                    this.f4193g = 1;
                    if (z.s(getContext()).C(c1Var, this) == aVar2) {
                        break;
                    }
                }
                break;
        }
        return jb.v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(e1 e1Var, nb.c cVar) {
        super(2, cVar);
        this.i = e1Var;
    }
}
