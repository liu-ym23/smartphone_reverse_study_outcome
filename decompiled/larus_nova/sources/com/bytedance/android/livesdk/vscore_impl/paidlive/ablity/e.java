package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidRoomTempWatchAbility f160221a;

    public e(PaidRoomTempWatchAbility r100) {
        this.f160221a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f160221a.Yj(null);
    }
}
