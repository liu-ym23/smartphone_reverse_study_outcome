package com.bytedance.apm6.hub.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: MemoryConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements com.bytedance.apm6.a.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm6.a.b.a f5411a;

    static /* synthetic */ void a(h r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    public h() {
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.hub.a.a.a.a().a(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm6.a.b.b
    public com.bytedance.apm6.a.b.a a() {
        return this.f5411a;
    }

    private void a(JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject("performance_modules");
        if (r13 != null) goto L5;
        return;
    L5:
        JSONObject r14 = r13.optJSONObject("memory");
        if (r14 != null) goto L8;
        return;
    L8:
        long r1 = r14.optLong("collect_interval", 120);
        double r3 = r14.optDouble("reach_top_memory_rate", 0.8d);
        boolean r8 = true;
        if (r14.optInt("enable_upload", 0) != 1) goto L11;
        boolean r9 = true;
    L13:
        if (r14.optInt("close_memory_collect") != 1) goto L16;
        r8 = false;
    L16:
        this.f5411a = new com.bytedance.apm6.a.b.a(r1, r3, false, false, r9, r8);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L19;
        com.bytedance.apm6.util.c.b.a("APM-Config", "parsed MemoryConfig=" + this.f5411a);
    L19:
        com.bytedance.apm6.a.b.a().a(a());
        return;
    L11:
        r9 = false;
        goto L13
    }
}
