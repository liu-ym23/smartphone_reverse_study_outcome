package o4;

/* loaded from: classes.dex */
public final class m extends p {

    /* renamed from: a, reason: collision with root package name */
    public final String f7448a;

    public m(String str) {
        this.f7448a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && q7.k.a(this.f7448a, ((m) obj).f7448a);
    }

    public final int hashCode() {
        return this.f7448a.hashCode();
    }

    public final String toString() {
        return a1.a.j("ReplyReady(text=", this.f7448a, ")");
    }
}
