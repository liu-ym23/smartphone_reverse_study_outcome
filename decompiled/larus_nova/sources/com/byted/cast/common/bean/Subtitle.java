package com.byted.cast.common.bean;

/* JADX INFO: loaded from: classes39.dex */
public class Subtitle {
    private String language;
    private String startTime;
    private int switchStatus;
    private String url;

    public Subtitle() {
    }

    public String toString() {
        return "Subtitle{switchStatus=" + this.switchStatus + ", language='" + this.language + "', startTime='" + this.startTime + "', url='" + this.url + "'}";
    }

    public String getLanguage() {
        return this.language;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getSwitchStatus() {
        return this.switchStatus;
    }

    public String getUrl() {
        return this.url;
    }

    public void setLanguage(String r100) {
        this.language = r100;
    }

    public void setStartTime(String r100) {
        this.startTime = r100;
    }

    public void setSwitchStatus(int r100) {
        this.switchStatus = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }
}
