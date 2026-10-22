package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m.c;
import d.x;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: FileIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<FileIDLStubWrapper>> f18638a = null;

    /* JADX INFO: renamed from: lambda$0Gnvu2ea1RfW-EfJsWpgFKMG9Gw, reason: not valid java name */
    public static /* synthetic */ boolean m199lambda$0Gnvu2ea1RfWEfJsWpgFKMG9Gw(Map.Entry r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$45644Mygk3Ef83F2JiQMeFE3wn8(IFileIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ IFileIDL.Stub a(c r1, boolean r2, int r3, Object r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r1, c.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFileIDL.Stub a(c<IFileIDL> r2, boolean r3) {
        o.e((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin"), "<this>");
        return a((IFileIDL.Stub) ZeusTransformUtils.preCheckCast(new FileIDLStub(), IFileIDL.Stub.class, "com.obric.aiagent.plugin"), r3);
    }

    public static /* synthetic */ IFileIDL a(IFileIDL r1, boolean r2, int r3, Object r4) {
        IFileIDL r5 = (IFileIDL) ZeusTransformUtils.wrapperContextForParams(r1, IFileIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = true;
    L6:
        return a(r5, r2);
    }

    public static final IFileIDL a(IFileIDL r8, boolean r9) {
        IFileIDL r10 = (IFileIDL) ZeusTransformUtils.wrapperContextForParams(r8, IFileIDL.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L6;
        h.a(h.f18670a, "IFileIDL", "registerAsIPC failed, IPC is null", null, 4, null);
        return null;
    L6:
        IFileIDL r11 = b(r10, r9);
        i.f18671a.a(IFileIDL.class, (IInterface) ZeusTransformUtils.preCheckCast(r11, IInterface.class, "com.obric.aiagent.plugin"));
        return r11;
    }

    static {
        f18638a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        p.a((Iterable) ZeusTransformUtils.preCheckCast(f18638a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$a$0Gnvu2ea1RfWEfJsWpgFKMG9Gw.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IFileIDL.Stub a(final IFileIDL.Stub r5, boolean r6) {
        o.e(r5, "<this>");
        Map<IBinder, WeakReference<FileIDLStubWrapper>> r0 = f18638a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        FileIDLStubWrapper r2 = (FileIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), FileIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IFileIDL.Stub r7 = (IFileIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IFileIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        x r3 = x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, FileIDLStubWrapper.class) == false) goto L16;
        FileIDLStubWrapper r4 = new FileIDLStubWrapper(((FileIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, FileIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        h.f18670a.a("IFileIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$a$45644Mygk3Ef83F2JiQMeFE3wn8(r5), 0);
        return (IFileIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IFileIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new FileIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IFileIDL.Stub r1) {
        Map<IBinder, WeakReference<FileIDLStubWrapper>> r0 = f18638a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        x r2 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IFileIDL b(IFileIDL r3, boolean r4) {
        IFileIDL r5 = (IFileIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFileIDL.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, FileIDLIpcWrapper.class) == false) goto L7;
        return (IFileIDL) ZeusTransformUtils.preCheckCast(new FileIDLIpcWrapper(((FileIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, FileIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IFileIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IFileIDL) ZeusTransformUtils.preCheckCast(new FileIDLIpcWrapper(r5, r4), IFileIDL.class, "com.obric.aiagent.plugin");
    }
}
