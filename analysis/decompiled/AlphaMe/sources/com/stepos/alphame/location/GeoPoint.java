package com.stepos.alphame.location;

/* loaded from: classes.dex */
public class GeoPoint {
    private final double latitude;
    private final double longitude;

    public GeoPoint(double d4, double d5) {
        this.longitude = d4;
        this.latitude = d5;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
