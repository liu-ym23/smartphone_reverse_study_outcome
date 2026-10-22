package com.bytedance.android.livesdk.gift.platform.business.tray2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchRoomGiftTrayAnimationView f130372a;

    public j(MatchRoomGiftTrayAnimationView r100) {
        this.f130372a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        hq2.c r101 = (hq2.c) r100;
        if (r101.f486498b == false) goto L7;
        int r102 = r101.f486497a;
        if (r102 <= 0) goto L7;
    L8:
        MatchRoomGiftTrayAnimationView.o(this.f130372a, r102);
        return;
    L7:
        r102 = MatchRoomGiftTrayAnimationView.q(this.f130372a);
        goto L8
    }
}
