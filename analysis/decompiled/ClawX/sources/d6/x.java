package d6;

import a6.h1;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public y f1914a;

    /* renamed from: b, reason: collision with root package name */
    public c f1915b;

    /* renamed from: c, reason: collision with root package name */
    public a0 f1916c;
    public h1 d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1917e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f1918f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ y f1919g;

    /* renamed from: h, reason: collision with root package name */
    public int f1920h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(y yVar, f5.c cVar) {
        super(cVar);
        this.f1919g = yVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f1918f = obj;
        this.f1920h |= Integer.MIN_VALUE;
        this.f1919g.collect(null, this);
        return g5.a.f2984a;
    }
}
