package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

/* JADX INFO: loaded from: classes10.dex */
public final class x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f145575d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f145576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f145577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f145578c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L12;
        x r101 = (x) r100;
        if (this.f145576a == r101.f145576a) goto L8;
        return false;
    L8:
        if (this.f145577b == r101.f145577b) goto L10;
        return false;
    L10:
        if (this.f145578c == r101.f145578c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f145576a * 31) + this.f145577b) * 31;
        long r101 = this.f145578c;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "SinghotInfo(status=" + this.f145576a + ", level=" + this.f145577b + ", hot=" + this.f145578c + ")";
    }

    public x(int r100, int r101, long r102) {
        this.f145576a = r100;
        this.f145577b = r101;
        this.f145578c = r102;
    }
}
