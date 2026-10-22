package com.mdisdk.action;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.InterfaceC1733z;

@c(c = "com.mdisdk.action.OpenAppAction$perform$3", f = "OpenAppAction.kt", l = {51}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes3.dex */
public final class OpenAppAction$perform$3 extends SuspendLambda implements n {
    final /* synthetic */ InterfaceC1723p $deferred;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenAppAction$perform$3(InterfaceC1723p interfaceC1723p, H7.c<? super OpenAppAction$perform$3> cVar) {
        super(2, cVar);
        this.$deferred = interfaceC1723p;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new OpenAppAction$perform$3(this.$deferred, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
        b.b(obj);
        InterfaceC1723p interfaceC1723p = this.$deferred;
        this.label = 1;
        Object objZ = ((C1724q) interfaceC1723p).z(this);
        return objZ == coroutineSingletons ? coroutineSingletons : objZ;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
        return ((OpenAppAction$perform$3) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
