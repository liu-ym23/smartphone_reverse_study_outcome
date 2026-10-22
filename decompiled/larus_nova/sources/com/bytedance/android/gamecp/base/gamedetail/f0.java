package com.bytedance.android.gamecp.base.gamedetail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f51577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f51578b;

    public f0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L10;
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f51577a, r101.f51577a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f51578b, r101.f51578b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        b0 r100 = this.f51577a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e0 r104 = this.f51578b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DownloadItemUIStyle(downloadBtnStyle=" + this.f51577a + ", titleDownloadBtnStyle=" + this.f51578b + ")";
    }

    public /* synthetic */ f0(int r110) {
        this(new b0(0, 0, 0, 0, 127), new e0(0, 0, 0, 0, 127));
    }

    public f0(b0 r100, e0 r101) {
        Intrinsics.checkNotNullParameter(r100, "downloadBtnStyle");
        Intrinsics.checkNotNullParameter(r101, "titleDownloadBtnStyle");
        this.f51577a = r100;
        this.f51578b = r101;
    }
}
