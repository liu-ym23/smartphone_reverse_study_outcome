package p5;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f8469a;

    /* renamed from: b, reason: collision with root package name */
    public final e f8470b;

    /* renamed from: c, reason: collision with root package name */
    public final long f8471c;

    public i(String str, long j2) {
        e eVar = e.BROADCAST;
        q7.k.e(eVar, "launchMethod");
        this.f8469a = str;
        this.f8470b = eVar;
        this.f8471c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return q7.k.a(this.f8469a, iVar.f8469a) && this.f8470b == iVar.f8470b && this.f8471c == iVar.f8471c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f8471c) + ((this.f8470b.hashCode() + (this.f8469a.hashCode() * 31)) * 961);
    }

    public final String toString() {
        return "PeerLaunchInfo(packageName=" + this.f8469a + ", launchMethod=" + this.f8470b + ", action=null, idleTimeoutMs=" + this.f8471c + ")";
    }
}
