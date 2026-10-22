package m8;

import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashMap f8343a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashMap f8344b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f8345c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f8343a.equals(fVar.f8343a) && this.f8344b.equals(fVar.f8344b) && this.f8345c.equals(fVar.f8345c);
    }

    public final int hashCode() {
        return this.f8345c.hashCode() + ((this.f8344b.hashCode() + (this.f8343a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "ChartBarDayCounts(ops=" + this.f8343a + ", risks=" + this.f8344b + ", undoable=" + this.f8345c + ")";
    }
}
