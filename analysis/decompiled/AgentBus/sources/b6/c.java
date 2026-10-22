package b6;

import i5.l;

/* loaded from: classes.dex */
public final class c extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public l f1539f;

    /* renamed from: g, reason: collision with root package name */
    public c5.b f1540g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f1541h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ l f1542i;

    /* renamed from: j, reason: collision with root package name */
    public int f1543j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(l lVar, i7.c cVar) {
        super(cVar);
        this.f1542i = lVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1541h = obj;
        this.f1543j |= Integer.MIN_VALUE;
        return this.f1542i.C(null, this);
    }
}
