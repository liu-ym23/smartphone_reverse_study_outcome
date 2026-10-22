package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class UploadInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f17509a = 1;

    /* renamed from: b, reason: collision with root package name */
    private String f17510b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f17511c;

    public int getCoordType() {
        return this.f17509a;
    }

    public LatLonPoint getPoint() {
        return this.f17511c;
    }

    public String getUserID() {
        return this.f17510b;
    }

    public void setCoordType(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f17509a = i10;
        } else {
            this.f17509a = 1;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f17511c = latLonPoint;
    }

    public void setUserID(String str) {
        this.f17510b = str;
    }
}
