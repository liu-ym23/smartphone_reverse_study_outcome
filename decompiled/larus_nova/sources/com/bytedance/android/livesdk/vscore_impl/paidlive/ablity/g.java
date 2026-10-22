package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidRoomTempWatchAbility f160223a;

    public g(PaidRoomTempWatchAbility r100) {
        this.f160223a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f160223a.a("complete temp watch! total watch " + this.f160223a.f160040f + " second!");
        this.f160223a.c(2);
    }
}
