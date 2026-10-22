package com.bytedance.applog.monitor.v3.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.log.n;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import ex3.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f192544f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f192545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f192546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f192547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f192548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ex3.b f192549e;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f192550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f192551b;

        public a(String r100, int r101) {
            this.f192550a = r100;
            this.f192551b = r101;
        }
    }

    static {
        f192544f = Collections.singletonList("StatsMonitor");
    }

    public final void e() {
        SharedPreferences r100 = this.f192548d;
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = r100.getLong("uptime", 0);
        if (r101 > 0) goto L8;
    L11:
        Map<String, ?> r102 = this.f192548d.getAll();
        if (r102.isEmpty() == false) goto L14;
        return;
    L14:
        Map<String, Integer> r103 = this.f192547c;
        monitor-enter(r103);
        Iterator<Map.Entry<String, ?>> r104 = r102.entrySet().iterator();     // Catch: Throwable -> L37
    L18:
        if (r104.hasNext() == false) goto L32;
        Map.Entry<String, ?> r105 = r104.next();     // Catch: Throwable -> L37
        String r106 = r105.getKey();     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r106) == true) goto L18;
        if ("uptime".equals(r105.getKey()) == true) goto L18;
        if (r105.getValue() == null) goto L27;
        int r107 = ((Integer) r105.getValue()).intValue();     // Catch: Throwable -> L37
    L28:
        Integer r108 = (Integer) ((ConcurrentHashMap) this.f192547c).get(r106);     // Catch: Throwable -> L37
        if (r108 == null) goto L30;
        ((ConcurrentHashMap) this.f192547c).put(r106, Integer.valueOf(r107 + r108.intValue()));     // Catch: Throwable -> L37
        goto L18
    L30:
        ((ConcurrentHashMap) this.f192547c).put(r106, Integer.valueOf(r107));     // Catch: Throwable -> L37
        goto L18
    L27:
        r107 = 0;
        goto L28
    L32:
        monitor-exit(r103);     // Catch: Throwable -> L37
        Handler r109 = this.f192546b;
        if (r109 == null) goto L53;
        r109.removeMessages(8);
        this.f192546b.sendEmptyMessageDelayed(8, 500);
        return;
    L53:
        return;
    L37:
        th = move-exception;
        throw th;
    L8:
        if ((System.currentTimeMillis() - r101) <= TimeUnit.DAYS.toMillis(this.f192549e.f474639i)) goto L11;
        this.f192548d.edit().clear().apply();
    }

    public e(ex3.b r100) {
        this.f192545a = true;
        this.f192547c = new ConcurrentHashMap();
        this.f192549e = r100;
    }

    public final Pair<Map<String, Integer>, Long> b(long r100) {
        if (((ConcurrentHashMap) this.f192547c).isEmpty() == false) goto L7;
        return new Pair(null, Long.valueOf(r100));
    L7:
        return new Pair(new HashMap(this.f192547c), Long.valueOf(r100 - (((long) ((ConcurrentHashMap) this.f192547c).size()) * 30)));
    }

    public final void d(a r100) {
        Map<String, Integer> r101 = this.f192547c;
        monitor-enter(r101);
        Map<String, Integer> r102 = this.f192547c;     // Catch: Throwable -> L14
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;     // Catch: Throwable -> L14
        Integer r104 = (Integer) r103.get(r100.f192550a);     // Catch: Throwable -> L14
        if (r104 == null) goto L7;
        int r105 = r104.intValue();     // Catch: Throwable -> L14
    L8:
        int r106 = r105 + r100.f192551b;     // Catch: Throwable -> L14
        Map<String, Integer> r107 = this.f192547c;     // Catch: Throwable -> L14
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;     // Catch: Throwable -> L14
        r108.put(r100.f192550a, Integer.valueOf(r106));     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        Handler r109 = this.f192546b;
        if (r109 == null) goto L19;
        r109.removeMessages(8);
        this.f192546b.sendEmptyMessageDelayed(8, 500);
        return;
    L19:
        return;
    L7:
        r105 = 0;
    L14:
        th = move-exception;
        throw th;
    }

    public final void f(Map<String, Integer> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L38;
        Map<String, Integer> r101 = this.f192547c;
        monitor-enter(r101);
        Iterator<Map.Entry<String, Integer>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L24
    L10:
        if (r102.hasNext() == false) goto L21;
        Map.Entry<String, Integer> r103 = r102.next();     // Catch: Throwable -> L24
        String r104 = r103.getKey();     // Catch: Throwable -> L24
        if (r103.getValue() == null) goto L14;
        int r105 = r103.getValue().intValue();     // Catch: Throwable -> L24
    L15:
        Integer r106 = (Integer) ((ConcurrentHashMap) this.f192547c).get(r104);     // Catch: Throwable -> L24
        if (r106 == null) goto L10;
        int r107 = Math.max(0, r106.intValue() - r105);     // Catch: Throwable -> L24
        if (r107 == 0) goto L19;
        Map<String, Integer> r108 = this.f192547c;     // Catch: Throwable -> L24
        ConcurrentHashMap r109 = (ConcurrentHashMap) r108;     // Catch: Throwable -> L24
        r109.put(r104, Integer.valueOf(r107));     // Catch: Throwable -> L24
        goto L10
    L19:
        ((ConcurrentHashMap) this.f192547c).remove(r104);     // Catch: Throwable -> L24
        goto L10
    L14:
        r105 = 0;
        goto L15
    L21:
        monitor-exit(r101);     // Catch: Throwable -> L24
        this.f192546b.removeMessages(8);
        this.f192546b.sendEmptyMessageDelayed(8, 500);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 8) goto L5;
        SharedPreferences.Editor r102 = this.f192548d.edit();
        r102.clear();
        Map<String, Integer> r103 = this.f192547c;
        monitor-enter(r103);
        Iterator r104 = ((ConcurrentHashMap) this.f192547c).entrySet().iterator();     // Catch: Throwable -> L24
    L15:
        if (r104.hasNext() == false) goto L21;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L24
        String r106 = (String) r105.getKey();     // Catch: Throwable -> L24
        if (r105.getValue() == null) goto L19;
        int r107 = ((Integer) r105.getValue()).intValue();     // Catch: Throwable -> L24
    L20:
        r102.putInt(r106, r107);     // Catch: Throwable -> L24
        goto L15
    L19:
        r107 = 0;
        goto L20
    L21:
        monitor-exit(r103);     // Catch: Throwable -> L24
        r102.putLong("uptime", System.currentTimeMillis());
        r102.apply();
    L23:
        return false;
    L24:
        th = move-exception;
        throw th;
    L5:
        if (r101 != 16) goto L7;
        d((a) r100.obj);
        goto L23
    L7:
        if (r101 != 24) goto L23;
        e();
        goto L23
    }

    public static void a(Map r100, JSONArray r101) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r102 = new JSONObject();
        r102.put("event", "sdk_stats");     // Catch: Throwable -> L16
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L16
        Iterator r104 = r100.entrySet().iterator();     // Catch: Throwable -> L16
    L8:
        if (r104.hasNext() == false) goto L14;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L16
        Integer r106 = (Integer) r105.getValue();     // Catch: Throwable -> L16
        if (r106 == null) goto L8;
        if (r106.intValue() <= 0) goto L8;
        r103.put((String) r105.getKey(), r106);     // Catch: Throwable -> L16
        goto L8
    L14:
        r102.put("params", r103);     // Catch: Throwable -> L16
        r102.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L16
        r102.put("event_id", g.f474707b.incrementAndGet());     // Catch: Throwable -> L16
        r102.put(SheetInputData.InputData.DateType.DATETIME, g.a());     // Catch: Throwable -> L16
    L18:
        r101.put(r102);
        return;
    L16:
        th = move-exception;
        n.w().r(8, f192544f, "appendMapToJSONArray failed", th, new Object[0]);
        goto L18
    }

    public final void c(String r100, int r101) {
        if (this.f192545a == true) goto L5;
        return;
    L5:
        a r102 = new a(r100, r101);
        Handler r103 = this.f192546b;
        if (r103 == null) goto L8;
        r103.sendMessageDelayed(r103.obtainMessage(16, r102), 16);
        return;
    L8:
        d(r102);
    }
}
