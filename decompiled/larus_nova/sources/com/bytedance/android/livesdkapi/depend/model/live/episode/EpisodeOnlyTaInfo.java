package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public class EpisodeOnlyTaInfo {

    @SerializedName("full_avatar")
    public k fullAvatar;

    @SerializedName("full_text")
    public String fullText;

    @SerializedName("Tas")
    public List<EpisodeOnlyTaSegments> segments;

    public EpisodeOnlyTaInfo() {
    }
}
