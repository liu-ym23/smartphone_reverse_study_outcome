package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: AgentPrivacyIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<AgentPrivacyIDLStubWrapper>> f16276a = null;

    public static /* synthetic */ void lambda$FQA9_5kWz_uix7g9ydMyasUGvIc(IAgentPrivacyIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ boolean lambda$VO2SeTiYIdnF8UFAc9h65qTM7rc(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ IAgentPrivacyIDL.Stub a(d.m.c r1, boolean r2, int r3, Object r4) {
        d.m.c r5 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r1, d.m.c.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IAgentPrivacyIDL.Stub a(d.m.c<IAgentPrivacyIDL> r2, boolean r3) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return a((IAgentPrivacyIDL.Stub) ZeusTransformUtils.preCheckCast(new AgentPrivacyIDLStub(), IAgentPrivacyIDL.Stub.class, "com.obric.aiagent.plugin"), r3);
    }

    static {
        f16276a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16276a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$h$VO2SeTiYIdnF8UFAc9h65qTM7rc.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IAgentPrivacyIDL.Stub a(final IAgentPrivacyIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<AgentPrivacyIDLStubWrapper>> r0 = f16276a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        AgentPrivacyIDLStubWrapper r2 = (AgentPrivacyIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), AgentPrivacyIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IAgentPrivacyIDL.Stub r7 = (IAgentPrivacyIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IAgentPrivacyIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, AgentPrivacyIDLStubWrapper.class) == false) goto L16;
        AgentPrivacyIDLStubWrapper r4 = new AgentPrivacyIDLStubWrapper(((AgentPrivacyIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, AgentPrivacyIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IAgentPrivacyIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$h$FQA9_5kWz_uix7g9ydMyasUGvIc(r5), 0);
        return (IAgentPrivacyIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAgentPrivacyIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new AgentPrivacyIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IAgentPrivacyIDL.Stub r1) {
        Map<IBinder, WeakReference<AgentPrivacyIDLStubWrapper>> r0 = f16276a;
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
