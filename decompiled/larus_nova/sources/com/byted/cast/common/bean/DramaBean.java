package com.byted.cast.common.bean;

import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class DramaBean {
    private String dramaId;
    private MediaAssetBean mediaAssetBean;
    private List<UrlBean> urlBeans;

    public DramaBean() {
    }

    public String toString() {
        return "DramaBean{dramaId='" + this.dramaId + "', urlBeans=" + this.urlBeans + ", mediaAssetBean=" + this.mediaAssetBean + '}';
    }

    public String getDramaId() {
        return this.dramaId;
    }

    public MediaAssetBean getMediaAssetBean() {
        return this.mediaAssetBean;
    }

    public List<UrlBean> getUrlBeans() {
        return this.urlBeans;
    }

    public void setDramaId(String r100) {
        this.dramaId = r100;
    }

    public void setMediaAssetBean(MediaAssetBean r100) {
        this.mediaAssetBean = r100;
    }

    public void setUrlBeans(List<UrlBean> r100) {
        this.urlBeans = r100;
    }
}
