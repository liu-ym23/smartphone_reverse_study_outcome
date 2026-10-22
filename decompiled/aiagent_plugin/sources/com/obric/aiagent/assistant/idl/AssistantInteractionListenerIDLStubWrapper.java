package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class AssistantInteractionListenerIDLStubWrapper extends IAssistantInteractionListenerIDL.Stub {
    boolean log;
    final IAssistantInteractionListenerIDL.Stub origin;

    AssistantInteractionListenerIDLStubWrapper(IAssistantInteractionListenerIDL.Stub r2) {
        this(r2, true);
    }

    AssistantInteractionListenerIDLStubWrapper(IAssistantInteractionListenerIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantTakeOver() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AssistantInteractionListenerIDLStub", "onAssistantTakeOver()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onAssistantTakeOver() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onAssistantTakeOver", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AssistantInteractionListenerIDLStub", "onAssistantTakeOver()");     // Catch: Exception -> L11
    L6:
        this.origin.onAssistantTakeOver();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AssistantInteractionListenerIDLStub", "onAssistantTakeOver = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onAssistantTakeOver() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onAssistantTakeOver", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onReply(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AssistantInteractionListenerIDLStub", "onReply(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onReply(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onReply", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AssistantInteractionListenerIDLStub", "onReply(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onReply(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AssistantInteractionListenerIDLStub", "onReply = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onReply(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onReply", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelCancel() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AssistantInteractionListenerIDLStub", "onPanelCancel()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onPanelCancel() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onPanelCancel", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AssistantInteractionListenerIDLStub", "onPanelCancel()");     // Catch: Exception -> L11
    L6:
        this.origin.onPanelCancel();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AssistantInteractionListenerIDLStub", "onPanelCancel = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onPanelCancel() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onPanelCancel", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelShow(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AssistantInteractionListenerIDLStub", "onPanelShow(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onPanelShow(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onPanelShow", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AssistantInteractionListenerIDLStub", "onPanelShow(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onPanelShow(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AssistantInteractionListenerIDLStub", "onPanelShow = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onPanelShow(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onPanelShow", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onPanelHeightChanged(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AssistantInteractionListenerIDLStub", "onPanelHeightChanged(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onPanelHeightChanged(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onPanelHeightChanged", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AssistantInteractionListenerIDLStub", "onPanelHeightChanged(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onPanelHeightChanged(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AssistantInteractionListenerIDLStub", "onPanelHeightChanged = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onPanelHeightChanged(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onPanelHeightChanged", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanel() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AssistantInteractionListenerIDLStub", "requestToShowInputPanel()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanel() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanel", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanel()");     // Catch: Exception -> L11
    L6:
        this.origin.requestToShowInputPanel();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AssistantInteractionListenerIDLStub", "requestToShowInputPanel = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanel() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanel", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void onAssistantDied() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AssistantInteractionListenerIDLStub", "onAssistantDied()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onAssistantDied() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onAssistantDied", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AssistantInteractionListenerIDLStub", "onAssistantDied()");     // Catch: Exception -> L11
    L6:
        this.origin.onAssistantDied();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AssistantInteractionListenerIDLStub", "onAssistantDied = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "onAssistantDied() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "onAssistantDied", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAssistantInteractionListenerIDL
    public void requestToShowInputPanelWithMeta(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.requestToShowInputPanelWithMeta(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AssistantInteractionListenerIDLStub", "requestToShowInputPanelWithMeta", r14, r17);     // Catch: Exception -> L11
    }
}
