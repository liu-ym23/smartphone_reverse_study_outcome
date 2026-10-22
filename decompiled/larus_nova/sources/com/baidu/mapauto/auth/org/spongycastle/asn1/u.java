package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import kotlin.UByte;
import org.bouncycastle.asn1.ASN1Encoding;

/* JADX INFO: loaded from: classes39.dex */
public abstract class u extends r implements Iterable<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f31891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f31892b;

    public u() {
        this.f31891a = new Vector();
        this.f31892b = false;
    }

    public u(e r100) {
        this.f31891a = new Vector();
        int r101 = 0;
        this.f31892b = false;
    L4:
        if (r101 == r100.a()) goto L6;
        this.f31891a.addElement(r100.a(r101));
        r101 = r101 + 1;
        goto L4
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        if (this.f31892b == false) goto L6;
        b1 r100 = new b1();
        r100.f31891a = this.f31891a;
        return r100;
    L6:
        Vector r101 = new Vector();
        int r102 = 0;
    L8:
        if (r102 == this.f31891a.size()) goto L10;
        r101.addElement(this.f31891a.elementAt(r102));
        r102 = r102 + 1;
        goto L8
    L10:
        b1 r103 = new b1();
        r103.f31891a = r101;
        r103.i();
        return r103;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        m1 r100 = new m1();
        r100.f31891a = this.f31891a;
        return r100;
    }

    public final String toString() {
        return this.f31891a.toString();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        Enumeration r100 = this.f31891a.elements();
        int r101 = this.f31891a.size();
    L4:
        if (r100.hasMoreElements() == false) goto L9;
        Object r102 = (d) r100.nextElement();
        if (r102 != null) goto L8;
        r102 = t0.f31887a;
    L8:
        r101 = (r101 * 17) ^ r102.hashCode();
        goto L4
    L9:
        return r101;
    }

    public final void i() {
        if (this.f31892b == true) goto L35;
        this.f31892b = true;
        if (this.f31891a.size() <= 1) goto L46;
        int r100 = this.f31891a.size() - 1;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L47;
        byte[] r102 = ((d) this.f31891a.elementAt(0)).c().a(ASN1Encoding.DER);     // Catch: IOException -> L33
        int r103 = 0;
        boolean r104 = false;
        int r105 = 0;
    L11:
        if (r105 == r100) goto L32;
        int r110 = r105 + 1;
        byte[] r106 = ((d) this.f31891a.elementAt(r110)).c().a(ASN1Encoding.DER);     // Catch: IOException -> L30
        int r111 = Math.min(r102.length, r106.length);
        int r112 = 0;
    L15:
        if (r112 == r111) goto L23;
        byte r113 = r102[r112];
        byte r114 = r106[r112];
        if (r113 != r114) goto L19;
        r112 = r112 + 1;
        goto L15
    L19:
        if ((r113 & UByte.MAX_VALUE) < (r114 & UByte.MAX_VALUE)) goto L24;
    L25:
        boolean r115 = false;
    L26:
        if (r115 == false) goto L28;
        r102 = r106;
    L29:
        r105 = r110;
        goto L11
    L28:
        Object r107 = this.f31891a.elementAt(r105);
        Vector r108 = this.f31891a;
        r108.setElementAt(r108.elementAt(r110), r105);
        this.f31891a.setElementAt(r107, r110);
        r103 = r105;
        r104 = true;
    L24:
        r115 = true;
        goto L26
    L23:
        if (r111 != r102.length) goto L25;
    L31:
        throw new IllegalArgumentException("cannot encode object added to SET");
    L32:
        r100 = r103;
        r101 = r104;
    L34:
        throw new IllegalArgumentException("cannot encode object added to SET");
    L47:
        return;
    L46:
        return;
    }

    @Override // java.lang.Iterable
    public final Iterator<d> iterator() {
        d[] r100 = new d[this.f31891a.size()];
        int r101 = 0;
    L4:
        if (r101 == this.f31891a.size()) goto L7;
        r100[r101] = (d) this.f31891a.elementAt(r101);
        r101 = r101 + 1;
        goto L4
    L7:
        return new com.baidu.mapauto.auth.org.spongycastle.util.a.C0635a(r100);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof u) == true) goto L5;
        return false;
    L5:
        u r101 = (u) r100;
        if (this.f31891a.size() == r101.f31891a.size()) goto L8;
        return false;
    L8:
        Enumeration r102 = this.f31891a.elements();
        Enumeration r103 = r101.f31891a.elements();
    L10:
        if (r102.hasMoreElements() == false) goto L23;
        d r104 = (d) r102.nextElement();
        if (r104 != null) goto L14;
        r104 = t0.f31887a;
    L14:
        d r105 = (d) r103.nextElement();
        if (r105 != null) goto L17;
        r105 = t0.f31887a;
    L17:
        r r106 = r104.c();
        r r107 = r105.c();
        if (r106 == r107) goto L10;
        if (r106.equals(r107) == true) goto L10;
        return false;
    L23:
        return true;
    }
}
