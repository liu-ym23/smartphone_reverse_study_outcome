package com.stepos.ability.screenops.service;

import C7.r;
import S7.k;
import android.os.Bundle;
import com.stepos.ability.screenops.service.ScreenOpsServiceImpl;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "com.stepos.ability.screenops.service.ScreenOpsServiceImpl$ScreenOpsBinder$getEditContent$1", f = "ScreenOpsServiceImpl.kt", l = {105}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenOpsServiceImpl$ScreenOpsBinder$getEditContent$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f3232a;
    public final /* synthetic */ ScreenOpsServiceImpl.ScreenOpsBinder b;
    public final /* synthetic */ Bundle c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenOpsServiceImpl$ScreenOpsBinder$getEditContent$1(ScreenOpsServiceImpl.ScreenOpsBinder screenOpsBinder, Bundle bundle, H7.c cVar) {
        super(1, cVar);
        this.b = screenOpsBinder;
        this.c = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new ScreenOpsServiceImpl$ScreenOpsBinder$getEditContent$1(this.b, this.c, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((ScreenOpsServiceImpl$ScreenOpsBinder$getEditContent$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3232a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        Bundle bundle = this.c;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f3232a = 1;
        Object objPerformGetTextList = this.b.performGetTextList(bundle, this);
        return objPerformGetTextList == coroutineSingletons ? coroutineSingletons : objPerformGetTextList;
    }
}
