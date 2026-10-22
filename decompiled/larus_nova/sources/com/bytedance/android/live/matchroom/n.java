package com.bytedance.android.live.matchroom;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f82902a = null;

    static {
        f82902a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        MatchRoomLandScapeAnimUtil.b();
    }
}
