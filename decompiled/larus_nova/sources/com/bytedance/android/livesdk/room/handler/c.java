package com.bytedance.android.livesdk.room.handler;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f157667a;

    public c(a r100) {
        this.f157667a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.livesdk.preview.event.b r101 = (com.bytedance.livesdk.preview.event.b) r100;
        if ((r101 instanceof com.bytedance.livesdk.preview.event.b.f) == false) goto L6;
        this.f157667a.f157657a.b(Boolean.TRUE);
        return;
    L6:
        if ((r101 instanceof com.bytedance.livesdk.preview.event.b.e) == false) goto L9;
        this.f157667a.f157658b.b(Boolean.TRUE);
        return;
    L9:
        if ((r101 instanceof com.bytedance.livesdk.preview.event.b.c) == false) goto L14;
        this.f157667a.f157658b.b(Boolean.FALSE);
        return;
    }
}
