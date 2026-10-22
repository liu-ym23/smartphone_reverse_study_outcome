package com.autonavi.base.amap.mapcore;

/* JADX INFO: loaded from: classes39.dex */
public class FPoint3 extends FPoint {
    public int colorIndex;

    public FPoint3() {
        this.colorIndex = -1;
    }

    public void setColorIndex(int r100) {
        this.colorIndex = r100;
    }

    public FPoint3(float r100, float r101, int r102) {
        super(r100, r101);
        this.colorIndex = r102;
    }
}
