package com.bytedance.android.ec.core.hybrid.utils;

import java.util.concurrent.Callable;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class o<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f44322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f44323b;

    public o(String r100, long r101) {
        this.f44322a = r100;
        this.f44323b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L5
        r100.put("api_path", "/order/buyRender");     // Catch: Throwable -> L5
        r100.put("page_name", "product_buynow_" + this.f44322a);     // Catch: Throwable -> L5
        r100.put("time_interval", this.f44323b);     // Catch: Throwable -> L5
        r100.put(com.bytedance.android.ec.core.event.a.KEY_FE_FLAG, "stand_for");     // Catch: Throwable -> L5
        com.bytedance.android.ec.sdk.helper.g.f48122a.logV3("ecommerce_tect_stat", r100);     // Catch: Throwable -> L5
        return r100;
    L5:
        th = move-exception;
        th.printStackTrace();
        return Unit.INSTANCE;
    }
}
