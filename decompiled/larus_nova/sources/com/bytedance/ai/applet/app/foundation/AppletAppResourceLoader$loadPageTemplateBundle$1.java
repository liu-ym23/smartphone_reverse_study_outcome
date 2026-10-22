package com.bytedance.ai.applet.app.foundation;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.foundation.AppletAppResourceLoader", f = "AppletAppResourceLoader.kt", i = {0, 0, 1}, l = {97, 119}, m = "loadPageTemplateBundle-gIAlu-s", n = {"page", "cacheKey", "resourceUrl"}, s = {"L$0", "L$1", "L$0"})
public final class AppletAppResourceLoader$loadPageTemplateBundle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAppResourceLoader this$0;

    public AppletAppResourceLoader$loadPageTemplateBundle$1(AppletAppResourceLoader r100, Continuation<? super AppletAppResourceLoader$loadPageTemplateBundle$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.e(null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
