package com.bytedance.ai.widget.contianer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.WidgetContainer", f = "WidgetContainer.kt", i = {0}, l = {726}, m = "getWidget", n = {"widgetContainerData"}, s = {"L$0"})
final class WidgetContainer$getWidget$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetContainer this$0;

    public WidgetContainer$getWidget$1(WidgetContainer r100, Continuation<? super WidgetContainer$getWidget$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return WidgetContainer.p(this.this$0, null, this);
    }
}
