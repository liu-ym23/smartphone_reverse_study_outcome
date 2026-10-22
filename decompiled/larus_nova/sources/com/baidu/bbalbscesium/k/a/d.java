package com.baidu.bbalbscesium.k.a;

import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes39.dex */
class d extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected byte[] f30322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f30323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f30324f;

    public d(b r100) {
        super(r100);
        this.f30324f = null;
        int r101 = this.f30343b;
        this.f30323e = new byte[r101];
        this.f30322d = new byte[r101];
    }

    @Override // com.baidu.bbalbscesium.k.a.f
    public void a(boolean r100, String r101, byte[] r102, byte[] r103) throws InvalidKeyException {
        if (r102 == null) goto L9;
        if (r103 == null) goto L9;
        if (r103.length != this.f30343b) goto L9;
        this.f30344c = r103;
        e();
        this.f30342a.a(r100, r101, r102);
        return;
    L9:
        throw new InvalidKeyException("Internal error");
    }

    @Override // com.baidu.bbalbscesium.k.a.f
    public void a(byte[] r100, int r101, int r102, byte[] r110, int r111) {
        int r103 = r102 + r101;
        if (r100 != r110) goto L8;
        if (r101 < r111) goto L8;
        if ((r101 - r111) >= this.f30343b) goto L8;
        byte[] r104 = (byte[]) r100.clone();
    L9:
        if (r101 >= r103) goto L19;
        this.f30342a.a(r100, r101, this.f30323e, 0);
        int r105 = 0;
    L11:
        int r106 = this.f30343b;
        if (r105 >= r106) goto L14;
        r110[r105 + r111] = (byte) (this.f30323e[r105] ^ this.f30322d[r105]);
        r105 = r105 + 1;
        goto L11
    L14:
        byte[] r107 = this.f30322d;
        if (r104 != null) goto L17;
        System.arraycopy(r100, r101, r107, 0, r106);
    L18:
        int r108 = this.f30343b;
        r101 = r101 + r108;
        r111 = r111 + r108;
        goto L9
    L17:
        System.arraycopy(r104, r101, r107, 0, r106);
        goto L18
    L19:
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.baidu.bbalbscesium.k.a.f
    public String c() {
        return "CBC";
    }

    @Override // com.baidu.bbalbscesium.k.a.f
    public void c(byte[] r100, int r101, int r102, byte[] r103, int r110) {
        int r104 = r102 + r101;
    L3:
        if (r101 >= r104) goto L9;
        int r105 = 0;
    L6:
        if (r105 >= this.f30343b) goto L8;
        this.f30323e[r105] = (byte) (r100[r105 + r101] ^ this.f30322d[r105]);
        r105 = r105 + 1;
        goto L6
    L8:
        this.f30342a.b(this.f30323e, 0, r103, r110);
        System.arraycopy(r103, r110, this.f30322d, 0, this.f30343b);
        int r106 = this.f30343b;
        r101 = r101 + r106;
        r110 = r110 + r106;
        goto L3
    }

    @Override // com.baidu.bbalbscesium.k.a.f
    public void e() {
        System.arraycopy(this.f30344c, 0, this.f30322d, 0, this.f30343b);
    }

    @Override // com.baidu.bbalbscesium.k.a.f
    public void f() {
        System.arraycopy(this.f30324f, 0, this.f30322d, 0, this.f30343b);
    }

    @Override // com.baidu.bbalbscesium.k.a.f
    public void g() {
        if (this.f30324f != null) goto L5;
        this.f30324f = new byte[this.f30343b];
    L5:
        System.arraycopy(this.f30322d, 0, this.f30324f, 0, this.f30343b);
    }
}
