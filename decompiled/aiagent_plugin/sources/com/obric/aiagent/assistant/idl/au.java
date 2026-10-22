package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowStreamObserverIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowStreamObserverIDLStubWrapper>> f16230a = null;

    /* JADX INFO: renamed from: lambda$dA07QQW1qO5KZaXPhLo-NIkuwQk, reason: not valid java name */
    public static /* synthetic */ void m131lambda$dA07QQW1qO5KZaXPhLoNIkuwQk(IFlowStreamObserverIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ boolean lambda$s_V5dAonBJQmzXqPCRP1WCY8RJA(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16230a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16230a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$au$s_V5dAonBJQmzXqPCRP1WCY8RJA.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowStreamObserverIDL.Stub a(final IFlowStreamObserverIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowStreamObserverIDLStubWrapper>> r0 = f16230a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowStreamObserverIDLStubWrapper r2 = (FlowStreamObserverIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowStreamObserverIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowStreamObserverIDL.Stub r7 = (IFlowStreamObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowStreamObserverIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowStreamObserverIDLStubWrapper.class) == false) goto L16;
        FlowStreamObserverIDLStubWrapper r4 = new FlowStreamObserverIDLStubWrapper(((FlowStreamObserverIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowStreamObserverIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowStreamObserverIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$au$dA07QQW1qO5KZaXPhLoNIkuwQk(r5), 0);
        return (IFlowStreamObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowStreamObserverIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowStreamObserverIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowStreamObserverIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowStreamObserverIDLStubWrapper>> r0 = f16230a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowStreamObserverIDL a(IFlowStreamObserverIDL r3, boolean r4) {
        IFlowStreamObserverIDL r5 = (IFlowStreamObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowStreamObserverIDLIpcWrapper.class) == false) goto L7;
        return (IFlowStreamObserverIDL) ZeusTransformUtils.preCheckCast(new FlowStreamObserverIDLIpcWrapper(((FlowStreamObserverIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowStreamObserverIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowStreamObserverIDL) ZeusTransformUtils.preCheckCast(new FlowStreamObserverIDLIpcWrapper(r5, r4), IFlowStreamObserverIDL.class, "com.obric.aiagent.plugin");
    }
}
