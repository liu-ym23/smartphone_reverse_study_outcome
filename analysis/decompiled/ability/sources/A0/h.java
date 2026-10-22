package A0;

/* loaded from: classes2.dex */
public final class h implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f74a;
    public final long b;
    public long d = System.currentTimeMillis();
    public int c = 1;

    public h(String str, long j5) {
        this.f74a = str;
        this.b = j5;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j5 = this.b;
        long j6 = ((h) obj).b;
        if (j5 == j6) {
            return 0;
        }
        return j5 > j6 ? 1 : -1;
    }
}
