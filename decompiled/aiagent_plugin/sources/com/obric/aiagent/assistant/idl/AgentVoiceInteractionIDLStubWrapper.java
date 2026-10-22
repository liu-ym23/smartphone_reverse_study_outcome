package com.obric.aiagent.assistant.idl;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.PersonalContextInfo;

/* JADX INFO: loaded from: classes2.dex */
class AgentVoiceInteractionIDLStubWrapper extends IAgentVoiceInteractionIDL.Stub {
    boolean log;
    final IAgentVoiceInteractionIDL.Stub origin;

    AgentVoiceInteractionIDLStubWrapper(IAgentVoiceInteractionIDL.Stub r2) {
        this(r2, true);
    }

    AgentVoiceInteractionIDLStubWrapper(IAgentVoiceInteractionIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onShow(Bundle r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentVoiceInteractionIDLStub", "onShow(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onShow(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onShow", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentVoiceInteractionIDLStub", "onShow(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onShow(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentVoiceInteractionIDLStub", "onShow = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onShow(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onShow", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHide() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentVoiceInteractionIDLStub", "onHide()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onHide() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onHide", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentVoiceInteractionIDLStub", "onHide()");     // Catch: Exception -> L11
    L6:
        this.origin.onHide();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentVoiceInteractionIDLStub", "onHide = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onHide() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onHide", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHandleAssist(AssistStructure r22, AssistContent r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentVoiceInteractionIDLStub", "onHandleAssist(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onHandleAssist(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onHandleAssist", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentVoiceInteractionIDLStub", "onHandleAssist(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onHandleAssist(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentVoiceInteractionIDLStub", "onHandleAssist = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onHandleAssist(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onHandleAssist", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onHandleScreenshot(Bitmap r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentVoiceInteractionIDLStub", "onHandleScreenshot(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onHandleScreenshot(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onHandleScreenshot", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentVoiceInteractionIDLStub", "onHandleScreenshot(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onHandleScreenshot(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentVoiceInteractionIDLStub", "onHandleScreenshot = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onHandleScreenshot(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onHandleScreenshot", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onStartChatWindow(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentVoiceInteractionIDLStub", "onStartChatWindow(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onStartChatWindow(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onStartChatWindow", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentVoiceInteractionIDLStub", "onStartChatWindow(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onStartChatWindow(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentVoiceInteractionIDLStub", "onStartChatWindow = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onStartChatWindow(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onStartChatWindow", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onAsrStart(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentVoiceInteractionIDLStub", "onAsrStart(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onAsrStart(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onAsrStart", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentVoiceInteractionIDLStub", "onAsrStart(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onAsrStart(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentVoiceInteractionIDLStub", "onAsrStart = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onAsrStart(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onAsrStart", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onAsrEnd() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentVoiceInteractionIDLStub", "onAsrEnd()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onAsrEnd() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onAsrEnd", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentVoiceInteractionIDLStub", "onAsrEnd()");     // Catch: Exception -> L11
    L6:
        this.origin.onAsrEnd();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentVoiceInteractionIDLStub", "onAsrEnd = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onAsrEnd() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onAsrEnd", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public PersonalContextInfo getUserRecentData() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentVoiceInteractionIDLStub", "getUserRecentData()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "getUserRecentData() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "getUserRecentData", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentVoiceInteractionIDLStub", "getUserRecentData()");     // Catch: Exception -> L11
    L6:
        PersonalContextInfo r9 = this.origin.getUserRecentData();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentVoiceInteractionIDLStub", "getUserRecentData = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "getUserRecentData() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "getUserRecentData", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL
    public void onQueryAudioFile(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentVoiceInteractionIDLStub", "onQueryAudioFile(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onQueryAudioFile(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onQueryAudioFile", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentVoiceInteractionIDLStub", "onQueryAudioFile(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onQueryAudioFile(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentVoiceInteractionIDLStub", "onQueryAudioFile = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentVoiceInteractionIDLStub", "onQueryAudioFile(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentVoiceInteractionIDLStub", "onQueryAudioFile", r13, r110);     // Catch: Exception -> L11
    }
}
