package com.baidu.mapauto.auth.org.spongycastle.asn1.x509;

import com.baidu.mapauto.auth.org.spongycastle.asn1.d;
import com.baidu.mapauto.auth.org.spongycastle.asn1.e;
import com.baidu.mapauto.auth.org.spongycastle.asn1.l;
import com.baidu.mapauto.auth.org.spongycastle.asn1.m;
import com.baidu.mapauto.auth.org.spongycastle.asn1.r;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.asn1.z0;

/* loaded from: classes.dex */
public final class a extends l {

    /* renamed from: a, reason: collision with root package name */
    public m f7783a;

    /* renamed from: b, reason: collision with root package name */
    public d f7784b;

    public a(s sVar) {
        if (sVar.size() < 1 || sVar.size() > 2) {
            StringBuilder sbA = com.baidu.mapauto.auth.a.a("Bad sequence size: ");
            sbA.append(sVar.size());
            throw new IllegalArgumentException(sbA.toString());
        }
        this.f7783a = m.a(sVar.a(0));
        this.f7784b = sVar.size() == 2 ? sVar.a(1) : null;
    }

    public static a a(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(s.a(obj));
        }
        return null;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        e eVar = new e();
        eVar.f7709a.addElement(this.f7783a);
        d dVar = this.f7784b;
        if (dVar != null) {
            eVar.f7709a.addElement(dVar);
        }
        return new z0(eVar);
    }
}
