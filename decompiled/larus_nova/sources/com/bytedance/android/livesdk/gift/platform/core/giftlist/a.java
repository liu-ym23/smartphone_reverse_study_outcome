package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public py.k f130580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.platform.core.model.g f130581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<com.bytedance.android.livesdk.gift.platform.core.model.e> f130582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.platform.core.model.m f130583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.platform.core.model.d f130584e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f130580a, r101.f130580a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f130581b, r101.f130581b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f130582c, r101.f130582c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f130583d, r101.f130583d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f130584e, r101.f130584e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        py.k r100 = this.f130580a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.g r104 = this.f130581b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<com.bytedance.android.livesdk.gift.platform.core.model.e> r107 = this.f130582c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.m r110 = this.f130583d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        com.bytedance.android.livesdk.gift.platform.core.model.d r113 = this.f130584e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftInfoCacheModel(giftEntranceIcon=" + this.f130580a + ", mExtraParam=" + this.f130581b + ", giftComboInfoList=" + this.f130582c + ", giftSearchConfig=" + this.f130583d + ", giftAgentConfig=" + this.f130584e + ")";
    }

    public a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "giftComboInfoList");
        this.f130580a = null;
        this.f130581b = null;
        this.f130582c = r100;
        this.f130583d = null;
        this.f130584e = null;
    }
}
