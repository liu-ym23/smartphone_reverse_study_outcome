package com.bytedance.android.window.shop.repository.tab.datasource.impl;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes14.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f189468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.datasource.c f189469b;

    public d(a r100, com.bytedance.android.window.shop.repository.tab.datasource.c r101) {
        this.f189468a = r100;
        this.f189469b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f189469b.onError("");
        ((mq3.a) this.f189468a.f189454e.b()).setExtensionCardParam(null);
        ECExceptionMonitor.e((Throwable) r100);
    }
}
