package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.livesdk.link.model.g9;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class SingingChallengeRtcInfo extends FlexModelBase<g9> implements g9 {

    @SerializedName("rtc_info_map")
    public Map<Long, String> rtcInfoMap;

    public SingingChallengeRtcInfo() {
        super(g9.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.g9
    public Map<Long, String> getRtcInfoMap() {
        return this.rtcInfoMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.g9
    public void setRtcInfoMap(Map<Long, String> r100) {
        this.rtcInfoMap = r100;
    }
}
