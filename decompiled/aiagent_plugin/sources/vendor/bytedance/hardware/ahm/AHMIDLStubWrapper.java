package vendor.bytedance.hardware.ahm;

import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.d;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
class AHMIDLStubWrapper extends IAHMIDL.Stub {
    boolean log;
    final IAHMIDL.Stub origin;

    AHMIDLStubWrapper(IAHMIDL.Stub r2) {
        this(r2, true);
    }

    AHMIDLStubWrapper(IAHMIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open(IAHMCallbackIDL r22) {
        IAHMCallbackIDL r4 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r22, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        j.f18676a.a("AHMIDLStub", "ipc_ahm_open(" + r4 + ")", e);
        g r1 = new g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        k.f18677a.b("AHMIDLStub", "ipc_ahm_open(" + r4 + ") = fail", r1, r5);
        d.f18654a.b("AHMIDLStub", "ipc_ahm_open", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("AHMIDLStub", "ipc_ahm_open(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IAHMIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IAHMCallbackIDL r7 = r4;
    L19:
        long r13 = r12.ipc_ahm_open(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        j.f18676a.c("AHMIDLStub", "ipc_ahm_open = " + r13);     // Catch: Exception -> L24
    L22:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L24
        k.f18677a.b("AHMIDLStub", "ipc_ahm_open(" + r4 + ") = " + r13, r14);     // Catch: Exception -> L24
        d.f18654a.b("AHMIDLStub", "ipc_ahm_open", r14, r19);     // Catch: Exception -> L24
        return r13;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, AHMCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, AHMCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IAHMCallbackIDL.Stub.class) == false) goto L17;
        r7 = a.a((IAHMCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAHMCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = a.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_close() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        j.f18676a.a("AHMIDLStub", "ipc_ahm_close()", e);
        g r1 = new g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        k.f18677a.b("AHMIDLStub", "ipc_ahm_close() = fail", r1, r2);
        d.f18654a.b("AHMIDLStub", "ipc_ahm_close", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("AHMIDLStub", "ipc_ahm_close()");     // Catch: Exception -> L11
    L6:
        long r9 = this.origin.ipc_ahm_close();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        j.f18676a.c("AHMIDLStub", "ipc_ahm_close = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        k.f18677a.b("AHMIDLStub", "ipc_ahm_close() = " + r9, r14);     // Catch: Exception -> L11
        d.f18654a.b("AHMIDLStub", "ipc_ahm_close", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open_v2(IAHMCallbackIDL r34, int r35) {
        IAHMCallbackIDL r6 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r34, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        j.f18676a.a("AHMIDLStub", "ipc_ahm_open_v2(" + r6 + ", " + r35 + ")", e);
        g r2 = new g(e);
        long r31 = SystemClock.elapsedRealtimeNanos();
        long r29 = Math.max(0, r31 - r8) / 1000;
        k.f18677a.b("AHMIDLStub", "ipc_ahm_open_v2(" + r6 + ", " + r35 + ") = fail", r2, r29);
        d.f18654a.b("AHMIDLStub", "ipc_ahm_open_v2", r2, r29, r31);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        j.f18676a.b("AHMIDLStub", "ipc_ahm_open_v2(" + r6 + ", " + r35 + ")");     // Catch: Exception -> L24
    L6:
        IAHMIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IAHMCallbackIDL r7 = r6;
    L19:
        long r10 = r14.ipc_ahm_open_v2(r7, r35);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        j.f18676a.c("AHMIDLStub", "ipc_ahm_open_v2 = " + r10);     // Catch: Exception -> L24
    L22:
        long r23 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r15 = Math.max(0, r23 - r8) / 1000;     // Catch: Exception -> L24
        k.f18677a.b("AHMIDLStub", "ipc_ahm_open_v2(" + r6 + ", " + r35 + ") = " + r10, r15);     // Catch: Exception -> L24
        d.f18654a.b("AHMIDLStub", "ipc_ahm_open_v2", r15, r23);     // Catch: Exception -> L24
        return r10;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, AHMCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, AHMCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IAHMCallbackIDL.Stub.class) == false) goto L17;
        r7 = a.a((IAHMCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IAHMCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = a.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }
}
