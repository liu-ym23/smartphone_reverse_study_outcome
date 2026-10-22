package com.bytedance.ai.lite.widget.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.lite.widget.cache.LiteWidgetResourceLoader", f = "LiteWidgetResourceLoader.kt", i = {}, l = {76}, m = "loadTemplateBundleFromPackage", n = {}, s = {})
public final class LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiteWidgetResourceLoader this$0;

    public LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1(LiteWidgetResourceLoader r100, Continuation<? super LiteWidgetResourceLoader$loadTemplateBundleFromPackage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(this);
    }
}
