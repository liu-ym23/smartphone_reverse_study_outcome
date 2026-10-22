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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f192515f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f192516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f192517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, a> f192518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f192519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ex3.b f192520e;

    /* JADX INFO: loaded from: classes6.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f192521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f192522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f192523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f192524d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f192525e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f192526f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f192527g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f192528h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f192529i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final JSONObject f192530j;

        public final JSONObject b() {
            JSONObject r100 = new JSONObject();
            r100.put("request_id", this.f192521a);     // Catch: Throwable -> L12
            r100.put("url", this.f192522b);     // Catch: Throwable -> L12
            r100.put("req_body_length", this.f192523c);     // Catch: Throwable -> L12
            r100.put("is_success", this.f192524d);     // Catch: Throwable -> L12
            r100.put("status_code", this.f192525e);     // Catch: Throwable -> L12
            r100.put("error_code", this.f192526f);     // Catch: Throwable -> L12
            r100.put("resp_body_length", this.f192527g);     // Catch: Throwable -> L12
            r100.put("message", this.f192528h);     // Catch: Throwable -> L12
            r100.put("duration", this.f192529i);     // Catch: Throwable -> L12
            JSONObject r101 = this.f192530j;     // Catch: Throwable -> L12
            if (r101 != null) goto L6;
        L14:
            return r100;
        L6:
            if (r101.length() <= 0) goto L14;
            Iterator<String> r102 = this.f192530j.keys();     // Catch: Throwable -> L12
        L9:
            if (r102.hasNext() == false) goto L14;
            String r103 = r102.next();     // Catch: Throwable -> L12
            r100.put(r103, this.f192530j.get(r103));     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            n.w().r(8, c.f192515f, "NetworkInfo toFlatJson failed", th, new Object[0]);
            goto L14
        }

        public final JSONObject c() {
            JSONObject r100 = new JSONObject();
            r100.put("request_id", this.f192521a);     // Catch: Throwable -> L9
            r100.put("url", this.f192522b);     // Catch: Throwable -> L9
            r100.put("req_body_length", this.f192523c);     // Catch: Throwable -> L9
            r100.put("is_success", this.f192524d);     // Catch: Throwable -> L9
            r100.put("status_code", this.f192525e);     // Catch: Throwable -> L9
            r100.put("error_code", this.f192526f);     // Catch: Throwable -> L9
            r100.put("resp_body_length", this.f192527g);     // Catch: Throwable -> L9
            r100.put("message", this.f192528h);     // Catch: Throwable -> L9
            r100.put("duration", this.f192529i);     // Catch: Throwable -> L9
            JSONObject r101 = this.f192530j;     // Catch: Throwable -> L9
            if (r101 != null) goto L6;
        L11:
            return r100;
        L6:
            if (r101.length() <= 0) goto L11;
            r100.put("extras", this.f192530j);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            n.w().r(8, c.f192515f, "NetworkInfo toJson failed", th, new Object[0]);
            goto L11
        }

        public static a a(String r210) {
            if (TextUtils.isEmpty(r210) == false) goto L10;
            return null;
        L10:
            JSONObject r100 = new JSONObject(r210);     // Catch: Throwable -> L7
            return new a(r100.optString("request_id"), r100.optString("url"), r100.optLong("req_body_length"), r100.optBoolean("is_success"), r100.optInt("status_code"), r100.optInt("error_code"), r100.optLong("resp_body_length"), r100.optString("message"), r100.optLong("duration"), r100.optJSONObject("extras"));
        L7:
            th = move-exception;
            n.w().r(8, c.f192515f, "NetworkInfo fromJson failed", th, new Object[0]);
            return null;
        }

        public a(String r100, String r101, long r102, boolean r103, int r104, int r105, long r106, String r110, long r111, JSONObject r112) {
            this.f192521a = r100;
            this.f192522b = r101;
            this.f192523c = r102;
            this.f192524d = r103;
            this.f192525e = r104;
            this.f192526f = r105;
            this.f192527g = r106;
            this.f192528h = r110;
            this.f192529i = r111;
            this.f192530j = r112;
        }
    }

    static {
        f192515f = Collections.singletonList("NetworkMonitor");
    }

    public final void c() {
        SharedPreferences r100 = this.f192519d;
        if (r100 != null) goto L5;
        return;
    L5:
        Map<String, ?> r101 = r100.getAll();
        if (r101.isEmpty() == false) goto L8;
        return;
    L8:
        Map<String, a> r102 = this.f192518c;
        monitor-enter(r102);
        Iterator<Map.Entry<String, ?>> r103 = r101.entrySet().iterator();     // Catch: Throwable -> L26
    L12:
        if (r103.hasNext() == false) goto L21;
        Map.Entry<String, ?> r104 = r103.next();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r104.getKey()) == true) goto L12;
        if ("uptime".equals(r104.getKey()) == true) goto L12;
        a r105 = a.a((String) r104.getValue());     // Catch: Throwable -> L26
        if (r105 == null) goto L12;
        Map<String, a> r106 = this.f192518c;     // Catch: Throwable -> L26
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;     // Catch: Throwable -> L26
        r107.put(r105.f192521a, r105);     // Catch: Throwable -> L26
        goto L12
    L21:
        monitor-exit(r102);     // Catch: Throwable -> L26
        Handler r108 = this.f192517b;
        if (r108 == null) goto L41;
        r108.removeMessages(8);
        this.f192517b.sendEmptyMessageDelayed(8, 500);
        return;
    L41:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public c(ex3.b r100) {
        this.f192516a = false;
        this.f192518c = new ConcurrentHashMap();
        this.f192520e = r100;
    }

    public final Pair<Map<String, a>, Long> b(long r110) {
        if (((ConcurrentHashMap) this.f192518c).isEmpty() == true) goto L5;
        HashMap r100 = new HashMap();
        Map<String, a> r101 = this.f192518c;
        monitor-enter(r101);
        Iterator r102 = ((ConcurrentHashMap) this.f192518c).entrySet().iterator();     // Catch: Throwable -> L21
    L10:
        if (r102.hasNext() == false) goto L18;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Throwable -> L21
        String r104 = (String) r103.getKey();     // Catch: Throwable -> L21
        a r105 = (a) r103.getValue();     // Catch: Throwable -> L21
        if (r105 == null) goto L10;
        r110 = r110 - (((long) ((r105.f192521a.length() + r105.f192522b.length()) + r105.f192528h.length())) + 200);     // Catch: Throwable -> L21
        if (r110 <= 0) goto L18;
        r100.put(r104, r105);     // Catch: Throwable -> L21
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L21
        return new Pair(r100, Long.valueOf(r110));
    L21:
        th = move-exception;
        throw th;
    L5:
        return new Pair(null, Long.valueOf(r110));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 8) goto L5;
        SharedPreferences.Editor r102 = this.f192519d.edit();
        Map<String, a> r103 = this.f192518c;
        monitor-enter(r103);
    L26:
        th = move-exception;
        throw th;
    L16:
        if (((ConcurrentHashMap) this.f192518c).size() <= 200) goto L18;
        r102.clear();     // Catch: Throwable -> L26
        ((ConcurrentHashMap) this.f192518c).clear();     // Catch: Throwable -> L26
    L18:
        Iterator r104 = ((ConcurrentHashMap) this.f192518c).entrySet().iterator();     // Catch: Throwable -> L26
    L20:
        if (r104.hasNext() == false) goto L22;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L26
        r102.putString((String) r105.getKey(), ((a) r105.getValue()).c().toString());     // Catch: Throwable -> L26
        goto L20
    L22:
        monitor-exit(r103);     // Catch: Throwable -> L26
        r102.apply();
        return false;
    L5:
        if (r101 != 16) goto L7;
        a r106 = (a) r100.obj;
        ((ConcurrentHashMap) this.f192518c).put(r106.f192521a, r106);
        Handler r107 = this.f192517b;
        if (r107 == null) goto L33;
        r107.removeMessages(8);
        this.f192517b.sendEmptyMessageDelayed(8, 500);
        return false;
    L33:
        return false;
    L7:
        if (r101 != 24) goto L35;
        c();
        return false;
    L35:
        return false;
    }

    public static void a(Map r100, JSONArray r101) {
        if (r100.isEmpty() == false) goto L15;
        return;
    L15:
        Iterator r102 = r100.entrySet().iterator();     // Catch: Throwable -> L12
    L7:
        if (r102.hasNext() == false) goto L22;
        a r103 = (a) ((Map.Entry) r102.next()).getValue();     // Catch: Throwable -> L12
        if (r103 == null) goto L7;
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L12
        r104.put("event", "sdk_network");     // Catch: Throwable -> L12
        r104.put("params", r103.b());     // Catch: Throwable -> L12
        r104.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L12
        r104.put("event_id", g.f474707b.incrementAndGet());     // Catch: Throwable -> L12
        r104.put(SheetInputData.InputData.DateType.DATETIME, g.a());     // Catch: Throwable -> L12
        r101.put(r104);     // Catch: Throwable -> L12
        goto L7
    L22:
        return;
    L12:
        th = move-exception;
        n.w().r(8, f192515f, "appendMapToJSONArray failed", th, new Object[0]);
    }

    public final void d(String r110, String r111, long r112, boolean r210, int r211, int r212, long r213, String r214, long r215, JSONObject r216) {
        if (this.f192516a == true) goto L5;
        return;
    L5:
        n.w().k(8, f192515f, "onRequestFinished {} -> {}, {}, {}, {}, {}, {}, {}, {}", new Object[]{r110, r111, Long.valueOf(r112), Boolean.valueOf(r210), Integer.valueOf(r211), Integer.valueOf(r212), Long.valueOf(r213), r214, Long.valueOf(r215), r216});
        a r113 = new a(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216);
        Handler r100 = this.f192517b;
        if (r100 == null) goto L8;
        r100.sendMessage(r100.obtainMessage(16, r113));
        return;
    L8:
        ((ConcurrentHashMap) this.f192518c).put(r110, r113);
        Handler r101 = this.f192517b;
        if (r101 == null) goto L13;
        r101.removeMessages(8);
        this.f192517b.sendEmptyMessageDelayed(8, 500);
        return;
    }
}
