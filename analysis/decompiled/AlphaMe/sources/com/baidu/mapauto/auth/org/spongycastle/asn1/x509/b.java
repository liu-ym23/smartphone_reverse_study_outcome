package com.baidu.mapauto.auth.org.spongycastle.asn1.x509;

import com.baidu.mapauto.auth.org.spongycastle.asn1.e;
import com.baidu.mapauto.auth.org.spongycastle.asn1.l;
import com.baidu.mapauto.auth.org.spongycastle.asn1.m0;
import com.baidu.mapauto.auth.org.spongycastle.asn1.r;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.asn1.z0;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class b extends l {

    /* renamed from: a, reason: collision with root package name */
    public a f7785a;

    /* renamed from: b, reason: collision with root package name */
    public m0 f7786b;

    @Deprecated
    public b(s sVar) {
        if (sVar.size() != 2) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("Bad sequence size: ");
            sbA.append(sVar.size());
            throw new IllegalArgumentException(sbA.toString());
        }
        Enumeration enumerationI = sVar.i();
        this.f7785a = a.a(enumerationI.nextElement());
        this.f7786b = m0.a(enumerationI.nextElement());
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        e eVar = new e();
        eVar.f7709a.addElement(this.f7785a);
        eVar.f7709a.addElement(this.f7786b);
        return new z0(eVar);
    }
}
