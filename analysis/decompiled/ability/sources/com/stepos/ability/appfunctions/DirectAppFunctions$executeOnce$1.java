package com.stepos.ability.appfunctions;

import J7.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.appfunctions.DirectAppFunctions", f = "DirectAppFunctions.kt", l = {1326}, m = "executeOnce-BWLJW6A", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DirectAppFunctions$executeOnce$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DirectAppFunctions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectAppFunctions$executeOnce$1(DirectAppFunctions directAppFunctions, H7.c<? super DirectAppFunctions$executeOnce$1> cVar) {
        super(cVar);
        this.this$0 = directAppFunctions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7334executeOnceBWLJW6A = this.this$0.m7334executeOnceBWLJW6A(null, null, null, this);
        return objM7334executeOnceBWLJW6A == CoroutineSingletons.f4909a ? objM7334executeOnceBWLJW6A : new Result(objM7334executeOnceBWLJW6A);
    }
}
