package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes47.dex */
public final class z implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v.g f89013a;

    public z(v.g r100) {
        this.f89013a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f89013a.f89000c.setDragCallback(null);
    }
}
