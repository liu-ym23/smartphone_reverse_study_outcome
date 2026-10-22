package A3;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f1123a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1124b;

    public int a() {
        return this.f1124b;
    }

    public int b() {
        return this.f1123a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f1123a == aVar.f1123a && this.f1124b == aVar.f1124b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f1123a * 32713) + this.f1124b;
    }

    public String toString() {
        return this.f1123a + "x" + this.f1124b;
    }
}
