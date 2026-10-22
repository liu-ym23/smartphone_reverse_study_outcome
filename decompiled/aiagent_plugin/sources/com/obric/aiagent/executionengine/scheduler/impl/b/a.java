package com.obric.aiagent.executionengine.scheduler.impl.b;

import com.obric.capabilitykit.common.AppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppFunctionDslExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.capabilitymanager.api.a.a f18345b = null;

    private a() {
    }

    static {
        f18344a = new a();
        f18345b = com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16399a;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.b.f
    public com.obric.aiagent.executionengine.capabilitymanager.api.a.a getType() {
        return f18345b;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.b.f
    public Object a(AppAction r7, com.obric.aiagent.executionengine.scheduler.impl.job.c r8, long r9, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r11) {
        d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl.b.f18159a.a(r7, r8, r9, r5);
    }
}
