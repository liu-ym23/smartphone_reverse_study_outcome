package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.shopping.anchorv4.bottom.CollectMeta;
import com.bytedance.android.shopping.anchorv4.bottom.LikeMeta;
import com.bytedance.android.shopping.anchorv4.bottom.SkuMeta;
import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0016J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00104\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0098\u0001\u00106\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u000eHÖ\u0001J\t\u0010<\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u000b\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006="}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BaseInfoBusinessMeta;", "Ljava/io/Serializable;", "bannerMetaList", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BannerMeta;", "rankUrl", "", "aboardInfo", "taxDesc", "skuMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;", "isPreselected", "", "termCount", "", IStrategyStateSupplier.KEY_INFO_LIKE, "Lcom/bytedance/android/shopping/anchorv4/bottom/LikeMeta;", ShareChannel.COLLECT, "Lcom/bytedance/android/shopping/anchorv4/bottom/CollectMeta;", "share", "Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;", "windowUrl", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/bottom/LikeMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/CollectMeta;Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;Ljava/lang/String;)V", "getAboardInfo", "()Ljava/lang/String;", "getBannerMetaList", "()Ljava/util/List;", "getCollect", "()Lcom/bytedance/android/shopping/anchorv4/bottom/CollectMeta;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLike", "()Lcom/bytedance/android/shopping/anchorv4/bottom/LikeMeta;", "getRankUrl", "getShare", "()Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;", "getSkuMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;", "getTaxDesc", "getTermCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWindowUrl", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/bottom/LikeMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/CollectMeta;Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BaseInfoBusinessMeta;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4BaseInfoBusinessMeta implements Serializable {

    @SerializedName("aboard_info")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String aboardInfo;

    @SerializedName("banner_meta_list")
    private final List<AnchorV4BannerMeta> bannerMetaList;

    @SerializedName(ShareChannel.COLLECT)
    private final CollectMeta collect;

    @SerializedName("is_preselected")
    private final Boolean isPreselected;

    @SerializedName(IStrategyStateSupplier.KEY_INFO_LIKE)
    private final LikeMeta like;

    @SerializedName("rank_url")
    private final String rankUrl;

    @SerializedName("share")
    private final ShareMeta share;

    @SerializedName(PageMetaMappedMap.SKU_META_KEY)
    private final SkuMeta skuMeta;

    @SerializedName("tax_desc")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String taxDesc;

    @SerializedName("term_count")
    private final Integer termCount;

    @SerializedName("window_url")
    private final String windowUrl;

    public AnchorV4BaseInfoBusinessMeta() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4BaseInfoBusinessMeta copy$default(AnchorV4BaseInfoBusinessMeta r110, List r111, String r112, String r113, String r114, SkuMeta r115, Boolean r116, Integer r117, LikeMeta r210, CollectMeta r211, ShareMeta r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        List r100 = r110.bannerMetaList;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.rankUrl;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.aboardInfo;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.taxDesc;
    L19:
        if ((r214 & 16) == 0) goto L21;
        SkuMeta r104 = r110.skuMeta;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Boolean r105 = r110.isPreselected;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Integer r106 = r110.termCount;
    L31:
        if ((r214 & 128) == 0) goto L33;
        LikeMeta r107 = r110.like;
    L35:
        if ((r214 & 256) == 0) goto L37;
        CollectMeta r118 = r110.collect;
    L39:
        if ((r214 & 512) == 0) goto L41;
        ShareMeta r119 = r110.share;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.windowUrl;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
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

    public final List<AnchorV4BannerMeta> component1() {
        return this.bannerMetaList;
    }

    public final ShareMeta component10() {
        return this.share;
    }

    public final String component11() {
        return this.windowUrl;
    }

    public final String component2() {
        return this.rankUrl;
    }

    public final String component3() {
        return this.aboardInfo;
    }

    public final String component4() {
        return this.taxDesc;
    }

    public final SkuMeta component5() {
        return this.skuMeta;
    }

    public final Boolean component6() {
        return this.isPreselected;
    }

    public final Integer component7() {
        return this.termCount;
    }

    public final LikeMeta component8() {
        return this.like;
    }

    public final CollectMeta component9() {
        return this.collect;
    }

    public final AnchorV4BaseInfoBusinessMeta copy(List<AnchorV4BannerMeta> r110, String r111, String r112, String r113, SkuMeta r114, Boolean r115, Integer r210, LikeMeta r211, CollectMeta r212, ShareMeta r213, String r214) {
        return new AnchorV4BaseInfoBusinessMeta(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4BaseInfoBusinessMeta) == false) goto L28;
        AnchorV4BaseInfoBusinessMeta r101 = (AnchorV4BaseInfoBusinessMeta) r100;
        if (Intrinsics.areEqual(this.bannerMetaList, r101.bannerMetaList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rankUrl, r101.rankUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.aboardInfo, r101.aboardInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taxDesc, r101.taxDesc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.skuMeta, r101.skuMeta) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.isPreselected, r101.isPreselected) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.termCount, r101.termCount) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.like, r101.like) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.collect, r101.collect) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.share, r101.share) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.windowUrl, r101.windowUrl) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        List<AnchorV4BannerMeta> r100 = this.bannerMetaList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.rankUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.aboardInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.taxDesc;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        SkuMeta r113 = this.skuMeta;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isPreselected;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.termCount;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        LikeMeta r122 = this.like;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        CollectMeta r125 = this.collect;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        ShareMeta r128 = this.share;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.windowUrl;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
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

    public String toString() {
        return "AnchorV4BaseInfoBusinessMeta(bannerMetaList=" + this.bannerMetaList + ", rankUrl=" + this.rankUrl + ", aboardInfo=" + this.aboardInfo + ", taxDesc=" + this.taxDesc + ", skuMeta=" + this.skuMeta + ", isPreselected=" + this.isPreselected + ", termCount=" + this.termCount + ", like=" + this.like + ", collect=" + this.collect + ", share=" + this.share + ", windowUrl=" + this.windowUrl + ")";
    }

    public final String getAboardInfo() {
        return this.aboardInfo;
    }

    public final List<AnchorV4BannerMeta> getBannerMetaList() {
        return this.bannerMetaList;
    }

    public final CollectMeta getCollect() {
        return this.collect;
    }

    public final LikeMeta getLike() {
        return this.like;
    }

    public final String getRankUrl() {
        return this.rankUrl;
    }

    public final ShareMeta getShare() {
        return this.share;
    }

    public final SkuMeta getSkuMeta() {
        return this.skuMeta;
    }

    public final String getTaxDesc() {
        return this.taxDesc;
    }

    public final Integer getTermCount() {
        return this.termCount;
    }

    public final String getWindowUrl() {
        return this.windowUrl;
    }

    public final Boolean isPreselected() {
        return this.isPreselected;
    }

    public AnchorV4BaseInfoBusinessMeta(List<AnchorV4BannerMeta> r100, String r101, String r102, String r103, SkuMeta r104, Boolean r105, Integer r106, LikeMeta r107, CollectMeta r108, ShareMeta r110, String r111) {
        this.bannerMetaList = r100;
        this.rankUrl = r101;
        this.aboardInfo = r102;
        this.taxDesc = r103;
        this.skuMeta = r104;
        this.isPreselected = r105;
        this.termCount = r106;
        this.like = r107;
        this.collect = r108;
        this.share = r110;
        this.windowUrl = r111;
    }

    public /* synthetic */ AnchorV4BaseInfoBusinessMeta(List r110, String r111, String r112, String r113, SkuMeta r114, Boolean r115, Integer r116, LikeMeta r210, CollectMeta r211, ShareMeta r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = null;
        if ((r214 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r214 & 16) == 0) goto L21;
        SkuMeta r105 = null;
    L23:
        if ((r214 & 32) == 0) goto L25;
        Boolean r106 = null;
    L27:
        if ((r214 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r214 & 128) == 0) goto L33;
        LikeMeta r108 = null;
    L35:
        if ((r214 & 256) == 0) goto L37;
        CollectMeta r117 = null;
    L39:
        if ((r214 & 512) == 0) goto L41;
        ShareMeta r118 = null;
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
