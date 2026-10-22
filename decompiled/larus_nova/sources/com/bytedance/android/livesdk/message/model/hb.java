package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.profit.privilege.ProfitCheckConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/hb;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;", "getProfitCheckConfig", "()Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;", "setProfitCheckConfig", "(Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;)V", "profitCheckConfig", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface hb extends vh7.c<hb>, yh6.c {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    ProfitCheckConfig getProfitCheckConfig();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    void setProfitCheckConfig(ProfitCheckConfig r100);
}
