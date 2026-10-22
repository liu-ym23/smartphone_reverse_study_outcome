package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ImageXUploadCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<ImageXUploadCallbackIDLStubWrapper>> f16235a = null;

    /* JADX INFO: renamed from: lambda$6k-U78yEOrBY9anamoEphoT4Xws, reason: not valid java name */
    public static /* synthetic */ boolean m133lambda$6kU78yEOrBY9anamoEphoT4Xws(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$gfujdyPOgK65RRCmbaTTTF6RARw(IImageXUploadCallbackIDL.Stub r0) {
        a(r0);
    }

    static {
        f16235a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(f16235a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$ay$6kU78yEOrBY9anamoEphoT4Xws.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IImageXUploadCallbackIDL.Stub a(final IImageXUploadCallbackIDL.Stub r5, boolean r6) {
        d.h.b.o.e(r5, "<this>");
        Map<IBinder, WeakReference<ImageXUploadCallbackIDLStubWrapper>> r0 = f16235a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        ImageXUploadCallbackIDLStubWrapper r2 = (ImageXUploadCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), ImageXUploadCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IImageXUploadCallbackIDL.Stub r7 = (IImageXUploadCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IImageXUploadCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, ImageXUploadCallbackIDLStubWrapper.class) == false) goto L16;
        ImageXUploadCallbackIDLStubWrapper r4 = new ImageXUploadCallbackIDLStubWrapper(((ImageXUploadCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, ImageXUploadCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.h.f18670a.a("IImageXUploadCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        d.h.b.o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$ay$gfujdyPOgK65RRCmbaTTTF6RARw(r5), 0);
        return (IImageXUploadCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IImageXUploadCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new ImageXUploadCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IImageXUploadCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<ImageXUploadCallbackIDLStubWrapper>> r0 = f16235a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IImageXUploadCallbackIDL a(IImageXUploadCallbackIDL r3, boolean r4) {
        IImageXUploadCallbackIDL r5 = (IImageXUploadCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, ImageXUploadCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IImageXUploadCallbackIDL) ZeusTransformUtils.preCheckCast(new ImageXUploadCallbackIDLIpcWrapper(((ImageXUploadCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, ImageXUploadCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IImageXUploadCallbackIDL) ZeusTransformUtils.preCheckCast(new ImageXUploadCallbackIDLIpcWrapper(r5, r4), IImageXUploadCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
