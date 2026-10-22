package g0;

import s.h1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4150c;

    /* renamed from: f, reason: collision with root package name */
    public int f4151f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k f4152g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(k kVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f4150c = i;
        this.f4152g = kVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f4150c) {
            case 0:
                return new i(this.f4152g, cVar, 0);
            case 1:
                return new i(this.f4152g, cVar, 1);
            case 2:
                return new i(this.f4152g, cVar, 2);
            default:
                return new i(this.f4152g, cVar, 3);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f4150c) {
        }
        return ((i) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f4150c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f4151f;
                if (i == 0) {
                    id.c.I(obj);
                    s.c cVar = this.f4152g.f4161f;
                    Float f5 = new Float(1.0f);
                    h1 h1VarN = s.d.n(75, 2, s.w.f11153b);
                    this.f4151f = 1;
                    if (s.c.c(cVar, f5, h1VarN, null, this, 12) == aVar) {
                    }
                } else if (i != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f4151f;
                if (i3 == 0) {
                    id.c.I(obj);
                    s.c cVar2 = this.f4152g.f4162g;
                    Float f10 = new Float(1.0f);
                    h1 h1VarN2 = s.d.n(225, 2, s.w.f11152a);
                    this.f4151f = 1;
                    if (s.c.c(cVar2, f10, h1VarN2, null, this, 12) == aVar2) {
                    }
                } else if (i3 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            case 2:
                ob.a aVar3 = ob.a.f9351c;
                int i10 = this.f4151f;
                if (i10 == 0) {
                    id.c.I(obj);
                    s.c cVar3 = this.f4152g.f4163h;
                    Float f11 = new Float(1.0f);
                    h1 h1VarN3 = s.d.n(225, 2, s.w.f11153b);
                    this.f4151f = 1;
                    if (s.c.c(cVar3, f11, h1VarN3, null, this, 12) == aVar3) {
                    }
                } else if (i10 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
            default:
                ob.a aVar4 = ob.a.f9351c;
                int i11 = this.f4151f;
                if (i11 == 0) {
                    id.c.I(obj);
                    s.c cVar4 = this.f4152g.f4161f;
                    Float f12 = new Float(0.0f);
                    h1 h1VarN4 = s.d.n(150, 2, s.w.f11153b);
                    this.f4151f = 1;
                    if (s.c.c(cVar4, f12, h1VarN4, null, this, 12) == aVar4) {
                    }
                } else if (i11 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    id.c.I(obj);
                }
                break;
        }
        return jb.v.f6774a;
    }
}
