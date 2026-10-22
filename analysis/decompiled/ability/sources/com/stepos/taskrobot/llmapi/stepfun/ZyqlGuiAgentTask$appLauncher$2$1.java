package com.stepos.taskrobot.llmapi.stepfun;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class ZyqlGuiAgentTask$appLauncher$2$1 extends FunctionReferenceImpl implements S7.a {
    public ZyqlGuiAgentTask$appLauncher$2$1(Object obj) {
        super(0, obj, ZyqlGuiAgentTask.class, "getActionDisplayId", "getActionDisplayId()I", 0);
    }

    @Override // S7.a
    public final Integer invoke() {
        return Integer.valueOf(((ZyqlGuiAgentTask) this.receiver).getActionDisplayId());
    }
}
