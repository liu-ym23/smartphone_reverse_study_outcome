package com.baidu.mapauto.auth.org.spongycastle.util.encoders;

/* JADX INFO: loaded from: classes39.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f31918b;

    public b() {
        this.f31917a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        this.f31918b = new byte[128];
        a();
    }

    public final void a() {
        int r100 = 0;
        int r101 = 0;
    L3:
        byte[] r102 = this.f31918b;
        if (r101 >= r102.length) goto L6;
        r102[r101] = -1;
        r101 = r101 + 1;
    L6:
        byte[] r103 = this.f31917a;
        if (r100 >= r103.length) goto L9;
        this.f31918b[r103[r100]] = (byte) r100;
        r100 = r100 + 1;
        goto L6
    }
}
