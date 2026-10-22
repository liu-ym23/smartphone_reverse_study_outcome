package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.watchcard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidRoomTempWatchCard f160530a;

    public e(PaidRoomTempWatchCard r100) {
        this.f160530a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f160530a.reset();
    }
}
