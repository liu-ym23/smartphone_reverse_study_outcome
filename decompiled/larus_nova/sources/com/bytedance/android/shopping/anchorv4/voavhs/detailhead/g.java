package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4DetailHeadView f168229a;

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        AutoHeightViewPager r100 = this.f168229a.f168164k;
        if (r100 == null) goto L5;
        r100.h(0);
    L5:
        return false;
    }

    public g(AnchorV4DetailHeadView r100) {
        this.f168229a = r100;
    }
}
