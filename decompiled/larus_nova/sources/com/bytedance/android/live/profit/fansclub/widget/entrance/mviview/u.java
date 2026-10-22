package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.AnimatorSet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleVipMVIView f87552a;

    public u(SingleVipMVIView r100) {
        this.f87552a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        AnimatorSet r102 = this.f87552a.f87493l;
        if (r102 == null) goto L6;
        r102.start();
        return;
    }
}
