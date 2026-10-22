package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.AnimatorSet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RightVipMVIView f87544a;

    public m(RightVipMVIView r100) {
        this.f87544a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        AnimatorSet r102 = this.f87544a.f87468l;
        if (r102 == null) goto L6;
        r102.start();
        return;
    }
}
