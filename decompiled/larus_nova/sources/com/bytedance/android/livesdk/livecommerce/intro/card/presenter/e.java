package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntroAuctionAtmosphereState f147887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IntroAtmosphere f147888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f147889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f147890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IntroProduct f147891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ECPromotionAuctionInfo f147892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f147893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f147894h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L20;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f147888b, r101.f147888b) == true) goto L8;
        return false;
    L8:
        if (this.f147889c == r101.f147889c) goto L10;
        return false;
    L10:
        if (this.f147890d == r101.f147890d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f147891e, r101.f147891e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f147892f, r101.f147892f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f147893g, r101.f147893g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f147894h, r101.f147894h) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        IntroAtmosphere r100 = this.f147888b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f147889c) * 31) + this.f147890d) * 31;
        IntroProduct r104 = this.f147891e;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECPromotionAuctionInfo r107 = this.f147892f;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f147893g;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f147894h;
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
        return "IntroAtmosphereModel(introAtmosphere=" + this.f147888b + ", productType=" + this.f147889c + ", industryType=" + this.f147890d + ", product=" + this.f147891e + ", auctionInfo=" + this.f147892f + ", roomId=" + this.f147893g + ", roomUniqueKey=" + this.f147894h + ")";
    }

    public e() {
        Intrinsics.checkNotNullParameter("", "roomId");
        Intrinsics.checkNotNullParameter("", "roomUniqueKey");
        this.f147888b = null;
        this.f147889c = 0;
        this.f147890d = 0;
        this.f147891e = null;
        this.f147892f = null;
        this.f147893g = "";
        this.f147894h = "";
        this.f147887a = new IntroAuctionAtmosphereState();
    }
}
