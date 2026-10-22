package com.obric.aikernel.phx.sdk;

import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.d;
import d.h.b.o;
import d.n;
import d.x;

/* JADX INFO: compiled from: AIKernelManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AIKernelManager implements IAIKernelManager {
    public static final AIKernelManager INSTANCE = null;
    private static final AIKernelApi instance = null;

    private AIKernelManager() {
    }

    static {
        INSTANCE = new AIKernelManager();
        instance = new AIKernelApi();
    }

    public final AIKernelApi getInstance$sdk_release() {
        return instance;
    }

    public final void init(AIKernelConfig r3) {
        o.e(r3, "config");
        AIKernelApi.init$default(instance, r3, null, 2, null);
    }

    public static /* synthetic */ void init$default(AIKernelManager r1, AIKernelConfig r2, ILog r3, int r4, Object r5) {
        ILog r6 = (ILog) ZeusTransformUtils.wrapperContextForParams(r3, ILog.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.init(r2, r6);
    }

    public final void init(AIKernelConfig r2, ILog r3) {
        ILog r1 = (ILog) ZeusTransformUtils.wrapperContextForParams(r3, ILog.class, "com.obric.aiagent.plugin");
        o.e(r2, "config");
        instance.init(r2, r1);
    }

    public final void registerLog(ILog r2) {
        ILog r1 = (ILog) ZeusTransformUtils.wrapperContextForParams(r2, ILog.class, "com.obric.aiagent.plugin");
        o.e(r1, "inst");
        AIKLog.INSTANCE.registerLog(r1);
    }

    public final IAIKernelManager invoke() {
        return (IAIKernelManager) ZeusTransformUtils.preCheckCast(this, IAIKernelManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE, reason: not valid java name */
    public Object mo393getPackage0E7RQCE(String r5, RequestParams r6, d<? super n<PackageResource>> r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AIKernelManager$getPackage$1.class) == false) goto L7;
        AIKernelManager$getPackage$1 r0 = (AIKernelManager$getPackage$1) ZeusTransformUtils.preCheckCast(r8, AIKernelManager$getPackage$1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.result;
        Object r9 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r4);
        return ((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        AIKernelApi r10 = instance;
        r0.label = 1;
        Object r11 = r10.mo393getPackage0E7RQCE(r5, r6, r0);
        if (r11 != r9) goto L18;
        return r9;
    L18:
        return r11;
    L7:
        r0 = new AIKernelManager$getPackage$1(this, r8);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE, reason: not valid java name */
    public Object mo394updatePackage0E7RQCE(PackageResource r5, RequestParams r6, d<? super n<PackageResource>> r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AIKernelManager$updatePackage$1.class) == false) goto L7;
        AIKernelManager$updatePackage$1 r0 = (AIKernelManager$updatePackage$1) ZeusTransformUtils.preCheckCast(r8, AIKernelManager$updatePackage$1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.result;
        Object r9 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r4);
        return ((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        AIKernelApi r10 = instance;
        r0.label = 1;
        Object r11 = r10.mo394updatePackage0E7RQCE(r5, r6, r0);
        if (r11 != r9) goto L18;
        return r9;
    L18:
        return r11;
    L7:
        r0 = new AIKernelManager$updatePackage$1(this, r8);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object loadPackage(String r2, boolean r3, RequestParams r4, d<? super IBaseModel> r5) {
        d<? super IBaseModel> r1 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return instance.loadPackage(r2, r3, r4, r1);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object clearAIKernelData(RequestParams r2, d<? super x> r3) {
        d<? super x> r1 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        Object r4 = instance.clearAIKernelData(r2, r1);
        if (r4 != b.a()) goto L6;
        return r4;
    L6:
        return x.f38692a;
    }
}
