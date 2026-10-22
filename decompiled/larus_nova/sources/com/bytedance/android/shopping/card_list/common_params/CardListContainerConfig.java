package com.bytedance.android.shopping.card_list.common_params;

import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b,\b\u0086\b\u0018\u0000 U2\u00020\u0001:\u0001VBÉ\u0001\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bS\u0010TJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010\u000e\u001a\u00020\fHÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003J\t\u0010\u0011\u001a\u00020\fHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003JË\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\fHÖ\u0001J\u0013\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003R\u001b\u00102\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00105\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00106\u001a\u0004\b7\u00108R\u001a\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00109\u001a\u0004\b:\u0010;R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010<\u001a\u0004\b=\u00101R$\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010<\u001a\u0004\b>\u00101\"\u0004\b?\u0010@R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010<\u001a\u0004\bA\u00101R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010<\u001a\u0004\bB\u00101R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010C\u001a\u0004\bD\u0010ER\u001a\u0010\u001f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010F\u001a\u0004\bG\u0010HR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010C\u001a\u0004\bI\u0010ER\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010C\u001a\u0004\bJ\u0010ER\u001a\u0010\"\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010F\u001a\u0004\bK\u0010HR\u001a\u0010#\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\bL\u0010;R\u001a\u0010$\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u00109\u001a\u0004\bM\u0010;R\u001a\u0010%\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u00109\u001a\u0004\bN\u0010;R\u001a\u0010&\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u00109\u001a\u0004\bO\u0010;R\u001c\u0010'\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010P\u001a\u0004\bQ\u0010R¨\u0006W"}, d2 = {"Lcom/bytedance/android/shopping/card_list/common_params/CardListContainerConfig;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;", "component1", "", "component2", "", "component3", "component4", "component5", "component6", "", "", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "component16", "bizType", "queryDataInStarter", "pageName", "pageType", "showEventName", "clickEventName", "uplinkCodesNeedReload", "cacheValidDuration", "bottomPlaceholderEnableScenes", "skipExplicitLoadingTriggerList", "gulPreloadThreshold", "needLoadGUL", "needSetGradientView", "needCacheManager", "needPullRefresh", "pageInfo", "copy", "toString", "hashCode", "", "other", "equals", "standardShowEventName$delegate", "Lkotlin/Lazy;", "getStandardShowEventName", "()Ljava/lang/String;", "standardShowEventName", "standardClickEventName$delegate", "getStandardClickEventName", "standardClickEventName", "Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;", "getBizType", "()Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;", "Z", "getQueryDataInStarter", "()Z", "Ljava/lang/String;", "getPageName", "getPageType", "setPageType", "(Ljava/lang/String;)V", "getShowEventName", "getClickEventName", "Ljava/util/List;", "getUplinkCodesNeedReload", "()Ljava/util/List;", "I", "getCacheValidDuration", "()I", "getBottomPlaceholderEnableScenes", "getSkipExplicitLoadingTriggerList", "getGulPreloadThreshold", "getNeedLoadGUL", "getNeedSetGradientView", "getNeedCacheManager", "getNeedPullRefresh", "Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "getPageInfo", "()Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "<init>", "(Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/util/List;Ljava/util/List;IZZZZLcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListContainerConfig implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("biz_type")
    private final LauncherBizType bizType;

    @SerializedName("bottom_placeholder_enable_scenes")
    private final List<String> bottomPlaceholderEnableScenes;

    @SerializedName("cache_valid_duration")
    private final int cacheValidDuration;

    @SerializedName("standard_click_event_name")
    private final String clickEventName;

    @SerializedName("gul_preload_threshold")
    private final int gulPreloadThreshold;

    @SerializedName("need_cache_manager")
    private final boolean needCacheManager;

    @SerializedName("need_load_gul")
    private final boolean needLoadGUL;

    @SerializedName("need_pull_refresh")
    private final boolean needPullRefresh;

    @SerializedName("need_set_gradient_view")
    private final boolean needSetGradientView;

    @SerializedName("page_info")
    private final YataPageInfo pageInfo;

    @SerializedName("page_name")
    private final String pageName;

    @SerializedName("page_type")
    private String pageType;

    @SerializedName("query_data_in_starter")
    private final boolean queryDataInStarter;

    @SerializedName("standard_show_event_name")
    private final String showEventName;

    @SerializedName("skip_explicit_loading_trigger_list")
    private final List<String> skipExplicitLoadingTriggerList;
    private final Lazy standardClickEventName$delegate;
    private final Lazy standardShowEventName$delegate;

    @SerializedName("uplink_codes_need_reload")
    private final List<Integer> uplinkCodesNeedReload;

    public static final class a {
        public a() {
        }

        public static CardListContainerConfig a(Map r210) {
            Intrinsics.checkNotNullParameter(r210, "pageConfig");
            Object r100 = null;
            if (CardListExtentionsKt.c(r210, "need_frontier", false) == false) goto L5;
            YataPageInfo r211 = new YataPageInfo(true, false, null, 6, null);
        L6:
            int r101 = CardListExtentionsKt.d(r210, "biz_type", 0);
            LauncherBizType[] r102 = LauncherBizType.values();
            int r103 = r102.length;
            int r104 = 0;
        L8:
            if (r104 >= r103) goto L16;
            LauncherBizType r105 = r102[r104];
            if (r105.ordinal() != r101) goto L12;
            boolean r106 = true;
        L13:
            if (r106 == true) goto L14;
            r104 = r104 + 1;
            goto L8
        L14:
            LauncherBizType r110 = r105;
        L17:
            if (r110 == null) goto L29;
            boolean r111 = CardListExtentionsKt.c(r210, "query_data_in_starter", false);
            String r112 = CardListExtentionsKt.f(r210, "page_name", "");
            String r113 = CardListExtentionsKt.f(r210, "page_type", "");
            String r114 = CardListExtentionsKt.f(r210, "standard_show_event_name", "");
            String r115 = CardListExtentionsKt.f(r210, "standard_click_event_name", "");
            List r107 = CollectionsKt.emptyList();
            Intrinsics.checkNotNullParameter(r210, "$this$getIntList");
            Intrinsics.checkNotNullParameter("uplink_codes_need_reload", "key");
            Intrinsics.checkNotNullParameter(r107, "default");
            Object r108 = r210.get("uplink_codes_need_reload");
            if ((r108 instanceof List) == false) goto L22;
            r100 = r108;
        L22:
            List r109 = (List) r100;
            if (r109 != null) goto L25;
            List r116 = r107;
        L27:
            return new CardListContainerConfig(r110, r111, r112, r113, r114, r115, r116, CardListExtentionsKt.d(r210, "cache_valid_duration", 0), CardListExtentionsKt.g(r210, "bottom_placeholder_enable_scenes"), CardListExtentionsKt.g(r210, "skip_explicit_loading_trigger_list"), CardListExtentionsKt.d(r210, "gul_preload_threshold", 3), CardListExtentionsKt.c(r210, "need_load_gul", true), CardListExtentionsKt.c(r210, "need_set_gradient_view", false), CardListExtentionsKt.c(r210, "need_cache_manager", false), CardListExtentionsKt.c(r210, "need_pull_refresh", true), r211);
        L25:
            r116 = r109;
            goto L27
        L29:
            throw new IllegalArgumentException("Invalid enum value: " + r101);
        L12:
            r106 = false;
            goto L13
        L16:
            r110 = null;
            goto L17
        L5:
            r211 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public CardListContainerConfig() {
        this(null, false, null, null, null, null, null, 0, null, null, 0, false, false, false, false, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardListContainerConfig copy$default(CardListContainerConfig r110, LauncherBizType r111, boolean r112, String r210, String r211, String r212, String r213, List r214, int r215, List r216, List r217, int r218, boolean r219, boolean r310, boolean r311, boolean r312, YataPageInfo r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        LauncherBizType r100 = r110.bizType;
    L7:
        if ((r314 & 2) == 0) goto L9;
        boolean r101 = r110.queryDataInStarter;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.pageName;
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = r110.pageType;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = r110.showEventName;
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = r110.clickEventName;
    L27:
        if ((r314 & 64) == 0) goto L29;
        List r106 = r110.uplinkCodesNeedReload;
    L31:
        if ((r314 & 128) == 0) goto L33;
        int r107 = r110.cacheValidDuration;
    L35:
        if ((r314 & 256) == 0) goto L37;
        List r113 = r110.bottomPlaceholderEnableScenes;
    L39:
        if ((r314 & 512) == 0) goto L41;
        List r114 = r110.skipExplicitLoadingTriggerList;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        int r115 = r110.gulPreloadThreshold;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        boolean r116 = r110.needLoadGUL;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        boolean r117 = r110.needSetGradientView;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        boolean r118 = r110.needCacheManager;
    L58:
        boolean r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        boolean r119 = r110.needPullRefresh;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        YataPageInfo r108 = r110.pageInfo;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
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

    public final LauncherBizType component1() {
        return this.bizType;
    }

    public final List<String> component10() {
        return this.skipExplicitLoadingTriggerList;
    }

    public final int component11() {
        return this.gulPreloadThreshold;
    }

    public final boolean component12() {
        return this.needLoadGUL;
    }

    public final boolean component13() {
        return this.needSetGradientView;
    }

    public final boolean component14() {
        return this.needCacheManager;
    }

    public final boolean component15() {
        return this.needPullRefresh;
    }

    public final YataPageInfo component16() {
        return this.pageInfo;
    }

    public final boolean component2() {
        return this.queryDataInStarter;
    }

    public final String component3() {
        return this.pageName;
    }

    public final String component4() {
        return this.pageType;
    }

    public final String component5() {
        return this.showEventName;
    }

    public final String component6() {
        return this.clickEventName;
    }

    public final List<Integer> component7() {
        return this.uplinkCodesNeedReload;
    }

    public final int component8() {
        return this.cacheValidDuration;
    }

    public final List<String> component9() {
        return this.bottomPlaceholderEnableScenes;
    }

    public final CardListContainerConfig copy(LauncherBizType r210, boolean r211, String r212, String r213, String r214, String r215, List<Integer> r216, int r217, List<String> r218, List<String> r219, int r310, boolean r311, boolean r312, boolean r313, boolean r314, YataPageInfo r315) {
        Intrinsics.checkNotNullParameter(r210, "bizType");
        return new CardListContainerConfig(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CardListContainerConfig) == false) goto L38;
        CardListContainerConfig r101 = (CardListContainerConfig) r100;
        if (Intrinsics.areEqual(this.bizType, r101.bizType) == true) goto L8;
        return false;
    L8:
        if (this.queryDataInStarter == r101.queryDataInStarter) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageType, r101.pageType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.showEventName, r101.showEventName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.clickEventName, r101.clickEventName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uplinkCodesNeedReload, r101.uplinkCodesNeedReload) == true) goto L20;
        return false;
    L20:
        if (this.cacheValidDuration == r101.cacheValidDuration) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bottomPlaceholderEnableScenes, r101.bottomPlaceholderEnableScenes) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.skipExplicitLoadingTriggerList, r101.skipExplicitLoadingTriggerList) == true) goto L26;
        return false;
    L26:
        if (this.gulPreloadThreshold == r101.gulPreloadThreshold) goto L28;
        return false;
    L28:
        if (this.needLoadGUL == r101.needLoadGUL) goto L30;
        return false;
    L30:
        if (this.needSetGradientView == r101.needSetGradientView) goto L32;
        return false;
    L32:
        if (this.needCacheManager == r101.needCacheManager) goto L34;
        return false;
    L34:
        if (this.needPullRefresh == r101.needPullRefresh) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.pageInfo, r101.pageInfo) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    public final String getStandardClickEventName() {
        return (String) this.standardClickEventName$delegate.getValue();
    }

    public final String getStandardShowEventName() {
        return (String) this.standardShowEventName$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        LauncherBizType r100 = this.bizType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.queryDataInStarter;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.pageName;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.pageType;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        String r114 = this.showEventName;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        String r117 = this.clickEventName;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        List<Integer> r120 = this.uplinkCodesNeedReload;
        if (r120 == null) goto L28;
        int r121 = r120.hashCode();
    L29:
        int r122 = (((r119 + r121) * 31) + this.cacheValidDuration) * 31;
        List<String> r123 = this.bottomPlaceholderEnableScenes;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        List<String> r126 = this.skipExplicitLoadingTriggerList;
        if (r126 == null) goto L36;
        int r127 = r126.hashCode();
    L37:
        int r128 = (((r125 + r127) * 31) + this.gulPreloadThreshold) * 31;
        boolean r129 = this.needLoadGUL;
        ?? r130 = r129;
        if (r129 == false) goto L40;
        r130 = 1;
    L40:
        int r131 = (r128 + r130) * 31;
        boolean r132 = this.needSetGradientView;
        ?? r133 = r132;
        if (r132 == false) goto L43;
        r133 = 1;
    L43:
        int r134 = (r131 + r133) * 31;
        boolean r135 = this.needCacheManager;
        ?? r136 = r135;
        if (r135 == false) goto L46;
        r136 = 1;
    L46:
        int r137 = (r134 + r136) * 31;
        boolean r138 = this.needPullRefresh;
        if (r138 == true) goto L50;
        r105 = r138;
    L50:
        int r139 = (r137 + r105) * 31;
        YataPageInfo r140 = this.pageInfo;
        if (r140 == null) goto L54;
        r101 = r140.hashCode();
    L54:
        return r139 + r101;
    L36:
        r127 = 0;
        goto L37
    L32:
        r124 = 0;
        goto L33
    L28:
        r121 = 0;
        goto L29
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CardListContainerConfig(bizType=" + this.bizType + ", queryDataInStarter=" + this.queryDataInStarter + ", pageName=" + this.pageName + ", pageType=" + this.pageType + ", showEventName=" + this.showEventName + ", clickEventName=" + this.clickEventName + ", uplinkCodesNeedReload=" + this.uplinkCodesNeedReload + ", cacheValidDuration=" + this.cacheValidDuration + ", bottomPlaceholderEnableScenes=" + this.bottomPlaceholderEnableScenes + ", skipExplicitLoadingTriggerList=" + this.skipExplicitLoadingTriggerList + ", gulPreloadThreshold=" + this.gulPreloadThreshold + ", needLoadGUL=" + this.needLoadGUL + ", needSetGradientView=" + this.needSetGradientView + ", needCacheManager=" + this.needCacheManager + ", needPullRefresh=" + this.needPullRefresh + ", pageInfo=" + this.pageInfo + ")";
    }

    public final LauncherBizType getBizType() {
        return this.bizType;
    }

    public final List<String> getBottomPlaceholderEnableScenes() {
        return this.bottomPlaceholderEnableScenes;
    }

    public final int getCacheValidDuration() {
        return this.cacheValidDuration;
    }

    public final String getClickEventName() {
        return this.clickEventName;
    }

    public final int getGulPreloadThreshold() {
        return this.gulPreloadThreshold;
    }

    public final boolean getNeedCacheManager() {
        return this.needCacheManager;
    }

    public final boolean getNeedLoadGUL() {
        return this.needLoadGUL;
    }

    public final boolean getNeedPullRefresh() {
        return this.needPullRefresh;
    }

    public final boolean getNeedSetGradientView() {
        return this.needSetGradientView;
    }

    public final YataPageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final boolean getQueryDataInStarter() {
        return this.queryDataInStarter;
    }

    public final String getShowEventName() {
        return this.showEventName;
    }

    public final List<String> getSkipExplicitLoadingTriggerList() {
        return this.skipExplicitLoadingTriggerList;
    }

    public final List<Integer> getUplinkCodesNeedReload() {
        return this.uplinkCodesNeedReload;
    }

    public final void setPageType(String r100) {
        this.pageType = r100;
    }

    public CardListContainerConfig(LauncherBizType r100, boolean r101, String r102, String r103, String r104, String r105, List<Integer> r110, int r111, List<String> r112, List<String> r113, int r114, boolean r115, boolean r116, boolean r117, boolean r118, YataPageInfo r119) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        this.bizType = r100;
        this.queryDataInStarter = r101;
        this.pageName = r102;
        this.pageType = r103;
        this.showEventName = r104;
        this.clickEventName = r105;
        this.uplinkCodesNeedReload = r110;
        this.cacheValidDuration = r111;
        this.bottomPlaceholderEnableScenes = r112;
        this.skipExplicitLoadingTriggerList = r113;
        this.gulPreloadThreshold = r114;
        this.needLoadGUL = r115;
        this.needSetGradientView = r116;
        this.needCacheManager = r117;
        this.needPullRefresh = r118;
        this.pageInfo = r119;
        this.standardShowEventName$delegate = LazyKt.lazy(new CardListContainerConfig$standardShowEventName$2(this));
        this.standardClickEventName$delegate = LazyKt.lazy(new CardListContainerConfig$standardClickEventName$2(this));
    }

    public /* synthetic */ CardListContainerConfig(LauncherBizType r110, boolean r111, String r210, String r211, String r212, String r213, List r214, int r215, List r216, List r217, int r218, boolean r219, boolean r310, boolean r311, boolean r312, YataPageInfo r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        LauncherBizType r100 = LauncherBizType.NONE;
    L7:
        if ((r314 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        List r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        int r112 = 0;
    L35:
        if ((r314 & 256) == 0) goto L37;
        List r113 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        List r114 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        int r115 = 3;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        boolean r116 = true;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        boolean r107 = false;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        boolean r108 = false;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        boolean r117 = true;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        YataPageInfo r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r107, r108, r117, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r117 = r312;
        goto L63
    L57:
        r108 = r311;
        goto L59
    L53:
        r107 = r310;
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
        r112 = r215;
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
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
