package com.obric.agent;

import com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: AgentServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AgentServiceImpl$flowStreamObserver$1 extends IFlowStreamObserverIDL.Stub {
    final /* synthetic */ AgentServiceImpl this$0;

    public static /* synthetic */ AgentServiceImpl.c lambda$_nLF6w5yeYSR0lyyxDUGCgaI_d0(AgentServiceImpl.c r0) {
        return onStreamEnd$lambda$1(r0);
    }

    AgentServiceImpl$flowStreamObserver$1(AgentServiceImpl r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
    public void onStreamBegin(IMMessage r4) {
        ILogDepend.Companion r0 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("onStreamBegin ");
        if (r4 == null) goto L5;
        String r2 = r4.getMessageId();
    L6:
        r0.i("AgentServiceImpl", r1.append(r2).toString());
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getStreamObservers$p(this.this$0), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ((q) ZeusTransformUtils.preCheckCast(r3.next(), q.class, "com.obric.aiagent.plugin")).a(r4);
        goto L8
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowStreamObserverIDL
    public void onStreamEnd(IMMessage r5) {
        ILogDepend.Companion r0 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("onStreamEnd ");
        String r2 = null;
        if (r5 == null) goto L5;
        String r3 = r5.getMessageId();
    L6:
        r0.i("AgentServiceImpl", r1.append(r3).toString());
        AgentServiceImpl r4 = this.this$0;
        if (r5 == null) goto L9;
        r2 = r5.getMessageId();
    L9:
        AgentServiceImpl.access$updateOpenMicSignalState(r4, r2, $$Lambda$AgentServiceImpl$flowStreamObserver$1$_nLF6w5yeYSR0lyyxDUGCgaI_d0.INSTANCE);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(AgentServiceImpl.access$getStreamObservers$p(this.this$0), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        ((q) ZeusTransformUtils.preCheckCast(r6.next(), q.class, "com.obric.aiagent.plugin")).b(r5);
        goto L11
    L13:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private static final AgentServiceImpl.c onStreamEnd$lambda$1(AgentServiceImpl.c r3) {
        d.h.b.o.e(r3, "it");
        return AgentServiceImpl.c.a(r3, true, null, 2, null);
    }
}
