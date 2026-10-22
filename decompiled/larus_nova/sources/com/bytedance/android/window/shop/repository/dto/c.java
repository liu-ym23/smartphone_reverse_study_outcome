package com.bytedance.android.window.shop.repository.dto;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R4\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0011\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/c;", "", "", "itemType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "Lcom/google/gson/JsonObject;", "insertParams", "Lcom/google/gson/JsonObject;", "getInsertParams", "()Lcom/google/gson/JsonObject;", "", "uniqueId", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "", "uiElementParams", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "bstIndex", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/google/gson/JsonElement;", "data", "Lcom/google/gson/JsonElement;", "lynxExtensionData", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("item_index")
    private final Integer bstIndex;

    @SerializedName(alternate = {"product", "recommend_mall", "recommend_store", "video", "live_product", "hot_title", ActivityVO.APPOINTMENT, "mix_livehot_product", "sync_products", "lynx_common_card", "livehot_latest_info", "livehot_recommend_title", "live_product_list", "coupon_collect", "video_product_card", "author", "follow_buy", "fans_comments", "bubbles", "anchor_bottom_item", "hint_bar", "vertical_margin", "replay_collection"}, value = "")
    private final JsonElement data;

    @SerializedName("dynamic_insert_card_info")
    private final JsonObject insertParams;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final Integer itemType;

    @SerializedName("lynx_extension_card")
    private final JsonElement lynxExtensionData;

    @SerializedName("ui_log_extra")
    private final Map<String, Map<String, String>> uiElementParams;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    private final String uniqueId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.insertParams, r101.insertParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.uniqueId, r101.uniqueId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uiElementParams, r101.uiElementParams) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bstIndex, r101.bstIndex) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynxExtensionData, r101.lynxExtensionData) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.itemType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.insertParams;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.uniqueId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Map<String, String>> r110 = this.uiElementParams;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.bstIndex;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        JsonElement r116 = this.data;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        JsonElement r119 = this.lynxExtensionData;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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

    public final v0 d() {
        JsonElement r100 = this.lynxExtensionData;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (v0) d.a(r100, v0.class);
    }

    public final Map<String, String> e() {
        JsonObject r100 = this.insertParams;
        if (r100 != null) goto L7;
        return MapsKt.emptyMap();
    L7:
        if (r100.keySet().isEmpty() == true) goto L9;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = this.insertParams.keySet().iterator();
    L12:
        if (r102.hasNext() == false) goto L20;
        String r103 = (String) r102.next();
        JsonElement r104 = this.insertParams.get(r103);
        if (r104.isJsonPrimitive() == true) goto L15;
        if (r104.isJsonObject() == true) goto L18;
        r101.put(r103, r104.toString());
        goto L12
    L18:
        r101.put(r103, r104.getAsJsonObject().toString());
        goto L12
    L15:
        r101.put(r103, r104.getAsJsonPrimitive().getAsString());
        goto L12
    L20:
        return r101;
    L9:
        return MapsKt.emptyMap();
    }

    public final boolean h() {
        if (this.itemType != null) goto L5;
    L8:
        return true;
    L5:
        if (this.data == null) goto L8;
        return false;
    }

    public final String toString() {
        int r100 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
        int r101 = com.bytedance.android.ec.core.opt.ab.m.f45240a;
        Object r102 = 0;
        boolean r103 = ECServiceManager.f42805a;
        s83.g r104 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r104 == null) goto L8;
        s83.a r105 = r104.q();
        if (r105 == null) goto L8;
        Object r106 = r105.e("ec_gson_adapter_opt");
        if (r106 == null) goto L8;
    L175:
        if (((Number) r106).intValue() != 1) goto L178;
        return "MixFullItem@" + super.hashCode();
    L178:
        return "MixFullItem(itemType=" + this.itemType + ", data=" + this.data + ')';
    L8:
        int r107 = com.bytedance.android.ec.core.opt.ab.n.f45241a;
        int r108 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L165
        Object r110 = null;
        Object r111 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_gson_adapter_opt");     // Catch: Throwable -> L60
        if (r111 != null) goto L15;
    L57:
        Object r112 = null;
    L58:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L60
    L62:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);     // Catch: Throwable -> L165
        if (r114 == null) goto L66;
        EnsureManager.ensureNotReachHere(r114);     // Catch: Throwable -> L165
    L66:
        if (Result.m9455isFailureimpl(r113) == false) goto L69;
        r113 = null;
    L69:
        if ((r113 instanceof Integer) == true) goto L71;
        r113 = null;
    L71:
        Integer r115 = (Integer) r113;     // Catch: Throwable -> L165
        if (r115 != null) goto L78;
        Object r116 = com.bytedance.android.ec.base.settings.d.f42816a.get("ec_gson_adapter_opt");     // Catch: Throwable -> L165
        if ((r116 instanceof Integer) == true) goto L77;
        r116 = null;
    L77:
        r115 = (Integer) r116;     // Catch: Throwable -> L165
    L78:
        if (r115 == null) goto L80;
        r106 = r115;
        goto L175
    L80:
        int r117 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L165
        Object r118 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_gson_adapter_opt");     // Catch: Throwable -> L130
        if (r118 != null) goto L85;
    L127:
        Object r119 = null;
    L128:
        Object r120 = Result.m9449constructorimpl(r119);     // Catch: Throwable -> L130
    L132:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);     // Catch: Throwable -> L156
        if (r121 == null) goto L136;
        EnsureManager.ensureNotReachHere(r121);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r120) == false) goto L139;
        r120 = null;
    L139:
        if ((r120 instanceof Integer) == true) goto L141;
        r120 = null;
    L141:
        Integer r122 = (Integer) r120;     // Catch: Throwable -> L156
        if (r122 == null) goto L144;
        r106 = r122;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_gson_adapter_opt", r106);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r123 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r123 == null) goto L147;
        Object r124 = r123.getHostABValue("ec_gson_adapter_opt", r102);     // Catch: Throwable -> L156
    L148:
        if (r124 != null) goto L150;
    L162:
        r106 = r102;
        goto L163
    L150:
        if ((r124 instanceof Integer) == false) goto L153;
        r110 = r124;
    L153:
        r106 = (Integer) r110;     // Catch: Throwable -> L156
        if (r106 != null) goto L163;
    L156:
        th = move-exception;
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L165
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r126 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L165
        if (r126 == null) goto L161;
        EnsureManager.ensureNotReachHere(r126);     // Catch: Throwable -> L165
    L161:
        if (Result.m9455isFailureimpl(r106) == false) goto L163;
    L147:
        r124 = null;
        goto L148
    L85:
        if ((r118 instanceof Integer) == true) goto L87;
        Object r127 = null;
    L88:
        r119 = (Integer) r127;     // Catch: Throwable -> L130
        if (r119 != null) goto L128;
        if ((r118 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r128 = Float.valueOf(((Number) r118).floatValue());     // Catch: Throwable -> L130
        if ((r128 instanceof Integer) == true) goto L98;
        r128 = null;
    L98:
        r119 = (Integer) r128;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r129 = Double.valueOf(((Number) r118).doubleValue());     // Catch: Throwable -> L130
        if ((r129 instanceof Integer) == true) goto L104;
        r129 = null;
    L104:
        r119 = (Integer) r129;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r119 = Integer.valueOf(((Number) r118).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r130 = Long.valueOf(((Number) r118).longValue());     // Catch: Throwable -> L130
        if ((r130 instanceof Integer) == true) goto L113;
        r130 = null;
    L113:
        r119 = (Integer) r130;     // Catch: Throwable -> L130
    L115:
        if ((r118 instanceof JSONObject) == false) goto L117;
    L189:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r131 = SDKSettingsCacheManager.a().fromJson(r118.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r131 instanceof Integer) == true) goto L121;
        r131 = null;
    L121:
        Object r132 = Result.m9449constructorimpl((Integer) r131);     // Catch: Throwable -> L123
    L125:
        r119 = r132;
        if (Result.m9455isFailureimpl(r119) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L130
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r118 instanceof JSONArray) == false) goto L127;
    L87:
        r127 = r118;
    L130:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L156
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r111 instanceof Integer) == true) goto L17;
        Object r135 = null;
    L18:
        r112 = (Integer) r135;     // Catch: Throwable -> L60
        if (r112 != null) goto L58;
        if ((r111 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r136 = Float.valueOf(((Number) r111).floatValue());     // Catch: Throwable -> L60
        if ((r136 instanceof Integer) == true) goto L28;
        r136 = null;
    L28:
        r112 = (Integer) r136;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r137 = Double.valueOf(((Number) r111).doubleValue());     // Catch: Throwable -> L60
        if ((r137 instanceof Integer) == true) goto L34;
        r137 = null;
    L34:
        r112 = (Integer) r137;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r112 = Integer.valueOf(((Number) r111).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r138 = Long.valueOf(((Number) r111).longValue());     // Catch: Throwable -> L60
        if ((r138 instanceof Integer) == true) goto L43;
        r138 = null;
    L43:
        r112 = (Integer) r138;     // Catch: Throwable -> L60
    L45:
        if ((r111 instanceof JSONObject) == false) goto L47;
    L187:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L53
        Object r139 = SDKSettingsCacheManager.a().fromJson(r111.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r139 instanceof Integer) == true) goto L51;
        r139 = null;
    L51:
        Object r140 = Result.m9449constructorimpl((Integer) r139);     // Catch: Throwable -> L53
    L55:
        r112 = r140;
        if (Result.m9455isFailureimpl(r112) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L60
        r140 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r111 instanceof JSONArray) == false) goto L57;
    L17:
        r135 = r111;
    L60:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L165
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        Object r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r145 = Result.m9452exceptionOrNullimpl(r144);
        if (r145 == null) goto L170;
        EnsureManager.ensureNotReachHere(r145);
    L170:
        if (Result.m9455isFailureimpl(r144) == true) goto L173;
        r102 = r144;
    L173:
        r106 = r102;
        goto L175
    }

    public c() {
        this.itemType = null;
        this.insertParams = null;
        this.uniqueId = null;
        this.uiElementParams = null;
        this.bstIndex = null;
        this.data = null;
        this.lynxExtensionData = null;
    }

    public final Integer a() {
        return this.bstIndex;
    }

    public final Integer c() {
        return this.itemType;
    }

    public final Map<String, Map<String, String>> f() {
        return this.uiElementParams;
    }

    public final String g() {
        return this.uniqueId;
    }

    public final <T> T b(Class<T> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        JsonElement r101 = this.data;
        if (r101 != null) goto L9;
        return null;
    L9:
        return (T) d.a(r101, r100);
    }
}
