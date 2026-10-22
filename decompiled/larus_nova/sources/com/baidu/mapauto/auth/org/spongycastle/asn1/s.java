package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes39.dex */
public abstract class s extends r implements Iterable<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f31884a;

    public s() {
        this.f31884a = new Vector();
    }

    public s(e r100) {
        this.f31884a = new Vector();
        int r101 = 0;
    L4:
        if (r101 == r100.a()) goto L6;
        this.f31884a.addElement(r100.a(r101));
        r101 = r101 + 1;
        goto L4
    }

    public d a(int r100) {
        return (d) this.f31884a.elementAt(r100);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public r g() {
        z0 r100 = new z0();
        r100.f31884a = this.f31884a;
        return r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public r h() {
        l1 r100 = new l1();
        r100.f31884a = this.f31884a;
        return r100;
    }

    public Enumeration i() {
        return this.f31884a.elements();
    }

    public int size() {
        return this.f31884a.size();
    }

    public final String toString() {
        return this.f31884a.toString();
    }

    @Override // java.lang.Iterable
    public final Iterator<d> iterator() {
        d[] r100 = new d[size()];
        int r101 = 0;
    L4:
        if (r101 == size()) goto L7;
        r100[r101] = a(r101);
        r101 = r101 + 1;
        goto L4
    L7:
        return new com.baidu.mapauto.auth.org.spongycastle.util.a.C0635a(r100);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        Enumeration r100 = i();
        int r101 = size();
    L4:
        if (r100.hasMoreElements() == false) goto L6;
        r101 = (r101 * 17) ^ ((d) r100.nextElement()).hashCode();
        goto L4
    L6:
        return r101;
    }

    public static s a(Object r100) {
        if (r100 == null) goto L26;
        if ((r100 instanceof s) == true) goto L26;
        if ((r100 instanceof t) == false) goto L11;
        return a(((t) r100).c());
    L11:
        if ((r100 instanceof byte[]) == false) goto L18;
        return a(r.a((byte[]) r100));
    L14:
        e = move-exception;
        StringBuilder r101 = com.baidu.mapauto.auth.b.a("failed to construct sequence from byte[]: ");
        r101.append(e.getMessage());
        throw new IllegalArgumentException(r101.toString());
    L18:
        if ((r100 instanceof d) == false) goto L23;
        r r102 = ((d) r100).c();
        if ((r102 instanceof s) == false) goto L23;
        return (s) r102;
    L23:
        StringBuilder r103 = com.baidu.mapauto.auth.b.a("unknown object in getInstance: ");
        r103.append(r100.getClass().getName());
        throw new IllegalArgumentException(r103.toString());
    L26:
        return (s) r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof s) == true) goto L5;
        return false;
    L5:
        s r101 = (s) r100;
        if (size() == r101.size()) goto L8;
        return false;
    L8:
        Enumeration r102 = i();
        Enumeration r103 = r101.i();
    L10:
        if (r102.hasMoreElements() == false) goto L17;
        d r104 = (d) r102.nextElement();
        d r105 = (d) r103.nextElement();
        r r106 = r104.c();
        r r107 = r105.c();
        if (r106 == r107) goto L10;
        if (r106.equals(r107) == true) goto L10;
        return false;
    L17:
        return true;
    }
}
