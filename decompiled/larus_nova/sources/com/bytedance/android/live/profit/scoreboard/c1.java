package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f88873a = null;

    static {
        f88873a = new c1();
    }

    public c1() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.c("ScoreboardInvitationHandler", "acceptRound failed: " + ((Throwable) r100), null, 4);
    }
}
