package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class MoreSpectacular {

    @SerializedName("background_colors")
    public List<String> colors;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String desc;

    @SerializedName("episodes")
    public List<AlbumItem> episodes;

    @SerializedName("extension_type")
    public long extensionType;

    @SerializedName("more_entry_list")
    public List<MoreEntry> moreEntryList;

    @SerializedName("more_seasons")
    public MoreSeason moreSeason;

    @SerializedName("title")
    public String title;

    @SerializedName("total")
    public long total;

    public MoreSpectacular() {
    }
}
