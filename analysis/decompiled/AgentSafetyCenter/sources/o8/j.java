package o8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public String f9315a;

    /* renamed from: b, reason: collision with root package name */
    public String f9316b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9317c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f9315a.equals(jVar.f9315a) && this.f9316b.equals(jVar.f9316b) && this.f9317c == jVar.f9317c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f9317c) + androidx.activity.b.d(this.f9315a.hashCode() * 31, 31, this.f9316b);
    }

    public final String toString() {
        String str = this.f9315a;
        String str2 = this.f9316b;
        boolean z10 = this.f9317c;
        StringBuilder sbP = androidx.activity.b.p("EnabledAccessibilityApp(packageName=", str, ", label=", str2, ", isSystemApp=");
        sbP.append(z10);
        sbP.append(")");
        return sbP.toString();
    }
}
