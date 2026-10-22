package com.bytedance.android.ec.core.monitor;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f45142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f45143b = null;

    public c() {
    }

    static {
        f45142a = new HashMap();
        f45143b = new v();
    }

    public static void d(String r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        a r100 = (a) ((HashMap) f45142a).get(r110);
        if (r100 != null) goto L38;
    L36:
        ((HashMap) f45142a).remove(r110);
        return;
    L38:
        n r101 = r100.f45138f;     // Catch: Exception -> L34
        if (r101 == null) goto L9;
        r101.a(r100.f45134b);     // Catch: Exception -> L34
    L9:
        Map<String, String> r102 = r100.f45135c;     // Catch: Exception -> L34
        Long r103 = null;
        if ((r102 instanceof Map) == true) goto L12;
        r102 = null;
    L12:
        if (r102 != null) goto L14;
        r102 = MapsKt.emptyMap();     // Catch: Exception -> L34
    L14:
        JSONObject r104 = new JSONObject(r102);     // Catch: Exception -> L34
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L34
        Map<String, String> r106 = r100.f45136d;     // Catch: Exception -> L34
        if ((r106 instanceof Map) == true) goto L17;
        r106 = null;
    L17:
        if (r106 != null) goto L19;
        r106 = MapsKt.emptyMap();     // Catch: Exception -> L34
    L19:
        JSONObject r107 = new JSONObject(r106);     // Catch: Exception -> L34
        Iterator r108 = ((HashMap) r100.f45134b).entrySet().iterator();     // Catch: Exception -> L34
    L21:
        if (r108.hasNext() == false) goto L25;
        Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Exception -> L34
        String r111 = (String) r109.getKey();     // Catch: Exception -> L34
        long r112 = ((Number) r109.getValue()).longValue();     // Catch: Exception -> L34
        if (r112 <= 0) goto L21;
        r105.put(r111, String.valueOf(r112));     // Catch: Exception -> L34
        goto L21
    L25:
        n r113 = r100.f45138f;     // Catch: Exception -> L34
        if (r113 == null) goto L28;
        r103 = r113.b(r100.f45134b);     // Catch: Exception -> L34
    L28:
        if (r103 != null) goto L30;
    L32:
        int r114 = ECMonitorService.f45110b;     // Catch: Exception -> L34
        ECMonitorService.a.a(r100.f45137e, r104, r105, r107);     // Catch: Exception -> L34
        goto L36
    L30:
        if (r103.longValue() <= 0) goto L32;
        r105.put(MetricNames.RENDER_DURATION.getMetricNames(), String.valueOf(r103.longValue()));     // Catch: Exception -> L34
    L34:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L36
    }

    public static void g(q r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorSceneWrapper");
        jh.b.f499064c.getClass();
        jh.b.a.a(r100).a();
    }

    public static void i(q r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorSceneWrapper");
        jh.b.f499064c.getClass();
        jh.b.a.a(r100).stop();
    }

    public static String c(MonitorScenes r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        String r102 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r100, "scene");
        String r103 = r100.getSceneName();
        if (r101 != null) goto L5;
        r101 = f45143b;
    L5:
        a r104 = new a(r103, r101);
        if (r102 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        r102 = UUID.randomUUID().toString();
    L14:
        ((HashMap) f45142a).put(r102, r104);
        return r102;
    L8:
        if (StringsKt.isBlank(r102) == true) goto L11;
        r105 = false;
        goto L12
    }

    public static void j(String r100, MetricNames r101) {
        Intrinsics.checkNotNullParameter(r101, "metricName");
        if (r100 != null) goto L5;
        return;
    L5:
        a r102 = (a) ((HashMap) f45142a).get(r100);
        if (r102 == null) goto L9;
        r102.a(r101.getMetricNames());
        return;
    }

    public static void a(String r100, MetricNames r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "metricName");
        if (r100 != null) goto L5;
        return;
    L5:
        a r103 = (a) ((HashMap) f45142a).get(r100);
        if (r103 == null) goto L11;
        String r104 = r101.getMetricNames();
        Intrinsics.checkNotNullParameter(r104, "metricName");
        if (r102 <= 0) goto L12;
        Map<String, Long> r105 = r103.f45134b;
        HashMap r106 = (HashMap) r105;
        r106.put(r104, Long.valueOf(r102));
        return;
    L12:
        return;
    }

    public static void b(MonitorScenes r100, Map r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        JSONObject r103 = new JSONObject();
        if (r101 == null) goto L8;
        Iterator r104 = r101.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.put((String) r105.getKey(), (String) r105.getValue());
    L8:
        JSONObject r106 = new JSONObject();
        if (r102 == null) goto L14;
        Iterator r107 = r102.entrySet().iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.put((String) r108.getKey(), (String) r108.getValue());
    L14:
        JSONObject r109 = new JSONObject();
        int r110 = ECMonitorService.f45110b;
        ECMonitorService.a.a(r100.getSceneName(), r106, r103, r109);
    }

    public static void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (r100 != null) goto L5;
        return;
    L5:
        a r103 = (a) ((HashMap) f45142a).get(r100);
        if (r103 == null) goto L9;
        ((HashMap) r103.f45135c).put(r101, r102);
        return;
    }

    public static void f(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (r100 != null) goto L5;
        return;
    L5:
        a r103 = (a) ((HashMap) f45142a).get(r100);
        if (r103 == null) goto L9;
        ((HashMap) r103.f45136d).put(r101, r102);
        return;
    }

    public static void h(String r100, MetricNames r101, Long r102) {
        Intrinsics.checkNotNullParameter(r101, "metricName");
        if (r100 != null) goto L5;
        return;
    L5:
        a r103 = (a) ((HashMap) f45142a).get(r100);
        if (r103 == null) goto L13;
        String r104 = r101.getMetricNames();
        Intrinsics.checkNotNullParameter(r104, "metricName");
        Map<String, Long> r105 = r103.f45133a;
        if (r102 == null) goto L10;
        long r106 = r102.longValue();
    L11:
        HashMap r107 = (HashMap) r105;
        r107.put(r104, Long.valueOf(r106));
        return;
    L10:
        r106 = SystemClock.elapsedRealtime();
        goto L11
    }
}
