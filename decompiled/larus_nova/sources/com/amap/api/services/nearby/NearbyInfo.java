package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class NearbyInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLonPoint f28971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f28972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f28974e;

    public NearbyInfo() {
    }

    public int getDistance() {
        return this.f28973d;
    }

    public int getDrivingDistance() {
        return this.f28974e;
    }

    public LatLonPoint getPoint() {
        return this.f28971b;
    }

    public long getTimeStamp() {
        return this.f28972c;
    }

    public String getUserID() {
        return this.f28970a;
    }

    public void setDistance(int r100) {
        this.f28973d = r100;
    }

    public void setDrivingDistance(int r100) {
        this.f28974e = r100;
    }

    public void setPoint(LatLonPoint r100) {
        this.f28971b = r100;
    }

    public void setTimeStamp(long r100) {
        this.f28972c = r100;
    }

    public void setUserID(String r100) {
        this.f28970a = r100;
    }
}
