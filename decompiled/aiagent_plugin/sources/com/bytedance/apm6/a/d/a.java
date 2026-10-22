package com.bytedance.apm6.a.d;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm6.perf.base.c;
import com.bytedance.apm6.util.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MemoryPerfDataEvent.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends com.bytedance.apm6.perf.base.model.a {
    private long g;
    private long h;
    private long i;
    private long j;
    private boolean k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private double r;
    private boolean s;
    private boolean t;
    private Map<Object, Object> u;

    @Override // com.bytedance.apm6.perf.base.model.a
    public String a() {
        return "memory";
    }

    @Override // com.bytedance.apm6.monitor.b
    public boolean h() {
        return true;
    }

    public a(long r4, long r6, long r8, long r10, boolean r12, long r13, long r15, long r17, long r19, long r21, long r23, double r25, boolean r27, boolean r28) {
        this.g = r4;
        this.h = r6;
        this.i = r8;
        this.j = r10;
        this.k = r12;
        this.l = r13;
        this.m = r15;
        this.n = r17;
        this.o = r19;
        this.p = r21;
        this.q = r23;
        this.r = r25;
        this.s = r27;
        this.t = r28;
    }

    public void a(Map<Object, Object> r3) {
        this.u = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject b() {
        JSONObject r0 = new JSONObject();
        r0.put("gc_count", this.g);     // Catch: JSONException -> L12
        r0.put("gc_time", this.h);     // Catch: JSONException -> L12
        r0.put("block_gc_count", this.i);     // Catch: JSONException -> L12
        r0.put("block_gc_time", this.j);     // Catch: JSONException -> L12
        if (this.k == false) goto L6;
        r0.put("dalvik_pss_background", this.o);     // Catch: JSONException -> L12
        r0.put("native_pss_background", this.l);     // Catch: JSONException -> L12
        r0.put("total_pss_background", this.m);     // Catch: JSONException -> L12
        r0.put("java_heap_background", this.n);     // Catch: JSONException -> L12
        r0.put("java_heap_background_used_rate", this.r);     // Catch: JSONException -> L12
        r0.put("vm_size_background", this.q);     // Catch: JSONException -> L12
        r0.put("graphics_background", this.p);     // Catch: JSONException -> L12
    L8:
        if (this.s == false) goto L10;
        r0.put("reach_top_java", 1);     // Catch: JSONException -> L12
    L10:
        a(r0);     // Catch: JSONException -> L12
    L14:
        return r0;
    L6:
        r0.put("dalvik_pss_foreground", this.o);     // Catch: JSONException -> L12
        r0.put("native_pss_foreground", this.l);     // Catch: JSONException -> L12
        r0.put("total_pss_foreground", this.m);     // Catch: JSONException -> L12
        r0.put("java_heap_foreground", this.n);     // Catch: JSONException -> L12
        r0.put("java_heap_foreground_used_rate", this.r);     // Catch: JSONException -> L12
        r0.put("vm_size_foreground", this.q);     // Catch: JSONException -> L12
        r0.put("graphics_foreground", this.p);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    private void a(JSONObject r6) {
        if (r6 != null) goto L15;
        return;
    L15:
        Map<Object, Object> r5 = this.u;     // Catch: Exception -> L14
        if (r5 != null) goto L8;
        return;
    L8:
        Iterator<Map.Entry<Object, Object>> r7 = r5.entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        r6.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin"), Long.parseLong((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L14
    L19:
        return;
    }

    public double f() {
        return this.r;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject c() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L8
        r0.put(DBHelper.BATTERY_COL_SCENE, c.a().b());     // Catch: Throwable -> L8
        r0.put("process_name", com.bytedance.apm6.foundation.context.a.f());     // Catch: Throwable -> L8
        if (this.k == true) goto L5;
        boolean r3 = true;
    L6:
        r0.put("is_front", r3);     // Catch: Throwable -> L8
        r0.put("is_main_process", com.bytedance.apm6.foundation.context.a.e());     // Catch: Throwable -> L8
        return r0;
    L5:
        r3 = false;
    L8:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject d() {
        JSONObject r0 = c.a().c();
        if (this.t == true) goto L14;
    L6:
        com.bytedance.apm6.service.a.a r3 = (com.bytedance.apm6.service.a.a) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.service.a.a.class), com.bytedance.apm6.service.a.a.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L12;
    L9:
        return r0;
    L12:
        e.a(r0, r3.a());     // Catch: Exception -> L11
        goto L9
    L14:
        e.a(r0, c.a().d());     // Catch: Exception -> L10
        goto L6
    }

    public com.bytedance.apm6.a.a.a j() {
        com.bytedance.apm6.a.a.a r0 = new com.bytedance.apm6.a.a.a();
        r0.f5014a = this.g;
        r0.f5015b = this.h;
        r0.f5016c = this.i;
        r0.f5017d = this.j;
        r0.f5018e = this.k;
        r0.f = this.l;
        r0.g = this.m;
        r0.h = this.n;
        r0.i = this.o;
        r0.j = this.p;
        r0.k = this.q;
        r0.l = this.s;
        return r0;
    }

    public String toString() {
        return "MemoryPerfMonitorable{gcCount=" + this.g + ", gcTime=" + this.h + ", blockingGcCount=" + this.i + ", blockingGcTime=" + this.j + ", background=" + this.k + ", nativePss=" + this.l + ", totalPss=" + this.m + ", javaUsedMemory=" + this.n + ", dalvikUsedSize=" + this.o + ", graphics=" + this.p + ", vmSize=" + this.q + ", javaUsedMemoryRate=" + this.r + ", isMemoryReachTop=" + this.s + '}';
    }
}
