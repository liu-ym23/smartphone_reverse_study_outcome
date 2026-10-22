package com.bytedance.android.livesdk.asr.aio;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ASRManagerService f103965a;

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.f103965a.f103962g.set(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(ASRManagerService r100) {
        this.f103965a = r100;
    }
}
