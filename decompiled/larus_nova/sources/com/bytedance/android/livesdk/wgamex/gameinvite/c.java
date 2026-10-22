package com.bytedance.android.livesdk.wgamex.gameinvite;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorInviteViewModel.a f160731a;

    public c(AnchorInviteViewModel.a r100) {
        this.f160731a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f160731a.f160673a.checkStatus();
    }
}
