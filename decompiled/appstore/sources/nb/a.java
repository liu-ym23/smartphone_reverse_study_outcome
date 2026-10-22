package nb;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22436a;

    public a(long r10) {
        this.f22436a = r10;
    }

    public String toString() {
        return '(' + Float.intBitsToFloat((int) (this.f22436a >> 32)) + ", " + Float.intBitsToFloat((int) (this.f22436a & 4294967295L)) + ')';
    }

    public a(float r10, float r11) {
        long r12 = Float.floatToRawIntBits(r10);
        this((((long) Float.floatToRawIntBits(r11)) & 4294967295L) | (r12 << 32));
    }
}
