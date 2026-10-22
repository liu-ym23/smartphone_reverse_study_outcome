package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class f1 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31833a;

    public f1(byte[] r100) {
        this.f31833a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(this.f31833a, 12);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof f1) == true) goto L7;
        return false;
    L7:
        return com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31833a, ((f1) r100).f31833a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        return (u1.a(this.f31833a.length) + 1) + this.f31833a.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f31833a);
    }

    public final String toString() {
        byte[] r100 = this.f31833a;
        int r101 = com.baidu.mapauto.auth.org.spongycastle.util.d.f31915a;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r100.length) goto L15;
        r104 = r104 + 1;
        byte r105 = r100[r103];
        if ((r105 & 240) == 240) goto L7;
        if ((r105 & 224) == 224) goto L10;
        if ((r105 & 192) == 192) goto L13;
        r103 = r103 + 1;
        goto L4
    L13:
        r103 = r103 + 2;
        goto L4
    L10:
        r103 = r103 + 3;
        goto L4
    L7:
        r104 = r104 + 1;
        r103 = r103 + 4;
        goto L4
    L15:
        char[] r106 = new char[r104];
        int r107 = 0;
    L17:
        if (r102 >= r100.length) goto L34;
        byte r108 = r100[r102];
        if ((r108 & 240) != 240) goto L22;
        int r109 = (((((r108 & 3) << 18) | ((r100[r102 + 1] & 63) << 12)) | ((r100[r102 + 2] & 63) << 6)) | (r100[r102 + 3] & 63)) - 65536;
        char r110 = (char) ((r109 >> 10) | 55296);
        char r111 = (char) ((r109 & 1023) | 56320);
        r106[r107] = r110;
        r102 = r102 + 4;
        r107 = r107 + 1;
    L32:
        r106[r107] = r111;
        r107 = r107 + 1;
        goto L17
    L22:
        if ((r108 & 224) != 224) goto L25;
        r111 = (char) ((((r108 & 15) << 12) | ((r100[r102 + 1] & 63) << 6)) | (r100[r102 + 2] & 63));
        r102 = r102 + 3;
        goto L32
    L25:
        if ((r108 & 208) != 208) goto L29;
        int r112 = (r108 & 31) << 6;
        byte r113 = r100[r102 + 1];
    L27:
        r111 = (char) (r112 | (r113 & 63));
        r102 = r102 + 2;
        goto L32
    L29:
        if ((r108 & 192) != 192) goto L31;
        r112 = (r108 & 31) << 6;
        r113 = r100[r102 + 1];
        goto L27
    L31:
        r111 = (char) (r108 & UByte.MAX_VALUE);
        r102 = r102 + 1;
        goto L32
    L34:
        return new String(r106);
    }
}
