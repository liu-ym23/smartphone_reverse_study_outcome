package c6;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f1901d = new a(1000, "normal", null);

    /* renamed from: a, reason: collision with root package name */
    public final int f1902a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1903b;

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f1904c;

    public a(int i2, String str, Throwable th) {
        this.f1902a = i2;
        this.f1903b = str;
        this.f1904c = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f1902a == aVar.f1902a && q7.k.a(this.f1903b, aVar.f1903b) && q7.k.a(this.f1904c, aVar.f1904c);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f1902a) * 31;
        String str = this.f1903b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Throwable th = this.f1904c;
        return iHashCode2 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CloseReason(code=" + this.f1902a + ", message=" + this.f1903b + ", cause=" + this.f1904c + ")";
    }
}
