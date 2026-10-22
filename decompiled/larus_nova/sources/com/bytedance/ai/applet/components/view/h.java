package com.bytedance.ai.applet.components.view;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.lynx.tasm.q1;

/* JADX INFO: loaded from: classes43.dex */
public final class h extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAISDKDebugService.d f34564a;

    @Override // com.lynx.tasm.q1
    public final void onLynxViewAndJSRuntimeDestroy() {
        IAISDKDebugService.f36186a.D(this.f34564a);
    }

    public h(IAISDKDebugService.d r100) {
        this.f34564a = r100;
    }
}
