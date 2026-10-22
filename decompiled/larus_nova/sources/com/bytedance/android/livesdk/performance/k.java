package com.bytedance.android.livesdk.performance;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes11.dex */
public class k {

    @SerializedName("comment_white_list")
    @Nullable
    public List<String> commentWhiteList;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("exclude_keyword_list")
    @Nullable
    public List<String> excludeKeywordList;

    @SerializedName("keyword_white_list")
    @Nullable
    public List<String> keywordWhiteList;

    @SerializedName("log_cache_interval_second")
    public int logCacheIntervalSecond;

    @SerializedName("resident_interval")
    public long residentInterval;

    @SerializedName("white_list")
    @Nullable
    public List<String> whiteList;

    public k() {
        this.enable = false;
        this.residentInterval = -1;
        this.whiteList = null;
        this.logCacheIntervalSecond = 300;
        this.commentWhiteList = null;
    }
}
