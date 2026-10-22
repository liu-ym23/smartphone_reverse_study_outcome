package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveAILyricParticleConfig;", "", "()V", "liveAiLyricParticleAnchorEnable", "", "getLiveAiLyricParticleAnchorEnable", "()Ljava/lang/Boolean;", "setLiveAiLyricParticleAnchorEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "liveAiLyricParticleAudienceEnable", "getLiveAiLyricParticleAudienceEnable", "setLiveAiLyricParticleAudienceEnable", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAILyricParticleConfig {

    @SerializedName("live_ai_lyric_particle_anchor_enable")
    private Boolean liveAiLyricParticleAnchorEnable;

    @SerializedName("live_ai_lyric_particle_audience_enable")
    private Boolean liveAiLyricParticleAudienceEnable;

    public LiveAILyricParticleConfig() {
        Boolean r100 = Boolean.FALSE;
        this.liveAiLyricParticleAnchorEnable = r100;
        this.liveAiLyricParticleAudienceEnable = r100;
    }

    public final Boolean getLiveAiLyricParticleAnchorEnable() {
        return this.liveAiLyricParticleAnchorEnable;
    }

    public final Boolean getLiveAiLyricParticleAudienceEnable() {
        return this.liveAiLyricParticleAudienceEnable;
    }

    public final void setLiveAiLyricParticleAnchorEnable(Boolean r100) {
        this.liveAiLyricParticleAnchorEnable = r100;
    }

    public final void setLiveAiLyricParticleAudienceEnable(Boolean r100) {
        this.liveAiLyricParticleAudienceEnable = r100;
    }
}
