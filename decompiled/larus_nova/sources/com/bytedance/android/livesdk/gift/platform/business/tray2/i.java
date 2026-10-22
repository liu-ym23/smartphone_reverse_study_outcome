package com.bytedance.android.livesdk.gift.platform.business.tray2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchRoomGiftTrayAnimationView f130371a;

    public i(MatchRoomGiftTrayAnimationView r100) {
        this.f130371a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101.intValue() <= 0) goto L5;
        int r102 = r101.intValue() + MatchRoomGiftTrayAnimationView.p(this.f130371a);
    L6:
        MatchRoomGiftTrayAnimationView.o(this.f130371a, r102);
        if (this.f130371a.getChildCount() <= 0) goto L10;
        this.f130371a.m(20, false);
        return;
    L10:
        return;
    L5:
        r102 = MatchRoomGiftTrayAnimationView.q(this.f130371a);
        goto L6
    }
}
