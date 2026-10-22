package com.bytedance.android.shopping.ligo.monitor;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Long>> f176462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.ligo.monitor.a f176463b;

    public static final class a {
    }

    static {
    }

    public c(com.bytedance.android.shopping.ligo.monitor.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventTracker");
        this.f176463b = r100;
        this.f176462a = new LinkedHashMap();
    }

    public final void a(ll.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRegion");
        c(r100.e(), "load_start");
    }

    public final void b(ll.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRegion");
        c(r100.e(), "on_load_success");
        String r101 = r100.e();
        if (r101 == null) goto L13;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(b.a(r100));
        Map r103 = (Map) ((LinkedHashMap) this.f176462a).get(r101);
        if (r103 == null) goto L10;
        Iterator r104 = r103.entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Map.Entry r105 = (Map.Entry) r104.next();
        r102.put(r105.getKey(), String.valueOf(((Number) r105.getValue()).longValue()));
    L10:
        this.f176463b.b("livesdk_ligo_load_perf", r102);
        return;
    }

    public final void c(String r110, String r111) {
        if (r110 != null) goto L67;
        return;
    L67:
    L64:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (this.f176462a.containsKey(r110) == true) goto L7;
        this.f176462a.put(r110, new LinkedHashMap());     // Catch: Exception -> L64
    L7:
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L64
        Map r101 = (Map) ((LinkedHashMap) this.f176462a).get(r110);     // Catch: Exception -> L64
        if (r101 == null) goto L10;
        Long r102 = (Long) r101.put(r111, Long.valueOf(r100));     // Catch: Exception -> L64
    L10:
        int r103 = r111.hashCode();     // Catch: Exception -> L64
        boolean r104 = true;
        Long r105 = null;
        if (r103 == (-335641590)) goto L33;
        if (r103 == 1140590858) goto L17;
        return;
    L17:
        if (r111.equals("on_template_loaded") == false) goto L68;
        Map r112 = (Map) ((LinkedHashMap) this.f176462a).get(r110);     // Catch: Exception -> L64
        if (r112 == null) goto L69;
        Long r113 = (Long) r112.get("load_start");     // Catch: Exception -> L64
        if (r113 != null) goto L23;
        return;
    L23:
        if (r113.longValue() > 0) goto L26;
        r104 = false;
    L26:
        if (r104 == false) goto L28;
        r105 = r113;
    L28:
        if (r105 == null) goto L71;
        long r106 = r105.longValue();     // Catch: Exception -> L64
        Map r114 = (Map) ((LinkedHashMap) this.f176462a).get(r110);     // Catch: Exception -> L64
        if (r114 == null) goto L72;
        Long r115 = (Long) r114.put("template_load_cost", Long.valueOf(r100 - r106));     // Catch: Exception -> L64
        return;
    L72:
        return;
    L71:
        return;
    L69:
        return;
    L68:
        return;
    L33:
        if (r111.equals("on_load_success") == false) goto L74;
        Map r116 = (Map) ((LinkedHashMap) this.f176462a).get(r110);     // Catch: Exception -> L64
        if (r116 == null) goto L49;
        Long r117 = (Long) r116.get("on_template_loaded");     // Catch: Exception -> L64
        if (r117 == null) goto L49;
        if (r117.longValue() <= 0) goto L41;
        boolean r107 = true;
    L42:
        if (r107 == true) goto L45;
        r117 = null;
    L45:
        if (r117 == null) goto L49;
        long r118 = r117.longValue();     // Catch: Exception -> L64
        Map r119 = (Map) ((LinkedHashMap) this.f176462a).get(r110);     // Catch: Exception -> L64
        if (r119 == null) goto L49;
        Long r120 = (Long) r119.put("load_page_cost", Long.valueOf(r100 - r118));     // Catch: Exception -> L64
        goto L49
    L41:
        r107 = false;
    L49:
        Map r121 = (Map) ((LinkedHashMap) this.f176462a).get(r110);     // Catch: Exception -> L64
        if (r121 == null) goto L75;
        Long r122 = (Long) r121.get("load_start");     // Catch: Exception -> L64
        if (r122 != null) goto L54;
        return;
    L54:
        if (r122.longValue() > 0) goto L57;
        r104 = false;
    L57:
        if (r104 == false) goto L59;
        r105 = r122;
    L59:
        if (r105 == null) goto L77;
        long r108 = r105.longValue();     // Catch: Exception -> L64
        Map r123 = (Map) ((LinkedHashMap) this.f176462a).get(r110);     // Catch: Exception -> L64
        if (r123 == null) goto L78;
        Long r124 = (Long) r123.put("load_duration", Long.valueOf(r100 - r108));     // Catch: Exception -> L64
        return;
    L78:
        return;
    L77:
        return;
    L75:
        return;
    }
}
