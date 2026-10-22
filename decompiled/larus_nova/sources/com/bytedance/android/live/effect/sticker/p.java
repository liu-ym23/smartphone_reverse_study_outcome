package com.bytedance.android.live.effect.sticker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f68214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f68215c;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L12;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f68213a, r101.f68213a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f68214b, r101.f68214b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f68215c, r101.f68215c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f68213a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f68214b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f68215c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StickerPanelExtraInfo(liveSearchTips=" + this.f68213a + ", liveSearchRecommend=" + this.f68214b + ", liveRecommendTips=" + this.f68215c + ")";
    }

    public /* synthetic */ p(int r100) {
        this("", CollectionsKt.emptyList(), "");
    }

    public p(String r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "liveSearchTips");
        Intrinsics.checkNotNullParameter(r101, "liveSearchRecommend");
        Intrinsics.checkNotNullParameter(r102, "liveRecommendTips");
        this.f68213a = r100;
        this.f68214b = r101;
        this.f68215c = r102;
    }
}
