package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class f1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f1 f88882a = null;

    static {
        f88882a = new f1();
    }

    public f1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.c("ScoreboardInvitationHandler", "readyForRound failed: " + ((Throwable) r100), null, 4);
    }
}
