package com.bytedance.android.monitorV2.listener;

import android.os.Handler;
import com.byted.cast.common.api.FirewallError;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EventWatchTools f163125a;

    public e(EventWatchTools r100) {
        this.f163125a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EventWatchTools.a(this.f163125a);     // Catch: Throwable -> L6
        EventWatchTools r100 = this.f163125a;     // Catch: Throwable -> L6
        Handler r101 = r100.f163112c;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        r101.postDelayed(new e(r100), FirewallError.FIREWALL_OK);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
