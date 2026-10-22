package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.model.MarkerOptions;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, a4> f28556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f28557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f28558c = 0;

    static {
        f28556a = new ConcurrentHashMap();
        f28557b = "";
    }

    public static void a() {
        if (y3.f28423a == true) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, a4>> r100 = f28556a.entrySet().iterator();     // Catch: Throwable -> L11
    L7:
        if (r100.hasNext() == false) goto L16;
        r100.next().getValue().flush();     // Catch: Throwable -> L11
    L16:
        return;
    }

    public static void a(JSONObject r100) {
        if (r100 != null) goto L15;
        return;
    L15:
        boolean r101 = m5.a(r100.optString("able", ""), false);     // Catch: Throwable -> L14
        boolean r102 = m5.a(r100.optString("mobile", ""), false);     // Catch: Throwable -> L14
        boolean r103 = m5.a(r100.optString("debugupload", ""), false);     // Catch: Throwable -> L14
        boolean r104 = m5.a(r100.optString("debugwrite", ""), false);     // Catch: Throwable -> L14
        boolean r105 = m5.a(r100.optString("forcedUpload", ""), false);     // Catch: Throwable -> L14
        y3.f28423a = r101;     // Catch: Throwable -> L14
        boolean r106 = m5.a(r100.optString("di", ""), false);     // Catch: Throwable -> L14
        String r107 = r100.optString(MapBundleKey.MapObjKey.OBJ_DIS, "");     // Catch: Throwable -> L14
        if (r106 == true) goto L8;
    L10:
        List<String> r108 = Arrays.asList(r100.optString("filter", "").split("&"));     // Catch: Throwable -> L14
        a6.a(w3.b()).a(r101, r102, r104, r103, r108);     // Catch: Throwable -> L14
        if (r105 == false) goto L17;
        a6.a(w3.b()).c(r105);     // Catch: Throwable -> L14
        return;
    L17:
        return;
    L8:
        if (x5.d(r107) == true) goto L10;
        return;
    }

    public static void a(Context r100) {
        if (r100 != null) goto L15;
        return;
    L15:
        Map<String, a4> r101 = f28556a;     // Catch: Throwable -> L11
        r101.put("overlay", new c4());     // Catch: Throwable -> L11
        Map<String, a4> r102 = f28556a;     // Catch: Throwable -> L11
        r102.put("normal", new b4());     // Catch: Throwable -> L11
    L13:
        a6.a(w3.b()).a(r100.getApplicationContext());     // Catch: Throwable -> L12
        return;
    }

    public static void a(String r100, String r101) {
        a(1, "normal", f28557b, r100, r101);
    }

    public static void b(String r100, String r101) {
        a(0, "normal", f28557b, r100, r101);
    }

    public static void c(String r100, String r101) {
        a(1, "overlay", f28557b, r100, r101);
    }

    public static void d(String r100, String r101) {
        a(0, "overlay", f28557b, r100, r101);
    }

    public static void a(String r100, String r101, MarkerOptions r102) {
        if (r102 == null) goto L4;
        c(r100, r101 + " " + r102.getPosition() + " " + r102.getIcons());
        return;
    L4:
        c(r100, r101);
    }

    private static void a(int r100, String r101, String r102, String r103, String r104) {
        String r105 = r103 + r104;     // Catch: Throwable -> L12
        if (y3.f28423a == true) goto L5;
        return;
    L5:
        Map<String, a4> r106 = f28556a;     // Catch: Throwable -> L12
        if (r106 != null) goto L8;
        return;
    L8:
        a4 r107 = r106.get(r101);     // Catch: Throwable -> L12
        if (r107 == null) goto L15;
        r107.a(r100, r102, r105);     // Catch: Throwable -> L12
        return;
    L15:
        return;
    }
}
