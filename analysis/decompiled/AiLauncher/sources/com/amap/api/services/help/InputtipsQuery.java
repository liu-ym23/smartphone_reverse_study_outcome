package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: classes.dex */
public class InputtipsQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f17481a;

    /* renamed from: b, reason: collision with root package name */
    private String f17482b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17483c = false;

    /* renamed from: d, reason: collision with root package name */
    private String f17484d = null;

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f17485e;

    public InputtipsQuery(String str, String str2) {
        this.f17481a = str;
        this.f17482b = str2;
    }

    public String getCity() {
        return this.f17482b;
    }

    public boolean getCityLimit() {
        return this.f17483c;
    }

    public String getKeyword() {
        return this.f17481a;
    }

    public LatLonPoint getLocation() {
        return this.f17485e;
    }

    public String getType() {
        return this.f17484d;
    }

    public void setCityLimit(boolean z10) {
        this.f17483c = z10;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f17485e = latLonPoint;
    }

    public void setType(String str) {
        this.f17484d = str;
    }
}
