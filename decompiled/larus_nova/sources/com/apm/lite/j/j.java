package com.apm.lite.j;

import com.apm.lite.k.n;
import com.apm.lite.k.p;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PolarisFileWrapper f29981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f29982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f29983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<String, String> f29984d;

    public static boolean a() {
        if (f29981a != null) goto L5;
        f29981a = new PolarisFileWrapper(n.g(com.apm.lite.e.f29909a), "apmlite/configCrash/configInvalid");
    L5:
        PolarisFileWrapper r100 = f29981a;
        Map<String, String> r101 = f29984d;     // Catch: Throwable -> L52
        if (r101 != null) goto L9;
        r101 = com.apm.lite.k.h.q(r100);     // Catch: Throwable -> L52
    L9:
        f29984d = r101;     // Catch: Throwable -> L52
        if (r101 != null) goto L13;
        f29984d = new HashMap();     // Catch: Throwable -> L52
        return true;
    L13:
        int r102 = r101.size();     // Catch: Throwable -> L52
        ConcurrentLinkedQueue<com.apm.lite.d> r103 = k1.b.f501332a;     // Catch: Throwable -> L52
        if (r102 >= r103.size()) goto L16;
        return true;
    L16:
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L52
        Iterator<com.apm.lite.d> r105 = r103.iterator();     // Catch: Throwable -> L52
    L18:
        if (r105.hasNext() == false) goto L22;
        com.apm.lite.d r106 = r105.next();     // Catch: Throwable -> L52
        if (r106 == null) goto L22;
        r104.add(r106.e());     // Catch: Throwable -> L52
    L22:
        Iterator r107 = r104.iterator();     // Catch: Throwable -> L52
    L24:
        if (r107.hasNext() == false) goto L28;
        String r108 = (String) r107.next();     // Catch: Throwable -> L52
        if (f29984d.containsKey(r108) == true) goto L24;
        return true;
    L28:
        long r109 = System.currentTimeMillis();     // Catch: Throwable -> L52
        Iterator<Map.Entry<String, String>> r110 = f29984d.entrySet().iterator();     // Catch: Throwable -> L52
        boolean r111 = false;
    L30:
        if (r110.hasNext() == false) goto L47;
        Map.Entry<String, String> r112 = r110.next();     // Catch: Throwable -> L52
        long r113 = Long.decode(r112.getValue()).longValue();     // Catch: Throwable -> L46
        String r114 = r112.getKey();     // Catch: Throwable -> L46
        HashMap<String, r1.e> r115 = r1.e.f535556b;     // Catch: Throwable -> L46
        if (r115.get(r114) == null) goto L35;
        boolean r116 = true;
    L36:
        if (r116 == false) goto L30;
        r1.e r117 = r115.get(r112.getKey());     // Catch: Throwable -> L46
    L39:
        if (r117 != null) goto L57;
    L42:
        long r118 = 3600000;
    L44:
        if ((r109 - r113) <= r118) goto L30;
        r111 = true;
        goto L30
    L57:
        r118 = Long.decode(com.apm.lite.k.k.e(r117.f535557a, new String[]{"over_all", "get_settings_interval"})).longValue() * 1000;
        goto L44
    L35:
        r116 = false;
    L46:
        com.apm.lite.e.f29913e.isDebugMode();     // Catch: Throwable -> L52
        goto L30
    L47:
        if (r111 == false) goto L49;
        String r119 = "config should be updated";
    L50:
        p.a(r119);     // Catch: Throwable -> L52
        return r111;
    L49:
        r119 = "config should not be updated";
    L52:
        return true;
    }

    public static void b() {
        if (f29982b == false) goto L5;
        return;
    L5:
        f29983c = true;
        PolarisFileWrapper r100 = new PolarisFileWrapper(n.g(com.apm.lite.e.f29909a), "apmlite/configCrash/configFile");
        if (r100.exists() == true) goto L12;
        return;
    L12:
        r1.a.c(new JSONArray(com.apm.lite.k.h.a(r100)), false);     // Catch: Throwable -> L10
        f29982b = true;     // Catch: Throwable -> L10
        return;
    L10:
        int r101 = r1.a.f535545a;
    }
}
