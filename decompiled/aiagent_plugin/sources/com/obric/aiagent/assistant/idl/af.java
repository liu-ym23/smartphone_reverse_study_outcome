package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowGetLocationCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowGetLocationCallbackIDLStubWrapper>> f16212a = null;

    /* JADX INFO: renamed from: lambda$L93XgLc-b2pRaH8pXHPHQVmuJMA, reason: not valid java name */
    public static /* synthetic */ void m121lambda$L93XgLcb2pRaH8pXHPHQVmuJMA(IFlowGetLocationCallbackIDL.Stub r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$lyv5C-Xo3RQYueeTeYYLFapHNDs, reason: not valid java name */
    public static /* synthetic */ boolean m122lambda$lyv5CXo3RQYueeTeYYLFapHNDs(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16212a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16212a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$af$lyv5CXo3RQYueeTeYYLFapHNDs.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowGetLocationCallbackIDL.Stub a(final IFlowGetLocationCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowGetLocationCallbackIDLStubWrapper>> r0 = f16212a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowGetLocationCallbackIDLStubWrapper r2 = (FlowGetLocationCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowGetLocationCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowGetLocationCallbackIDL.Stub r7 = (IFlowGetLocationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowGetLocationCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowGetLocationCallbackIDLStubWrapper.class) == false) goto L16;
        FlowGetLocationCallbackIDLStubWrapper r4 = new FlowGetLocationCallbackIDLStubWrapper(((FlowGetLocationCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowGetLocationCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowGetLocationCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$af$L93XgLcb2pRaH8pXHPHQVmuJMA(r5), 0);
        return (IFlowGetLocationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowGetLocationCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowGetLocationCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowGetLocationCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowGetLocationCallbackIDLStubWrapper>> r0 = f16212a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowGetLocationCallbackIDL a(IFlowGetLocationCallbackIDL r3, boolean r4) {
        IFlowGetLocationCallbackIDL r5 = (IFlowGetLocationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowGetLocationCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IFlowGetLocationCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowGetLocationCallbackIDLIpcWrapper(((FlowGetLocationCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowGetLocationCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowGetLocationCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowGetLocationCallbackIDLIpcWrapper(r5, r4), IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
