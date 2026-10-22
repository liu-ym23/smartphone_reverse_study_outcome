package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LastPageVideoZoomer f181111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f181112b;

    public l(LastPageVideoZoomer r100, CompatFrameLayout r101) {
        this.f181111a = r100;
        this.f181112b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LastPageVideoZoomer r100 = this.f181111a;     // Catch: Throwable -> L9
        View r101 = this.f181112b;     // Catch: Throwable -> L9
        ValueAnimator r102 = r100.f181043b;     // Catch: Throwable -> L9
        if (r102 != null) goto L5;
    L7:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{-1.0f, 0.0f});     // Catch: Throwable -> L9
        r103.setDuration(150);     // Catch: Throwable -> L9
        r103.addUpdateListener(new g(r100, r101));     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r100.f181043b = r103;     // Catch: Throwable -> L9
        r103.start();     // Catch: Throwable -> L9
        return;
    L5:
        if (r102.isRunning() != true) goto L7;
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
