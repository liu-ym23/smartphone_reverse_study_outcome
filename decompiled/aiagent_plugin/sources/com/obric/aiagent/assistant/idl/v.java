package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowAssistantTTSStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowAssistantTTSStateListenerIDLStubWrapper>> f16293a = null;

    public static /* synthetic */ boolean lambda$3Fwb3bEHsKCtSCZWXYhCxDhMxqY(Map.Entry r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$XvjUlqmDNKzYow_TfVHetA8uK-k, reason: not valid java name */
    public static /* synthetic */ void m149lambda$XvjUlqmDNKzYow_TfVHetA8uKk(IFlowAssistantTTSStateListenerIDL.Stub r0) {
        a(r0);
    }

    static {
        f16293a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16293a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$v$3Fwb3bEHsKCtSCZWXYhCxDhMxqY.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowAssistantTTSStateListenerIDL.Stub a(final IFlowAssistantTTSStateListenerIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowAssistantTTSStateListenerIDLStubWrapper>> r0 = f16293a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowAssistantTTSStateListenerIDLStubWrapper r2 = (FlowAssistantTTSStateListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowAssistantTTSStateListenerIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowAssistantTTSStateListenerIDL.Stub r7 = (IFlowAssistantTTSStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowAssistantTTSStateListenerIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowAssistantTTSStateListenerIDLStubWrapper.class) == false) goto L16;
        FlowAssistantTTSStateListenerIDLStubWrapper r4 = new FlowAssistantTTSStateListenerIDLStubWrapper(((FlowAssistantTTSStateListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAssistantTTSStateListenerIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowAssistantTTSStateListenerIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$v$XvjUlqmDNKzYow_TfVHetA8uKk(r5), 0);
        return (IFlowAssistantTTSStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantTTSStateListenerIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowAssistantTTSStateListenerIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowAssistantTTSStateListenerIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowAssistantTTSStateListenerIDLStubWrapper>> r0 = f16293a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowAssistantTTSStateListenerIDL a(IFlowAssistantTTSStateListenerIDL r3, boolean r4) {
        IFlowAssistantTTSStateListenerIDL r5 = (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowAssistantTTSStateListenerIDLIpcWrapper.class) == false) goto L7;
        return (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.preCheckCast(new FlowAssistantTTSStateListenerIDLIpcWrapper(((FlowAssistantTTSStateListenerIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAssistantTTSStateListenerIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowAssistantTTSStateListenerIDL) ZeusTransformUtils.preCheckCast(new FlowAssistantTTSStateListenerIDLIpcWrapper(r5, r4), IFlowAssistantTTSStateListenerIDL.class, "com.obric.aiagent.plugin");
    }
}
