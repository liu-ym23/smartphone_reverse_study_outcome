package com.obric.aikernel.phx.sdk.api;

import com.obric.aikernel.core.log.AIKLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.h.b.p;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
final class AIKernelApi$clearAIKernelData$2$onResult$2 extends p implements q<Integer, String, JSONObject, x> {
    public static final AIKernelApi$clearAIKernelData$2$onResult$2 INSTANCE = null;

    static {
        INSTANCE = new AIKernelApi$clearAIKernelData$2$onResult$2();
    }

    AIKernelApi$clearAIKernelData$2$onResult$2() {
        super(3);
    }

    @Override // d.h.a.q
    public /* synthetic */ x invoke(Integer r3, String r4, JSONObject r5) {
        invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    public final void invoke(int r3, String r4, JSONObject r5) {
        o.e(r4, "errInfo");
        o.e(r5, "extra");
        AIKLog.INSTANCE.d(AIKernelApi.TAG, "clearAIKernelData failed: " + r3 + " = " + r3 + ", errInfo = " + r4 + ", extra = " + r5);
    }
}
