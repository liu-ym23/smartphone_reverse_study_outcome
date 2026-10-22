package com.amap.api.trace;

/* JADX INFO: loaded from: classes28.dex */
public class TraceLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f29319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f29320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f29321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f29323e;

    public TraceLocation copy() {
        TraceLocation r100 = new TraceLocation();
        r100.f29322d = this.f29322d;
        r100.f29319a = this.f29319a;
        r100.f29320b = this.f29320b;
        r100.f29321c = this.f29321c;
        r100.f29323e = this.f29323e;
        return r100;
    }

    public String toString() {
        return this.f29319a + ",longitude " + this.f29320b + ",speed " + this.f29321c + ",bearing " + this.f29322d + ",time " + this.f29323e;
    }

    public TraceLocation() {
    }

    public float getBearing() {
        return this.f29322d;
    }

    public double getLatitude() {
        return this.f29319a;
    }

    public double getLongitude() {
        return this.f29320b;
    }

    public float getSpeed() {
        return this.f29321c;
    }

    public long getTime() {
        return this.f29323e;
    }

    private static double a(double r100) {
        return Math.round(r100 * 1000000.0d) / 1000000.0d;
    }

    public void setBearing(float r100) {
        this.f29322d = (int) r100;
    }

    public void setLatitude(double r100) {
        this.f29319a = a(r100);
    }

    public void setLongitude(double r100) {
        this.f29320b = a(r100);
    }

    public void setSpeed(float r100) {
        this.f29321c = (int) ((r100 * 3600.0f) / 1000.0f);
    }

    public void setTime(long r100) {
        this.f29323e = r100;
    }

    public TraceLocation(double r100, double r101, float r102, float r103, long r104) {
        this.f29319a = a(r100);
        this.f29320b = a(r101);
        this.f29321c = (int) ((r102 * 3600.0f) / 1000.0f);
        this.f29322d = (int) r103;
        this.f29323e = r104;
    }
}
