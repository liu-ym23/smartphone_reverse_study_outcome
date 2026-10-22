package com.bytedance.android.shopping.deepfeed.viewmodel;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductView;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InFeedProductV2 f173997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DeepFeedProductView f173998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f173999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f174000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECUrlModel f174001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f174002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f174003g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f174004h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L22;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f173997a, r101.f173997a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173998b, r101.f173998b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f173999c, r101.f173999c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f174000d, r101.f174000d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f174001e, r101.f174001e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f174002f, r101.f174002f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f174003g, r101.f174003g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f174004h, r101.f174004h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        InFeedProductV2 r100 = this.f173997a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        DeepFeedProductView r104 = this.f173998b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f173999c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f174000d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECUrlModel r113 = this.f174001e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f174002f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f174003g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f174004h;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "DeepFeedShopStatus(bindData=" + this.f173997a + ", view=" + this.f173998b + ", btmEnterStore=" + this.f173999c + ", productTagsList=" + this.f174000d + ", shopLogo=" + this.f174001e + ", shopDanceLogo=" + this.f174002f + ", danceLink=" + this.f174003g + ", shopName=" + this.f174004h + ")";
    }

    public e(InFeedProductV2 r100, DeepFeedProductView r101, String r102, List<String> r103, ECUrlModel r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, "productTagsList");
        this.f173997a = r100;
        this.f173998b = r101;
        this.f173999c = r102;
        this.f174000d = r103;
        this.f174001e = r104;
        this.f174002f = r105;
        this.f174003g = r106;
        this.f174004h = r107;
    }
}
