package com.bytedance.android.gamecp.business.downloadview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f52994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f52995b;

    public a() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f52994a, r101.f52994a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f52995b, r101.f52995b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        h r100 = this.f52994a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e r104 = this.f52995b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DownloadAnimTipInfo(text=" + this.f52994a + ", icon=" + this.f52995b + ")";
    }

    public a(h r100, e r101) {
        this.f52994a = r100;
        this.f52995b = r101;
    }
}
