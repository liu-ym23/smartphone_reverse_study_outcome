package com.bytedance.android.livesdk.ceremony.view;

import android.animation.ObjectAnimator;
import com.bytedance.android.livesdk.config.uk0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CeremonyPrizeNoticeWidget f104965a;

    public h(CeremonyPrizeNoticeWidget r100) {
        this.f104965a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        CeremonyPrizeNoticeWidget r102 = this.f104965a;
        r102.Bq();
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r102.yq(), "alpha", new float[]{1.0f, 0.0f});
        r102.f104916h = r103;
        if (r103 == null) goto L5;
        r103.setDuration(uk0.f121382a.getValue().fadeOutDuration);
    L5:
        ObjectAnimator r104 = r102.f104916h;
        if (r104 == null) goto L8;
        r104.addListener(new f(r102));
    L8:
        ObjectAnimator r105 = r102.f104916h;
        if (r105 == null) goto L12;
        r105.start();
        return;
    }
}
