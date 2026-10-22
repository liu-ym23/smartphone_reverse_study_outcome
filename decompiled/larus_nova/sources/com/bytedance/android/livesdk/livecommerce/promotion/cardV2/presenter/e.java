package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f150700a;

    public e(f r100) {
        this.f150700a = r100;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.f150700a.G();
        this.f150700a.I();
        return false;
    }
}
