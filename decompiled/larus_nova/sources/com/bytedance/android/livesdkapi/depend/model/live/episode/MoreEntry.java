package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class MoreEntry {

    @SerializedName("batch_size")
    public long batchSize;

    @SerializedName("background_colors")
    public List<String> colors;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String desc;

    @SerializedName("display_type")
    public long displayType;

    @SerializedName("episode_ids")
    public List<Long> episodeIds;

    @SerializedName("episode_ids_str")
    public List<String> episodeIdsStr;

    @SerializedName("episodes")
    public List<AlbumItem> episodes;

    @SerializedName("extension_type")
    public long extensionType;

    @SerializedName("second_title")
    public String secondTitle;

    @SerializedName("title")
    public String title;

    @SerializedName("total")
    public long total;

    public MoreEntry() {
    }
}
