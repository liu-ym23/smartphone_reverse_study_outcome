package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class j1 extends b {
    public j1(byte[] r100, int r101) {
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

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        byte[] r101 = this.f31815a;
        int r102 = r101.length + 1;
        byte[] r103 = new byte[r102];
        r103[0] = (byte) this.f31816b;
        System.arraycopy(r101, 0, r103, 1, r102 - 1);
        r100.a(r103, 3);
    }
}
