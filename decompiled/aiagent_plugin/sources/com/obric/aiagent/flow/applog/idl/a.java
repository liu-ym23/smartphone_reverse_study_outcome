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

/* JADX INFO: compiled from: FlowAppLogDataObserverIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowAppLogDataObserverIDLStubWrapper>> f18588a = null;

    public static /* synthetic */ boolean lambda$Ip_su41_LLskD38vfI55psA6vss(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$MfNjx7Ix79qnSbUQmgRJtCIDOUY(IFlowAppLogDataObserverIDL.Stub r0) {
        a(r0);
    }

    static {
        f18588a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        p.a((Iterable) ZeusTransformUtils.preCheckCast(f18588a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$a$Ip_su41_LLskD38vfI55psA6vss.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowAppLogDataObserverIDL.Stub a(final IFlowAppLogDataObserverIDL.Stub r5, boolean r6) {
        o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowAppLogDataObserverIDLStubWrapper>> r0 = f18588a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowAppLogDataObserverIDLStubWrapper r2 = (FlowAppLogDataObserverIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowAppLogDataObserverIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowAppLogDataObserverIDL.Stub r7 = (IFlowAppLogDataObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowAppLogDataObserverIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        x r3 = x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowAppLogDataObserverIDLStubWrapper.class) == false) goto L16;
        FlowAppLogDataObserverIDLStubWrapper r4 = new FlowAppLogDataObserverIDLStubWrapper(((FlowAppLogDataObserverIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAppLogDataObserverIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        h.f18670a.a("IFlowAppLogDataObserverIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$a$MfNjx7Ix79qnSbUQmgRJtCIDOUY(r5), 0);
        return (IFlowAppLogDataObserverIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowAppLogDataObserverIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowAppLogDataObserverIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowAppLogDataObserverIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowAppLogDataObserverIDLStubWrapper>> r0 = f18588a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        x r2 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowAppLogDataObserverIDL a(IFlowAppLogDataObserverIDL r3, boolean r4) {
        IFlowAppLogDataObserverIDL r5 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowAppLogDataObserverIDLIpcWrapper.class) == false) goto L7;
        return (IFlowAppLogDataObserverIDL) ZeusTransformUtils.preCheckCast(new FlowAppLogDataObserverIDLIpcWrapper(((FlowAppLogDataObserverIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowAppLogDataObserverIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowAppLogDataObserverIDL) ZeusTransformUtils.preCheckCast(new FlowAppLogDataObserverIDLIpcWrapper(r5, r4), IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
    }
}
