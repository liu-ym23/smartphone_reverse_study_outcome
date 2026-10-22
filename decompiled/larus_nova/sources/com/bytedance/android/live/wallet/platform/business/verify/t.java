package com.bytedance.android.live.wallet.platform.business.verify;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: classes7.dex */
public final class t implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleSubject f102749a;

    public t(SingleSubject r100) {
        this.f102749a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        SingleSubject r101 = this.f102749a;
        r101.onError(r100);
    }
}
