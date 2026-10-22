package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class LiveOfficialChannelInfo {
    public static final int BOTH = 3;
    public static final int ENTER_FROM = 1;
    public static final int ENTER_METHOD = 2;

    @SerializedName("live_official_channel_anchor_alert_before_end")
    public int alertBeforeEnd;

    @SerializedName("live_enterfrom_control_info")
    public List<ControlInfo> enterFromControl;

    @SerializedName("live_official_channel_anchor_forbid_before_end")
    public int forbidBeforeEnd;

    public static class ControlInfo {
        public ControlInfo() {
        }
    }

    public LiveOfficialChannelInfo() {
        this.forbidBeforeEnd = 5;
        this.alertBeforeEnd = 1;
    }
}
