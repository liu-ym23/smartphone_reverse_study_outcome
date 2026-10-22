package com.bytedance.android.livesdk.arch.task;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TbTaskFlower f103908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f103909b;

    public n(TbTaskFlower r100, x r101) {
        this.f103908a = r100;
        this.f103909b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TbTaskFlower r101 = this.f103908a;
        e r102 = this.f103909b;
        TbTaskFlower.b(r101, r102, (Throwable) r100);
    }
}
