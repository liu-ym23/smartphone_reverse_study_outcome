package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes39.dex */
public final class b1 extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f31820c;

    public b1() {
        this.f31820c = -1;
    }

    public b1(e r100) {
        super(r100);
        this.f31820c = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        if (this.f31820c >= 0) goto L9;
        Enumeration r100 = this.f31891a.elements();
        int r101 = 0;
    L6:
        if (r100.hasMoreElements() == false) goto L8;
        r101 = r101 + ((d) r100.nextElement()).c().g().e();
        goto L6
    L8:
        this.f31820c = r101;
    L9:
        int r102 = this.f31820c;
        return (u1.a(r102) + 1) + r102;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        x0 r101 = r100.a();
        if (this.f31820c >= 0) goto L9;
        Enumeration r102 = this.f31891a.elements();
        int r103 = 0;
    L6:
        if (r102.hasMoreElements() == false) goto L8;
        r103 = r103 + ((d) r102.nextElement()).c().g().e();
        goto L6
    L8:
        this.f31820c = r103;
    L9:
        int r104 = this.f31820c;
        r100.a(49);
        r100.b(r104);
        Enumeration r105 = this.f31891a.elements();
    L11:
        if (r105.hasMoreElements() == false) goto L13;
        r101.a((d) r105.nextElement());
        goto L11
    }
}
