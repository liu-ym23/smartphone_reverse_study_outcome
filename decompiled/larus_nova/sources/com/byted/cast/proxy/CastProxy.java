package com.byted.cast.proxy;

import android.content.Context;
import com.byted.cast.proxy.impl.CastProxyImpl;

/* JADX INFO: loaded from: classes39.dex */
public class CastProxy {
    private CastProxyImpl impl;

    public String getVersion() {
        return this.impl.getVersion();
    }

    public boolean stop() {
        return this.impl.stop();
    }

    public CastProxy() {
        this.impl = new CastProxyImpl();
    }

    public String getLocalUrl(String r100, String r101) {
        return this.impl.getLocalUrl(r100, r101);
    }

    public String proxyUrl(String r100, String r101) {
        return proxyUrl(r100, r101, null);
    }

    public boolean start(Context r100, Config r101) {
        return this.impl.start(r100, r101);
    }

    public String proxyUrl(String r100, String r101, CastProxyMediaType r102) {
        return proxyUrl(r100, r101, null, r102);
    }

    public String proxyUrl(String r100, String r101, String r102) {
        return proxyUrl(r100, r101, r102, null);
    }

    public String proxyUrl(String r100, String r101, String r102, CastProxyMediaType r110) {
        return proxyUrl(r100, r101, r102, r110, null);
    }

    public String proxyUrl(String r100, String r101, String r102, String r103) {
        return this.impl.proxyUrl(r100, r101, r102, r103);
    }

    public String proxyUrl(String r100, String r101, String r102, CastProxyMediaType r110, CastProxyOutputResolution r111) {
        return this.impl.proxyUrl(r100, r101, r102, r110, r111);
    }
}
