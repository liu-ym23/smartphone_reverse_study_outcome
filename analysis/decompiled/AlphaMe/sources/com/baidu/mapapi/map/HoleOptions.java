package com.baidu.mapapi.map;

/* loaded from: classes.dex */
public class HoleOptions extends OverlayOptions {
    protected String mHoleType;
    protected boolean mIsHoleClickable = false;

    public String getHoleType() {
        return this.mHoleType;
    }

    public boolean isHoleClickable() {
        return this.mIsHoleClickable;
    }

    public HoleOptions setHoleClickable(boolean z4) {
        this.mIsHoleClickable = z4;
        return this;
    }
}
