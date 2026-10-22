package com.stepos.policy.sdk;

import com.stepos.policy.sdk.util.PolicySdkLogUtils;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes.dex */
public final class S extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        PolicySdkLogUtils.INSTANCE.d("exceptionHandler", coroutineContext.get(Z2.E.f2164b) + " 处理异常 ：" + th);
    }
}
