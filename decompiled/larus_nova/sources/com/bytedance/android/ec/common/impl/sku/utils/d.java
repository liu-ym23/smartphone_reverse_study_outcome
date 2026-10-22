package com.bytedance.android.ec.common.impl.sku.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class d {
    @SafeVarargs
    public static String a(String r100, Pair... r101) {
        Map r102 = MapsKt.mapOf(r101);
        Uri r103 = UriProtector.parse(r100);     // Catch: Exception -> L9
        String r104 = UriProtector.getQueryParameter(r103, "url");     // Catch: Exception -> L9
        if (r104 == null) goto L7;
        r100 = e(r103, "url", c(r104, "log_data", r102)).toString();     // Catch: Exception -> L9
    L12:
    L11:
        return r100;
    L7:
        r100 = c(r100, "log_data", r102);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static String b(String r100, String r101, String r102) {
        Uri r103 = UriProtector.parse(r100);     // Catch: Exception -> L9
        String r104 = UriProtector.getQueryParameter(r103, "url");     // Catch: Exception -> L9
        if (r104 == null) goto L8;
        return e(r103, "url", e(UriProtector.parse(r104), r101, r102).toString()).toString();
    L8:
        return e(r103, r101, r102).toString();
    L9:
        e = move-exception;
        e.printStackTrace();
        return r100;
    }

    public static String c(String r100, String r101, Map<String, String> r102) {
        Uri r103 = UriProtector.parse(r100);     // Catch: Exception -> L17
        String r104 = UriProtector.getQueryParameter(r103, r101);     // Catch: Exception -> L17
        if (r104 != null) goto L5;
    L6:
        r104 = SliceInitService.DEFAULT_SWITCH;
    L7:
        JSONObject r105 = new JSONObject(r104);     // Catch: Exception -> L17
        Iterator<Map.Entry<String, String>> r106 = r102.entrySet().iterator();     // Catch: Exception -> L17
    L9:
        if (r106.hasNext() == false) goto L15;
        Map.Entry<String, String> r107 = r106.next();     // Catch: Exception -> L17
        if (r107.getKey() == null) goto L9;
        if (r107.getValue() == null) goto L9;
        r105.put(r107.getKey(), r107.getValue());     // Catch: Exception -> L17
        goto L9
    L15:
        return e(r103, r101, r105.toString()).toString();
    L5:
        if (r104.isEmpty() == false) goto L7;
    L17:
        e = move-exception;
        e.printStackTrace();
        return r100;
    }

    public static String d(String r100, String r101, String r102) {
        Uri.Builder r103 = UriProtector.parse(r100).buildUpon();
        r103.appendQueryParameter(r101, r102);
        return r103.build().toString();
    }

    public static Uri e(Uri r100, String r101, String r102) {
        if (r102 == null) goto L25;
        Uri.Builder r103 = r100.buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r100, r101)) == false) goto L7;
        r103.appendQueryParameter(r101, r102);
    L18:
        return r103.build();
    L7:
        r103.clearQuery();
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r100).iterator();
    L9:
        if (r104.hasNext() == false) goto L18;
        String r105 = r104.next();
        if (r105.equals(r101) == false) goto L12;
        r103.appendQueryParameter(r105, r102);
        goto L9
    L12:
        Iterator<String> r106 = UriProtector.getQueryParameters(r100, r105).iterator();
    L14:
        if (r106.hasNext() == false) goto L9;
        r103.appendQueryParameter(r105, r106.next());
        goto L14
    L25:
        return r100;
    }
}
