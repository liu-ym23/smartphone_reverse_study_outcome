package x;

import t.u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public r f15470c;

    /* renamed from: f, reason: collision with root package name */
    public u0 f15471f;

    /* renamed from: g, reason: collision with root package name */
    public pb.i f15472g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f15473h;
    public final /* synthetic */ r i;

    /* renamed from: j, reason: collision with root package name */
    public int f15474j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(r rVar, pb.c cVar) {
        super(cVar);
        this.i = rVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f15473h = obj;
        this.f15474j |= Integer.MIN_VALUE;
        return this.i.c(null, null, this);
    }
}
