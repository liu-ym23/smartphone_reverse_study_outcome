package com.stepos.policy.sdk.util;

import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@rb.c(c = "com.stepos.policy.sdk.util.PolicySdkToolsUtils$Companion", f = "PolicySdkToolsUtils.kt", l = {481}, m = "isNeedSyncLocalFile")
/* loaded from: classes.dex */
public final class PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PolicySdkToolsUtils.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1(PolicySdkToolsUtils.Companion companion, qb.b<? super PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1> bVar) {
        super(bVar);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.isNeedSyncLocalFile(null, null, null, this);
    }
}
