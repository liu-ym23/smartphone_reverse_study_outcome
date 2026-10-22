package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class NearbyInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f17494a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f17495b;

    /* renamed from: c, reason: collision with root package name */
    private long f17496c;

    /* renamed from: d, reason: collision with root package name */
    private int f17497d;

    /* renamed from: e, reason: collision with root package name */
    private int f17498e;

    public int getDistance() {
        return this.f17497d;
    }

    public int getDrivingDistance() {
        return this.f17498e;
    }

    public LatLonPoint getPoint() {
        return this.f17495b;
    }

    public long getTimeStamp() {
        return this.f17496c;
    }

    public String getUserID() {
        return this.f17494a;
    }

    public void setDistance(int i10) {
        this.f17497d = i10;
    }

    public void setDrivingDistance(int i10) {
        this.f17498e = i10;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f17495b = latLonPoint;
    }

    public void setTimeStamp(long j10) {
        this.f17496c = j10;
    }

    public void setUserID(String str) {
        this.f17494a = str;
    }
}
