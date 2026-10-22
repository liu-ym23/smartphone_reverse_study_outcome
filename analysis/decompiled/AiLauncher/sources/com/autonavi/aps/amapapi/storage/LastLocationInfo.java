package com.autonavi.aps.amapapi.storage;

import com.amap.api.location.AMapLocation;

/* loaded from: classes.dex */
public class LastLocationInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f18367a;

    /* renamed from: b, reason: collision with root package name */
    private long f18368b;

    /* renamed from: c, reason: collision with root package name */
    private String f18369c;

    /* renamed from: d, reason: collision with root package name */
    private AMapLocation f18370d;

    public AMapLocation getAmapLocation() {
        return this.f18370d;
    }

    public String getLocInfo() {
        return this.f18367a;
    }

    public String getNb() {
        return this.f18369c;
    }

    public long getTime() {
        return this.f18368b;
    }

    public void setAmapLocation(AMapLocation aMapLocation) {
        this.f18370d = aMapLocation;
    }

    public void setLocInfo(String str) {
        this.f18367a = str;
    }

    public void setNb(String str) {
        this.f18369c = str;
    }

    public void setTime(long j10) {
        this.f18368b = j10;
    }
}
