package com.bytedance.android.btm.impl.thread;

import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.g;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zc.e;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f42484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f42485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ScheduledExecutorService f42486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ExecutorService f42487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f42488e = null;

    public b() {
    }

    static {
        f42488e = new b();
    }

    public static ScheduledExecutorService c() {
        if (f42486c == null) goto L5;
    L24:
        ScheduledExecutorService r100 = f42486c;
        if (r100 != null) goto L27;
        Intrinsics.throwNpe();
    L27:
        return r100;
    L5:
        monitor-enter(b.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (f42486c != null) goto L16;
        if (BtmSetting.f42469d.c().c().o() == true) goto L16;
        e r101 = BtmHostDependManager.F.e();     // Catch: Throwable -> L21
        if (r101 == null) goto L13;
        ScheduledExecutorService r102 = r101.a();     // Catch: Throwable -> L21
    L14:
        f42486c = r102;     // Catch: Throwable -> L21
        goto L16
    L13:
        r102 = null;
    L16:
        if (f42486c != null) goto L18;
        f42486c = new PThreadScheduledThreadPoolExecutor(3, new a("ScheduledThreadPool"));     // Catch: Throwable -> L21
    L18:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(b.class);
        goto L24
    }

    public static void d(Runnable r100) {
        if (f42487d == null) goto L5;
    L24:
        ExecutorService r101 = f42487d;
        if (r101 != null) goto L27;
        Intrinsics.throwNpe();
    L27:
        r101.execute(r100);
        return;
    L5:
        monitor-enter(b.class);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (f42487d != null) goto L16;
        if (BtmSetting.f42469d.c().c().o() == true) goto L16;
        e r102 = BtmHostDependManager.F.e();     // Catch: Throwable -> L21
        if (r102 == null) goto L13;
        ExecutorService r103 = r102.b();     // Catch: Throwable -> L21
    L14:
        f42487d = r103;     // Catch: Throwable -> L21
        goto L16
    L13:
        r103 = null;
    L16:
        if (f42487d != null) goto L18;
        f42487d = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("BtmThreadPoolExecutor"));     // Catch: Throwable -> L21
    L18:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(b.class);
        goto L24
    }

    @Override // com.bytedance.android.btm.api.g
    public final void a(Runnable r110, boolean r111) {
        if (r111 == false) goto L7;
        if (ThreadUtils.b() == true) goto L7;
        r110.run();
        return;
    L7:
        if (f42484a == null) goto L9;
    L28:
        ExecutorService r112 = f42484a;
        if (r112 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        r112.execute(r110);
        return;
    L9:
        monitor-enter(b.class);
    L25:
        th = move-exception;
        throw th;
    L11:
        if (f42484a != null) goto L20;
        if (BtmSetting.f42469d.c().c().o() == true) goto L20;
        e r100 = BtmHostDependManager.F.e();     // Catch: Throwable -> L25
        if (r100 == null) goto L17;
        ExecutorService r101 = r100.c();     // Catch: Throwable -> L25
    L18:
        f42484a = r101;     // Catch: Throwable -> L25
        goto L20
    L17:
        r101 = null;
    L20:
        if (f42484a != null) goto L22;
        f42484a = new PThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a("CPUThreadPool"));     // Catch: Throwable -> L25
    L22:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(b.class);
        goto L28
    }

    @Override // com.bytedance.android.btm.api.g
    public final void b(Runnable r110, boolean r111) {
        if (r111 == false) goto L7;
        if (ThreadUtils.b() == true) goto L7;
        r110.run();
        return;
    L7:
        if (f42485b == null) goto L9;
    L28:
        ExecutorService r112 = f42485b;
        if (r112 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        r112.execute(r110);
        return;
    L9:
        monitor-enter(b.class);
    L25:
        th = move-exception;
        throw th;
    L11:
        if (f42485b != null) goto L20;
        if (BtmSetting.f42469d.c().c().o() == true) goto L20;
        e r100 = BtmHostDependManager.F.e();     // Catch: Throwable -> L25
        if (r100 == null) goto L17;
        ExecutorService r101 = r100.getIOExecutor();     // Catch: Throwable -> L25
    L18:
        f42485b = r101;     // Catch: Throwable -> L25
        goto L20
    L17:
        r101 = null;
    L20:
        if (f42485b != null) goto L22;
        f42485b = new PThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a("IOThreadPool"));     // Catch: Throwable -> L25
    L22:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(b.class);
        goto L28
    }
}
