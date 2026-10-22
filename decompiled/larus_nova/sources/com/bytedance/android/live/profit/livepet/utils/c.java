package com.bytedance.android.live.profit.livepet.utils;

import android.animation.AnimatorSet;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f87922a;

    public c(AnimatorSet r100) {
        this.f87922a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        this.f87922a.start();
    }
}
