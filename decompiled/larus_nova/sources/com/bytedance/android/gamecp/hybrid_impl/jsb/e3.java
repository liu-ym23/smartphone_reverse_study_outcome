package com.bytedance.android.gamecp.hybrid_impl.jsb;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\bB\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bh\u0010iR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR$\u0010>\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000e\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012R$\u0010A\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000e\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R$\u0010D\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u000e\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012R$\u0010G\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010*\u001a\u0004\bH\u0010,\"\u0004\bI\u0010.R$\u0010J\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u0004\u001a\u0004\bK\u0010\u0006\"\u0004\bL\u0010\bR$\u0010M\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010*\u001a\u0004\bN\u0010,\"\u0004\bO\u0010.R$\u0010P\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010*\u001a\u0004\bQ\u0010,\"\u0004\bR\u0010.R$\u0010S\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010*\u001a\u0004\bT\u0010,\"\u0004\bU\u0010.R$\u0010V\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010\u000e\u001a\u0004\bW\u0010\u0010\"\u0004\bX\u0010\u0012R$\u0010Y\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010\u0004\u001a\u0004\bZ\u0010\u0006\"\u0004\b[\u0010\bR$\u0010\\\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u0004\u001a\u0004\b]\u0010\u0006\"\u0004\b^\u0010\bR$\u0010_\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010*\u001a\u0004\b`\u0010,\"\u0004\ba\u0010.R$\u0010b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bb\u0010\u000e\u001a\u0004\bc\u0010\u0010\"\u0004\bd\u0010\u0012R$\u0010e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010\u0004\u001a\u0004\bf\u0010\u0006\"\u0004\bg\u0010\b¨\u0006j"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/e3;", "", "", "game_id", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "setGame_id", "(Ljava/lang/String;)V", com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, "d", "setContent_id", "", "reserve_state", "Ljava/lang/Integer;", "s", "()Ljava/lang/Integer;", "setReserve_state", "(Ljava/lang/Integer;)V", "scene", BaseSwitches.V, "setScene", BdpAppEventConstant.PARAMS_SUB_SCENE, "x", "setSub_scene", AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, "o", "setPromoter_id", "user_nick_name", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setUser_nick_name", "traffic_source", "y", "setTraffic_source", "enter_method", ce.f26391f, "setEnter_method", "creative_id", "e", "setCreative_id", "", "is_ad", "Ljava/lang/Boolean;", "B", "()Ljava/lang/Boolean;", "set_ad", "(Ljava/lang/Boolean;)V", "ad_id", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAd_id", EventConstants.ExtraJson.GAME_NAME, RXScreenCaptureService.KEY_INDEX, "setGame_name", PdpOpenThirdParam.KEY_AD_LOG_EXTRA, "b", "setAd_log_extra", "request_id", "q", "setRequest_id", "is_other_channel", "C", "set_other_channel", "ad_source_type", "c", "setAd_source_type", "stock_type", "w", "setStock_type", "original_system_origin", "m", "setOriginal_system_origin", "if_dou", ce.f26395j, "setIf_dou", AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID, OfficeSDKRequestTag.KEY_NEW_USER, "setPromote_instance_id", "need_show_success_notice", "l", "setNeed_show_success_notice", "enable_cancel_reserve", "f", "setEnable_cancel_reserve", "need_show_cancel_alert", ce.f26396k, "setNeed_show_cancel_alert", "reserve_alert_type", "r", "setReserve_alert_type", "report_params", "p", "setReport_params", AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP, "D", "set_rsvp", "use_param_passing", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "setUse_param_passing", "reserve_type", "t", "setReserve_type", "reserve_version_num", "u", "setReserve_version_num", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e3 {

    @SerializedName("ad_id")
    private String ad_id;

    @SerializedName(PdpOpenThirdParam.KEY_AD_LOG_EXTRA)
    private String ad_log_extra;

    @SerializedName("ad_source_type")
    private Integer ad_source_type;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID)
    private String content_id;

    @SerializedName("creative_id")
    private String creative_id;

    @SerializedName("enable_cancel_reserve")
    private Boolean enable_cancel_reserve;

    @SerializedName("enter_method")
    private String enter_method;

    @SerializedName("game_id")
    private String game_id;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    private String game_name;

    @SerializedName("if_dou")
    private Boolean if_dou;

    @SerializedName("is_ad")
    private Boolean is_ad;

    @SerializedName("is_other_channel")
    private String is_other_channel;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP)
    private String is_rsvp;

    @SerializedName("need_show_cancel_alert")
    private Boolean need_show_cancel_alert;

    @SerializedName("need_show_success_notice")
    private Boolean need_show_success_notice;

    @SerializedName("original_system_origin")
    private Integer original_system_origin;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID)
    private String promote_instance_id;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID)
    private String promoter_id;

    @SerializedName("report_params")
    private String report_params;

    @SerializedName("request_id")
    private String request_id;

    @SerializedName("reserve_alert_type")
    private Integer reserve_alert_type;

    @SerializedName("reserve_state")
    private Integer reserve_state;

    @SerializedName("reserve_type")
    private Integer reserve_type;

    @SerializedName("reserve_version_num")
    private String reserve_version_num;

    @SerializedName("scene")
    private Integer scene;

    @SerializedName("stock_type")
    private Integer stock_type;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
    private String sub_scene;

    @SerializedName("traffic_source")
    private String traffic_source;

    @SerializedName("use_param_passing")
    private Boolean use_param_passing;

    @SerializedName("user_nick_name")
    private String user_nick_name;

    public e3() {
    }

    public final String A() {
        return this.user_nick_name;
    }

    public final Boolean B() {
        return this.is_ad;
    }

    public final String C() {
        return this.is_other_channel;
    }

    public final String D() {
        return this.is_rsvp;
    }

    public final String a() {
        return this.ad_id;
    }

    public final String b() {
        return this.ad_log_extra;
    }

    public final Integer c() {
        return this.ad_source_type;
    }

    public final String d() {
        return this.content_id;
    }

    public final String e() {
        return this.creative_id;
    }

    public final Boolean f() {
        return this.enable_cancel_reserve;
    }

    public final String g() {
        return this.enter_method;
    }

    public final String h() {
        return this.game_id;
    }

    public final String i() {
        return this.game_name;
    }

    public final Boolean j() {
        return this.if_dou;
    }

    public final Boolean k() {
        return this.need_show_cancel_alert;
    }

    public final Boolean l() {
        return this.need_show_success_notice;
    }

    public final Integer m() {
        return this.original_system_origin;
    }

    public final String n() {
        return this.promote_instance_id;
    }

    public final String o() {
        return this.promoter_id;
    }

    public final String p() {
        return this.report_params;
    }

    public final String q() {
        return this.request_id;
    }

    public final Integer r() {
        return this.reserve_alert_type;
    }

    public final Integer s() {
        return this.reserve_state;
    }

    public final Integer t() {
        return this.reserve_type;
    }

    public final String u() {
        return this.reserve_version_num;
    }

    public final Integer v() {
        return this.scene;
    }

    public final Integer w() {
        return this.stock_type;
    }

    public final String x() {
        return this.sub_scene;
    }

    public final String y() {
        return this.traffic_source;
    }

    public final Boolean z() {
        return this.use_param_passing;
    }
}
