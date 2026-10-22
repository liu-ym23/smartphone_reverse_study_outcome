package com.bytedance.android.live.messagewindow.framework.process;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f83135a;

    public b(c r100) {
        this.f83135a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        z61.b r101 = (z61.b) r100;
        this.f83135a.f83136a.put(r101.f570448f, r101.f570447e);
    }
}
