package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.jmsl.C1;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpRequest extends C1 {

    /* renamed from: o, reason: collision with root package name */
    Map<String, String> f18382o = null;

    /* renamed from: p, reason: collision with root package name */
    Map<String, String> f18383p = null;

    /* renamed from: q, reason: collision with root package name */
    String f18384q = "";

    /* renamed from: r, reason: collision with root package name */
    byte[] f18385r = null;

    /* renamed from: s, reason: collision with root package name */
    private String f18386s = null;

    @Override // com.amap.api.col.jmsl.s7
    public byte[] getEntityBytes() {
        return this.f18385r;
    }

    @Override // com.amap.api.col.jmsl.C1, com.amap.api.col.jmsl.s7
    public String getIPV6URL() {
        return !TextUtils.isEmpty(this.f18386s) ? this.f18386s : super.getIPV6URL();
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() {
        return this.f18383p;
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        return this.f18382o;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return this.f18384q;
    }

    public void setEntity(byte[] bArr) {
        this.f18385r = bArr;
    }

    public void setHead(Map<String, String> map) {
        this.f18382o = map;
    }

    public void setIpv6Url(String str) {
        this.f18386s = str;
    }

    public void setParams(Map<String, String> map) {
        this.f18383p = map;
    }

    public void setUrl(String str) {
        this.f18384q = str;
    }
}
