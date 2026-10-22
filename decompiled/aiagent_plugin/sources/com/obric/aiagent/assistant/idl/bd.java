package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: RecordingDeleteCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<RecordingDeleteCallbackIDLStubWrapper>> f16241a = null;

    /* JADX INFO: renamed from: lambda$jype0nqI-U81GjweR0yQbZIOdxI, reason: not valid java name */
    public static /* synthetic */ void m137lambda$jype0nqIU81GjweR0yQbZIOdxI(IRecordingDeleteCallbackIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ boolean lambda$rZ5dMfDfra8rPfUifFmQCj3MtNw(Map.Entry r0) {
        return a(r0);
    }

    static {
        f16241a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16241a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$bd$rZ5dMfDfra8rPfUifFmQCj3MtNw.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IRecordingDeleteCallbackIDL.Stub a(final IRecordingDeleteCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<RecordingDeleteCallbackIDLStubWrapper>> r0 = f16241a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        RecordingDeleteCallbackIDLStubWrapper r2 = (RecordingDeleteCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), RecordingDeleteCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IRecordingDeleteCallbackIDL.Stub r7 = (IRecordingDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IRecordingDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, RecordingDeleteCallbackIDLStubWrapper.class) == false) goto L16;
        RecordingDeleteCallbackIDLStubWrapper r4 = new RecordingDeleteCallbackIDLStubWrapper(((RecordingDeleteCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, RecordingDeleteCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IRecordingDeleteCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$bd$jype0nqIU81GjweR0yQbZIOdxI(r5), 0);
        return (IRecordingDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IRecordingDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new RecordingDeleteCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IRecordingDeleteCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<RecordingDeleteCallbackIDLStubWrapper>> r0 = f16241a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IRecordingDeleteCallbackIDL a(IRecordingDeleteCallbackIDL r3, boolean r4) {
        IRecordingDeleteCallbackIDL r5 = (IRecordingDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, RecordingDeleteCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IRecordingDeleteCallbackIDL) ZeusTransformUtils.preCheckCast(new RecordingDeleteCallbackIDLIpcWrapper(((RecordingDeleteCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, RecordingDeleteCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IRecordingDeleteCallbackIDL) ZeusTransformUtils.preCheckCast(new RecordingDeleteCallbackIDLIpcWrapper(r5, r4), IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
