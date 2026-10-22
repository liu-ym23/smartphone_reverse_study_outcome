package c6;

import q7.u;

/* loaded from: classes.dex */
public final class f extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public h f1927f;

    /* renamed from: g, reason: collision with root package name */
    public u f1928g;

    /* renamed from: h, reason: collision with root package name */
    public int f1929h;

    /* renamed from: i, reason: collision with root package name */
    public int f1930i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1931j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ h f1932k;

    /* renamed from: l, reason: collision with root package name */
    public int f1933l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, i7.c cVar) {
        super(cVar);
        this.f1932k = hVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1931j = obj;
        this.f1933l |= Integer.MIN_VALUE;
        return h.a(this.f1932k, this);
    }
}
