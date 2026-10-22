package s1;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: b, reason: collision with root package name */
    public static final long f9268b = z.b(0, 0);

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f9269c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f9270a;

    public /* synthetic */ g0(long j2) {
        this.f9270a = j2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g0) {
            return this.f9270a == ((g0) obj).f9270a;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f9270a);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TextRange(");
        long j2 = this.f9270a;
        sb2.append((int) (j2 >> 32));
        sb2.append(", ");
        return m.x.m(sb2, (int) (j2 & 4294967295L), ')');
    }
}
