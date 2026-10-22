package u0;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f9906a = (Float.floatToRawIntBits(0.5f) << 32) | (Float.floatToRawIntBits(0.5f) & 4294967295L);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f9907b = 0;

    public static final float a(long j2) {
        return Float.intBitsToFloat((int) (j2 >> 32));
    }

    public static final float b(long j2) {
        return Float.intBitsToFloat((int) (j2 & 4294967295L));
    }

    public static String c(long j2) {
        return "TransformOrigin(packedValue=" + j2 + ')';
    }
}
