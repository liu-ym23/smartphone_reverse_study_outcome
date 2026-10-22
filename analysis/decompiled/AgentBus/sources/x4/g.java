package x4;

import c7.r;
import ia.b0;
import ia.d0;
import p7.n;
import w7.e0;

/* loaded from: classes.dex */
public final class g extends i7.i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11171f;

    /* renamed from: g, reason: collision with root package name */
    public int f11172g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f11173h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i f11174i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(long j2, i iVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f11171f = i2;
        this.f11173h = j2;
        this.f11174i = iVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f11171f) {
            case 0:
                return new g(this.f11173h, this.f11174i, dVar, 0);
            default:
                return new g(this.f11173h, this.f11174i, dVar, 1);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f11171f) {
        }
        return ((g) create(b0Var, dVar)).invokeSuspend(r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f11171f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f11172g;
                long j2 = this.f11173h;
                if (i2 == 0) {
                    e0.N(obj);
                    this.f11172g = 1;
                    if (d0.g(j2, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                i.a(this.f11174i, "idle disconnect after " + j2 + "ms");
                return r.f1986a;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f11172g;
                long j4 = this.f11173h;
                if (i10 == 0) {
                    e0.N(obj);
                    this.f11172g = 1;
                    if (d0.g(j4, this) == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                i.a(this.f11174i, "screen-off idle disconnect after " + j4 + "ms");
                return r.f1986a;
        }
    }
}
