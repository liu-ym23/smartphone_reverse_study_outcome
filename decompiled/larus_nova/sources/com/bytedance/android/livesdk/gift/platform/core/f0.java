package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: classes9.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f130519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f130520b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L10;
        f0 r101 = (f0) r100;
        if (this.f130519a == r101.f130519a) goto L8;
        return false;
    L8:
        if (this.f130520b == r101.f130520b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f130519a * 31) + this.f130520b;
    }

    public final String toString() {
        return "RowLocation(startRowLocation=" + this.f130519a + ", endRowLocation=" + this.f130520b + ")";
    }

    public f0(int r100, int r101) {
        this.f130519a = r100;
        this.f130520b = r101;
    }
}
