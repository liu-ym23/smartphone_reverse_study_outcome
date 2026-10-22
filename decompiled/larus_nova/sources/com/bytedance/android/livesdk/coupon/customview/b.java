package com.bytedance.android.livesdk.coupon.customview;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f121840a = null;

    static {
        f121840a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.w("UgCouponGoodsNewDialog", "initCountDown failed", (Throwable) r100);
    }
}
