package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class m0 extends b {
    public m0(byte[] r100, int r101) {
        super(r100, r101);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return ((u1.a(this.f31815a.length + 1) + 1) + this.f31815a.length) + 1;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    public static m0 a(Object r100) {
        if (r100 == null) goto L20;
        if ((r100 instanceof m0) == true) goto L20;
        if ((r100 instanceof j1) == false) goto L11;
        j1 r101 = (j1) r100;
        return new m0(r101.f31815a, r101.f31816b);
    L11:
        if ((r100 instanceof byte[]) == true) goto L21;
        StringBuilder r102 = com.baidu.mapauto.auth.b.a("illegal object in getInstance: ");
        r102.append(r100.getClass().getName());
        throw new IllegalArgumentException(r102.toString());
    L21:
        return (m0) r.a((byte[]) r100);
    L14:
        e = move-exception;
        StringBuilder r103 = com.baidu.mapauto.auth.b.a("encoding error in getInstance: ");
        r103.append(e.toString());
        throw new IllegalArgumentException(r103.toString());
    L20:
        return (m0) r100;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        byte[] r101 = this.f31815a;
        int r102 = this.f31816b;
        byte[] r103 = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r101);
        if (r102 <= 0) goto L5;
        int r104 = r101.length - 1;
        int r105 = 255 << r102;
        r103[r104] = (byte) (r105 & r103[r104]);
    L5:
        int r106 = r103.length + 1;
        byte[] r107 = new byte[r106];
        r107[0] = (byte) this.f31816b;
        System.arraycopy(r103, 0, r107, 1, r106 - 1);
        r100.a(r107, 3);
    }
}
