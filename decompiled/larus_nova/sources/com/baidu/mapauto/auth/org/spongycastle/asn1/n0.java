package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encoding;

/* JADX INFO: loaded from: classes39.dex */
public final class n0 extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f31860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f31861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f31862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f31864e;

    public n0(e r100) {
        int r101 = 0;
        r r102 = a(0, r100);
        if ((r102 instanceof m) == false) goto L6;
        this.f31860a = (m) r102;
        r102 = a(1, r100);
        r101 = 1;
    L6:
        if ((r102 instanceof j) == false) goto L9;
        this.f31861b = (j) r102;
        r101 = r101 + 1;
        r102 = a(r101, r100);
    L9:
        if ((r102 instanceof w) == true) goto L12;
        this.f31862c = r102;
        r101 = r101 + 1;
        r102 = a(r101, r100);
    L12:
        if (r100.a() != (r101 + 1)) goto L20;
        if ((r102 instanceof w) == false) goto L18;
        w r103 = (w) r102;
        a(r103.j());
        this.f31864e = r103.i();
        return;
    L18:
        throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
    L20:
        throw new IllegalArgumentException("input vector too large");
    }

    public final void a(int r100) {
        if (r100 < 0) goto L8;
        if (r100 > 2) goto L8;
        this.f31863d = r100;
        return;
    L8:
        throw new IllegalArgumentException("invalid encoding value: " + r100);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof n0) == true) goto L5;
        return false;
    L5:
        if (this != r100) goto L8;
        return true;
    L8:
        n0 r101 = (n0) r100;
        m r102 = this.f31860a;
        if (r102 == null) goto L15;
        m r103 = r101.f31860a;
        if (r103 != null) goto L13;
    L14:
        return false;
    L13:
        if (r103.equals(r102) == false) goto L14;
    L15:
        j r104 = this.f31861b;
        if (r104 == null) goto L22;
        j r105 = r101.f31861b;
        if (r105 != null) goto L20;
    L21:
        return false;
    L20:
        if (r105.equals(r104) == false) goto L21;
    L22:
        r r106 = this.f31862c;
        if (r106 == null) goto L30;
        r r107 = r101.f31862c;
        if (r107 != null) goto L27;
    L28:
        return false;
    L27:
        if (r107.equals(r106) == false) goto L28;
    L30:
        return this.f31864e.equals(r101.f31864e);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() throws IOException {
        return d().length;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        m r100 = this.f31860a;
        if (r100 == null) goto L5;
        int r101 = r100.f31854a.hashCode();
    L6:
        j r102 = this.f31861b;
        if (r102 == null) goto L9;
        r101 = r101 ^ r102.hashCode();
    L9:
        r r103 = this.f31862c;
        if (r103 == null) goto L13;
        r101 = r101 ^ r103.hashCode();
    L13:
        return r101 ^ this.f31864e.hashCode();
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        m r102 = this.f31860a;
        if (r102 == null) goto L5;
        r101.write(r102.a(ASN1Encoding.DER));
    L5:
        j r103 = this.f31861b;
        if (r103 == null) goto L8;
        r101.write(r103.a(ASN1Encoding.DER));
    L8:
        r r104 = this.f31862c;
        if (r104 == null) goto L11;
        r101.write(r104.a(ASN1Encoding.DER));
    L11:
        r101.write(new e1(true, this.f31863d, this.f31864e).a(ASN1Encoding.DER));
        byte[] r105 = r101.toByteArray();
        r100.a(32, 8);
        r100.b(r105.length);
        r100.f31869a.write(r105);
    }

    public static r a(int r100, e r101) {
        if (r101.f31829a.size() <= r100) goto L7;
        return r101.a(r100).c();
    L7:
        throw new IllegalArgumentException("too few objects in input vector");
    }
}
