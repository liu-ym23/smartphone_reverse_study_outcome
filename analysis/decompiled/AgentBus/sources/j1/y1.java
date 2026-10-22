package j1;

/* loaded from: classes.dex */
public interface y1 {
    default float a() {
        return Float.MAX_VALUE;
    }

    float b();

    default long c() {
        float f10 = 48;
        return (Float.floatToRawIntBits(f10) << 32) | (Float.floatToRawIntBits(f10) & 4294967295L);
    }
}
