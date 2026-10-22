package com.bytedance.android.gamecp.business.gamedetail.component.minigamebar;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f54563a = null;

    static {
        f54563a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        yr.c.e("MiniGame", "notify open mini game action fail");
    }
}
