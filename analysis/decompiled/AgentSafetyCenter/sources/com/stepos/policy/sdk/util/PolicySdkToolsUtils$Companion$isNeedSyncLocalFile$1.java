package com.stepos.policy.sdk.util;

import com.stepos.policy.sdk.util.PolicySdkToolsUtils;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@pb.e(c = "com.stepos.policy.sdk.util.PolicySdkToolsUtils$Companion", f = "PolicySdkToolsUtils.kt", l = {472}, m = "isNeedSyncLocalFile")
/* loaded from: classes.dex */
public final class PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1 extends pb.c {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PolicySdkToolsUtils.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1(PolicySdkToolsUtils.Companion companion, nb.c cVar) {
        super(cVar);
        this.this$0 = companion;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.isNeedSyncLocalFile(null, null, null, this);
    }
}
