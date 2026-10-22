package com.bytedanceos.appstore.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Developer implements Serializable {
    private static final long serialVersionUID = -2487370583787503286L;
    private String devBanner;
    private String devInfo;
    private String devName;
    private String deverId;

    public Developer() {
    }

    public String getDevBanner() {
        return this.devBanner;
    }

    public String getDevInfo() {
        return this.devInfo;
    }

    public String getDevName() {
        return this.devName;
    }

    public String getDeverId() {
        return this.deverId;
    }

    public void setDevBanner(String r10) {
        this.devBanner = r10;
    }

    public void setDevInfo(String r10) {
        this.devInfo = r10;
    }

    public void setDevName(String r10) {
        this.devName = r10;
    }

    public void setDeverId(String r10) {
        this.deverId = r10;
    }
}
