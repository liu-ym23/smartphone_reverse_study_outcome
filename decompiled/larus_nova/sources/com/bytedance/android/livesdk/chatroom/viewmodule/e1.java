package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class e1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1 f115241a;

    public e1(f1 r100) {
        this.f115241a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f115241a.f115247a = false;
    }
}
