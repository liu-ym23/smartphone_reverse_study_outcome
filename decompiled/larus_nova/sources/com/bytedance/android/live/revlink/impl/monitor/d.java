package com.bytedance.android.live.revlink.impl.monitor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevLinkStallReporter f93064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f93065b;

    public d(RevLinkStallReporter r100, String r101) {
        this.f93064a = r100;
        this.f93065b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f93064a.f(this.f93065b, 0);
        this.f93064a.e();
    }
}
