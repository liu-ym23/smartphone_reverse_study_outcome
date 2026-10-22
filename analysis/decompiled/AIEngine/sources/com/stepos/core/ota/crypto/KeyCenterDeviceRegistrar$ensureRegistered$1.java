package com.stepos.core.ota.crypto;

import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.crypto.KeyCenterDeviceRegistrar", f = "KeyCenterDeviceRegistrar.kt", l = {231, 42}, m = "ensureRegistered-IoAF18A")
/* loaded from: classes.dex */
public final class KeyCenterDeviceRegistrar$ensureRegistered$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KeyCenterDeviceRegistrar this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyCenterDeviceRegistrar$ensureRegistered$1(KeyCenterDeviceRegistrar keyCenterDeviceRegistrar, b<? super KeyCenterDeviceRegistrar$ensureRegistered$1> bVar) {
        super(bVar);
        this.this$0 = keyCenterDeviceRegistrar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo120ensureRegisteredIoAF18A = this.this$0.mo120ensureRegisteredIoAF18A(this);
        return objMo120ensureRegisteredIoAF18A == CoroutineSingletons.f10059a ? objMo120ensureRegisteredIoAF18A : new Result(objMo120ensureRegisteredIoAF18A);
    }
}
