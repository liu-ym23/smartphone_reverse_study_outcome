package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: FPSMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f33652b;

    static {
        f33651a = new b();
    }

    private b() {
    }

    public static final /* synthetic */ void a(b r0) {
        r0.a();
    }

    private final void a() {
        if (f33652b == false) goto L5;
        return;
    L5:
        if (a.f33650a.a() != null) goto L17;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("FPSMonitor", "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r3 = LooperPrinterUtils.class.getDeclaredField("b");     // Catch: Exception -> L12
        r3.setAccessible(true);     // Catch: Exception -> L12
        Object r4 = r3.get(null);     // Catch: Exception -> L12
        if (r4 == null) goto L11;
        Printer r5 = (Printer) ZeusTransformUtils.preCheckCast(r4, Printer.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        Looper.getMainLooper().setMessageLogging(r5);     // Catch: Exception -> L12
        f33652b = true;     // Catch: Exception -> L12
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
