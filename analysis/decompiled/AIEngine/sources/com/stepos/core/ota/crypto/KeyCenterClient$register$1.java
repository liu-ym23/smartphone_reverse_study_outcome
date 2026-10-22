package com.stepos.core.ota.crypto;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.KeyCenterClient", f = "KeyCenterClient.kt", l = {95}, m = "register-BWLJW6A")
/* loaded from: classes.dex */
public final class KeyCenterClient$register$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KeyCenterClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyCenterClient$register$1(KeyCenterClient keyCenterClient, b<? super KeyCenterClient$register$1> bVar) {
        super(bVar);
        this.this$0 = keyCenterClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM129registerBWLJW6A = this.this$0.m129registerBWLJW6A(null, null, null, this);
        return objM129registerBWLJW6A == CoroutineSingletons.f10059a ? objM129registerBWLJW6A : new Result(objM129registerBWLJW6A);
    }
}
