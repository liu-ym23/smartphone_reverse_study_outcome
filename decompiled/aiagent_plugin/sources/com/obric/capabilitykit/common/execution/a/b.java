package com.obric.capabilitykit.common.execution.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f32052b;

    public b() {
        this.f32051a = "";
    }

    public final void a(a r3) {
        this.f32052b = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public final a c() {
        return this.f32052b;
    }
}
