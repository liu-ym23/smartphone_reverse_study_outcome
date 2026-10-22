package com.bytedance.android.livesdk.chatroom.progressbar.highlight;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f107780a;

    public e(c r100) {
        this.f107780a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f107780a.b();
    }
}
