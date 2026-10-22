package com.baidu.mapauto.auth.org.spongycastle.asn1;

/* JADX INFO: loaded from: classes39.dex */
public abstract class w extends r implements p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f31899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f31900c;

    public w(boolean r100, int r101, d r102) {
        this.f31900c = null;
        this.f31899b = r100;
        this.f31898a = r101;
        if (r100 == true) goto L6;
        boolean r103 = r102.c() instanceof u;
    L6:
        this.f31900c = r102;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.p1
    public final r a() {
        return this;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof w) == true) goto L5;
        return false;
    L5:
        w r101 = (w) r100;
        if (this.f31898a == r101.f31898a) goto L8;
    L20:
        return false;
    L8:
        if (this.f31899b != r101.f31899b) goto L20;
        d r102 = this.f31900c;
        if (r102 != null) goto L16;
        if (r101.f31900c == null) goto L18;
        return false;
    L18:
        return true;
    L16:
        if (r102.c().equals(r101.f31900c.c()) == true) goto L21;
        return false;
    L21:
        return true;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r g() {
        return new e1(this.f31899b, this.f31898a, this.f31900c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final r h() {
        return new n1(this.f31899b, this.f31898a, this.f31900c);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        int r100 = this.f31898a;
        d r101 = this.f31900c;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return r100 ^ r101.hashCode();
    }

    public final r i() {
        d r100 = this.f31900c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.c();
    }

    public final int j() {
        return this.f31898a;
    }

    public final String toString() {
        StringBuilder r100 = com.baidu.mapauto.auth.b.a("[");
        r100.append(this.f31898a);
        r100.append("]");
        r100.append(this.f31900c);
        return r100.toString();
    }
}
