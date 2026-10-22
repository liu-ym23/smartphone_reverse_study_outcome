package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FlowSemanticEditCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FlowSemanticEditCallbackIDLStubWrapper>> f16226a = null;

    public static /* synthetic */ boolean lambda$iRESVEgknQGVvRe03eRvq_GUPgM(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$o0OCylZN8Rwgrp00r21CvBsU4pQ(IFlowSemanticEditCallbackIDL.Stub r0) {
        a(r0);
    }

    static {
        f16226a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16226a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$ar$iRESVEgknQGVvRe03eRvq_GUPgM.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFlowSemanticEditCallbackIDL.Stub a(final IFlowSemanticEditCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<FlowSemanticEditCallbackIDLStubWrapper>> r0 = f16226a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FlowSemanticEditCallbackIDLStubWrapper r2 = (FlowSemanticEditCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FlowSemanticEditCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFlowSemanticEditCallbackIDL.Stub r7 = (IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FlowSemanticEditCallbackIDLStubWrapper.class) == false) goto L16;
        FlowSemanticEditCallbackIDLStubWrapper r4 = new FlowSemanticEditCallbackIDLStubWrapper(((FlowSemanticEditCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FlowSemanticEditCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IFlowSemanticEditCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$ar$o0OCylZN8Rwgrp00r21CvBsU4pQ(r5), 0);
        return (IFlowSemanticEditCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFlowSemanticEditCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FlowSemanticEditCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFlowSemanticEditCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<FlowSemanticEditCallbackIDLStubWrapper>> r0 = f16226a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFlowSemanticEditCallbackIDL a(IFlowSemanticEditCallbackIDL r3, boolean r4) {
        IFlowSemanticEditCallbackIDL r5 = (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FlowSemanticEditCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowSemanticEditCallbackIDLIpcWrapper(((FlowSemanticEditCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FlowSemanticEditCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFlowSemanticEditCallbackIDL) ZeusTransformUtils.preCheckCast(new FlowSemanticEditCallbackIDLIpcWrapper(r5, r4), IFlowSemanticEditCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
