package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public class EpisodeOnlyTaSegments {

    @SerializedName("avatar")
    public k avatar;

    @SerializedName(DBDefinition.SEGMENT_TABLE_NAME)
    public List<EpisodeOnlyTaSegmentScope> scopes;

    @SerializedName("ta_id")
    public long taId;

    @SerializedName("ta_nick_name")
    public String taNickname;

    public EpisodeOnlyTaSegments() {
    }
}
