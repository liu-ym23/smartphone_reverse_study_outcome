package com.bytedance.android.shopping.api.mall.mita;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003JÃ\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001J\u0013\u0010<\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018¨\u0006A"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/mita/MallMitaConfig;", "", "enableSharedRecyclerViewPool", "", "mallMitaPrefetchNextTabFeed", "mallMitaUseOldCache", "enableMitaLayoutSuppress", "mallMitaCardExposeCheckOpt", "mallMitaAdjustRVHeightOpt", "mallMitaReuseFirstScreenParsedDataOpt", "mallMitaFoldSlotChildScrollOpt", "mallMitaFoldNestedBridgeOpt", "skipStraightOutNodeIds", "", "", "xTabFullBuildOnNextFrame", "enableMitaGulPageNames", "enableFeedPreInit", "enableFeedDataFastPath", "enableDMTViewPager", "enableFoldHeaderAlwaysCanDrag", "closeRefreshableFeedAutoMeasure", "(ZZZZZZZZZLjava/util/List;ZLjava/util/List;ZZZZZ)V", "getCloseRefreshableFeedAutoMeasure", "()Z", "getEnableDMTViewPager", "getEnableFeedDataFastPath", "getEnableFeedPreInit", "getEnableFoldHeaderAlwaysCanDrag", "getEnableMitaGulPageNames", "()Ljava/util/List;", "getEnableMitaLayoutSuppress", "getEnableSharedRecyclerViewPool", "getMallMitaAdjustRVHeightOpt", "getMallMitaCardExposeCheckOpt", "getMallMitaFoldNestedBridgeOpt", "getMallMitaFoldSlotChildScrollOpt", "getMallMitaPrefetchNextTabFeed", "getMallMitaReuseFirstScreenParsedDataOpt", "getMallMitaUseOldCache", "getSkipStraightOutNodeIds", "getXTabFullBuildOnNextFrame", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallMitaConfig {

    @SerializedName("mall_mita_close_refreshable_feed_auto_measure")
    private final boolean closeRefreshableFeedAutoMeasure;

    @SerializedName("mall_mita_enable_dmt_view_pager")
    private final boolean enableDMTViewPager;

    @SerializedName("mall_mita_enable_feed_data_fast_path")
    private final boolean enableFeedDataFastPath;

    @SerializedName("mall_mita_enable_feed_pre_init")
    private final boolean enableFeedPreInit;

    @SerializedName("mall_mita_enable_fold_header_always_can_drag")
    private final boolean enableFoldHeaderAlwaysCanDrag;

    @SerializedName("enable_gul_page_name")
    private final List<String> enableMitaGulPageNames;

    @SerializedName("enable_mita_layout_suppress")
    private final boolean enableMitaLayoutSuppress;

    @SerializedName("enable_shared_recycler_view_pool")
    private final boolean enableSharedRecyclerViewPool;

    @SerializedName("mall_mita_adjust_rv_height_opt")
    private final boolean mallMitaAdjustRVHeightOpt;

    @SerializedName("mall_mita_list_card_expose_opt")
    private final boolean mallMitaCardExposeCheckOpt;

    @SerializedName("mall_mita_fold_nested_bridge_opt")
    private final boolean mallMitaFoldNestedBridgeOpt;

    @SerializedName("mall_mita_fold_slot_child_scroll_opt")
    private final boolean mallMitaFoldSlotChildScrollOpt;

    @SerializedName("mall_mita_prefetch_next_tab_feed")
    private final boolean mallMitaPrefetchNextTabFeed;

    @SerializedName("mall_mita_reuse_first_screen_parsed_data_opt")
    private final boolean mallMitaReuseFirstScreenParsedDataOpt;

    @SerializedName("mall_mita_use_old_cache")
    private final boolean mallMitaUseOldCache;

    @SerializedName("mall_mita_skip_straight_out_node_ids")
    private final List<String> skipStraightOutNodeIds;

    @SerializedName("mall_mita_xtab_full_build_on_next_frame")
    private final boolean xTabFullBuildOnNextFrame;

    public MallMitaConfig() {
        this(false, false, false, false, false, false, false, false, false, null, false, null, false, false, false, false, false, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallMitaConfig copy$default(MallMitaConfig r110, boolean r111, boolean r112, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, List r217, boolean r218, List r219, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        boolean r100 = r110.enableSharedRecyclerViewPool;
    L7:
        if ((r315 & 2) == 0) goto L9;
        boolean r101 = r110.mallMitaPrefetchNextTabFeed;
    L11:
        if ((r315 & 4) == 0) goto L13;
        boolean r102 = r110.mallMitaUseOldCache;
    L15:
        if ((r315 & 8) == 0) goto L17;
        boolean r103 = r110.enableMitaLayoutSuppress;
    L19:
        if ((r315 & 16) == 0) goto L21;
        boolean r104 = r110.mallMitaCardExposeCheckOpt;
    L23:
        if ((r315 & 32) == 0) goto L25;
        boolean r105 = r110.mallMitaAdjustRVHeightOpt;
    L27:
        if ((r315 & 64) == 0) goto L29;
        boolean r106 = r110.mallMitaReuseFirstScreenParsedDataOpt;
    L31:
        if ((r315 & 128) == 0) goto L33;
        boolean r107 = r110.mallMitaFoldSlotChildScrollOpt;
    L35:
        if ((r315 & 256) == 0) goto L37;
        boolean r113 = r110.mallMitaFoldNestedBridgeOpt;
    L39:
        if ((r315 & 512) == 0) goto L41;
        List r114 = r110.skipStraightOutNodeIds;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        boolean r115 = r110.xTabFullBuildOnNextFrame;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        List r116 = r110.enableMitaGulPageNames;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        boolean r117 = r110.enableFeedPreInit;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        boolean r118 = r110.enableFeedDataFastPath;
    L58:
        boolean r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        boolean r119 = r110.enableDMTViewPager;
    L62:
        boolean r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        boolean r120 = r110.enableFoldHeaderAlwaysCanDrag;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        boolean r108 = r110.closeRefreshableFeedAutoMeasure;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.enableSharedRecyclerViewPool;
    }

    public final List<String> component10() {
        return this.skipStraightOutNodeIds;
    }

    public final boolean component11() {
        return this.xTabFullBuildOnNextFrame;
    }

    public final List<String> component12() {
        return this.enableMitaGulPageNames;
    }

    public final boolean component13() {
        return this.enableFeedPreInit;
    }

    public final boolean component14() {
        return this.enableFeedDataFastPath;
    }

    public final boolean component15() {
        return this.enableDMTViewPager;
    }

    public final boolean component16() {
        return this.enableFoldHeaderAlwaysCanDrag;
    }

    public final boolean component17() {
        return this.closeRefreshableFeedAutoMeasure;
    }

    public final boolean component2() {
        return this.mallMitaPrefetchNextTabFeed;
    }

    public final boolean component3() {
        return this.mallMitaUseOldCache;
    }

    public final boolean component4() {
        return this.enableMitaLayoutSuppress;
    }

    public final boolean component5() {
        return this.mallMitaCardExposeCheckOpt;
    }

    public final boolean component6() {
        return this.mallMitaAdjustRVHeightOpt;
    }

    public final boolean component7() {
        return this.mallMitaReuseFirstScreenParsedDataOpt;
    }

    public final boolean component8() {
        return this.mallMitaFoldSlotChildScrollOpt;
    }

    public final boolean component9() {
        return this.mallMitaFoldNestedBridgeOpt;
    }

    public final MallMitaConfig copy(boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, List<String> r219, boolean r310, List<String> r311, boolean r312, boolean r313, boolean r314, boolean r315, boolean r316) {
        return new MallMitaConfig(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MallMitaConfig) == false) goto L40;
        MallMitaConfig r101 = (MallMitaConfig) r100;
        if (this.enableSharedRecyclerViewPool == r101.enableSharedRecyclerViewPool) goto L8;
        return false;
    L8:
        if (this.mallMitaPrefetchNextTabFeed == r101.mallMitaPrefetchNextTabFeed) goto L10;
        return false;
    L10:
        if (this.mallMitaUseOldCache == r101.mallMitaUseOldCache) goto L12;
        return false;
    L12:
        if (this.enableMitaLayoutSuppress == r101.enableMitaLayoutSuppress) goto L14;
        return false;
    L14:
        if (this.mallMitaCardExposeCheckOpt == r101.mallMitaCardExposeCheckOpt) goto L16;
        return false;
    L16:
        if (this.mallMitaAdjustRVHeightOpt == r101.mallMitaAdjustRVHeightOpt) goto L18;
        return false;
    L18:
        if (this.mallMitaReuseFirstScreenParsedDataOpt == r101.mallMitaReuseFirstScreenParsedDataOpt) goto L20;
        return false;
    L20:
        if (this.mallMitaFoldSlotChildScrollOpt == r101.mallMitaFoldSlotChildScrollOpt) goto L22;
        return false;
    L22:
        if (this.mallMitaFoldNestedBridgeOpt == r101.mallMitaFoldNestedBridgeOpt) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.skipStraightOutNodeIds, r101.skipStraightOutNodeIds) == true) goto L26;
        return false;
    L26:
        if (this.xTabFullBuildOnNextFrame == r101.xTabFullBuildOnNextFrame) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.enableMitaGulPageNames, r101.enableMitaGulPageNames) == true) goto L30;
        return false;
    L30:
        if (this.enableFeedPreInit == r101.enableFeedPreInit) goto L32;
        return false;
    L32:
        if (this.enableFeedDataFastPath == r101.enableFeedDataFastPath) goto L34;
        return false;
    L34:
        if (this.enableDMTViewPager == r101.enableDMTViewPager) goto L36;
        return false;
    L36:
        if (this.enableFoldHeaderAlwaysCanDrag == r101.enableFoldHeaderAlwaysCanDrag) goto L38;
        return false;
    L38:
        if (this.closeRefreshableFeedAutoMeasure == r101.closeRefreshableFeedAutoMeasure) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean r100 = this.enableSharedRecyclerViewPool;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.mallMitaPrefetchNextTabFeed;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.mallMitaUseOldCache;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.enableMitaLayoutSuppress;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.mallMitaCardExposeCheckOpt;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.mallMitaAdjustRVHeightOpt;
        ?? r117 = r116;
        if (r116 == false) goto L20;
        r117 = 1;
    L20:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.mallMitaReuseFirstScreenParsedDataOpt;
        ?? r120 = r119;
        if (r119 == false) goto L23;
        r120 = 1;
    L23:
        int r121 = (r118 + r120) * 31;
        boolean r122 = this.mallMitaFoldSlotChildScrollOpt;
        ?? r123 = r122;
        if (r122 == false) goto L26;
        r123 = 1;
    L26:
        int r124 = (r121 + r123) * 31;
        boolean r125 = this.mallMitaFoldNestedBridgeOpt;
        ?? r126 = r125;
        if (r125 == false) goto L29;
        r126 = 1;
    L29:
        int r127 = (r124 + r126) * 31;
        List<String> r128 = this.skipStraightOutNodeIds;
        int r129 = 0;
        if (r128 == null) goto L32;
        int r130 = r128.hashCode();
    L33:
        int r131 = (r127 + r130) * 31;
        boolean r132 = this.xTabFullBuildOnNextFrame;
        ?? r133 = r132;
        if (r132 == false) goto L36;
        r133 = 1;
    L36:
        int r134 = (r131 + r133) * 31;
        List<String> r135 = this.enableMitaGulPageNames;
        if (r135 == null) goto L39;
        r129 = r135.hashCode();
    L39:
        int r136 = (r134 + r129) * 31;
        boolean r137 = this.enableFeedPreInit;
        ?? r138 = r137;
        if (r137 == false) goto L42;
        r138 = 1;
    L42:
        int r139 = (r136 + r138) * 31;
        boolean r140 = this.enableFeedDataFastPath;
        ?? r141 = r140;
        if (r140 == false) goto L45;
        r141 = 1;
    L45:
        int r142 = (r139 + r141) * 31;
        boolean r143 = this.enableDMTViewPager;
        ?? r144 = r143;
        if (r143 == false) goto L48;
        r144 = 1;
    L48:
        int r145 = (r142 + r144) * 31;
        boolean r146 = this.enableFoldHeaderAlwaysCanDrag;
        ?? r147 = r146;
        if (r146 == false) goto L51;
        r147 = 1;
    L51:
        int r148 = (r145 + r147) * 31;
        boolean r149 = this.closeRefreshableFeedAutoMeasure;
        if (r149 == true) goto L56;
        r101 = r149;
    L56:
        return r148 + r101;
    L32:
        r130 = 0;
        goto L33
    }

    public String toString() {
        return "MallMitaConfig(enableSharedRecyclerViewPool=" + this.enableSharedRecyclerViewPool + ", mallMitaPrefetchNextTabFeed=" + this.mallMitaPrefetchNextTabFeed + ", mallMitaUseOldCache=" + this.mallMitaUseOldCache + ", enableMitaLayoutSuppress=" + this.enableMitaLayoutSuppress + ", mallMitaCardExposeCheckOpt=" + this.mallMitaCardExposeCheckOpt + ", mallMitaAdjustRVHeightOpt=" + this.mallMitaAdjustRVHeightOpt + ", mallMitaReuseFirstScreenParsedDataOpt=" + this.mallMitaReuseFirstScreenParsedDataOpt + ", mallMitaFoldSlotChildScrollOpt=" + this.mallMitaFoldSlotChildScrollOpt + ", mallMitaFoldNestedBridgeOpt=" + this.mallMitaFoldNestedBridgeOpt + ", skipStraightOutNodeIds=" + this.skipStraightOutNodeIds + ", xTabFullBuildOnNextFrame=" + this.xTabFullBuildOnNextFrame + ", enableMitaGulPageNames=" + this.enableMitaGulPageNames + ", enableFeedPreInit=" + this.enableFeedPreInit + ", enableFeedDataFastPath=" + this.enableFeedDataFastPath + ", enableDMTViewPager=" + this.enableDMTViewPager + ", enableFoldHeaderAlwaysCanDrag=" + this.enableFoldHeaderAlwaysCanDrag + ", closeRefreshableFeedAutoMeasure=" + this.closeRefreshableFeedAutoMeasure + ")";
    }

    public final boolean getCloseRefreshableFeedAutoMeasure() {
        return this.closeRefreshableFeedAutoMeasure;
    }

    public final boolean getEnableDMTViewPager() {
        return this.enableDMTViewPager;
    }

    public final boolean getEnableFeedDataFastPath() {
        return this.enableFeedDataFastPath;
    }

    public final boolean getEnableFeedPreInit() {
        return this.enableFeedPreInit;
    }

    public final boolean getEnableFoldHeaderAlwaysCanDrag() {
        return this.enableFoldHeaderAlwaysCanDrag;
    }

    public final List<String> getEnableMitaGulPageNames() {
        return this.enableMitaGulPageNames;
    }

    public final boolean getEnableMitaLayoutSuppress() {
        return this.enableMitaLayoutSuppress;
    }

    public final boolean getEnableSharedRecyclerViewPool() {
        return this.enableSharedRecyclerViewPool;
    }

    public final boolean getMallMitaAdjustRVHeightOpt() {
        return this.mallMitaAdjustRVHeightOpt;
    }

    public final boolean getMallMitaCardExposeCheckOpt() {
        return this.mallMitaCardExposeCheckOpt;
    }

    public final boolean getMallMitaFoldNestedBridgeOpt() {
        return this.mallMitaFoldNestedBridgeOpt;
    }

    public final boolean getMallMitaFoldSlotChildScrollOpt() {
        return this.mallMitaFoldSlotChildScrollOpt;
    }

    public final boolean getMallMitaPrefetchNextTabFeed() {
        return this.mallMitaPrefetchNextTabFeed;
    }

    public final boolean getMallMitaReuseFirstScreenParsedDataOpt() {
        return this.mallMitaReuseFirstScreenParsedDataOpt;
    }

    public final boolean getMallMitaUseOldCache() {
        return this.mallMitaUseOldCache;
    }

    public final List<String> getSkipStraightOutNodeIds() {
        return this.skipStraightOutNodeIds;
    }

    public final boolean getXTabFullBuildOnNextFrame() {
        return this.xTabFullBuildOnNextFrame;
    }

    public MallMitaConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, List<String> r112, boolean r113, List<String> r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119) {
        this.enableSharedRecyclerViewPool = r100;
        this.mallMitaPrefetchNextTabFeed = r101;
        this.mallMitaUseOldCache = r102;
        this.enableMitaLayoutSuppress = r103;
        this.mallMitaCardExposeCheckOpt = r104;
        this.mallMitaAdjustRVHeightOpt = r105;
        this.mallMitaReuseFirstScreenParsedDataOpt = r106;
        this.mallMitaFoldSlotChildScrollOpt = r110;
        this.mallMitaFoldNestedBridgeOpt = r111;
        this.skipStraightOutNodeIds = r112;
        this.xTabFullBuildOnNextFrame = r113;
        this.enableMitaGulPageNames = r114;
        this.enableFeedPreInit = r115;
        this.enableFeedDataFastPath = r116;
        this.enableDMTViewPager = r117;
        this.enableFoldHeaderAlwaysCanDrag = r118;
        this.closeRefreshableFeedAutoMeasure = r119;
    }

    public /* synthetic */ MallMitaConfig(boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, List r219, boolean r310, List r311, boolean r312, boolean r313, boolean r314, boolean r315, boolean r316, int r317, DefaultConstructorMarker r318) {
        boolean r100 = false;
        if ((r317 & 1) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r317 & 2) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r317 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r317 & 8) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r317 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r317 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r317 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r317 & 128) == 0) goto L33;
        boolean r108 = false;
    L35:
        if ((r317 & 256) == 0) goto L37;
        boolean r110 = false;
    L38:
        List r111 = null;
        if ((r317 & 512) == 0) goto L41;
        List r112 = null;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        boolean r113 = false;
    L47:
        if ((r317 & 2048) != 0) goto L51;
        r111 = r311;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        boolean r114 = false;
    L55:
        if ((r317 & 8192) != 0) goto L58;
        r100 = r313;
    L58:
        boolean r115 = true;
        if ((r317 & 16384) == 0) goto L61;
        boolean r116 = true;
    L63:
        if ((r317 & 32768) == 0) goto L65;
        boolean r117 = true;
    L67:
        if ((r317 & 65536) != 0) goto L70;
        r115 = r316;
    L70:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r110, r112, r113, r111, r114, r100, r116, r117, r115);
        return;
    L65:
        r117 = r315;
        goto L67
    L61:
        r116 = r314;
        goto L63
    L53:
        r114 = r312;
        goto L55
    L45:
        r113 = r310;
        goto L47
    L41:
        r112 = r219;
        goto L43
    L37:
        r110 = r218;
        goto L38
    L33:
        r108 = r217;
        goto L35
    L29:
        r107 = r216;
        goto L31
    L25:
        r106 = r215;
        goto L27
    L21:
        r105 = r214;
        goto L23
    L17:
        r104 = r213;
        goto L19
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
