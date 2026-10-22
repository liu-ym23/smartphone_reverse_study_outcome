package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.core.resources.e f131621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f131622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f131623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.effect.assets.a f131624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f131625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f131626f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L18;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f131621a, r101.f131621a) == true) goto L8;
        return false;
    L8:
        if (this.f131622b == r101.f131622b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f131623c, r101.f131623c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f131624d, r101.f131624d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f131625e, r101.f131625e) == true) goto L16;
        return false;
    L16:
        if (this.f131626f == r101.f131626f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.core.resources.e r100 = this.f131621a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f131622b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f131623c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.a r108 = this.f131624d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f131625e;
        if (r111 == null) goto L17;
        r101 = r111.hashCode();
    L17:
        int r112 = (r110 + r101) * 31;
        long r113 = this.f131626f;
        return r112 + ((int) (r113 ^ (r113 >>> 32)));
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeleteAssetData(assetsModel=" + this.f131621a + ", assetId=" + this.f131622b + ", md5=" + this.f131623c + ", assetsMd5Model=" + this.f131624d + ", filePath=" + this.f131625e + ", interval=" + this.f131626f + ")";
    }

    public l(long r100, String r101, com.bytedance.android.livesdk.gift.platform.business.effect.assets.a r102, String r103, long r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r111 & 8) == 0) goto L9;
        r102 = null;
    L9:
        if ((r111 & 16) == 0) goto L12;
        r103 = "";
    L12:
        if ((r111 & 32) == 0) goto L14;
        r110 = 0;
    L14:
        Intrinsics.checkNotNullParameter(r101, "md5");
        Intrinsics.checkNotNullParameter(r103, "filePath");
        this.f131621a = null;
        this.f131622b = r100;
        this.f131623c = r101;
        this.f131624d = r102;
        this.f131625e = r103;
        this.f131626f = r110;
    }
}
