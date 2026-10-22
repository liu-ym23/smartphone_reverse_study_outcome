package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ObricActionResultCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<ObricActionResultCallbackIDLStubWrapper>> f16238a = null;

    public static /* synthetic */ void lambda$VmQytMgfEDqExZAC1dr0U_mXRvg(IObricActionResultCallbackIDL.Stub r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$kRAGjetFXZxTaC0a-w2lHTWOSj0, reason: not valid java name */
    public static /* synthetic */ boolean m135lambda$kRAGjetFXZxTaC0aw2lHTWOSj0(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16238a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16238a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$ba$kRAGjetFXZxTaC0aw2lHTWOSj0.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IObricActionResultCallbackIDL.Stub a(final IObricActionResultCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<ObricActionResultCallbackIDLStubWrapper>> r0 = f16238a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        ObricActionResultCallbackIDLStubWrapper r2 = (ObricActionResultCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), ObricActionResultCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IObricActionResultCallbackIDL.Stub r7 = (IObricActionResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IObricActionResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, ObricActionResultCallbackIDLStubWrapper.class) == false) goto L16;
        ObricActionResultCallbackIDLStubWrapper r4 = new ObricActionResultCallbackIDLStubWrapper(((ObricActionResultCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, ObricActionResultCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IObricActionResultCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$ba$VmQytMgfEDqExZAC1dr0U_mXRvg(r5), 0);
        return (IObricActionResultCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IObricActionResultCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new ObricActionResultCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IObricActionResultCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<ObricActionResultCallbackIDLStubWrapper>> r0 = f16238a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IObricActionResultCallbackIDL a(IObricActionResultCallbackIDL r3, boolean r4) {
        IObricActionResultCallbackIDL r5 = (IObricActionResultCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IObricActionResultCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, ObricActionResultCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IObricActionResultCallbackIDL) ZeusTransformUtils.preCheckCast(new ObricActionResultCallbackIDLIpcWrapper(((ObricActionResultCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, ObricActionResultCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IObricActionResultCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IObricActionResultCallbackIDL) ZeusTransformUtils.preCheckCast(new ObricActionResultCallbackIDLIpcWrapper(r5, r4), IObricActionResultCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
