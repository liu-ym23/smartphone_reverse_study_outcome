package com.obric.wakeup.impl;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import com.obric.agent.IAgentService;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDLSPI;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VoiceInteractionIDLStub.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class VoiceInteractionIDLStub implements IAgentVoiceInteractionIDLSPI {
    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHide() {
    }

    public VoiceInteractionIDLStub() {
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentVoiceInteractionIDLSPI.b.a(this);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onShow(Bundle r3) {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.onAssistantShow(r3);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHandleAssist(AssistStructure r3, AssistContent r4) {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.onHandleAssist(r3, r4);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHandleScreenshot(Bitmap r3) {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.onHandleScreenshot(r3);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onStartChatWindow(int r3) {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.onStartChatWindow(r3);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onAsrStart(String r3) {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.onAsrStart(r3);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onAsrEnd() {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.onAsrEnd();
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public PersonalContextInfo getUserRecentData() {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getUserRecentData();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onQueryAudioFile(String r3, String r4) {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.onQueryAudioFile(r3, r4);
        return;
    }
}
