package com.bytedance.ai.monitor.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor$Session", f = "AppletAuthTaskMonitor.kt", i = {}, l = {150}, m = "trackUserWait", n = {}, s = {})
public final class AppletAuthTaskMonitor$Session$trackUserWait$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAuthTaskMonitor.Session this$0;

    public AppletAuthTaskMonitor$Session$trackUserWait$1(AppletAuthTaskMonitor.Session r100, Continuation<? super AppletAuthTaskMonitor$Session$trackUserWait$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, this);
    }
}
