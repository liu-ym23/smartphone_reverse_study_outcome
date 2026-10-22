package v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface u1 {
    long a();

    long b();

    default long c() {
        float f5 = 48;
        return (Float.floatToRawIntBits(f5) << 32) | (Float.floatToRawIntBits(f5) & 4294967295L);
    }

    default float d() {
        return Float.MAX_VALUE;
    }

    float e();
}
