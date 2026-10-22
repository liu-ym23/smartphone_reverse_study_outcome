package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.Looper;
import android.util.Printer;
import com.bytedance.platform.godzilla.common.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: BridgeIdleTaskToLooperPrinter.java */
/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f9060a;

    private static Printer a() {
        if (f9060a == null) goto L12;
    L10:
        return (Printer) ZeusTransformUtils.preCheckCast(f9060a.get(Looper.getMainLooper()), Printer.class, "com.obric.aiagent.plugin");
    L7:
        return null;
    L12:
        f9060a = c.a(Looper.class, "mLogging");     // Catch: Throwable -> L9
        goto L10
    }

    static void a(String r1) {
        Printer r0 = a();
        if (r0 == null) goto L6;
        r0.println(r1);
        return;
    }
}
