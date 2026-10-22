package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R\"\u00105\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010*\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R\u001a\u00108\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006¨\u0006<"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/c;", "", "", "enableMultiGameSupport", "Z", "c", "()Z", "setEnableMultiGameSupport", "(Z)V", "", "", "multiGameConfig", "Ljava/util/Map;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/Map;", "enable", "b", "setEnable", "shouldIntercept", ce.f26396k, "setShouldIntercept", "", "predictInterval", FaceService.girlLabel, ce.f26395j, "()F", "setPredictInterval", "(F)V", "reportThreshold", "getReportThreshold", "setReportThreshold", "useNewTag", "getUseNewTag", "setUseNewTag", "businessKey", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setBusinessKey", "(Ljava/lang/String;)V", "", "maxDailyShowPassive", "I", "f", "()I", "setMaxDailyShowPassive", "(I)V", "maxTotalShowPassive", "h", "setMaxTotalShowPassive", "maxDailyShowActive", "e", "setMaxDailyShowActive", "maxTotalShowActive", ce.f26391f, "setMaxTotalShowActive", "installFailPushEnable", "d", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_BUSINESS_KEY_STRING)
    private String businessKey;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("multi_game_support_enable")
    private boolean enableMultiGameSupport;

    @SerializedName("check_install_fail_push_enable")
    private final boolean installFailPushEnable;

    @SerializedName("max_daily_show_active")
    private int maxDailyShowActive;

    @SerializedName("max_daily_show_passive")
    private int maxDailyShowPassive;

    @SerializedName("max_total_show_active")
    private int maxTotalShowActive;

    @SerializedName("max_total_show_passive")
    private int maxTotalShowPassive;

    @SerializedName("push_ab_params")
    private final Map<String, String> multiGameConfig;

    @SerializedName("push_predict_interval")
    private float predictInterval;

    @SerializedName("push_report_threshold")
    private float reportThreshold;

    @SerializedName("shouldIntercept")
    private boolean shouldIntercept;

    @SerializedName("push_use_new_tag")
    private boolean useNewTag;

    public c() {
        this.multiGameConfig = new LinkedHashMap();
        this.enable = true;
        this.predictInterval = 2.0f;
        this.reportThreshold = 0.01f;
        this.businessKey = "client_intelligence_push";
        this.maxDailyShowPassive = 1;
        this.maxTotalShowPassive = 3;
        this.maxDailyShowActive = 3;
        this.maxTotalShowActive = 5;
        this.installFailPushEnable = true;
    }

    public final String a() {
        return this.businessKey;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableMultiGameSupport;
    }

    public final boolean d() {
        return this.installFailPushEnable;
    }

    public final int e() {
        return this.maxDailyShowActive;
    }

    public final int f() {
        return this.maxDailyShowPassive;
    }

    public final int g() {
        return this.maxTotalShowActive;
    }

    public final int h() {
        return this.maxTotalShowPassive;
    }

    public final Map<String, String> i() {
        return this.multiGameConfig;
    }

    public final float j() {
        return this.predictInterval;
    }

    public final boolean k() {
        return this.shouldIntercept;
    }
}
