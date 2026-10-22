package com.bytedance.android.livesdk.share;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareTicketFragment f158100a;

    public m(ShareTicketFragment r100) {
        this.f158100a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ShareTicketFragment r102 = this.f158100a;
        r102.H = false;
        ShareTicketFragment.U90(r102);
    }
}
