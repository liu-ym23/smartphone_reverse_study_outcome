package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class SeasonAlbumTab {

    @SerializedName("episodes")
    public List<AlbumItem> episodes;

    @SerializedName("special_episodes")
    public List<AlbumItem> specialEpisodes;

    public SeasonAlbumTab() {
    }
}
