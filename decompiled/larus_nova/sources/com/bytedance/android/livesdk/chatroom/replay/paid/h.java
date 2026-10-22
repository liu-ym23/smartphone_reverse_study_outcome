package com.bytedance.android.livesdk.chatroom.replay.paid;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f109376a = null;

    static {
        f109376a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e(PaidReplayConstants.PAID_REPLAY_LOG_TAG, String.valueOf(((Throwable) r100).getMessage()));
    }
}
