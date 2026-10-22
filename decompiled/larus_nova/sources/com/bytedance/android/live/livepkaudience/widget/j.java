package com.bytedance.android.live.livepkaudience.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkPkInteractControlWidget f82446a;

    public j(LinkPkInteractControlWidget r100) {
        this.f82446a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = x8.a.f562881a;
        String r102 = this.f82446a.f82421a;
        x8.a.c(r102, (Throwable) r100, false);
    }
}
