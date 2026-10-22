package com.amap.api.col.jmsl;

import com.amap.api.col.jmsl.s7;
import java.util.Map;

/* loaded from: classes.dex */
public class T0 extends s7 {

    /* renamed from: y, reason: collision with root package name */
    public byte[] f16354y;

    /* renamed from: z, reason: collision with root package name */
    public Map<String, String> f16355z;

    public T0(byte[] bArr, Map<String, String> map) {
        this.f16354y = bArr;
        this.f16355z = map;
        setDegradeAbility(s7.a.SINGLE);
        setHttpProtocol(s7.c.HTTPS);
    }

    @Override // com.amap.api.col.jmsl.s7
    public byte[] getEntityBytes() {
        return this.f16354y;
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() {
        return this.f16355z;
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
