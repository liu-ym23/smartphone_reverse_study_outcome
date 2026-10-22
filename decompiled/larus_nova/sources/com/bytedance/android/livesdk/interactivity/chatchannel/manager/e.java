package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f134298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s22.e f134299b;

    public e(c r100, s22.e r101) {
        this.f134298a = r100;
        this.f134299b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f134299b.notifyChannelUnreadCountChanged(this.f134298a, ((Integer) r100).intValue());
    }
}
