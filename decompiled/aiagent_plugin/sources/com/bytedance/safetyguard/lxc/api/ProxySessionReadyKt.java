package com.bytedance.safetyguard.lxc.api;

import com.bytedance.safetyguard.lxc.internal.d.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: ProxySessionReady.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxySessionReadyKt {
    public static final Object awaitReady(ProxySession r2, d<? super ProxyReady> r3) {
        ProxySession r4 = (ProxySession) ZeusTransformUtils.wrapperContextForParams(r2, ProxySession.class, "com.obric.aiagent.plugin");
        d<? super ProxyReady> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, aa.class) == false) goto L5;
        aa r0 = (aa) ZeusTransformUtils.preCheckCast(r4, aa.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L10;
        return r0.a(r5);
    L10:
        throw new ProxyReadyUnsupportedException(r4.getSessionId());
    L5:
        r0 = null;
        goto L6
    }
}
