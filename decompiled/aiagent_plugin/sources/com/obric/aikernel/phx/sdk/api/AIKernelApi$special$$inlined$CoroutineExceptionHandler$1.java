package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.core.log.AIKLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a;
import d.c.g;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AIKernelApi$special$$inlined$CoroutineExceptionHandler$1 extends a implements CoroutineExceptionHandler {
    public AIKernelApi$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a r3) {
        super((g.c) ZeusTransformUtils.preCheckCast(r3, g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(g r2, Throwable r3) {
        AIKLog.INSTANCE.e(AIKernelApi.TAG, ((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin")) + " crashed " + r3);
    }
}
