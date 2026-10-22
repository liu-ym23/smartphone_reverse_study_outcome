package com.bytedance.android.shopping.anchorv3.repository.api;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.shopping.anchorv3.utils.n;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b7\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BË\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\b\u0010:\u001a\u00020\u0006H\u0016J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003JÔ\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\u00172\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\b\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\u0001H\u0016J\t\u0010R\u001a\u00020SHÖ\u0001J\b\u0010T\u001a\u00020\u0017H\u0016J\b\u0010U\u001a\u00020\u0017H\u0016J\t\u0010V\u001a\u00020\u0004HÖ\u0001J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u0004H\u0016J!\u0010Z\u001a\u00020X2\b\u0010[\u001a\u0004\u0018\u00010\u00042\b\u0010\\\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0002\u0010]J\u0012\u0010^\u001a\u00020X2\b\u0010_\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010`\u001a\u00020X2\u0006\u0010a\u001a\u00020\u0017H\u0016J\u0010\u0010b\u001a\u00020X2\u0006\u0010c\u001a\u00020\u0017H\u0016J\u0010\u0010d\u001a\u00020X2\u0006\u0010e\u001a\u00020\u0017H\u0016J\u0012\u0010f\u001a\u00020X2\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010h\u001a\u00020X2\b\u0010i\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010j\u001a\u00020X2\u0010\u0010k\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014H\u0016J\u0017\u0010l\u001a\u00020X2\b\u0010m\u001a\u0004\u0018\u00010SH\u0016¢\u0006\u0002\u0010nJ\u0012\u0010o\u001a\u00020X2\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0016R \u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR \u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001aR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u00105R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001eR \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001c¨\u0006p"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/api/SchemaPackRequest;", "Lcom/bytedance/android/shopping/anchorv3/repository/api/PdpPackRequestParam;", "Ljava/io/Serializable;", "bffType", "", "productInfo", "Lorg/json/JSONObject;", "bizContext", "chainInfo", "userInfo", "abParams", "customParams", "clientParams", "platformParams", "passThrough", "Lorg/json/JSONArray;", "extraParams", "sliceSdkVersion", "sourceBtmToken", "identifiers", "", "refreshReqParams", "fromSchemaConvert", "", "(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONArray;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAbParams", "()Lorg/json/JSONObject;", "setAbParams", "(Lorg/json/JSONObject;)V", "getBffType", "()Ljava/lang/String;", "getBizContext", "getChainInfo", "getClientParams", "setClientParams", "getCustomParams", "setCustomParams", "getExtraParams", "setExtraParams", "getFromSchemaConvert", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIdentifiers", "()Ljava/util/List;", "getPassThrough", "()Lorg/json/JSONArray;", "setPassThrough", "(Lorg/json/JSONArray;)V", "getPlatformParams", "setPlatformParams", "getProductInfo", "getRefreshReqParams", "setRefreshReqParams", "(Ljava/lang/String;)V", "getSliceSdkVersion", "getSourceBtmToken", "getUserInfo", "setUserInfo", "asJsonDescription", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONArray;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/android/shopping/anchorv3/repository/api/SchemaPackRequest;", "equals", "other", "", "getEcomSceneId", "getSimplifiedCacheKey", "hashCode", "", "isInSplit", "isPreload", "toString", "updateAddressDetail", "", "addressList", "updateAddressId", "userAddressId", "userAddrType", "(Ljava/lang/String;Ljava/lang/Integer;)V", "updateClientStorage", "clientStorage", "updateFullResp", "fullResp", "updateIsAuth", "isAuth", "updateIsExpanded", "isExpanded", "updateNormalSkuId", "normalSkuId", "updateRefreshRepParams", "params", "updateSelectedIds", "selectedIds", "updateShopRecommendTabIndex", "index", "(Ljava/lang/Integer;)V", "updateSkuSwitch", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SchemaPackRequest extends PdpPackRequestParam {

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS)
    private JSONObject abParams;

    @SerializedName("bff_type")
    private final String bffType;

    @SerializedName("biz_context")
    private final JSONObject bizContext;

    @SerializedName("chain_info")
    private final JSONObject chainInfo;

    @SerializedName("client_params")
    private JSONObject clientParams;

    @SerializedName("custom_params")
    private JSONObject customParams;

    @SerializedName("extra_params")
    private JSONObject extraParams;

    @SerializedName("from_schema_convert")
    private final Boolean fromSchemaConvert;
    private final List<String> identifiers;

    @SerializedName("pass_through")
    private JSONArray passThrough;

    @SerializedName("platform_params")
    private JSONObject platformParams;

    @SerializedName("product_info")
    private final JSONObject productInfo;

    @SerializedName("refresh_req_params")
    private String refreshReqParams;

    @SerializedName("slice_sdk_version")
    private final String sliceSdkVersion;

    @SerializedName(PhotoEnterModel.SOURCE_BTM_TOKEN)
    private final String sourceBtmToken;

    @SerializedName("user_info")
    private JSONObject userInfo;

    public SchemaPackRequest() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SchemaPackRequest copy$default(SchemaPackRequest r110, String r111, JSONObject r112, JSONObject r210, JSONObject r211, JSONObject r212, JSONObject r213, JSONObject r214, JSONObject r215, JSONObject r216, JSONArray r217, JSONObject r218, String r219, String r310, List r311, String r312, Boolean r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = r110.bffType;
    L7:
        if ((r314 & 2) == 0) goto L9;
        JSONObject r101 = r110.productInfo;
    L11:
        if ((r314 & 4) == 0) goto L13;
        JSONObject r102 = r110.bizContext;
    L15:
        if ((r314 & 8) == 0) goto L17;
        JSONObject r103 = r110.chainInfo;
    L19:
        if ((r314 & 16) == 0) goto L21;
        JSONObject r104 = r110.userInfo;
    L23:
        if ((r314 & 32) == 0) goto L25;
        JSONObject r105 = r110.abParams;
    L27:
        if ((r314 & 64) == 0) goto L29;
        JSONObject r106 = r110.customParams;
    L31:
        if ((r314 & 128) == 0) goto L33;
        JSONObject r107 = r110.clientParams;
    L35:
        if ((r314 & 256) == 0) goto L37;
        JSONObject r113 = r110.platformParams;
    L39:
        if ((r314 & 512) == 0) goto L41;
        JSONArray r114 = r110.passThrough;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        JSONObject r115 = r110.extraParams;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        String r116 = r110.sliceSdkVersion;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r117 = r110.sourceBtmToken;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        List r118 = r110.identifiers;
    L58:
        List r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        String r119 = r110.refreshReqParams;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        Boolean r108 = r110.fromSchemaConvert;
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
        return this.bffType;
    }

    public final JSONArray component10() {
        return this.passThrough;
    }

    public final JSONObject component11() {
        return this.extraParams;
    }

    public final String component12() {
        return this.sliceSdkVersion;
    }

    public final String component13() {
        return this.sourceBtmToken;
    }

    public final List<String> component14() {
        return this.identifiers;
    }

    public final String component15() {
        return this.refreshReqParams;
    }

    public final Boolean component16() {
        return this.fromSchemaConvert;
    }

    public final JSONObject component2() {
        return this.productInfo;
    }

    public final JSONObject component3() {
        return this.bizContext;
    }

    public final JSONObject component4() {
        return this.chainInfo;
    }

    public final JSONObject component5() {
        return this.userInfo;
    }

    public final JSONObject component6() {
        return this.abParams;
    }

    public final JSONObject component7() {
        return this.customParams;
    }

    public final JSONObject component8() {
        return this.clientParams;
    }

    public final JSONObject component9() {
        return this.platformParams;
    }

    public final SchemaPackRequest copy(String r110, JSONObject r210, JSONObject r211, JSONObject r212, JSONObject r213, JSONObject r214, JSONObject r215, JSONObject r216, JSONObject r217, JSONArray r218, JSONObject r219, String r310, String r311, List<String> r312, String r313, Boolean r314) {
        return new SchemaPackRequest(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SchemaPackRequest) == false) goto L38;
        SchemaPackRequest r101 = (SchemaPackRequest) r100;
        if (Intrinsics.areEqual(this.bffType, r101.bffType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productInfo, r101.productInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bizContext, r101.bizContext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chainInfo, r101.chainInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.userInfo, r101.userInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.abParams, r101.abParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.customParams, r101.customParams) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.clientParams, r101.clientParams) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.platformParams, r101.platformParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.passThrough, r101.passThrough) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.sliceSdkVersion, r101.sliceSdkVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sourceBtmToken, r101.sourceBtmToken) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.identifiers, r101.identifiers) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.refreshReqParams, r101.refreshReqParams) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.fromSchemaConvert, r101.fromSchemaConvert) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        String r100 = this.bffType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.productInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.bizContext;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.chainInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        JSONObject r113 = this.userInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        JSONObject r116 = this.abParams;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        JSONObject r119 = this.customParams;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        JSONObject r122 = this.clientParams;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        JSONObject r125 = this.platformParams;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        JSONArray r128 = this.passThrough;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        JSONObject r131 = this.extraParams;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.sliceSdkVersion;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.sourceBtmToken;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        List<String> r140 = this.identifiers;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.refreshReqParams;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Boolean r146 = this.fromSchemaConvert;
        if (r146 == null) goto L66;
        r101 = r146.hashCode();
    L66:
        return r145 + r101;
    L61:
        r144 = 0;
        goto L62
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
        return "SchemaPackRequest(bffType=" + this.bffType + ", productInfo=" + this.productInfo + ", bizContext=" + this.bizContext + ", chainInfo=" + this.chainInfo + ", userInfo=" + this.userInfo + ", abParams=" + this.abParams + ", customParams=" + this.customParams + ", clientParams=" + this.clientParams + ", platformParams=" + this.platformParams + ", passThrough=" + this.passThrough + ", extraParams=" + this.extraParams + ", sliceSdkVersion=" + this.sliceSdkVersion + ", sourceBtmToken=" + this.sourceBtmToken + ", identifiers=" + this.identifiers + ", refreshReqParams=" + this.refreshReqParams + ", fromSchemaConvert=" + this.fromSchemaConvert + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public JSONObject asJsonDescription() {
        int r100 = n.f165314a;     // Catch: Exception -> L4
        return tv5.a.a(n.a.f165315a, this);
    L5:
        return new JSONObject();
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public String getEcomSceneId() {
        JSONObject r100 = this.chainInfo;
        if (r100 == null) goto L5;
        String r101 = r100.optString("ecom_scene_id");
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public PdpPackRequestParam getSimplifiedCacheKey() {
        ArrayList r110 = new ArrayList();
        JSONObject r100 = this.productInfo;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.optString("promotion_id");
    L6:
        String r103 = "";
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r110.add(r102);
        JSONObject r104 = this.bizContext;
        if (r104 == null) goto L12;
        r101 = r104.optString("ecom_scene_id");
    L12:
        if (r101 == null) goto L15;
        r103 = r101;
    L15:
        r110.add(r103);
        r110.add(String.valueOf(isInSplit()));
        return new SchemaPackRequest(null, null, null, null, null, null, null, null, null, null, null, null, null, r110, null, null, 57343, null);
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public boolean isInSplit() {
        JSONObject r100 = this.clientParams;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.optBoolean("is_in_split") != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    /* JADX INFO: renamed from: isPreload */
    public boolean mo8285isPreload() {
        JSONObject r100 = this.clientParams;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.optInt("is_preload_req") != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final JSONObject getAbParams() {
        return this.abParams;
    }

    public final String getBffType() {
        return this.bffType;
    }

    public final JSONObject getBizContext() {
        return this.bizContext;
    }

    public final JSONObject getChainInfo() {
        return this.chainInfo;
    }

    public final JSONObject getClientParams() {
        return this.clientParams;
    }

    public final JSONObject getCustomParams() {
        return this.customParams;
    }

    public final JSONObject getExtraParams() {
        return this.extraParams;
    }

    public final Boolean getFromSchemaConvert() {
        return this.fromSchemaConvert;
    }

    public final List<String> getIdentifiers() {
        return this.identifiers;
    }

    public final JSONArray getPassThrough() {
        return this.passThrough;
    }

    public final JSONObject getPlatformParams() {
        return this.platformParams;
    }

    public final JSONObject getProductInfo() {
        return this.productInfo;
    }

    public final String getRefreshReqParams() {
        return this.refreshReqParams;
    }

    public final String getSliceSdkVersion() {
        return this.sliceSdkVersion;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final JSONObject getUserInfo() {
        return this.userInfo;
    }

    public final void setAbParams(JSONObject r100) {
        this.abParams = r100;
    }

    public final void setClientParams(JSONObject r100) {
        this.clientParams = r100;
    }

    public final void setCustomParams(JSONObject r100) {
        this.customParams = r100;
    }

    public final void setExtraParams(JSONObject r100) {
        this.extraParams = r100;
    }

    public final void setPassThrough(JSONArray r100) {
        this.passThrough = r100;
    }

    public final void setPlatformParams(JSONObject r100) {
        this.platformParams = r100;
    }

    public final void setRefreshReqParams(String r100) {
        this.refreshReqParams = r100;
    }

    public final void setUserInfo(JSONObject r100) {
        this.userInfo = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateAddressDetail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "addressList");
        JSONObject r101 = this.userInfo;
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        r101.put("address_detail", r100);
        Unit r102 = Unit.INSTANCE;
        this.userInfo = r101;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateClientStorage(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r101 = this.clientParams;
        if (r101 != null) goto L7;
        r101 = new JSONObject();
    L7:
        r101.put("client_storage", r100);
        Unit r102 = Unit.INSTANCE;
        this.clientParams = r101;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateFullResp(boolean r100) {
        JSONObject r101 = this.clientParams;
        if (r101 != null) goto L9;
        r101 = new JSONObject();
    L9:
        r101.put("full_resp", r100);     // Catch: Exception -> L8
        Unit r102 = Unit.INSTANCE;
        this.clientParams = r101;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateIsAuth(boolean r100) {
        JSONObject r101 = this.clientParams;
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        if (r100 == false) goto L7;
        String r102 = "1";
    L8:
        r101.put("is_auth", r102);
        Unit r103 = Unit.INSTANCE;
        this.clientParams = r101;
        return;
    L7:
        r102 = "0";
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateIsExpanded(boolean r100) {
        JSONObject r101 = this.productInfo;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        String r102 = "1";
    L11:
        r101.put("is_expanded", r102);     // Catch: Exception -> L10
        return;
    L14:
        return;
    L7:
        r102 = "0";
        goto L11
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateNormalSkuId(String r100) {
        JSONObject r101 = this.productInfo;
        if (r101 == null) goto L9;
        r101.put("normal_sku_id", r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateRefreshRepParams(String r100) {
        this.refreshReqParams = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateSelectedIds(List<String> r100) {
        List<String> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        JSONObject r103 = this.clientParams;
        if (r103 != null) goto L18;
        r103 = new JSONObject();
    L18:
        r103.put("default_spec_id", new JSONArray(r100));     // Catch: Exception -> L17
        Unit r104 = Unit.INSTANCE;
        this.clientParams = r103;
        return;
    L20:
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateShopRecommendTabIndex(Integer r100) {
        JSONObject r101 = this.clientParams;
        if (r101 != null) goto L9;
        r101 = new JSONObject();
    L9:
        r101.put("shop_recommend_tab_index", r100);     // Catch: Exception -> L8
        Unit r102 = Unit.INSTANCE;
        this.clientParams = r101;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateSkuSwitch(String r100) {
        JSONObject r101 = this.productInfo;
        if (r101 == null) goto L13;
        if (com.bytedance.android.shopping.anchorv3.a.b(r100) == false) goto L7;
        String r102 = "1";
    L8:
        r101.put("sku_switch", r102);     // Catch: Exception -> L10
        return;
    L7:
        r102 = "0";
    L14:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam
    public void updateAddressId(String r100, Integer r101) {
        JSONObject r102 = this.userInfo;
        if (r102 != null) goto L5;
        r102 = new JSONObject();
    L5:
        r102.put("user_addr_id", r100);
        r102.put("receive_address_id", r100);
        r102.put("address_type", r101);
        Unit r103 = Unit.INSTANCE;
        this.userInfo = r102;
    }

    public SchemaPackRequest(String r100, JSONObject r101, JSONObject r102, JSONObject r103, JSONObject r104, JSONObject r105, JSONObject r106, JSONObject r110, JSONObject r111, JSONArray r112, JSONObject r113, String r114, String r115, List<String> r116, String r117, Boolean r118) {
        super(null);
        this.bffType = r100;
        this.productInfo = r101;
        this.bizContext = r102;
        this.chainInfo = r103;
        this.userInfo = r104;
        this.abParams = r105;
        this.customParams = r106;
        this.clientParams = r110;
        this.platformParams = r111;
        this.passThrough = r112;
        this.extraParams = r113;
        this.sliceSdkVersion = r114;
        this.sourceBtmToken = r115;
        this.identifiers = r116;
        this.refreshReqParams = r117;
        this.fromSchemaConvert = r118;
    }

    public /* synthetic */ SchemaPackRequest(String r110, JSONObject r111, JSONObject r210, JSONObject r211, JSONObject r212, JSONObject r213, JSONObject r214, JSONObject r215, JSONObject r216, JSONArray r217, JSONObject r218, String r219, String r310, List r311, String r312, Boolean r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        String r100 = "1";
    L7:
        if ((r314 & 2) == 0) goto L9;
        JSONObject r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        JSONObject r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        JSONObject r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        JSONObject r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        JSONObject r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        JSONObject r106 = null;
    L31:
        if ((r314 & 128) == 0) goto L33;
        JSONObject r107 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        JSONObject r112 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        JSONArray r113 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        JSONObject r114 = null;
    L46:
        String r115 = "";
        if ((r314 & 2048) == 0) goto L49;
        String r116 = "";
    L51:
        if ((r314 & 4096) != 0) goto L55;
        r115 = r310;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        List r117 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        Boolean r109 = Boolean.FALSE;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r112, r113, r114, r116, r115, r117, r108, r109);
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
    L49:
        r116 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L46
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
