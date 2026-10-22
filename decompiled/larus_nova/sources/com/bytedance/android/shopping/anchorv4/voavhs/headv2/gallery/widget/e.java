package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.animation.ValueAnimator;
import com.bytedance.android.ec.sdk.helper.q;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f169506a;

    public e(d r100) {
        this.f169506a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = pi3.a.f529323a;     // Catch: Throwable -> L6
        long r101 = System.currentTimeMillis() / ((long) 1000);     // Catch: Throwable -> L6
        q.f48131a.e("anchor_v4_find_similar_button_last_show_time", r101);     // Catch: Throwable -> L6
        d r102 = this.f169506a;     // Catch: Throwable -> L6
        r102.f169492n = true;     // Catch: Throwable -> L6
        r102.setBubbleIsShown(true);     // Catch: Throwable -> L6
        ValueAnimator r103 = this.f169506a.f169489k;     // Catch: Throwable -> L6
        if (r103 == null) goto L9;
        r103.start();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
