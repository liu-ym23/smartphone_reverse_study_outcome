package o4;

import nc.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f9176c;

    /* renamed from: f, reason: collision with root package name */
    public int f9177f;

    /* renamed from: g, reason: collision with root package name */
    public nc.h f9178g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s f9179h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(s sVar, nb.c cVar) {
        super(cVar);
        this.f9179h = sVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f9176c = obj;
        this.f9177f |= Integer.MIN_VALUE;
        return this.f9179h.emit(null, this);
    }
}
