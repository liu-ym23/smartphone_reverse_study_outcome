package com.stepos.policy.sdk.util;

import com.stepos.policy.sdk.util.PolicySdkToolsUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.stepos.policy.sdk.util.PolicySdkToolsUtils$Companion", f = "PolicySdkToolsUtils.kt", i = {0, 0, 0}, l = {472}, m = "isNeedSyncLocalFile", n = {"newestPolicyPath", "localMd5", "isNeedSyncLocalFile"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes.dex */
public final class PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PolicySdkToolsUtils.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1(PolicySdkToolsUtils.Companion companion, Continuation<? super PolicySdkToolsUtils$Companion$isNeedSyncLocalFile$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.isNeedSyncLocalFile(null, null, null, this);
    }
}
