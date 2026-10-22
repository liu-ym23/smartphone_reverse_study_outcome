package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bH\u0010IR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00102\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\b¨\u0006J"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/b;", "", "", "autoIntroEnabled", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setAutoIntroEnabled", "(Z)V", "allRoomAutoIntroEnabled", "getAllRoomAutoIntroEnabled", "setAllRoomAutoIntroEnabled", "", "enterRoomDelay", "I", "f", "()I", "setEnterRoomDelay", "(I)V", "manualIntroInterval", ce.f26391f, "setManualIntroInterval", "autoIntroInterval", "b", "setAutoIntroInterval", "autoIntroMaxTimes", "c", "setAutoIntroMaxTimes", "manualShowDelayMilliseconds", "getManualShowDelayMilliseconds", "setManualShowDelayMilliseconds", "canIntroDownloadedApps", "e", "setCanIntroDownloadedApps", "sameShowingPriority", "h", "setSameShowingPriority", "showWhenIntroducingManually", RXScreenCaptureService.KEY_INDEX, "setShowWhenIntroducingManually", "useToolbarData", "getUseToolbarData", "setUseToolbarData", "canIntroNonUnionGame", "getCanIntroNonUnionGame", "setCanIntroNonUnionGame", "canIntroBookGame", "getCanIntroBookGame", "setCanIntroBookGame", "", "reportThreshold", FaceService.girlLabel, "getReportThreshold", "()F", "setReportThreshold", "(F)V", "predictInterval", "getPredictInterval", "setPredictInterval", "", "businessKey", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setBusinessKey", "(Ljava/lang/String;)V", "autoIntroWhenEnter", "getAutoIntroWhenEnter", "setAutoIntroWhenEnter", "showAutoIntroTag", "getShowAutoIntroTag", "setShowAutoIntroTag", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("all_room_auto_intro_enabled")
    private boolean allRoomAutoIntroEnabled;

    @SerializedName("auto_intro_enabled")
    private boolean autoIntroEnabled;

    @SerializedName("auto_intro_interval_seconds")
    private int autoIntroInterval;

    @SerializedName("auto_intro_max_times")
    private int autoIntroMaxTimes;

    @SerializedName("auto_intro_when_enter")
    private boolean autoIntroWhenEnter;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_BUSINESS_KEY_STRING)
    private String businessKey;

    @SerializedName("can_intro_book_game")
    private boolean canIntroBookGame;

    @SerializedName("can_intro_downloaded_apps")
    private boolean canIntroDownloadedApps;

    @SerializedName("can_intro_nonunion_game")
    private boolean canIntroNonUnionGame;

    @SerializedName("enter_room_delay_seconds")
    private int enterRoomDelay;

    @SerializedName("manual_intro_interval_seconds")
    private int manualIntroInterval;

    @SerializedName("manual_override_show_delay_milliseconds")
    private int manualShowDelayMilliseconds;

    @SerializedName("predict_interval")
    private float predictInterval;

    @SerializedName("report_threshold")
    private float reportThreshold;

    @SerializedName("same_showing_priority")
    private boolean sameShowingPriority;

    @SerializedName("show_auto_intro_tag")
    private boolean showAutoIntroTag;

    @SerializedName("show_when_introducing_manually")
    private boolean showWhenIntroducingManually;

    @SerializedName("use_toolbar_data")
    private boolean useToolbarData;

    public b() {
        this.autoIntroEnabled = true;
        this.enterRoomDelay = 10;
        this.manualIntroInterval = 5;
        this.autoIntroInterval = 360;
        this.autoIntroMaxTimes = 100;
        this.manualShowDelayMilliseconds = 300;
        this.canIntroDownloadedApps = true;
        this.sameShowingPriority = true;
        this.predictInterval = 5.0f;
        this.businessKey = "client_intelligence";
    }

    public final boolean a() {
        return this.autoIntroEnabled;
    }

    public final int b() {
        return this.autoIntroInterval;
    }

    public final int c() {
        return this.autoIntroMaxTimes;
    }

    public final String d() {
        return this.businessKey;
    }

    public final boolean e() {
        return this.canIntroDownloadedApps;
    }

    public final int f() {
        return this.enterRoomDelay;
    }

    public final int g() {
        return this.manualIntroInterval;
    }

    public final boolean h() {
        return this.sameShowingPriority;
    }

    public final boolean i() {
        return this.showWhenIntroducingManually;
    }
}
