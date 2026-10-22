package com.bytedanceos.common.ad.entity.rep;

import com.bytedanceos.common.ad.entity.rep.media.RepMediaEntity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepCreativeEntity<M extends RepMediaEntity> {
    private String cid;
    private List<String> click;
    private List<String> download;
    private String dsp;
    private List<String> event;
    private List<String> impression;
    private M media;
    private String mid;
    private List<String> playstart;
    private String tid;

    public RepCreativeEntity() {
        this.cid = "";
        this.tid = "";
        this.mid = "";
        this.dsp = "";
    }

    public String getCid() {
        return this.cid;
    }

    public List<String> getClick() {
        return this.click;
    }

    public List<String> getDownload() {
        return this.download;
    }

    public String getDsp() {
        return this.dsp;
    }

    public List<String> getEvent() {
        return this.event;
    }

    public List<String> getImpression() {
        return this.impression;
    }

    public M getMedia() {
        return this.media;
    }

    public String getMid() {
        return this.mid;
    }

    public List<String> getPlaystart() {
        return this.playstart;
    }

    public String getTid() {
        return this.tid;
    }

    public void setCid(String r10) {
        this.cid = r10;
    }

    public void setClick(List<String> r10) {
        this.click = r10;
    }

    public void setDownload(List<String> r10) {
        this.download = r10;
    }

    public void setDsp(String r10) {
        this.dsp = r10;
    }

    public void setEvent(List<String> r10) {
        this.event = r10;
    }

    public void setImpression(List<String> r10) {
        this.impression = r10;
    }

    public void setMedia(M r10) {
        this.media = r10;
    }

    public void setMid(String r10) {
        this.mid = r10;
    }

    public void setPlaystart(List<String> r10) {
        this.playstart = r10;
    }

    public void setTid(String r10) {
        this.tid = r10;
    }
}
