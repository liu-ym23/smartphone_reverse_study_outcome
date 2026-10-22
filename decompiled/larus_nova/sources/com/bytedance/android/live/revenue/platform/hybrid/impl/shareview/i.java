package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.content.Context;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevShareViewServiceImpl f91455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f91456b;

    public i(RevShareViewServiceImpl r100, Context r101) {
        this.f91455a = r100;
        this.f91456b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f91455a.f91418b.remove(this.f91456b);
    }
}
