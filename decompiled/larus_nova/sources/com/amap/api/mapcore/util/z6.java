package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w5 f28590a;

    public z6(String r100) {
        this.f28590a = null;
        this.f28590a = new w5.a(r100, "1.0", "1.0.0").a(new String[]{"info"}).a();     // Catch: k5 -> L5
        return;
    }

    public w5 a(JSONObject r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
        String r101 = r100.optString(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);     // Catch: Throwable -> L11
        String r102 = r100.optString("b");     // Catch: Throwable -> L11
        String r103 = r100.optString("c");     // Catch: Throwable -> L11
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L11
        JSONArray r105 = r100.optJSONArray("d");     // Catch: Throwable -> L11
        int r106 = 0;
    L7:
        if (r106 >= r105.length()) goto L9;
        r104.add(r105.getString(r106));     // Catch: Throwable -> L11
        r106 = r106 + 1;     // Catch: Throwable -> L11
        goto L7
    L9:
        return new w5.a(r101, r102, r101).a(r103).a((String[]) r104.toArray(new String[0])).a();
    L11:
        return null;
    }

    public List<w5> a(Context r100) {
        JSONArray r101 = new JSONArray(y6.a(r100, this.f28590a, "rbck"));     // Catch: JSONException -> L16
        if (r101.length() == 0) goto L24;
        ArrayList r102 = new ArrayList();     // Catch: JSONException -> L16
        int r103 = 0;
    L8:
        if (r103 >= r101.length()) goto L25;
        w5 r104 = a(JSONArrayProtectorUtils.getJSONObject(r101, r103));     // Catch: JSONException -> L11
    L12:
        if (r104 == null) goto L15;
        r102.add(r104);     // Catch: JSONException -> L16
    L15:
        r103 = r103 + 1;
    L11:
        r104 = null;
        goto L12
    L25:
        return r102;
    L24:
        return new ArrayList();
    L17:
        return new ArrayList();
    }

    public void a(Context r100, w5 r101) {
        ArrayList r102 = new ArrayList();
        r102.add(r101);
        if (r102.size() != 0) goto L5;
        JSONArray r103 = new JSONArray();
    L24:
        String r104 = r103.toString();
        if (TextUtils.isEmpty(r104) == false) goto L27;
        return;
    L27:
        y6.a(r100, this.f28590a, "rbck", r104);
        return;
    L5:
        r103 = new JSONArray();
        Iterator r105 = r102.iterator();
    L7:
        if (r105.hasNext() == false) goto L24;
        w5 r106 = (w5) r105.next();
        JSONObject r107 = new JSONObject();
        r107.put(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, r106.d());     // Catch: JSONException -> L21
        r107.put("b", r106.e());     // Catch: JSONException -> L21
        r107.put("c", r106.b());     // Catch: JSONException -> L21
        JSONArray r108 = new JSONArray();     // Catch: JSONException -> L21
        int r109 = 0;
    L15:
        if (r106.c() == null) goto L19;
        if (r109 >= r106.c().length) goto L19;
        r108.put(r106.c()[r109]);     // Catch: JSONException -> L21
        r109 = r109 + 1;     // Catch: JSONException -> L21
    L19:
        r107.put("d", r108);     // Catch: JSONException -> L21
    L23:
        r103.put(r107);
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }
}
