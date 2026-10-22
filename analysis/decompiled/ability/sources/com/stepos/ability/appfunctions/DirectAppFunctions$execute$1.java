package com.stepos.ability.appfunctions;

import J7.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.appfunctions.DirectAppFunctions", f = "DirectAppFunctions.kt", l = {1136, 1144}, m = "execute-yxL6bBk", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DirectAppFunctions$execute$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DirectAppFunctions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectAppFunctions$execute$1(DirectAppFunctions directAppFunctions, H7.c<? super DirectAppFunctions$execute$1> cVar) {
        super(cVar);
        this.this$0 = directAppFunctions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7336executeyxL6bBk = this.this$0.m7336executeyxL6bBk(null, null, null, 0, this);
        return objM7336executeyxL6bBk == CoroutineSingletons.f4909a ? objM7336executeyxL6bBk : new Result(objM7336executeyxL6bBk);
    }
}
