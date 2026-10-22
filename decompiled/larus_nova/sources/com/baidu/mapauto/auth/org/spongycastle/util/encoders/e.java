package com.baidu.mapauto.auth.org.spongycastle.util.encoders;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f31922b;

    public e() {
        this.f31921a = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        this.f31922b = new byte[128];
        a();
    }

    public final void a() {
        int r100 = 0;
        int r101 = 0;
    L3:
        byte[] r102 = this.f31922b;
        if (r101 >= r102.length) goto L6;
        r102[r101] = -1;
        r101 = r101 + 1;
    L6:
        byte[] r103 = this.f31921a;
        if (r100 >= r103.length) goto L9;
        this.f31922b[r103[r100]] = (byte) r100;
        r100 = r100 + 1;
        goto L6
    L9:
        byte[] r104 = this.f31922b;
        r104[65] = r104[97];
        r104[66] = r104[98];
        r104[67] = r104[99];
        r104[68] = r104[100];
        r104[69] = r104[101(0x65, float:1.42E-43)];
        r104[70] = r104[102(0x66, float:1.43E-43)];
    }
}
