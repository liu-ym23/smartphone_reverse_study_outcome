package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes39.dex */
public final class l1 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f31852b;

    public l1() {
        this.f31852b = -1;
    }

    public l1(e r100) {
        super(r100);
        this.f31852b = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        if (this.f31852b >= 0) goto L9;
        Enumeration r100 = this.f31884a.elements();
        int r101 = 0;
    L6:
        if (r100.hasMoreElements() == false) goto L8;
        r101 = r101 + ((d) r100.nextElement()).c().h().e();
        goto L6
    L8:
        this.f31852b = r101;
    L9:
        int r102 = this.f31852b;
        return (u1.a(r102) + 1) + r102;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        p r101 = r100.b();
        if (this.f31852b >= 0) goto L9;
        Enumeration r102 = this.f31884a.elements();
        int r103 = 0;
    L6:
        if (r102.hasMoreElements() == false) goto L8;
        r103 = r103 + ((d) r102.nextElement()).c().h().e();
        goto L6
    L8:
        this.f31852b = r103;
    L9:
        int r104 = this.f31852b;
        r100.a(48);
        r100.b(r104);
        Enumeration r105 = this.f31884a.elements();
    L11:
        if (r105.hasMoreElements() == false) goto L13;
        r101.a((d) r105.nextElement());
        goto L11
    }
}
