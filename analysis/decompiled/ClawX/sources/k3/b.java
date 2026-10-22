package k3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f3581a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3582b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3583c;
    public final a d;

    public b(int i8, long j4, long j8, a aVar) {
        this.f3581a = i8;
        this.f3582b = j4;
        this.f3583c = j8;
        this.d = aVar;
    }

    public static b a(b bVar, a aVar) {
        int i8 = bVar.f3581a;
        long j4 = bVar.f3582b;
        long j8 = bVar.f3583c;
        bVar.getClass();
        return new b(i8, j4, j8, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3581a == bVar.f3581a && this.f3582b == bVar.f3582b && this.f3583c == bVar.f3583c && this.d == bVar.d;
    }

    public final int hashCode() {
        return this.d.hashCode() + a8.b.e(a8.b.e(Integer.hashCode(this.f3581a) * 31, 31, this.f3582b), 31, this.f3583c);
    }

    public final String toString() {
        return "CpuCore(coreId=" + this.f3581a + ", maxFrequency=" + this.f3582b + ", minFrequency=" + this.f3583c + ", tier=" + this.d + ")";
    }
}
