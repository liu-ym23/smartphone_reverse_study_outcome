package com.stepos.core.ota.adapter;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.RemoteModelActivator", f = "RemoteModelActivator.kt", l = {74}, m = "activate-yxL6bBk")
/* loaded from: classes.dex */
public final class RemoteModelActivator$activate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteModelActivator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteModelActivator$activate$1(RemoteModelActivator remoteModelActivator, b<? super RemoteModelActivator$activate$1> bVar) {
        super(bVar);
        this.this$0 = remoteModelActivator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo115activateyxL6bBk = this.this$0.mo115activateyxL6bBk(null, 0, null, null, this);
        return objMo115activateyxL6bBk == CoroutineSingletons.f10059a ? objMo115activateyxL6bBk : new Result(objMo115activateyxL6bBk);
    }
}
