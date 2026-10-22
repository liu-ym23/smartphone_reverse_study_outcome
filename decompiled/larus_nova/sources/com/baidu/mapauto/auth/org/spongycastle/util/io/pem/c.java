package com.baidu.mapauto.auth.org.spongycastle.util.io.pem;

import com.baidu.mapauto.auth.org.spongycastle.util.d;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class c extends BufferedWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f31926a;

    public c(StringWriter r100) {
        super(r100);
        this.f31926a = new char[64];
        int r101 = d.f31915a;
    }

    public final void a(b r110) throws IOException {
        write("-----BEGIN RSA PUBLIC KEY-----");
        newLine();
        if (r110.f31924a.isEmpty() == true) goto L9;
        Iterator r100 = r110.f31924a.iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((a) r100.next()).getClass();
        write(null);
        write(": ");
        write(null);
        newLine();
        goto L6
    L8:
        newLine();
    L9:
        byte[] r111 = r110.f31925b;
        com.baidu.mapauto.auth.org.spongycastle.util.encoders.b r101 = com.baidu.mapauto.auth.org.spongycastle.util.encoders.a.f31916a;
        int r102 = r111.length;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(((r102 + 2) / 3) * 4);
        r101.getClass();     // Catch: Exception -> L36
        int r104 = r102 % 3;     // Catch: Exception -> L36
        int r105 = r102 - r104;     // Catch: Exception -> L36
        int r106 = 0;
    L11:
        int r107 = 0 + r105;     // Catch: Exception -> L36
        if (r106 >= r107) goto L15;
        int r108 = r111[r106] & UByte.MAX_VALUE;     // Catch: Exception -> L36
        int r109 = r111[r106 + 1] & UByte.MAX_VALUE;     // Catch: Exception -> L36
        int r112 = r111[r106 + 2] & UByte.MAX_VALUE;     // Catch: Exception -> L36
        r103.write(r101.f31917a[(r108 >>> 2) & 63]);     // Catch: Exception -> L36
        r103.write(r101.f31917a[((r108 << 4) | (r109 >>> 4)) & 63]);     // Catch: Exception -> L36
        r103.write(r101.f31917a[((r109 << 2) | (r112 >>> 6)) & 63]);     // Catch: Exception -> L36
        r103.write(r101.f31917a[r112 & 63]);     // Catch: Exception -> L36
        r106 = r106 + 3;     // Catch: Exception -> L36
        goto L11
    L15:
        if (r104 != 1) goto L17;
        int r113 = r111[r107] & UByte.MAX_VALUE;     // Catch: Exception -> L36
        int r114 = (r113 >>> 2) & 63;     // Catch: Exception -> L36
        r103.write(r101.f31917a[r114]);     // Catch: Exception -> L36
        byte[] r115 = r101.f31917a;     // Catch: Exception -> L36
        r103.write(r115[(r113 << 4) & 63]);     // Catch: Exception -> L36
        r103.write(61);     // Catch: Exception -> L36
    L21:
        r103.write(61);     // Catch: Exception -> L36
    L22:
        int r116 = r105 / 3;     // Catch: Exception -> L36
        byte[] r117 = r103.toByteArray();
        int r118 = 0;
    L25:
        if (r118 >= r117.length) goto L34;
        int r119 = 0;
    L27:
        char[] r120 = this.f31926a;
        if (r119 == r120.length) goto L33;
        int r121 = r118 + r119;
        if (r121 >= r117.length) goto L33;
        r120[r119] = (char) r117[r121];
        r119 = r119 + 1;
    L33:
        write(r120, 0, r119);
        newLine();
        r118 = r118 + this.f31926a.length;
        goto L25
    L34:
        write("-----END RSA PUBLIC KEY-----");
        newLine();
        return;
    L17:
        if (r104 != 2) goto L22;
        int r122 = r111[r107] & UByte.MAX_VALUE;     // Catch: Exception -> L36
        int r123 = r111[r107 + 1] & UByte.MAX_VALUE;     // Catch: Exception -> L36
        int r124 = (r122 >>> 2) & 63;     // Catch: Exception -> L36
        int r125 = ((r122 << 4) | (r123 >>> 4)) & 63;     // Catch: Exception -> L36
        r103.write(r101.f31917a[r124]);     // Catch: Exception -> L36
        r103.write(r101.f31917a[r125]);     // Catch: Exception -> L36
        byte[] r126 = r101.f31917a;     // Catch: Exception -> L36
        r103.write(r126[(r123 << 2) & 63]);     // Catch: Exception -> L36
    L36:
        e = move-exception;
        StringBuilder r127 = com.baidu.mapauto.auth.b.a("exception encoding base64 string: ");
        r127.append(e.getMessage());
        throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(r127.toString(), e);
    }
}
