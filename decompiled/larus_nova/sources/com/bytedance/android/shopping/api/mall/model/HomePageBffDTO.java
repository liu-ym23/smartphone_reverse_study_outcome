package com.bytedance.android.shopping.api.mall.model;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bM\u0010NJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u008d\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\t\u0010!\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020\"HÖ\u0001J\u0013\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b2\u00103R$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u00101\u001a\u0004\b4\u00103\"\u0004\b5\u00106R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010D\u001a\u0004\bE\u0010FR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010J\u001a\u0004\bK\u0010L¨\u0006O"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/HomePageBffDTO;", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "component1", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "component2", "Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;", "component3", "component4", "Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "component5", "", "", "component6", "Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;", "component7", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;", "component8", "Lcom/bytedance/android/shopping/api/mall/model/PendantWrapper;", "component9", "Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;", "component10", "feed", "feedVO", "popup", "topBar", "bizInfo", "dynamicParams", "background", "mallCategoryTabAreaInfo", "pendantWrapper", "extra", "copy", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "getFeed", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "setFeed", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;)V", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "getFeedVO", "()Lcom/bytedance/android/ec/hybrid/list/entity/k;", "setFeedVO", "(Lcom/bytedance/android/ec/hybrid/list/entity/k;)V", "Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;", "getPopup", "()Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;", "getTopBar", "setTopBar", "(Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;)V", "Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "getBizInfo", "()Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;", "setBizInfo", "(Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;)V", "Ljava/util/Map;", "getDynamicParams", "()Ljava/util/Map;", "setDynamicParams", "(Ljava/util/Map;)V", "Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;", "getBackground", "()Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;", "getMallCategoryTabAreaInfo", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;", "Lcom/bytedance/android/shopping/api/mall/model/PendantWrapper;", "getPendantWrapper", "()Lcom/bytedance/android/shopping/api/mall/model/PendantWrapper;", "Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;", "<init>", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;Lcom/bytedance/android/ec/hybrid/list/entity/k;Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;Lcom/bytedance/android/shopping/api/mall/model/SingleCardData;Lcom/bytedance/android/shopping/api/mall/model/BffBizInfo;Ljava/util/Map;Lcom/bytedance/android/shopping/api/mall/model/BackgroundWrapper;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;Lcom/bytedance/android/shopping/api/mall/model/PendantWrapper;Lcom/bytedance/android/shopping/api/mall/model/HomepageExtra;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HomePageBffDTO {

    @SerializedName("background")
    private final BackgroundWrapper background;

    @SerializedName("biz_info")
    private BffBizInfo bizInfo;

    @SerializedName("dynamic_params")
    private Map<String, ? extends Object> dynamicParams;

    @SerializedName("extra")
    private final HomepageExtra extra;

    @SerializedName("feed")
    private ECHybridListDTO feed;
    private volatile transient k feedVO;

    @SerializedName("mall_category_tab_area_info")
    private final MallCategoryTabAreaInfo mallCategoryTabAreaInfo;

    @SerializedName("pendant")
    private final PendantWrapper pendantWrapper;

    @SerializedName("popup")
    private final SingleCardData popup;

    @SerializedName(BitableAnalytic.MemberItemSource.TOP_BAR_SOURCE)
    private SingleCardData topBar;

    public HomePageBffDTO() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HomePageBffDTO copy$default(HomePageBffDTO r110, ECHybridListDTO r111, k r112, SingleCardData r113, SingleCardData r114, BffBizInfo r115, Map r116, BackgroundWrapper r117, MallCategoryTabAreaInfo r118, PendantWrapper r210, HomepageExtra r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        ECHybridListDTO r100 = r110.feed;
    L7:
        if ((r212 & 2) == 0) goto L9;
        k r101 = r110.feedVO;
    L11:
        if ((r212 & 4) == 0) goto L13;
        SingleCardData r102 = r110.popup;
    L15:
        if ((r212 & 8) == 0) goto L17;
        SingleCardData r103 = r110.topBar;
    L19:
        if ((r212 & 16) == 0) goto L21;
        BffBizInfo r104 = r110.bizInfo;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Map r105 = r110.dynamicParams;
    L27:
        if ((r212 & 64) == 0) goto L29;
        BackgroundWrapper r106 = r110.background;
    L31:
        if ((r212 & 128) == 0) goto L33;
        MallCategoryTabAreaInfo r107 = r110.mallCategoryTabAreaInfo;
    L35:
        if ((r212 & 256) == 0) goto L37;
        PendantWrapper r119 = r110.pendantWrapper;
    L39:
        if ((r212 & 512) == 0) goto L41;
        HomepageExtra r108 = r110.extra;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
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

    public final ECHybridListDTO component1() {
        return this.feed;
    }

    public final HomepageExtra component10() {
        return this.extra;
    }

    public final k component2() {
        return this.feedVO;
    }

    public final SingleCardData component3() {
        return this.popup;
    }

    public final SingleCardData component4() {
        return this.topBar;
    }

    public final BffBizInfo component5() {
        return this.bizInfo;
    }

    public final Map<String, Object> component6() {
        return this.dynamicParams;
    }

    public final BackgroundWrapper component7() {
        return this.background;
    }

    public final MallCategoryTabAreaInfo component8() {
        return this.mallCategoryTabAreaInfo;
    }

    public final PendantWrapper component9() {
        return this.pendantWrapper;
    }

    public final HomePageBffDTO copy(ECHybridListDTO r110, k r111, SingleCardData r112, SingleCardData r113, BffBizInfo r114, Map<String, ? extends Object> r115, BackgroundWrapper r116, MallCategoryTabAreaInfo r210, PendantWrapper r211, HomepageExtra r212) {
        return new HomePageBffDTO(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HomePageBffDTO) == false) goto L26;
        HomePageBffDTO r101 = (HomePageBffDTO) r100;
        if (Intrinsics.areEqual(this.feed, r101.feed) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.feedVO, r101.feedVO) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.popup, r101.popup) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topBar, r101.topBar) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bizInfo, r101.bizInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.dynamicParams, r101.dynamicParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.mallCategoryTabAreaInfo, r101.mallCategoryTabAreaInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.pendantWrapper, r101.pendantWrapper) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        ECHybridListDTO r100 = this.feed;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        k r104 = this.feedVO;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        SingleCardData r107 = this.popup;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        SingleCardData r110 = this.topBar;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        BffBizInfo r113 = this.bizInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, ? extends Object> r116 = this.dynamicParams;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        BackgroundWrapper r119 = this.background;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        MallCategoryTabAreaInfo r122 = this.mallCategoryTabAreaInfo;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        PendantWrapper r125 = this.pendantWrapper;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        HomepageExtra r128 = this.extra;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
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
        return "HomePageBffDTO(feed=" + this.feed + ", feedVO=" + this.feedVO + ", popup=" + this.popup + ", topBar=" + this.topBar + ", bizInfo=" + this.bizInfo + ", dynamicParams=" + this.dynamicParams + ", background=" + this.background + ", mallCategoryTabAreaInfo=" + this.mallCategoryTabAreaInfo + ", pendantWrapper=" + this.pendantWrapper + ", extra=" + this.extra + ")";
    }

    public final BackgroundWrapper getBackground() {
        return this.background;
    }

    public final BffBizInfo getBizInfo() {
        return this.bizInfo;
    }

    public final Map<String, Object> getDynamicParams() {
        return this.dynamicParams;
    }

    public final HomepageExtra getExtra() {
        return this.extra;
    }

    public final ECHybridListDTO getFeed() {
        return this.feed;
    }

    public final k getFeedVO() {
        return this.feedVO;
    }

    public final MallCategoryTabAreaInfo getMallCategoryTabAreaInfo() {
        return this.mallCategoryTabAreaInfo;
    }

    public final PendantWrapper getPendantWrapper() {
        return this.pendantWrapper;
    }

    public final SingleCardData getPopup() {
        return this.popup;
    }

    public final SingleCardData getTopBar() {
        return this.topBar;
    }

    public final void setBizInfo(BffBizInfo r100) {
        this.bizInfo = r100;
    }

    public final void setDynamicParams(Map<String, ? extends Object> r100) {
        this.dynamicParams = r100;
    }

    public final void setFeed(ECHybridListDTO r100) {
        this.feed = r100;
    }

    public final void setFeedVO(k r100) {
        this.feedVO = r100;
    }

    public final void setTopBar(SingleCardData r100) {
        this.topBar = r100;
    }

    public HomePageBffDTO(ECHybridListDTO r100, k r101, SingleCardData r102, SingleCardData r103, BffBizInfo r104, Map<String, ? extends Object> r105, BackgroundWrapper r106, MallCategoryTabAreaInfo r107, PendantWrapper r108, HomepageExtra r110) {
        this.feed = r100;
        this.feedVO = r101;
        this.popup = r102;
        this.topBar = r103;
        this.bizInfo = r104;
        this.dynamicParams = r105;
        this.background = r106;
        this.mallCategoryTabAreaInfo = r107;
        this.pendantWrapper = r108;
        this.extra = r110;
    }

    public /* synthetic */ HomePageBffDTO(ECHybridListDTO r110, k r111, SingleCardData r112, SingleCardData r113, BffBizInfo r114, Map r115, BackgroundWrapper r116, MallCategoryTabAreaInfo r117, PendantWrapper r210, HomepageExtra r211, int r212, DefaultConstructorMarker r213) {
        HomepageExtra r100 = null;
        if ((r212 & 1) == 0) goto L5;
        ECHybridListDTO r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        k r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        SingleCardData r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        SingleCardData r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        BffBizInfo r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        BackgroundWrapper r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        MallCategoryTabAreaInfo r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        PendantWrapper r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
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
