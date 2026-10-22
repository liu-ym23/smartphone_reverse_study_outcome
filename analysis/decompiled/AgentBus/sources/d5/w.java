package d5;

import ia.w1;

/* loaded from: classes.dex */
public final class w extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public z f2913f;

    /* renamed from: g, reason: collision with root package name */
    public w1 f2914g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f2915h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ z f2916i;

    /* renamed from: j, reason: collision with root package name */
    public int f2917j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(z zVar, i7.c cVar) {
        super(cVar);
        this.f2916i = zVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f2915h = obj;
        this.f2917j |= Integer.MIN_VALUE;
        return this.f2916i.k(null, this);
    }
}
