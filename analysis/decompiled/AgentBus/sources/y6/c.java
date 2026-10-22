package y6;

import ab.v;

/* loaded from: classes.dex */
public final class c extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public d f11682f;

    /* renamed from: g, reason: collision with root package name */
    public v f11683g;

    /* renamed from: h, reason: collision with root package name */
    public String f11684h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f11685i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d f11686j;

    /* renamed from: k, reason: collision with root package name */
    public int f11687k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, i7.c cVar) {
        super(cVar);
        this.f11686j = dVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f11685i = obj;
        this.f11687k |= Integer.MIN_VALUE;
        return this.f11686j.a(null, this);
    }
}
