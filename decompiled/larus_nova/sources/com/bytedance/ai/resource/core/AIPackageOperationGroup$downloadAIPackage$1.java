package com.bytedance.ai.resource.core;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup", f = "AIPackageOperationGroup.kt", i = {0, 0, 0}, l = {581}, m = "downloadAIPackage", n = {"deploymentInfo", WikiFolderPushPlugin.OPT, "errorCode"}, s = {"L$0", "L$1", "I$0"})
final class AIPackageOperationGroup$downloadAIPackage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$downloadAIPackage$1(AIPackageOperationGroup r100, Continuation<? super AIPackageOperationGroup$downloadAIPackage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return AIPackageOperationGroup.a(this.this$0, null, null, this);
    }
}
