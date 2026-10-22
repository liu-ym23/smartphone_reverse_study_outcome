package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class AppFromEntity {
    private String logo;
    private String mark;
    private String name;
    private String url;

    public AppFromEntity() {
        this.mark = "";
        this.name = "";
        this.logo = "";
        this.url = "";
    }

    public String getLogo() {
        return this.logo;
    }

    public String getMark() {
        return this.mark;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLogo(String r10) {
        this.logo = r10;
    }

    public void setMark(String r10) {
        this.mark = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setUrl(String r10) {
        this.url = r10;
    }
}
