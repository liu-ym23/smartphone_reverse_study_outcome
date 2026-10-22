package zd;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c extends k {

    /* renamed from: d, reason: collision with root package name */
    public final String f16578d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f16579e;

    /* renamed from: f, reason: collision with root package name */
    public final vd.a f16580f;

    public c(String str, String str2, boolean z10, yd.a aVar, yd.a aVar2, vd.a aVar3) {
        super(str, aVar, aVar2);
        this.f16578d = str2;
        this.f16579e = z10;
        if (aVar3 != null) {
            this.f16580f = aVar3;
        } else {
            g5.f.g("Flow style must be provided.");
            throw null;
        }
    }

    @Override // zd.k, zd.g
    public final String a() {
        return super.a() + ", tag=" + this.f16578d + ", implicit=" + this.f16579e;
    }
}
