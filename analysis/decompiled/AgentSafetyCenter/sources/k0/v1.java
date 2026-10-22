package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v1 {

    /* renamed from: a, reason: collision with root package name */
    public y f7088a;

    /* renamed from: b, reason: collision with root package name */
    public int f7089b;

    /* renamed from: c, reason: collision with root package name */
    public b f7090c;

    /* renamed from: d, reason: collision with root package name */
    public xb.p f7091d;

    /* renamed from: e, reason: collision with root package name */
    public int f7092e;

    /* renamed from: f, reason: collision with root package name */
    public p.z f7093f;

    /* renamed from: g, reason: collision with root package name */
    public p.f0 f7094g;

    public v1(y yVar) {
        this.f7088a = yVar;
    }

    public final boolean a() {
        if (this.f7088a != null) {
            b bVar = this.f7090c;
            if (bVar != null ? bVar.a() : false) {
                return true;
            }
        }
        return false;
    }

    public final t0 b(Object obj) {
        t0 t0VarR;
        y yVar = this.f7088a;
        return (yVar == null || (t0VarR = yVar.r(this, obj)) == null) ? t0.f7068c : t0VarR;
    }

    public final void c() {
        y yVar = this.f7088a;
        if (yVar != null) {
            yVar.f7129s = true;
            yVar.f7132v.x();
        }
        this.f7088a = null;
        this.f7093f = null;
        this.f7094g = null;
        this.f7091d = null;
    }

    public final void d(boolean z10) {
        int i = this.f7089b;
        this.f7089b = z10 ? i | 32 : i & (-33);
    }
}
