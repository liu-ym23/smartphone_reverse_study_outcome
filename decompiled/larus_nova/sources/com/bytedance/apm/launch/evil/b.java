package com.bytedance.apm.launch.evil;

import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.block.g;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f190617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f190618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a47.a f190619c;

    public static synchronized void a() {
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f190619c != null) goto L7;
    L9:
        monitor-exit(b.class);
        return;
    L7:
        if (EvilMethodSwitcher.isOpenLaunchEvilMethod() == false) goto L9;
        f190619c.h();     // Catch: Throwable -> L11
        goto L9
    }

    public static synchronized void b() {
        monitor-enter(b.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f190617a == true) goto L9;
        monitor-exit(b.class);
        return;
    L9:
        f190617a = false;     // Catch: Throwable -> L15
        a47.a r100 = f190619c;     // Catch: Throwable -> L15
        EvilMethodSwitcher.isLimitEvilMethodDepth();     // Catch: Throwable -> L15
        r100.getClass();     // Catch: Throwable -> L15
        long r101 = EvilMethodSwitcher.getEvilThresholdMs();     // Catch: Throwable -> L15
        if (r101 >= 70) goto L12;
        r101 = 1000;
    L12:
        a47.a.f1768j = r101;     // Catch: Throwable -> L15
        g.f190348c = true;     // Catch: Throwable -> L15
        g.f190346a.remove("app_launch_evil_method_scene_apm_2");     // Catch: Throwable -> L15
        monitor-exit(b.class);
    }
}
