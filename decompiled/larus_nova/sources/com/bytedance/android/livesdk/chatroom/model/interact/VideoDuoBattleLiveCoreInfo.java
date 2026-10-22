package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class VideoDuoBattleLiveCoreInfo extends FlexModelBase<g2> implements g2 {

    @SerializedName("live_core_info_map")
    public Map<Long, String> liveCoreExtInfoMap;

    public VideoDuoBattleLiveCoreInfo() {
        super(g2.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g2
    public Map<Long, String> getLiveCoreExtInfoMap() {
        return this.liveCoreExtInfoMap;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.g2
    public void setLiveCoreExtInfoMap(Map<Long, String> r100) {
        this.liveCoreExtInfoMap = r100;
    }
}
