package f4;

/* loaded from: classes.dex */
public enum k1 implements com.google.crypto.tink.shaded.protobuf.x {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* renamed from: f, reason: collision with root package name */
    public final int f3433f;

    k1(int i2) {
        this.f3433f = i2;
    }

    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f3433f;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
