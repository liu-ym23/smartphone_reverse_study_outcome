package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileHighScoreSong {

    @SerializedName("count_str")
    String countStr;

    @SerializedName("count_substr")
    String countSubStr;

    @SerializedName("song_list_schema")
    String songListSchema;

    public ProfileHighScoreSong() {
    }

    public String getCountStr() {
        return this.countStr;
    }

    public String getCountSubStr() {
        return this.countSubStr;
    }

    public String getSongListSchema() {
        return this.songListSchema;
    }
}
