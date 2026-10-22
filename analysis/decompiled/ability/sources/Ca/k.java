package Ca;

/* loaded from: classes4.dex */
public final class k extends G {

    /* renamed from: a, reason: collision with root package name */
    public final String f354a;
    public final String b;

    public k(String sessionId, String str) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        this.f354a = sessionId;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kotlin.jvm.internal.k.b(this.f354a, kVar.f354a) && kotlin.jvm.internal.k.b(this.b, kVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f354a.hashCode() * 31);
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.m("ScreenshotBefore(sessionId=", this.f354a, ", stepId=", this.b, ")");
    }
}
