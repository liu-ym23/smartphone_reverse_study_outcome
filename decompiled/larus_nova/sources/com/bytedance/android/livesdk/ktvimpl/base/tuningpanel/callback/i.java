package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f143489a;

    public i(j r100) {
        this.f143489a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        fd2.a r101 = (fd2.a) r100;
        if ((r101 instanceof fd2.a.b) == false) goto L5;
    L8:
        this.f143489a.c();
        return;
    L5:
        if ((r101 instanceof fd2.a.c) == true) goto L8;
        if ((r101 instanceof fd2.a.d) == true) goto L8;
    }
}
