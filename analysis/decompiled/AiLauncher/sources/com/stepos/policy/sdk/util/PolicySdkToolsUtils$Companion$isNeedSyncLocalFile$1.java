package com.stepos.policy.sdk.util;

import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.policy.sdk.util.PolicySdkToolsUtils$Companion", f = "PolicySdkToolsUtils.kt", l = {481}, m = "isNeedSyncLocalFile")
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PolicySdkToolsUtils.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1(PolicySdkToolsUtils.Companion companion, InterfaceC4014c<? super PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.isNeedSyncLocalFile(null, null, null, this);
    }
}
