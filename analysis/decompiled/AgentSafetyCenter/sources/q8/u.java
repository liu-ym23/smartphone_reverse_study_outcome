package q8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u {
    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof u);
    }

    public final int hashCode() {
        return Long.hashCode(30L) + k0.a.i(104857600L, Long.hashCode(730L) * 31, 31);
    }

    public final String toString() {
        return "DashboardRetentionPolicy(maxRetentionDays=730, maxStorageBytes=104857600, minKeepRecentDays=30)";
    }
}
