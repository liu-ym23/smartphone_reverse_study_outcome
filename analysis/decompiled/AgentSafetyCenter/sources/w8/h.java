package w8;

import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f15385a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15386b;

    public h(String str, boolean z10) {
        this.f15385a = z10;
        this.f15386b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f15385a == hVar.f15385a && k.a(this.f15386b, hVar.f15386b);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f15385a) * 31;
        String str = this.f15386b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "RevokeHiddenNotesResult(success=" + this.f15385a + ", errorMessage=" + this.f15386b + ")";
    }
}
