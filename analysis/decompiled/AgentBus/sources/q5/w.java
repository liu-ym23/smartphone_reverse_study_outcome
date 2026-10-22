package q5;

/* loaded from: classes.dex */
public final class w extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f8778a;

    public w(String str) {
        this.f8778a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && q7.k.a(this.f8778a, ((w) obj).f8778a);
    }

    public final int hashCode() {
        return this.f8778a.hashCode();
    }

    public final String toString() {
        return a1.a.j("EnqueueOffline(queueTag=", this.f8778a, ")");
    }
}
