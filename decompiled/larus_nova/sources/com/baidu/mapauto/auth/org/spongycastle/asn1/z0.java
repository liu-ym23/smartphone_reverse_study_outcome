package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes39.dex */
public final class z0 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f31910b;

    public z0() {
        this.f31910b = -1;
    }

    public z0(e r100) {
        super(r100);
        this.f31910b = -1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        int r100 = j();
        return (u1.a(r100) + 1) + r100;
    }

    public final int j() throws IOException {
        if (this.f31910b >= 0) goto L10;
        Enumeration r100 = this.f31884a.elements();
        int r101 = 0;
    L6:
        if (r100.hasMoreElements() == false) goto L8;
        r101 = r101 + ((d) r100.nextElement()).c().g().e();
        goto L6
    L8:
        this.f31910b = r101;
    L10:
        return this.f31910b;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        x0 r101 = r100.a();
        int r102 = j();
        r100.a(48);
        r100.b(r102);
        Enumeration r103 = this.f31884a.elements();
    L4:
        if (r103.hasMoreElements() == false) goto L6;
        r101.a((d) r103.nextElement());
        goto L4
    }
}
