package ja;

import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f9747p = b1.a("; filename=");

    /* renamed from: n, reason: collision with root package name */
    public final byte[] f9748n;

    /* renamed from: o, reason: collision with root package name */
    public final String f9749o;

    public a(String str, byte[] bArr) {
        this.f9758b = "data";
        this.f9759c = "application/octet-stream";
        this.f9760d = "ISO-8859-1";
        this.f9761e = "binary";
        if (bArr == null) {
            throw new IllegalArgumentException("Source may not be null");
        }
        this.f9749o = str;
        this.f9748n = bArr;
    }
}
