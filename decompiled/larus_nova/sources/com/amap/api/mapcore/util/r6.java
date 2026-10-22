package com.amap.api.mapcore.util;

import com.ss.android.downloadlib.constants.MimeType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class r6 extends s5 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private byte[] f27934o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f27935p;

    @Override // com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.mapcore.util.y7
    public boolean isHostToIP() {
        return false;
    }

    @Override // com.amap.api.mapcore.util.y7
    public Map<String, String> getRequestHead() {
        HashMap r100 = new HashMap();
        r100.put("Content-Type", MimeType.ZIP);
        r100.put("Content-Length", String.valueOf(this.f27934o.length));
        return r100;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getURL() {
        boolean r100 = m6.f27614b;
        String r101 = x5.b("IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz");
        byte[] r102 = x5.e("9aj&#k81");
        byte[] r103 = new byte[r102.length + 50];
        System.arraycopy(this.f27934o, 0, r103, 0, 50);
        System.arraycopy(r102, 0, r103, 50, r102.length);
        return String.format(r101, new Object[]{"1", this.f27935p, "1", "open", t5.a(r103)});
    }

    @Override // com.amap.api.mapcore.util.y7
    public byte[] getEntityBytes() {
        return this.f27934o;
    }

    public r6(byte[] r100, String r101) {
        this.f27935p = "1";
        this.f27934o = (byte[]) r100.clone();
        this.f27935p = r101;
        setDegradeAbility(y7.a.f28456e);
        setHttpProtocol(y7.c.f28467a);
    }
}
