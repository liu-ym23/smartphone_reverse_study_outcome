package com.bytedance.android.livesdk.interactivity.service.messagelist;

import android.view.animation.TranslateAnimation;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListScrollManager f140894a;

    public k(MessageListScrollManager r100) {
        this.f140894a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TranslateAnimation r100 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);     // Catch: Throwable -> L4
        r100.setDuration(100);     // Catch: Throwable -> L4
        this.f140894a.f140874m.startAnimation(r100);     // Catch: Throwable -> L4
        this.f140894a.f140874m.setVisibility(0);     // Catch: Throwable -> L4
        this.f140894a.f140875n.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
