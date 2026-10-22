package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class MultiAnchorLinkmicRtcInfo extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.o1> implements com.bytedance.android.livesdk.link.model.bridge.o1 {

    @SerializedName("push_stream_mode_rtc_map")
    public Map<Long, String> pushStreamModeRTCMap;

    @SerializedName("rtc_info_map")
    public Map<Long, String> rtcInfoMap;

    public MultiAnchorLinkmicRtcInfo() {
        super(com.bytedance.android.livesdk.link.model.bridge.o1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.o1
    public Map<Long, String> getPushStreamModeRTCMap() {
        return this.pushStreamModeRTCMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.o1
    public Map<Long, String> getRtcInfoMap() {
        return this.rtcInfoMap;
    }
}
