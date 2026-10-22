package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class UserLiveStatusModel {

    @SerializedName("live_status")
    public int liveStatus;

    @SerializedName("open_user_id")
    public String openUserId;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("room_id_str")
    public String room_id_str;

    public UserLiveStatusModel() {
    }

    public String toString() {
        return "UserLiveStatusModel{openUserId='" + this.openUserId + "', roomId=" + this.roomId + ", liveStatus=" + this.liveStatus + ", room_id_str='" + this.room_id_str + '\'';
    }
}
