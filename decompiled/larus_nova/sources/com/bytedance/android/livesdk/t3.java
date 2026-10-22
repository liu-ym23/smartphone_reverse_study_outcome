package com.bytedance.android.livesdk;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class t3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f158506a;

    public t3(View r100) {
        this.f158506a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f158506a.sendAccessibilityEvent(128);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
