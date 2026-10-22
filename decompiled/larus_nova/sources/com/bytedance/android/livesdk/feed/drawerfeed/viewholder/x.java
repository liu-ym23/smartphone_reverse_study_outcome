package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerLynxViewHolder f123989a;

    public x(DrawerLynxViewHolder r100) {
        this.f123989a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f123989a.f123913d;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        r100.setVisibility(8);     // Catch: Throwable -> L9
    L5:
        ViewGroup r101 = this.f123989a.Z3();     // Catch: Throwable -> L9
        if (r101 == null) goto L12;
        r101.setVisibility(0);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
