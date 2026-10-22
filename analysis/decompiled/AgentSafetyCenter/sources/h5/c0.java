package h5;

import android.os.Trace;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g5.t f5311c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f5312f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f5313g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d0 f5314h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(g5.t tVar, boolean z10, String str, d0 d0Var) {
        super(1);
        this.f5311c = tVar;
        this.f5312f = z10;
        this.f5313g = str;
        this.f5314h = d0Var;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        String str;
        Throwable th = (Throwable) obj;
        if (th instanceof u) {
            this.f5311c.f4340c.compareAndSet(-256, ((u) th).f5384c);
        }
        if (this.f5312f && (str = this.f5313g) != null) {
            d0 d0Var = this.f5314h;
            g5.j jVar = d0Var.f5329e.f4279m;
            int iHashCode = d0Var.f5325a.hashCode();
            jVar.getClass();
            Trace.endAsyncSection(com.stepos.statsrpk.h.J(str), iHashCode);
        }
        return jb.v.f6774a;
    }
}
