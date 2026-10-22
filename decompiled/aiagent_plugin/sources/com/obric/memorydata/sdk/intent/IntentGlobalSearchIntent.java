package com.obric.memorydata.sdk.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.BasePCIntentGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCIntentGlobalSearchParams;
import com.obric.memorydata.sdk.MemoryResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: IntentGlobalSearchIntent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IntentGlobalSearchIntent extends BasePCIntentGlobalSearchIntent {
    private final AppIntentImplInfo getDispatchIntentImplInfo() {
        return null;
    }

    public IntentGlobalSearchIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCIntentGlobalSearchIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((PCIntentGlobalSearchParams) ZeusTransformUtils.preCheckCast(r6, PCIntentGlobalSearchParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCIntentGlobalSearchIntent
    public Object doAction(PCIntentGlobalSearchParams r16, DispatchContext r17, d<? super IntentResult<Empty>> r18) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r18, d.class, "com.obric.aiagent.plugin");
        if (getDispatchIntentImplInfo() != null) goto L11;
        MemoryResponse<IntentResult<Empty>> r1 = com.obric.memorydata.sdk.a.f33793a.a(r16, r17);
        IntentResult r2 = (IntentResult) ZeusTransformUtils.preCheckCast(r1.getData(), IntentResult.class, "com.obric.aiagent.plugin");
        if (r1.getCode() != 0) goto L9;
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new IntentResult(-2002, null, null, "executeCommonGlobalSearchIntent error", false, false, 256, null, null, null, 950, null);
    L11:
        throw new UnsupportedOperationException("not support dispatch intent");
    }
}
