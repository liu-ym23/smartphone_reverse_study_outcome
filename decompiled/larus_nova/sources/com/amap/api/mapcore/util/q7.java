package com.amap.api.mapcore.util;

import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class q7 extends y7 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private byte[] f27896o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Map<String, String> f27897p;

    @Override // com.amap.api.mapcore.util.y7
    public Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.amap.api.mapcore.util.y7
    public byte[] getEntityBytes() {
        return this.f27896o;
    }

    @Override // com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        return this.f27897p;
    }

    public q7(byte[] r100, Map<String, String> r101) {
        this.f27896o = r100;
        this.f27897p = r101;
        setDegradeAbility(y7.a.f28456e);
        setHttpProtocol(y7.c.f28468b);
    }
}
