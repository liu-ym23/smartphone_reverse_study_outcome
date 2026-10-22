package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f143741a = null;

    static {
        f143741a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        w.b("ConcertStageComponent", "leaveChorus failed, msg: " + ((Throwable) r100).getMessage());
    }
}
