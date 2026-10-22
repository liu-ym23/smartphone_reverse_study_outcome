package com.bytedance.apm6.perf.base;

import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.apm.util.d;
import com.bytedance.apm.util.g;
import com.bytedance.apm6.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PerfFilterManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.apm6.service.e.b {
    private static volatile c g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f5434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f5435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5438e;
    private long f;

    private c() {
        this.f5434a = new CopyOnWriteArraySet();
        this.f5435b = new ConcurrentHashMap();
    }

    public static c a() {
        if (g != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public void a(String r1, String r2) {
        this.f5435b.put(r1, r2);
    }

    public String b() {
        String r2 = f.a(this.f5434a.toArray(), "#");
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        com.bytedance.apm6.service.d.a r3 = (com.bytedance.apm6.service.d.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.d.a.class), com.bytedance.apm6.service.d.a.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L8;
        return "";
    L8:
        return r3.getTopActivityClassName();
    }

    public JSONObject c() {
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, String>> r5 = this.f5435b.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L9
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r2.getValue());     // Catch: JSONException -> L9
    L8:
        return r1;
    }

    public JSONObject a(boolean r6) {
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, String>> r5 = this.f5435b.entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r5.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L11
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), r2.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r1.put("RealRefreshRate", String.valueOf(g.e()));     // Catch: JSONException -> L11
        r1.put("RealMaxRefreshRate", String.valueOf(g.e()));     // Catch: JSONException -> L11
        if (r6 == false) goto L10;
        d.a().e(r1);     // Catch: JSONException -> L11
        d.a().f(r1);     // Catch: JSONException -> L11
    L10:
        return r1;
    }

    public JSONObject d() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        e();     // Catch: Exception -> L4
        r0.put("apm_native_heap_size", this.f5436c);     // Catch: Exception -> L4
        r0.put("apm_java_heap_leak", this.f5437d);     // Catch: Exception -> L4
        r0.put("apm_java_heap_used", this.f);     // Catch: Exception -> L4
        r0.put("apm_java_heap_max", this.f5438e);     // Catch: Exception -> L4
        return r0;
    L4:
        return null;
    }

    private void e() {
        this.f5436c = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r0 = Runtime.getRuntime();
        long r4 = r0.maxMemory();
        long r6 = r0.freeMemory();
        long r1 = r0.totalMemory();
        this.f5438e = r4 / 1048576;
        long r2 = r1 - r6;
        this.f = r2 / 1048576;
        if (r2 <= (r4 * 0.95f)) goto L5;
        boolean r3 = true;
    L6:
        this.f5437d = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }
}
