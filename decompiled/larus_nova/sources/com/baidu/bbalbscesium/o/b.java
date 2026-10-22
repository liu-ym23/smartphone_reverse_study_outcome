package com.baidu.bbalbscesium.o;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f30417a;

    public b() {
        this(0);
    }

    public b(long r100) {
        this.f30417a = r100;
    }

    public long a() {
        return this.f30417a;
    }

    public long a(long r100) {
        return r100 & this.f30417a;
    }

    public boolean a(long r100, long r101) {
        long r102 = this.f30417a;
        long r103 = r100 & r101;
        long r104 = r103 | ((~r101) & r102);
        this.f30417a = r104;
        if ((r104 ^ r102) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void b(long r100) {
        this.f30417a = r100;
    }
}
