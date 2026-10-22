package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowIDLStubWrapper>> f16213a = null;

    /* JADX INFO: compiled from: FlowIDLExt.kt */
    public static final class a implements com.obric.aiagent.ipc.utils.i.b<IFlowIDL> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.ipc.utils.i.b<IFlowIDL> f16214a;

        a(com.obric.aiagent.ipc.utils.i.b<IFlowIDL> r3) {
            this.f16214a = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.ipc.utils.i.b
        public /* synthetic */ void onRegister(IFlowIDL r3) {
            a((IFlowIDL) ZeusTransformUtils.preCheckCast(r3, IFlowIDL.class, "com.obric.aiagent.plugin"));
        }

        public void a(IFlowIDL r5) {
            IFlowIDL r6 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r5, IFlowIDL.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "inst");
            com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"));
            this.f16214a.onRegister(r6);
        }
    }

    /* JADX INFO: renamed from: lambda$_RDf0yKt4F5ESrrMTthpmyg-oYI, reason: not valid java name */
    public static /* synthetic */ boolean m123lambda$_RDf0yKt4F5ESrrMTthpmygoYI(Map.Entry r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$vBphH-4VnczqiylZZnwDoKg1_3E, reason: not valid java name */
    public static /* synthetic */ void m124lambda$vBphH4VnczqiylZZnwDoKg1_3E(IFlowIDL.Stub r0) {
        a(r0);
    }

    public static final IFlowIDL a(d.m.c<IFlowIDL> r2) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return (IFlowIDL) ZeusTransformUtils.preCheckCast(com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowIDL.class), IFlowIDL.class, "com.obric.aiagent.plugin");
    }

    public static final IFlowIDL a(IFlowIDL r8, boolean r9) {
        IFlowIDL r10 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFlowIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IFlowIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFlowIDL r11 = b(r10, r9);
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
        return r11;
    }

    public static /* synthetic */ void a(d.m.c r1, boolean r2, boolean r3, com.obric.aiagent.ipc.utils.i.b r4, int r5, Object r6) {
        d.m.c r7 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r1, d.m.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.ipc.utils.i.b r8 = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = false;
    L8:
        a(r7, r2, r3, r8);
    }

    public static final void a(d.m.c<IFlowIDL> r2, boolean r3, boolean r4, com.obric.aiagent.ipc.utils.i.b<IFlowIDL> r5) {
        d.m.c r6 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.ipc.utils.i.b r7 = (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "<this>");
        d.h.b.o.e(r7, "action");
        if (r4 == false) goto L5;
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowIDL.class, (com.obric.aiagent.ipc.utils.i.b) ZeusTransformUtils.preCheckCast(new a(r7), com.obric.aiagent.ipc.utils.i.b.class, "com.obric.aiagent.plugin"), r3);
        return;
    L5:
        com.obric.aiagent.ipc.utils.i.f18671a.a(IFlowIDL.class, r7, r3);
    }

    static {
        f16213a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16213a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$ag$_RDf0yKt4F5ESrrMTthpmygoYI.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowIDL.Stub a(final IFlowIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowIDLStubWrapper>> r0 = f16213a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowIDLStubWrapper r2 = (FlowIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowIDL.Stub r7 = (IFlowIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowIDLStubWrapper.class) == false) goto L16;
        FlowIDLStubWrapper r4 = new FlowIDLStubWrapper(((FlowIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$ag$vBphH4VnczqiylZZnwDoKg1_3E(r5), 0);
        return (IFlowIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowIDLStubWrapper>> r0 = f16213a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowIDL b(IFlowIDL r3, boolean r4) {
        IFlowIDL r5 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowIDLIpcWrapper.class) == false) goto L7;
        return (IFlowIDL) ZeusTransformUtils.preCheckCast(new FlowIDLIpcWrapper(((FlowIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowIDL) ZeusTransformUtils.preCheckCast(new FlowIDLIpcWrapper(r5, r4), IFlowIDL.class, "com.obric.aiagent.plugin");
    }
}
