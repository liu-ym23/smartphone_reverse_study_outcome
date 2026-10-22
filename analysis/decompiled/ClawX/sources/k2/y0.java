package k2;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public enum y0 implements com.google.crypto.tink.shaded.protobuf.y {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f3576a;

    y0(int i8) {
        this.f3576a = i8;
    }

    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f3576a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
