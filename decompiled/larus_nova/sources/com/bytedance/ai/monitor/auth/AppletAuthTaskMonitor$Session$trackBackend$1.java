package com.bytedance.ai.monitor.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.monitor.auth.AppletAuthTaskMonitor$Session", f = "AppletAuthTaskMonitor.kt", i = {0}, l = {159}, m = "trackBackend", n = {"start"}, s = {"J$0"})
public final class AppletAuthTaskMonitor$Session$trackBackend$1<T> extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAuthTaskMonitor.Session this$0;

    public AppletAuthTaskMonitor$Session$trackBackend$1(AppletAuthTaskMonitor.Session r100, Continuation<? super AppletAuthTaskMonitor$Session$trackBackend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
