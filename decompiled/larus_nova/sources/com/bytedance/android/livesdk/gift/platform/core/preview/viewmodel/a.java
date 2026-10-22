package com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.gift.platform.core.preview.b> f131127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.gift.platform.core.preview.b> f131128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f131129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Long> f131130d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f131127a, r101.f131127a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f131128b, r101.f131128b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f131129c, r101.f131129c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f131130d, r101.f131130d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r100 = this.f131127a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r104 = this.f131128b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<Long> r107 = this.f131129c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<Long> r110 = this.f131130d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "UgcGiftData(saleList=" + this.f131127a + ", poolList=" + this.f131128b + ", topList=" + this.f131129c + ", dislikeList=" + this.f131130d + ")";
    }

    public a(List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r100, List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r101, List<Long> r102, List<Long> r103) {
        Intrinsics.checkNotNullParameter(r100, "saleList");
        Intrinsics.checkNotNullParameter(r101, "poolList");
        Intrinsics.checkNotNullParameter(r102, "topList");
        Intrinsics.checkNotNullParameter(r103, "dislikeList");
        this.f131127a = r100;
        this.f131128b = r101;
        this.f131129c = r102;
        this.f131130d = r103;
    }
}
