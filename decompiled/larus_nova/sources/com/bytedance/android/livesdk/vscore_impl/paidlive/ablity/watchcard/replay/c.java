package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.watchcard.replay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f160535a;

    public c(d r100) {
        this.f160535a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f160535a.reset();
    }
}
