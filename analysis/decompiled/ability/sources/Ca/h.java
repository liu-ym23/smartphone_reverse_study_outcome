package Ca;

/* loaded from: classes4.dex */
public final class h extends G {

    /* renamed from: a, reason: collision with root package name */
    public final String f351a;
    public final String b;

    public h(String str, String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        this.f351a = str;
        this.b = reason;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return kotlin.jvm.internal.k.b(this.f351a, hVar.f351a) && kotlin.jvm.internal.k.b(this.b, hVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f351a.hashCode() * 31);
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.m("AccessibilityActionAfter(sessionId=", this.f351a, ", reason=", this.b, ")");
    }
}
