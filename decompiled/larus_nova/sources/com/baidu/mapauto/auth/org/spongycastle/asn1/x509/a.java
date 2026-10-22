package com.baidu.mapauto.auth.org.spongycastle.asn1.x509;

import com.baidu.mapauto.auth.org.spongycastle.asn1.d;
import com.baidu.mapauto.auth.org.spongycastle.asn1.e;
import com.baidu.mapauto.auth.org.spongycastle.asn1.l;
import com.baidu.mapauto.auth.org.spongycastle.asn1.m;
import com.baidu.mapauto.auth.org.spongycastle.asn1.r;
import com.baidu.mapauto.auth.org.spongycastle.asn1.s;
import com.baidu.mapauto.auth.org.spongycastle.asn1.z0;

/* JADX INFO: loaded from: classes39.dex */
public final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f31903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f31904b;

    public static a a(Object r100) {
        if ((r100 instanceof a) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new a(s.a(r100));
    L5:
        return (a) r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.l, com.baidu.mapauto.auth.org.spongycastle.asn1.d
    public final r c() {
        e r100 = new e();
        m r101 = this.f31903a;
        r100.f31829a.addElement(r101);
        d r102 = this.f31904b;
        if (r102 == null) goto L6;
        r100.f31829a.addElement(r102);
    L6:
        return new z0(r100);
    }

    public a(s r100) {
        if (r100.size() >= 1) goto L5;
    L12:
        StringBuilder r101 = com.baidu.mapauto.auth.b.a("Bad sequence size: ");
        r101.append(r100.size());
        throw new IllegalArgumentException(r101.toString());
    L5:
        if (r100.size() > 2) goto L12;
        this.f31903a = m.a(r100.a(0));
        if (r100.size() != 2) goto L9;
        d r102 = r100.a(1);
    L10:
        this.f31904b = r102;
        return;
    L9:
        r102 = null;
        goto L10
    }
}
