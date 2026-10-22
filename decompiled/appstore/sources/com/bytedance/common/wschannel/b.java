package com.bytedance.common.wschannel;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f6902c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WsChannelMultiProcessSharedProvider.c f6904b;

    public b(Context r10) {
        Context r11 = r10.getApplicationContext();
        this.f6903a = r11;
        this.f6904b = WsChannelMultiProcessSharedProvider.k(r11);
    }

    public static b d(Context r10) {
        if (f6902c != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f6902c != null) goto L11;
        f6902c = new b(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f6902c;
    }

    public long a() {
        return this.f6904b.c(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0);
    }

    public long b() {
        return this.f6904b.c(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT);
    }

    public String c() {
        return this.f6904b.d(WsConstants.KEY_WS_APPS, "");
    }

    public boolean e() {
        return this.f6904b.b(WsConstants.KEY_FRONTIER_ENABLED, true);
    }

    public boolean f() {
        return this.f6904b.b(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    public boolean g() {
        return this.f6904b.b(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false);
    }

    public void h(String r10) {
        this.f6904b.a().c(WsConstants.KEY_WS_APPS, r10).b();
    }
}
