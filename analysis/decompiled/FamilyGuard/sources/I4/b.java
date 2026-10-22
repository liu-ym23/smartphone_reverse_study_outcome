package I4;

/* loaded from: classes.dex */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);


    /* renamed from: a, reason: collision with root package name */
    public final int f2987a;

    b(int i5) {
        this.f2987a = i5;
    }

    public static b b(int i5) {
        for (b bVar : values()) {
            if (bVar.f2987a == i5) {
                return bVar;
            }
        }
        return null;
    }
}
