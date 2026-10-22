package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListItemGroupPresenter f150198a;

    public g(ListItemGroupPresenter r100) {
        this.f150198a = r100;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.f150198a.I(null);
        this.f150198a.K();
        return false;
    }
}
