package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: RequestAuthenticationCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<RequestAuthenticationCallbackIDLStubWrapper>> f16242a = null;

    public static /* synthetic */ void lambda$9GlXcVaMYC9kisLiy_8z8BsTdeU(IRequestAuthenticationCallbackIDL.Stub r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$lVacEfe01Ky5LyU2TiS-sPDZTvE, reason: not valid java name */
    public static /* synthetic */ boolean m138lambda$lVacEfe01Ky5LyU2TiSsPDZTvE(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16242a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16242a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$be$lVacEfe01Ky5LyU2TiSsPDZTvE.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IRequestAuthenticationCallbackIDL.Stub a(final IRequestAuthenticationCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<RequestAuthenticationCallbackIDLStubWrapper>> r0 = f16242a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        RequestAuthenticationCallbackIDLStubWrapper r2 = (RequestAuthenticationCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), RequestAuthenticationCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IRequestAuthenticationCallbackIDL.Stub r7 = (IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, RequestAuthenticationCallbackIDLStubWrapper.class) == false) goto L16;
        RequestAuthenticationCallbackIDLStubWrapper r4 = new RequestAuthenticationCallbackIDLStubWrapper(((RequestAuthenticationCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, RequestAuthenticationCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IRequestAuthenticationCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$be$9GlXcVaMYC9kisLiy_8z8BsTdeU(r5), 0);
        return (IRequestAuthenticationCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IRequestAuthenticationCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new RequestAuthenticationCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IRequestAuthenticationCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<RequestAuthenticationCallbackIDLStubWrapper>> r0 = f16242a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IRequestAuthenticationCallbackIDL a(IRequestAuthenticationCallbackIDL r3, boolean r4) {
        IRequestAuthenticationCallbackIDL r5 = (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, RequestAuthenticationCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.preCheckCast(new RequestAuthenticationCallbackIDLIpcWrapper(((RequestAuthenticationCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, RequestAuthenticationCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IRequestAuthenticationCallbackIDL) ZeusTransformUtils.preCheckCast(new RequestAuthenticationCallbackIDLIpcWrapper(r5, r4), IRequestAuthenticationCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
