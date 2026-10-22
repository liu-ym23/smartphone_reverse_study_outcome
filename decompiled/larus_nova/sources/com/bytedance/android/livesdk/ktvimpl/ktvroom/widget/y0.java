package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class y0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f145875a;

    public y0(View r100) {
        this.f145875a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f145875a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setVisibility(8);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
