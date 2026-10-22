package com.amap.api.services.core;

import com.amap.api.col.s.an;
import com.amap.api.col.s.bk;
import com.amap.api.col.s.bo;
import com.amap.api.col.s.i;

/* JADX INFO: loaded from: classes28.dex */
public class ServiceSettings {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final int HTTP = 1;
    public static final int HTTPS = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ServiceSettings f28865c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28867b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f28869e;

    public static ServiceSettings getInstance() {
        if (f28865c != null) goto L6;
        f28865c = new ServiceSettings();
    L6:
        return f28865c;
    }

    private ServiceSettings() {
        this.f28866a = "zh-CN";
        this.f28867b = 1;
        this.f28868d = 20000;
        this.f28869e = 20000;
    }

    public void destroyInnerAsynThreadPool() {
        an.b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        i.a(th, "ServiceSettings", "destroyInnerAsynThreadPool");
    }

    public int getConnectionTimeOut() {
        return this.f28868d;
    }

    public String getLanguage() {
        return this.f28866a;
    }

    public int getProtocol() {
        return this.f28867b;
    }

    public int getSoTimeOut() {
        return this.f28869e;
    }

    public void setApiKey(String r100) {
        bk.a(r100);
    }

    public void setConnectionTimeOut(int r100) {
        if (r100 >= 5000) goto L7;
        this.f28868d = 5000;
        return;
    L7:
        if (r100 <= 30000) goto L10;
        this.f28868d = 30000;
        return;
    L10:
        this.f28868d = r100;
    }

    public void setLanguage(String r100) {
        this.f28866a = r100;
    }

    public void setProtocol(int r100) {
        this.f28867b = r100;
        bo r101 = bo.a();
        if (this.f28867b != 2) goto L5;
        boolean r102 = true;
    L6:
        r101.a(r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setSoTimeOut(int r100) {
        if (r100 >= 5000) goto L7;
        this.f28869e = 5000;
        return;
    L7:
        if (r100 <= 30000) goto L10;
        this.f28869e = 30000;
        return;
    L10:
        this.f28869e = r100;
    }
}
