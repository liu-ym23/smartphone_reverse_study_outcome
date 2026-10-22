package d0;

import d1.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long f2950a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2951b;

    public c(long j10, long j11) {
        this.f2950a = j10;
        this.f2951b = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return p.d(this.f2950a, cVar.f2950a) && p.d(this.f2951b, cVar.f2951b);
    }

    public final int hashCode() {
        int i = p.f3025h;
        return Long.hashCode(this.f2951b) + (Long.hashCode(this.f2950a) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SelectionColors(selectionHandleColor=");
        k0.a.z(this.f2950a, sb2, ", selectionBackgroundColor=");
        sb2.append((Object) p.j(this.f2951b));
        sb2.append(')');
        return sb2.toString();
    }
}
