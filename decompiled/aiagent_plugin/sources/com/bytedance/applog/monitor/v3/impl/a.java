package com.bytedance.applog.monitor.v3.impl;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.monitor.v3.c;
import com.bytedance.applog.monitor.v3.f;
import com.bytedance.applog.monitor.v3.g;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ErrorMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<C0137a> f5816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f5819d;

    /* JADX INFO: renamed from: com.bytedance.applog.monitor.v3.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ErrorMonitor.java */
    private static class C0137a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f5821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f5822c;

        public C0137a(String r1, String r2, String r3) {
            this.f5820a = r1;
            this.f5821b = r2;
            this.f5822c = r3;
        }

        public C0137a(String r1) {
            this.f5820a = r1;
        }

        public JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("event", "sdk_fatal");     // Catch: Throwable -> L8
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L8
            r1.put("message", this.f5820a);     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(this.f5821b) == true) goto L6;
            r1.put("class", this.f5821b);     // Catch: Throwable -> L8
            r1.put("stack", this.f5822c);     // Catch: Throwable -> L8
        L6:
            r0.put("params", r1);     // Catch: Throwable -> L8
            r0.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L8
            r0.put("event_id", f.b());     // Catch: Throwable -> L8
            r0.put("datetime", f.d());     // Catch: Throwable -> L8
        L10:
            return r0;
        L8:
            th = move-exception;
            th.printStackTrace();
            goto L10
        }

        public long b() {
            if (TextUtils.isEmpty(this.f5821b) == false) goto L6;
            return this.f5820a.length() + 43;
        L6:
            return ((this.f5820a.length() + 65) + this.f5821b.length()) + this.f5822c.length();
        }
    }

    public void a(Context r1, HandlerThread r2, String r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
    }

    public void a(Map<String, JSONObject> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
    }

    public a(c r2) {
        this.f5816a = new CopyOnWriteArrayList();
        this.f5817b = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.f5818c = 100;
        this.f5819d = r2;
    }

    public void a() {
        this.f5817b = 0;
    }

    public Pair<Map<String, JSONObject>, Long> a(long r7) {
        if (this.f5817b <= 0) goto L5;
        HashMap r0 = new HashMap();
        Iterator<C0137a> r1 = this.f5816a.iterator();
        int r2 = 0;
    L8:
        if (r1.hasNext() == false) goto L14;
        C0137a r3 = (C0137a) ZeusTransformUtils.preCheckCast(r1.next(), C0137a.class, "com.obric.aiagent.plugin");
        int r4 = r2 + 1;
        r0.put(String.valueOf(r2), r3.a());
        this.f5816a.remove(r3);
        r7 = r7 - r3.b();
        if (r7 <= 0) goto L14;
        r2 = r4;
    L14:
        return new Pair(r0, Long.valueOf(r7));
    L5:
        return new Pair(null, Long.valueOf(r7));
    }

    public void a(Map<String, JSONObject> r3, JSONArray r4) {
        Iterator r2 = ((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin")).values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r4.put((JSONObject) ZeusTransformUtils.preCheckCast(r2.next(), JSONObject.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    public void a(String r4, Throwable r5) {
        if (g.a(this.f5817b, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) == true) goto L5;
        return;
    L5:
        if (r5 == null) goto L7;
        this.f5816a.add(new C0137a(r4, r5.getClass().getCanonicalName(), a(r5)));
    L9:
        if (this.f5816a.size() <= 100) goto L12;
        this.f5816a.remove(0);
        return;
    L12:
        return;
    L7:
        this.f5816a.add(new C0137a(r4));
        goto L9
    }

    private String a(Throwable r2) {
        StringBuilder r0 = new StringBuilder();
    L3:
        if (r2 == null) goto L5;
        a(r0, r2);
        r2 = r2.getCause();
        goto L3
    L5:
        String r1 = r0.toString().replaceAll("[\\s|\\n]", "");
        if (r1.length() > 200) goto L9;
        return r1;
    L9:
        return r1.substring(0, 200);
    }

    private void a(StringBuilder r4, Throwable r5) {
        r4.append(r5.toString());
        StackTraceElement[] r3 = r5.getStackTrace();
        int r6 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        StackTraceElement r1 = r3[r0];
        r4.append("\n\tat ").append(r1);
        r0 = r0 + 1;
        goto L3
    }
}
