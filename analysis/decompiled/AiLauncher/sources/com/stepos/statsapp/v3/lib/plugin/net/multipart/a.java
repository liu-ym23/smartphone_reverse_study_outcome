package com.stepos.statsapp.v3.lib.plugin.net.multipart;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class a extends h {

    /* renamed from: A, reason: collision with root package name */
    public static final String f30823A = "binary";

    /* renamed from: B, reason: collision with root package name */
    protected static final String f30824B = "; filename=";

    /* renamed from: C, reason: collision with root package name */
    private static final byte[] f30825C = b.a(f30824B);

    /* renamed from: y, reason: collision with root package name */
    public static final String f30826y = "application/octet-stream";

    /* renamed from: z, reason: collision with root package name */
    public static final String f30827z = "ISO-8859-1";

    /* renamed from: w, reason: collision with root package name */
    private byte[] f30828w;

    /* renamed from: x, reason: collision with root package name */
    private String f30829x;

    public a(String str, String str2, byte[] bArr, String str3, String str4) {
        super(str, str3 == null ? "application/octet-stream" : str3, str4 == null ? "ISO-8859-1" : str4, "binary");
        if (bArr == null) {
            throw new IllegalArgumentException("Source may not be null");
        }
        this.f30829x = str2;
        this.f30828w = bArr;
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public void c(OutputStream outputStream) throws IOException {
        if (i() == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f30828w);
        while (true) {
            try {
                int i10 = byteArrayInputStream.read(bArr);
                if (i10 < 0) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i10);
                }
            } finally {
                byteArrayInputStream.close();
            }
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public void d(OutputStream outputStream) throws IOException {
        super.d(outputStream);
        if (this.f30829x != null) {
            outputStream.write(f30825C);
            byte[] bArr = g.f30874h;
            outputStream.write(bArr);
            outputStream.write(b.a(this.f30829x));
            outputStream.write(bArr);
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public long i() {
        return this.f30828w.length;
    }

    public a(String str, String str2, byte[] bArr) {
        this(str, str2, bArr, null, null);
    }

    public a(String str, byte[] bArr) {
        this(str, str, bArr, null, null);
    }
}
