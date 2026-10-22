package Ca;

/* loaded from: classes4.dex */
public final class i extends G {

    /* renamed from: a, reason: collision with root package name */
    public final String f352a;
    public final String b;

    public i(String str, String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        this.f352a = str;
        this.b = reason;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.k.b(this.f352a, iVar.f352a) && kotlin.jvm.internal.k.b(this.b, iVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f352a.hashCode() * 31);
    }

    public final String toString() {
        return androidx.appfunctions.metadata.a.m("AccessibilityActionBefore(sessionId=", this.f352a, ", reason=", this.b, ")");
    }
}
