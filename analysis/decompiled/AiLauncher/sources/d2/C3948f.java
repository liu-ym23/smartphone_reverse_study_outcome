package d2;

/* renamed from: d2.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3948f extends AbstractC3952j {

    /* renamed from: a, reason: collision with root package name */
    public final long f32105a;

    public C3948f(long j10) {
        this.f32105a = j10;
    }

    @Override // d2.AbstractC3952j
    public long c() {
        return this.f32105a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AbstractC3952j) && this.f32105a == ((AbstractC3952j) obj).c();
    }

    public int hashCode() {
        long j10 = this.f32105a;
        return ((int) (j10 ^ (j10 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f32105a + "}";
    }
}
