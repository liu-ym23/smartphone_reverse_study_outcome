package com.stepos.statsapp.v3.lib.plugin.net.multipart;

import com.stepos.statsapp.v3.utils.CommonUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class c extends h {

    /* renamed from: A, reason: collision with root package name */
    protected static final String f30830A = "; filename=";

    /* renamed from: B, reason: collision with root package name */
    private static final byte[] f30831B = b.a(f30830A);

    /* renamed from: x, reason: collision with root package name */
    public static final String f30832x = "application/octet-stream";

    /* renamed from: y, reason: collision with root package name */
    public static final String f30833y = "ISO-8859-1";

    /* renamed from: z, reason: collision with root package name */
    public static final String f30834z = "binary";

    /* renamed from: w, reason: collision with root package name */
    private i f30835w;

    public c(String str, i iVar, String str2, String str3) {
        super(str, str2 == null ? "application/octet-stream" : str2, str3 == null ? "ISO-8859-1" : str3, "binary");
        if (iVar == null) {
            throw new IllegalArgumentException("Source may not be null");
        }
        this.f30835w = iVar;
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public void c(OutputStream outputStream) throws IOException {
        if (i() == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        InputStream inputStreamB = this.f30835w.b();
        while (true) {
            try {
                int i10 = inputStreamB.read(bArr);
                if (i10 < 0) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i10);
                }
            } finally {
                CommonUtils.closeQuietly(inputStreamB);
            }
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public void d(OutputStream outputStream) throws IOException {
        super.d(outputStream);
        String fileName = this.f30835w.getFileName();
        if (fileName != null) {
            outputStream.write(f30831B);
            byte[] bArr = g.f30874h;
            outputStream.write(bArr);
            outputStream.write(b.a(fileName));
            outputStream.write(bArr);
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.net.multipart.g
    public long i() {
        return this.f30835w.a();
    }

    public i j() {
        return this.f30835w;
    }

    public c(String str, i iVar) {
        this(str, iVar, (String) null, (String) null);
    }

    public c(String str, File file) throws FileNotFoundException {
        this(str, new d(file), (String) null, (String) null);
    }

    public c(String str, File file, String str2, String str3) throws FileNotFoundException {
        this(str, new d(file), str2, str3);
    }

    public c(String str, String str2, File file) throws FileNotFoundException {
        this(str, new d(str2, file), (String) null, (String) null);
    }

    public c(String str, String str2, File file, String str3, String str4) throws FileNotFoundException {
        this(str, new d(str2, file), str3, str4);
    }
}
