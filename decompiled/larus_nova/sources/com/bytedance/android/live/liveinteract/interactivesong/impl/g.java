package com.bytedance.android.live.liveinteract.interactivesong.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f74035a = null;

    static {
        f74035a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        InteractiveSongContext.Companion.getClass();
        InteractiveSongContext.access$getMicSeatTaskExecutors$cp().clear();
    }
}
