package com.stepos.core.ability.speech;

import com.stepos.core.ability.speech.AsrMultiFilesPipeline;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.core.ability.speech.AsrMultiFilesPipeline$runCloudMultiFiles$1", f = "AsrMultiFilesPipeline.kt", l = {73}, m = "invokeSuspend$drain")
/* loaded from: classes.dex */
public final class AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$1(qb.b<? super AsrMultiFilesPipeline$runCloudMultiFiles$1$drain$1> bVar) {
        super(bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AsrMultiFilesPipeline.C03201.invokeSuspend$drain(null, null, null, null, null, null, null, null, null, null, null, null, this);
    }
}
