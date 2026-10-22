package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R,\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerAudioAbnormalCheckConfig;", "", "()V", "enableAbnormalMuteChecker", "", "getEnableAbnormalMuteChecker", "()Z", "muteCheckScenes", "", "", "", "getMuteCheckScenes", "()Ljava/util/Map;", "setMuteCheckScenes", "(Ljava/util/Map;)V", "muteMonitorDuration", "getMuteMonitorDuration", "()I", "muteStackBlackList", "", "getMuteStackBlackList", "()Ljava/util/List;", "setMuteStackBlackList", "(Ljava/util/List;)V", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerAudioAbnormalCheckConfig {

    @SerializedName("enable_abnormal_mute_checker")
    private final boolean enableAbnormalMuteChecker;

    @SerializedName("mute_check_scenes")
    private Map<String, Integer> muteCheckScenes;

    @SerializedName("mute_monitor_duration")
    private final int muteMonitorDuration;

    @SerializedName("mute_stack_blacklist")
    private List<String> muteStackBlackList;

    public PlayerAudioAbnormalCheckConfig() {
        this.muteMonitorDuration = 3;
    }

    public final boolean getEnableAbnormalMuteChecker() {
        return this.enableAbnormalMuteChecker;
    }

    public final Map<String, Integer> getMuteCheckScenes() {
        return this.muteCheckScenes;
    }

    public final int getMuteMonitorDuration() {
        return this.muteMonitorDuration;
    }

    public final List<String> getMuteStackBlackList() {
        return this.muteStackBlackList;
    }

    public final void setMuteCheckScenes(Map<String, Integer> r100) {
        this.muteCheckScenes = r100;
    }

    public final void setMuteStackBlackList(List<String> r100) {
        this.muteStackBlackList = r100;
    }
}
