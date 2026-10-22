package ka;

import ia.k0;

/* loaded from: classes.dex */
public final class e extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5671f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f5672g;

    /* renamed from: h, reason: collision with root package name */
    public int f5673h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, i7.c cVar) {
        super(cVar);
        this.f5672g = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws k0 {
        this.f5671f = obj;
        this.f5673h |= Integer.MIN_VALUE;
        Object objD = g.D(this.f5672g, this);
        return objD == h7.a.f4212f ? objD : new n(objD);
    }
}
