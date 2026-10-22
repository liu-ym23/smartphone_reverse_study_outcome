package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f139408a;

    public f(d r100) {
        this.f139408a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f139408a.c("timer error");
        d.a(this.f139408a, CollectionsKt.emptyList());
    }
}
