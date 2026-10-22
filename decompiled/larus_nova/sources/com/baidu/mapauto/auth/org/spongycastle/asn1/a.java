package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public abstract class a extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f31809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f31810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f31811c;

    public a(boolean r100, int r101, byte[] r102) {
        this.f31809a = r100;
        this.f31810b = r101;
        this.f31811c = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r102);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof a) == true) goto L5;
        return false;
    L5:
        a r101 = (a) r100;
        if (this.f31809a == r101.f31809a) goto L8;
        return false;
    L8:
        if (this.f31810b == r101.f31810b) goto L10;
        return false;
    L10:
        if (com.baidu.mapauto.auth.org.spongycastle.util.a.a(this.f31811c, r101.f31811c) == false) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int r100 = u1.b(this.f31810b);
        return (u1.a(this.f31811c.length) + r100) + this.f31811c.length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return this.f31809a;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        boolean r100 = this.f31809a;
        int r101 = this.f31810b;
        return ((r100 ? 1 : 0) ^ r101) ^ com.baidu.mapauto.auth.org.spongycastle.util.a.b(this.f31811c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public void a(p r100) throws IOException {
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
