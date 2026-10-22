package com.baidu.mapauto.auth.org.spongycastle.asn1;

/* loaded from: classes.dex */
public abstract class w extends r implements p1 {

    /* renamed from: a, reason: collision with root package name */
    public int f7778a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7779b;

    /* renamed from: c, reason: collision with root package name */
    public d f7780c;

    public w(boolean z4, int i4, d dVar) {
        this.f7780c = null;
        this.f7779b = z4;
        this.f7778a = i4;
        if (!z4) {
            boolean z5 = dVar.c() instanceof u;
        }
        this.f7780c = dVar;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        return new e1(this.f7779b, this.f7778a, this.f7780c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        return new n1(this.f7779b, this.f7778a, this.f7780c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        int i4 = this.f7778a;
        d dVar = this.f7780c;
        return dVar != null ? i4 ^ dVar.hashCode() : i4;
    }

    public final r i() {
        d dVar = this.f7780c;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public final int j() {
        return this.f7778a;
    }

    public final String toString() {
        StringBuilder sbA = com.baidu.mapauto.auth.a.a("[");
        sbA.append(this.f7778a);
        sbA.append("]");
        sbA.append(this.f7780c);
        return sbA.toString();
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        if (!(rVar instanceof w)) {
            return false;
        }
        w wVar = (w) rVar;
        if (this.f7778a != wVar.f7778a || this.f7779b != wVar.f7779b) {
            return false;
        }
        d dVar = this.f7780c;
        return dVar == null ? wVar.f7780c == null : dVar.c().equals(wVar.f7780c.c());
    }
}
