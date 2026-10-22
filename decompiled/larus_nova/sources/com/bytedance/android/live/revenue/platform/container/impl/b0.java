package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class b0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f91136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.platform.aio.channel.js.model.e f91137b;

    public b0(d0 r100, com.bytedance.platform.aio.channel.js.model.e r101) {
        this.f91136a = r100;
        this.f91137b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f91136a.finishWithResult(Unit.INSTANCE);
        ALogger.e("RpcJsBridgeImpl", "invoke method success " + this.f91137b);
    }
}
