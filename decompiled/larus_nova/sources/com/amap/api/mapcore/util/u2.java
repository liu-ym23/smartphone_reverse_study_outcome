package com.amap.api.mapcore.util;

import android.content.Context;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class u2 extends d5<String, a> {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f28037a;

        public a() {
        }
    }

    @Override // com.amap.api.mapcore.util.d5
    public /* bridge */ /* synthetic */ a b(String r100) throws c5 {
        return null;
    }

    @Override // com.amap.api.mapcore.util.y7
    public boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getIPV6URL() {
        return w3.a(this.f27174r, this.f27173q);
    }

    @Override // com.amap.api.mapcore.util.c3, com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        HashMap r100 = new HashMap(16);
        r100.put("key", l5.e(this.f27173q));
        r100.put(BdpAppEventConstant.PARAMS_OUTPUT, "bin");
        String r101 = n5.a();
        String r102 = n5.a(this.f27173q, r101, x5.a(r100));
        r100.put("ts", r101);
        r100.put("scode", r102);
        return r100;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getURL() {
        return this.f27174r;
    }

    @Override // com.amap.api.mapcore.util.d5
    public a a(byte[] r100) throws c5 {
        a r101 = new a();
        r101.f28037a = r100;
        return r101;
    }

    public u2(Context r100, String r101) {
        super(r100, r101);
        this.f27174r = "/map/styles";
    }
}
