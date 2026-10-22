package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowSendMessageExtCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowSendMessageExtCallbackIDLStubWrapper>> f16227a = null;

    /* JADX INFO: renamed from: lambda$7Jm9v2P-5P8fl2jNebqVJsArKpc, reason: not valid java name */
    public static /* synthetic */ void m129lambda$7Jm9v2P5P8fl2jNebqVJsArKpc(IFlowSendMessageExtCallbackIDL.Stub r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$Z-_1ejvHb2Q0Fk6zGQd4o2Cjvew, reason: not valid java name */
    public static /* synthetic */ boolean m130lambda$Z_1ejvHb2Q0Fk6zGQd4o2Cjvew(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16227a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16227a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$as$Z_1ejvHb2Q0Fk6zGQd4o2Cjvew.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowSendMessageExtCallbackIDL.Stub a(final IFlowSendMessageExtCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowSendMessageExtCallbackIDLStubWrapper>> r0 = f16227a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowSendMessageExtCallbackIDLStubWrapper r2 = (FlowSendMessageExtCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowSendMessageExtCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowSendMessageExtCallbackIDL.Stub r7 = (IFlowSendMessageExtCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowSendMessageExtCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowSendMessageExtCallbackIDLStubWrapper.class) == false) goto L16;
        FlowSendMessageExtCallbackIDLStubWrapper r4 = new FlowSendMessageExtCallbackIDLStubWrapper(((FlowSendMessageExtCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowSendMessageExtCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowSendMessageExtCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$as$7Jm9v2P5P8fl2jNebqVJsArKpc(r5), 0);
        return (IFlowSendMessageExtCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowSendMessageExtCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowSendMessageExtCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowSendMessageExtCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowSendMessageExtCallbackIDLStubWrapper>> r0 = f16227a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowSendMessageExtCallbackIDL a(IFlowSendMessageExtCallbackIDL r3, boolean r4) {
        IFlowSendMessageExtCallbackIDL r5 = (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowSendMessageExtCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowSendMessageExtCallbackIDLIpcWrapper(((FlowSendMessageExtCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowSendMessageExtCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowSendMessageExtCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowSendMessageExtCallbackIDLIpcWrapper(r5, r4), IFlowSendMessageExtCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
