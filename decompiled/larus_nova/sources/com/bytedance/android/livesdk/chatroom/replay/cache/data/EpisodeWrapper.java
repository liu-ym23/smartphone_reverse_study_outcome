package com.bytedance.android.livesdk.chatroom.replay.cache.data;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class EpisodeWrapper {

    @SerializedName("episode")
    public Episode episode;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    public int itemType;

    public EpisodeWrapper() {
    }
}
