package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f91140a;

    public c0(d0 r100) {
        this.f91140a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f91140a.finishWithFailure(r101);
        ALogger.e("RpcJsBridgeImpl", "invoke method fail " + r101);
    }
}
