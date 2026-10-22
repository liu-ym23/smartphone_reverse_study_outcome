package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidRoomTempWatchAbility f160222a;

    public f(PaidRoomTempWatchAbility r100) {
        this.f160222a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f160222a.a("timing error ! " + ((Throwable) r100).getMessage());
        this.f160222a.c(2);
    }
}
