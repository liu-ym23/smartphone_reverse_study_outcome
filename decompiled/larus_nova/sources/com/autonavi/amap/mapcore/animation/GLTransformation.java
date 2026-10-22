package com.autonavi.amap.mapcore.animation;

/* JADX INFO: loaded from: classes39.dex */
public class GLTransformation {
    public double alpha;
    public double rotate;
    public double scaleX;
    public double scaleY;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public double f30023x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double f30024y;

    public void clear() {
        this.f30023x = Double.NaN;
        this.f30024y = Double.NaN;
        this.alpha = Double.NaN;
        this.scaleX = Double.NaN;
        this.scaleY = Double.NaN;
        this.rotate = Double.NaN;
    }

    public GLTransformation() {
        this.f30023x = Double.NaN;
        this.f30024y = Double.NaN;
        this.alpha = Double.NaN;
        this.rotate = Double.NaN;
        this.scaleX = Double.NaN;
        this.scaleY = Double.NaN;
    }
}
