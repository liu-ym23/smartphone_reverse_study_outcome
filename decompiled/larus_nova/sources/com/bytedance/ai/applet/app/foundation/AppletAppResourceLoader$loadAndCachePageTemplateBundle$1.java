package com.bytedance.ai.applet.app.foundation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.foundation.AppletAppResourceLoader", f = "AppletAppResourceLoader.kt", i = {0, 0, 0, 0, 1, 1}, l = {187, 153}, m = "loadAndCachePageTemplateBundle", n = {"page", "cacheKey", "resourceUrl", "$this$withLock_u24default$iv", "cacheKey", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
public final class AppletAppResourceLoader$loadAndCachePageTemplateBundle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAppResourceLoader this$0;

    public AppletAppResourceLoader$loadAndCachePageTemplateBundle$1(AppletAppResourceLoader r100, Continuation<? super AppletAppResourceLoader$loadAndCachePageTemplateBundle$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AppletAppResourceLoader r101 = this.this$0;
        int r102 = AppletAppResourceLoader.f34174f;
        return r101.c(null, null, null, this);
    }
}
