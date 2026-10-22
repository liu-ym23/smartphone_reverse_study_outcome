package com.bytedance.android.gamecp.business.gamedetail.component.minigameplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f54605a = null;

    static {
        f54605a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        yr.c.e("MiniGame", "notify open mini gameplay action fail");
    }
}
