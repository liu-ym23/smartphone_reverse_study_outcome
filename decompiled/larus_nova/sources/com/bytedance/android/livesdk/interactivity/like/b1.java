package com.bytedance.android.livesdk.interactivity.like;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0 f137575a;

    public b1(x0 r100) {
        this.f137575a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = com.bytedance.android.livesdk.interactivity.like.utils.b.f137723a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.b(this.f137575a.getSpm(), "Fetch Icon Failed, Error: " + ((Throwable) r100).getMessage());
    }
}
