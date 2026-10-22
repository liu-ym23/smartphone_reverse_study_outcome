package com.bytedance.android.live.broadcastgame.openplatform.miniapp.card;

import android.animation.AnimatorSet;
import com.bytedance.android.live.broadcastgame.opengame.GameIntroCard;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IntroduceCardWidget f61751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f61752b;

    public c(IntroduceCardWidget r100, AnimatorSet r101) {
        this.f61751a = r100;
        this.f61752b = r101;
    }

    public final void a() {
        GameIntroCard r100 = this.f61751a.f61744c;
        if (r100 == null) goto L11;
        r100.setPivotX(0.0f);
        GameIntroCard r101 = this.f61751a.f61744c;
        if (r101 == null) goto L9;
        r101.setPivotY(r101.getHeight());
        this.f61752b.start();
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
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
