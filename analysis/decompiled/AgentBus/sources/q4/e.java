package q4;

import i5.l;

/* loaded from: classes.dex */
public final class e extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public l f8647f;

    /* renamed from: g, reason: collision with root package name */
    public String f8648g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8649h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ l f8650i;

    /* renamed from: j, reason: collision with root package name */
    public int f8651j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(l lVar, i7.c cVar) {
        super(cVar);
        this.f8650i = lVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8649h = obj;
        this.f8651j |= Integer.MIN_VALUE;
        return this.f8650i.K(null, this);
    }
}
