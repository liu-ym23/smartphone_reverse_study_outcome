package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f28038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f28039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f28040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f28041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f28042e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f28043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f28044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f28045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f28046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f28047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static HashMap<String, Boolean> f28048k;

    static {
        f28048k = new HashMap();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    private static <T> String a(Map<String, T> r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L8
        r101.append("{");     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, T>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L8
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, T> r103 = r102.next();     // Catch: Throwable -> L8
        r101.append("\"" + r103.getKey() + "\":");     // Catch: Throwable -> L8
        r101.append(r103.getValue());     // Catch: Throwable -> L8
        r101.append(",");     // Catch: Throwable -> L8
        goto L4
    L6:
        r101.deleteCharAt(r101.length() - 1);     // Catch: Throwable -> L8
        r101.append(com.alipay.sdk.m.u.i.f25855d);     // Catch: Throwable -> L8
        return r101.toString();
    L8:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static void b(Context r100) {
        if (f28040c == false) goto L10;
        return;
    L10:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L9
        r101.put("amap_3dmap_heatmap", 1);     // Catch: Throwable -> L9
        a(r100, "O009", a(r101));     // Catch: Throwable -> L9
        f28040c = true;     // Catch: Throwable -> L9
        return;
    }

    public static void c(Context r100) {
        h8 r101 = new h8(r100, "3dmap", "11.2.101", "Map-Init-Android");     // Catch: Throwable -> L13
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L13
        r102.put("adiu", o5.g(r100));     // Catch: Throwable -> L13
        if (l5.e() == false) goto L10;
        String r103 = "1";
    L11:
        r102.put("isOverSea", r103);     // Catch: Throwable -> L13
        r102.put("type", "common");     // Catch: Throwable -> L13
        r102.put("version", "11.2.101");     // Catch: Throwable -> L13
        r101.a(r102.toString());     // Catch: Throwable -> L13
        i8.a(r101, r100);     // Catch: Throwable -> L13
        return;
    L10:
        r103 = "0";
    L13:
        th = move-exception;
        th.printStackTrace();
    }

    public static void d(Context r100) {
        if (f28044g == false) goto L10;
        return;
    L10:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L9
        r101.put("amap_3dmap_bzmapreview", 1);     // Catch: Throwable -> L9
        a(r100, "O012", a(r101));     // Catch: Throwable -> L9
        f28044g = true;     // Catch: Throwable -> L9
        return;
    }

    public static void e(Context r100) {
        if (f28041d == false) goto L10;
        return;
    L10:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L9
        r101.put("amap_3dmap_offlinemap", 1);     // Catch: Throwable -> L9
        a(r100, "O010", a(r101));     // Catch: Throwable -> L9
        f28041d = true;     // Catch: Throwable -> L9
        return;
    }

    public static void f(Context r100) {
        if (f28042e == false) goto L10;
        return;
    L10:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L9
        r101.put("amap_3dmap_particleoverlay", 1);     // Catch: Throwable -> L9
        a(r100, "O011", a(r101));     // Catch: Throwable -> L9
        f28042e = true;     // Catch: Throwable -> L9
        return;
    }

    public static void g(Context r100) {
        if (f28045h == false) goto L10;
        return;
    L10:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L9
        r101.put("amap_3dmap_wxmapreview", 1);     // Catch: Throwable -> L9
        a(r100, "O013", a(r101));     // Catch: Throwable -> L9
        f28045h = true;     // Catch: Throwable -> L9
        return;
    }

    public static void h(Context r100) {
        if (f28043f == false) goto L10;
        return;
    L10:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L9
        r101.put("amap_3dmap_renderfps", 1);     // Catch: Throwable -> L9
        a(r100, "O014", a(r101));     // Catch: Throwable -> L9
        f28043f = true;     // Catch: Throwable -> L9
        return;
    }

    public static void i(Context r100) {
        if (f28046i == false) goto L10;
        return;
    L10:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L9
        r101.put("amap_3dmap_dxmapreview", 1);     // Catch: Throwable -> L9
        a(r100, "0016", a(r101));     // Catch: Throwable -> L9
        f28046i = true;     // Catch: Throwable -> L9
        return;
    }

    public static void a(Context r100) {
        if (f28047j == false) goto L10;
        return;
    L10:
        HashMap r101 = new HashMap();     // Catch: Throwable -> L9
        r101.put("amap_3dmap_buildingoverlay", 1);     // Catch: Throwable -> L9
        a(r100, "O015", a(r101));     // Catch: Throwable -> L9
        f28047j = true;     // Catch: Throwable -> L9
        return;
    }

    public static synchronized void a(Context r100, String r101) {
        monitor-enter(u3.class);
        if (f28048k != null) goto L7;
    L19:
        monitor-exit(u3.class);
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (f28048k.containsKey(r101) == true) goto L12;
    L15:
        HashMap r102 = new HashMap();     // Catch: Throwable -> L23
        r102.put("amap_3dmap_coordinate", r101);     // Catch: Throwable -> L23
        a(r100, "O008", a(r102));     // Catch: Throwable -> L23
        if (f28048k.containsKey(r101) == true) goto L21;
        f28048k.put(r101, Boolean.TRUE);     // Catch: Throwable -> L23
        goto L21
    L12:
        if (f28048k.get(r101).booleanValue() == false) goto L15;
        monitor-exit(u3.class);
        return;
    L21:
        monitor-exit(u3.class);
    }

    public static void b(Context r100, boolean r101) {
        if (f28038a == false) goto L10;
        return;
    L10:
        HashMap r102 = new HashMap();     // Catch: Throwable -> L9
        r102.put("amap_3dmap_stylemap", Integer.valueOf(r101 ? 1 : 0));     // Catch: Throwable -> L9
        a(r100, "O006", a(r102));     // Catch: Throwable -> L9
        f28038a = true;     // Catch: Throwable -> L9
        return;
    }

    public static void c(Context r100, boolean r101) {
        if (f28039b == false) goto L10;
        return;
    L10:
        HashMap r102 = new HashMap();     // Catch: Throwable -> L9
        r102.put("amap_3dmap_indoormap", Integer.valueOf(r101 ? 1 : 0));     // Catch: Throwable -> L9
        a(r100, "O007", a(r102));     // Catch: Throwable -> L9
        f28039b = true;     // Catch: Throwable -> L9
        return;
    }

    public static void a(Context r100, boolean r101) {
        String r102 = "{\"Quest\":" + r101 + com.alipay.sdk.m.u.i.f25855d;     // Catch: Throwable -> L5
    L7:
        h8 r103 = new h8(r100, "3dmap", "11.2.101", "O001");     // Catch: Throwable -> L9
        r103.a(r102);     // Catch: Throwable -> L9
        i8.a(r103, r100);     // Catch: Throwable -> L9
        return;
    L5:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L9
        r102 = null;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public static void b(Context r100, String r101) {
        HashMap r102 = new HashMap();     // Catch: Throwable -> L4
        r102.put("amap_3dmap_engine_init_fail", r101);     // Catch: Throwable -> L4
        a(r100, "O021", a(r102));     // Catch: Throwable -> L4
        return;
    }

    public static void c(Context r100, String r101) {
        HashMap r102 = new HashMap();     // Catch: Throwable -> L4
        r102.put("amap_3dmap_res_load_fail", r101);     // Catch: Throwable -> L4
        a(r100, "O022", a(r102));     // Catch: Throwable -> L4
        return;
    }

    public static void a(Context r100, long r101) {
        HashMap r102 = new HashMap();     // Catch: Throwable -> L8
        r102.put("amap_3dmap_rendertime", Long.valueOf(r101));     // Catch: Throwable -> L8
        r102.put("amap_3dmap_render_background", 0L);     // Catch: Throwable -> L8
        a(r100, "O005", a(r102));     // Catch: Throwable -> L8
        return;
    }

    public static void a(Context r100, int r101) {
        HashMap r102 = new HashMap();     // Catch: Throwable -> L6
        r102.put("amap_3dmap_draw_fail", Integer.valueOf(r101));     // Catch: Throwable -> L6
        a(r100, "O023", a(r102));     // Catch: Throwable -> L6
        return;
    }

    private static void a(Context r100, String r101, String r102) {
        if (r100 != null) goto L7;
        return;
    L7:
        h8 r103 = new h8(r100, "3dmap", "11.2.101", r101);     // Catch: Throwable -> L6
        r103.a(r102);     // Catch: Throwable -> L6
        i8.a(r103, r100);     // Catch: Throwable -> L6
        return;
    }
}
