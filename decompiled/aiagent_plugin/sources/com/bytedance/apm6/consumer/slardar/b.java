package com.bytedance.apm6.consumer.slardar;

import android.app.Application;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.UUID;

/* JADX INFO: compiled from: DiskEnvironmentHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f5061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static File f5062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f5063c;

    public static synchronized File b() {
        monitor-enter(b.class);
        File r1 = a();     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized File c() {
        monitor-enter(b.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (f5063c == null) goto L7;
    L16:
        File r1 = f5063c;     // Catch: Throwable -> L19
        monitor-exit(b.class);
        return r1;
    L7:
        if (com.bytedance.apm6.foundation.context.a.e() == false) goto L9;
        File r2 = new File(b(), "persistent");     // Catch: Throwable -> L19
    L11:
        if (r2.exists() == true) goto L13;
        r2.mkdirs();     // Catch: Throwable -> L19
    L13:
        f5063c = r2;     // Catch: Throwable -> L19
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L16;
        com.bytedance.apm6.util.c.b.a(a.f5054a, "prepare PersistentDirectory success. name=" + f5063c);     // Catch: Throwable -> L19
        goto L16
    L9:
        r2 = new File(b(), "child_process_persistent");     // Catch: Throwable -> L19
        goto L11
    }

    public static synchronized File d() {
        monitor-enter(b.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f5061a == null) goto L26;
    L18:
        File r1 = f5061a;     // Catch: Throwable -> L21
        monitor-exit(b.class);
        return r1;
    L26:
        String r2 = com.bytedance.apm6.foundation.context.a.f().replace(".", "_").replace(":", "-") + ".bin";     // Catch: Exception -> L16 Throwable -> L21
        if (com.bytedance.apm6.foundation.context.a.e() == true) goto L9;
        r2 = com.bytedance.apm6.foundation.context.a.d() + "_" + r2;     // Catch: Exception -> L16 Throwable -> L21
    L9:
        File r3 = new File(c(), r2);     // Catch: Exception -> L16 Throwable -> L21
        if (r3.exists() == true) goto L12;
        r3.createNewFile();     // Catch: Exception -> L16 Throwable -> L21
    L12:
        f5061a = r3;     // Catch: Exception -> L16 Throwable -> L21
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L18;
        com.bytedance.apm6.util.c.b.a(a.f5054a, "prepare PersistentFile success. fileName=" + f5061a);     // Catch: Exception -> L16 Throwable -> L21
    L16:
        e = move-exception;
        com.bytedance.apm6.util.c.b.b(a.f5054a, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L21
        goto L18
    }

    public static synchronized File e() {
        monitor-enter(b.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f5062b != null) goto L12;
        File r1 = new File(b(), ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH);     // Catch: Throwable -> L15
        if (r1.exists() == true) goto L9;
        r1.mkdirs();     // Catch: Throwable -> L15
    L9:
        f5062b = r1;     // Catch: Throwable -> L15
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L12;
        com.bytedance.apm6.util.c.b.a(a.f5054a, "prepare FlushDirectory success. name=" + f5062b);     // Catch: Throwable -> L15
    L12:
        File r2 = f5062b;     // Catch: Throwable -> L15
        monitor-exit(b.class);
        return r2;
    }

    public static File f() {
        return new File(b(), "child_process_persistent");
    }

    public static String g() {
        return System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + ".log";
    }

    public static File a() {
        if (com.obric.aiagent.apm.impl.f.f16115a != null) goto L8;
        com.obric.aiagent.apm.impl.f.f16115a = new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir().getParentFile(), "apm6");
        if (com.obric.aiagent.apm.impl.f.f16115a.exists() == true) goto L8;
        com.obric.aiagent.apm.impl.f.f16115a.mkdirs();
    L8:
        return com.obric.aiagent.apm.impl.f.f16115a;
    }
}
