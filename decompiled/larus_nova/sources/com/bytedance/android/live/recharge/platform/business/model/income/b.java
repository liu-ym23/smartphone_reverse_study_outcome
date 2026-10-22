package com.bytedance.android.live.recharge.platform.business.model.income;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/income/b;", "Lvh7/c;", "Lcom/bytedance/android/live/recharge/platform/business/model/income/a;", "Lcom/bytedance/android/live/recharge/platform/business/model/a;", "getRebateData", "()Lcom/bytedance/android/live/recharge/platform/business/model/a;", "getRebateData$annotations", "()V", "rebateData", "", "getMaxGoldCount", "()J", "getMaxGoldCount$annotations", "maxGoldCount", "getGoldBalance", "getGoldBalance$annotations", "goldBalance", "getEquivalentCashValue", "getEquivalentCashValue$annotations", "equivalentCashValue", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b>, com.bytedance.android.live.recharge.platform.business.model.income.a {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ long getCashBalance();

    @FieldName(name = "equivalent_cash_value")
    long getEquivalentCashValue();

    @FieldName(name = "gold_balance")
    long getGoldBalance();

    /* synthetic */ long getMaxCash();

    @FieldName(name = "max_gold_count")
    long getMaxGoldCount();

    @FieldName(name = "rebate_data")
    com.bytedance.android.live.recharge.platform.business.model.a getRebateData();
}
