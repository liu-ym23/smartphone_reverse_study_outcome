package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: AssistantInteractionListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<AssistantInteractionListenerIDLStubWrapper>> f16282a = null;

    public static /* synthetic */ void lambda$KqTKHELrZx5kOUEisRXWXnCH6WA(IAssistantInteractionListenerIDL.Stub r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$n7UtrLz3CuE-6rV2rc4mvShZjdk, reason: not valid java name */
    public static /* synthetic */ boolean m146lambda$n7UtrLz3CuE6rV2rc4mvShZjdk(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16282a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16282a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$n$n7UtrLz3CuE6rV2rc4mvShZjdk.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IAssistantInteractionListenerIDL.Stub a(final IAssistantInteractionListenerIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<AssistantInteractionListenerIDLStubWrapper>> r0 = f16282a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        AssistantInteractionListenerIDLStubWrapper r2 = (AssistantInteractionListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), AssistantInteractionListenerIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IAssistantInteractionListenerIDL.Stub r7 = (IAssistantInteractionListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IAssistantInteractionListenerIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, AssistantInteractionListenerIDLStubWrapper.class) == false) goto L16;
        AssistantInteractionListenerIDLStubWrapper r4 = new AssistantInteractionListenerIDLStubWrapper(((AssistantInteractionListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, AssistantInteractionListenerIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IAssistantInteractionListenerIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$n$KqTKHELrZx5kOUEisRXWXnCH6WA(r5), 0);
        return (IAssistantInteractionListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAssistantInteractionListenerIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new AssistantInteractionListenerIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IAssistantInteractionListenerIDL.Stub r1) {
        Map<IBinder, WeakReference<AssistantInteractionListenerIDLStubWrapper>> r0 = f16282a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IAssistantInteractionListenerIDL a(IAssistantInteractionListenerIDL r3, boolean r4) {
        IAssistantInteractionListenerIDL r5 = (IAssistantInteractionListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, AssistantInteractionListenerIDLIpcWrapper.class) == false) goto L7;
        return (IAssistantInteractionListenerIDL) ZeusTransformUtils.preCheckCast(new AssistantInteractionListenerIDLIpcWrapper(((AssistantInteractionListenerIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, AssistantInteractionListenerIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IAssistantInteractionListenerIDL) ZeusTransformUtils.preCheckCast(new AssistantInteractionListenerIDLIpcWrapper(r5, r4), IAssistantInteractionListenerIDL.class, "com.obric.aiagent.plugin");
    }
}
