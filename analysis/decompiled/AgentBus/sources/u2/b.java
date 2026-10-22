package u2;

import ob.e0;

/* loaded from: classes.dex */
public final class b extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public c f9960f;

    /* renamed from: g, reason: collision with root package name */
    public e0 f9961g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9962h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c f9963i;

    /* renamed from: j, reason: collision with root package name */
    public int f9964j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, i7.c cVar2) {
        super(cVar2);
        this.f9963i = cVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9962h = obj;
        this.f9964j |= Integer.MIN_VALUE;
        return c.a(this.f9963i, this);
    }
}
