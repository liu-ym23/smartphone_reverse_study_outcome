package com.bytedance.ai.applet.render.core.lynx;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.render.core.lynx.LynxRenderView", f = "LynxRenderView.kt", i = {0, 0}, l = {110}, m = "loadUrl", n = {"url", "data"}, s = {"L$0", "L$1"})
public final class LynxRenderView$loadUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LynxRenderView this$0;

    public LynxRenderView$loadUrl$1(LynxRenderView r100, Continuation<? super LynxRenderView$loadUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, this);
    }
}
