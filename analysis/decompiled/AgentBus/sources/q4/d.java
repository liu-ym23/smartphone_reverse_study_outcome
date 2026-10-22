package q4;

import o4.k0;

/* loaded from: classes.dex */
public final class d extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public h4.e f8642f;

    /* renamed from: g, reason: collision with root package name */
    public k0 f8643g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8644h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ h4.e f8645i;

    /* renamed from: j, reason: collision with root package name */
    public int f8646j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h4.e eVar, g7.d dVar) {
        super(dVar);
        this.f8645i = eVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8644h = obj;
        this.f8646j |= Integer.MIN_VALUE;
        return this.f8645i.a(null, this);
    }
}
