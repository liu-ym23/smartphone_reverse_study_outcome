package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jc\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\u0010\u00103\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u000105J\t\u00106\u001a\u00020\u0005HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u001fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015¨\u00068"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/EnterCartMeta;", "Ljava/io/Serializable;", "cartUrl", "", "firstCount", "", "trackParamsJStr", "isLuban", "", "productId", "promotionSource", "", "searchId", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;JLjava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "setAdLogExtra", "(Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "getCartUrl", "()Ljava/lang/String;", "getFirstCount", "()I", "setFirstCount", "(I)V", "()Z", "setLuban", "(Z)V", "getProductId", "setProductId", "(Ljava/lang/String;)V", "getPromotionSource", "()J", "setPromotionSource", "(J)V", "getSearchId", "setSearchId", "getTrackParamsJStr", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "fillCommonMeta", "commonMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterCartMeta implements Serializable {
    private ECAdLogExtra adLogExtra;

    @SerializedName("cart_url")
    private final String cartUrl;

    @SerializedName("first_count")
    private int firstCount;
    private boolean isLuban;
    private String productId;
    private long promotionSource;
    private String searchId;

    @SerializedName("track_params")
    private final String trackParamsJStr;

    public EnterCartMeta() {
        this(null, 0, null, false, null, 0, null, null, 255, null);
    }

    public static /* synthetic */ EnterCartMeta copy$default(EnterCartMeta r110, String r111, int r112, String r113, boolean r114, String r115, long r116, String r117, ECAdLogExtra r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.cartUrl;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.firstCount;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.trackParamsJStr;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.isLuban;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.productId;
    L23:
        if ((r210 & 32) == 0) goto L25;
        long r105 = r110.promotionSource;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.searchId;
    L31:
        if ((r210 & 128) == 0) goto L33;
        ECAdLogExtra r107 = r110.adLogExtra;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.cartUrl;
    }

    public final int component2() {
        return this.firstCount;
    }

    public final String component3() {
        return this.trackParamsJStr;
    }

    public final boolean component4() {
        return this.isLuban;
    }

    public final String component5() {
        return this.productId;
    }

    public final long component6() {
        return this.promotionSource;
    }

    public final String component7() {
        return this.searchId;
    }

    public final ECAdLogExtra component8() {
        return this.adLogExtra;
    }

    public final EnterCartMeta copy(String r110, int r111, String r112, boolean r113, String r114, long r115, String r116, ECAdLogExtra r210) {
        return new EnterCartMeta(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EnterCartMeta) == false) goto L22;
        EnterCartMeta r101 = (EnterCartMeta) r100;
        if (Intrinsics.areEqual(this.cartUrl, r101.cartUrl) == true) goto L8;
        return false;
    L8:
        if (this.firstCount == r101.firstCount) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.trackParamsJStr, r101.trackParamsJStr) == true) goto L12;
        return false;
    L12:
        if (this.isLuban == r101.isLuban) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L16;
        return false;
    L16:
        if (this.promotionSource == r101.promotionSource) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.adLogExtra, r101.adLogExtra) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public int hashCode() {
        String r100 = this.cartUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.firstCount) * 31;
        String r104 = this.trackParamsJStr;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.isLuban;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.productId;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        long r113 = this.promotionSource;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        String r115 = this.searchId;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        ECAdLogExtra r118 = this.adLogExtra;
        if (r118 == null) goto L25;
        r101 = r118.hashCode();
    L25:
        return r117 + r101;
    L20:
        r116 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "EnterCartMeta(cartUrl=" + this.cartUrl + ", firstCount=" + this.firstCount + ", trackParamsJStr=" + this.trackParamsJStr + ", isLuban=" + this.isLuban + ", productId=" + this.productId + ", promotionSource=" + this.promotionSource + ", searchId=" + this.searchId + ", adLogExtra=" + this.adLogExtra + ")";
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getCartUrl() {
        return this.cartUrl;
    }

    public final int getFirstCount() {
        return this.firstCount;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getTrackParamsJStr() {
        return this.trackParamsJStr;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final EnterCartMeta fillCommonMeta(CommonMeta r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Long r102 = Long.valueOf(r100.getPromotionSource());
    L6:
        this.promotionSource = com.bytedance.android.shopping.extensions.k.h(r102);
        if (r100 == null) goto L9;
        String r103 = r100.getSearchId();
    L10:
        this.searchId = r103;
        if (r100 == null) goto L13;
        ECAdLogExtra r104 = r100.getAdLogExtra();
    L14:
        this.adLogExtra = r104;
        if (r100 == null) goto L17;
        Boolean r105 = Boolean.valueOf(r100.isLuban());
    L18:
        this.isLuban = com.bytedance.android.shopping.extensions.k.i(r105);
        if (r100 == null) goto L21;
        r101 = r100.getProductId();
    L21:
        this.productId = r101;
        return this;
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setAdLogExtra(ECAdLogExtra r100) {
        this.adLogExtra = r100;
    }

    public final void setFirstCount(int r100) {
        this.firstCount = r100;
    }

    public final void setLuban(boolean r100) {
        this.isLuban = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setPromotionSource(long r100) {
        this.promotionSource = r100;
    }

    public final void setSearchId(String r100) {
        this.searchId = r100;
    }

    public EnterCartMeta(String r100, int r101, String r102, boolean r103, String r104, long r105, String r106, ECAdLogExtra r107) {
        this.cartUrl = r100;
        this.firstCount = r101;
        this.trackParamsJStr = r102;
        this.isLuban = r103;
        this.productId = r104;
        this.promotionSource = r105;
        this.searchId = r106;
        this.adLogExtra = r107;
    }

    public /* synthetic */ EnterCartMeta(String r110, int r111, String r112, boolean r113, String r114, long r115, String r116, ECAdLogExtra r117, int r210, DefaultConstructorMarker r211) {
        ECAdLogExtra r100 = null;
        if ((r210 & 1) == 0) goto L5;
        String r101 = null;
    L6:
        boolean r102 = false;
        if ((r210 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r210 & 8) != 0) goto L19;
        r102 = r113;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        long r106 = 0;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r103, r104, r102, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
