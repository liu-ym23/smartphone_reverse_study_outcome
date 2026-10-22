package com.obric.aiagent.executionengine.capabilitymanager.publish;

import com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.n;
import d.o;
import d.x;

/* JADX INFO: compiled from: IntentInfoManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentInfoManagerService implements IIntentInfoManagerApi {

    /* JADX INFO: compiled from: IntentInfoManager.kt */
    @f(b = "IntentInfoManager.kt", c = {35}, d = "queryIntentInfo", e = "com.obric.aiagent.executionengine.capabilitymanager.publish.IntentInfoManagerService")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntentInfoManagerService f16518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16519c;

        a(IntentInfoManagerService r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16518b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16517a = r3;
            this.f16519c |= Integer.MIN_VALUE;
            return this.f16518b.queryIntentInfo(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public IntentInfoManagerService() {
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi
    public void init() {
        com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a.a();
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi
    public Object queryIntentInfo(String r6, d.c.d<? super com.obric.aiagent.executionengine.capabilitymanager.api.publish.a> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
        if ((r0.f16519c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16519c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f16517a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16519c;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        o.a(r9);     // Catch: Throwable -> L21
    L19:
        Object r5 = n.f((com.obric.aiagent.executionengine.capabilitymanager.api.publish.a) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.executionengine.capabilitymanager.api.publish.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
    L24:
        if (n.b(r5) == false) goto L29;
        return null;
    L29:
        return r5;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        o.a(r9);
        n.a r10 = n.f38560a;     // Catch: Throwable -> L21
        IntentInfoManagerService r11 = (IntentInfoManagerService) ZeusTransformUtils.preCheckCast(this, IntentInfoManagerService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        com.obric.aiagent.executionengine.capabilitymanager.publish.a r12 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a;     // Catch: Throwable -> L21
        r0.f16519c = 1;     // Catch: Throwable -> L21
        r9 = r12.a(r6, r0);     // Catch: Throwable -> L21
        if (r9 != r2) goto L19;
        return r2;
    L21:
        th = move-exception;
        n.a r13 = n.f38560a;
        r5 = n.f(o.a(th));
    L7:
        r0 = new a(this, r8);
        goto L8
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi
    public Object scanIntentsForAllPackage(d.c.d<? super x> r2) {
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        Object r3 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a.a(r1);
        if (r3 != d.c.a.b.a()) goto L6;
        return r3;
    L6:
        return x.f38692a;
    }
}
