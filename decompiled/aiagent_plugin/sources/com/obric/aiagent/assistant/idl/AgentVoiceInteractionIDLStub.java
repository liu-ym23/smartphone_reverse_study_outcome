package com.obric.aiagent.assistant.idl;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AgentVoiceInteractionIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class AgentVoiceInteractionIDLStub extends IAgentVoiceInteractionIDL.Stub implements IAgentVoiceInteractionIDL {
    private final /* synthetic */ IAgentVoiceInteractionIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public PersonalContextInfo getUserRecentData() {
        return this.$$delegate_0.getUserRecentData();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onAsrEnd() {
        this.$$delegate_0.onAsrEnd();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onAsrStart(String r1) {
        this.$$delegate_0.onAsrStart(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHandleAssist(AssistStructure r1, AssistContent r2) {
        this.$$delegate_0.onHandleAssist(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHandleScreenshot(Bitmap r1) {
        this.$$delegate_0.onHandleScreenshot(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHide() {
        this.$$delegate_0.onHide();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onQueryAudioFile(String r1, String r2) {
        this.$$delegate_0.onQueryAudioFile(r1, r2);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onShow(Bundle r1) {
        this.$$delegate_0.onShow(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onStartChatWindow(int r1) {
        this.$$delegate_0.onStartChatWindow(r1);
    }

    public AgentVoiceInteractionIDLStub() {
        Object r0 = (IAgentVoiceInteractionIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentVoiceInteractionIDLSPI.class), IAgentVoiceInteractionIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IAgentVoiceInteractionIDL.Default();
    L6:
        this.$$delegate_0 = (IAgentVoiceInteractionIDL) ZeusTransformUtils.preCheckCast(r0, IAgentVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
