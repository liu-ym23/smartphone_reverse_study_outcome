package h5;

import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f4178a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4179b;

    public a(String str, long j2) {
        this.f4178a = str;
        this.f4179b = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f4178a, aVar.f4178a) && this.f4179b == aVar.f4179b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4179b) + (this.f4178a.hashCode() * 31);
    }

    public final String toString() {
        return "Entry(respondedBy=" + this.f4178a + ", timestamp=" + this.f4179b + ")";
    }
}
