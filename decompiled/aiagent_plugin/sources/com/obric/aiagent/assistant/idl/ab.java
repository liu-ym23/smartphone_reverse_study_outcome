package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowFindMessagesCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowFindMessagesCallbackIDLStubWrapper>> f16207a = null;

    public static /* synthetic */ void lambda$7b99jRHRGUJ6c8Ljnf974nXXVXo(IFlowFindMessagesCallbackIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ boolean lambda$pCpoJjn8nWakGmV0uBz91cQQWRQ(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16207a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16207a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$ab$pCpoJjn8nWakGmV0uBz91cQQWRQ.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowFindMessagesCallbackIDL.Stub a(final IFlowFindMessagesCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowFindMessagesCallbackIDLStubWrapper>> r0 = f16207a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowFindMessagesCallbackIDLStubWrapper r2 = (FlowFindMessagesCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowFindMessagesCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowFindMessagesCallbackIDL.Stub r7 = (IFlowFindMessagesCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowFindMessagesCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowFindMessagesCallbackIDLStubWrapper.class) == false) goto L16;
        FlowFindMessagesCallbackIDLStubWrapper r4 = new FlowFindMessagesCallbackIDLStubWrapper(((FlowFindMessagesCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowFindMessagesCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowFindMessagesCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$ab$7b99jRHRGUJ6c8Ljnf974nXXVXo(r5), 0);
        return (IFlowFindMessagesCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowFindMessagesCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowFindMessagesCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowFindMessagesCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowFindMessagesCallbackIDLStubWrapper>> r0 = f16207a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowFindMessagesCallbackIDL a(IFlowFindMessagesCallbackIDL r3, boolean r4) {
        IFlowFindMessagesCallbackIDL r5 = (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowFindMessagesCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowFindMessagesCallbackIDLIpcWrapper(((FlowFindMessagesCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowFindMessagesCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowFindMessagesCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowFindMessagesCallbackIDLIpcWrapper(r5, r4), IFlowFindMessagesCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
