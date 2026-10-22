package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hk6.b.a f140979a;

    public f(hk6.d r100) {
        this.f140979a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f140979a.a(r101.getMessage(), r101);
    }
}
