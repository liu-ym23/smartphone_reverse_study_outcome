package com.byted.cast.common.bean;

/* JADX INFO: loaded from: classes39.dex */
public class UrlBean {
    private int bitrate;
    private String extra;
    private int height;
    private boolean isDefault;
    private String resolution;
    private String url;
    private String urlType;
    private int width;

    public UrlBean() {
    }

    public String toString() {
        return "UrlBean{url='" + this.url + "', resolution='" + this.resolution + "', bitrate=" + this.bitrate + ", width=" + this.width + ", height=" + this.height + ", isDefault=" + this.isDefault + ", urlType=" + this.urlType + ", extra=" + this.extra + '}';
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public boolean getDefault() {
        return this.isDefault;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getHeight() {
        return this.height;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrlType() {
        return this.urlType;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBitrate(int r100) {
        this.bitrate = r100;
    }

    public void setDefault(boolean r100) {
        this.isDefault = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setResolution(String r100) {
        this.resolution = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setUrlType(String r100) {
        this.urlType = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
