package com.baidu.mapapi.map.entity;

/* JADX INFO: loaded from: classes39.dex */
public class BackgroundNaviLocEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f31596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f31597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f31598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f31599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f31600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f31601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f31602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f31603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f31604i;

    public boolean isValid() {
        if (this.f31600e != (-1.0d)) goto L5;
    L11:
        return false;
    L5:
        if (this.f31599d == (-1.0d)) goto L11;
        if (this.f31604i == (-1.0d)) goto L11;
        if (this.f31603h == (-1.0d)) goto L11;
        return true;
    }

    public BackgroundNaviLocEntity() {
        this.f31596a = -1;
        this.f31599d = -1.0d;
        this.f31600e = -1.0d;
        this.f31603h = -1.0d;
        this.f31604i = -1.0d;
    }

    public int getCurRouteShapeIdx() {
        return this.f31596a;
    }

    public float getGpsDirection() {
        return this.f31597b;
    }

    public double getGpsLatitude() {
        return this.f31600e;
    }

    public double getGpsLongitude() {
        return this.f31599d;
    }

    public float getGpsSpeed() {
        return this.f31598c;
    }

    public float getPostDirection() {
        return this.f31601f;
    }

    public double getPostLatitude() {
        return this.f31604i;
    }

    public double getPostLongitude() {
        return this.f31603h;
    }

    public float getPostSpeed() {
        return this.f31602g;
    }

    public void setCurRouteShapeIdx(int r100) {
        this.f31596a = r100;
    }

    public void setGpsDirection(float r100) {
        this.f31597b = r100;
    }

    public void setGpsLatitude(double r100) {
        this.f31600e = r100;
    }

    public void setGpsLongitude(double r100) {
        this.f31599d = r100;
    }

    public void setGpsSpeed(float r100) {
        this.f31598c = r100;
    }

    public void setPostDirection(float r100) {
        this.f31601f = r100;
    }

    public void setPostLatitude(double r100) {
        this.f31604i = r100;
    }

    public void setPostLongitude(double r100) {
        this.f31603h = r100;
    }

    public void setPostSpeed(float r100) {
        this.f31602g = r100;
    }
}
