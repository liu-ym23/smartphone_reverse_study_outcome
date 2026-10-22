package com.amap.api.mapcore.util;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class d1 extends d5<String, a> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f27157t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f27158u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f27159v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f27160w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f27161x;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f27162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f27163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f27164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<String> f27165d;

        public a() {
            this.f27162a = false;
            this.f27163b = "";
            this.f27164c = 0;
            this.f27165d = null;
        }
    }

    @Override // com.amap.api.mapcore.util.y7
    public boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.mapcore.util.c3, com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        Hashtable r100 = new Hashtable(16);
        String r101 = this.f27161x;
        if (r101 != null) goto L5;
    L7:
        String r102 = this.f27157t;
        if (r102 != null) goto L10;
    L12:
        String r103 = this.f27158u;
        if (r103 != null) goto L15;
    L17:
        String r104 = this.f27159v;
        if (r104 != null) goto L20;
    L22:
        String r105 = this.f27160w;
        if (r105 != null) goto L25;
    L27:
        String r106 = n5.a();
        String r107 = n5.a(this.f27173q, r106, x5.a(r100));
        r100.put("ts", r106);
        r100.put("scode", r107);
        return r100;
    L25:
        if (r105.isEmpty() == true) goto L27;
        r100.put("key", this.f27160w);
        goto L27
    L20:
        if (r104.isEmpty() == true) goto L22;
        r100.put("type", this.f27159v);
        goto L22
    L15:
        if (r103.isEmpty() == true) goto L17;
        r100.put("platform", this.f27158u);
        goto L17
    L10:
        if (r102.isEmpty() == true) goto L12;
        r100.put("area", this.f27157t);
        goto L12
    L5:
        if (r101.isEmpty() == true) goto L7;
        r100.put("adcode", this.f27161x);
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

    @Override // com.amap.api.mapcore.util.d5
    public a b(String r100) throws c5 {
        a r101 = new a();
        if (r100 != null) goto L5;
    L30:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L30;
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L28
        String r103 = r102.optString("infocode", "");     // Catch: JSONException -> L28
        r102.optString("info", "");     // Catch: JSONException -> L28
        if ("10000".equals(r103) == false) goto L26;
        r101.f27162a = true;     // Catch: JSONException -> L28
        r101.f27163b = r102.optString("version", "");     // Catch: JSONException -> L28
        r101.f27164c = CastLongProtector.parseLong(r102.optString(ShortVideoSegments.KEY_PROP_ZIP_SIZE, "0"));     // Catch: NumberFormatException -> L13 JSONException -> L28
    L15:
        r102.optString("adcode", "");     // Catch: JSONException -> L28
        JSONArray r104 = r102.optJSONArray("urls");     // Catch: JSONException -> L28
        if (r104 == null) goto L30;
        if (r104.length() <= 0) goto L30;
        r101.f27165d = new ArrayList();     // Catch: JSONException -> L28
        int r105 = 0;
    L21:
        if (r105 >= r104.length()) goto L30;
        String r106 = r104.optString(r105, "");     // Catch: JSONException -> L28
        if (r106.isEmpty() == true) goto L25;
        r101.f27165d.add(r106);     // Catch: JSONException -> L28
    L25:
        r105 = r105 + 1;     // Catch: JSONException -> L28
        goto L21
    L14:
        r101.f27164c = 0;     // Catch: JSONException -> L28
        goto L15
    L26:
        r101.f27162a = false;     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        r101.f27162a = false;
        e.getMessage();
        goto L30
    }

    public d1(Context r100, String r101) {
        super(r100, "city_pack");
        this.f27161x = r101;
        if (l5.e() == false) goto L5;
        String r102 = "overseas";
    L6:
        this.f27157t = r102;
        this.f27158u = "android";
        this.f27159v = "vector";
        this.f27160w = l5.e(r100);
        this.f27174r = "/v5/rtos/sdk/offlinemap/city_pack";
        this.isPostFlag = false;
        return;
    L5:
        r102 = "cn_mainland";
        goto L6
    }
}
