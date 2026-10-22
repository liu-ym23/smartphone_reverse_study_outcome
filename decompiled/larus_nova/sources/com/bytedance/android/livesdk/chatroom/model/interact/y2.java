package com.bytedance.android.livesdk.chatroom.model.interact;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class y2 {

    @SerializedName("custom_team_config")
    public w1 customTeamConfig;

    @SerializedName("duration_list")
    public List<Long> durationList;

    @SerializedName("finish_fallback_delay_sec")
    public long fallbackDelay;

    @SerializedName("score_type_list")
    public List<Integer> scoreList;

    @SerializedName("score_type_info_list")
    public List<a> scoreListInfo;

    public static class a {

        @SerializedName("intro")
        public String intro;

        @SerializedName("title")
        public String title;

        @SerializedName("type")
        public int type;

        public a() {
        }
    }

    public y2() {
        this.fallbackDelay = 5;
    }
}
