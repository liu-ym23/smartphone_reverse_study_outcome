package com.bytedance.android.livesdk.chatroom.ui;

/* JADX INFO: loaded from: classes8.dex */
public final class f9 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f112776e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f112777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f112778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f112779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f112780d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f9) == false) goto L14;
        f9 r101 = (f9) r100;
        if (Float.compare(this.f112777a, r101.f112777a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f112778b, r101.f112778b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f112779c, r101.f112779c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f112780d, r101.f112780d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f112777a) * 31) + Float.floatToIntBits(this.f112778b)) * 31) + Float.floatToIntBits(this.f112779c)) * 31) + Float.floatToIntBits(this.f112780d);
    }

    public final String toString() {
        return "SandwichBorderInfo(top=" + this.f112777a + ", bottom=" + this.f112778b + ", left=" + this.f112779c + ", right=" + this.f112780d + ')';
    }

    public f9(float r100, float r101, float r102, float r103) {
        this.f112777a = r100;
        this.f112778b = r101;
        this.f112779c = r102;
        this.f112780d = r103;
    }
}
