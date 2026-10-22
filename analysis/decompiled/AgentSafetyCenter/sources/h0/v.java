package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final long f5201a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5202b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5203c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5204d;

    public v(long j10, long j11, long j12, long j13) {
        this.f5201a = j10;
        this.f5202b = j11;
        this.f5203c = j12;
        this.f5204d = j13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return d1.p.d(this.f5201a, vVar.f5201a) && d1.p.d(this.f5202b, vVar.f5202b) && d1.p.d(this.f5203c, vVar.f5203c) && d1.p.d(this.f5204d, vVar.f5204d);
    }

    public final int hashCode() {
        int i = d1.p.f3025h;
        return Long.hashCode(this.f5204d) + k0.a.i(this.f5203c, k0.a.i(this.f5202b, Long.hashCode(this.f5201a) * 31, 31), 31);
    }
}
