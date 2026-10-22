package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdjustGuestPositionDialog f71980a;

    public c(AdjustGuestPositionDialog r100) {
        this.f71980a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f71980a.d(LinkmicAdjustPositionPingType.AdjustPositinoPingType_Continue);
    }
}
