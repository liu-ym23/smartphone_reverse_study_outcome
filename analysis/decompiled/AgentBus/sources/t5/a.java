package t5;

import i5.l;

/* loaded from: classes.dex */
public final class a extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public l f9748f;

    /* renamed from: g, reason: collision with root package name */
    public long f9749g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9750h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ l f9751i;

    /* renamed from: j, reason: collision with root package name */
    public int f9752j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(l lVar, i7.c cVar) {
        super(cVar);
        this.f9751i = lVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9750h = obj;
        this.f9752j |= Integer.MIN_VALUE;
        return this.f9751i.s(null, null, this);
    }
}
