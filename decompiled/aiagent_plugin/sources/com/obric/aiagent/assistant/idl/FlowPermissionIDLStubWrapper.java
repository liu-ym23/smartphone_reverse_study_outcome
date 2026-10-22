package com.obric.aiagent.assistant.idl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowPermissionIDLStubWrapper extends IFlowPermissionIDL.Stub {
    boolean log;
    final IFlowPermissionIDL.Stub origin;

    FlowPermissionIDLStubWrapper(IFlowPermissionIDL.Stub r2) {
        this(r2, true);
    }

    FlowPermissionIDLStubWrapper(IFlowPermissionIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPermissionGranted(List<String> r21) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowPermissionIDLStub", "isPermissionGranted(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "isPermissionGranted(" + r4 + ") = fail", r1, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "isPermissionGranted", r1, r6, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowPermissionIDLStub", "isPermissionGranted(" + r4 + ")");     // Catch: Exception -> L11
    L6:
        Map r11 = this.origin.isPermissionGranted(r4);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowPermissionIDLStub", "isPermissionGranted = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "isPermissionGranted(" + r4 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "isPermissionGranted", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public boolean requestPermission(String r23, String r24) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowPermissionIDLStub", "requestPermission(" + r23 + ", " + r24 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "requestPermission(" + r23 + ", " + r24 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "requestPermission", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowPermissionIDLStub", "requestPermission(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L11
    L6:
        boolean r13 = this.origin.requestPermission(r23, r24);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowPermissionIDLStub", "requestPermission = " + r13);     // Catch: Exception -> L11
    L9:
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r20 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "requestPermission(" + r23 + ", " + r24 + ") = " + r13, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "requestPermission", r14, r20);     // Catch: Exception -> L11
        return r13;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isAppletPermissionGranted(String r23, List<String> r24) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowPermissionIDLStub", "isAppletPermissionGranted(" + r23 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "isAppletPermissionGranted(" + r23 + ", " + r6 + ") = fail", r2, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "isAppletPermissionGranted", r2, r8, r19);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowPermissionIDLStub", "isAppletPermissionGranted(" + r23 + ", " + r6 + ")");     // Catch: Exception -> L11
    L6:
        Map r13 = this.origin.isAppletPermissionGranted(r23, r6);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowPermissionIDLStub", "isAppletPermissionGranted = " + r13);     // Catch: Exception -> L11
    L9:
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r20 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "isAppletPermissionGranted(" + r23 + ", " + r6 + ") = " + r13, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "isAppletPermissionGranted", r14, r20);     // Catch: Exception -> L11
        return r13;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updateAppletPermissions(List<Permission> r21) {
        List<Permission> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowPermissionIDLStub", "updateAppletPermissions(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "updateAppletPermissions(" + r4 + ") = fail", r1, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "updateAppletPermissions", r1, r6, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowPermissionIDLStub", "updateAppletPermissions(" + r4 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.updateAppletPermissions(r4);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowPermissionIDLStub", "updateAppletPermissions = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "updateAppletPermissions(" + r4 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "updateAppletPermissions", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPersonalPermissionGranted(String r23, List<String> r24) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowPermissionIDLStub", "isPersonalPermissionGranted(" + r23 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "isPersonalPermissionGranted(" + r23 + ", " + r6 + ") = fail", r2, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "isPersonalPermissionGranted", r2, r8, r19);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowPermissionIDLStub", "isPersonalPermissionGranted(" + r23 + ", " + r6 + ")");     // Catch: Exception -> L11
    L6:
        Map r13 = this.origin.isPersonalPermissionGranted(r23, r6);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowPermissionIDLStub", "isPersonalPermissionGranted = " + r13);     // Catch: Exception -> L11
    L9:
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r20 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "isPersonalPermissionGranted(" + r23 + ", " + r6 + ") = " + r13, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "isPersonalPermissionGranted", r14, r20);     // Catch: Exception -> L11
        return r13;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updatePersonalPermissions(List<Permission> r21) {
        List<Permission> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("FlowPermissionIDLStub", "updatePersonalPermissions(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "updatePersonalPermissions(" + r4 + ") = fail", r1, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "updatePersonalPermissions", r1, r6, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("FlowPermissionIDLStub", "updatePersonalPermissions(" + r4 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.updatePersonalPermissions(r4);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("FlowPermissionIDLStub", "updatePersonalPermissions = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("FlowPermissionIDLStub", "updatePersonalPermissions(" + r4 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("FlowPermissionIDLStub", "updatePersonalPermissions", r14, r17);     // Catch: Exception -> L11
    }
}
