package com.bytedance.safetyguard.lxc.internal;

import android.content.Context;
import com.bytedance.safetyguard.lxc.api.SafetyGuard;
import com.bytedance.safetyguard.lxc.api.SafetyGuardLogger;
import com.bytedance.safetyguard.lxc.internal.a.e;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: SafetyGuardInstanceProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static final String TAG = "SafetyGuardInstanceProvider";

    /* JADX INFO: compiled from: SafetyGuardInstanceProvider.kt */
    static final class a extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SafetyGuard f9806b;

        a(String r3, SafetyGuard r4) {
            SafetyGuard r5 = (SafetyGuard) ZeusTransformUtils.wrapperContextForParams(r4, SafetyGuard.class, "com.obric.aiagent.plugin");
            this.f9805a = r3;
            this.f9806b = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }

        public final String a() {
            return "component=sdk event=initialized outcome=success logger=" + this.f9805a + " sidecarVersion=" + this.f9806b.getSidecar().getVersion();
        }
    }

    public static final SafetyGuard a(Context r4, SafetyGuardLogger r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        SafetyGuardLogger r7 = (SafetyGuardLogger) ZeusTransformUtils.wrapperContextForParams(r5, SafetyGuardLogger.class, "com.obric.aiagent.plugin");
        o.e(r6, "appContext");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "getApplicationContext(...)");
        e r8 = com.bytedance.safetyguard.lxc.internal.a.c.a(r0, r7);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r9, "getApplicationContext(...)");
        return (SafetyGuard) ZeusTransformUtils.preCheckCast(new com.bytedance.safetyguard.lxc.internal.a(r9, r8), SafetyGuard.class, "com.obric.aiagent.plugin");
    }

    public static final void a(Context r2, SafetyGuard r3, SafetyGuardLogger r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        SafetyGuard r6 = (SafetyGuard) ZeusTransformUtils.wrapperContextForParams(r3, SafetyGuard.class, "com.obric.aiagent.plugin");
        SafetyGuardLogger r7 = (SafetyGuardLogger) ZeusTransformUtils.wrapperContextForParams(r4, SafetyGuardLogger.class, "com.obric.aiagent.plugin");
        o.e(r5, "appContext");
        o.e(r6, "instance");
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r8, "getApplicationContext(...)");
        e r9 = com.bytedance.safetyguard.lxc.internal.a.c.a(r8, r7);
        if (r7 != null) goto L5;
        String r10 = "android";
    L6:
        r9.b(TAG, (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r10, r6), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r10 = MonitorConstants.CUSTOM;
        goto L6
    }
}
