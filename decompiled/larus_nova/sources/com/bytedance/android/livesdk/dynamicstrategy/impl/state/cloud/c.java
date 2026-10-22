package com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.m;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.x;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.y;
import com.bytedance.android.livesdk.dynamicstrategy.api.utils.DynamicStrategyMonitor;
import io.reactivex.functions.Consumer;
import java.util.List;
import lu1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Boolean f123275a;

    public c(Boolean r100) {
        this.f123275a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        String r102 = ((x) r101.extra).a();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (this.f123275a.booleanValue() == false) goto L8;
        boolean r103 = a.f123267a;
        y r104 = (y) r101.data;
        a.b(r102);
    L13:
        k.a("fetch cloud factor success trigger by cold start");
        int r105 = DynamicStrategyMonitor.f123031a;
        DynamicStrategyMonitor.c(1, a.f123269c);
        return;
    L8:
        boolean r106 = a.f123267a;
        y r107 = (y) r101.data;
        if (r107 == null) goto L11;
        List<m> r108 = r107.featureData;
    L12:
        a.a(r108, r102);
        goto L13
    L11:
        r108 = null;
        goto L12
    }
}
