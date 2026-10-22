package com.bytedance.applet.aibridge.baidunavi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.baidunavi.NavigationCallback$Companion", f = "NavigationCallback.kt", i = {0}, l = {44}, m = "updateParams", n = {"params"}, s = {"L$0"})
public final class NavigationCallback$Companion$updateParams$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NavigationCallback.Companion this$0;

    public NavigationCallback$Companion$updateParams$1(NavigationCallback.Companion r100, Continuation<? super NavigationCallback$Companion$updateParams$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
