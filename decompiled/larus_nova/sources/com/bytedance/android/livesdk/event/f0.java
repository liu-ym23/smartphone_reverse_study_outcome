package com.bytedance.android.livesdk.event;

/* JADX INFO: loaded from: classes8.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f123345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f123346b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L10;
        f0 r101 = (f0) r100;
        if (this.f123345a == r101.f123345a) goto L8;
        return false;
    L8:
        if (this.f123346b == r101.f123346b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f123345a * 31) + this.f123346b;
    }

    public final String toString() {
        return "SetRoomInfoBannerSizeEvent(width=" + this.f123345a + ", height=" + this.f123346b + ")";
    }

    public f0(int r100, int r101) {
        this.f123345a = r100;
        this.f123346b = r101;
    }
}
