package com.bytedance.android.btm.impl;

import android.os.SystemClock;
import com.bytedance.android.btm.impl.chain.BtmChainRecorder;
import com.bytedance.android.btm.impl.page.observe.AppStatusObserver;
import com.bytedance.android.btm.impl.page.observe.AppStatusObserverV2;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f42122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static BtmChainRecorder f42123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.bytedance.android.btm.impl.event.a f42124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f42125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f42126e = null;

    public b() {
    }

    public final synchronized void d() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (f42122a == true) goto L6;
        f42122a = true;     // Catch: Throwable -> L8
        f42123b = new BtmChainRecorder();     // Catch: Throwable -> L8
        f42124c = new com.bytedance.android.btm.impl.event.a();     // Catch: Throwable -> L8
        f42125d = String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L8
        SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    static {
        f42126e = new b();
        f42125d = "";
    }

    public static gd.b b() {
        if (BtmSetting.f42469d.c().b().a() != 1) goto L6;
        return AppStatusObserverV2.f42385j;
    L6:
        return AppStatusObserver.f42375g;
    }

    public final com.bytedance.android.btm.impl.event.a a() {
        if (f42124c != null) goto L5;
        d();
    L5:
        com.bytedance.android.btm.impl.event.a r100 = f42124c;
        if (r100 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return r100;
    }

    public final BtmChainRecorder c() {
        if (f42123b != null) goto L5;
        d();
    L5:
        BtmChainRecorder r100 = f42123b;
        if (r100 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return r100;
    }
}
