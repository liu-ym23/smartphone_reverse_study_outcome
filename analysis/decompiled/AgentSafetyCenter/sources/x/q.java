package x;

import jb.v;
import s.o0;
import u.j0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15475c;

    /* renamed from: f, reason: collision with root package name */
    public int f15476f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ r f15477g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, int i, nb.c cVar) {
        super(2, cVar);
        this.f15475c = 0;
        this.f15477g = rVar;
        this.f15476f = i;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f15475c) {
            case 0:
                return new q(this.f15477g, this.f15476f, cVar);
            case 1:
                return new q(this.f15477g, cVar, 1);
            default:
                return new q(this.f15477g, cVar, 2);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f15475c) {
            case 0:
                q qVar = (q) create((j0) obj, (nb.c) obj2);
                v vVar = v.f6774a;
                qVar.invokeSuspend(vVar);
                break;
        }
        return ((q) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f15475c;
        v vVar = v.f6774a;
        r rVar = this.f15477g;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                rVar.l(this.f15476f);
                break;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f15476f;
                if (i3 == 0) {
                    id.c.I(obj);
                    s.i iVar = rVar.f15500w;
                    Float f5 = new Float(0.0f);
                    o0 o0VarM = s.d.m(1, new Float(0.5f));
                    this.f15476f = 1;
                    if (s.d.f(iVar, f5, o0VarM, true, null, this, 8) == aVar2) {
                        break;
                    }
                } else if (i3 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            default:
                ob.a aVar3 = ob.a.f9351c;
                int i10 = this.f15476f;
                if (i10 == 0) {
                    id.c.I(obj);
                    s.i iVar2 = rVar.f15500w;
                    Float f10 = new Float(0.0f);
                    o0 o0VarM2 = s.d.m(1, new Float(0.5f));
                    this.f15476f = 1;
                    if (s.d.f(iVar2, f10, o0VarM2, true, null, this, 8) == aVar3) {
                        break;
                    }
                } else if (i10 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
        }
        return vVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(r rVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f15475c = i;
        this.f15477g = rVar;
    }
}
