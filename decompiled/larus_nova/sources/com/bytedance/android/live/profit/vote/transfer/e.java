package com.bytedance.android.live.profit.vote.transfer;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jy0.a f89273a;

    public e(jy0.a r100) {
        this.f89273a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f89273a.k("VoteApiClient", BitableAnalytic.SelectSceneClickType.COMPLETE);
    }
}
