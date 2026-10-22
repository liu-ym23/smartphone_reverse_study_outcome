package com.amap.api.col.s;

import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class cr extends cy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f26474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f26475b;

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> f() {
        return null;
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> e() {
        return this.f26475b;
    }

    @Override // com.amap.api.col.s.cy
    public final byte[] g() {
        return this.f26474a;
    }

    public cr(byte[] r100, Map<String, String> r101) {
        this.f26474a = r100;
        this.f26475b = r101;
    }
}
