package com.stepos.policy.sdk.widget;

import android.view.View;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.policy.sdk.widget.PolicySDKLoadDataView$setDebounceClickListener$1$1", f = "PolicySDKLoadDataView.kt", l = {157}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicySDKLoadDataView$setDebounceClickListener$1$1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
    final /* synthetic */ View $it;
    final /* synthetic */ View.OnClickListener $listener;
    final /* synthetic */ long $time;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView$setDebounceClickListener$1$1(long j10, View.OnClickListener onClickListener, View view, b<? super PolicySDKLoadDataView$setDebounceClickListener$1$1> bVar) {
        super(2, bVar);
        this.$time = j10;
        this.$listener = onClickListener;
        this.$it = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new PolicySDKLoadDataView$setDebounceClickListener$1$1(this.$time, this.$listener, this.$it, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            long j10 = this.$time;
            this.label = 1;
            if (DelayKt.delay(j10, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        this.$listener.onClick(this.$it);
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((PolicySDKLoadDataView$setDebounceClickListener$1$1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
