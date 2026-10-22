package com.obric.agent.trace.omni;

import com.obric.assistant.dm.api.statemachine.core.TaskId;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DmStateListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final String a(TaskId r3) {
        d.h.b.o.e(r3, "<this>");
        d.o.i r4 = new d.o.k("task_(.+?)_.*").c((CharSequence) ZeusTransformUtils.preCheckCast(r3.getValue(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r4 == null) goto L9;
        d.o.g r5 = r4.c();
        if (r5 == null) goto L9;
        d.o.f r6 = r5.a(1);
        if (r6 == null) goto L9;
        return r6.a();
    L9:
        return null;
    }
}
