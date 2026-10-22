package com.baidu.mapauto.auth.org.spongycastle.asn1;

import androidx.room.AbstractC0351g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class n0 extends r {

    /* renamed from: a, reason: collision with root package name */
    public m f7740a;

    /* renamed from: b, reason: collision with root package name */
    public j f7741b;

    /* renamed from: c, reason: collision with root package name */
    public r f7742c;

    /* renamed from: d, reason: collision with root package name */
    public int f7743d;

    /* renamed from: e, reason: collision with root package name */
    public r f7744e;

    public n0(e eVar) {
        int i4 = 0;
        r rVarA = a(0, eVar);
        if (rVarA instanceof m) {
            this.f7740a = (m) rVarA;
            rVarA = a(1, eVar);
            i4 = 1;
        }
        if (rVarA instanceof j) {
            this.f7741b = (j) rVarA;
            i4++;
            rVarA = a(i4, eVar);
        }
        if (!(rVarA instanceof w)) {
            this.f7742c = rVarA;
            i4++;
            rVarA = a(i4, eVar);
        }
        if (eVar.a() != i4 + 1) {
            throw new IllegalArgumentException("input vector too large");
        }
        if (!(rVarA instanceof w)) {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
        w wVar = (w) rVarA;
        a(wVar.j());
        this.f7744e = wVar.i();
    }

    public final void a(int i4) {
        if (i4 < 0 || i4 > 2) {
            throw new IllegalArgumentException(AbstractC0351g.m("invalid encoding value: ", i4));
        }
        this.f7743d = i4;
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
        m mVar = this.f7740a;
        int iHashCode = mVar != null ? mVar.f7734a.hashCode() : 0;
        j jVar = this.f7741b;
        if (jVar != null) {
            iHashCode ^= jVar.hashCode();
        }
        r rVar = this.f7742c;
        if (rVar != null) {
            iHashCode ^= rVar.hashCode();
        }
        return this.f7744e.hashCode() ^ iHashCode;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        r rVar2;
        j jVar;
        m mVar;
        if (!(rVar instanceof n0)) {
            return false;
        }
        if (this == rVar) {
            return true;
        }
        n0 n0Var = (n0) rVar;
        m mVar2 = this.f7740a;
        if (mVar2 != null && ((mVar = n0Var.f7740a) == null || !mVar.equals(mVar2))) {
            return false;
        }
        j jVar2 = this.f7741b;
        if (jVar2 != null && ((jVar = n0Var.f7741b) == null || !jVar.equals(jVar2))) {
            return false;
        }
        r rVar3 = this.f7742c;
        if (rVar3 == null || ((rVar2 = n0Var.f7742c) != null && rVar2.equals(rVar3))) {
            return this.f7744e.equals(n0Var.f7744e);
        }
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m mVar = this.f7740a;
        if (mVar != null) {
            byteArrayOutputStream.write(mVar.a("DER"));
        }
        j jVar = this.f7741b;
        if (jVar != null) {
            byteArrayOutputStream.write(jVar.a("DER"));
        }
        r rVar = this.f7742c;
        if (rVar != null) {
            byteArrayOutputStream.write(rVar.a("DER"));
        }
        byteArrayOutputStream.write(new e1(true, this.f7743d, this.f7744e).a("DER"));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        pVar.a(32, 8);
        pVar.b(byteArray.length);
        pVar.f7749a.write(byteArray);
    }

    public static r a(int i4, e eVar) {
        if (eVar.f7709a.size() > i4) {
            return eVar.a(i4).c();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }
}
