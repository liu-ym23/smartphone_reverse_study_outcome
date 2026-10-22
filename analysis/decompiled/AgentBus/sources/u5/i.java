package u5;

import b0.g2;
import ia.b0;
import ia.d0;
import w7.e0;

/* loaded from: classes.dex */
public final class i extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f10132f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f10133g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s f10134h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c5.b f10135i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f10136j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(long j2, s sVar, c5.b bVar, String str, g7.d dVar) {
        super(2, dVar);
        this.f10133g = j2;
        this.f10134h = sVar;
        this.f10135i = bVar;
        this.f10136j = str;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new i(this.f10133g, this.f10134h, this.f10135i, this.f10136j, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((i) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f10132f;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e0.N(obj);
            return obj;
        }
        e0.N(obj);
        g2 g2Var = new g2(this.f10134h, this.f10135i, this.f10136j, null, 8);
        this.f10132f = 1;
        Object objC = d0.C(this.f10133g, g2Var, this);
        return objC == aVar ? aVar : objC;
    }
}
