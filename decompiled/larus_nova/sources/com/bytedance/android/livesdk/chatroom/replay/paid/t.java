package com.bytedance.android.livesdk.chatroom.replay.paid;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes7.dex */
public final class t implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidReplayPresenter f109460a;

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.c.a
    public final void a() {
        PaidReplayPresenter r100 = this.f109460a;
        int r101 = PaidReplayPresenter.f109299u;
        ALogger.i(r100.getLogTag(), "enter undelvery state.");
        PaidReplayPresenter.e(this.f109460a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.paid.c.a
    public final void b() {
        PaidReplayPresenter r100 = this.f109460a;
        int r101 = PaidReplayPresenter.f109299u;
        ALogger.i(r100.getLogTag(), "exit undelvery state.");
        Disposable r102 = this.f109460a.f109311l;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        this.f109460a.f109311l = null;
    }

    public t(PaidReplayPresenter r100) {
        this.f109460a = r100;
    }
}
