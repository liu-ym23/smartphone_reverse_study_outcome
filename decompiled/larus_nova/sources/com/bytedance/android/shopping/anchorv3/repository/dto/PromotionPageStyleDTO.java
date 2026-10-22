package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001(BK\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JM\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b!\u0010\u001fR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPageStyleDTO;", "Ljava/io/Serializable;", "", "component1", "component2", "", "component3", "component4", "component5", "", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/ConfirmOrderUrl;", "component6", "detailPageTagShow", "detailPageStatsShow", "detailPageTagMax", "commentPageTagMax", "confirmOrderStyle", "confirmOrderUrl", "copy", "", "toString", "hashCode", "", "other", "equals", "Z", "getDetailPageTagShow", "()Z", "getDetailPageStatsShow", "I", "getDetailPageTagMax", "()I", "getCommentPageTagMax", "getConfirmOrderStyle", "Ljava/util/List;", "getConfirmOrderUrl", "()Ljava/util/List;", "<init>", "(ZZIIILjava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionPageStyleDTO implements Serializable {
    public static final int CONFIRM_ORDER_STYLE_ANCHOR_V5 = 3;
    public static final int CONFIRM_ORDER_STYLE_NATIVE_ANCHOR_V3 = 1;
    public static final int CONFIRM_ORDER_STYLE_SHORT_URL = 2;
    public static final a Companion = null;

    @SerializedName("comment_page_tag_max")
    private final int commentPageTagMax;

    @SerializedName("confirm_order_style")
    private final int confirmOrderStyle;

    @SerializedName("confirm_order_short_url")
    private final List<ConfirmOrderUrl> confirmOrderUrl;

    @SerializedName("detail_page_stats_show")
    private final boolean detailPageStatsShow;

    @SerializedName("detail_page_tag_max")
    private final int detailPageTagMax;

    @SerializedName("detail_page_tag_show")
    private final boolean detailPageTagShow;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionPageStyleDTO() {
        this(false, false, 0, 0, 0, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionPageStyleDTO copy$default(PromotionPageStyleDTO r100, boolean r101, boolean r102, int r103, int r104, int r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.detailPageTagShow;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.detailPageStatsShow;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.detailPageTagMax;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.commentPageTagMax;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.confirmOrderStyle;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.confirmOrderUrl;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.detailPageTagShow;
    }

    public final boolean component2() {
        return this.detailPageStatsShow;
    }

    public final int component3() {
        return this.detailPageTagMax;
    }

    public final int component4() {
        return this.commentPageTagMax;
    }

    public final int component5() {
        return this.confirmOrderStyle;
    }

    public final List<ConfirmOrderUrl> component6() {
        return this.confirmOrderUrl;
    }

    public final PromotionPageStyleDTO copy(boolean r100, boolean r110, int r111, int r112, int r113, List<ConfirmOrderUrl> r114) {
        return new PromotionPageStyleDTO(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionPageStyleDTO) == false) goto L18;
        PromotionPageStyleDTO r101 = (PromotionPageStyleDTO) r100;
        if (this.detailPageTagShow == r101.detailPageTagShow) goto L8;
        return false;
    L8:
        if (this.detailPageStatsShow == r101.detailPageStatsShow) goto L10;
        return false;
    L10:
        if (this.detailPageTagMax == r101.detailPageTagMax) goto L12;
        return false;
    L12:
        if (this.commentPageTagMax == r101.commentPageTagMax) goto L14;
        return false;
    L14:
        if (this.confirmOrderStyle == r101.confirmOrderStyle) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.confirmOrderUrl, r101.confirmOrderUrl) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        boolean r100 = this.detailPageTagShow;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.detailPageStatsShow;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (((((((r103 + r101) * 31) + this.detailPageTagMax) * 31) + this.commentPageTagMax) * 31) + this.confirmOrderStyle) * 31;
        List<ConfirmOrderUrl> r106 = this.confirmOrderUrl;
        if (r106 == null) goto L12;
        int r107 = r106.hashCode();
    L14:
        return r105 + r107;
    L12:
        r107 = 0;
        goto L14
    }

    public String toString() {
        return "PromotionPageStyleDTO(detailPageTagShow=" + this.detailPageTagShow + ", detailPageStatsShow=" + this.detailPageStatsShow + ", detailPageTagMax=" + this.detailPageTagMax + ", commentPageTagMax=" + this.commentPageTagMax + ", confirmOrderStyle=" + this.confirmOrderStyle + ", confirmOrderUrl=" + this.confirmOrderUrl + ")";
    }

    public final int getCommentPageTagMax() {
        return this.commentPageTagMax;
    }

    public final int getConfirmOrderStyle() {
        return this.confirmOrderStyle;
    }

    public final List<ConfirmOrderUrl> getConfirmOrderUrl() {
        return this.confirmOrderUrl;
    }

    public final boolean getDetailPageStatsShow() {
        return this.detailPageStatsShow;
    }

    public final int getDetailPageTagMax() {
        return this.detailPageTagMax;
    }

    public final boolean getDetailPageTagShow() {
        return this.detailPageTagShow;
    }

    public PromotionPageStyleDTO(boolean r100, boolean r101, int r102, int r103, int r104, List<ConfirmOrderUrl> r105) {
        this.detailPageTagShow = r100;
        this.detailPageStatsShow = r101;
        this.detailPageTagMax = r102;
        this.commentPageTagMax = r103;
        this.confirmOrderStyle = r104;
        this.confirmOrderUrl = r105;
    }

    public /* synthetic */ PromotionPageStyleDTO(boolean r100, boolean r101, int r102, int r103, int r104, List r110, int r111, DefaultConstructorMarker r112) {
        int r105 = 0;
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = false;
    L7:
        if ((r111 & 2) == 0) goto L9;
        boolean r106 = true;
    L11:
        if ((r111 & 4) == 0) goto L13;
        int r107 = 3;
    L15:
        if ((r111 & 8) == 0) goto L17;
        int r108 = 0;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = null;
    L25:
        List r114 = r110;
        this(r113, r106, r107, r108, r105, r114);
        return;
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
