package hb;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f20396a = Float.MAX_VALUE;

    static {
    }

    public static final c a(float r10, float r11) {
        long r12 = Float.floatToRawIntBits(r10);
        return new c((((long) Float.floatToRawIntBits(r11)) & 4294967295L) | (r12 << 32));
    }

    public static final float b() {
        return f20396a;
    }
}
