package com.bytedance.android.gamecp.business.downloadview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f53135a;

    public p(n r100) {
        this.f53135a = r100;
    }

    public final void a() {
        n r100 = this.f53135a;
        r100.f53130w = null;
        AnimatorSet r101 = r100.f53132y;
        if (r101 != null) goto L5;
    L7:
        float r102 = r100.f53115h.getHeight();
        if (r102 > 0.0f) goto L10;
        r100.j();
        return;
    L10:
        r100.f53115h.setTranslationY(0.0f);
        r100.f53115h.setAlpha(1.0f);
        r100.f53115h.setVisibility(0);
        r100.f53114g.setTranslationY(r102);
        r100.f53114g.setAlpha(0.0f);
        r100.f53114g.setVisibility(0);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100.f53115h, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -r102});
        r103.setDuration(600);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100.f53114g, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102, 0.0f});
        r104.setDuration(600);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r100.f53115h, "alpha", new float[]{1.0f, 0.0f});
        r105.setDuration(300);
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r100.f53114g, "alpha", new float[]{0.0f, 1.0f});
        r106.setDuration(400);
        r106.setStartDelay(200);
        AnimatorSet r107 = new AnimatorSet();
        r100.f53132y = r107;
        r107.play(r104).with(r103).with(r105).with(r106);
        r107.addListener(new o(r100));
        r107.start();
        return;
    L5:
        if (r101.isRunning() != true) goto L7;
        AnimatorSet r108 = r100.f53132y;
        Intrinsics.checkNotNull(r108);
        r108.cancel();
        goto L7
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
