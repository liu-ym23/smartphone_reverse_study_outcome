package com.bytedance.android.shopping.deepfeed.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f173994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f173995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f173996c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (this.f173994a == r101.f173994a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173995b, r101.f173995b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f173996c, r101.f173996c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f173994a * 31;
        String r101 = this.f173995b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f173996c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedPitayaAutoSlideEvent(result=" + this.f173994a + ", productId=" + this.f173995b + ", message=" + this.f173996c + ")";
    }

    public d(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "message");
        this.f173994a = r100;
        this.f173995b = r101;
        this.f173996c = r102;
    }
}
