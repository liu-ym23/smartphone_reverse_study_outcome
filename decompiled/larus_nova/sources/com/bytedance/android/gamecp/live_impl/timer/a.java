package com.bytedance.android.gamecp.live_impl.timer;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameCardShowTimer f57936a;

    public a(GameCardShowTimer r100) {
        this.f57936a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f57936a.f57931a = false;
    }
}
