package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class l0 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f31851a;

    public l0(char[] r100) {
        this.f31851a = r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(30);
        r100.b(this.f31851a.length * 2);
        int r101 = 0;
    L3:
        char[] r102 = this.f31851a;
        if (r101 == r102.length) goto L6;
        char r103 = r102[r101];
        r100.a((byte) (r103 >> '\b'));
        r100.a((byte) r103);
        r101 = r101 + 1;
        goto L3
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        int r100 = u1.a(this.f31851a.length * 2) + 1;
        return (this.f31851a.length * 2) + r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        char[] r100 = this.f31851a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = r101 + 1;
    L6:
        r101 = r101 - 1;
        if (r101 < 0) goto L10;
        r102 = (r102 * 257) ^ r100[r101];
        goto L6
    L10:
        return r102;
    }

    public final String toString() {
        return new String(this.f31851a);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof l0) == true) goto L5;
        return false;
    L5:
        char[] r101 = this.f31851a;
        char[] r102 = ((l0) r100).f31851a;
        if (r101 == r102) goto L21;
        if (r101 == null) goto L25;
        if (r102 != null) goto L12;
        return false;
    L12:
        if (r101.length != r102.length) goto L27;
        int r103 = 0;
    L16:
        if (r103 == r101.length) goto L21;
        if (r101[r103] != r102[r103]) goto L28;
        r103 = r103 + 1;
        goto L16
    L28:
        return false;
    L27:
        return false;
    L25:
        return false;
    L21:
        return true;
    }
}
