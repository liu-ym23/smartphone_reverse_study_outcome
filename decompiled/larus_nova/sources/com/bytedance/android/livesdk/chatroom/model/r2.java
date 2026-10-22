package com.bytedance.android.livesdk.chatroom.model;

import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\"\u0010\u000bR\u001a\u0010#\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000bR\u001a\u0010%\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\t\u001a\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001aR\u001a\u0010)\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000bR\u001a\u0010+\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u0010¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/r2;", "", "", "reportDuration", "I", "e", "()I", "", "enableAnimateBg", "Z", "getEnableAnimateBg", "()Z", "", "maxTempWatchDuration", "J", "b", "()J", "", "tempEndViewAlpha", FaceService.girlLabel, "f", "()F", "", "portraitTempWatchBgUrl", "Ljava/lang/String;", "getPortraitTempWatchBgUrl", "()Ljava/lang/String;", "landscapeTempWatchBgUrl", "getLandscapeTempWatchBgUrl", "replayGeneratingUrl", "d", "appLogEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "autoReEnterRoom", "getAutoReEnterRoom", "smoothEnterRoom", "getSmoothEnterRoom", "tempWatchEndPlayerBlur", ce.f26391f, "replayGeneratingUrlLiveEnd", "getReplayGeneratingUrlLiveEnd", "tempWatchEndPlayerFreeze", "h", "mockRefreshStreamInterval", "c", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r2 {

    @SerializedName("core_log_enable")
    private final boolean appLogEnable;

    @SerializedName("auto_re_enter_room")
    private final boolean autoReEnterRoom;

    @SerializedName("enable_animate_bg")
    private final boolean enableAnimateBg;

    @SerializedName("landscape_temp_watch_bg_url")
    private final String landscapeTempWatchBgUrl;

    @SerializedName("max_temp_watch_duration")
    private final long maxTempWatchDuration;

    @SerializedName("temp_watch_refresh_stream_data_interval")
    private final long mockRefreshStreamInterval;

    @SerializedName("portrait_temp_watch_bg_url")
    private final String portraitTempWatchBgUrl;

    @SerializedName("replay_generating_url")
    private final String replayGeneratingUrl;

    @SerializedName("replay_generating_url_live_end")
    private final String replayGeneratingUrlLiveEnd;

    @SerializedName("report_duration")
    private final int reportDuration;

    @SerializedName("smooth_enter_room")
    private final boolean smoothEnterRoom;

    @SerializedName("temp_end_view_alpha")
    private final float tempEndViewAlpha;

    @SerializedName("temp_watch_end_player_blur")
    private final boolean tempWatchEndPlayerBlur;

    @SerializedName("temp_watch_end_player_freeze")
    private final boolean tempWatchEndPlayerFreeze;

    public r2() {
        this(0);
    }

    public final boolean a() {
        return this.appLogEnable;
    }

    public final long b() {
        return this.maxTempWatchDuration;
    }

    public final long c() {
        return this.mockRefreshStreamInterval;
    }

    public final String d() {
        return this.replayGeneratingUrl;
    }

    public final int e() {
        return this.reportDuration;
    }

    public final float f() {
        return this.tempEndViewAlpha;
    }

    public final boolean g() {
        return this.tempWatchEndPlayerBlur;
    }

    public final boolean h() {
        return this.tempWatchEndPlayerFreeze;
    }

    public r2(int r100) {
        Intrinsics.checkNotNullParameter("https://p9.douyinpic.com/aweme-client-static-resource/ttlive_paid_temp_watch_portrait.webp~tplv-obj.image", "portraitTempWatchBgUrl");
        Intrinsics.checkNotNullParameter("https://p9.douyinpic.com/aweme-client-static-resource/ttlive_paid_temp_watch_landscape.webp~tplv-obj.image", "landscapeTempWatchBgUrl");
        Intrinsics.checkNotNullParameter("https://p9.douyinpic.com/aweme-client-static-resource/ttlive_paid_live_replay_generating_new.webp~tplv-obj.image", "replayGeneratingUrl");
        Intrinsics.checkNotNullParameter("https://p9.douyinpic.com/aweme-client-static-resource/ttlive_replay_generating_new.webp~tplv-obj.image", "replayGeneratingUrlLiveEnd");
        this.reportDuration = 10;
        this.enableAnimateBg = true;
        this.maxTempWatchDuration = 300;
        this.tempEndViewAlpha = 0.98f;
        this.portraitTempWatchBgUrl = "https://p9.douyinpic.com/aweme-client-static-resource/ttlive_paid_temp_watch_portrait.webp~tplv-obj.image";
        this.landscapeTempWatchBgUrl = "https://p9.douyinpic.com/aweme-client-static-resource/ttlive_paid_temp_watch_landscape.webp~tplv-obj.image";
        this.replayGeneratingUrl = "https://p9.douyinpic.com/aweme-client-static-resource/ttlive_paid_live_replay_generating_new.webp~tplv-obj.image";
        this.appLogEnable = true;
        this.autoReEnterRoom = false;
        this.smoothEnterRoom = true;
        this.tempWatchEndPlayerBlur = true;
        this.replayGeneratingUrlLiveEnd = "https://p9.douyinpic.com/aweme-client-static-resource/ttlive_replay_generating_new.webp~tplv-obj.image";
        this.tempWatchEndPlayerFreeze = false;
        this.mockRefreshStreamInterval = 20;
    }
}
