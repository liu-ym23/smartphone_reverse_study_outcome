package com.bytedance.android.livesdk.player.performance;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f156021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f156022f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f156023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f156024d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, com.ss.android.ugc.bytex.pthread.base.convergence.hook.HandlerThreadProxyWrapper, java.lang.Thread
    public final void start() {
    }

    public final void exit() {
        if (this.f156024d <= 0) goto L7;
        new Throwable("LivePlayerThreadPool.HandlerThread.exit").printStackTrace();
        return;
    L7:
        if (this.f156023c == true) goto L9;
        this.f156023c = true;
        f156021e--;
        com.bytedance.android.livesdk.player.performance.a.f156019a.getClass();
    L9:
        super.quitSafely();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, android.os.HandlerThread
    public final boolean quit() {
        exit();
        return true;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, android.os.HandlerThread
    public final boolean quitSafely() {
        exit();
        return true;
    }

    public final void b(int r100) {
        if (r100 == this.f156024d) goto L6;
        this.f156024d = r100;
        com.bytedance.android.livesdk.player.performance.a.f156019a.getClass();
        getName();
        return;
    }

    public b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        super(r100 + '_' + f156022f, r101);
        f156022f = f156022f + 1;
        f156021e = f156021e + 1;
        com.bytedance.android.livesdk.player.performance.a.f156019a.getClass();
        super.start();
    }
}
