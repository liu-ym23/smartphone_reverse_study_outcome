package com.obric.agent;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IAgentMessageIDLSPI;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MessageIDLStub.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageIDLStub implements IAgentMessageIDLSPI {
    public MessageIDLStub() {
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentMessageIDLSPI.b.a(this);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentMessageIDL
    public PicInfo getScreenPicInfo() {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        PicInfo r3 = r2.getScreenPicInfo(false, false);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return null;
    }
}
