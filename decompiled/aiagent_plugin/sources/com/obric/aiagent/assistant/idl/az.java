package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: MusicStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<MusicStateListenerIDLStubWrapper>> f16236a = null;

    public static /* synthetic */ void lambda$qTmYl_rWsaYZoU9SVnO_azo7mzw(IMusicStateListenerIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ boolean lambda$zOiur6pRBDnCi2iNXtFc3H3XkPc(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16236a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16236a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$az$zOiur6pRBDnCi2iNXtFc3H3XkPc.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IMusicStateListenerIDL.Stub a(final IMusicStateListenerIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<MusicStateListenerIDLStubWrapper>> r0 = f16236a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        MusicStateListenerIDLStubWrapper r2 = (MusicStateListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), MusicStateListenerIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IMusicStateListenerIDL.Stub r7 = (IMusicStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IMusicStateListenerIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, MusicStateListenerIDLStubWrapper.class) == false) goto L16;
        MusicStateListenerIDLStubWrapper r4 = new MusicStateListenerIDLStubWrapper(((MusicStateListenerIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, MusicStateListenerIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IMusicStateListenerIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$az$qTmYl_rWsaYZoU9SVnO_azo7mzw(r5), 0);
        return (IMusicStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IMusicStateListenerIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new MusicStateListenerIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IMusicStateListenerIDL.Stub r1) {
        Map<IBinder, WeakReference<MusicStateListenerIDLStubWrapper>> r0 = f16236a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IMusicStateListenerIDL a(IMusicStateListenerIDL r3, boolean r4) {
        IMusicStateListenerIDL r5 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, MusicStateListenerIDLIpcWrapper.class) == false) goto L7;
        return (IMusicStateListenerIDL) ZeusTransformUtils.preCheckCast(new MusicStateListenerIDLIpcWrapper(((MusicStateListenerIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, MusicStateListenerIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IMusicStateListenerIDL) ZeusTransformUtils.preCheckCast(new MusicStateListenerIDLIpcWrapper(r5, r4), IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
    }
}
