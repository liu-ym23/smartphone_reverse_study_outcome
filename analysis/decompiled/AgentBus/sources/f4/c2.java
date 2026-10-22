package f4;

/* loaded from: classes.dex */
public enum c2 implements com.google.crypto.tink.shaded.protobuf.x {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);


    /* renamed from: f, reason: collision with root package name */
    public final int f3418f;

    c2(int i2) {
        this.f3418f = i2;
    }

    public static c2 a(int i2) {
        if (i2 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i2 == 1) {
            return TINK;
        }
        if (i2 == 2) {
            return LEGACY;
        }
        if (i2 == 3) {
            return RAW;
        }
        if (i2 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    public final int b() {
        if (this != UNRECOGNIZED) {
            return this.f3418f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
