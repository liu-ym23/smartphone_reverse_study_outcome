package com.bytedance.safetyguard.lxc.internal;

import android.content.Context;
import com.bytedance.safetyguard.lxc.api.SafetyGuard;
import com.bytedance.safetyguard.lxc.api.SafetyGuardProxyConfig;
import com.bytedance.safetyguard.lxc.api.SafetyGuardProxyRuntime;
import com.bytedance.safetyguard.lxc.api.sidecar.SafetyGuardSidecar;
import com.bytedance.safetyguard.lxc.internal.a.e;
import com.bytedance.safetyguard.lxc.internal.client.ProxyServiceConnector;
import com.bytedance.safetyguard.lxc.internal.client.s;
import com.bytedance.safetyguard.lxc.internal.client.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DefaultSafetyGuard.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements SafetyGuard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f9699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f9700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ProxyServiceConnector f9701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SafetyGuardSidecar f9702d;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r18, e r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        e r14 = (e) ZeusTransformUtils.wrapperContextForParams(r19, e.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r14, "logger");
        this.f9699a = r14;
        Context r5 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f9700b = r5;
        o.c(r5, "appContext");
        ProxyServiceConnector r2 = new ProxyServiceConnector(r5, null, null, null, null, null, null, 0, r14, 254, null);
        this.f9701c = r2;
        Object[] r8 = 0 == true ? 1 : 0;
        Object[] r9 = 0 == true ? 1 : 0;
        this.f9702d = (SafetyGuardSidecar) ZeusTransformUtils.preCheckCast(new t(r2, r8, r9, 6, 0 == true ? 1 : 0), SafetyGuardSidecar.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.safetyguard.lxc.api.SafetyGuard
    public SafetyGuardSidecar getSidecar() {
        return this.f9702d;
    }

    @Override // com.bytedance.safetyguard.lxc.api.SafetyGuard
    public SafetyGuardProxyRuntime createProxyRuntime(SafetyGuardProxyConfig r3) {
        o.e(r3, "config");
        return (SafetyGuardProxyRuntime) ZeusTransformUtils.preCheckCast(new s(this.f9701c, r3, this.f9699a), SafetyGuardProxyRuntime.class, "com.obric.aiagent.plugin");
    }
}
