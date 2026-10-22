package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class VideoEntity {
    private String direct;
    private String img;
    private String url;

    public VideoEntity() {
        this.img = "";
        this.url = "";
        this.direct = "";
    }

    public String getDirect() {
        return this.direct;
    }

    public String getImg() {
        return this.img;
    }

    public String getUrl() {
        return this.url;
    }

    public void setDirect(String r10) {
        this.direct = r10;
    }

    public void setImg(String r10) {
        this.img = r10;
    }

    public void setUrl(String r10) {
        this.url = r10;
    }
}
