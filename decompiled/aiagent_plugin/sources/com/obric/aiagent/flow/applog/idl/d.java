package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import com.obric.aiagent.ipc.utils.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowAppLogSessionObserverIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowAppLogSessionObserverIDLStubWrapper>> f18592a = null;

    public static /* synthetic */ boolean lambda$qZPe9I2AuUmMVN_Ssjh2qofW8P4(Map.Entry r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$vWk2B-AtVSm4pHqcbXCzvin4jSE, reason: not valid java name */
    public static /* synthetic */ void m197lambda$vWk2BAtVSm4pHqcbXCzvin4jSE(IFlowAppLogSessionObserverIDL.Stub r0) {
        a(r0);
    }

    static {
        f18592a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        p.a((Iterable) ZeusTransformUtils.preCheckCast(f18592a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$d$qZPe9I2AuUmMVN_Ssjh2qofW8P4.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowAppLogSessionObserverIDL.Stub a(final IFlowAppLogSessionObserverIDL.Stub r5, boolean r6) {
        o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowAppLogSessionObserverIDLStubWrapper>> r0 = f18592a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowAppLogSessionObserverIDLStubWrapper r2 = (FlowAppLogSessionObserverIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowAppLogSessionObserverIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowAppLogSessionObserverIDL.Stub r7 = (IFlowAppLogSessionObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowAppLogSessionObserverIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        x r3 = x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowAppLogSessionObserverIDLStubWrapper.class) == false) goto L16;
        FlowAppLogSessionObserverIDLStubWrapper r4 = new FlowAppLogSessionObserverIDLStubWrapper(((FlowAppLogSessionObserverIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAppLogSessionObserverIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        h.f18670a.a("IFlowAppLogSessionObserverIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$d$vWk2BAtVSm4pHqcbXCzvin4jSE(r5), 0);
        return (IFlowAppLogSessionObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogSessionObserverIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowAppLogSessionObserverIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowAppLogSessionObserverIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowAppLogSessionObserverIDLStubWrapper>> r0 = f18592a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        x r2 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowAppLogSessionObserverIDL a(IFlowAppLogSessionObserverIDL r3, boolean r4) {
        IFlowAppLogSessionObserverIDL r5 = (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowAppLogSessionObserverIDLIpcWrapper.class) == false) goto L7;
        return (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.preCheckCast(new FlowAppLogSessionObserverIDLIpcWrapper(((FlowAppLogSessionObserverIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAppLogSessionObserverIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowAppLogSessionObserverIDL) ZeusTransformUtils.preCheckCast(new FlowAppLogSessionObserverIDLIpcWrapper(r5, r4), IFlowAppLogSessionObserverIDL.class, "com.obric.aiagent.plugin");
    }
}
