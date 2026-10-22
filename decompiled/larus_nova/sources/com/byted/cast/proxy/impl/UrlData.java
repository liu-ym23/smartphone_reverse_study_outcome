package com.byted.cast.proxy.impl;

/* JADX INFO: loaded from: classes39.dex */
public class UrlData {

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private String f33725iv;
    private String mediaType;
    private String originUrl;
    private String outputResolution;
    private String token;

    public UrlData deepCopy() {
        return new UrlData(this.originUrl, this.token, this.f33725iv, this.mediaType, this.outputResolution);
    }

    public String getIv() {
        return this.f33725iv;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getOriginUrl() {
        return this.originUrl;
    }

    public String getOutputResolution() {
        return this.outputResolution;
    }

    public String getToken() {
        return this.token;
    }

    public void setIv(String r100) {
        this.f33725iv = r100;
    }

    public void setMediaType(String r100) {
        this.mediaType = r100;
    }

    public void setOriginUrl(String r100) {
        this.originUrl = r100;
    }

    public void setOutputResolution(String r100) {
        this.outputResolution = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public UrlData(String r100, String r101, String r102, String r103, String r104) {
        this.originUrl = r100;
        this.token = r101;
        this.f33725iv = r102;
        this.mediaType = r103;
        this.outputResolution = r104;
    }
}
