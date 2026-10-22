package com.byted.cast.common.api;

/* JADX INFO: loaded from: classes39.dex */
public class DisPlayType {
    private String codecs;
    private Integer frameRate;
    private Integer height;
    private String mimeType;
    private Integer width;

    public DisPlayType() {
    }

    public String toString() {
        return "DisPlayType{mimeType='" + this.mimeType + "', codecs='" + this.codecs + "', width=" + this.width + ", height=" + this.height + ", frameRate=" + this.frameRate + '}';
    }

    public String getCodecs() {
        return this.codecs;
    }

    public Integer getFrameRate() {
        return this.frameRate;
    }

    public Integer getHeight() {
        return this.height;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setCodecs(String r100) {
        this.codecs = r100;
    }

    public void setFrameRate(Integer r100) {
        this.frameRate = r100;
    }

    public void setHeight(Integer r100) {
        this.height = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setWidth(Integer r100) {
        this.width = r100;
    }
}
