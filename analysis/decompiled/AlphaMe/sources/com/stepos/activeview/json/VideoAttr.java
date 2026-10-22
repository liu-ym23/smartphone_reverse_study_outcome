package com.stepos.activeview.json;

/* loaded from: classes.dex */
public class VideoAttr {
    private Boolean audio;
    private Boolean autoPlay;
    private Long intervalDelay;
    private Boolean loop;
    private String src;
    private Long startTime;

    public Boolean getAudio() {
        return this.audio;
    }

    public Boolean getAutoPlay() {
        return this.autoPlay;
    }

    public Long getIntervalDelay() {
        return this.intervalDelay;
    }

    public Boolean getLoop() {
        return this.loop;
    }

    public String getSrc() {
        return this.src;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public void setAudio(Boolean bool) {
        this.audio = bool;
    }

    public void setAutoPlay(Boolean bool) {
        this.autoPlay = bool;
    }

    public void setIntervalDelay(Long l4) {
        this.intervalDelay = l4;
    }

    public void setLoop(Boolean bool) {
        this.loop = bool;
    }

    public void setSrc(String str) {
        this.src = str;
    }

    public void setStartTime(Long l4) {
        this.startTime = l4;
    }
}
