package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowIsMessageInterruptedCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowIsMessageInterruptedCallbackIDLStubWrapper>> f16215a = null;

    public static /* synthetic */ boolean lambda$Y9C6YCSiczIFGZakFR58BvigA6k(Map.Entry r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$pacX2zW_5LUQj-ZyUUY7fsihAEY, reason: not valid java name */
    public static /* synthetic */ void m125lambda$pacX2zW_5LUQjZyUUY7fsihAEY(IFlowIsMessageInterruptedCallbackIDL.Stub r0) {
        a(r0);
    }

    static {
        f16215a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16215a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$ah$Y9C6YCSiczIFGZakFR58BvigA6k.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowIsMessageInterruptedCallbackIDL.Stub a(final IFlowIsMessageInterruptedCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowIsMessageInterruptedCallbackIDLStubWrapper>> r0 = f16215a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowIsMessageInterruptedCallbackIDLStubWrapper r2 = (FlowIsMessageInterruptedCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowIsMessageInterruptedCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowIsMessageInterruptedCallbackIDL.Stub r7 = (IFlowIsMessageInterruptedCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowIsMessageInterruptedCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowIsMessageInterruptedCallbackIDLStubWrapper.class) == false) goto L16;
        FlowIsMessageInterruptedCallbackIDLStubWrapper r4 = new FlowIsMessageInterruptedCallbackIDLStubWrapper(((FlowIsMessageInterruptedCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowIsMessageInterruptedCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowIsMessageInterruptedCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$ah$pacX2zW_5LUQjZyUUY7fsihAEY(r5), 0);
        return (IFlowIsMessageInterruptedCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowIsMessageInterruptedCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowIsMessageInterruptedCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowIsMessageInterruptedCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowIsMessageInterruptedCallbackIDLStubWrapper>> r0 = f16215a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowIsMessageInterruptedCallbackIDL a(IFlowIsMessageInterruptedCallbackIDL r3, boolean r4) {
        IFlowIsMessageInterruptedCallbackIDL r5 = (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowIsMessageInterruptedCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowIsMessageInterruptedCallbackIDLIpcWrapper(((FlowIsMessageInterruptedCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowIsMessageInterruptedCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowIsMessageInterruptedCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowIsMessageInterruptedCallbackIDLIpcWrapper(r5, r4), IFlowIsMessageInterruptedCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
