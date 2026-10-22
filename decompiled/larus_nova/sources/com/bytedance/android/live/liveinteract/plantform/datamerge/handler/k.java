package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f76457a;

    public k(l r100) {
        this.f76457a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        l r102 = this.f76457a;
        r102.f76461d = true;
        r102.a().E0(true);
        this.f76457a.c();
    }
}
