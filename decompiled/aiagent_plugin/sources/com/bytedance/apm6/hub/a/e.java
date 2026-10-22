package com.bytedance.apm6.hub.a;

import com.obric.capabilitykit.entity.EntityContentProvider;
import org.json.JSONObject;

/* JADX INFO: compiled from: FluencyConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.apm.config.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm.config.e f5405a;

    static /* synthetic */ void a(e r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    public e() {
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.hub.a.a.a.a().a(new AnonymousClass1(this));
    }

    public com.bytedance.apm.config.e a() {
        return this.f5405a;
    }

    private void a(JSONObject r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        JSONObject r7 = com.bytedance.apm6.perf.base.a.a(r5, "smooth");
        if (r7 != null) goto L7;
        return;
    L7:
        this.f5405a = new com.bytedance.apm.config.e();
        boolean r0 = false;
        if (r7.optInt("enable_stack_sampling", 0) != 1) goto L10;
        boolean r8 = true;
    L11:
        this.f5405a.a(r8);
        if (r7.optInt("enable_trace", 0) != 1) goto L14;
        boolean r9 = true;
    L15:
        this.f5405a.b(r9);
        this.f5405a.a(r7.optLong("atrace_tag", 0));
        if (r7.optInt("block_dump_stack_enable", 1) != 1) goto L18;
        boolean r10 = true;
    L19:
        this.f5405a.c(r10);
        if (r7.optInt("enable_gfx_monitor", 0) != 1) goto L22;
        boolean r11 = true;
    L23:
        this.f5405a.d(r11);
        this.f5405a.a(r7.optInt("block_monitor_mode", 1001));
        if (r7.optInt("serious_block_enable_upload", 1) != 1) goto L26;
        boolean r12 = true;
    L27:
        this.f5405a.e(r12);
        this.f5405a.b(r7.optLong("serious_block_threshold", 4000));
        if (r7.optInt("slow_method_enable_upload", 1) != 1) goto L30;
        boolean r13 = true;
    L31:
        this.f5405a.f(r13);
        if (r7.optInt("drop_enable_upload", 1) != 1) goto L34;
        boolean r14 = true;
    L35:
        this.f5405a.g(r14);
        if (r7.optInt("enable_upload", 0) != 1) goto L38;
        boolean r15 = true;
    L39:
        this.f5405a.h(r15);
        this.f5405a.c(r7.optLong("block_threshold", EntityContentProvider.g));
        this.f5405a.d(r7.optLong("drop_threshold", 1000));
        if (r7.optInt("block_enable_upload", 0) != 1) goto L42;
        r0 = true;
    L42:
        this.f5405a.i(r0);
        this.f5405a.j(r7.optBoolean("drop_slow_method_switch", true));
        this.f5405a.a(r7.optJSONObject("scene_enable_upload"));
        com.bytedance.apm.g.a().a(a());
        return;
    L38:
        r15 = false;
        goto L39
    L34:
        r14 = false;
        goto L35
    L30:
        r13 = false;
        goto L31
    L26:
        r12 = false;
        goto L27
    L22:
        r11 = false;
        goto L23
    L18:
        r10 = false;
        goto L19
    L14:
        r9 = false;
        goto L15
    L10:
        r8 = false;
        goto L11
    }
}
