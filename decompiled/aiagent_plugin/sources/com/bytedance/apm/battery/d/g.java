package com.bytedance.apm.battery.d;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BatteryLocStatsImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends a<com.bytedance.apm.battery.d.a.c> implements com.bytedance.apm.battery.b.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f4314e;

    @Override // com.bytedance.apm.battery.b.b
    public String a() {
        return "android.location.ILocationManager";
    }

    @Override // com.bytedance.apm.battery.d.a
    public /* synthetic */ void a(com.bytedance.apm.battery.d.a.b r3, long r4) {
        a((com.bytedance.apm.battery.d.a.c) ZeusTransformUtils.preCheckCast(r3, com.bytedance.apm.battery.d.a.c.class, "com.obric.aiagent.plugin"), r4);
    }

    public g() {
        super("location");
        this.f4314e = new ArrayList();
    }

    @Override // com.bytedance.apm.battery.b.b
    public void a(Object r1, Method r2, Object[] r3) {
        String r4 = r2.getName();     // Catch: Exception -> L14
        if (TextUtils.equals(r4, "requestLocationUpdates") == false) goto L6;
        a(r3);     // Catch: Exception -> L14
    L15:
        return;
    L6:
        if (TextUtils.equals(r4, "registerLocationListener") == false) goto L9;
        b(r3);     // Catch: Exception -> L14
        goto L15
    L9:
        if (TextUtils.equals(r4, "removeUpdates") == false) goto L11;
    L12:
        c(r3);     // Catch: Exception -> L14
        goto L15
    L11:
        if (TextUtils.equals(r4, "unregisterLocationListener") == false) goto L15;
    }

    private void a(Object[] r4) {
        if (r4[0] != null) goto L5;
        return;
    L5:
        if (r4[1] == null) goto L9;
        a(r4[1].hashCode(), r4[0].toString());
        return;
    }

    private void b(Object[] r4) {
        if (r4[1] != null) goto L5;
        return;
    L5:
        if (r4[2] == null) goto L9;
        a(r4[2].hashCode(), r4[1].toString());
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void a(int r4, String r5) {
        String r0 = String.valueOf(r4);
        if (this.f4314e.contains(r0) == true) goto L6;
        b();
        this.f4314e.add(r0);
    L6:
        if (com.bytedance.apm.battery.a.a().g() == false) goto L12;
        com.bytedance.apm.battery.d.a.c r1 = (com.bytedance.apm.battery.d.a.c) ZeusTransformUtils.preCheckCast(this.f4307d.get(Integer.valueOf(r4)), com.bytedance.apm.battery.d.a.c.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L10;
        r1 = new com.bytedance.apm.battery.d.a.c();
        r1.f4297a = r5;
    L10:
        r1.f4295d = System.currentTimeMillis();
        r1.f4296e = -1;
        r1.g = Thread.currentThread().getStackTrace();
        r1.f = Thread.currentThread().getName();
        this.f4307d.put(Integer.valueOf(r4), r1);
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void c(Object[] r4) {
        if (r4[0] == null) goto L13;
        int r5 = r4[0].hashCode();
        String r0 = String.valueOf(r5);
        if (this.f4314e.contains(r0) == false) goto L8;
        c();
        this.f4314e.remove(r0);
    L8:
        if (com.bytedance.apm.battery.a.a().g() == false) goto L14;
        com.bytedance.apm.battery.d.a.c r1 = (com.bytedance.apm.battery.d.a.c) ZeusTransformUtils.preCheckCast(this.f4307d.get(Integer.valueOf(r5)), com.bytedance.apm.battery.d.a.c.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        r1.f4296e = System.currentTimeMillis();
        this.f4307d.put(Integer.valueOf(r5), r1);
        return;
    L15:
        return;
    L14:
        return;
    }

    public void a(com.bytedance.apm.battery.d.a.c r4, long r5) {
        if (r5 >= com.bytedance.apm.battery.a.a.f()) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L7
        r0.put("issue_type", 32).put("single_hold_time", r5);     // Catch: Throwable -> L7
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L7
        r6.put(r4.a());     // Catch: Throwable -> L7
        r0.put("detail", r6);     // Catch: Throwable -> L7
        com.bytedance.apm.perf.b.a(r0, "battery_trace");     // Catch: Throwable -> L7
        com.bytedance.apm.d.a.a.c().a(new com.bytedance.apm.d.b.d("battery_trace", r0));     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.apm.battery.d.a
    void a(double r5, double r7) {
        if (r5 < com.bytedance.apm.battery.a.a.h()) goto L5;
        int r1 = 33;
    L7:
        if (r7 < com.bytedance.apm.battery.a.a.g()) goto L9;
        r1 = r1 | 34;
    L9:
        if (r1 != 0) goto L23;
        return;
    L23:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L22
        r2.put("issue_type", r1).put("total_hold_time", r5).put("total_acquire_count", r7);     // Catch: Throwable -> L22
        if (this.f4307d != null) goto L14;
    L20:
        com.bytedance.apm.perf.b.a(r2, "battery_trace");     // Catch: Throwable -> L22
        com.bytedance.apm.d.a.a.c().a(new com.bytedance.apm.d.b.d("battery_trace", r2));     // Catch: Throwable -> L22
        return;
    L14:
        if (this.f4307d.size() <= 0) goto L20;
        JSONArray r6 = new JSONArray();     // Catch: Throwable -> L22
        Iterator r4 = this.f4307d.values().iterator();     // Catch: Throwable -> L22
    L17:
        if (r4.hasNext() == false) goto L19;
        r6.put(((com.bytedance.apm.battery.d.a.c) ZeusTransformUtils.preCheckCast(r4.next(), com.bytedance.apm.battery.d.a.c.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L22
        goto L17
    L19:
        r2.put("detail", r6);     // Catch: Throwable -> L22
    L26:
        return;
    L5:
        r1 = 0;
        goto L7
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r3, com.bytedance.apm.e.a r4) {
        if (getType().equals(r4.f4583b) == true) goto L5;
        return;
    L5:
        if (r4.a() == false) goto L7;
        r3.q(r4.d());
        return;
    L7:
        r3.h(r4.d());
    }
}
