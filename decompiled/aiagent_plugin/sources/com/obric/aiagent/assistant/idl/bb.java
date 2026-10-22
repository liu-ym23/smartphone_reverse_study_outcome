package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: OpenRealTimeCallCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<OpenRealTimeCallCallbackIDLStubWrapper>> f16239a = null;

    public static /* synthetic */ void lambda$UNHio_QlnRr8wJrRDWA8hRVemW0(IOpenRealTimeCallCallbackIDL.Stub r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$eF-XxxwrSr38dkUVEUvklSDLp2Y, reason: not valid java name */
    public static /* synthetic */ boolean m136lambda$eFXxxwrSr38dkUVEUvklSDLp2Y(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16239a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16239a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$bb$eFXxxwrSr38dkUVEUvklSDLp2Y.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IOpenRealTimeCallCallbackIDL.Stub a(final IOpenRealTimeCallCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<OpenRealTimeCallCallbackIDLStubWrapper>> r0 = f16239a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        OpenRealTimeCallCallbackIDLStubWrapper r2 = (OpenRealTimeCallCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), OpenRealTimeCallCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IOpenRealTimeCallCallbackIDL.Stub r7 = (IOpenRealTimeCallCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IOpenRealTimeCallCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, OpenRealTimeCallCallbackIDLStubWrapper.class) == false) goto L16;
        OpenRealTimeCallCallbackIDLStubWrapper r4 = new OpenRealTimeCallCallbackIDLStubWrapper(((OpenRealTimeCallCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, OpenRealTimeCallCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IOpenRealTimeCallCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$bb$UNHio_QlnRr8wJrRDWA8hRVemW0(r5), 0);
        return (IOpenRealTimeCallCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IOpenRealTimeCallCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new OpenRealTimeCallCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IOpenRealTimeCallCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<OpenRealTimeCallCallbackIDLStubWrapper>> r0 = f16239a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IOpenRealTimeCallCallbackIDL a(IOpenRealTimeCallCallbackIDL r3, boolean r4) {
        IOpenRealTimeCallCallbackIDL r5 = (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, OpenRealTimeCallCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.preCheckCast(new OpenRealTimeCallCallbackIDLIpcWrapper(((OpenRealTimeCallCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, OpenRealTimeCallCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IOpenRealTimeCallCallbackIDL) ZeusTransformUtils.preCheckCast(new OpenRealTimeCallCallbackIDLIpcWrapper(r5, r4), IOpenRealTimeCallCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
