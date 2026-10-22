package com.bytedance.android.shopping.store.hybrid.download;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f184843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f184844b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f184843a, r101.f184843a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f184844b, r101.f184844b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f184843a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f184844b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PreDownloadInfoEntity(cdnUrl=" + this.f184843a + ", version=" + this.f184844b + ")";
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cdnUrl");
        Intrinsics.checkNotNullParameter(r101, "version");
        this.f184843a = r100;
        this.f184844b = r101;
    }
}
