package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f89957a = null;

    static {
        f89957a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r101 = com.bytedance.android.live.recharge.utils.f.f90457a;
        com.bytedance.android.live.recharge.utils.f.d("loadExchangeInfo", MapsKt.mapOf(TuplesKt.to("error", ((Throwable) r100).toString())), new Class[]{IRoom.class});
    }
}
