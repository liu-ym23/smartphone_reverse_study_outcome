package com.baidu.mapauto.auth.org.spongycastle.asn1.x509;

import com.baidu.mapauto.auth.org.spongycastle.asn1.e;
import com.baidu.mapauto.auth.org.spongycastle.asn1.l;
import com.baidu.mapauto.auth.org.spongycastle.asn1.m0;
import com.baidu.mapauto.auth.org.spongycastle.asn1.r;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.asn1.z0;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f31905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m0 f31906b;

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        e r100 = new e();
        a r101 = this.f31905a;
        r100.f31829a.addElement(r101);
        m0 r102 = this.f31906b;
        r100.f31829a.addElement(r102);
        return new z0(r100);
    }

    public b(s r100) {
        if (r100.size() != 2) goto L6;
        Enumeration r101 = r100.i();
        this.f31905a = a.a(r101.nextElement());
        this.f31906b = m0.a(r101.nextElement());
        return;
    L6:
        StringBuilder r102 = com.baidu.mapauto.auth.b.a("Bad sequence size: ");
        r102.append(r100.size());
        throw new IllegalArgumentException(r102.toString());
    }
}
