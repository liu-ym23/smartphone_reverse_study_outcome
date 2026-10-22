package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cc0.c f143824a;

    public i(k r100) {
        this.f143824a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        cc0.c r101 = this.f143824a;
        r101.a((String) r100);
    }
}
