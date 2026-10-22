package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.model.n f127476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vz1.i f127477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f127478c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p0) == false) goto L12;
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.f127476a, r101.f127476a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f127477b, r101.f127477b) == true) goto L10;
        return false;
    L10:
        if (this.f127478c == r101.f127478c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.livesdk.gift.model.n r100 = this.f127476a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        vz1.i r104 = this.f127477b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f127478c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VMDIYInfo(diyInfo=" + this.f127476a + ", showImageInfo=" + this.f127477b + ", originId=" + this.f127478c + ")";
    }

    public final com.bytedance.android.livesdk.gift.model.n a() {
        return this.f127476a;
    }

    public final long b() {
        return this.f127478c;
    }

    public final vz1.i c() {
        return this.f127477b;
    }

    public p0(com.bytedance.android.livesdk.gift.model.n r100, vz1.i r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "diyInfo");
        Intrinsics.checkNotNullParameter(r101, "showImageInfo");
        this.f127476a = r100;
        this.f127477b = r101;
        this.f127478c = r102;
    }
}
