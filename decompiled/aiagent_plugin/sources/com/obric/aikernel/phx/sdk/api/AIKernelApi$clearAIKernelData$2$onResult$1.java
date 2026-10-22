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
final class AIKernelApi$clearAIKernelData$2$onResult$1 extends p implements q<Boolean, Object, JSONObject, x> {
    public static final AIKernelApi$clearAIKernelData$2$onResult$1 INSTANCE = null;

    static {
        INSTANCE = new AIKernelApi$clearAIKernelData$2$onResult$1();
    }

    AIKernelApi$clearAIKernelData$2$onResult$1() {
        super(3);
    }

    @Override // d.h.a.q
    public /* synthetic */ x invoke(Boolean r3, Object r4, JSONObject r5) {
        invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), r4, (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    public final void invoke(boolean r1, Object r2, JSONObject r3) {
        o.e(r3, "extra");
        AIKLog.INSTANCE.d(AIKernelApi.TAG, "clearAIKernelData succeed extra = " + r3);
    }
}
