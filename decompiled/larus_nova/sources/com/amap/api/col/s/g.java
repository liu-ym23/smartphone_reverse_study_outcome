package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class g extends e<CloudSearch.Query, CloudResult> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f26599j;

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final String a() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String i() {
        if (((CloudSearch.Query) this.f25991b).getSortingrules() != null) goto L5;
        return "";
    L5:
        return ((CloudSearch.Query) this.f25991b).getSortingrules().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.cy
    public final Map<String, String> e() {
        Hashtable r100 = new Hashtable(16);
        r100.put("key", bi.f(this.f25994e));
        r100.put(BdpAppEventConstant.PARAMS_OUTPUT, "json");
        if (((CloudSearch.Query) this.f25991b).getBound() != null) goto L5;
    L20:
        r100.put("layerId", ((CloudSearch.Query) this.f25991b).getTableID());
        if (i.a(i()) == true) goto L23;
        r100.put("sortrule", i());
    L23:
        StringBuffer r101 = new StringBuffer();
        String r102 = ((CloudSearch.Query) this.f25991b).getFilterString();
        String r103 = ((CloudSearch.Query) this.f25991b).getFilterNumString();
        r101.append(r102);
        if (i.a(r102) == false) goto L26;
    L28:
        r101.append(r103);
        String r104 = r101.toString();
        if (i.a(r104) == true) goto L31;
        r100.put("filter", r104);
    L31:
        String r105 = ((CloudSearch.Query) this.f25991b).getQueryString();
        if (r105 != null) goto L34;
    L36:
        r100.put("keywords", "");
    L37:
        StringBuilder r106 = new StringBuilder();
        r106.append(((CloudSearch.Query) this.f25991b).getPageSize());
        r100.put("pageSize", r106.toString());
        StringBuilder r107 = new StringBuilder();
        r107.append(((CloudSearch.Query) this.f25991b).getPageNum());
        r100.put("pageNum", r107.toString());
        String r108 = bl.a();
        String r109 = bl.a(this.f25994e, r108, d(a(r100)));
        r100.put("ts", r108);
        r100.put("scode", r109);
        return r100;
    L34:
        if ("".equals(r105) == true) goto L36;
        r100.put("keywords", r105);
        goto L37
    L26:
        if (i.a(r103) == true) goto L28;
        r101.append("&&");
        goto L28
    L5:
        if (((CloudSearch.Query) this.f25991b).getBound().getShape().equals("Bound") == false) goto L8;
        r100.put("center", i.a(((CloudSearch.Query) this.f25991b).getBound().getCenter().getLongitude()) + "," + i.a(((CloudSearch.Query) this.f25991b).getBound().getCenter().getLatitude()));
        StringBuilder r110 = new StringBuilder();
        r110.append(((CloudSearch.Query) this.f25991b).getBound().getRange());
        r100.put("radius", r110.toString());
        goto L20
    L8:
        if (((CloudSearch.Query) this.f25991b).getBound().getShape().equals("Rectangle") == false) goto L11;
        LatLonPoint r111 = ((CloudSearch.Query) this.f25991b).getBound().getLowerLeft();
        LatLonPoint r112 = ((CloudSearch.Query) this.f25991b).getBound().getUpperRight();
        double r113 = i.a(r111.getLatitude());
        double r114 = i.a(r111.getLongitude());
        double r115 = i.a(r112.getLatitude());
        r100.put(SVGRenderEngine.POLYGON, r114 + "," + r113 + com.alipay.sdk.m.u.i.f25853b + i.a(r112.getLongitude()) + "," + r115);
        goto L20
    L11:
        if (((CloudSearch.Query) this.f25991b).getBound().getShape().equals("Polygon") == false) goto L18;
        List<LatLonPoint> r116 = ((CloudSearch.Query) this.f25991b).getBound().getPolyGonList();
        if (r116 == null) goto L20;
        if (r116.size() <= 0) goto L20;
        r100.put(SVGRenderEngine.POLYGON, i.a(r116, com.alipay.sdk.m.u.i.f25853b));
        goto L20
    L18:
        if (((CloudSearch.Query) this.f25991b).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE) == false) goto L20;
        r100.put("city", ((CloudSearch.Query) this.f25991b).getBound().getCity());
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.cy
    public final String h() {
        String r100 = h.d() + "/datasearch";
        String r101 = ((CloudSearch.Query) this.f25991b).getBound().getShape();
        if (r101.equals("Bound") == false) goto L6;
        return r100 + "/around";
    L6:
        if (r101.equals("Polygon") == true) goto L14;
        if (r101.equals("Rectangle") == true) goto L14;
        if (r101.equals(CloudSearch.SearchBound.LOCAL_SHAPE) == true) goto L17;
        return r100;
    L17:
        return r100 + "/local";
    L14:
        return r100 + "/polygon";
    }

    private static String a(Map<String, String> r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, String> r103 = r102.next();
        if (r101.length() <= 0) goto L8;
        r101.append("&");
    L8:
        r101.append(r103.getKey());
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(r103.getValue());
        goto L4
    L10:
        return r101.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CloudResult c(String r100) throws AMapException {
        ArrayList<CloudItem> r101 = null;
        if (r100 != null) goto L5;
    L15:
        T r102 = this.f25991b;
        return CloudResult.createPagedResult((CloudSearch.Query) r102, this.f26599j, ((CloudSearch.Query) r102).getBound(), ((CloudSearch.Query) this.f25991b).getPageSize(), null);
    L5:
        if (r100.equals("") == true) goto L15;
        r101 = c(new JSONObject(r100));     // Catch: Exception -> L9 JSONException -> L11
    L13:
        T r103 = this.f25991b;
        return CloudResult.createPagedResult((CloudSearch.Query) r103, this.f26599j, ((CloudSearch.Query) r103).getBound(), ((CloudSearch.Query) this.f25991b).getPageSize(), r101);
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private static String d(String r100) {
    L20:
        th = move-exception;
        cd.a(th, "ut", "sPa");
    L22:
        return r100;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return "";
    L8:
        if (r100 == null) goto L10;
        r100 = r100.replace("&&", "%26%26");     // Catch: Throwable -> L20
    L10:
        String[] r101 = r100.split("&");     // Catch: Throwable -> L20
        Arrays.sort(r101);     // Catch: Throwable -> L20
        StringBuffer r102 = new StringBuffer();     // Catch: Throwable -> L20
        int r103 = r101.length;     // Catch: Throwable -> L20
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L13;
        r102.append(r101[r104]);     // Catch: Throwable -> L20
        r102.append("&");     // Catch: Throwable -> L20
        r104 = r104 + 1;     // Catch: Throwable -> L20
        goto L11
    L13:
        String r105 = r102.toString();     // Catch: Throwable -> L20
        if (r105 == null) goto L17;
        r105 = r105.replace("%26%26", "&&");     // Catch: Throwable -> L20
    L17:
        if (r105.length() <= 1) goto L22;
        return (String) r105.subSequence(0, r105.length() - 1);
    }

    private ArrayList<CloudItem> c(JSONObject r100) throws JSONException {
        ArrayList<CloudItem> r101 = new ArrayList();
        JSONArray r102 = e.a(r100);
        if (r102 != null) goto L5;
        return r101;
    L5:
        JSONObject r103 = r100.optJSONObject("data");
        int r104 = 0;
        if (r103 == null) goto L10;
        JSONObject r105 = r103.optJSONObject("info");
        if (r105 == null) goto L10;
        int r106 = r105.optInt("count");
    L11:
        this.f26599j = r106;
    L13:
        if (r104 >= r102.length()) goto L15;
        JSONObject r107 = r102.optJSONObject(r104);
        CloudItemDetail r108 = e.b(r107);
        e.a(r108, r107);
        r101.add(r108);
        r104 = r104 + 1;
        goto L13
    L15:
        return r101;
    L10:
        r106 = 0;
        goto L11
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String r100) throws AMapException {
        return c(r100);
    }

    public g(Context r100, CloudSearch.Query r101) {
        super(r100, r101);
        this.f26599j = 0;
    }
}
