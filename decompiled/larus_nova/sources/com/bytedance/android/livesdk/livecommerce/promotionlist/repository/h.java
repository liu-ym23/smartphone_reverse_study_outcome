package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f151244a = null;

    static {
        f151244a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = ECExceptionMonitor.f45108a;
        ECExceptionMonitor.h("top接口拉取失败");
    }
}
