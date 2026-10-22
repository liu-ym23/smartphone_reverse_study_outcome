package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import io.reactivex.functions.Consumer;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f166460a = null;

    static {
        f166460a = new q();
    }

    public q() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Set<String> r102 = ECProcessMonitor.f45118a;
        com.bytedance.android.ec.core.monitor.listener.c.j(ECProcessMonitor.c("ec_product_detail", "/aweme/v2/shop/coupon/apply/auto/"), -1);
    }
}
