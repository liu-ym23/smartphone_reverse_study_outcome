package com.bytedance.safetyguard.lxc.internal.e.b;

import com.bytedance.safetyguard.lxc.api.SidecarAuthHandler;
import com.bytedance.safetyguard.lxc.api.SidecarAuthRequest;
import com.bytedance.safetyguard.lxc.api.SidecarAuthResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final class g implements SidecarAuthHandler, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SidecarAuthHandler f10688b;

    public g(int r3, SidecarAuthHandler r4) {
        SidecarAuthHandler r5 = (SidecarAuthHandler) ZeusTransformUtils.wrapperContextForParams(r4, SidecarAuthHandler.class, "com.obric.aiagent.plugin");
        o.e(r5, "delegate");
        this.f10687a = r3;
        this.f10688b = r5;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.b.i
    public int a() {
        return this.f10687a;
    }

    @Override // com.bytedance.safetyguard.lxc.api.SidecarAuthHandler
    public Object handle(SidecarAuthRequest r3, d.c.d<? super SidecarAuthResponse> r4) {
        d.c.d<? super SidecarAuthResponse> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return this.f10688b.handle(r3, r5);
    }
}
