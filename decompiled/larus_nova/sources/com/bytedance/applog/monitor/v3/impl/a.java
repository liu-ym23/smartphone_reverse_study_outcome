package com.bytedance.applog.monitor.v3.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import ex3.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C2789a> f192508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f192509b;

    /* JADX INFO: renamed from: com.bytedance.applog.monitor.v3.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static class C2789a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f192510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f192511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f192512c;

        public C2789a(String r100) {
            this.f192510a = r100;
        }

        public C2789a(String r100, String r101, String r102) {
            this.f192510a = r100;
            this.f192511b = r101;
            this.f192512c = r102;
        }
    }

    public a() {
        this.f192508a = new CopyOnWriteArrayList();
        this.f192509b = 10000;
    }

    public final Pair<Map<String, JSONObject>, Long> a(long r110) {
        if (this.f192509b <= 0) goto L5;
        HashMap r100 = new HashMap();
        Iterator r101 = ((CopyOnWriteArrayList) this.f192508a).iterator();
        int r102 = 0;
    L8:
        if (r101.hasNext() == false) goto L26;
        C2789a r103 = (C2789a) r101.next();
        int r104 = r102 + 1;
        String r105 = String.valueOf(r102);
        r103.getClass();
        JSONObject r106 = new JSONObject();
        r106.put("event", "sdk_fatal");     // Catch: Throwable -> L15
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L15
        r107.put("message", r103.f192510a);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r103.f192511b) == true) goto L13;
        r107.put("class", r103.f192511b);     // Catch: Throwable -> L15
        r107.put("stack", r103.f192512c);     // Catch: Throwable -> L15
    L13:
        r106.put("params", r107);     // Catch: Throwable -> L15
        r106.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L15
        r106.put("event_id", g.f474707b.incrementAndGet());     // Catch: Throwable -> L15
        r106.put(SheetInputData.InputData.DateType.DATETIME, g.a());     // Catch: Throwable -> L15
    L17:
        r100.put(r105, r106);
        ((CopyOnWriteArrayList) this.f192508a).remove(r103);
        if (TextUtils.isEmpty(r103.f192511b) == false) goto L20;
        int r108 = r103.f192510a.length() + 43;
    L21:
        r110 = r110 - ((long) r108);
        if (r110 <= 0) goto L26;
        r102 = r104;
        goto L8
    L20:
        r108 = ((r103.f192510a.length() + 65) + r103.f192511b.length()) + r103.f192512c.length();
    L15:
        th = move-exception;
        th.printStackTrace();
    L26:
        return new Pair(r100, Long.valueOf(r110));
    L5:
        return new Pair(null, Long.valueOf(r110));
    }
}
