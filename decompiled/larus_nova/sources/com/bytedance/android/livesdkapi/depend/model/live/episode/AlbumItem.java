package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class AlbumItem {

    @SerializedName("episode")
    public Episode episode;

    @SerializedName("is_hide")
    public boolean isHide;

    @SerializedName("is_playing")
    public boolean isPlaying;

    @SerializedName("room")
    public IRoom room;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    public int type;

    public AlbumItem() {
    }
}
