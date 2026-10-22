package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public class MyLocationData {
    public final float accuracy;
    public final float direction;
    public final double latitude;
    public final double longitude;
    public final int satellitesNum;
    public final float speed;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f31190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f31191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f31192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f31193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f31194e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f31195f;

        public MyLocationData build() {
            return new MyLocationData(this.f31190a, this.f31191b, this.f31192c, this.f31193d, this.f31194e, this.f31195f);
        }

        public Builder() {
        }

        public Builder accuracy(float r100) {
            this.f31194e = r100;
            return this;
        }

        public Builder direction(float r100) {
            this.f31193d = r100;
            return this;
        }

        public Builder latitude(double r100) {
            this.f31190a = r100;
            return this;
        }

        public Builder longitude(double r100) {
            this.f31191b = r100;
            return this;
        }

        public Builder satellitesNum(int r100) {
            this.f31195f = r100;
            return this;
        }

        public Builder speed(float r100) {
            this.f31192c = r100;
            return this;
        }
    }

    public MyLocationData(double r100, double r101, float r102, float r103, float r104, int r105) {
        this.latitude = r100;
        this.longitude = r101;
        this.speed = r102;
        this.direction = r103;
        this.accuracy = r104;
        this.satellitesNum = r105;
    }
}
