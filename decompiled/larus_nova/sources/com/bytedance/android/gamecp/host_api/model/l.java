package com.bytedance.android.gamecp.host_api.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public class l {

    @SerializedName("uri")
    String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    List<String> urlList;

    public l() {
    }

    public final String toString() {
        return "UrlStruct{uri='" + this.uri + "', urlList=" + this.urlList + '}';
    }

    public final List<String> a() {
        return this.urlList;
    }
}
