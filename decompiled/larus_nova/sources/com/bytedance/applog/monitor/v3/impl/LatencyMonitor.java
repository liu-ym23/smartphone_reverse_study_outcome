package com.bytedance.applog.monitor.v3.impl;

import android.util.Pair;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import ex3.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class LatencyMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f192501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a> f192502b;

    /* JADX INFO: loaded from: classes6.dex */
    public static final enum EventLatencyScope extends Enum<EventLatencyScope> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventLatencyScope[] f192503a = null;
        public static final EventLatencyScope l_0_1 = null;
        public static final EventLatencyScope l_0_60 = null;
        public static final EventLatencyScope l_10_20 = null;
        public static final EventLatencyScope l_120_ = null;
        public static final EventLatencyScope l_1_10 = null;
        public static final EventLatencyScope l_20_30 = null;
        public static final EventLatencyScope l_30_40 = null;
        public static final EventLatencyScope l_40_50 = null;
        public static final EventLatencyScope l_50_60 = null;
        public static final EventLatencyScope l_60_120 = null;

        static {
            EventLatencyScope r100 = new EventLatencyScope("l_0_60", 0);
            l_0_60 = r100;
            EventLatencyScope r101 = new EventLatencyScope("l_0_1", 1);
            l_0_1 = r101;
            EventLatencyScope r102 = new EventLatencyScope("l_1_10", 2);
            l_1_10 = r102;
            EventLatencyScope r103 = new EventLatencyScope("l_10_20", 3);
            l_10_20 = r103;
            EventLatencyScope r104 = new EventLatencyScope("l_20_30", 4);
            l_20_30 = r104;
            EventLatencyScope r105 = new EventLatencyScope("l_30_40", 5);
            l_30_40 = r105;
            EventLatencyScope r110 = new EventLatencyScope("l_40_50", 6);
            l_40_50 = r110;
            EventLatencyScope r111 = new EventLatencyScope("l_50_60", 7);
            l_50_60 = r111;
            EventLatencyScope r112 = new EventLatencyScope("l_60_120", 8);
            l_60_120 = r112;
            EventLatencyScope r113 = new EventLatencyScope("l_120_", 9);
            l_120_ = r113;
            f192503a = new EventLatencyScope[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static EventLatencyScope[] values() {
            return (EventLatencyScope[]) f192503a.clone();
        }

        public static EventLatencyScope valueOf(String r100) {
            return (EventLatencyScope) r27.a.a(EventLatencyScope.class, r100);
        }

        public EventLatencyScope(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f192504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f192505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public StageEventType f192506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public EventLatencyScope f192507d;

        public final JSONObject a() {
            JSONObject r100 = new JSONObject();
            r100.put("event", "sdk_event_latency");     // Catch: Throwable -> L5
            JSONObject r101 = new JSONObject();     // Catch: Throwable -> L5
            r101.put("stage", 2);     // Catch: Throwable -> L5
            r101.put("event_priority", this.f192505b);     // Catch: Throwable -> L5
            r101.put("event_type", this.f192506c.getLabel());     // Catch: Throwable -> L5
            r101.put("interval_scope", this.f192507d.toString());     // Catch: Throwable -> L5
            r101.put("event_count", this.f192504a);     // Catch: Throwable -> L5
            r100.put("params", r101);     // Catch: Throwable -> L5
            r100.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L5
            r100.put("event_id", g.f474707b.incrementAndGet());     // Catch: Throwable -> L5
            r100.put(SheetInputData.InputData.DateType.DATETIME, g.a());     // Catch: Throwable -> L5
        L4:
            return r100;
        }

        public a() {
            this.f192504a = 0;
            this.f192505b = -1;
            this.f192506c = StageEventType.V3_EVENT;
            this.f192507d = EventLatencyScope.l_0_60;
        }
    }

    public LatencyMonitor() {
        this.f192501a = true;
        this.f192502b = new ConcurrentHashMap();
    }

    public final Pair<Map<String, JSONObject>, Long> a(long r100) {
        if (this.f192501a == false) goto L23;
        if (((ConcurrentHashMap) this.f192502b).isEmpty() == true) goto L23;
        HashMap r101 = new HashMap();
        Map<String, a> r102 = this.f192502b;
        monitor-enter(r102);
        Iterator r103 = ((ConcurrentHashMap) this.f192502b).keySet().iterator();     // Catch: Throwable -> L19
    L11:
        if (r103.hasNext() == false) goto L16;
        String r104 = (String) r103.next();     // Catch: Throwable -> L19
        a r105 = (a) ((ConcurrentHashMap) this.f192502b).remove(r104);     // Catch: Throwable -> L19
        if (r105 == null) goto L11;
        r101.put(r104, r105.a());     // Catch: Throwable -> L19
        r100 = r100 - 231;     // Catch: Throwable -> L19
        if (r100 > 0) goto L11;
    L16:
        monitor-exit(r102);     // Catch: Throwable -> L19
        return new Pair(r101, Long.valueOf(r100));
    L19:
        th = move-exception;
        throw th;
    L23:
        return new Pair(null, Long.valueOf(r100));
    }

    public final void b(int r100, StageEventType r101, int r102) {
        if (r102 > 1) goto L6;
        EventLatencyScope r103 = EventLatencyScope.l_0_1;
    L27:
        String r104 = r100 + "_" + r101.toString() + "_" + r103.toString();
        Map<String, a> r105 = this.f192502b;
        monitor-enter(r105);
        a r106 = (a) ((ConcurrentHashMap) this.f192502b).get(r104);     // Catch: Throwable -> L35
        if (r106 != null) goto L32;
        r106 = new a();     // Catch: Throwable -> L35
        r106.f192507d = r103;     // Catch: Throwable -> L35
        r106.f192506c = r101;     // Catch: Throwable -> L35
        r106.f192505b = r100;     // Catch: Throwable -> L35
        ((ConcurrentHashMap) this.f192502b).put(r104, r106);     // Catch: Throwable -> L35
    L32:
        r106.f192504a++;     // Catch: Throwable -> L35
        monitor-exit(r105);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    L6:
        if (r102 > 10) goto L9;
        r103 = EventLatencyScope.l_1_10;
        goto L27
    L9:
        if (r102 > 20) goto L12;
        r103 = EventLatencyScope.l_10_20;
        goto L27
    L12:
        if (r102 > 30) goto L15;
        r103 = EventLatencyScope.l_20_30;
        goto L27
    L15:
        if (r102 > 40) goto L18;
        r103 = EventLatencyScope.l_30_40;
        goto L27
    L18:
        if (r102 > 50) goto L21;
        r103 = EventLatencyScope.l_40_50;
        goto L27
    L21:
        if (r102 > 60) goto L24;
        r103 = EventLatencyScope.l_50_60;
        goto L27
    L24:
        if (r102 > 120) goto L26;
        r103 = EventLatencyScope.l_60_120;
        goto L27
    L26:
        r103 = EventLatencyScope.l_120_;
        goto L27
    }
}
