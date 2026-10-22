package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentDMStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentDMStateListenerIDLStub extends IAgentDMStateListenerIDL.Stub implements IAgentDMStateListenerIDL {
    private final /* synthetic */ IAgentDMStateListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onDMStateChanged(DMStateInfo r1) {
        this.$$delegate_0.onDMStateChanged(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskAdded(DMTaskInfo r1) {
        this.$$delegate_0.onTaskAdded(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskEnd(DMTaskInfo r1) {
        this.$$delegate_0.onTaskEnd(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL
    public void onTaskStateChanged(DMTaskInfo r1, DMTaskState r2, DMTaskState r3) {
        this.$$delegate_0.onTaskStateChanged(r1, r2, r3);
    }

    public AgentDMStateListenerIDLStub() {
        Object r0 = (IAgentDMStateListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentDMStateListenerIDLSPI.class), IAgentDMStateListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentDMStateListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentDMStateListenerIDL) ZeusTransformUtils.preCheckCast(r0, IAgentDMStateListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentDMStateListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
