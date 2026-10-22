package com.amap.api.maps.model;

/* loaded from: classes.dex */
public class CustomMapStyleOptions {
    private String styleId = null;
    private boolean enable = true;

    public String getStyleId() {
        return this.styleId;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public CustomMapStyleOptions setEnable(boolean z10) {
        this.enable = z10;
        return this;
    }

    public CustomMapStyleOptions setStyleId(String str) {
        this.styleId = str;
        return this;
    }
}
