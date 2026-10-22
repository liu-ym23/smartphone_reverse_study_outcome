package vd;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public enum a {
    FLOW(Boolean.TRUE),
    BLOCK(Boolean.FALSE),
    AUTO(null);


    /* renamed from: c, reason: collision with root package name */
    public final Boolean f14898c;

    a(Boolean bool) {
        this.f14898c = bool;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Flow style: '" + this.f14898c + "'";
    }
}
