package u2;

import ob.z;

/* loaded from: classes.dex */
public final class h extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public i f9983f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9984g;

    /* renamed from: h, reason: collision with root package name */
    public z f9985h;

    /* renamed from: i, reason: collision with root package name */
    public Object f9986i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f9987j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i f9988k;

    /* renamed from: l, reason: collision with root package name */
    public int f9989l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, i7.c cVar) {
        super(cVar);
        this.f9988k = iVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9987j = obj;
        this.f9989l |= Integer.MIN_VALUE;
        return this.f9988k.b(null, this);
    }
}
