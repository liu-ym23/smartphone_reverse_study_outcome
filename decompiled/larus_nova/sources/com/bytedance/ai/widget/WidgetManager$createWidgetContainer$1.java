package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.WidgetManager", f = "WidgetManager.kt", i = {0}, l = {406}, m = "createWidgetContainer", n = {"widgetContainer"}, s = {"L$0"})
public final class WidgetManager$createWidgetContainer$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetManager this$0;

    public WidgetManager$createWidgetContainer$1(WidgetManager r100, Continuation<? super WidgetManager$createWidgetContainer$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        WidgetManager r101 = this.this$0;
        WidgetManager.a r102 = WidgetManager.f37917h;
        return r101.j(null, this);
    }
}
