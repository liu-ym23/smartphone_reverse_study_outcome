package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PlatformApiIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<PlatformApiIDLStubWrapper>> f16240a = null;

    public static /* synthetic */ void lambda$GotVhPXyGEGcAtFRdIhZE2SPLqA(IPlatformApiIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ boolean lambda$hj3K0PeKRAHF873nY7XXDvtUAV0(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ IPlatformApiIDL.Stub a(d.m.c r1, boolean r2, int r3, Object r4) {
        d.m.c r5 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r1, d.m.c.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IPlatformApiIDL.Stub a(d.m.c<IPlatformApiIDL> r2, boolean r3) {
        d.h.b.o.e((d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin"), "<this>");
        return a((IPlatformApiIDL.Stub) ZeusTransformUtils.preCheckCast(new PlatformApiIDLStub(), IPlatformApiIDL.Stub.class, "com.obric.aiagent.plugin"), r3);
    }

    static {
        f16240a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16240a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$bc$hj3K0PeKRAHF873nY7XXDvtUAV0.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IPlatformApiIDL.Stub a(final IPlatformApiIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<PlatformApiIDLStubWrapper>> r0 = f16240a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        PlatformApiIDLStubWrapper r2 = (PlatformApiIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), PlatformApiIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IPlatformApiIDL.Stub r7 = (IPlatformApiIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IPlatformApiIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, PlatformApiIDLStubWrapper.class) == false) goto L16;
        PlatformApiIDLStubWrapper r4 = new PlatformApiIDLStubWrapper(((PlatformApiIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, PlatformApiIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPlatformApiIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$bc$GotVhPXyGEGcAtFRdIhZE2SPLqA(r5), 0);
        return (IPlatformApiIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IPlatformApiIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new PlatformApiIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IPlatformApiIDL.Stub r1) {
        Map<IBinder, WeakReference<PlatformApiIDLStubWrapper>> r0 = f16240a;
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
