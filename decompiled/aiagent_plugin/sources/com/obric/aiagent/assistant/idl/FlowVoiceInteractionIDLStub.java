package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: FlowVoiceInteractionIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class FlowVoiceInteractionIDLStub extends IFlowVoiceInteractionIDL.Stub implements IFlowVoiceInteractionIDL {
    private final /* synthetic */ IFlowVoiceInteractionIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean closeContinuousTalk() {
        return this.$$delegate_0.closeContinuousTalk();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean isInRealtimeCalling() {
        return this.$$delegate_0.isInRealtimeCalling();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean isInteractionSessionStateListening() {
        return this.$$delegate_0.isInteractionSessionStateListening();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void readContent(String r1) {
        this.$$delegate_0.readContent(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void readContentByMessage(IMMessage r1) {
        this.$$delegate_0.readContentByMessage(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void replayMessageTts(String r1) {
        this.$$delegate_0.replayMessageTts(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void requireSyncData(IFlowSyncDataResultIDL r3) {
        IFlowSyncDataResultIDL r4 = (IFlowSyncDataResultIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSyncDataResultIDL.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.requireSyncData(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean tryInterruptAssistant(AppEvent r1) {
        return this.$$delegate_0.tryInterruptAssistant(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void tryOpenClickTalk(int r1) {
        this.$$delegate_0.tryOpenClickTalk(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public boolean tryOpenMicToRecording(AppEvent r1) {
        return this.$$delegate_0.tryOpenMicToRecording(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void updateIntentExt(Map r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        this.$$delegate_0.updateIntentExt(r4);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void updateScreenshotForAsr(String r1) {
        this.$$delegate_0.updateScreenshotForAsr(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL
    public void wakeupAssistant(String r1) {
        this.$$delegate_0.wakeupAssistant(r1);
    }

    public FlowVoiceInteractionIDLStub() {
        Object r0 = (IFlowVoiceInteractionIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowVoiceInteractionIDLSPI.class), IFlowVoiceInteractionIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IFlowVoiceInteractionIDL.Default();
    L6:
        this.$$delegate_0 = (IFlowVoiceInteractionIDL) ZeusTransformUtils.preCheckCast(r0, IFlowVoiceInteractionIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
