package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b*\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\ba\u0010bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00102\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR$\u0010C\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u00103\u001a\u0004\bJ\u00105\"\u0004\bK\u00107R\"\u0010L\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\"\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\"\u0010R\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0004\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\"\u0010U\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\u0004\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\"\u0010[\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\u0004\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\"\u0010^\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010\u0004\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\b¨\u0006c"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/a;", "", "", "autoIntroEnabled", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setAutoIntroEnabled", "(Z)V", "", "enterRoomDelay", "I", "f", "()I", "setEnterRoomDelay", "(I)V", "enterRoomDelayForNoIntro", ce.f26391f, "setEnterRoomDelayForNoIntro", "manualIntroInterval", "h", "setManualIntroInterval", "autoIntroInterval", "b", "setAutoIntroInterval", "autoIntroMaxTimes", "c", "setAutoIntroMaxTimes", "manualShowDelayMilliseconds", "getManualShowDelayMilliseconds", "setManualShowDelayMilliseconds", "canIntroDownloadedApps", "e", "setCanIntroDownloadedApps", "sameShowingPriority", "o", "setSameShowingPriority", "showWhenIntroducingManually", "p", "setShowWhenIntroducingManually", "useToolbarData", "getUseToolbarData", "setUseToolbarData", "canIntroNonUnionGame", "getCanIntroNonUnionGame", "setCanIntroNonUnionGame", "canIntroBookGame", "getCanIntroBookGame", "setCanIntroBookGame", "", "reportThreshold", FaceService.girlLabel, "getReportThreshold", "()F", "setReportThreshold", "(F)V", "", "", "userTagFeatures", "Ljava/util/List;", "getUserTagFeatures", "()Ljava/util/List;", "setUserTagFeatures", "(Ljava/util/List;)V", "useNewTag", "getUseNewTag", "setUseNewTag", "businessKey", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setBusinessKey", "(Ljava/lang/String;)V", "predictInterval", OfficeSDKRequestTag.KEY_NEW_USER, "setPredictInterval", "optStrategyFix", "l", "setOptStrategyFix", "optStrategyEnterDelay", ce.f26396k, "setOptStrategyEnterDelay", "optStrategyUP", "m", "setOptStrategyUP", "optStrategyAlive", ce.f26395j, "setOptStrategyAlive", "optMultiGameOrUser", RXScreenCaptureService.KEY_INDEX, "setOptMultiGameOrUser", "autoIntroWhenEnter", "getAutoIntroWhenEnter", "setAutoIntroWhenEnter", "showAutoIntroTag", "getShowAutoIntroTag", "setShowAutoIntroTag", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

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

    @SerializedName("enter_room_no_intro_delay_seconds")
    private int enterRoomDelayForNoIntro;

    @SerializedName("manual_intro_interval_seconds")
    private int manualIntroInterval;

    @SerializedName("manual_override_show_delay_milliseconds")
    private int manualShowDelayMilliseconds;

    @SerializedName("opt_user_portrait_multi_game")
    private boolean optMultiGameOrUser;

    @SerializedName("opt_strategy_keep_alive")
    private boolean optStrategyAlive;

    @SerializedName("opt_strategy_enter_delay")
    private boolean optStrategyEnterDelay;

    @SerializedName("opt_strategy_fix")
    private boolean optStrategyFix;

    @SerializedName("opt_strategy_user_portrait")
    private boolean optStrategyUP;

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

    @SerializedName("push_use_new_tag")
    private boolean useNewTag;

    @SerializedName("use_toolbar_data")
    private boolean useToolbarData;

    @SerializedName("user_tag_features")
    private List<String> userTagFeatures;

    public a() {
        this.enterRoomDelay = 100;
        this.enterRoomDelayForNoIntro = 10;
        this.manualIntroInterval = 5;
        this.autoIntroInterval = 360;
        this.autoIntroMaxTimes = 100;
        this.manualShowDelayMilliseconds = 300;
        this.canIntroDownloadedApps = true;
        this.sameShowingPriority = true;
        this.reportThreshold = 0.01f;
        this.userTagFeatures = new ArrayList();
        this.businessKey = "client_intelligence";
        this.predictInterval = 5.0f;
        this.optMultiGameOrUser = true;
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
        return this.enterRoomDelayForNoIntro;
    }

    public final int h() {
        return this.manualIntroInterval;
    }

    public final boolean i() {
        return this.optMultiGameOrUser;
    }

    public final boolean j() {
        return this.optStrategyAlive;
    }

    public final boolean k() {
        return this.optStrategyEnterDelay;
    }

    public final boolean l() {
        return this.optStrategyFix;
    }

    public final boolean m() {
        return this.optStrategyUP;
    }

    public final float n() {
        return this.predictInterval;
    }

    public final boolean o() {
        return this.sameShowingPriority;
    }

    public final boolean p() {
        return this.showWhenIntroducingManually;
    }
}
