package com.bytedance.ai.widget.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader", f = "WidgetResourceLoader.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {144, 156}, m = "loadWidget$suspendImpl", n = {"$this", "versionTag", "deferredKey", "deferred", "$this", "deferredKey", "deferred"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
public final class WidgetResourceLoader$loadWidget$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetResourceLoader this$0;

    public WidgetResourceLoader$loadWidget$1(WidgetResourceLoader r100, Continuation<? super WidgetResourceLoader$loadWidget$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return WidgetResourceLoader.n(this.this$0, this);
    }
}
