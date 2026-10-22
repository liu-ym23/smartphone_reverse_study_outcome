package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: AgentDMStateManagerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<AgentDMStateManagerIDLStubWrapper>> f16272a = null;

    public static /* synthetic */ boolean lambda$D5_YOQZaCRKP26YYPvaSbHIOn_4(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$maGmZk9Ca7n5CiscYCC8CgCveLE(IAgentDMStateManagerIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ IAgentDMStateManagerIDL.Stub a(d.m.c r1, boolean r2, int r3, Object r4) {
        d.m.c r5 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r1, d.m.c.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IAgentDMStateManagerIDL.Stub a(d.m.c<IAgentDMStateManagerIDL> r2, boolean r3) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return a((IAgentDMStateManagerIDL.Stub) ZeusTransformUtils.preCheckCast(new AgentDMStateManagerIDLStub(), IAgentDMStateManagerIDL.Stub.class, "com.obric.aiagent.plugin"), r3);
    }

    static {
        f16272a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16272a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$d$D5_YOQZaCRKP26YYPvaSbHIOn_4.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IAgentDMStateManagerIDL.Stub a(final IAgentDMStateManagerIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<AgentDMStateManagerIDLStubWrapper>> r0 = f16272a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        AgentDMStateManagerIDLStubWrapper r2 = (AgentDMStateManagerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), AgentDMStateManagerIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IAgentDMStateManagerIDL.Stub r7 = (IAgentDMStateManagerIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IAgentDMStateManagerIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, AgentDMStateManagerIDLStubWrapper.class) == false) goto L16;
        AgentDMStateManagerIDLStubWrapper r4 = new AgentDMStateManagerIDLStubWrapper(((AgentDMStateManagerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, AgentDMStateManagerIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IAgentDMStateManagerIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$d$maGmZk9Ca7n5CiscYCC8CgCveLE(r5), 0);
        return (IAgentDMStateManagerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentDMStateManagerIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new AgentDMStateManagerIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IAgentDMStateManagerIDL.Stub r1) {
        Map<IBinder, WeakReference<AgentDMStateManagerIDLStubWrapper>> r0 = f16272a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
