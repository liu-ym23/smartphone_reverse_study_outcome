package p1;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f8266a;

    /* renamed from: b, reason: collision with root package name */
    public final c7.c f8267b;

    public a(String str, c7.c cVar) {
        this.f8266a = str;
        this.f8267b = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return q7.k.a(this.f8266a, aVar.f8266a) && q7.k.a(this.f8267b, aVar.f8267b);
    }

    public final int hashCode() {
        String str = this.f8266a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        c7.c cVar = this.f8267b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public final String toString() {
        return "AccessibilityAction(label=" + this.f8266a + ", action=" + this.f8267b + ')';
    }
}
