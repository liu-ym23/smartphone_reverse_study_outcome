package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerPrePrepareConfig;", "", "()V", "enableInnerDrawPrePrepare", "", "getEnableInnerDrawPrePrepare", "()Z", "enableInnerDrawSlideDown", "getEnableInnerDrawSlideDown", "enablePreviewPrePrepare", "getEnablePreviewPrePrepare", "enablePreviewPrePrepareOpt", "getEnablePreviewPrePrepareOpt", "enableUnifyPip", "getEnableUnifyPip", "innerDrawDelayTime", "", "getInnerDrawDelayTime", "()J", "preCreateLivePlayer", "getPreCreateLivePlayer", "pullResolutionFixed", "getPullResolutionFixed", "updateStateMachine", "getUpdateStateMachine", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerPrePrepareConfig {

    @SerializedName("enable_inner_draw_pre_prepare")
    private final boolean enableInnerDrawPrePrepare;

    @SerializedName("enable_inner_draw_slide_down")
    private final boolean enableInnerDrawSlideDown;

    @SerializedName("enable_preview_pre_prepare")
    private final boolean enablePreviewPrePrepare;

    @SerializedName("enable_preview_pre_prepare_opt")
    private final boolean enablePreviewPrePrepareOpt;

    @SerializedName("enable_unify_pip")
    private final boolean enableUnifyPip;

    @SerializedName("inner_draw_delay_time")
    private final long innerDrawDelayTime;

    @SerializedName("pre_create_live_player")
    private final boolean preCreateLivePlayer;

    @SerializedName("pull_resolution_fixed")
    private final boolean pullResolutionFixed;

    @SerializedName("enable_update_state_machine")
    private final boolean updateStateMachine;

    public PlayerPrePrepareConfig() {
    }

    public final boolean getEnableInnerDrawPrePrepare() {
        return this.enableInnerDrawPrePrepare;
    }

    public final boolean getEnableInnerDrawSlideDown() {
        return this.enableInnerDrawSlideDown;
    }

    public final boolean getEnablePreviewPrePrepare() {
        return this.enablePreviewPrePrepare;
    }

    public final boolean getEnablePreviewPrePrepareOpt() {
        return this.enablePreviewPrePrepareOpt;
    }

    public final boolean getEnableUnifyPip() {
        return this.enableUnifyPip;
    }

    public final long getInnerDrawDelayTime() {
        return this.innerDrawDelayTime;
    }

    public final boolean getPreCreateLivePlayer() {
        return this.preCreateLivePlayer;
    }

    public final boolean getPullResolutionFixed() {
        return this.pullResolutionFixed;
    }

    public final boolean getUpdateStateMachine() {
        return this.updateStateMachine;
    }
}
