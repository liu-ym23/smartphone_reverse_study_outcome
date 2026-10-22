package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J?\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\u0010\u0010 \u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\"J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/LikeMeta;", "Ljava/io/Serializable;", "productId", "", "commissionInfo", "realPrice", "", "costPrice", "isLike", "", "(Ljava/lang/String;Ljava/lang/String;JJZ)V", "getCommissionInfo", "()Ljava/lang/String;", "setCommissionInfo", "(Ljava/lang/String;)V", "getCostPrice", "()J", "()Z", "setLike", "(Z)V", "getProductId", "setProductId", "getRealPrice", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "fillLikeMeta", "commonMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LikeMeta implements Serializable {
    private String commissionInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COST_PRICE)
    private final long costPrice;

    @SerializedName("is_liked")
    private boolean isLike;
    private String productId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REAL_PRICE)
    private final long realPrice;

    public LikeMeta() {
        this(null, null, 0, 0, false, 31, null);
    }

    public static /* synthetic */ LikeMeta copy$default(LikeMeta r100, String r101, String r102, long r103, long r110, boolean r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.productId;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.commissionInfo;
    L8:
        String r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.realPrice;
    L11:
        long r104 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.costPrice;
    L14:
        long r105 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.isLike;
    L17:
        String r106 = r101;
        return r100.copy(r106, r114, r104, r105, r111);
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.commissionInfo;
    }

    public final long component3() {
        return this.realPrice;
    }

    public final long component4() {
        return this.costPrice;
    }

    public final boolean component5() {
        return this.isLike;
    }

    public final LikeMeta copy(String r110, String r111, long r112, long r113, boolean r114) {
        return new LikeMeta(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LikeMeta) == false) goto L16;
        LikeMeta r101 = (LikeMeta) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commissionInfo, r101.commissionInfo) == true) goto L10;
        return false;
    L10:
        if (this.realPrice == r101.realPrice) goto L12;
        return false;
    L12:
        if (this.costPrice == r101.costPrice) goto L14;
        return false;
    L14:
        if (this.isLike == r101.isLike) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.commissionInfo;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.realPrice;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.costPrice;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        boolean r110 = this.isLike;
        ?? r111 = r110;
        if (r110 == false) goto L13;
        r111 = 1;
    L13:
        return r109 + r111;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LikeMeta(productId=" + this.productId + ", commissionInfo=" + this.commissionInfo + ", realPrice=" + this.realPrice + ", costPrice=" + this.costPrice + ", isLike=" + this.isLike + ")";
    }

    public final String getCommissionInfo() {
        return this.commissionInfo;
    }

    public final long getCostPrice() {
        return this.costPrice;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final long getRealPrice() {
        return this.realPrice;
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final LikeMeta fillLikeMeta(CommonMeta r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getProductId();
    L6:
        this.productId = r102;
        JSONObject r103 = new JSONObject(this.commissionInfo);
        if (r100 == null) goto L19;
        String r104 = r100.getEntranceInfo();
        if (r104 == null) goto L19;
        JSONObject r105 = com.bytedance.android.shopping.extensions.k.w(r104);
        if (r105 == null) goto L19;
        r103.put("ecom_scene_id", r105.optString("ecom_scene_id"));
        r103.put("promotion_id", r105.optString("promotion_id"));
        r103.put("author_id", r105.optString("anchor_id"));
        r103.put("room_id", r105.optString("room_id"));
        r103.put(AppConstants.BUNDLE_MEDIA_ID, r105.optString("group_id"));
        ECAdLogExtra r106 = r100.getAdLogExtra();
        if (r106 == null) goto L15;
        r101 = r106.getCreativeId();
    L15:
        r103.put("creative_id", r101);
        String r107 = r100.getSecAuthorId();
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        r103.put("sec_author_id", r107);
    L19:
        Unit r108 = Unit.INSTANCE;
        this.commissionInfo = r103.toString();
        return this;
    L5:
        r102 = null;
        goto L6
    }

    public final void setCommissionInfo(String r100) {
        this.commissionInfo = r100;
    }

    public final void setLike(boolean r100) {
        this.isLike = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public LikeMeta(String r100, String r101, long r102, long r103, boolean r104) {
        this.productId = r100;
        this.commissionInfo = r101;
        this.realPrice = r102;
        this.costPrice = r103;
        this.isLike = r104;
    }

    public /* synthetic */ LikeMeta(String r100, String r101, long r102, long r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r101 = SliceInitService.DEFAULT_SWITCH;
    L8:
        String r114 = r101;
        long r103 = 0;
        if ((r112 & 4) == 0) goto L11;
        long r104 = 0;
    L13:
        if ((r112 & 8) != 0) goto L17;
        r103 = r110;
    L17:
        if ((r112 & 16) == 0) goto L19;
        boolean r105 = false;
    L20:
        this(r100, r114, r104, r103, r105);
        return;
    L19:
        r105 = r111;
        goto L20
    L11:
        r104 = r102;
        goto L13
    }
}
