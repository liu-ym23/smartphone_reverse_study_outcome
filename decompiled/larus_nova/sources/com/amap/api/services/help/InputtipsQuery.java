package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* JADX INFO: loaded from: classes28.dex */
public class InputtipsQuery implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LatLonPoint f28961e;

    public String getCity() {
        return this.f28958b;
    }

    public boolean getCityLimit() {
        return this.f28959c;
    }

    public String getKeyword() {
        return this.f28957a;
    }

    public LatLonPoint getLocation() {
        return this.f28961e;
    }

    public String getType() {
        return this.f28960d;
    }

    public void setCityLimit(boolean r100) {
        this.f28959c = r100;
    }

    public void setLocation(LatLonPoint r100) {
        this.f28961e = r100;
    }

    public void setType(String r100) {
        this.f28960d = r100;
    }

    public InputtipsQuery(String r100, String r101) {
        this.f28959c = false;
        this.f28960d = null;
        this.f28957a = r100;
        this.f28958b = r101;
    }
}
