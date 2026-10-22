package v3;

import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f14735c;

    /* renamed from: f, reason: collision with root package name */
    public Object f14736f;

    /* renamed from: g, reason: collision with root package name */
    public Serializable f14737g;

    /* renamed from: h, reason: collision with root package name */
    public yb.u f14738h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public int f14739j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f14740k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ z f14741l;

    /* renamed from: m, reason: collision with root package name */
    public int f14742m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(z zVar, pb.c cVar) {
        super(cVar);
        this.f14741l = zVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f14740k = obj;
        this.f14742m |= Integer.MIN_VALUE;
        return z.f(this.f14741l, false, this);
    }
}
