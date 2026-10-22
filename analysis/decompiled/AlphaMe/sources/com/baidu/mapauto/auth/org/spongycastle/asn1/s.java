package com.baidu.mapauto.auth.org.spongycastle.asn1;

import com.baidu.mapauto.auth.org.spongycastle.util.a;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes.dex */
public abstract class s extends r implements Iterable<d> {

    /* renamed from: a, reason: collision with root package name */
    public Vector f7764a = new Vector();

    public s() {
    }

    public d a(int i4) {
        return (d) this.f7764a.elementAt(i4);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public r g() {
        z0 z0Var = new z0();
        z0Var.f7764a = this.f7764a;
        return z0Var;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public r h() {
        l1 l1Var = new l1();
        l1Var.f7764a = this.f7764a;
        return l1Var;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        Enumeration enumerationI = i();
        int size = size();
        while (enumerationI.hasMoreElements()) {
            size = (size * 17) ^ ((d) enumerationI.nextElement()).hashCode();
        }
        return size;
    }

    public Enumeration i() {
        return this.f7764a.elements();
    }

    @Override // java.lang.Iterable
    public final Iterator<d> iterator() {
        d[] dVarArr = new d[size()];
        for (int i4 = 0; i4 != size(); i4++) {
            dVarArr[i4] = a(i4);
        }
        return new a.C0021a(dVarArr);
    }

    public int size() {
        return this.f7764a.size();
    }

    public final String toString() {
        return this.f7764a.toString();
    }

    public s(e eVar) {
        for (int i4 = 0; i4 != eVar.a(); i4++) {
            this.f7764a.addElement(eVar.a(i4));
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof s)) {
            return false;
        }
        s sVar = (s) rVar;
        if (size() != sVar.size()) {
            return false;
        }
        Enumeration enumerationI = i();
        Enumeration enumerationI2 = sVar.i();
        while (enumerationI.hasMoreElements()) {
            d dVar = (d) enumerationI.nextElement();
            d dVar2 = (d) enumerationI2.nextElement();
            r rVarC = dVar.c();
            r rVarC2 = dVar2.c();
            if (rVarC != rVarC2 && !rVarC.equals(rVarC2)) {
                return false;
            }
        }
        return true;
    }

    public static s a(Object obj) {
        if (obj == null || (obj instanceof s)) {
            return (s) obj;
        }
        if (obj instanceof t) {
            return a((Object) ((t) obj).c());
        }
        if (obj instanceof byte[]) {
            try {
                return a((Object) r.a((byte[]) obj));
            } catch (IOException e4) {
                StringBuilder sbA = com.baidu.mapauto.auth.a.a("failed to construct sequence from byte[]: ");
                sbA.append(e4.getMessage());
                throw new IllegalArgumentException(sbA.toString());
            }
        }
        if (obj instanceof d) {
            r rVarC = ((d) obj).c();
            if (rVarC instanceof s) {
                return (s) rVarC;
            }
        }
        StringBuilder sbA2 = com.baidu.mapauto.auth.a.a("unknown object in getInstance: ");
        sbA2.append(obj.getClass().getName());
        throw new IllegalArgumentException(sbA2.toString());
    }
}
