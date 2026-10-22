package com.bytedance.android.anniex.detect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f40701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40702b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f40701a == r101.f40701a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f40702b, r101.f40702b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f40701a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f40702b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SnapShotResult(isSuccess=" + this.f40701a + ", errorMsg=" + this.f40702b + ')';
    }

    public k(boolean r100, String r101) {
        this.f40701a = r100;
        this.f40702b = r101;
    }
}
