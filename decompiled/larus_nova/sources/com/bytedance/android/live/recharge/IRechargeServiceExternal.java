package com.bytedance.android.live.recharge;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.depend.live.IRechargeListener;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import zg1.w2;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.recharge.RechargeServiceWrapper")
public interface IRechargeServiceExternal extends IService {
    void clearCurrentRechargeCacheDataObject();

    void fetchAutoExchangeStatus(int r100);

    zv0.a getCJExternalService();

    RechargeCurrentCacheData getCurrentRechargeCacheDataObject();

    IAutoExchangeService getExchangeUtils();

    IJsMethodsProvideService.IFactory getRechargeJsFactory();

    boolean isRechargeDialogShowing();

    zv0.f rechargeCenter();

    void showPayCancelChargePanel(Context r100, w2 r101);

    DialogFragment showRechargeDialogFragment(Context r100, Bundle r101, IRechargeListener r102);

    DialogFragment showRechargeDialogFragment(Context r100, com.bytedance.android.live.recharge.model.d r101, IRechargeListener r102);
}
