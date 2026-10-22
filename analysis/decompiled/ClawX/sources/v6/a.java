package v6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f5992a;

    /* renamed from: b, reason: collision with root package name */
    public long f5993b;

    /* renamed from: c, reason: collision with root package name */
    public long f5994c;

    public a(int i8) {
        this.f5992a = i8;
    }

    public static void b(a aVar, long j4, long j8, int i8) {
        if ((i8 & 1) != 0) {
            j4 = 0;
        }
        if ((i8 & 2) != 0) {
            j8 = 0;
        }
        synchronized (aVar) {
            try {
                if (j4 < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                if (j8 < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                long j9 = aVar.f5993b + j4;
                aVar.f5993b = j9;
                long j10 = aVar.f5994c + j8;
                aVar.f5994c = j10;
                if (j10 > j9) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized long a() {
        return this.f5993b - this.f5994c;
    }

    public final String toString() {
        return "WindowCounter(streamId=" + this.f5992a + ", total=" + this.f5993b + ", acknowledged=" + this.f5994c + ", unacknowledged=" + a() + ')';
    }
}
