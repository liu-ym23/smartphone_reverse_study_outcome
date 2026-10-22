package com.bytedance.android.shopping.sku.params.schema;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ul.i;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b9\u0010:J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001d\u00105\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;", "Lul/i;", "Ljava/io/Serializable;", "Landroid/net/Uri;", "uri", "initData", "Lorg/json/JSONObject;", "getJSONSchema", "Lcom/bytedance/android/shopping/sku/params/schema/SkuProductInfo;", "productInfo", "Lcom/bytedance/android/shopping/sku/params/schema/SkuProductInfo;", "getProductInfo", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuProductInfo;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuBizContext;", "bizContext", "Lcom/bytedance/android/shopping/sku/params/schema/SkuBizContext;", "getBizContext", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuBizContext;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuUserInfo;", "userInfo", "Lcom/bytedance/android/shopping/sku/params/schema/SkuUserInfo;", "getUserInfo", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuUserInfo;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuClientParams;", "clientParams", "Lcom/bytedance/android/shopping/sku/params/schema/SkuClientParams;", "getClientParams", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuClientParams;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuChainInfo;", "chainInfo", "Lcom/bytedance/android/shopping/sku/params/schema/SkuChainInfo;", "getChainInfo", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuChainInfo;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuCustomParams;", "customParams", "Lcom/bytedance/android/shopping/sku/params/schema/SkuCustomParams;", "getCustomParams", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuCustomParams;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuPassThrough;", "passThrough", "Lcom/bytedance/android/shopping/sku/params/schema/SkuPassThrough;", "getPassThrough", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuPassThrough;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuPlatformParams;", "platformParams", "Lcom/bytedance/android/shopping/sku/params/schema/SkuPlatformParams;", "getPlatformParams", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuPlatformParams;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuProductContext;", "productContext", "Lcom/bytedance/android/shopping/sku/params/schema/SkuProductContext;", "", "", "passThroughToKeys", "Ljava/util/List;", "getPassThroughToKeys", "()Ljava/util/List;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuSchemaParams extends i implements Serializable {

    @SerializedName("biz_context")
    private final SkuBizContext bizContext;

    @SerializedName("chain_info")
    private final SkuChainInfo chainInfo;

    @SerializedName("client_params")
    private final SkuClientParams clientParams;

    @SerializedName("custom_params")
    private final SkuCustomParams customParams;

    @SerializedName("pass_through")
    private final SkuPassThrough passThrough;
    private final List<String> passThroughToKeys;

    @SerializedName("platform_params")
    private final SkuPlatformParams platformParams;
    private final SkuProductContext productContext;

    @SerializedName("product_info")
    private final SkuProductInfo productInfo;

    @SerializedName("user_info")
    private final SkuUserInfo userInfo;

    public final JSONObject getJSONSchema() {
        JSONObject r100 = new JSONObject();
        String r101 = this.productInfo.getParamKey();
        int r102 = k.f44314a;
        r100.put(r101, k.b(this.productInfo.getMap()));
        r100.put(this.bizContext.getParamKey(), k.b(this.bizContext.getMap()));
        r100.put(this.userInfo.getParamKey(), k.b(this.userInfo.getMap()));
        r100.put(this.clientParams.getParamKey(), k.b(this.clientParams.getMap()));
        r100.put(this.chainInfo.getParamKey(), k.b(this.chainInfo.getMap()));
        r100.put(this.customParams.getParamKey(), k.b(this.customParams.getMap()));
        r100.put(this.platformParams.getParamKey(), k.b(this.platformParams.getMap()));
        r100.put(this.productContext.getParamKey(), k.b(this.productContext.getMap()));
        r100.put(this.passThrough.getParamKey(), k.a(this.passThrough.getList()));
        return r100;
    }

    public SkuSchemaParams() {
        this.productInfo = new SkuProductInfo();
        this.bizContext = new SkuBizContext();
        this.userInfo = new SkuUserInfo();
        this.clientParams = new SkuClientParams();
        this.chainInfo = new SkuChainInfo();
        this.customParams = new SkuCustomParams();
        this.passThrough = new SkuPassThrough();
        this.platformParams = new SkuPlatformParams();
        this.productContext = new SkuProductContext();
        this.passThroughToKeys = new ArrayList();
    }

    public final SkuBizContext getBizContext() {
        return this.bizContext;
    }

    public final SkuChainInfo getChainInfo() {
        return this.chainInfo;
    }

    public final SkuClientParams getClientParams() {
        return this.clientParams;
    }

    public final SkuCustomParams getCustomParams() {
        return this.customParams;
    }

    public final SkuPassThrough getPassThrough() {
        return this.passThrough;
    }

    public final List<String> getPassThroughToKeys() {
        return this.passThroughToKeys;
    }

    public final SkuPlatformParams getPlatformParams() {
        return this.platformParams;
    }

    public final SkuProductInfo getProductInfo() {
        return this.productInfo;
    }

    public final SkuUserInfo getUserInfo() {
        return this.userInfo;
    }

    public final SkuSchemaParams initData(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        final long r101 = SystemClock.elapsedRealtime();
        this.productInfo.initData(r100);
        this.bizContext.initData(r100);
        this.userInfo.initData(r100);
        this.clientParams.initData(r100);
        this.chainInfo.initData(r100);
        this.customParams.initData(r100);
        this.passThrough.initData(r100);
        this.platformParams.initData(r100);
        this.productContext.initData(r100);
        String r102 = this.bizContext.getAuthorId();
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        String r105 = null;
        if (r104 == false) goto L22;
        String r106 = this.productContext.getAuthorId();
        if (r106 == null) goto L22;
        if (r106.length() <= 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == true) goto L20;
        r106 = null;
    L20:
        if (r106 == null) goto L22;
        this.bizContext.appendOrReplaceParams("author_id", r106);
        goto L22
    L16:
        r107 = false;
    L22:
        String r108 = this.bizContext.getSecAuthorId();
        if (r108 != null) goto L25;
    L28:
        boolean r109 = true;
    L29:
        if (r109 == false) goto L41;
        String r110 = this.productContext.getSecAuthorId();
        if (r110 == null) goto L41;
        if (r110.length() <= 0) goto L35;
        boolean r111 = true;
    L36:
        if (r111 == true) goto L39;
        r110 = null;
    L39:
        if (r110 == null) goto L41;
        this.bizContext.appendOrReplaceParams("sec_author_id", r110);
        goto L41
    L35:
        r111 = false;
    L41:
        String r112 = this.chainInfo.getMarketingChannel();
        if (r112 != null) goto L44;
    L47:
        boolean r113 = true;
    L48:
        if (r113 == false) goto L60;
        String r114 = this.productContext.getMarketingChannel();
        if (r114 == null) goto L60;
        if (r114.length() <= 0) goto L54;
        boolean r115 = true;
    L55:
        if (r115 == true) goto L58;
        r114 = null;
    L58:
        if (r114 == null) goto L60;
        this.chainInfo.appendOrReplaceParams(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, r114);
        goto L60
    L54:
        r115 = false;
    L60:
        String r116 = this.bizContext.getRoomId();
        if (r116 != null) goto L63;
    L66:
        boolean r117 = true;
    L67:
        if (r117 == false) goto L79;
        String r118 = this.productContext.getRoomId();
        if (r118 == null) goto L79;
        if (r118.length() <= 0) goto L73;
        boolean r119 = true;
    L74:
        if (r119 == true) goto L77;
        r118 = null;
    L77:
        if (r118 == null) goto L79;
        this.bizContext.appendOrReplaceParams("room_id", r118);
        goto L79
    L73:
        r119 = false;
    L79:
        Boolean r120 = this.bizContext.isGroupBuy();
        Boolean r121 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r120, r121)) == true) goto L82;
    L84:
        String r122 = this.bizContext.getOrderUrl();
        if (r122 != null) goto L87;
    L90:
        boolean r123 = true;
    L91:
        if (r123 == false) goto L103;
        String r124 = this.productContext.getOrderUrl();
        if (r124 == null) goto L103;
        if (r124.length() <= 0) goto L97;
        boolean r125 = true;
    L98:
        if (r125 == true) goto L101;
        r124 = null;
    L101:
        if (r124 == null) goto L103;
        this.bizContext.appendOrReplaceParams("order_url", r124);
        goto L103
    L97:
        r125 = false;
    L103:
        String r126 = this.bizContext.getItemId();
        if (r126 != null) goto L106;
    L109:
        boolean r127 = true;
    L110:
        if (r127 == false) goto L122;
        String r128 = this.productContext.getItemId();
        if (r128 == null) goto L122;
        if (r128.length() <= 0) goto L116;
        boolean r129 = true;
    L117:
        if (r129 == true) goto L120;
        r128 = null;
    L120:
        if (r128 == null) goto L122;
        this.bizContext.appendOrReplaceParams("item_id", r128);
        goto L122
    L116:
        r129 = false;
    L122:
        String r130 = this.bizContext.getActionType();
        if (r130 != null) goto L125;
    L128:
        boolean r131 = true;
    L129:
        if (r131 == false) goto L144;
        Object r132 = this.chainInfo.getMap().get("action_type");
        if ((r132 instanceof String) == true) goto L133;
        r132 = null;
    L133:
        String r133 = (String) r132;
        if (r133 == null) goto L144;
        if (r133.length() <= 0) goto L138;
        boolean r134 = true;
    L139:
        if (r134 == true) goto L142;
        r133 = null;
    L142:
        if (r133 == null) goto L144;
        this.bizContext.appendOrReplaceParams("action_type", r133);
        goto L144
    L138:
        r134 = false;
    L144:
        String r135 = this.bizContext.getSceneType();
        if (r135 != null) goto L147;
    L150:
        boolean r136 = true;
    L151:
        if (r136 == false) goto L166;
        Object r137 = this.chainInfo.getMap().get("scene_type");
        if ((r137 instanceof String) == true) goto L155;
        r137 = null;
    L155:
        String r138 = (String) r137;
        if (r138 == null) goto L166;
        if (r138.length() <= 0) goto L160;
        boolean r139 = true;
    L161:
        if (r139 == true) goto L164;
        r138 = null;
    L164:
        if (r138 == null) goto L166;
        this.bizContext.appendOrReplaceParams("scene_type", r138);
        goto L166
    L160:
        r139 = false;
    L166:
        String r140 = this.bizContext.getSkuId();
        if (r140 != null) goto L169;
    L172:
        boolean r141 = true;
    L173:
        if (r141 == false) goto L189;
        Object r142 = this.clientParams.getMap().get("default_sku_id");
        if ((r142 instanceof String) == true) goto L177;
        r142 = null;
    L177:
        String r143 = (String) r142;
        if (r143 == null) goto L189;
        if (r143.length() <= 0) goto L182;
        boolean r144 = true;
    L183:
        if (r144 == true) goto L186;
        r143 = null;
    L186:
        if (r143 == null) goto L189;
        this.bizContext.appendOrReplaceParams("default_sku_id", r143);
        goto L189
    L182:
        r144 = false;
    L189:
        if (this.bizContext.getHotSaleType() != null) goto L196;
        Object r145 = this.clientParams.getMap().get("hot_sale_type");
        if ((r145 instanceof Integer) == true) goto L193;
        r145 = null;
    L193:
        Integer r146 = (Integer) r145;
        if (r146 == null) goto L196;
        this.bizContext.appendOrReplaceParams("hot_sale_type", Integer.valueOf(r146.intValue()));
    L196:
        String r147 = this.bizContext.getDetailUrl();
        if (r147 != null) goto L199;
    L202:
        boolean r148 = true;
    L203:
        if (r148 == false) goto L216;
        Object r149 = this.clientParams.getMap().get("detail_url");
        if ((r149 instanceof String) == true) goto L207;
        r149 = null;
    L207:
        String r150 = (String) r149;
        if (r150 == null) goto L216;
        if (r150.length() <= 0) goto L212;
        r103 = true;
    L212:
        if (r103 == false) goto L214;
        r105 = r150;
    L214:
        if (r105 == null) goto L216;
        this.bizContext.appendOrReplaceParams("detail_url", r105);
    L216:
        Lazy r151 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuSchemaParams", new AnonymousClass1(r101));
        return this;
    L199:
        if (r147.length() == 0) goto L202;
        r148 = false;
        goto L203
    L169:
        if (r140.length() == 0) goto L172;
        r141 = false;
        goto L173
    L147:
        if (r135.length() == 0) goto L150;
        r136 = false;
        goto L151
    L125:
        if (r130.length() == 0) goto L128;
        r131 = false;
        goto L129
    L106:
        if (r126.length() == 0) goto L109;
        r127 = false;
        goto L110
    L87:
        if (r122.length() == 0) goto L90;
        r123 = false;
        goto L91
    L82:
        if (Intrinsics.areEqual(this.productContext.isGroupBuy(), r121) == false) goto L84;
        this.bizContext.appendOrReplaceParams("is_group_buy", r121);
        goto L84
    L63:
        if (r116.length() == 0) goto L66;
        r117 = false;
        goto L67
    L44:
        if (r112.length() == 0) goto L47;
        r113 = false;
        goto L48
    L25:
        if (r108.length() == 0) goto L28;
        r109 = false;
        goto L29
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
