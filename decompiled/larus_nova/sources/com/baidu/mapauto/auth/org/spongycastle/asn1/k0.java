package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class k0 extends a {
    public k0(boolean r100, int r101, byte[] r102) {
        super(r100, r101, r102);
    }

    public final String toString() {
        StringBuffer r100 = new StringBuffer("[");
        if (this.f31809a == false) goto L5;
        r100.append("CONSTRUCTED ");
    L5:
        r100.append("APPLICATION ");
        r100.append(Integer.toString(this.f31810b));
        r100.append("]");
        if (this.f31811c == null) goto L17;
        r100.append(" #");
        byte[] r101 = this.f31811c;
        com.baidu.mapauto.auth.org.spongycastle.util.encoders.e r102 = com.baidu.mapauto.auth.org.spongycastle.util.encoders.d.f31920a;
        int r103 = r101.length;
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        r102.getClass();     // Catch: Exception -> L14
        int r105 = 0;
    L10:
        if (r105 >= (0 + r103)) goto L13;
        int r106 = r101[r105] & UByte.MAX_VALUE;     // Catch: Exception -> L14
        r104.write(r102.f31921a[r106 >>> 4]);     // Catch: Exception -> L14
        r104.write(r102.f31921a[r106 & 15]);     // Catch: Exception -> L14
        r105 = r105 + 1;
        goto L10
    L13:
        r100.append(com.baidu.mapauto.auth.org.spongycastle.util.d.a(r104.toByteArray()));
    L18:
        r100.append(" ");
        return r100.toString();
    L14:
        e = move-exception;
        StringBuilder r107 = com.baidu.mapauto.auth.b.a("exception encoding Hex string: ");
        r107.append(e.getMessage());
        throw new com.baidu.mapauto.auth.org.spongycastle.util.encoders.c(r107.toString(), e);
    L17:
        r100.append(" #null");
        goto L18
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.a, com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        if (this.f31809a == false) goto L5;
        int r101 = 96;
    L6:
        int r102 = this.f31810b;
        byte[] r103 = this.f31811c;
        r100.a(r101, r102);
        r100.b(r103.length);
        r100.f31869a.write(r103);
        return;
    L5:
        r101 = 64;
        goto L6
    }
}
