package com.obric.agent;

import com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL;
import com.obric.aiagent.assistant.idl.bean.TtsInfo;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: AgentServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AgentServiceImpl$flowTTSListener$1 extends IFlowAssistantTTSStateListenerIDL.Stub {
    final /* synthetic */ AgentServiceImpl this$0;

    /* JADX INFO: renamed from: lambda$M8nzxAAB-EbABYsMR4RMT9tvPTk, reason: not valid java name */
    public static /* synthetic */ AgentServiceImpl.c m55lambda$M8nzxAABEbABYsMR4RMT9tvPTk(TtsInfo r0, AgentServiceImpl.c r1) {
        return onChanged$lambda$1$lambda$0(r0, r1);
    }

    AgentServiceImpl$flowTTSListener$1(AgentServiceImpl r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAssistantTTSStateListenerIDL
    public void onChanged(final TtsInfo r5) {
        ILogDepend.Companion r0 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("onTtsState ");
        Integer r2 = null;
        if (r5 == null) goto L5;
        Integer r3 = r5.getPlayStateEnum();
    L6:
        r0.i("AgentServiceImpl", r1.append(r3).toString());
        AgentServiceImpl r4 = this.this$0;
        if (r5 == null) goto L9;
        r2 = r5.getPlayStateEnum();
    L9:
        d.h.b.o.a(r2);
        AgentServiceImpl.access$setTtsPlayState$p(r4, r2.intValue());
        if (r5 == null) goto L12;
        AgentServiceImpl.access$updateOpenMicSignalState(this.this$0, r5.getMessageId(), new $$Lambda$AgentServiceImpl$flowTTSListener$1$M8nzxAABEbABYsMR4RMT9tvPTk(r5));
    L12:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getTtsStateListeners$p(this.this$0), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        ((y) ZeusTransformUtils.preCheckCast(r6.next(), y.class, "com.obric.aiagent.plugin")).a(r5);
        goto L14
    L16:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private static final AgentServiceImpl.c onChanged$lambda$1$lambda$0(TtsInfo r3, AgentServiceImpl.c r4) {
        d.h.b.o.e(r4, "it");
        return AgentServiceImpl.c.a(r4, false, r3.getPlayStateEnum(), 1, null);
    }
}
