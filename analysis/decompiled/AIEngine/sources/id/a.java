package id;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f9591a;

    /* renamed from: b, reason: collision with root package name */
    public long f9592b;

    /* renamed from: c, reason: collision with root package name */
    public long f9593c;

    public a(int i10) {
        this.f9591a = i10;
    }

    public static void b(a aVar, long j10, long j11, int i10) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        if ((i10 & 2) != 0) {
            j11 = 0;
        }
        synchronized (aVar) {
            try {
                if (j10 < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                if (j11 < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                long j12 = aVar.f9592b + j10;
                aVar.f9592b = j12;
                long j13 = aVar.f9593c + j11;
                aVar.f9593c = j13;
                if (j13 > j12) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized long a() {
        return this.f9592b - this.f9593c;
    }

    public final String toString() {
        return "WindowCounter(streamId=" + this.f9591a + ", total=" + this.f9592b + ", acknowledged=" + this.f9593c + ", unacknowledged=" + a() + ')';
    }
}
