package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f133386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f133387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f133388c;

    public k() {
        this(0, 0, 7);
    }

    public final String toString() {
        return "WidthInfo(width=" + this.f133386a + ", leftMargin=" + this.f133387b + ", rightMargin=" + this.f133388c + ')';
    }

    public k(int r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = -10086;
    L6:
        if ((r102 & 2) == 0) goto L8;
        int r103 = -10086;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = -10086;
    L12:
        this.f133386a = r100;
        this.f133387b = r103;
        this.f133388c = r101;
        return;
    L8:
        r103 = 0;
        goto L10
    }
}
