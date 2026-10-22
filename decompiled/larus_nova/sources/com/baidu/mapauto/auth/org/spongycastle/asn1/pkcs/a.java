package com.baidu.mapauto.auth.org.spongycastle.asn1.pkcs;

import com.baidu.mapauto.auth.b;
import com.baidu.mapauto.auth.org.spongycastle.asn1.e;
import com.baidu.mapauto.auth.org.spongycastle.asn1.j;
import com.baidu.mapauto.auth.org.spongycastle.asn1.l;
import com.baidu.mapauto.auth.org.spongycastle.asn1.r;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.asn1.z0;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes39.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f31873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f31874b;

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        e r100 = new e();
        j r101 = new j(this.f31873a);
        r100.f31829a.addElement(r101);
        j r102 = new j(this.f31874b);
        r100.f31829a.addElement(r102);
        return new z0(r100);
    }

    public a(s r100) {
        if (r100.size() != 2) goto L6;
        Enumeration r101 = r100.i();
        this.f31873a = j.a(r101.nextElement()).i();
        this.f31874b = j.a(r101.nextElement()).i();
        return;
    L6:
        StringBuilder r102 = b.a("Bad sequence size: ");
        r102.append(r100.size());
        throw new IllegalArgumentException(r102.toString());
    }
}
