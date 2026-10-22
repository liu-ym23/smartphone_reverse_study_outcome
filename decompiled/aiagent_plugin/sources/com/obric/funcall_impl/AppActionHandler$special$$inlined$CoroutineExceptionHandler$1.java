package com.obric.funcall_impl;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a;
import d.c.g;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppActionHandler$special$$inlined$CoroutineExceptionHandler$1 extends a implements CoroutineExceptionHandler {
    public AppActionHandler$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a r3) {
        super((g.c) ZeusTransformUtils.preCheckCast(r3, g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(g r2, Throwable r3) {
        g r1 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e("AppActionHandler", "error , msg = " + d.a.a(r3));
    }
}
