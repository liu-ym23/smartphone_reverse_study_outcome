package u8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public List f14189c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f14190f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.f f14191g;

    /* renamed from: h, reason: collision with root package name */
    public int f14192h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(stepos.support.v7.app.f fVar, pb.c cVar) {
        super(cVar);
        this.f14191g = fVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14190f = obj;
        this.f14192h |= Integer.MIN_VALUE;
        return this.f14191g.a(null, this);
    }
}
