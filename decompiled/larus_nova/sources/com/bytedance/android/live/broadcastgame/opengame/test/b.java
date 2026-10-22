package com.bytedance.android.live.broadcastgame.opengame.test;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenGameTestHelper f61102a;

    public b(OpenGameTestHelper r100) {
        this.f61102a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Boolean) r100).booleanValue() == false) goto L7;
        OpenGameTestFloatBall r101 = this.f61102a.f61097b;
        if (r101 == null) goto L11;
        r101.setVisible();
        return;
    L11:
        return;
    L7:
        OpenGameTestFloatBall r102 = this.f61102a.f61097b;
        if (r102 == null) goto L13;
        r102.setGone();
        return;
    }
}
