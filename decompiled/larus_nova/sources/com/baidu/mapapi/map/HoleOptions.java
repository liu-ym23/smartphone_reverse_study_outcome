package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public class HoleOptions extends OverlayOptions {
    protected String mHoleType;
    protected boolean mIsHoleClickable;

    public HoleOptions() {
        this.mIsHoleClickable = false;
    }

    public String getHoleType() {
        return this.mHoleType;
    }

    public boolean isHoleClickable() {
        return this.mIsHoleClickable;
    }

    public HoleOptions setHoleClickable(boolean r100) {
        this.mIsHoleClickable = r100;
        return this;
    }
}
