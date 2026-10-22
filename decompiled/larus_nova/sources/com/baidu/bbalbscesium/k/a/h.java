package com.baidu.bbalbscesium.k.a;

import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: classes39.dex */
final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30346a;

    public h(int r100) {
        this.f30346a = r100;
    }

    @Override // com.baidu.bbalbscesium.k.a.i
    public int a(int r100) {
        int r101 = this.f30346a;
        return r101 - (r100 % r101);
    }

    @Override // com.baidu.bbalbscesium.k.a.i
    public int a(byte[] r100, int r101, int r102) {
        int r103 = 0;
        if (r100 == null) goto L21;
        if (r102 == 0) goto L21;
        int r104 = r102 + r101;
        int r105 = r100[r104 - 1];
        int r106 = r105 & 255;
        if (r106 >= 1) goto L9;
    L20:
        return -1;
    L9:
        if (r106 > this.f30346a) goto L20;
        int r107 = r104 - r106;
        if (r107 >= r101) goto L14;
        return -1;
    L14:
        if (r103 >= r106) goto L19;
        if (r100[r107 + r103] != r105) goto L17;
        r103 = r103 + 1;
        goto L14
    L17:
        return -1;
    L19:
        return r107;
    L21:
        return 0;
    }

    @Override // com.baidu.bbalbscesium.k.a.i
    public void b(byte[] r100, int r101, int r102) throws ShortBufferException {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r101 + r102) > r100.length) goto L11;
        byte r103 = (byte) (r102 & 255);
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L9;
        r100[r104 + r101] = r103;
        r104 = r104 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new ShortBufferException("Buffer too small to hold padding");
    }
}
