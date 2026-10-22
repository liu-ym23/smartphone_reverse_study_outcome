package o8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends i {

    /* renamed from: a, reason: collision with root package name */
    public List f9312a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.f9312a.equals(((f) obj).f9312a);
    }

    public final int hashCode() {
        return this.f9312a.hashCode();
    }

    public final String toString() {
        return "AccessibilityBlocked(appLabels=" + this.f9312a + ")";
    }
}
