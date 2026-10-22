package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.Permission;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class FlowPermissionIDLIpcWrapper implements IFlowPermissionIDL {
    boolean log;
    final IFlowPermissionIDL origin;

    FlowPermissionIDLIpcWrapper(IFlowPermissionIDL r3) {
        this((IFlowPermissionIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowPermissionIDL.class, "com.obric.aiagent.plugin"), true);
    }

    FlowPermissionIDLIpcWrapper(IFlowPermissionIDL r3, boolean r4) {
        this.origin = (IFlowPermissionIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowPermissionIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPermissionGranted(List<String> r22) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
        Map r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r4 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r4 + ") = fail", r1, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "isPermissionGranted", r1, r6, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.isPermissionGranted(r4);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowPermissionIDLIPC", "isPermissionGranted = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "isPermissionGranted(" + r4 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "isPermissionGranted", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public boolean requestPermission(String r23, String r24) {
        long r7 = SystemClock.elapsedRealtimeNanos();
        boolean r13 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r20 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "requestPermission", r3, r6, r20);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r13 = this.origin.requestPermission(r23, r24);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowPermissionIDLIPC", "requestPermission = " + r13);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "requestPermission(" + r23 + ", " + r24 + ") = " + r13, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "requestPermission", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return r13;
    L16:
        return r13;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isAppletPermissionGranted(String r23, List<String> r24) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
        Map r13 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r6 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r8 = Math.max(0, r20 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r6 + ") = fail", r2, r8);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted", r2, r8, r20);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r13 = this.origin.isAppletPermissionGranted(r23, r6);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowPermissionIDLIPC", "isAppletPermissionGranted = " + r13);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted(" + r23 + ", " + r6 + ") = " + r13, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "isAppletPermissionGranted", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return r13;
    L16:
        return r13;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updateAppletPermissions(List<Permission> r21) {
        List<Permission> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r4 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r4 + ") = fail", r1, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "updateAppletPermissions", r1, r6, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updateAppletPermissions(r4);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowPermissionIDLIPC", "updateAppletPermissions = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "updateAppletPermissions(" + r4 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "updateAppletPermissions", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public Map isPersonalPermissionGranted(String r23, List<String> r24) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        long r7 = SystemClock.elapsedRealtimeNanos();
        Map r13 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r6 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r8 = Math.max(0, r20 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r6 + ") = fail", r2, r8);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted", r2, r8, r20);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r6 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r13 = this.origin.isPersonalPermissionGranted(r23, r6);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowPermissionIDLIPC", "isPersonalPermissionGranted = " + r13);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r21 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted(" + r23 + ", " + r6 + ") = " + r13, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "isPersonalPermissionGranted", r14, r21);     // Catch: Exception -> L14 Throwable -> L17
        return r13;
    L16:
        return r13;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowPermissionIDL
    public void updatePersonalPermissions(List<Permission> r21) {
        List<Permission> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r4 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r4 + ") = fail", r1, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "updatePersonalPermissions", r1, r6, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.updatePersonalPermissions(r4);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IFlowPermissionIDLIPC", "updatePersonalPermissions = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IFlowPermissionIDLIPC", "updatePersonalPermissions(" + r4 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IFlowPermissionIDLIPC", "updatePersonalPermissions", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
