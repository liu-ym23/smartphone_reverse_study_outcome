package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B©\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0002\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0002\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u0010;\u001a\u00020\u0006\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001c\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010C\u001a\u00020#\u0012\b\b\u0002\u0010E\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u0002\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bN\u0010OJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u001a\u0010$\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001bR\"\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010\u001bR\u001c\u00102\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0014\u001a\u0004\b3\u0010\u0016R\u001c\u00104\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0016R\u001c\u00107\u001a\u0004\u0018\u0001068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010)\u001a\u0004\b<\u0010+R\u001c\u0010=\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\"\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010\u0019\u001a\u0004\bB\u0010\u001bR\u001a\u0010C\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010%\u001a\u0004\bD\u0010'R\u001a\u0010E\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010)\u001a\u0004\bF\u0010+R\"\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010\u0019\u001a\u0004\bH\u0010\u001bR\"\u0010J\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010\u0019\u001a\u0004\bK\u0010\u001bR\u001c\u0010L\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010\u0014\u001a\u0004\bM\u0010\u0016¨\u0006P"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowTabDataListResponseDTODeprecated;", "Lcom/bytedance/android/window/shop/repository/compat/WindowTabInfoProvider;", "", "Lcom/bytedance/android/window/shop/repository/dto/p;", ReportCardMonitorPlugin.CATEGORIES, "subCategories", "", "getWindowStatusCode", "", "msg", "cardCount", "getTargetSelectCategoryId", "getTargetSelectSubCategoryId", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "getWindowLayoutType", "tabType", "Ljava/lang/Integer;", "getTabType", "()Ljava/lang/Integer;", "selectCategoryId", "Ljava/lang/String;", "getSelectCategoryId", "()Ljava/lang/String;", "Lcom/bytedance/android/window/shop/repository/dto/a;", "filterType", "Ljava/util/List;", "getFilterType", "()Ljava/util/List;", "Lcom/bytedance/android/window/shop/repository/dto/c;", "mixFullCards", "getMixFullCards", "categoryData", "getCategoryData", "globalMixFullCards", "getGlobalMixFullCards", "", "hasMore", "Z", "getHasMore", "()Z", EffectConfiguration.KEY_CURSOR, "I", "getCursor", "()I", "Lcom/bytedance/android/ec/window/base/repository/dto/q;", "sortType", "getSortType", "Lcom/bytedance/android/window/shop/repository/dto/i;", "tabs", "getTabs", "searchHint", "getSearchHint", "commonPassThrough", "getCommonPassThrough", "Lcom/bytedance/android/window/shop/repository/dto/v;", "extensionCardControl", "Lcom/bytedance/android/window/shop/repository/dto/v;", "getExtensionCardControl", "()Lcom/bytedance/android/window/shop/repository/dto/v;", "layout", "getLayout", "topCards", "Lcom/bytedance/android/window/shop/repository/dto/c;", "getTopCards", "()Lcom/bytedance/android/window/shop/repository/dto/c;", "category", "getCategory", "hideEmptyStatus", "getHideEmptyStatus", "stickyArea", "getStickyArea", "subCategorys", "getSubCategorys", "Lnq3/a;", "dynamicViews", "getDynamicViews", "selectSubCategory", "getSelectSubCategory", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ZILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/window/shop/repository/dto/v;ILcom/bytedance/android/window/shop/repository/dto/c;Ljava/util/List;ZILjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabDataListResponseDTODeprecated extends WindowTabInfoProvider {

    @SerializedName("category_list")
    private final List<p> category;

    @SerializedName("category_data")
    private final String categoryData;

    @SerializedName("common_pass_through")
    private final String commonPassThrough;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final int cursor;

    @SerializedName("dynamic_views")
    private final List<nq3.a> dynamicViews;

    @SerializedName("extension_card_control")
    private final v extensionCardControl;

    @SerializedName(EffectConfiguration.KEY_FILTER_TYPE)
    private final List<a> filterType;

    @SerializedName("global_mix_full_cards")
    private final List<c> globalMixFullCards;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("hide_empty_status")
    private final boolean hideEmptyStatus;

    @SerializedName("layout")
    private final int layout;

    @SerializedName("mix_full_cards")
    private final List<c> mixFullCards;

    @SerializedName("search_hint")
    private final String searchHint;

    @SerializedName("select_category")
    private final String selectCategoryId;

    @SerializedName("select_sub_category")
    private final String selectSubCategory;

    @SerializedName("sort_types")
    private final List<com.bytedance.android.ec.window.base.repository.dto.q> sortType;

    @SerializedName("ecom_window_goods_sticky_area")
    private final int stickyArea;

    @SerializedName("sub_category_list")
    private final List<p> subCategorys;

    @SerializedName("select_tab_type")
    private final Integer tabType;

    @SerializedName("tabs")
    private final List<i> tabs;

    @SerializedName("top_cards")
    private final c topCards;

    public WindowTabDataListResponseDTODeprecated() {
        this(null, null, null, null, null, null, false, 0, null, null, null, null, null, 0, null, null, false, 0, null, null, null, 2097151, null);
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public int cardCount() {
        List<c> r100 = this.mixFullCards;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public List<p> categories() {
        List<p> r100 = this.category;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public WindowLayoutType getWindowLayoutType() {
        WindowLayoutType.a r100 = WindowLayoutType.Companion;
        Integer r101 = Integer.valueOf(this.layout);
        r100.getClass();
        WindowLayoutType r102 = WindowLayoutType.a.b(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return WindowLayoutType.SINGLECOLUMN;
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public List<p> subCategories() {
        List<p> r100 = this.subCategorys;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public int getWindowStatusCode() {
        return getStatusCode();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public String msg() {
        String r100 = getMessage();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final List<p> getCategory() {
        return this.category;
    }

    public final String getCategoryData() {
        return this.categoryData;
    }

    public final String getCommonPassThrough() {
        return this.commonPassThrough;
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final List<nq3.a> getDynamicViews() {
        return this.dynamicViews;
    }

    public final v getExtensionCardControl() {
        return this.extensionCardControl;
    }

    public final List<a> getFilterType() {
        return this.filterType;
    }

    public final List<c> getGlobalMixFullCards() {
        return this.globalMixFullCards;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getHideEmptyStatus() {
        return this.hideEmptyStatus;
    }

    public final int getLayout() {
        return this.layout;
    }

    public final List<c> getMixFullCards() {
        return this.mixFullCards;
    }

    public final String getSearchHint() {
        return this.searchHint;
    }

    public final String getSelectCategoryId() {
        return this.selectCategoryId;
    }

    public final String getSelectSubCategory() {
        return this.selectSubCategory;
    }

    public final List<com.bytedance.android.ec.window.base.repository.dto.q> getSortType() {
        return this.sortType;
    }

    public final int getStickyArea() {
        return this.stickyArea;
    }

    public final List<p> getSubCategorys() {
        return this.subCategorys;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public final List<i> getTabs() {
        return this.tabs;
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public String getTargetSelectCategoryId() {
        return this.selectCategoryId;
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public String getTargetSelectSubCategoryId() {
        return this.selectSubCategory;
    }

    public final c getTopCards() {
        return this.topCards;
    }

    public WindowTabDataListResponseDTODeprecated(Integer r100, String r101, List<a> r102, List<c> r103, String r104, List<c> r105, boolean r106, int r110, List<com.bytedance.android.ec.window.base.repository.dto.q> r111, List<i> r112, String r113, String r114, v r115, int r116, c r117, List<p> r118, boolean r119, int r210, List<p> r211, List<nq3.a> r212, String r213) {
        this.tabType = r100;
        this.selectCategoryId = r101;
        this.filterType = r102;
        this.mixFullCards = r103;
        this.categoryData = r104;
        this.globalMixFullCards = r105;
        this.hasMore = r106;
        this.cursor = r110;
        this.sortType = r111;
        this.tabs = r112;
        this.searchHint = r113;
        this.commonPassThrough = r114;
        this.extensionCardControl = r115;
        this.layout = r116;
        this.topCards = r117;
        this.category = r118;
        this.hideEmptyStatus = r119;
        this.stickyArea = r210;
        this.subCategorys = r211;
        this.dynamicViews = r212;
        this.selectSubCategory = r213;
    }

    public /* synthetic */ WindowTabDataListResponseDTODeprecated(Integer r210, String r211, List r212, List r213, String r214, List r215, boolean r216, int r310, List r311, List r312, String r313, String r314, v r315, int r316, c r317, List r318, boolean r319, int r410, List r411, List r412, String r413, int r414, DefaultConstructorMarker r415) {
        if ((r414 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r414 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r414 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r414 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r414 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r414 & 32) == 0) goto L25;
        List r105 = null;
    L27:
        if ((r414 & 64) == 0) goto L29;
        boolean r106 = false;
    L31:
        if ((r414 & 128) == 0) goto L33;
        int r110 = 0;
    L35:
        if ((r414 & 256) == 0) goto L37;
        List r111 = null;
    L39:
        if ((r414 & 512) == 0) goto L41;
        List r112 = null;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        v r115 = null;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        int r107 = -1;
    L59:
        if ((r414 & 16384) == 0) goto L61;
        c r108 = null;
    L63:
        if ((r414 & 32768) == 0) goto L65;
        List r116 = null;
    L67:
        if ((r414 & 65536) == 0) goto L69;
        boolean r117 = false;
    L71:
        if ((r414 & 131072) == 0) goto L73;
        int r118 = 0;
    L75:
        if ((r414 & 262144) == 0) goto L77;
        List r119 = null;
    L79:
        if ((r414 & 524288) == 0) goto L81;
        List r217 = null;
    L83:
        if ((r414 & 1048576) == 0) goto L85;
        String r109 = null;
    L86:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r217, r109);
        return;
    L85:
        r109 = r413;
        goto L86
    L81:
        r217 = r412;
        goto L83
    L77:
        r119 = r411;
        goto L79
    L73:
        r118 = r410;
        goto L75
    L69:
        r117 = r319;
        goto L71
    L65:
        r116 = r318;
        goto L67
    L61:
        r108 = r317;
        goto L63
    L57:
        r107 = r316;
        goto L59
    L53:
        r115 = r315;
        goto L55
    L49:
        r114 = r314;
        goto L51
    L45:
        r113 = r313;
        goto L47
    L41:
        r112 = r312;
        goto L43
    L37:
        r111 = r311;
        goto L39
    L33:
        r110 = r310;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
