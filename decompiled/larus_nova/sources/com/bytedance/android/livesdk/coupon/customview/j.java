package com.bytedance.android.livesdk.coupon.customview;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f121853a = null;

    static {
        f121853a = new j();
    }

    public j() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.w("UgCouponOnlyNewDialog", "initCountDown failed", (Throwable) r100);
    }
}
