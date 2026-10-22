package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ReplayInfo extends FlexModelBase<IReplayInfo> implements IReplayInfo {

    @SerializedName("content_uniq_id")
    public String contentUniqId;

    @SerializedName("replay_duration")
    public int replayDuration;

    @SerializedName("replay_url")
    public String replayUrl;

    public ReplayInfo() {
        super(IReplayInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IReplayInfo
    public String getContentUniqId() {
        return this.contentUniqId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IReplayInfo
    public int getReplayDuration() {
        return this.replayDuration;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IReplayInfo
    public String getReplayUrl() {
        return this.replayUrl;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IReplayInfo
    public void setContentUniqId(String r100) {
        this.contentUniqId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IReplayInfo
    public void setReplayDuration(int r100) {
        this.replayDuration = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IReplayInfo
    public void setReplayUrl(String r100) {
        this.replayUrl = r100;
    }
}
