package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.animation.TranslateAnimation;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseModelListScrollManager f141139a;

    public e(BaseModelListScrollManager r100) {
        this.f141139a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TranslateAnimation r100 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);     // Catch: Throwable -> L4
        r100.setDuration(100);     // Catch: Throwable -> L4
        this.f141139a.f141123k.startAnimation(r100);     // Catch: Throwable -> L4
        this.f141139a.f141123k.setVisibility(0);     // Catch: Throwable -> L4
        this.f141139a.f141124l.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
