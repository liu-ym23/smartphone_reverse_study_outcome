package u8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public List f14208a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && yb.k.a(this.f14208a, ((h) obj).f14208a);
    }

    public final int hashCode() {
        return this.f14208a.hashCode();
    }

    public final String toString() {
        return "FileUndoDisplay(paths=" + this.f14208a + ")";
    }
}
