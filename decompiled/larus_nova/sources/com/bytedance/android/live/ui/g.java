package com.bytedance.android.live.ui;

import android.graphics.drawable.Animatable;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f102081a;

    public g(h r100) {
        this.f102081a = r100;
    }

    public final void a() {
        c r100 = this.f102081a.f102082c;
        int r101 = c.f102052u;
        if (r100.f102066n == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        Animatable r103 = r100.f102059g;
        if (r103 == null) goto L20;
        r103.stop();
        return;
    L20:
        return;
    L12:
        Animatable r104 = r100.f102059g;
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.isRunning() == true) goto L23;
        Animatable r105 = this.f102081a.f102082c.f102059g;
        if (r105 == null) goto L24;
        r105.start();
        return;
    L24:
        return;
    L23:
        return;
    L5:
        if (r100.f102058f == true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
