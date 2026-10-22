package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class CoverImageModel {
    private String mPath;

    @SerializedName("uri")
    String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    List<String> urlList;

    public CoverImageModel() {
    }

    public String getPath() {
        return this.mPath;
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrlList() {
        return this.urlList;
    }

    public void setPath(String r100) {
        this.mPath = r100;
    }

    public void setUri(String r100) {
        this.uri = r100;
    }

    public void setUrlList(List<String> r100) {
        this.urlList = r100;
    }
}
