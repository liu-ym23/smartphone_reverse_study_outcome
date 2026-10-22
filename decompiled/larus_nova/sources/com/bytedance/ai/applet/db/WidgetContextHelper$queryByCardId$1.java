package com.bytedance.ai.applet.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.db.WidgetContextHelper", f = "WidgetContextHelper.kt", i = {0}, l = {79}, m = "queryByCardId", n = {"cardId"}, s = {"L$0"})
public final class WidgetContextHelper$queryByCardId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WidgetContextHelper this$0;

    public WidgetContextHelper$queryByCardId$1(WidgetContextHelper r100, Continuation<? super WidgetContextHelper$queryByCardId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        WidgetContextHelper r101 = this.this$0;
        WidgetContextHelper r102 = WidgetContextHelper.f34570a;
        return r101.c(null, this);
    }
}
