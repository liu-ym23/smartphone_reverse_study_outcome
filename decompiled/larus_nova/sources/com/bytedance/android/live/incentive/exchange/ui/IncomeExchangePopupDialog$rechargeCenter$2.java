package com.bytedance.android.live.incentive.exchange.ui;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zv0.f;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lzv0/f;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "()Lzv0/f;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class IncomeExchangePopupDialog$rechargeCenter$2 extends Lambda implements Function0<f> {
    public static final IncomeExchangePopupDialog$rechargeCenter$2 INSTANCE = null;

    static {
        INSTANCE = new IncomeExchangePopupDialog$rechargeCenter$2();
    }

    public IncomeExchangePopupDialog$rechargeCenter$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final f invoke2() {
        IService r100 = k.f(IRechargeService.class);
        Intrinsics.checkNotNull(r100);
        return ((IRechargeService) r100).rechargeCenter();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ f invoke() {
        return invoke2();
    }
}
