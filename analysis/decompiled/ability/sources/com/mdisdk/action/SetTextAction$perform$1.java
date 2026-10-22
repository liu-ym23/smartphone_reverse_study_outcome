package com.mdisdk.action;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.mdisdk.action.SetTextAction", f = "SetTextAction.kt", l = {34}, m = "perform$mdisdk_release")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SetTextAction$perform$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SetTextAction this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetTextAction$perform$1(SetTextAction setTextAction, H7.c<? super SetTextAction$perform$1> cVar) {
        super(cVar);
        this.this$0 = setTextAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.perform$mdisdk_release(null, this);
    }
}
