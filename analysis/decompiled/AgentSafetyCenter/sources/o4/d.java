package o4;

import java.io.Serializable;
import yb.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public Object f9159c;

    /* renamed from: f, reason: collision with root package name */
    public Serializable f9160f;

    /* renamed from: g, reason: collision with root package name */
    public i f9161g;

    /* renamed from: h, reason: collision with root package name */
    public u f9162h;
    public nb.g i;

    /* renamed from: j, reason: collision with root package name */
    public u f9163j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9164k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f9165l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e f9166m;

    /* renamed from: n, reason: collision with root package name */
    public int f9167n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, pb.c cVar) {
        super(cVar);
        this.f9166m = eVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f9165l = obj;
        this.f9167n |= Integer.MIN_VALUE;
        return this.f9166m.m(false, null, this);
    }
}
