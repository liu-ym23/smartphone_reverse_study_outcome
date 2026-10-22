package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesComponent;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailTagCard;
import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormatGroup;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends VOIdentifier {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f168217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ProductFormatGroup> f168218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h53.a f168219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v63.b f168220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DetailCombinePropertiesComponent f168221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f168222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DetailTagCard f168223h;

    public d() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f168217b, r101.f168217b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f168218c, r101.f168218c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f168219d, r101.f168219d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f168220e, r101.f168220e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f168221f, r101.f168221f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f168222g, r101.f168222g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f168223h, r101.f168223h) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.f168217b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ProductFormatGroup> r104 = this.f168218c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        h53.a r107 = this.f168219d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        v63.b r110 = this.f168220e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        DetailCombinePropertiesComponent r113 = this.f168221f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f168222g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        DetailTagCard r119 = this.f168223h;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "AnchorV4DetailHeadVO(headerImage=" + this.f168217b + ", productFormatGroup=" + this.f168218c + ", categoryStyle=" + this.f168219d + ", detailTopTagComponent=" + this.f168220e + ", combineProperties=" + this.f168221f + ", jumpUrl=" + this.f168222g + ", tagCard=" + this.f168223h + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        return ComponentIDs.DETAIL_HEAD.getId();
    }

    public d(ECUrlModel r100, List r101, v63.b r102, DetailCombinePropertiesComponent r103, String r104, DetailTagCard r105, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = CollectionsKt.emptyList();
    L9:
        if ((r110 & 4) == 0) goto L11;
        h53.a.C6101a r106 = h53.a.C6101a.f483874a;
    L13:
        if ((r110 & 8) == 0) goto L16;
        r102 = null;
    L16:
        if ((r110 & 16) == 0) goto L19;
        r103 = null;
    L19:
        if ((r110 & 32) == 0) goto L22;
        r104 = null;
    L22:
        if ((r110 & 64) == 0) goto L24;
        r105 = null;
    L24:
        Intrinsics.checkNotNullParameter(r101, "productFormatGroup");
        Intrinsics.checkNotNullParameter(r106, "categoryStyle");
        this.f168217b = r100;
        this.f168218c = r101;
        this.f168219d = r106;
        this.f168220e = r102;
        this.f168221f = r103;
        this.f168222g = r104;
        this.f168223h = r105;
        scrollConfig("id_detail", AnchorV4TabArea.f167089j);
        return;
    L11:
        r106 = null;
        goto L13
    }
}
