package x;

import ia.b0;
import n.f1;
import w7.e0;

/* loaded from: classes.dex */
public final class h extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11014f;

    /* renamed from: g, reason: collision with root package name */
    public int f11015g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j f11016h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(j jVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f11014f = i2;
        this.f11016h = jVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f11014f) {
            case 0:
                return new h(this.f11016h, dVar, 0);
            case 1:
                return new h(this.f11016h, dVar, 1);
            case 2:
                return new h(this.f11016h, dVar, 2);
            default:
                return new h(this.f11016h, dVar, 3);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f11014f) {
        }
        return ((h) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f11014f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f11015g;
                if (i2 == 0) {
                    e0.N(obj);
                    n.c cVar = this.f11016h.f11025f;
                    Float f10 = new Float(1.0f);
                    f1 f1Var = new f1(75, n.u.f6737b);
                    this.f11015g = 1;
                    if (n.c.b(cVar, f10, f1Var, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f11015g;
                if (i10 == 0) {
                    e0.N(obj);
                    n.c cVar2 = this.f11016h.f11026g;
                    Float f11 = new Float(1.0f);
                    f1 f1Var2 = new f1(225, n.u.f6736a);
                    this.f11015g = 1;
                    if (n.c.b(cVar2, f11, f1Var2, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
            case 2:
                h7.a aVar3 = h7.a.f4212f;
                int i11 = this.f11015g;
                if (i11 == 0) {
                    e0.N(obj);
                    n.c cVar3 = this.f11016h.f11027h;
                    Float f12 = new Float(1.0f);
                    f1 f1Var3 = new f1(225, n.u.f6737b);
                    this.f11015g = 1;
                    if (n.c.b(cVar3, f12, f1Var3, this) == aVar3) {
                        return aVar3;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
            default:
                h7.a aVar4 = h7.a.f4212f;
                int i12 = this.f11015g;
                if (i12 == 0) {
                    e0.N(obj);
                    n.c cVar4 = this.f11016h.f11025f;
                    Float f13 = new Float(0.0f);
                    f1 f1Var4 = new f1(150, n.u.f6737b);
                    this.f11015g = 1;
                    if (n.c.b(cVar4, f13, f1Var4, this) == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                return c7.r.f1986a;
        }
    }
}
