package com.bytedance.ai.resource.core.operations;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.operations.AIPackageUninstallOperation", f = "AIPackageUnInstallOperation.kt", i = {}, l = {31}, m = "run", n = {}, s = {})
public final class AIPackageUninstallOperation$run$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageUninstallOperation this$0;

    public AIPackageUninstallOperation$run$1(AIPackageUninstallOperation r100, Continuation<? super AIPackageUninstallOperation$run$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(this);
    }
}
