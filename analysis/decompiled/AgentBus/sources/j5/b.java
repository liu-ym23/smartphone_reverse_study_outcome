package j5;

import q7.k;

/* loaded from: classes.dex */
public final class b extends s7.a {

    /* renamed from: b, reason: collision with root package name */
    public final String f5398b;

    public b(String str) {
        k.e(str, "reason");
        this.f5398b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && k.a(this.f5398b, ((b) obj).f5398b);
    }

    public final int hashCode() {
        return this.f5398b.hashCode();
    }

    public final String toString() {
        return a1.a.j("Deny(reason=", this.f5398b, ")");
    }
}
