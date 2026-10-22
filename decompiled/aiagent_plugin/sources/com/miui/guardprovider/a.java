package com.miui.guardprovider;

import android.os.CancellationSignal;
import android.os.ICancellationSignal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/* JADX INFO: compiled from: CancellationSignalUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MethodHandle f13909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MethodHandle f13910b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final MethodHandle f13911c = null;

    static {
        MethodHandles.Lookup r0 = MethodHandles.lookup();     // Catch: Throwable -> L4
        f13909a = r0.findStatic(CancellationSignal.class, "createTransport", MethodType.methodType(ICancellationSignal.class));     // Catch: Throwable -> L4
        f13910b = r0.findStatic(CancellationSignal.class, "fromTransport", MethodType.methodType(CancellationSignal.class, ICancellationSignal.class));     // Catch: Throwable -> L4
        f13911c = r0.findVirtual(CancellationSignal.class, "setRemote", MethodType.methodType(Void.TYPE, ICancellationSignal.class));     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        throw new ExceptionInInitializerError(e);
    }

    public static void a(CancellationSignal r2, ICancellationSignal r3) {
        ICancellationSignal r4 = (ICancellationSignal) ZeusTransformUtils.wrapperContextForParams(r3, ICancellationSignal.class, "com.obric.aiagent.plugin");
        (void) f13911c.invoke(r2, r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        throw new RuntimeException(th);
    }
}
