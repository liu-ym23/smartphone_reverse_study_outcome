package com.bytedance.reparo;

import android.app.Application;
import com.bytedance.crash.MonitorCrash;
import com.bytedance.crash.Npth;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: ReparoNpth.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MonitorCrash f9369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentLinkedQueue<Runnable> f9370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ExecutorService f9371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f9372d;

    static /* synthetic */ MonitorCrash a() {
        return f9369a;
    }

    static {
        f9370b = new ConcurrentLinkedQueue();
        f9371c = null;
        f9372d = "noPatch";
    }

    public static void a(Application r8, ExecutorService r9, boolean r10, long r11, String r13) {
        Application r2 = (Application) ZeusTransformUtils.wrapperContextForParams(r8, Application.class, "com.obric.aiagent.plugin");
        f9371c = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r9, ExecutorService.class, "com.obric.aiagent.plugin");
        if (f9369a != null) goto L15;
        if (Npth.isInit() == false) goto L15;
        MonitorCrash r12 = MonitorCrash.initSDK(r2, "8616", r11, r13, "");
        f9369a = r12;
        MonitorCrash.Config r14 = r12.config();
        String r15 = "alpha";
        if (r10 == false) goto L10;
        r15 = "debug";
    L13:
        r14.setChannel(r15);
        goto L15
    L10:
        if (r13.contains("alpha") == true) goto L13;
        r15 = "release";
    L15:
        if (f9369a != null) goto L25;
        return;
    L25:
        if (f9370b.isEmpty() == true) goto L32;
        Runnable r16 = (Runnable) ZeusTransformUtils.preCheckCast(f9370b.poll(), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r16 == null) goto L30;
        r16.run();     // Catch: Throwable -> L24
    L30:
        return;
    L32:
        return;
    }

    public static void a(String r1) {
        f9372d = r1;
        Npth.addTag("reparo_patch_id", r1);     // Catch: Throwable -> L5
        return;
    }

    public static void a(final String r2, final String r3, final Throwable r4) {
        MonitorCrash r0 = f9369a;
        if (r0 == null) goto L5;
        r0.reportCustomErr(r3, r2, r4);
        return;
    L5:
        f9370b.add(new AnonymousClass1(r3, r2, r4));
    }
}
