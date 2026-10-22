package com.bytedance.android.ec.store.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0002\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\b\b\u0002\u0010&\u001a\u00020\f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0002\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0002\u0012\u0016\b\u0002\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001f¢\u0006\u0004\b]\u0010^J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0002HÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001fHÆ\u0003J\u0094\u0002\u00103\u001a\u00020\u00002\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00022\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00022\u0016\b\u0002\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001fHÆ\u0001¢\u0006\u0004\b3\u00104J\t\u00105\u001a\u00020\u0011HÖ\u0001J\t\u00106\u001a\u00020\u000eHÖ\u0001J\u0013\u00109\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\b;\u0010<R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\b=\u0010<R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010:\u001a\u0004\b>\u0010<R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010:\u001a\u0004\b?\u0010<R\u001a\u0010%\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010&\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010C\u001a\u0004\bD\u0010ER\u001c\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010F\u001a\u0004\bG\u0010\u0010R\u001c\u0010(\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010)\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010F\u001a\u0004\bN\u0010\u0010R$\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010F\u001a\u0004\bO\u0010\u0010\"\u0004\bP\u0010QR\u001c\u0010,\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010H\u001a\u0004\bR\u0010JR\u001c\u0010-\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010H\u001a\u0004\bS\u0010JR$\u0010.\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010H\u001a\u0004\bT\u0010J\"\u0004\bU\u0010VR\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010:\u001a\u0004\bW\u0010<R\u001c\u00100\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010H\u001a\u0004\bX\u0010JR\"\u00101\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010:\u001a\u0004\bY\u0010<R(\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010Z\u001a\u0004\b[\u0010\\¨\u0006_"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/StoreV2ProductListResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/ec/store/repository/dto/k;", "component1", "Lcom/bytedance/android/ec/store/repository/dto/m;", "component2", "component3", "Lcom/bytedance/android/ec/store/repository/dto/l;", "component4", "", "component5", "", "component6", "", "component7", "()Ljava/lang/Integer;", "", "component8", "Lcom/bytedance/android/ec/store/repository/dto/StoreV2CartsInfoDTO;", "component9", "component10", "component11", "component12", "component13", "component14", "Lcom/bytedance/android/ec/store/repository/dto/c;", "component15", "component16", "Lcom/bytedance/android/ec/store/repository/dto/g;", "component17", "", "component18", "goodTypes", "sortTypes", "filters", "products", EffectConfiguration.KEY_CURSOR, "hasMore", "styleType", "materialTitle", "cartsInfo", "layout", "recommendModuleType", "bottomModuleParams", "nextPageParams", "innerflowSchema", "selectButtons", "toast", "pickTypes", "bizExtra", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;JZLjava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/store/repository/dto/StoreV2CartsInfoDTO;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lcom/bytedance/android/ec/store/repository/dto/StoreV2ProductListResponseDTO;", "toString", "hashCode", "", "other", "equals", "Ljava/util/List;", "getGoodTypes", "()Ljava/util/List;", "getSortTypes", "getFilters", "getProducts", "J", "getCursor", "()J", "Z", "getHasMore", "()Z", "Ljava/lang/Integer;", "getStyleType", "Ljava/lang/String;", "getMaterialTitle", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/store/repository/dto/StoreV2CartsInfoDTO;", "getCartsInfo", "()Lcom/bytedance/android/ec/store/repository/dto/StoreV2CartsInfoDTO;", "getLayout", "getRecommendModuleType", "setRecommendModuleType", "(Ljava/lang/Integer;)V", "getBottomModuleParams", "getNextPageParams", "getInnerflowSchema", "setInnerflowSchema", "(Ljava/lang/String;)V", "getSelectButtons", "getToast", "getPickTypes", "Ljava/util/Map;", "getBizExtra", "()Ljava/util/Map;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;JZLjava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/store/repository/dto/StoreV2CartsInfoDTO;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreV2ProductListResponseDTO extends CommerceBaseResponse {

    @SerializedName("biz_extra")
    private final Map<String, String> bizExtra;

    @SerializedName("bottom_module_params")
    private final String bottomModuleParams;

    @SerializedName("carts_info")
    private final StoreV2CartsInfoDTO cartsInfo;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final long cursor;

    @SerializedName("filters")
    private final List<m> filters;

    @SerializedName("good_types")
    private final List<k> goodTypes;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("innerflow_schema")
    private String innerflowSchema;

    @SerializedName("layout")
    private final Integer layout;

    @SerializedName("material_title")
    private final String materialTitle;

    @SerializedName("next_page_params")
    private final String nextPageParams;

    @SerializedName("pick_types")
    private final List<g> pickTypes;

    @SerializedName("products")
    private final List<l> products;

    @SerializedName("bottom_module_type")
    private Integer recommendModuleType;

    @SerializedName("select_buttons")
    private final List<c> selectButtons;

    @SerializedName("sort_types")
    private final List<m> sortTypes;

    @SerializedName("product_style_type")
    private final Integer styleType;

    @SerializedName("toast")
    private final String toast;

    public StoreV2ProductListResponseDTO() {
        this(null, null, null, null, 0, false, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreV2ProductListResponseDTO copy$default(StoreV2ProductListResponseDTO r110, List r111, List r112, List r210, List r211, long r212, boolean r213, Integer r214, String r215, StoreV2CartsInfoDTO r216, Integer r217, Integer r218, String r310, String r311, String r312, List r313, String r314, List r315, Map r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        List r100 = r110.goodTypes;
    L7:
        if ((r317 & 2) == 0) goto L9;
        List r101 = r110.sortTypes;
    L11:
        if ((r317 & 4) == 0) goto L13;
        List r102 = r110.filters;
    L15:
        if ((r317 & 8) == 0) goto L17;
        List r103 = r110.products;
    L19:
        if ((r317 & 16) == 0) goto L21;
        long r104 = r110.cursor;
    L23:
        if ((r317 & 32) == 0) goto L25;
        boolean r105 = r110.hasMore;
    L27:
        if ((r317 & 64) == 0) goto L29;
        Integer r106 = r110.styleType;
    L31:
        if ((r317 & 128) == 0) goto L33;
        String r113 = r110.materialTitle;
    L35:
        if ((r317 & 256) == 0) goto L37;
        StoreV2CartsInfoDTO r114 = r110.cartsInfo;
    L39:
        if ((r317 & 512) == 0) goto L41;
        Integer r115 = r110.layout;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        Integer r116 = r110.recommendModuleType;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        String r117 = r110.bottomModuleParams;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        String r118 = r110.nextPageParams;
    L54:
        String r319 = r118;
        if ((r317 & 8192) == 0) goto L57;
        String r119 = r110.innerflowSchema;
    L58:
        String r320 = r119;
        if ((r317 & 16384) == 0) goto L61;
        List r120 = r110.selectButtons;
    L62:
        List r321 = r120;
        if ((r317 & 32768) == 0) goto L65;
        String r121 = r110.toast;
    L66:
        String r322 = r121;
        if ((r317 & 65536) == 0) goto L69;
        List r122 = r110.pickTypes;
    L71:
        if ((r317 & 131072) == 0) goto L73;
        Map r107 = r110.bizExtra;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r319, r320, r321, r322, r122, r107);
    L73:
        r107 = r316;
        goto L75
    L69:
        r122 = r315;
        goto L71
    L65:
        r121 = r314;
        goto L66
    L61:
        r120 = r313;
        goto L62
    L57:
        r119 = r312;
        goto L58
    L53:
        r118 = r311;
        goto L54
    L49:
        r117 = r310;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
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

    public final List<k> component1() {
        return this.goodTypes;
    }

    public final Integer component10() {
        return this.layout;
    }

    public final Integer component11() {
        return this.recommendModuleType;
    }

    public final String component12() {
        return this.bottomModuleParams;
    }

    public final String component13() {
        return this.nextPageParams;
    }

    public final String component14() {
        return this.innerflowSchema;
    }

    public final List<c> component15() {
        return this.selectButtons;
    }

    public final String component16() {
        return this.toast;
    }

    public final List<g> component17() {
        return this.pickTypes;
    }

    public final Map<String, String> component18() {
        return this.bizExtra;
    }

    public final List<m> component2() {
        return this.sortTypes;
    }

    public final List<m> component3() {
        return this.filters;
    }

    public final List<l> component4() {
        return this.products;
    }

    public final long component5() {
        return this.cursor;
    }

    public final boolean component6() {
        return this.hasMore;
    }

    public final Integer component7() {
        return this.styleType;
    }

    public final String component8() {
        return this.materialTitle;
    }

    public final StoreV2CartsInfoDTO component9() {
        return this.cartsInfo;
    }

    public final StoreV2ProductListResponseDTO copy(List<k> r210, List<m> r211, List<m> r212, List<? extends l> r213, long r214, boolean r215, Integer r216, String r310, StoreV2CartsInfoDTO r311, Integer r312, Integer r313, String r314, String r315, String r316, List<c> r317, String r318, List<g> r319, Map<String, String> r410) {
        return new StoreV2ProductListResponseDTO(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StoreV2ProductListResponseDTO) == false) goto L42;
        StoreV2ProductListResponseDTO r101 = (StoreV2ProductListResponseDTO) r100;
        if (Intrinsics.areEqual(this.goodTypes, r101.goodTypes) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sortTypes, r101.sortTypes) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.filters, r101.filters) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.products, r101.products) == true) goto L14;
        return false;
    L14:
        if (this.cursor == r101.cursor) goto L16;
        return false;
    L16:
        if (this.hasMore == r101.hasMore) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.styleType, r101.styleType) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.materialTitle, r101.materialTitle) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.cartsInfo, r101.cartsInfo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.layout, r101.layout) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.recommendModuleType, r101.recommendModuleType) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.bottomModuleParams, r101.bottomModuleParams) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.nextPageParams, r101.nextPageParams) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.innerflowSchema, r101.innerflowSchema) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.selectButtons, r101.selectButtons) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.toast, r101.toast) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.pickTypes, r101.pickTypes) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.bizExtra, r101.bizExtra) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v62 */
    public int hashCode() {
        List<k> r100 = this.goodTypes;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<m> r104 = this.sortTypes;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<m> r107 = this.filters;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<l> r110 = this.products;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.cursor;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        boolean r115 = this.hasMore;
        ?? r116 = r115;
        if (r115 == false) goto L21;
        r116 = 1;
    L21:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.styleType;
        if (r118 == null) goto L24;
        int r119 = r118.hashCode();
    L25:
        int r120 = (r117 + r119) * 31;
        String r121 = this.materialTitle;
        if (r121 == null) goto L28;
        int r122 = r121.hashCode();
    L29:
        int r123 = (r120 + r122) * 31;
        StoreV2CartsInfoDTO r124 = this.cartsInfo;
        if (r124 == null) goto L32;
        int r125 = r124.hashCode();
    L33:
        int r126 = (r123 + r125) * 31;
        Integer r127 = this.layout;
        if (r127 == null) goto L36;
        int r128 = r127.hashCode();
    L37:
        int r129 = (r126 + r128) * 31;
        Integer r130 = this.recommendModuleType;
        if (r130 == null) goto L40;
        int r131 = r130.hashCode();
    L41:
        int r132 = (r129 + r131) * 31;
        String r133 = this.bottomModuleParams;
        if (r133 == null) goto L44;
        int r134 = r133.hashCode();
    L45:
        int r135 = (r132 + r134) * 31;
        String r136 = this.nextPageParams;
        if (r136 == null) goto L48;
        int r137 = r136.hashCode();
    L49:
        int r138 = (r135 + r137) * 31;
        String r139 = this.innerflowSchema;
        if (r139 == null) goto L52;
        int r140 = r139.hashCode();
    L53:
        int r141 = (r138 + r140) * 31;
        List<c> r142 = this.selectButtons;
        if (r142 == null) goto L56;
        int r143 = r142.hashCode();
    L57:
        int r144 = (r141 + r143) * 31;
        String r145 = this.toast;
        if (r145 == null) goto L60;
        int r146 = r145.hashCode();
    L61:
        int r147 = (r144 + r146) * 31;
        List<g> r148 = this.pickTypes;
        if (r148 == null) goto L64;
        int r149 = r148.hashCode();
    L65:
        int r150 = (r147 + r149) * 31;
        Map<String, String> r151 = this.bizExtra;
        if (r151 == null) goto L69;
        r101 = r151.hashCode();
    L69:
        return r150 + r101;
    L64:
        r149 = 0;
        goto L65
    L60:
        r146 = 0;
        goto L61
    L56:
        r143 = 0;
        goto L57
    L52:
        r140 = 0;
        goto L53
    L48:
        r137 = 0;
        goto L49
    L44:
        r134 = 0;
        goto L45
    L40:
        r131 = 0;
        goto L41
    L36:
        r128 = 0;
        goto L37
    L32:
        r125 = 0;
        goto L33
    L28:
        r122 = 0;
        goto L29
    L24:
        r119 = 0;
        goto L25
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
        return "StoreV2ProductListResponseDTO(goodTypes=" + this.goodTypes + ", sortTypes=" + this.sortTypes + ", filters=" + this.filters + ", products=" + this.products + ", cursor=" + this.cursor + ", hasMore=" + this.hasMore + ", styleType=" + this.styleType + ", materialTitle=" + this.materialTitle + ", cartsInfo=" + this.cartsInfo + ", layout=" + this.layout + ", recommendModuleType=" + this.recommendModuleType + ", bottomModuleParams=" + this.bottomModuleParams + ", nextPageParams=" + this.nextPageParams + ", innerflowSchema=" + this.innerflowSchema + ", selectButtons=" + this.selectButtons + ", toast=" + this.toast + ", pickTypes=" + this.pickTypes + ", bizExtra=" + this.bizExtra + ")";
    }

    public final Map<String, String> getBizExtra() {
        return this.bizExtra;
    }

    public final String getBottomModuleParams() {
        return this.bottomModuleParams;
    }

    public final StoreV2CartsInfoDTO getCartsInfo() {
        return this.cartsInfo;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final List<m> getFilters() {
        return this.filters;
    }

    public final List<k> getGoodTypes() {
        return this.goodTypes;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getInnerflowSchema() {
        return this.innerflowSchema;
    }

    public final Integer getLayout() {
        return this.layout;
    }

    public final String getMaterialTitle() {
        return this.materialTitle;
    }

    public final String getNextPageParams() {
        return this.nextPageParams;
    }

    public final List<g> getPickTypes() {
        return this.pickTypes;
    }

    public final List<l> getProducts() {
        return this.products;
    }

    public final Integer getRecommendModuleType() {
        return this.recommendModuleType;
    }

    public final List<c> getSelectButtons() {
        return this.selectButtons;
    }

    public final List<m> getSortTypes() {
        return this.sortTypes;
    }

    public final Integer getStyleType() {
        return this.styleType;
    }

    public final String getToast() {
        return this.toast;
    }

    public final void setInnerflowSchema(String r100) {
        this.innerflowSchema = r100;
    }

    public final void setRecommendModuleType(Integer r100) {
        this.recommendModuleType = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreV2ProductListResponseDTO(List<k> r100, List<m> r101, List<m> r102, List<? extends l> r103, long r104, boolean r110, Integer r111, String r112, StoreV2CartsInfoDTO r113, Integer r114, Integer r115, String r116, String r117, String r118, List<c> r119, String r210, List<g> r211, Map<String, String> r212) {
        this.goodTypes = r100;
        this.sortTypes = r101;
        this.filters = r102;
        this.products = r103;
        this.cursor = r104;
        this.hasMore = r110;
        this.styleType = r111;
        this.materialTitle = r112;
        this.cartsInfo = r113;
        this.layout = r114;
        this.recommendModuleType = r115;
        this.bottomModuleParams = r116;
        this.nextPageParams = r117;
        this.innerflowSchema = r118;
        this.selectButtons = r119;
        this.toast = r210;
        this.pickTypes = r211;
        this.bizExtra = r212;
    }

    public /* synthetic */ StoreV2ProductListResponseDTO(List r210, List r211, List r212, List r213, long r214, boolean r215, Integer r216, String r217, StoreV2CartsInfoDTO r310, Integer r311, Integer r312, String r313, String r314, String r315, List r316, String r317, List r318, Map r319, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        List r103 = null;
    L19:
        if ((r410 & 16) == 0) goto L21;
        long r104 = 0;
    L23:
        if ((r410 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r410 & 64) == 0) goto L29;
        Integer r106 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        StoreV2CartsInfoDTO r111 = null;
    L39:
        if ((r410 & 512) == 0) goto L41;
        Integer r112 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        Integer r113 = null;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        String r107 = null;
    L58:
        String r116 = r107;
        if ((r410 & 16384) == 0) goto L61;
        List r108 = null;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r410 & 65536) == 0) goto L69;
        List r118 = null;
    L71:
        if ((r410 & 131072) == 0) goto L73;
        Map r109 = null;
    L74:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r108, r117, r118, r109);
        return;
    L73:
        r109 = r319;
        goto L74
    L69:
        r118 = r318;
        goto L71
    L65:
        r117 = r317;
        goto L67
    L61:
        r108 = r316;
        goto L63
    L57:
        r107 = r315;
        goto L58
    L53:
        r115 = r314;
        goto L55
    L49:
        r114 = r313;
        goto L51
    L45:
        r113 = r312;
        goto L47
    L41:
        r112 = r311;
        goto L43
    L37:
        r111 = r310;
        goto L39
    L33:
        r110 = r217;
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
