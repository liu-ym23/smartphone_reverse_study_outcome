package com.bytedance.android.livesdk.arch.task;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f103912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f103913b;

    public p(r r100, d r101) {
        this.f103912a = r100;
        this.f103913b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        r r101 = this.f103912a;
        TbTaskFlower r102 = r101.f103915a;
        TbTaskFlower.c(r102, (TaskResult) r100, r101.f103916b, this.f103913b);
    }
}
