package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class SingingChallengeLiveCoreInfo extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.i2> implements com.bytedance.android.livesdk.link.model.bridge.i2 {

    @SerializedName("live_core_info_map")
    public Map<Long, String> livecoreInfoMap;

    public SingingChallengeLiveCoreInfo() {
        super(com.bytedance.android.livesdk.link.model.bridge.i2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.i2
    public Map<Long, String> getLivecoreInfoMap() {
        return this.livecoreInfoMap;
    }
}
