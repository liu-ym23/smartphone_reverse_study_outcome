package com.bytedance.android.livesdk.popup.manager;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f156307a;

    public i(k r100) {
        this.f156307a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f156307a.f156310b.a(LivePopupInfo.State.DISMISSED);
    }
}
