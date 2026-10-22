package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentMessageIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentMessageIDLStub extends IAgentMessageIDL.Stub implements IAgentMessageIDL {
    private final /* synthetic */ IAgentMessageIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDL
    public PicInfo getScreenPicInfo() {
        return this.$$delegate_0.getScreenPicInfo();
    }

    public AgentMessageIDLStub() {
        Object r0 = (IAgentMessageIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentMessageIDLSPI.class), IAgentMessageIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentMessageIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentMessageIDL) ZeusTransformUtils.preCheckCast(r0, IAgentMessageIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
