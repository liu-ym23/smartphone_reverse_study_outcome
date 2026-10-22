package com.baidu.mapapi.map.entity;

/* loaded from: classes.dex */
public class BackgroundNaviLocEntity {

    /* renamed from: b, reason: collision with root package name */
    private float f7162b;

    /* renamed from: c, reason: collision with root package name */
    private float f7163c;

    /* renamed from: f, reason: collision with root package name */
    private float f7166f;

    /* renamed from: g, reason: collision with root package name */
    private float f7167g;

    /* renamed from: a, reason: collision with root package name */
    private int f7161a = -1;

    /* renamed from: d, reason: collision with root package name */
    private double f7164d = -1.0d;

    /* renamed from: e, reason: collision with root package name */
    private double f7165e = -1.0d;

    /* renamed from: h, reason: collision with root package name */
    private double f7168h = -1.0d;

    /* renamed from: i, reason: collision with root package name */
    private double f7169i = -1.0d;

    public int getCurRouteShapeIdx() {
        return this.f7161a;
    }

    public float getGpsDirection() {
        return this.f7162b;
    }

    public double getGpsLatitude() {
        return this.f7165e;
    }

    public double getGpsLongitude() {
        return this.f7164d;
    }

    public float getGpsSpeed() {
        return this.f7163c;
    }

    public float getPostDirection() {
        return this.f7166f;
    }

    public double getPostLatitude() {
        return this.f7169i;
    }

    public double getPostLongitude() {
        return this.f7168h;
    }

    public float getPostSpeed() {
        return this.f7167g;
    }

    public boolean isValid() {
        return (this.f7165e == -1.0d || this.f7164d == -1.0d || this.f7169i == -1.0d || this.f7168h == -1.0d) ? false : true;
    }

    public void setCurRouteShapeIdx(int i4) {
        this.f7161a = i4;
    }

    public void setGpsDirection(float f4) {
        this.f7162b = f4;
    }

    public void setGpsLatitude(double d4) {
        this.f7165e = d4;
    }

    public void setGpsLongitude(double d4) {
        this.f7164d = d4;
    }

    public void setGpsSpeed(float f4) {
        this.f7163c = f4;
    }

    public void setPostDirection(float f4) {
        this.f7166f = f4;
    }

    public void setPostLatitude(double d4) {
        this.f7169i = d4;
    }

    public void setPostLongitude(double d4) {
        this.f7168h = d4;
    }

    public void setPostSpeed(float f4) {
        this.f7167g = f4;
    }
}
