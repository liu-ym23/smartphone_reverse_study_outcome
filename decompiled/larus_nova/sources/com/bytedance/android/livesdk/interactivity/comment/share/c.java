package com.bytedance.android.livesdk.interactivity.comment.share;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f136234a;

    public c(a r100) {
        this.f136234a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        a.InterfaceC2158a r102 = (a.InterfaceC2158a) this.f136234a.f531633a;
        if (r102 == null) goto L6;
        r102.y10();
        return;
    }
}
