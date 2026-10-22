package n4;

import q7.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6849a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6850b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6851c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6852d;

    public d(String str, String str2, String str3, boolean z4) {
        this.f6849a = z4;
        this.f6850b = str;
        this.f6851c = str2;
        this.f6852d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f6849a == dVar.f6849a && k.a(this.f6850b, dVar.f6850b) && k.a(this.f6851c, dVar.f6851c) && k.a(this.f6852d, dVar.f6852d);
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f6849a) * 31;
        String str = this.f6850b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f6851c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f6852d;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "AgentTaskOutcome(ok=" + this.f6849a + ", summary=" + this.f6850b + ", errorCode=" + this.f6851c + ", errorMessage=" + this.f6852d + ")";
    }
}
