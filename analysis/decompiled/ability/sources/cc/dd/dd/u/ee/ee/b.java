package cc.dd.dd.u.ee.ee;

/* loaded from: classes2.dex */
public enum b {
    /* JADX INFO: Fake field, exist only in values array */
    B(0),
    KB(1),
    MB(2),
    /* JADX INFO: Fake field, exist only in values array */
    GB(3),
    /* JADX INFO: Fake field, exist only in values array */
    TB(4),
    /* JADX INFO: Fake field, exist only in values array */
    PB(5);


    /* renamed from: a, reason: collision with root package name */
    public final int f2135a;
    public long b = -1;

    b(int i) {
        this.f2135a = i;
    }

    public final long a() {
        long j5 = this.b;
        if (j5 > 0) {
            return j5;
        }
        long j6 = 1;
        for (int i = 0; i < this.f2135a; i++) {
            j6 *= 1024;
        }
        this.b = j6;
        return j6;
    }
}
