package com.stepos.ability.appfunctions;

import J7.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.appfunctions.JetpackAppFunctions", f = "JetpackAppFunctions.kt", l = {129}, m = "execute-BWLJW6A", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JetpackAppFunctions$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ JetpackAppFunctions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JetpackAppFunctions$execute$1(JetpackAppFunctions jetpackAppFunctions, H7.c<? super JetpackAppFunctions$execute$1> cVar) {
        super(cVar);
        this.this$0 = jetpackAppFunctions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7337executeBWLJW6A = this.this$0.m7337executeBWLJW6A(null, null, null, this);
        return objM7337executeBWLJW6A == CoroutineSingletons.f4909a ? objM7337executeBWLJW6A : new Result(objM7337executeBWLJW6A);
    }
}
