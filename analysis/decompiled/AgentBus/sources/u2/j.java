package u2;

import ob.c0;
import ob.u;

/* loaded from: classes.dex */
public final class j extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public u f9996f;

    /* renamed from: g, reason: collision with root package name */
    public u f9997g;

    /* renamed from: h, reason: collision with root package name */
    public c0 f9998h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f9999i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k f10000j;

    /* renamed from: k, reason: collision with root package name */
    public int f10001k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, i7.c cVar) {
        super(cVar);
        this.f10000j = kVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f9999i = obj;
        this.f10001k |= Integer.MIN_VALUE;
        return this.f10000j.b(null, this);
    }
}
