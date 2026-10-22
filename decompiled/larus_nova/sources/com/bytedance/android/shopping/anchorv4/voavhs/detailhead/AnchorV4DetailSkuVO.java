package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.ec.model.ECUrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JS\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;", "Ljava/io/Serializable;", "jumpUrl", "", "skuId", "name", "pic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "showBottomView", "", "subProducts", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4SubProduct;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;ZLjava/util/List;)V", "getJumpUrl", "()Ljava/lang/String;", "getName", "getPic", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getShowBottomView", "()Z", "getSkuId", "getSubProducts", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailSkuVO implements Serializable {
    private final String jumpUrl;
    private final String name;

    /* JADX INFO: renamed from: pic, reason: collision with root package name */
    private final ECUrlModel f168193pic;
    private final boolean showBottomView;
    private final String skuId;
    private final List<AnchorV4SubProduct> subProducts;

    public AnchorV4DetailSkuVO() {
        this(null, null, null, null, false, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4DetailSkuVO copy$default(AnchorV4DetailSkuVO r100, String r101, String r102, String r103, ECUrlModel r104, boolean r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.jumpUrl;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.skuId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.name;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.f168193pic;
    L14:
        ECUrlModel r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.showBottomView;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.subProducts;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.jumpUrl;
    }

    public final String component2() {
        return this.skuId;
    }

    public final String component3() {
        return this.name;
    }

    public final ECUrlModel component4() {
        return this.f168193pic;
    }

    public final boolean component5() {
        return this.showBottomView;
    }

    public final List<AnchorV4SubProduct> component6() {
        return this.subProducts;
    }

    public final AnchorV4DetailSkuVO copy(String r100, String r110, String r111, ECUrlModel r112, boolean r113, List<AnchorV4SubProduct> r114) {
        Intrinsics.checkNotNullParameter(r114, "subProducts");
        return new AnchorV4DetailSkuVO(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4DetailSkuVO) == false) goto L18;
        AnchorV4DetailSkuVO r101 = (AnchorV4DetailSkuVO) r100;
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f168193pic, r101.f168193pic) == true) goto L14;
        return false;
    L14:
        if (this.showBottomView == r101.showBottomView) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.subProducts, r101.subProducts) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public int hashCode() {
        String r100 = this.jumpUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.skuId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECUrlModel r110 = this.f168193pic;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.showBottomView;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        int r115 = (r112 + r114) * 31;
        List<AnchorV4SubProduct> r116 = this.subProducts;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
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

    public String toString() {
        return "AnchorV4DetailSkuVO(jumpUrl=" + this.jumpUrl + ", skuId=" + this.skuId + ", name=" + this.name + ", pic=" + this.f168193pic + ", showBottomView=" + this.showBottomView + ", subProducts=" + this.subProducts + ")";
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final ECUrlModel getPic() {
        return this.f168193pic;
    }

    public final boolean getShowBottomView() {
        return this.showBottomView;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final List<AnchorV4SubProduct> getSubProducts() {
        return this.subProducts;
    }

    public AnchorV4DetailSkuVO(String r100, String r101, String r102, ECUrlModel r103, boolean r104, List<AnchorV4SubProduct> r105) {
        Intrinsics.checkNotNullParameter(r105, "subProducts");
        this.jumpUrl = r100;
        this.skuId = r101;
        this.name = r102;
        this.f168193pic = r103;
        this.showBottomView = r104;
        this.subProducts = r105;
    }

    public /* synthetic */ AnchorV4DetailSkuVO(String r100, String r101, String r102, ECUrlModel r103, boolean r104, List r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) != 0) goto L11;
        r105 = r101;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        ECUrlModel r107 = null;
    L19:
        if ((r111 & 16) == 0) goto L21;
        boolean r108 = false;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = CollectionsKt.emptyList();
    L25:
        this(r113, r105, r106, r107, r108, r110);
        return;
    L21:
        r108 = r104;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L5:
        r113 = r100;
        goto L7
    }
}
