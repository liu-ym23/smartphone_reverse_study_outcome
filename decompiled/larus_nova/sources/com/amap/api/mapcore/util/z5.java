package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f28588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28589d;

    public String a() {
        if (this.f28587b != 2) goto L5;
        return "error";
    L5:
        return "info";
    }

    public String b() {
        new JSONObject();
        return this.f28586a;
    }

    public int c() {
        return this.f28587b;
    }

    public static String a(Context r100, List<z5> r101) {
        if (r101 == null) goto L34;
        if (r101.size() == 0) goto L35;
        JSONArray r102 = new JSONArray();     // Catch: Throwable -> L24
        Iterator<z5> r103 = r101.iterator();     // Catch: Throwable -> L24
    L9:
        if (r103.hasNext() == false) goto L22;
        z5 r104 = r103.next();     // Catch: Throwable -> L24
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L24
        r105.put("info", r104.b());     // Catch: Throwable -> L18
        r105.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, r104.f28589d);     // Catch: Throwable -> L18
        r105.put("timestamp", r104.f28588c);     // Catch: Throwable -> L18
        String r106 = r105.toString();     // Catch: Throwable -> L24
    L20:
        if (TextUtils.isEmpty(r106) == true) goto L9;
        r102.put(r106);     // Catch: Throwable -> L24
    L18:
        r106 = "";
        goto L20
    L22:
        return r102.toString();
    L35:
        return "";
    L36:
        return "";
    L34:
        return "";
    }

    public static z5 b(String r100, String r101) {
        return new z5(1, r100, r101);
    }

    public static z5 a(String r100, String r101) {
        return new z5(2, r100, r101);
    }

    private z5(int r100, String r101, String r102) {
        this.f28586a = r102;
        this.f28587b = r100;
        this.f28589d = r101;
        this.f28588c = System.currentTimeMillis();
    }
}
