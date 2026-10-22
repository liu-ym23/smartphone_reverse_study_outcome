package com.autonavi.aps.amapapi;

/* loaded from: classes.dex */
public class DNSIPDelegate {

    /* renamed from: a, reason: collision with root package name */
    private String[] f18230a;

    /* renamed from: b, reason: collision with root package name */
    private String f18231b;

    /* renamed from: c, reason: collision with root package name */
    private String f18232c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f18233d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f18234e = false;

    public String getCacheIp() {
        return this.f18232c;
    }

    public String[] getLocationIPs() {
        return this.f18230a;
    }

    public String getUseIp() {
        return this.f18231b;
    }

    public boolean isHasLocalCache() {
        return this.f18233d;
    }

    public boolean isIsDNSOK() {
        return this.f18234e;
    }

    public void setCacheIp(String str) {
        this.f18232c = str;
    }

    public void setHasLocalCache(boolean z10) {
        this.f18233d = z10;
    }

    public void setIsDNSOK(boolean z10) {
        this.f18234e = z10;
    }

    public void setLocationIPs(String[] strArr) {
        this.f18230a = strArr;
    }

    public void setUseIp(String str) {
        this.f18231b = str;
    }
}
