package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class FlowAppIntentIDLIpcWrapper implements IFlowAppIntentIDL {
    boolean log;
    final IFlowAppIntentIDL origin;

    FlowAppIntentIDLIpcWrapper(IFlowAppIntentIDL r3) {
        this((IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowAppIntentIDLIpcWrapper(IFlowAppIntentIDL r3, boolean r4) {
        this.origin = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void setAppIntentActive(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "setAppIntentActive", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setAppIntentActive(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "setAppIntentActive = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "setAppIntentActive(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "setAppIntentActive", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0161: RETURN (r15 I:boolean) A[SYNTHETIC], block:B:28:? */
    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean checkPermission(String r34, boolean r35, long r36) {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L18:
        e = e;
        boolean r15 = false;
    L20:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "checkPermission(" + r34 + ", " + r35 + ", " + r36 + ")", e);     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.g r5 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L22
        long r31 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L22
        long r29 = Math.max(0, r31 - r9) / 1000;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "checkPermission(" + r34 + ", " + r35 + ", " + r36 + ") = fail", r5, r29);     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "checkPermission", r5, r29, r31);     // Catch: Throwable -> L22
        return r15;
    L17:
        return false;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "checkPermission(" + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Throwable -> L17 Exception -> L18
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "checkPermission(" + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Throwable -> L17 Exception -> L18
    L9:
        r15 = this.origin.checkPermission(r34, r35, r36);     // Catch: Throwable -> L17 Exception -> L18
    L15:
        e = e;
        goto L20
    L11:
        if (this.log == false) goto L13;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "checkPermission = " + r15);     // Catch: Exception -> L15 Throwable -> L22
    L13:
        long r23 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L22
        long r11 = Math.max(0, r23 - r9) / 1000;     // Catch: Exception -> L15 Throwable -> L22
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "checkPermission(" + r34 + ", " + r35 + ", " + r36 + ") = " + r15, r11);     // Catch: Exception -> L15 Throwable -> L22
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "checkPermission", r11, r23);     // Catch: Exception -> L15 Throwable -> L22
        return r15;
    L28:
        return r15;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void stopComplexTask(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "stopComplexTask", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.stopComplexTask(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "stopComplexTask = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "stopComplexTask(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "stopComplexTask", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isLogin() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "isLogin()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "isLogin() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "isLogin", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "isLogin()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "isLogin()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isLogin();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "isLogin = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "isLogin() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "isLogin", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isEnterpriseAccount() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isEnterpriseAccount();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "isEnterpriseAccount = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "isEnterpriseAccount", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public OTaskTimeoutConfig getObricTaskTimeoutConfig() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        OTaskTimeoutConfig r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getObricTaskTimeoutConfig();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "getObricTaskTimeoutConfig", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean isDoraConnected() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "isDoraConnected()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "isDoraConnected() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "isDoraConnected", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "isDoraConnected()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "isDoraConnected()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isDoraConnected();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "isDoraConnected = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "isDoraConnected() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "isDoraConnected", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void jumpDoraPage() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "jumpDoraPage()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "jumpDoraPage() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "jumpDoraPage", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "jumpDoraPage()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "jumpDoraPage()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.jumpDoraPage();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "jumpDoraPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "jumpDoraPage() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "jumpDoraPage", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00a4: MOVE (r7 I:??[long, double]) = (r9 I:??[long, double]), block:B:21:0x00a4 */
    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public long currentTimeMillis() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L17:
        e = e;
        long r9 = 0;
    L19:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "currentTimeMillis()", e);     // Catch: Throwable -> L21
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L21
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L21
        long r2 = Math.max(0, r18 - r3) / 1000;     // Catch: Throwable -> L21
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "currentTimeMillis() = fail", r1, r2);     // Catch: Throwable -> L21
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "currentTimeMillis", r1, r2, r18);     // Catch: Throwable -> L21
        return r9;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "currentTimeMillis()");     // Catch: Exception -> L17 Throwable -> L23
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "currentTimeMillis()");     // Catch: Exception -> L17 Throwable -> L23
    L9:
        r9 = this.origin.currentTimeMillis();     // Catch: Exception -> L17 Throwable -> L23
    L15:
        e = e;
        goto L19
    L11:
        if (this.log == false) goto L13;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "currentTimeMillis = " + r9);     // Catch: Exception -> L15 Throwable -> L21
    L13:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L21
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L15 Throwable -> L21
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "currentTimeMillis() = " + r9, r14);     // Catch: Exception -> L15 Throwable -> L21
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "currentTimeMillis", r14, r17);     // Catch: Exception -> L15 Throwable -> L21
        return r9;
        goto L28
    L22:
        return r9;
    L28:
        return 0;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public String getUserId() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        String r9 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "getUserId()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "getUserId() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "getUserId", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "getUserId()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "getUserId()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.getUserId();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "getUserId = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "getUserId() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "getUserId", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public void getLocation(IFlowGetLocationCallbackIDL r21) {
        IFlowGetLocationCallbackIDL r4 = (IFlowGetLocationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "getLocation(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "getLocation(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "getLocation", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "getLocation(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("getLocation(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IFlowGetLocationCallbackIDL r15 = r4;
    L21:
        r12.a("IFlowAppIntentIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, FlowGetLocationCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, FlowGetLocationCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IFlowGetLocationCallbackIDL.Stub.class) == false) goto L19;
        r15 = af.a((IFlowGetLocationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowGetLocationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = af.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IFlowAppIntentIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IFlowGetLocationCallbackIDL r7 = r4;
    L35:
        r13.getLocation(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "getLocation = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "getLocation(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "getLocation", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, FlowGetLocationCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, FlowGetLocationCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IFlowGetLocationCallbackIDL.Stub.class) == false) goto L33;
        r7 = af.a((IFlowGetLocationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowGetLocationCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = af.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean openMiniApp(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "openMiniApp", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.openMiniApp(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "openMiniApp = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "openMiniApp(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "openMiniApp", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowAppIntentIDL
    public boolean syncAppletData(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "syncAppletData", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.syncAppletData(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowAppIntentIDLIPC", "syncAppletData = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowAppIntentIDLIPC", "syncAppletData(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowAppIntentIDLIPC", "syncAppletData", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
