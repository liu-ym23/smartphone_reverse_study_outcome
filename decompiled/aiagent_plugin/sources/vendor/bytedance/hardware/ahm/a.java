package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import com.obric.aiagent.ipc.utils.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: AHMCallbackIDLExt.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IBinder, WeakReference<AHMCallbackIDLStubWrapper>> f40706a = null;

    public static /* synthetic */ void lambda$49AUQcvJsA2X877BvYjj3y8QsSA(IAHMCallbackIDL.Stub r0) {
        a(r0);
    }

    public static /* synthetic */ boolean lambda$8jolApT45kHvCLj0oEzFK83uylI(Map.Entry r0) {
        return a(r0);
    }

    static {
        f40706a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private static final void a() {
        p.a((Iterable) ZeusTransformUtils.preCheckCast(f40706a.entrySet(), Iterable.class, "com.obric.aiagent.plugin"), $$Lambda$a$8jolApT45kHvCLj0oEzFK83uylI.INSTANCE);
    }

    private static final boolean a(Map.Entry r2) {
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.aiagent.plugin");
        o.e(r3, "it");
        if (((WeakReference) ZeusTransformUtils.preCheckCast(r3.getValue(), WeakReference.class, "com.obric.aiagent.plugin")).get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static final IAHMCallbackIDL.Stub a(final IAHMCallbackIDL.Stub r5, boolean r6) {
        o.e(r5, "<this>");
        Map<IBinder, WeakReference<AHMCallbackIDLStubWrapper>> r0 = f40706a;
        monitor-enter(r0);
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r5.asBinder()), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        AHMCallbackIDLStubWrapper r2 = (AHMCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r1.get(), AHMCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L11;
        r2.log = r6;     // Catch: Throwable -> L25
        IAHMCallbackIDL.Stub r7 = (IAHMCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r2, IAHMCallbackIDL.Stub.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r7;
    L11:
        x r3 = x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r0);
        if (ZeusTransformUtils.instanceOf(r5, AHMCallbackIDLStubWrapper.class) == false) goto L16;
        AHMCallbackIDLStubWrapper r4 = new AHMCallbackIDLStubWrapper(((AHMCallbackIDLStubWrapper) ZeusTransformUtils.preCheckCast(r5, AHMCallbackIDLStubWrapper.class, "com.obric.aiagent.plugin")).origin, r6);
    L17:
        monitor-enter(r0);
        a();     // Catch: Throwable -> L22
        h.f18670a.a("IAHMCallbackIDL", "Stub.wrap, (" + r4 + ')');     // Catch: Throwable -> L22
        IBinder r8 = r5.asBinder();     // Catch: Throwable -> L22
        o.c(r8, "asBinder(...)");     // Catch: Throwable -> L22
        WeakReference r9 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.put(r8, new WeakReference(r4)), WeakReference.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        monitor-exit(r0);
        r4.linkToDeath(new $$Lambda$a$49AUQcvJsA2X877BvYjj3y8QsSA(r5), 0);
        return (IAHMCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IAHMCallbackIDL.Stub.class, "com.obric.aiagent.plugin");
    L22:
        th = move-exception;
        throw th;
    L16:
        r4 = new AHMCallbackIDLStubWrapper(r5, r6);
    L25:
        th = move-exception;
        throw th;
    }

    private static final void a(IAHMCallbackIDL.Stub r1) {
        Map<IBinder, WeakReference<AHMCallbackIDLStubWrapper>> r0 = f40706a;
        monitor-enter(r0);
        r0.remove(r1.asBinder());     // Catch: Throwable -> L7
        x r2 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static final IAHMCallbackIDL a(IAHMCallbackIDL r3, boolean r4) {
        IAHMCallbackIDL r5 = (IAHMCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
        o.e(r5, "<this>");
        if (ZeusTransformUtils.instanceOf(r5, AHMCallbackIDLIpcWrapper.class) == false) goto L7;
        return (IAHMCallbackIDL) ZeusTransformUtils.preCheckCast(new AHMCallbackIDLIpcWrapper(((AHMCallbackIDLIpcWrapper) ZeusTransformUtils.preCheckCast(r5, AHMCallbackIDLIpcWrapper.class, "com.obric.aiagent.plugin")).origin, r4), IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
    L7:
        return (IAHMCallbackIDL) ZeusTransformUtils.preCheckCast(new AHMCallbackIDLIpcWrapper(r5, r4), IAHMCallbackIDL.class, "com.obric.aiagent.plugin");
    }
}
