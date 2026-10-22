package com.bytedance.android.live.recharge.service;

import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.IPreRenderDataInfo;
import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f90377a = null;

    static {
        f90377a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.d("RechargeRoomService", "pre fetch 0 cashier info");
        Map<Long, IPreRenderDataInfo> r101 = ((IQueryPrePayCashierData) r100).getRenderData();
        if (r101 == null) goto L13;
        IPreRenderDataInfo r102 = r101.get(0L);
        if (r102 != null) goto L7;
        return;
    L7:
        if (r2.a(r102.getRenderData()) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L15;
        ConcurrentHashMap<Long, IRenderDataInfoBase> r103 = sw0.a.f543687a;
        Intrinsics.checkNotNullParameter(r102, "data");
        jy0.b.a("Recharge/PreCashierInfoMemoryCache", "cache write, price: 0");
        sw0.a.f543687a.put(0L, r102);
        return;
    L15:
        return;
    }
}
