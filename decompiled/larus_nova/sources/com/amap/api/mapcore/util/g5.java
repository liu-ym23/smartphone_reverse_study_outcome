package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class g5 extends e5<List<TraceLocation>, List<LatLng>> implements Runnable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<TraceLocation> f27313t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Handler f27314u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f27315v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f27316w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f27317x;

    @Override // com.amap.api.mapcore.util.y7
    public boolean isSupportIPV6() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        com_amap_api_mapcore_util_g5_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_amap_api_mapcore_util_g5__run$___twin___() {
        new ArrayList();
        List<LatLng> r100 = c();     // Catch: Throwable -> L5 c5 -> L7
        i5.a().a(this.f27317x, this.f27315v, r100);     // Catch: Throwable -> L5
        i5.a().a(this.f27317x).a(this.f27314u);     // Catch: Throwable -> L5
        return;
    L7:
        e = move-exception;
        i5.a().a(this.f27314u, this.f27316w, e.a());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.amap.api.mapcore.util.e5
    public String f() {
        JSONArray r100 = new JSONArray();
        long r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= this.f27313t.size()) goto L30;
        TraceLocation r103 = (TraceLocation) ListProtector.get(this.f27313t, r102);
        JSONObject r104 = new JSONObject();
        r104.put("x", r103.getLongitude());     // Catch: JSONException -> L27
        r104.put("y", r103.getLatitude());     // Catch: JSONException -> L27
        r104.put("ag", (int) r103.getBearing());     // Catch: JSONException -> L27
        long r105 = r103.getTime();     // Catch: JSONException -> L27
        if (r102 != 0) goto L18;
        if (r105 != 0) goto L16;
        r105 = (System.currentTimeMillis() - 10000) / 1000;     // Catch: JSONException -> L27
    L16:
        r104.put("tm", r105 / 1000);     // Catch: JSONException -> L27
    L24:
        r101 = r105;
        r104.put(CloudControlInf.SP, (int) r103.getSpeed());     // Catch: JSONException -> L27
    L29:
        r100.put(r104);
        r102 = r102 + 1;
        goto L4
    L18:
        if (r105 == 0) goto L23;
        long r110 = r105 - r101;     // Catch: JSONException -> L27
        if (r110 < 1000) goto L23;
        r104.put("tm", r110 / 1000);     // Catch: JSONException -> L27
    L23:
        r104.put("tm", 1);     // Catch: JSONException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L30:
        this.f27174r = getURL() + "&" + r100.toString();
        return r100.toString();
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getURL() {
        String r100 = "key=" + l5.e(this.f27173q);
        String r101 = n5.a();
        String r102 = "&ts=" + r101;
        String r103 = "&scode=" + n5.a(this.f27173q, r101, r100);
        return ("http://" + p5.b(this.f27173q).a(27)) + "/v4/grasproad/driving?" + r100 + r102 + r103;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getIPV6URL() {
        return w3.a(getURL(), this.f27173q);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_amap_api_mapcore_util_g5_com_larus_apm_impl_protector_RunnableLancet_run(g5 r100) {
        r100.com_amap_api_mapcore_util_g5__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // com.amap.api.mapcore.util.d5
    public Object b(String r100) throws c5 {
        ArrayList r101 = new ArrayList();
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L16 JSONException -> L18
        if (r102.has("data") == false) goto L20;
        JSONArray r103 = r102.optJSONObject("data").optJSONArray("points");     // Catch: Throwable -> L16 JSONException -> L18
        if (r103 == null) goto L20;
        if (r103.length() == 0) goto L20;
        int r104 = 0;
    L13:
        if (r104 >= r103.length()) goto L20;
        JSONObject r105 = r103.optJSONObject(r104);     // Catch: Throwable -> L16 JSONException -> L18
        r101.add(new LatLng(Double.parseDouble(r105.optString("y")), Double.parseDouble(r105.optString("x"))));     // Catch: Throwable -> L16 JSONException -> L18
        r104 = r104 + 1;
        goto L13
    L20:
        return r101;
    L18:
        e = move-exception;
        e.printStackTrace();
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public g5(Context r100, Handler r101, List r102, String r103, int r104, int r105) {
        super(r100, r102);
        this.f27313t = r102;
        this.f27314u = r101;
        this.f27316w = r104;
        this.f27315v = r105;
        this.f27317x = r103;
    }
}
