package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0016\u0010\u0018\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0016\u0010\u001a\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0016\u0010\u001c\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u0016\u0010\u001e\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerMixedAudioConfig;", "", "()V", "delayTTVideoEngineCheck", "", "getDelayTTVideoEngineCheck", "()Z", "doubleCheckMixedAudioPlayer", "getDoubleCheckMixedAudioPlayer", "enableMixedAudioCheck", "getEnableMixedAudioCheck", "enableMixedAudioCheckDelayTime", "", "getEnableMixedAudioCheckDelayTime", "()J", "enableMixedAudioCheckV2", "getEnableMixedAudioCheckV2", "enableMuteMixedAudioScenes", "", "", "getEnableMuteMixedAudioScenes", "()Ljava/util/List;", "enableReportVideoMixed", "getEnableReportVideoMixed", "enableTTVideoEngineMixedAudio", "getEnableTTVideoEngineMixedAudio", "fixPreviewResumeMixedAudio", "getFixPreviewResumeMixedAudio", "mixedAudioCheckInterval", "getMixedAudioCheckInterval", "mockMixedAudioEvent", "getMockMixedAudioEvent", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerMixedAudioConfig {

    @SerializedName("delay_tt_video_engine_check")
    private final boolean delayTTVideoEngineCheck;

    @SerializedName("double_check_mixed_audio_player")
    private final boolean doubleCheckMixedAudioPlayer;

    @SerializedName("enable_business_mixed_audio_check")
    private final boolean enableMixedAudioCheck;

    @SerializedName("mixed_audio_check_v2_delay_time")
    private final long enableMixedAudioCheckDelayTime;

    @SerializedName("enable_mixed_audio_check_v2")
    private final boolean enableMixedAudioCheckV2;

    @SerializedName("enable_mute_mixed_audio_scenes")
    private final List<String> enableMuteMixedAudioScenes;

    @SerializedName("enable_report_video_mixed")
    private final boolean enableReportVideoMixed;

    @SerializedName("enable_tt_video_engine_mixed_audio_check")
    private final boolean enableTTVideoEngineMixedAudio;

    @SerializedName("fix_preview_resume_mixed_audio")
    private final boolean fixPreviewResumeMixedAudio;

    @SerializedName("mixed_audio_check_interval")
    private final long mixedAudioCheckInterval;

    @SerializedName("mock_mixed_audio_event")
    private final boolean mockMixedAudioEvent;

    public PlayerMixedAudioConfig() {
        this.enableMixedAudioCheck = true;
        this.mixedAudioCheckInterval = 3;
        this.doubleCheckMixedAudioPlayer = true;
        this.enableMixedAudioCheckDelayTime = 300;
        this.enableMuteMixedAudioScenes = CollectionsKt.listOf(new String[]{"inner_draw", "feed_preview"});
    }

    public final boolean getDelayTTVideoEngineCheck() {
        return this.delayTTVideoEngineCheck;
    }

    public final boolean getDoubleCheckMixedAudioPlayer() {
        return this.doubleCheckMixedAudioPlayer;
    }

    public final boolean getEnableMixedAudioCheck() {
        return this.enableMixedAudioCheck;
    }

    public final long getEnableMixedAudioCheckDelayTime() {
        return this.enableMixedAudioCheckDelayTime;
    }

    public final boolean getEnableMixedAudioCheckV2() {
        return this.enableMixedAudioCheckV2;
    }

    public final List<String> getEnableMuteMixedAudioScenes() {
        return this.enableMuteMixedAudioScenes;
    }

    public final boolean getEnableReportVideoMixed() {
        return this.enableReportVideoMixed;
    }

    public final boolean getEnableTTVideoEngineMixedAudio() {
        return this.enableTTVideoEngineMixedAudio;
    }

    public final boolean getFixPreviewResumeMixedAudio() {
        return this.fixPreviewResumeMixedAudio;
    }

    public final long getMixedAudioCheckInterval() {
        return this.mixedAudioCheckInterval;
    }

    public final boolean getMockMixedAudioEvent() {
        return this.mockMixedAudioEvent;
    }
}
