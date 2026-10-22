package com.bytedance.android.livesdk.chatroom.replay.paid.privilegeClarity;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes7.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f109448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f109449b;

    public i(Function0 r100) {
        this.f109448a = 6;
        this.f109449b = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f109449b.invoke();
        ALogger.i(PaidReplayConstants.PAID_REPLAY_LOG_TAG, "request ping error! type : " + this.f109448a + " , " + ((Throwable) r100).getMessage());
    }
}
