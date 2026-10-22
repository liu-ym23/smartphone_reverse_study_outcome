package com.bytedance.android.livesdk.ktvimpl.ktvroom.theme;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvThemeControl f144881a;

    public a(KtvThemeControl r100) {
        this.f144881a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvThemeControl.a(this.f144881a);     // Catch: Throwable -> L4
        ALogger.i("alog_ktv_smooth_enter_room", "removeFeedMockView ;; ktv bg visible time out");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
