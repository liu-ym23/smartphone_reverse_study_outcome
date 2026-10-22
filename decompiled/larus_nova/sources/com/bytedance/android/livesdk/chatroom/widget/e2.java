package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class e2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d2 f118794a;

    public e2(d2 r100) {
        this.f118794a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f118794a.a("time");
    }
}
