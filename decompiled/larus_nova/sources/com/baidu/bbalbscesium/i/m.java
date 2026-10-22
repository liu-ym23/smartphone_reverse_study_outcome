package com.baidu.bbalbscesium.i;

import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes39.dex */
final class m extends k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f30167h = 0;

    public m(int r100, int r101) {
        this.f30157a = BodyPartID.bodyIdMax;
        this.f30158b = 4;
        this.f30159c = 32;
        this.f30160d = r100;
        this.f30161e = r101;
    }

    @Override // com.baidu.bbalbscesium.i.k
    public b a(byte[] r100, int r101, int r102) {
        n r103 = new n();
        r103.a(r100, r101, r102);
        return b.a(new long[]{r103.a()});
    }
}
