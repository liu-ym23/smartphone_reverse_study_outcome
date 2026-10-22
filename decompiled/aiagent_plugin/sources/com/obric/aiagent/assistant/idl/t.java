package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowAssistantActiveStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowAssistantActiveStateListenerIDLStubWrapper>> f16290a = null;

    public static /* synthetic */ boolean lambda$ANnr36ivUfpAyFLIyYgakvfCiNQ(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$FJyehx9HbMOAEpJPG08_Ek37_Yw(IFlowAssistantActiveStateListenerIDL.Stub r0) {
        a(r0);
    }

    static {
        f16290a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16290a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$t$ANnr36ivUfpAyFLIyYgakvfCiNQ.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowAssistantActiveStateListenerIDL.Stub a(final IFlowAssistantActiveStateListenerIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowAssistantActiveStateListenerIDLStubWrapper>> r0 = f16290a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowAssistantActiveStateListenerIDLStubWrapper r2 = (FlowAssistantActiveStateListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowAssistantActiveStateListenerIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowAssistantActiveStateListenerIDL.Stub r7 = (IFlowAssistantActiveStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowAssistantActiveStateListenerIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowAssistantActiveStateListenerIDLStubWrapper.class) == false) goto L16;
        FlowAssistantActiveStateListenerIDLStubWrapper r4 = new FlowAssistantActiveStateListenerIDLStubWrapper(((FlowAssistantActiveStateListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAssistantActiveStateListenerIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowAssistantActiveStateListenerIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$t$FJyehx9HbMOAEpJPG08_Ek37_Yw(r5), 0);
        return (IFlowAssistantActiveStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAssistantActiveStateListenerIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowAssistantActiveStateListenerIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowAssistantActiveStateListenerIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowAssistantActiveStateListenerIDLStubWrapper>> r0 = f16290a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowAssistantActiveStateListenerIDL a(IFlowAssistantActiveStateListenerIDL r3, boolean r4) {
        IFlowAssistantActiveStateListenerIDL r5 = (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowAssistantActiveStateListenerIDLIpcWrapper.class) == false) goto L7;
        return (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.preCheckCast(new FlowAssistantActiveStateListenerIDLIpcWrapper(((FlowAssistantActiveStateListenerIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAssistantActiveStateListenerIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowAssistantActiveStateListenerIDL) ZeusTransformUtils.preCheckCast(new FlowAssistantActiveStateListenerIDLIpcWrapper(r5, r4), IFlowAssistantActiveStateListenerIDL.class, "com.obric.aiagent.plugin");
    }
}
