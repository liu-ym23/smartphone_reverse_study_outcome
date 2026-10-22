package o4;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f9208c;

    /* renamed from: f, reason: collision with root package name */
    public Serializable f9209f;

    /* renamed from: g, reason: collision with root package name */
    public int f9210g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f9211h;
    public final /* synthetic */ q i;

    /* renamed from: j, reason: collision with root package name */
    public int f9212j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, pb.c cVar) {
        super(cVar);
        this.i = qVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f9211h = obj;
        this.f9212j |= Integer.MIN_VALUE;
        return this.i.g(null, null, this);
    }
}
