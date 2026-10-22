package com.bytedance.android.live.wallet;

import android.app.Activity;
import com.bytedance.android.live.recharge.platform.service.w;
import com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements e, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f102675a;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f102675a.R();
    }

    public f(d r100) {
        Intrinsics.checkNotNullParameter(r100, "cjPayService");
        this.f102675a = r100;
    }

    @Override // com.bytedance.android.live.wallet.e
    public final void Y(Activity r100, DetailChargeDeal r101, w r102) {
        zc1.o.a(r100, r101, r102);
    }
}
