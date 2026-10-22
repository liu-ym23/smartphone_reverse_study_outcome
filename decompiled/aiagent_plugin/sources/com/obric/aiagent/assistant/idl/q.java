package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: EntityDeleteCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<EntityDeleteCallbackIDLStubWrapper>> f16285a = null;

    /* JADX INFO: renamed from: lambda$sX0ijCdgTdtsbsFh6bKVQ-Jy7hg, reason: not valid java name */
    public static /* synthetic */ boolean m148lambda$sX0ijCdgTdtsbsFh6bKVQJy7hg(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$vQnZfE2HO32bdFtC6ogrevm_jmE(IEntityDeleteCallbackIDL.Stub r0) {
        a(r0);
    }

    static {
        f16285a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16285a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$q$sX0ijCdgTdtsbsFh6bKVQJy7hg.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IEntityDeleteCallbackIDL.Stub a(final IEntityDeleteCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<EntityDeleteCallbackIDLStubWrapper>> r0 = f16285a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        EntityDeleteCallbackIDLStubWrapper r2 = (EntityDeleteCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), EntityDeleteCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IEntityDeleteCallbackIDL.Stub r7 = (IEntityDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IEntityDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, EntityDeleteCallbackIDLStubWrapper.class) == false) goto L16;
        EntityDeleteCallbackIDLStubWrapper r4 = new EntityDeleteCallbackIDLStubWrapper(((EntityDeleteCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, EntityDeleteCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IEntityDeleteCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$q$vQnZfE2HO32bdFtC6ogrevm_jmE(r5), 0);
        return (IEntityDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IEntityDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new EntityDeleteCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IEntityDeleteCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<EntityDeleteCallbackIDLStubWrapper>> r0 = f16285a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IEntityDeleteCallbackIDL a(IEntityDeleteCallbackIDL r3, boolean r4) {
        IEntityDeleteCallbackIDL r5 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, EntityDeleteCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IEntityDeleteCallbackIDL) ZeusTransformUtils.preCheckCast(new EntityDeleteCallbackIDLIpcWrapper(((EntityDeleteCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, EntityDeleteCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IEntityDeleteCallbackIDL) ZeusTransformUtils.preCheckCast(new EntityDeleteCallbackIDLIpcWrapper(r5, r4), IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
