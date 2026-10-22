package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowSyncDataResultIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowSyncDataResultIDLStubWrapper>> f16231a = null;

    public static /* synthetic */ boolean lambda$6mfiLefopFlW0xamYxidazk11cE(Map.Entry r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$hmD_vid1urX_1-g0sh5E20Cr6QY, reason: not valid java name */
    public static /* synthetic */ void m132lambda$hmD_vid1urX_1g0sh5E20Cr6QY(IFlowSyncDataResultIDL.Stub r0) {
        a(r0);
    }

    static {
        f16231a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16231a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$av$6mfiLefopFlW0xamYxidazk11cE.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowSyncDataResultIDL.Stub a(final IFlowSyncDataResultIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowSyncDataResultIDLStubWrapper>> r0 = f16231a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowSyncDataResultIDLStubWrapper r2 = (FlowSyncDataResultIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowSyncDataResultIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowSyncDataResultIDL.Stub r7 = (IFlowSyncDataResultIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowSyncDataResultIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowSyncDataResultIDLStubWrapper.class) == false) goto L16;
        FlowSyncDataResultIDLStubWrapper r4 = new FlowSyncDataResultIDLStubWrapper(((FlowSyncDataResultIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowSyncDataResultIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowSyncDataResultIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$av$hmD_vid1urX_1g0sh5E20Cr6QY(r5), 0);
        return (IFlowSyncDataResultIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowSyncDataResultIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowSyncDataResultIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowSyncDataResultIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowSyncDataResultIDLStubWrapper>> r0 = f16231a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowSyncDataResultIDL a(IFlowSyncDataResultIDL r3, boolean r4) {
        IFlowSyncDataResultIDL r5 = (IFlowSyncDataResultIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSyncDataResultIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowSyncDataResultIDLIpcWrapper.class) == false) goto L7;
        return (IFlowSyncDataResultIDL) ZeusTransformUtils.preCheckCast(new FlowSyncDataResultIDLIpcWrapper(((FlowSyncDataResultIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowSyncDataResultIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowSyncDataResultIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowSyncDataResultIDL) ZeusTransformUtils.preCheckCast(new FlowSyncDataResultIDLIpcWrapper(r5, r4), IFlowSyncDataResultIDL.class, "com.obric.aiagent.plugin");
    }
}
