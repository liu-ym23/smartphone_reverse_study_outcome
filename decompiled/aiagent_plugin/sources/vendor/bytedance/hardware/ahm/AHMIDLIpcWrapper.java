package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.d;
import com.obric.aiagent.ipc.utils.g;
import com.obric.aiagent.ipc.utils.j;
import com.obric.aiagent.ipc.utils.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
class AHMIDLIpcWrapper implements IAHMIDL {
    boolean log;
    final IAHMIDL origin;

    AHMIDLIpcWrapper(IAHMIDL r3) {
        this((IAHMIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAHMIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AHMIDLIpcWrapper(IAHMIDL r3, boolean r4) {
        this.origin = (IAHMIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAHMIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0172: MOVE (r10 I:??[long, double]) = (r12 I:??[long, double]), block:B:47:0x0172 */
    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open(IAHMCallbackIDL r30) {
        IAHMCallbackIDL r4 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r30, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L43:
        e = e;
        long r12 = 0;
    L45:
        j.f18676a.a("IAHMIDLIPC", "ipc_ahm_open(" + r4 + ")", e);     // Catch: Throwable -> L47
        g r1 = new g(e);     // Catch: Throwable -> L47
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L47
        long r25 = Math.max(0, r27 - r6) / 1000;     // Catch: Throwable -> L47
        k.f18677a.a("IAHMIDLIPC", "ipc_ahm_open(" + r4 + ") = fail", r1, r25);     // Catch: Throwable -> L47
        d.f18654a.a("IAHMIDLIPC", "ipc_ahm_open", r1, r25, r27);     // Catch: Throwable -> L47
        return r12;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IAHMIDLIPC", "ipc_ahm_open(" + r4 + ")");     // Catch: Exception -> L43 Throwable -> L49
    L7:
        if (this.log == false) goto L22;
        j r13 = j.f18676a;     // Catch: Exception -> L43 Throwable -> L49
        StringBuilder r14 = new StringBuilder().append("ipc_ahm_open(");     // Catch: Exception -> L43 Throwable -> L49
        if (r4 != null) goto L12;
    L20:
        IAHMCallbackIDL r15 = r4;
    L21:
        r13.a("IAHMIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L43 Throwable -> L49
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, AHMCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, AHMCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IAHMCallbackIDL.Stub.class) == false) goto L19;
        r15 = a.a((IAHMCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAHMCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L43 Throwable -> L49
        goto L21
    L19:
        r15 = a.a(r4, true);     // Catch: Exception -> L43 Throwable -> L49
    L22:
        IAHMIDL r16 = this.origin;     // Catch: Exception -> L43 Throwable -> L49
        if (r4 != null) goto L26;
    L34:
        IAHMCallbackIDL r5 = r4;
    L35:
        r12 = r16.ipc_ahm_open(r5);     // Catch: Exception -> L43 Throwable -> L49
    L41:
        e = e;
        goto L45
    L37:
        if (this.log == false) goto L39;
        j.f18676a.c("IAHMIDLIPC", "ipc_ahm_open = " + r12);     // Catch: Exception -> L41 Throwable -> L47
    L39:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L41 Throwable -> L47
        long r17 = Math.max(0, r19 - r6) / 1000;     // Catch: Exception -> L41 Throwable -> L47
        k.f18677a.a("IAHMIDLIPC", "ipc_ahm_open(" + r4 + ") = " + r12, r17);     // Catch: Exception -> L41 Throwable -> L47
        d.f18654a.a("IAHMIDLIPC", "ipc_ahm_open", r17, r19);     // Catch: Exception -> L41 Throwable -> L47
        return r12;
        goto L54
    L26:
        if (ZeusTransformUtils.instanceOf(r4, AHMCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, AHMCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IAHMCallbackIDL.Stub.class) == false) goto L33;
        r5 = a.a((IAHMCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAHMCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L43 Throwable -> L49
        goto L35
    L33:
        r5 = a.a(r4, true);     // Catch: Exception -> L43 Throwable -> L49
        goto L35
    L48:
        return r12;
    L54:
        return 0;
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00a4: MOVE (r7 I:??[long, double]) = (r9 I:??[long, double]), block:B:21:0x00a4 */
    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_close() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L17:
        e = e;
        long r9 = 0;
    L19:
        j.f18676a.a("IAHMIDLIPC", "ipc_ahm_close()", e);     // Catch: Throwable -> L21
        g r1 = new g(e);     // Catch: Throwable -> L21
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L21
        long r2 = Math.max(0, r18 - r3) / 1000;     // Catch: Throwable -> L21
        k.f18677a.a("IAHMIDLIPC", "ipc_ahm_close() = fail", r1, r2);     // Catch: Throwable -> L21
        d.f18654a.a("IAHMIDLIPC", "ipc_ahm_close", r1, r2, r18);     // Catch: Throwable -> L21
        return r9;
    L4:
        if (this.log == false) goto L7;
        j.f18676a.a("IAHMIDLIPC", "ipc_ahm_close()");     // Catch: Exception -> L17 Throwable -> L23
    L7:
        if (this.log == false) goto L9;
        j.f18676a.a("IAHMIDLIPC", "ipc_ahm_close()");     // Catch: Exception -> L17 Throwable -> L23
    L9:
        r9 = this.origin.ipc_ahm_close();     // Catch: Exception -> L17 Throwable -> L23
    L15:
        e = e;
        goto L19
    L11:
        if (this.log == false) goto L13;
        j.f18676a.c("IAHMIDLIPC", "ipc_ahm_close = " + r9);     // Catch: Exception -> L15 Throwable -> L21
    L13:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L21
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L15 Throwable -> L21
        k.f18677a.a("IAHMIDLIPC", "ipc_ahm_close() = " + r9, r14);     // Catch: Exception -> L15 Throwable -> L21
        d.f18654a.a("IAHMIDLIPC", "ipc_ahm_close", r14, r17);     // Catch: Exception -> L15 Throwable -> L21
        return r9;
        goto L28
    L22:
        return r9;
    L28:
        return 0;
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x01a7: MOVE (r12 I:??[long, double]) = (r10 I:??[long, double]), block:B:53:0x01a7 */
    @Override // vendor.bytedance.hardware.ahm.IAHMIDL
    public long ipc_ahm_open_v2(IAHMCallbackIDL r34, int r35) {
        IAHMCallbackIDL r6 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r34, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L49:
        e = e;
        long r10 = 0;
    L51:
        j.f18676a.a("IAHMIDLIPC", "ipc_ahm_open_v2(" + r6 + ", " + r35 + ")", e);     // Catch: Throwable -> L53
        g r2 = new g(e);     // Catch: Throwable -> L53
        long r31 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L53
        long r29 = Math.max(0, r31 - r8) / 1000;     // Catch: Throwable -> L53
        k.f18677a.a("IAHMIDLIPC", "ipc_ahm_open_v2(" + r6 + ", " + r35 + ") = fail", r2, r29);     // Catch: Throwable -> L53
        d.f18654a.a("IAHMIDLIPC", "ipc_ahm_open_v2", r2, r29, r31);     // Catch: Throwable -> L53
        return r10;
    L48:
        return 0;
    L4:
        if (this.log == false) goto L11;
        j.f18676a.a("IAHMIDLIPC", "ipc_ahm_open_v2(" + r6 + ", " + r35 + ")");     // Catch: Exception -> L7 Throwable -> L55
    L7:
        e = e;
        r10 = 0;
        goto L51
    L62:
        return 0;
    L11:
        if (this.log == false) goto L26;
        j r14 = j.f18676a;     // Catch: Exception -> L7 Throwable -> L55
        StringBuilder r11 = new StringBuilder().append("ipc_ahm_open_v2(");     // Catch: Exception -> L7 Throwable -> L55
        if (r6 != null) goto L16;
    L24:
        IAHMCallbackIDL r12 = r6;
    L25:
        r14.a("IAHMIDLIPC", r11.append(r12).append(", ").append(r35).append(")").toString());     // Catch: Exception -> L7 Throwable -> L55
        goto L26
    L16:
        if (ZeusTransformUtils.instanceOf(r6, AHMCallbackIDLIpcWrapper.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r6, AHMCallbackIDLStubWrapper.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r6, IAHMCallbackIDL.Stub.class) == false) goto L23;
        r12 = a.a((IAHMCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IAHMCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L7 Throwable -> L55
        goto L25
    L23:
        r12 = a.a(r6, true);     // Catch: Exception -> L7 Throwable -> L55
    L26:
        IAHMIDL r13 = this.origin;     // Catch: Throwable -> L48 Exception -> L49
        if (r6 != null) goto L30;
    L39:
        IAHMCallbackIDL r7 = r6;
    L40:
        r10 = r13.ipc_ahm_open_v2(r7, r35);     // Catch: Throwable -> L48 Exception -> L49
    L46:
        e = e;
        goto L51
    L42:
        if (this.log == false) goto L44;
        j.f18676a.c("IAHMIDLIPC", "ipc_ahm_open_v2 = " + r10);     // Catch: Exception -> L46 Throwable -> L53
    L44:
        long r23 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L46 Throwable -> L53
        long r15 = Math.max(0, r23 - r8) / 1000;     // Catch: Exception -> L46 Throwable -> L53
        k.f18677a.a("IAHMIDLIPC", "ipc_ahm_open_v2(" + r6 + ", " + r35 + ") = " + r10, r15);     // Catch: Exception -> L46 Throwable -> L53
        d.f18654a.a("IAHMIDLIPC", "ipc_ahm_open_v2", r15, r23);     // Catch: Exception -> L46 Throwable -> L53
        return r10;
    L30:
        if (ZeusTransformUtils.instanceOf(r6, AHMCallbackIDLIpcWrapper.class) == true) goto L39;
        if (ZeusTransformUtils.instanceOf(r6, AHMCallbackIDLStubWrapper.class) == true) goto L39;
        if (ZeusTransformUtils.instanceOf(r6, IAHMCallbackIDL.Stub.class) == false) goto L37;
        r7 = a.a((IAHMCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IAHMCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L7 Throwable -> L55
        goto L40
    L37:
        r7 = a.a(r6, true);     // Catch: Exception -> L7 Throwable -> L55
        goto L40
    L54:
        return r10;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
