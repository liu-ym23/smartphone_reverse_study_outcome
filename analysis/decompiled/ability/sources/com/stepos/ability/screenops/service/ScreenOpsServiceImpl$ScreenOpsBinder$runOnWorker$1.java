package com.stepos.ability.screenops.service;

import C7.r;
import S7.k;
import S7.n;
import androidx.appcompat.app.AppCompatDelegate;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder$runOnWorker$1", f = "ScreenOpsServiceImpl.kt", l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Landroid/os/Bundle;", "<anonymous>", "(Lm9/z;)Landroid/os/Bundle;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class ScreenOpsServiceImpl$ScreenOpsBinder$runOnWorker$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3236a;
    public final /* synthetic */ k b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenOpsServiceImpl$ScreenOpsBinder$runOnWorker$1(k kVar, H7.c cVar) {
        super(2, cVar);
        this.b = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ScreenOpsServiceImpl$ScreenOpsBinder$runOnWorker$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((ScreenOpsServiceImpl$ScreenOpsBinder$runOnWorker$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3236a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        this.f3236a = 1;
        Object objInvoke = this.b.invoke(this);
        return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
    }
}
