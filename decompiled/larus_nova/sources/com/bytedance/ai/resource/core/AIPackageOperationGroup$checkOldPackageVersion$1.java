package com.bytedance.ai.resource.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup", f = "AIPackageOperationGroup.kt", i = {}, l = {525}, m = "checkOldPackageVersion", n = {}, s = {})
public final class AIPackageOperationGroup$checkOldPackageVersion$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$checkOldPackageVersion$1(AIPackageOperationGroup r100, Continuation<? super AIPackageOperationGroup$checkOldPackageVersion$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, false, this);
    }
}
