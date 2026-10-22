package J2;

import B0.f;

/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f881p = f.b("; filename=");

    /* renamed from: n, reason: collision with root package name */
    public final byte[] f882n;

    /* renamed from: o, reason: collision with root package name */
    public final String f883o;

    public a(String str, byte[] bArr) {
        this.f893b = "data";
        this.f894c = "application/octet-stream";
        this.f895d = "ISO-8859-1";
        this.f896e = "binary";
        if (bArr == null) {
            throw new IllegalArgumentException("Source may not be null");
        }
        this.f883o = str;
        this.f882n = bArr;
    }
}
