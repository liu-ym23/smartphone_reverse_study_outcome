package p5;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f8474a;

    public m(String str) {
        this.f8474a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && q7.k.a(this.f8474a, ((m) obj).f8474a);
    }

    public final int hashCode() {
        String str = this.f8474a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return a1.a.j("PeerWakeContext(traceId=", this.f8474a, ")");
    }
}
