package com.bytedance.android.gamecp.business.download.ai;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f52488a;

    public i(c r100) {
        this.f52488a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (c.b(this.f52488a) == false) goto L6;
        c.c(this.f52488a);
        return;
    }
}
