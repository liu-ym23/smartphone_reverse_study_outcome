package com.bytedance.android.shopping.new_cart.params;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b-\b\u0086\b\u0018\u0000 Y2\u00020\u0001:\u0001ZBã\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0013\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bW\u0010XJ\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000eHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0013HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jå\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010%\u001a\u00020\u00132\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0013HÖ\u0001J\u0013\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b3\u00102R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b4\u00102R$\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00100\u001a\u0004\b5\u00102\"\u0004\b6\u00107R$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00100\u001a\u0004\b8\u00102\"\u0004\b9\u00107R$\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00100\u001a\u0004\b:\u00102\"\u0004\b;\u00107R$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00100\u001a\u0004\b<\u00102\"\u0004\b=\u00107R$\u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00100\u001a\u0004\b>\u00102\"\u0004\b?\u00107RB\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00100\u001a\u0004\bE\u00102\"\u0004\bF\u00107R$\u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00100\u001a\u0004\bG\u00102\"\u0004\bH\u00107R$\u0010$\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\bI\u00102\"\u0004\bJ\u00107R\"\u0010%\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u00100\u001a\u0004\bP\u00102\"\u0004\bQ\u00107R\u001c\u0010'\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010R\u001a\u0004\bS\u0010TR$\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u00100\u001a\u0004\bU\u00102\"\u0004\bV\u00107¨\u0006["}, d2 = {"Lcom/bytedance/android/shopping/new_cart/params/CartParams;", "Ljava/io/Serializable;", "", "", "getSchemaParamsOrCreate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component9", "component10", "component11", "component12", "", "component13", "component14", "Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "component15", "component16", "newSourceType", "historyPath", "enterFromLiveSaas", "ecomSceneId", "cartIds", "shopIds", "showShopIds", "anchorCartId", "schemaParams", "durationMonitorKey", "yataPerfMonitorKey", "transparentParams", "heightPercent", "deliverySessionId", "pageInfo", "splitActivityScene", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getNewSourceType", "()Ljava/lang/String;", "getHistoryPath", "getEnterFromLiveSaas", "getEcomSceneId", "setEcomSceneId", "(Ljava/lang/String;)V", "getCartIds", "setCartIds", "getShopIds", "setShopIds", "getShowShopIds", "setShowShopIds", "getAnchorCartId", "setAnchorCartId", "Ljava/util/HashMap;", "getSchemaParams", "()Ljava/util/HashMap;", "setSchemaParams", "(Ljava/util/HashMap;)V", "getDurationMonitorKey", "setDurationMonitorKey", "getYataPerfMonitorKey", "setYataPerfMonitorKey", "getTransparentParams", "setTransparentParams", "I", "getHeightPercent", "()I", "setHeightPercent", "(I)V", "getDeliverySessionId", "setDeliverySessionId", "Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "getPageInfo", "()Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "getSplitActivityScene", "setSplitActivityScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartParams implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("anchor_cart_id")
    private String anchorCartId;

    @SerializedName("cart_ids")
    private String cartIds;

    @SerializedName("delivery_session_id")
    private String deliverySessionId;

    @SerializedName("ec_monitor_key")
    private String durationMonitorKey;

    @SerializedName("ecom_scene_id")
    private String ecomSceneId;

    @SerializedName("enter_from_live_saas")
    private final String enterFromLiveSaas;

    @SerializedName(ECFindSimilarConfig.HEIGHT_PERCENT)
    private int heightPercent;

    @SerializedName("history_path")
    private final String historyPath;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE)
    private final String newSourceType;

    @SerializedName("page_info")
    private final YataPageInfo pageInfo;

    @SerializedName("schema_params")
    private HashMap<String, String> schemaParams;

    @SerializedName("shop_ids")
    private String shopIds;

    @SerializedName("show_shop_ids")
    private String showShopIds;

    @SerializedName("split_activity_scene")
    private String splitActivityScene;

    @SerializedName("transparent_params")
    private String transparentParams;

    @SerializedName("yata_monitor_key")
    private String yataPerfMonitorKey;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CartParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CartParams copy$default(CartParams r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, HashMap r216, String r217, String r218, String r219, int r310, String r311, YataPageInfo r312, String r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.newSourceType;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.historyPath;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.enterFromLiveSaas;
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = r110.ecomSceneId;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = r110.cartIds;
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = r110.shopIds;
    L27:
        if ((r314 & 64) == 0) goto L29;
        String r106 = r110.showShopIds;
    L31:
        if ((r314 & 128) == 0) goto L33;
        String r107 = r110.anchorCartId;
    L35:
        if ((r314 & 256) == 0) goto L37;
        HashMap r113 = r110.schemaParams;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r114 = r110.durationMonitorKey;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r115 = r110.yataPerfMonitorKey;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r116 = r110.transparentParams;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        int r117 = r110.heightPercent;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r118 = r110.deliverySessionId;
    L58:
        String r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        YataPageInfo r119 = r110.pageInfo;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r108 = r110.splitActivityScene;
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

    public final String component1() {
        return this.newSourceType;
    }

    public final String component10() {
        return this.durationMonitorKey;
    }

    public final String component11() {
        return this.yataPerfMonitorKey;
    }

    public final String component12() {
        return this.transparentParams;
    }

    public final int component13() {
        return this.heightPercent;
    }

    public final String component14() {
        return this.deliverySessionId;
    }

    public final YataPageInfo component15() {
        return this.pageInfo;
    }

    public final String component16() {
        return this.splitActivityScene;
    }

    public final String component2() {
        return this.historyPath;
    }

    public final String component3() {
        return this.enterFromLiveSaas;
    }

    public final String component4() {
        return this.ecomSceneId;
    }

    public final String component5() {
        return this.cartIds;
    }

    public final String component6() {
        return this.shopIds;
    }

    public final String component7() {
        return this.showShopIds;
    }

    public final String component8() {
        return this.anchorCartId;
    }

    public final HashMap<String, String> component9() {
        return this.schemaParams;
    }

    public final CartParams copy(String r110, String r210, String r211, String r212, String r213, String r214, String r215, String r216, HashMap<String, String> r217, String r218, String r219, String r310, int r311, String r312, YataPageInfo r313, String r314) {
        return new CartParams(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CartParams) == false) goto L38;
        CartParams r101 = (CartParams) r100;
        if (Intrinsics.areEqual(this.newSourceType, r101.newSourceType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.historyPath, r101.historyPath) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterFromLiveSaas, r101.enterFromLiveSaas) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomSceneId, r101.ecomSceneId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cartIds, r101.cartIds) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopIds, r101.shopIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showShopIds, r101.showShopIds) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.anchorCartId, r101.anchorCartId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.schemaParams, r101.schemaParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.durationMonitorKey, r101.durationMonitorKey) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.yataPerfMonitorKey, r101.yataPerfMonitorKey) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.transparentParams, r101.transparentParams) == true) goto L30;
        return false;
    L30:
        if (this.heightPercent == r101.heightPercent) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.deliverySessionId, r101.deliverySessionId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.pageInfo, r101.pageInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.splitActivityScene, r101.splitActivityScene) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        String r100 = this.newSourceType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.historyPath;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.enterFromLiveSaas;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.ecomSceneId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.cartIds;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.shopIds;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.showShopIds;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.anchorCartId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        HashMap<String, String> r125 = this.schemaParams;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.durationMonitorKey;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.yataPerfMonitorKey;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.transparentParams;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (((r133 + r135) * 31) + this.heightPercent) * 31;
        String r137 = this.deliverySessionId;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        YataPageInfo r140 = this.pageInfo;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.splitActivityScene;
        if (r143 == null) goto L62;
        r101 = r143.hashCode();
    L62:
        return r142 + r101;
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
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
        return "CartParams(newSourceType=" + this.newSourceType + ", historyPath=" + this.historyPath + ", enterFromLiveSaas=" + this.enterFromLiveSaas + ", ecomSceneId=" + this.ecomSceneId + ", cartIds=" + this.cartIds + ", shopIds=" + this.shopIds + ", showShopIds=" + this.showShopIds + ", anchorCartId=" + this.anchorCartId + ", schemaParams=" + this.schemaParams + ", durationMonitorKey=" + this.durationMonitorKey + ", yataPerfMonitorKey=" + this.yataPerfMonitorKey + ", transparentParams=" + this.transparentParams + ", heightPercent=" + this.heightPercent + ", deliverySessionId=" + this.deliverySessionId + ", pageInfo=" + this.pageInfo + ", splitActivityScene=" + this.splitActivityScene + ")";
    }

    public final Map<String, String> getSchemaParamsOrCreate() {
        HashMap<String, String> r100 = this.schemaParams;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new HashMap();
    }

    public final String getAnchorCartId() {
        return this.anchorCartId;
    }

    public final String getCartIds() {
        return this.cartIds;
    }

    public final String getDeliverySessionId() {
        return this.deliverySessionId;
    }

    public final String getDurationMonitorKey() {
        return this.durationMonitorKey;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final String getEnterFromLiveSaas() {
        return this.enterFromLiveSaas;
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final String getHistoryPath() {
        return this.historyPath;
    }

    public final String getNewSourceType() {
        return this.newSourceType;
    }

    public final YataPageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final HashMap<String, String> getSchemaParams() {
        return this.schemaParams;
    }

    public final String getShopIds() {
        return this.shopIds;
    }

    public final String getShowShopIds() {
        return this.showShopIds;
    }

    public final String getSplitActivityScene() {
        return this.splitActivityScene;
    }

    public final String getTransparentParams() {
        return this.transparentParams;
    }

    public final String getYataPerfMonitorKey() {
        return this.yataPerfMonitorKey;
    }

    public final void setAnchorCartId(String r100) {
        this.anchorCartId = r100;
    }

    public final void setCartIds(String r100) {
        this.cartIds = r100;
    }

    public final void setDeliverySessionId(String r100) {
        this.deliverySessionId = r100;
    }

    public final void setDurationMonitorKey(String r100) {
        this.durationMonitorKey = r100;
    }

    public final void setEcomSceneId(String r100) {
        this.ecomSceneId = r100;
    }

    public final void setHeightPercent(int r100) {
        this.heightPercent = r100;
    }

    public final void setSchemaParams(HashMap<String, String> r100) {
        this.schemaParams = r100;
    }

    public final void setShopIds(String r100) {
        this.shopIds = r100;
    }

    public final void setShowShopIds(String r100) {
        this.showShopIds = r100;
    }

    public final void setSplitActivityScene(String r100) {
        this.splitActivityScene = r100;
    }

    public final void setTransparentParams(String r100) {
        this.transparentParams = r100;
    }

    public final void setYataPerfMonitorKey(String r100) {
        this.yataPerfMonitorKey = r100;
    }

    public CartParams(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, HashMap<String, String> r111, String r112, String r113, String r114, int r115, String r116, YataPageInfo r117, String r118) {
        this.newSourceType = r100;
        this.historyPath = r101;
        this.enterFromLiveSaas = r102;
        this.ecomSceneId = r103;
        this.cartIds = r104;
        this.shopIds = r105;
        this.showShopIds = r106;
        this.anchorCartId = r110;
        this.schemaParams = r111;
        this.durationMonitorKey = r112;
        this.yataPerfMonitorKey = r113;
        this.transparentParams = r114;
        this.heightPercent = r115;
        this.deliverySessionId = r116;
        this.pageInfo = r117;
        this.splitActivityScene = r118;
    }

    public /* synthetic */ CartParams(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, HashMap r216, String r217, String r218, String r219, int r310, String r311, YataPageInfo r312, String r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
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
        String r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        HashMap r112 = new HashMap();
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        int r116 = 0;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r117 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        YataPageInfo r108 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r115, r116, r117, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r117 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L41:
        r113 = r217;
        goto L43
    L37:
        r112 = r216;
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
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
