package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import xi2.f0;

/* JADX INFO: loaded from: classes10.dex */
public final class TitleSwitchHelper$switchAction$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f148943a;

    public final void a() {
        final List<f0> r100 = this.f148943a.f149040d.d();
        if (r100 != null) goto L5;
        return;
    L5:
        m r101 = this.f148943a;
        int r102 = r101.f149037a + 1;
        r101.f149037a = r102;
        if (r102 < r100.size()) goto L9;
        this.f148943a.f149037a = 0;
    L9:
        if (ViewCompat.isAttachedToWindow(this.f148943a.f149039c) == true) goto L11;
        return;
    L11:
        ViewPropertyAnimator r103 = this.f148943a.f149039c.animate().alpha(0.0f).setDuration(300);
        com.bytedance.android.ec.core.utils.f.b(r103, new TitleSwitchHelper$switchAction$1$run$1(this, r100));
        r103.start();
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

    public TitleSwitchHelper$switchAction$1(m r100) {
        this.f148943a = r100;
    }
}
