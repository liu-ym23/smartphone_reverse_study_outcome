package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowMessageCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowMessageCallbackIDLStubWrapper>> f16216a = null;

    /* JADX INFO: renamed from: lambda$Euaq2tzijRvuM4U2FX1-A4FpVC8, reason: not valid java name */
    public static /* synthetic */ boolean m126lambda$Euaq2tzijRvuM4U2FX1A4FpVC8(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$burJz_tFME_pYbfM5aE7h3ibauE(IFlowMessageCallbackIDL.Stub r0) {
        a(r0);
    }

    static {
        f16216a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16216a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$aj$Euaq2tzijRvuM4U2FX1A4FpVC8.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowMessageCallbackIDL.Stub a(final IFlowMessageCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowMessageCallbackIDLStubWrapper>> r0 = f16216a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowMessageCallbackIDLStubWrapper r2 = (FlowMessageCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowMessageCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowMessageCallbackIDL.Stub r7 = (IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowMessageCallbackIDLStubWrapper.class) == false) goto L16;
        FlowMessageCallbackIDLStubWrapper r4 = new FlowMessageCallbackIDLStubWrapper(((FlowMessageCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowMessageCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowMessageCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$aj$burJz_tFME_pYbfM5aE7h3ibauE(r5), 0);
        return (IFlowMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowMessageCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowMessageCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowMessageCallbackIDLStubWrapper>> r0 = f16216a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowMessageCallbackIDL a(IFlowMessageCallbackIDL r3, boolean r4) {
        IFlowMessageCallbackIDL r5 = (IFlowMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowMessageCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IFlowMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowMessageCallbackIDLIpcWrapper(((FlowMessageCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowMessageCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowMessageCallbackIDLIpcWrapper(r5, r4), IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
