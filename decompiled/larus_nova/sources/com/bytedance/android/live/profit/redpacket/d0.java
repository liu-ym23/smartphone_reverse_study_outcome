package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes47.dex */
public final class d0 implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xr2.h f88598a;

    public d0(xr2.h r100) {
        this.f88598a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ((xr2.f) this.f88598a).clearAnimators();
    }
}
