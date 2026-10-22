package com.bytedance.ai.resource.core.operations;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.AIPackageUpdateOperation", f = "AIPackageUpdateOperation.kt", i = {0}, l = {58}, m = "updateAIPackage", n = {"aiPackage"}, s = {"L$0"})
public final class AIPackageUpdateOperation$updateAIPackage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageUpdateOperation this$0;

    public AIPackageUpdateOperation$updateAIPackage$1(AIPackageUpdateOperation r100, Continuation<? super AIPackageUpdateOperation$updateAIPackage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m(this);
    }
}
