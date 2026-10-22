package com.bytedance.android.livesdk.gamecp;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f125417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f125418b = null;

    public b() {
    }

    static {
        f125418b = new b();
    }

    @JvmStatic
    public static final xr.f a() {
        if (f125417a == true) goto L21;
        b r100 = f125418b;
        if (f125417a == true) goto L21;
        monitor-enter(r100);
        bw.m r101 = com.bytedance.android.gamecp.host_api.a.b();     // Catch: Throwable -> L18
        if ((r101 instanceof ew.s) == true) goto L13;
        if (kv.a.f506227b.c(r101) == false) goto L13;
        f125417a = true;     // Catch: Throwable -> L18
    L13:
        if (f125417a == true) goto L15;
        LocalTestManager.a(new Class[]{wy.a.class});     // Catch: Throwable -> L18
    L15:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r100);
    L18:
        th = move-exception;
        throw th;
    L21:
        boolean r103 = kv.a.f506226a;
        return kv.a.b();
    }
}
