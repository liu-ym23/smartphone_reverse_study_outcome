package com.bytedanceos.common.networkv2.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class ReportCustomParams {
    private String app_name;
    private String app_type;
    private String clickposition_type;
    private String pkg_name;
    private String topic_id;
    private String topic_name;
    private String web_url;

    public ReportCustomParams() {
        this.pkg_name = "";
        this.app_name = "";
        this.app_type = "";
        this.topic_id = "";
        this.topic_name = "";
        this.clickposition_type = "";
        this.web_url = "";
    }

    public String getApp_name() {
        return this.app_name;
    }

    public String getApp_type() {
        return this.app_type;
    }

    public String getClickposition_type() {
        return this.clickposition_type;
    }

    public String getPkg_name() {
        return this.pkg_name;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public String getTopic_name() {
        return this.topic_name;
    }

    public String getWeb_url() {
        return this.web_url;
    }

    public void setApp_name(String r10) {
        this.app_name = r10;
    }

    public void setApp_type(String r10) {
        this.app_type = r10;
    }

    public void setClickposition_type(String r10) {
        this.clickposition_type = r10;
    }

    public void setPkg_name(String r10) {
        this.pkg_name = r10;
    }

    public void setTopic_id(String r10) {
        this.topic_id = r10;
    }

    public void setTopic_name(String r10) {
        this.topic_name = r10;
    }

    public void setWeb_url(String r10) {
        this.web_url = r10;
    }
}
