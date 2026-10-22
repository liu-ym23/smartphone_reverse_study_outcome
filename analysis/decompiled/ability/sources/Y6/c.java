package Y6;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public long f1567a;
    public long b;

    public final String toString() {
        long j5 = this.f1567a;
        if (j5 < 0 && this.b < 0) {
            return "bytes=0-";
        }
        if (j5 > 0) {
            long j6 = this.b;
            if (j6 > 0 && j5 > j6) {
                return "bytes=0-";
            }
        }
        if (j5 < 0) {
            return "bytes=0-" + this.b;
        }
        if (this.b < 0) {
            return androidx.constraintlayout.core.dsl.a.e(this.f1567a, "-", new StringBuilder("bytes="));
        }
        return "bytes=" + this.f1567a + "-" + this.b;
    }
}
