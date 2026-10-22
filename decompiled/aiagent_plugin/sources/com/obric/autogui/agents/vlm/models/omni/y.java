package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.au;

/* JADX INFO: compiled from: OmniSession.kt */
/* JADX INFO: loaded from: classes3.dex */
final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final au<Boolean> f28893b;

    public y(String r3, au<Boolean> r4) {
        au<Boolean> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r4, au.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "screenshotStepId");
        d.h.b.o.e(r5, "result");
        this.f28892a = r3;
        this.f28893b = r5;
    }

    public final String a() {
        return this.f28892a;
    }

    public final au<Boolean> b() {
        return this.f28893b;
    }
}
