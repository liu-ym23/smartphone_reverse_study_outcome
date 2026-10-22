package com.amap.api.mapcore.util;

import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class d2 extends c3 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f27166o;

    @Override // com.amap.api.mapcore.util.c3, com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.y7
    public boolean isSupportIPV6() {
        return false;
    }

    @Override // com.amap.api.mapcore.util.y7
    public Map<String, String> getRequestHead() {
        Hashtable r100 = new Hashtable(32);
        r100.put("User-Agent", "MAC=channel:amapapi");
        return r100;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getIPV6URL() {
        return this.f27166o;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getURL() {
        return this.f27166o;
    }

    public d2(String r100) {
        this.f27166o = r100;
    }
}
