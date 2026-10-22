package com.baidu.mapapi.map;

/* loaded from: classes.dex */
public class MyLocationData {
    public final float accuracy;
    public final float direction;
    public final double latitude;
    public final double longitude;
    public final int satellitesNum;
    public final float speed;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private double f6712a;

        /* renamed from: b, reason: collision with root package name */
        private double f6713b;

        /* renamed from: c, reason: collision with root package name */
        private float f6714c;

        /* renamed from: d, reason: collision with root package name */
        private float f6715d;

        /* renamed from: e, reason: collision with root package name */
        private float f6716e;

        /* renamed from: f, reason: collision with root package name */
        private int f6717f;

        public Builder accuracy(float f4) {
            this.f6716e = f4;
            return this;
        }

        public MyLocationData build() {
            return new MyLocationData(this.f6712a, this.f6713b, this.f6714c, this.f6715d, this.f6716e, this.f6717f);
        }

        public Builder direction(float f4) {
            this.f6715d = f4;
            return this;
        }

        public Builder latitude(double d4) {
            this.f6712a = d4;
            return this;
        }

        public Builder longitude(double d4) {
            this.f6713b = d4;
            return this;
        }

        public Builder satellitesNum(int i4) {
            this.f6717f = i4;
            return this;
        }

        public Builder speed(float f4) {
            this.f6714c = f4;
            return this;
        }
    }

    public MyLocationData(double d4, double d5, float f4, float f5, float f6, int i4) {
        this.latitude = d4;
        this.longitude = d5;
        this.speed = f4;
        this.direction = f5;
        this.accuracy = f6;
        this.satellitesNum = i4;
    }
}
