package com.amap.api.col.jmsl;

import com.amap.api.col.jmsl.s7;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class M1 extends C1 {

    /* renamed from: y, reason: collision with root package name */
    public byte[] f16197y;

    /* renamed from: z, reason: collision with root package name */
    public String f16198z;

    public M1(byte[] bArr, String str) {
        this.f16198z = "1";
        this.f16197y = (byte[]) bArr.clone();
        this.f16198z = str;
        setDegradeAbility(s7.a.SINGLE);
        setHttpProtocol(s7.c.HTTP);
    }

    @Override // com.amap.api.col.jmsl.s7
    public byte[] getEntityBytes() {
        return this.f16197y;
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/zip");
        map.put("Content-Length", String.valueOf(this.f16197y.length));
        return map;
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        byte[] bArr = K0.f16145a;
        String strM = C1604s2.m("IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz");
        String str = this.f16198z;
        byte[] bArrT = C1604s2.t("9aj&#k81");
        byte[] bArr2 = new byte[bArrT.length + 50];
        System.arraycopy(this.f16197y, 0, bArr2, 0, 50);
        System.arraycopy(bArrT, 0, bArr2, 50, bArrT.length);
        return String.format(strM, "1", str, "1", "open", L1.b(bArr2));
    }

    @Override // com.amap.api.col.jmsl.s7
    public boolean isHostToIP() {
        return false;
    }
}
