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

/* JADX INFO: compiled from: FlowAppLogEventObserverIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowAppLogEventObserverIDLStubWrapper>> f18589a = null;

    public static /* synthetic */ boolean lambda$IVpjY22LwdyF2eAncKzLGvVkh1Y(Map.Entry r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$lTGO7DHur-EkuS3QdmeGVuT3zoM, reason: not valid java name */
    public static /* synthetic */ void m196lambda$lTGO7DHurEkuS3QdmeGVuT3zoM(IFlowAppLogEventObserverIDL.Stub r0) {
        a(r0);
    }

    static {
        f18589a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        p.a((Iterable) ZeusTransformUtils.preCheckCast(f18589a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$b$IVpjY22LwdyF2eAncKzLGvVkh1Y.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowAppLogEventObserverIDL.Stub a(final IFlowAppLogEventObserverIDL.Stub r5, boolean r6) {
        o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowAppLogEventObserverIDLStubWrapper>> r0 = f18589a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowAppLogEventObserverIDLStubWrapper r2 = (FlowAppLogEventObserverIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowAppLogEventObserverIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowAppLogEventObserverIDL.Stub r7 = (IFlowAppLogEventObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowAppLogEventObserverIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        x r3 = x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowAppLogEventObserverIDLStubWrapper.class) == false) goto L16;
        FlowAppLogEventObserverIDLStubWrapper r4 = new FlowAppLogEventObserverIDLStubWrapper(((FlowAppLogEventObserverIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAppLogEventObserverIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        h.f18670a.a("IFlowAppLogEventObserverIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$b$lTGO7DHurEkuS3QdmeGVuT3zoM(r5), 0);
        return (IFlowAppLogEventObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogEventObserverIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowAppLogEventObserverIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowAppLogEventObserverIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowAppLogEventObserverIDLStubWrapper>> r0 = f18589a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        x r2 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowAppLogEventObserverIDL a(IFlowAppLogEventObserverIDL r3, boolean r4) {
        IFlowAppLogEventObserverIDL r5 = (IFlowAppLogEventObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowAppLogEventObserverIDLIpcWrapper.class) == false) goto L7;
        return (IFlowAppLogEventObserverIDL) ZeusTransformUtils.preCheckCast(new FlowAppLogEventObserverIDLIpcWrapper(((FlowAppLogEventObserverIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAppLogEventObserverIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowAppLogEventObserverIDL) ZeusTransformUtils.preCheckCast(new FlowAppLogEventObserverIDLIpcWrapper(r5, r4), IFlowAppLogEventObserverIDL.class, "com.obric.aiagent.plugin");
    }
}
