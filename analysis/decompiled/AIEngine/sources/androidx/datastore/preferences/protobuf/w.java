package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public volatile i0 f1896a;

    /* renamed from: b, reason: collision with root package name */
    public volatile ByteString f1897b;

    static {
        m.a();
    }

    public final i0 a(i0 i0Var) {
        if (this.f1896a == null) {
            synchronized (this) {
                if (this.f1896a == null) {
                    try {
                        this.f1896a = i0Var;
                        this.f1897b = ByteString.f1717b;
                    } catch (InvalidProtocolBufferException unused) {
                        this.f1896a = i0Var;
                        this.f1897b = ByteString.f1717b;
                    }
                }
            }
        }
        return this.f1896a;
    }
}
