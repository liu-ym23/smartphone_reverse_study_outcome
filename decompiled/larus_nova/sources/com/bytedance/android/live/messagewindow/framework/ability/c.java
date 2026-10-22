package com.bytedance.android.live.messagewindow.framework.ability;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardAbilityImpl f83057a;

    public c(CardAbilityImpl r100) {
        this.f83057a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f83057a.f83033q.L();
    }
}
