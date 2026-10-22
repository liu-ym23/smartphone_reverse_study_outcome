package com.bytedance.android.gamecp.business.gamedetail.component.minigameplay;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f54604a = null;

    static {
        f54604a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.gamecp.base.network.response.i r101 = (com.bytedance.android.gamecp.base.network.response.i) r100;
        yr.c.e("MiniGame", "notify open mini gameplay action success");
    }
}
