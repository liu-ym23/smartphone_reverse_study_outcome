package com.bytedanceos.common.ktx.e2e;

/* JADX INFO: loaded from: classes2.dex */
public final class InitialPadding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9834d;

    public InitialPadding(int r10, int r11, int r12, int r13) {
        this.f9831a = r10;
        this.f9832b = r11;
        this.f9833c = r12;
        this.f9834d = r13;
    }

    public final int a() {
        return this.f9834d;
    }

    public final int b() {
        return this.f9831a;
    }

    public final int c() {
        return this.f9833c;
    }

    public final int d() {
        return this.f9832b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof InitialPadding) == true) goto L8;
        return false;
    L8:
        InitialPadding r11 = (InitialPadding) r10;
        if (this.f9831a == r11.f9831a) goto L12;
        return false;
    L12:
        if (this.f9832b == r11.f9832b) goto L15;
        return false;
    L15:
        if (this.f9833c == r11.f9833c) goto L18;
        return false;
    L18:
        if (this.f9834d == r11.f9834d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f9831a) * 31) + Integer.hashCode(this.f9832b)) * 31) + Integer.hashCode(this.f9833c)) * 31) + Integer.hashCode(this.f9834d);
    }

    public String toString() {
        return "InitialPadding(left=" + this.f9831a + ", top=" + this.f9832b + ", right=" + this.f9833c + ", bottom=" + this.f9834d + ')';
    }
}
