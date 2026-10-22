package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowNetworkResultCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowNetworkResultCallbackIDLStubWrapper>> f16222a = null;

    /* JADX INFO: renamed from: lambda$CqActvka02myj9JN0R-uiiQlo-Y, reason: not valid java name */
    public static /* synthetic */ void m127lambda$CqActvka02myj9JN0RuiiQloY(IFlowNetworkResultCallbackIDL.Stub r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$ZKG-sCs0lCAOHOWz-rd0AjtmJl4, reason: not valid java name */
    public static /* synthetic */ boolean m128lambda$ZKGsCs0lCAOHOWzrd0AjtmJl4(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16222a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16222a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$an$ZKGsCs0lCAOHOWzrd0AjtmJl4.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowNetworkResultCallbackIDL.Stub a(final IFlowNetworkResultCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowNetworkResultCallbackIDLStubWrapper>> r0 = f16222a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowNetworkResultCallbackIDLStubWrapper r2 = (FlowNetworkResultCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowNetworkResultCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowNetworkResultCallbackIDL.Stub r7 = (IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLStubWrapper.class) == false) goto L16;
        FlowNetworkResultCallbackIDLStubWrapper r4 = new FlowNetworkResultCallbackIDLStubWrapper(((FlowNetworkResultCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowNetworkResultCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowNetworkResultCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$an$CqActvka02myj9JN0RuiiQloY(r5), 0);
        return (IFlowNetworkResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowNetworkResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowNetworkResultCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowNetworkResultCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowNetworkResultCallbackIDLStubWrapper>> r0 = f16222a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowNetworkResultCallbackIDL a(IFlowNetworkResultCallbackIDL r3, boolean r4) {
        IFlowNetworkResultCallbackIDL r5 = (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowNetworkResultCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowNetworkResultCallbackIDLIpcWrapper(((FlowNetworkResultCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowNetworkResultCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowNetworkResultCallbackIDLIpcWrapper(r5, r4), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
