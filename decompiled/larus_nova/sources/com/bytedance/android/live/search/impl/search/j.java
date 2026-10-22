package com.bytedance.android.live.search.impl.search;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f100776a;

    public j(h r100) {
        this.f100776a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        h r101 = this.f100776a;
        r101.f100755a = false;
        r101.f100764j.cF(new Exception((Throwable) r100));
    }
}
