package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: DowngradeAuthForDoraCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<DowngradeAuthForDoraCallbackIDLStubWrapper>> f16284a = null;

    /* JADX INFO: renamed from: lambda$-WB0LbHf7CXmyj3iVllV7kbVksQ, reason: not valid java name */
    public static /* synthetic */ void m147lambda$WB0LbHf7CXmyj3iVllV7kbVksQ(IDowngradeAuthForDoraCallbackIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ boolean lambda$8y5yq__TSpHUjyjgQActIL89QHQ(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16284a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16284a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$p$8y5yq__TSpHUjyjgQActIL89QHQ.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IDowngradeAuthForDoraCallbackIDL.Stub a(final IDowngradeAuthForDoraCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<DowngradeAuthForDoraCallbackIDLStubWrapper>> r0 = f16284a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        DowngradeAuthForDoraCallbackIDLStubWrapper r2 = (DowngradeAuthForDoraCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), DowngradeAuthForDoraCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IDowngradeAuthForDoraCallbackIDL.Stub r7 = (IDowngradeAuthForDoraCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IDowngradeAuthForDoraCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, DowngradeAuthForDoraCallbackIDLStubWrapper.class) == false) goto L16;
        DowngradeAuthForDoraCallbackIDLStubWrapper r4 = new DowngradeAuthForDoraCallbackIDLStubWrapper(((DowngradeAuthForDoraCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, DowngradeAuthForDoraCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IDowngradeAuthForDoraCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$p$WB0LbHf7CXmyj3iVllV7kbVksQ(r5), 0);
        return (IDowngradeAuthForDoraCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IDowngradeAuthForDoraCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new DowngradeAuthForDoraCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IDowngradeAuthForDoraCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<DowngradeAuthForDoraCallbackIDLStubWrapper>> r0 = f16284a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IDowngradeAuthForDoraCallbackIDL a(IDowngradeAuthForDoraCallbackIDL r3, boolean r4) {
        IDowngradeAuthForDoraCallbackIDL r5 = (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, DowngradeAuthForDoraCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.preCheckCast(new DowngradeAuthForDoraCallbackIDLIpcWrapper(((DowngradeAuthForDoraCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, DowngradeAuthForDoraCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IDowngradeAuthForDoraCallbackIDL) ZeusTransformUtils.preCheckCast(new DowngradeAuthForDoraCallbackIDLIpcWrapper(r5, r4), IDowngradeAuthForDoraCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
