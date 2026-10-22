package com.stepos.alphame.predict;

/* loaded from: classes.dex */
public class AppMatchRecord {
    String pkgName = "";
    int openTimes = 0;
    int hitTimes = 0;
    int wrongTimes = 0;
    int missTimes = 0;

    public int getHitTimes() {
        return this.hitTimes;
    }

    public int getMissTimes() {
        return this.missTimes;
    }

    public int getOpenTimes() {
        return this.openTimes;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public int getWrongTimes() {
        return this.wrongTimes;
    }

    public void setHitTimes(int i4) {
        this.hitTimes = i4;
    }

    public void setMissTimes(int i4) {
        this.missTimes = i4;
    }

    public void setOpenTimes(int i4) {
        this.openTimes = i4;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setWrongTimes(int i4) {
        this.wrongTimes = i4;
    }
}
