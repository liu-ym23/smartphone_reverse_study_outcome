package com.bytedance.android.live.recharge.panel.dynamic;

import android.content.Context;
import com.bytedance.android.live.recharge.RechargeDialogFactoryImpl;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public interface d extends com.bytedance.android.live.recharge.core.c {
    zy0.d d(Context r100, com.bytedance.android.live.recharge.model.d r101, RechargeDialogFactoryImpl.a r102);

    void e0(int r100, int r101, long r102);

    Disposable l1(Function0<Unit> r100);

    void m1(boolean r100);
}
