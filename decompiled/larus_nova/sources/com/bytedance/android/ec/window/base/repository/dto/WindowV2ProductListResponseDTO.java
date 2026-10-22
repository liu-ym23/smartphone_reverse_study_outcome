package com.bytedance.android.ec.window.base.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001Bù\u0001\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\b\b\u0002\u0010$\u001a\u00020\u000b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0002\u0012\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001e¢\u0006\u0004\bZ\u0010[J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0002HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001eHÆ\u0003J\u0082\u0002\u00101\u001a\u00020\u00002\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00022\b\b\u0002\u0010#\u001a\u00020\t2\b\b\u0002\u0010$\u001a\u00020\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00022\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b1\u00102J\t\u00103\u001a\u00020\u0010HÖ\u0001J\t\u00104\u001a\u00020\rHÖ\u0001J\u0013\u00107\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u000105HÖ\u0003R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b9\u0010:R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\b;\u0010:R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00108\u001a\u0004\b<\u0010:R\u001a\u0010#\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010$\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010%\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010C\u001a\u0004\bD\u0010\u000fR\u001c\u0010&\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010E\u001a\u0004\bF\u0010GR\u001c\u0010'\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010H\u001a\u0004\bI\u0010JR\u001c\u0010(\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010C\u001a\u0004\bK\u0010\u000fR$\u0010)\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010C\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010NR\u001c\u0010*\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010E\u001a\u0004\bO\u0010GR\u001c\u0010+\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010E\u001a\u0004\bP\u0010GR$\u0010,\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010E\u001a\u0004\bQ\u0010G\"\u0004\bR\u0010SR\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u00108\u001a\u0004\bT\u0010:R\u001c\u0010.\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010E\u001a\u0004\bU\u0010GR\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u00108\u001a\u0004\bV\u0010:R(\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010W\u001a\u0004\bX\u0010Y¨\u0006\\"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductListResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Lcom/bytedance/android/ec/window/base/repository/dto/p;", "component1", "Lcom/bytedance/android/ec/window/base/repository/dto/q;", "component2", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "component3", "", "component4", "", "component5", "", "component6", "()Ljava/lang/Integer;", "", "component7", "Lcom/bytedance/android/ec/window/base/repository/dto/StoreV2CartsInfoDTO;", "component8", "component9", "component10", "component11", "component12", "component13", "Lcom/bytedance/android/ec/window/base/repository/dto/d;", "component14", "component15", "Lcom/bytedance/android/ec/window/base/repository/dto/i;", "component16", "", "component17", "goodTypes", "sortTypes", "products", EffectConfiguration.KEY_CURSOR, "hasMore", "styleType", "materialTitle", "cartsInfo", "layout", "recommendModuleType", "bottomModuleParams", "nextPageParams", "innerflowSchema", "selectButtons", "toast", "pickTypes", "bizExtra", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;JZLjava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/window/base/repository/dto/StoreV2CartsInfoDTO;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductListResponseDTO;", "toString", "hashCode", "", "other", "equals", "Ljava/util/List;", "getGoodTypes", "()Ljava/util/List;", "getSortTypes", "getProducts", "J", "getCursor", "()J", "Z", "getHasMore", "()Z", "Ljava/lang/Integer;", "getStyleType", "Ljava/lang/String;", "getMaterialTitle", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/window/base/repository/dto/StoreV2CartsInfoDTO;", "getCartsInfo", "()Lcom/bytedance/android/ec/window/base/repository/dto/StoreV2CartsInfoDTO;", "getLayout", "getRecommendModuleType", "setRecommendModuleType", "(Ljava/lang/Integer;)V", "getBottomModuleParams", "getNextPageParams", "getInnerflowSchema", "setInnerflowSchema", "(Ljava/lang/String;)V", "getSelectButtons", "getToast", "getPickTypes", "Ljava/util/Map;", "getBizExtra", "()Ljava/util/Map;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;JZLjava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/window/base/repository/dto/StoreV2CartsInfoDTO;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowV2ProductListResponseDTO extends CommerceBaseResponse {

    @SerializedName("biz_extra")
    private final Map<String, String> bizExtra;

    @SerializedName("bottom_module_params")
    private final String bottomModuleParams;

    @SerializedName("carts_info")
    private final StoreV2CartsInfoDTO cartsInfo;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final long cursor;

    @SerializedName("good_types")
    private final List<p> goodTypes;

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
    private final List<i> pickTypes;

    @SerializedName("products")
    private final List<WindowV2ProductItemDTO> products;

    @SerializedName("bottom_module_type")
    private Integer recommendModuleType;

    @SerializedName("select_buttons")
    private final List<d> selectButtons;

    @SerializedName("sort_types")
    private final List<q> sortTypes;

    @SerializedName("product_style_type")
    private final Integer styleType;

    @SerializedName("toast")
    private final String toast;

    public WindowV2ProductListResponseDTO() {
        this(null, null, null, 0, false, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WindowV2ProductListResponseDTO copy$default(WindowV2ProductListResponseDTO r110, List r111, List r112, List r210, long r211, boolean r212, Integer r213, String r214, StoreV2CartsInfoDTO r215, Integer r216, Integer r217, String r218, String r310, String r311, List r312, String r313, List r314, Map r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        List r100 = r110.goodTypes;
    L7:
        if ((r316 & 2) == 0) goto L9;
        List r101 = r110.sortTypes;
    L11:
        if ((r316 & 4) == 0) goto L13;
        List r102 = r110.products;
    L15:
        if ((r316 & 8) == 0) goto L17;
        long r103 = r110.cursor;
    L19:
        if ((r316 & 16) == 0) goto L21;
        boolean r104 = r110.hasMore;
    L23:
        if ((r316 & 32) == 0) goto L25;
        Integer r105 = r110.styleType;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = r110.materialTitle;
    L31:
        if ((r316 & 128) == 0) goto L33;
        StoreV2CartsInfoDTO r113 = r110.cartsInfo;
    L35:
        if ((r316 & 256) == 0) goto L37;
        Integer r114 = r110.layout;
    L39:
        if ((r316 & 512) == 0) goto L41;
        Integer r115 = r110.recommendModuleType;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r116 = r110.bottomModuleParams;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r117 = r110.nextPageParams;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r118 = r110.innerflowSchema;
    L54:
        String r318 = r118;
        if ((r316 & 8192) == 0) goto L57;
        List r119 = r110.selectButtons;
    L58:
        List r319 = r119;
        if ((r316 & 16384) == 0) goto L61;
        String r120 = r110.toast;
    L62:
        String r320 = r120;
        if ((r316 & 32768) == 0) goto L65;
        List r121 = r110.pickTypes;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        Map r107 = r110.bizExtra;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r318, r319, r320, r121, r107);
    L69:
        r107 = r315;
        goto L71
    L65:
        r121 = r314;
        goto L67
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

    public final List<p> component1() {
        return this.goodTypes;
    }

    public final Integer component10() {
        return this.recommendModuleType;
    }

    public final String component11() {
        return this.bottomModuleParams;
    }

    public final String component12() {
        return this.nextPageParams;
    }

    public final String component13() {
        return this.innerflowSchema;
    }

    public final List<d> component14() {
        return this.selectButtons;
    }

    public final String component15() {
        return this.toast;
    }

    public final List<i> component16() {
        return this.pickTypes;
    }

    public final Map<String, String> component17() {
        return this.bizExtra;
    }

    public final List<q> component2() {
        return this.sortTypes;
    }

    public final List<WindowV2ProductItemDTO> component3() {
        return this.products;
    }

    public final long component4() {
        return this.cursor;
    }

    public final boolean component5() {
        return this.hasMore;
    }

    public final Integer component6() {
        return this.styleType;
    }

    public final String component7() {
        return this.materialTitle;
    }

    public final StoreV2CartsInfoDTO component8() {
        return this.cartsInfo;
    }

    public final Integer component9() {
        return this.layout;
    }

    public final WindowV2ProductListResponseDTO copy(List<p> r210, List<q> r211, List<? extends WindowV2ProductItemDTO> r212, long r213, boolean r214, Integer r215, String r216, StoreV2CartsInfoDTO r217, Integer r310, Integer r311, String r312, String r313, String r314, List<d> r315, String r316, List<i> r317, Map<String, String> r318) {
        return new WindowV2ProductListResponseDTO(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowV2ProductListResponseDTO) == false) goto L40;
        WindowV2ProductListResponseDTO r101 = (WindowV2ProductListResponseDTO) r100;
        if (Intrinsics.areEqual(this.goodTypes, r101.goodTypes) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sortTypes, r101.sortTypes) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.products, r101.products) == true) goto L12;
        return false;
    L12:
        if (this.cursor == r101.cursor) goto L14;
        return false;
    L14:
        if (this.hasMore == r101.hasMore) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.styleType, r101.styleType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.materialTitle, r101.materialTitle) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.cartsInfo, r101.cartsInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.layout, r101.layout) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.recommendModuleType, r101.recommendModuleType) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.bottomModuleParams, r101.bottomModuleParams) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.nextPageParams, r101.nextPageParams) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.innerflowSchema, r101.innerflowSchema) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.selectButtons, r101.selectButtons) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.toast, r101.toast) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.pickTypes, r101.pickTypes) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.bizExtra, r101.bizExtra) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        List<p> r100 = this.goodTypes;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<q> r104 = this.sortTypes;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<WindowV2ProductItemDTO> r107 = this.products;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.cursor;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        boolean r112 = this.hasMore;
        ?? r113 = r112;
        if (r112 == false) goto L17;
        r113 = 1;
    L17:
        int r114 = (r111 + r113) * 31;
        Integer r115 = this.styleType;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        String r118 = this.materialTitle;
        if (r118 == null) goto L24;
        int r119 = r118.hashCode();
    L25:
        int r120 = (r117 + r119) * 31;
        StoreV2CartsInfoDTO r121 = this.cartsInfo;
        if (r121 == null) goto L28;
        int r122 = r121.hashCode();
    L29:
        int r123 = (r120 + r122) * 31;
        Integer r124 = this.layout;
        if (r124 == null) goto L32;
        int r125 = r124.hashCode();
    L33:
        int r126 = (r123 + r125) * 31;
        Integer r127 = this.recommendModuleType;
        if (r127 == null) goto L36;
        int r128 = r127.hashCode();
    L37:
        int r129 = (r126 + r128) * 31;
        String r130 = this.bottomModuleParams;
        if (r130 == null) goto L40;
        int r131 = r130.hashCode();
    L41:
        int r132 = (r129 + r131) * 31;
        String r133 = this.nextPageParams;
        if (r133 == null) goto L44;
        int r134 = r133.hashCode();
    L45:
        int r135 = (r132 + r134) * 31;
        String r136 = this.innerflowSchema;
        if (r136 == null) goto L48;
        int r137 = r136.hashCode();
    L49:
        int r138 = (r135 + r137) * 31;
        List<d> r139 = this.selectButtons;
        if (r139 == null) goto L52;
        int r140 = r139.hashCode();
    L53:
        int r141 = (r138 + r140) * 31;
        String r142 = this.toast;
        if (r142 == null) goto L56;
        int r143 = r142.hashCode();
    L57:
        int r144 = (r141 + r143) * 31;
        List<i> r145 = this.pickTypes;
        if (r145 == null) goto L60;
        int r146 = r145.hashCode();
    L61:
        int r147 = (r144 + r146) * 31;
        Map<String, String> r148 = this.bizExtra;
        if (r148 == null) goto L65;
        r101 = r148.hashCode();
    L65:
        return r147 + r101;
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
    L20:
        r116 = 0;
        goto L21
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
        return "WindowV2ProductListResponseDTO(goodTypes=" + this.goodTypes + ", sortTypes=" + this.sortTypes + ", products=" + this.products + ", cursor=" + this.cursor + ", hasMore=" + this.hasMore + ", styleType=" + this.styleType + ", materialTitle=" + this.materialTitle + ", cartsInfo=" + this.cartsInfo + ", layout=" + this.layout + ", recommendModuleType=" + this.recommendModuleType + ", bottomModuleParams=" + this.bottomModuleParams + ", nextPageParams=" + this.nextPageParams + ", innerflowSchema=" + this.innerflowSchema + ", selectButtons=" + this.selectButtons + ", toast=" + this.toast + ", pickTypes=" + this.pickTypes + ", bizExtra=" + this.bizExtra + ")";
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

    public final List<p> getGoodTypes() {
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

    public final List<i> getPickTypes() {
        return this.pickTypes;
    }

    public final List<WindowV2ProductItemDTO> getProducts() {
        return this.products;
    }

    public final Integer getRecommendModuleType() {
        return this.recommendModuleType;
    }

    public final List<d> getSelectButtons() {
        return this.selectButtons;
    }

    public final List<q> getSortTypes() {
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
    public WindowV2ProductListResponseDTO(List<p> r100, List<q> r101, List<? extends WindowV2ProductItemDTO> r102, long r103, boolean r104, Integer r110, String r111, StoreV2CartsInfoDTO r112, Integer r113, Integer r114, String r115, String r116, String r117, List<d> r118, String r119, List<i> r210, Map<String, String> r211) {
        this.goodTypes = r100;
        this.sortTypes = r101;
        this.products = r102;
        this.cursor = r103;
        this.hasMore = r104;
        this.styleType = r110;
        this.materialTitle = r111;
        this.cartsInfo = r112;
        this.layout = r113;
        this.recommendModuleType = r114;
        this.bottomModuleParams = r115;
        this.nextPageParams = r116;
        this.innerflowSchema = r117;
        this.selectButtons = r118;
        this.toast = r119;
        this.pickTypes = r210;
        this.bizExtra = r211;
    }

    public /* synthetic */ WindowV2ProductListResponseDTO(List r210, List r211, List r212, long r213, boolean r214, Integer r215, String r216, StoreV2CartsInfoDTO r217, Integer r218, Integer r310, String r311, String r312, String r313, List r314, String r315, List r316, Map r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        long r103 = 0;
    L19:
        if ((r318 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r318 & 32) == 0) goto L25;
        Integer r105 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        StoreV2CartsInfoDTO r110 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        Integer r111 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        Integer r112 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        List r107 = null;
    L58:
        List r116 = r107;
        if ((r318 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        List r117 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        Map r109 = null;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r108, r117, r109);
        return;
    L69:
        r109 = r317;
        goto L70
    L65:
        r117 = r316;
        goto L67
    L61:
        r108 = r315;
        goto L63
    L57:
        r107 = r314;
        goto L58
    L53:
        r115 = r313;
        goto L55
    L49:
        r114 = r312;
        goto L51
    L45:
        r113 = r311;
        goto L47
    L41:
        r112 = r310;
        goto L43
    L37:
        r111 = r218;
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
