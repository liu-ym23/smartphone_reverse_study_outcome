package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public long f16017a;

    /* renamed from: b, reason: collision with root package name */
    public long f16018b;

    /* renamed from: c, reason: collision with root package name */
    public long f16019c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f16017a == xVar.f16017a && this.f16018b == xVar.f16018b && this.f16019c == xVar.f16019c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f16019c) + k0.a.i(this.f16018b, Long.hashCode(this.f16017a) * 31, 31);
    }

    public final String toString() {
        return "LedgerScopeMeta(version=" + this.f16017a + ", checkedAtMs=" + this.f16018b + ", updatedAtMs=" + this.f16019c + ")";
    }
}
