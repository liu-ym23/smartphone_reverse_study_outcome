package com.autonavi.base.amap.mapcore;

/* JADX INFO: loaded from: classes39.dex */
public class LinkInfo {
    private int length;
    private int state;
    private int time;

    public String toString() {
        return "状态：" + this.state + "|时间：" + this.time + "|长度：" + this.length;
    }

    public LinkInfo() {
        this.state = 0;
        this.time = 0;
        this.length = 0;
    }

    public int getLength() {
        return this.length;
    }

    public int getState() {
        return this.state;
    }

    public int getTime() {
        return this.time;
    }

    public void setLength(int r100) {
        this.length = r100;
    }

    public void setState(int r100) {
        this.state = r100;
    }

    public void setTime(int r100) {
        this.time = r100;
    }
}
