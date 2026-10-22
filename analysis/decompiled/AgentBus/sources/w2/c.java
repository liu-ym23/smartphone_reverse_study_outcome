package w2;

import c7.r;
import i7.i;
import p7.n;
import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public final class c extends i implements n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10651f;

    /* renamed from: g, reason: collision with root package name */
    public int f10652g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f10653h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i f10654i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(n nVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f10651f = i2;
        switch (i2) {
            case 1:
                this.f10654i = (i) nVar;
                super(2, dVar);
                break;
            default:
                this.f10654i = (i) nVar;
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [i7.i, p7.n] */
    /* JADX WARN: Type inference failed for: r2v2, types: [i7.i, p7.n] */
    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f10651f) {
            case 0:
                c cVar = new c(this.f10654i, dVar, 0);
                cVar.f10653h = obj;
                return cVar;
            default:
                c cVar2 = new c(this.f10654i, dVar, 1);
                cVar2.f10653h = obj;
                return cVar2;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b bVar = (b) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f10651f) {
        }
        return ((c) create(bVar, dVar)).invokeSuspend(r.f1986a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [i7.i, p7.n] */
    /* JADX WARN: Type inference failed for: r5v10, types: [i7.i, p7.n] */
    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f10651f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                int i2 = this.f10652g;
                if (i2 == 0) {
                    e0.N(obj);
                    b bVar = (b) this.f10653h;
                    this.f10652g = 1;
                    obj = this.f10654i.invoke(bVar, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e0.N(obj);
                }
                b bVar2 = (b) obj;
                k.c(bVar2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
                bVar2.f10650b.f9959a.set(true);
                return bVar2;
            default:
                h7.a aVar2 = h7.a.f4212f;
                int i10 = this.f10652g;
                if (i10 != 0) {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b bVar3 = (b) this.f10653h;
                    e0.N(obj);
                    return bVar3;
                }
                e0.N(obj);
                b bVar4 = new b(d7.e0.b0(((b) this.f10653h).a()), false);
                this.f10653h = bVar4;
                this.f10652g = 1;
                return this.f10654i.invoke(bVar4, this) == aVar2 ? aVar2 : bVar4;
        }
    }
}
