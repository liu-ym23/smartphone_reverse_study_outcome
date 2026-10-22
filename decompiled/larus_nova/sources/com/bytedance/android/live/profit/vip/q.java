package com.bytedance.android.live.profit.vip;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f89186a = null;

    static {
        f89186a = new q();
    }

    public q() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ExtraResponse r101 = (ExtraResponse) r100;
        int r102 = w51.a.f558315a;
        Intrinsics.checkNotNullParameter("VipRepository", "tag");
        Intrinsics.checkNotNullParameter("report VipRechargeStrategy Success", "msg");
        ALogger.i("VipRepository", "report VipRechargeStrategy Success");
    }
}
