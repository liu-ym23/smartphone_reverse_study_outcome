package com.byted.mgl.merge.service.api.pay;

import android.app.Activity;
import com.byted.mgl.merge.service.api.pay.model.WxGamePayParamEntity;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpGamePayService extends IBdpService {
    void doAliPay(Activity r100, String r101, GameClientPayListener r102, String r103);

    void doWXPay(Activity r100, WxGamePayParamEntity r101, GameClientPayListener r102);

    boolean isSupportAliPay();

    boolean isSupportWXPay();
}
