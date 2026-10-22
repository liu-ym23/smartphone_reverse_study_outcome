package com.bytedance.android.livesdk.chatroom.replay.paid;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f109387a = null;

    static {
        f109387a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.i(PaidReplayConstants.PAID_REPLAY_LOG_TAG, "timing error ! " + ((Throwable) r100).getMessage());
    }
}
