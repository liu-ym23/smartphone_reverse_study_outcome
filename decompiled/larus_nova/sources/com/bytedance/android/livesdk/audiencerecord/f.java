package com.bytedance.android.livesdk.audiencerecord;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BacktrackServiceImp f104046a;

    public f(BacktrackServiceImp r100) {
        this.f104046a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f104046a.f("app");
    }
}
