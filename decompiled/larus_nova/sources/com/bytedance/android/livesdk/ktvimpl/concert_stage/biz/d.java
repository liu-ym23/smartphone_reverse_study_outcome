package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f143737a;

    public d(c r100) {
        this.f143737a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f143737a.l(((Boolean) r100).booleanValue());
    }
}
