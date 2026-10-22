package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class EpisodeGroup {

    @SerializedName("info_list")
    public List<Episode> episodes;

    @SerializedName("extra")
    public ReplayListExtra extra;

    @SerializedName("type_name")
    public String groupName;

    public EpisodeGroup() {
    }
}
