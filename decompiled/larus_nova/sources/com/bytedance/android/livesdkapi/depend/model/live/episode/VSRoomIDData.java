package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class VSRoomIDData {

    @SerializedName("episode")
    public Episode episode;

    @SerializedName("episode_stage")
    public int episodeStage;

    @SerializedName("room")
    public IRoom room;

    public VSRoomIDData() {
    }
}
