package com.stepos.core.ota.adapter;

import com.stepos.core.ota.adapter.Fetch2ModelDownloadPort;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import qb.b;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot", f = "Fetch2ModelDownloadPort.kt", l = {316}, m = "awaitStopped")
/* loaded from: classes.dex */
public final class Fetch2ModelDownloadPort$Slot$awaitStopped$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Fetch2ModelDownloadPort.Slot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Fetch2ModelDownloadPort$Slot$awaitStopped$1(Fetch2ModelDownloadPort.Slot slot, b<? super Fetch2ModelDownloadPort$Slot$awaitStopped$1> bVar) {
        super(bVar);
        this.this$0 = slot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.awaitStopped(0L, this);
    }
}
