package Ca;

/* loaded from: classes4.dex */
public final class j extends G {

    /* renamed from: a, reason: collision with root package name */
    public final String f353a;
    public final String b;

    public j(String sessionId, String str) {
        kotlin.jvm.internal.k.f(sessionId, "sessionId");
        this.f353a = sessionId;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return kotlin.jvm.internal.k.b(this.f353a, jVar.f353a) && kotlin.jvm.internal.k.b(this.b, jVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f353a.hashCode() * 31);
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.m("ScreenshotAfter(sessionId=", this.f353a, ", stepId=", this.b, ")");
    }
}
