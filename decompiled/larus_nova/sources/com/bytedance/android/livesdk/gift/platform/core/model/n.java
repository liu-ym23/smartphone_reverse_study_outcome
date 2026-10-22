package com.bytedance.android.livesdk.gift.platform.core.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public py.k f130916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f130917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f130918c;

    public n() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f130916a, r101.f130916a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f130917b, r101.f130917b) == true) goto L10;
        return false;
    L10:
        if (this.f130918c == r101.f130918c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        py.k r100 = this.f130916a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f130917b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f130918c;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftShowInfo(icon=" + this.f130916a + ", giftName=" + this.f130917b + ", scrollCount=" + this.f130918c + ")";
    }

    public n(py.k r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f130916a = r100;
        this.f130917b = r101;
        this.f130918c = 0;
    }
}
