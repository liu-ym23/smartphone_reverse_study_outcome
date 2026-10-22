package com.stepos.core.ota.adapter;

import com.stepos.core.ota.adapter.Fetch2ModelDownloadPort;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot$awaitStopped$2", f = "Fetch2ModelDownloadPort.kt", l = {316}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Fetch2ModelDownloadPort$Slot$awaitStopped$2 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
    int label;
    final /* synthetic */ Fetch2ModelDownloadPort.Slot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fetch2ModelDownloadPort$Slot$awaitStopped$2(Fetch2ModelDownloadPort.Slot slot, b<? super Fetch2ModelDownloadPort$Slot$awaitStopped$2> bVar) {
        super(2, bVar);
        this.this$0 = slot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        return new Fetch2ModelDownloadPort$Slot$awaitStopped$2(this.this$0, bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.c.b(obj);
            CompletableDeferred completableDeferred = this.this$0.stopped;
            this.label = 1;
            if (completableDeferred.await(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
        }
        return n.f10413a;
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
        return ((Fetch2ModelDownloadPort$Slot$awaitStopped$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }
}
