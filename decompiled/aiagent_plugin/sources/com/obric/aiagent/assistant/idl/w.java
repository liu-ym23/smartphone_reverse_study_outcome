package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowBackgroundInterceptStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowBackgroundInterceptStateListenerIDLStubWrapper>> f16294a = null;

    public static /* synthetic */ void lambda$CDxYg3VJU8X5g2xZbKSIgwK8keI(IFlowBackgroundInterceptStateListenerIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ boolean lambda$JJ46_cF9CNxDYYhAqOa2PRL7tlw(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16294a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16294a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$w$JJ46_cF9CNxDYYhAqOa2PRL7tlw.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowBackgroundInterceptStateListenerIDL.Stub a(final IFlowBackgroundInterceptStateListenerIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowBackgroundInterceptStateListenerIDLStubWrapper>> r0 = f16294a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowBackgroundInterceptStateListenerIDLStubWrapper r2 = (FlowBackgroundInterceptStateListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowBackgroundInterceptStateListenerIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowBackgroundInterceptStateListenerIDL.Stub r7 = (IFlowBackgroundInterceptStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowBackgroundInterceptStateListenerIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowBackgroundInterceptStateListenerIDLStubWrapper.class) == false) goto L16;
        FlowBackgroundInterceptStateListenerIDLStubWrapper r4 = new FlowBackgroundInterceptStateListenerIDLStubWrapper(((FlowBackgroundInterceptStateListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowBackgroundInterceptStateListenerIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowBackgroundInterceptStateListenerIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$w$CDxYg3VJU8X5g2xZbKSIgwK8keI(r5), 0);
        return (IFlowBackgroundInterceptStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowBackgroundInterceptStateListenerIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowBackgroundInterceptStateListenerIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowBackgroundInterceptStateListenerIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowBackgroundInterceptStateListenerIDLStubWrapper>> r0 = f16294a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowBackgroundInterceptStateListenerIDL a(IFlowBackgroundInterceptStateListenerIDL r3, boolean r4) {
        IFlowBackgroundInterceptStateListenerIDL r5 = (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowBackgroundInterceptStateListenerIDLIpcWrapper.class) == false) goto L7;
        return (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.preCheckCast(new FlowBackgroundInterceptStateListenerIDLIpcWrapper(((FlowBackgroundInterceptStateListenerIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowBackgroundInterceptStateListenerIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowBackgroundInterceptStateListenerIDL) ZeusTransformUtils.preCheckCast(new FlowBackgroundInterceptStateListenerIDLIpcWrapper(r5, r4), IFlowBackgroundInterceptStateListenerIDL.class, "com.obric.aiagent.plugin");
    }
}
