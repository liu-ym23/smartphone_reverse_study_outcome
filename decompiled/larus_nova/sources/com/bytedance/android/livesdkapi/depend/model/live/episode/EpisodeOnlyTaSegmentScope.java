package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;

/* JADX INFO: loaded from: classes12.dex */
public class EpisodeOnlyTaSegmentScope {

    @SerializedName(DbJsonConstants.DBJSON_KEY_START_OFFSET)
    public int startOffset;

    @SerializedName("stop_offset")
    public int stopOffset;

    public EpisodeOnlyTaSegmentScope() {
    }
}
