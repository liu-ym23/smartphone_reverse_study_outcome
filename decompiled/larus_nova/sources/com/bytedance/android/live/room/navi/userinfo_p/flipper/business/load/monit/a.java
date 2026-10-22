package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f100009a;

    public a(b r100) {
        this.f100009a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f100009a.run();
    }
}
