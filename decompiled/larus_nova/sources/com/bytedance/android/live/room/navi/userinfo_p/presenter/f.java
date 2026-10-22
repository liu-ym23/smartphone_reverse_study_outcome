package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserInfoTabPresenter f100138a;

    public f(UserInfoTabPresenter r100) {
        this.f100138a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f100138a.C.setAlpha(1.0f);
    }
}
