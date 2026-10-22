package com.bytedance.android.live.profit.scoreboard;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class z0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f89014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ dv0.f f89015b;

    public z0(r0 r100, dv0.f r101) {
        this.f89014a = r100;
        this.f89015b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.d("ScoreboardInvitationHandler", "error while processing invitation: " + ((Throwable) r100));
        r0.a(this.f89014a, this.f89015b, false);
    }
}
