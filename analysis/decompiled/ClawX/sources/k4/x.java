package k4;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x {
    public static final x d = new x("HTTP", 1, 1);

    /* renamed from: a, reason: collision with root package name */
    public final String f3641a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3642b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3643c;

    public x(String str, int i8, int i9) {
        this.f3641a = str;
        this.f3642b = i8;
        this.f3643c = i9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f3641a.equals(xVar.f3641a) && this.f3642b == xVar.f3642b && this.f3643c == xVar.f3643c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f3643c) + a8.b.C(this.f3642b, this.f3641a.hashCode() * 31, 31);
    }

    public final String toString() {
        return this.f3641a + '/' + this.f3642b + '.' + this.f3643c;
    }
}
