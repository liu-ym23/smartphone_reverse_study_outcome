package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class UploadInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f28986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LatLonPoint f28988c;

    public UploadInfo() {
        this.f28986a = 1;
    }

    public int getCoordType() {
        return this.f28986a;
    }

    public LatLonPoint getPoint() {
        return this.f28988c;
    }

    public String getUserID() {
        return this.f28987b;
    }

    public void setCoordType(int r100) {
        if (r100 != 0) goto L4;
    L7:
        this.f28986a = r100;
        return;
    L4:
        if (r100 == 1) goto L7;
        this.f28986a = 1;
    }

    public void setPoint(LatLonPoint r100) {
        this.f28988c = r100;
    }

    public void setUserID(String r100) {
        this.f28987b = r100;
    }
}
