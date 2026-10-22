package com.bytedance.android.shopping.anchorv4.voavhs;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f168384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f168385b;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f168384a, r101.f168384a) == true) goto L8;
        return false;
    L8:
        if (this.f168385b == r101.f168385b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f168384a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f168385b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "ScrollConfig(scrollId=" + this.f168384a + ", scrollAmount=" + this.f168385b + ")";
    }

    public h(int r100) {
        Intrinsics.checkNotNullParameter("default", "scrollId");
        this.f168384a = "default";
        this.f168385b = 0;
    }
}
