package ka;

import ia.k0;

/* loaded from: classes.dex */
public final class f extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5674f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g f5675g;

    /* renamed from: h, reason: collision with root package name */
    public int f5676h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, i7.c cVar) {
        super(cVar);
        this.f5675g = gVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws k0 {
        this.f5674f = obj;
        this.f5676h |= Integer.MIN_VALUE;
        Object objE = this.f5675g.E(null, 0, 0L, this);
        return objE == h7.a.f4212f ? objE : new n(objE);
    }
}
