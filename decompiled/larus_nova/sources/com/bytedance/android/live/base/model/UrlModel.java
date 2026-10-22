package com.bytedance.android.live.base.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class UrlModel {

    @SerializedName("uri")
    String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    List<String> urlList;

    public UrlModel() {
    }

    public py.k toImgModel() {
        py.k r100 = (py.k) vh7.f.c(py.k.class);
        r100.setUri(this.uri);
        r100.setUrls(this.urlList);
        return r100;
    }

    public String toString() {
        return "UrlStruct{uri='" + this.uri + "', urlList=" + this.urlList + '}';
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrlList() {
        return this.urlList;
    }

    public void setUri(String r100) {
        this.uri = r100;
    }

    public void setUrlList(List<String> r100) {
        this.urlList = r100;
    }
}
