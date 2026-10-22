package com.bytedance.apm6.hub.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: JavaAllocConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements com.bytedance.apm6.java_alloc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm6.java_alloc.b f5409a;

    static /* synthetic */ void a(g r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    public g() {
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.hub.a.a.a.a().a(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm6.java_alloc.c
    public com.bytedance.apm6.java_alloc.b a() {
        return this.f5409a;
    }

    private void a(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("performance_modules");
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r13 = r12.optJSONObject("memory");
        if (r13 != null) goto L8;
        return;
    L8:
        boolean r2 = true;
        if (r13.optInt("enable_alloc_collect", 0) != 1) goto L11;
        boolean r3 = true;
    L13:
        if (r13.optInt("enable_alloc_upload", 0) == 1) goto L16;
        r2 = false;
    L16:
        this.f5409a = new com.bytedance.apm6.java_alloc.b(r3, r2, r13.optInt("alloc_collect_per_thousand_alloc", 0), r13.optInt("alloc_dump_per_thousand_collect", 0), r13.optInt("alloc_threshold_alloc_frequency", 0), r13.optLong("alloc_threshold_alloc_size", 0));
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L19;
        com.bytedance.apm6.util.c.b.a("APM-Config", "parsed JavaAllocConfig=" + this.f5409a);
    L19:
        com.bytedance.apm6.java_alloc.a.a().a(a());
        return;
    L11:
        r3 = false;
        goto L13
    }
}
