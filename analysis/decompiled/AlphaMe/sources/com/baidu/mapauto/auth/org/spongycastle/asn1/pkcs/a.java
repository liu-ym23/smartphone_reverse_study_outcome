package com.baidu.mapauto.auth.org.spongycastle.asn1.pkcs;

import com.baidu.mapauto.auth.org.spongycastle.asn1.e;
import com.baidu.mapauto.auth.org.spongycastle.asn1.j;
import com.baidu.mapauto.auth.org.spongycastle.asn1.l;
import com.baidu.mapauto.auth.org.spongycastle.asn1.r;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.asn1.z0;
import java.math.BigInteger;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class a extends l {

    /* renamed from: a, reason: collision with root package name */
    public BigInteger f7753a;

    /* renamed from: b, reason: collision with root package name */
    public BigInteger f7754b;

    public a(s sVar) {
        if (sVar.size() != 2) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("Bad sequence size: ");
            sbA.append(sVar.size());
            throw new IllegalArgumentException(sbA.toString());
        }
        Enumeration enumerationI = sVar.i();
        this.f7753a = j.a(enumerationI.nextElement()).i();
        this.f7754b = j.a(enumerationI.nextElement()).i();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        e eVar = new e();
        eVar.f7709a.addElement(new j(this.f7753a));
        eVar.f7709a.addElement(new j(this.f7754b));
        return new z0(eVar);
    }
}
