package com.bytedanceos.common.ad.entity.rep.media;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class RepSplashMediaEntity extends RepMediaEntity {
    private String app_name;
    private String button_text;
    private int creative_style;
    private int creative_type;
    private String creative_url;
    private String deeplink_url;
    private String description;
    private String download_url;
    private String ext;

    @SerializedName("package")
    private String pkg;
    private String subject;
    private String title;
    private String web_url;

    public RepSplashMediaEntity() {
        this.creative_style = 0;
        this.creative_type = 0;
        this.creative_url = "";
        this.download_url = "";
        this.web_url = "";
        this.subject = "";
        this.pkg = "";
        this.app_name = "";
        this.button_text = "";
        this.description = "";
        this.title = "";
        this.ext = "";
        this.deeplink_url = "";
    }

    public String getApp_name() {
        return this.app_name;
    }

    public String getButton_text() {
        return this.button_text;
    }

    public int getCreative_style() {
        return this.creative_style;
    }

    public int getCreative_type() {
        return this.creative_type;
    }

    public String getCreative_url() {
        return this.creative_url;
    }

    public String getDeeplink_url() {
        return this.deeplink_url;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDownload_url() {
        return this.download_url;
    }

    public String getExt() {
        return this.ext;
    }

    public String getPkg() {
        return this.pkg;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWeb_url() {
        return this.web_url;
    }

    public void setApp_name(String r10) {
        this.app_name = r10;
    }

    public void setButton_text(String r10) {
        this.button_text = r10;
    }

    public void setCreative_style(int r10) {
        this.creative_style = r10;
    }

    public void setCreative_type(int r10) {
        this.creative_type = r10;
    }

    public void setCreative_url(String r10) {
        this.creative_url = r10;
    }

    public void setDeeplink_url(String r10) {
        this.deeplink_url = r10;
    }

    public void setDescription(String r10) {
        this.description = r10;
    }

    public void setDownload_url(String r10) {
        this.download_url = r10;
    }

    public void setExt(String r10) {
        this.ext = r10;
    }

    public void setPkg(String r10) {
        this.pkg = r10;
    }

    public void setSubject(String r10) {
        this.subject = r10;
    }

    public void setTitle(String r10) {
        this.title = r10;
    }

    public void setWeb_url(String r10) {
        this.web_url = r10;
    }
}
