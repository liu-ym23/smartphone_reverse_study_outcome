package com.bytedanceos.common.networkv2.cloudsettings;

/* JADX INFO: loaded from: classes2.dex */
public class SettingConfigEntity {
    private String md5;
    private String update_time;
    private String uri;
    private String version;

    public SettingConfigEntity() {
        this.uri = "";
        this.md5 = "";
        this.version = "";
        this.update_time = "";
    }

    public String getMd5() {
        return this.md5;
    }

    public String getUpdate_time() {
        return this.update_time;
    }

    public String getUri() {
        return this.uri;
    }

    public String getVersion() {
        return this.version;
    }

    public void setMd5(String r10) {
        this.md5 = r10;
    }

    public void setUpdate_time(String r10) {
        this.update_time = r10;
    }

    public void setUri(String r10) {
        this.uri = r10;
    }

    public void setVersion(String r10) {
        this.version = r10;
    }
}
