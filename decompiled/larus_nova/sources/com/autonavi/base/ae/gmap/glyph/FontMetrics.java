package com.autonavi.base.ae.gmap.glyph;

/* JADX INFO: loaded from: classes39.dex */
public class FontMetrics {
    public boolean bSuccess;
    public float fAscent;
    public float fDescent;
    public float fHeight;
    public float fLeading;

    public FontMetrics() {
        this.bSuccess = false;
        this.fAscent = 0.0f;
        this.fDescent = 0.0f;
        this.fLeading = 0.0f;
        this.fHeight = 0.0f;
    }

    public FontMetrics(float r100, float r101, float r102, float r103) {
        this.bSuccess = false;
        this.fAscent = r100;
        this.fDescent = r101;
        this.fLeading = r102;
        this.fHeight = r103;
    }
}
