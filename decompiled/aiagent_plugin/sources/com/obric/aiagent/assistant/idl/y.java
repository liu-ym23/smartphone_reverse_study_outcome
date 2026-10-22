package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowDeleteMessageCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowDeleteMessageCallbackIDLStubWrapper>> f16296a = null;

    public static /* synthetic */ void lambda$DV4wByqOr8OV7URVAxldzf9stJI(IFlowDeleteMessageCallbackIDL.Stub r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$g55oFXo214-zssDX1XCORSPs_5c, reason: not valid java name */
    public static /* synthetic */ boolean m150lambda$g55oFXo214zssDX1XCORSPs_5c(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16296a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16296a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$y$g55oFXo214zssDX1XCORSPs_5c.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowDeleteMessageCallbackIDL.Stub a(final IFlowDeleteMessageCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowDeleteMessageCallbackIDLStubWrapper>> r0 = f16296a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowDeleteMessageCallbackIDLStubWrapper r2 = (FlowDeleteMessageCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowDeleteMessageCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowDeleteMessageCallbackIDL.Stub r7 = (IFlowDeleteMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowDeleteMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowDeleteMessageCallbackIDLStubWrapper.class) == false) goto L16;
        FlowDeleteMessageCallbackIDLStubWrapper r4 = new FlowDeleteMessageCallbackIDLStubWrapper(((FlowDeleteMessageCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowDeleteMessageCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowDeleteMessageCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$y$DV4wByqOr8OV7URVAxldzf9stJI(r5), 0);
        return (IFlowDeleteMessageCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowDeleteMessageCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowDeleteMessageCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowDeleteMessageCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowDeleteMessageCallbackIDLStubWrapper>> r0 = f16296a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowDeleteMessageCallbackIDL a(IFlowDeleteMessageCallbackIDL r3, boolean r4) {
        IFlowDeleteMessageCallbackIDL r5 = (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowDeleteMessageCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowDeleteMessageCallbackIDLIpcWrapper(((FlowDeleteMessageCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowDeleteMessageCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowDeleteMessageCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowDeleteMessageCallbackIDLIpcWrapper(r5, r4), IFlowDeleteMessageCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
