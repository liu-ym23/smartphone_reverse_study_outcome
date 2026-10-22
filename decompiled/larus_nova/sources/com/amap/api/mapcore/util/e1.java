package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class e1 extends d5<String, a> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f27192t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f27193u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f27194v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f27195w;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f27196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f27197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f27198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f27199d;

        public a() {
            this.f27196a = false;
        }
    }

    @Override // com.amap.api.mapcore.util.y7
    public boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.mapcore.util.c3, com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        Hashtable r100 = new Hashtable(16);
        String r101 = this.f27192t;
        if (r101 != null) goto L5;
    L7:
        String r102 = this.f27193u;
        if (r102 != null) goto L10;
    L12:
        String r103 = this.f27194v;
        if (r103 != null) goto L15;
    L17:
        String r104 = this.f27195w;
        if (r104 != null) goto L20;
    L22:
        String r105 = n5.a();
        String r106 = n5.a(this.f27173q, r105, x5.a(r100));
        r100.put("ts", r105);
        r100.put("scode", r106);
        return r100;
    L20:
        if (r104.isEmpty() == true) goto L22;
        r100.put("key", this.f27195w);
        goto L22
    L15:
        if (r103.isEmpty() == true) goto L17;
        r100.put("type", this.f27194v);
        goto L17
    L10:
        if (r102.isEmpty() == true) goto L12;
        r100.put("platform", this.f27193u);
        goto L12
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.put("area", this.f27192t);
        goto L7
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getURL() {
        return "https://restapi.amap.com" + this.f27174r;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getIPV6URL() {
        return w3.a(getURL(), this.f27173q);
    }

    @Override // com.amap.api.mapcore.util.d5, com.amap.api.mapcore.util.y7
    public Map<String, String> getRequestHead() {
        Map<String, String> r100 = super.getRequestHead();
        ((Hashtable) r100).put("Host", "restapi.amap.com");
        return r100;
    }

    public e1(Context r100) {
        super(r100, "city_pack_list");
        if (l5.e() == false) goto L5;
        String r101 = "overseas";
    L6:
        this.f27192t = r101;
        this.f27193u = "android";
        this.f27194v = "vector";
        this.f27195w = l5.e(r100);
        this.f27174r = "/v5/rtos/sdk/offlinemap/city_pack_list";
        this.isPostFlag = false;
        return;
    L5:
        r101 = "cn_mainland";
        goto L6
    }

    @Override // com.amap.api.mapcore.util.d5
    public a b(String r100) throws c5 {
        a r101 = new a();
        r101.f27199d = r100;
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L7
        r101.f27197b = r102.optString("infocode", "");     // Catch: Exception -> L7
        r102.optString("info", "");     // Catch: Exception -> L7
        r101.f27196a = "10000".equals(r101.f27197b);     // Catch: Exception -> L7
        r101.f27198c = r102.optString("version", "");     // Catch: Exception -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        r101.f27196a = false;
        e.getMessage();
        goto L9
    }
}
