package com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import io.reactivex.functions.Consumer;
import lu1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f123276a = null;

    static {
        f123276a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = k.f510820a;
        String r103 = r101.getMessage();
        if (r103 != null) goto L5;
        r103 = "Unknown";
    L5:
        k.a("fetch cloud factor failed trigger by cold start due to ".concat(r103));
        int r104 = DynamicStrategyMonitor.f123031a;
        boolean r105 = a.f123267a;
        String r106 = a.f123269c;
        if ((r101 instanceof ApiServerException) == true) goto L8;
        Throwable r107 = null;
    L9:
        ApiServerException r108 = (ApiServerException) r107;
        if (r108 == null) goto L12;
        int r109 = r108.getErrorCode();
    L13:
        String r110 = r101.getMessage();
        if (r110 != null) goto L16;
        r110 = "api error";
    L16:
        DynamicStrategyMonitor.b(1, r106, r109, r110);
        return;
    L12:
        r109 = 999;
        goto L13
    L8:
        r107 = r101;
        goto L9
    }
}
