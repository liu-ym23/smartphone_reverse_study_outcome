package com.obric.aiagent.executionengine.scheduler.impl.b;

import com.obric.capabilitykit.common.AppAction;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppIntentExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.capabilitymanager.api.a.a f18359b = null;

    private d() {
    }

    static {
        f18358a = new d();
        f18359b = com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16401c;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.b.f
    public com.obric.aiagent.executionengine.capabilitymanager.api.a.a getType() {
        return f18359b;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.b.f
    public Object a(AppAction r7, com.obric.aiagent.executionengine.scheduler.impl.job.c r8, long r9, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r11) {
        d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a.a(r7, r8, r9, r5);
    }
}
