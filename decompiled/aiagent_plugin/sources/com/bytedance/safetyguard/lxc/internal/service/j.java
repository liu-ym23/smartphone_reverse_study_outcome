package com.bytedance.safetyguard.lxc.internal.service;

import android.content.Context;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecarConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SidecarServiceHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j implements ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f11033a = null;

    /* JADX INFO: compiled from: SidecarServiceHost.kt */
    /* synthetic */ class a extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11034a = null;

        static {
            f11034a = new a();
        }

        a() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        public final Long a() {
            return Long.valueOf(System.currentTimeMillis());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    static {
        f11033a = new j();
    }

    private j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.safetyguard.lxc.internal.service.ag
    public SafetyGuardSidecar a(Context r26) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r26, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "context");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        SafetyGuardSidecarConfig r13 = new SafetyGuardSidecarConfig(0, 0, 0, 0, 0, 0, 63, null);
        com.bytedance.safetyguard.lxc.internal.a.a.C0222a r2 = com.bytedance.safetyguard.lxc.internal.a.a.f9703a;
        d.h.b.o.a(r1);
        com.bytedance.safetyguard.lxc.internal.a.a r3 = r2.a(r1);
        com.bytedance.safetyguard.lxc.internal.e.i.a r4 = new com.bytedance.safetyguard.lxc.internal.e.i.a(r1, null, 2, 0 == true ? 1 : 0);
        d.h.a.a r17 = null;
        d.h.a.a r18 = null;
        com.bytedance.safetyguard.lxc.internal.e.a.x r5 = new com.bytedance.safetyguard.lxc.internal.e.a.x(r13.getConnectTimeoutMillis(), r13.getReadTimeoutMillis(), r17, r18, (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin"), null, null, null, 236, null);
        com.bytedance.safetyguard.lxc.internal.e.h.c r6 = new com.bytedance.safetyguard.lxc.internal.e.h.c((com.bytedance.safetyguard.lxc.internal.e.i.b) ZeusTransformUtils.preCheckCast(r4, com.bytedance.safetyguard.lxc.internal.e.i.b.class, "com.obric.aiagent.plugin"), (com.bytedance.safetyguard.lxc.internal.e.a.l) ZeusTransformUtils.preCheckCast(r5, com.bytedance.safetyguard.lxc.internal.e.a.l.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(a.f11034a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        com.bytedance.safetyguard.lxc.internal.e.e.b r19 = null;
        com.bytedance.safetyguard.lxc.internal.e.e.c r8 = new com.bytedance.safetyguard.lxc.internal.e.e.c(r13.getMaxResponseBodyBytes(), r13.getConnectTimeoutMillis(), r13.getReadTimeoutMillis(), (com.bytedance.safetyguard.lxc.internal.b.a) ZeusTransformUtils.preCheckCast(v.f11058a, com.bytedance.safetyguard.lxc.internal.b.a.class, "com.obric.aiagent.plugin"), r19, (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin"), 16, 0 == true ? 1 : 0);
        d.h.a.a r7 = null;
        return (SafetyGuardSidecar) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.e.b.c(r13, r7, (com.bytedance.safetyguard.lxc.internal.e.i.b) ZeusTransformUtils.preCheckCast(r4, com.bytedance.safetyguard.lxc.internal.e.i.b.class, "com.obric.aiagent.plugin"), (com.bytedance.safetyguard.lxc.internal.e.a.l) ZeusTransformUtils.preCheckCast(r5, com.bytedance.safetyguard.lxc.internal.e.a.l.class, "com.obric.aiagent.plugin"), (com.bytedance.safetyguard.lxc.internal.e.h.b) ZeusTransformUtils.preCheckCast(r6, com.bytedance.safetyguard.lxc.internal.e.h.b.class, "com.obric.aiagent.plugin"), r8, (com.bytedance.safetyguard.lxc.internal.a.e) ZeusTransformUtils.preCheckCast(r3, com.bytedance.safetyguard.lxc.internal.a.e.class, "com.obric.aiagent.plugin"), 2, null), SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
    }
}
